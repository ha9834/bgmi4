package com.vk.api.sdk.chain;

import com.vk.api.sdk.k;
import kotlin.jvm.a.q;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* loaded from: classes3.dex */
/* synthetic */ class ValidationHandlerChainCall$handleValidation$credentials$1 extends FunctionReferenceImpl implements q<k, String, k.a<k.b>, kotlin.k> {

    /* renamed from: a, reason: collision with root package name */
    public static final ValidationHandlerChainCall$handleValidation$credentials$1 f6866a = new ValidationHandlerChainCall$handleValidation$credentials$1();

    ValidationHandlerChainCall$handleValidation$credentials$1() {
        super(3, k.class, "handleValidation", "handleValidation(Ljava/lang/String;Lcom/vk/api/sdk/VKApiValidationHandler$Callback;)V", 0);
    }

    @Override // kotlin.jvm.a.q
    public /* bridge */ /* synthetic */ kotlin.k a(k kVar, String str, k.a<k.b> aVar) {
        a2(kVar, str, aVar);
        return kotlin.k.f6974a;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public final void a2(k kVar, String str, k.a<k.b> aVar) {
        kotlin.jvm.internal.h.b(kVar, "p0");
        kotlin.jvm.internal.h.b(str, "p1");
        kotlin.jvm.internal.h.b(aVar, "p2");
        kVar.b(str, aVar);
    }
}
