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
            return "Y";
        } else
            return "O";
    }

    protected String getHoursFirstRow(GregorianCalendar time) {
        return null;
    }

    protected String getHoursSecondRow(GregorianCalendar time) {
        return null;
    }

    protected String getMinutesFirstRow(GregorianCalendar time) {
        return null;
    }

    protected String getMinutesSecondRow(GregorianCalendar time) {
        return null;
    }

}