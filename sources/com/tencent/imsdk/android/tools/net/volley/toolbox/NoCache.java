package com.tencent.imsdk.android.tools.net.volley.toolbox;

import com.tencent.imsdk.android.tools.net.volley.Cache;

/* loaded from: classes.dex */
public class NoCache implements Cache {
    @Override // com.tencent.imsdk.android.tools.net.volley.Cache
    public void clear() {
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.Cache
    public Cache.Entry get(String str) {
        return null;
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.Cache
    public void initialize() {
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.Cache
    public void invalidate(String str, boolean z) {
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.Cache
    public void put(String str, Cache.Entry entry) {
    }

    @Override // com.tencent.imsdk.android.tools.net.volley.Cache
    public void remove(String str) {
    }
}
