package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ax implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zal f1348a;
    private final aw b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(zal zalVar, aw awVar) {
        this.f1348a = zalVar;
        this.b = awVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1348a.b) {
            ConnectionResult b = this.b.b();
            if (b.hasResolution()) {
                this.f1348a.f1316a.startActivityForResult(GoogleApiActivity.zaa(this.f1348a.getActivity(), b.getResolution(), this.b.a(), false), 1);
                return;
            }
            if (this.f1348a.d.isUserResolvableError(b.getErrorCode())) {
                this.f1348a.d.zaa(this.f1348a.getActivity(), this.f1348a.f1316a, b.getErrorCode(), 2, this.f1348a);
            } else if (b.getErrorCode() == 18) {
                this.f1348a.d.zaa(this.f1348a.getActivity().getApplicationContext(), new ay(this, GoogleApiAvailability.zaa(this.f1348a.getActivity(), this.f1348a)));
            } else {
                this.f1348a.a(b, this.b.a());
            }
        }
    }
}
