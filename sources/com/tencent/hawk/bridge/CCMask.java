package com.tencent.hawk.bridge;

/* loaded from: classes2.dex */
public class CCMask {
    public static final int MSK_APM_VER = 12;
    public static final int MSK_ARCH = 6;
    public static final int MSK_CC = 13;
    public static final int MSK_GAME_VER = 10;
    public static final int MSK_GRAY_MANU = 3;
    public static final int MSK_GRAY_MODEL = 2;
    public static final int MSK_IP = 5;
    public static final int MSK_MAC = 4;
    public static final int MSK_MANU = 8;
    public static final int MSK_MODEL = 7;
    public static final int MSK_OGL_MASK = 11;
    public static final int MSK_OS_VER = 9;
    public static final int MSK_RAND_PB = 1;
    private static int sCCMask;

    public static void initCCMask(int i) {
        sCCMask = i;
    }

    public static boolean isApmVersionEnabled() {
        return ((sCCMask >> 11) & 1) == 1;
    }

    public static boolean isOglEnabled() {
        return ((sCCMask >> 10) & 1) == 1;
    }

    public static boolean isGameVersionEnabled() {
        return ((sCCMask >> 9) & 1) == 1;
    }

    public static boolean isOsVersionEnabled() {
        return ((sCCMask >> 8) & 1) == 1;
    }

    public static boolean isManuEnabled() {
        return ((sCCMask >> 7) & 1) == 1;
    }

    public static boolean isModelEnabled() {
        return ((sCCMask >> 6) & 1) == 1;
    }

    public static boolean isArchEnabled() {
        return ((sCCMask >> 5) & 1) == 1;
    }

    public static boolean isIpEnabled() {
        return ((sCCMask >> 4) & 1) == 1;
    }

    public static boolean isMacEnabled() {
        return ((sCCMask >> 3) & 1) == 1;
    }

    public static boolean isGrayManuEnabled() {
        return ((sCCMask >> 2) & 1) == 1;
    }

    public static boolean isGrayModelEnabled() {
        return ((sCCMask >> 1) & 1) == 1;
    }

    public static boolean isRandPbEnabled() {
        return ((sCCMask >> 0) & 1) == 1;
    }

    public static boolean isGrayEnabled() {
        return (sCCMask & 31) > 0;
    }
}
