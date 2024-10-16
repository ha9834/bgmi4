package com.ihoc.mgpa.h;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.ihoc.mgpa.h.t;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class r implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f5603a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(s sVar) {
        this.f5603a = sVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean a2;
        n nVar;
        n nVar2;
        String a3;
        try {
            this.f5603a.b = t.a.a(iBinder);
            a2 = this.f5603a.a();
            if (a2) {
                nVar = this.f5603a.f5604a;
                if (nVar != null) {
                    nVar2 = this.f5603a.f5604a;
                    a3 = this.f5603a.a(com.ihoc.mgpa.n.a.a(), "OUID");
                    nVar2.a(a3);
                }
            } else {
                Log.d("TGPA_MID", "MSA OPPO not supported");
            }
        } catch (Throwable th) {
            Log.d("TGPA_MID", "MSA OPPO oaid get exception.");
            th.printStackTrace();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("TGPA_MID", "OPPO MSA onServiceDisconnected ");
    }
}
