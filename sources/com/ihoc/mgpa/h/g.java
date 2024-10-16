package com.ihoc.mgpa.h;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class g implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f5594a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar) {
        this.f5594a = hVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        n nVar;
        n nVar2;
        try {
            i iVar = new i(iBinder);
            nVar = this.f5594a.f5595a;
            if (nVar != null) {
                nVar2 = this.f5594a.f5595a;
                nVar2.a(iVar.a());
            }
        } catch (Throwable th) {
            th.printStackTrace();
            Log.d("TGPA_MID", "MSA HW oaid get exception. ");
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Log.d("TGPA_MID", "Huawei MSA onServiceDisconnected ");
    }
}
