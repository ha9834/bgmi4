package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public class zaae extends zal {
    private final androidx.b.b<zai<?>> e;
    private GoogleApiManager f;

    public static void zaa(Activity activity, GoogleApiManager googleApiManager, zai<?> zaiVar) {
        LifecycleFragment fragment = getFragment(activity);
        zaae zaaeVar = (zaae) fragment.getCallbackOrNull("ConnectionlessLifecycleHelper", zaae.class);
        if (zaaeVar == null) {
            zaaeVar = new zaae(fragment);
        }
        zaaeVar.f = googleApiManager;
        Preconditions.checkNotNull(zaiVar, "ApiKey cannot be null");
        zaaeVar.e.add(zaiVar);
        googleApiManager.zaa(zaaeVar);
    }

    private zaae(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.e = new androidx.b.b<>();
        this.f1316a.addCallback("ConnectionlessLifecycleHelper", this);
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStart() {
        super.onStart();
        d();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void onResume() {
        super.onResume();
        d();
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void onStop() {
        super.onStop();
        this.f.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.zal
    public final void a(ConnectionResult connectionResult, int i) {
        this.f.zaa(connectionResult, i);
    }

    @Override // com.google.android.gms.common.api.internal.zal
    protected final void a() {
        this.f.zao();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final androidx.b.b<zai<?>> b() {
        return this.e;
    }

    private final void d() {
        if (this.e.isEmpty()) {
            return;
        }
        this.f.zaa(this);
    }
}
