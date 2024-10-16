package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzclc {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<zzamp> f3306a = new AtomicReference<>();

    public final void zzb(zzamp zzampVar) {
        this.f3306a.compareAndSet(null, zzampVar);
    }

    public final zzams zze(String str, JSONObject jSONObject) throws RemoteException {
        if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
            return new zzanl(new AdMobAdapter());
        }
        if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
            return new zzanl(new AdUrlAdapter());
        }
        if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
            return new zzanl(new zzapl());
        }
        return a(str, jSONObject);
    }

    public final zzaov zzcy(String str) throws RemoteException {
        return a().zzcy(str);
    }

    public final boolean zzakr() {
        return this.f3306a.get() != null;
    }

    private final zzams a(String str, JSONObject jSONObject) throws RemoteException {
        zzamp a2 = a();
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                if (a2.zzcv(jSONObject.getString("class_name"))) {
                    return a2.zzcu("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
                }
                return a2.zzcu("com.google.ads.mediation.customevent.CustomEventAdapter");
            } catch (JSONException e) {
                zzawz.zzc("Invalid custom event.", e);
            }
        }
        return a2.zzcu(str);
    }

    private final zzamp a() throws RemoteException {
        zzamp zzampVar = this.f3306a.get();
        if (zzampVar != null) {
            return zzampVar;
        }
        zzawz.zzep("Unexpected call to adapter creator.");
        throw new RemoteException();
    }
}
