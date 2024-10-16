package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzax extends zzby implements Cloneable {
    private zzaw c;

    public final void zza(zzaw zzawVar) {
        this.c = zzawVar;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        zzaw zzawVar = this.c;
        if (zzawVar != null) {
            try {
                return zzawVar.toString(this);
            } catch (IOException e) {
                throw zzeb.zzb(e);
            }
        }
        return super.toString();
    }

    public final String zzaq() throws IOException {
        zzaw zzawVar = this.c;
        if (zzawVar != null) {
            return zzawVar.zzc(this);
        }
        return super.toString();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzby, java.util.AbstractMap
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public zzax clone() {
        return (zzax) super.clone();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzby
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public zzax zzb(String str, Object obj) {
        return (zzax) super.zzb(str, obj);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzby
    /* renamed from: zzb */
    public /* synthetic */ zzby clone() {
        return (zzax) clone();
    }
}
