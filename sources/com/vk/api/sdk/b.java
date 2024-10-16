package com.vk.api.sdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;
import com.vk.api.sdk.auth.VKScope;
import com.vk.api.sdk.exceptions.VKApiException;
import com.vk.api.sdk.exceptions.VKApiExecutionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class b {
    public static h b;

    @SuppressLint({"StaticFieldLeak"})
    private static e c;
    private static com.vk.api.sdk.auth.c d;
    private static int f;

    /* renamed from: a, reason: collision with root package name */
    public static final b f6862a = new b();
    private static final ArrayList<r> e = new ArrayList<>();
    private static final kotlin.c g = kotlin.d.a(new kotlin.jvm.a.a<com.vk.api.sdk.utils.k>() { // from class: com.vk.api.sdk.VK$urlResolver$2
        @Override // kotlin.jvm.a.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final com.vk.api.sdk.utils.k b() {
            return new com.vk.api.sdk.utils.k();
        }
    });

    public static final boolean a(int i, int i2, Intent intent, com.vk.api.sdk.auth.b bVar) {
        kotlin.jvm.internal.h.b(bVar, "callback");
        return a(i, i2, intent, bVar, false, 16, null);
    }

    private b() {
    }

    public final h a() {
        h hVar = b;
        if (hVar != null) {
            return hVar;
        }
        kotlin.jvm.internal.h.b("apiManager");
        throw null;
    }

    public final void a(h hVar) {
        kotlin.jvm.internal.h.b(hVar, "<set-?>");
        b = hVar;
    }

    public static final void a(e eVar) {
        kotlin.jvm.internal.h.b(eVar, ConfigDBHelper.TABLE_NAME_CONFIG);
        b bVar = f6862a;
        c = eVar;
        bVar.a(new h(eVar));
        b bVar2 = f6862a;
        d = new com.vk.api.sdk.auth.c(eVar.l());
        f6862a.a().a(f.f6879a.a(new kotlin.jvm.a.a<com.vk.api.sdk.auth.a>() { // from class: com.vk.api.sdk.VK$setConfig$1
            @Override // kotlin.jvm.a.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final com.vk.api.sdk.auth.a b() {
                com.vk.api.sdk.auth.c cVar;
                cVar = b.d;
                if (cVar != null) {
                    return cVar.b();
                }
                kotlin.jvm.internal.h.b("authManager");
                throw null;
            }
        }));
    }

    public static final void a(Activity activity, Collection<? extends VKScope> collection) {
        kotlin.jvm.internal.h.b(activity, "activity");
        kotlin.jvm.internal.h.b(collection, "scopes");
        com.vk.api.sdk.auth.c cVar = d;
        if (cVar != null) {
            cVar.a(activity, collection);
        } else {
            kotlin.jvm.internal.h.b("authManager");
            throw null;
        }
    }

    public static final void b() {
        com.vk.api.sdk.auth.c cVar = d;
        if (cVar == null) {
            kotlin.jvm.internal.h.b("authManager");
            throw null;
        }
        cVar.c();
        com.vk.api.sdk.utils.l lVar = com.vk.api.sdk.utils.l.f6927a;
        e eVar = c;
        if (eVar != null) {
            lVar.a(eVar.a());
        } else {
            kotlin.jvm.internal.h.b(ConfigDBHelper.TABLE_NAME_CONFIG);
            throw null;
        }
    }

    public static final boolean c() {
        com.vk.api.sdk.auth.c cVar = d;
        if (cVar != null) {
            return cVar.a();
        }
        kotlin.jvm.internal.h.b("authManager");
        throw null;
    }

    public static final String d() {
        e eVar = c;
        if (eVar != null) {
            return eVar.e();
        }
        kotlin.jvm.internal.h.b(ConfigDBHelper.TABLE_NAME_CONFIG);
        throw null;
    }

    public static /* synthetic */ boolean a(int i, int i2, Intent intent, com.vk.api.sdk.auth.b bVar, boolean z, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z = true;
        }
        return a(i, i2, intent, bVar, z);
    }

    public static final boolean a(int i, int i2, Intent intent, com.vk.api.sdk.auth.b bVar, boolean z) {
        kotlin.jvm.internal.h.b(bVar, "callback");
        com.vk.api.sdk.auth.c cVar = d;
        if (cVar == null) {
            kotlin.jvm.internal.h.b("authManager");
            throw null;
        }
        e eVar = c;
        if (eVar == null) {
            kotlin.jvm.internal.h.b(ConfigDBHelper.TABLE_NAME_CONFIG);
            throw null;
        }
        boolean a2 = cVar.a(eVar.a(), i, i2, intent, bVar, z);
        if (a2) {
            b bVar2 = f6862a;
            if (c()) {
                f6862a.h();
            }
        }
        return a2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void e() {
        com.vk.api.sdk.auth.c cVar = d;
        if (cVar == null) {
            kotlin.jvm.internal.h.b("authManager");
            throw null;
        }
        cVar.c();
        Iterator<T> it = e.iterator();
        while (it.hasNext()) {
            ((r) it.next()).a();
        }
    }

    public static final <T> T a(com.vk.api.sdk.internal.a<T> aVar) throws InterruptedException, IOException, VKApiException {
        kotlin.jvm.internal.h.b(aVar, "cmd");
        return aVar.a(f6862a.a());
    }

    public static /* synthetic */ void a(com.vk.api.sdk.internal.a aVar, d dVar, int i, Object obj) {
        if ((i & 2) != 0) {
            dVar = null;
        }
        a(aVar, dVar);
    }

    public static final <T> void a(final com.vk.api.sdk.internal.a<T> aVar, final d<? super T> dVar) {
        kotlin.jvm.internal.h.b(aVar, "request");
        q.f6908a.a().submit(new Runnable() { // from class: com.vk.api.sdk.-$$Lambda$b$0wbK7BNZ646LsfhaI5zOe4s9w-I
            @Override // java.lang.Runnable
            public final void run() {
                b.b(com.vk.api.sdk.internal.a.this, dVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.vk.api.sdk.internal.a aVar, final d dVar) {
        kotlin.jvm.internal.h.b(aVar, "$request");
        try {
            final Object a2 = a((com.vk.api.sdk.internal.a<Object>) aVar);
            q.a(new Runnable() { // from class: com.vk.api.sdk.-$$Lambda$b$4R1_OpjhPWhwgknguVU8RYy9tok
                @Override // java.lang.Runnable
                public final void run() {
                    b.a(d.this, a2);
                }
            }, 0L, 2, null);
        } catch (Exception e2) {
            q.a(new Runnable() { // from class: com.vk.api.sdk.-$$Lambda$b$CWFHyH32MmVvvvceqcqQEX3TV2A
                @Override // java.lang.Runnable
                public final void run() {
                    b.a(e2, dVar);
                }
            }, 0L, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(d dVar, Object obj) {
        if (dVar == null) {
            return;
        }
        dVar.a((d) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Exception exc, d dVar) {
        kotlin.jvm.internal.h.b(exc, "$e");
        if ((exc instanceof VKApiExecutionException) && ((VKApiExecutionException) exc).e()) {
            f6862a.e();
        }
        if (dVar == null) {
            return;
        }
        dVar.a(exc);
    }

    public static final void a(Context context) {
        kotlin.jvm.internal.h.b(context, "context");
        int c2 = f6862a.c(context);
        b bVar = f6862a;
        a(new e(context, c2, new l(context), null, null, null, null, null, null, null, null, false, null, 0, null, null, null, null, 0L, null, null, false, null, 8388600, null));
        b bVar2 = f6862a;
        if (c()) {
            f6862a.h();
        }
    }

    public static final int b(Context context) {
        kotlin.jvm.internal.h.b(context, "context");
        try {
            return f6862a.a().a().b();
        } catch (Exception unused) {
            return f6862a.c(context);
        }
    }

    public final com.vk.api.sdk.utils.c f() {
        e eVar = c;
        if (eVar == null) {
            throw new RuntimeException("please call VK.initialize first!");
        }
        if (eVar != null) {
            PackageManager packageManager = eVar.a().getPackageManager();
            e eVar2 = c;
            if (eVar2 == null) {
                kotlin.jvm.internal.h.b(ConfigDBHelper.TABLE_NAME_CONFIG);
                throw null;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(eVar2.a().getPackageName(), 128);
            String valueOf = String.valueOf(applicationInfo.metaData.get("VKSdkVersion"));
            String valueOf2 = String.valueOf(applicationInfo.metaData.get("VKSdkVersionCode"));
            com.vk.api.sdk.utils.l lVar = com.vk.api.sdk.utils.l.f6927a;
            e eVar3 = c;
            if (eVar3 != null) {
                return new com.vk.api.sdk.utils.c("VKAndroidSDK", valueOf, valueOf2, lVar.b(eVar3.a()));
            }
            kotlin.jvm.internal.h.b(ConfigDBHelper.TABLE_NAME_CONFIG);
            throw null;
        }
        kotlin.jvm.internal.h.b(ConfigDBHelper.TABLE_NAME_CONFIG);
        throw null;
    }

    private final void h() {
        a(new com.vk.api.sdk.b.a("stats.trackVisitor"), (d) null, 2, (Object) null);
    }

    private final int c(Context context) {
        int i;
        int i2 = f;
        if (i2 != 0) {
            return i2;
        }
        try {
            i = context.getResources().getInteger(context.getResources().getIdentifier("com_vk_sdk_AppId", "integer", context.getPackageName()));
        } catch (Exception unused) {
            i = 0;
        }
        if (i == 0) {
            throw new RuntimeException("<integer name=\"com_vk_sdk_AppId\">your_app_id</integer> is not found in your resources.xml");
        }
        f = i;
        return i;
    }
}
