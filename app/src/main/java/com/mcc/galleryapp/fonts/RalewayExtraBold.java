package com.mcc.galleryapp.fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by msi on 10/26/2017.
 */

public class RalewayExtraBold extends TextView {

    public RalewayExtraBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RalewayExtraBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RalewayExtraBold(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Raleway/Raleway_ExtraBold.ttf");
        setTypeface(tf);
    }
}