package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zze extends androidx.loader.content.a<Void> implements SignInConnectionListener {
    private Semaphore o;
    private Set<GoogleApiClient> p;

    public zze(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.o = new Semaphore(0);
        this.p = set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.loader.content.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final Void loadInBackground() {
        Iterator<GoogleApiClient> it = this.p.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().maybeSignIn(this)) {
                i++;
            }
        }
        try {
            this.o.tryAcquire(i, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // androidx.loader.content.b
    protected final void e() {
        this.o.drainPermits();
        forceLoad();
    }

    @Override // com.google.android.gms.common.api.internal.SignInConnectionListener
    public final void onComplete() {
        this.o.release();
    }
}
