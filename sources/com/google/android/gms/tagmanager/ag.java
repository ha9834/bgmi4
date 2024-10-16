package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class ag {

    /* renamed from: a, reason: collision with root package name */
    private final Set<String> f5071a;
    private final String b;

    public abstract zzl zzb(Map<String, zzl> map);

    public abstract boolean zzgw();

    public String zzif() {
        return this.b;
    }

    public ag(String str, String... strArr) {
        this.b = str;
        this.f5071a = new HashSet(strArr.length);
        for (String str2 : strArr) {
            this.f5071a.add(str2);
        }
    }

    public Set<String> zzig() {
        return this.f5071a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(Set<String> set) {
        return set.containsAll(this.f5071a);
    }
}
