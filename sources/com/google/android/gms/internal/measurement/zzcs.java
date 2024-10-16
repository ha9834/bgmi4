package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzcs implements av {

    /* renamed from: a, reason: collision with root package name */
    static final Map<String, zzcs> f4546a = new HashMap();
    private final SharedPreferences b;
    private volatile Map<String, ?> e;
    private final SharedPreferences.OnSharedPreferenceChangeListener c = new SharedPreferences.OnSharedPreferenceChangeListener(this) { // from class: com.google.android.gms.internal.measurement.bd

        /* renamed from: a, reason: collision with root package name */
        private final zzcs f4482a;

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            this.f4482a = this;
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            this.f4482a.a(sharedPreferences, str);
        }
    };
    private final Object d = new Object();
    private final List<zzcf> f = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzcs a(Context context, String str) {
        zzcs zzcsVar;
        SharedPreferences sharedPreferences;
        if (!((!zzcb.zzri() || str.startsWith("direct_boot:")) ? true : zzcb.isUserUnlocked(context))) {
            return null;
        }
        synchronized (zzcs.class) {
            zzcsVar = f4546a.get(str);
            if (zzcsVar == null) {
                if (str.startsWith("direct_boot:")) {
                    if (zzcb.zzri()) {
                        context = context.createDeviceProtectedStorageContext();
                    }
                    sharedPreferences = context.getSharedPreferences(str.substring(12), 0);
                } else {
                    sharedPreferences = context.getSharedPreferences(str, 0);
                }
                zzcsVar = new zzcs(sharedPreferences);
                f4546a.put(str, zzcsVar);
            }
        }
        return zzcsVar;
    }

    private zzcs(SharedPreferences sharedPreferences) {
        this.b = sharedPreferences;
        this.b.registerOnSharedPreferenceChangeListener(this.c);
    }

    @Override // com.google.android.gms.internal.measurement.av
    public final Object zzdd(String str) {
        Map<String, ?> map = this.e;
        if (map == null) {
            synchronized (this.d) {
                map = this.e;
                if (map == null) {
                    map = this.b.getAll();
                    this.e = map;
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final /* synthetic */ void a(SharedPreferences sharedPreferences, String str) {
        synchronized (this.d) {
            this.e = null;
            zzcm.a();
        }
        synchronized (this) {
            Iterator<zzcf> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().zzrk();
            }
        }
    }
}
