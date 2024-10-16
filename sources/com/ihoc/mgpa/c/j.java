package com.ihoc.mgpa.c;

import com.ihoc.mgpa.c.k;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class j implements com.ihoc.mgpa.g.m {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f5503a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(k kVar) {
        this.f5503a = kVar;
    }

    @Override // com.ihoc.mgpa.g.m
    public boolean a(com.ihoc.mgpa.i.g gVar, String str) {
        k kVar;
        k.a aVar;
        com.ihoc.mgpa.g.r a2;
        if (gVar != com.ihoc.mgpa.i.g.VMP_SUCCESS || str == null) {
            com.ihoc.mgpa.n.m.a("TGPA_OptCfg", "async download cloud config, parse response content failed.");
            kVar = this.f5503a;
            aVar = k.a.ConfigDownloadFailed;
        } else {
            try {
                a2 = this.f5503a.a(new JSONObject(str));
                if (a2 == null) {
                    return false;
                }
                com.ihoc.mgpa.n.m.a("TGPA_OptCfg", "parse opt config from cloud sync success. ");
                this.f5503a.c = k.a.Success;
                this.f5503a.b = a2;
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                com.ihoc.mgpa.n.m.a("TGPA_OptCfg", "download optimize config parse to json exception, ple check it.");
                kVar = this.f5503a;
                aVar = k.a.ConfigJsonError;
            }
        }
        kVar.c = aVar;
        return false;
    }
}
