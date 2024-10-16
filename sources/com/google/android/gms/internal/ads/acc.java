package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class acc {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f1786a;
    static final /* synthetic */ int[] b;
    static final /* synthetic */ int[] c = new int[zzdfd.values().length];

    static {
        try {
            c[zzdfd.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            c[zzdfd.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            c[zzdfd.COMPRESSED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        b = new int[zzdgf.values().length];
        try {
            b[zzdgf.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            b[zzdgf.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            b[zzdgf.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        f1786a = new int[zzdgj.values().length];
        try {
            f1786a[zzdgj.SHA1.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f1786a[zzdgj.SHA256.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f1786a[zzdgj.SHA512.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
