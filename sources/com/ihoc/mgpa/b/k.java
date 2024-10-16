package com.ihoc.mgpa.b;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class k implements h {

    /* renamed from: a, reason: collision with root package name */
    private com.ihoc.mgpa.i.d f5490a;

    public k() {
        int i = com.ihoc.mgpa.g.o.b().c.s;
        this.f5490a = i == 1 ? new com.ihoc.mgpa.i.j() : new com.ihoc.mgpa.i.c();
        com.ihoc.mgpa.n.m.a("ReportObserver: available report data dealer: %d.", Integer.valueOf(i));
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(int i, String str) {
        try {
            this.f5490a.a(i, str);
        } catch (Throwable th) {
            com.ihoc.mgpa.n.m.a("ReportObserver: key data deal exception, ple check it!", th);
        }
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(int i, float[] fArr) {
        if (!com.ihoc.mgpa.i.f.Y()) {
            com.ihoc.mgpa.n.m.a("ReportObserver: do not need report data!", new Object[0]);
            return;
        }
        try {
            this.f5490a.a(i, fArr);
        } catch (Throwable th) {
            com.ihoc.mgpa.n.m.a("ReportObserver: fps data deal exception, ple check it!", th);
        }
    }

    @Override // com.ihoc.mgpa.b.h
    public void a(HashMap<String, String> hashMap) {
        try {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                a(Integer.parseInt(entry.getKey()), entry.getValue());
            }
        } catch (Throwable th) {
            com.ihoc.mgpa.n.m.a("ReportObserver: map data deal exception, ple check it!", th);
        }
    }
}
