package com.ihoc.mgpa.b;

import java.util.HashMap;

/* loaded from: classes2.dex */
public class n implements h {
    @Override // com.ihoc.mgpa.b.h
    public void a(int i, String str) {
        try {
            com.ihoc.mgpa.k.c.a().a(i, str);
        } catch (Throwable unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "TransceiverObserver key data run exception.");
        }
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(int i, float[] fArr) {
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(HashMap<String, String> hashMap) {
        try {
            com.ihoc.mgpa.k.c.a().a(hashMap);
        } catch (Throwable unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "TransceiverObserver map data run exception.");
        }
    }
}
