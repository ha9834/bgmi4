package com.vk.api.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.adjust.sdk.Constants;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f6927a = new l();

    private l() {
    }

    public static final boolean a(Context context, String str, Uri uri, String str2) {
        kotlin.jvm.internal.h.b(context, "context");
        kotlin.jvm.internal.h.b(str, "action");
        kotlin.jvm.internal.h.b(str2, "allowedPackage");
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> queryIntentActivities = packageManager == null ? null : packageManager.queryIntentActivities(new Intent(str, uri), 65536);
        if (queryIntentActivities == null) {
            return false;
        }
        List<ResolveInfo> list = queryIntentActivities;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (kotlin.jvm.internal.h.a((Object) ((ResolveInfo) it.next()).activityInfo.packageName, (Object) str2)) {
                return true;
            }
        }
        return false;
    }

    public static final Map<String, String> a(String str) {
        if (str == null) {
            return null;
        }
        List a2 = kotlin.text.l.a((CharSequence) str, new String[]{"&"}, false, 0, 6, (Object) null);
        HashMap hashMap = new HashMap(a2.size());
        Iterator it = a2.iterator();
        while (it.hasNext()) {
            List a3 = kotlin.text.l.a((CharSequence) it.next(), new String[]{"="}, false, 0, 6, (Object) null);
            if (a3.size() > 1) {
                hashMap.put(a3.get(0), a3.get(1));
            }
        }
        return hashMap;
    }

    public final void a(Context context) {
        kotlin.jvm.internal.h.b(context, "context");
        CookieManager cookieManager = CookieManager.getInstance();
        if (Build.VERSION.SDK_INT >= 21) {
            cookieManager.removeAllCookies(null);
            return;
        }
        CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
        createInstance.startSync();
        cookieManager.removeAllCookie();
        createInstance.stopSync();
    }

    public final int a(int i) {
        return (int) Math.ceil(i * a());
    }

    public final float a() {
        return b().density;
    }

    public final DisplayMetrics b() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        kotlin.jvm.internal.h.a((Object) displayMetrics, "getSystem().displayMetrics");
        return displayMetrics;
    }

    public final Point b(Context context) {
        kotlin.jvm.internal.h.b(context, "context");
        Point point = new Point();
        Object systemService = context.getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= 23) {
            b(defaultDisplay, point);
        } else {
            a(defaultDisplay, point);
        }
        return point;
    }

    private final void a(Display display, Point point) {
        if (display == null) {
            return;
        }
        display.getRealSize(point);
    }

    private final void b(Display display, Point point) {
        Display.Mode mode = display == null ? null : display.getMode();
        point.x = mode == null ? 0 : mode.getPhysicalWidth();
        point.y = mode != null ? mode.getPhysicalHeight() : 0;
    }

    public static final String b(String str) {
        if (str == null) {
            return "";
        }
        int i = 0;
        while (i < str.length()) {
            int codePointAt = str.codePointAt(i);
            i += Character.charCount(codePointAt);
            if (!(32 <= codePointAt && codePointAt <= 126)) {
                okio.c cVar = new okio.c();
                cVar.a(str, 0, i);
                while (i < str.length()) {
                    int codePointAt2 = str.codePointAt(i);
                    cVar.a(32 <= codePointAt2 && codePointAt2 <= 126 ? codePointAt2 : 63);
                    i += Character.charCount(codePointAt2);
                }
                return cVar.p();
            }
        }
        return str;
    }

    /* loaded from: classes3.dex */
    public static final class a {
        static final /* synthetic */ kotlin.e.e<Object>[] b = {kotlin.jvm.internal.j.a(new PropertyReference1Impl(kotlin.jvm.internal.j.b(a.class), "tmpBuilder", "getTmpBuilder()Ljava/lang/StringBuilder;"))};

        /* renamed from: a, reason: collision with root package name */
        public static final a f6928a = new a();
        private static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        private static final f d = h.a(new kotlin.jvm.a.a<StringBuilder>() { // from class: com.vk.api.sdk.utils.VKUtils$MD5$tmpBuilder$2
            @Override // kotlin.jvm.a.a
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final StringBuilder b() {
                return new StringBuilder();
            }
        });

        private a() {
        }

        private final StringBuilder a() {
            return (StringBuilder) d.a(this, b[0]);
        }

        public static final String a(String str) {
            kotlin.jvm.internal.h.b(str, "h");
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
                Charset forName = Charset.forName("UTF-8");
                kotlin.jvm.internal.h.a((Object) forName, "Charset.forName(charsetName)");
                byte[] bytes = str.getBytes(forName);
                kotlin.jvm.internal.h.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                byte[] digest = messageDigest.digest(bytes);
                f6928a.a().setLength(0);
                a aVar = f6928a;
                kotlin.jvm.internal.h.a((Object) digest, "md5");
                a(digest);
                String sb = f6928a.a().toString();
                kotlin.jvm.internal.h.a((Object) sb, "tmpBuilder.toString()");
                return sb;
            } catch (Exception unused) {
                return "";
            }
        }

        private static final void a(byte[] bArr) {
            int length = bArr.length;
            int i = 0;
            while (i < length) {
                byte b2 = bArr[i];
                i++;
                f6928a.a().append(c[(b2 & 240) >> 4]);
                f6928a.a().append(c[b2 & 15]);
            }
        }
    }
}
