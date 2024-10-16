package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
final class aq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Result f1342a;
    private final /* synthetic */ zacm b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(zacm zacmVar, Result result) {
        this.b = zacmVar;
        this.f1342a = result;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WeakReference weakReference;
        ar arVar;
        ar arVar2;
        WeakReference weakReference2;
        ResultTransform resultTransform;
        ar arVar3;
        ar arVar4;
        WeakReference weakReference3;
        try {
            try {
                BasePendingResult.c.set(true);
                resultTransform = this.b.f1397a;
                PendingResult onSuccess = resultTransform.onSuccess(this.f1342a);
                arVar3 = this.b.h;
                arVar4 = this.b.h;
                arVar3.sendMessage(arVar4.obtainMessage(0, onSuccess));
                BasePendingResult.c.set(false);
                zacm zacmVar = this.b;
                zacm.a(this.f1342a);
                weakReference3 = this.b.g;
                GoogleApiClient googleApiClient = (GoogleApiClient) weakReference3.get();
                if (googleApiClient != null) {
                    googleApiClient.zab(this.b);
                }
            } catch (RuntimeException e) {
                arVar = this.b.h;
                arVar2 = this.b.h;
                arVar.sendMessage(arVar2.obtainMessage(1, e));
                BasePendingResult.c.set(false);
                zacm zacmVar2 = this.b;
                zacm.a(this.f1342a);
                weakReference2 = this.b.g;
                GoogleApiClient googleApiClient2 = (GoogleApiClient) weakReference2.get();
                if (googleApiClient2 != null) {
                    googleApiClient2.zab(this.b);
                }
            }
        } catch (Throwable th) {
            BasePendingResult.c.set(false);
            zacm zacmVar3 = this.b;
            zacm.a(this.f1342a);
            weakReference = this.b.g;
            GoogleApiClient googleApiClient3 = (GoogleApiClient) weakReference.get();
            if (googleApiClient3 != null) {
                googleApiClient3.zab(this.b);
            }
            throw th;
        }
    }
}
