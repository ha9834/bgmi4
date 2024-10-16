package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

@zzard
/* loaded from: classes2.dex */
public final class zzaqd {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f2783a = new Object();

    @VisibleForTesting
    @GuardedBy("lock")
    private static boolean b = false;

    @VisibleForTesting
    @GuardedBy("lock")
    private static boolean c = false;

    @VisibleForTesting
    private zzdah d;

    public final boolean zzl(Context context) {
        synchronized (f2783a) {
            if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue()) {
                return false;
            }
            if (b) {
                return true;
            }
            try {
                a(context);
                boolean zzap = this.d.zzap(ObjectWrapper.wrap(context));
                b = zzap;
                return zzap;
            } catch (RemoteException e) {
                e = e;
                zzbad.zze("#007 Could not call remote method.", e);
                return false;
            } catch (NullPointerException e2) {
                e = e2;
                zzbad.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    @VisibleForTesting
    private final void a(Context context) {
        synchronized (f2783a) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue() && !c) {
                try {
                    c = true;
                    this.d = (zzdah) zzbae.zza(context, "com.google.android.gms.ads.omid.DynamiteOmid", dw.f2134a);
                } catch (zzbag e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final String getVersion(Context context) {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue()) {
            return null;
        }
        try {
            a(context);
            String valueOf = String.valueOf(this.d.getVersion());
            return valueOf.length() != 0 ? "a.".concat(valueOf) : new String("a.");
        } catch (RemoteException | NullPointerException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4) {
        return zza(str, webView, str2, str3, str4, "Google");
    }

    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (f2783a) {
            try {
                try {
                    if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue() && b) {
                        try {
                            return this.d.zza(str, ObjectWrapper.wrap(webView), str2, str3, str4, str5);
                        } catch (RemoteException | NullPointerException e) {
                            zzbad.zze("#007 Could not call remote method.", e);
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void zzaa(IObjectWrapper iObjectWrapper) {
        synchronized (f2783a) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue() && b) {
                try {
                    this.d.zzaa(iObjectWrapper);
                } catch (RemoteException | NullPointerException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void zzab(IObjectWrapper iObjectWrapper) {
        synchronized (f2783a) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue() && b) {
                try {
                    this.d.zzab(iObjectWrapper);
                } catch (RemoteException | NullPointerException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, View view) {
        synchronized (f2783a) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcuu)).booleanValue() && b) {
                try {
                    this.d.zzd(iObjectWrapper, ObjectWrapper.wrap(view));
                } catch (RemoteException | NullPointerException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }
}
