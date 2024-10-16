package com.devbrackets.android.exomedia.core.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import com.devbrackets.android.exomedia.ExoMedia;
import com.devbrackets.android.exomedia.core.e.a.b;
import com.devbrackets.android.exomedia.core.e.a.d;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.TransferListener;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"DefaultLocale"})
    protected String f1016a = String.format("ExoMedia %s (%d) / Android %s / %s", "4.2.3", 42300L, Build.VERSION.RELEASE, Build.MODEL);

    public MediaSource a(Context context, Handler handler, Uri uri, TransferListener transferListener) {
        C0074a a2 = a(uri);
        return (a2 != null ? a2.f1017a : new b()).a(context, uri, this.f1016a, handler, transferListener);
    }

    protected static C0074a a(Uri uri) {
        C0074a b = b(uri);
        if (b != null) {
            return b;
        }
        C0074a c = c(uri);
        if (c != null) {
            return c;
        }
        C0074a d = d(uri);
        if (d != null) {
            return d;
        }
        return null;
    }

    protected static C0074a b(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme == null || scheme.isEmpty()) {
            return null;
        }
        for (C0074a c0074a : ExoMedia.a.b) {
            if (c0074a.c != null && c0074a.c.equalsIgnoreCase(scheme)) {
                return c0074a;
            }
        }
        return null;
    }

    protected static C0074a c(Uri uri) {
        String a2 = com.devbrackets.android.exomedia.b.b.a(uri);
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        for (C0074a c0074a : ExoMedia.a.b) {
            if (c0074a.b != null && c0074a.b.equalsIgnoreCase(a2)) {
                return c0074a;
            }
        }
        return null;
    }

    protected static C0074a d(Uri uri) {
        for (C0074a c0074a : ExoMedia.a.b) {
            if (c0074a.d != null && uri.toString().matches(c0074a.d)) {
                return c0074a;
            }
        }
        return null;
    }

    /* renamed from: com.devbrackets.android.exomedia.core.e.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0074a {

        /* renamed from: a, reason: collision with root package name */
        public final d f1017a;
        public final String b;
        public final String c;
        public final String d;

        public C0074a(d dVar, String str, String str2, String str3) {
            this.f1017a = dVar;
            this.c = str;
            this.b = str2;
            this.d = str3;
        }
    }
}
