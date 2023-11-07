/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.assignment;

import dal.DBContext;
import entity.assignment.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author duchi
 */
public class InstructorDBContext extends DBContext {

    public ArrayList<Instructor> getInstructors() {
        ArrayList<Instructor> instructors = new ArrayList<>();

        String sql = "SELECT * FROM Instructor";

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("iid");
                String name = rs.getString("iname");

                Instructor slot = new Instructor(id, name);
                instructors.add(slot);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instructors;
    }

    public static void main(String[] args) {

        InstructorDBContext db = new InstructorDBContext();

        ArrayList<Instructor> ins = db.getInstructors();
        for (Instructor i : ins) {

            System.out.println(i.getName());

        }

    }
}
