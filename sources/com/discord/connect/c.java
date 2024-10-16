package com.discord.connect;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import com.discord.connect.jni.Core;
import com.discord.connect.managers.ActivitiesManager;
import com.discord.connect.schema.a;
import java.io.Closeable;
import lombok.NonNull;

/* loaded from: classes.dex */
public final class c implements Closeable {
    private static boolean g;

    /* renamed from: a, reason: collision with root package name */
    private final Core f1068a;

    @NonNull
    private final a b;

    @NonNull
    private final com.discord.connect.managers.c c;

    @NonNull
    private final ActivitiesManager d;

    @NonNull
    private final com.discord.connect.managers.b e;
    private com.discord.connect.auth.a f;

    @NonNull
    public ActivitiesManager b() {
        return this.d;
    }

    private c(com.discord.connect.auth.a aVar, @NonNull a aVar2) {
        if (aVar2 == null) {
            throw new NullPointerException("eventHandler is marked non-null but is null");
        }
        this.f = aVar;
        this.b = aVar2;
        this.f1068a = new Core(aVar.f1065a, aVar2);
        this.c = new com.discord.connect.managers.c(this.f1068a);
        this.d = new ActivitiesManager(this.f1068a);
        this.e = new com.discord.connect.managers.b(this.f1068a);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1068a.close();
    }

    public static void a() {
        if (g) {
            return;
        }
        if (Build.VERSION.SDK_INT < 23) {
            throw new UnsupportedOperationException("Android SDK version " + Build.VERSION.SDK_INT + " < 23");
        }
        System.loadLibrary("discord_connect_sdk_android");
        Core.initNative();
        g = true;
    }

    public static c a(e eVar, a aVar) {
        com.discord.connect.auth.a a2 = eVar.a();
        if (a2 == null) {
            return null;
        }
        return new c(a2, aVar);
    }

    /* loaded from: classes.dex */
    public static class a implements Core.a {
        protected static final String LOG_TAG = "Discord.Event";

        public void onConnected() {
            Log.d(LOG_TAG, "onConnected");
        }

        public void onConnectFailed(String str) {
            Log.d(LOG_TAG, "onConnectFailed: " + str);
        }

        public void onActivitySet() {
            Log.d(LOG_TAG, "onActivitySet");
        }

        public void onActivitySetFailed(String str) {
            Log.d(LOG_TAG, "onActivitySetFailed: " + str);
        }

        public void onActivityCleared() {
            Log.d(LOG_TAG, "onActivityCleared");
        }

        public void onAction(com.discord.connect.schema.a aVar) {
            if (aVar instanceof a.C0082a) {
                onActionJoin(((a.C0082a) aVar).a());
            }
        }

        public void onActionJoin(String str) {
            Log.d(LOG_TAG, "onActionJoin: " + str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ResolveInfo a(@NonNull Context context, @NonNull Intent intent) {
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        if (intent == null) {
            throw new NullPointerException("intent is marked non-null but is null");
        }
        for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo.packageName.startsWith(com.discord.connect.a.b)) {
                return resolveInfo;
            }
        }
        return null;
    }
}
