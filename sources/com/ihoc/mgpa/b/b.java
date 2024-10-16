package com.ihoc.mgpa.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.ihoc.mgpa.download.BgDownloadService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class b implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f5486a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.f5486a = cVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i;
        int i2;
        String str;
        BgDownloadService.BgDownloadServiceLocalBinder bgDownloadServiceLocalBinder;
        String str2;
        int i3;
        if (iBinder != null) {
            try {
                this.f5486a.f = (BgDownloadService.BgDownloadServiceLocalBinder) iBinder;
                Context a2 = com.ihoc.mgpa.n.a.a();
                Intent intent = new Intent(a2, (Class<?>) BgDownloadService.class);
                i = this.f5486a.c;
                intent.putExtra("update_progress", i);
                i2 = this.f5486a.b;
                intent.putExtra("update_icon", i2);
                str = this.f5486a.f5487a;
                intent.putExtra("update_title", str);
                if (Build.VERSION.SDK_INT >= 26) {
                    a2.startForegroundService(intent);
                    bgDownloadServiceLocalBinder = this.f5486a.f;
                    str2 = this.f5486a.f5487a;
                    i3 = this.f5486a.c;
                    bgDownloadServiceLocalBinder.bringServiceToForeground(str2, i3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f5486a.f = null;
    }
}
