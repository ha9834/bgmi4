package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public final class zzcul implements zzcva<zzcuk> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbl f3446a;
    private final ScheduledExecutorService b;
    private final List<zzcpk> c;
    private final Context d;
    private final zzcxv e;
    private String f;

    public zzcul(zzbbl zzbblVar, ScheduledExecutorService scheduledExecutorService, String str, zzcpf zzcpfVar, Context context, zzcxv zzcxvVar) {
        this.f3446a = zzbblVar;
        this.b = scheduledExecutorService;
        this.f = str;
        this.d = context;
        this.e = zzcxvVar;
        if (zzcpfVar.zzakx().containsKey(zzcxvVar.zzglb)) {
            this.c = zzcpfVar.zzakx().get(zzcxvVar.zzglb);
        } else {
            this.c = Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcuk> zzalm() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcqt)).booleanValue()) {
            return zzbar.zza(this.f3446a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zc

                /* renamed from: a, reason: collision with root package name */
                private final zzcul f2656a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2656a = this;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f2656a.a();
                }
            }), new zzbal(this) { // from class: com.google.android.gms.internal.ads.zd

                /* renamed from: a, reason: collision with root package name */
                private final zzcul f2657a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2657a = this;
                }

                @Override // com.google.android.gms.internal.ads.zzbal
                public final zzbbh zzf(Object obj) {
                    return this.f2657a.b((List) obj);
                }
            }, this.f3446a);
        }
        return zzbar.zzm(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ zzcuk a(List list) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(((zzbbh) it.next()).get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return new zzcuk(jSONArray.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzcpk zzcpkVar, Bundle bundle, zzcpl zzcplVar, zzbbr zzbbrVar) {
        try {
            zzcpkVar.zzgdj.zza(ObjectWrapper.wrap(this.d), this.f, bundle, zzcpkVar.zzemv, this.e.zzdll, zzcplVar);
        } catch (Exception e) {
            zzbbrVar.setException(new Exception("Error calling adapter"));
            zzbad.zzc("", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh b(final List list) throws Exception {
        return zzbar.zzf(list).zza(new Callable(list) { // from class: com.google.android.gms.internal.ads.zf

            /* renamed from: a, reason: collision with root package name */
            private final List f2659a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2659a = list;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzcul.a(this.f2659a);
            }
        }, this.f3446a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ List a() throws Exception {
        ArrayList arrayList = new ArrayList();
        for (final zzcpk zzcpkVar : this.c) {
            final zzbbr zzbbrVar = new zzbbr();
            final zzcpl zzcplVar = new zzcpl(zzcpkVar, zzbbrVar);
            final Bundle bundle = this.e.zzghg.zzcgv != null ? this.e.zzghg.zzcgv.getBundle(zzcpkVar.zzfis) : null;
            arrayList.add(zzbar.zza(zzbbrVar, ((Long) zzyt.zzpe().zzd(zzacu.zzcqs)).longValue(), TimeUnit.MILLISECONDS, this.b));
            this.f3446a.execute(new Runnable(this, zzcpkVar, bundle, zzcplVar, zzbbrVar) { // from class: com.google.android.gms.internal.ads.ze

                /* renamed from: a, reason: collision with root package name */
                private final zzcul f2658a;
                private final zzcpk b;
                private final Bundle c;
                private final zzcpl d;
                private final zzbbr e;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2658a = this;
                    this.b = zzcpkVar;
                    this.c = bundle;
                    this.d = zzcplVar;
                    this.e = zzbbrVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f2658a.a(this.b, this.c, this.d, this.e);
                }
            });
        }
        return arrayList;
    }
}
