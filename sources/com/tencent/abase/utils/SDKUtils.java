package com.tencent.abase.utils;

import android.content.Context;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SDKUtils {
    private static final String GCLOUD_INFO_FILE = "GCloudInfo.json";

    private static String getGCloudInfo(Context context) {
        try {
            return FileUtils.readStreamToString(context.getAssets().open(GCLOUD_INFO_FILE));
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getSDKVersion(Context context, String str) {
        try {
            return new JSONObject(getGCloudInfo(context)).getJSONObject("PackageVersions").getString(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static List<String> getAllSDKNames(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray names = new JSONObject(getGCloudInfo(context)).getJSONObject("PackageVersions").names();
            for (int i = 0; i < names.length(); i++) {
                arrayList.add(names.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
