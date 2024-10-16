package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.amazonaws.services.s3.util.Mimetypes;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzbzt {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3144a;
    private final zzcdn b;
    private final zzccj c;
    private final zzbmy d;
    private final zzbzb e;

    public zzbzt(Context context, zzcdn zzcdnVar, zzccj zzccjVar, zzbmy zzbmyVar, zzbzb zzbzbVar) {
        this.f3144a = context;
        this.b = zzcdnVar;
        this.c = zzccjVar;
        this.d = zzbmyVar;
        this.e = zzbzbVar;
    }

    public final View zzajb() throws zzbhj {
        zzbgz zzc = this.b.zzc(zzyd.zzg(this.f3144a));
        zzc.getView().setVisibility(8);
        zzc.zza("/sendMessageToSdk", new zzaho(this) { // from class: com.google.android.gms.internal.ads.qm

            /* renamed from: a, reason: collision with root package name */
            private final zzbzt f2442a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2442a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void zza(Object obj, Map map) {
                this.f2442a.d((zzbgz) obj, map);
            }
        });
        zzc.zza("/adMuted", new zzaho(this) { // from class: com.google.android.gms.internal.ads.qn

            /* renamed from: a, reason: collision with root package name */
            private final zzbzt f2443a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2443a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void zza(Object obj, Map map) {
                this.f2443a.c((zzbgz) obj, map);
            }
        });
        this.c.zza(new WeakReference(zzc), "/loadHtml", new zzaho(this) { // from class: com.google.android.gms.internal.ads.qo

            /* renamed from: a, reason: collision with root package name */
            private final zzbzt f2444a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2444a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void zza(Object obj, final Map map) {
                final zzbzt zzbztVar = this.f2444a;
                zzbgz zzbgzVar = (zzbgz) obj;
                zzbgzVar.zzaai().zza(new zzbij(zzbztVar, map) { // from class: com.google.android.gms.internal.ads.qr

                    /* renamed from: a, reason: collision with root package name */
                    private final zzbzt f2447a;
                    private final Map b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2447a = zzbztVar;
                        this.b = map;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbij
                    public final void zzae(boolean z) {
                        this.f2447a.a(this.b, z);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzbgzVar.loadData(str, Mimetypes.MIMETYPE_HTML, "UTF-8");
                } else {
                    zzbgzVar.loadDataWithBaseURL(str2, str, Mimetypes.MIMETYPE_HTML, "UTF-8", null);
                }
            }
        });
        this.c.zza(new WeakReference(zzc), "/showOverlay", new zzaho(this) { // from class: com.google.android.gms.internal.ads.qp

            /* renamed from: a, reason: collision with root package name */
            private final zzbzt f2445a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2445a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void zza(Object obj, Map map) {
                this.f2445a.b((zzbgz) obj, map);
            }
        });
        this.c.zza(new WeakReference(zzc), "/hideOverlay", new zzaho(this) { // from class: com.google.android.gms.internal.ads.qq

            /* renamed from: a, reason: collision with root package name */
            private final zzbzt f2446a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2446a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void zza(Object obj, Map map) {
                this.f2446a.a((zzbgz) obj, map);
            }
        });
        return zzc.getView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzbgz zzbgzVar, Map map) {
        zzbgzVar.getView().setVisibility(8);
        this.d.zzax(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(zzbgz zzbgzVar, Map map) {
        zzbgzVar.getView().setVisibility(0);
        this.d.zzax(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.c.zza("sendMessageToNativeJs", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(zzbgz zzbgzVar, Map map) {
        this.e.zzahl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d(zzbgz zzbgzVar, Map map) {
        this.c.zza("sendMessageToNativeJs", (Map<String, ?>) map);
    }
}
