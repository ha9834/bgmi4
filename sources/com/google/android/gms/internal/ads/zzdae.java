package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzdae {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f3526a;
    private final zzbah b;
    private final zzcmu c;
    private final String d;
    private final String e;
    private final String f;
    private final Context g;
    private final Clock h;

    public zzdae(Executor executor, zzbah zzbahVar, zzcmu zzcmuVar, zzbai zzbaiVar, String str, String str2, Context context, Clock clock) {
        this.f3526a = executor;
        this.b = zzbahVar;
        this.c = zzcmuVar;
        this.d = zzbaiVar.zzbsx;
        this.e = str;
        this.f = str2;
        this.g = context;
        this.h = clock;
    }

    public final void zza(zzcxu zzcxuVar, zzcxm zzcxmVar, List<String> list) {
        zza(zzcxuVar, zzcxmVar, false, list);
    }

    public final void zza(zzcxu zzcxuVar, @Nullable zzcxm zzcxmVar, boolean z, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str = z ? "1" : "0";
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String a2 = a(a(a(it.next(), "@gw_adlocid@", zzcxuVar.zzgkx.zzfjp.zzglb), "@gw_adnetrefresh@", str), "@gw_sdkver@", this.d);
            if (zzcxmVar != null) {
                a2 = zzavx.zzd(a(a(a(a2, "@gw_qdata@", zzcxmVar.zzdfk), "@gw_adnetid@", zzcxmVar.zzatl), "@gw_allocid@", zzcxmVar.zzdej), this.g, zzcxmVar.zzdok);
            }
            arrayList.add(a(a(a(a2, "@gw_adnetstatus@", this.c.zzaku()), "@gw_seqnum@", this.e), "@gw_sessid@", this.f));
        }
        zzh(arrayList);
    }

    public final void zza(zzcxu zzcxuVar, zzcxm zzcxmVar, List<String> list, zzasr zzasrVar) {
        long currentTimeMillis = this.h.currentTimeMillis();
        try {
            String type = zzasrVar.getType();
            String num = Integer.toString(zzasrVar.getAmount());
            ArrayList arrayList = new ArrayList();
            String b = b(zzcxuVar.zzgkx.zzfjp.zzgle);
            String b2 = b(zzcxuVar.zzgkx.zzfjp.zzglf);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zzavx.zzd(a(a(a(a(a(a(it.next(), "@gw_rwd_userid@", Uri.encode(b)), "@gw_rwd_custom_data@", Uri.encode(b2)), "@gw_tmstmp@", Long.toString(currentTimeMillis)), "@gw_rwd_itm@", Uri.encode(type)), "@gw_rwd_amt@", num), "@gw_sdkver@", this.d), this.g, zzcxmVar.zzdok));
            }
            zzh(arrayList);
        } catch (RemoteException unused) {
        }
    }

    public final void zzh(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            zzed(it.next());
        }
    }

    public final void zzed(final String str) {
        this.f3526a.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.aaz

            /* renamed from: a, reason: collision with root package name */
            private final zzdae f1773a;
            private final String b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1773a = this;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f1773a.a(this.b);
            }
        });
    }

    private static String a(String str, String str2, @Nullable String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    @Nullable
    private static String b(@Nullable String str) {
        return (TextUtils.isEmpty(str) || !zzazx.isEnabled()) ? str : "fakeForAdDebugLog";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(String str) {
        this.b.zzed(str);
    }
}
