package com.ihoc.mgpa.h;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.ihoc.mgpa.h.m;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class k implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f5597a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(l lVar) {
        this.f5597a = lVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str;
        String str2;
        n nVar;
        n nVar2;
        try {
            m a2 = m.a.a(iBinder);
            if (a2 != null) {
                nVar = this.f5597a.f5598a;
                if (nVar != null) {
                    if (a2.c()) {
                        nVar2 = this.f5597a.f5598a;
                        nVar2.a(a2.a());
                    } else {
                        str = "TGPA_MID";
                        str2 = "MSA Lenovo not supported";
                        Log.d(str, str2);
                    }
                }
            }
            str = "TGPA_MID";
            str2 = "MSA Lenovo Service get oaid failed.";
            Log.d(str, str2);
        } catch (Throwable th) {
            Log.d("TGPA_MID", "MSA Lenovo oaid get exception.");
            th.printStackTrace();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("TGPA_MID", "Lenovo MSA onServiceDisconnected ");
    }
}
