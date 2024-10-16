package com.tencent.grobot.lite.ui.dialog;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.grobot.lite.R;
import com.tencent.grobot.lite.ui.container.FrameActivity;
import com.tencent.grobot.lite.ui.container.FrameDialog;

/* loaded from: classes2.dex */
public final class ReconnectDialog extends FrameDialog implements Handler.Callback {
    private static final long AFTER_TIME = 1000;
    private static final int MSG_CLOSE = 10000;
    public static final int STATE_FAILED = 3;
    private static final int STATE_IDLE = -1;
    public static final int STATE_RECONNECTING = 1;
    public static final int STATE_RETRY = 0;
    public static final int STATE_SUCCESS = 2;
    private ActionDelegate action;
    private final Handler handler;
    private ImageView ivBanner;
    private ProgressBar pbLoading;
    private int state;
    private TextView tvMsg;

    /* loaded from: classes2.dex */
    public interface ActionDelegate {
        void reconnect();
    }

    public ReconnectDialog(FrameActivity frameActivity) {
        super(frameActivity);
        this.state = -1;
        this.action = null;
        this.handler = new Handler(Looper.getMainLooper(), this);
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog
    protected View initView() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_reconnect, (ViewGroup) this, false);
        inflate.setOnClickListener(this);
        setBackgroundResource(android.R.color.transparent);
        this.ivBanner = (ImageView) inflate.findViewById(R.id.iv_banner);
        this.tvMsg = (TextView) inflate.findViewById(R.id.tv_msg);
        this.pbLoading = (ProgressBar) inflate.findViewById(R.id.pb_loading);
        return inflate;
    }

    @Override // com.tencent.grobot.lite.ui.container.FrameDialog, android.view.View.OnClickListener
    public void onClick(View view) {
        ActionDelegate actionDelegate;
        if (view.getId() == R.id.ll_container && this.state == 0 && (actionDelegate = this.action) != null) {
            actionDelegate.reconnect();
            setState(1);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 10000) {
            return false;
        }
        this.handler.removeMessages(10000);
        dismissCustomDialog();
        return false;
    }

    public void setState(int i) {
        this.state = i;
        switch (this.state) {
            case 0:
                this.ivBanner.setVisibility(0);
                this.ivBanner.setImageResource(R.drawable.dialog_reconnecting_retry);
                this.pbLoading.setVisibility(8);
                this.tvMsg.setVisibility(0);
                this.tvMsg.setText(R.string.reconnecting_retry);
                return;
            case 1:
                this.ivBanner.setVisibility(8);
                this.pbLoading.setVisibility(0);
                this.tvMsg.setVisibility(8);
                return;
            case 2:
                this.ivBanner.setVisibility(0);
                this.ivBanner.setImageResource(R.drawable.dialog_reconnecting_success);
                this.pbLoading.setVisibility(8);
                this.tvMsg.setVisibility(0);
                this.tvMsg.setText(R.string.reconnecting_success);
                Message obtain = Message.obtain();
                obtain.what = 10000;
                obtain.arg1 = 2;
                this.handler.sendMessageDelayed(obtain, AFTER_TIME);
                return;
            case 3:
                this.ivBanner.setVisibility(0);
                this.ivBanner.setImageResource(R.drawable.dialog_reconnecting_failed);
                this.pbLoading.setVisibility(8);
                this.tvMsg.setVisibility(0);
                this.tvMsg.setText(R.string.reconnecting_failed);
                Message obtain2 = Message.obtain();
                obtain2.what = 10000;
                obtain2.arg1 = 3;
                this.handler.sendMessageDelayed(obtain2, AFTER_TIME);
                return;
            default:
                return;
        }
    }

    public int getState() {
        return this.state;
    }

    public void setAction(ActionDelegate actionDelegate) {
        this.action = actionDelegate;
    }
}
