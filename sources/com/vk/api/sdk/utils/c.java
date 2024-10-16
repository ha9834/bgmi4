package com.vk.api.sdk.utils;

import android.graphics.Point;
import android.os.Build;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class c implements i {

    /* renamed from: a, reason: collision with root package name */
    private final String f6919a;
    private final String b;
    private final String c;
    private final Point d;
    private final kotlin.c e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.h.a((Object) this.f6919a, (Object) cVar.f6919a) && kotlin.jvm.internal.h.a((Object) this.b, (Object) cVar.b) && kotlin.jvm.internal.h.a((Object) this.c, (Object) cVar.c) && kotlin.jvm.internal.h.a(this.d, cVar.d);
    }

    public int hashCode() {
        return (((((this.f6919a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "DefaultUserAgent(prefix=" + this.f6919a + ", appVersion=" + this.b + ", appBuild=" + this.c + ", displaySize=" + this.d + ')';
    }

    public c(String str, String str2, String str3, Point point) {
        kotlin.jvm.internal.h.b(str, "prefix");
        kotlin.jvm.internal.h.b(str2, "appVersion");
        kotlin.jvm.internal.h.b(str3, "appBuild");
        kotlin.jvm.internal.h.b(point, "displaySize");
        this.f6919a = str;
        this.b = str2;
        this.c = str3;
        this.d = point;
        this.e = kotlin.d.a(new kotlin.jvm.a.a<String>() { // from class: com.vk.api.sdk.utils.DefaultUserAgent$stringify$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final String b() {
                kotlin.jvm.internal.l lVar = kotlin.jvm.internal.l.f6973a;
                Locale locale = Locale.US;
                Object[] objArr = {c.this.a(), c.this.b(), c.this.c(), Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT), Build.CPU_ABI, Build.MANUFACTURER, Build.MODEL, System.getProperty("user.language"), Integer.valueOf(Math.max(c.this.d().x, c.this.d().y)), Integer.valueOf(Math.min(c.this.d().x, c.this.d().y))};
                String format = String.format(locale, "%s/%s-%s (Android %s; SDK %d; %s; %s %s; %s; %dx%d)", Arrays.copyOf(objArr, objArr.length));
                kotlin.jvm.internal.h.a((Object) format, "java.lang.String.format(locale, format, *args)");
                return l.b(format);
            }
        });
    }

    public final String a() {
        return this.f6919a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final Point d() {
        return this.d;
    }

    private final String f() {
        return (String) this.e.a();
    }

    @Override // com.vk.api.sdk.utils.i
    public String e() {
        return f();
    }
}
