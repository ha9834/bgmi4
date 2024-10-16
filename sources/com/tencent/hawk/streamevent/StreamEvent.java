package com.tencent.hawk.streamevent;

/* loaded from: classes2.dex */
public class StreamEvent {
    private String mEventCategory;
    private boolean mIsLinked = false;

    public String getEventCategory() {
        return this.mEventCategory;
    }

    public void setEventCategory(String str) {
        this.mEventCategory = str;
    }

    public boolean isLinked() {
        return this.mIsLinked;
    }

    public void linkSession() {
        this.mIsLinked = true;
    }
}
