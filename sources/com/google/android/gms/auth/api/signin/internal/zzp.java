package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes.dex */
public final class zzp {

    /* renamed from: a, reason: collision with root package name */
    private static zzp f1268a;

    @VisibleForTesting
    private Storage b;

    @VisibleForTesting
    private GoogleSignInAccount c;

    @VisibleForTesting
    private GoogleSignInOptions d;

    private zzp(Context context) {
        this.b = Storage.getInstance(context);
        this.c = this.b.getSavedDefaultGoogleSignInAccount();
        this.d = this.b.getSavedDefaultGoogleSignInOptions();
    }

    public static synchronized zzp zzd(Context context) {
        zzp a2;
        synchronized (zzp.class) {
            a2 = a(context.getApplicationContext());
        }
        return a2;
    }

    private static synchronized zzp a(Context context) {
        zzp zzpVar;
        synchronized (zzp.class) {
            if (f1268a == null) {
                f1268a = new zzp(context);
            }
            zzpVar = f1268a;
        }
        return zzpVar;
    }

    public final synchronized void clear() {
        this.b.clear();
        this.c = null;
        this.d = null;
    }

    public final synchronized void zzc(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.b.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
        this.c = googleSignInAccount;
        this.d = googleSignInOptions;
    }

    public final synchronized GoogleSignInAccount zzh() {
        return this.c;
    }

    public final synchronized GoogleSignInOptions zzi() {
        return this.d;
    }
}
