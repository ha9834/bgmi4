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
import com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM;
import com.helpshift.support.imageloader.ImageLoader;
import com.helpshift.support.views.HSRoundedImageView;
import com.helpshift.util.Styles;

/* loaded from: classes2.dex */
class AdminImageAttachmentMessageDataBinder extends MessageViewDataBinder<ViewHolder, AdminImageAttachmentMessageDM> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AdminImageAttachmentMessageDataBinder(Context context) {
        super(context);
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.hs__msg_attachment_image, viewGroup, false));
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public void bind(ViewHolder viewHolder, final AdminImageAttachmentMessageDM adminImageAttachmentMessageDM) {
        String string;
        String str;
        String str2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String formattedFileSize = adminImageAttachmentMessageDM.getFormattedFileSize();
        boolean z5 = false;
        switch (adminImageAttachmentMessageDM.state) {
            case DOWNLOAD_NOT_STARTED:
                string = this.context.getString(R.string.hs__image_not_downloaded_voice_over, adminImageAttachmentMessageDM.getFormattedFileSize());
                str = formattedFileSize;
                str2 = null;
                z = false;
                z2 = true;
                z3 = true;
                z5 = true;
                z4 = true;
                break;
            case THUMBNAIL_DOWNLOADING:
                string = this.context.getString(R.string.hs__image_not_downloaded_voice_over, adminImageAttachmentMessageDM.getFormattedFileSize());
                str = formattedFileSize;
                str2 = null;
                z = false;
                z2 = true;
                z3 = true;
                z5 = true;
                z4 = true;
                break;
            case THUMBNAIL_DOWNLOADED:
                str2 = adminImageAttachmentMessageDM.checkAndGetThumbnailFilePath();
                str = formattedFileSize;
                string = this.context.getString(R.string.hs__image_not_downloaded_voice_over, adminImageAttachmentMessageDM.getFormattedFileSize());
                z = false;
                z2 = true;
                z3 = true;
                z5 = true;
                z4 = true;
                break;
            case IMAGE_DOWNLOADING:
                str2 = adminImageAttachmentMessageDM.checkAndGetThumbnailFilePath();
                str = adminImageAttachmentMessageDM.getDownloadProgressAndFileSize();
                string = this.context.getString(R.string.hs__image_downloading_voice_over, adminImageAttachmentMessageDM.getDownloadedProgressSize(), adminImageAttachmentMessageDM.getFormattedFileSize());
                z = true;
                z2 = false;
                z3 = true;
                z5 = true;
                z4 = false;
                break;
            case IMAGE_DOWNLOADED:
                str2 = adminImageAttachmentMessageDM.checkAndGetFilePath();
                str = formattedFileSize;
                string = this.context.getString(R.string.hs__image_downloaded_voice_over);
                z = false;
                z2 = false;
                z3 = false;
                z4 = true;
                break;
            default:
                string = "";
                str = formattedFileSize;
                str2 = null;
                z = true;
                z2 = false;
                z3 = true;
                z5 = true;
                z4 = true;
                break;
        }
        setViewVisibility(viewHolder.downloadProgressbarContainer, z5);
        setViewVisibility(viewHolder.progressBarView, z);
        setViewVisibility(viewHolder.downloadButtonView, z2);
        if (z3) {
            viewHolder.roundedImageView.setAlpha(0.25f);
        } else {
            viewHolder.roundedImageView.setAlpha(1.0f);
        }
        setViewVisibility(viewHolder.fileSize, true);
        ImageLoader.getInstance().load(str2, viewHolder.roundedImageView, this.context.getResources().getDrawable(R.drawable.hs__placeholder_image));
        viewHolder.fileSize.setText(str);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.helpshift.support.conversations.messages.AdminImageAttachmentMessageDataBinder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AdminImageAttachmentMessageDataBinder.this.messageClickListener != null) {
                    AdminImageAttachmentMessageDataBinder.this.messageClickListener.handleAdminImageAttachmentMessageClick(adminImageAttachmentMessageDM);
                }
            }
        };
        if (z2) {
            viewHolder.downloadButtonView.setOnClickListener(onClickListener);
        } else {
            viewHolder.downloadButtonView.setOnClickListener(null);
        }
        if (z4) {
            viewHolder.roundedImageView.setOnClickListener(onClickListener);
        } else {
            viewHolder.roundedImageView.setOnClickListener(null);
        }
        viewHolder.roundedImageView.setContentDescription(string);
        viewHolder.messageLayout.setContentDescription(getAdminMessageContentDesciption(adminImageAttachmentMessageDM));
        if (adminImageAttachmentMessageDM.shouldShowAvatar()) {
            setAdminMessageLayoutMarginForAvatar(viewHolder.messageContainer.getLayoutParams());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public final class ViewHolder extends RecyclerView.w {
        final View downloadButtonView;
        final View downloadProgressbarContainer;
        final TextView fileSize;
        final View messageContainer;
        final View messageLayout;
        final ProgressBar progressBarView;
        final HSRoundedImageView roundedImageView;

        ViewHolder(View view) {
            super(view);
            this.messageLayout = view.findViewById(R.id.admin_image_message_layout);
            this.roundedImageView = (HSRoundedImageView) view.findViewById(R.id.admin_attachment_imageview);
            this.downloadButtonView = view.findViewById(R.id.download_button);
            this.downloadProgressbarContainer = view.findViewById(R.id.download_progressbar_container);
            this.progressBarView = (ProgressBar) view.findViewById(R.id.download_attachment_progressbar);
            this.fileSize = (TextView) view.findViewById(R.id.attachment_file_size);
            this.messageContainer = view.findViewById(R.id.admin_image_attachment_message_container);
            Styles.setColorFilter(AdminImageAttachmentMessageDataBinder.this.context, ((ImageView) view.findViewById(R.id.hs_download_foreground_view)).getDrawable(), R.attr.hs__chatBubbleMediaBackgroundColor);
            com.helpshift.support.util.Styles.setAccentColor(AdminImageAttachmentMessageDataBinder.this.context, this.progressBarView.getIndeterminateDrawable());
        }
    }
}
