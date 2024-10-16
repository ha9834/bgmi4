package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzcae implements zzbzb {

    /* renamed from: a, reason: collision with root package name */
    private final zzana f3148a;
    private final zzand b;
    private final zzang c;
    private final zzbrt d;
    private final zzbri e;
    private final Context f;
    private final zzcxm g;
    private final zzbai h;
    private final zzcxv i;
    private boolean j = false;
    private boolean k = false;

    public zzcae(zzana zzanaVar, zzand zzandVar, zzang zzangVar, zzbrt zzbrtVar, zzbri zzbriVar, Context context, zzcxm zzcxmVar, zzbai zzbaiVar, zzcxv zzcxvVar) {
        this.f3148a = zzanaVar;
        this.b = zzandVar;
        this.c = zzangVar;
        this.d = zzbrtVar;
        this.e = zzbriVar;
        this.f = context;
        this.g = zzcxmVar;
        this.h = zzbaiVar;
        this.i = zzcxvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void cancelUnconfirmedClick() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void destroy() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void setClickConfirmingView(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(zzagd zzagdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzahk() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzahm() {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzf(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzfi(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzg(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final boolean zzh(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            HashMap<String, View> a2 = a(map);
            HashMap<String, View> a3 = a(map2);
            if (this.c != null) {
                this.c.zzc(wrap, ObjectWrapper.wrap(a2), ObjectWrapper.wrap(a3));
                return;
            }
            if (this.f3148a != null) {
                this.f3148a.zzc(wrap, ObjectWrapper.wrap(a2), ObjectWrapper.wrap(a3));
                this.f3148a.zzu(wrap);
            } else if (this.b != null) {
                this.b.zzc(wrap, ObjectWrapper.wrap(a2), ObjectWrapper.wrap(a3));
                this.b.zzu(wrap);
            }
        } catch (RemoteException e) {
            zzawz.zzd("Failed to call trackView", e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static HashMap<String, View> a(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view = entry.getValue().get();
                if (view != null) {
                    hashMap.put(entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(View view, Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            if (this.c != null) {
                this.c.zzv(wrap);
            } else if (this.f3148a != null) {
                this.f3148a.zzv(wrap);
            } else if (this.b != null) {
                this.b.zzv(wrap);
            }
        } catch (RemoteException e) {
            zzawz.zzd("Failed to call untrackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (this.k && this.g.zzdft) {
            return;
        }
        a(view);
    }

    private final void a(View view) {
        try {
            if (this.c != null && !this.c.getOverrideClickHandling()) {
                this.c.zzt(ObjectWrapper.wrap(view));
                this.e.onAdClicked();
            } else if (this.f3148a != null && !this.f3148a.getOverrideClickHandling()) {
                this.f3148a.zzt(ObjectWrapper.wrap(view));
                this.e.onAdClicked();
            } else {
                if (this.b == null || this.b.getOverrideClickHandling()) {
                    return;
                }
                this.b.zzt(ObjectWrapper.wrap(view));
                this.e.onAdClicked();
            }
        } catch (RemoteException e) {
            zzawz.zzd("Failed to call handleClick", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.k) {
            zzawz.zzep("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.g.zzdft) {
            zzawz.zzep("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
        } else {
            a(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzro() {
        this.k = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        try {
            if (!this.j && this.g.zzgkj != null) {
                this.j |= zzk.zzlq().zzb(this.f, this.h.zzbsx, this.g.zzgkj.toString(), this.i.zzglb);
            }
            if (this.c != null && !this.c.getOverrideImpressionRecording()) {
                this.c.recordImpression();
                this.d.onAdImpression();
            } else if (this.f3148a != null && !this.f3148a.getOverrideImpressionRecording()) {
                this.f3148a.recordImpression();
                this.d.onAdImpression();
            } else {
                if (this.b == null || this.b.getOverrideImpressionRecording()) {
                    return;
                }
                this.b.recordImpression();
                this.d.onAdImpression();
            }
        } catch (RemoteException e) {
            zzawz.zzd("Failed to call recordImpression", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(zzaak zzaakVar) {
        zzawz.zzep("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zza(zzaag zzaagVar) {
        zzawz.zzep("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void zzahl() {
        zzawz.zzep("Mute This Ad is not supported for 3rd party ads");
    }
}
