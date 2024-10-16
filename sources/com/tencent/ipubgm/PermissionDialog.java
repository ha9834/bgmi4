package com.tencent.ipubgm;

import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.internal.AnalyticsEvents;

/* loaded from: classes.dex */
public class PermissionDialog extends Dialog {
    public static final int PermissionDialogType_OK = 0;
    public static final int PermissionDialogType_YesNo = 1;

    public PermissionDialog(Context context, int i) {
        super(context, i);
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private Context mContext;
        private PermissionDialog mDialog;
        private int mDialogType;
        private View mLayout;
        private TextView mMessage;
        private Button mNegativeButton;
        private View.OnClickListener mNegativeListener;
        private Button mPositiveButton;
        private View.OnClickListener mPositiveListener;
        private TextView mTitle;

        public Builder(Context context, int i) {
            int identifier;
            this.mContext = context;
            this.mDialogType = i;
            this.mDialog = new PermissionDialog(context, context.getResources().getIdentifier("PermissionDialogTheme", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, context.getPackageName()));
            LayoutInflater from = LayoutInflater.from(context);
            int i2 = this.mDialogType;
            if (i2 == 0) {
                identifier = context.getResources().getIdentifier("dialog_ok_permission", "layout", context.getPackageName());
            } else {
                if (i2 != 1) {
                    Log.e("iGamePermission", String.format("Unknown DialogType = %d", Integer.valueOf(i)));
                    return;
                }
                identifier = context.getResources().getIdentifier("dialog_permission", "layout", context.getPackageName());
            }
            this.mLayout = from.inflate(identifier, (ViewGroup) null);
            this.mTitle = (TextView) this.mLayout.findViewById(context.getResources().getIdentifier("permissiondialog_title", "id", context.getPackageName()));
            this.mMessage = (TextView) this.mLayout.findViewById(context.getResources().getIdentifier("permissiondialog_message", "id", context.getPackageName()));
            if (this.mDialogType == 1) {
                this.mNegativeButton = (Button) this.mLayout.findViewById(context.getResources().getIdentifier("permissiondialog_button_negative", "id", context.getPackageName()));
            }
            this.mPositiveButton = (Button) this.mLayout.findViewById(context.getResources().getIdentifier("permissiondialog_button_positive", "id", context.getPackageName()));
        }

        public Builder setTitle(int i) {
            TextView textView = this.mTitle;
            if (textView != null) {
                textView.setText(i);
            }
            return this;
        }

        public Builder setTitle(String str) {
            TextView textView = this.mTitle;
            if (textView != null) {
                textView.setText(str);
            }
            return this;
        }

        public Builder setMessage(int i) {
            TextView textView = this.mMessage;
            if (textView != null) {
                textView.setText(i);
            }
            return this;
        }

        public Builder setMessage(String str) {
            TextView textView = this.mMessage;
            if (textView != null) {
                textView.setText(str);
            }
            return this;
        }

        public Builder setHTMLMessage(int i) {
            if (this.mMessage != null) {
                this.mMessage.setText(Html.fromHtml(this.mContext.getResources().getString(i)));
            }
            return this;
        }

        public Builder setHTMLMessage(String str) {
            TextView textView = this.mMessage;
            if (textView != null) {
                textView.setText(Html.fromHtml(str));
            }
            return this;
        }

        public Builder setPositiveButton(int i, View.OnClickListener onClickListener) {
            Button button = this.mPositiveButton;
            if (button != null) {
                button.setText(i);
            }
            this.mPositiveListener = onClickListener;
            return this;
        }

        public Builder setPositiveButton(String str, View.OnClickListener onClickListener) {
            Button button = this.mPositiveButton;
            if (button != null) {
                button.setText(str);
            }
            this.mPositiveListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(int i, View.OnClickListener onClickListener) {
            Button button = this.mNegativeButton;
            if (button != null) {
                button.setText(i);
            }
            this.mNegativeListener = onClickListener;
            return this;
        }

        public Builder setNegativeButton(String str, View.OnClickListener onClickListener) {
            Button button = this.mNegativeButton;
            if (button != null) {
                button.setText(str);
            }
            this.mNegativeListener = onClickListener;
            return this;
        }

        public PermissionDialog create() {
            this.mDialog.setContentView(this.mLayout);
            Button button = this.mPositiveButton;
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ipubgm.PermissionDialog.Builder.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Builder.this.mPositiveListener != null) {
                            Builder.this.mPositiveListener.onClick(view);
                        }
                        Builder.this.mDialog.dismiss();
                    }
                });
            }
            Button button2 = this.mNegativeButton;
            if (button2 != null) {
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ipubgm.PermissionDialog.Builder.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (Builder.this.mNegativeListener != null) {
                            Builder.this.mNegativeListener.onClick(view);
                        }
                        Builder.this.mDialog.dismiss();
                    }
                });
            }
            this.mDialog.setCancelable(false);
            this.mDialog.setCanceledOnTouchOutside(false);
            return this.mDialog;
        }
    }
}
