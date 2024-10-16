package com.helpshift.common.domain.idempotent;

/* loaded from: classes2.dex */
public interface IdempotentPolicy {
    boolean isRequestCompleted(int i);
}
