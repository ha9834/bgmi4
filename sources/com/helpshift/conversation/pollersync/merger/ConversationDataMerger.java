package com.helpshift.conversation.pollersync.merger;

import com.helpshift.common.platform.Platform;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.IssueType;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.states.ConversationCSATState;
import com.helpshift.util.HSLogger;
import com.helpshift.util.StringUtils;

/* loaded from: classes2.dex */
public class ConversationDataMerger {
    private static final String TAG = "HS_PollConvDataMerger";
    private Platform platform;
    private SDKConfigurationDM sdkConfigurationDM;

    public ConversationDataMerger(Platform platform, SDKConfigurationDM sDKConfigurationDM) {
        this.platform = platform;
        this.sdkConfigurationDM = sDKConfigurationDM;
    }

    public void mergeProperties(Conversation conversation, Conversation conversation2) {
        if (canMergeConversationProperties(conversation.issueType, conversation2.issueType)) {
            mergeCommonConversationProperties(conversation, conversation2);
            if (conversation2.isInPreIssueMode()) {
                return;
            }
            mergeIssueUniqueProperties(conversation, conversation2);
        }
    }

    private boolean canMergeConversationProperties(String str, String str2) {
        if (!IssueType.ISSUE.equals(str) || !IssueType.PRE_ISSUE.equals(str2)) {
            return true;
        }
        HSLogger.d(TAG, "Not merging conversation data since remote type is preissue and local type is issue");
        return false;
    }

    private void mergeCommonConversationProperties(Conversation conversation, Conversation conversation2) {
        HSLogger.d(TAG, "Merging conversation properties");
        conversation.preConversationServerId = conversation2.preConversationServerId;
        conversation.serverId = conversation2.serverId;
        conversation.issueType = conversation2.issueType;
        conversation.title = conversation2.title;
        conversation.publishId = conversation2.publishId;
        conversation.createdAt = conversation2.createdAt;
        conversation.epochCreatedAtTime = conversation2.getEpochCreatedAtTime();
        conversation.updatedAt = conversation2.updatedAt;
        conversation.shouldIncrementMessageCount = conversation2.shouldIncrementMessageCount;
        if (conversation2.messageCursor != null) {
            conversation.messageCursor = conversation2.messageCursor;
        }
        if (!StringUtils.isEmpty(conversation2.createdRequestId)) {
            conversation.createdRequestId = conversation2.createdRequestId;
        }
        conversation.state = getStateToUpdateForConversation(conversation.state, conversation2.state, conversation2.issueType, ConversationUtil.isResolutionQuestionExpired(this.platform, conversation2));
    }

    private void mergeIssueUniqueProperties(Conversation conversation, Conversation conversation2) {
        conversation.isRedacted = conversation2.isRedacted;
        conversation.resolutionExpiryAt = conversation2.resolutionExpiryAt;
        conversation.csatExpiryAt = conversation2.csatExpiryAt;
        if (conversation2.csatState == ConversationCSATState.SUBMITTED_SYNCED) {
            conversation.csatState = conversation2.csatState;
        } else if (ConversationUtil.isCSATTimerExpired(this.platform, conversation)) {
            conversation.csatState = ConversationCSATState.EXPIRED;
        }
    }

    private IssueState getStateToUpdateForConversation(IssueState issueState, IssueState issueState2, String str, boolean z) {
        if (issueState2 == IssueState.RESOLUTION_REQUESTED) {
            if (IssueType.PRE_ISSUE.equals(str)) {
                issueState2 = IssueState.RESOLUTION_ACCEPTED;
            } else {
                if (issueState != IssueState.RESOLUTION_ACCEPTED && issueState != IssueState.RESOLUTION_EXPIRED) {
                    if (z) {
                        issueState2 = IssueState.RESOLUTION_EXPIRED;
                    } else if (issueState != IssueState.RESOLUTION_REJECTED) {
                        if (!this.sdkConfigurationDM.shouldShowConversationResolutionQuestion()) {
                            issueState2 = IssueState.RESOLUTION_ACCEPTED;
                        }
                    }
                }
                issueState2 = issueState;
            }
        }
        HSLogger.d(TAG, "Updating conversation state from " + issueState + " to: " + issueState2);
        return issueState2;
    }
}
