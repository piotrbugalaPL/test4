package com.ubs.opsit.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by piobug on 2016-03-13.
 */
public class BerlinClock implements TimeConverter {
    private static final Logger LOG = LoggerFactory.getLogger(BerlinClock.class);

    private static final String lamp_blinks_on = "Y";
    private static final String lamp_blinks_off = "O";
    private static final String lamp_red = "R";
    private static final String lamp_yellow = "Y";


    @Override
    public String convertTime(String aTime) {
        GregorianCalendar time = parseTime(aTime);
        LOG.debug("Get time {} ", time);
        return "A";
    }

    protected GregorianCalendar parseTime(final String aTime) {

        if (aTime == null) {
            throw new NullPointerException("Empty time parameter");
        }

        if (aTime.length() != 8) {
            throw new IllegalArgumentException("Wrong time format");
        }
        try {
            int hours = Integer.parseInt(aTime.substring(0, 2));
            int minutes = Integer.parseInt(aTime.substring(3, 5));
            int sec = Integer.parseInt(aTime.substring(6, 8));

            if (hours > 23 || hours < 0 || minutes > 59 || minutes < 0 || sec > 59 || sec < 0) {
                throw new IllegalArgumentException("Wrong time format");
            }

            GregorianCalendar time = new GregorianCalendar();
            time.set(Calendar.HOUR_OF_DAY, hours);
            time.set(Calendar.MINUTE, minutes);
            time.set(Calendar.SECOND, sec);

            return time;
        } catch (Exception e) {
            throw new IllegalArgumentException("Wrong time format");
        }
    }

    protected String getSeconds(GregorianCalendar time) {
        if ((time.get(Calendar.SECOND) % 2) == 0) {
            return lamp_blinks_on;
        } else
            return lamp_blinks_off;
    }

    protected String getHoursFirstRow(GregorianCalendar time) {
        int lamps = time.get(Calendar.HOUR_OF_DAY) / 5;
        String firstRow = "";

        for (int i = 1; i <= 4; i++) {
            if (lamps >= i) {
                firstRow += lamp_red;
            } else {
                firstRow += lamp_blinks_off;
            }
        }
        return firstRow;
    }

    protected String getHoursSecondRow(GregorianCalendar time) {
        int lamps = time.get(Calendar.HOUR_OF_DAY) % 5;
        String secondRow = "";

        for (int i = 1; i <= 4; i++) {
            if (lamps >= i) {
                secondRow += lamp_red;
            } else {
                secondRow += lamp_blinks_off;
            }
        }
        return secondRow;
    }

    protected String getMinutesFirstRow(GregorianCalendar time) {
        int lamps = time.get(Calendar.MINUTE) / 5;
        String firstRow = "";

        for (int i = 1; i <= 11; i++) {
            if (lamps >= i) {
                if (i % 3 == 0) { // every 3rd lamp means quarter
                    firstRow += lamp_red;
                } else {
                    firstRow += lamp_yellow;
                }
            } else {
                firstRow += lamp_blinks_off;
            }
        }

        return firstRow;
    }

    protected String getMinutesSecondRow(GregorianCalendar time) {
        return null;
    }

}
