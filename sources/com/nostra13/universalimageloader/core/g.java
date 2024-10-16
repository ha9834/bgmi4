package com.nostra13.universalimageloader.core;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    final String f5755a;
    final String b;
    final com.nostra13.universalimageloader.core.c.a c;
    final com.nostra13.universalimageloader.core.assist.c d;
    final c e;
    final com.nostra13.universalimageloader.core.d.a f;
    final com.nostra13.universalimageloader.core.d.b g;
    final ReentrantLock h;

    public g(String str, com.nostra13.universalimageloader.core.c.a aVar, com.nostra13.universalimageloader.core.assist.c cVar, String str2, c cVar2, com.nostra13.universalimageloader.core.d.a aVar2, com.nostra13.universalimageloader.core.d.b bVar, ReentrantLock reentrantLock) {
        this.f5755a = str;
        this.c = aVar;
        this.d = cVar;
        this.e = cVar2;
        this.f = aVar2;
        this.g = bVar;
        this.h = reentrantLock;
        this.b = str2;
    }
}
