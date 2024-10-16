package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.gtm.zzpf;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
final class ao extends Thread implements an {
    private static ao d;

    /* renamed from: a, reason: collision with root package name */
    private final LinkedBlockingQueue<Runnable> f5077a;
    private volatile boolean b;
    private volatile boolean c;
    private volatile ar e;
    private final Context f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ao a(Context context) {
        if (d == null) {
            d = new ao(context);
        }
        return d;
    }

    private ao(Context context) {
        super("GAThread");
        this.f5077a = new LinkedBlockingQueue<>();
        this.b = false;
        this.c = false;
        if (context != null) {
            this.f = context.getApplicationContext();
        } else {
            this.f = context;
        }
        start();
    }

    @Override // com.google.android.gms.tagmanager.an
    public final void a(String str) {
        a(new aq(this, this, System.currentTimeMillis(), str));
    }

    @Override // com.google.android.gms.tagmanager.an
    public final void a(Runnable runnable) {
        this.f5077a.add(runnable);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (true) {
            boolean z = this.c;
            try {
                try {
                    Runnable take = this.f5077a.take();
                    if (!this.b) {
                        take.run();
                    }
                } catch (InterruptedException e) {
                    zzdi.zzaw(e.toString());
                }
            } catch (Exception e2) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                PrintStream printStream = new PrintStream(byteArrayOutputStream);
                zzpf.zza(e2, printStream);
                printStream.flush();
                String valueOf = String.valueOf(new String(byteArrayOutputStream.toByteArray()));
                zzdi.zzav(valueOf.length() != 0 ? "Error on Google TagManager Thread: ".concat(valueOf) : new String("Error on Google TagManager Thread: "));
                zzdi.zzav("Google TagManager is shutting down.");
                this.b = true;
            }
        }
    }
}
