package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.util.zzp;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ InputStream f3860a;
    private /* synthetic */ OutputStream b;
    private /* synthetic */ long c;
    private /* synthetic */ OutputStream d;
    private /* synthetic */ zzctz e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(zzctz zzctzVar, InputStream inputStream, OutputStream outputStream, long j, OutputStream outputStream2) {
        this.e = zzctzVar;
        this.f3860a = inputStream;
        this.b = outputStream;
        this.c = j;
        this.d = outputStream2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        Throwable th;
        boolean z;
        this.e.b = this.f3860a;
        boolean z2 = true;
        try {
            zzp.zza(this.f3860a, this.b, false, 65536);
            zzp.closeQuietly(this.f3860a);
            zzctz zzctzVar = this.e;
            zzctz.a(this.d, false, this.c);
        } catch (IOException e) {
            try {
                z = this.e.c;
                if (z) {
                    Log.d("NearbyConnections", String.format("Terminating copying stream for Payload %d due to shutdown of OutgoingPayloadStreamer.", Long.valueOf(this.c)));
                } else {
                    Log.w("NearbyConnections", String.format("Exception copying stream for Payload %d", Long.valueOf(this.c)), e);
                }
                zzp.closeQuietly(this.f3860a);
                zzctz zzctzVar2 = this.e;
                zzctz.a(this.d, true, this.c);
            } catch (Throwable th2) {
                th = th2;
                zzp.closeQuietly(this.f3860a);
                zzctz zzctzVar3 = this.e;
                zzctz.a(this.d, z2, this.c);
                zzp.closeQuietly(this.b);
                this.e.b = null;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            zzp.closeQuietly(this.f3860a);
            zzctz zzctzVar32 = this.e;
            zzctz.a(this.d, z2, this.c);
            zzp.closeQuietly(this.b);
            this.e.b = null;
            throw th;
        }
        zzp.closeQuietly(this.b);
        this.e.b = null;
    }
}
