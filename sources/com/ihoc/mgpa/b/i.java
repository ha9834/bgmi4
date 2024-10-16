package com.ihoc.mgpa.b;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class i implements h {
    private void a(String str) {
        String e = com.ihoc.mgpa.g.o.b().c.p.e();
        String f = com.ihoc.mgpa.g.o.b().c.p.f();
        if (str.equals(e)) {
            com.ihoc.mgpa.c.i.a().b();
        } else if (str.equals(f)) {
            com.ihoc.mgpa.c.i.a().c();
        }
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(int i, String str) {
        if (i == com.ihoc.mgpa.a.e.SCENE.a()) {
            a(str);
        }
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(int i, float[] fArr) {
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(HashMap<String, String> hashMap) {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (Integer.parseInt(entry.getKey()) == com.ihoc.mgpa.a.e.SCENE.a()) {
                a(entry.getValue());
                return;
            }
        }
    }
}
