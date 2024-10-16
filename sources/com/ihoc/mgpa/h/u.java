package com.ihoc.mgpa.h;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.ihoc.mgpa.h.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class u implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f5606a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(v vVar) {
        this.f5606a = vVar;
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        w wVar;
        n nVar;
        n nVar2;
        w wVar2;
        Log.d("TGPA_MID", "Sumsung Service onServiceConnected");
        try {
            this.f5606a.b = w.a.a(iBinder);
            wVar = this.f5606a.b;
        } catch (Throwable th) {
            Log.d("TGPA_MID", "MSA Sumsung oaid get exception.");
            th.printStackTrace();
        }
        if (wVar != null) {
            nVar = this.f5606a.f5607a;
            if (nVar != null) {
                nVar2 = this.f5606a.f5607a;
                wVar2 = this.f5606a.b;
                nVar2.a(wVar2.a());
            }
        }
        Log.d("TGPA_MID", "MSA Sumsung not supported");
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("TGPA_MID", "Sumsung Service onServiceDisconnected");
    }
}
