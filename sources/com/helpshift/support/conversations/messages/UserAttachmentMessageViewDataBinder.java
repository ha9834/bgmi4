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
import com.helpshift.conversation.activeconversation.message.UIViewState;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.support.util.Styles;

/* loaded from: classes2.dex */
public class UserAttachmentMessageViewDataBinder extends MessageViewDataBinder<ViewHolder, UserAttachmentMessageDM> {
    public UserAttachmentMessageViewDataBinder(Context context) {
        super(context);
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.hs__msg_user_attachment_generic, viewGroup, false));
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public void bind(ViewHolder viewHolder, final UserAttachmentMessageDM userAttachmentMessageDM) {
        String string;
        String str;
        String str2;
        ViewHolder viewHolder2;
        boolean z;
        int i;
        int i2;
        String str3;
        boolean z2;
        boolean z3;
        float f;
        View.OnClickListener onClickListener;
        int color = Styles.getColor(this.context, android.R.attr.textColorPrimary);
        int color2 = Styles.getColor(this.context, android.R.attr.textColorSecondary);
        String formattedFileSize = userAttachmentMessageDM.getFormattedFileSize();
        String subText = userAttachmentMessageDM.getSubText();
        boolean z4 = false;
        boolean z5 = true;
        switch (userAttachmentMessageDM.state) {
            case SENDING:
                String formattedFileSize2 = userAttachmentMessageDM.getFormattedFileSize();
                subText = this.context.getResources().getString(R.string.hs__sending_msg);
                string = this.context.getString(R.string.hs__user_sending_message_voice_over);
                str = "";
                str2 = "";
                viewHolder2 = null;
                z = false;
                z5 = false;
                i = color;
                i2 = color2;
                str3 = formattedFileSize2;
                z2 = true;
                z3 = false;
                f = 0.5f;
                break;
            case SENT:
                int color3 = Styles.getColor(this.context, R.attr.colorAccent);
                string = this.context.getString(R.string.hs__user_sent_message_voice_over, userAttachmentMessageDM.getAccessbilityMessageTime());
                str = "";
                str2 = this.context.getString(R.string.hs__attachment_downloaded__voice_over, userAttachmentMessageDM.fileName);
                viewHolder2 = null;
                z = true;
                i = color3;
                i2 = color2;
                str3 = formattedFileSize;
                z2 = false;
                z3 = false;
                f = 1.0f;
                break;
            case UNSENT_RETRYABLE:
                subText = this.context.getResources().getString(R.string.hs__sending_fail_msg);
                int color4 = Styles.getColor(this.context, R.attr.hs__errorTextColor);
                String string2 = this.context.getString(R.string.hs__user_failed_message_voice_over);
                viewHolder2 = viewHolder;
                string = string2;
                str = this.context.getString(R.string.hs__retry_button_voice_over);
                str2 = this.context.getString(R.string.hs__attachment_name_voice_over, userAttachmentMessageDM.fileName, userAttachmentMessageDM.getFormattedFileSize());
                z = false;
                i = color;
                i2 = color4;
                str3 = formattedFileSize;
                z2 = false;
                z3 = true;
                f = 0.5f;
                break;
            case UNSENT_NOT_RETRYABLE:
                if (userAttachmentMessageDM.isRejected) {
                    subText = this.context.getString(R.string.hs__file_type_unsupported);
                } else {
                    subText = this.context.getResources().getString(R.string.hs__sending_fail_msg);
                }
                int color5 = Styles.getColor(this.context, R.attr.hs__errorTextColor);
                string = this.context.getString(R.string.hs__user_attachment_rejected_voice_over);
                str = "";
                str2 = this.context.getString(R.string.hs__attachment_name_voice_over, userAttachmentMessageDM.fileName, userAttachmentMessageDM.getFormattedFileSize());
                viewHolder2 = null;
                z = false;
                i = color;
                i2 = color5;
                str3 = formattedFileSize;
                z2 = false;
                z3 = false;
                f = 0.5f;
                break;
            case DOWNLOAD_NOT_STARTED:
                string = this.context.getString(R.string.hs__user_sent_message_voice_over, userAttachmentMessageDM.getAccessbilityMessageTime());
                str = "";
                str2 = this.context.getString(R.string.hs__attachment_not_downloaded_voice_over, userAttachmentMessageDM.fileName, userAttachmentMessageDM.getFormattedFileSize());
                viewHolder2 = null;
                z = true;
                z4 = true;
                z5 = false;
                i = color;
                i2 = color2;
                str3 = formattedFileSize;
                z2 = false;
                z3 = false;
                f = 1.0f;
                break;
            case DOWNLOADING:
                String progressAndFileSize = userAttachmentMessageDM.getProgressAndFileSize();
                string = this.context.getString(R.string.hs__user_sent_message_voice_over, userAttachmentMessageDM.getAccessbilityMessageTime());
                str = "";
                str2 = this.context.getString(R.string.hs__attachment_downloading_voice_over, userAttachmentMessageDM.fileName, userAttachmentMessageDM.getProgressAndFileSize(), userAttachmentMessageDM.getFormattedFileSize());
                viewHolder2 = null;
                z = false;
                z5 = false;
                i = color;
                i2 = color2;
                str3 = progressAndFileSize;
                z2 = true;
                z3 = false;
                f = 1.0f;
                break;
            default:
                string = "";
                str = "";
                str2 = "";
                viewHolder2 = null;
                z = false;
                z5 = false;
                i = color;
                i2 = color2;
                str3 = formattedFileSize;
                z2 = false;
                z3 = false;
                f = 0.5f;
                break;
        }
        UIViewState uiViewState = userAttachmentMessageDM.getUiViewState();
        String str4 = str2;
        setViewVisibility(viewHolder.downloadButton, z4);
        setViewVisibility(viewHolder.attachmentIcon, z5);
        setViewVisibility(viewHolder.progress, z2);
        setViewVisibility(viewHolder.retryButton, z3);
        setViewVisibility(viewHolder.subText, uiViewState.isFooterVisible());
        viewHolder.messageLayout.setAlpha(f);
        viewHolder.fileName.setText(userAttachmentMessageDM.fileName);
        viewHolder.fileSize.setText(str3);
        viewHolder.fileName.setTextColor(i);
        if (uiViewState.isFooterVisible()) {
            viewHolder.subText.setText(subText);
            viewHolder.subText.setTextColor(i2);
        }
        if (z3) {
            viewHolder.retryButton.setOnClickListener(viewHolder2);
            onClickListener = null;
        } else {
            onClickListener = null;
            viewHolder.retryButton.setOnClickListener(null);
        }
        if (z) {
            viewHolder.messageLayout.setOnClickListener(new View.OnClickListener() { // from class: com.helpshift.support.conversations.messages.UserAttachmentMessageViewDataBinder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UserAttachmentMessageViewDataBinder.this.messageClickListener.onUserAttachmentMessageClicked(userAttachmentMessageDM);
                }
            });
        } else {
            viewHolder.messageLayout.setOnClickListener(onClickListener);
        }
        viewHolder.messageContainer.setContentDescription(string);
        viewHolder.messageLayout.setContentDescription(str4);
        viewHolder.retryButton.setContentDescription(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public final class ViewHolder extends RecyclerView.w implements View.OnClickListener {
        final ImageView attachmentIcon;
        final View downloadButton;
        final TextView fileName;
        final TextView fileSize;
        final View messageContainer;
        final View messageLayout;
        final ProgressBar progress;
        final ImageView retryButton;
        final TextView subText;

        ViewHolder(View view) {
            super(view);
            this.messageLayout = view.findViewById(R.id.user_attachment_message_layout);
            this.messageContainer = view.findViewById(R.id.user_attachment_container);
            this.fileName = (TextView) view.findViewById(R.id.attachment_file_name);
            this.fileSize = (TextView) view.findViewById(R.id.attachment_file_size);
            this.downloadButton = view.findViewById(R.id.download_button);
            this.progress = (ProgressBar) view.findViewById(R.id.progress);
            this.attachmentIcon = (ImageView) view.findViewById(R.id.attachment_icon);
            this.subText = (TextView) view.findViewById(R.id.date);
            this.retryButton = (ImageView) view.findViewById(R.id.user_message_retry_button);
            com.helpshift.util.Styles.setColorFilter(UserAttachmentMessageViewDataBinder.this.context, ((ImageView) view.findViewById(R.id.hs_download_foreground_view)).getDrawable(), R.attr.hs__chatBubbleMediaBackgroundColor);
            Styles.setAccentColor(UserAttachmentMessageViewDataBinder.this.context, this.progress.getIndeterminateDrawable());
            Styles.setAccentColor(UserAttachmentMessageViewDataBinder.this.context, this.attachmentIcon.getDrawable());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (UserAttachmentMessageViewDataBinder.this.messageClickListener != null) {
                UserAttachmentMessageViewDataBinder.this.messageClickListener.retryMessage(getAdapterPosition());
            }
        }
    }
}
