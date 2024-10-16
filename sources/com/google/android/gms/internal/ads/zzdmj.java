package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdmi;
import com.google.android.gms.internal.ads.zzdmj;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzdmj<MessageType extends zzdmi<MessageType, BuilderType>, BuilderType extends zzdmj<MessageType, BuilderType>> implements zzdpl {
    protected abstract BuilderType a(MessageType messagetype);

    public abstract BuilderType zza(zzdnd zzdndVar, zzdno zzdnoVar) throws IOException;

    @Override // 
    /* renamed from: zzavh, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2, zzdno zzdnoVar) throws zzdok {
        try {
            zzdnd a2 = zzdnd.a(bArr, 0, i2, false);
            zza(a2, zzdnoVar);
            a2.zzfp(0);
            return this;
        } catch (zzdok e) {
            throw e;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + String.valueOf("byte array").length());
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdpl
    public final /* synthetic */ zzdpl zzi(zzdpk zzdpkVar) {
        if (!zzaxv().getClass().isInstance(zzdpkVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return a((zzdmi) zzdpkVar);
    }
}
