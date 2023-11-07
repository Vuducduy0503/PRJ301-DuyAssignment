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
public class DAO extends DBContext {

    public ArrayList<Group> getGroups() {
        ArrayList<Group> groups = new ArrayList<>();

        String sql = "SELECT * FROM Group";

        return groups;
    }

    public ArrayList<Student> getStudentsByGroup(int groupId) {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT s.* "
                + "FROM Student s "
                + "INNER JOIN Group_Student gs ON s.stuid = gs.stuid "
                + "WHERE gs.gid = ?";

        try {

            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, groupId);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("stuid");
                String name = rs.getString("stuname");

                Student student = new Student(id, name);
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();

        ArrayList<Student> students = dao.getStudentsByGroup(1);
        for (Student student : students) {
            System.out.println(student.getName());
        }

    }

}
