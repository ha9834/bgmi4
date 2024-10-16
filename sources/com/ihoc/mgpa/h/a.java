package com.ihoc.mgpa.h;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.ihoc.mgpa.h.c;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class a implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f5588a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) {
        this.f5588a = bVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str;
        String str2;
        n nVar;
        n nVar2;
        try {
            c a2 = c.a.a(iBinder);
            if (a2 != null) {
                nVar = this.f5588a.f5589a;
                if (nVar != null) {
                    if (a2.a()) {
                        nVar2 = this.f5588a.f5589a;
                        nVar2.a(a2.c());
                    } else {
                        str = "TGPA_MID";
                        str2 = "MSA ASUS not supported";
                        Log.d(str, str2);
                    }
                }
            }
            str = "TGPA_MID";
            str2 = "MSA ASUS Service get oaid failed.";
            Log.d(str, str2);
        } catch (Throwable th) {
            Log.d("TGPA_MID", "MSA ASUS oaid get exception.");
            th.printStackTrace();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("TGPA_MID", "ASUS MSA onServiceDisconnected ");
    }
}
