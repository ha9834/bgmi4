package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import com.google.android.gms.internal.ads.zzdpk;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public abstract class zzdbt<P, KeyProto extends zzdpk, KeyFormatProto extends zzdpk> implements zzdbs<P> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<P> f3536a;
    private final Class<KeyProto> b;
    private final Class<KeyFormatProto> c;
    private final String d;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdbt(Class<P> cls, Class<KeyProto> cls2, Class<KeyFormatProto> cls3, String str) {
        this.f3536a = cls;
        this.b = cls2;
        this.c = cls3;
        this.d = str;
    }

    protected abstract zzdgr.zzb a();

    protected abstract KeyProto a(zzdmr zzdmrVar) throws zzdok;

    protected abstract void a(KeyProto keyproto) throws GeneralSecurityException;

    protected abstract KeyFormatProto b(zzdmr zzdmrVar) throws zzdok;

    protected abstract void b(KeyFormatProto keyformatproto) throws GeneralSecurityException;

    protected abstract P c(KeyProto keyproto) throws GeneralSecurityException;

    protected abstract KeyProto d(KeyFormatProto keyformatproto) throws GeneralSecurityException;

    /* JADX WARN: Multi-variable type inference failed */
    private static <Casted> Casted a(Object obj, String str, Class<Casted> cls) throws GeneralSecurityException {
        if (cls.isInstance(obj)) {
            return obj;
        }
        throw new GeneralSecurityException(str);
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final P zzp(zzdmr zzdmrVar) throws GeneralSecurityException {
        try {
            return e(a(zzdmrVar));
        } catch (zzdok e) {
            String valueOf = String.valueOf(this.b.getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdbs
    public final P zza(zzdpk zzdpkVar) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.b.getName());
        return (P) e((zzdpk) a(zzdpkVar, valueOf.length() != 0 ? "Expected proto of type ".concat(valueOf) : new String("Expected proto of type "), this.b));
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final zzdpk zzq(zzdmr zzdmrVar) throws GeneralSecurityException {
        try {
            return f(b(zzdmrVar));
        } catch (zzdok e) {
            String valueOf = String.valueOf(this.c.getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdbs
    public final zzdpk zzb(zzdpk zzdpkVar) throws GeneralSecurityException {
        String valueOf = String.valueOf(this.c.getName());
        return f((zzdpk) a(zzdpkVar, valueOf.length() != 0 ? "Expected proto of type ".concat(valueOf) : new String("Expected proto of type "), this.c));
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final String getKeyType() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final zzdgr zzr(zzdmr zzdmrVar) throws GeneralSecurityException {
        try {
            return (zzdgr) ((zzdob) zzdgr.zzarw().zzgk(this.d).zzbo(f(b(zzdmrVar)).zzavf()).zzb(a()).zzaya());
        } catch (zzdok e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final Class<P> zzanr() {
        return this.f3536a;
    }

    private final P e(KeyProto keyproto) throws GeneralSecurityException {
        a((zzdbt<P, KeyProto, KeyFormatProto>) keyproto);
        return c(keyproto);
    }

    private final KeyProto f(KeyFormatProto keyformatproto) throws GeneralSecurityException {
        b((zzdbt<P, KeyProto, KeyFormatProto>) keyformatproto);
        KeyProto d = d(keyformatproto);
        a((zzdbt<P, KeyProto, KeyFormatProto>) d);
        return d;
    }
}
