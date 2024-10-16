package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class zzddp implements zzdcc<zzdby> {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f3550a = Logger.getLogger(zzddp.class.getName());

    @Override // com.google.android.gms.internal.ads.zzdcc
    public final Class<zzdby> zzanr() {
        return zzdby.class;
    }

    /* loaded from: classes2.dex */
    static class a implements zzdby {

        /* renamed from: a, reason: collision with root package name */
        private final zzdca<zzdby> f3551a;
        private final byte[] b;

        private a(zzdca<zzdby> zzdcaVar) {
            this.b = new byte[]{0};
            this.f3551a = zzdcaVar;
        }

        @Override // com.google.android.gms.internal.ads.zzdby
        public final byte[] zzk(byte[] bArr) throws GeneralSecurityException {
            if (this.f3551a.zzanu().zzanw().equals(zzdhm.LEGACY)) {
                return zzdjs.zza(this.f3551a.zzanu().zzanx(), this.f3551a.zzanu().zzanv().zzk(zzdjs.zza(bArr, this.b)));
            }
            return zzdjs.zza(this.f3551a.zzanu().zzanx(), this.f3551a.zzanu().zzanv().zzk(bArr));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcc
    public final /* synthetic */ zzdby zza(zzdca<zzdby> zzdcaVar) throws GeneralSecurityException {
        return new a(zzdcaVar);
    }
}
