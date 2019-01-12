package app.utility.framework.utilities;

import android.text.TextUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {
    public enum DateFormat {
        DD_MM_YYYY_hh_mm_ss("dd-MM-yyyy hh:mm:ss"),
        DD__MM__YYYY("dd MM yyyy"),
        DD_MM_YYYY("dd-MM-yyyy"),
        YYYY_MM_DD("yyyy-MM-dd");

        private final String format;

        DateFormat(String format) {
            this.format = format;
        }
    }

    public static String convertTimeStampToFormatDate(String timestamp, DateFormat format) {
        if (!TextUtils.isEmpty(timestamp) && format != null) {
            long timeStamp = Long.parseLong(timestamp);
            SimpleDateFormat dateFormat = new SimpleDateFormat(format.format, Locale.getDefault());
            return dateFormat.format(new Date(timeStamp));
        }
        return "";
    }

    /**
     * Checks if provided Date objects points to the same day.
     *
     * @param date1 First java.util.Date object
     * @param date2 Second java.util.Date object
     * @return True if both objects points to the same day, otherwise returns false
     */
    public static boolean isSameDay(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);

        return isSameDay(calendar1, calendar2);
    }

    /**
     * Checks if second Date object points to the day after the first Date object.
     *
     * @param now  First java.util.Date object
     * @param date Second java.util.Date object
     * @return True if second Date object points to the day after the first Date object, false otherwise.
     */
    public static boolean isTomorrow(Date now, Date date) {
        Calendar calendarNew = Calendar.getInstance();
        calendarNew.setTime(now);
        calendarNew.add(Calendar.DAY_OF_MONTH, 1);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return isSameDay(calendarNew, calendar);
    }

    /**
     * Checks if provided Calendar objects points to the same day.
     *
     * @param calendar1 First Calendar object
     * @param calendar2 Second Calendar object
     * @return True if both objects points to the same day, otherwise returns false
     */
    public static boolean isSameDay(Calendar calendar1, Calendar calendar2) {
        return (calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)) &&
                (calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)) &&
                (calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH));
    }

}
