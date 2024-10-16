package com.tencent.midas.oversea.comm;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.TextView;

/* loaded from: classes.dex */
public class APProgressDialog extends ProgressDialog {
    private Context context;
    private String loadingTxt;
    private TextView loading_txt;
    private boolean mCancelable;

    public APProgressDialog(Context context, boolean z) {
        super(context, APCommMethod.getStyleId(context, "unipay_CustomProgressDialog"));
        this.loadingTxt = "";
        this.loading_txt = null;
        this.context = null;
        this.context = context;
        this.mCancelable = z;
        this.loadingTxt = APCommMethod.getStringId(context, "unipay_waiting");
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(APCommMethod.getLayoutId(this.context, "unipay_abroad_loadding"));
        ProgressBar progressBar = (ProgressBar) findViewById(APCommMethod.getId(this.context, "unipay_progress"));
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
        alphaAnimation.setDuration(600L);
        alphaAnimation.setRepeatCount(-1);
        alphaAnimation.setRepeatMode(2);
        progressBar.setAnimation(alphaAnimation);
        alphaAnimation.start();
        this.loading_txt = (TextView) findViewById(APCommMethod.getId(this.context, "unipay_id_LoadingTxt"));
        this.loading_txt.setText(this.loadingTxt);
        setCancelable(this.mCancelable);
    }

    @Override // android.app.ProgressDialog, android.app.AlertDialog
    public void setMessage(CharSequence charSequence) {
        super.setMessage(charSequence);
        this.loadingTxt = String.valueOf(charSequence);
    }
}
