package com.tencent.grobot.lite.model.node;

import java.io.Serializable;

/* loaded from: classes2.dex */
public abstract class BaseNode implements Serializable {
    public static final int CHAT_ITEM_CONTAINER = 6;
    public static final int CHAT_ITEM_FEEDBACK = 24;
    public static final int CHAT_ITEM_FLOW = 5;
    public static final int CHAT_ITEM_FROM = 31;
    public static final int CHAT_ITEM_GIFT = 51;
    public static final int CHAT_ITEM_HOT = 7;
    public static final int CHAT_ITEM_ITEMTYPE_PIC = 1000;
    public static final int CHAT_ITEM_ITEMTYPE_VIDEO = 1001;
    public static final int CHAT_ITEM_LIKEUNLIKE = 23;
    public static final int CHAT_ITEM_MIX_TIPS = 34;
    public static final int CHAT_ITEM_OPTION = 22;
    public static final int CHAT_ITEM_PIC = 2;
    public static final int CHAT_ITEM_QUESTION = 21;
    public static final int CHAT_ITEM_RECOMMEND = 13;
    public static final int CHAT_ITEM_TEXT = 1;
    public static final int CHAT_ITEM_TEXT_INFO = 8;
    public static final int CHAT_ITEM_TICKET = 32;
    public static final int CHAT_ITEM_TICKET_STAR = 33;
    public static final int CHAT_ITEM_TIP = 4;
    public static final int CHAT_ITEM_VIDEO = 3;
    public static final int IM_ITEM_DIALOG = 41;
    public static final int IM_ITEM_NOTIFICATION = 42;
    public static final int IM_USER_STAR = 43;
    public static final int MSG_LOADING = 100;
    public boolean isListTop;

    public String getExtra() {
        return "";
    }

    public String getRawContent() {
        return "";
    }

    public int getStatus() {
        return 0;
    }

    public abstract String getStoreKey();

    public long getTimestamp() {
        return -1L;
    }

    public abstract int getType();

    public void parseExtra(String str) {
    }
}
