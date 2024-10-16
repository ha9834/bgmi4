package com.ihoc.mgpa.b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.ihoc.mgpa.download.BgDownloadService;
import com.ihoc.mgpa.download.DownloadState;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class c implements h {
    private BgDownloadService.BgDownloadServiceLocalBinder f;

    /* renamed from: a, reason: collision with root package name */
    private String f5487a = "";
    private int b = com.ihoc.mgpa.n.a.a().getApplicationInfo().icon;
    private int c = -1;
    private long d = 0;
    private final int e = -75;
    private final Handler g = new Handler(Looper.getMainLooper());
    private final Runnable h = new a(this);
    private final ServiceConnection i = new b(this);
    private boolean j = false;

    private void a(String str) {
        if (com.ihoc.mgpa.n.p.c(str)) {
            return;
        }
        try {
            int parseDouble = (int) Double.parseDouble(str.trim());
            if (b(parseDouble)) {
                this.c = parseDouble;
                this.d = System.currentTimeMillis();
                f();
            }
            this.j = a(parseDouble);
        } catch (NumberFormatException e) {
            com.ihoc.mgpa.n.m.b("TGPA_BgDownloadObserver", "BgPreDownloadUpdateNotification state_progress: " + e.toString());
        }
    }

    private boolean a(int i) {
        return i > DownloadState.START.state && i < DownloadState.FINISH.state;
    }

    private void b(String str) {
        if (com.ihoc.mgpa.n.p.c(str)) {
            return;
        }
        int identifier = com.ihoc.mgpa.n.a.a().getResources().getIdentifier(str.trim(), "drawable", com.ihoc.mgpa.n.a.a().getPackageName());
        if (identifier != 0) {
            this.b = identifier;
        } else {
            com.ihoc.mgpa.n.m.b("TGPA_BgDownloadObserver", " updateIcon is not found: " + str);
        }
        int i = this.c;
        if (i < DownloadState.START.state || i > DownloadState.FINISH.state) {
            return;
        }
        f();
    }

    private boolean b(int i) {
        if (i >= DownloadState.FINISH.state || i <= DownloadState.START.state) {
            return true;
        }
        return i != this.c && System.currentTimeMillis() - this.d >= 500;
    }

    private void c() {
        try {
            Context a2 = com.ihoc.mgpa.n.a.a();
            Intent intent = new Intent(a2, (Class<?>) BgDownloadService.class);
            intent.putExtra("update_progress", this.c);
            intent.putExtra("update_icon", this.b);
            intent.putExtra("update_title", this.f5487a);
            if (Build.VERSION.SDK_INT < 26) {
                a2.startService(intent);
            } else if (this.f == null) {
                a2.bindService(intent, this.i, 1);
            } else if (this.f.isStartForeground()) {
                a2.startForegroundService(intent);
            } else {
                a2.startForegroundService(intent);
                this.g.post(this.h);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c(String str) {
        if (com.ihoc.mgpa.n.p.c(str)) {
            return;
        }
        try {
            int parseDouble = (int) Double.parseDouble(str.trim());
            if (this.j) {
                com.ihoc.mgpa.n.m.a("TGPA_BgDownloadObserver", "BgPreDownload is using Notification, pls wait! but you can change title, icon");
            } else if (b(parseDouble)) {
                this.c = parseDouble;
                this.d = System.currentTimeMillis();
                f();
            }
        } catch (NumberFormatException e) {
            com.ihoc.mgpa.n.m.b("TGPA_BgDownloadObserver", "updateNotification state_progress: " + e.toString());
        }
    }

    private void d(String str) {
        if (com.ihoc.mgpa.n.p.c(str)) {
            return;
        }
        this.f5487a = str;
        int i = this.c;
        if (i < DownloadState.START.state || i > DownloadState.FINISH.state) {
            return;
        }
        f();
    }

    private boolean d() {
        return (this.c < DownloadState.START.getState() || this.c > DownloadState.FINISH.getState()) && com.ihoc.mgpa.n.k.a(com.ihoc.mgpa.n.a.a()).a();
    }

    private boolean e() {
        if (com.ihoc.mgpa.n.k.a(com.ihoc.mgpa.n.a.a()).b()) {
            return !com.ihoc.mgpa.g.o.b().b.P;
        }
        return true;
    }

    private void f() {
        if (e() && !d()) {
            c();
        }
    }

    public void a() {
        this.c = DownloadState.ERROR.getState();
        c();
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(int i, String str) {
        if (com.ihoc.mgpa.a.e.RESOURCE_UPDATE_PROGRESS.a() == i) {
            c(str);
            return;
        }
        if (com.ihoc.mgpa.a.e.RESOURCE_UPDATE_TITLE.a() == i) {
            d(str);
        } else if (com.ihoc.mgpa.a.e.RESOURCE_UPDATE_ICON.a() == i) {
            b(str);
        } else if (-75 == i) {
            a(str);
        }
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(int i, float[] fArr) {
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(HashMap<String, String> hashMap) {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (entry.getKey().equals(com.ihoc.mgpa.a.e.RESOURCE_UPDATE_PROGRESS.b())) {
                c(entry.getValue());
            } else if (entry.getKey().equals(com.ihoc.mgpa.a.e.RESOURCE_UPDATE_TITLE.b())) {
                d(entry.getValue());
            } else if (entry.getKey().equals(com.ihoc.mgpa.a.e.RESOURCE_UPDATE_ICON.b())) {
                b(entry.getValue());
            }
        }
    }

    public void b() {
        this.c = DownloadState.START.getState();
        this.f5487a = "";
        c();
    }
}
