package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;

/* loaded from: classes2.dex */
public final class zzbxu implements zzdti<String> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzbxu f3111a = new zzbxu();

    public static zzbxu zzahi() {
        return f3111a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (String) zzdto.zza(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, "Cannot return null from a non-@Nullable @Provides method");
    }
}
