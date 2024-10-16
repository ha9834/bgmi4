package com.helpshift.support.conversations.messages;

import android.content.Context;
import android.util.SparseArray;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminMessageDM;
import com.helpshift.conversation.activeconversation.message.ConfirmationRejectedMessageDM;
import com.helpshift.conversation.activeconversation.message.FAQListMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.OptionInputMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestForReopenMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.SystemDateMessageDM;
import com.helpshift.conversation.activeconversation.message.SystemDividerMessageDM;
import com.helpshift.conversation.activeconversation.message.SystemPublishIdMessageDM;
import com.helpshift.conversation.activeconversation.message.SystemRedactedConversationMessageDM;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageDM;
import com.helpshift.conversation.activeconversation.message.UserSmartIntentMessageDM;

/* loaded from: classes2.dex */
public class MessageViewTypeConverter {
    private AgentTypingMessageDataBinder agentTypingMessageDataBinder;
    private final Context context;
    private ConversationFooterViewBinder conversationFooterViewBinder;
    private HistoryLoadingViewBinder historyLoadingViewBinder;
    private SparseArray<MessageViewDataBinder> viewTypeToDataBinderMap = new SparseArray<>();

    public MessageViewTypeConverter(Context context) {
        this.context = context;
        this.conversationFooterViewBinder = new ConversationFooterViewBinder(context);
        this.agentTypingMessageDataBinder = new AgentTypingMessageDataBinder(context);
        this.historyLoadingViewBinder = new HistoryLoadingViewBinder(context);
    }

    public int messageToViewType(MessageDM messageDM) {
        if (messageDM.isRedacted) {
            if (messageDM.isAdminMessage) {
                return MessageViewType.ADMIN_REDACTED_MESSAGE.key;
            }
            return MessageViewType.USER_REDACTED_MESSAGE.key;
        }
        if (messageDM instanceof FAQListMessageDM) {
            return MessageViewType.ADMIN_SUGGESTIONS_LIST.key;
        }
        if (messageDM instanceof OptionInputMessageDM) {
            return MessageViewType.USER_SELECTABLE_OPTION.key;
        }
        if (messageDM instanceof AdminActionCardMessageDM) {
            return MessageViewType.ACTION_CARD_MESSAGE.key;
        }
        if (messageDM instanceof UserSmartIntentMessageDM) {
            return MessageViewType.USER_SMART_INTENT_MESSAGE.key;
        }
        if (messageDM instanceof AdminMessageDM) {
            return MessageViewType.ADMIN_TEXT_MESSAGE.key;
        }
        if (messageDM instanceof UserMessageDM) {
            return MessageViewType.USER_TEXT_MESSAGE.key;
        }
        if (messageDM instanceof ScreenshotMessageDM) {
            return MessageViewType.USER_SCREENSHOT_ATTACHMENT.key;
        }
        if (messageDM instanceof UserAttachmentMessageDM) {
            return MessageViewType.USER_ATTACHMENT_GENERIC.key;
        }
        if (messageDM instanceof AdminImageAttachmentMessageDM) {
            return MessageViewType.ADMIN_ATTACHMENT_IMAGE.key;
        }
        if (messageDM instanceof AdminAttachmentMessageDM) {
            return MessageViewType.ADMIN_ATTACHMENT_GENERIC.key;
        }
        if (messageDM instanceof RequestAppReviewMessageDM) {
            return MessageViewType.REQUESTED_APP_REVIEW.key;
        }
        if (messageDM instanceof ConfirmationRejectedMessageDM) {
            return MessageViewType.CONFIRMATION_REJECTED.key;
        }
        if (messageDM instanceof RequestScreenshotMessageDM) {
            return MessageViewType.ADMIN_REQUEST_ATTACHMENT.key;
        }
        if (messageDM instanceof RequestForReopenMessageDM) {
            return MessageViewType.REQUEST_FOR_REOPEN.key;
        }
        if (messageDM instanceof SystemDateMessageDM) {
            return MessageViewType.SYSTEM_DATE.key;
        }
        if (messageDM instanceof SystemDividerMessageDM) {
            return MessageViewType.SYSTEM_DIVIDER.key;
        }
        if (messageDM instanceof SystemPublishIdMessageDM) {
            return MessageViewType.SYSTEM_PUBLISH_ID.key;
        }
        if (messageDM instanceof SystemRedactedConversationMessageDM) {
            return MessageViewType.SYSTEM_CONVERSATION_REDACTED_MESSAGE.key;
        }
        return -1;
    }

