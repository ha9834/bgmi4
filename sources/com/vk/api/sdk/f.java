package com.vk.api.sdk;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.LazyThreadSafetyMode;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6879a = new a(null);
    private final String b;
    private final String c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kotlin.jvm.internal.h.a((Object) this.b, (Object) fVar.b) && kotlin.jvm.internal.h.a((Object) this.c, (Object) fVar.c);
    }

    public int hashCode() {
        int hashCode = this.b.hashCode() * 31;
        String str = this.c;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "VKApiCredentials(accessToken=" + this.b + ", secret=" + ((Object) this.c) + ')';
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }

        public final kotlin.c<f> a(final String str, final String str2) {
            kotlin.jvm.internal.h.b(str, SDKConstants.PARAM_ACCESS_TOKEN);
            return kotlin.d.a(LazyThreadSafetyMode.NONE, new kotlin.jvm.a.a<f>() { // from class: com.vk.api.sdk.VKApiCredentials$Companion$lazyFrom$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.a.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final f b() {
                    return new f(str, str2);
                }
            });
        }

        public final kotlin.c<f> a(final kotlin.jvm.a.a<com.vk.api.sdk.auth.a> aVar) {
            kotlin.jvm.internal.h.b(aVar, "tokenProvider");
            return kotlin.d.a(new kotlin.jvm.a.a<f>() { // from class: com.vk.api.sdk.VKApiCredentials$Companion$lazyFrom$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.a.a
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final f b() {
                    String b;
                    com.vk.api.sdk.auth.a b2 = aVar.b();
                    if (b2 == null || (b = b2.b()) == null) {
                        b = "";
                    }
                    return new f(b, b2 == null ? null : b2.c());
                }
            });
        }
    }

    public f(String str, String str2) {
        kotlin.jvm.internal.h.b(str, SDKConstants.PARAM_ACCESS_TOKEN);
        this.b = str;
        this.c = str2;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }
}
