package com.helpshift.conversation.activeconversation;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.activeconversation.LiveUpdateDM;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.loaders.ConversationsLoader;
import com.helpshift.conversation.viewmodel.ConversationVMCallback;
import com.helpshift.util.HSListObserver;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public abstract class ViewableConversation implements ConversationDMListener, LiveUpdateDM.TypingIndicatorListener, ConversationsLoader.LoadMoreConversationsCallback {
    protected ConversationsLoader conversationLoader;
    protected ConversationManager conversationManager;
    private ConversationVMCallback conversationVMCallback;
    protected Domain domain;
    private AtomicBoolean isLoadMoreInProgress = new AtomicBoolean(false);
    protected LiveUpdateDM liveUpdateDM;
    protected Platform platform;
    private SDKConfigurationDM sdkConfigurationDM;
    protected UserDM userDM;

    /* loaded from: classes2.dex */
    public enum ConversationType {
        HISTORY,
        SINGLE
    }

    public abstract Conversation getActiveConversation();

    public abstract List<Conversation> getAllConversations();

    public abstract PaginationCursor getPaginationCursor();

    public abstract ConversationType getType();

    public abstract void init();

    public abstract void initializeConversationsForUI();

    public abstract void onNewConversationStarted(Conversation conversation);

    public abstract void prependConversations(List<Conversation> list);

    public abstract void registerMessagesObserver(HSListObserver<MessageDM> hSListObserver);

    public abstract boolean shouldOpen();

    public ViewableConversation(Platform platform, Domain domain, UserDM userDM, ConversationsLoader conversationsLoader, ConversationManager conversationManager) {
        this.platform = platform;
        this.domain = domain;
        this.userDM = userDM;
        this.conversationLoader = conversationsLoader;
        this.sdkConfigurationDM = domain.getSDKConfigurationDM();
        this.conversationManager = conversationManager;
    }

    public void setLiveUpdateDM(LiveUpdateDM liveUpdateDM) {
        this.liveUpdateDM = liveUpdateDM;
    }

    public boolean isVisibleOnUI() {
        ConversationVMCallback conversationVMCallback = this.conversationVMCallback;
        return conversationVMCallback != null && conversationVMCallback.isVisibleOnUI();
    }

    public boolean isConversationVMAttached() {
        return this.conversationVMCallback != null;
    }

    public void onScreenshotMessageClicked(ScreenshotMessageDM screenshotMessageDM) {
        screenshotMessageDM.handleClick(this.conversationVMCallback);
    }

    public void onUserAttachmentMessageClicked(UserAttachmentMessageDM userAttachmentMessageDM) {
        userAttachmentMessageDM.handleClick(this.conversationVMCallback);
    }

    public void onActionCardMessageClicked(AdminActionCardMessageDM adminActionCardMessageDM) {
        adminActionCardMessageDM.handleClick(getConversationForLocalId(adminActionCardMessageDM.conversationLocalId.longValue()));
    }

    public void onAdminAttachmentMessageClicked(AttachmentMessageDM attachmentMessageDM) {
        switch (attachmentMessageDM.messageType) {
            case ADMIN_IMAGE_ATTACHMENT:
                ((AdminImageAttachmentMessageDM) attachmentMessageDM).handleClick(this.conversationVMCallback);
                return;
            case ADMIN_ATTACHMENT:
                ((AdminAttachmentMessageDM) attachmentMessageDM).handleClick(this.conversationVMCallback);
                return;
            default:
                return;
        }
    }

    public void dispatchPollSuccessCallback() {
        ConversationVMCallback conversationVMCallback = this.conversationVMCallback;
        if (conversationVMCallback != null) {
            conversationVMCallback.onConversationInboxPollSuccess();
        }
    }

    public void dispatchPollFailureCallback() {
        ConversationVMCallback conversationVMCallback = this.conversationVMCallback;
        if (conversationVMCallback != null) {
            conversationVMCallback.onConversationInboxPollFailure();
        }
    }

    public boolean isActiveConversationEqual(Conversation conversation) {
        Conversation activeConversation;
        if (conversation == null || (activeConversation = getActiveConversation()) == null) {
            return false;
        }
        if (activeConversation == conversation) {
            return true;
        }
        if (!StringUtils.isEmpty(activeConversation.serverId)) {
            return activeConversation.serverId.equals(conversation.serverId);
        }
        if (StringUtils.isEmpty(activeConversation.preConversationServerId)) {
            return false;
        }
        return activeConversation.preConversationServerId.equals(conversation.preConversationServerId);
    }

    public void handleIdempotentPreIssueCreationSuccess() {
        if (this.conversationVMCallback != null) {
            init();
            this.conversationVMCallback.handleIdempotentPreIssueCreationSuccess();
        }
    }

    @Override // com.helpshift.conversation.activeconversation.ConversationDMListener
    public void onIssueStatusChange(IssueState issueState) {
        ConversationVMCallback conversationVMCallback = this.conversationVMCallback;
        if (conversationVMCallback != null) {
            conversationVMCallback.onIssueStatusChange(issueState);
        }
    }

    public void startLiveUpdates() {
        Conversation activeConversation = getActiveConversation();
        if (this.liveUpdateDM == null || activeConversation.isInPreIssueMode() || !this.sdkConfigurationDM.shouldEnableTypingIndicator()) {
            return;
        }
        this.liveUpdateDM.registerListener(this, activeConversation.serverId);
    }

    public void stopLiveUpdates() {
        LiveUpdateDM liveUpdateDM = this.liveUpdateDM;
        if (liveUpdateDM != null) {
            liveUpdateDM.unregisterListener();
        }
    }

    public boolean isAgentTyping() {
        LiveUpdateDM liveUpdateDM = this.liveUpdateDM;
        return liveUpdateDM != null && liveUpdateDM.isAgentTyping() && this.sdkConfigurationDM.shouldEnableTypingIndicator();
    }

    @Override // com.helpshift.conversation.activeconversation.LiveUpdateDM.TypingIndicatorListener
    public void onAgentTypingUpdate(boolean z) {
        ConversationVMCallback conversationVMCallback = this.conversationVMCallback;
        if (conversationVMCallback != null) {
            conversationVMCallback.onAgentTypingUpdate(z);
        }
    }

    public ConversationVMCallback getConversationVMCallback() {
        return this.conversationVMCallback;
    }

    public void setConversationVMCallback(ConversationVMCallback conversationVMCallback) {
        this.conversationVMCallback = conversationVMCallback;
        getActiveConversation().setListener(this);
    }

    public void unregisterConversationVMCallback() {
        this.conversationVMCallback = null;
        getActiveConversation().setListener(null);
    }

    public boolean hasMoreMessages() {
        return this.conversationLoader.hasMoreMessages();
    }

    public List<UIConversation> getUIConversations() {
        List<Conversation> allConversations = getAllConversations();
        ArrayList arrayList = new ArrayList();
        if (ListUtils.isEmpty(allConversations)) {
            return arrayList;
        }
        int size = allConversations.size();
        for (int i = 0; i < size; i++) {
            Conversation conversation = allConversations.get(i);
            arrayList.add(new UIConversation(conversation.localId.longValue(), i, conversation.getCreatedAt(), conversation.getEpochCreatedAtTime(), conversation.publishId, conversation.isInPreIssueMode(), conversation.state, conversation.isRedacted));
        }
        return arrayList;
    }

    public void loadMoreMessages() {
        if (this.isLoadMoreInProgress.compareAndSet(false, true)) {
            this.conversationLoader.loadMoreConversations(getPaginationCursor(), this);
        }
    }

    @Override // com.helpshift.conversation.loaders.ConversationsLoader.LoadMoreConversationsCallback
    public void onSuccess(List<Conversation> list, boolean z) {
        ConversationVMCallback conversationVMCallback = this.conversationVMCallback;
        if (conversationVMCallback != null) {
            conversationVMCallback.onHistoryLoadingSuccess();
        }
        if (ListUtils.isEmpty(list)) {
            this.isLoadMoreInProgress.set(false);
            ConversationVMCallback conversationVMCallback2 = this.conversationVMCallback;
            if (conversationVMCallback2 != null) {
                conversationVMCallback2.prependConversations(new ArrayList(), z);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Conversation conversation : list) {
            conversation.userLocalId = this.userDM.getLocalId().longValue();
            this.conversationManager.initializeMessageListForUI(conversation, conversation.messageDMs, isActiveConversationEqual(conversation) && this.conversationManager.shouldEnableMessagesClick(getActiveConversation()));
            arrayList.add(conversation);
        }
        prependConversations(arrayList);
        ConversationVMCallback conversationVMCallback3 = this.conversationVMCallback;
        if (conversationVMCallback3 != null) {
            conversationVMCallback3.prependConversations(arrayList, z);
        }
        this.isLoadMoreInProgress.set(false);
    }

    @Override // com.helpshift.conversation.loaders.ConversationsLoader.LoadMoreConversationsCallback
    public void onError() {
        this.isLoadMoreInProgress.set(false);
        ConversationVMCallback conversationVMCallback = this.conversationVMCallback;
        if (conversationVMCallback != null) {
            conversationVMCallback.onHistoryLoadingError();
        }
    }

    @Override // com.helpshift.conversation.loaders.ConversationsLoader.LoadMoreConversationsCallback
    public void loading() {
        this.isLoadMoreInProgress.set(false);
        ConversationVMCallback conversationVMCallback = this.conversationVMCallback;
        if (conversationVMCallback != null) {
            conversationVMCallback.onHistoryLoadingStarted();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PaginationCursor buildPaginationCursor(Conversation conversation) {
        if (conversation == null) {
            return null;
        }
        String createdAt = conversation.getCreatedAt();
        return new PaginationCursor(createdAt, ListUtils.isEmpty(conversation.messageDMs) ? createdAt : conversation.messageDMs.get(0).getCreatedAt());
    }

    private Conversation getConversationForLocalId(long j) {
        for (Conversation conversation : getAllConversations()) {
            if (conversation.localId.equals(Long.valueOf(j))) {
                return conversation;
            }
        }
        return null;
    }
}
