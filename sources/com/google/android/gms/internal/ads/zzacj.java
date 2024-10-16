package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public abstract class zzacj<T> {

    /* renamed from: a, reason: collision with root package name */
    private final int f2697a;
    private final String b;
    private final T c;

    private zzacj(int i, String str, T t) {
        this.f2697a = i;
        this.b = str;
        this.c = t;
        zzyt.zzpd().zza(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T a(SharedPreferences sharedPreferences);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T a(JSONObject jSONObject);

    public abstract T zza(Bundle bundle);

    public abstract void zza(SharedPreferences.Editor editor, T t);

    public final String getKey() {
        return this.b;
    }

    public final T zzqm() {
        return this.c;
    }

    public static zzacj<Boolean> zza(int i, String str, Boolean bool) {
        return new l(i, str, bool);
    }

    public static zzacj<Integer> zza(int i, String str, int i2) {
        return new m(i, str, Integer.valueOf(i2));
    }

    public static zzacj<Long> zza(int i, String str, long j) {
        return new n(i, str, Long.valueOf(j));
    }

    public static zzacj<Float> zza(int i, String str, float f) {
        return new o(i, str, Float.valueOf(f));
    }

    public static zzacj<String> zza(int i, String str, String str2) {
        return new p(i, str, str2);
    }

    public static zzacj<String> zzb(int i, String str) {
        zzacj<String> zza = zza(i, str, (String) null);
        zzyt.zzpd().zzb(zza);
        return zza;
    }

    public static zzacj<String> zzc(int i, String str) {
        zzacj<String> zza = zza(i, str, (String) null);
        zzyt.zzpd().zzc(zza);
        return zza;
    }

    public final int getSource() {
        return this.f2697a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzacj(int i, String str, Object obj, l lVar) {
        this(i, str, obj);
    }
}
