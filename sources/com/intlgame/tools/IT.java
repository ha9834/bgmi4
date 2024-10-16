package com.intlgame.tools;

import android.content.Context;
import android.content.res.Resources;
import com.intlgame.INTLApp;
import com.intlgame.api.INTLResult;
import com.intlgame.foundation.EmptyUtils;
import com.intlgame.foundation.INTLLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class IT {
    private static final String INTL_SHARE_PREFERENCE_FILE_NAME = "intl";

    public static native String createSequenceId();

    public static native String getRetMsg(int i);

    public static native void onPluginRetCallback(int i, INTLResult iNTLResult, String str);

    public String getFilePathDir(boolean z) {
        File externalFilesDir;
        Context appContext = INTLApp.getInstance().getAppContext();
        if (z) {
            externalFilesDir = appContext.getFilesDir();
        } else {
            externalFilesDir = appContext.getExternalFilesDir(INTL_SHARE_PREFERENCE_FILE_NAME);
            if (externalFilesDir == null) {
                externalFilesDir = appContext.getFilesDir();
            }
        }
        externalFilesDir.exists();
        externalFilesDir.isDirectory();
        externalFilesDir.mkdirs();
        return externalFilesDir.toString();
    }

    public byte[] readFileFromAssets(String str) {
        byte[] bArr = null;
        try {
            InputStream open = INTLApp.getInstance().getAppContext().getAssets().open(str);
            bArr = new byte[open.available()];
            if (open.read(bArr) == -1) {
                INTLLog.e("read from asset error");
            }
        } catch (IOException e) {
            INTLLog.e(e.getMessage());
        }
        return bArr;
    }

    public static String getJsonString(String str, String str2) {
        if (EmptyUtils.isEmpty(str)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has(str2) ? jSONObject.getString(str2) : "";
        } catch (JSONException e) {
            INTLLog.e(e.getMessage());
            return "";
        }
    }

    public static int getJsonInt(String str, String str2) {
        if (EmptyUtils.isEmpty(str)) {
            return -1;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str2)) {
                return jSONObject.getInt(str2);
            }
        } catch (JSONException e) {
            INTLLog.e(e.getMessage());
        }
        return -1;
    }

    public static int loadIdByResource(Resources resources, String str, String str2, String str3) {
        int identifier = resources.getIdentifier(str, str2, str3);
        if (identifier == 0) {
            new Exception(String.format("Resources %s [type = %s, pkg = %s] is not found", str, str2, str3)).printStackTrace();
        }
        return identifier;
    }
}
