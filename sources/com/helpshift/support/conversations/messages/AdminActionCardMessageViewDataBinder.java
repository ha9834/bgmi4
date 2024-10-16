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
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.support.imageloader.ImageLoader;

/* loaded from: classes2.dex */
public class AdminActionCardMessageViewDataBinder extends MessageViewDataBinder<ViewHolder, AdminActionCardMessageDM> {
    public AdminActionCardMessageViewDataBinder(Context context) {
        super(context);
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.hs__msg_admin_action_card, viewGroup, false));
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public void bind(ViewHolder viewHolder, final AdminActionCardMessageDM adminActionCardMessageDM) {
        boolean isActionCardTitleVisible = adminActionCardMessageDM.isActionCardTitleVisible();
        viewHolder.actionCardImage.setImageResource(R.drawable.hs__placeholder_image);
        boolean z = false;
        boolean z2 = true;
        switch (adminActionCardMessageDM.state) {
            case IMAGE_DOWNLOADED:
                ImageLoader.getInstance().load(adminActionCardMessageDM.actionCard.filePath, viewHolder.actionCardImage, this.context.getResources().getDrawable(R.drawable.hs__placeholder_image));
                break;
            case DOWNLOAD_NOT_STARTED:
                break;
            case IMAGE_DOWNLOADING:
                z = true;
                break;
            default:
                z2 = false;
                break;
        }
        setViewVisibility(viewHolder.imageViewContainer, z2);
        setViewVisibility(viewHolder.actionTitle, isActionCardTitleVisible);
        setViewVisibility(viewHolder.separator, isActionCardTitleVisible);
        setViewVisibility(viewHolder.progress, z);
        viewHolder.actionButton.setOnClickListener(new View.OnClickListener() { // from class: com.helpshift.support.conversations.messages.AdminActionCardMessageViewDataBinder.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AdminActionCardMessageViewDataBinder.this.messageClickListener.onActionCardClicked(adminActionCardMessageDM);
            }
        });
        if (isActionCardTitleVisible) {
            viewHolder.actionTitle.setText(adminActionCardMessageDM.actionCard.title);
            viewHolder.actionTitle.setContentDescription(adminActionCardMessageDM.actionCard.title);
        }
        setAdminMessageSubText(viewHolder.dateText, adminActionCardMessageDM.getUiViewState(), adminActionCardMessageDM.getSubText());
        viewHolder.actionButton.setText(adminActionCardMessageDM.actionCard.action.actionTitle);
        viewHolder.actionButton.setContentDescription(adminActionCardMessageDM.actionCard.action.actionTitle);
        viewHolder.messageContainer.setContentDescription(getAdminMessageContentDesciption(adminActionCardMessageDM));
        if (adminActionCardMessageDM.shouldShowAvatar()) {
            setAdminMessageLayoutMarginForAvatar(viewHolder.actionCardView.getLayoutParams());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public final class ViewHolder extends RecyclerView.w {
        final TextView actionButton;
        final ImageView actionCardImage;
        final View actionCardView;
        final TextView actionTitle;
        final TextView dateText;
        final View imageViewContainer;
        final View messageContainer;
        final ProgressBar progress;
        final View separator;

        ViewHolder(View view) {
            super(view);
            this.actionTitle = (TextView) view.findViewById(R.id.action_card_title);
            this.dateText = (TextView) view.findViewById(R.id.admin_date_text);
            this.actionButton = (TextView) view.findViewById(R.id.action_card_action);
            this.progress = (ProgressBar) view.findViewById(R.id.download_progressbar);
            this.actionCardImage = (ImageView) view.findViewById(R.id.action_card_imageview);
            this.imageViewContainer = view.findViewById(R.id.action_card_imageview_container);
            this.separator = view.findViewById(R.id.action_card_separator);
            this.messageContainer = view.findViewById(R.id.action_card_container);
            this.actionCardView = view.findViewById(R.id.action_card_cardview);
        }
    }
}
