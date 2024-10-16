package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest;

/* loaded from: classes2.dex */
final /* synthetic */ class dg {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f2119a = new int[AdRequest.ErrorCode.values().length];
    private static final /* synthetic */ int[] b;

    static {
        try {
            f2119a[AdRequest.ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2119a[AdRequest.ErrorCode.INVALID_REQUEST.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f2119a[AdRequest.ErrorCode.NETWORK_ERROR.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f2119a[AdRequest.ErrorCode.NO_FILL.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        b = new int[AdRequest.Gender.values().length];
        try {
            b[AdRequest.Gender.FEMALE.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            b[AdRequest.Gender.MALE.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            b[AdRequest.Gender.UNKNOWN.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
