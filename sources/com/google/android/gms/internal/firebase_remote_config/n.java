package com.google.android.gms.internal.firebase_remote_config;

import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
final class n implements Map.Entry<String, Object> {

    /* renamed from: a, reason: collision with root package name */
    private Object f4103a;
    private final zzbz b;
    private final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, zzbz zzbzVar, Object obj) {
        this.c = lVar;
        this.b = zzbzVar;
        this.f4103a = zzdt.checkNotNull(obj);
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f4103a;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object obj2 = this.f4103a;
        this.f4103a = zzdt.checkNotNull(obj);
        this.b.zzb(this.c.f4101a, obj);
        return obj2;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return ((String) getKey()).hashCode() ^ getValue().hashCode();
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return ((String) getKey()).equals(entry.getKey()) && getValue().equals(entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ String getKey() {
        String name = this.b.getName();
        return this.c.b.zzbv() ? name.toLowerCase(Locale.US) : name;
    }
}
