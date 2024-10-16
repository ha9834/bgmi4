package com.ihoc.mgpa.j;

import com.ihoc.mgpa.f.RunnableC0236b;
import com.xiaomi.boostersdk.GameBoosterEngineCallback;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class T implements GameBoosterEngineCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ V f5635a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public T(V v) {
        this.f5635a = v;
    }

    @Override // com.xiaomi.boostersdk.GameBoosterEngineCallback
    public void onThermalControlChanged(int i) {
        int a2;
        int i2;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("xiaomi:callback: level: ");
            sb.append(String.valueOf(i));
            com.ihoc.mgpa.n.m.a("TGPA", sb.toString());
            a2 = this.f5635a.a(i);
            i2 = this.f5635a.d;
            if (i2 == a2) {
                com.ihoc.mgpa.n.m.a("TGPA", "xiaomi:callback: the same to last. ");
                return;
            }
            com.ihoc.mgpa.i.f.z(String.valueOf(a2));
            if (com.ihoc.mgpa.i.f.Y()) {
                HashMap hashMap = new HashMap();
                hashMap.put(com.ihoc.mgpa.a.f.VENDOR_LEVEL.a(), String.valueOf(i));
                hashMap.put(com.ihoc.mgpa.a.h.FREQUENCY_SIGNAL.a(), "2");
                hashMap.put(com.ihoc.mgpa.a.h.FREQUENCY_LEVEL.a(), String.valueOf(a2));
                com.ihoc.mgpa.i.m.o(hashMap);
            }
            if (com.ihoc.mgpa.i.f.J()) {
                this.f5635a.d = a2;
                if (a2 > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("{");
                    sb2.append("\"");
                    sb2.append(com.ihoc.mgpa.a.h.FREQUENCY_SIGNAL.a());
                    sb2.append("\":\"2\",");
                    String sb3 = sb2.toString();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(sb3);
                    sb4.append("\"");
                    sb4.append(com.ihoc.mgpa.a.h.FREQUENCY_LEVEL.a());
                    sb4.append("\":\"");
                    sb4.append(a2);
                    sb4.append("\"}");
                    com.ihoc.mgpa.f.H.b().a(new RunnableC0236b(com.ihoc.mgpa.a.a.VENDOR, sb4.toString()));
                }
            }
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "xiaomi:callback: exception.");
        }
    }
}
