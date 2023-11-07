/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author sonnt
 */
public class DateTimeHelper {

    public static ArrayList<java.sql.Date> getCurrentWeekDates() {
        // Create an instance of ArrayList to hold the dates.
        ArrayList<java.sql.Date> dates = new ArrayList<>();

        // Get the current date.
        java.util.Date now = new java.util.Date();

        // Create an instance of the Calendar object
        Calendar calendar = Calendar.getInstance();

        // Set the calendar time to the current date.
        calendar.setTime(now);

        // Determine the current day of the week (1 = Sunday, 2 = Monday, ..., 7 = Saturday)
        int currentDay = calendar.get(Calendar.DAY_OF_WEEK);

        // Calculate how much to add or subtract to get Monday's date.
        // Note: Calendar.DAY_OF_WEEK starts from 1 (Sunday) and ends at 7 (Saturday).
        int daysToSubtract = currentDay - Calendar.MONDAY; // For Monday, this would be 0.
        // Adjust the calendar to the beginning of the week (Monday)
        calendar.add(Calendar.DAY_OF_MONTH, -daysToSubtract);

        // For each day from Monday to Sunday, add the corresponding date to the ArrayList.
        for (int i = 0; i < 7; i++) {
            // Add the current calendar date to the list.
            dates.add(convertUtilToSql(removeTimeFromDate(calendar.getTime())));

            // Move the calendar to the next day.
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        return dates;
    }

    public static java.util.Date removeTimeFromDate(java.util.Date inputDate) {
        // Check for null input date
        if (inputDate == null) {
            return null;
        }

        // Create an instance of the calendar
        Calendar cal = Calendar.getInstance();
        // Set the calendar time to the input date
        cal.setTime(inputDate);

        // Set the time fields to zero
        cal.set(Calendar.HOUR_OF_DAY, 0); // Use 24-hour time format
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        // Return the date part only
        return cal.getTime();
    }

    public static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        // Check for null
        if (uDate == null) {
            return null;
        }

        // java.sql.Date constructor takes the milliseconds since January 1, 1970, 00:00:00 GMT (the standard base time);
        // getTime() from java.util.Date provides it.
        return new java.sql.Date(uDate.getTime());
    }

    public static ArrayList<java.sql.Date> getWeekDatesFromStartDate(String startDateStr) throws ParseException {
        // Định dạng ngày, ví dụ, "yyyy-MM-dd" cho định dạng ISO 8601.
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Parse startDateStr thành đối tượng java.util.Date.
        java.util.Date parsedStartDate = dateFormat.parse(startDateStr);

        // Chuyển đổi java.util.Date thành java.sql.Date cho ngày bắt đầu.
        java.sql.Date startDate = new java.sql.Date(parsedStartDate.getTime());

        // Tạo một đối tượng Calendar để lặp qua các ngày trong tuần.
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        // Xác định ngày trong tuần (1 = Chủ Nhật, 2 = Thứ Hai, ..., 7 = Thứ Bảy).
        int currentDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Tính toán số ngày cần giảm để lấy ngày đầu tuần (Thứ Hai).
        int daysToSubtract = currentDayOfWeek - Calendar.MONDAY;
        calendar.add(Calendar.DAY_OF_MONTH, -daysToSubtract);

        // Danh sách để chứa các ngày trong tuần.
        ArrayList<java.sql.Date> weekDates = new ArrayList<>();

        // Sử dụng vòng lặp để thêm các ngày trong tuần vào danh sách.
        for (int i = 0; i < 7; i++) {
            // Thêm ngày hiện tại vào danh sách.
            weekDates.add(new java.sql.Date(calendar.getTimeInMillis()));

            // Di chuyển calendar đến ngày tiếp theo.
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        return weekDates;
    }

    public static void main(String[] args) throws ParseException {
        String startDateStr = "2023-11-24"; // Ngày bắt đầu trong chuỗi "yyyy-MM-dd"
        ArrayList<java.sql.Date> weekDates = getWeekDatesFromStartDate(startDateStr);

        // Hiển thị các ngày trong tuần
        for (java.sql.Date date : weekDates) {
            System.out.println(date);
        }
    }

}
