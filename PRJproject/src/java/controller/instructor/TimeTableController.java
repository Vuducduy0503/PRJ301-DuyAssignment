/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.instructor;

import dal.assignment.*;
import entity.assignment.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.sql.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DateTimeHelper;

@WebServlet(name = "TimeTableController", urlPatterns = {"/TimeTable"})
public class TimeTableController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String instructorid = request.getParameter("instructorId");
        String r_from = request.getParameter("from");
        String r_to = request.getParameter("to");
        ArrayList<Date> dates = new ArrayList<>();

        int id = 0;
        if (instructorid != null) {
            try {
                id = Integer.parseInt(instructorid);
            } catch (Exception e) {
                id = 0;
            }
        }

        if (r_from == null)//this week
        {
            dates = DateTimeHelper.getCurrentWeekDates();
        } else {
            try {
                dates = DateTimeHelper.getWeekDatesFromStartDate(r_from);
            } catch (ParseException ex) {
                Logger.getLogger(TimeTableController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //get slot from database
        TimeSlotDBContext timeDB = new TimeSlotDBContext();
        ArrayList<TimeSlot> slots = timeDB.getTimeSlots();

        //get session from database
        SessionTimeTableDBContext sessionDB = new SessionTimeTableDBContext();
        ArrayList<SessionTimeTable> sessions = sessionDB.getSessionTimeTable(id);

        //get instructor
        InstructorDBContext instructorDB = new InstructorDBContext();
        ArrayList<Instructor> instructors = instructorDB.getInstructors();

        //get room
        request.setAttribute("instructorId", instructorid);
        request.setAttribute("instructors", instructors);
        request.setAttribute("sessions", sessions);
        request.setAttribute("slots", slots);
        request.setAttribute("dates", dates);
        request.setAttribute("from", dates.get(0));
        request.setAttribute("to", dates.get(dates.size() - 1));

        request.getRequestDispatcher("view/instructor/timetable.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
