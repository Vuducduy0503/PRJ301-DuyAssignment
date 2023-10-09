/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM StudentAttendance";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("Id"));
                student.setStudentCode(resultSet.getString("StudentCode"));
                student.setStudentName(resultSet.getString("StudentName"));
                student.setGroupName(resultSet.getString("GroupName"));
                student.setImageUrl(resultSet.getString("ImageUrl"));
                student.setStatus(resultSet.getString("Status"));
                student.setComment(resultSet.getString("Comment"));
                student.setTaker(resultSet.getString("Taker"));
                student.setRecordTime(resultSet.getTimestamp("RecordTime"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}


