package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class aea {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f1825a;
    static final /* synthetic */ int[] b = new int[zzdkt.values().length];

    static {
        try {
            b[zzdkt.NIST_P256.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[zzdkt.NIST_P384.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[zzdkt.NIST_P521.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f1825a = new int[zzdkv.values().length];
        try {
            f1825a[zzdkv.UNCOMPRESSED.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f1825a[zzdkv.DO_NOT_USE_CRUNCHY_UNCOMPRESSED.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f1825a[zzdkv.COMPRESSED.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
    }
}
