package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class zzdck implements zzdcc<zzdbj> {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f3543a = Logger.getLogger(zzdck.class.getName());

    @Override // com.google.android.gms.internal.ads.zzdcc
    public final Class<zzdbj> zzanr() {
        return zzdbj.class;
    }

    /* loaded from: classes2.dex */
    static class a implements zzdbj {

        /* renamed from: a, reason: collision with root package name */
        private final zzdca<zzdbj> f3544a;

        private a(zzdca<zzdbj> zzdcaVar) {
            this.f3544a = zzdcaVar;
        }

        @Override // com.google.android.gms.internal.ads.zzdbj
        public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            return zzdjs.zza(this.f3544a.zzanu().zzanx(), this.f3544a.zzanu().zzanv().zzc(bArr, bArr2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcc
    public final /* synthetic */ zzdbj zza(zzdca<zzdbj> zzdcaVar) throws GeneralSecurityException {
        return new a(zzdcaVar);
    }
}
