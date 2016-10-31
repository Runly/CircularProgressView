package com.github.runly.circularprogressview;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

public class ViewUtil {
	
	public static final long FRAME_DURATION = 1000 / 60;

    public static void setBackground(View v, Drawable drawable){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
            v.setBackground(drawable);
        else
            v.setBackgroundDrawable(drawable);
    }

}
