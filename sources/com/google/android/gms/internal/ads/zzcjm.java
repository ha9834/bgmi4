package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzwt;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class zzcjm {
    private static final SparseArray<zzwt.zzi.zzc> g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f3287a;
    private final zzbbh<Bundle> b;
    private final TelephonyManager c;
    private final zzcji d;
    private final zzcjc e;
    private zzwx f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcjm(Context context, zzbbh<Bundle> zzbbhVar, zzcji zzcjiVar, zzcjc zzcjcVar) {
        this.f3287a = context;
        this.b = zzbbhVar;
        this.d = zzcjiVar;
        this.e = zzcjcVar;
        this.c = (TelephonyManager) context.getSystemService("phone");
    }

    private static zzwx a(boolean z) {
        return z ? zzwx.ENUM_TRUE : zzwx.ENUM_FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzwt.zzg a(Bundle bundle) {
        zzwt.zzg.zzb zzbVar;
        zzwt.zzg.zza zznv = zzwt.zzg.zznv();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.f = zzwx.ENUM_TRUE;
        } else {
            this.f = zzwx.ENUM_FALSE;
            switch (i) {
                case 0:
                    zznv.zzb(zzwt.zzg.zzc.CELL);
                    break;
                case 1:
                    zznv.zzb(zzwt.zzg.zzc.WIFI);
                    break;
                default:
                    zznv.zzb(zzwt.zzg.zzc.NETWORKTYPE_UNSPECIFIED);
                    break;
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzbVar = zzwt.zzg.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzbVar = zzwt.zzg.zzb.THREE_G;
                    break;
                case 13:
                    zzbVar = zzwt.zzg.zzb.LTE;
                    break;
                default:
                    zzbVar = zzwt.zzg.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zznv.zzb(zzbVar);
        }
        return (zzwt.zzg) ((zzdob) zznv.zzaya());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzwt.zzi.zzc b(Bundle bundle) {
        return g.get(zzcxz.zza(zzcxz.zza(bundle, "device"), "network").getInt("active_network_state", -1), zzwt.zzi.zzc.UNSPECIFIED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<com.google.android.gms.internal.ads.zzwt.zza.EnumC0103zza> c(android.os.Bundle r5) {
        /*
            java.lang.String r0 = "ad_types"
            java.lang.Object r5 = r5.get(r0)
            boolean r0 = r5 instanceof java.util.List
            if (r0 == 0) goto Ld
            java.util.List r5 = (java.util.List) r5
            goto L17
        Ld:
            boolean r0 = r5 instanceof java.lang.String[]
            if (r0 == 0) goto L3d
            java.lang.String[] r5 = (java.lang.String[]) r5
            java.util.List r5 = java.util.Arrays.asList(r5)
        L17:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r5.size()
            r0.<init>(r1)
            java.util.Iterator r5 = r5.iterator()
        L24:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L38
            java.lang.Object r1 = r5.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L24
            java.lang.String r1 = (java.lang.String) r1
            r0.add(r1)
            goto L24
        L38:
            java.util.List r5 = java.util.Collections.unmodifiableList(r0)
            goto L41
        L3d:
            java.util.List r5 = java.util.Collections.emptyList()
        L41:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r5 = r5.iterator()
        L4a:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto Lac
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = -1
            int r3 = r1.hashCode()
            r4 = -1396342996(0xffffffffacc57f2c, float:-5.6131957E-12)
            if (r3 == r4) goto L8e
            r4 = -1052618729(0xffffffffc1425017, float:-12.144553)
            if (r3 == r4) goto L84
            r4 = -239580146(0xfffffffff1b84c0e, float:-1.82519E30)
            if (r3 == r4) goto L7a
            r4 = 604727084(0x240b672c, float:3.022821E-17)
            if (r3 == r4) goto L70
            goto L97
        L70:
            java.lang.String r3 = "interstitial"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L97
            r2 = 1
            goto L97
        L7a:
            java.lang.String r3 = "rewarded"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L97
            r2 = 3
            goto L97
        L84:
            java.lang.String r3 = "native"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L97
            r2 = 2
            goto L97
        L8e:
            java.lang.String r3 = "banner"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L97
            r2 = 0
        L97:
            switch(r2) {
                case 0: goto La6;
                case 1: goto La3;
                case 2: goto La0;
                case 3: goto L9d;
                default: goto L9a;
            }
        L9a:
            com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.EnumC0103zza.AD_FORMAT_TYPE_UNSPECIFIED
            goto La8
        L9d:
            com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.EnumC0103zza.REWARD_BASED_VIDEO_AD
            goto La8
        La0:
            com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.EnumC0103zza.NATIVE_APP_INSTALL
            goto La8
        La3:
            com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.EnumC0103zza.INTERSTITIAL
            goto La8
        La6:
            com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.EnumC0103zza.BANNER
        La8:
            r0.add(r1)
            goto L4a
        Lac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcjm.c(android.os.Bundle):java.util.ArrayList");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] a(boolean z, ArrayList<zzwt.zza.EnumC0103zza> arrayList, zzwt.zzg zzgVar, zzwt.zzi.zzc zzcVar) {
        return ((zzwt.zzi.zza) ((zzdob) zzwt.zzi.zza.zzoa().zzc(arrayList).zzh(a(zzk.zzli().zzb(this.f3287a.getContentResolver()) != 0)).zzi(zzk.zzli().zza(this.f3287a, this.c)).zzex(this.d.zzakl()).zzey(this.d.zzakn()).zzcg(this.d.getResponseCode()).zzb(zzcVar).zzb(zzgVar).zzj(this.f).zzf(a(z)).zzew(zzk.zzln().currentTimeMillis()).zzg(a(zzk.zzli().zza(this.f3287a.getContentResolver()) != 0)).zzaya())).toByteArray();
    }

    public final void zzba(boolean z) {
        zzbar.zza(this.b, new ui(this, z), zzbbm.zzeaf);
    }

    static {
        SparseArray<zzwt.zzi.zzc> sparseArray = new SparseArray<>();
        g = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzwt.zzi.zzc.CONNECTED);
        g.put(NetworkInfo.DetailedState.AUTHENTICATING.ordinal(), zzwt.zzi.zzc.CONNECTING);
        g.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzwt.zzi.zzc.CONNECTING);
        g.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzwt.zzi.zzc.CONNECTING);
        g.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzwt.zzi.zzc.DISCONNECTING);
        g.put(NetworkInfo.DetailedState.BLOCKED.ordinal(), zzwt.zzi.zzc.DISCONNECTED);
        g.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzwt.zzi.zzc.DISCONNECTED);
        g.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzwt.zzi.zzc.DISCONNECTED);
        g.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzwt.zzi.zzc.DISCONNECTED);
        g.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzwt.zzi.zzc.DISCONNECTED);
        g.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzwt.zzi.zzc.SUSPENDED);
        if (Build.VERSION.SDK_INT >= 17) {
            g.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzwt.zzi.zzc.CONNECTING);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            g.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzwt.zzi.zzc.CONNECTING);
        }
    }
}
