package com.ihoc.mgpa.g;

import com.ihoc.mgpa.g.g;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class i {
    private com.ihoc.mgpa.i.g b = com.ihoc.mgpa.i.g.VMP_SUCCESS;

    /* renamed from: a, reason: collision with root package name */
    private String f5565a = com.ihoc.mgpa.n.a.e() + File.separator + ".tgpacloud";

    public com.ihoc.mgpa.i.g a() {
        com.ihoc.mgpa.i.g gVar;
        try {
            new g(g.a.CloudContrl).b(new h(this));
        } catch (IOException e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.b("TGPA_CloudControlChecker", "download cloud config request run io exception, ple check your network!");
            gVar = com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CONFIG_EXCEPTION;
            this.b = gVar;
            return this.b;
        } catch (Throwable th) {
            th.printStackTrace();
            com.ihoc.mgpa.n.m.b("TGPA_CloudControlChecker", "download cloud config code run exception, ple check!");
            gVar = com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CODE_EXCEPTION;
            this.b = gVar;
            return this.b;
        }
        return this.b;
    }

    public com.ihoc.mgpa.i.g a(String str) {
        try {
            int a2 = o.b().a(new JSONObject(str));
            com.ihoc.mgpa.i.f.ua();
            if (a2 > 0) {
                com.ihoc.mgpa.n.m.d("TGPA_CloudControlChecker", "parse cloud control some value to json exception, maybe you lost some config.");
            }
            if (a2 < 0) {
                com.ihoc.mgpa.n.m.b("TGPA_CloudControlChecker", "parse cloud control json's value exception, check json.");
                return com.ihoc.mgpa.i.g.PARSE_JSON_VALUE_EXCEPTION;
            }
            com.ihoc.mgpa.n.m.c("parse cloud control json finished. result: %d", Integer.valueOf(a2));
            return com.ihoc.mgpa.i.g.VMP_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.b("TGPA_CloudControlChecker", "file content parse exception, not json.");
            return com.ihoc.mgpa.i.g.PARSE_JSON_CONFIG_EXCEPTION;
        }
    }

    public com.ihoc.mgpa.i.g b() {
        try {
            com.ihoc.mgpa.n.m.c("CloudChecker: start to load local config . ", new Object[0]);
            String i = com.ihoc.mgpa.n.i.i(this.f5565a);
            if (!com.ihoc.mgpa.n.p.b(i)) {
                return a(i);
            }
            com.ihoc.mgpa.n.m.a("TGPA_CloudControlChecker", "CloudChecker: local config content is empty or null.");
            return com.ihoc.mgpa.i.g.GET_LOCAL_CONFIG_EMPTY;
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.a("TGPA_CloudControlChecker", "CloudChecker: read local cloud config exception.");
            return com.ihoc.mgpa.i.g.READ_LOCAL_CONFIG_EXCEPTION;
        }
    }
}
