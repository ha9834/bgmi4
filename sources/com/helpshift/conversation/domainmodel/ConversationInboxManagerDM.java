package com.helpshift.conversation.domainmodel;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.account.domainmodel.UserManagerDM;
import com.helpshift.common.HSBlockReason;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.Platform;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ConversationInboxManagerDM {
    public static final String TAG = "ConvInboxManagerDM";
    private Map<Long, ConversationController> activeUserAndInboxMapping = new HashMap();
    private final Domain domain;
    private final Platform platform;
    private final UserManagerDM userManagerDM;

    public ConversationInboxManagerDM(Platform platform, Domain domain, UserManagerDM userManagerDM) {
        this.platform = platform;
        this.domain = domain;
        this.userManagerDM = userManagerDM;
    }

    private ConversationController buildConversationInboxDM(UserDM userDM) {
        return new ConversationController(this.platform, this.domain, userDM);
    }

    public synchronized ConversationController getActiveConversationInboxDM() {
        ConversationController conversationController;
        conversationController = null;
        try {
            UserDM activeUser = this.userManagerDM.getActiveUser();
            ConversationController conversationController2 = this.activeUserAndInboxMapping.get(activeUser.getLocalId());
            if (conversationController2 == null) {
                try {
                    conversationController = buildConversationInboxDM(activeUser);
                    conversationController.initialize();
                    this.activeUserAndInboxMapping.clear();
                    this.activeUserAndInboxMapping.put(activeUser.getLocalId(), conversationController);
                } catch (Exception e) {
                    e = e;
                    conversationController = conversationController2;
                    HSLogger.e(TAG, "Exception while setting up active conversation controller", e);
                    this.domain.blockPublicAPI(HSBlockReason.FETCH_ACTIVE_USER_ERROR);
                    return conversationController;
                }
            } else {
                conversationController = conversationController2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        return conversationController;
    }

    public synchronized ConversationController getConversationInboxDM(UserDM userDM) {
        if (userDM == null) {
            return null;
        }
        ConversationController conversationController = this.activeUserAndInboxMapping.get(userDM.getLocalId());
        if (conversationController == null) {
            conversationController = buildConversationInboxDM(userDM);
        }
        return conversationController;
    }

    public synchronized void deleteConversations(UserDM userDM) {
        ConversationController conversationInboxDM = getConversationInboxDM(userDM);
        if (conversationInboxDM != null) {
            conversationInboxDM.deleteAllConversationsData();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void resetPreIssueConversations() {
        List<UserDM> allUsers = this.domain.getUserManagerDM().getAllUsers();
        if (ListUtils.isEmpty(allUsers)) {
            return;
        }
        for (UserDM userDM : allUsers) {
            ConversationController conversationInboxDM = getConversationInboxDM(userDM);
            if (conversationInboxDM != null) {
                conversationInboxDM.resetPreIssueConversationsForUser(userDM);
            }
        }
    }
}
