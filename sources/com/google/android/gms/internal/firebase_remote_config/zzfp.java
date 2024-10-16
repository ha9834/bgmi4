package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzfm;
import com.google.android.gms.internal.firebase_remote_config.zzfp;

/* loaded from: classes2.dex */
public abstract class zzfp<MessageType extends zzfm<MessageType, BuilderType>, BuilderType extends zzfp<MessageType, BuilderType>> implements zzip {
    protected abstract BuilderType a(MessageType messagetype);

    @Override // 
    /* renamed from: zzeq, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.firebase_remote_config.zzip
    public final /* synthetic */ zzip zza(zzim zzimVar) {
        if (!zzgx().getClass().isInstance(zzimVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return a((zzfm) zzimVar);
    }
}
