package com.vk.api.sdk.okhttp;

import java.util.Map;
import kotlin.collections.w;
import kotlin.i;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final Integer f6905a;
    private final Boolean b;
    private final String c;
    private final Integer d;

    public f() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return h.a(this.f6905a, fVar.f6905a) && h.a(this.b, fVar.b) && h.a((Object) this.c, (Object) fVar.c) && h.a(this.d, fVar.d);
    }

    public int hashCode() {
        Integer num = this.f6905a;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.b;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.c;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.d;
        return hashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        return "RequestTag(uid=" + this.f6905a + ", awaitNetwork=" + this.b + ", reason=" + ((Object) this.c) + ", retryCount=" + this.d + ')';
    }

    public f(Integer num, Boolean bool, String str, Integer num2) {
        this.f6905a = num;
        this.b = bool;
        this.c = str;
        this.d = num2;
    }

    public /* synthetic */ f(Integer num, Boolean bool, String str, Integer num2, int i, kotlin.jvm.internal.f fVar) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : num2);
    }

    public final Map<String, Object> a() {
        return w.b(i.a("UID", this.f6905a), i.a("AWAIT_NETWORK", this.b), i.a("REASON", this.c), i.a("RETRY_COUNT", this.d));
    }
}
