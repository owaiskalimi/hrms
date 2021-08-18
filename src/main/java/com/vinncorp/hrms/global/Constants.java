package com.vinncorp.hrms.global;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Constants {

    private static final String PRESENT = "Present";
    private static final String ABSENT = "Absent";
    private static final String LEAVE = "Leave";
    private static final String HALFDAY = "Half Day";
    private static final String LATE = "Late";

    public static boolean isEmpty(Long value) {
        boolean isEmpty = false;
        if (value == null || value == (long) 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public static boolean isEmpty(String value) {
        boolean isEmpty = false;
        if (value == null || value.length() == 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public static boolean isEmpty(ArrayList value) {
        boolean isEmpty = false;
        if (value == null || value.size() == 0) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public static String getDayFromDate(String date) throws ParseException {
        if (Constants.isEmpty(date)) {
            return null;
        }
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-mm-dd");
        Date dt1 = format1.parse(date);
        DateFormat format2 = new SimpleDateFormat("EEEE");
        String finalDay = format2.format(dt1);
        return finalDay;
    }

    public static String previousDate(String date) {
        if (Constants.isEmpty(date)) {
            return null;
        }
        LocalDate parsedDate = LocalDate.parse(date);
        LocalDate addedDate = parsedDate.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
        return addedDate.toString();
    }

    public static int numOfDaysBetweenTwoTimeStamps(Timestamp time1, Timestamp time2) {
        int numOfDays = 1;
        if (time1 != null && time2 != null) {
            Date date = new Date(time1.getTime());
            Date date1 = new Date(time2.getTime());
            numOfDays = (int) ((date1.getTime() - date.getTime()) / (1000 * 60 * 60 * 24));
        } else if (time1 != null && time2 == null) {
            time2 = new Timestamp(System.currentTimeMillis());
            Date date = new Date(time1.getTime());
            Date date1 = new Date(time2.getTime());
            numOfDays = (int) ((date1.getTime() - date.getTime()) / (1000 * 60 * 60 * 24));
        }
        return numOfDays;
    }

    public static String numOfHoursBetweenTwoTimeStamps(Timestamp timeOut, Timestamp timeIn) {
        long duration = timeOut.getTime() - timeIn.getTime();
        long durationMinutes = duration / (60 * 1000) % 60;
        long durationHours = duration / (60 * 60 * 1000) % 24;
        String durationString = durationHours + ":" + durationMinutes;
        System.out.println(durationString);
        return durationString;
    }

    public static Timestamp getCustomTime(String currentDate, String customTime) {
        Timestamp customTimestamp = Timestamp.valueOf(currentDate + customTime);
        return customTimestamp;
    }

    public static String getDateInString(Date timestamp) {
        String strDate = null;
        if (timestamp != null) {
            Date date = new Date(timestamp.getTime());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            strDate = dateFormat.format(date);
        }
        return strDate;
    }

    public static String getMacAddress() throws SocketException {
        InetAddress ip;
        StringBuilder sb = new StringBuilder();
        try {
            ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    public static Date getCurrentDate(Timestamp timestamp) {
        Date date = new Date(Long.parseLong(String.valueOf(timestamp)));
        return date;
//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//        String dateString = formatter.format(new Date(Long.parseLong(String.valueOf(timestamp))));
//        return dateString;
//        DateFormat df = new SimpleDateFormat("EE dd/MM/yy");
//        java.sql.Date date = null;
//        return df.format(date);
    }

    public static Date getDateFromString(String date) {
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-mm-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }

    public static String getPRESENT() {
        return PRESENT;
    }

    public static String getABSENT() {
        return ABSENT;
    }

    public static String getLEAVE() {
        return LEAVE;
    }

    public static String getHalfDay() {
        return HALFDAY;
    }

    public static String getLATE() {
        return LATE;
    }
}
