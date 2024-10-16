package com.tencent.grobot.lite.ui.view.im;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.common.ViewUtils;
import com.tencent.grobot.lite.model.local.IMMsgInfo;
import com.tencent.grobot.lite.model.local.OptionItemInfo;
import com.tencent.grobot.lite.report.Report;

/* loaded from: classes2.dex */
public class IMActionView extends LinearLayout implements View.OnClickListener {
    private TextView actionBtn;
    private TextView infoText;
    private Context mContext;
    private Handler mHandler;
    private int mImState;
    private String tagId;

    /* loaded from: classes2.dex */
    public static class IMClickObj {
        public String extra = "";
        public int state;
    }

    /* loaded from: classes2.dex */
    public static class IMState {
        public static final int state_InService = 3;
        public static final int state_NotIn = 1;
        public static final int state_Ready = 0;
        public static final int state_Waiting = 2;
    }

    public IMActionView(Context context) {
        this(context, null, 0);
    }

    public IMActionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMActionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tagId = "";
        this.mContext = context;
        buildSubView();
    }

    private void buildSubView() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.im_bottom_action, (ViewGroup) this, true);
        this.actionBtn = (TextView) inflate.findViewById(R.id.actionBtn);
        ViewUtils.setBoldTypeface(this.mContext, this.actionBtn);
        this.actionBtn.setVisibility(8);
        this.infoText = (TextView) inflate.findViewById(R.id.infoText);
        ViewUtils.setBoldTypeface(this.mContext, this.infoText);
        setOnClickListener(this);
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }

    public void updateRobotStatus(int i, String str, IMMsgInfo.SysMsg sysMsg) {
        switch (i) {
            case 0:
                updateIMInfo(null);
                setVisibility(8);
                return;
            case 1:
                if (sysMsg != null) {
                    if (sysMsg.sessionStatus == 1) {
                        updateImState(2);
                    } else if (sysMsg.sessionStatus == 2) {
                        updateImState(3);
                    } else if (sysMsg.sessionStatus == 3) {
                        updateImState(1);
                    } else {
                        updateImState(1);
                    }
                    updateIMInfo(sysMsg);
                } else if (str.equals("0")) {
                    updateImState(0);
                } else if (str.equals("1")) {
                    updateImState(2);
                } else if (str.equals("2")) {
                    updateImState(3);
                } else if (str.equals("3")) {
                    updateImState(1);
                } else {
                    updateImState(2);
                }
                setVisibility(0);
                return;
            default:
                return;
        }
    }

    public void updateImState(int i) {
        this.mImState = i;
        switch (i) {
            case 0:
                this.actionBtn.setVisibility(0);
                this.actionBtn.setText(this.mContext.getString(R.string.im_exist));
                this.actionBtn.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.im_stop), (Drawable) null, (Drawable) null, (Drawable) null);
                return;
            case 1:
                this.actionBtn.setVisibility(0);
                this.actionBtn.setText(this.mContext.getString(R.string.im_manual));
                this.actionBtn.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.im_manual), (Drawable) null, (Drawable) null, (Drawable) null);
                new Report().eventType("1001").itemId("7065").report(false);
                return;
            case 2:
                this.actionBtn.setVisibility(0);
                this.actionBtn.setText(this.mContext.getString(R.string.im_stopwaiting));
                this.actionBtn.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.im_stop), (Drawable) null, (Drawable) null, (Drawable) null);
                new Report().eventType("1001").itemId("7066").report(false);
                return;
            case 3:
                this.actionBtn.setVisibility(0);
                this.actionBtn.setText(this.mContext.getString(R.string.im_stopservice));
                this.actionBtn.setCompoundDrawablesWithIntrinsicBounds(this.mContext.getResources().getDrawable(R.drawable.im_stop), (Drawable) null, (Drawable) null, (Drawable) null);
                new Report().eventType("1001").itemId("7067").report(false);
                return;
            default:
                return;
        }
    }

    public void updateIMInfo(IMMsgInfo.SysMsg sysMsg) {
        if (sysMsg == null || TextUtils.isEmpty(sysMsg.msg)) {
            this.infoText.setVisibility(8);
            return;
        }
        this.infoText.setVisibility(0);
        this.infoText.setText(sysMsg.msg);
        ViewUtils.setBoldTypeface(this.mContext, this.infoText);
    }

    public void setOptionItem(OptionItemInfo optionItemInfo) {
        if (optionItemInfo != null && optionItemInfo.optionType == 2) {
            setVisibility(0);
            updateImState(1);
            this.tagId = optionItemInfo.optionText;
        } else {
            setVisibility(8);
            this.tagId = "";
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ViewUtils.isFastClick()) {
            return;
        }
        IMClickObj iMClickObj = new IMClickObj();
        iMClickObj.state = this.mImState;
        iMClickObj.extra = this.tagId;
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1009, iMClickObj));
    }

    public void onDestory() {
        this.actionBtn = null;
        this.infoText = null;
        setOnClickListener(null);
        setHandler(null);
    }
}
