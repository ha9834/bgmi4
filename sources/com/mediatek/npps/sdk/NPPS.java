package com.mediatek.npps.sdk;

import android.os.IInterface;

/* loaded from: classes2.dex */
public class NPPS {
    public static final int VERSION = 400;

    public static native int clCt();

    public static native void dDPPCb();

    public static native boolean eDPPCb(int i);

    public static native boolean iDPPeb();

    public static native boolean iSpt();

    public static native boolean rgDPPEt(IInterface iInterface);

    public static native AtRes sAt(byte[] bArr);

    public static native CtRes sCt(byte[] bArr, byte[] bArr2);

    public static native boolean spDPP();

    public static native int spNLO();

    public static native boolean stDPP();

    public static native int stNLO(int i, String str, int i2, String str2, int i3);

    public static native boolean ugDPPEt(IInterface iInterface);

    public static native boolean upMDPL(DLI[] dliArr);
}
