package com.tencent.grobot.lite.image.model;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class ImageItemInfo {
    public int order;
    public String path;
    public int selectPosition;
    public boolean canSelect = true;
    public boolean selected = false;

    public boolean equals(Object obj) {
        return !TextUtils.isEmpty(this.path) && this.path.equals(((ImageItemInfo) obj).path);
    }
}
