package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.common.api.internal.zzck;
import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.common.api.internal.zzcq;
import com.google.android.gms.common.api.internal.zzdo;
import com.google.android.gms.tasks.Task;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzcon {

    /* renamed from: a, reason: collision with root package name */
    private static zzcon f4680a;
    private final Map<String, Set<zzck<?>>> b = new HashMap();
    private final Set<zzck<?>> c = new HashSet();
    private final Map<String, zzci<String>> d = new HashMap();

    private zzcon() {
    }

    private final void a(String str, zzck<?> zzckVar) {
        Set<zzck<?>> set = this.b.get(str);
        if (set == null) {
            set = new HashSet<>();
            this.b.put(str, set);
        }
        set.add(zzckVar);
    }

    public static synchronized zzcon zzbdd() {
        zzcon zzconVar;
        synchronized (zzcon.class) {
            if (f4680a == null) {
                f4680a = new zzcon();
            }
            zzconVar = f4680a;
        }
        return zzconVar;
    }

    public final synchronized <T> zzci<T> zza(GoogleApi googleApi, T t, String str) {
        zzci<T> zza;
        zza = googleApi.zza(t, str);
        a(str, zza.zzakx());
        return zza;
    }

    public final synchronized zzci<String> zza(GoogleApi googleApi, String str, String str2) {
        if (this.d.containsKey(str) && this.d.get(str).zzafr()) {
            return this.d.get(str);
        }
        zzci<String> zza = googleApi.zza(str, str2);
        a(str2, zza.zzakx());
        this.d.put(str, zza);
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void zza(GoogleApi googleApi, String str) {
        Set<zzck<?>> set = this.b.get(str);
        if (set == null) {
            return;
        }
        for (zzck<?> zzckVar : set) {
            if (this.c.contains(zzckVar)) {
                zzb(googleApi, zzckVar);
            }
        }
        this.b.remove(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized <T> zzck<T> zzb(GoogleApi googleApi, T t, String str) {
        if (t instanceof String) {
            return zza(googleApi, (String) t, str).zzakx();
        }
        return zzcm.zzb(t, str);
    }

    public final synchronized Task<Boolean> zzb(GoogleApi googleApi, zzck<?> zzckVar) {
        this.c.remove(zzckVar);
        return googleApi.zza(zzckVar);
    }

    public final synchronized Task<Void> zzb(GoogleApi googleApi, zzcq zzcqVar, zzdo zzdoVar) {
        this.c.add(zzcqVar.zzakx());
        return googleApi.zza(zzcqVar, zzdoVar).addOnFailureListener(new b(this, zzcqVar));
    }
}
