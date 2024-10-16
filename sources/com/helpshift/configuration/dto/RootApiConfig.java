package com.helpshift.configuration.dto;

import com.helpshift.configuration.domainmodel.SDKConfigurationDM;
import com.helpshift.util.MapUtil;
import com.helpshift.util.StringUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public class RootApiConfig {
    public final String conversationPrefillText;
    public final EnableContactUs enableContactUs;
    public final Boolean enableDefaultConversationalFiling;
    public final Boolean enableFullPrivacy;
    public final Boolean enableTypingIndicator;
    public final Boolean gotoConversationAfterContactUs;
    public final Boolean hideNameAndEmail;
    public final String initialUserMessageToAutoSend;
    public final Boolean requireEmail;
    public final Boolean showConversationInfoScreen;
    public final Boolean showConversationResolutionQuestion;
    public final Boolean showSearchOnNewConversation;

    public RootApiConfig(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, EnableContactUs enableContactUs, String str, Boolean bool7, Boolean bool8, Boolean bool9, String str2) {
        this.enableContactUs = enableContactUs;
        this.gotoConversationAfterContactUs = bool;
        this.requireEmail = bool2;
        this.hideNameAndEmail = bool3;
        this.conversationPrefillText = str;
        this.enableFullPrivacy = bool4;
        this.showSearchOnNewConversation = bool5;
        this.showConversationResolutionQuestion = bool6;
        this.showConversationInfoScreen = bool7;
        this.enableTypingIndicator = bool8;
        this.enableDefaultConversationalFiling = bool9;
        this.initialUserMessageToAutoSend = str2;
    }

    /* loaded from: classes2.dex */
    public enum EnableContactUs {
        ALWAYS(0),
        NEVER(1),
        AFTER_VIEWING_FAQS(2),
        AFTER_MARKING_ANSWER_UNHELPFUL(3);

        private final int value;

        EnableContactUs(int i) {
            this.value = i;
        }

        public static EnableContactUs fromInt(int i) {
            for (EnableContactUs enableContactUs : values()) {
                if (enableContactUs.getValue() == i) {
                    return enableContactUs;
                }
            }
            return null;
        }

        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes2.dex */
    public static class RootApiConfigBuilder {
        private EnableContactUs enableContactUs;
        private Boolean enableDefaultConversationalFiling;
        private Boolean enableFullPrivacy;
        private Boolean enableTypingIndicator;
        private Boolean gotoConversationAfterContactUs;
        private Boolean hideNameAndEmail;
        private Boolean requireEmail;
        private Boolean showConversationInfoScreen;
        private Boolean showConversationResolutionQuestion;
        private Boolean showSearchOnNewConversation;
        private String conversationPrefillText = "";
        private String initialUserMessageToAutoSend = "";

        public RootApiConfigBuilder applyMap(Map<String, Object> map) {
            Integer num = (Integer) MapUtil.getValue(map, SDKConfigurationDM.ENABLE_CONTACT_US, Integer.class, null);
            if (num != null) {
                this.enableContactUs = EnableContactUs.fromInt(num.intValue());
            }
            String str = "";
            if (map.containsKey(SDKConfigurationDM.GOTO_CONVERSATION_AFTER_CONTACT_US)) {
                str = SDKConfigurationDM.GOTO_CONVERSATION_AFTER_CONTACT_US;
            } else if (map.containsKey("gotoCoversationAfterContactUs")) {
                str = "gotoCoversationAfterContactUs";
            }
            this.gotoConversationAfterContactUs = (Boolean) MapUtil.getValue(map, str, Boolean.class, this.gotoConversationAfterContactUs);
            this.requireEmail = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.REQUIRE_EMAIL, Boolean.class, this.requireEmail);
            this.hideNameAndEmail = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.HIDE_NAME_AND_EMAIL, Boolean.class, this.hideNameAndEmail);
            this.enableFullPrivacy = (Boolean) MapUtil.getValue(map, "enableFullPrivacy", Boolean.class, this.enableFullPrivacy);
            this.showSearchOnNewConversation = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.SHOW_SEARCH_ON_NEW_CONVERSATION, Boolean.class, this.showSearchOnNewConversation);
            this.showConversationResolutionQuestion = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.SHOW_CONVERSATION_RESOLUTION_QUESTION_API, Boolean.class, this.showConversationResolutionQuestion);
            this.conversationPrefillText = (String) MapUtil.getValue(map, SDKConfigurationDM.CONVERSATION_PRE_FILL_TEXT, String.class, this.conversationPrefillText);
            if (StringUtils.isEmpty(this.conversationPrefillText)) {
                this.conversationPrefillText = "";
            }
            this.showConversationInfoScreen = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.SHOW_CONVERSATION_INFO_SCREEN, Boolean.class, this.showConversationInfoScreen);
            this.enableTypingIndicator = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.ENABLE_TYPING_INDICATOR, Boolean.class, this.enableTypingIndicator);
            this.enableDefaultConversationalFiling = (Boolean) MapUtil.getValue(map, SDKConfigurationDM.ENABLE_DEFAULT_CONVERSATIONAL_FILING, Boolean.class, this.enableDefaultConversationalFiling);
            this.initialUserMessageToAutoSend = (String) MapUtil.getValue(map, "initialUserMessage", String.class, this.initialUserMessageToAutoSend);
            this.initialUserMessageToAutoSend = this.initialUserMessageToAutoSend.trim();
            if (StringUtils.isEmpty(this.initialUserMessageToAutoSend)) {
                this.initialUserMessageToAutoSend = "";
            }
            return this;
        }

        public RootApiConfig build() {
            return new RootApiConfig(this.gotoConversationAfterContactUs, this.requireEmail, this.hideNameAndEmail, this.enableFullPrivacy, this.showSearchOnNewConversation, this.showConversationResolutionQuestion, this.enableContactUs, this.conversationPrefillText, this.showConversationInfoScreen, this.enableTypingIndicator, this.enableDefaultConversationalFiling, this.initialUserMessageToAutoSend);
        }
    }
}
