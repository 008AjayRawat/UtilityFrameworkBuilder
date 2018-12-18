package app.utility.framework.utilities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;

import app.utility.framework.R;


public class DialogFactoryUtils {

    private static final @ColorInt
    int DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF");

    private static final @ColorInt
    int ERROR_COLOR = Color.parseColor("#D50000");
    private static final @ColorInt
    int INFO_COLOR = Color.parseColor("#3F51B5");
    private static final @ColorInt
    int SUCCESS_COLOR = Color.parseColor("#388E3C");
    private static final @ColorInt
    int WARNING_COLOR = Color.parseColor("#FFA900");

    public static Dialog createSimpleOkDialog(Context context, String title, String message) {
        AlertDialog.Builder alertDialog =
                new AlertDialog.Builder(context).setTitle(title).setMessage(message).setNeutralButton(R.string.dialog_action_ok, null);
        return alertDialog.create();
    }

    public static Dialog createGenericErrorDialog(Context context, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context, R.style.AppCompatAlertDialogErrorStyle).setTitle(context.getString(R.string.generic_error_title))
                .setMessage(message)
                .setNeutralButton(R.string.dialog_action_ok, null);
        return alertDialog.create();
    }

    public static ProgressDialog createProgressDialog(Context context, String message) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        return progressDialog;
    }

    public static ProgressDialog createProgressDialog(Context context, @StringRes int messageResource) {
        return createProgressDialog(context, context.getString(messageResource));
    }


}
