package com.ihoc.mgpa.c;

import com.ihoc.mgpa.g.g;
import com.tencent.imsdk.android.base.config.ConfigDBHelper;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static volatile k f5504a;
    private com.ihoc.mgpa.g.r b;
    private a c = a.DefaultError;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum a {
        Success(0),
        DefaultError(-1),
        IOException(-2),
        NetworkError(-3),
        ConfitNoRet(-4),
        ConfigRetNoZero(-5),
        ConfigJsonError(-6),
        ContextNull(-7),
        CodeException(-8),
        ConfigDownloadFailed(-9),
        LocalConfigJsonError(-10);

        int m;

        a(int i) {
            this.m = i;
        }

        public String a() {
            return String.valueOf(this.m);
        }
    }

    private k() {
    }

    public static k a() {
        if (f5504a == null) {
            synchronized (k.class) {
                if (f5504a == null) {
                    f5504a = new k();
                }
            }
        }
        return f5504a;
    }

    private com.ihoc.mgpa.g.r a(String str) {
        a aVar;
        try {
            String i = com.ihoc.mgpa.n.i.i(str);
            if (i != null) {
                return a(new JSONObject(i));
            }
            com.ihoc.mgpa.n.m.a("TGPA_OptCfg", "optimize config read failed, check local file!");
            this.c = a.IOException;
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.b("TGPA_OptCfg", "optimize config read exception, check local file!");
            aVar = a.IOException;
            this.c = aVar;
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            com.ihoc.mgpa.n.m.b("TGPA_OptCfg", "optimize config's json data parse failed, check local file!");
            aVar = a.LocalConfigJsonError;
            this.c = aVar;
            return null;
        } catch (Exception e3) {
            e3.printStackTrace();
            com.ihoc.mgpa.n.m.b("TGPA_OptCfg", "optimize config's json data parse exception, check local file!");
            aVar = a.CodeException;
            this.c = aVar;
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ihoc.mgpa.g.r a(JSONObject jSONObject) {
        String str;
        String str2;
        JSONObject optJSONObject = jSONObject.optJSONObject(ConfigDBHelper.TABLE_NAME_CONFIG);
        if (optJSONObject == null) {
            str = "TGPA_OptCfg";
            str2 = "config key don't exsit, ple check it.";
        } else {
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("optimizeConfig");
            if (optJSONObject2 == null) {
                str = "TGPA_OptCfg";
                str2 = "config has no optimizeConfig, ple check it.";
            } else {
                com.ihoc.mgpa.g.r rVar = new com.ihoc.mgpa.g.r();
                if (rVar.a(optJSONObject2)) {
                    com.ihoc.mgpa.n.m.a("TGPA_OptCfg", "optimizeConfig config parse success.");
                    this.c = a.Success;
                    return rVar;
                }
                str = "TGPA_OptCfg";
                str2 = "optimizeConfig key parse failed, ple check it.";
            }
        }
        com.ihoc.mgpa.n.m.b(str, str2);
        this.c = a.ConfigJsonError;
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private a d() {
        StringBuilder sb;
        a aVar;
        StringBuilder sb2;
        try {
            try {
            } catch (IOException e) {
                e.printStackTrace();
                com.ihoc.mgpa.n.m.a("TGPA_OptCfg", "download optimize config io exception, ple check network.");
                this.c = a.NetworkError;
                sb = new StringBuilder();
            } catch (Exception e2) {
                e2.printStackTrace();
                com.ihoc.mgpa.n.m.a("TGPA_OptCfg", "download optimize config exception.");
                this.c = a.CodeException;
                sb = new StringBuilder();
            }
            if (com.ihoc.mgpa.n.a.a() != null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(com.ihoc.mgpa.n.a.e());
                sb3.append(File.separator);
                sb3.append(".tgpacloud");
                String sb4 = sb3.toString();
                if (com.ihoc.mgpa.n.i.a(sb4)) {
                    com.ihoc.mgpa.n.m.a("TGPA_OptCfg", "start to parse opt config from local cloud file.");
                    com.ihoc.mgpa.g.r a2 = a(sb4);
                    if (a2 != null) {
                        com.ihoc.mgpa.n.m.a("TGPA_OptCfg", "parse opt config from local cloud file success. ");
                        this.c = a.Success;
                        this.b = a2;
                        aVar = this.c;
                        sb2 = new StringBuilder();
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("parse opt config from local cloud file result: ");
                        sb5.append(this.c.a());
                        com.ihoc.mgpa.n.m.a("TGPA_OptCfg", sb5.toString());
                    }
                }
                com.ihoc.mgpa.n.m.a("TGPA_OptCfg", "start get optimize config from cloud sync. ");
                new com.ihoc.mgpa.g.g(g.a.OptimizeConfig).a(2000, 2000, new j(this));
                sb = new StringBuilder();
                sb.append("parse config from cloud sync finished, result: ");
                sb.append(this.c.a());
                com.ihoc.mgpa.n.m.a("TGPA_OptCfg", sb.toString());
                return this.c;
            }
            com.ihoc.mgpa.n.m.b("TGPA_OptCfg", "checkOptCfg: context is null, maybe you should init first!");
            this.c = a.ContextNull;
            aVar = this.c;
            sb2 = new StringBuilder();
            sb2.append("parse config from cloud sync finished, result: ");
            sb2.append(this.c.a());
            com.ihoc.mgpa.n.m.a("TGPA_OptCfg", sb2.toString());
            return aVar;
        } catch (Throwable th) {
            com.ihoc.mgpa.n.m.a("TGPA_OptCfg", "parse config from cloud sync finished, result: " + this.c.a());
            throw th;
        }
    }

    public String b() {
        com.ihoc.mgpa.g.r rVar = this.b;
        return rVar != null ? rVar.f5578a : com.ihoc.mgpa.g.o.b().c.i != null ? com.ihoc.mgpa.g.o.b().c.i.f5578a : d() == a.Success ? this.b.f5578a : this.c.a();
    }

    public String c() {
        com.ihoc.mgpa.g.r rVar = this.b;
        return rVar != null ? rVar.b : com.ihoc.mgpa.g.o.b().c.i != null ? com.ihoc.mgpa.g.o.b().c.i.b : d() == a.Success ? this.b.b : this.c.a();
    }
}
