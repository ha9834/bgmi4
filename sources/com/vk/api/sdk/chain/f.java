package com.vk.api.sdk.chain;

import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.okhttp.c;
import com.vk.api.sdk.okhttp.e;
import java.util.Locale;
import kotlin.text.l;

/* loaded from: classes3.dex */
public class f<T> extends c<T> {

    /* renamed from: a, reason: collision with root package name */
    private final com.vk.api.sdk.okhttp.c f6872a;
    private final e.a b;
    private String c;
    private final String d;
    private final com.vk.api.sdk.i<T> e;
    private final com.vk.api.sdk.j f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(com.vk.api.sdk.h hVar, com.vk.api.sdk.okhttp.c cVar, e.a aVar, String str, String str2, com.vk.api.sdk.i<T> iVar) {
        super(hVar);
        kotlin.jvm.internal.h.b(hVar, "manager");
        kotlin.jvm.internal.h.b(cVar, "okHttpExecutor");
        kotlin.jvm.internal.h.b(aVar, "callBuilder");
        kotlin.jvm.internal.h.b(str, "defaultDeviceId");
        kotlin.jvm.internal.h.b(str2, "defaultLang");
        this.f6872a = cVar;
        this.b = aVar;
        this.c = str;
        this.d = str2;
        this.e = iVar;
        this.f = hVar.a().q();
    }

    @Override // com.vk.api.sdk.chain.c
    public T a(b bVar) throws Exception {
        kotlin.jvm.internal.h.b(bVar, "args");
        if (bVar.d()) {
            this.b.a("captcha_sid", bVar.a()).a("captcha_key", bVar.b());
        }
        if (bVar.c()) {
            this.b.a("confirm", "1");
        }
        String d = this.b.d("device_id");
        if (d == null) {
            d = "";
        }
        if (l.a((CharSequence) d)) {
            d = this.c;
        }
        e.a aVar = this.b;
        Locale locale = Locale.getDefault();
        kotlin.jvm.internal.h.a((Object) locale, "getDefault()");
        if (d == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = d.toLowerCase(locale);
        kotlin.jvm.internal.h.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        aVar.a("device_id", lowerCase);
        String d2 = this.b.d("lang");
        if (d2 == null) {
            d2 = "";
        }
        if (l.a((CharSequence) d2)) {
            d2 = this.d;
        }
        e.a aVar2 = this.b;
        Locale locale2 = Locale.getDefault();
        kotlin.jvm.internal.h.a((Object) locale2, "getDefault()");
        if (d2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase2 = d2.toLowerCase(locale2);
        kotlin.jvm.internal.h.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
        aVar2.a("lang", lowerCase2);
        return a(this.b.h());
    }

    public T a(com.vk.api.sdk.okhttp.e eVar) {
        kotlin.jvm.internal.h.b(eVar, "mc");
        return a(this.f6872a.a(eVar), eVar.b(), eVar.f(), null);
    }

    public final T a(c.b bVar, String str, boolean z, int[] iArr) {
        kotlin.jvm.internal.h.b(bVar, "methodResponse");
        kotlin.jvm.internal.h.b(str, "methodName");
        String a2 = bVar.a();
        if (a2 == null) {
            throw new VKApiException("Response returned null instead of valid string response");
        }
        if (com.vk.api.sdk.utils.a.a(a2)) {
            throw com.vk.api.sdk.utils.a.a(a2, str, bVar.c());
        }
        if (com.vk.api.sdk.utils.a.a(a2, iArr)) {
            throw com.vk.api.sdk.utils.a.a(a2, str, iArr);
        }
        try {
            com.vk.api.sdk.j jVar = this.f;
            if (jVar != null) {
                jVar.a(str, z, a2, bVar.b());
            }
        } catch (Throwable unused) {
        }
        com.vk.api.sdk.i<T> iVar = this.e;
        if (iVar == null) {
            return null;
        }
        return iVar.a(a2);
    }
}
