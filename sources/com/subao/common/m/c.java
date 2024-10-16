package com.subao.common.m;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class c implements Executor {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayDeque<Runnable> f6129a = new ArrayDeque<>();
    private Runnable b;

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        synchronized (this) {
            this.f6129a.offer(new Runnable() { // from class: com.subao.common.m.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        c.this.a();
                    }
                }
            });
            if (this.b == null) {
                a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        synchronized (this) {
            Runnable poll = this.f6129a.poll();
            this.b = poll;
            if (poll != null) {
                d.a().execute(this.b);
            }
        }
    }
}
