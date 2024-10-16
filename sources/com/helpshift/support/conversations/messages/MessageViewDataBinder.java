package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.text.Html;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.w;
import com.helpshift.R;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.FAQListMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.OptionInputMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.UIViewState;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import com.helpshift.util.HSLinkify;
import com.helpshift.util.HSPattern;
import com.helpshift.util.StringUtils;
import com.helpshift.util.Styles;
import com.helpshift.views.CircleImageView;

/* loaded from: classes2.dex */
public abstract class MessageViewDataBinder<VH extends RecyclerView.w, M extends MessageDM> {
    protected static final float BUBBLE_OPAGUE = 1.0f;
    protected static final float BUBBLE_TRANSLUCENT = 0.5f;
    protected Context context;
    protected MessageItemClickListener messageClickListener;

    /* loaded from: classes2.dex */
    public interface MessageItemClickListener {
        void downloadAvatarImage(MessageDM messageDM);

        void handleAdminImageAttachmentMessageClick(AdminImageAttachmentMessageDM adminImageAttachmentMessageDM);

        void handleGenericAttachmentMessageClick(AdminAttachmentMessageDM adminAttachmentMessageDM);

        void handleOptionSelected(OptionInputMessageDM optionInputMessageDM, OptionInput.Option option, boolean z);

        void handleReplyReviewButtonClick(RequestAppReviewMessageDM requestAppReviewMessageDM);

        void launchImagePicker(RequestScreenshotMessageDM requestScreenshotMessageDM);

        void onActionCardClicked(AdminActionCardMessageDM adminActionCardMessageDM);

        void onAdminMessageLinkClickFailed();

        void onAdminMessageLinkClicked(String str, MessageDM messageDM);

        void onAdminSuggestedQuestionSelected(FAQListMessageDM fAQListMessageDM, String str, String str2);

        void onCreateContextMenu(ContextMenu contextMenu, String str);

        void onScreenshotMessageClicked(ScreenshotMessageDM screenshotMessageDM);

        void onUserAttachmentMessageClicked(UserAttachmentMessageDM userAttachmentMessageDM);

        void retryMessage(int i);
    }

    public abstract void bind(VH vh, M m);

    public abstract VH createViewHolder(ViewGroup viewGroup);

    public MessageViewDataBinder(Context context) {
        this.context = context;
    }

    public void setMessageItemClickListener(MessageItemClickListener messageItemClickListener) {
        this.messageClickListener = messageItemClickListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void linkify(TextView textView, HSLinkify.LinkClickListener linkClickListener) {
        HSLinkify.addLinks(textView, 14, linkClickListener);
        HSLinkify.addLinks(textView, HSPattern.getUrlPattern(), (String) null, (HSLinkify.MatchFilter) null, (HSLinkify.TransformFilter) null, linkClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String escapeHtml(String str) {
        return Html.fromHtml(str.replace("\n", "<br/>")).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getRedactedBodyText(String str) {
        return str + " ";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdminMessageContainerBackground(View view, UIViewState uIViewState) {
        setDrawable(view, uIViewState.isRoundedBackground() ? R.drawable.hs__chat_bubble_rounded : R.drawable.hs__chat_bubble_admin, R.attr.hs__chatBubbleAdminBackgroundColor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdminMessageSubText(TextView textView, UIViewState uIViewState, String str) {
        textView.setText(str);
        setViewVisibility(textView, uIViewState.isFooterVisible());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUserMessageSubText(TextView textView, UIViewState uIViewState, String str) {
        textView.setText(str);
        setViewVisibility(textView, uIViewState.isFooterVisible());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUserMessageContainerBackground(View view, UIViewState uIViewState) {
        setDrawable(view, uIViewState.isRoundedBackground() ? R.drawable.hs__chat_bubble_rounded : R.drawable.hs__chat_bubble_user, R.attr.hs__chatBubbleUserBackgroundColor);
    }

    public void setAuthorAvatar(MessageDM messageDM, CircleImageView circleImageView) {
        UIViewState uiViewState = messageDM.getUiViewState();
        if (messageDM.shouldShowAvatar()) {
            if (uiViewState.isFooterVisible() && !uiViewState.isRoundedBackground()) {
                setViewVisibility(circleImageView, true);
                AvatarImageLoader.loadAvatarImageAccordingToState(this.context, messageDM, circleImageView);
                MessageItemClickListener messageItemClickListener = this.messageClickListener;
                if (messageItemClickListener != null) {
                    messageItemClickListener.downloadAvatarImage(messageDM);
                    return;
                }
                return;
            }
            circleImageView.setVisibility(4);
            return;
        }
        setViewVisibility(circleImageView, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAdminMessageLayoutMarginForAvatar(ViewGroup.LayoutParams layoutParams) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins((int) this.context.getResources().getDimension(R.dimen.hs__author_avatar_size), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUserMessageLayoutMargin(ViewGroup.LayoutParams layoutParams) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        float f = this.context.getResources().getDisplayMetrics().widthPixels;
        TypedValue typedValue = new TypedValue();
        this.context.getResources().getValue(R.dimen.hs__screen_to_conversation_view_ratio, typedValue, true);
        marginLayoutParams.setMargins((int) (f * typedValue.getFloat() * 0.2f), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setViewVisibility(View view, boolean z) {
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setDrawable(View view, int i, int i2) {
        Styles.setDrawable(this.context, view, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getAdminMessageContentDesciption(MessageDM messageDM) {
        String displayedAuthorName = messageDM.getDisplayedAuthorName();
        String accessbilityMessageTime = messageDM.getAccessbilityMessageTime();
        return StringUtils.isEmpty(displayedAuthorName) ? this.context.getString(R.string.hs__agent_message_voice_over, accessbilityMessageTime) : this.context.getString(R.string.hs__agent_message_with_name_voice_over, displayedAuthorName, accessbilityMessageTime);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void applyRedactionStyle(TextView textView) {
        textView.setTypeface(textView.getTypeface(), 2);
        textView.setAlpha(0.55f);
    }
}
