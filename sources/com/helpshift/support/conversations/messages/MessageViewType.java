package com.helpshift.support.conversations.messages;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.intlgame.core.INTLMethodID;
import com.tencent.smtt.sdk.TbsListener;

/* loaded from: classes2.dex */
public enum MessageViewType {
    USER_TEXT_MESSAGE(10),
    ADMIN_TEXT_MESSAGE(20),
    USER_SCREENSHOT_ATTACHMENT(30),
    ADMIN_ATTACHMENT_IMAGE(40),
    ADMIN_ATTACHMENT_GENERIC(50),
    ADMIN_REQUEST_ATTACHMENT(60),
    REQUESTED_APP_REVIEW(70),
    REQUEST_FOR_REOPEN(80),
    CONFIRMATION_REJECTED(90),
    CONVERSATION_FOOTER(100),
    AGENT_TYPING_FOOTER(110),
    SYSTEM_DATE(120),
    SYSTEM_DIVIDER(INTLMethodID.INTL_METHOD_ID_QUERY_ID_TOKEN),
    USER_SELECTABLE_OPTION(140),
    ADMIN_SUGGESTIONS_LIST(150),
    SYSTEM_PUBLISH_ID(TbsListener.ErrorCode.STARTDOWNLOAD_1),
    SYSTEM_CONVERSATION_REDACTED_MESSAGE(TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE),
    HISTORY_LOADING_VIEW(180),
    ADMIN_REDACTED_MESSAGE(FacebookRequestErrorClassification.EC_INVALID_TOKEN),
    USER_REDACTED_MESSAGE(200),
    USER_ATTACHMENT_GENERIC(TbsListener.ErrorCode.ROM_NOT_ENOUGH),
    ACTION_CARD_MESSAGE(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS),
    USER_SMART_INTENT_MESSAGE(230);

    public final int key;

    MessageViewType(int i) {
        this.key = i;
    }

    public static MessageViewType getEnum(int i) {
        for (MessageViewType messageViewType : values()) {
            if (messageViewType.key == i) {
                return messageViewType;
            }
        }
        return null;
    }
}
