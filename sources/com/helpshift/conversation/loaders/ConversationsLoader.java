package com.helpshift.conversation.loaders;

import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.Platform;
import com.helpshift.conversation.activeconversation.PaginationCursor;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class ConversationsLoader {
    protected final ConversationDBLoader conversationDBLoader;
    private final long messagesPageSize;
    protected final RemoteConversationLoader remoteConversationLoader;

    /* loaded from: classes2.dex */
    public interface LoadMoreConversationsCallback {
        void loading();

        void onError();

        void onSuccess(List<Conversation> list, boolean z);
    }

    public abstract boolean hasMoreMessages();

    public ConversationsLoader(Platform platform, ConversationDBLoader conversationDBLoader, RemoteConversationLoader remoteConversationLoader, long j) {
        this.conversationDBLoader = conversationDBLoader;
        this.remoteConversationLoader = remoteConversationLoader;
        this.messagesPageSize = j;
    }

    public List<Conversation> fetchInitialConversations() {
        List<Conversation> fetchMessages = this.conversationDBLoader.fetchMessages(null, null, this.messagesPageSize);
        updateLocalCache(fetchMessages);
        return fetchMessages;
    }

    public synchronized void loadMoreConversations(PaginationCursor paginationCursor, LoadMoreConversationsCallback loadMoreConversationsCallback) {
        if (loadMoreConversationsCallback == null) {
            return;
        }
        if (paginationCursor != null) {
            if (hasMoreMessages()) {
                if (!StringUtils.isEmpty(paginationCursor.conversationCursor) && !StringUtils.isEmpty(paginationCursor.messageCursor)) {
                    loadMoreConversationsCallback.loading();
                    if (this.conversationDBLoader.hasMoreMessages()) {
                        List<Conversation> fetchMessages = this.conversationDBLoader.fetchMessages(paginationCursor.conversationCursor, paginationCursor.messageCursor, this.messagesPageSize);
                        updateLocalCache(fetchMessages);
                        if (!ListUtils.isEmpty(fetchMessages)) {
                            loadMoreConversationsCallback.onSuccess(fetchMessages, hasMoreMessages());
                            return;
                        }
                    }
                    if (!this.remoteConversationLoader.hasMoreMessage()) {
                        loadMoreConversationsCallback.onSuccess(new ArrayList(), false);
                        return;
                    }
                    try {
                        loadMoreConversationsCallback.loading();
                        if (this.remoteConversationLoader.loadMoreMessages()) {
                            this.conversationDBLoader.setHasMoreMessages(true);
                            List<Conversation> fetchMessages2 = this.conversationDBLoader.fetchMessages(paginationCursor.conversationCursor, paginationCursor.messageCursor, this.messagesPageSize);
                            updateLocalCache(fetchMessages2);
                            loadMoreConversationsCallback.onSuccess(fetchMessages2, hasMoreMessages());
                        } else {
                            loadMoreConversationsCallback.onSuccess(new ArrayList(), hasMoreMessages());
                        }
                    } catch (RootAPIException unused) {
                        loadMoreConversationsCallback.onError();
                    }
                    return;
                }
                return;
            }
        }
        loadMoreConversationsCallback.onSuccess(new ArrayList(), false);
    }

    private void updateLocalCache(List<Conversation> list) {
        if (ListUtils.isEmpty(list)) {
            this.conversationDBLoader.setHasMoreMessages(false);
        }
        Iterator<Conversation> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().messageDMs.size();
        }
        if (i == 0) {
            this.conversationDBLoader.setHasMoreMessages(false);
        }
    }
}
