package com.vk.api.sdk.exceptions;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class VKApiIllegalResponseException extends VKApiException {
    public static final a b = new a(null);
    public static final long serialVersionUID = 1632913732314330746L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VKApiIllegalResponseException(String str, Throwable th) {
        super(str, th);
        h.b(str, "detailMessage");
        h.b(th, "throwable");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VKApiIllegalResponseException(Throwable th) {
        super(th);
        h.b(th, "throwable");
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
        }
    }
}
