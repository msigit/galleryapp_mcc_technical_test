package com.mcc.galleryapp.customview;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import com.mcc.galleryapp.R;

import java.util.Objects;


/**
 * Created by Sahidul Islam on 4/24/2018.
 */

public class CustomLoadingDialog {

    private Dialog dialog;

    public CustomLoadingDialog(Context context) {
        dialog = new Dialog(context);
        Objects.requireNonNull(dialog.getWindow()).requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);

        dialog.getWindow().setContentView(R.layout.loading_dialog_layout);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
    }

    public void show() {
        if (!dialog.isShowing() && dialog != null) {
            dialog.show();
        }
    }

    public void dismiss() {
        if (dialog.isShowing() && dialog != null) {
            dialog.dismiss();
        }
    }

    public void setCancelable(boolean cancelable) {
        dialog.setCancelable(cancelable);
    }

    public void setCanceledOnTouchOutside(boolean flag) {
        dialog.setCanceledOnTouchOutside(flag);
    }

    public boolean isShowing() {
        return dialog.isShowing();
    }
}
