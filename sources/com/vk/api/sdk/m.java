package com.vk.api.sdk;

/* loaded from: classes3.dex */
public interface m {
    String a(String str);

    void a(String str, String str2);

    void b(String str);

    void b(String str, String str2);

    /* loaded from: classes3.dex */
    public static final class a {
        public static void a(m mVar, String str, String str2) {
            kotlin.k kVar;
            kotlin.jvm.internal.h.b(mVar, "this");
            kotlin.jvm.internal.h.b(str, "key");
            if (str2 == null) {
                kVar = null;
            } else {
                mVar.a(str, str2);
                kVar = kotlin.k.f6974a;
            }
            if (kVar == null) {
                mVar.b(str);
            }
        }
    }
}
