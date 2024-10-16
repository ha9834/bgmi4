package com.ihoc.mgpa.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.ihoc.mgpa.n.m;

/* loaded from: classes2.dex */
public class I implements m.a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile I f5523a;
    private a b;
    private HandlerThread c = new HandlerThread("tgpa_subhandler");

    /* loaded from: classes2.dex */
    private class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        com.ihoc.mgpa.c.a.c().a();
                    } else if (i != 3) {
                        com.ihoc.mgpa.n.m.d("[VmpSubHandler]: no msg type is matched!", new Object[0]);
                    } else {
                        I.this.a(message);
                    }
                }
            } catch (Throwable unused) {
                com.ihoc.mgpa.n.m.b("[VmpSubHandler]: run exception, ple check!", new Object[0]);
            }
        }
    }

    private I() {
    }

    public static I a() {
        if (f5523a == null) {
            synchronized (I.class) {
                if (f5523a == null) {
                    f5523a = new I();
                }
            }
        }
        return f5523a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Object obj = message.obj;
        if (obj == null) {
            return;
        }
        com.ihoc.mgpa.n.m.a(obj.toString());
    }

    public void a(int i, String str, long j) {
        a aVar = this.b;
        if (aVar != null) {
            this.b.sendMessageDelayed(Message.obtain(aVar, i, str), j);
        }
    }

    @Override // com.ihoc.mgpa.n.m.a
    public void a(String str) {
        a aVar = this.b;
        if (aVar != null) {
            Message.obtain(aVar, 3, str).sendToTarget();
        }
    }

    public void b() {
        if (this.c.isAlive()) {
            com.ihoc.mgpa.n.m.a("VmpSubHandler: tgpa sub handler thread is already alive, do not need create again!", new Object[0]);
        } else {
            com.ihoc.mgpa.n.m.a("VmpSubHandler: tgpa sub handler thread start!", new Object[0]);
            this.c.start();
            this.b = new a(this.c.getLooper());
        }
        com.ihoc.mgpa.n.m.a(this);
    }
}
