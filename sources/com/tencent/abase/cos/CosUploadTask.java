package com.tencent.abase.cos;

import com.tencent.abase.TX;
import com.tencent.abase.log.XLog;
import com.tencent.abase.utils.FileUtils;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class CosUploadTask implements Runnable {
    private static final String TAG = "GCloud.CosUploadTask";
    private static final String URL = "https://cloudctrl.gcloud.qq.com";
    private CosResultListener mResultListener = null;
    private String mUploadid = null;
    private String mFilePath = null;
    private long mPartSize = 0;
    private String mComParams = null;
    private long mNextPos = 0;
    private String mNextUrl = "";

    public void setCredentialInfo(String str) {
        this.mComParams = str;
    }

    public void setResultListener(CosResultListener cosResultListener) {
        this.mResultListener = cosResultListener;
    }

    public void upload(String str, String str2, long j) {
        this.mUploadid = str;
        this.mFilePath = str2;
        this.mPartSize = j;
        new Thread(this).start();
    }

    private void uploadInner(String str, String str2) {
        int i;
        Credential credential = new Credential();
        int prepareFile = prepareFile(str2, this.mComParams, str, credential);
        int i2 = 1;
        if (prepareFile == 0) {
            long j = credential.nextPos;
            String str3 = credential.uploadUrl;
            this.mNextPos = j;
            this.mNextUrl = str3;
            long length = new File(this.mFilePath).length();
            while (true) {
                i = 3;
                boolean z = false;
                if (this.mNextPos >= length) {
                    i = 0;
                    break;
                }
                int i3 = 3;
                while (true) {
                    int i4 = i3 - 1;
                    if (i3 <= 0 || (z = uploadPart(this.mNextUrl, this.mNextPos))) {
                        break;
                    } else {
                        i3 = i4;
                    }
                }
                if (!z) {
                    break;
                }
            }
            if (this.mNextPos >= length) {
                XLog.i(TAG, "upload file success!");
            }
            i2 = i;
        } else if (prepareFile != 1) {
            i2 = 2;
        }
        CosResultListener cosResultListener = this.mResultListener;
        if (cosResultListener != null) {
            cosResultListener.onFinished(i2);
        }
    }

    private int prepareFile(String str, String str2, String str3, Credential credential) {
        HttpURLConnection httpURLConnection;
        String fileToSHA1 = FileUtils.fileToSHA1(str);
        long length = new File(str).length();
        InputStream inputStream = null;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("upload_id", str3);
            jSONObject.put("total_size", length);
            jSONObject.put("total_sha1", fileToSHA1);
            String str4 = "com_params=" + URLEncoder.encode(str2, "UTF-8") + "&biz_params=" + URLEncoder.encode(jSONObject.toString(), "UTF-8");
            String str5 = TX.Instance.getSolidConfigString("GCloud.GCloudCore", "RemoteConfigUrl", URL) + "/upload/prepareFile?" + str4;
            XLog.i("GCloud", "preparefile url is " + URLDecoder.decode(str5, "UTF-8"));
            httpURLConnection = (HttpURLConnection) new URL(str5).openConnection();
        } catch (Exception e) {
            e.printStackTrace();
            XLog.e(TAG, "prepareFile excepiton " + e.getMessage());
            httpURLConnection = null;
        }
        int i = -1;
        if (httpURLConnection == null) {
            return -1;
        }
        try {
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setRequestMethod("PUT");
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                inputStream = httpURLConnection.getInputStream();
                String readStreamToString = FileUtils.readStreamToString(inputStream);
                XLog.i(TAG, readStreamToString);
                JSONObject jSONObject2 = new JSONObject(readStreamToString);
                int i2 = jSONObject2.getInt("ret");
                String optString = jSONObject2.optString("err");
                if (i2 == 0) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("biz_data");
                    String string = jSONObject3.getString("upload_url");
                    Long valueOf = Long.valueOf(jSONObject3.getLong("next_pos"));
                    credential.uploadUrl = string;
                    credential.nextPos = valueOf.longValue();
                    i = 0;
                } else if (i2 > 0) {
                    XLog.e(TAG, "prepareFile failed ret:" + i2 + ",err:" + optString);
                    i = 1;
                } else {
                    XLog.e(TAG, "prepareFile failed ret:" + i2 + ",err:" + optString);
                }
            } else {
                XLog.e(TAG, "http error code " + responseCode);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            XLog.e(TAG, "prepareFile excepiton " + e2.getMessage());
        }
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        if (inputStream != null) {
            inputStream.close();
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0273 A[Catch: Exception -> 0x026f, TryCatch #1 {Exception -> 0x026f, blocks: (B:46:0x026b, B:37:0x0273, B:39:0x0278), top: B:45:0x026b }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0278 A[Catch: Exception -> 0x026f, TRY_LEAVE, TryCatch #1 {Exception -> 0x026f, blocks: (B:46:0x026b, B:37:0x0273, B:39:0x0278), top: B:45:0x026b }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x026b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean uploadPart(java.lang.String r19, long r20) {
        /*
            Method dump skipped, instructions count: 647
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.abase.cos.CosUploadTask.uploadPart(java.lang.String, long):boolean");
    }

    @Override // java.lang.Runnable
    public void run() {
        uploadInner(this.mUploadid, this.mFilePath);
    }
}
