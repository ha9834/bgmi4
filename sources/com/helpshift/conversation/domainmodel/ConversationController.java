package com.helpshift.conversation.domainmodel;

import com.facebook.appevents.UserDataStore;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.helpshift.account.domainmodel.IUserSyncExecutor;
import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.account.domainmodel.UserSyncStatus;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.common.AutoRetriableDM;
import com.helpshift.common.AutoRetryFailedEventDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.domain.F;
import com.helpshift.common.domain.One;
import com.helpshift.common.domain.Poller;
import com.helpshift.common.domain.idempotent.PollerSyncDataProvider;
import com.helpshift.common.domain.idempotent.SuccessOrNonRetriableStatusCodeIdempotentPolicy;
import com.helpshift.common.domain.network.AuthenticationFailureNetwork;
import com.helpshift.common.domain.network.FailedAPICallNetworkDecorator;
import com.helpshift.common.domain.network.GuardOKNetwork;
import com.helpshift.common.domain.network.IdempotentNetwork;
import com.helpshift.common.domain.network.MetaCorrectedNetwork;
import com.helpshift.common.domain.network.Network;
import com.helpshift.common.domain.network.NetworkDataRequestUtil;
import com.helpshift.common.domain.network.POSTNetwork;
import com.helpshift.common.domain.network.PUTNetwork;
import com.helpshift.common.domain.network.TSCorrectedNetwork;
import com.helpshift.common.exception.NetworkException;
import com.helpshift.common.exception.PollerException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.KVStore;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.RequestData;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.conversation.ConversationInboxPoller;
import com.helpshift.conversation.ConversationUtil;
import com.helpshift.conversation.CreatePreIssueDM;
import com.helpshift.conversation.IssueType;
import com.helpshift.conversation.activeconversation.ConversationManager;
import com.helpshift.conversation.activeconversation.LiveUpdateDM;
import com.helpshift.conversation.activeconversation.ViewableConversation;
import com.helpshift.conversation.activeconversation.ViewableConversationHistory;
import com.helpshift.conversation.activeconversation.ViewableSingleConversation;
import com.helpshift.conversation.activeconversation.message.AdminMessageDM;
import com.helpshift.conversation.activeconversation.message.Author;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageDM;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dao.ConversationDAO;
import com.helpshift.conversation.dao.ConversationInboxDAO;
import com.helpshift.conversation.dao.PushNotificationData;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.dto.ConversationDetailDTO;
import com.helpshift.conversation.dto.ConversationInbox;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.loaders.ConversationHistoryLoader;
import com.helpshift.conversation.loaders.RemoteConversationLoader;
import com.helpshift.conversation.loaders.SingleConversationLoader;
import com.helpshift.conversation.pollersync.PollerSyncManager;
import com.helpshift.conversation.pollersync.exception.PollerSyncException;
import com.helpshift.conversation.states.ConversationCSATState;
import com.helpshift.conversation.util.predicate.ConversationPredicates;
import com.helpshift.conversation.viewmodel.ConversationVMCallback;
import com.helpshift.faq.domainmodel.FAQSearchDM;
import com.helpshift.providers.ICampaignsModuleAPIs;
import com.helpshift.util.FetchDataFromThread;
import com.helpshift.util.Filters;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import com.helpshift.util.ValuePair;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public class ConversationController implements IUserSyncExecutor, AutoRetriableDM {
    private static final long ACTIVE_ISSUE_NOTIFICATION_COUNT_TIMEOUT = 60000;
    public static final String CREATE_ISSUE_ROUTE = "/issues/";
    public static final String CREATE_ISSUE_UNIQUE_MAPPING_KEY = "issue_default_unique_key";
    public static final String CREATE_PRE_ISSUE_ROUTE = "/preissues/";
    public static final String CREATE_PRE_ISSUE_UNIQUE_MAPPING_KEY = "preissue_default_unique_key";
    private static final long INACTIVE_ISSUES_NOTIFICATION_COUNT_TIMEOUT = 300000;
    private static final String LAST_NOTIFCOUNT_FETCH_KEY = "lastNotifCountFetchTime";
    private static final int MAX_POLL_SYNC_EXCEPTION_COUNT = 10;
    public static final long MESSAGES_PAGE_SIZE = 100;
    private static final String TAG = "Helpshift_ConvInboxDM";
    static final Object fetchConversationUpdatesLock = new Object();
    private WeakReference<ViewableConversation> aliveViewableConversation;
    final ConversationDAO conversationDAO;
    private final ConversationInboxDAO conversationInboxDAO;
    private final ConversationInboxPoller conversationInboxPoller;
    public final ConversationManager conversationManager;
    final Domain domain;
    private final FAQSearchDM faqSearchDM;
    private boolean isCreateConversationInProgress;
    private final KVStore kvStore;
    private final LiveUpdateDM liveUpdateDM;
    final Platform platform;
    private int pollSyncExceptionCount;
    private PollerSyncManager pollerSyncManager;
    private RemoteConversationLoader remoteConversationLoader;
    private final SDKConfigurationDM sdkConfigurationDM;
    private boolean shouldDropCustomMetadata;
    private WeakReference<StartNewConversationListener> startNewConversationListenerRef;
    private boolean userCanReadMessages;
    final UserDM userDM;
    public AtomicReference<FetchDataFromThread<Integer, Integer>> fetchConversationUpdatesListenerReference = null;
    HashMap<Long, One> inProgressPreIssueCreators = new HashMap<>();
    private int conversationViewState = -1;
    private Map<String, Integer> inAppNotificationMessageCountMap = new ConcurrentHashMap();

    /* loaded from: classes2.dex */
    public interface StartNewConversationListener {
        void onCreateConversationFailure(Exception exc);

        void onCreateConversationSuccess(long j);
    }

    public ConversationController(Platform platform, Domain domain, UserDM userDM) {
        this.platform = platform;
        this.domain = domain;
        this.userDM = userDM;
        this.conversationInboxDAO = platform.getConversationInboxDAO();
        this.conversationDAO = platform.getConversationDAO();
        this.kvStore = platform.getKVStore();
        this.faqSearchDM = platform.getFAQSearchDM();
        this.sdkConfigurationDM = domain.getSDKConfigurationDM();
        this.conversationInboxPoller = new ConversationInboxPoller(userDM, this.sdkConfigurationDM, getPoller(), this.conversationDAO);
        this.liveUpdateDM = new LiveUpdateDM(domain, platform);
        this.conversationManager = new ConversationManager(platform, domain, userDM);
        this.remoteConversationLoader = new RemoteConversationLoader(platform, domain, userDM, this.conversationManager);
        this.pollerSyncManager = new PollerSyncManager(domain, platform, userDM, new PollerSyncDataProviderImpl(), this.conversationManager);
    }

    public ConversationManager getConversationManager() {
        return this.conversationManager;
    }

    public void initialize() {
        this.domain.getAutoRetryFailedEventDM().register(AutoRetryFailedEventDM.EventType.CONVERSATION, this);
        if (this.userDM.getSyncState() == UserSyncStatus.COMPLETED) {
            this.userDM.addObserver(getConversationInboxPoller());
        }
    }

    public ConversationInboxPoller getConversationInboxPoller() {
        return this.conversationInboxPoller;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deleteAllConversationsData() {
        deleteConversationsAndMessages();
        this.conversationInboxDAO.deleteUserData(this.userDM.getLocalId().longValue());
    }

    private void deleteConversationsAndMessages() {
        long longValue = this.userDM.getLocalId().longValue();
        for (Conversation conversation : this.conversationDAO.readConversationsWithoutMessages(longValue).getData()) {
            conversation.userLocalId = this.userDM.getLocalId().longValue();
            this.conversationManager.deleteCachedAttachmentFiles(conversation);
        }
        this.conversationDAO.deleteConversations(longValue);
    }

    private Poller getPoller() {
        return new Poller(this.domain, new F() { // from class: com.helpshift.conversation.domainmodel.ConversationController.1
            @Override // com.helpshift.common.domain.F
            public synchronized void f() {
                ConversationController.this.fetchConversationUpdates();
            }
        });
    }

    @Override // com.helpshift.common.AutoRetriableDM
    public void sendFailedApiCalls(AutoRetryFailedEventDM.EventType eventType) {
        for (Conversation conversation : this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData()) {
            ViewableConversation aliveViewableConversation = getAliveViewableConversation(conversation.localId);
            if (aliveViewableConversation != null) {
                retryCallsForConversation(aliveViewableConversation.getActiveConversation(), true);
            } else {
                retryCallsForConversation(conversation, false);
            }
        }
    }

    private void retryCallsForConversation(Conversation conversation, boolean z) {
        conversation.userLocalId = this.userDM.getLocalId().longValue();
        if (this.conversationManager.canAutoRetryMessages(conversation)) {
            this.conversationManager.retryMessages(conversation, z);
        }
        if (conversation.csatState == ConversationCSATState.SUBMITTED_NOT_SYNCED) {
            try {
                this.conversationManager.sendCSATSurveyInternal(conversation);
            } catch (RootAPIException e) {
                if (e.exceptionType != NetworkException.NON_RETRIABLE) {
                    throw e;
                }
            }
        }
    }

    public void setUserCanReadMessages(boolean z) {
        this.userCanReadMessages = z;
    }

    public ConversationDetailDTO getConversationDetail() {
        return this.conversationInboxDAO.getDescriptionDetail(this.userDM.getLocalId().longValue());
    }

    public String getConversationArchivalPrefillText() {
        return this.conversationInboxDAO.getConversationArchivalPrefillText(this.userDM.getLocalId().longValue());
    }

    public void saveDescriptionDetail(String str, int i) {
        this.conversationInboxDAO.saveDescriptionDetail(this.userDM.getLocalId().longValue(), new ConversationDetailDTO(str, System.nanoTime(), i));
    }

    public void saveName(String str) {
        this.conversationInboxDAO.saveName(this.userDM.getLocalId().longValue(), str);
    }

    public void saveEmail(String str) {
        this.conversationInboxDAO.saveEmail(this.userDM.getLocalId().longValue(), str);
    }

    public String getName() {
        String name = this.conversationInboxDAO.getName(this.userDM.getLocalId().longValue());
        return StringUtils.isEmpty(name) ? this.userDM.getName() : name;
    }

    public String getEmail() {
        String email = this.conversationInboxDAO.getEmail(this.userDM.getLocalId().longValue());
        return StringUtils.isEmpty(email) ? this.userDM.getEmail() : email;
    }

    public void saveImageAttachmentDraft(AttachmentPickerFile attachmentPickerFile) {
        this.conversationInboxDAO.saveImageAttachment(this.userDM.getLocalId().longValue(), attachmentPickerFile);
    }

    public void saveLastConversationsRedactionTime(long j) {
        this.conversationInboxDAO.saveLastConversationsRedactionTime(this.userDM.getLocalId().longValue(), j);
    }

    public Long getLastConversationsRedactionTime() {
        return this.conversationInboxDAO.getLastConversationsRedactionTime(this.userDM.getLocalId().longValue());
    }

    public AttachmentPickerFile getImageAttachmentDraft() {
        return this.conversationInboxDAO.getImageAttachment(this.userDM.getLocalId().longValue());
    }

    public void saveUserReplyText(String str) {
        this.conversationInboxDAO.saveUserReplyDraft(this.userDM.getLocalId().longValue(), str);
    }

    public String getUserReplyText() {
        return this.conversationInboxDAO.getUserReplyDraft(this.userDM.getLocalId().longValue());
    }

    public ArrayList getFAQSearchResults(String str) {
        return this.faqSearchDM.getSearchResults(str);
    }

    public void triggerFAQSearchIndexing() {
        this.faqSearchDM.startFAQSearchIndexing();
    }

    public void setShouldDropCustomMetadata(boolean z) {
        this.shouldDropCustomMetadata = z;
    }

    public void registerStartNewConversationListener(StartNewConversationListener startNewConversationListener) {
        this.startNewConversationListenerRef = new WeakReference<>(startNewConversationListener);
    }

    public void unregisterStartNewConversationListener(StartNewConversationListener startNewConversationListener) {
        WeakReference<StartNewConversationListener> weakReference = this.startNewConversationListenerRef;
        if (weakReference == null || weakReference.get() != startNewConversationListener) {
            return;
        }
        this.startNewConversationListenerRef = new WeakReference<>(null);
    }

    public void startNewConversation(String str, String str2, String str3, AttachmentPickerFile attachmentPickerFile) {
        this.domain.runParallel(new CreateConversationStateHolder(str, str2, str3, attachmentPickerFile).getStartNewConversationInternalF());
    }

    void startNewConversationInternal(String str, String str2, String str3, AttachmentPickerFile attachmentPickerFile) {
        this.isCreateConversationInProgress = true;
        Conversation tryToStartNewConversation = tryToStartNewConversation(str, str2, str3);
        ViewableSingleConversation viewableSingleConversation = new ViewableSingleConversation(this.platform, this.domain, this.userDM, new SingleConversationLoader(this.platform, this.userDM, tryToStartNewConversation.localId, this.remoteConversationLoader, 100L), this.conversationManager);
        viewableSingleConversation.init();
        viewableSingleConversation.setLiveUpdateDM(this.liveUpdateDM);
        setAliveConversation(viewableSingleConversation);
        checkAndTryToUploadImage(viewableSingleConversation.getActiveConversation(), attachmentPickerFile);
        this.isCreateConversationInProgress = false;
        WeakReference<StartNewConversationListener> weakReference = this.startNewConversationListenerRef;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.startNewConversationListenerRef.get().onCreateConversationSuccess(tryToStartNewConversation.localId.longValue());
    }

    private synchronized void setAliveConversation(ViewableConversation viewableConversation) {
        this.aliveViewableConversation = new WeakReference<>(viewableConversation);
    }

    private synchronized void removeInMemoryConversation() {
        this.aliveViewableConversation = null;
    }

    public Conversation tryToStartNewConversation(String str, String str2, String str3) {
        Conversation createConversation;
        try {
            synchronized (fetchConversationUpdatesLock) {
                createConversation = createConversation(str, str2, str3);
            }
            saveDescriptionDetail("", 0);
            if (!this.sdkConfigurationDM.shouldCreateConversationAnonymously()) {
                saveName(str2);
                saveEmail(str3);
            }
            this.conversationInboxDAO.saveConversationArchivalPrefillText(this.userDM.getLocalId().longValue(), null);
            checkAndDropCustomMeta(createConversation);
            this.conversationManager.sendConversationPostedEvent(createConversation);
            this.domain.getDelegate().newConversationStarted(str);
            return createConversation;
        } catch (Exception e) {
            this.isCreateConversationInProgress = false;
            if (this.startNewConversationListenerRef.get() != null) {
                this.startNewConversationListenerRef.get().onCreateConversationFailure(e);
            }
            throw e;
        }
    }

    public void checkAndDropCustomMeta(Conversation conversation) {
        if (this.shouldDropCustomMetadata) {
            this.conversationManager.dropCustomMetaData();
        }
    }

    private void checkAndTryToUploadImage(Conversation conversation, AttachmentPickerFile attachmentPickerFile) {
        if (attachmentPickerFile == null || attachmentPickerFile.filePath == null) {
            return;
        }
        try {
            this.conversationManager.sendAttachment(conversation, attachmentPickerFile, null);
        } catch (Exception unused) {
        }
        saveImageAttachmentDraft(null);
    }

    public Conversation createConversation(String str, String str2, String str3) {
        this.domain.getUserManagerDM().registerUserWithServer(this.userDM);
        HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(this.userDM);
        userRequestData.put("user_provided_emails", this.platform.getJsonifier().jsonify(Collections.singletonList(str3)).toString());
        userRequestData.put("user_provided_name", str2);
        userRequestData.put("body", str);
        userRequestData.put("cuid", getCampaignUID());
        userRequestData.put("cdid", getCampaignDID());
        userRequestData.put("device_language", this.domain.getLocaleProviderDM().getDefaultLanguage());
        String sDKLanguage = this.domain.getLocaleProviderDM().getSDKLanguage();
        if (!StringUtils.isEmpty(sDKLanguage)) {
            userRequestData.put("developer_set_language", sDKLanguage);
        }
        userRequestData.put("meta", this.domain.getMetaDataDM().getMetaInfo().toString());
        boolean z = this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.ENABLE_FULL_PRIVACY);
        Object customIssueFieldData = this.domain.getCustomIssueFieldDM().getCustomIssueFieldData();
        if (customIssueFieldData != null) {
            userRequestData.put("custom_fields", customIssueFieldData.toString());
        }
        try {
            Conversation parseReadableConversation = this.platform.getResponseParser().parseReadableConversation(new GuardOKNetwork(new MetaCorrectedNetwork(new TSCorrectedNetwork(new AuthenticationFailureNetwork(new IdempotentNetwork(new POSTNetwork(CREATE_ISSUE_ROUTE, this.domain, this.platform), this.platform, new SuccessOrNonRetriableStatusCodeIdempotentPolicy(), CREATE_ISSUE_ROUTE, CREATE_ISSUE_UNIQUE_MAPPING_KEY)), this.platform), this.platform)).makeRequest(new RequestData(userRequestData)).responseString);
            parseReadableConversation.wasFullPrivacyEnabledAtCreation = z;
            parseReadableConversation.userLocalId = this.userDM.getLocalId().longValue();
            if (this.conversationDAO.readConversationWithoutMessages(parseReadableConversation.serverId) == null) {
                this.conversationDAO.insertConversation(parseReadableConversation);
            }
            this.domain.getUserManagerDM().updateIssueExists(this.userDM, true);
            this.domain.getUserManagerDM().sendPushToken();
            this.conversationInboxPoller.startAppPoller(true);
            return parseReadableConversation;
        } catch (RootAPIException e) {
            if (e.exceptionType == NetworkException.INVALID_AUTH_TOKEN || e.exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(this.userDM, e.exceptionType);
            }
            throw e;
        }
    }

    public void createPreIssueViaSmartIntent(Conversation conversation, String str, String str2, List<String> list, StartNewConversationListener startNewConversationListener) {
        createPreIssue(conversation, str, str2, list, startNewConversationListener);
    }

    public void createPreIssueViaConversationalFlow(Conversation conversation, String str, String str2, StartNewConversationListener startNewConversationListener) {
        createPreIssue(conversation, str, str2, null, startNewConversationListener);
    }

    private void createPreIssue(final Conversation conversation, String str, String str2, List<String> list, StartNewConversationListener startNewConversationListener) {
        One one = this.inProgressPreIssueCreators.get(conversation.localId);
        if (one != null) {
            HSLogger.d(TAG, "Pre issue creation already in progress: " + conversation.localId);
            ((CreatePreIssueDM) one.getF()).setListener(startNewConversationListener);
            return;
        }
        final One one2 = new One(new CreatePreIssueDM(this, this.conversationManager, conversation, startNewConversationListener, str, str2, list));
        this.inProgressPreIssueCreators.put(conversation.localId, one2);
        this.domain.runParallel(new F() { // from class: com.helpshift.conversation.domainmodel.ConversationController.2
            @Override // com.helpshift.common.domain.F
            public void f() {
                try {
                    synchronized (ConversationController.fetchConversationUpdatesLock) {
                        one2.f();
                    }
                } finally {
                    ConversationController.this.inProgressPreIssueCreators.remove(conversation.localId);
                }
            }
        });
    }

    public boolean isPreissueCreationInProgress(long j) {
        return this.inProgressPreIssueCreators.containsKey(Long.valueOf(j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void createPreIssueNetwork(Conversation conversation, String str, String str2, List<String> list) {
        HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(this.userDM);
        String name = this.userDM.getName();
        String email = this.userDM.getEmail();
        if (!StringUtils.isEmpty(name)) {
            userRequestData.put("name", name);
        }
        if (!StringUtils.isEmpty(email)) {
            userRequestData.put("email", email);
        }
        userRequestData.put("cuid", getCampaignUID());
        userRequestData.put("cdid", getCampaignDID());
        userRequestData.put("device_language", this.domain.getLocaleProviderDM().getDefaultLanguage());
        String sDKLanguage = this.domain.getLocaleProviderDM().getSDKLanguage();
        if (!StringUtils.isEmpty(sDKLanguage)) {
            userRequestData.put("developer_set_language", sDKLanguage);
        }
        userRequestData.put("meta", this.domain.getMetaDataDM().getMetaInfo().toString());
        boolean z = this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.ENABLE_FULL_PRIVACY);
        Object customIssueFieldData = this.domain.getCustomIssueFieldDM().getCustomIssueFieldData();
        if (customIssueFieldData != null) {
            userRequestData.put("custom_fields", customIssueFieldData.toString());
        }
        if (StringUtils.isNotEmpty(str)) {
            userRequestData.put("greeting", str);
        }
        if (StringUtils.isNotEmpty(str2)) {
            userRequestData.put("user_message", str2);
        }
        userRequestData.put("is_prefilled", String.valueOf(conversation.isAutoFilledPreIssue));
        if (StringUtils.isNotEmpty(conversation.acid)) {
            userRequestData.put("acid", conversation.acid);
        }
        if (StringUtils.isNotEmpty(conversation.smartIntentTreeId)) {
            userRequestData.put("tree_id", conversation.smartIntentTreeId);
        }
        if (StringUtils.isNotEmpty(conversation.smartIntentUserQuery)) {
            userRequestData.put(UserDataStore.STATE, conversation.smartIntentUserQuery);
        }
        if (ListUtils.isNotEmpty(conversation.smartIntentIds)) {
            userRequestData.put(SDKConstants.PARAM_INTENT, this.platform.getJsonifier().jsonifyListToJsonArray(conversation.smartIntentIds).toString());
        }
        if (ListUtils.isNotEmpty(list)) {
            userRequestData.put("intent_labels", this.platform.getJsonifier().jsonifyListToJsonArray(list).toString());
        }
        try {
            Conversation parseReadableConversation = this.platform.getResponseParser().parseReadableConversation(new GuardOKNetwork(new MetaCorrectedNetwork(new TSCorrectedNetwork(new AuthenticationFailureNetwork(new IdempotentNetwork(new POSTNetwork(CREATE_PRE_ISSUE_ROUTE, this.domain, this.platform), this.platform, new SuccessOrNonRetriableStatusCodeIdempotentPolicy(), CREATE_PRE_ISSUE_ROUTE, CREATE_PRE_ISSUE_UNIQUE_MAPPING_KEY)), this.platform), this.platform)).makeRequest(new RequestData(userRequestData)).responseString);
            if (conversation.serverId == null) {
                conversation.serverId = parseReadableConversation.serverId;
            }
            conversation.issueType = parseReadableConversation.issueType;
            conversation.title = parseReadableConversation.title;
            conversation.setCreatedAt(parseReadableConversation.getCreatedAt());
            conversation.setEpochCreatedAtTime(parseReadableConversation.getEpochCreatedAtTime());
            conversation.updatedAt = parseReadableConversation.updatedAt;
            conversation.publishId = parseReadableConversation.publishId;
            conversation.state = parseReadableConversation.state;
            conversation.wasFullPrivacyEnabledAtCreation = z;
            conversation.userLocalId = this.userDM.getLocalId().longValue();
            conversation.acid = parseReadableConversation.acid;
            conversation.smartIntentIds = parseReadableConversation.smartIntentIds;
            this.conversationDAO.deleteMessagesForConversation(conversation.localId.longValue());
            conversation.messageDMs = parseReadableConversation.messageDMs;
            Iterator<MessageDM> it = conversation.messageDMs.iterator();
            while (it.hasNext()) {
                MessageDM next = it.next();
                next.conversationLocalId = conversation.localId;
                if (next instanceof AdminMessageDM) {
                    next.deliveryState = 1;
                } else if (next instanceof UserMessageDM) {
                    next.deliveryState = 2;
                }
            }
            conversation.preConversationServerId = parseReadableConversation.preConversationServerId;
            this.domain.getUserManagerDM().updateIssueExists(this.userDM, true);
            this.domain.getUserManagerDM().sendPushToken();
            this.conversationDAO.updateConversation(conversation);
            if (ListUtils.isNotEmpty(list)) {
                str2 = ListUtils.serializeWithDelimiter(list, ",");
            } else if (!StringUtils.isNotEmpty(str2)) {
                str2 = "";
            }
            this.domain.getDelegate().newConversationStarted(str2);
            if (IssueType.ISSUE.equals(parseReadableConversation.issueType)) {
                HSLogger.d(TAG, "Preissue creation skipped, issue created directly.");
                this.conversationManager.sendConversationPostedEvent(parseReadableConversation);
            } else {
                this.conversationManager.sendMessageAddedEventOnPreissueCreation(conversation);
            }
        } catch (RootAPIException e) {
            if (e.exceptionType == NetworkException.INVALID_AUTH_TOKEN || e.exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(this.userDM, e.exceptionType);
            }
            throw e;
        }
    }

    private String getCampaignUID() {
        ICampaignsModuleAPIs campaignModuleAPIs = this.platform.getCampaignModuleAPIs();
        if (campaignModuleAPIs == null) {
            return null;
        }
        return campaignModuleAPIs.getUserIdentifier();
    }

    private String getCampaignDID() {
        ICampaignsModuleAPIs campaignModuleAPIs = this.platform.getCampaignModuleAPIs();
        if (campaignModuleAPIs == null) {
            return null;
        }
        return campaignModuleAPIs.getDeviceIdentifier();
    }

    public boolean isCreateConversationInProgress() {
        return this.isCreateConversationInProgress;
    }

    public ConversationInbox fetchConversationUpdates() {
        ConversationInbox fetchConversationUpdatesInternal;
        synchronized (fetchConversationUpdatesLock) {
            fetchConversationUpdatesInternal = fetchConversationUpdatesInternal(this.conversationInboxDAO.getConversationInboxTimestamp(this.userDM.getLocalId().longValue()), false);
        }
        return fetchConversationUpdatesInternal;
    }

    public ConversationInbox fetchInitialConversationUpdates() {
        ConversationInbox fetchConversationUpdatesInternal;
        synchronized (fetchConversationUpdatesLock) {
            fetchConversationUpdatesInternal = fetchConversationUpdatesInternal(null, true);
        }
        return fetchConversationUpdatesInternal;
    }

    private Network buildForwardPollerNetwork() {
        return new GuardOKNetwork(new TSCorrectedNetwork(new FailedAPICallNetworkDecorator(new AuthenticationFailureNetwork(new POSTNetwork("/conversations/updates/", this.domain, this.platform))), this.platform));
    }

    private RequestData buildForwardPollerRequestData(String str) {
        HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(this.userDM);
        if (!StringUtils.isEmpty(str)) {
            userRequestData.put("cursor", str);
        }
        Conversation lastViewableSyncedConversation = getLastViewableSyncedConversation();
        if (lastViewableSyncedConversation != null) {
            if (!StringUtils.isEmpty(lastViewableSyncedConversation.serverId)) {
                userRequestData.put(AnalyticsEventKey.ISSUE_ID, lastViewableSyncedConversation.serverId);
            } else if (!StringUtils.isEmpty(lastViewableSyncedConversation.preConversationServerId)) {
                userRequestData.put(AnalyticsEventKey.PREISSUE_ID, lastViewableSyncedConversation.preConversationServerId);
            }
        }
        userRequestData.put("ucrm", String.valueOf(this.userCanReadMessages));
        return new RequestData(userRequestData);
    }

    private ConversationInbox fetchConversationUpdatesInternal(String str, boolean z) {
        ViewableConversation aliveViewableConversation;
        Network buildForwardPollerNetwork = buildForwardPollerNetwork();
        RequestData buildForwardPollerRequestData = buildForwardPollerRequestData(str);
        try {
            ConversationInbox parseConversationInbox = this.platform.getResponseParser().parseConversationInbox(buildForwardPollerNetwork.makeRequest(buildForwardPollerRequestData).responseString);
            this.domain.getUserManagerDM().updateIssueExists(this.userDM, parseConversationInbox.issueExists);
            if (!buildForwardPollerRequestData.body.containsKey("cursor") && parseConversationInbox.hasOlderMessages != null) {
                this.conversationInboxDAO.saveHasOlderMessages(this.userDM.getLocalId().longValue(), parseConversationInbox.hasOlderMessages.booleanValue());
            }
            try {
                this.pollerSyncManager.sync(parseConversationInbox.conversations, z);
                ViewableConversation aliveViewableConversation2 = getAliveViewableConversation();
                if (aliveViewableConversation2 != null) {
                    aliveViewableConversation2.dispatchPollSuccessCallback();
                }
                if (!this.userDM.isPushTokenSynced() && this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.ENABLE_IN_APP_NOTIFICATION)) {
                    checkAndGenerateNotification();
                }
                sendUnreadCountUpdate();
                this.conversationInboxDAO.saveConversationInboxTimestamp(this.userDM.getLocalId().longValue(), parseConversationInbox.cursor);
                this.pollSyncExceptionCount = 0;
            } catch (PollerSyncException e) {
                HSLogger.e(TAG, "Caught poller sync exception: " + e.getMessage() + ", Not updating cursor.");
                this.pollSyncExceptionCount = this.pollSyncExceptionCount + 1;
                if (!z && this.pollSyncExceptionCount >= 10) {
                    HSLogger.e(TAG, "Max poller sync exception limit reached, stopping poller");
                    ViewableConversation aliveViewableConversation3 = getAliveViewableConversation();
                    if (aliveViewableConversation3 != null) {
                        aliveViewableConversation3.dispatchPollFailureCallback();
                    }
                    throw RootAPIException.wrap(e, PollerException.SYNC_FAILURE_MAX_LIMIT_REACHED);
                }
            }
            return parseConversationInbox;
        } catch (RootAPIException e2) {
            if (e2.exceptionType == NetworkException.INVALID_AUTH_TOKEN || e2.exceptionType == NetworkException.AUTH_TOKEN_NOT_PROVIDED) {
                this.domain.getAuthenticationFailureDM().notifyAuthenticationFailure(this.userDM, e2.exceptionType);
            } else if ((e2.exceptionType instanceof NetworkException) && (aliveViewableConversation = getAliveViewableConversation()) != null && aliveViewableConversation.isVisibleOnUI()) {
                aliveViewableConversation.dispatchPollFailureCallback();
            }
            throw e2;
        }
    }

    /* loaded from: classes2.dex */
    private class PollerSyncDataProviderImpl implements PollerSyncDataProvider {
        private PollerSyncDataProviderImpl() {
        }

        @Override // com.helpshift.common.domain.idempotent.PollerSyncDataProvider
        public String getPendingRequestIdForPreissue() {
            return ConversationController.this.platform.getNetworkRequestDAO().getPendingRequestId(ConversationController.CREATE_PRE_ISSUE_ROUTE, ConversationController.CREATE_PRE_ISSUE_UNIQUE_MAPPING_KEY);
        }

        @Override // com.helpshift.common.domain.idempotent.PollerSyncDataProvider
        public Map<String, String> getMessagesLocalIdToPendingRequestIdMap(Conversation conversation) {
            return ConversationController.this.conversationManager.getMessagesLocalIdToPendingRequestIdMap(conversation);
        }

        @Override // com.helpshift.common.domain.idempotent.PollerSyncDataProvider
        public int getCurrentConversationViewState() {
            return ConversationController.this.conversationViewState;
        }

        @Override // com.helpshift.common.domain.idempotent.PollerSyncDataProvider
        public ViewableConversation getAliveViewableConversation() {
            return ConversationController.this.getAliveViewableConversation();
        }

        @Override // com.helpshift.common.domain.idempotent.PollerSyncDataProvider
        public Conversation getActiveConversationFromStorage() {
            return ConversationController.this.getActiveConversationFromStorage();
        }
    }

    private void sendUnreadCountUpdate() {
        final FetchDataFromThread<Integer, Integer> fetchDataFromThread;
        AtomicReference<FetchDataFromThread<Integer, Integer>> atomicReference = this.fetchConversationUpdatesListenerReference;
        if (atomicReference == null || (fetchDataFromThread = atomicReference.get()) == null) {
            return;
        }
        this.domain.runOnUI(new F() { // from class: com.helpshift.conversation.domainmodel.ConversationController.3
            @Override // com.helpshift.common.domain.F
            public void f() {
                fetchDataFromThread.onDataFetched(Integer.valueOf(ConversationController.this.getNotificationCountSync()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewableConversation getAliveViewableConversation() {
        WeakReference<ViewableConversation> weakReference = this.aliveViewableConversation;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.aliveViewableConversation.get();
    }

    private void checkAndGenerateNotification() {
        Conversation activeConversationFromUIOrStorage = getActiveConversationFromUIOrStorage();
        if (shouldShowInAppNotification(activeConversationFromUIOrStorage)) {
            activeConversationFromUIOrStorage.userLocalId = this.userDM.getLocalId().longValue();
            showInAppNotification(activeConversationFromUIOrStorage, getMessageCountForShowingInAppNotification(activeConversationFromUIOrStorage));
        }
    }

    private void showInAppNotification(Conversation conversation, int i) {
        if (i > 0) {
            showNotificationOnUI(conversation.localId, conversation.localUUID, i, this.platform.getDevice().getAppName(), true);
            updateInAppNotificationCountCache(conversation.localUUID, i);
        }
    }

    private int getInAppNotificationCountCache(String str) {
        Integer num = this.inAppNotificationMessageCountMap.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    private void updateInAppNotificationCountCache(String str, int i) {
        this.inAppNotificationMessageCountMap.put(str, Integer.valueOf(i));
    }

    private void clearInAppNotificationCountCache() {
        this.inAppNotificationMessageCountMap.clear();
    }

    private boolean shouldShowInAppNotification(Conversation conversation) {
        if (this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.ENABLE_IN_APP_NOTIFICATION)) {
            return canShowNotificationForConversation(conversation);
        }
        return false;
    }

    private int getMessageCountForShowingInAppNotification(Conversation conversation) {
        int inAppNotificationCountCache = getInAppNotificationCountCache(conversation.localUUID);
        int unSeenMessageCount = this.conversationManager.getUnSeenMessageCount(conversation);
        if (unSeenMessageCount > 0 && unSeenMessageCount != inAppNotificationCountCache) {
            return unSeenMessageCount;
        }
        return 0;
    }

    private boolean canShowNotificationForConversation(Conversation conversation) {
        Conversation activeConversation;
        if (conversation == null || this.userDM.getLocalId().longValue() != conversation.userLocalId || StringUtils.isEmpty(conversation.localUUID)) {
            return false;
        }
        ViewableConversation aliveViewableConversation = getAliveViewableConversation();
        if (aliveViewableConversation != null && aliveViewableConversation.isVisibleOnUI()) {
            return false;
        }
        if (aliveViewableConversation == null) {
            activeConversation = getActiveConversationFromStorage();
        } else {
            activeConversation = aliveViewableConversation.getActiveConversation();
        }
        if (activeConversation != null) {
            return conversation.localUUID.equals(activeConversation.localUUID);
        }
        return true;
    }

    private void showNotificationOnUI(final Long l, final String str, final int i, final String str2, final boolean z) {
        if (i > 0) {
            this.domain.runOnUI(new F() { // from class: com.helpshift.conversation.domainmodel.ConversationController.4
                @Override // com.helpshift.common.domain.F
                public void f() {
                    ConversationController.this.platform.showNotification(l, str, i, str2, z);
                }
            });
        }
    }

    public ViewableConversation getViewableConversation(boolean z, Long l) {
        ViewableConversation aliveViewableConversation;
        if (z) {
            aliveViewableConversation = getAliveViewableConversation();
            if (aliveViewableConversation != null && aliveViewableConversation.getType() == ViewableConversation.ConversationType.SINGLE) {
                removeInMemoryConversation();
                aliveViewableConversation = null;
            }
            if (aliveViewableConversation == null) {
                ViewableConversationHistory viewableConversationHistory = new ViewableConversationHistory(this.platform, this.domain, this.userDM, new ConversationHistoryLoader(this.platform, this.userDM, this.remoteConversationLoader, 100L), this.conversationManager);
                viewableConversationHistory.init();
                if (ListUtils.isEmpty(viewableConversationHistory.getAllConversations())) {
                    viewableConversationHistory.onNewConversationStarted(createLocalPreIssueConversation());
                }
                aliveViewableConversation = viewableConversationHistory;
            }
        } else {
            aliveViewableConversation = getAliveViewableConversation(l);
            if (aliveViewableConversation != null && aliveViewableConversation.getType() == ViewableConversation.ConversationType.HISTORY) {
                removeInMemoryConversation();
                aliveViewableConversation = null;
            }
            if (aliveViewableConversation == null) {
                ViewableSingleConversation viewableSingleConversation = new ViewableSingleConversation(this.platform, this.domain, this.userDM, new SingleConversationLoader(this.platform, this.userDM, l, this.remoteConversationLoader, 100L), this.conversationManager);
                viewableSingleConversation.init();
                aliveViewableConversation = viewableSingleConversation;
            }
        }
        aliveViewableConversation.setLiveUpdateDM(this.liveUpdateDM);
        setAliveConversation(aliveViewableConversation);
        return aliveViewableConversation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewableConversation getAliveViewableConversation(Long l) {
        WeakReference<ViewableConversation> weakReference = this.aliveViewableConversation;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        ViewableConversation viewableConversation = this.aliveViewableConversation.get();
        if (l.equals(viewableConversation.getActiveConversation().localId)) {
            return viewableConversation;
        }
        return null;
    }

    public boolean shouldOpenConversationFromNotification(long j) {
        Conversation readConversationWithoutMessages;
        ViewableConversation aliveViewableConversation = getAliveViewableConversation(Long.valueOf(j));
        if ((aliveViewableConversation != null && aliveViewableConversation.getActiveConversation() != null) || (readConversationWithoutMessages = this.conversationDAO.readConversationWithoutMessages(Long.valueOf(j))) == null) {
            return aliveViewableConversation != null && aliveViewableConversation.shouldOpen();
        }
        readConversationWithoutMessages.userLocalId = this.userDM.getLocalId().longValue();
        return this.conversationManager.shouldOpen(readConversationWithoutMessages);
    }

    public Conversation getActiveConversationOrPreIssue() {
        Conversation activeConversationFromStorage = getActiveConversationFromStorage();
        return (activeConversationFromStorage == null && this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.CONVERSATIONAL_ISSUE_FILING)) ? createLocalPreIssueConversation() : activeConversationFromStorage;
    }

    public Conversation getActiveConversationFromStorage() {
        if (!this.sdkConfigurationDM.getBoolean(SDKConfigurationDM.DISABLE_IN_APP_CONVERSATION)) {
            List<Conversation> data = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData();
            ArrayList arrayList = new ArrayList();
            for (Conversation conversation : data) {
                conversation.userLocalId = this.userDM.getLocalId().longValue();
                if (this.conversationManager.shouldOpen(conversation)) {
                    arrayList.add(conversation);
                }
            }
            if (arrayList.size() > 0) {
                return ConversationUtil.getLastConversationBasedOnCreatedAt(arrayList);
            }
        }
        return null;
    }

    public Conversation getOpenConversationWithMessages() {
        List<Conversation> data = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData();
        ArrayList arrayList = new ArrayList();
        if (data.isEmpty()) {
            return null;
        }
        for (Conversation conversation : data) {
            conversation.userLocalId = this.userDM.getLocalId().longValue();
            if (conversation.isIssueInProgress()) {
                arrayList.add(conversation);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Conversation lastConversationBasedOnCreatedAt = ConversationUtil.getLastConversationBasedOnCreatedAt(arrayList);
        lastConversationBasedOnCreatedAt.setMessageDMs(this.conversationDAO.readMessages(lastConversationBasedOnCreatedAt.localId.longValue()).getData());
        return lastConversationBasedOnCreatedAt;
    }

    public Conversation createLocalPreIssueConversation() {
        ValuePair<String, Long> currentAdjustedTimeForStorage = HSDateFormatSpec.getCurrentAdjustedTimeForStorage(this.platform);
        String str = currentAdjustedTimeForStorage.first;
        long longValue = currentAdjustedTimeForStorage.second.longValue();
        Conversation conversation = new Conversation("Pre Issue Conversation", IssueState.NEW, str, longValue, str, null, null, IssueType.PRE_ISSUE, UUID.randomUUID().toString());
        conversation.userLocalId = this.userDM.getLocalId().longValue();
        conversation.lastUserActivityTime = System.currentTimeMillis();
        this.conversationDAO.insertPreIssueConversation(conversation);
        String string = this.sdkConfigurationDM.getString(SDKConfigurationDM.CONVERSATION_GREETING_MESSAGE);
        if (!StringUtils.isEmpty(string)) {
            AdminMessageDM adminMessageDM = new AdminMessageDM(null, string, str, longValue, new Author("", "", Author.AuthorRole.SYSTEM));
            adminMessageDM.conversationLocalId = conversation.localId;
            adminMessageDM.deliveryState = 1;
            adminMessageDM.setDependencies(this.domain, this.platform);
            this.conversationDAO.insertOrUpdateMessage(adminMessageDM);
            conversation.messageDMs.add(adminMessageDM);
        }
        return conversation;
    }

    public boolean isActiveConversationActionable() {
        ViewableConversation aliveViewableConversation = getAliveViewableConversation();
        Conversation activeConversation = aliveViewableConversation != null ? aliveViewableConversation.getActiveConversation() : null;
        if (activeConversation == null) {
            activeConversation = getActiveConversationFromStorage();
        }
        return this.conversationManager.isConversationActionable(activeConversation, isMessageBoxVisibleInConversationResolutionRejectedState(activeConversation, aliveViewableConversation));
    }

    private boolean isMessageBoxVisibleInConversationResolutionRejectedState(Conversation conversation, ViewableConversation viewableConversation) {
        ConversationVMCallback conversationVMCallback;
        if (conversation == null || conversation.state != IssueState.RESOLUTION_REJECTED) {
            return false;
        }
        if (viewableConversation == null || (conversationVMCallback = viewableConversation.getConversationVMCallback()) == null) {
            return this.conversationInboxDAO.getPersistMessageBox(this.userDM.getLocalId().longValue()) || !StringUtils.isEmpty(this.conversationInboxDAO.getUserReplyDraft(this.userDM.getLocalId().longValue()));
        }
        return conversationVMCallback.isMessageBoxVisible();
    }

    public boolean shouldPersistMessageBox() {
        return this.conversationInboxDAO.getPersistMessageBox(this.userDM.getLocalId().longValue());
    }

    public void setPersistMessageBox(boolean z) {
        this.conversationInboxDAO.savePersistMessageBox(this.userDM.getLocalId().longValue(), z);
    }

    public void setConversationViewState(int i) {
        this.conversationViewState = i;
    }

    public void handlePushNotification(String str, String str2, String str3) {
        Conversation readPreConversationWithoutMessages;
        String str4;
        int i;
        if (IssueType.ISSUE.equals(str)) {
            readPreConversationWithoutMessages = this.conversationDAO.readConversationWithoutMessages(str2);
        } else if (IssueType.PRE_ISSUE.equals(str)) {
            readPreConversationWithoutMessages = this.conversationDAO.readPreConversationWithoutMessages(str2);
        } else {
            HSLogger.e(TAG, "Cannot handle push for unknown issue type. " + str);
            return;
        }
        if (readPreConversationWithoutMessages == null) {
            return;
        }
        String appName = StringUtils.isEmpty(str3) ? this.platform.getDevice().getAppName() : str3;
        PushNotificationData pushNotificationData = this.conversationInboxDAO.getPushNotificationData(readPreConversationWithoutMessages.localUUID);
        if (pushNotificationData == null) {
            str4 = appName;
            i = 1;
        } else {
            int i2 = pushNotificationData.count + 1;
            str4 = pushNotificationData.title;
            i = i2;
        }
        this.conversationInboxDAO.setPushNotificationData(readPreConversationWithoutMessages.localUUID, new PushNotificationData(i, str4));
        if (i > 0 && canShowNotificationForConversation(readPreConversationWithoutMessages)) {
            showNotificationOnUI(readPreConversationWithoutMessages.localId, readPreConversationWithoutMessages.localUUID, i, appName, false);
        }
        sendUnreadCountUpdate();
    }

    public void resetPushNotificationCount(Conversation conversation) {
        this.conversationInboxDAO.setPushNotificationData(conversation.localUUID, null);
        this.domain.getDelegate().didReceiveNotification(0);
    }

    public void clearPushNotifications() {
        Iterator<Conversation> it = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData().iterator();
        while (it.hasNext()) {
            clearNotification(it.next());
        }
    }

    public void showPushNotifications() {
        for (Conversation conversation : this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData()) {
            PushNotificationData pushNotificationData = this.conversationInboxDAO.getPushNotificationData(conversation.localUUID);
            if (pushNotificationData != null && pushNotificationData.count > 0) {
                showNotificationOnUI(conversation.localId, conversation.localUUID, pushNotificationData.count, pushNotificationData.title, false);
            }
        }
    }

    public void clearNotification(final Conversation conversation) {
        this.domain.runOnUI(new F() { // from class: com.helpshift.conversation.domainmodel.ConversationController.5
            @Override // com.helpshift.common.domain.F
            public void f() {
                ConversationController.this.platform.clearNotifications(conversation.localUUID);
            }
        });
        clearInAppNotificationCountCache();
    }

    public int getNotificationCountSync() {
        Conversation activeConversationFromUIOrStorage;
        if (this.userCanReadMessages || (activeConversationFromUIOrStorage = getActiveConversationFromUIOrStorage()) == null) {
            return 0;
        }
        int unSeenMessageCount = this.conversationManager.getUnSeenMessageCount(activeConversationFromUIOrStorage);
        PushNotificationData pushNotificationData = this.conversationInboxDAO.getPushNotificationData(activeConversationFromUIOrStorage.localUUID);
        return Math.max(unSeenMessageCount, pushNotificationData != null ? pushNotificationData.count : 0);
    }

    public ValuePair<Integer, Boolean> fetchConversationsAndGetNotificationCount() {
        UserDM userDM = this.userDM;
        if (userDM == null || !userDM.issueExists()) {
            return new ValuePair<>(-1, true);
        }
        if (this.userCanReadMessages) {
            return new ValuePair<>(0, true);
        }
        List<Conversation> data = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData();
        if (ListUtils.isEmpty(data)) {
            return new ValuePair<>(0, true);
        }
        if (System.currentTimeMillis() - this.kvStore.getLong(LAST_NOTIFCOUNT_FETCH_KEY, 0L).longValue() < (ConversationUtil.shouldPollActivelyForConversations(data) ? ACTIVE_ISSUE_NOTIFICATION_COUNT_TIMEOUT : INACTIVE_ISSUES_NOTIFICATION_COUNT_TIMEOUT)) {
            return new ValuePair<>(Integer.valueOf(getNotificationCountSync()), true);
        }
        this.kvStore.setLong(LAST_NOTIFCOUNT_FETCH_KEY, Long.valueOf(System.currentTimeMillis()));
        fetchConversationUpdates();
        Conversation activeConversationFromUIOrStorage = getActiveConversationFromUIOrStorage();
        return new ValuePair<>(Integer.valueOf(activeConversationFromUIOrStorage != null ? this.conversationManager.getUnSeenMessageCount(activeConversationFromUIOrStorage) : 0), false);
    }

    public void resetLastNotificationCountFetchTime() {
        this.kvStore.setLong(LAST_NOTIFCOUNT_FETCH_KEY, 0L);
    }

    private Conversation getActiveConversationFromUIOrStorage() {
        ViewableConversation aliveViewableConversation = getAliveViewableConversation();
        if (aliveViewableConversation == null) {
            Conversation activeConversationFromStorage = getActiveConversationFromStorage();
            if (activeConversationFromStorage == null) {
                return null;
            }
            activeConversationFromStorage.userLocalId = this.userDM.getLocalId().longValue();
            return activeConversationFromStorage;
        }
        return aliveViewableConversation.getActiveConversation();
    }

    private Conversation getLastViewableSyncedConversation() {
        ViewableConversation aliveViewableConversation = getAliveViewableConversation();
        if (aliveViewableConversation != null) {
            Conversation activeConversation = aliveViewableConversation.getActiveConversation();
            return this.conversationManager.isSynced(activeConversation) ? activeConversation : getLastViewableSyncedConversationFromStorage();
        }
        return getLastViewableSyncedConversationFromStorage();
    }

    private Conversation getLastViewableSyncedConversationFromStorage() {
        List<Conversation> data = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData();
        if (data.isEmpty()) {
            return null;
        }
        List filter = Filters.filter(data, ConversationPredicates.newSyncedConversationPredicate(this.conversationManager));
        List filter2 = Filters.filter(filter, ConversationPredicates.newInProgressConversationPredicate());
        if (ListUtils.isEmpty(filter)) {
            return null;
        }
        if (filter2.isEmpty()) {
            return ConversationUtil.getLastConversationBasedOnCreatedAt(filter);
        }
        return ConversationUtil.getLastConversationBasedOnCreatedAt(filter2);
    }

    public void deleteCachedFilesForResolvedConversations() {
        this.domain.runParallel(new F() { // from class: com.helpshift.conversation.domainmodel.ConversationController.6
            @Override // com.helpshift.common.domain.F
            public void f() {
                for (Conversation conversation : ConversationController.this.conversationDAO.readConversationsWithoutMessages(ConversationController.this.userDM.getLocalId().longValue()).getData()) {
                    conversation.userLocalId = ConversationController.this.userDM.getLocalId().longValue();
                    if (!ConversationController.this.conversationManager.shouldOpen(conversation)) {
                        ConversationController.this.conversationManager.deleteCachedAttachmentFiles(conversation);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void resetPreIssueConversationsForUser(final UserDM userDM) {
        HSLogger.d(TAG, "Starting preissues reset.");
        List<Conversation> data = this.conversationDAO.readConversationsWithoutMessages(userDM.getLocalId().longValue()).getData();
        if (data == null || data.size() == 0) {
            return;
        }
        long preissueResetInterval = this.sdkConfigurationDM.getPreissueResetInterval() * 1000;
        for (final Conversation conversation : data) {
            if (conversation.isInPreIssueMode()) {
                if (System.currentTimeMillis() - conversation.lastUserActivityTime >= preissueResetInterval) {
                    if (StringUtils.isEmpty(conversation.preConversationServerId) && StringUtils.isEmpty(conversation.serverId)) {
                        HSLogger.d(TAG, "Deleting offline preissue : " + conversation.localId);
                        this.conversationDAO.deleteConversation(conversation.localId.longValue());
                        removeInMemoryConversation();
                    } else if (conversation.isIssueInProgress() || conversation.state == IssueState.UNKNOWN) {
                        clearNotification(conversation);
                        this.domain.runParallel(new F() { // from class: com.helpshift.conversation.domainmodel.ConversationController.7
                            @Override // com.helpshift.common.domain.F
                            public void f() {
                                Conversation activeConversation;
                                try {
                                    HSLogger.d(ConversationController.TAG, "Reseting preissue on backend: " + conversation.preConversationServerId);
                                    HashMap<String, String> userRequestData = NetworkDataRequestUtil.getUserRequestData(userDM);
                                    userRequestData.put("state", String.valueOf(IssueState.REJECTED.getValue()));
                                    new GuardOKNetwork(new TSCorrectedNetwork(new PUTNetwork(ConversationController.CREATE_PRE_ISSUE_ROUTE + conversation.preConversationServerId + "/", ConversationController.this.domain, ConversationController.this.platform), ConversationController.this.platform)).makeRequest(new RequestData(userRequestData));
                                    ViewableConversation aliveViewableConversation = ConversationController.this.getAliveViewableConversation(conversation.localId);
                                    if (aliveViewableConversation == null) {
                                        activeConversation = conversation;
                                    } else {
                                        activeConversation = aliveViewableConversation.getActiveConversation();
                                    }
                                    ConversationController.this.conversationManager.updateIssueStatus(activeConversation, IssueState.REJECTED);
                                } catch (RootAPIException e) {
                                    HSLogger.e(ConversationController.TAG, "Error resetting preissue : " + conversation.preConversationServerId, e);
                                    throw e;
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private void fetchConversationHistory() {
        synchronized (fetchConversationUpdatesLock) {
            this.remoteConversationLoader.loadMoreMessages();
        }
    }

    @Override // com.helpshift.account.domainmodel.IUserSyncExecutor
    public void executeUserSync() {
        fetchInitialConversationUpdates();
        List<Conversation> data = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData();
        if (isAtLeastOneConversationNonActionable(data)) {
            return;
        }
        boolean hasMoreMessage = this.remoteConversationLoader.hasMoreMessage();
        for (int i = 0; !isAtLeastOneConversationNonActionable(data) && hasMoreMessage && i < 3; i++) {
            fetchConversationHistory();
            data = this.conversationDAO.readConversationsWithoutMessages(this.userDM.getLocalId().longValue()).getData();
            hasMoreMessage = this.remoteConversationLoader.hasMoreMessage();
        }
    }

    private boolean isAtLeastOneConversationNonActionable(List<Conversation> list) {
        if (ListUtils.isEmpty(list)) {
            return false;
        }
        for (Conversation conversation : list) {
            conversation.userLocalId = this.userDM.getLocalId().longValue();
            if (!conversation.isIssueInProgress()) {
                return true;
            }
        }
        return false;
    }

    public Long getOldestConversationCreatedAtTime() {
        return this.conversationDAO.getOldestConversationCreatedAtTime(this.userDM.getLocalId().longValue());
    }

    public void redactConversations() {
        synchronized (fetchConversationUpdatesLock) {
            deleteConversationsAndMessages();
            if (this.aliveViewableConversation != null) {
                this.aliveViewableConversation.clear();
            }
            this.conversationInboxDAO.resetDataAfterConversationsDeletion(this.userDM.getLocalId().longValue());
        }
    }

    public void updateActiveConversationExpiryProperties() {
        Conversation activeConversationFromUIOrStorage = getActiveConversationFromUIOrStorage();
        if (activeConversationFromUIOrStorage != null) {
            this.conversationManager.updateConversationExpiryProperties(activeConversationFromUIOrStorage);
        }
    }

    /* loaded from: classes2.dex */
    private class CreateConversationStateHolder {
        final AttachmentPickerFile attachmentPickerFile;
        final String description;
        private final F startNewConversationInternalF = new One(new F() { // from class: com.helpshift.conversation.domainmodel.ConversationController.CreateConversationStateHolder.1
            @Override // com.helpshift.common.domain.F
            public void f() {
                ConversationController.this.startNewConversationInternal(CreateConversationStateHolder.this.description, CreateConversationStateHolder.this.userProvidedName, CreateConversationStateHolder.this.userProvidedEmail, CreateConversationStateHolder.this.attachmentPickerFile);
            }
        });
        final String userProvidedEmail;
        final String userProvidedName;

        CreateConversationStateHolder(String str, String str2, String str3, AttachmentPickerFile attachmentPickerFile) {
            this.description = str;
            this.userProvidedName = str2;
            this.userProvidedEmail = str3;
            this.attachmentPickerFile = attachmentPickerFile;
        }

        F getStartNewConversationInternalF() {
            return this.startNewConversationInternalF;
        }
    }
}
