package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventAdapter;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
public final class zzamo extends zzamq {
    private static final zzapb b = new zzapb();

    /* renamed from: a, reason: collision with root package name */
    private Map<Class<? extends NetworkExtras>, NetworkExtras> f2759a;

    @Override // com.google.android.gms.internal.ads.zzamp
    public final zzams zzcu(String str) throws RemoteException {
        return a(str);
    }

    @Override // com.google.android.gms.internal.ads.zzamp
    public final boolean zzcv(String str) throws RemoteException {
        try {
            return CustomEvent.class.isAssignableFrom(Class.forName(str, false, zzamo.class.getClassLoader()));
        } catch (Throwable unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 80);
            sb.append("Could not load custom event implementation class: ");
            sb.append(str);
            sb.append(", assuming old implementation.");
            zzbad.zzep(sb.toString());
            return false;
        }
    }

    public final void zzf(Map<Class<? extends NetworkExtras>, NetworkExtras> map) {
        this.f2759a = map;
    }

    private final <NetworkExtrasT extends com.google.ads.mediation.NetworkExtras, ServerParametersT extends MediationServerParameters> zzams a(String str) throws RemoteException {
        try {
            Class<?> cls = Class.forName(str, false, zzamo.class.getClassLoader());
            if (MediationAdapter.class.isAssignableFrom(cls)) {
                MediationAdapter mediationAdapter = (MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                return new zzant(mediationAdapter, (com.google.ads.mediation.NetworkExtras) this.f2759a.get(mediationAdapter.getAdditionalParametersType()));
            }
            if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(cls)) {
                return new zzanl((com.google.android.gms.ads.mediation.MediationAdapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            if (Adapter.class.isAssignableFrom(cls)) {
                return new zzanl((Adapter) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 64);
            sb.append("Could not instantiate mediation adapter: ");
            sb.append(str);
            sb.append(" (not a valid adapter).");
            zzbad.zzep(sb.toString());
            throw new RemoteException();
        } catch (Throwable unused) {
            return b(str);
        }
    }

    private final zzams b(String str) throws RemoteException {
        try {
            zzbad.zzdp("Reflection failed, retrying using direct instantiation");
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 43);
            sb.append("Could not instantiate mediation adapter: ");
            sb.append(str);
            sb.append(". ");
            zzbad.zzd(sb.toString(), th);
        }
        if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
            return new zzanl(new AdMobAdapter());
        }
        if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
            return new zzanl(new AdUrlAdapter());
        }
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            return new zzanl(new CustomEventAdapter());
        }
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            com.google.ads.mediation.customevent.CustomEventAdapter customEventAdapter = new com.google.ads.mediation.customevent.CustomEventAdapter();
            return new zzant(customEventAdapter, (CustomEventExtras) this.f2759a.get(customEventAdapter.getAdditionalParametersType()));
        }
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzamp
    public final zzaov zzcy(String str) throws RemoteException {
        return zzapb.zzdd(str);
    }
}
