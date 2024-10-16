package com.devbrackets.android.exomedia.core.video.scale;

/* loaded from: classes.dex */
public enum ScaleType {
    CENTER,
    CENTER_CROP,
    CENTER_INSIDE,
    FIT_CENTER,
    FIT_XY,
    NONE;

    public static ScaleType a(int i) {
        if (i < 0 || i > NONE.ordinal()) {
            return NONE;
        }
        return values()[i];
    }
}
