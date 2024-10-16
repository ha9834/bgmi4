package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.drive.DriveFile;
import java.lang.ref.WeakReference;

@zzard
/* loaded from: classes2.dex */
public final class zzasq extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    private Context f2797a;
    private WeakReference<Activity> b;

    private zzasq(Context context) {
        super(context);
        this.b = new WeakReference<>(null);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this;
    }

    public final synchronized void setAppPackageName(String str) throws PackageManager.NameNotFoundException {
        this.f2797a = super.createPackageContext(str, 0);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized ApplicationInfo getApplicationInfo() {
        if (this.f2797a != null) {
            return this.f2797a.getApplicationInfo();
        }
        return super.getApplicationInfo();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized String getPackageName() {
        if (this.f2797a != null) {
            return this.f2797a.getPackageName();
        }
        return super.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized String getPackageResourcePath() {
        if (this.f2797a != null) {
            return this.f2797a.getPackageResourcePath();
        }
        return super.getPackageResourcePath();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final synchronized void startActivity(Intent intent) {
        b(a(intent));
    }

    private final synchronized Intent a(Intent intent) {
        if (this.f2797a != null && intent.getComponent() != null && intent.getComponent().getPackageName().equals(this.f2797a.getPackageName())) {
            Intent intent2 = (Intent) intent.clone();
            intent2.setClassName(super.getPackageName(), intent.getComponent().getClassName());
            return intent2;
        }
        return intent;
    }

    private final synchronized void b(Intent intent) {
        Activity activity = this.b.get();
        if (activity == null) {
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            super.startActivity(intent);
            return;
        }
        try {
            Intent intent2 = (Intent) intent.clone();
            intent2.setFlags(intent.getFlags() & (-268435457));
            activity.startActivity(intent2);
        } catch (Throwable th) {
            zzk.zzlk().zza(th, "");
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            super.startActivity(intent);
        }
    }

    public static zzasq zzv(Context context) {
        return new zzasq(a(context));
    }

    public static Context zzw(Context context) {
        if (context instanceof zzasq) {
            return ((zzasq) context).getBaseContext();
        }
        return a(context);
    }

    private static Context a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }
}
