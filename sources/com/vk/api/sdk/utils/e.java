package com.vk.api.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import kotlin.Pair;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final b f6921a;
    private final long b;
    private final long c;
    private final float d;
    private final kotlin.jvm.a.a<Long> e;

    /* loaded from: classes3.dex */
    public interface b {
        Pair<Long, Integer> a(String str, long j);

        boolean a(String str);

        void b(String str);

        void b(String str, long j);
    }

    public e(b bVar, long j, long j2, float f, kotlin.jvm.a.a<Long> aVar) {
        kotlin.jvm.internal.h.b(bVar, "store");
        kotlin.jvm.internal.h.b(aVar, "timeProvider");
        this.f6921a = bVar;
        this.b = j;
        this.c = j2;
        this.d = f;
        this.e = aVar;
    }

    public /* synthetic */ e(b bVar, long j, long j2, float f, kotlin.jvm.a.a aVar, int i, kotlin.jvm.internal.f fVar) {
        this(bVar, j, (i & 4) != 0 ? j : j2, (i & 8) != 0 ? 1.5f : f, (i & 16) != 0 ? new kotlin.jvm.a.a<Long>() { // from class: com.vk.api.sdk.utils.RateLimitTokenBackoff$1
            public final long a() {
                return SystemClock.elapsedRealtime();
            }

            @Override // kotlin.jvm.a.a
            public /* synthetic */ Long b() {
                return Long.valueOf(a());
            }
        } : aVar);
    }

    public final boolean a(String str) {
        kotlin.jvm.internal.h.b(str, "operationKey");
        return b(str) > 0;
    }

    public final long b(String str) {
        kotlin.jvm.internal.h.b(str, "operationKey");
        if (!this.f6921a.a(str)) {
            return 0L;
        }
        Pair<Long, Integer> a2 = this.f6921a.a(str, Long.MAX_VALUE);
        long longValue = a2.c().longValue();
        int intValue = a2.d().intValue();
        long a3 = a() - longValue;
        long a4 = a(intValue);
        if (a3 >= 0 && a3 < a4) {
            return a4 - a3;
        }
        return 0L;
    }

    public final void c(String str) {
        kotlin.jvm.internal.h.b(str, "operationKey");
        if (this.f6921a.a(str)) {
            this.f6921a.b(str);
        }
    }

    public final void d(String str) {
        kotlin.jvm.internal.h.b(str, "operationKey");
        this.f6921a.b(str, a());
    }

    private final long a() {
        return this.e.b().longValue();
    }

    private final long a(int i) {
        long j = this.b;
        for (int i2 = 0; i2 < i; i2++) {
            j = ((float) j) * this.d;
        }
        return Math.min(j, this.c);
    }

    /* loaded from: classes3.dex */
    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public static final C0224a f6922a = new C0224a(null);
        private final kotlin.c b;

        public a(final Context context) {
            kotlin.jvm.internal.h.b(context, "context");
            this.b = kotlin.d.a(new kotlin.jvm.a.a<SharedPreferences>() { // from class: com.vk.api.sdk.utils.RateLimitTokenBackoff$TokenPrefStore$prefStorage$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.a.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final SharedPreferences b() {
                    return context.getSharedPreferences("rate_limit_backoff_storage", 0);
                }
            });
        }

        private final SharedPreferences a() {
            return (SharedPreferences) this.b.a();
        }

        @Override // com.vk.api.sdk.utils.e.b
        public boolean a(String str) {
            kotlin.jvm.internal.h.b(str, "token");
            return a().contains(str);
        }

        @Override // com.vk.api.sdk.utils.e.b
        public void b(String str) {
            kotlin.jvm.internal.h.b(str, "token");
            a().edit().remove(str).apply();
        }

        @Override // com.vk.api.sdk.utils.e.b
        public Pair<Long, Integer> a(String str, long j) {
            kotlin.jvm.internal.h.b(str, "token");
            return kotlin.i.a(Long.valueOf(a().getLong(str, j)), 0);
        }

        @Override // com.vk.api.sdk.utils.e.b
        public void b(String str, long j) {
            kotlin.jvm.internal.h.b(str, "token");
            a().edit().putLong(str, j).apply();
        }

        /* renamed from: com.vk.api.sdk.utils.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0224a {
            public /* synthetic */ C0224a(kotlin.jvm.internal.f fVar) {
                this();
            }

            private C0224a() {
            }
        }
    }
}
