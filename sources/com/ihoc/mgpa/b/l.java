package com.ihoc.mgpa.b;

import java.util.HashMap;

/* loaded from: classes2.dex */
public class l implements h {
    @Override // com.ihoc.mgpa.b.h
    public void a(int i, String str) {
        try {
            com.ihoc.mgpa.c.o.a().a(i, str);
        } catch (Throwable unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "ThreadAffinityObserver key data run exception.");
        }
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(int i, float[] fArr) {
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(HashMap<String, String> hashMap) {
        try {
            com.ihoc.mgpa.c.o.a().a(hashMap);
        } catch (Throwable unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "ThreadAffinityObserver map data run exception.");
        }
    }
}
