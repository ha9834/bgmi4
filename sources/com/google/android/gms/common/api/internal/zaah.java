package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zaah implements zabd {

    /* renamed from: a, reason: collision with root package name */
    private final zabe f1385a;
    private boolean b = false;

    public zaah(zabe zabeVar) {
        this.f1385a = zabeVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void begin() {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void onConnected(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        return (T) execute(t);
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        try {
            this.f1385a.d.e.a(t);
            zaaw zaawVar = this.f1385a.d;
            Api.Client client = zaawVar.b.get(t.getClientKey());
            Preconditions.checkNotNull(client, "Appropriate Api was not requested.");
            if (!client.isConnected() && this.f1385a.b.containsKey(t.getClientKey())) {
                t.setFailedResult(new Status(17));
            } else {
                boolean z = client instanceof SimpleClientAdapter;
                A a2 = client;
                if (z) {
                    a2 = ((SimpleClientAdapter) client).getClient();
                }
                t.run(a2);
            }
        } catch (DeadObjectException unused) {
            this.f1385a.a(new e(this, this));
        }
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final boolean disconnect() {
        if (this.b) {
            return false;
        }
        if (this.f1385a.d.c()) {
            this.b = true;
            Iterator<zacm> it = this.f1385a.d.d.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            return false;
        }
        this.f1385a.a((ConnectionResult) null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void connect() {
        if (this.b) {
            this.b = false;
            this.f1385a.a(new f(this, this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void onConnectionSuspended(int i) {
        this.f1385a.a((ConnectionResult) null);
        this.f1385a.e.zab(i, this.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        if (this.b) {
            this.b = false;
            this.f1385a.d.e.release();
            disconnect();
        }
    }
}
