package com.vk.api.sdk.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.tencent.imsdk.android.vk.IMSDKVKHelper;
import com.vk.api.sdk.a;
import com.vk.api.sdk.exceptions.VKAuthException;
import com.vk.api.sdk.m;
import com.vk.api.sdk.ui.VKWebViewAuthActivity;
import com.vk.api.sdk.utils.l;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.j;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6859a = new a(null);
    private final m b;

    public c(m mVar) {
        h.b(mVar, "keyValueStorage");
        this.b = mVar;
    }

    public final void a(Activity activity, Collection<? extends VKScope> collection) {
        h.b(activity, "activity");
        h.b(collection, "scopes");
        Activity activity2 = activity;
        d dVar = new d(com.vk.api.sdk.b.b(activity2), null, a(collection), 2, null);
        if (l.a(activity2, IMSDKVKHelper.VK_APP_AUTH_ACTION, null, IMSDKVKHelper.VK_APP_PACKAGE_ID)) {
            a(activity, dVar);
        } else {
            b(activity, dVar);
        }
    }

    private final void a(Activity activity, d dVar) {
        Intent intent = new Intent(IMSDKVKHelper.VK_APP_AUTH_ACTION, (Uri) null);
        intent.setPackage(IMSDKVKHelper.VK_APP_PACKAGE_ID);
        intent.putExtras(dVar.d());
        activity.startActivityForResult(intent, 282);
    }

    private final void b(Activity activity, d dVar) {
        VKWebViewAuthActivity.f6912a.a(activity, dVar, 282);
    }

    public final boolean a(Context context, int i, int i2, Intent intent, b bVar, boolean z) {
        h.b(context, "context");
        h.b(bVar, "callback");
        if (i != 282) {
            return false;
        }
        if (intent == null) {
            bVar.onLoginFailed(new VKAuthException(0, null, 3, null));
            return true;
        }
        e a2 = a(intent);
        if (i2 != -1 || a2 == null || a2.b()) {
            Bundle extras = intent.getExtras();
            int i3 = extras != null ? extras.getInt("vw_login_error") : 0;
            Bundle extras2 = intent.getExtras();
            VKAuthException vKAuthException = new VKAuthException(i3, extras2 != null ? extras2.getString("error") : null);
            bVar.onLoginFailed(vKAuthException);
            if (z && !vKAuthException.c()) {
                com.vk.api.sdk.a.a.a(context, a.c.vk_message_login_error);
            }
        } else {
            com.vk.api.sdk.auth.a a3 = a2.a();
            h.a(a3);
            a3.a(this.b);
            com.vk.api.sdk.b.f6862a.a().a(a2.a().b(), a2.a().c());
            bVar.onLogin(a2.a());
        }
        return true;
    }

    private final e a(Intent intent) {
        Map<String, String> map;
        if (intent.hasExtra("extra-token-data")) {
            map = l.a(intent.getStringExtra("extra-token-data"));
        } else {
            if (intent.getExtras() == null) {
                return null;
            }
            HashMap hashMap = new HashMap();
            Bundle extras = intent.getExtras();
            h.a(extras);
            for (String str : extras.keySet()) {
                h.a((Object) str, "key");
                Bundle extras2 = intent.getExtras();
                h.a(extras2);
                hashMap.put(str, String.valueOf(extras2.get(str)));
            }
            map = hashMap;
        }
        if (map == null || map.get("error") != null) {
            return null;
        }
        try {
            return new e(new com.vk.api.sdk.auth.a(map), 0, 2, null);
        } catch (Exception e) {
            Log.e(c.class.getSimpleName(), "Failed to get VK token", e);
            return (e) null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Collection<VKScope> a(Collection<? extends VKScope> collection) {
        return !collection.contains(VKScope.OFFLINE) ? j.a(collection, VKScope.OFFLINE) : collection;
    }

    public final boolean a() {
        com.vk.api.sdk.auth.a b = b();
        return b != null && b.d();
    }

    public final com.vk.api.sdk.auth.a b() {
        return com.vk.api.sdk.auth.a.f6858a.b(this.b);
    }

    public final void c() {
        com.vk.api.sdk.auth.a.f6858a.a(this.b);
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        private a() {
        }
    }
}
