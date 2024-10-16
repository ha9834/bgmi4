package com.vk.api.sdk.internal;

import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.h;
import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class a<Response> {
    protected abstract Response b(h hVar) throws InterruptedException, IOException, VKApiException;

    public final Response a(h hVar) throws InterruptedException, IOException, VKApiException {
        kotlin.jvm.internal.h.b(hVar, "manager");
        return b(hVar);
    }
}
