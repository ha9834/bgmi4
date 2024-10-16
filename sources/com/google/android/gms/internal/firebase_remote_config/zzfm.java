package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzfm;
import com.google.android.gms.internal.firebase_remote_config.zzfp;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzfm<MessageType extends zzfm<MessageType, BuilderType>, BuilderType extends zzfp<MessageType, BuilderType>> implements zzim {
    private static boolean zzok;
    protected int zzoj = 0;

    @Override // com.google.android.gms.internal.firebase_remote_config.zzim
    public final zzfx zzeo() {
        try {
            bm b = zzfx.b(zzgy());
            zzb(b.b());
            return b.a();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("ByteString").length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        throw new UnsupportedOperationException();
    }
}
