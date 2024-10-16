package com.vk.api.sdk.exceptions;

import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public class VKInternalServerErrorException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VKInternalServerErrorException(int i, String str) {
        super("Server returned httpStatusCode=" + i + " with body: " + str);
        h.b(str, "detailMessage");
    }
}
