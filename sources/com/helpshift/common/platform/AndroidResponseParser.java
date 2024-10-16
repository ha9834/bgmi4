package com.helpshift.common.platform;

import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.ServerProtocol;
import com.helpshift.analytics.AnalyticsEventKey;
import com.helpshift.auth.dto.WebSocketAuthData;
import com.helpshift.bots.BotControlActions;
import com.helpshift.common.exception.ParseException;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.common.platform.network.ResponseParser;
import com.helpshift.common.util.HSDateFormatSpec;
import com.helpshift.configuration.response.AvatarConfig;
import com.helpshift.configuration.response.PeriodicReview;
import com.helpshift.configuration.response.RootServerConfig;
import com.helpshift.conversation.IssueType;
import com.helpshift.conversation.activeconversation.message.AcceptedAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminActionCardMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminBotControlMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminMessageDM;
import com.helpshift.conversation.activeconversation.message.AdminMessageWithOptionInputDM;
import com.helpshift.conversation.activeconversation.message.AdminMessageWithTextInputDM;
import com.helpshift.conversation.activeconversation.message.Author;
import com.helpshift.conversation.activeconversation.message.ConfirmationAcceptedMessageDM;
import com.helpshift.conversation.activeconversation.message.ConfirmationRejectedMessageDM;
import com.helpshift.conversation.activeconversation.message.FAQListMessageDM;
import com.helpshift.conversation.activeconversation.message.FAQListMessageWithOptionInputDM;
import com.helpshift.conversation.activeconversation.message.FollowupAcceptedMessageDM;
import com.helpshift.conversation.activeconversation.message.FollowupRejectedMessageDM;
import com.helpshift.conversation.activeconversation.message.MessageDM;
import com.helpshift.conversation.activeconversation.message.MessageType;
import com.helpshift.conversation.activeconversation.message.RequestAppReviewMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestForReopenMessageDM;
import com.helpshift.conversation.activeconversation.message.RequestScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.ScreenshotMessageDM;
import com.helpshift.conversation.activeconversation.message.UnsupportedAdminMessageWithInputDM;
import com.helpshift.conversation.activeconversation.message.UserAttachmentMessageDM;
import com.helpshift.conversation.activeconversation.message.UserBotControlMessageDM;
import com.helpshift.conversation.activeconversation.message.UserMessageDM;
import com.helpshift.conversation.activeconversation.message.UserResponseMessageForOptionInput;
import com.helpshift.conversation.activeconversation.message.UserResponseMessageForTextInputDM;
import com.helpshift.conversation.activeconversation.message.UserSmartIntentMessageDM;
import com.helpshift.conversation.activeconversation.message.input.OptionInput;
import com.helpshift.conversation.activeconversation.model.Action;
import com.helpshift.conversation.activeconversation.model.ActionCard;
import com.helpshift.conversation.activeconversation.model.ActionType;
import com.helpshift.conversation.activeconversation.model.Conversation;
import com.helpshift.conversation.dto.ConversationHistory;
import com.helpshift.conversation.dto.ConversationInbox;
import com.helpshift.conversation.dto.IssueState;
import com.helpshift.conversation.dto.WSPingMessage;
import com.helpshift.conversation.dto.WSTypingActionMessage;
import com.helpshift.conversation.dto.WebSocketMessage;
import com.helpshift.conversation.smartintent.dto.SISearchModelDTO;
import com.helpshift.conversation.smartintent.dto.SITreeDTO;
import com.helpshift.conversation.smartintent.dto.SmartIntentDTO;
import com.helpshift.conversation.states.ConversationCSATState;
import com.helpshift.db.conversation.tables.ActionCardTable;
import com.helpshift.db.conversation.tables.ActionTable;
import com.helpshift.db.conversation.tables.ConversationTable;
import com.helpshift.db.conversation.tables.MessagesTable;
import com.helpshift.db.smartintents.tables.SmartIntentModelsTable;
import com.helpshift.db.smartintents.tables.SmartIntentTreeTable;
import com.helpshift.db.user.tables.UserTable;
import com.helpshift.faq.FaqCore;
import com.helpshift.logger.constants.LogLevel;
import com.helpshift.util.HSJSONUtils;
import com.helpshift.util.HSLogger;
import com.tencent.grobot.lite.GameParameters;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.imsdk.android.IR;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class AndroidResponseParser implements ResponseParser {
    private static final int AVATAR_IMAGE_CACHE_DEFAULT_INTERVAL = 14400000;
    private static final int OPTIONS_MAX_LIMIT = 500;
    private static final long SMART_INTENT_CLIENT_CACHE_DEFAULT_INTERVAL = 259200000;
    private static final long SMART_INTENT_REFRESH_DEFAULT_INTERVAL = 600000;
    private static final String TAG = "Helpshift_AResponseParser";

    @Override // com.helpshift.common.platform.network.ResponseParser
    public UserMessageDM parseReadableUserMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("created_at");
            UserMessageDM userMessageDM = new UserMessageDM(jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), true));
            userMessageDM.serverId = jSONObject.getString("id");
            userMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            userMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(userMessageDM, jSONObject);
            return userMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading user text message");
        }
    }

    @Override // com.helpshift.common.platform.network.ResponseParser
    public UserResponseMessageForTextInputDM parseResponseMessageForTextInput(String str) {
        boolean z;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            char c = 65535;
            int i = 3;
            switch (string.hashCode()) {
                case -831290677:
                    if (string.equals("rsp_txt_msg_with_email_input")) {
                        c = 2;
                        break;
                    }
                    break;
                case -94670724:
                    if (string.equals("rsp_txt_msg_with_numeric_input")) {
                        c = 3;
                        break;
                    }
                    break;
                case 493654943:
                    if (string.equals("rsp_txt_msg_with_txt_input")) {
                        c = 1;
                        break;
                    }
                    break;
                case 919037346:
                    if (string.equals("rsp_empty_msg_with_txt_input")) {
                        c = 0;
                        break;
                    }
                    break;
                case 2071762039:
                    if (string.equals("rsp_txt_msg_with_dt_input")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    i = 1;
                    z = true;
                    break;
                case 1:
                    i = 1;
                    z = false;
                    break;
                case 2:
                    i = 2;
                    z = false;
                    break;
                case 3:
                    z = false;
                    break;
                case 4:
                    i = 4;
                    z = false;
                    break;
                default:
                    return null;
            }
            boolean z2 = !z && jSONObject.getBoolean("skipped");
            JSONObject jSONObject2 = jSONObject.getJSONObject("meta");
            String string2 = jSONObject.getString("created_at");
            UserResponseMessageForTextInputDM userResponseMessageForTextInputDM = new UserResponseMessageForTextInputDM(jSONObject.getString("body"), string2, HSDateFormatSpec.convertToEpochTime(string2), parseMessageAuthor(jSONObject.getJSONObject("author"), true), i, jSONObject.getJSONObject("chatbot_info").toString(), z2, jSONObject2.getString("refers"), z);
            if (i == 4 && !z2) {
                userResponseMessageForTextInputDM.dateInMillis = jSONObject2.getLong("dt");
                userResponseMessageForTextInputDM.timeZoneId = jSONObject2.optString("timezone");
            }
            userResponseMessageForTextInputDM.serverId = jSONObject.getString("id");
            userResponseMessageForTextInputDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(userResponseMessageForTextInputDM, jSONObject);
            return userResponseMessageForTextInputDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading user response for text input");
        }
    }

    @Override // com.helpshift.common.platform.network.ResponseParser
    public ScreenshotMessageDM parseScreenshotMessageDM(String str) {
        try {
            return parseScreenshotMessageDM(new JSONObject(str));
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading user screenshot message");
        }
    }

    @Override // com.helpshift.common.platform.network.ResponseParser
    public UserAttachmentMessageDM parseUserAttachmentMessageDM(String str) {
        try {
            return parseUserAttachmentMessageDM(new JSONObject(str));
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading user attachment message");
        }
    }

    @Override // com.helpshift.common.platform.network.ResponseParser
    public AcceptedAppReviewMessageDM parseAcceptedAppReviewMessageDM(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("created_at");
            AcceptedAppReviewMessageDM acceptedAppReviewMessageDM = new AcceptedAppReviewMessageDM(jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), true), jSONObject.getJSONObject("meta").getString("refers"), 2);
            acceptedAppReviewMessageDM.serverId = jSONObject.getString("id");
            acceptedAppReviewMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            acceptedAppReviewMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(acceptedAppReviewMessageDM, jSONObject);
            return acceptedAppReviewMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading accepted review message");
        }
    }

    @Override // com.helpshift.common.platform.network.ResponseParser
    public ConfirmationAcceptedMessageDM parseConfirmationAcceptedMessageDM(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("created_at");
            ConfirmationAcceptedMessageDM confirmationAcceptedMessageDM = new ConfirmationAcceptedMessageDM(jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), true), 2);
            confirmationAcceptedMessageDM.serverId = jSONObject.getString("id");
            confirmationAcceptedMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            confirmationAcceptedMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(confirmationAcceptedMessageDM, jSONObject);
            return confirmationAcceptedMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading confirmation accepted message");
        }
    }

    @Override // com.helpshift.common.platform.network.ResponseParser
    public ConfirmationRejectedMessageDM parseConfirmationRejectedMessageDM(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("created_at");
            ConfirmationRejectedMessageDM confirmationRejectedMessageDM = new ConfirmationRejectedMessageDM(jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), false), 2);
            confirmationRejectedMessageDM.serverId = jSONObject.getString("id");
            confirmationRejectedMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            confirmationRejectedMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(confirmationRejectedMessageDM, jSONObject);
            return confirmationRejectedMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading confirmation rejected message");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.common.platform.network.ResponseParser
    public ConversationInbox parseConversationInbox(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(ConversationTable.TABLE_NAME);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(parseReadableConversation(jSONArray.getJSONObject(i).toString()));
            }
            return new ConversationInbox(jSONObject.getString("cursor"), arrayList, jSONObject.getBoolean(UserTable.Columns.ISSUE_EXISTS), jSONObject.has("has_older_messages") ? Boolean.valueOf(jSONObject.getBoolean("has_older_messages")) : null);
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading conversation inbox");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.common.platform.network.ResponseParser
    public ConversationHistory parseConversationHistory(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(ConversationTable.TABLE_NAME);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(parseReadableConversation(jSONArray.getJSONObject(i).toString()));
            }
            return new ConversationHistory(arrayList, jSONObject.getBoolean("has_older_messages"));
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading conversation history");
        }
    }

    @Override // com.helpshift.common.platform.network.ResponseParser
    public FollowupRejectedMessageDM parseFollowupRejectedMessage(String str) {
        try {
            return parseFollowupRejectedMessageDM(new JSONObject(str));
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading follow-up rejected message");
        }
    }

    @Override // com.helpshift.common.platform.network.ResponseParser
    public FollowupAcceptedMessageDM parseFollowupAcceptedMessage(String str) {
        try {
            return parseFollowupAcceptedMessageDM(new JSONObject(str));
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading follow-up accepted message");
        }
    }

    @Override // com.helpshift.common.platform.network.ResponseParser
    public WebSocketAuthData parseAuthToken(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new WebSocketAuthData(jSONObject.getString("token"), jSONObject.getString("endpoint"));
        } catch (JSONException e) {
            HSLogger.e(TAG, "Exception in parsing auth token", e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    @Override // com.helpshift.common.platform.network.ResponseParser
    public WebSocketMessage parseWebSocketMessage(String str) {
        WSTypingActionMessage wSTypingActionMessage;
        WebSocketMessage webSocketMessage;
        WSTypingActionMessage wSTypingActionMessage2 = null;
        wSTypingActionMessage2 = null;
        wSTypingActionMessage2 = null;
        try {
            JSONArray jSONArray = new JSONArray(str);
            int i = jSONArray.getInt(0);
            if (i != 100) {
                webSocketMessage = i != 107 ? null : new WSPingMessage(TimeUnit.SECONDS.toMillis(jSONArray.getLong(1)));
            } else {
                JSONArray jSONArray2 = jSONArray.getJSONArray(2);
                wSTypingActionMessage = null;
                ?? r0 = 0;
                while (r0 < jSONArray2.length()) {
                    try {
                        JSONObject jSONObject = new JSONObject(jSONArray2.getJSONObject(r0 == true ? 1 : 0).getString("m"));
                        if ("agent_type_activity".equals(jSONObject.getString("stream"))) {
                            String string = jSONObject.getString("action");
                            if ("start".equals(string)) {
                                wSTypingActionMessage = new WSTypingActionMessage(true, TimeUnit.SECONDS.toMillis(jSONObject.getLong("ttl")));
                            } else if ("stop".equals(string)) {
                                wSTypingActionMessage = new WSTypingActionMessage(false, 0L);
                            }
                        }
                        r0 = (r0 == true ? 1 : 0) + 1;
                    } catch (JSONException e) {
                        e = e;
                        HSLogger.e(TAG, "Exception in parsing web-socket message", e);
                        return wSTypingActionMessage;
                    }
                }
                webSocketMessage = wSTypingActionMessage;
                wSTypingActionMessage2 = r0;
            }
            return webSocketMessage;
        } catch (JSONException e2) {
            e = e2;
            wSTypingActionMessage = wSTypingActionMessage2;
        }
    }

    private boolean parseDisableHelpshiftBrandingValue(JSONObject jSONObject) {
        if (jSONObject != null) {
            return !jSONObject.optBoolean("hl", true);
        }
        return false;
    }

    private List<MessageDM> parseMessageDMs(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("type");
                String string2 = jSONObject.getString("origin");
                if ("admin".equals(string2)) {
                    parseAdminMessage(string, jSONObject, arrayList);
                } else if (GameParameters.SOURCE_MOBILE.equals(string2)) {
                    parseMobileMessage(string, jSONObject, arrayList);
                } else {
                    HSLogger.e(TAG, "Unknown message type received.");
                }
            } catch (RootAPIException | JSONException e) {
                HSLogger.e(TAG, "Exception while parsing messages: ", e);
            }
        }
        return arrayList;
    }

    private void parseAdminMessage(String str, JSONObject jSONObject, List<MessageDM> list) {
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1052767485:
                    if (str.equals("faq_list_msg_with_option_input")) {
                        c = 11;
                        break;
                    }
                    break;
                case -185416997:
                    if (str.equals("txt_msg_with_email_input")) {
                        c = 2;
                        break;
                    }
                    break;
                case 112675:
                    if (str.equals("rar")) {
                        c = 7;
                        break;
                    }
                    break;
                case 112830:
                    if (str.equals("rfr")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 113218:
                    if (str.equals("rsc")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 115312:
                    if (str.equals("txt")) {
                        c = 0;
                        break;
                    }
                    break;
                case 61080689:
                    if (str.equals("txt_msg_with_actions")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 133418599:
                    if (str.equals("txt_msg_with_dt_input")) {
                        c = 4;
                        break;
                    }
                    break;
                case 373335180:
                    if (str.equals("txt_msg_with_option_input")) {
                        c = 6;
                        break;
                    }
                    break;
                case 534550447:
                    if (str.equals("txt_msg_with_txt_input")) {
                        c = 1;
                        break;
                    }
                    break;
                case 892689447:
                    if (str.equals("faq_list")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 903982601:
                    if (str.equals(BotControlActions.BOT_STARTED)) {
                        c = '\r';
                        break;
                    }
                    break;
                case 1564911026:
                    if (str.equals("empty_msg_with_txt_input")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1829173826:
                    if (str.equals(BotControlActions.BOT_ENDED)) {
                        c = 14;
                        break;
                    }
                    break;
                case 2114645132:
                    if (str.equals("txt_msg_with_numeric_input")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    list.addAll(parseAdminMessageDM(jSONObject));
                    return;
                case 1:
                    list.addAll(parseAdminMessageWithTextInputDM(jSONObject, 1));
                    return;
                case 2:
                    list.addAll(parseAdminMessageWithTextInputDM(jSONObject, 2));
                    return;
                case 3:
                    list.addAll(parseAdminMessageWithTextInputDM(jSONObject, 3));
                    return;
                case 4:
                    list.addAll(parseAdminMessageWithTextInputDM(jSONObject, 4));
                    return;
                case 5:
                    list.add(parseAdminEmptyMessageWithTextInputDM(jSONObject));
                    return;
                case 6:
                    list.addAll(parseAdminMessageWithOptionInputDM(jSONObject));
                    return;
                case 7:
                    list.add(parseRequestAppReviewMessageDM(jSONObject));
                    return;
                case '\b':
                    list.addAll(parseRequestScreenshotMessageDM(jSONObject));
                    return;
                case '\t':
                    list.add(parseRequestForReopenMessageDM(jSONObject));
                    return;
                case '\n':
                    list.add(parseFAQListMessageDM(jSONObject));
                    return;
                case 11:
                    list.add(parseFAQListMessageWitOptionInputDM(jSONObject));
                    return;
                case '\f':
                    list.addAll(parseAdminMessageWithActionCardMessageDM(jSONObject));
                    return;
                case '\r':
                case 14:
                    list.add(parseBotControlMessage(jSONObject.toString(), true));
                    return;
                default:
                    if (jSONObject.has(EvaluateItemInfo.ACTIONTYPE_INPUT)) {
                        list.add(parseUnsupportedAdminMessageWithInput(jSONObject.toString()));
                        return;
                    }
                    return;
            }
        } catch (RootAPIException e) {
            HSLogger.e(TAG, "Exception while parsing messages: ", e);
        }
    }

    private void parseMobileMessage(String str, JSONObject jSONObject, List<MessageDM> list) {
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -831290677:
                    if (str.equals("rsp_txt_msg_with_email_input")) {
                        c = 11;
                        break;
                    }
                    break;
                case -657647885:
                    if (str.equals("rsp_faq_list_msg_with_option_input")) {
                        c = 15;
                        break;
                    }
                    break;
                case -545696551:
                    if (str.equals(BotControlActions.BOT_CANCELLED)) {
                        c = 16;
                        break;
                    }
                    break;
                case -94670724:
                    if (str.equals("rsp_txt_msg_with_numeric_input")) {
                        c = '\f';
                        break;
                    }
                    break;
                case 3121:
                    if (str.equals("ar")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3123:
                    if (str.equals("at")) {
                        c = 5;
                        break;
                    }
                    break;
                case 3166:
                    if (str.equals("ca")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3631:
                    if (str.equals("ra")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3640:
                    if (str.equals("rj")) {
                        c = 7;
                        break;
                    }
                    break;
                case 3664:
                    if (str.equals("sc")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3670:
                    if (str.equals("si")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 108893:
                    if (str.equals("ncr")) {
                        c = 2;
                        break;
                    }
                    break;
                case 115312:
                    if (str.equals("txt")) {
                        c = 0;
                        break;
                    }
                    break;
                case 493654943:
                    if (str.equals("rsp_txt_msg_with_txt_input")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 919037346:
                    if (str.equals("rsp_empty_msg_with_txt_input")) {
                        c = '\t';
                        break;
                    }
                    break;
                case 1826087580:
                    if (str.equals("rsp_txt_msg_with_option_input")) {
                        c = 14;
                        break;
                    }
                    break;
                case 2071762039:
                    if (str.equals("rsp_txt_msg_with_dt_input")) {
                        c = '\r';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    list.add(parseReadableUserMessage(jSONObject.toString()));
                    return;
                case 1:
                    list.add(parseAcceptedAppReviewMessageDM(jSONObject.toString()));
                    return;
                case 2:
                    list.add(parseConfirmationRejectedMessageDM(jSONObject.toString()));
                    return;
                case 3:
                    list.add(parseConfirmationAcceptedMessageDM(jSONObject.toString()));
                    return;
                case 4:
                    list.add(parseScreenshotMessageDM(jSONObject));
                    return;
                case 5:
                    list.add(parseUserAttachmentMessageDM(jSONObject));
                    return;
                case 6:
                    list.add(parseFollowupAcceptedMessageDM(jSONObject));
                    return;
                case 7:
                    list.add(parseFollowupRejectedMessageDM(jSONObject));
                    return;
                case '\b':
                    list.add(parseUserSmartIntentMessage(jSONObject.toString()));
                    return;
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                    list.add(parseResponseMessageForTextInput(jSONObject.toString()));
                    return;
                case 14:
                case 15:
                    list.add(parseResponseMessageForOptionInput(jSONObject.toString()));
                    return;
                case 16:
                    list.add(parseBotControlMessage(jSONObject.toString(), false));
                    return;
                default:
                    return;
            }
        } catch (RootAPIException e) {
            HSLogger.e(TAG, "Exception while parsing messages: ", e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.helpshift.common.platform.AndroidResponseParser] */
    public MessageDM parseUserSmartIntentMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("created_at");
            JSONArray optJSONArray = jSONObject.optJSONArray("intent_labels");
            UserSmartIntentMessageDM userSmartIntentMessageDM = new UserSmartIntentMessageDM(optJSONArray != null ? HSJSONUtils.convertJSONArrayToStringList(optJSONArray) : new ArrayList(), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), true));
            userSmartIntentMessageDM.serverId = jSONObject.getString("id");
            userSmartIntentMessageDM.body = jSONObject.getString("body");
            userSmartIntentMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            userSmartIntentMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(userSmartIntentMessageDM, jSONObject);
            return userSmartIntentMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading user smart intent message");
        }
    }

    @Override // com.helpshift.common.platform.network.ResponseParser
    public MessageDM parseBotControlMessage(String str, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            String string2 = jSONObject.getString("id");
            String jSONObject2 = jSONObject.getJSONObject("chatbot_info").toString();
            boolean optBoolean = jSONObject.optBoolean("redacted", false);
            String string3 = jSONObject.getString("created_at");
            long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(string3);
            if (z) {
                AdminBotControlMessageDM adminBotControlMessageDM = new AdminBotControlMessageDM(string2, jSONObject.getString("body"), string3, convertToEpochTime, parseMessageAuthor(jSONObject.getJSONObject("author"), false), string, jSONObject2);
                adminBotControlMessageDM.hasNextBot = jSONObject.optBoolean("has_next_bot", false);
                adminBotControlMessageDM.isRedacted = optBoolean;
                return adminBotControlMessageDM;
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("meta");
            UserBotControlMessageDM userBotControlMessageDM = new UserBotControlMessageDM(jSONObject.getString("body"), string3, convertToEpochTime, parseMessageAuthor(jSONObject.getJSONObject("author"), true), string, jSONObject3.getString("chatbot_cancelled_reason"), jSONObject2, jSONObject3.getString("refers"), 2);
            userBotControlMessageDM.serverId = string2;
            userBotControlMessageDM.isRedacted = optBoolean;
            parseAndSetDataForUserSentMessages(userBotControlMessageDM, jSONObject);
            return userBotControlMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading bot control messages.");
        }
    }

    private List<FAQListMessageDM.FAQ> parseFAQList(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            arrayList.add(new FAQListMessageDM.FAQ(jSONObject.getString("title"), jSONObject2.getString("publish_id"), jSONObject2.getString("language")));
        }
        return arrayList;
    }

    private MessageDM parseFAQListMessageWitOptionInputDM(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(EvaluateItemInfo.ACTIONTYPE_INPUT);
            String string = jSONObject.getString("created_at");
            FAQListMessageWithOptionInputDM fAQListMessageWithOptionInputDM = new FAQListMessageWithOptionInputDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), false), parseFAQList(jSONObject.getJSONArray("faqs")), jSONObject.optString("faq_source"), jSONObject.getJSONObject("chatbot_info").toString(), jSONObject2.getBoolean("required"), jSONObject2.getString("label"), jSONObject2.optString("skip_label"), parseOptions(jSONObject2));
            fAQListMessageWithOptionInputDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            fAQListMessageWithOptionInputDM.isRedacted = jSONObject.optBoolean("redacted", false);
            return fAQListMessageWithOptionInputDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading list message with option input");
        }
    }

    private FAQListMessageDM parseFAQListMessageDM(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("created_at");
            FAQListMessageDM fAQListMessageDM = new FAQListMessageDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), false), parseFAQList(jSONObject.getJSONArray("faqs")), jSONObject.optString("faq_source"));
            fAQListMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            fAQListMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            return fAQListMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading faq list message");
        }
    }

    private FollowupRejectedMessageDM parseFollowupRejectedMessageDM(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("created_at");
            FollowupRejectedMessageDM followupRejectedMessageDM = new FollowupRejectedMessageDM(jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), true), jSONObject.getJSONObject("meta").getString("refers"), 2);
            followupRejectedMessageDM.serverId = jSONObject.getString("id");
            followupRejectedMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            followupRejectedMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(followupRejectedMessageDM, jSONObject);
            return followupRejectedMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading follow-up rejected message");
        }
    }

    private FollowupAcceptedMessageDM parseFollowupAcceptedMessageDM(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("created_at");
            FollowupAcceptedMessageDM followupAcceptedMessageDM = new FollowupAcceptedMessageDM(jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), true), jSONObject.getJSONObject("meta").getString("refers"), 2);
            followupAcceptedMessageDM.serverId = jSONObject.getString("id");
            followupAcceptedMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            followupAcceptedMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(followupAcceptedMessageDM, jSONObject);
            return followupAcceptedMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading follow-up accepted message");
        }
    }

    private RequestForReopenMessageDM parseRequestForReopenMessageDM(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("created_at");
            RequestForReopenMessageDM requestForReopenMessageDM = new RequestForReopenMessageDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), false));
            requestForReopenMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            requestForReopenMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            return requestForReopenMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading reopen message");
        }
    }

    private List<OptionInput.Option> parseOptions(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        int min = Math.min(jSONArray.length(), 500);
        for (int i = 0; i < min; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            arrayList.add(new OptionInput.Option(jSONObject2.getString("title"), jSONObject2.getJSONObject("data").toString()));
        }
        return arrayList;
    }

    private OptionInput.Type parseOptionType(JSONObject jSONObject) throws JSONException {
        return OptionInput.Type.getType(jSONObject.optString("type"), jSONObject.getJSONArray(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS).length());
    }

    private List<MessageDM> parseAdminMessageWithOptionInputDM(JSONObject jSONObject) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject2 = jSONObject.getJSONObject(EvaluateItemInfo.ACTIONTYPE_INPUT);
            String string = jSONObject.getString("created_at");
            AdminMessageWithOptionInputDM adminMessageWithOptionInputDM = new AdminMessageWithOptionInputDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), false), jSONObject.getJSONObject("chatbot_info").toString(), jSONObject2.getBoolean("required"), jSONObject2.getString("label"), jSONObject2.optString("skip_label"), parseOptions(jSONObject2), parseOptionType(jSONObject2));
            adminMessageWithOptionInputDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            adminMessageWithOptionInputDM.isRedacted = jSONObject.optBoolean("redacted", false);
            List<MessageDM> parseAdminAttachmentEntities = parseAdminAttachmentEntities(jSONObject);
            adminMessageWithOptionInputDM.attachmentCount = parseAdminAttachmentEntities.size();
            arrayList.add(adminMessageWithOptionInputDM);
            arrayList.addAll(parseAdminAttachmentEntities);
            return arrayList;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading admin text message with option input");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.common.platform.network.ResponseParser
    public UserResponseMessageForOptionInput parseResponseMessageForOptionInput(String str) {
        MessageType messageType;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            char c = 65535;
            int hashCode = string.hashCode();
            if (hashCode != -657647885) {
                if (hashCode == 1826087580 && string.equals("rsp_txt_msg_with_option_input")) {
                    c = 0;
                }
            } else if (string.equals("rsp_faq_list_msg_with_option_input")) {
                c = 1;
            }
            switch (c) {
                case 0:
                    messageType = MessageType.ADMIN_TEXT_WITH_OPTION_INPUT;
                    break;
                case 1:
                    messageType = MessageType.FAQ_LIST_WITH_OPTION_INPUT;
                    break;
                default:
                    return null;
            }
            boolean z = jSONObject.getBoolean("skipped");
            String jSONObject2 = z ? "{}" : jSONObject.getJSONObject("option_data").toString();
            String string2 = jSONObject.getString("created_at");
            UserResponseMessageForOptionInput userResponseMessageForOptionInput = new UserResponseMessageForOptionInput(jSONObject.getString("body"), string2, HSDateFormatSpec.convertToEpochTime(string2), parseMessageAuthor(jSONObject.getJSONObject("author"), true), jSONObject.getJSONObject("chatbot_info").toString(), z, jSONObject2, jSONObject.getJSONObject("meta").getString("refers"), messageType);
            userResponseMessageForOptionInput.serverId = jSONObject.getString("id");
            userResponseMessageForOptionInput.isRedacted = jSONObject.optBoolean("redacted", false);
            parseAndSetDataForUserSentMessages(userResponseMessageForOptionInput, jSONObject);
            return userResponseMessageForOptionInput;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading user response for option input");
        }
    }

    private AdminMessageWithTextInputDM parseAdminEmptyMessageWithTextInputDM(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(EvaluateItemInfo.ACTIONTYPE_INPUT);
            String string = jSONObject.getString("created_at");
            AdminMessageWithTextInputDM adminMessageWithTextInputDM = new AdminMessageWithTextInputDM(jSONObject.getString("id"), "", string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), false), jSONObject.getJSONObject("chatbot_info").toString(), jSONObject2.getString("placeholder"), jSONObject2.getBoolean("required"), jSONObject2.getString("label"), jSONObject2.optString("skip_label"), 1, true);
            adminMessageWithTextInputDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            adminMessageWithTextInputDM.isRedacted = jSONObject.optBoolean("redacted", false);
            return adminMessageWithTextInputDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading admin empty message with text input");
        }
    }

    private List<MessageDM> parseAdminMessageWithTextInputDM(JSONObject jSONObject, int i) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject2 = jSONObject.getJSONObject(EvaluateItemInfo.ACTIONTYPE_INPUT);
            String string = jSONObject.getString("created_at");
            AdminMessageWithTextInputDM adminMessageWithTextInputDM = new AdminMessageWithTextInputDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), false), jSONObject.getJSONObject("chatbot_info").toString(), jSONObject2.getString("placeholder"), jSONObject2.getBoolean("required"), jSONObject2.getString("label"), jSONObject2.optString("skip_label"), i, false);
            adminMessageWithTextInputDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            adminMessageWithTextInputDM.isRedacted = jSONObject.optBoolean("redacted", false);
            arrayList.add(adminMessageWithTextInputDM);
            arrayList.addAll(parseAdminAttachmentEntities(jSONObject));
            return arrayList;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading admin message with text input");
        }
    }

    private List<MessageDM> parseAdminMessageDM(JSONObject jSONObject) {
        try {
            ArrayList arrayList = new ArrayList();
            String string = jSONObject.getString("created_at");
            AdminMessageDM adminMessageDM = new AdminMessageDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), false));
            adminMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            adminMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            arrayList.add(adminMessageDM);
            arrayList.addAll(parseAdminAttachmentEntities(jSONObject));
            return arrayList;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading admin text message");
        }
    }

    private List<MessageDM> parseAdminMessageWithActionCardMessageDM(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            String string = jSONObject.getString("created_at");
            AdminMessageDM adminMessageDM = new AdminMessageDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), false));
            adminMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            adminMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            arrayList.add(adminMessageDM);
            arrayList.add(parseAdminActionCardMessageDM(jSONObject));
            return arrayList;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading admin action card message");
        }
    }

    private AdminActionCardMessageDM parseAdminActionCardMessageDM(JSONObject jSONObject) throws JSONException {
        String str = jSONObject.getString("id") + "_0";
        String addMilliSeconds = HSDateFormatSpec.addMilliSeconds(HSDateFormatSpec.STORAGE_TIME_FORMAT, jSONObject.getString("created_at"), 1);
        long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(addMilliSeconds);
        JSONObject jSONObject2 = jSONObject.getJSONArray(ActionCardTable.TABLE_NAME).getJSONObject(0);
        JSONObject jSONObject3 = jSONObject2.getJSONArray(ActionTable.TABLE_NAME).getJSONObject(0);
        AdminActionCardMessageDM adminActionCardMessageDM = new AdminActionCardMessageDM(str, jSONObject.getString("body"), addMilliSeconds, convertToEpochTime, parseMessageAuthor(jSONObject.getJSONObject("author"), false), jSONObject.getString("id"), new ActionCard(jSONObject2.optString("title"), jSONObject2.optString("image_url"), jSONObject2.optBoolean(ActionCardTable.Columns.IS_IMAGE_SECURE), new Action(jSONObject3.getString("display_text"), jSONObject3.getString("id"), ActionType.fromValue(jSONObject3.getString("type")), HSJSONUtils.toStringMap(jSONObject3.getJSONObject("data")))));
        adminActionCardMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
        adminActionCardMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
        return adminActionCardMessageDM;
    }

    private UnsupportedAdminMessageWithInputDM parseUnsupportedAdminMessageWithInput(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("created_at");
            return new UnsupportedAdminMessageWithInputDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), false), jSONObject.getString("type"), jSONObject.getJSONObject("chatbot_info").toString(), jSONObject.getJSONObject(EvaluateItemInfo.ACTIONTYPE_INPUT).toString());
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading unsupported admin message with input");
        }
    }

    @Override // com.helpshift.common.platform.network.ResponseParser
    public RootServerConfig parseConfigResponse(String str) {
        Long l;
        Long l2;
        Long l3;
        boolean z;
        String str2;
        String str3;
        boolean z2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            Long valueOf = jSONObject.has("last_redaction_at") ? Long.valueOf(jSONObject.getLong("last_redaction_at")) : null;
            Long valueOf2 = jSONObject.has("profile_created_at") ? Long.valueOf(jSONObject.getLong("profile_created_at")) : null;
            long optLong = jSONObject.optLong("pfi", 0L) / 1000;
            long optLong2 = jSONObject.optLong("pri", 0L) / 1000;
            boolean optBoolean = jSONObject.optBoolean("afp", false);
            if (jSONObject.has("si")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("si");
                boolean z3 = jSONObject2.getBoolean("enabled");
                Long valueOf3 = Long.valueOf(jSONObject2.optLong("tree_sla", SMART_INTENT_REFRESH_DEFAULT_INTERVAL));
                Long valueOf4 = Long.valueOf(jSONObject2.optLong("model_sla", SMART_INTENT_REFRESH_DEFAULT_INTERVAL));
                l3 = Long.valueOf(jSONObject2.optLong("cache_sla", SMART_INTENT_CLIENT_CACHE_DEFAULT_INTERVAL));
                z = z3;
                l2 = valueOf3;
                l = valueOf4;
            } else {
                l = null;
                l2 = null;
                l3 = null;
                z = false;
            }
            ArrayList<ArrayList<String>> nestedJsonArrayToNestedArrayList = HSJSONUtils.nestedJsonArrayToNestedArrayList(jSONObject.optString("wa", "[[\"*/*\"]]"));
            int optInt = jSONObject.optInt("ll", LogLevel.FATAL.getValue());
            if (jSONObject.has("hdr")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("hdr");
                boolean optBoolean2 = jSONObject3.optBoolean("sh", false);
                String optString = jSONObject3.optString("htxt", "");
                str3 = jSONObject3.optString("hurl", "");
                z2 = optBoolean2;
                str2 = optString;
            } else {
                str2 = "";
                str3 = "";
                z2 = false;
            }
            return new RootServerConfig(jSONObject.optBoolean("rne", false), jSONObject.optBoolean("pfe", true), jSONObject.optBoolean("csat", false), jSONObject.optBoolean("dia", false), parseDisableHelpshiftBrandingValue(jSONObject.optJSONObject("t")), jSONObject.optBoolean(UserTable.Columns.ISSUE_EXISTS, true), jSONObject.optInt("dbgl", 100), jSONObject.optInt("bcl", 100), jSONObject.optString("rurl", ""), parsePeriodicReview(jSONObject.getJSONObject("pr")), jSONObject.optBoolean(IR.path.DOCS_IMSDK_CODE, false), jSONObject.optString("gm", ""), jSONObject.optBoolean("tyi", true), jSONObject.optBoolean("rq", false), jSONObject.optBoolean("conversation_history_enabled", false), valueOf, valueOf2, jSONObject.optBoolean("allow_user_attachments", true), optLong, optLong2, optBoolean, z, l, l2, l3, nestedJsonArrayToNestedArrayList, optInt, z2, str2, str3, jSONObject.has("avtr") ? parseAvatarKeys(jSONObject.getJSONObject("avtr")) : null, jSONObject.optBoolean("asae", true), jSONObject.optLong("pasi", 0L));
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while fetching config");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.common.platform.network.ResponseParser
    public Conversation parseReadableConversation(String str) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                List<MessageDM> parseMessageDMs = parseMessageDMs(jSONObject.getJSONArray(MessagesTable.TABLE_NAME));
                int size = parseMessageDMs.size() - 1;
                while (true) {
                    if (size < 0) {
                        str2 = null;
                        break;
                    }
                    MessageDM messageDM = parseMessageDMs.get(size);
                    if (!(messageDM instanceof AdminAttachmentMessageDM) && !(messageDM instanceof AdminImageAttachmentMessageDM)) {
                        str2 = messageDM.getCreatedAt();
                        break;
                    }
                    size--;
                }
                IssueState fromInt = IssueState.fromInt(jSONObject.getInt("state"));
                String string = jSONObject.getString("created_at");
                long convertToEpochTime = HSDateFormatSpec.convertToEpochTime(string);
                String string2 = jSONObject.getString("type");
                Conversation conversation = new Conversation(jSONObject.optString("title", ""), fromInt, string, convertToEpochTime, jSONObject.getString(ConversationTable.Columns.UPDATED_AT), jSONObject.getString("publish_id"), str2, string2, jSONObject.isNull("acid") ? null : jSONObject.getString("acid"));
                conversation.isRedacted = jSONObject.optBoolean("redacted", false);
                conversation.serverId = jSONObject.isNull(AnalyticsEventKey.ISSUE_ID) ? null : jSONObject.getString(AnalyticsEventKey.ISSUE_ID);
                conversation.preConversationServerId = jSONObject.isNull(AnalyticsEventKey.PREISSUE_ID) ? null : jSONObject.getString(AnalyticsEventKey.PREISSUE_ID);
                conversation.issueType = string2;
                conversation.createdRequestId = jSONObject.optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
                conversation.smartIntentIds = jSONObject.isNull(SDKConstants.PARAM_INTENT) ? null : HSJSONUtils.jsonArrayToStringArrayList(jSONObject.getString(SDKConstants.PARAM_INTENT));
                if (IssueType.ISSUE.equals(string2)) {
                    conversation.csatState = jSONObject.optBoolean("csat_received") ? ConversationCSATState.SUBMITTED_SYNCED : ConversationCSATState.NONE;
                }
                if (jSONObject.has("resolution_question_expiry_at")) {
                    conversation.resolutionExpiryAt = Long.valueOf(jSONObject.getLong("resolution_question_expiry_at"));
                }
                if (jSONObject.has(ConversationTable.Columns.CSAT_EXPIRY_AT)) {
                    conversation.csatExpiryAt = Long.valueOf(jSONObject.getLong(ConversationTable.Columns.CSAT_EXPIRY_AT));
                }
                conversation.setMessageDMs(parseMessageDMs);
                return conversation;
            } catch (JSONException e) {
                e = e;
                throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception in reading conversation");
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    @Override // com.helpshift.common.platform.network.ResponseParser
    public FaqCore parseSingleFAQ(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new FaqCore(jSONObject.getString("id"), jSONObject.getString("publish_id"), jSONObject.getString("language"), jSONObject.getString("section_id"), jSONObject.getString("title"), jSONObject.getString("body"), 0, Boolean.valueOf(jSONObject.getString("is_rtl").equals(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)), jSONObject.has("stags") ? HSJSONUtils.jsonArrayToStringArrayList(jSONObject.getString("stags")) : new ArrayList<>(), jSONObject.has("issue_tags") ? HSJSONUtils.jsonArrayToStringArrayList(jSONObject.getString("issue_tags")) : new ArrayList<>());
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading single faq");
        }
    }

    private List<SmartIntentDTO> parseSmartIntents(String str, JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length == 0) {
            return arrayList;
        }
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String string = jSONObject.getString("id");
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            List<SmartIntentDTO> list = null;
            if (optJSONArray != null) {
                list = parseSmartIntents(string, optJSONArray);
            }
            arrayList.add(new SmartIntentDTO(jSONObject.getString("label"), string, str, list));
        }
        return arrayList;
    }

    @Override // com.helpshift.common.platform.network.ResponseParser
    public SITreeDTO parseSmartIntentTree(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            List<SmartIntentDTO> parseSmartIntents = parseSmartIntents(null, jSONObject.getJSONArray("tree"));
            int i = jSONObject.getInt("version");
            JSONObject jSONObject2 = jSONObject.getJSONObject("translations");
            return new SITreeDTO(jSONObject.getString("id"), i, jSONObject2.getString(SmartIntentTreeTable.Columns.SI_TREE_PROMPT_TITLE), jSONObject2.getString("typing_hint"), jSONObject2.getString(SmartIntentTreeTable.Columns.SI_TREE_SEARCH_TITLE), jSONObject2.getString(SmartIntentTreeTable.Columns.SI_TREE_EMPTY_SEARCH_TITLE), jSONObject2.getString("empty_search_desc"), jSONObject.getBoolean(AnalyticsEventKey.SMART_INTENT_ENFORCE_INTENT_SELECTION), HSJSONUtils.convertJSONArrayToStringList(jSONObject.getJSONArray("token_delimiters")), parseSmartIntents);
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading smart intent tree");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.common.platform.network.ResponseParser
    public SISearchModelDTO parseSmartIntentSearchModel(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("weights");
            JSONArray jSONArray = jSONObject.getJSONArray("intent_ids");
            int i = jSONObject.getInt("version");
            List<String> convertJSONArrayToStringList = HSJSONUtils.convertJSONArrayToStringList(jSONArray);
            List<Double> doubleListFromJSONArray = HSJSONUtils.getDoubleListFromJSONArray(jSONObject2.getJSONArray("label_base_probabilities"));
            if (convertJSONArrayToStringList.size() != doubleListFromJSONArray.size()) {
                throw new JSONException("Mismatch in LeafIntentIds and baseProbabilities list");
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("vocabulary");
            JSONArray jSONArray3 = jSONObject2.getJSONArray("word_label_probabilities");
            if (jSONArray2.length() != jSONArray3.length()) {
                throw new JSONException("Mismatch in vocabulary and wordLabelProbability array");
            }
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                hashMap.put(jSONArray2.getString(i2), HSJSONUtils.getDoubleListFromJSONArray(jSONArray3.getJSONArray(i2)));
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("parameters");
            return new SISearchModelDTO(Integer.valueOf(i), Double.valueOf(jSONObject3.getDouble(SmartIntentModelsTable.Columns.CONFIDENCE_THRESHOLD)), Double.valueOf(jSONObject3.getDouble(SmartIntentModelsTable.Columns.MAX_COMBINED_CONFIDENCE)), convertJSONArrayToStringList, doubleListFromJSONArray, hashMap);
        } catch (Exception e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading smart intent model");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c3 A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:3:0x0004, B:5:0x0012, B:7:0x001a, B:10:0x0022, B:11:0x0053, B:13:0x0059, B:15:0x0085, B:16:0x008e, B:18:0x00ae, B:22:0x00bb, B:24:0x00c3, B:25:0x00f4, B:27:0x00df), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00df A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:3:0x0004, B:5:0x0012, B:7:0x001a, B:10:0x0022, B:11:0x0053, B:13:0x0059, B:15:0x0085, B:16:0x008e, B:18:0x00ae, B:22:0x00bb, B:24:0x00c3, B:25:0x00f4, B:27:0x00df), top: B:2:0x0004 }] */
    /* JADX WARN: Type inference failed for: r25v1, types: [com.helpshift.conversation.activeconversation.message.AdminImageAttachmentMessageDM] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.helpshift.conversation.activeconversation.message.MessageDM> parseAdminAttachmentEntities(org.json.JSONObject r28) {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.common.platform.AndroidResponseParser.parseAdminAttachmentEntities(org.json.JSONObject):java.util.List");
    }

    private RequestAppReviewMessageDM parseRequestAppReviewMessageDM(JSONObject jSONObject) {
        boolean z;
        try {
            JSONObject optJSONObject = jSONObject.getJSONObject("meta").optJSONObject(AnalyticsEventKey.RESPONSE);
            boolean optBoolean = optJSONObject != null ? optJSONObject.optBoolean("state") : false;
            if (!jSONObject.optBoolean("invisible") && !optBoolean) {
                z = false;
                String string = jSONObject.getString("created_at");
                RequestAppReviewMessageDM requestAppReviewMessageDM = new RequestAppReviewMessageDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), false), z);
                requestAppReviewMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
                requestAppReviewMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
                return requestAppReviewMessageDM;
            }
            z = true;
            String string2 = jSONObject.getString("created_at");
            RequestAppReviewMessageDM requestAppReviewMessageDM2 = new RequestAppReviewMessageDM(jSONObject.getString("id"), jSONObject.getString("body"), string2, HSDateFormatSpec.convertToEpochTime(string2), parseMessageAuthor(jSONObject.getJSONObject("author"), false), z);
            requestAppReviewMessageDM2.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            requestAppReviewMessageDM2.isRedacted = jSONObject.optBoolean("redacted", false);
            return requestAppReviewMessageDM2;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading request review message");
        }
    }

    private List<MessageDM> parseRequestScreenshotMessageDM(JSONObject jSONObject) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject optJSONObject = jSONObject.getJSONObject("meta").optJSONObject(AnalyticsEventKey.RESPONSE);
            boolean z = optJSONObject != null ? optJSONObject.getBoolean("state") : false;
            String string = jSONObject.getString("created_at");
            RequestScreenshotMessageDM requestScreenshotMessageDM = new RequestScreenshotMessageDM(jSONObject.getString("id"), jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), false), z);
            requestScreenshotMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            requestScreenshotMessageDM.isRedacted = jSONObject.optBoolean("redacted", false);
            arrayList.add(requestScreenshotMessageDM);
            arrayList.addAll(parseAdminAttachmentEntities(jSONObject));
            return arrayList;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading request screenshot message");
        }
    }

    private ScreenshotMessageDM parseScreenshotMessageDM(JSONObject jSONObject) {
        boolean z;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("meta").getJSONArray("attachments").getJSONObject(0);
            String string = jSONObject.getString("created_at");
            ScreenshotMessageDM screenshotMessageDM = new ScreenshotMessageDM(jSONObject2.has("body") ? jSONObject2.getString("body") : jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), true), jSONObject2.getString("content-type"), jSONObject2.optString("thumbnail", ""), jSONObject2.getString("file-name"), jSONObject2.getString("url"), jSONObject2.getInt("size"), jSONObject2.optBoolean("secure?", false));
            screenshotMessageDM.serverId = jSONObject.getString("id");
            screenshotMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            if (!jSONObject.optBoolean("redacted", false) && !jSONObject2.optBoolean("redacted", false)) {
                z = false;
                screenshotMessageDM.isRedacted = z;
                screenshotMessageDM.isZipped = jSONObject2.optBoolean("zipped", false);
                parseAndSetDataForUserSentMessages(screenshotMessageDM, jSONObject);
                return screenshotMessageDM;
            }
            z = true;
            screenshotMessageDM.isRedacted = z;
            screenshotMessageDM.isZipped = jSONObject2.optBoolean("zipped", false);
            parseAndSetDataForUserSentMessages(screenshotMessageDM, jSONObject);
            return screenshotMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading screenshot message");
        }
    }

    private UserAttachmentMessageDM parseUserAttachmentMessageDM(JSONObject jSONObject) {
        boolean z;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("meta").getJSONArray("attachments").getJSONObject(0);
            String string = jSONObject.getString("created_at");
            UserAttachmentMessageDM userAttachmentMessageDM = new UserAttachmentMessageDM(jSONObject2.has("body") ? jSONObject2.getString("body") : jSONObject.getString("body"), string, HSDateFormatSpec.convertToEpochTime(string), parseMessageAuthor(jSONObject.getJSONObject("author"), true), jSONObject2.getInt("size"), jSONObject2.getString("content-type"), jSONObject2.getString("url"), jSONObject2.getString("file-name"), jSONObject2.optBoolean("secure?", false));
            userAttachmentMessageDM.serverId = jSONObject.getString("id");
            userAttachmentMessageDM.deliveryState = convertDeliveryStateToInt(jSONObject.optString(MessagesTable.Columns.DELIVERY_STATE, ""));
            if (!jSONObject.optBoolean("redacted", false) && !jSONObject2.optBoolean("redacted", false)) {
                z = false;
                userAttachmentMessageDM.isRedacted = z;
                userAttachmentMessageDM.isZipped = jSONObject2.optBoolean("zipped", false);
                parseAndSetDataForUserSentMessages(userAttachmentMessageDM, jSONObject);
                return userAttachmentMessageDM;
            }
            z = true;
            userAttachmentMessageDM.isRedacted = z;
            userAttachmentMessageDM.isZipped = jSONObject2.optBoolean("zipped", false);
            parseAndSetDataForUserSentMessages(userAttachmentMessageDM, jSONObject);
            return userAttachmentMessageDM;
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading user attachment message");
        }
    }

    private PeriodicReview parsePeriodicReview(JSONObject jSONObject) throws JSONException {
        return new PeriodicReview(jSONObject.optBoolean(AnalyticsEventKey.SEARCH_QUERY), jSONObject.optInt("i"), jSONObject.optString("t", ""));
    }

    private AvatarConfig parseAvatarKeys(JSONObject jSONObject) throws JSONException {
        return new AvatarConfig(jSONObject.optBoolean("savtr", false), jSONObject.optBoolean("pagnt", false), jSONObject.optString("af", ""), jSONObject.optBoolean("pbot", false), jSONObject.optString("bf", ""), jSONObject.optString("snn", ""), jSONObject.optString("turl", ""), jSONObject.optInt("ce", AVATAR_IMAGE_CACHE_DEFAULT_INTERVAL));
    }

    private Author parseMessageAuthor(JSONObject jSONObject, boolean z) {
        Author.AuthorRole authorRole;
        try {
            if (z) {
                authorRole = Author.AuthorRole.LOCAL_USER;
            } else {
                authorRole = Author.AuthorRole.SYSTEM;
            }
            if (jSONObject.has("role")) {
                authorRole = Author.AuthorRole.getEnum(jSONObject.getString("role"));
            }
            return new Author(jSONObject.getString("name"), jSONObject.getString("id"), authorRole);
        } catch (JSONException e) {
            throw RootAPIException.wrap(e, ParseException.GENERIC, "Parsing exception while reading author of message");
        }
    }

    private int convertDeliveryStateToInt(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -840272977) {
            if (str.equals("unread")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 3496342) {
            if (hashCode == 3526552 && str.equals("sent")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("read")) {
                c = 1;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                return 0;
        }
    }

    private void parseAndSetDataForUserSentMessages(MessageDM messageDM, JSONObject jSONObject) throws JSONException {
        messageDM.author = parseMessageAuthor(jSONObject.getJSONObject("author"), !(messageDM instanceof ConfirmationRejectedMessageDM));
        messageDM.createdRequestId = jSONObject.optString(SDKAnalyticsEvents.PARAMETER_REQUEST_ID);
    }

    @Override // com.helpshift.common.platform.network.ResponseParser
    public String parseErrorMessage(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has("msg") ? jSONObject.getString("msg") : "";
        } catch (Exception unused) {
            return "";
        }
    }
}
