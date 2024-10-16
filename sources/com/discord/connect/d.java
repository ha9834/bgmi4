package com.discord.connect;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.discord.connect.jni.LoginSession;
import com.discord.connect.jni.LoginSessionRFC6749;
import java.io.Closeable;
import lombok.NonNull;

/* loaded from: classes.dex */
public class d implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final LoginSession f1069a;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1069a.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Intent b(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        ResolveInfo a2 = c.a(context, intent);
        if (a2 != null) {
            intent.setPackage(a2.activityInfo.packageName);
        }
        return intent;
    }

    /* loaded from: classes.dex */
    public static class a implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        private final LoginSessionRFC6749 f1070a;

        public a(com.discord.connect.auth.b bVar) {
            this.f1070a = new LoginSessionRFC6749(bVar.f1066a, bVar.b, bVar.a());
        }

        public void a(Context context) throws IllegalStateException {
            context.startActivity(d.b(context, Uri.parse(this.f1070a.b())));
        }

        public void a(@NonNull String str, @NonNull String str2, @NonNull AbstractC0081a abstractC0081a) {
            if (str == null) {
                throw new NullPointerException("accessCode is marked non-null but is null");
            }
            if (str2 == null) {
                throw new NullPointerException("state is marked non-null but is null");
            }
            if (abstractC0081a == null) {
                throw new NullPointerException("callback is marked non-null but is null");
            }
            this.f1070a.a(str, str2, abstractC0081a);
        }

        public void a(@NonNull Uri uri, @NonNull AbstractC0081a abstractC0081a) {
            if (uri == null) {
                throw new NullPointerException("uri is marked non-null but is null");
            }
            if (abstractC0081a == null) {
                throw new NullPointerException("callback is marked non-null but is null");
            }
            String queryParameter = uri.getQueryParameter("code");
            String queryParameter2 = uri.getQueryParameter("state");
            if (TextUtils.isEmpty(queryParameter)) {
                throw new IllegalArgumentException("code param was not found in " + uri);
            }
            if (queryParameter2 == null) {
                queryParameter2 = "";
            }
            a(queryParameter, queryParameter2, abstractC0081a);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f1070a.close();
        }

        /* renamed from: com.discord.connect.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static abstract class AbstractC0081a implements LoginSessionRFC6749.a {
            public abstract void onTokenGrant(com.discord.connect.auth.a aVar);

            public void onTokenGrant(String str, String str2, String str3, long j, String str4) {
                onTokenGrant(new com.discord.connect.auth.a(str, str2, str3, j, str4));
            }
        }
    }
}
