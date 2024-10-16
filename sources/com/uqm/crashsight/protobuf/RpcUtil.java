package com.uqm.crashsight.protobuf;

/* loaded from: classes3.dex */
public final class RpcUtil {
    private RpcUtil() {
    }

    /* loaded from: classes3.dex */
    public static final class AlreadyCalledException extends RuntimeException {
        public AlreadyCalledException() {
            super("This RpcCallback was already called and cannot be called multiple times.");
        }
    }
}
