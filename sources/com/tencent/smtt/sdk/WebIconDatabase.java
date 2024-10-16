package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.webkit.WebIconDatabase;
import com.tencent.smtt.export.external.interfaces.IconListener;

@Deprecated
/* loaded from: classes2.dex */
public class WebIconDatabase {

    /* renamed from: a, reason: collision with root package name */
    private static WebIconDatabase f6483a;

    @Deprecated
    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, Bitmap bitmap);
    }

    public void bulkRequestIconForPageUrl(ContentResolver contentResolver, String str, a aVar) {
    }

    public void open(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().b(str);
        } else {
            android.webkit.WebIconDatabase.getInstance().open(str);
        }
    }

    public void close() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().j();
        } else {
            android.webkit.WebIconDatabase.getInstance().close();
        }
    }

    public void removeAllIcons() {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().i();
        } else {
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
        }
    }

    public void requestIconForPageUrl(String str, final a aVar) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().a(str, new IconListener() { // from class: com.tencent.smtt.sdk.WebIconDatabase.1
                @Override // com.tencent.smtt.export.external.interfaces.IconListener
                public void onReceivedIcon(String str2, Bitmap bitmap) {
                    aVar.a(str2, bitmap);
                }
            });
        } else {
            android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(str, new WebIconDatabase.IconListener() { // from class: com.tencent.smtt.sdk.WebIconDatabase.2
                @Override // android.webkit.WebIconDatabase.IconListener
                public void onReceivedIcon(String str2, Bitmap bitmap) {
                    aVar.a(str2, bitmap);
                }
            });
        }
    }

    public void retainIconForPageUrl(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().c(str);
        } else {
            android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(str);
        }
    }

    public void releaseIconForPageUrl(String str) {
        r a2 = r.a();
        if (a2 != null && r.b()) {
            a2.c().d(str);
        } else {
            android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(str);
        }
    }

    public static WebIconDatabase getInstance() {
        return a();
    }

    private static synchronized WebIconDatabase a() {
        WebIconDatabase webIconDatabase;
        synchronized (WebIconDatabase.class) {
            if (f6483a == null) {
                f6483a = new WebIconDatabase();
            }
            webIconDatabase = f6483a;
        }
        return webIconDatabase;
    }

    private WebIconDatabase() {
    }
}
