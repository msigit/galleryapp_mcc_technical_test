package com.mcc.galleryapp.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by MD Sahidul Islam on 2/7/2017.
 */

public class RobotoRegular extends TextView {

    public RobotoRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RobotoRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobotoRegular(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/roboto/roboto_regular.ttf");
        setTypeface(tf);
    }
}
