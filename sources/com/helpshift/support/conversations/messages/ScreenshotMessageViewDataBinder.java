package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.R;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.UIViewState;
import com.helpshift.support.imageloader.ImageLoader;
import com.helpshift.support.util.Styles;
import com.helpshift.support.views.HSRoundedImageView;
import com.helpshift.util.TextUtils;

/* loaded from: classes2.dex */
public class ScreenshotMessageViewDataBinder extends MessageViewDataBinder<ViewHolder, ScreenshotMessageDM> {
    public ScreenshotMessageViewDataBinder(Context context) {
        super(context);
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.hs__msg_screenshot_status, viewGroup, false));
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public void bind(ViewHolder viewHolder, final ScreenshotMessageDM screenshotMessageDM) {
        String string;
        int color;
        String str;
        String string2;
        boolean z;
        boolean z2;
        boolean z3;
        ViewHolder viewHolder2;
        View.OnClickListener onClickListener;
        String filePath = screenshotMessageDM.getFilePath();
        int color2 = Styles.getColor(this.context, android.R.attr.textColorSecondary);
        boolean z4 = !TextUtils.isEmpty(filePath);
        float f = 0.5f;
        switch (screenshotMessageDM.state) {
            case UNSENT_RETRYABLE:
                string = this.context.getResources().getString(R.string.hs__sending_fail_msg);
                color = Styles.getColor(this.context, R.attr.hs__errorTextColor);
                str = "";
                string2 = this.context.getString(R.string.hs__user_failed_message_voice_over);
                z = true;
                z2 = false;
                z3 = false;
                viewHolder2 = viewHolder;
                break;
            case UNSENT_NOT_RETRYABLE:
                if (screenshotMessageDM.isRejected) {
                    string = this.context.getString(R.string.hs__file_type_unsupported);
                } else {
                    string = this.context.getResources().getString(R.string.hs__sending_fail_msg);
                }
                color = Styles.getColor(this.context, R.attr.hs__errorTextColor);
                string2 = this.context.getString(R.string.hs__user_failed_message_voice_over);
                str = "";
                z = false;
                z2 = false;
                viewHolder2 = null;
                z3 = false;
                break;
            case SENDING:
                color = color2;
                string = this.context.getResources().getString(R.string.hs__sending_msg);
                str = "";
                string2 = this.context.getString(R.string.hs__user_sending_message_voice_over);
                z = false;
                z2 = true;
                viewHolder2 = null;
                z3 = false;
                break;
            case SENT:
                f = 1.0f;
                String subText = screenshotMessageDM.getSubText();
                z2 = TextUtils.isEmpty(filePath);
                string2 = this.context.getString(R.string.hs__user_sent_message_voice_over, screenshotMessageDM.getAccessbilityMessageTime());
                str = this.context.getString(R.string.hs__image_downloaded_voice_over);
                color = color2;
                string = subText;
                z3 = !z2;
                z = false;
                viewHolder2 = null;
                break;
            default:
                color = color2;
                string2 = "";
                str = "";
                string = null;
                z = false;
                z2 = false;
                viewHolder2 = null;
                z3 = false;
                break;
        }
        UIViewState uiViewState = screenshotMessageDM.getUiViewState();
        String str2 = str;
        String str3 = string2;
        ImageLoader.getInstance().load(filePath, viewHolder.roundedImageView, this.context.getResources().getDrawable(R.drawable.hs__placeholder_image));
        viewHolder.roundedImageView.setAlpha(f);
        setViewVisibility(viewHolder.roundedImageView, z4);
        viewHolder.subText.setVisibility(0);
        if (uiViewState.isFooterVisible()) {
            viewHolder.subText.setText(string);
            viewHolder.subText.setTextColor(color);
        }
        setViewVisibility(viewHolder.subText, uiViewState.isFooterVisible());
        setViewVisibility(viewHolder.progress, z2);
        setViewVisibility(viewHolder.retryButton, z);
        if (z) {
            viewHolder.retryButton.setOnClickListener(viewHolder2);
            onClickListener = null;
        } else {
            onClickListener = null;
            viewHolder.retryButton.setOnClickListener(null);
        }
        if (z3) {
            viewHolder.roundedImageView.setOnClickListener(new View.OnClickListener() { // from class: com.helpshift.support.conversations.messages.ScreenshotMessageViewDataBinder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ScreenshotMessageViewDataBinder.this.messageClickListener.onScreenshotMessageClicked(screenshotMessageDM);
                }
            });
        } else {
            viewHolder.roundedImageView.setOnClickListener(onClickListener);
        }
        viewHolder.messageLayout.setContentDescription(str3);
        viewHolder.roundedImageView.setContentDescription(str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public final class ViewHolder extends RecyclerView.w implements View.OnClickListener {
        final View messageLayout;
        private final ProgressBar progress;
        final ImageView retryButton;
        final HSRoundedImageView roundedImageView;
        final TextView subText;

        ViewHolder(View view) {
            super(view);
            this.messageLayout = view.findViewById(R.id.user_image_message_layout);
            this.progress = (ProgressBar) view.findViewById(R.id.upload_attachment_progressbar);
            this.roundedImageView = (HSRoundedImageView) view.findViewById(R.id.user_attachment_imageview);
            this.subText = (TextView) view.findViewById(R.id.date);
            this.retryButton = (ImageView) view.findViewById(R.id.user_message_retry_button);
            Styles.setAccentColor(ScreenshotMessageViewDataBinder.this.context, this.progress.getIndeterminateDrawable());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ScreenshotMessageViewDataBinder.this.messageClickListener != null) {
                ScreenshotMessageViewDataBinder.this.messageClickListener.retryMessage(getAdapterPosition());
            }
        }
    }
}
