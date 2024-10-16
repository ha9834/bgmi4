package com.tencent.imsdk.android.vk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.imsdk.android.api.common.IMSDKFriendInfo;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.vk.api.sdk.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class IMSDKVKHelper {
    public static final String CHANNEL = "VK";
    public static final int CHANNEL_ID = 14;
    public static final String VK_APP_AUTH_ACTION = "com.vkontakte.android.action.SDK_AUTH";
    public static final String VK_APP_PACKAGE_ID = "com.vkontakte.android";
    public static final int VK_SDK_APP_ID_DEFAULT = 0;

    public static void initVKSdk(Context context) {
        if (b.b(context) <= 0) {
            IMLogger.e("please config com_vk_sdk_AppId in AndroidManifest.xml", new Object[0]);
        } else {
            b.a(context);
        }
    }

    public static boolean isVKInstalled(Context context) {
        if (context == null) {
            return false;
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent(VK_APP_AUTH_ACTION, (Uri) null), 0);
        if (queryIntentActivities == null) {
            return false;
        }
        Iterator<ResolveInfo> it = queryIntentActivities.iterator();
        while (it.hasNext()) {
            if (it.next().resolvePackageName.equals(VK_APP_PACKAGE_ID)) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap createFromPath(Context context, String str) {
        File file = new File(str);
        if (file.exists()) {
            IMLogger.d("get normal file : " + file);
            return BitmapFactory.decodeFile(str);
        }
        if (str.toLowerCase().startsWith(TransferTable.COLUMN_FILE)) {
            IMLogger.d("get file:// format file : " + file);
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return null;
            }
            try {
                return MediaStore.Images.Media.getBitmap(context.getContentResolver(), parse);
            } catch (FileNotFoundException e) {
                IMLogger.e("get image file error : " + e.getMessage(), new Object[0]);
                return null;
            } catch (IOException e2) {
                IMLogger.e("get image file error : " + e2.getMessage(), new Object[0]);
                return null;
            }
        }
        if (str.toLowerCase().startsWith(FirebaseAnalytics.Param.CONTENT)) {
            try {
                return BitmapFactory.decodeStream(context.getContentResolver().openInputStream(Uri.parse(str)));
            } catch (FileNotFoundException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        if (!str.toLowerCase().startsWith("http")) {
            return null;
        }
        IMLogger.d("get http format file : " + file);
        return loadBitmap(str);
    }

    private static Bitmap loadBitmap(String str) {
        try {
            return BitmapFactory.decodeStream(new URL(str).openConnection().getInputStream());
        } catch (FileNotFoundException e) {
            IMLogger.e("get image file from web error : " + e.getMessage(), new Object[0]);
            return null;
        } catch (IOException e2) {
            IMLogger.e("get image file from web error : " + e2.getMessage(), new Object[0]);
            return null;
        } catch (Exception e3) {
            IMLogger.e("get image file from web error : " + e3.getMessage(), new Object[0]);
            return null;
        }
    }

    public static int getIntResByName(Context context, String str) {
        try {
            return context.getResources().getInteger(context.getResources().getIdentifier(str, "integer", context.getPackageName()));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static List<IMSDKFriendInfo> parseFriendFieldFromJson(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(AnalyticsEventKey.RESPONSE);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                IMSDKFriendInfo iMSDKFriendInfo = new IMSDKFriendInfo();
                iMSDKFriendInfo.channelUserId = jSONObject2.getString("id");
                iMSDKFriendInfo.userName = jSONObject2.getString("first_name");
                if (jSONObject2.has("sex")) {
                    iMSDKFriendInfo.gender = 0;
                    if (jSONObject2.getInt("sex") == 1) {
                        iMSDKFriendInfo.gender = 2;
                    } else if (jSONObject2.getInt("sex") == 2) {
                        iMSDKFriendInfo.gender = 1;
                    }
                }
                if (jSONObject2.has("photo_100")) {
                    iMSDKFriendInfo.pictureUrl = jSONObject2.getString("photo_100");
                }
                if (jSONObject2.has("mobile_phone") && !T.ckIsEmpty(jSONObject2.getString("mobile_phone"))) {
                    iMSDKFriendInfo.phone = jSONObject2.getString("mobile_phone");
                } else if (jSONObject2.has("home_phone") && !T.ckIsEmpty(jSONObject2.getString("home_phone"))) {
                    iMSDKFriendInfo.phone = jSONObject2.getString("home_phone");
                }
                arrayList.add(iMSDKFriendInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static int getJsonInt(JSONObject jSONObject, String str, int i) {
        if (jSONObject == null || T.ckIsEmpty(str)) {
            return i;
        }
        try {
            return jSONObject.getInt(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static String getJsonString(JSONObject jSONObject, String str, String str2) {
        if (jSONObject == null || T.ckIsEmpty(str)) {
            return str2;
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return str2;
        }
    }

    public static double getJsonDouble(JSONObject jSONObject, String str, double d) {
        if (jSONObject == null || T.ckIsEmpty(str)) {
            return d;
        }
        try {
            return jSONObject.getDouble(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return d;
        }
    }

    public static boolean getJsonBoolean(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || T.ckIsEmpty(str)) {
            return z;
        }
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException e) {
            e.printStackTrace();
            return z;
        }
    }
}
