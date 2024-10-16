package com.tencent.imsdk.android.tools;

import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.base.IMSDKDB4Login;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKFuse;
import com.tencent.imsdk.android.base.IMSDKValidKeyCalcUnit;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class InnerStat {
    private static final String APP_SIGNATURE = "sig";
    private static final String APP_VERSION = "appversion";
    private static final String CALL_INTERVAL = "interval";
    public static final int DEPTH_BASE_OF_PLUGIN_CALL_STAT = 5;
    public static final int DEPTH_PLUGIN_CALL_STAT_DIRECTLY = 4;
    private static final String DID = "did";
    private static final String EVENT = "event";
    private static final String EVENT_RESULT = "result";
    private static final String EVENT_STAGE = "stage";
    private static final String EXTRA = "extra";
    private static final String FB_VERSION = "facebook";
    private static final String GAME_ID = "gid";
    private static final String GMS_VERSION = "gms";
    private static final String GPG_VERSION = "playgames";
    private static final String GPS_VERSION = "playstore";
    private static final String IID = "iid";
    private static final String IMSDK_CODE = "code";
    private static final String IMSDK_MSG = "msg";
    private static final int INNER_REPORT_DATA_CACHE_MAX = 1024;
    private static final String MAC_ADDRESS = "mac";
    private static final String M_TIME = "mtime";
    private static final String OPEN_ID = "openId";
    private static final String PLATFORM = "platform";
    private static final String PLUGIN_NAME = "plugin";
    private static final String SDK_VERSION = "sdk";
    private static final String SID = "sid";
    private static final String THIRD_CODE = "tcode";
    private static final String THIRD_MSG = "tmsg";
    private static final String TYPE = "type";
    private static final String TYPE_INIT = "init";
    private static final String TYPE_LOG = "log";
    private static final String TYPE_MONITOR = "monitor";
    private static final String TYPE_ONCE = "once";
    private static final String TYPE_PLUGIN = "plugin";
    private static final String VERSION = "version";
    private Builder mBuilder;
    private int mGameId;
    private static final String mSessionId = UUID.randomUUID().toString();
    private static boolean mAppStartReported = false;
    private static Queue<Properties> mCachedReportData = new ArrayDeque();

    /* loaded from: classes.dex */
    public static class ThirdPN {
        public static final String FACEBOOK = "com.facebook.katana";
        public static final String GOOGLE = "com.google.android.gms";
        public static final String GOOGLE_PLAY_GAMES = "com.google.android.play.games";
        public static final String GOOGLE_PLAY_STORE = "com.android.vending";
    }

    private InnerStat(Builder builder) {
        this();
        this.mBuilder = builder;
    }

    private InnerStat() {
    }

    private void setPropertyIfAbsent(Properties properties, String str, String str2) {
        if (str == null || properties.containsKey(str) || str2 == null || str2.length() <= 0) {
            return;
        }
        properties.setProperty(str, str2);
    }

    private void beginReport(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", TYPE_MONITOR);
        hashMap.put("event", str);
        hashMap.put(EVENT_STAGE, "begin");
        hashMap.put(IMSDK_CODE, String.valueOf(1));
        hashMap.put("msg", String.valueOf(IMSDKErrCode.getMessageByCode(1)));
        reportEvent(this.mBuilder, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void endReport(String str, String str2, IMSDKResult iMSDKResult) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", TYPE_MONITOR);
        hashMap.put("event", str);
        hashMap.put(IMSDK_CODE, String.valueOf(iMSDKResult != null ? iMSDKResult.imsdkRetCode : 0));
        hashMap.put(THIRD_CODE, String.valueOf(iMSDKResult != null ? iMSDKResult.thirdRetCode : 0));
        hashMap.put("msg", iMSDKResult != null ? iMSDKResult.imsdkRetMsg : "");
        hashMap.put(THIRD_MSG, iMSDKResult != null ? iMSDKResult.thirdRetMsg : "");
        hashMap.put(CALL_INTERVAL, str2);
        hashMap.put(EVENT_STAGE, "end");
        reportEvent(this.mBuilder, hashMap);
    }

    private void reportOnce(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", TYPE_ONCE);
        hashMap.put("event", str);
        hashMap.put(EVENT_RESULT, str2);
        reportEvent(this.mBuilder, hashMap);
    }

    public <D extends IMSDKResult> IMSDKResultListener<D> proxyListener4EventReport(String str, IMSDKResultListener<D> iMSDKResultListener) {
        StringBuilder sb = new StringBuilder();
        if (str != null && str.startsWith("http")) {
            sb.append(str);
        } else {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            String className = stackTraceElement.getClassName();
            sb.append(className.substring(className.lastIndexOf(".") + 1).replaceFirst(IR.def.IMSDK_KEYWORD, ""));
            sb.append("-");
            sb.append(str == null ? "imsdk" : str);
            sb.append("-");
            sb.append(stackTraceElement.getMethodName());
        }
        return proxyListener4EventReport(str, iMSDKResultListener, sb.toString().toLowerCase(Locale.US));
    }

    public <D extends IMSDKResult> IMSDKResultListener<D> proxyListener4EventReport(final String str, final IMSDKResultListener<D> iMSDKResultListener, final String str2) {
        if (iMSDKResultListener != null) {
            beginReport(str2);
            final long currentTimeMillis = System.currentTimeMillis();
            return (IMSDKResultListener<D>) new IMSDKResultListener<D>() { // from class: com.tencent.imsdk.android.tools.InnerStat.1
                /* JADX WARN: Incorrect types in method signature: (TD;)V */
                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                public void onResult(IMSDKResult iMSDKResult) {
                    InnerStat.this.endReport(str2, String.valueOf(System.currentTimeMillis() - currentTimeMillis), iMSDKResult);
                    iMSDKResultListener.onResult(iMSDKResult);
                    InnerStat.this.showResultHelpLog(str, iMSDKResult);
                }
            };
        }
        reportOnce(str2, str);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showResultHelpLog(String str, IMSDKResult iMSDKResult) {
        if (str == null) {
            str = "imsdk";
        } else if (str.startsWith("http")) {
            return;
        }
        T.HelperLog.resultCheck(str, iMSDKResult);
    }

    public Properties reportEvent() {
        return reportEvent(this.mBuilder);
    }

    public Properties reportEvent(Builder builder, Map<String, String> map) {
        if (builder.innerProp == null) {
            builder.innerProp = new HashMap();
        }
        builder.innerProp.putAll(map);
        return reportEvent(builder);
    }

    private void thirdPlatformReport(Properties properties) {
        if (properties == null || properties.get("type") == null) {
            IMLogger.w("inner report need properties with type", new Object[0]);
            return;
        }
        if (IMSDKConfig.isConfigEnable()) {
            if (IMSDKConfig.isFinishPullConfig()) {
                if (IMSDKFuse.isAvailable(IR.fuse.IMSDK_INNER_STAT_ENABLE)) {
                    Queue<Properties> queue = mCachedReportData;
                    if (queue != null && queue.size() > 0) {
                        while (true) {
                            Properties poll = mCachedReportData.poll();
                            if (poll == null) {
                                break;
                            } else {
                                InnerStatImpl.report(poll.get("type").toString(), poll);
                            }
                        }
                    }
                    InnerStatImpl.report(properties.get("type").toString(), properties);
                    return;
                }
                mCachedReportData.clear();
                return;
            }
            if (mCachedReportData == null) {
                mCachedReportData = new ArrayDeque();
            }
            if (mCachedReportData.size() < 1024) {
                mCachedReportData.add(properties);
                return;
            }
            return;
        }
        InnerStatImpl.report(properties.get("type").toString(), properties);
    }

    public Properties reportEvent(Builder builder) {
        try {
            Properties properties = new Properties();
            if (builder.innerProp != null && !builder.innerProp.isEmpty()) {
                for (Map.Entry entry : builder.innerProp.entrySet()) {
                    setPropertyIfAbsent(properties, (String) entry.getKey(), (String) entry.getValue());
                }
            }
            if (builder.extraProp != null && !builder.extraProp.isEmpty()) {
                String aESSecretKey = DigestUtils.getAESSecretKey();
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry2 : builder.extraProp.entrySet()) {
                    if (builder.isCrypt) {
                        jSONObject.put((String) entry2.getKey(), DigestUtils.encryptAES((String) entry2.getValue(), aESSecretKey));
                    } else {
                        jSONObject.put((String) entry2.getKey(), entry2.getValue());
                    }
                }
                if (builder.isCrypt) {
                    jSONObject.put("IMSDKEncryptKey", DigestUtils.getAESEncryptKey(DigestUtils.PUBLIC_KEY, aESSecretKey));
                }
                setPropertyIfAbsent(properties, EXTRA, jSONObject.toString());
            }
            if (this.mGameId == 0) {
                this.mGameId = IMSDKConfig.getOrMetaData(IR.meta.GAME_ID, IR.meta.GAME_ID, 11);
            }
            setPropertyIfAbsent(properties, GAME_ID, String.valueOf(this.mGameId));
            setPropertyIfAbsent(properties, "platform", "2");
            setPropertyIfAbsent(properties, "version", builder.version);
            if (!"plugin".equals(properties.get("type"))) {
                setPropertyIfAbsent(properties, OPEN_ID, T.ckIsEmpty(builder.openId) ? IMSDKDB4Login.getOpenId(builder.ctx) : builder.openId);
                setPropertyIfAbsent(properties, "did", T.Device.getDeviceUuid(builder.ctx));
                setPropertyIfAbsent(properties, IID, T.Device.getInstallId(builder.ctx));
                setPropertyIfAbsent(properties, "sid", mSessionId);
                setPropertyIfAbsent(properties, "event", builder.method);
                setPropertyIfAbsent(properties, EVENT_STAGE, builder.stage);
                setPropertyIfAbsent(properties, EVENT_RESULT, builder.result);
                setPropertyIfAbsent(properties, M_TIME, String.valueOf(System.currentTimeMillis()));
                setPropertyIfAbsent(properties, "type", TYPE_LOG);
            }
            thirdPlatformReport(properties);
            builder.reset();
            if (T.isDebug()) {
                return properties;
            }
            return null;
        } catch (Exception e) {
            IMLogger.w("inner report failed : " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private String channel;
        private Context ctx;
        private Map<String, String> extraProp;
        private Map<String, String> innerProp;
        private boolean isCrypt;
        private String method;
        private String openId;
        private String result;
        private String sdkVersion;
        private String stage;
        private String version;

        @Deprecated
        public Builder setDebuggable(boolean z) {
            return this;
        }

        @Deprecated
        public Builder setNewSeq(boolean z) {
            return this;
        }

        private void reportOnceAtAppStart(Context context) {
            if (InnerStat.mAppStartReported) {
                return;
            }
            if (this.innerProp == null) {
                this.innerProp = new HashMap();
            }
            this.innerProp.put("type", InnerStat.TYPE_INIT);
            this.innerProp.put("mac", "");
            this.innerProp.put(InnerStat.GMS_VERSION, T.Device.getAppVersion(context, "com.google.android.gms"));
            this.innerProp.put(InnerStat.FB_VERSION, T.Device.getAppVersion(context, ThirdPN.FACEBOOK));
            this.innerProp.put(InnerStat.GPG_VERSION, T.Device.getAppVersion(context, "com.google.android.play.games"));
            this.innerProp.put(InnerStat.GPS_VERSION, T.Device.getAppVersion(context, "com.android.vending"));
            this.innerProp.put(InnerStat.APP_SIGNATURE, IMSDKValidKeyCalcUnit.getIns(context).getApplicationSignature());
            new InnerStat(this).reportEvent(this);
            if (this.innerProp == null) {
                this.innerProp = new HashMap();
            }
            this.innerProp.put("type", "plugin");
            this.innerProp.put("plugin", "imsdkbase");
            this.innerProp.put(InnerStat.APP_VERSION, T.Device.getAppVersion(context));
            this.innerProp.put("version", "2.10.1");
            this.innerProp.put("sdk", "2.10.1");
            this.innerProp.put("platform", "2");
            new InnerStat(this).reportEvent(this);
            boolean unused = InnerStat.mAppStartReported = true;
        }

        private void reportOnceAtPluginInit(Context context, int i) {
            try {
                if (this.innerProp == null) {
                    this.innerProp = new HashMap();
                }
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (i == 0) {
                    i = 4;
                }
                String className = stackTrace[i].getClassName();
                if (className == null || className.startsWith("com.tencent.imsdk.android.api")) {
                    return;
                }
                this.channel = className.substring(className.lastIndexOf(".") + 1);
                String lowerCase = this.channel.toLowerCase(Locale.US);
                if (!lowerCase.startsWith("imsdk")) {
                    if (lowerCase.endsWith("webview")) {
                        lowerCase = "webview".toLowerCase() + lowerCase.substring(0, lowerCase.indexOf("webview"));
                    } else {
                        int length = this.channel.length() - 1;
                        while (true) {
                            if (length <= 0) {
                                break;
                            }
                            if (Character.isUpperCase(this.channel.charAt(length))) {
                                String substring = this.channel.substring(0, length);
                                lowerCase = (this.channel.substring(length) + substring).toLowerCase();
                                break;
                            }
                            length--;
                        }
                    }
                }
                if (!lowerCase.startsWith("imsdk")) {
                    lowerCase = "imsdk" + lowerCase;
                }
                this.innerProp.put("type", "plugin");
                this.innerProp.put("plugin", lowerCase);
                this.innerProp.put(InnerStat.APP_VERSION, T.Device.getAppVersion(context));
                this.innerProp.put("sdk", this.sdkVersion);
                this.innerProp.put("platform", "2");
                new InnerStat(this).reportEvent(this);
            } catch (Exception e) {
                IMLogger.i("inner report failed : " + e.getMessage(), new Object[0]);
            }
        }

        public Builder(Context context, String str, String str2, String str3) {
            this.version = str;
            this.channel = str2;
            this.ctx = context;
            this.method = str3;
            reportOnceAtAppStart(this.ctx);
        }

        public Builder(Context context, String str) {
            this(context, str, (String) null, 5);
        }

        public Builder(Context context, String str, String str2) {
            this(context, str, str2, 5);
        }

        public Builder(Context context, String str, String str2, int i) {
            this.version = str;
            this.ctx = context;
            this.sdkVersion = str2;
            reportOnceAtAppStart(this.ctx);
            reportOnceAtPluginInit(this.ctx, i);
        }

        public Builder reset() {
            this.result = "";
            this.openId = "";
            this.stage = "";
            this.sdkVersion = "";
            this.isCrypt = false;
            this.extraProp = null;
            this.innerProp = null;
            return this;
        }

        public Builder setVersion(String str) {
            this.version = str;
            return this;
        }

        public Builder setChannel(String str) {
            this.channel = str;
            return this;
        }

        public Builder setMethod(String str) {
            this.method = str;
            return this;
        }

        public Builder setStage(String str) {
            this.stage = str;
            return this;
        }

        public Builder setResult(String str) {
            this.result = str;
            return this;
        }

        public Builder setCrypt(boolean z) {
            this.isCrypt = z;
            return this;
        }

        public Builder setOpenId(String str) {
            this.openId = str;
            return this;
        }

        public Builder setExtraProp(Map<String, String> map) {
            this.extraProp = map;
            return this;
        }

        public InnerStat create() {
            return new InnerStat(this);
        }
    }
}
