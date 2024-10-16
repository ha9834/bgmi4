package com.ihoc.mgpa.notch;

/* loaded from: classes2.dex */
public class NotchCloudData {
    private int mNotchHeight;
    private int mNotchWidth;

    public NotchCloudData(int i, int i2) {
        this.mNotchWidth = i;
        this.mNotchHeight = i2;
    }

    public int getNotchHeight() {
        return this.mNotchHeight;
    }

    public int getNotchWidth() {
        return this.mNotchWidth;
    }

    public String toString() {
        return "NotchCloudData{mNotchWidth=" + this.mNotchWidth + ", mNotchHeight=" + this.mNotchHeight + '}';
    }
}
