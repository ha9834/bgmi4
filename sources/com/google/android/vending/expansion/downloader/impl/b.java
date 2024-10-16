package com.google.android.vending.expansion.downloader.impl;

import android.R;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Messenger;
import androidx.core.app.h;
import com.google.android.vending.expansion.downloader.DownloadProgressInfo;
import com.google.android.vending.expansion.downloader.e;

/* loaded from: classes2.dex */
public class b implements e {

    /* renamed from: a, reason: collision with root package name */
    static final int f5376a = "DownloadNotification".hashCode();
    private int b = -1;
    private final Context c;
    private final NotificationManager d;
    private CharSequence e;
    private e f;
    private h.e g;
    private h.e h;
    private h.e i;
    private CharSequence j;
    private String k;
    private DownloadProgressInfo l;
    private PendingIntent m;

    @Override // com.google.android.vending.expansion.downloader.e
    public void a(Messenger messenger) {
    }

    public void a(PendingIntent pendingIntent) {
        this.h.a(pendingIntent);
        this.g.a(pendingIntent);
        this.m = pendingIntent;
    }

    public void a() {
        e eVar = this.f;
        if (eVar != null) {
            eVar.a(this.b);
        }
    }

    @Override // com.google.android.vending.expansion.downloader.e
    public void a(int i) {
        int i2;
        boolean z;
        e eVar = this.f;
        if (eVar != null) {
            eVar.a(i);
        }
        if (i != this.b) {
            this.b = i;
            if (i == 1 || this.m == null) {
                return;
            }
            int i3 = R.drawable.stat_sys_download_done;
            if (i != 0) {
                if (i != 7) {
                    switch (i) {
                        case 2:
                        case 3:
                            i2 = com.google.android.vending.expansion.downloader.d.a(i);
                            z = true;
                            break;
                        case 4:
                            i3 = R.drawable.stat_sys_download;
                            i2 = com.google.android.vending.expansion.downloader.d.a(i);
                            z = true;
                            break;
                        case 5:
                            break;
                        default:
                            switch (i) {
                                case 15:
                                case 16:
                                case 17:
                                case 18:
                                case 19:
                                    i2 = com.google.android.vending.expansion.downloader.d.a(i);
                                    i3 = R.drawable.stat_sys_warning;
                                    z = false;
                                    break;
                                default:
                                    i2 = com.google.android.vending.expansion.downloader.d.a(i);
                                    i3 = R.drawable.stat_sys_warning;
                                    z = true;
                                    break;
                            }
                    }
                }
                i2 = com.google.android.vending.expansion.downloader.d.a(i);
                z = false;
            } else {
                i2 = com.pubg.imobile.R.string.state_unknown;
                i3 = R.drawable.stat_sys_warning;
                z = false;
            }
            this.k = this.c.getString(i2);
            this.e = this.j;
            this.i.d(((Object) this.j) + ": " + this.k);
            this.i.a(i3);
            this.i.a(this.e);
            this.i.b((CharSequence) this.k);
            if (z) {
                this.i.a(true);
            } else {
                this.i.a(false);
                this.i.c(true);
            }
            this.d.notify(f5376a, this.i.b());
        }
    }

    @Override // com.google.android.vending.expansion.downloader.e
    public void a(DownloadProgressInfo downloadProgressInfo) {
        this.l = downloadProgressInfo;
        e eVar = this.f;
        if (eVar != null) {
            eVar.a(downloadProgressInfo);
        }
        if (downloadProgressInfo.f5356a <= 0) {
            this.h.d(this.e);
            this.h.a(R.drawable.stat_sys_download);
            this.h.a(this.e);
            this.h.b((CharSequence) this.k);
            this.i = this.h;
        } else {
            this.g.a((int) downloadProgressInfo.f5356a, (int) downloadProgressInfo.b, false);
            this.g.b((CharSequence) com.google.android.vending.expansion.downloader.d.a(downloadProgressInfo.b, downloadProgressInfo.f5356a));
            this.g.a(R.drawable.stat_sys_download);
            this.g.d(((Object) this.j) + ": " + this.k);
            this.g.a(this.j);
            this.g.c(this.c.getString(com.pubg.imobile.R.string.time_remaining_notification, com.google.android.vending.expansion.downloader.d.a(downloadProgressInfo.c)));
            this.i = this.g;
        }
        this.d.notify(f5376a, this.i.b());
    }

    public void b(Messenger messenger) {
        this.f = com.google.android.vending.expansion.downloader.b.a(messenger);
        DownloadProgressInfo downloadProgressInfo = this.l;
        if (downloadProgressInfo != null) {
            this.f.a(downloadProgressInfo);
        }
        int i = this.b;
        if (i != -1) {
            this.f.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, CharSequence charSequence) {
        this.c = context;
        this.j = charSequence;
        this.d = (NotificationManager) this.c.getSystemService("notification");
        if (Build.VERSION.SDK_INT < 14) {
            this.g = new d(context);
        } else {
            this.g = new h.e(context);
        }
        this.h = new h.e(context);
        this.g.c(-1);
        this.g.a("progress");
        this.h.c(-1);
        this.h.a("progress");
        this.i = this.h;
    }
}
