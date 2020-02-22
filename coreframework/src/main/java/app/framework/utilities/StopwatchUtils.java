package app.framework.utilities;

import android.util.Log;

public class StopwatchUtils {
    private static final String TAG = StopwatchUtils.class.getSimpleName();

    private long mStart;
    private long mLast;

    public StopwatchUtils() {
        mLast = mStart = System.currentTimeMillis();
    }

    public void current(String text) {
        long currTime = System.currentTimeMillis();
        long elapsedTime = currTime - mLast;
        mLast = currTime;
        Log.d(TAG, text + " " + elapsedTime);
    }

    public void stop(String text) {
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - mStart;
        Log.d(TAG, text + " " + elapsedTime);
    }

}
