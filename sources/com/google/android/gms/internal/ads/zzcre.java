package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcre implements zzcva<zzcrd> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbl f3390a;
    private final Context b;
    private final zzcxv c;
    private final View d;

    public zzcre(zzbbl zzbblVar, Context context, zzcxv zzcxvVar, ViewGroup viewGroup) {
        this.f3390a = zzbblVar;
        this.b = context;
        this.c = zzcxvVar;
        this.d = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcrd> zzalm() {
        if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcnr)).booleanValue()) {
            return zzbar.zzd(new Exception("Ad Key signal disabled."));
        }
        return this.f3390a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.xx

            /* renamed from: a, reason: collision with root package name */
            private final zzcre f2624a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2624a = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2624a.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcrd a() throws Exception {
        Context context = this.b;
        zzyd zzydVar = this.c.zzdll;
        ArrayList arrayList = new ArrayList();
        View view = this.d;
        while (view != null) {
            Object parent = view.getParent();
            if (parent == null) {
                break;
            }
            int indexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", indexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzcrd(context, zzydVar, arrayList);
    }
}
