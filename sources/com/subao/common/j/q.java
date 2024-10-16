package com.subao.common.j;

import android.content.Context;

/* loaded from: classes2.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    private final a f6089a;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i);
    }

    public abstract void a();

    public abstract void a(Context context);

    /* JADX INFO: Access modifiers changed from: protected */
    public q(a aVar) {
        if (aVar == null) {
            throw new NullPointerException("Callback can not be null");
        }
        this.f6089a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        this.f6089a.a(i);
    }
}
