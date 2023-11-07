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

/**
 *
 * @author sonnt
 */
@WebServlet(name = "AttendanceController", urlPatterns = {"/Attendance"})
public class AttendanceController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sessionId = request.getParameter("sessionId");
        int id = 0;

        if (sessionId != null) {
            try {
                id = Integer.parseInt(sessionId);
            } catch (Exception e) {
                id = 0;
            }
        }

        //lay ra session
        SessionTimeTableDBContext sessionDB = new SessionTimeTableDBContext();
        SessionTimeTable ses = sessionDB.getSessionTimeTablebyId(id);

        //lay ra studentlist
        AttendanceDBContext attDB = new AttendanceDBContext();
        ArrayList<Attendance> atts = attDB.getAttendances(id);

        request.setAttribute("atts", atts);
        request.setAttribute("session", ses);
        request.getRequestDispatcher("view/instructor/attendance.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get student id list
        String[] stuids = request.getParameterValues("stuid");

        
        
        //khai bao session
        Session ses = new Session();
        ses.setId(Integer.parseInt(request.getParameter("sesid")));
        
        //khai bao list attendance
        ArrayList<Attendance> atts = new ArrayList<>();
        for (String stuid : stuids) {
            int id = Integer.parseInt(stuid);
            Attendance a = new Attendance();
            Student s = new Student();
            s.setId(id);
            a.setStudent(s);
            a.setSession(ses);
            a.setDescription(request.getParameter("description" + stuid));
            a.setStatus(request.getParameter("status" + stuid).equals("present"));
            atts.add(a);
        }
        ses.setAtts(atts);
        SessionDBContext sesDB = new SessionDBContext();
        sesDB.addAttendances(ses);
        response.sendRedirect("Attendance?sessionId="+Integer.parseInt(request.getParameter("sesid")));
    }

}
