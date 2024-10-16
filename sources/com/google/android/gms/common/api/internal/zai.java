package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.internal.Objects;

/* loaded from: classes.dex */
public final class zai<O extends Api.ApiOptions> {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1401a;
    private final int b;
    private final Api<O> c;
    private final O d;

    private zai(Api<O> api, O o) {
        this.f1401a = false;
        this.c = api;
        this.d = o;
        this.b = Objects.hashCode(this.c, this.d);
    }

    private zai(Api<O> api) {
        this.f1401a = true;
        this.c = api;
        this.d = null;
        this.b = System.identityHashCode(this);
    }

    public static <O extends Api.ApiOptions> zai<O> zaa(Api<O> api, O o) {
        return new zai<>(api, o);
    }

    public static <O extends Api.ApiOptions> zai<O> zaa(Api<O> api) {
        return new zai<>(api);
    }

    public final String zan() {
        return this.c.getName();
    }

    public final int hashCode() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zai)) {
            return false;
        }
        zai zaiVar = (zai) obj;
        return !this.f1401a && !zaiVar.f1401a && Objects.equal(this.c, zaiVar.c) && Objects.equal(this.d, zaiVar.d);
    }
}
