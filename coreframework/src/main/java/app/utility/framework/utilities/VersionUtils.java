package app.utility.framework.utilities;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

public class VersionUtils {

    private static final String TAG = VersionUtils.class.getSimpleName();

    private static final String DEFAULT_VERSION_NAME = "N/A";
    private static final int DEFAULT_VERSION_CODE = 0;

    /**
     * Gets the application version name as configured in AndroidManifest.xml file.
     *
     * @param context Current context.
     * @return Application version name or DEFAULT_VERSION_NAME if not found.
     */
    public static String getAppVersionName(Context context) {
        String result;

        try {
            Context applicationContext = context.getApplicationContext();
            result = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w(TAG, "VersionUtils.getAppVersionName() NameNotFoundException", e);
            result = DEFAULT_VERSION_NAME;
        }

        return result;
    }

    /**
     * Gets the application version code as configured in AndroidManifest.xml file.
     *
     * @param context Current context.
     * @return Application version code or DEFAULT_VERSION_CODE if not found.
     */
    public static int getAppVersionCode(Context context) {
        int result;

        try {
            Context applicationContext = context.getApplicationContext();
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            result = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w(TAG, "VersionUtils.getAppVersionName() NameNotFoundException", e);
            result = DEFAULT_VERSION_CODE;
        }

        return result;
    }

}
