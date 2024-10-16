package com.vk.api.sdk.exceptions;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public class VKApiException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6878a = new a(null);
    public static final long serialVersionUID = 1221900559703281428L;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VKApiException(String str) {
        super(str);
        h.b(str, "detailMessage");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VKApiException(String str, Throwable th) {
        super(str, th);
        h.b(str, "detailMessage");
        h.b(th, "throwable");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VKApiException(Throwable th) {
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
