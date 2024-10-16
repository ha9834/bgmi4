package com.ihoc.mgpa.h;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.ihoc.mgpa.h.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f5592a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar) {
        this.f5592a = fVar;
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        n nVar;
        n nVar2;
        Log.d("TGPA_MID", "Common Service onServiceConnected");
        try {
            d a2 = d.a.a(iBinder);
            if (a2 != null) {
                nVar = this.f5592a.f5593a;
                if (nVar != null) {
                    nVar2 = this.f5592a.f5593a;
                    nVar2.a(a2.b());
                }
            }
        } catch (Throwable unused) {
            Log.d("TGPA_MID", "Common Service get id exception.");
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("TGPA_MID", "Common Service onServiceDisconnected");
    }
}
