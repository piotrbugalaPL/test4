package com.ubs.opsit.interviews;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by piobug on 2016-03-13.
 */
public class BerlinClockTest extends BerlinClock {

    @Test
    public void shouldParse1() {
        String aTime = "00:00:00";

        GregorianCalendar time = parseTime(aTime);

        assert (time.get(Calendar.HOUR) == 0);
        assert (time.get(Calendar.MINUTE) == 0);
        assert (time.get(Calendar.SECOND) == 0);
    }

    @Test
    public void shouldParse2() {
        String aTime = "01:02:03";

        GregorianCalendar time = parseTime(aTime);

        assert (time.get(Calendar.HOUR) == 1);
        assert (time.get(Calendar.MINUTE) == 2);
        assert (time.get(Calendar.SECOND) == 3);
    }

    @Test
    public void shouldParse3() {
        String aTime = "11:22:33";

        GregorianCalendar time = parseTime(aTime);

        assert (time.get(Calendar.HOUR) == 11);
        assert (time.get(Calendar.MINUTE) == 22);
        assert (time.get(Calendar.SECOND) == 33);
    }

    @Test
    public void shouldParse4() {
        String aTime = "23:59:59";

        GregorianCalendar time = parseTime(aTime);

        assert (time.get(Calendar.HOUR_OF_DAY) == 23);
        assert (time.get(Calendar.MINUTE) == 59);
        assert (time.get(Calendar.SECOND) == 59);
    }

    @Test
    public void shouldNotParse1() {
        String aTime = "25:79:79";
        Exception error = new Exception();

        try {
            GregorianCalendar time = parseTime(aTime);
        } catch (Exception e) {
            error = e;
        }

        assert (error.getMessage().equals("Wrong time format"));
    }

    @Test
    public void shouldNotParse2() {
        String aTime = "25:79:7";
        Exception error = new Exception();

        try {
            GregorianCalendar time = parseTime(aTime);
        } catch (Exception e) {
            error = e;
        }

        assert (error.getMessage().equals("Wrong time format"));
    }

    @Test
    public void shouldNotParse3() {
        Exception error = new Exception();

        try {
            GregorianCalendar time = parseTime(null);
        } catch (Exception e) {
            error = e;
        }

        assert (error.getMessage().equals("Empty time parameter"));
    }

    @Test
    public void shouldGetSecondsEven() {
        String aTime = "00:00:00";

        GregorianCalendar time = parseTime(aTime);
        String seconds = getSeconds(time);

        assert (seconds.equals("Y"));
    }

    @Test
    public void shouldGetSecondsOdd() {
        String aTime = "00:00:01";

        GregorianCalendar time = parseTime(aTime);
        String seconds = getSeconds(time);

        assert (seconds.equals("O"));
    }

    @Test
    public void shouldGetHoursFirstRow1() {
        String aTime = "00:00:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getHoursFirstRow(time);

        assert (firstRow.equals("OOOO"));
    }

    @Test
    public void shouldGetHoursFirstRow2() {
        String aTime = "01:00:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getHoursFirstRow(time);

        assert (firstRow.equals("OOOO"));
    }

    @Test
    public void shouldGetHoursFirstRow3() {
        String aTime = "06:00:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getHoursFirstRow(time);

        assert (firstRow.equals("ROOO"));
    }

    @Test
    public void shouldGetHoursFirstRow4() {
        String aTime = "10:00:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getHoursFirstRow(time);

        assert (firstRow.equals("RROO"));
    }

    @Test
    public void shouldGetHoursFirstRow5() {
        String aTime = "12:00:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getHoursFirstRow(time);

        assert (firstRow.equals("RROO"));
    }

    @Test
    public void shouldGetHoursFirstRow6() {
        String aTime = "16:00:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getHoursFirstRow(time);

        assert (firstRow.equals("RRRO"));
    }

    @Test
    public void shouldGetHoursFirstRow7() {
        String aTime = "20:00:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getHoursFirstRow(time);

        assert (firstRow.equals("RRRR"));
    }

    @Test
    public void shouldGetHoursFirstRow8() {
        String aTime = "23:00:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getHoursFirstRow(time);

        assert (firstRow.equals("RRRR"));
    }

    @Test
    public void shouldGetHoursSecondRow1() {
        String aTime = "00:00:00";

        GregorianCalendar time = parseTime(aTime);
        String secondRow = getHoursSecondRow(time);

        assert (secondRow.equals("OOOO"));
    }

