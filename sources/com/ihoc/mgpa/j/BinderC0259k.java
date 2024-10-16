package com.ihoc.mgpa.j;

import com.ihoc.mgpa.f.RunnableC0236b;
import com.oppo.oiface.IOIfaceNotifier;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ihoc.mgpa.j.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class BinderC0259k extends IOIfaceNotifier.Stub {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0260l f5642a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BinderC0259k(C0260l c0260l) {
        this.f5642a = c0260l;
    }

    @Override // com.oppo.oiface.IOIfaceNotifier
    public void onSystemNotify(String str) {
        int i;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("oppo:callback: json: ");
            sb.append(String.valueOf(str));
            com.ihoc.mgpa.n.m.a("TGPA", sb.toString());
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("IsSupport")) {
                com.ihoc.mgpa.n.m.a("TGPA", "oppo:callback: check strategy.");
                com.ihoc.mgpa.f.G.a(jSONObject);
                return;
            }
            if (jSONObject.has("4")) {
                int parseInt = Integer.parseInt(jSONObject.getString("4"));
                i = this.f5642a.e;
                if (i == parseInt) {
                    com.ihoc.mgpa.n.m.a("TGPA", "oppo:callback: same to last level.");
                    return;
                }
                com.ihoc.mgpa.i.f.z(String.valueOf(parseInt));
                if (com.ihoc.mgpa.i.f.Y()) {
                    this.f5642a.e = parseInt;
                    HashMap hashMap = new HashMap();
                    hashMap.put(com.ihoc.mgpa.a.f.VENDOR_LEVEL.a(), String.valueOf(parseInt));
                    hashMap.put(com.ihoc.mgpa.a.h.FREQUENCY_SIGNAL.a(), "2");
                    hashMap.put(com.ihoc.mgpa.a.h.FREQUENCY_LEVEL.a(), String.valueOf(parseInt));
                    com.ihoc.mgpa.i.m.o(hashMap);
                }
                if (com.ihoc.mgpa.i.f.J()) {
                    this.f5642a.e = parseInt;
                    if (parseInt > 0) {
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
                        sb4.append(parseInt);
                        sb4.append("\"");
                        String sb5 = sb4.toString();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(sb5);
                        sb6.append("}");
                        com.ihoc.mgpa.f.H.b().a(new RunnableC0236b(com.ihoc.mgpa.a.a.VENDOR, sb6.toString()));
                    }
                }
            }
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "oppo:callback: exception.");
        }
    }
}
