package com.vk.api.sdk.utils;

/* loaded from: classes3.dex */
public interface f<T> {
    T a();

    T a(Object obj, kotlin.e.e<?> eVar);

    /* loaded from: classes3.dex */
    public static final class a {
        public static <T> T a(f<T> fVar, Object obj, kotlin.e.e<?> eVar) {
            kotlin.jvm.internal.h.b(fVar, "this");
            kotlin.jvm.internal.h.b(eVar, "property");
            return fVar.a();
        }
    }
}