    @Test
    public void shouldGetHoursSecondRow2() {
        String aTime = "01:00:00";

        GregorianCalendar time = parseTime(aTime);
        String secondRow = getHoursSecondRow(time);

        assert (secondRow.equals("ROOO"));
    }

    @Test
    public void shouldGetHoursSecondRow3() {
        String aTime = "06:00:00";

        GregorianCalendar time = parseTime(aTime);
        String secondRow = getHoursSecondRow(time);

        assert (secondRow.equals("ROOO"));
    }

    @Test
    public void shouldGetHoursSecondRow4() {
        String aTime = "10:00:00";

        GregorianCalendar time = parseTime(aTime);
        String secondRow = getHoursSecondRow(time);

        assert (secondRow.equals("OOOO"));
    }

    @Test
    public void shouldGetHoursSecondRow5() {
        String aTime = "12:00:00";

        GregorianCalendar time = parseTime(aTime);
        String secondRow = getHoursSecondRow(time);

        assert (secondRow.equals("RROO"));
    }

    @Test
    public void shouldGetHoursSecondRow6() {
        String aTime = "18:00:00";

        GregorianCalendar time = parseTime(aTime);
        String secondRow = getHoursSecondRow(time);

        assert (secondRow.equals("RRRO"));
    }

    @Test
    public void shouldGetHoursSecondRow7() {
        String aTime = "19:00:00";

        GregorianCalendar time = parseTime(aTime);
        String secondRow = getHoursSecondRow(time);

        assert (secondRow.equals("RRRR"));
    }

    @Test
    public void shouldGetMinutesFirstRow0() {
        String aTime = "00:00:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getMinutesFirstRow(time);

        assert (firstRow.equals("OOOOOOOOOOO"));
    }

    @Test
    public void shouldGetMinutesFirstRow1() {
        String aTime = "00:01:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getMinutesFirstRow(time);

        assert (firstRow.equals("OOOOOOOOOOO"));
    }

    @Test
    public void shouldGetMinutesFirstRow2() {
        String aTime = "00:02:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getMinutesFirstRow(time);

        assert (firstRow.equals("OOOOOOOOOOO"));
    }

    @Test
    public void shouldGetMinutesFirstRow3() {
        String aTime = "00:03:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getMinutesFirstRow(time);

        assert (firstRow.equals("OOOOOOOOOOO"));
    }

    @Test
    public void shouldGetMinutesFirstRow4() {
        String aTime = "00:04:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getMinutesFirstRow(time);

        assert (firstRow.equals("OOOOOOOOOOO"));
    }

    @Test
    public void shouldGetMinutesFirstRow5() {
        String aTime = "00:05:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getMinutesFirstRow(time);

        assert (firstRow.equals("YOOOOOOOOOO"));
    }

    @Test
    public void shouldGetMinutesFirstRow6() {
        String aTime = "00:06:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getMinutesFirstRow(time);

        assert (firstRow.equals("YOOOOOOOOOO"));
    }

    @Test
    public void shouldGetMinutesFirstRow10() {
        String aTime = "00:10:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getMinutesFirstRow(time);

        assert (firstRow.equals("YYOOOOOOOOO"));
    }

    @Test
    public void shouldGetMinutesFirstRow11() {
        String aTime = "00:11:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getMinutesFirstRow(time);

        assert (firstRow.equals("YYOOOOOOOOO"));
    }

    @Test
    public void shouldGetMinutesFirstRow15() {
        String aTime = "00:15:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getMinutesFirstRow(time);

        assert (firstRow.equals("YYROOOOOOOO"));
    }

    @Test
    public void shouldGetMinutesFirstRow20() {
        String aTime = "00:20:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getMinutesFirstRow(time);

        assert (firstRow.equals("YYRYOOOOOOO"));
    }

    @Test
    public void shouldGetMinutesFirstRow25() {
        String aTime = "00:25:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getMinutesFirstRow(time);

        assert (firstRow.equals("YYRYYOOOOOO"));
    }

    @Test
    public void shouldGetMinutesFirstRow30() {
        String aTime = "00:30:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getMinutesFirstRow(time);

        assert (firstRow.equals("YYRYYROOOOO"));
    }

    @Test
    public void shouldGetMinutesFirstRow59() {
        String aTime = "00:59:00";

        GregorianCalendar time = parseTime(aTime);
        String firstRow = getMinutesFirstRow(time);

        assert (firstRow.equals("YYRYYRYYRYY"));
    }
}
