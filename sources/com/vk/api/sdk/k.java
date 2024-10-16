package com.vk.api.sdk;

import com.tencent.imsdk.android.IR;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public interface k {
    void a(VKApiExecutionException vKApiExecutionException, h hVar) throws VKApiExecutionException;

    void a(String str, a<String> aVar);

    void b(String str, a<b> aVar);

    void c(String str, a<Boolean> aVar);

    /* loaded from: classes3.dex */
    public static final class c {
        public static void a(k kVar, VKApiExecutionException vKApiExecutionException, h hVar) throws VKApiExecutionException {
            kotlin.jvm.internal.h.b(kVar, "this");
            kotlin.jvm.internal.h.b(vKApiExecutionException, IR.path.DOCS_EXTRA_MSG);
            kotlin.jvm.internal.h.b(hVar, "apiManager");
            throw vKApiExecutionException;
        }
    }

    /* loaded from: classes3.dex */
    public static class a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final CountDownLatch f6886a;
        private volatile T b;

        public a(CountDownLatch countDownLatch) {
            kotlin.jvm.internal.h.b(countDownLatch, "latch");
            this.f6886a = countDownLatch;
        }

        public final T a() {
            return this.b;
        }

        public void b() {
            this.f6886a.countDown();
        }

        public void a(T t) {
            this.b = t;
            this.f6886a.countDown();
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6887a = new a(null);
        private static final b f = new b("", "", null);
        private final String b;
        private final String c;
        private final Integer d;
        private final boolean e;

        public b(String str, String str2, Integer num) {
            this.b = str;
            this.c = str2;
            this.d = num;
            String str3 = this.c;
            this.e = !(str3 == null || kotlin.text.l.a((CharSequence) str3));
        }

        public final String a() {
            return this.b;
        }

        public final String b() {
            return this.c;
        }

        public final boolean c() {
            return this.e;
        }

        /* loaded from: classes3.dex */
        public static final class a {
            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }

            private a() {
            }

            public final b a() {
                return b.f;
            }
        }
    }
}
