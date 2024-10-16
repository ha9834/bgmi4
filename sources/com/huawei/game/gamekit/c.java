package com.huawei.game.gamekit;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Process;
import android.rms.iaware.IAwareSdkCore;
import android.text.TextUtils;
import com.huawei.game.gamekit.GameManager;
import com.huawei.game.gamekit.a.g;
import com.huawei.game.gamekit.a.h;

/* loaded from: classes2.dex */
public final class c extends com.huawei.game.gamekit.a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5474a = "GameKit";
    private static final int b = 3005;
    private static final int c = 1;
    private static final int d = 3;
    private static c e;
    private static final Object f = new Object();
    private static int g = 1;
    private static int h = 4;
    private String o;
    private GameManager.GameCallBack k = null;
    private a l = null;
    private String m = "";
    private int n = 0;
    private g i = new h();
    private g j = new com.huawei.game.gamekit.a.b();

    /* loaded from: classes2.dex */
    private class a extends Binder implements IInterface {
        private static final String b = "com.huawei.iaware.sdk.ISDKCallbak";
        private static final int c = 1;
        private static final int d = 2;
        private static final int e = 3;

        a() {
            attachInterface(this, b);
        }

        private static boolean a(Parcel parcel) {
            try {
                parcel.enforceInterface(b);
                com.huawei.game.gamekit.b.b a2 = com.huawei.game.gamekit.b.b.a();
                String readString = parcel.readString();
                com.huawei.devices.hapticskit.b bVar = a2.b;
                if (bVar == null) {
                    com.huawei.game.gamekit.b.c.c("HapticsUtil", "HapticsUtil mHapticsAdapter is null");
                    return true;
                }
                bVar.a(readString);
                com.huawei.game.gamekit.b.c.b("HapticsUtil", "setVibrationLevel Success:" + readString);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str;
            if (i > 0 && i <= 16777215) {
                if (i == 1) {
                    try {
                        parcel.enforceInterface(b);
                        String readString = parcel.readString();
                        synchronized (c.f) {
                            str = c.this.o;
                        }
                        String a2 = c.this.i.a(readString, str).a(c.this.m, readString);
                        if (c.this.k != null) {
                            com.huawei.game.gamekit.b.c.b(c.f5474a, "SdkCallback onPhoneInfoUpdated");
                            c.this.k.onPhoneInfoUpdated(a2);
                        }
                        return true;
                    } catch (SecurityException unused) {
                        return false;
                    }
                }
                if (i == 2) {
                    try {
                        parcel.enforceInterface(b);
                        synchronized (c.f) {
                            c.this.o = parcel.readString();
                            com.huawei.game.gamekit.b.c.b(c.f5474a, "SdkCallback IAware Version is " + c.this.o);
                        }
                        if (parcel2 != null) {
                            parcel2.writeString(BuildConfig.VERSION_NAME);
                            return true;
                        }
                        com.huawei.game.gamekit.b.c.c(c.f5474a, "SdkCallback cannot input kit version");
                        return false;
                    } catch (SecurityException unused2) {
                        return false;
                    }
                }
                if (i != 3) {
                    return false;
                }
                a(parcel);
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }
    }

    private c() {
    }

    private static boolean a(String str, a aVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeString(str);
        obtain.writeStrongBinder(aVar);
        boolean handleEvent = IAwareSdkCore.handleEvent(h, obtain, obtain2);
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        com.huawei.game.gamekit.b.c.b(f5474a, "remote registerSdkCallback return:" + handleEvent + "reply:" + readInt);
        return readInt > 0 && handleEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static synchronized com.huawei.game.gamekit.a b() {
        c cVar;
        synchronized (c.class) {
            if (e == null) {
                e = new c();
            }
            cVar = e;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.game.gamekit.a
    public final void a(String str) {
        String str2;
        com.huawei.game.gamekit.b.c.b(f5474a, "reportData package:" + this.m);
        synchronized (f) {
            str2 = this.o;
        }
        String a2 = this.j.a(str, str2).a(this.m, str);
        if (TextUtils.isEmpty(a2)) {
            return;
        }
        Parcel obtain = Parcel.obtain();
        String str3 = "1&&" + this.m + "&&" + this.n + "&&" + a2;
        obtain.writeInt(3005);
        obtain.writeLong(0L);
        obtain.writeString(str3);
        com.huawei.game.gamekit.b.c.b(f5474a, "reportData result: " + IAwareSdkCore.handleEvent(g, obtain, null, 3005));
        obtain.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.game.gamekit.a
    public final boolean a(String str, GameManager.GameCallBack gameCallBack) {
        if (TextUtils.isEmpty(str) || gameCallBack == null) {
            com.huawei.game.gamekit.b.c.c(f5474a, "package " + str + " register failed: invalid params");
            return false;
        }
        this.k = gameCallBack;
        this.m = str;
        this.n = Process.myPid();
        if (this.l == null) {
            this.l = new a();
            com.huawei.game.gamekit.b.c.a(f5474a, "need create SdkCallback");
        }
        a aVar = this.l;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        obtain.writeString(str);
        obtain.writeStrongBinder(aVar);
        boolean handleEvent = IAwareSdkCore.handleEvent(h, obtain, obtain2);
        int readInt = obtain2.readInt();
        obtain2.recycle();
        obtain.recycle();
        com.huawei.game.gamekit.b.c.b(f5474a, "remote registerSdkCallback return:" + handleEvent + "reply:" + readInt);
        return readInt > 0 && handleEvent;
    }
}
