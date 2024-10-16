package com.subao.common.k;

import com.subao.common.k.a;

/* loaded from: classes2.dex */
public class b implements a.InterfaceC0174a {

    /* renamed from: a, reason: collision with root package name */
    private final com.subao.common.g.c f6095a;

    public b(com.subao.common.g.c cVar) {
        this.f6095a = cVar;
    }

    @Override // com.subao.common.k.a.InterfaceC0174a
    public void a(boolean z) {
        this.f6095a.a(0, "key_cellular_state_change", z ? 1 : 0);
    }
}
