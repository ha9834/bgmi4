package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class gi extends ThreadLocal<ByteBuffer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public gi(zzay zzayVar) {
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ ByteBuffer initialValue() {
        return ByteBuffer.allocate(32);
    }
}
