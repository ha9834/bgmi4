package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public abstract class GmsClientSupervisor {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1451a = new Object();
    private static GmsClientSupervisor b;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean a(zza zzaVar, ServiceConnection serviceConnection, String str);

    protected abstract void b(zza zzaVar, ServiceConnection serviceConnection, String str);

    @KeepForSdk
    public static GmsClientSupervisor getInstance(Context context) {
        synchronized (f1451a) {
            if (b == null) {
                b = new k(context.getApplicationContext());
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class zza {

        /* renamed from: a, reason: collision with root package name */
        private final String f1452a;
        private final String b;
        private final ComponentName c;
        private final int d;

        public zza(String str, int i) {
            this.f1452a = Preconditions.checkNotEmpty(str);
            this.b = "com.google.android.gms";
            this.c = null;
            this.d = 129;
        }

        public zza(String str, String str2, int i) {
            this.f1452a = Preconditions.checkNotEmpty(str);
            this.b = Preconditions.checkNotEmpty(str2);
            this.c = null;
            this.d = i;
        }

        public zza(ComponentName componentName, int i) {
            this.f1452a = null;
            this.b = null;
            this.c = (ComponentName) Preconditions.checkNotNull(componentName);
            this.d = 129;
        }

        public final String toString() {
            String str = this.f1452a;
            return str == null ? this.c.flattenToString() : str;
        }

        public final String getPackage() {
            return this.b;
        }

        public final ComponentName getComponentName() {
            return this.c;
        }

        public final int zzq() {
            return this.d;
        }

        public final Intent zzb(Context context) {
            String str = this.f1452a;
            if (str != null) {
                return new Intent(str).setPackage(this.b);
            }
            return new Intent().setComponent(this.c);
        }

        public final int hashCode() {
            return Objects.hashCode(this.f1452a, this.b, this.c, Integer.valueOf(this.d));
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return Objects.equal(this.f1452a, zzaVar.f1452a) && Objects.equal(this.b, zzaVar.b) && Objects.equal(this.c, zzaVar.c) && this.d == zzaVar.d;
        }
    }

    @KeepForSdk
    public boolean bindService(String str, ServiceConnection serviceConnection, String str2) {
        return a(new zza(str, 129), serviceConnection, str2);
    }

    @KeepForSdk
    public boolean bindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return a(new zza(componentName, 129), serviceConnection, str);
    }

    @KeepForSdk
    public void unbindService(String str, ServiceConnection serviceConnection, String str2) {
        b(new zza(str, 129), serviceConnection, str2);
    }

    public final void zza(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        b(new zza(str, str2, i), serviceConnection, str3);
    }

    @KeepForSdk
    public void unbindService(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        b(new zza(componentName, 129), serviceConnection, str);
    }
}
