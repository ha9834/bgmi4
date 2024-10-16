package com.vk.api.sdk.exceptions;

import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public class VKLargeEntityException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VKLargeEntityException(String str) {
        super(str);
        h.b(str, "detailMessage");
    }
}
