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
import java.util.Date;

/**
 *
 * @author duchi
 */
public class SessionTimeTableDBContext extends DBContext {

    public ArrayList<SessionTimeTable> getSessionTimeTable(int id) {
        ArrayList<SessionTimeTable> sessions = new ArrayList<>();

        String sql = "SELECT se.sesid, s.subname, se.tid, se.date, se.[index], r.roomid, g.gid, g.gname, se.iid, se.isAtt "
                + "FROM Session se "
                + "INNER JOIN [Group] g ON se.gid = g.gid "
                + "INNER JOIN Subject s ON g.subid = s.subid "
                + "INNER JOIN Room r ON se.rid = r.roomid "
                + "WHERE se.iid = ? "
                + "ORDER BY se.date;";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int sessionId = rs.getInt("sesid");
                String subject = rs.getString("subname");
                int timeId = rs.getInt("tid");
                Date date = rs.getDate("date");
                String room = rs.getString("roomid");
                int groupId = rs.getInt("gid");
                String groupName = rs.getString("gname");
                int index = rs.getInt("index");
                int instructorId = rs.getInt("iid");
                int status = rs.getInt("isAtt");

                SessionTimeTable session = new SessionTimeTable(sessionId, subject, timeId, date, room, groupId, groupName, index, instructorId, status);
                sessions.add(session);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sessions;
    }

    public SessionTimeTable getSessionTimeTablebyId(int id) {
        SessionTimeTable session = new SessionTimeTable();

        String sql = "SELECT se.sesid, s.subname, se.tid, se.date, se.[index], r.roomid, g.gid, g.gname, se.iid, se.isAtt "
                + "FROM Session se "
                + "INNER JOIN [Group] g ON se.gid = g.gid "
                + "INNER JOIN Subject s ON g.subid = s.subid "
                + "INNER JOIN Room r ON se.rid = r.roomid "
                + "WHERE se.sesid = ? "
                + "ORDER BY se.date;";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int sessionId = rs.getInt("sesid");
                String subject = rs.getString("subname");
                int timeId = rs.getInt("tid");
                Date date = rs.getDate("date");
                String room = rs.getString("roomid");
                int groupId = rs.getInt("gid");
                String groupName = rs.getString("gname");
                int index = rs.getInt("index");
                int instructorId = rs.getInt("iid");
                int status = rs.getInt("isAtt");

                session = new SessionTimeTable(sessionId, subject, timeId, date, room, groupId, groupName, index, instructorId, status);
                return session;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        SessionTimeTableDBContext db = new SessionTimeTableDBContext();
        SessionTimeTable session = db.getSessionTimeTablebyId(1);

        System.out.println(session.getGroupId());

    }

}
