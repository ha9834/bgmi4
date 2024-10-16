package com.vk.api.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.vk.api.sdk.m;

/* loaded from: classes3.dex */
public final class p implements m {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6907a = new a(null);
    private final SharedPreferences b;

    public p(Context context, String str) {
        kotlin.jvm.internal.h.b(context, "context");
        kotlin.jvm.internal.h.b(str, "prefsName");
        this.b = context.getSharedPreferences(str, 0);
    }

    public /* synthetic */ p(Context context, String str, int i, kotlin.jvm.internal.f fVar) {
        this(context, (i & 2) != 0 ? "com.vkontakte.android_pref_name" : str);
    }

    @Override // com.vk.api.sdk.m
    public void b(String str, String str2) {
        m.a.a(this, str, str2);
    }

    @Override // com.vk.api.sdk.m
    public void a(String str, String str2) {
        kotlin.jvm.internal.h.b(str, "key");
        kotlin.jvm.internal.h.b(str2, "value");
        this.b.edit().putString(str, str2).apply();
    }

    @Override // com.vk.api.sdk.m
    public String a(String str) {
        kotlin.jvm.internal.h.b(str, "key");
        return this.b.getString(str, null);
    }

    @Override // com.vk.api.sdk.m
    public void b(String str) {
        kotlin.jvm.internal.h.b(str, "key");
        this.b.edit().remove(str).apply();
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        private a() {
        }
    }
}
