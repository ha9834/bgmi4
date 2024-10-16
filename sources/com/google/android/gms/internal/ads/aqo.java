package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import javax.annotation.Nonnull;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class aqo<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzzv f2055a = c();

    @Nonnull
    protected abstract T a();

    protected abstract T a(zzzv zzzvVar) throws RemoteException;

    protected abstract T b() throws RemoteException;

    private static zzzv c() {
        try {
            Object newInstance = zzyh.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi2").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzbad.zzep("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            if (queryLocalInterface instanceof zzzv) {
                return (zzzv) queryLocalInterface;
            }
            return new zzzx(iBinder);
        } catch (Exception unused) {
            zzbad.zzep("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    private final T d() {
        zzzv zzzvVar = f2055a;
        if (zzzvVar == null) {
            zzbad.zzep("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return a(zzzvVar);
        } catch (RemoteException e) {
            zzbad.zzd("Cannot invoke local loader using ClientApi class.", e);
            return null;
        }
    }

    private final T e() {
        try {
            return b();
        } catch (RemoteException e) {
            zzbad.zzd("Cannot invoke remote loader.", e);
            return null;
        }
    }

    public final T a(Context context, boolean z) {
        T d;
        if (!z) {
            zzyt.zzpa();
            if (!zzazt.zzc(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzbad.zzdp("Google Play Services is not available.");
                z = true;
            }
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID)) {
            z = true;
        }
        zzacu.initialize(context);
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcur)).booleanValue()) {
            z = false;
        }
        if (z) {
            d = d();
            if (d == null) {
                d = e();
            }
        } else {
            T e = e();
            int i = e == null ? 1 : 0;
            if (i != 0) {
                if (zzyt.zzph().nextInt(((Integer) zzyt.zzpe().zzd(zzacu.zzcwr)).intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", i);
                    zzyt.zzpa().zza(context, zzyt.zzpg().zzbsx, "gmob-apps", bundle, true);
                }
            }
            d = e == null ? d() : e;
        }
        return d == null ? a() : d;
    }
}
