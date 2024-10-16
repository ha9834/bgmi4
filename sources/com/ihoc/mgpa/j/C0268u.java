package com.ihoc.mgpa.j;

import com.ihoc.mgpa.MgpaCallback;
import com.samsung.android.game.gamelib.GameServiceHelper;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ihoc.mgpa.j.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0268u implements GameServiceHelper.Listener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f5651a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0268u(w wVar) {
        this.f5651a = wVar;
    }

    @Override // com.samsung.android.game.gamelib.GameServiceHelper.Listener
    public void resultCallBack(int i, int i2) {
        com.ihoc.mgpa.n.m.a("TGPA", "resultCallBack: ");
    }

    @Override // com.samsung.android.game.gamelib.GameServiceHelper.Listener
    public void systemCallBack(int i) {
        int i2;
        int a2;
        int i3;
        MgpaCallback mgpaCallback;
        MgpaCallback mgpaCallback2;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("samsung2:callback: last level: ");
            i2 = this.f5651a.g;
            sb.append(i2);
            sb.append(" , current level: ");
            sb.append(String.valueOf(i));
            com.ihoc.mgpa.n.m.a("TGPA", sb.toString());
            a2 = this.f5651a.a(i);
            i3 = this.f5651a.g;
            if (a2 == i3) {
                com.ihoc.mgpa.n.m.a("TGPA", "samsung2:callback: the same to last.");
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
                mgpaCallback = this.f5651a.i;
                if (mgpaCallback != null) {
                    this.f5651a.g = a2;
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
                        String sb5 = sb4.toString();
                        mgpaCallback2 = this.f5651a.i;
                        mgpaCallback2.notifySystemInfo(sb5);
                    }
                }
            }
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "samsung:callback: exception. ");
        }
    }
}
