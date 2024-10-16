package com.tencent.midas.oversea.comm;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.comm.MAlertDialog;

/* loaded from: classes.dex */
public class MUIManager {
    public static final String TAG = "MUIManager";
    private Context mContext;
    private MAlertDialog mTestEnvDialog = null;
    private MAlertDialog mErrorMsgDialog = null;
    private ProgressDialog mProgressDialog = null;

    /* loaded from: classes.dex */
    public interface MNotifier {
        void callback();
    }

    public MUIManager(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void showLoading() {
        if (isShowLoading()) {
            ProgressDialog progressDialog = this.mProgressDialog;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.mProgressDialog = new APProgressDialog(this.mContext, false);
                ProgressDialog progressDialog2 = this.mProgressDialog;
                if (progressDialog2 != null) {
                    progressDialog2.setMessage(APCommMethod.getStringId(this.mContext, "unipay_waiting"));
                    this.mProgressDialog.show();
                    APLog.i(TAG, "showLoading()");
                }
            }
        }
    }

    public void showLoading(final MNotifier mNotifier) {
        if (isShowLoading()) {
            ProgressDialog progressDialog = this.mProgressDialog;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.mProgressDialog = new APProgressDialog(this.mContext, true);
                ProgressDialog progressDialog2 = this.mProgressDialog;
                if (progressDialog2 != null) {
                    progressDialog2.setMessage(APCommMethod.getStringId(this.mContext, "unipay_waiting"));
                    this.mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.midas.oversea.comm.MUIManager.1
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            MNotifier mNotifier2 = mNotifier;
                            if (mNotifier2 != null) {
                                mNotifier2.callback();
                            }
                            APLog.e(MUIManager.TAG, "showWaitDialog() onCancel.");
                        }
                    });
                    this.mProgressDialog.show();
                    APLog.i(TAG, "showWaitDialog()");
                }
            }
        }
    }

    public void dismissWaitDialog() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
        this.mProgressDialog = null;
        APLog.i(TAG, "dismissWaitDialog()");
    }

    public void showSandboxDialog(final MNotifier mNotifier, final MNotifier mNotifier2) {
        MAlertDialog mAlertDialog = this.mTestEnvDialog;
        if (mAlertDialog == null || !mAlertDialog.isShowing()) {
            this.mTestEnvDialog = new MAlertDialog.Builder(this.mContext).setTitle(APCommMethod.getStringId(this.mContext, "unipay_hints")).setContent(APCommMethod.getStringId(this.mContext, "unipay_no_charge_hints")).setCancelable(false).setDialogButton(APCommMethod.getStringId(this.mContext, "unipay_sure"), new DialogInterface.OnClickListener() { // from class: com.tencent.midas.oversea.comm.MUIManager.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    MNotifier mNotifier3 = mNotifier;
                    if (mNotifier3 != null) {
                        mNotifier3.callback();
                    }
                }
            }).create();
            MAlertDialog mAlertDialog2 = this.mTestEnvDialog;
            if (mAlertDialog2 != null) {
                mAlertDialog2.setCancelable(false);
                this.mTestEnvDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.midas.oversea.comm.MUIManager.3
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        if (i != 4 || keyEvent.getAction() != 1) {
                            return false;
                        }
                        dialogInterface.dismiss();
                        MNotifier mNotifier3 = mNotifier2;
                        if (mNotifier3 == null) {
                            return false;
                        }
                        mNotifier3.callback();
                        return false;
                    }
                });
                this.mTestEnvDialog.show();
                APLog.i(TAG, "showSandboxDialog()");
            }
        }
    }

    public void showErrorMsg(String str, final MNotifier mNotifier) {
        if (!isShowPayResult()) {
            if (mNotifier != null) {
                mNotifier.callback();
                return;
            }
            return;
        }
        MAlertDialog mAlertDialog = this.mErrorMsgDialog;
        if (mAlertDialog == null || !mAlertDialog.isShowing()) {
            this.mErrorMsgDialog = new MAlertDialog.Builder(this.mContext).setTitle("error").setContent(str).setCancelable(false).setDialogButton(APCommMethod.getStringId(this.mContext, "unipay_sure"), new DialogInterface.OnClickListener() { // from class: com.tencent.midas.oversea.comm.MUIManager.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    MNotifier mNotifier2 = mNotifier;
                    if (mNotifier2 != null) {
                        mNotifier2.callback();
                    }
                }
            }).create();
            MAlertDialog mAlertDialog2 = this.mErrorMsgDialog;
            if (mAlertDialog2 != null) {
                mAlertDialog2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.tencent.midas.oversea.comm.MUIManager.5
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        dialogInterface.dismiss();
                        MNotifier mNotifier2 = mNotifier;
                        if (mNotifier2 == null) {
                            return false;
                        }
                        mNotifier2.callback();
                        return false;
                    }
                });
                this.mErrorMsgDialog.show();
                APLog.i(TAG, "showErrorMsg()");
            }
        }
    }

    public void successToast(String str) {
        if (isShowPayResult()) {
            View inflate = LayoutInflater.from(this.mContext).inflate(APCommMethod.getLayoutId(this.mContext, "unipay_abroad_tips_suc"), (ViewGroup) null);
            TextView textView = (TextView) APUICommMethod.findViewById(inflate, "unipay_id_succnum");
            TextView textView2 = (TextView) APUICommMethod.findViewById(inflate, "unipay_id_name");
            if ("0".equals(str) || TextUtils.isEmpty(str)) {
                textView.setVisibility(4);
                textView2.setVisibility(4);
            } else {
                textView.setText("x" + str);
            }
            Toast makeText = Toast.makeText(this.mContext, "", 1);
            makeText.setGravity(23, 0, 0);
            makeText.setDuration(1);
            makeText.setView(inflate);
            makeText.show();
        }
    }

    public void release() {
        MAlertDialog mAlertDialog = this.mTestEnvDialog;
        if (mAlertDialog != null && mAlertDialog.isShowing()) {
            this.mTestEnvDialog.dismiss();
        }
        this.mTestEnvDialog = null;
        MAlertDialog mAlertDialog2 = this.mErrorMsgDialog;
        if (mAlertDialog2 != null && mAlertDialog2.isShowing()) {
            this.mErrorMsgDialog.dismiss();
        }
        this.mErrorMsgDialog = null;
        dismissWaitDialog();
    }

    public boolean isShowPayResult() {
        return GlobalData.singleton().showPayResult();
    }

    public boolean isShowLoading() {
        return GlobalData.singleton().showLoading();
    }
}
