package com.helpshift.analytics;

import com.nostra13.universalimageloader.core.d;
import com.tencent.imsdk.android.IR;

/* loaded from: classes2.dex */
public enum AnalyticsEventType {
    APP_START(AnalyticsEventKey.ACTION_SHA),
    LIBRARY_OPENED("o"),
    LIBRARY_OPENED_DECOMP(d.f5744a),
    SUPPORT_LAUNCH(AnalyticsEventKey.SMART_INTENT_INTENT_LEVEL),
    PERFORMED_SEARCH(AnalyticsEventKey.SEARCH_QUERY),
    BROWSED_FAQ_LIST("b"),
    READ_FAQ("f"),
    MARKED_HELPFUL("h"),
    MARKED_UNHELPFUL(AnalyticsEventKey.URL),
    REPORTED_ISSUE("i"),
    CONVERSATION_POSTED(AnalyticsEventKey.PROTOCOL),
    REVIEWED_APP(AnalyticsEventKey.SMART_INTENT_SEARCH_RANK),
    OPEN_ISSUE(IR.path.DOCS_IMSDK_CHANNEL),
    OPEN_INBOX("x"),
    LIBRARY_QUIT("q"),
    MESSAGE_ADDED("m"),
    RESOLUTION_ACCEPTED("y"),
    RESOLUTION_REJECTED(AnalyticsEventKey.FAQ_SEARCH_RESULT_COUNT),
    START_CSAT_RATING("sr"),
    CANCEL_CSAT_RATING("cr"),
    LINK_VIA_FAQ("fl"),
    TICKET_AVOIDED("ta"),
    TICKET_AVOIDANCE_FAILED("taf"),
    DYNAMIC_FORM_OPEN("dfo"),
    ADMIN_MESSAGE_DEEPLINK_CLICKED("ml"),
    DYNAMIC_FORM_CLOSE("dfc"),
    SMART_INTENT_TREE_SHOWN("its"),
    SMART_INTENT_SELECTION("sis"),
    SMART_INTENT_DESELECTION(IR.unifiedAccount.UNIFIED_ACCOUNT_SESSION_ID),
    SMART_INTENT_SEARCH_INTENT("sisr"),
    ACTION_CARD_CLICKED("acl"),
    TIMER_EXPIRED("te");

    public final String key;

    AnalyticsEventType(String str) {
        this.key = str;
    }
}
