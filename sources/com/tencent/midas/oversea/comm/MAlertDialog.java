package com.tencent.midas.oversea.comm;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes.dex */
public class MAlertDialog extends Dialog {
    public static final String TAG = "MAlertDialog";

    public MAlertDialog(Context context, int i) {
        super(context, i);
    }

    public MAlertDialog(Context context) {
        super(context);
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private DialogInterface.OnClickListener buttonListener;
        private String buttonText;
        private String content;
        private boolean isCancelable;
        private Context mContext;
        private String testSubTitle;
        private String title;

        public Builder(Context context) {
            this.mContext = context;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setTestSubTitle(String str) {
            this.testSubTitle = str;
            return this;
        }

        public Builder setContent(String str) {
            this.content = str;
            return this;
        }

        public Builder setCancelable(boolean z) {
            this.isCancelable = z;
            return this;
        }

        public Builder setDialogButton(String str, DialogInterface.OnClickListener onClickListener) {
            this.buttonText = str;
            this.buttonListener = onClickListener;
            return this;
        }

        public MAlertDialog create() {
            View inflate = LayoutInflater.from(this.mContext).inflate(APCommMethod.getLayoutId(this.mContext, "unipay_abroad_layout_mdialog"), (ViewGroup) null);
            Context context = this.mContext;
            MAlertDialog mAlertDialog = new MAlertDialog(context, APCommMethod.getStyleId(context, "unipay_customDialog"));
            mAlertDialog.addContentView(inflate, new ViewGroup.LayoutParams(-2, -2));
            initDialogWindowSize(mAlertDialog);
            initDialogButton(inflate, mAlertDialog);
            setHeadView(inflate);
            setDialogContent(inflate);
            mAlertDialog.setCanceledOnTouchOutside(this.isCancelable);
            mAlertDialog.setContentView(inflate);
            return mAlertDialog;
        }

        private void initDialogWindowSize(MAlertDialog mAlertDialog) {
            mAlertDialog.getWindow().getAttributes().width = (int) (((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() * (this.mContext.getResources().getConfiguration().orientation == 2 ? 0.56f : 0.8f));
        }

        private void initDialogButton(View view, final MAlertDialog mAlertDialog) {
            Button button = (Button) view.findViewById(APCommMethod.getId(this.mContext, "unipay_dialog_sure"));
            if (!TextUtils.isEmpty(this.buttonText)) {
                button.setText(this.buttonText);
                if (this.buttonListener != null) {
                    button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.midas.oversea.comm.MAlertDialog.Builder.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            Builder.this.buttonListener.onClick(mAlertDialog, -1);
                        }
                    });
                    return;
                }
                return;
            }
            button.setVisibility(8);
        }

        private void setHeadView(View view) {
            TextView textView;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(APCommMethod.getId(this.mContext, "unipay_head_test"));
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(APCommMethod.getId(this.mContext, "unipay_head_release"));
            if (APTools.isTestEnv()) {
                linearLayout.setVisibility(0);
                linearLayout2.setVisibility(8);
                textView = (TextView) view.findViewById(APCommMethod.getId(this.mContext, "unipay_head_test_title"));
                TextView textView2 = (TextView) view.findViewById(APCommMethod.getId(this.mContext, "unipay_head_test_subTitle"));
                this.title = "Midas Sandbox!";
                this.testSubTitle = "OpenID : " + GlobalData.singleton().openID;
                textView2.setText(this.testSubTitle);
            } else {
                linearLayout.setVisibility(8);
                linearLayout2.setVisibility(0);
                textView = (TextView) view.findViewById(APCommMethod.getId(this.mContext, "unipay_head_release_title"));
            }
            if (TextUtils.isEmpty(this.title)) {
                return;
            }
            textView.setText(this.title);
        }

        private void setDialogContent(View view) {
            TextView textView = (TextView) view.findViewById(APCommMethod.getId(this.mContext, "unipay_dialog_content"));
            if (TextUtils.isEmpty(this.content)) {
                return;
            }
            textView.setText(this.content);
        }
    }
}
