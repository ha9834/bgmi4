package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* loaded from: classes.dex */
final class bh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ LifecycleCallback f1357a;
    private final /* synthetic */ String b;
    private final /* synthetic */ zzc c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(zzc zzcVar, LifecycleCallback lifecycleCallback, String str) {
        this.c = zzcVar;
        this.f1357a = lifecycleCallback;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        i = this.c.c;
        if (i > 0) {
            LifecycleCallback lifecycleCallback = this.f1357a;
            bundle = this.c.d;
            if (bundle != null) {
                bundle3 = this.c.d;
                bundle2 = bundle3.getBundle(this.b);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
        i2 = this.c.c;
        if (i2 >= 2) {
            this.f1357a.onStart();
        }
        i3 = this.c.c;
        if (i3 >= 3) {
            this.f1357a.onResume();
        }
        i4 = this.c.c;
        if (i4 >= 4) {
            this.f1357a.onStop();
        }
        i5 = this.c.c;
        if (i5 >= 5) {
            this.f1357a.onDestroy();
        }
    }
}
