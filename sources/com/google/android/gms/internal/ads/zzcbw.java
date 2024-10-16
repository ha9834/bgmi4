package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class zzcbw extends zzajb implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzadv {

    /* renamed from: a, reason: collision with root package name */
    private View f3169a;
    private zzaar b;
    private zzbyn c;
    private boolean d = false;
    private boolean e = false;

    public zzcbw(zzbyn zzbynVar, zzbyt zzbytVar) {
        this.f3169a = zzbytVar.zzahy();
        this.b = zzbytVar.getVideoController();
        this.c = zzbynVar;
        if (zzbytVar.zzahz() != null) {
            zzbytVar.zzahz().zza(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaja
    public final void zza(IObjectWrapper iObjectWrapper, zzajc zzajcVar) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.d) {
            zzawz.zzen("Instream ad is destroyed already.");
            a(zzajcVar, 2);
            return;
        }
        if (this.f3169a == null || this.b == null) {
            String valueOf = String.valueOf(this.f3169a == null ? "can not get video view." : "can not get video controller.");
            zzawz.zzen(valueOf.length() != 0 ? "Instream internal error: ".concat(valueOf) : new String("Instream internal error: "));
            a(zzajcVar, 0);
            return;
        }
        if (this.e) {
            zzawz.zzen("Instream ad should not be used again.");
            a(zzajcVar, 1);
            return;
        }
        this.e = true;
        b();
        ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.f3169a, new ViewGroup.LayoutParams(-1, -1));
        zzk.zzmd();
        zzbbz.zza(this.f3169a, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzk.zzmd();
        zzbbz.zza(this.f3169a, (ViewTreeObserver.OnScrollChangedListener) this);
        c();
        try {
            zzajcVar.zzrt();
        } catch (RemoteException e) {
            zzawz.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaja
    public final zzaar getVideoController() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.d) {
            zzawz.zzen("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzaja
    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        b();
        zzbyn zzbynVar = this.c;
        if (zzbynVar != null) {
            zzbynVar.destroy();
        }
        this.c = null;
        this.f3169a = null;
        this.b = null;
        this.d = true;
    }

    private final void b() {
        View view = this.f3169a;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f3169a);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        c();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        c();
    }

    @Override // com.google.android.gms.internal.ads.zzadv
    public final void zzre() {
        zzaxi.zzdvv.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.rq

            /* renamed from: a, reason: collision with root package name */
            private final zzcbw f2472a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2472a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2472a.a();
            }
        });
    }

    private final void c() {
        View view;
        zzbyn zzbynVar = this.c;
        if (zzbynVar == null || (view = this.f3169a) == null) {
            return;
        }
        zzbynVar.zzb(view, Collections.emptyMap(), Collections.emptyMap(), zzbyn.zzx(this.f3169a));
    }

    private static void a(zzajc zzajcVar, int i) {
        try {
            zzajcVar.zzcq(i);
        } catch (RemoteException e) {
            zzawz.zze("#007 Could not call remote method.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a() {
        try {
            destroy();
        } catch (RemoteException e) {
            zzawz.zze("#007 Could not call remote method.", e);
        }
    }
}
