package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzpl;
import com.google.android.gms.internal.gtm.zzpm;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzpl<MessageType extends zzpl<MessageType, BuilderType>, BuilderType extends zzpm<MessageType, BuilderType>> implements zzsk {
    private static boolean zzavq;
    protected int zzavp = 0;

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final zzps zzmv() {
        try {
            bf b = zzps.b(zzpe());
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
