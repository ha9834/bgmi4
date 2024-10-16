package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public class zzcgm extends Exception {
    private final int errorCode;

    public static int zze(Throwable th) {
        if (th instanceof zzcgm) {
            return ((zzcgm) th).errorCode;
        }
        if (th instanceof zzayn) {
            return ((zzayn) th).getErrorCode();
        }
        return 0;
    }

    public zzcgm(int i) {
        this.errorCode = i;
    }

    public zzcgm(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public zzcgm(String str, Throwable th, int i) {
        super(str, th);
        this.errorCode = 0;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
