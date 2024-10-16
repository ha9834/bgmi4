package com.ihoc.mgpa.g;

import com.ihoc.mgpa.g.g;
import com.ihoc.mgpa.n.d;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public static long f5583a;
    public t b;
    private com.ihoc.mgpa.i.g d = com.ihoc.mgpa.i.g.VMP_SUCCESS;
    private String c = com.ihoc.mgpa.n.a.e() + File.separator + ".tgpapdcloud";

    /* JADX INFO: Access modifiers changed from: private */
    public com.ihoc.mgpa.i.g a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("ret")) {
                com.ihoc.mgpa.n.m.b("TGPA_PDChecker", "pd cloud file has no ret, ple check it!");
                return com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CONFIG_HAS_NO_RET;
            }
            int i = jSONObject.getInt("ret");
            if (i != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("pd cloud file has ret, but ret is not 0, ple check ret: ");
                sb.append(i);
                com.ihoc.mgpa.n.m.b("TGPA_PDChecker", sb.toString());
                return com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CONFIG_RET_IS_NOT_0;
            }
            t tVar = new t();
            if (!tVar.a(jSONObject)) {
                return com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CONFIG_CONTENT_JSON_ERROR;
            }
            this.b = tVar;
            return com.ihoc.mgpa.i.g.VMP_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.b("TGPA_PDChecker", "pd cloud file content parse exception, not json.");
            return com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CONFIG_CONTENT_ERROR;
        }
    }

    private boolean c() {
        if ((System.currentTimeMillis() / 1000) - f5583a > 43200) {
            return true;
        }
        if (!com.ihoc.mgpa.n.i.a(this.c)) {
            com.ihoc.mgpa.n.m.a("TGPA_PDChecker", "local cloud file doesn't exsit, sync download it now.");
            return true;
        }
        long e = com.ihoc.mgpa.n.i.e(this.c);
        if ((System.currentTimeMillis() / 1000) - (e / 1000) < 604800) {
            com.ihoc.mgpa.n.m.a("TGPA_PDChecker", "local cloud file is new, last update time: " + com.ihoc.mgpa.n.d.a(e, d.a.PATTERN2.getFormat()));
            return false;
        }
        com.ihoc.mgpa.n.m.a("TGPA_PDChecker", "local cloud file is too old, last update time: " + com.ihoc.mgpa.n.d.a(e, d.a.PATTERN2.getFormat()));
        return true;
    }

    private com.ihoc.mgpa.i.g d() {
        com.ihoc.mgpa.i.g gVar;
        try {
            new g(g.a.PDControl).a(2000, 2000, new u(this));
        } catch (IOException e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.b("predownload cloud config request run io exception, ple check your network!", new Object[0]);
            gVar = com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CONFIG_EXCEPTION;
            this.d = gVar;
            return this.d;
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.b("predownload cloud config code run exception, ple check code!", new Object[0]);
            gVar = com.ihoc.mgpa.i.g.DOWNLOAD_NEW_CODE_EXCEPTION;
            this.d = gVar;
            return this.d;
        }
        return this.d;
    }

    private com.ihoc.mgpa.i.g e() {
        try {
            com.ihoc.mgpa.n.m.a("TGPA_PDChecker", "start to load local config . ");
            String i = com.ihoc.mgpa.n.i.i(this.c);
            if (!com.ihoc.mgpa.n.p.b(i)) {
                return a(i);
            }
            com.ihoc.mgpa.n.m.a("TGPA_PDChecker", "local config content is empty or null.");
            return com.ihoc.mgpa.i.g.GET_LOCAL_CONFIG_EMPTY;
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.a("TGPA_PDChecker", "read local cloud config exception.");
            return com.ihoc.mgpa.i.g.READ_LOCAL_CONFIG_EXCEPTION;
        }
    }

    public com.ihoc.mgpa.i.g a() {
        return c() ? d() : e();
    }

    public t b() {
        return this.b;
    }
}
