package com.tencent.abase.hotfix;

import android.content.Context;
import android.util.Log;
import com.tencent.abase.utils.FileUtils;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SecurityCheck {
    private static final String GCLOUD_CRT_PATH = "gcloud.crt";
    private static final String PATCH_INFO_FILE = "patch_info.json";
    private static final String SO_INFO_FILE = "so_info.json";
    private static final String TAG = "ABase.SecurityCheck";
    private static String mCertificateMd5;
    private final Context mContext;
    private final HashMap<String, String> metaContentMap = new HashMap<>();

    public SecurityCheck(Context context) {
        this.mContext = context;
        if (mCertificateMd5 == null) {
            init(this.mContext);
        }
    }

    public PatchInfo getPatchInfo() {
        String str = this.metaContentMap.get(PATCH_INFO_FILE);
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            PatchInfo patchInfo = new PatchInfo();
            patchInfo.sdkName = jSONObject.getString("sdk_name");
            patchInfo.sdkVersion = jSONObject.getString(Constants.JumpUrlConstants.URL_KEY_SDK_VERSION);
            patchInfo.patchVersion = jSONObject.getInt("patch_version");
            return patchInfo;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SoInfo> getSoInfos() {
        String str = this.metaContentMap.get(SO_INFO_FILE);
        ArrayList arrayList = new ArrayList();
        if (str == null) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                SoInfo soInfo = new SoInfo();
                soInfo.name = jSONObject.getString("name");
                soInfo.arch = jSONObject.getString("arch");
                soInfo.md5 = jSONObject.getString("md5");
                arrayList.add(soInfo);
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean verifyPatchMetaSignature(java.io.File r10) {
        /*
            r9 = this;
            java.lang.String r0 = com.tencent.abase.hotfix.SecurityCheck.mCertificateMd5
            r1 = 0
            if (r0 != 0) goto Ld
            java.lang.String r10 = "ABase.SecurityCheck"
            java.lang.String r0 = "mCertificateMd5 is null! check if gcloud.crt exist!"
            android.util.Log.e(r10, r0)
            return r1
        Ld:
            r0 = 0
            r2 = 1
            java.util.jar.JarFile r3 = new java.util.jar.JarFile     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L76
            r3.<init>(r10)     // Catch: java.lang.Throwable -> L72 java.lang.Exception -> L76
            java.util.Enumeration r0 = r3.entries()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> La1
        L18:
            boolean r4 = r0.hasMoreElements()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> La1
            if (r4 == 0) goto L61
            java.lang.Object r4 = r0.nextElement()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> La1
            java.util.jar.JarEntry r4 = (java.util.jar.JarEntry) r4     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> La1
            if (r4 != 0) goto L27
            goto L18
        L27:
            java.lang.String r5 = r4.getName()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> La1
            java.lang.String r6 = "META-INF/"
            boolean r6 = r5.startsWith(r6)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> La1
            if (r6 == 0) goto L34
            goto L18
        L34:
            java.lang.String r6 = "_info.json"
            boolean r6 = r5.endsWith(r6)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> La1
            if (r6 != 0) goto L3d
            goto L18
        L3d:
            java.util.HashMap<java.lang.String, java.lang.String> r6 = r9.metaContentMap     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> La1
            java.lang.String r7 = com.tencent.abase.utils.FileUtils.loadDigestes(r3, r4)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> La1
            r6.put(r5, r7)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> La1
            java.security.cert.Certificate[] r4 = r4.getCertificates()     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> La1
            if (r4 == 0) goto L52
            boolean r4 = r9.check(r10, r4)     // Catch: java.lang.Exception -> L70 java.lang.Throwable -> La1
            if (r4 != 0) goto L18
        L52:
            r3.close()     // Catch: java.io.IOException -> L56
            goto L60
        L56:
            r0 = move-exception
            java.lang.String r2 = "ABase.SecurityCheck"
            java.lang.String r10 = r10.getAbsolutePath()
            android.util.Log.e(r2, r10, r0)
        L60:
            return r1
        L61:
            r3.close()     // Catch: java.io.IOException -> L65
            goto La0
        L65:
            r0 = move-exception
            java.lang.String r1 = "ABase.SecurityCheck"
            java.lang.String r10 = r10.getAbsolutePath()
            android.util.Log.e(r1, r10, r0)
            goto La0
        L70:
            r0 = move-exception
            goto L7a
        L72:
            r1 = move-exception
            r3 = r0
            r0 = r1
            goto La2
        L76:
            r3 = move-exception
            r8 = r3
            r3 = r0
            r0 = r8
        L7a:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> La1
            java.lang.String r0 = "ABase.SecurityCheck"
            java.lang.String r4 = "SecurityCheck file %s, size %d verifyPatchMetaSignature fail"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> La1
            java.lang.String r6 = r10.getAbsolutePath()     // Catch: java.lang.Throwable -> La1
            r5[r1] = r6     // Catch: java.lang.Throwable -> La1
            long r6 = r10.length()     // Catch: java.lang.Throwable -> La1
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Throwable -> La1
            r5[r2] = r1     // Catch: java.lang.Throwable -> La1
            java.lang.String r1 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> La1
            android.util.Log.e(r0, r1)     // Catch: java.lang.Throwable -> La1
            if (r3 == 0) goto La0
            r3.close()     // Catch: java.io.IOException -> L65
        La0:
            return r2
        La1:
            r0 = move-exception
        La2:
            if (r3 == 0) goto Lb2
            r3.close()     // Catch: java.io.IOException -> La8
            goto Lb2
        La8:
            r1 = move-exception
            java.lang.String r10 = r10.getAbsolutePath()
            java.lang.String r2 = "ABase.SecurityCheck"
            android.util.Log.e(r2, r10, r1)
        Lb2:
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.abase.hotfix.SecurityCheck.verifyPatchMetaSignature(java.io.File):boolean");
    }

    private boolean check(File file, Certificate[] certificateArr) {
        if (certificateArr.length <= 0) {
            return false;
        }
        for (int length = certificateArr.length - 1; length >= 0; length--) {
            try {
            } catch (Exception e) {
                Log.e(TAG, file.getAbsolutePath(), e);
            }
            if (mCertificateMd5.equals(FileUtils.getMD5(certificateArr[length].getEncoded()))) {
                return true;
            }
        }
        return false;
    }

    private void init(Context context) {
        InputStream inputStream = null;
        try {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509", "BC");
                inputStream = context.getAssets().open(GCLOUD_CRT_PATH);
                mCertificateMd5 = FileUtils.getMD5(((X509Certificate) certificateFactory.generateCertificate(inputStream)).getEncoded());
                if (mCertificateMd5 == null) {
                    Log.e(TAG, "mCertificateMd5 is null!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.e(TAG, "get gcloud.crt failed! check if gcloud.crt exist!");
            }
        } finally {
            FileUtils.closeQuietly(inputStream);
        }
    }
}
