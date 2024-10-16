package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@VisibleForTesting
/* loaded from: classes2.dex */
final class apa {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private ByteArrayOutputStream f2023a = new ByteArrayOutputStream(4096);

    @VisibleForTesting
    private Base64OutputStream b = new Base64OutputStream(this.f2023a, 10);

    public final void a(byte[] bArr) throws IOException {
        this.b.write(bArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        try {
            this.b.close();
        } catch (IOException e) {
            zzawz.zzc("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.f2023a.close();
            return this.f2023a.toString();
        } catch (IOException e2) {
            zzawz.zzc("HashManager: Unable to convert to Base64.", e2);
            return "";
        } finally {
            this.f2023a = null;
            this.b = null;
        }
    }
}
