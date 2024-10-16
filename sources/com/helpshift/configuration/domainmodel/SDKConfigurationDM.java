package com.helpshift.configuration.domainmodel;

import com.helpshift.account.domainmodel.UserDM;
import com.helpshift.account.domainmodel.UserManagerDM;
import com.helpshift.common.domain.Domain;
import com.helpshift.common.platform.KVStore;
import com.helpshift.common.platform.Platform;
import com.helpshift.common.platform.network.ResponseParser;
import com.helpshift.configuration.dto.RootApiConfig;
import com.helpshift.configuration.dto.RootInstallConfig;
import com.helpshift.configuration.response.AvatarConfig;
import com.helpshift.configuration.response.PeriodicReview;
import com.helpshift.configuration.response.RootServerConfig;
import com.helpshift.conversation.activeconversation.message.AvatarImageDownloader;
import com.helpshift.logger.constants.LogLevel;
import com.helpshift.util.AttachmentConstants;
import com.helpshift.util.ListUtils;
import com.helpshift.util.StringUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class SDKConfigurationDM {
    public static final String ACTIVELY_SYNC_APP_LAUNCH_EVENT = "activelySyncAppLaunchEvent";
    public static final String AGENT_FALLBACK_IMAGE_LOCAL_PATH = "agentFallbackImageLocalPath";
    public static final String AGENT_FALLBACK_IMAGE_URL = "agentFallbackImageUrl";
    public static final String ALLOW_USER_ATTACHMENTS = "allowUserAttachments";
    public static final String API_KEY = "apiKey";
    public static final String APP_REVIEWED = "app_reviewed";
    public static final String AUTO_FILL_FIRST_PREISSUE_MESSAGE = "autoFillFirstPreIssueMessage";
    public static final String AVATAR_CACHE_EXPIRY = "avatarCacheExpiry";
    private static final long AVATAR_IMAGE_CACHE_DEFAULT_INTERVAL = 14400000;
    public static final String AVATAR_IMAGE_LOCAL_PATH = "avatar_image_local_path";
    public static final String AVATAR_IMAGE_TEMPLATE_URL = "avatarTemplateUrl";
    public static final String AVATAR_IMAGE_URL = "avatar_image_url";
    public static final String BOT_FALLBACK_IMAGE_LOCAL_PATH = "botFallbackImageLocalPath";
    public static final String BOT_FALLBACK_IMAGE_URL = "botFallbackImageUrl";
    public static final String BREADCRUMB_LIMIT = "breadcrumbLimit";
    public static final String CONVERSATIONAL_ISSUE_FILING = "conversationalIssueFiling";
    public static final String CONVERSATION_GREETING_MESSAGE = "conversationGreetingMessage";
    public static final String CONVERSATION_PRE_FILL_TEXT = "conversationPrefillText";
    public static final String CUSTOMER_SATISFACTION_SURVEY = "customerSatisfactionSurvey";
    public static final String DEBUG_LOG_LIMIT = "debugLogLimit";
    public static final String DEFAULT_FALLBACK_LANGUAGE_ENABLE = "defaultFallbackLanguageEnable";
    public static final String DISABLE_ANIMATION = "disableAnimations";
    public static final String DISABLE_APP_LAUNCH_EVENT = "disableAppLaunchEvent";
    public static final String DISABLE_ERROR_LOGGING = "disableErrorLogging";
    public static final String DISABLE_IN_APP_CONVERSATION = "disableInAppConversation";
    public static final String DOMAIN_NAME = "domainName";
    public static final String ENABLE_CONTACT_US = "enableContactUs";
    public static final String ENABLE_DEFAULT_CONVERSATIONAL_FILING = "enableDefaultConversationalFiling";
    public static final String ENABLE_FULL_PRIVACY = "fullPrivacy";
    public static final String ENABLE_IN_APP_NOTIFICATION = "enableInAppNotification";
    public static final String ENABLE_TYPING_INDICATOR = "enableTypingIndicator";
    public static final String ENABLE_TYPING_INDICATOR_AGENT = "enableTypingIndicatorAgent";
    public static final String FONT_PATH = "fontPath";
    public static final String GOTO_CONVERSATION_AFTER_CONTACT_US = "gotoConversationAfterContactUs";
    public static final String HEADER_IMAGE_LOCAL_PATH = "headerImageLocalPath";
    public static final String HEADER_IMAGE_URL = "headerImageUrl";
    public static final String HEADER_TITLE_TEXT = "headerText";
    public static final String HELPSHIFT_BRANDING_DISABLE_AGENT = "disableHelpshiftBrandingAgent";
    public static final String HELPSHIFT_BRANDING_DISABLE_INSTALL = "disableHelpshiftBranding";
    public static final String HIDE_NAME_AND_EMAIL = "hideNameAndEmail";
    public static final String INBOX_POLLING_ENABLE = "inboxPollingEnable";
    public static final String INITIAL_USER_MESSAGE_TO_AUTOSEND_IN_PREISSUE = "initialUserMessageToAutoSendInPreissue";
    public static final String IS_AVATAR_ENABLED_IN_CHAT_FEED = "showAvatarEnabled";
    public static final String IS_CUSTOM_HEADER_ENABLED = "showHeaderEnabled";
    public static final String IS_PERSONALISED_CONVERSATION_ENABLED = "personalisedConversationEnabled";
    public static final String IS_SMART_INTENT_ENABLED = "smartIntentEnabled";
    public static final String LAST_SUCCESSFUL_APP_LAUNCH_EVENT_SYNC_TIME = "lastSuccessfulAppLaunchEventTime";
    public static final String LAST_SUCCESSFUL_CONFIG_FETCH_TIME = "lastSuccessfulConfigFetchTime";
    private static final Long MINIMUM_PERIODIC_FETCH_INTERVAL = 60L;
    private static final Long MINIMUM_PREISSUE_RESET_INTERVAL = 43200L;
    public static final String NOTIFICATION_ICON_ID = "notificationIconId";
    public static final String NOTIFICATION_LARGE_ICON_ID = "notificationLargeIconId";
    public static final String NOTIFICATION_MUTE_ENABLE = "notificationMute";
    public static final String NOTIFICATION_SOUND_ID = "notificationSoundId";
    public static final String PERIODIC_FETCH_INTERVAL = "periodicFetchInterval";
    public static final String PERIODIC_REVIEW_ENABLED = "periodicReviewEnabled";
    public static final String PERIODIC_REVIEW_INTERVAL = "periodicReviewInterval";
    public static final String PERIODIC_REVIEW_TYPE = "periodicReviewType";
    public static final String PERIODIC_SYNC_APP_LAUNCH_EVENT_INTERVAL = "periodicSyncAppLaunchEventInterval";
    public static final String PLATFORM_ID = "platformId";
    public static final String PLUGIN_VERSION = "pluginVersion";
    public static final String PREISSUE_RESET_INTERVAL = "preissueResetInterval";
    public static final String PROFILE_FORM_ENABLE = "profileFormEnable";
    public static final String REQUIRED_LOG_LEVEL_FOR_REPORTING = "logLevelForReporting";
    public static final String REQUIRE_EMAIL = "requireEmail";
    public static final String REQUIRE_NAME_AND_EMAIL = "requireNameAndEmail";
    public static final String REVIEW_URL = "reviewUrl";
    public static final String RUNTIME_VERSION = "runtimeVersion";
    public static final String SDK_LANGUAGE = "sdkLanguage";
    public static final String SDK_TYPE = "sdkType";
    public static final String SHOULD_SHOW_CONVERSATION_HISTORY_AGENT = "showConversationHistoryAgent";
    public static final String SHOW_CONVERSATION_INFO_SCREEN = "showConversationInfoScreen";
    public static final String SHOW_CONVERSATION_RESOLUTION_QUESTION_AGENT = "showConversationResolutionQuestionAgent";
    public static final String SHOW_CONVERSATION_RESOLUTION_QUESTION_API = "showConversationResolutionQuestion";
    public static final String SHOW_PERSONALIZED_AGENT_AVATAR = "personalizedAgent";
    public static final String SHOW_PERSONALIZED_BOT_AVATAR = "personalizedBot";
    public static final String SHOW_SEARCH_ON_NEW_CONVERSATION = "showSearchOnNewConversation";
    private static final long SMART_INTENT_CLIENT_CACHE_DEFAULT_INTERVAL = 259200000;
    public static final String SMART_INTENT_CLIENT_CACHE_INTERVAL = "smartIntentClientCache";
    private static final long SMART_INTENT_MODEL_REFRESH_DEFAULT_INTERVAL = 600000;
    public static final String SMART_INTENT_MODEL_REFRESH_INTERVAL = "smartIntentModelSLA";
    private static final long SMART_INTENT_TREE_REFRESH_DEFAULT_INTERVAL = 600000;
    public static final String SMART_INTENT_TREE_REFRESH_INTERVAL = "smartIntentTreeSLA";
    public static final String SUPPORT_NOTIFICATION_CHANNEL_ID = "supportNotificationChannelId";
    public static final String SYSTEM_MESSAGE_NICKNAME = "systemMessageNickname";
    private static final String TAG = "Helpshift_SDKConfigDM";
    public static final String WHITELISTED_ATTACHMENT = "whiteListedAttachment";
    private final Domain domain;
    private final KVStore kvStore;
    private final Platform platform;
    private final ResponseParser responseParser;

    public SDKConfigurationDM(Domain domain, Platform platform) {
        this.domain = domain;
        this.platform = platform;
        this.responseParser = platform.getResponseParser();
        this.kvStore = platform.getKVStore();
    }

    public void updateUserConfig(UserDM userDM, RootServerConfig rootServerConfig, UserManagerDM userManagerDM) {
        userManagerDM.updateIssueExists(userDM, rootServerConfig.issueExists);
    }

    public void updateServerConfig(RootServerConfig rootServerConfig) {
        boolean z;
        boolean z2;
        HashMap hashMap = new HashMap();
        hashMap.put(REQUIRE_NAME_AND_EMAIL, Boolean.valueOf(rootServerConfig.requireNameAndEmail));
        hashMap.put(PROFILE_FORM_ENABLE, Boolean.valueOf(rootServerConfig.profileFormEnable));
        hashMap.put(CUSTOMER_SATISFACTION_SURVEY, Boolean.valueOf(rootServerConfig.customerSatisfactionSurvey));
        hashMap.put(DISABLE_IN_APP_CONVERSATION, Boolean.valueOf(rootServerConfig.disableInAppConversation));
        hashMap.put(HELPSHIFT_BRANDING_DISABLE_AGENT, Boolean.valueOf(rootServerConfig.disableHelpshiftBranding));
        hashMap.put(DEBUG_LOG_LIMIT, Integer.valueOf(rootServerConfig.debugLogLimit));
        hashMap.put(BREADCRUMB_LIMIT, Integer.valueOf(rootServerConfig.breadcrumbLimit));
        hashMap.put(REVIEW_URL, rootServerConfig.reviewUrl);
        PeriodicReview periodicReview = rootServerConfig.periodicReview;
        boolean z3 = false;
        if (periodicReview == null) {
            periodicReview = new PeriodicReview(false, 0, null);
        }
        hashMap.put(PERIODIC_REVIEW_ENABLED, Boolean.valueOf(periodicReview.isEnabled));
        hashMap.put(PERIODIC_REVIEW_INTERVAL, Integer.valueOf(periodicReview.interval));
        hashMap.put(PERIODIC_REVIEW_TYPE, periodicReview.type);
        hashMap.put(CONVERSATION_GREETING_MESSAGE, rootServerConfig.conversationGreetingMessage);
        hashMap.put(CONVERSATIONAL_ISSUE_FILING, Boolean.valueOf(rootServerConfig.conversationalIssueFiling));
        hashMap.put(ENABLE_TYPING_INDICATOR_AGENT, Boolean.valueOf(rootServerConfig.enableTypingIndicator));
        hashMap.put(SHOW_CONVERSATION_RESOLUTION_QUESTION_AGENT, Boolean.valueOf(rootServerConfig.showConversationResolutionQuestion));
        hashMap.put(SHOULD_SHOW_CONVERSATION_HISTORY_AGENT, Boolean.valueOf(rootServerConfig.shouldShowConversationHistory));
        hashMap.put(ALLOW_USER_ATTACHMENTS, Boolean.valueOf(rootServerConfig.allowUserAttachments));
        hashMap.put(PERIODIC_FETCH_INTERVAL, Long.valueOf(rootServerConfig.periodicFetchInterval));
        hashMap.put(PREISSUE_RESET_INTERVAL, Long.valueOf(rootServerConfig.preissueResetInterval));
        hashMap.put(AUTO_FILL_FIRST_PREISSUE_MESSAGE, Boolean.valueOf(rootServerConfig.autoFillFirstPreissueMessage));
        hashMap.put(IS_SMART_INTENT_ENABLED, Boolean.valueOf(rootServerConfig.isSmartIntentEnabled));
        hashMap.put(SMART_INTENT_MODEL_REFRESH_INTERVAL, rootServerConfig.smartIntentSearchModelRefreshInterval);
        hashMap.put(SMART_INTENT_TREE_REFRESH_INTERVAL, rootServerConfig.smartIntentTreeRefreshInterval);
        hashMap.put(SMART_INTENT_CLIENT_CACHE_INTERVAL, rootServerConfig.smartIntentClientCacheInterval);
        hashMap.put(WHITELISTED_ATTACHMENT, rootServerConfig.whiteListedAttachments);
        hashMap.put(REQUIRED_LOG_LEVEL_FOR_REPORTING, Integer.valueOf(rootServerConfig.logLevel));
        hashMap.put(ACTIVELY_SYNC_APP_LAUNCH_EVENT, Boolean.valueOf(rootServerConfig.activelySyncAppLaunchEvent));
        hashMap.put(PERIODIC_SYNC_APP_LAUNCH_EVENT_INTERVAL, Long.valueOf(rootServerConfig.periodicSyncAppLaunchEventInterval));
        AvatarConfig avatarConfig = rootServerConfig.avatarConfig;
        boolean z4 = avatarConfig != null;
        if (avatarConfig == null) {
            avatarConfig = new AvatarConfig(false, false, "", false, "", "", "", 0L);
        }
        if (avatarConfig.isShowAvatarInChatFeedEnabled) {
            boolean z5 = !rootServerConfig.conversationHeaderImageUrl.equals(getConversationHeaderImageUrl());
            boolean z6 = !avatarConfig.botFallbackImageUrl.equals(getBotFallbackImageUrl());
            z2 = !avatarConfig.agentFallbackImageUrl.equals(getAgentFallbackImageUrl());
            z = z5;
            z3 = z6;
        } else {
            z = false;
            z2 = false;
        }
        if (rootServerConfig.isShowConversationHeaderEnabled) {
            z = !rootServerConfig.conversationHeaderImageUrl.equals(getConversationHeaderImageUrl());
        }
        hashMap.put(IS_PERSONALISED_CONVERSATION_ENABLED, Boolean.valueOf(z4));
        hashMap.put(IS_CUSTOM_HEADER_ENABLED, Boolean.valueOf(rootServerConfig.isShowConversationHeaderEnabled));
        hashMap.put(IS_AVATAR_ENABLED_IN_CHAT_FEED, Boolean.valueOf(avatarConfig.isShowAvatarInChatFeedEnabled));
        hashMap.put(HEADER_TITLE_TEXT, rootServerConfig.conversationHeaderTitleText);
        hashMap.put(HEADER_IMAGE_URL, rootServerConfig.conversationHeaderImageUrl);
        hashMap.put(SHOW_PERSONALIZED_AGENT_AVATAR, Boolean.valueOf(avatarConfig.isPersonalisedAgentEnabled));
        hashMap.put(AGENT_FALLBACK_IMAGE_URL, avatarConfig.agentFallbackImageUrl);
        hashMap.put(SHOW_PERSONALIZED_BOT_AVATAR, Boolean.valueOf(avatarConfig.isPersonalisedBotEnabled));
        hashMap.put(BOT_FALLBACK_IMAGE_URL, avatarConfig.botFallbackImageUrl);
        hashMap.put(SYSTEM_MESSAGE_NICKNAME, avatarConfig.systemMessageNickname);
        hashMap.put(AVATAR_IMAGE_TEMPLATE_URL, avatarConfig.templateUrl);
        hashMap.put(AVATAR_CACHE_EXPIRY, Long.valueOf(avatarConfig.cacheExpiry));
        this.kvStore.setKeyValues(hashMap);
        downloadFallbackAndHeaderImages(z2, z3, z);
    }

    private void downloadFallbackAndHeaderImages(boolean z, boolean z2, boolean z3) {
        if (isAvatarEnabledInChatFeed()) {
            if (z) {
                AvatarImageDownloader.downloadAgentFallbackImage(this.platform, this.domain);
            }
            if (z2) {
                AvatarImageDownloader.downloadBotFallbackImage(this.platform, this.domain);
            }
        }
        if (z3) {
            AvatarImageDownloader.downloadConversationHeaderImage(this.platform, this.domain);
        }
    }

    public void setAgentAvatarImagePath(String str) {
        this.kvStore.setString(AGENT_FALLBACK_IMAGE_LOCAL_PATH, str);
    }

    public void setBotAvatarImagePath(String str) {
        this.kvStore.setString(BOT_FALLBACK_IMAGE_LOCAL_PATH, str);
    }

    public void setHeaderAvatarImagePath(String str) {
        this.kvStore.setString(HEADER_IMAGE_LOCAL_PATH, str);
    }

    public void updateLastSuccessfulConfigFetchTime() {
        this.kvStore.setLong(LAST_SUCCESSFUL_CONFIG_FETCH_TIME, Long.valueOf(System.currentTimeMillis() / 1000));
    }

    public Long getLastSuccessfulConfigFetchTime() {
        return this.kvStore.getLong(LAST_SUCCESSFUL_CONFIG_FETCH_TIME, 0L);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean getBoolean(String str) {
        char c;
        boolean z = true;
        switch (str.hashCode()) {
            case -1703140188:
                if (str.equals(CONVERSATIONAL_ISSUE_FILING)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -591814160:
                if (str.equals(PROFILE_FORM_ENABLE)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -366496336:
                if (str.equals(ENABLE_TYPING_INDICATOR_AGENT)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -338380156:
                if (str.equals(ENABLE_IN_APP_NOTIFICATION)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1262906910:
                if (str.equals(DEFAULT_FALLBACK_LANGUAGE_ENABLE)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1423623260:
                if (str.equals(ALLOW_USER_ATTACHMENTS)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                z = this.kvStore.getBoolean(ENABLE_DEFAULT_CONVERSATIONAL_FILING, false).booleanValue();
                break;
            default:
                z = false;
                break;
        }
        return this.kvStore.getBoolean(str, Boolean.valueOf(z)).booleanValue();
    }

    public Integer getInt(String str) {
        char c;
        Integer num;
        int hashCode = str.hashCode();
        if (hashCode != -71624118) {
            if (hashCode == 1384494456 && str.equals(BREADCRUMB_LIMIT)) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str.equals(DEBUG_LOG_LIMIT)) {
                c = 0;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
            case 1:
                num = 100;
                break;
            default:
                num = null;
                break;
        }
        return this.kvStore.getInt(str, num);
    }

    public String getString(String str) {
        char c;
        String str2;
        int hashCode = str.hashCode();
        if (hashCode == -340534862) {
            if (str.equals(SDK_LANGUAGE)) {
                c = 1;
            }
            c = 65535;
        } else if (hashCode == 365503764) {
            if (str.equals(FONT_PATH)) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode != 493025015) {
            if (hashCode == 1948062356 && str.equals(SDK_TYPE)) {
                c = 3;
            }
            c = 65535;
        } else {
            if (str.equals(REVIEW_URL)) {
                c = 0;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                str2 = "";
                break;
            case 3:
                str2 = "android";
                break;
            default:
                str2 = null;
                break;
        }
        return this.kvStore.getString(str, str2);
    }

    public PeriodicReview getPeriodicReview() {
        return new PeriodicReview(this.kvStore.getBoolean(PERIODIC_REVIEW_ENABLED, false).booleanValue(), this.kvStore.getInt(PERIODIC_REVIEW_INTERVAL, 0).intValue(), this.kvStore.getString(PERIODIC_REVIEW_TYPE, ""));
    }

    public void updateInstallConfig(RootInstallConfig rootInstallConfig) {
        HashMap hashMap = new HashMap();
        String str = rootInstallConfig.supportNotificationChannelId == null ? "" : rootInstallConfig.supportNotificationChannelId;
        String str2 = rootInstallConfig.fontPath == null ? "" : rootInstallConfig.fontPath;
        hashMap.put(SUPPORT_NOTIFICATION_CHANNEL_ID, str);
        hashMap.put(FONT_PATH, str2);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(ENABLE_IN_APP_NOTIFICATION, rootInstallConfig.enableInAppNotification);
        hashMap2.put(DEFAULT_FALLBACK_LANGUAGE_ENABLE, rootInstallConfig.enableDefaultFallbackLanguage);
        hashMap2.put(INBOX_POLLING_ENABLE, rootInstallConfig.enableInboxPolling);
        hashMap2.put(NOTIFICATION_MUTE_ENABLE, rootInstallConfig.enableNotificationMute);
        hashMap2.put(DISABLE_ANIMATION, rootInstallConfig.disableAnimations);
        hashMap2.put("disableHelpshiftBranding", rootInstallConfig.disableHelpshiftBranding);
        hashMap2.put(DISABLE_ERROR_LOGGING, rootInstallConfig.disableErrorLogging);
        hashMap2.put(DISABLE_APP_LAUNCH_EVENT, rootInstallConfig.disableAppLaunchEvent);
        hashMap2.put(NOTIFICATION_SOUND_ID, rootInstallConfig.notificationSound);
        hashMap2.put(NOTIFICATION_ICON_ID, rootInstallConfig.notificationIcon);
        hashMap2.put(NOTIFICATION_LARGE_ICON_ID, rootInstallConfig.largeNotificationIcon);
        hashMap2.put(SDK_TYPE, rootInstallConfig.sdkType);
        hashMap2.put(PLUGIN_VERSION, rootInstallConfig.pluginVersion);
        hashMap2.put(RUNTIME_VERSION, rootInstallConfig.runtimeVersion);
        removeNullValues(hashMap2);
        hashMap2.putAll(hashMap);
        this.kvStore.setKeyValues(hashMap2);
    }

    public boolean isHelpshiftBrandingDisabled() {
        return this.kvStore.getBoolean("disableHelpshiftBranding", false).booleanValue() || this.kvStore.getBoolean(HELPSHIFT_BRANDING_DISABLE_AGENT, false).booleanValue();
    }

    public boolean shouldShowConversationResolutionQuestion() {
        return getBoolean(SHOW_CONVERSATION_RESOLUTION_QUESTION_AGENT) || getBoolean(SHOW_CONVERSATION_RESOLUTION_QUESTION_API);
    }

    public void updateApiConfig(RootApiConfig rootApiConfig) {
        HashMap hashMap = new HashMap();
        hashMap.put(CONVERSATION_PRE_FILL_TEXT, rootApiConfig.conversationPrefillText);
        hashMap.put(INITIAL_USER_MESSAGE_TO_AUTOSEND_IN_PREISSUE, rootApiConfig.initialUserMessageToAutoSend);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(ENABLE_FULL_PRIVACY, rootApiConfig.enableFullPrivacy);
        hashMap2.put(HIDE_NAME_AND_EMAIL, rootApiConfig.hideNameAndEmail);
        hashMap2.put(REQUIRE_EMAIL, rootApiConfig.requireEmail);
        hashMap2.put(SHOW_SEARCH_ON_NEW_CONVERSATION, rootApiConfig.showSearchOnNewConversation);
        hashMap2.put(GOTO_CONVERSATION_AFTER_CONTACT_US, rootApiConfig.gotoConversationAfterContactUs);
        hashMap2.put(SHOW_CONVERSATION_RESOLUTION_QUESTION_API, rootApiConfig.showConversationResolutionQuestion);
        hashMap2.put(SHOW_CONVERSATION_INFO_SCREEN, rootApiConfig.showConversationInfoScreen);
        hashMap2.put(ENABLE_TYPING_INDICATOR, rootApiConfig.enableTypingIndicator);
        if (rootApiConfig.enableContactUs != null) {
            hashMap2.put(ENABLE_CONTACT_US, Integer.valueOf(rootApiConfig.enableContactUs.getValue()));
        }
        hashMap2.put(ENABLE_DEFAULT_CONVERSATIONAL_FILING, rootApiConfig.enableDefaultConversationalFiling);
        removeNullValues(hashMap2);
        hashMap2.putAll(hashMap);
        this.kvStore.setKeyValues(hashMap2);
    }

    public RootApiConfig.EnableContactUs getEnableContactUs() {
        return RootApiConfig.EnableContactUs.fromInt(this.kvStore.getInt(ENABLE_CONTACT_US, 0).intValue());
    }

    public void setAppReviewed(boolean z) {
        this.kvStore.setBoolean(APP_REVIEWED, Boolean.valueOf(z));
    }

    public void setSdkLanguage(String str) {
        this.kvStore.setString(SDK_LANGUAGE, str);
    }

    public boolean shouldEnableTypingIndicator() {
        return getBoolean(ENABLE_TYPING_INDICATOR_AGENT) || getBoolean(ENABLE_TYPING_INDICATOR);
    }

    public boolean shouldCreateConversationAnonymously() {
        return getBoolean(ENABLE_FULL_PRIVACY) || !((getBoolean(REQUIRE_NAME_AND_EMAIL) && getBoolean(HIDE_NAME_AND_EMAIL)) || getBoolean(PROFILE_FORM_ENABLE));
    }

    public int getMinimumConversationDescriptionLength() {
        return this.platform.getMinimumConversationDescriptionLength();
    }

    private void removeNullValues(Map<String, Serializable> map) {
        Iterator<Map.Entry<String, Serializable>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue() == null) {
                it.remove();
            }
        }
    }

    public boolean shouldShowConversationHistory() {
        if (getBoolean(SHOULD_SHOW_CONVERSATION_HISTORY_AGENT) && getBoolean(CONVERSATIONAL_ISSUE_FILING)) {
            return !getBoolean(ENABLE_FULL_PRIVACY);
        }
        return false;
    }

    public long getPeriodicFetchInterval() {
        return Math.max(this.kvStore.getLong(PERIODIC_FETCH_INTERVAL, 0L).longValue(), MINIMUM_PERIODIC_FETCH_INTERVAL.longValue());
    }

    public long getPreissueResetInterval() {
        return Math.max(this.kvStore.getLong(PREISSUE_RESET_INTERVAL, 0L).longValue(), MINIMUM_PREISSUE_RESET_INTERVAL.longValue());
    }

    public boolean isSmartIntentsEnabled() {
        return this.kvStore.getBoolean(IS_SMART_INTENT_ENABLED, false).booleanValue();
    }

    public long getSmartIntentTreeRefreshInterval() {
        return this.kvStore.getLong(SMART_INTENT_TREE_REFRESH_INTERVAL, 600000L).longValue();
    }

    public long getSmartIntentModelRefreshInterval() {
        return this.kvStore.getLong(SMART_INTENT_MODEL_REFRESH_INTERVAL, 600000L).longValue();
    }

    public long getSmartIntentClientCacheExpiryInterval() {
        return this.kvStore.getLong(SMART_INTENT_CLIENT_CACHE_INTERVAL, Long.valueOf(SMART_INTENT_CLIENT_CACHE_DEFAULT_INTERVAL)).longValue();
    }

    public boolean shouldAutoFillPreissueFirstMessage() {
        return this.kvStore.getBoolean(AUTO_FILL_FIRST_PREISSUE_MESSAGE, false).booleanValue();
    }

    public List<String> getWhiteListAttachmentMimeTypes() {
        Object serializable = this.kvStore.getSerializable(WHITELISTED_ATTACHMENT);
        return serializable != null ? ListUtils.flatten((List) serializable) : Arrays.asList(AttachmentConstants.ALLOW_ALL_MIME);
    }

    public boolean isImageWhiteListed() {
        for (String str : getWhiteListAttachmentMimeTypes()) {
            if (str.startsWith(AttachmentConstants.IMAGE_MIME_PREFIX) || str.equals(AttachmentConstants.ALLOW_ALL_MIME)) {
                return true;
            }
        }
        return false;
    }

    public int getRequiredLogCachingLevel() {
        return this.kvStore.getInt(REQUIRED_LOG_LEVEL_FOR_REPORTING, Integer.valueOf(LogLevel.FATAL.getValue())).intValue();
    }

    public boolean isPersonalisedConversationEnabled() {
        return this.kvStore.getBoolean(IS_PERSONALISED_CONVERSATION_ENABLED, true).booleanValue();
    }

    public boolean isAvatarEnabledInChatFeed() {
        return this.kvStore.getBoolean(IS_AVATAR_ENABLED_IN_CHAT_FEED, true).booleanValue() && isPersonalisedConversationEnabled();
    }

    public boolean isPersonalisedAgentEnabled() {
        return this.kvStore.getBoolean(SHOW_PERSONALIZED_AGENT_AVATAR, false).booleanValue() && isAvatarEnabledInChatFeed();
    }

    public boolean isPersonalisedBotEnabled() {
        return this.kvStore.getBoolean(SHOW_PERSONALIZED_BOT_AVATAR, false).booleanValue() && isAvatarEnabledInChatFeed();
    }

    public boolean isConversationHeaderEnabled() {
        return this.kvStore.getBoolean(IS_CUSTOM_HEADER_ENABLED, true).booleanValue();
    }

    public String getSystemMessageNickname() {
        return this.kvStore.getString(SYSTEM_MESSAGE_NICKNAME, "");
    }

    public String getCustomHeaderTitle() {
        return this.kvStore.getString(HEADER_TITLE_TEXT, "");
    }

    public String getConversationHeaderImageUrl() {
        return this.kvStore.getString(HEADER_IMAGE_URL, "");
    }

    public String getAgentFallbackImageUrl() {
        return this.kvStore.getString(AGENT_FALLBACK_IMAGE_URL, "");
    }

    public String getBotFallbackImageUrl() {
        return this.kvStore.getString(BOT_FALLBACK_IMAGE_URL, "");
    }

    public String getConversationHeaderImageLocalPath() {
        return this.kvStore.getString(HEADER_IMAGE_LOCAL_PATH, "");
    }

    public String getAgentFallbackImageLocalPath() {
        return this.kvStore.getString(AGENT_FALLBACK_IMAGE_LOCAL_PATH, "");
    }

    public String getBotFallbackImageLocalPath() {
        return this.kvStore.getString(BOT_FALLBACK_IMAGE_LOCAL_PATH, "");
    }

    public long getAvatarCacheExpiry() {
        return this.kvStore.getLong(AVATAR_CACHE_EXPIRY, Long.valueOf(AVATAR_IMAGE_CACHE_DEFAULT_INTERVAL)).longValue();
    }

    public String getAvatarImageTemplateUrl() {
        return this.kvStore.getString(AVATAR_IMAGE_TEMPLATE_URL);
    }

    public String getAvatarImageUrl(String str) {
        String avatarImageTemplateUrl = getAvatarImageTemplateUrl();
        return StringUtils.isNotEmpty(avatarImageTemplateUrl) ? avatarImageTemplateUrl.replace("{{avatar_id}}", str) : "";
    }

    public void storeDownloadedImage(String str, String str2) {
        char c;
        int hashCode = str2.hashCode();
        if (hashCode == -996622595) {
            if (str2.equals(BOT_FALLBACK_IMAGE_URL)) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode != 662817729) {
            if (hashCode == 1628981307 && str2.equals(AGENT_FALLBACK_IMAGE_URL)) {
                c = 1;
            }
            c = 65535;
        } else {
            if (str2.equals(HEADER_IMAGE_URL)) {
                c = 0;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                setHeaderAvatarImagePath(str);
                return;
            case 1:
                setAgentAvatarImagePath(str);
                return;
            case 2:
                setBotAvatarImagePath(str);
                return;
            default:
                return;
        }
    }

    public long getAppLaunchEventSyncInterval() {
        return this.kvStore.getLong(PERIODIC_SYNC_APP_LAUNCH_EVENT_INTERVAL, 0L).longValue();
    }

    public boolean isActivelySyncAppLaunchEventEnabled() {
        return this.kvStore.getBoolean(ACTIVELY_SYNC_APP_LAUNCH_EVENT, true).booleanValue();
    }

    public void updateLastSuccessfulAppLaunchEventSyncTime() {
        this.kvStore.setLong(LAST_SUCCESSFUL_APP_LAUNCH_EVENT_SYNC_TIME, Long.valueOf(System.currentTimeMillis()));
    }

    public Long getLastSuccessfulAppLaunchEventSyncTime() {
        return this.kvStore.getLong(LAST_SUCCESSFUL_APP_LAUNCH_EVENT_SYNC_TIME, 0L);
    }
}
