package com.tencent.grobot.lite.model.node;

import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;

/* loaded from: classes2.dex */
public class QuTextNode extends BaseNode {
    public int position;
    public String questionId;
    public int robotType;
    public String text = "";
    public long showTimestamp = 0;
    public int quSendingState = 0;
    public int questionOrderId = 0;

    /* loaded from: classes2.dex */
    public interface QuSendingState {
        public static final int SendFail = 2;
        public static final int SendSuccess = 1;
        public static final int Sending = 0;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getType() {
        return 21;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getStoreKey() {
        return "item_" + getType() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.questionId;
    }
}
