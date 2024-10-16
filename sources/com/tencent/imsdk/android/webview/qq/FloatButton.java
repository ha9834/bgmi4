package com.tencent.imsdk.android.webview.qq;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* loaded from: classes.dex */
public class FloatButton extends ImageButton implements View.OnClickListener, View.OnTouchListener {
    private static final String TAG = "FloatButton";
    private static final int TIMEOUT = 3000;
    private static final int WEBVIEW_ID = 1;
    public static Handler backButtonHandler = null;
    private static final String floatIconName = "js_float_close";
    private static FloatButton instance;
    private Callback callback;
    private Context ctx;
    private int downX;
    private int downY;
    private boolean isClick;
    private boolean isShow;
    private int lastX;
    private int lastY;
    private ViewGroup parentView;

    /* loaded from: classes.dex */
    public interface Callback {
        void onClick(View view);
    }

    public FloatButton(Context context, Callback callback) {
        super(context);
        this.lastX = 0;
        this.lastY = 0;
        this.downX = 0;
        this.downY = 0;
        try {
            instance = this;
            this.ctx = context;
            this.isClick = true;
            this.callback = callback;
            getBackground().setAlpha(0);
            int drawableId = ResourceUtil.getDrawableId(context, floatIconName);
            Log.d(TAG, "float button image id " + drawableId);
            if (drawableId >= 0) {
                setImageResource(drawableId);
            }
            setOnTouchListener(this);
            setOnClickListener(this);
            hide();
        } catch (Exception e) {
            IMLogger.w(TAG, e);
        }
    }

    public static void show() {
        FloatButton floatButton = instance;
        if (floatButton == null) {
            return;
        }
        floatButton.isShow = true;
        floatButton.setVisibility(0);
    }

    public static void showDelayed() {
        try {
            if (instance == null || instance.isShow) {
                return;
            }
            instance.isShow = true;
            backButtonHandler = new Handler();
            backButtonHandler.postDelayed(new Runnable() { // from class: com.tencent.imsdk.android.webview.qq.FloatButton.1
                @Override // java.lang.Runnable
                public void run() {
                    if (FloatButton.instance != null && FloatButton.instance.isShow) {
                        FloatButton.show();
                    }
                }
            }, 3000L);
        } catch (Exception e) {
            IMLogger.w(TAG, e);
        }
    }

    public static void hide() {
        try {
            if (instance == null) {
                return;
            }
            instance.isShow = false;
            instance.setVisibility(4);
        } catch (Exception e) {
            IMLogger.w(TAG, e);
        }
    }

    public void addViewToGroup(ViewGroup viewGroup) {
        try {
            CoordinatorLayout.e eVar = new CoordinatorLayout.e(-2, -2);
            eVar.c = 85;
            viewGroup.addView(this, eVar);
            this.parentView = viewGroup;
        } catch (Exception e) {
            IMLogger.w(TAG, e);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int right;
        int height;
        int i;
        try {
            right = this.parentView.getRight();
            height = this.parentView.getHeight();
        } catch (Exception e) {
            IMLogger.w(TAG, e);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.lastX = (int) motionEvent.getRawX();
                this.lastY = (int) motionEvent.getRawY();
                this.downX = this.lastX;
                this.downY = this.lastY;
                return false;
            case 1:
                this.isClick = Math.abs((int) (motionEvent.getRawX() - ((float) this.downX))) <= 5 && Math.abs((int) (motionEvent.getRawY() - ((float) this.downY))) <= 5;
                return false;
            case 2:
                int rawX = ((int) motionEvent.getRawX()) - this.lastX;
                int rawY = ((int) motionEvent.getRawY()) - this.lastY;
                int left = view.getLeft() + rawX;
                int top = view.getTop() + rawY;
                int right2 = view.getRight() + rawX;
                int bottom = view.getBottom() + rawY;
                if (left < 0) {
                    i = view.getWidth() + 0;
                    left = 0;
                } else {
                    i = right2;
                }
                if (i > right) {
                    left = right - view.getWidth();
                } else {
                    right = i;
                }
                if (top < 0) {
                    bottom = view.getHeight() + 0;
                    top = 0;
                }
                if (bottom > height) {
                    top = height - view.getHeight();
                } else {
                    height = bottom;
                }
                view.layout(left, top, right, height);
                this.lastX = (int) motionEvent.getRawX();
                this.lastY = (int) motionEvent.getRawY();
                return false;
            default:
                return false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (this.isClick && this.callback != null) {
                this.callback.onClick(view);
            }
        } catch (Exception e) {
            IMLogger.w(TAG, e);
        }
    }
}
