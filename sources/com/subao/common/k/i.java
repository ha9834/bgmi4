package com.subao.common.k;

/* loaded from: classes2.dex */
public class i implements h {

    /* renamed from: a, reason: collision with root package name */
    private final com.subao.common.g.c f6105a;
    private final int b;

    public i(com.subao.common.g.c cVar, int i) {
        this.f6105a = cVar;
        this.b = i;
    }

    @Override // com.subao.common.k.h
    public void a(int i, int i2, g gVar) {
        this.f6105a.a(this.b, i2, i, gVar, com.subao.common.b.a(i));
    }
}
