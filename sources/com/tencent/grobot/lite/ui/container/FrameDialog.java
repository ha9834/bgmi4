package com.tencent.grobot.lite.ui.container;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ComponentRef;
import com.tencent.grobot.lite.common.SystemUtils;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.common.ViewUtils;

/* loaded from: classes2.dex */
public abstract class FrameDialog extends FrameLayout implements View.OnClickListener, ComponentRef {
    private static final String TAG = "FrameDialog";
    protected FrameActivity context;
    protected boolean isShowed;

    protected void destoryView() {
    }

    public void handleCallBackOnActivityForResult(int i, int i2, Intent intent) {
    }

    protected void initData() {
    }

    protected abstract View initView();

    public void onClick(View view) {
    }

    public FrameDialog(FrameActivity frameActivity) {
        super(frameActivity);
        this.isShowed = false;
        this.context = frameActivity;
        View initView = initView();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) initView.getLayoutParams();
        layoutParams = layoutParams == null ? new FrameLayout.LayoutParams(-2, -2) : layoutParams;
        layoutParams.gravity = 17;
        addView(initView, layoutParams);
        initData();
        setOnClickListener(this);
        setBackgroundResource(R.color.dialog_whole_bg);
    }

    public void showCustomDialog() {
        try {
            if (!this.isShowed) {
                setVisibility(0);
                this.context.openDialog(this);
            }
            this.isShowed = true;
        } catch (Exception e) {
            TLog.e(TAG, "mDialog.show();" + e);
        }
    }

    public void showCustomDialog(boolean z, int i, int i2, int i3) {
        try {
            if (!this.isShowed) {
                setVisibility(0);
                this.context.openDialog(this, z, i, i2);
                setBackgroundResource(i3);
            }
            this.isShowed = true;
        } catch (Exception e) {
            TLog.e(TAG, "mDialog.show();" + e);
        }
    }

    public void dismissCustomDialog() {
        try {
            TLog.d(TAG, "dismissCustomDialog");
            setVisibility(8);
            this.context.closeDialog(this);
            TLog.d(TAG, "dismissCustomDialog closeDialog");
            this.isShowed = false;
        } catch (Exception e) {
            TLog.e(TAG, "mDialog.dismiss();" + e);
        }
        SystemUtils.doGCDelay(500L);
    }

    public void onBackPressed() {
        dismissCustomDialog();
    }

    public boolean isShowing() {
        return getParent() != null && this.isShowed;
    }

    @Override // com.tencent.grobot.lite.common.ComponentRef
    public void onDestroy() {
        ViewUtils.clearViews(this);
        destoryView();
        ((ViewGroup) this.context.getWindow().getDecorView()).removeView(this);
    }
}
