package in.abmulani.carinventory.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import in.abmulani.carinventory.R;


public class Utils {

    public static Typeface getThisFont(Context context, int textStyleIndex) {
        final int FONT_BOLD = 0;
        final int FONT_BOLD_ITALIC = 1;
        final int FONT_MEDIUM = 2;
        final int FONT_MEDIUM_ITALIC = 3;
        final int FONT_SEMI_BOLD = 4;
        final int FONT_SEMI_BOLD_ITALIC = 5;
        final int FONT_LIGHT = 6;
        final int FONT_LIGHT_ITALIC = 7;

        Typeface typeface;
        switch (textStyleIndex) {
            case FONT_BOLD:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf");
                break;
            case FONT_BOLD_ITALIC:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-MediumItalic.ttf");
                break;
            case FONT_MEDIUM:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
                break;
            case FONT_MEDIUM_ITALIC:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-LightItalic.ttf");
                break;
            case FONT_SEMI_BOLD:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
                break;
            case FONT_SEMI_BOLD_ITALIC:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Italic.ttf");
                break;
            case FONT_LIGHT:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Thin.ttf");
                break;
            case FONT_LIGHT_ITALIC:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-ThinItalic.ttf");
                break;
            default:
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
                break;
        }
        return typeface;
    }

    private static ProgressDialog progressDialog;

    public static boolean isEmpty(EditText editText) {
        return (editText.getText().toString().isEmpty());
    }

    public static void showToast(Context activity, String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    public static void setError(EditText editText, String msg) {
        editText.setError(msg);
        editText.requestFocus();
    }

    public static void hideKeyboard(Activity activity) {
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams
                .SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public static void hideKeyboard(Context context, View editText) {
        try {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context
                    .INPUT_METHOD_SERVICE);
            if (editText != null) {
                imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                editText.clearFocus();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createAndShowThisMsg(Context activity, String title, String message,
                                            String positiveText, DialogInterface.OnClickListener
            onOkClickListener, String negativeText, DialogInterface.OnClickListener
                                                    onCancelClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        if (title != null) {
            builder.setTitle(title);
            builder.setIcon(R.drawable.app_icon);
        } else {
            builder.setTitle(null);
        }
        builder.setMessage(message);
        builder.setPositiveButton(positiveText, onOkClickListener);
        if (onCancelClickListener != null || negativeText != null) {
            builder.setNegativeButton(negativeText, onCancelClickListener);
        }
        Dialog dialog = builder.show();
        dialog.show();
    }

}
