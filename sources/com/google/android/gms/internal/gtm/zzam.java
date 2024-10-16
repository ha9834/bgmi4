package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.uqm.crashsight.CrashSight;

/* loaded from: classes2.dex */
public class zzam {

    /* renamed from: a, reason: collision with root package name */
    private final zzap f4385a;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzam(zzap zzapVar) {
        Preconditions.checkNotNull(zzapVar);
        this.f4385a = zzapVar;
    }

    public final zzap zzcm() {
        return this.f4385a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Clock d() {
        return this.f4385a.zzcn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Context e() {
        return this.f4385a.getContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzci f() {
        return this.f4385a.zzco();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbq g() {
        return this.f4385a.zzcp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final com.google.android.gms.analytics.zzk h() {
        return this.f4385a.zzcq();
    }

    public final GoogleAnalytics zzcr() {
        return this.f4385a.zzde();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzae i() {
        return this.f4385a.zzcs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbv j() {
        return this.f4385a.zzct();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzda k() {
        return this.f4385a.zzcu();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzcm l() {
        return this.f4385a.zzcv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbh m() {
        return this.f4385a.zzdh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzad n() {
        return this.f4385a.zzdg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzba o() {
        return this.f4385a.zzcy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbu p() {
        return this.f4385a.zzcz();
    }

    public final void zzq(String str) {
        a(2, str, null, null, null);
    }

    public final void zza(String str, Object obj) {
        a(2, str, obj, null, null);
    }

    public final void zza(String str, Object obj, Object obj2) {
        a(2, str, obj, obj2, null);
    }

    public final void zzr(String str) {
        a(3, str, null, null, null);
    }

    public final void zzb(String str, Object obj) {
        a(3, str, obj, null, null);
    }

    public final void zzb(String str, Object obj, Object obj2) {
        a(3, str, obj, obj2, null);
    }

    public final void zza(String str, Object obj, Object obj2, Object obj3) {
        a(3, str, obj, obj2, obj3);
    }

    public final void zzs(String str) {
        a(4, str, null, null, null);
    }

    public final void zzc(String str, Object obj) {
        a(4, str, obj, null, null);
    }

    public final void zzt(String str) {
        a(5, str, null, null, null);
    }

    public final void zzd(String str, Object obj) {
        a(5, str, obj, null, null);
    }

    public final void zzc(String str, Object obj, Object obj2) {
        a(5, str, obj, obj2, null);
    }

    public final void zzb(String str, Object obj, Object obj2, Object obj3) {
        a(5, str, obj, obj2, obj3);
    }

    public final void zzu(String str) {
        a(6, str, null, null, null);
    }

    public final void zze(String str, Object obj) {
        a(6, str, obj, null, null);
    }

    public final void zzd(String str, Object obj, Object obj2) {
        a(6, str, obj, obj2, null);
    }

    public static boolean zzda() {
        return Log.isLoggable(zzby.zzzb.get(), 2);
    }

    private final void a(int i, String str, Object obj, Object obj2, Object obj3) {
        zzap zzapVar = this.f4385a;
        zzci zzdd = zzapVar != null ? zzapVar.zzdd() : null;
        if (zzdd != null) {
            String str2 = zzby.zzzb.get();
            if (Log.isLoggable(str2, i)) {
                Log.println(i, str2, zzci.a(str, obj, obj2, obj3));
            }
            if (i >= 5) {
                zzdd.zzb(i, str, obj, obj2, obj3);
                return;
            }
            return;
        }
        String str3 = zzby.zzzb.get();
        if (Log.isLoggable(str3, i)) {
            Log.println(i, str3, a(str, obj, obj2, obj3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String a2 = a(obj);
        String a3 = a(obj2);
        String a4 = a(obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a2)) {
            sb.append(str2);
            sb.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            sb.append(str2);
            sb.append(a3);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a4)) {
            sb.append(str2);
            sb.append(a4);
        }
        return sb.toString();
    }

    private static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Boolean) {
            return obj == Boolean.TRUE ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : CrashSight.SDK_IS_DEV;
        }
        if (obj instanceof Throwable) {
            return ((Throwable) obj).toString();
        }
        return obj.toString();
    }
}
