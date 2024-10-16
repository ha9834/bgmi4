package com.tencent.midas.oversea.data;

import com.tencent.midas.oversea.business.APBaseRestore;

/* loaded from: classes.dex */
public class RestoreItem {
    public final String channel;
    public final APBaseRestore restore;

    public RestoreItem(String str, APBaseRestore aPBaseRestore) {
        this.channel = str == null ? "" : str;
        this.restore = aPBaseRestore;
    }
}
