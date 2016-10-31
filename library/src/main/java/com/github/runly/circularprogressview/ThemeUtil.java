package com.github.runly.circularprogressview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.os.Build;
import android.util.TypedValue;

public class ThemeUtil {
		
	private static TypedValue value;
	
	public static int dpToPx(Context context, int dp){
		return (int)(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics()) + 0.5f);
	}

	
	private static int getColor(Context context, int id, int defaultValue){
		if(value == null)
			value = new TypedValue();
		
		try{
			Theme theme = context.getTheme();
			if(theme != null && theme.resolveAttribute(id, value, true)){
                if (value.type >= TypedValue.TYPE_FIRST_INT && value.type <= TypedValue.TYPE_LAST_INT)
                    return value.data;
                else if (value.type == TypedValue.TYPE_STRING)
                    return context.getResources().getColor(value.resourceId);
            }
		}
		catch(Exception ex){

		}
		
		return defaultValue;
	}
	
	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public static int colorPrimary(Context context, int defaultValue){
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
			return getColor(context, android.R.attr.colorPrimary, defaultValue);
		
		return getColor(context, R.attr.colorPrimary, defaultValue);
	}

}
