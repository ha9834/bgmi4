package com.google.android.gms.internal.ads;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
@ParametersAreNonnullByDefault
@TargetApi(14)
/* loaded from: classes.dex */
public final class zzuu extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3754a;
    private boolean b;
    private boolean c;
    private final Object d;
    private final zzup e;
    private final int f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;
    private final String n;
    private final boolean o;
    private final boolean p;
    private final boolean q;

    public zzuu() {
        this(new zzup());
    }

    @VisibleForTesting
    private zzuu(zzup zzupVar) {
        this.f3754a = false;
        this.b = false;
        this.c = false;
        this.e = zzupVar;
        this.d = new Object();
        this.g = ((Integer) zzyt.zzpe().zzd(zzacu.zzcnb)).intValue();
        this.h = ((Integer) zzyt.zzpe().zzd(zzacu.zzcnc)).intValue();
        this.i = ((Integer) zzyt.zzpe().zzd(zzacu.zzcnd)).intValue();
        this.j = ((Integer) zzyt.zzpe().zzd(zzacu.zzcne)).intValue();
        this.k = ((Integer) zzyt.zzpe().zzd(zzacu.zzcng)).intValue();
        this.l = ((Integer) zzyt.zzpe().zzd(zzacu.zzcnh)).intValue();
        this.m = ((Integer) zzyt.zzpe().zzd(zzacu.zzcni)).intValue();
        this.f = ((Integer) zzyt.zzpe().zzd(zzacu.zzcnf)).intValue();
        this.n = (String) zzyt.zzpe().zzd(zzacu.zzcnk);
        this.o = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcnl)).booleanValue();
        this.p = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcnp)).booleanValue();
        this.q = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcnq)).booleanValue();
        setName("ContentFetchTask");
    }

    public final void zzmv() {
        synchronized (this.d) {
            if (this.f3754a) {
                zzawz.zzdp("Content hash thread already started, quiting...");
            } else {
                this.f3754a = true;
                start();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                try {
                    if (a()) {
                        Activity activity = zzk.zzlj().getActivity();
                        if (activity == null) {
                            zzawz.zzdp("ContentFetchThread: no activity. Sleeping.");
                            b();
                        } else if (activity != null) {
                            View view = null;
                            try {
                                if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                                    view = activity.getWindow().getDecorView().findViewById(R.id.content);
                                }
                            } catch (Exception e) {
                                zzk.zzlk().zza(e, "ContentFetchTask.extractContent");
                                zzawz.zzdp("Failed getting root view of activity. Content not extracted.");
                            }
                            if (view != null && view != null) {
                                view.post(new aov(this, view));
                            }
                        }
                    } else {
                        zzawz.zzdp("ContentFetchTask: sleeping");
                        b();
                    }
                    Thread.sleep(this.f * 1000);
                } catch (Exception e2) {
                    zzawz.zzc("Error in ContentFetchTask", e2);
                    zzk.zzlk().zza(e2, "ContentFetchTask.run");
                }
            } catch (InterruptedException e3) {
                zzawz.zzc("Error in ContentFetchTask", e3);
            }
            synchronized (this.d) {
                while (this.b) {
                    try {
                        zzawz.zzdp("ContentFetchTask: waiting");
                        this.d.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a(View view) {
        try {
            zzuo zzuoVar = new zzuo(this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.p);
            Context context = zzk.zzlj().getContext();
            if (context != null && !TextUtils.isEmpty(this.n)) {
                String str = (String) view.getTag(context.getResources().getIdentifier((String) zzyt.zzpe().zzd(zzacu.zzcnj), "id", context.getPackageName()));
                if (str != null && str.equals(this.n)) {
                    return;
                }
            }
            aoy a2 = a(view, zzuoVar);
            zzuoVar.zzmt();
            if (a2.f2021a == 0 && a2.b == 0) {
                return;
            }
            if (a2.b == 0 && zzuoVar.a() == 0) {
                return;
            }
            if (a2.b == 0 && this.e.zza(zzuoVar)) {
                return;
            }
            this.e.zzc(zzuoVar);
        } catch (Exception e) {
            zzawz.zzc("Exception in fetchContentOnUIThread", e);
            zzk.zzlk().zza(e, "ContentFetchTask.fetchContent");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r4.importance != 100) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        if (r3.inKeyguardRestrictedInputMode() != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        r1 = (android.os.PowerManager) r1.getSystemService("power");
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        if (r1 != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r1 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0058, code lost:
    
        r1 = r1.isScreenOn();
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean a() {
        /*
            r0 = 0
            com.google.android.gms.internal.ads.zzuq r1 = com.google.android.gms.ads.internal.zzk.zzlj()     // Catch: java.lang.Throwable -> L62
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Throwable -> L62
            if (r1 != 0) goto Lc
            return r0
        Lc:
            java.lang.String r2 = "activity"
            java.lang.Object r2 = r1.getSystemService(r2)     // Catch: java.lang.Throwable -> L62
            android.app.ActivityManager r2 = (android.app.ActivityManager) r2     // Catch: java.lang.Throwable -> L62
            java.lang.String r3 = "keyguard"
            java.lang.Object r3 = r1.getSystemService(r3)     // Catch: java.lang.Throwable -> L62
            android.app.KeyguardManager r3 = (android.app.KeyguardManager) r3     // Catch: java.lang.Throwable -> L62
            if (r2 == 0) goto L61
            if (r3 != 0) goto L21
            goto L61
        L21:
            java.util.List r2 = r2.getRunningAppProcesses()     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L28
            return r0
        L28:
            java.util.Iterator r2 = r2.iterator()     // Catch: java.lang.Throwable -> L62
        L2c:
            boolean r4 = r2.hasNext()     // Catch: java.lang.Throwable -> L62
            if (r4 == 0) goto L60
            java.lang.Object r4 = r2.next()     // Catch: java.lang.Throwable -> L62
            android.app.ActivityManager$RunningAppProcessInfo r4 = (android.app.ActivityManager.RunningAppProcessInfo) r4     // Catch: java.lang.Throwable -> L62
            int r5 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L62
            int r6 = r4.pid     // Catch: java.lang.Throwable -> L62
            if (r5 != r6) goto L2c
            int r2 = r4.importance     // Catch: java.lang.Throwable -> L62
            r4 = 100
            if (r2 != r4) goto L60
            boolean r2 = r3.inKeyguardRestrictedInputMode()     // Catch: java.lang.Throwable -> L62
            if (r2 != 0) goto L60
            java.lang.String r2 = "power"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch: java.lang.Throwable -> L62
            android.os.PowerManager r1 = (android.os.PowerManager) r1     // Catch: java.lang.Throwable -> L62
            if (r1 != 0) goto L58
            r1 = 0
            goto L5c
        L58:
            boolean r1 = r1.isScreenOn()     // Catch: java.lang.Throwable -> L62
        L5c:
            if (r1 == 0) goto L60
            r0 = 1
            return r0
        L60:
            return r0
        L61:
            return r0
        L62:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzawm r2 = com.google.android.gms.ads.internal.zzk.zzlk()
            java.lang.String r3 = "ContentFetchTask.isInForeground"
            r2.zza(r1, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuu.a():boolean");
    }

    @VisibleForTesting
    private final aoy a(View view, zzuo zzuoVar) {
        boolean z;
        if (view == null) {
            return new aoy(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (!TextUtils.isEmpty(text)) {
                zzuoVar.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
                return new aoy(this, 1, 0);
            }
            return new aoy(this, 0, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzbgz)) {
            WebView webView = (WebView) view;
            if (PlatformVersion.isAtLeastKitKat()) {
                zzuoVar.zzmr();
                webView.post(new aow(this, zzuoVar, webView, globalVisibleRect));
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return new aoy(this, 0, 1);
            }
            return new aoy(this, 0, 0);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                aoy a2 = a(viewGroup.getChildAt(i3), zzuoVar);
                i += a2.f2021a;
                i2 += a2.b;
            }
            return new aoy(this, i, i2);
        }
        return new aoy(this, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void a(zzuo zzuoVar, WebView webView, String str, boolean z) {
        zzuoVar.zzmq();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (!this.o && !TextUtils.isEmpty(webView.getTitle())) {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append("\n");
                    sb.append(optString);
                    zzuoVar.zza(sb.toString(), z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    zzuoVar.zza(optString, z, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzuoVar.zzml()) {
                this.e.zzb(zzuoVar);
            }
        } catch (JSONException unused) {
            zzawz.zzdp("Json string may be malformed.");
        } catch (Throwable th) {
            zzawz.zzb("Failed to get webview content.", th);
            zzk.zzlk().zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    public final zzuo zzmx() {
        return this.e.zzo(this.q);
    }

    public final void wakeup() {
        synchronized (this.d) {
            this.b = false;
            this.d.notifyAll();
            zzawz.zzdp("ContentFetchThread: wakeup");
        }
    }

    private final void b() {
        synchronized (this.d) {
            this.b = true;
            boolean z = this.b;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(z);
            zzawz.zzdp(sb.toString());
        }
    }

    public final boolean zzmz() {
        return this.b;
    }
}
