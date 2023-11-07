/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity.assignment;

import java.util.Date;

/**
 *
 * @author duchi
 */
public class SessionTimeTable {

    private int sessionId;
    private String subjectName;
    private int timeId;
    private Date date;
    private String room;
    private int groupId;
    private String groupName;
    private int index;
    private int instructorId;
    private int status;

    public SessionTimeTable() {
    }

    public SessionTimeTable(int sessionId, String subjectName, int timeId, Date date, String room, int groupId, String groupName, int index, int instructorId, int status) {
        this.sessionId = sessionId;
        this.subjectName = subjectName;
        this.timeId = timeId;
        this.date = date;
        this.room = room;
        this.groupId = groupId;
        this.groupName = groupName;
        this.index = index;
        this.instructorId = instructorId;
        this.status = status;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

}
