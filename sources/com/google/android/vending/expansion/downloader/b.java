package com.google.android.vending.expansion.downloader;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;

/* loaded from: classes2.dex */
public class b {

    /* loaded from: classes2.dex */
    private static class a implements e {

        /* renamed from: a, reason: collision with root package name */
        private Messenger f5358a;

        @Override // com.google.android.vending.expansion.downloader.e
        public void a(Messenger messenger) {
        }

        @Override // com.google.android.vending.expansion.downloader.e
        public void a(int i) {
            Bundle bundle = new Bundle(1);
            bundle.putInt("newState", i);
            a(10, bundle);
        }

        @Override // com.google.android.vending.expansion.downloader.e
        public void a(DownloadProgressInfo downloadProgressInfo) {
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("progress", downloadProgressInfo);
            a(11, bundle);
        }

        private void a(int i, Bundle bundle) {
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                this.f5358a.send(obtain);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        public a(Messenger messenger) {
            this.f5358a = messenger;
        }
    }

    /* renamed from: com.google.android.vending.expansion.downloader.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0121b implements g {
        private e b;
        private Class<?> c;
        private boolean d;
        private Messenger e;
        private Context f;

        /* renamed from: a, reason: collision with root package name */
        final Messenger f5359a = new Messenger(new Handler() { // from class: com.google.android.vending.expansion.downloader.b.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 10:
                        C0121b.this.b.a(message.getData().getInt("newState"));
                        return;
                    case 11:
                        Bundle data = message.getData();
                        if (C0121b.this.f != null) {
                            data.setClassLoader(C0121b.this.f.getClassLoader());
                            C0121b.this.b.a((DownloadProgressInfo) message.getData().getParcelable("progress"));
                            return;
                        }
                        return;
                    case 12:
                        C0121b.this.b.a((Messenger) message.getData().getParcelable("EMH"));
                        return;
                    default:
                        return;
                }
            }
        });
        private ServiceConnection g = new ServiceConnection() { // from class: com.google.android.vending.expansion.downloader.b.b.2
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                C0121b.this.e = new Messenger(iBinder);
                C0121b.this.b.a(C0121b.this.e);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                C0121b.this.e = null;
            }
        };

        public C0121b(e eVar, Class<?> cls) {
            this.b = null;
            this.b = eVar;
            this.c = cls;
        }

        @Override // com.google.android.vending.expansion.downloader.g
        public void a(Context context) {
            this.f = context;
            Intent intent = new Intent(context, this.c);
            intent.putExtra("EMH", this.f5359a);
            if (context.bindService(intent, this.g, 2)) {
                this.d = true;
            }
        }

        @Override // com.google.android.vending.expansion.downloader.g
        public void b(Context context) {
            if (this.d) {
                context.unbindService(this.g);
                this.d = false;
            }
            this.f = null;
        }

        @Override // com.google.android.vending.expansion.downloader.g
        public Messenger a() {
            return this.f5359a;
        }
    }

    public static e a(Messenger messenger) {
        return new a(messenger);
    }

    public static g a(e eVar, Class<?> cls) {
        return new C0121b(eVar, cls);
    }

    public static int a(Context context, PendingIntent pendingIntent, Class<?> cls) throws PackageManager.NameNotFoundException {
        return DownloaderService.a(context, pendingIntent, cls);
    }

    public static int a(Context context, Intent intent, Class<?> cls) throws PackageManager.NameNotFoundException {
        return DownloaderService.a(context, intent, cls);
    }
}
