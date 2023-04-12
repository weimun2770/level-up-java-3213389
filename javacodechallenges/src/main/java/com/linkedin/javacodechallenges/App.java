package com.linkedin.javacodechallenges;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class App 
{
    // Create function to calculate the date that's 
    // 100 days from now
    public static String afterDay(int days) {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, days);

        return dateFormat.format(calendar.getTime());
    }

    public static void main( String[] args )
    {
        System.out.println("100 days from now is... " + 
            afterDay(100));
    }
}
