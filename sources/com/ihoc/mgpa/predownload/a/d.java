package com.ihoc.mgpa.predownload.a;

import android.os.Build;
import android.os.Bundle;
import com.facebook.appevents.integrity.IntegrityManager;
import com.ihoc.mgpa.n.m;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class d implements c {
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004f, code lost:
    
        if (r0 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
    
        if (r0 != null) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.os.Bundle b(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "queryAppStore jsonQueryParams: "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TGPA_IFileMover"
            com.ihoc.mgpa.n.m.a(r1, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 24
            if (r0 < r2) goto L5b
            android.content.Context r0 = com.ihoc.mgpa.n.a.a()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            if (r0 == 0) goto L43
            java.lang.String r2 = "content://mk_ex"
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            android.content.ContentProviderClient r0 = r0.acquireUnstableContentProviderClient(r2)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L4a
            if (r0 == 0) goto L44
            java.lang.String r2 = "dispatchResource"
            android.os.Bundle r4 = r0.call(r2, r4, r1)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            if (r0 == 0) goto L3e
            r0.close()
        L3e:
            return r4
        L3f:
            r4 = move-exception
            goto L55
        L41:
            r4 = move-exception
            goto L4c
        L43:
            r0 = r1
        L44:
            if (r0 == 0) goto L5b
            goto L51
        L47:
            r4 = move-exception
            r0 = r1
            goto L55
        L4a:
            r4 = move-exception
            r0 = r1
        L4c:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L3f
            if (r0 == 0) goto L5b
        L51:
            r0.close()
            goto L5b
        L55:
            if (r0 == 0) goto L5a
            r0.close()
        L5a:
            throw r4
        L5b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.predownload.a.d.b(java.lang.String):android.os.Bundle");
    }

    @Override // com.ihoc.mgpa.predownload.a.c
    public String a(String str) {
        m.a("TGPA_IFileMover", "getFilePathFromAppStore  fileMd5：" + str);
        if (Build.VERSION.SDK_INT < 24) {
            return IntegrityManager.INTEGRITY_TYPE_NONE;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", 2);
            jSONObject.put("md5", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Bundle b = b(jSONObject.toString());
        if (b == null) {
            return IntegrityManager.INTEGRITY_TYPE_NONE;
        }
        String string = b.getString("resourcePath");
        m.a("TGPA_IFileMover", "getFilePathFromAppStore filePath: " + string + " fileMd5: " + str);
        return string;
    }

    @Override // com.ihoc.mgpa.predownload.a.c
    public void a(String str, boolean z, String str2) {
        m.a("TGPA_IFileMover", "reportCopyResultToAppStore  ");
        if (Build.VERSION.SDK_INT >= 24) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", 3);
                jSONObject.put("md5", str);
                jSONObject.put("result", z);
                jSONObject.put("message", str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            b(jSONObject.toString());
        }
    }

    @Override // com.ihoc.mgpa.predownload.a.c
    public boolean a() {
        m.a("TGPA_IFileMover", "isAppStoreSupportPreDownload  ");
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Bundle b = b(jSONObject.toString());
        if (b != null) {
            return b.getBoolean("isSupportDispatch");
        }
        return false;
    }

    @Override // com.ihoc.mgpa.predownload.a.c
    public boolean a(List<String> list) {
        return false;
    }
}
