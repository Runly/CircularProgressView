package com.github.runly.circularprogressview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;

public class ProgressView extends View {
	public static final int MODE_DETERMINATE = 0;
	public static final int MODE_INDETERMINATE = 1;
	private CircularProgressDrawable circularProgressDrawable;
    private boolean isStart = false;
    private boolean isAutoStart = true;

	public ProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
		init(context);
	}

    protected void init(Context context){
        applyStyle(context);
    }

    /**
     *set progress's style
     */
    protected void applyStyle(Context context){
        int mProgressId = R.style.CircularProgress;
        circularProgressDrawable = new CircularProgressDrawable.Builder(context, mProgressId).build();
        ViewUtil.setBackground(this, circularProgressDrawable);
    }

	public CircularProgressDrawable getCircularProgressDrawable() {
		return circularProgressDrawable;
	}

    public void setAutoStart(boolean autoStart) {
        isAutoStart = autoStart;
    }

    /**
    *set the stroke size with px
     */
	public void setStrokeSizePx(int px) {
		getCircularProgressDrawable().setmStrokeSize(px);
	}

    /**
     *set the stroke size with dp
     */
    public void setStrokeSizeDp(Context context , float dp) {
        int px = dipToPixels(context, dp);
        getCircularProgressDrawable().setmStrokeSize(px);
    }

    /**
     *set the colors with int[]
     */
	public void setStrokeColors(int[] strokeColors) {
		getCircularProgressDrawable().setmStrokeColors(strokeColors);
	}

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isAutoStart)
            start();

    }

    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == GONE || visibility == INVISIBLE && isStart) {
            stop();
        } else {
            if(isAutoStart)
                start();
        }


    }

	@Override
	protected void onDetachedFromWindow() {
        if (isStart && getVisibility() == View.VISIBLE) {
            stop();
        }
	    super.onDetachedFromWindow();
	}

    /**
     * Start showing progress.
     */
	public void start(){
		if(circularProgressDrawable != null) {
            circularProgressDrawable.start();
            isStart = true;
        }
	}

    /**
     * Stop showing progress.
     */
	public void stop(){
		if(circularProgressDrawable != null && isStart){
            circularProgressDrawable.stop();
            isStart = false;
		}

	}

    /**
     *convert dip tp px
     */
    private int dipToPixels(Context context, float dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics) + 0.5f);
    }

}
