package com.helpshift.conversation.activeconversation.message;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.analytics.AnalyticsEventType;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.platform.network.Response;
import com.helpshift.conversation.activeconversation.ConversationServerInfo;
import com.helpshift.util.StringUtils;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class UserMessageDM extends MessageDM {
    private UserMessageState state;

    /* JADX INFO: Access modifiers changed from: protected */
    public String getMessageTypeForRequest() {
        return "txt";
    }

    public String getReferredMessageId() {
        return "";
    }

    @Override // com.helpshift.conversation.activeconversation.message.MessageDM
    public boolean isUISupportedMessage() {
        return true;
    }

    public UserMessageDM(String str, String str2, long j, Author author) {
        super(str, str2, j, author, false, MessageType.USER_TEXT);
    }

    public UserMessageDM(String str, String str2, long j, Author author, MessageType messageType) {
        super(str, str2, j, author, false, messageType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UserMessageDM(UserMessageDM userMessageDM) {
        super(userMessageDM);
        this.state = userMessageDM.state;
    }

    protected Map<String, String> getData() throws ParseException {
        return new HashMap();
    }

    public void send(UserDM userDM, ConversationServerInfo conversationServerInfo) {
        String issueSendMessageRoute;
        if (this.state == UserMessageState.SENDING || this.state == UserMessageState.SENT || this.state == UserMessageState.UNSENT_NOT_RETRYABLE) {
            return;
        }
        setState(UserMessageState.SENDING);
        if (conversationServerInfo.isInPreIssueMode()) {
            issueSendMessageRoute = getPreIssueSendMessageRoute(conversationServerInfo);
        } else {
            issueSendMessageRoute = getIssueSendMessageRoute(conversationServerInfo);
        }
        try {
            Map<String, String> data = getData();
            data.putAll(NetworkDataRequestUtil.getUserRequestData(userDM));
            data.put("body", this.body);
            data.put("type", getMessageTypeForRequest());
            data.put("refers", getReferredMessageId());
            UserMessageDM parseResponse = parseResponse(getSendMessageNetwork(issueSendMessageRoute).makeRequest(new RequestData(data)));
            this.state = UserMessageState.SENT;
            merge(parseResponse);
            this.serverId = parseResponse.serverId;
            this.platform.getConversationDAO().insertOrUpdateMessage(this);
            this.author = parseResponse.author;
            notifyUpdated();
            HashMap hashMap = new HashMap();
            if (StringUtils.isNotEmpty(conversationServerInfo.getIssueId())) {
                hashMap.put("id", conversationServerInfo.getIssueId());
            }
            hashMap.put("type", "txt");
            if (StringUtils.isNotEmpty(conversationServerInfo.getAnalyticConversationId())) {
                hashMap.put("acid", conversationServerInfo.getAnalyticConversationId());
            }
            this.domain.getAnalyticsEventDM().pushEvent(AnalyticsEventType.MESSAGE_ADDED, hashMap);
            this.domain.getDelegate().userRepliedToConversation(this.body);
        } catch (RootAPIException e) {
            if (e.exceptionType == NetworkException.INVALID_AUTH_TOKEN || e.exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                setStateAsUnsentRetryable();
                this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(userDM, e.exceptionType);
            } else if (e.exceptionType != NetworkException.CONVERSATION_ARCHIVED && e.exceptionType != NetworkException.USER_PRE_CONDITION_FAILED) {
                setStateAsUnsentRetryable();
            }
            throw RootAPIException.wrap(e);
        } catch (ParseException e2) {
            setStateAsUnsentRetryable();
            throw RootAPIException.wrap(e2);
        }
    }

    protected UserMessageDM parseResponse(Response response) {
        return this.platform.getResponseParser().parseReadableUserMessage(response.responseString);
    }

    private void setStateAsUnsentRetryable() {
        if (StringUtils.isEmpty(this.serverId)) {
            setState(UserMessageState.UNSENT_RETRYABLE);
        }
    }

    public void updateState(boolean z) {
        if (StringUtils.isEmpty(this.serverId)) {
            if (this.state == UserMessageState.SENDING) {
                return;
            }
            if (z) {
                setState(UserMessageState.UNSENT_RETRYABLE);
                return;
            } else {
                setState(UserMessageState.UNSENT_NOT_RETRYABLE);
                return;
            }
        }
        setState(UserMessageState.SENT);
    }

    public UserMessageState getState() {
        return this.state;
    }

    public void setState(UserMessageState userMessageState) {
        UserMessageState userMessageState2 = this.state;
        this.state = userMessageState;
        if (userMessageState2 != this.state) {
            notifyUpdated();
        }
    }

    @Override // com.helpshift.conversation.activeconversation.message.MessageDM, com.helpshift.util.HSCloneable
    public UserMessageDM deepClone() {
        return new UserMessageDM(this);
    }
}
