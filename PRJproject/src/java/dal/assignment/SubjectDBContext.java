/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.assignment;

import entity.assignment.*;
import dal.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class SubjectDBContext extends DBContext {

    public ArrayList<SessionTimeTable> getSubjects() {
        ArrayList<SessionTimeTable> subjects = new ArrayList<>();

        String sql = "SELECT * FROM";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int sessionId = rs.getInt("sesd");
                String subject = rs.getString("subname");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return subjects;
    }

}
