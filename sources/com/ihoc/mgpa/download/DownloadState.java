package com.ihoc.mgpa.download;

/* loaded from: classes2.dex */
public enum DownloadState {
    ERROR(-1, "error"),
    START(0, "start"),
    FINISH(100, "finish");

    public String description;
    public int state;

    DownloadState(int i, String str) {
        this.state = i;
        this.description = str;
    }

    public int getState() {
        return this.state;
    }
}
