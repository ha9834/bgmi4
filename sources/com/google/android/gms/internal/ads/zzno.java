package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public interface zzno {
    long getLength();

    long getPosition();

    int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    boolean zza(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException;

    int zzaq(int i) throws IOException, InterruptedException;

    void zzar(int i) throws IOException, InterruptedException;

    void zzc(byte[] bArr, int i, int i2) throws IOException, InterruptedException;

    void zzig();

    void zzr(int i) throws IOException, InterruptedException;
}
