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
import com.helpshift.conversation.activeconversation.message.UserMessageState;
import com.helpshift.conversation.activeconversation.message.UserSmartIntentMessageDM;
import com.helpshift.util.Styles;

/* loaded from: classes2.dex */
public class UserSmartIntentMessageViewDataBinder extends MessageViewDataBinder<ViewHolder, UserSmartIntentMessageDM> {
    public UserSmartIntentMessageViewDataBinder(Context context) {
        super(context);
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public ViewHolder createViewHolder(ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hs__msg_smart_intent_txt_user, viewGroup, false));
        setUserMessageLayoutMargin(viewHolder.messageBubble.getLayoutParams());
        viewHolder.setListeners();
        return viewHolder;
    }

    @Override // com.helpshift.support.conversations.messages.MessageViewDataBinder
    public void bind(ViewHolder viewHolder, UserSmartIntentMessageDM userSmartIntentMessageDM) {
        UserMessageState state = userSmartIntentMessageDM.getState();
        boolean z = true;
        boolean z2 = false;
        if (userSmartIntentMessageDM.intentLabels.size() >= 2) {
            viewHolder.rootLabelText.setText(userSmartIntentMessageDM.intentLabels.get(0));
            viewHolder.leafLabelText.setText(userSmartIntentMessageDM.intentLabels.get(1));
        }
        float f = 0.5f;
        String str = "";
        int color = Styles.getColor(this.context, android.R.attr.textColorSecondary);
        String str2 = "";
        switch (state) {
            case UNSENT_NOT_RETRYABLE:
                str = this.context.getString(R.string.hs__sending_fail_msg);
                str2 = this.context.getString(R.string.hs__user_failed_message_voice_over);
                color = Styles.getColor(this.context, R.attr.hs__errorTextColor);
                break;
            case UNSENT_RETRYABLE:
                str = this.context.getString(R.string.hs__sending_fail_msg);
                str2 = this.context.getString(R.string.hs__user_failed_message_voice_over);
                color = Styles.getColor(this.context, R.attr.hs__errorTextColor);
                z2 = true;
                break;
            case SENDING:
                str = this.context.getString(R.string.hs__sending_msg);
                str2 = this.context.getString(R.string.hs__user_sending_message_voice_over);
                z = false;
                break;
            case SENT:
                str = userSmartIntentMessageDM.getSubText();
                str2 = this.context.getString(R.string.hs__user_sent_message_voice_over, userSmartIntentMessageDM.getAccessbilityMessageTime());
                f = 1.0f;
                break;
        }
        viewHolder.messageLayout.setContentDescription(str2);
        viewHolder.subText.setTextColor(color);
        viewHolder.messageBubble.setAlpha(f);
        viewHolder.rootLabelText.setEnabled(z);
        viewHolder.leafLabelText.setEnabled(z);
        setViewVisibility(viewHolder.retryButton, z2);
        UIViewState uiViewState = userSmartIntentMessageDM.getUiViewState();
        setUserMessageContainerBackground(viewHolder.messageBubble, uiViewState);
        setUserMessageSubText(viewHolder.subText, uiViewState, str);
        if (z2) {
            viewHolder.retryButton.setOnClickListener(viewHolder);
        } else {
            viewHolder.retryButton.setOnClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public final class ViewHolder extends RecyclerView.w implements View.OnClickListener, View.OnCreateContextMenuListener {
        final TextView leafLabelText;
        final FrameLayout messageBubble;
        final View messageLayout;
        final ImageView retryButton;
        final TextView rootLabelText;
        final TextView subText;

        ViewHolder(View view) {
            super(view);
            this.rootLabelText = (TextView) view.findViewById(R.id.smart_intent_root_label);
            this.leafLabelText = (TextView) view.findViewById(R.id.smart_intent_leaf_label);
            this.subText = (TextView) view.findViewById(R.id.user_date_text);
            this.messageBubble = (FrameLayout) view.findViewById(R.id.user_message_container);
            this.retryButton = (ImageView) view.findViewById(R.id.user_message_retry_button);
            this.messageLayout = view.findViewById(R.id.smart_intent_user_message_layout);
        }

        void setListeners() {
            this.messageLayout.setOnCreateContextMenuListener(this);
        }

        @Override // android.view.View.OnCreateContextMenuListener
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            if (UserSmartIntentMessageViewDataBinder.this.messageClickListener != null) {
                UserSmartIntentMessageViewDataBinder.this.messageClickListener.onCreateContextMenu(contextMenu, ((Object) this.rootLabelText.getText()) + " " + ((Object) this.leafLabelText.getText()));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (UserSmartIntentMessageViewDataBinder.this.messageClickListener != null) {
                UserSmartIntentMessageViewDataBinder.this.messageClickListener.retryMessage(getAdapterPosition());
            }
        }
    }
}
