package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class zzdde implements zzdcc<zzdbp> {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f3547a = Logger.getLogger(zzdde.class.getName());

    /* loaded from: classes2.dex */
    static class a implements zzdbp {

        /* renamed from: a, reason: collision with root package name */
        private final zzdca<zzdbp> f3548a;

        public a(zzdca<zzdbp> zzdcaVar) {
            this.f3548a = zzdcaVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcc
    public final Class<zzdbp> zzanr() {
        return zzdbp.class;
    }

    @Override // com.google.android.gms.internal.ads.zzdcc
    public final /* synthetic */ zzdbp zza(zzdca<zzdbp> zzdcaVar) throws GeneralSecurityException {
        return new a(zzdcaVar);
    }
}
