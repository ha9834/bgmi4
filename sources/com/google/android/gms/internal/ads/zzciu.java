package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzciu implements zzczc<zzciv, zzciw> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3272a;
    private final String b;
    private final zzasm c;
    private final String d;

    public zzciu(Context context, String str, zzasm zzasmVar, String str2) {
        this.f3272a = context;
        this.b = str;
        this.c = zzasmVar;
        this.d = str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:91:0x0203, code lost:
    
        r0 = new java.lang.StringBuilder(46);
        r0.append("Received error HTTP response code: ");
        r0.append(r12);
        com.google.android.gms.internal.ads.zzawz.zzep(r0.toString());
        r4 = new java.lang.StringBuilder(46);
        r4.append("Received error HTTP response code: ");
        r4.append(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x022f, code lost:
    
        throw new com.google.android.gms.internal.ads.zzcif(r4.toString());
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.google.android.gms.internal.ads.zzciw a(java.lang.String r18, com.google.android.gms.internal.ads.zzasd r19, org.json.JSONObject r20, java.lang.String r21) throws com.google.android.gms.internal.ads.zzcif {
        /*
            Method dump skipped, instructions count: 635
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzciu.a(java.lang.String, com.google.android.gms.internal.ads.zzasd, org.json.JSONObject, java.lang.String):com.google.android.gms.internal.ads.zzciw");
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final /* synthetic */ zzciw apply(zzciv zzcivVar) throws Exception {
        zzasd zzasdVar;
        zzasd zzasdVar2;
        JSONObject jSONObject;
        zzciv zzcivVar2 = zzcivVar;
        zzasdVar = zzcivVar2.b;
        String url = zzasdVar.getUrl();
        zzasdVar2 = zzcivVar2.b;
        jSONObject = zzcivVar2.f3273a;
        return a(url, zzasdVar2, jSONObject, this.d);
    }
}
