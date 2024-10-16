package com.google.android.vending.expansion.downloader;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public class c {

    /* loaded from: classes2.dex */
    private static class a implements f {

        /* renamed from: a, reason: collision with root package name */
        private Messenger f5362a;

        private void a(int i, Bundle bundle) {
            Message obtain = Message.obtain((Handler) null, i);
            obtain.setData(bundle);
            try {
                this.f5362a.send(obtain);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        public a(Messenger messenger) {
            this.f5362a = messenger;
        }

        @Override // com.google.android.vending.expansion.downloader.f
        public void a() {
            a(1, new Bundle());
        }

        @Override // com.google.android.vending.expansion.downloader.f
        public void b() {
            a(2, new Bundle());
        }

        @Override // com.google.android.vending.expansion.downloader.f
        public void a(int i) {
            Bundle bundle = new Bundle();
            bundle.putInt("flags", i);
            a(3, bundle);
        }

        @Override // com.google.android.vending.expansion.downloader.f
        public void c() {
            a(4, new Bundle());
        }

        @Override // com.google.android.vending.expansion.downloader.f
        public void d() {
            a(5, new Bundle());
        }

        @Override // com.google.android.vending.expansion.downloader.f
        public void a(Messenger messenger) {
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("EMH", messenger);
            a(6, bundle);
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements g {

        /* renamed from: a, reason: collision with root package name */
        final Messenger f5363a = new Messenger(new Handler() { // from class: com.google.android.vending.expansion.downloader.c.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        b.this.b.a();
                        return;
                    case 2:
                        b.this.b.b();
                        return;
                    case 3:
                        b.this.b.a(message.getData().getInt("flags"));
                        return;
                    case 4:
                        b.this.b.c();
                        return;
                    case 5:
                        b.this.b.d();
                        return;
                    case 6:
                        b.this.b.a((Messenger) message.getData().getParcelable("EMH"));
                        return;
                    default:
                        return;
                }
            }
        });
        private f b;

        @Override // com.google.android.vending.expansion.downloader.g
        public void a(Context context) {
        }

        @Override // com.google.android.vending.expansion.downloader.g
        public void b(Context context) {
        }

        public b(f fVar) {
            this.b = null;
            this.b = fVar;
        }

        @Override // com.google.android.vending.expansion.downloader.g
        public Messenger a() {
            return this.f5363a;
        }
    }

    public static f a(Messenger messenger) {
        return new a(messenger);
    }

    public static g a(f fVar) {
        return new b(fVar);
    }
}