    public MessageViewDataBinder viewTypeToDataBinder(int i) {
        MessageViewDataBinder messageViewDataBinder = this.viewTypeToDataBinderMap.get(i);
        if (messageViewDataBinder != null) {
            return messageViewDataBinder;
        }
        MessageViewType messageViewType = MessageViewType.getEnum(i);
        if (messageViewType == null) {
            return new AdminMessageViewDataBinder(this.context);
        }
        switch (messageViewType) {
            case ADMIN_TEXT_MESSAGE:
                this.viewTypeToDataBinderMap.put(MessageViewType.ADMIN_TEXT_MESSAGE.key, new AdminMessageViewDataBinder(this.context));
                break;
            case USER_TEXT_MESSAGE:
                this.viewTypeToDataBinderMap.put(MessageViewType.USER_TEXT_MESSAGE.key, new UserMessageViewDataBinder(this.context));
                break;
            case USER_SCREENSHOT_ATTACHMENT:
                this.viewTypeToDataBinderMap.put(MessageViewType.USER_SCREENSHOT_ATTACHMENT.key, new ScreenshotMessageViewDataBinder(this.context));
                break;
            case ADMIN_ATTACHMENT_IMAGE:
                this.viewTypeToDataBinderMap.put(MessageViewType.ADMIN_ATTACHMENT_IMAGE.key, new AdminImageAttachmentMessageDataBinder(this.context));
                break;
            case ADMIN_ATTACHMENT_GENERIC:
                this.viewTypeToDataBinderMap.put(MessageViewType.ADMIN_ATTACHMENT_GENERIC.key, new AdminAttachmentMessageDataBinder(this.context));
                break;
            case REQUESTED_APP_REVIEW:
                this.viewTypeToDataBinderMap.put(MessageViewType.REQUESTED_APP_REVIEW.key, new RequestAppReviewMessageDataBinder(this.context));
                break;
            case CONFIRMATION_REJECTED:
                this.viewTypeToDataBinderMap.put(MessageViewType.CONFIRMATION_REJECTED.key, new ConfirmationRejectedMessageDataBinder(this.context));
                break;
            case ADMIN_REQUEST_ATTACHMENT:
                this.viewTypeToDataBinderMap.put(MessageViewType.ADMIN_REQUEST_ATTACHMENT.key, new RequestScreenshotMessageDataBinder(this.context));
                break;
            case REQUEST_FOR_REOPEN:
                this.viewTypeToDataBinderMap.put(MessageViewType.REQUEST_FOR_REOPEN.key, new AdminMessageViewDataBinder(this.context));
                break;
            case ADMIN_SUGGESTIONS_LIST:
                this.viewTypeToDataBinderMap.put(MessageViewType.ADMIN_SUGGESTIONS_LIST.key, new AdminSuggestionsMessageViewDataBinder(this.context));
                break;
            case USER_SELECTABLE_OPTION:
                this.viewTypeToDataBinderMap.put(MessageViewType.USER_SELECTABLE_OPTION.key, new UserSelectableOptionViewDataBinder(this.context));
                break;
            case SYSTEM_DATE:
                this.viewTypeToDataBinderMap.put(MessageViewType.SYSTEM_DATE.key, new SystemDateMessageDataBinder(this.context));
                break;
            case SYSTEM_DIVIDER:
                this.viewTypeToDataBinderMap.put(MessageViewType.SYSTEM_DIVIDER.key, new SystemDividerMessageDataBinder(this.context));
                break;
            case SYSTEM_PUBLISH_ID:
                this.viewTypeToDataBinderMap.put(MessageViewType.SYSTEM_PUBLISH_ID.key, new SystemPublishIdMessageDataBinder(this.context));
                break;
            case ADMIN_REDACTED_MESSAGE:
                this.viewTypeToDataBinderMap.put(MessageViewType.ADMIN_REDACTED_MESSAGE.key, new AdminRedactedMessageDataBinder(this.context));
                break;
            case USER_REDACTED_MESSAGE:
                this.viewTypeToDataBinderMap.put(MessageViewType.USER_REDACTED_MESSAGE.key, new UserRedactedMessageDataBinder(this.context));
                break;
            case SYSTEM_CONVERSATION_REDACTED_MESSAGE:
                this.viewTypeToDataBinderMap.put(MessageViewType.SYSTEM_CONVERSATION_REDACTED_MESSAGE.key, new SystemRedactedConversationDataBinder(this.context));
                break;
            case USER_ATTACHMENT_GENERIC:
                this.viewTypeToDataBinderMap.put(MessageViewType.USER_ATTACHMENT_GENERIC.key, new UserAttachmentMessageViewDataBinder(this.context));
                break;
            case ACTION_CARD_MESSAGE:
                this.viewTypeToDataBinderMap.put(MessageViewType.ACTION_CARD_MESSAGE.key, new AdminActionCardMessageViewDataBinder(this.context));
                break;
            case USER_SMART_INTENT_MESSAGE:
                this.viewTypeToDataBinderMap.put(MessageViewType.USER_SMART_INTENT_MESSAGE.key, new UserSmartIntentMessageViewDataBinder(this.context));
                break;
        }
        return this.viewTypeToDataBinderMap.get(i);
    }

    public ConversationFooterViewBinder getConversationFooterViewBinder() {
        return this.conversationFooterViewBinder;
    }

    public AgentTypingMessageDataBinder getAgentTypingMessageDataBinder() {
        return this.agentTypingMessageDataBinder;
    }

    public HistoryLoadingViewBinder getHistoryLoadingViewBinder() {
        return this.historyLoadingViewBinder;
    }
}
