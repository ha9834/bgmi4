package com.tencent.imsdk.android.extend.discord;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.discord.connect.b;
import com.discord.connect.c;
import com.discord.connect.managers.ActivitiesManager;
import com.discord.connect.managers.a;
import com.discord.connect.schema.Activity;
import com.tencent.connect.common.Constants;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.discord.DiscordConstants;
import com.tencent.imsdk.android.login.discord.AccountManager;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Arrays;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DiscordExtend {
    private static final String DISCORD_APP = "com.discord";
    private static Context mCurCtx;
    private static InnerStat.Builder mSTBuilder;

    public static boolean initialize(Context context) {
        IMLogger.d("in DiscordExtend initialize");
        if (context == null) {
            IMLogger.e("DiscordExtend init context is null", new Object[0]);
            return false;
        }
        mCurCtx = context;
        c.a();
        mSTBuilder = new InnerStat.Builder(context, "2.0.1", "1.0.3");
        return true;
    }

    public static void connect(final IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        new Thread(new Runnable() { // from class: com.tencent.imsdk.android.extend.discord.DiscordExtend.1
            @Override // java.lang.Runnable
            public void run() {
                AccountManager.discordConnect = c.a(new b(DiscordExtend.mCurCtx, DiscordConstants.DISCORD_DB_NAME), new c.a() { // from class: com.tencent.imsdk.android.extend.discord.DiscordExtend.1.1
                    @Override // com.discord.connect.c.a
                    public void onConnected() {
                        super.onConnected();
                        IMLogger.d("DiscordConnect onConnected");
                        IMSDKResultListener.this.onResult(new IMSDKResult(1));
                    }

                    @Override // com.discord.connect.c.a
                    public void onConnectFailed(String str) {
                        super.onConnectFailed(str);
                        IMSDKResultListener.this.onResult(new IMSDKResult(9999, -1, str));
                    }
                });
            }
        }).start();
    }

    public static void getActivity(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        if (iMSDKResultListener == null) {
            IMLogger.e("Discord getActivity with null listener", new Object[0]);
            return;
        }
        if (AccountManager.discordConnect != null) {
            mSTBuilder.setMethod("getActivity: discordExtend").create().reportEvent();
            Activity b = AccountManager.discordConnect.b().b();
            if (b != null) {
                IMSDKResult iMSDKResult = new IMSDKResult(1);
                iMSDKResult.retExtraJson = convertActivity(b);
                iMSDKResultListener.onResult(iMSDKResult);
                return;
            }
            iMSDKResultListener.onResult(new IMSDKResult(9999, -1, "get null activity"));
            return;
        }
        iMSDKResultListener.onResult(new IMSDKResult(10, "make sure you have login discord successfully"));
    }

    public static void updateActivity(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        Activity createActivity = createActivity(str, iMSDKResultListener);
        if (AccountManager.discordConnect != null) {
            if (createActivity != null) {
                AccountManager.discordConnect.b().a(createActivity);
                mSTBuilder.setMethod("updateActivity: discordExtend").create().reportEvent();
            }
            iMSDKResultListener.onResult(new IMSDKResult(1));
            return;
        }
        iMSDKResultListener.onResult(new IMSDKResult(10, "make sure you have login discord successfully"));
    }

    public static void shareActivity(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        if (AccountManager.discordConnect != null) {
            if (!isPackageInstalled(DISCORD_APP, mCurCtx.getPackageManager())) {
                iMSDKResultListener.onResult(new IMSDKResult(15, -1, "share Activity need app installed"));
                return;
            }
            boolean a2 = a.a(AccountManager.discordConnect.b(), mCurCtx, ActivitiesManager.ActionType.valueOf(str));
            mSTBuilder.setMethod("shareActivity: discordExtend").create().reportEvent();
            if (!a2) {
                IMLogger.d("No packages found to handle share request");
                iMSDKResultListener.onResult(new IMSDKResult(9999, -1, "No packages found to handle share request"));
                return;
            } else {
                iMSDKResultListener.onResult(new IMSDKResult(1));
                return;
            }
        }
        iMSDKResultListener.onResult(new IMSDKResult(10, "make sure you have login discord successfully"));
    }

    public static void clearActivity(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        if (AccountManager.discordConnect != null) {
            AccountManager.discordConnect.b().a();
            mSTBuilder.setMethod("clearActivity: discordExtend").create().reportEvent();
            iMSDKResultListener.onResult(new IMSDKResult(1));
            return;
        }
        IMLogger.e("discordConnect is null, make sure you have login discord successfully", new Object[0]);
    }

    private static boolean isPackageInstalled(String str, PackageManager packageManager) {
        try {
        } catch (PackageManager.NameNotFoundException unused) {
            IMLogger.d("app " + str + " is not installed");
        } catch (Exception e) {
            IMLogger.d("get app " + str + " info failed : " + e.getMessage());
        }
        return packageManager.getApplicationInfo(str, 0).enabled;
    }

    private static String getApplicationName(Context context) {
        if (mCurCtx == null) {
            return "";
        }
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int i = applicationInfo.labelRes;
        return i == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(i);
    }

    private static String convertActivity(Activity activity) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("applicationId", activity.b);
            jSONObject.put("name", activity.c);
            jSONObject.put("type", activity.f1081a);
            jSONObject.put(Constants.PARAM_PLATFORM, activity.d.name());
            jSONObject.put("sessionId", activity.f);
            jSONObject.put("curPartyStatus", activity.g);
            jSONObject.put("details", activity.h);
            jSONObject.put("startTime", activity.i.f1088a);
            jSONObject.put("endTime", activity.i.b);
            jSONObject.put("largeImage", activity.j.f1084a);
            jSONObject.put("largeText", activity.j.b);
            jSONObject.put("smallImage", activity.j.c);
            jSONObject.put("smallText", activity.j.d);
            jSONObject.put("partyId", activity.k.f1085a);
            jSONObject.put("partyCurSize", activity.k.b.f1086a);
            jSONObject.put("partyMaxSize", activity.k.b.b);
            jSONObject.put("joinSecret", activity.l.f1087a);
            jSONObject.put("spectateSecret", activity.l.b);
            return jSONObject.toString();
        } catch (Exception e) {
            IMLogger.e("convert activity error : " + e.getMessage(), new Object[0]);
            return "{}";
        }
    }

    private static Activity createActivity(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.has("activityType") ? jSONObject.getInt("activityType") : 0;
            Activity.Type type = (i < 0 || i >= Activity.Type.values().length) ? Activity.Type.Playing : Activity.Type.values()[i];
            String string = jSONObject.has("name") ? jSONObject.getString("name") : getApplicationName(mCurCtx);
            Activity.a aVar = new Activity.a(jSONObject.has("largeImage") ? jSONObject.getString("largeImage") : "img_large", jSONObject.has("largeText") ? jSONObject.getString("largeText") : "", jSONObject.has("smallImage") ? jSONObject.getString("smallImage") : "img_small", jSONObject.has("smallText") ? jSONObject.getString("smallText") : "");
            Activity.b bVar = new Activity.b(jSONObject.has("partyId") ? jSONObject.getString("partyId") : UUID.randomUUID().toString(), new Activity.b.a(jSONObject.has("partyCurSize") ? jSONObject.getInt("partyCurSize") : 0, jSONObject.has("partyMaxSize") ? jSONObject.getInt("partyMaxSize") : 0));
            Long valueOf = Long.valueOf(jSONObject.has("startTime") ? jSONObject.getLong("startTime") : System.currentTimeMillis() / 1000);
            return new Activity(type, Long.parseLong(DiscordConstants.getDiscordApId()), string, Activity.Platform.ANDROID, Arrays.asList(Activity.Platform.ANDROID, Activity.Platform.IOS), null, jSONObject.has("curPartyStatus") ? jSONObject.getString("curPartyStatus") : "", jSONObject.has("details") ? jSONObject.getString("details") : "", new Activity.d(valueOf, Long.valueOf(jSONObject.has("endTime") ? jSONObject.getLong("endTime") : valueOf.longValue() + 3600)), aVar, bVar, new Activity.c(jSONObject.has("matchSecret") ? jSONObject.getString("matchSecret") : "secret![match]", jSONObject.has("joinSecret") ? jSONObject.getString("joinSecret") : "secret![join]"), 0);
        } catch (JSONException e) {
            IMLogger.e("jsonException caught : " + e.getMessage(), new Object[0]);
            iMSDKResultListener.onResult(new IMSDKResult(0, "jsonException caught : " + e.getMessage()));
            return null;
        }
    }
}
