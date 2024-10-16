package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzuq {

    /* renamed from: a, reason: collision with root package name */
    private final Object f3753a = new Object();

    @GuardedBy("activityTrackerLock")
    private aot b = null;

    @GuardedBy("activityTrackerLock")
    private boolean c = false;

    public final void initialize(Context context) {
        synchronized (this.f3753a) {
            if (!this.c) {
                if (!PlatformVersion.isAtLeastIceCreamSandwich()) {
                    return;
                }
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    zzawz.zzep("Can not cast Context to Application");
                    return;
                }
                if (this.b == null) {
                    this.b = new aot();
                }
                this.b.a(application, context);
                this.c = true;
            }
        }
    }

    public final void zza(zzut zzutVar) {
        synchronized (this.f3753a) {
            if (PlatformVersion.isAtLeastIceCreamSandwich()) {
                if (this.b == null) {
                    this.b = new aot();
                }
                this.b.a(zzutVar);
            }
        }
    }

    public final Activity getActivity() {
        synchronized (this.f3753a) {
            if (!PlatformVersion.isAtLeastIceCreamSandwich()) {
                return null;
            }
            if (this.b == null) {
                return null;
            }
            return this.b.a();
        }
    }

    public final Context getContext() {
        synchronized (this.f3753a) {
            if (!PlatformVersion.isAtLeastIceCreamSandwich()) {
                return null;
            }
            if (this.b == null) {
                return null;
            }
            return this.b.b();
        }
    }
}
