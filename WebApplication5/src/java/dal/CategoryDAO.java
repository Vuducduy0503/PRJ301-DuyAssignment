/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import java.util.Locale.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.employee;

/**
 *
 * @author vuduc
 */
public class CategoryDAO extends DBcontext {

    public List<employee> getALL() {
        List<employee> list = new ArrayList<>();
        String sql = "select*from students";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                employee c = new employee(rs.getInt("ID"),
                        rs.getString("name"),
                        rs.getString("email"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    /*
    insert
     */
    public void insert(employee c) {
        String sql = "INSERT INTO [dbo].[students]\n"
                + "           ([ID]\n"
                + "           ,[name]\n"
                + "           ,[email])\n"
                + "     VALUES\n"
                + "         (?,?,?)";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            st.setString(2,c.getName());
             st.setString(3,c.getEmail());
             st.executeUpdate();
        }
        catch(SQLException e){
            System.out.println("e");
        }
    }
public employee getCategoryById(int id) {
     
        String sql = "select*from students where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
             st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                employee c = new employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"));
               return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public static void main(String[] args) {
        CategoryDAO c = new CategoryDAO();
        List<employee> list = c.getALL();

    }
}
