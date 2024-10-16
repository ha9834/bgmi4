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
import com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM;
import com.helpshift.support.util.Styles;

/* loaded from: classes2.dex */
class AdminAttachmentMessageDataBinder extends MessageViewDataBinder<ViewHolder, AdminAttachmentMessageDM> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AdminAttachmentMessageDataBinder(Context context) {
        super(context);
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.hs__msg_attachment_generic, viewGroup, false));
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public void bind(ViewHolder viewHolder, final AdminAttachmentMessageDM adminAttachmentMessageDM) {
        String string;
        int i;
        boolean z;
        int color = Styles.getColor(this.context, android.R.attr.textColorPrimary);
        String formattedFileSize = adminAttachmentMessageDM.getFormattedFileSize();
        boolean z2 = true;
        boolean z3 = false;
        switch (adminAttachmentMessageDM.state) {
            case DOWNLOAD_NOT_STARTED:
                string = this.context.getString(R.string.hs__attachment_not_downloaded_voice_over, adminAttachmentMessageDM.fileName, adminAttachmentMessageDM.getFormattedFileSize());
                z2 = false;
                z3 = true;
                i = color;
                z = false;
                break;
            case DOWNLOADING:
                formattedFileSize = adminAttachmentMessageDM.getDownloadProgressAndFileSize();
                string = this.context.getString(R.string.hs__attachment_downloading_voice_over, adminAttachmentMessageDM.fileName, adminAttachmentMessageDM.getDownloadedProgressSize(), adminAttachmentMessageDM.getFormattedFileSize());
                z2 = false;
                i = color;
                z = true;
                break;
            case DOWNLOADED:
                int color2 = Styles.getColor(this.context, R.attr.colorAccent);
                string = this.context.getString(R.string.hs__attachment_downloaded__voice_over, adminAttachmentMessageDM.fileName);
                i = color2;
                z = false;
                break;
            default:
                string = "";
                z2 = false;
                i = color;
                z = false;
                break;
        }
        setViewVisibility(viewHolder.downloadButton, z3);
        setViewVisibility(viewHolder.attachmentIcon, z2);
        setViewVisibility(viewHolder.progress, z);
        viewHolder.fileName.setText(adminAttachmentMessageDM.fileName);
        viewHolder.fileSize.setText(formattedFileSize);
        viewHolder.fileName.setTextColor(i);
        viewHolder.messageContainer.setOnClickListener(new View.OnClickListener() { // from class: com.helpshift.support.conversations.messages.AdminAttachmentMessageDataBinder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdminAttachmentMessageDataBinder.this.messageClickListener != null) {
                    AdminAttachmentMessageDataBinder.this.messageClickListener.handleGenericAttachmentMessageClick(adminAttachmentMessageDM);
                }
            }
        });
        viewHolder.messageContainer.setContentDescription(string);
        viewHolder.messageLayout.setContentDescription(getAdminMessageContentDesciption(adminAttachmentMessageDM));
        if (adminAttachmentMessageDM.shouldShowAvatar()) {
            setAdminMessageLayoutMarginForAvatar(viewHolder.messageContainer.getLayoutParams());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public final class ViewHolder extends RecyclerView.w {
        final ImageView attachmentIcon;
        final View downloadButton;
        final TextView fileName;
        final TextView fileSize;
        final View messageContainer;
        final View messageLayout;
        final ProgressBar progress;

        ViewHolder(View view) {
            super(view);
            this.messageLayout = view.findViewById(R.id.admin_attachment_message_layout);
            this.fileName = (TextView) view.findViewById(R.id.attachment_file_name);
            this.fileSize = (TextView) view.findViewById(R.id.attachment_file_size);
            this.messageContainer = view.findViewById(R.id.admin_message);
            this.downloadButton = view.findViewById(R.id.download_button);
            this.progress = (ProgressBar) view.findViewById(R.id.progress);
            this.attachmentIcon = (ImageView) view.findViewById(R.id.attachment_icon);
            com.helpshift.util.Styles.setColorFilter(AdminAttachmentMessageDataBinder.this.context, ((ImageView) view.findViewById(R.id.hs_download_foreground_view)).getDrawable(), R.attr.hs__chatBubbleMediaBackgroundColor);
            com.helpshift.util.Styles.setColorFilter(AdminAttachmentMessageDataBinder.this.context, this.messageContainer.getBackground(), R.attr.hs__chatBubbleMediaBackgroundColor);
            Styles.setAccentColor(AdminAttachmentMessageDataBinder.this.context, this.progress.getIndeterminateDrawable());
            Styles.setAccentColor(AdminAttachmentMessageDataBinder.this.context, this.attachmentIcon.getDrawable());
        }
    }
}
