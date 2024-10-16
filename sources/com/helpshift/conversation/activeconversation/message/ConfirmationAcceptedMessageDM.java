package com.helpshift.conversation.activeconversation.message;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.common.domain.network.AuthenticationFailureNetwork;
import com.helpshift.common.domain.network.FailedAPICallNetworkDecorator;
import com.helpshift.common.domain.network.GuardAgainstConversationArchivalNetwork;
import com.helpshift.common.domain.network.GuardAgainstConversationReOpenExpiryNetwork;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.IdempotentNetwork;
import com.helpshift.common.domain.network.Network;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.domain.network.POSTNetwork;
import com.helpshift.common.domain.network.TSCorrectedNetwork;
import com.helpshift.common.domain.network.UserPreConditionsFailedNetwork;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.network.Response;
import com.helpshift.conversation.activeconversation.ConversationServerInfo;
import com.helpshift.util.StringUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public class ConfirmationAcceptedMessageDM extends AutoRetriableMessageDM {
    @Override // com.helpshift.conversation.activeconversation.message.MessageDM
    public boolean isUISupportedMessage() {
        return false;
    }

    public ConfirmationAcceptedMessageDM(String str, String str2, long j, Author author, int i) {
        super(str, str2, j, author, false, MessageType.CONFIRMATION_ACCEPTED, i);
    }

    private ConfirmationAcceptedMessageDM(ConfirmationAcceptedMessageDM confirmationAcceptedMessageDM) {
        super(confirmationAcceptedMessageDM);
    }

    @Override // com.helpshift.conversation.activeconversation.message.AutoRetriableMessageDM, com.helpshift.conversation.activeconversation.message.MessageDM
    Network getSendMessageNetwork(String str) {
        return new GuardOKNetwork(new FailedAPICallNetworkDecorator(new GuardAgainstConversationArchivalNetwork(new GuardAgainstConversationReOpenExpiryNetwork(new UserPreConditionsFailedNetwork(new AuthenticationFailureNetwork(new TSCorrectedNetwork(new IdempotentNetwork(new POSTNetwork(str, this.domain, this.platform), this.platform, getIdempotentPolicy(), str, String.valueOf(this.localId)), this.platform))), this.platform))));
    }

    @Override // com.helpshift.conversation.activeconversation.message.AutoRetriableMessageDM
    Response makeNetworkRequest(String str, Map<String, String> map) {
        try {
            return super.makeNetworkRequest(str, map);
        } catch (RootAPIException e) {
            if (e.exceptionType == NetworkException.CONVERSATION_REOPEN_EXPIRED) {
                updateSyncStatusIntoMemoryAndDB(3);
            }
            throw e;
        }
    }

    @Override // com.helpshift.conversation.activeconversation.message.AutoRetriableMessageDM
    public void send(UserDM userDM, ConversationServerInfo conversationServerInfo) {
        if (StringUtils.isEmpty(conversationServerInfo.getIssueId())) {
            throw new UnsupportedOperationException("ConfirmationAcceptedMessageDM send called with conversation in pre issue mode.");
        }
        Map<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(userDM);
        userRequestData.put("body", this.body);
        userRequestData.put("type", "ca");
        userRequestData.put("refers", "");
        try {
            ConfirmationAcceptedMessageDM parseConfirmationAcceptedMessageDM = this.platform.getResponseParser().parseConfirmationAcceptedMessageDM(makeNetworkRequest(getIssueSendMessageRoute(conversationServerInfo), userRequestData).responseString);
            merge(parseConfirmationAcceptedMessageDM);
            this.serverId = parseConfirmationAcceptedMessageDM.serverId;
            this.author = parseConfirmationAcceptedMessageDM.author;
            this.platform.getConversationDAO().insertOrUpdateMessage(this);
        } catch (RootAPIException e) {
            if (e.exceptionType == NetworkException.INVALID_AUTH_TOKEN || e.exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(userDM, e.exceptionType);
            }
            throw e;
        }
    }

    @Override // com.helpshift.conversation.activeconversation.message.MessageDM, com.helpshift.util.HSCloneable
    public ConfirmationAcceptedMessageDM deepClone() {
        return new ConfirmationAcceptedMessageDM(this);
    }
}
