package com.nostra13.universalimageloader.core.assist;

/* loaded from: classes2.dex */
public class FailReason {

    /* renamed from: a, reason: collision with root package name */
    private final FailType f5728a;
    private final Throwable b;

    /* loaded from: classes2.dex */
    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th) {
        this.f5728a = failType;
        this.b = th;
    }
}
