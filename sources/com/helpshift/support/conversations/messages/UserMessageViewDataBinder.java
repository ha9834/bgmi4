package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.helpshift.R;
import com.helpshift.conversation.activeconversation.message.UIViewState;
import com.helpshift.conversation.activeconversation.message.UserMessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageState;
import com.helpshift.util.Styles;

/* loaded from: classes2.dex */
public class UserMessageViewDataBinder extends MessageViewDataBinder<ViewHolder, UserMessageDM> {
    public UserMessageViewDataBinder(Context context) {
        super(context);
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hs__msg_txt_user, viewGroup, false));
        setUserMessageLayoutMargin(viewHolder.messageBubble.getLayoutParams());
        viewHolder.setListeners();
        return viewHolder;
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public void bind(ViewHolder viewHolder, UserMessageDM userMessageDM) {
        boolean z;
        UserMessageState state = userMessageDM.getState();
        viewHolder.messageText.setText(escapeHtml(userMessageDM.body));
        String str = "";
        int color = Styles.getColor(this.context, android.R.attr.textColorSecondary);
        String str2 = "";
        boolean z2 = true;
        boolean z3 = false;
        float f = 0.5f;
        switch (state) {
            case UNSENT_NOT_RETRYABLE:
                str = this.context.getString(R.string.hs__sending_fail_msg);
                str2 = this.context.getString(R.string.hs__user_failed_message_voice_over);
                color = Styles.getColor(this.context, R.attr.hs__errorTextColor);
                z = true;
                break;
            case UNSENT_RETRYABLE:
                str = this.context.getString(R.string.hs__sending_fail_msg);
                str2 = this.context.getString(R.string.hs__user_failed_message_voice_over);
                color = Styles.getColor(this.context, R.attr.hs__errorTextColor);
                z = true;
                z2 = false;
                z3 = true;
                break;
            case SENDING:
                str = this.context.getString(R.string.hs__sending_msg);
                str2 = this.context.getString(R.string.hs__user_sending_message_voice_over);
                z = false;
                z2 = false;
                break;
            case SENT:
                str = userMessageDM.getSubText();
                str2 = this.context.getString(R.string.hs__user_sent_message_voice_over, userMessageDM.getAccessbilityMessageTime());
                f = 1.0f;
                z = true;
                break;
            default:
                z = true;
                break;
        }
        viewHolder.messageLayout.setContentDescription(str2);
        viewHolder.subText.setTextColor(color);
        viewHolder.messageBubble.setAlpha(f);
        if (z2) {
            linkify(viewHolder.messageText, null);
        }
        viewHolder.messageText.setEnabled(z);
        setViewVisibility(viewHolder.retryButton, z3);
        UIViewState uiViewState = userMessageDM.getUiViewState();
        setUserMessageContainerBackground(viewHolder.messageBubble, uiViewState);
        setUserMessageSubText(viewHolder.subText, uiViewState, str);
        if (z3) {
            viewHolder.retryButton.setOnClickListener(viewHolder);
        } else {
            viewHolder.retryButton.setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public final class ViewHolder extends RecyclerView.w implements View.OnClickListener, View.OnCreateContextMenuListener {
        final FrameLayout messageBubble;
        final View messageLayout;
        final TextView messageText;
        final ImageView retryButton;
        final TextView subText;

        ViewHolder(View view) {
            super(view);
            this.messageText = (TextView) view.findViewById(R.id.user_message_text);
            this.subText = (TextView) view.findViewById(R.id.user_date_text);
            this.messageBubble = (FrameLayout) view.findViewById(R.id.user_message_container);
            this.retryButton = (ImageView) view.findViewById(R.id.user_message_retry_button);
            this.messageLayout = view.findViewById(R.id.user_text_message_layout);
        }

        void setListeners() {
            this.messageText.setOnCreateContextMenuListener(this);
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            if (UserMessageViewDataBinder.this.messageClickListener != null) {
                UserMessageViewDataBinder.this.messageClickListener.onCreateContextMenu(contextMenu, ((TextView) view).getText().toString());
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (UserMessageViewDataBinder.this.messageClickListener != null) {
                UserMessageViewDataBinder.this.messageClickListener.retryMessage(getAdapterPosition());
            }
        }
    }
}
