package com.shieldtunnel.svpn.common.f;

import android.text.TextUtils;
import android.util.Log;
import com.amazonaws.event.ProgressEvent;
import com.shieldtunnel.svpn.common.LogTag;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f5812a;
    private final com.shieldtunnel.svpn.common.g.b b;

    /* loaded from: classes2.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f5813a;
        final /* synthetic */ byte[] b;
        final /* synthetic */ byte[] c;
        final /* synthetic */ boolean d;

        a(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z) {
            this.f5813a = bArr;
            this.b = bArr2;
            this.c = bArr3;
            this.d = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String a2 = com.shieldtunnel.svpn.common.k.e.a(this.f5813a);
                String a3 = com.shieldtunnel.svpn.common.k.e.a(this.b);
                com.shieldtunnel.svpn.common.g.b a4 = h.this.a(a2, a3);
                boolean a5 = com.shieldtunnel.svpn.common.b.a(LogTag.DATA);
                if (this.c == null) {
                    if (this.d) {
                        return;
                    }
                    boolean b = a4.b();
                    if (a5) {
                        Log.d(LogTag.DATA, String.format("(JNI) delete '%s/%s' return: %b", a2, a3, Boolean.valueOf(b)));
                        return;
                    }
                    return;
                }
                OutputStream a6 = a4.a(this.d);
                try {
                    a6.write(this.c);
                    if (a5) {
                        Log.d(LogTag.DATA, String.format(f.b, "(JNI) write to '%s/%s' %d bytes", a2, a3, Integer.valueOf(this.c.length)));
                    }
                } finally {
                    com.shieldtunnel.svpn.common.c.a(a6);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f5814a;
        final /* synthetic */ byte[] b;
        final /* synthetic */ com.shieldtunnel.svpn.common.jni.b c;
        final /* synthetic */ int d;

        b(byte[] bArr, byte[] bArr2, com.shieldtunnel.svpn.common.jni.b bVar, int i) {
            this.f5814a = bArr;
            this.b = bArr2;
            this.c = bVar;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr;
            int i;
            try {
                bArr = h.this.a(com.shieldtunnel.svpn.common.k.e.a(this.f5814a), com.shieldtunnel.svpn.common.k.e.a(this.b)).a(10485760);
                i = 0;
            } catch (IOException unused) {
                bArr = null;
                i = 5;
            }
            this.c.a(this.d, i, bArr);
        }
    }

    /* loaded from: classes2.dex */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f5815a;
        final /* synthetic */ byte[] b;

        c(byte[] bArr, byte[] bArr2) {
            this.f5815a = bArr;
            this.b = bArr2;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] split = com.shieldtunnel.svpn.common.k.e.a(this.f5815a).split("\\|");
            String a2 = com.shieldtunnel.svpn.common.k.e.a(this.b);
            for (String str : split) {
                boolean b = h.this.a(a2, str).b();
                if (com.shieldtunnel.svpn.common.b.a(LogTag.DATA)) {
                    Log.d(LogTag.DATA, String.format("(JNI) delete '%s/%s' return: %b", a2, str, Boolean.valueOf(b)));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ byte[] f5816a;
        final /* synthetic */ com.shieldtunnel.svpn.common.jni.b b;
        final /* synthetic */ int c;

        d(byte[] bArr, com.shieldtunnel.svpn.common.jni.b bVar, int i) {
            this.f5816a = bArr;
            this.b = bVar;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            int i;
            String a2 = com.shieldtunnel.svpn.common.k.e.a(this.f5816a);
            Iterable<com.shieldtunnel.svpn.common.g.b> f = (TextUtils.isEmpty(a2) ? h.this.b : h.this.b.a(a2)).f();
            if (f != null) {
                StringBuilder sb = new StringBuilder(ProgressEvent.PART_COMPLETED_EVENT_CODE);
                int i2 = 0;
                for (com.shieldtunnel.svpn.common.g.b bVar : f) {
                    if (bVar.c()) {
                        sb.append(bVar.a());
                        sb.append('|');
                        i2++;
                        if (i2 > 256) {
                            break;
                        }
                    }
                }
                str = sb.toString();
                i = 0;
            } else {
                str = "";
                i = 5;
            }
            if (com.shieldtunnel.svpn.common.b.a(LogTag.DATA)) {
                Log.d(LogTag.DATA, String.format("(JNI) '%s' list: '%s'", a2, str));
            }
            this.b.a(this.c, i, str);
        }
    }

    public h(com.shieldtunnel.svpn.common.g.b bVar) {
        this(bVar, Executors.newSingleThreadExecutor());
    }

    h(com.shieldtunnel.svpn.common.g.b bVar, Executor executor) {
        this.b = bVar;
        this.f5812a = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.shieldtunnel.svpn.common.g.b a(String str, String str2) {
        return (TextUtils.isEmpty(str) ? this.b : this.b.a(str)).a(str2);
    }

    public void a(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z) {
        this.f5812a.execute(new a(bArr, bArr2, bArr3, z));
    }

    public void a(byte[] bArr, byte[] bArr2, com.shieldtunnel.svpn.common.jni.b bVar, int i) {
        this.f5812a.execute(new b(bArr, bArr2, bVar, i));
    }

    public void a(byte[] bArr, byte[] bArr2) {
        this.f5812a.execute(new c(bArr2, bArr));
    }

    public void a(byte[] bArr, com.shieldtunnel.svpn.common.jni.b bVar, int i) {
        this.f5812a.execute(new d(bArr, bVar, i));
    }
}
