package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;

@zzard
@TargetApi(14)
/* loaded from: classes.dex */
public class zzaxo {
    public String getDefaultUserAgent(Context context) {
        return "";
    }

    public boolean isAttachedToWindow(View view) {
        return (view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true;
    }

    public boolean zza(Activity activity, Configuration configuration) {
        return false;
    }

    public void zzay(Context context) {
    }

    public void zzg(Activity activity) {
    }

    public int zzwf() {
        return 5;
    }

    public int zzwi() {
        return 1;
    }

    public boolean zza(final Context context, final WebSettings webSettings) {
        return ((Boolean) zzazl.zza(context, new Callable(context, webSettings) { // from class: com.google.android.gms.internal.ads.fs

            /* renamed from: a, reason: collision with root package name */
            private final Context f2179a;
            private final WebSettings b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2179a = context;
                this.b = webSettings;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                Context context2 = this.f2179a;
                WebSettings webSettings2 = this.b;
                if (context2.getCacheDir() != null) {
                    webSettings2.setAppCachePath(context2.getCacheDir().getAbsolutePath());
                    webSettings2.setAppCacheMaxSize(0L);
                    webSettings2.setAppCacheEnabled(true);
                }
                webSettings2.setDatabasePath(context2.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath());
                webSettings2.setDatabaseEnabled(true);
                webSettings2.setDomStorageEnabled(true);
                webSettings2.setDisplayZoomControls(false);
                webSettings2.setBuiltInZoomControls(true);
                webSettings2.setSupportZoom(true);
                webSettings2.setAllowContentAccess(false);
                return true;
            }
        })).booleanValue();
    }

    public static boolean zza(zzbgz zzbgzVar) {
        if (zzbgzVar == null) {
            return false;
        }
        zzbgzVar.onPause();
        return true;
    }

    public static boolean zzb(zzbgz zzbgzVar) {
        if (zzbgzVar == null) {
            return false;
        }
        zzbgzVar.onResume();
        return true;
    }

    public zzbha zza(zzbgz zzbgzVar, zzwj zzwjVar, boolean z) {
        return new zzbhz(zzbgzVar, zzwjVar, z);
    }

    public void zza(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
    }

    public ViewGroup.LayoutParams zzwg() {
        return new ViewGroup.LayoutParams(-2, -2);
    }

    public void setBackground(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

    public Drawable zza(Context context, Bitmap bitmap, boolean z, float f) {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    public static boolean zzwh() {
        int myUid = Process.myUid();
        return myUid == 0 || myUid == 1000;
    }

    public CookieManager zzaz(Context context) {
        if (zzwh()) {
            return null;
        }
        try {
            CookieSyncManager.createInstance(context);
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzawz.zzc("Failed to obtain CookieManager.", th);
            zzk.zzlk().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public zzwx zza(Context context, TelephonyManager telephonyManager) {
        return zzwx.ENUM_UNKNOWN;
    }

    public int zza(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "wifi_on", 0);
    }

    public int zzb(ContentResolver contentResolver) {
        return Settings.System.getInt(contentResolver, "airplane_mode_on", 0);
    }

    public WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, inputStream);
    }

    private zzaxo() {
    }

    public static zzaxo zzcv(int i) {
        if (i >= 28) {
            return new zzaxy();
        }
        if (i >= 26) {
            return new zzaxx();
        }
        if (i >= 24) {
            return new zzaxw();
        }
        if (i >= 21) {
            return new zzaxv();
        }
        if (i >= 19) {
            return new zzaxu();
        }
        if (i >= 18) {
            return new zzaxs();
        }
        if (i >= 17) {
            return new zzaxr();
        }
        if (i >= 16) {
            return new zzaxt();
        }
        return new zzaxo();
    }
}
