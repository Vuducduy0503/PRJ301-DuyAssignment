/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.assignment;

import entity.assignment.TimeSlot;
import dal.DBContext;
import entity.assignment.TimeSlot;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sonnt
 */
public class TimeSlotDBContext extends DBContext {

    public ArrayList<TimeSlot> getTimeSlots() {
        ArrayList<TimeSlot> timeSlots = new ArrayList<>();

        String sql = "SELECT * FROM TimeSlot";

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int timeId = rs.getInt("tid");
                String time = rs.getString("description");

                TimeSlot slot = new TimeSlot(timeId, time);
                timeSlots.add(slot);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return timeSlots;
    }
    
    public static void main(String[] args) {
        
        TimeSlotDBContext db = new TimeSlotDBContext();
        
        ArrayList<TimeSlot> timeSlots = db.getTimeSlots();
        for(TimeSlot time : timeSlots){
            
            System.out.println(time.getDescription());
            
        }
        
    }
    
}
