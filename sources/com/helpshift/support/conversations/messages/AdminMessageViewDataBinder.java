package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.R;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.UIViewState;
import com.helpshift.util.HSLinkify;
import com.helpshift.util.StringUtils;
import com.helpshift.views.CircleImageView;

/* loaded from: classes2.dex */
class AdminMessageViewDataBinder extends MessageViewDataBinder<ViewHolder, MessageDM> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public AdminMessageViewDataBinder(Context context) {
        super(context);
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hs__msg_txt_admin, viewGroup, false));
        viewHolder.setListeners();
        return viewHolder;
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public void bind(ViewHolder viewHolder, final MessageDM messageDM) {
        if (StringUtils.isEmpty(messageDM.body)) {
            viewHolder.messageLayout.setVisibility(8);
            return;
        }
        viewHolder.messageLayout.setVisibility(0);
        viewHolder.messageText.setText(escapeHtml(messageDM.body));
        UIViewState uiViewState = messageDM.getUiViewState();
        setAdminMessageContainerBackground(viewHolder.messageContainer, uiViewState);
        setAdminMessageSubText(viewHolder.dateText, uiViewState, messageDM.getSubText());
        viewHolder.messageLayout.setContentDescription(getAdminMessageContentDesciption(messageDM));
        linkify(viewHolder.messageText, new HSLinkify.LinkClickListener() { // from class: com.helpshift.support.conversations.messages.AdminMessageViewDataBinder.1
            @Override // com.helpshift.util.HSLinkify.LinkClickListener
            public void onLinkClicked(String str) {
                if (AdminMessageViewDataBinder.this.messageClickListener != null) {
                    AdminMessageViewDataBinder.this.messageClickListener.onAdminMessageLinkClicked(str, messageDM);
                }
            }

            @Override // com.helpshift.util.HSLinkify.LinkClickListener
            public void onLinkClickFailed() {
                if (AdminMessageViewDataBinder.this.messageClickListener != null) {
                    AdminMessageViewDataBinder.this.messageClickListener.onAdminMessageLinkClickFailed();
                }
            }
        });
        setAuthorAvatar(messageDM, viewHolder.avatarImageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public final class ViewHolder extends RecyclerView.w implements View.OnCreateContextMenuListener {
        final CircleImageView avatarImageView;
        final TextView dateText;
        final View messageContainer;
        final View messageLayout;
        final TextView messageText;

        ViewHolder(View view) {
            super(view);
            this.messageLayout = view.findViewById(R.id.admin_text_message_layout);
            this.messageText = (TextView) view.findViewById(R.id.admin_message_text);
            this.dateText = (TextView) view.findViewById(R.id.admin_date_text);
            this.messageContainer = view.findViewById(R.id.admin_message_container);
            this.avatarImageView = (CircleImageView) view.findViewById(R.id.avatar_image_view);
        }

        void setListeners() {
            this.messageText.setOnCreateContextMenuListener(this);
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            if (AdminMessageViewDataBinder.this.messageClickListener != null) {
                AdminMessageViewDataBinder.this.messageClickListener.onCreateContextMenu(contextMenu, ((TextView) view).getText().toString());
            }
        }
    }
}
