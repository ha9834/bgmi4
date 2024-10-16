package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ff extends zzawv {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzawm f2168a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ff(zzawm zzawmVar) {
        this.f2168a = zzawmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzto() {
        Context context;
        zzbai zzbaiVar;
        Object obj;
        zzacy zzacyVar;
        context = this.f2168a.f;
        zzbaiVar = this.f2168a.g;
        zzacx zzacxVar = new zzacx(context, zzbaiVar.zzbsx);
        obj = this.f2168a.f2816a;
        synchronized (obj) {
            try {
                zzk.zzlp();
                zzacyVar = this.f2168a.h;
                zzada.zza(zzacyVar, zzacxVar);
            } catch (IllegalArgumentException e) {
                zzawz.zzd("Cannot config CSI reporter.", e);
            }
        }
    }
}
