package com.google.android.vending.licensing;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.android.vending.licensing.ILicenseResultListener;
import com.android.vending.licensing.ILicensingService;
import com.google.android.vending.licensing.util.Base64DecoderException;
import com.tencent.imsdk.android.tools.log.LogUtils;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/* loaded from: classes2.dex */
public class d implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private static final SecureRandom f5383a = new SecureRandom();
    private ILicensingService b;
    private PublicKey c;
    private final Context d;
    private final i e;
    private Handler f;
    private final String g;
    private final String h;
    private final Set<f> i = new HashSet();
    private final Queue<f> j = new LinkedList();

    public d(Context context, i iVar, String str) {
        this.d = context;
        this.e = iVar;
        this.c = a(str);
        this.g = this.d.getPackageName();
        this.h = a(context, this.g);
        HandlerThread handlerThread = new HandlerThread("background thread");
        handlerThread.start();
        this.f = new Handler(handlerThread.getLooper());
    }

    private static PublicKey a(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(com.google.android.vending.licensing.util.a.a(str)));
        } catch (Base64DecoderException e) {
            Log.e("LicenseChecker", "Could not decode from Base64.");
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        } catch (InvalidKeySpecException e3) {
            Log.e("LicenseChecker", "Invalid key specification.");
            throw new IllegalArgumentException(e3);
        }
    }

    public synchronized void a(e eVar) {
        if (this.e.c()) {
            Log.i("LicenseChecker", "Using cached license response");
            eVar.allow(256);
        } else {
            f fVar = new f(this.e, new g(), eVar, d(), this.g, this.h);
            if (this.b == null) {
                Log.i("LicenseChecker", "Binding to licensing service.");
                try {
                    if (this.d.bindService(new Intent(new String(com.google.android.vending.licensing.util.a.a("Y29tLmFuZHJvaWQudmVuZGluZy5saWNlbnNpbmcuSUxpY2Vuc2luZ1NlcnZpY2U="))).setPackage(new String(com.google.android.vending.licensing.util.a.a("Y29tLmFuZHJvaWQudmVuZGluZw=="))), this, 1)) {
                        this.j.offer(fVar);
                    } else {
                        Log.e("LicenseChecker", "Could not bind to service.");
                        b(fVar);
                    }
                } catch (Base64DecoderException e) {
                    e.printStackTrace();
                } catch (SecurityException unused) {
                    eVar.applicationError(6);
                }
            } else {
                this.j.offer(fVar);
                b();
            }
        }
    }

    private void b() {
        while (true) {
            f poll = this.j.poll();
            if (poll == null) {
                return;
            }
            try {
                Log.i("LicenseChecker", "Calling checkLicense on service for " + poll.c());
                this.b.checkLicense((long) poll.b(), poll.c(), new a(poll));
                this.i.add(poll);
            } catch (RemoteException e) {
                Log.w("LicenseChecker", "RemoteException in checkLicense call.", e);
                b(poll);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(f fVar) {
        this.i.remove(fVar);
        if (this.i.isEmpty()) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends ILicenseResultListener.Stub {
        private final f b;
        private Runnable c;

        public a(f fVar) {
            this.b = fVar;
            this.c = new Runnable() { // from class: com.google.android.vending.licensing.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("LicenseChecker", "Check timed out.");
                    d.this.b(a.this.b);
                    d.this.a(a.this.b);
                }
            };
            a();
        }

        @Override // com.android.vending.licensing.ILicenseResultListener
        public void verifyLicense(final int i, final String str, final String str2) {
            d.this.f.post(new Runnable() { // from class: com.google.android.vending.licensing.d.a.2
                @Override // java.lang.Runnable
                public void run() {
                    Log.i("LicenseChecker", "Received response.");
                    if (d.this.i.contains(a.this.b)) {
                        a.this.b();
                        a.this.b.a(d.this.c, i, str, str2);
                        d.this.a(a.this.b);
                    }
                }
            });
        }

        private void a() {
            Log.i("LicenseChecker", "Start monitoring timeout.");
            d.this.f.postDelayed(this.c, LogUtils.LOG_FUSE_TIME);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            Log.i("LicenseChecker", "Clearing timeout.");
            d.this.f.removeCallbacks(this.c);
        }
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.b = ILicensingService.Stub.asInterface(iBinder);
        b();
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceDisconnected(ComponentName componentName) {
        Log.w("LicenseChecker", "Service unexpectedly disconnected.");
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(f fVar) {
        this.e.a(291, null);
        if (this.e.c()) {
            fVar.a().allow(291);
        } else {
            fVar.a().dontAllow(291);
        }
    }

    private void c() {
        if (this.b != null) {
            try {
                this.d.unbindService(this);
            } catch (IllegalArgumentException unused) {
                Log.e("LicenseChecker", "Unable to unbind from licensing service (already unbound)");
            }
            this.b = null;
        }
    }

    public synchronized void a() {
        c();
        this.f.getLooper().quit();
    }

    private int d() {
        return f5383a.nextInt();
    }

    private static String a(Context context, String str) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(str, 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("LicenseChecker", "Package not found. could not get version code.");
            return "";
        }
    }
}
