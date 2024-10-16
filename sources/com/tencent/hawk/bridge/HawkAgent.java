package com.tencent.hawk.bridge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.helpshift.common.domain.network.NetworkConstants;
import com.tencent.hawk.bridge.CC;
import com.tencent.hawk.bridge.GpuInfoHandler;
import com.tencent.hawk.bridge.VmpHelper;
import com.tencent.hawk.receiver.ReceiverMgr;
import com.tencent.hawk.streamevent.StreamEventFBNotification;
import com.tencent.hawk.streamevent.StreamEventPortal;
import com.tencent.hawk.streamevent.Ticker;
import com.tencent.hawk.utils.BuglyHelper;
import com.tencent.hawk.utils.CocosHelper;
import com.tencent.hawk.utils.DebugHelper;
import com.tencent.hawk.utils.StartupHelper;
import com.tencent.hawk.utils.UnityHelper;
import com.tencent.tdm.TDataMaster;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Stack;
import java.util.TimeZone;
import java.util.concurrent.Semaphore;

@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class HawkAgent {
    private static boolean bInitOnce;
    private static boolean isGpuInfoNativeSet;
    private static boolean isInitGpuInfoValid;
    private static boolean isLevelFin;
    private static boolean isLevelLoaded;
    private static boolean isSpecialProj;
    private static boolean isStatusSet;
    private static boolean isTApmEnabled;
    private static boolean isTrackStateInit;
    private static boolean isUEInit;
    private static String mOaid;
    private static ReceiverMgr mReceiverMgr;
    private static Routine mRoutine;
    private static Ticker mStepEventTicker;
    private static String mXid;
    private static String sAppId;
    private static int sBackwardStartIdx;
    private static Context sContext;
    private static String sCurrentSceneName;
    private static int sForwardStartIdx;
    private static int sGlobalQuality;
    private static String sGpuRender;
    private static String sGpuVendor;
    private static String sGpuVersion;
    private static boolean sIsStepEventFinished;
    private static boolean sIsStepEventInited;
    private static QccHandler sQccHandler;
    private static Semaphore sSECommittingSem;
    private static StreamEventFBNotification sSENotification;
    private static StreamEventPortal sStreamEventPortal;
    private static Stack<String> sTagStack;
    private static Semaphore sTickerWakeupSem;
    private static String sUserId;
    private static int tgapIdFailedCounter;

    public static void postStreamEvent(int i, int i2, int i3, String str) {
    }

    static {
        System.loadLibrary("TDataMaster");
        System.loadLibrary("cubehawk");
        sContext = null;
        bInitOnce = false;
        isTApmEnabled = false;
        sForwardStartIdx = NetworkConstants.UPLOAD_CONNECT_TIMEOUT;
        sBackwardStartIdx = sForwardStartIdx;
        sCurrentSceneName = null;
        isLevelLoaded = false;
        isLevelFin = false;
        sAppId = null;
        sUserId = null;
        sGlobalQuality = 0;
        isInitGpuInfoValid = true;
        isGpuInfoNativeSet = false;
        sQccHandler = null;
        sGpuRender = Constant.APM_CFG_GPU_NA;
        sGpuVendor = Constant.APM_CFG_GPU_NA;
        sGpuVersion = Constant.APM_CFG_GPU_NA;
        isSpecialProj = false;
        sTagStack = null;
        mRoutine = null;
        sSECommittingSem = new Semaphore(0);
        sTickerWakeupSem = new Semaphore(0);
        sSENotification = null;
        mStepEventTicker = null;
        mReceiverMgr = null;
        mXid = Constant.APM_CFG_GPU_NA;
        mOaid = Constant.APM_CFG_GPU_NA;
        tgapIdFailedCounter = 10;
        isUEInit = false;
        isStatusSet = false;
        isTrackStateInit = false;
        sStreamEventPortal = null;
        sIsStepEventInited = false;
        sIsStepEventFinished = false;
    }

    private static void checkCC(Context context) {
        HawkLogger.i("CheckCC");
        CC.initCC(MetaInfo.getManu(), MetaInfo.getModel(), MetaInfo.getAbi(), MetaInfo.getMacAddr(), MetaInfo.getIpAddr(), MetaInfo.getBuildInt(), TApmBuildConfig.VERSION_CODE, MetaInfo.getOsLevel());
        CC.isTApmEnabled = CC.checkHawkEnabled(sContext, sAppId, Constant.APM_CFG_GPU_NA, Constant.APM_CFG_GPU_NA);
        new Fetcher(sContext, sAppId, Constant.APM_CFG_GPU_NA).asynFetch(new CCFileChangeListener() { // from class: com.tencent.hawk.bridge.HawkAgent.1
            @Override // com.tencent.hawk.bridge.CCFileChangeListener
            public void isCCChanged(boolean z) {
            }
        });
    }

    public static synchronized void initNativeContext(String str, int i, String str2, String str3, String str4) {
        int i2;
        int i3;
        synchronized (HawkAgent.class) {
            if (sContext == null) {
                HawkLogger.e("Context error");
                return;
            }
            BuglyHelper.buglyShare(sContext);
            FileUtil.preCreateFile(sContext);
            DebugHelper.checkTransparentMode(sContext);
            RTState.initRTState(sContext);
            if (CC.getStrategy().isExternalFlashInfoEnabled()) {
                HawkLogger.d("External FlashInfo enabled");
                Pair<Long, Long> externalFlashSz = DevPacket.getExternalFlashSz(sContext);
                int intValue = externalFlashSz.getLeft().intValue();
                i3 = externalFlashSz.getRight().intValue();
                i2 = intValue;
            } else {
                i2 = 0;
                i3 = 0;
            }
            Pair<Long, Long> GetInternalFlashSz = DevPacket.GetInternalFlashSz(sContext);
            int intValue2 = GetInternalFlashSz.getLeft().intValue();
            int intValue3 = GetInternalFlashSz.getRight().intValue();
            HawkNative.initNativeSession(str, TApmBuildConfig.VERSION_CODE, TApmBuildConfig.VERSION_NAME, i, (int) (RTState.getBootTime() / 1000), RTState.getRandSeed(), MetaInfo.getPkgName(), MetaInfo.getBuildStr(), MetaInfo.getBuildInt(), RTState.getSessionId(), RTState.getUniversalSessionId(), RTState.getUUIDHigh(), RTState.getUUIDLow(), MetaInfo.getExternalFilePath(), StartupHelper.getStartupTime(), SystemClock.elapsedRealtime());
            String country = Locale.getDefault().getCountry();
            String str5 = country == null ? Constant.APM_CFG_GPU_NA : country;
            String displayName = TimeZone.getDefault().getDisplayName(false, 0);
            String str6 = displayName == null ? Constant.APM_CFG_GPU_NA : displayName;
            DisplayMetrics displayInfo = DevPacket.getDisplayInfo(sContext);
            HawkNative.initNativeDeviceInfo(MetaInfo.getMacAddr(), MetaInfo.getImei(), MetaInfo.getManu(), MetaInfo.getModel(), MetaInfo.getAbi(), str2, str3, str4, MetaInfo.getCpuCore(), MetaInfo.getRam(), MetaInfo.getCpuFreqMax(), MetaInfo.getCpuFreqMin(), MetaInfo.getOsLevel(), DevPacket.getAndroidId(sContext), DevPacket.getHardwareInfo(), intValue2, intValue3, i2, i3, str5, str6, displayInfo.widthPixels, displayInfo.heightPixels, displayInfo.xdpi, displayInfo.ydpi);
        }
    }

    private static boolean ccInitCheck(Context context, String str, int i) {
        if (context == null) {
            return false;
        }
        checkCC(context);
        if (!CC.isTApmEnabled) {
            HawkLogger.e("TAPM DISABLED");
            return false;
        }
        if (CC.getBlockMask() == 511) {
            HawkLogger.e("MASK is 511");
            return false;
        }
        if (CC.getBlockMask() == -1) {
            return true;
        }
        disableOpts(CC.getBlockMask());
        return true;
    }

    public static void initContext(Context context, String str) {
        if (context == null || isUEInit) {
            return;
        }
        isUEInit = true;
        sContext = context;
        sAppId = str;
        if (HashGen.oneWayHash(str, 1) == 1180219410) {
            isSpecialProj = true;
        }
        if (isSpecialProj) {
            sGpuVendor = Constant.APM_CFG_GPU_NA;
            sGpuRender = Constant.APM_CFG_GPU_NA;
            sGpuVersion = Constant.APM_CFG_GPU_NA;
            isInitGpuInfoValid = true;
        } else {
            GpuInfoHandler.GpuInfo readGpuInfoByCache = GpuInfoHandler.readGpuInfoByCache(context);
            HawkLogger.d(String.format("read gfx info from cache : %s %s %s", readGpuInfoByCache.getRender(), readGpuInfoByCache.getVendor(), readGpuInfoByCache.getVersion()));
            if (readGpuInfoByCache.isValid()) {
                isInitGpuInfoValid = true;
                sGpuRender = readGpuInfoByCache.getRender();
                sGpuVendor = readGpuInfoByCache.getVendor();
                sGpuVersion = readGpuInfoByCache.getVersion();
            } else {
                isInitGpuInfoValid = false;
            }
            HawkLogger.d("GpuInfo valid " + String.valueOf(isInitGpuInfoValid));
        }
        try {
            initTApm(sContext, 8, sAppId, sGpuVendor, sGpuRender, sGpuVersion);
        } catch (Exception e) {
            HawkLogger.e("InitTApm Error: " + e.getMessage());
        }
        bInitOnce = true;
    }

    public static void markAppFinishLaunch() {
        HawkNative.setAppStartupTime((int) (System.currentTimeMillis() - RTState.getBootTime()));
    }

    public static void postLagState(float f) {
        HawkNative.postLagStatus((int) (f * 100.0f));
    }

    public static void setGlobalQuality(int i) {
        sGlobalQuality = i;
        HawkNative.setGQuality(i);
        if (VmpHelper.sIsTGPAInit) {
            updateGameStatusToVmp(9, String.valueOf(i));
        }
    }

    public static int getQuality() {
        return sGlobalQuality;
    }

    public static void setUserId(String str) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (str == null) {
            return;
        }
        sUserId = str;
        Context context = sContext;
        if (context != null && (sharedPreferences = context.getSharedPreferences(Constant.APM_CFG_NAME, 0)) != null && (edit = sharedPreferences.edit()) != null) {
            edit.putString(Constant.APM_USER_NAME_KEY, str);
            edit.commit();
        }
        HawkNative.setUserId(str);
        if (VmpHelper.sIsTGPAInit) {
            VmpHelper.updateGameInfoToTGPASS("OpenID", str);
        }
    }

    private static void getDeviceIdentifier() {
        SharedPreferences.Editor edit;
        try {
            int i = tgapIdFailedCounter;
            tgapIdFailedCounter = i - 1;
            if (i < 0) {
                return;
            }
            if (mOaid == null || mXid == null || mOaid.length() <= 5 || mXid.length() <= 5) {
                SharedPreferences sharedPreferences = sContext.getSharedPreferences(Constant.APM_CFG_NAME, 0);
                if (sharedPreferences != null) {
                    mOaid = sharedPreferences.getString(Constant.APM_OAID_KEY, Constant.APM_CFG_GPU_NA);
                    mXid = sharedPreferences.getString(Constant.APM_XID_KEY, Constant.APM_CFG_GPU_NA);
                }
                if (mXid != null && mOaid != null && (mXid.length() < 5 || mOaid.length() < 5)) {
                    mXid = VmpHelper.getXid();
                    if (mXid == null) {
                        HawkLogger.w("get xid failed");
                        mXid = Constant.APM_CFG_GPU_NA;
                    }
                    mOaid = VmpHelper.getOAID();
                    if (mOaid == null) {
                        HawkLogger.w("get oaid failed");
                        mOaid = Constant.APM_CFG_GPU_NA;
                    }
                    if (sContext != null && mOaid != null && mXid != null && mXid.length() > 5 && mOaid.length() > 5 && sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
                        edit.putString(Constant.APM_OAID_KEY, mOaid);
                        edit.putString(Constant.APM_XID_KEY, mXid);
                        edit.commit();
                    }
                }
                if (mXid != null && mOaid != null) {
                    HawkNative.setXid(mXid, mOaid);
                } else {
                    HawkNative.setXid(Constant.APM_CFG_GPU_NA, Constant.APM_CFG_GPU_NA);
                }
                HawkLogger.d("Xid OAID: " + mXid + " " + mOaid);
            }
        } catch (Exception unused) {
        }
    }

    public static void markLevelLoad(String str, int i) {
        getDeviceIdentifier();
        if (sAppId == null) {
            HawkLogger.e("MarkLevelLoad, Appid is null");
            return;
        }
        if (sContext == null) {
            HawkLogger.e("Context is null, return MarkLevelLoad");
            return;
        }
        Stack<String> stack = sTagStack;
        if (stack != null) {
            stack.clear();
        }
        if (isSpecialProj) {
            HawkNative.setGfxInfo(Constant.APM_CFG_GPU_NA, Constant.APM_CFG_GPU_NA, Constant.APM_CFG_GPU_NA);
        } else if (!isGpuInfoNativeSet && !isInitGpuInfoValid) {
            GpuInfoHandler.GpuInfo readGpuInfoByCache = GpuInfoHandler.readGpuInfoByCache(sContext);
            if (!readGpuInfoByCache.isValid()) {
                HawkLogger.d("read gpu by cache, invalid, read by gles");
                readGpuInfoByCache = GpuInfoHandler.getGpuInfoByGLES();
                if (readGpuInfoByCache.isValid()) {
                    HawkLogger.d("read by gles valid, write in cache");
                    GpuInfoHandler.writeGpuInfoInCache(sContext, readGpuInfoByCache);
                } else {
                    HawkLogger.d("Gpu info not valid by gles");
                }
            } else {
                HawkLogger.w("Gpu info valid");
            }
            HawkLogger.w("InitGpuInfo is not valid, Start Set Native");
            HawkNative.setGfxInfo(readGpuInfoByCache.getVendor(), readGpuInfoByCache.getRender(), readGpuInfoByCache.getVersion());
            isGpuInfoNativeSet = true;
        }
        if (str == null) {
            HawkLogger.e("MarkLevelLoad, SceneName is null");
            return;
        }
        if (!isTApmEnabled) {
            HawkLogger.e("MarkLevelLoad, isHawkEnabled disabled");
            return;
        }
        if (sCurrentSceneName != null) {
            markLevelFin();
        }
        String str2 = sCurrentSceneName;
        if (str2 != null && str.equals(str2) && !isLevelFin) {
            HawkLogger.e("MarkLevelLoad: scene name is the same, but the latest is not finished : " + str + " : " + sCurrentSceneName);
            return;
        }
        isLevelFin = false;
        isLevelLoaded = false;
        if (str.length() == 0) {
            str = "A_DEF_NULL_";
        }
        sCurrentSceneName = str;
        int i2 = sForwardStartIdx;
        sBackwardStartIdx = i2;
        sForwardStartIdx = i2 + 1;
        HawkNative.levelControl(sBackwardStartIdx, 1, sGlobalQuality, str);
        if (VmpHelper.sIsTGPAInit) {
            updateGameStatusToVmp(0, String.valueOf(HashGen.oneWayHash(str, 2) & 65535));
        }
        Routine routine = mRoutine;
        if (routine != null) {
            routine.markLevel();
        }
    }

    public static void markLevelLoadCompleted() {
        if (sAppId != null && isTApmEnabled) {
            String str = sCurrentSceneName;
            if (str == null) {
                HawkLogger.e("MarkLevelloadCompleted:  no current scene set");
                return;
            }
            if (isLevelLoaded) {
                HawkLogger.e("MarkLevelloadCompleted:  the current level is loaded, " + sCurrentSceneName);
                return;
            }
            isLevelLoaded = true;
            HawkNative.levelControl(sBackwardStartIdx, 2, 0, str);
        }
    }

    public static void markLevelFin() {
        if (sAppId == null) {
            HawkLogger.e("mark-level-fin: appid");
            return;
        }
        if (!isTApmEnabled) {
            HawkLogger.e("mark-level-fin: isTApmEnabled");
            return;
        }
        if (sCurrentSceneName == null) {
            HawkLogger.e("mark-level-fin:  no current scene set");
            return;
        }
        if (sContext == null) {
            HawkLogger.e("Context is null, return markLevelFin");
            return;
        }
        isLevelFin = true;
        isLevelLoaded = false;
        ExtMsg.cleanIdxMap();
        HawkNative.levelControl(sBackwardStartIdx, 3, NetworkUtil.getNetworkState(sContext), sCurrentSceneName);
        HawkNative.endHawk();
        sCurrentSceneName = null;
        Routine routine = mRoutine;
        if (routine != null) {
            routine.markLevelFin();
        }
    }

    public static void beginTag(String str) {
        if (sAppId != null && isTApmEnabled) {
            if (sCurrentSceneName == null) {
                HawkLogger.e("AddTag ERROR, no current scene set");
                return;
            }
            if (str == null) {
                HawkLogger.e("AddTag ERROR, TagName is null");
                return;
            }
            if (sTagStack.size() >= 8) {
                HawkLogger.e("AddTag ERROR, reaches max limit 8, return");
                return;
            }
            if (sTagStack.size() != 0 && sTagStack.peek().equals(str)) {
                HawkLogger.e("AddTag ERROR, equals the last TagName : " + str);
                return;
            }
            sTagStack.push(str);
            HawkNative.levelControl(sBackwardStartIdx, 11, 0, str);
        }
    }

    public static void endTag() {
        if (sTagStack.size() == 0) {
            HawkLogger.e("EndTag ERROR, there's no tag set");
        } else {
            HawkNative.levelControl(sBackwardStartIdx, 13, 0, sTagStack.pop());
        }
    }

    public static void disableOpts(int i) {
        if (i > 511) {
            return;
        }
        HawkNative.disableOpts(i);
    }

    public static void setTargetFramerate(int i) {
        HawkNative.setTargetFramerate(i);
        if (VmpHelper.sIsTGPAInit) {
            updateGameStatusToVmp(4, String.valueOf(i));
        }
    }

    public static void setLocale(String str, int i) {
        HawkNative.setLocale(str, i);
    }

    public static void postEvent(int i, String str) {
        if (str != null && (str.trim().length() == 0 || str.equals(Constant.APM_CFG_GPU_NA))) {
            str = null;
        }
        EventDispatcher.dispatchEvent(i, str);
    }

    @SuppressLint({"NewApi"})
    public static void setVersionIden(String str) {
        if (str == null || str.isEmpty()) {
            HawkLogger.e("VersionName is NULL or is empty");
        }
        HawkNative.setRevisedVersion(str);
    }

    private static boolean initTApm(Context context, int i, String str, String str2, String str3, String str4) {
        DebugHelper.checkTransparentMode(context);
        MetaInfo.initMetaCtx(context);
        RTState.initCCURL(context);
        if (TDataMaster.getInstance() != null) {
            TDataMaster.getInstance().initialize(context.getApplicationContext());
        }
        if (!ccInitCheck(sContext, str, i)) {
            HawkLogger.e("Init failed, return");
            return false;
        }
        CC.Strategy strategy = CC.getStrategy();
        if (strategy.isTencentQemuHardwareBlocked()) {
            HawkLogger.e("Block Tencent Qemu info");
            HawkNative.setTencentQemuBlocked();
        }
        HawkNative.setStrategy(strategy.getNativePssIntervals(), strategy.getVbufferSz(), true, strategy.isZigzagCompressEnabled(), strategy.ismStartupTimeEnabled());
        initNativeContext(str, i, sGpuVendor, sGpuRender, sGpuVersion);
        HawkLogger.w("TAPM VERSION: 714");
        FileUtil.cleanSpace(sContext);
        initCachedOpenId();
        HawkLogger.i("JavaPolicy: " + strategy.getNativePssIntervals() + " " + strategy.getVbufferSz() + " " + strategy.isZigzagCompressEnabled());
        HawkNative.startNativeMonitoring();
        if (mReceiverMgr == null) {
            mReceiverMgr = new ReceiverMgr();
            mReceiverMgr.addNotificationSemaphore(sSECommittingSem);
            mReceiverMgr.registerStatusReceiver(sContext);
        }
        sQccHandler = new QccHandler(context, str);
        sTagStack = new Stack<>();
        if (mRoutine == null) {
            mRoutine = new Routine(sContext, CC.getInstance());
        }
        if (sSENotification == null) {
            sSENotification = new StreamEventFBNotification(sSECommittingSem);
        }
        if (mStepEventTicker == null) {
            mStepEventTicker = new Ticker(sSECommittingSem, sTickerWakeupSem, 3);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(mRoutine);
        arrayList.add(sSENotification);
        arrayList.add(mStepEventTicker);
        arrayList.add(mReceiverMgr);
        LifeCycleMgr.registerLifeCycle(sContext, arrayList);
        mRoutine.start();
        isTApmEnabled = true;
        return true;
    }

    public static synchronized int hawkInitForUnity(String str, String str2, String str3, String str4) {
        synchronized (HawkAgent.class) {
            if (bInitOnce) {
                HawkLogger.e("Context init more than once");
                return -1;
            }
            if (sContext == null) {
                sContext = UnityHelper.getUnityContext();
            }
            if (sContext == null) {
                HawkLogger.e("init context error");
                bInitOnce = true;
                return -1;
            }
            sAppId = str;
            sGpuVendor = str2;
            sGpuRender = str3;
            sGpuVersion = str4;
            isGpuInfoNativeSet = true;
            try {
                initTApm(sContext, 0, str, sGpuVendor, sGpuRender, sGpuVersion);
            } catch (Exception e) {
                HawkLogger.e("InitTApm Error: " + e.getMessage());
            }
            bInitOnce = true;
            return 0;
        }
    }

    public static synchronized int hawkInitForCocos(String str, String str2, String str3, String str4) {
        synchronized (HawkAgent.class) {
            if (bInitOnce) {
                HawkLogger.e("context init more than once");
                return -1;
            }
            sContext = CocosHelper.getContext();
            if (sContext == null) {
                HawkLogger.e("init context error");
                bInitOnce = true;
                return -1;
            }
            sAppId = str;
            sGpuVendor = str2;
            sGpuRender = str3;
            sGpuVersion = str4;
            isGpuInfoNativeSet = true;
            try {
                initTApm(sContext, 2, str, sGpuVendor, sGpuRender, sGpuVersion);
            } catch (Exception e) {
                HawkLogger.e("InitTApm Error: " + e.getMessage());
            }
            bInitOnce = true;
            return 0;
        }
    }

    private static void initCachedOpenId() {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        SharedPreferences.Editor edit;
        if (sUserId != null && (sharedPreferences2 = sContext.getSharedPreferences(Constant.APM_CFG_NAME, 0)) != null && (edit = sharedPreferences2.edit()) != null) {
            edit.putString(Constant.APM_USER_NAME_KEY, sUserId);
            edit.commit();
        }
        if (sUserId != null || (sharedPreferences = sContext.getSharedPreferences(Constant.APM_CFG_NAME, 0)) == null) {
            return;
        }
        String string = sharedPreferences.getString(Constant.APM_USER_NAME_KEY, Constant.APM_USERNAME_DEFAULT_VALUE);
        HawkLogger.d("retrive last login name : " + string);
        if (string != null) {
            HawkNative.setUserId(string);
        }
    }

    public static void postNTL(int i, int i2) {
        if (isTApmEnabled) {
            if (sCurrentSceneName == null) {
                HawkLogger.i("NTL current scene name is null");
            } else {
                HawkNative.postNTL(i, i2);
            }
        }
    }

    public static void postNTL(int i, long j) {
        if (isTApmEnabled) {
            if (sCurrentSceneName == null) {
                HawkLogger.e("ntl current scene name is null");
            } else {
                HawkNative.postNTL2(i, j);
            }
        }
    }

    public static void enableDebugMode() {
        HawkLogger.enableDebug();
        HawkNative.enableLogPrint();
    }

    public static void postValue1F(String str, String str2, float f) {
        HawkNative.postValue1F(str, str2, f);
    }

    public static void postValue2F(String str, String str2, float f, float f2) {
        HawkNative.postValue2F(str, str2, f, f2);
    }

    public static void postValue3F(String str, String str2, float f, float f2, float f3) {
        HawkNative.postValue3F(str, str2, f, f2, f3);
    }

    public static void postValue1I(String str, String str2, int i) {
        HawkNative.postValue1I(str, str2, i);
    }

    public static void postValue2I(String str, String str2, int i, int i2) {
        HawkNative.postValue2I(str, str2, i, i2);
    }

    public static void postValue3I(String str, String str2, int i, int i2, int i3) {
        HawkNative.postValue3I(str, str2, i, i2, i3);
    }

    public static void postValueS(String str, String str2, String str3) {
        HawkNative.postValueS(str, str2, str3);
    }

    public static void postLargeValueS(String str, String str2, String str3) {
        HawkNative.postLargeValueS(str, str2, str3);
    }

    public static void setSceneIdentifier(String str) {
        HawkNative.setIdentifier(sBackwardStartIdx, str);
    }

    public static void beginTupleWrap(String str) {
        HawkNative.beginTupleWrap(str);
    }

    public static void endTupleWrap() {
        HawkNative.endTupleWrap();
    }

    public static int checkDCLSByQccSync(String str, String str2, String str3) {
        Context context = sContext;
        if (context == null) {
            HawkLogger.e("DCLS SYNC, context is null, return");
            return -9;
        }
        String str4 = sAppId;
        if (str4 == null) {
            HawkLogger.e("DCLS SYNC, appid is null, return");
            return -8;
        }
        if (str == null) {
            HawkLogger.e("DCLS SYNC, configName is null, return");
            return -7;
        }
        return new QccHandlerSync(context, str4).checkDCLSByQccSync(str, str2, str3);
    }

    public static int getQccJudgeCpuFreq() {
        if (sAppId == null) {
            HawkLogger.e("Context is not inited, getQccJudgeCpuFreq");
            return -1;
        }
        Pair<Float, Float> cpuFreq = DevPacket.getCpuFreq(DevPacket.getCpuCoreNum());
        if (sAppId.equals("APM_NBORN")) {
            return (int) (cpuFreq.getRight().floatValue() * 1000.0f);
        }
        return (int) (cpuFreq.getLeft().floatValue() * 1000.0f);
    }

    public static Context getCtx() {
        return sContext;
    }

    public static void setPssManualMode() {
        HawkNative.setPssManualMode();
    }

    public static void requestPssSample() {
        HawkNative.requestPssSample();
    }

    public static void postFrame(float f) {
        HawkNative.postFrame(f);
    }

    public static synchronized int checkDCLSByQcc(String str, String str2, String str3) {
        synchronized (HawkAgent.class) {
            if (sQccHandler == null) {
                HawkLogger.e("QccHandler is null");
                EventDispatcher.dispatchEvent(1000, "Qcc");
                return 0;
            }
            if (!VersionHandler.checkCacheValidation(sContext) && sAppId != null) {
                HawkLogger.w("Version changed, needs to flush cached info and cp files");
                FileUtil.cpAssetFile(sContext, Constant.QUALITY_CONTROL_PREFIX + sAppId, Constant.APM_QCC_FINALLY);
                FileUtil.deleteFile(sContext, Constant.APM_QCC_FILENAME_PREONCE);
                FileUtil.cpFileWithCtx(sContext, Constant.APM_QCC_FINALLY, Constant.APM_QCC_FILENAME_PREONCE);
            }
            if (!sContext.getFileStreamPath(Constant.APM_QCC_FINALLY).exists() && sAppId != null) {
                HawkLogger.w("Cannot find finally file, cp qcc from asset");
                FileUtil.cpAssetFile(sContext, Constant.QUALITY_CONTROL_PREFIX + sAppId, Constant.APM_QCC_FINALLY);
                FileUtil.cpFileWithCtx(sContext, Constant.APM_QCC_FINALLY, Constant.APM_QCC_FILENAME_PREONCE);
                HawkLogger.d("end cp asset file");
            }
            if (str != null && str2 != null && str3 != null) {
                int checkDCLSByQcc = sQccHandler.checkDCLSByQcc(str, str2, str3);
                if (!isStatusSet) {
                    isStatusSet = true;
                    EventDispatcher.dispatchEvent(1023, String.valueOf(checkDCLSByQcc));
                }
                return checkDCLSByQcc;
            }
            HawkLogger.e("Param is null");
            EventDispatcher.dispatchEvent(1001, "Qcc");
            return 0;
        }
    }

    public static void genTmpCCFile(Context context, boolean z) {
        BufferedWriter bufferedWriter;
        if (z) {
            try {
                RefInvoke.invokeStaticMethod("com.tencent.bugly.crashreport.CrashReport", "initCrashReport", new Class[]{Context.class, String.class, Boolean.TYPE}, new Object[]{context, "a7b2de6200", true});
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                HawkLogger.e("RefError :" + e.getMessage());
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                HawkLogger.e("RefError :" + e2.getMessage());
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                HawkLogger.e("RefError :" + e3.getMessage());
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
                HawkLogger.e("RefError :" + e4.getMessage());
            } catch (SecurityException e5) {
                e5.printStackTrace();
                HawkLogger.e("RefError :" + e5.getMessage());
            } catch (InvocationTargetException e6) {
                e6.printStackTrace();
                HawkLogger.e("RefError :" + e6.getMessage());
            }
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(context.openFileOutput(Constant.CFG_NAME, 0)));
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            } catch (FileNotFoundException e8) {
                e = e8;
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            bufferedWriter.write("32512;0;112;0;0;0;0;0;0;0;0;0;100;1;2622463251");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (FileNotFoundException e10) {
            e = e10;
            bufferedWriter2 = bufferedWriter;
            e.printStackTrace();
            HawkLogger.e(e.getMessage());
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
        } catch (IOException e11) {
            e = e11;
            bufferedWriter2 = bufferedWriter;
            e.printStackTrace();
            if (bufferedWriter2 != null) {
                bufferedWriter2.close();
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static void initTGPA() {
        if (sContext == null) {
            sContext = UnityHelper.getUnityContext();
        }
        Context context = sContext;
        if (context == null) {
            HawkLogger.e("TGPA init context error");
        } else {
            VmpHelper.initTGPA(context);
            VmpHelper.sIsTGPAInit = true;
        }
    }

    public static boolean registerCallBack(String str, String str2, VmpGCallbackWrapper vmpGCallbackWrapper) {
        if (sContext == null) {
            sContext = UnityHelper.getUnityContext();
        }
        if (sContext == null) {
            HawkLogger.e("init context error");
            return false;
        }
        return VmpHelper.registerTGPACallback(VmpHelper.ENGINE.UNITY, vmpGCallbackWrapper);
    }

    public static boolean setUserIdenForUE4(String str, String str2) {
        if (sContext == null) {
            HawkLogger.e("init context error");
            return false;
        }
        VmpHelper.registerTGPACallback(VmpHelper.ENGINE.UNRAL, null);
        return true;
    }

    public static void updateGameStatusToVmp(int i, String str) {
        if (sContext == null) {
            return;
        }
        VmpHelper.tgpaUpdateGameInfo(i, str);
    }

    public static void requestResourceGuarantee(int i, int i2, int i3) {
        if (sContext == null) {
            HawkLogger.e("init context error");
        } else {
            VmpHelper.requestResourceGuarantee(i);
        }
    }

    public static void processAffinitySetting(int i, int i2) {
        if (sContext == null) {
            HawkLogger.e("init context error");
        } else if (i2 == 1) {
            VmpHelper.tgpaUpdateGameInfo(51, String.valueOf(i));
        }
    }

    public static String checkDeviceIsReal() {
        return VmpHelper.checkDeviceIsReal();
    }

    public static synchronized void ayncFetchQccQuality() {
        synchronized (HawkAgent.class) {
            HawkLogger.e("no implementation");
        }
    }

    public static void setGfxInfoForUe(String str, String str2) {
        if (str == null) {
            str = Constant.APM_CFG_GPU_NA;
        }
        if (str2 == null) {
            str2 = Constant.APM_CFG_GPU_NA;
        }
        HawkNative.setGfxInfo(Constant.APM_CFG_GPU_NA, str, str2);
    }

    public static void postTrackState(float f, float f2, float f3, float f4, float f5, float f6) {
        if (isTApmEnabled) {
            if (!CC.getStrategy().isCoordinatetEnabled) {
                HawkLogger.e("PostTrackState: Closed by CC");
                return;
            }
            if (!isTrackStateInit) {
                HawkNative.enableTrackState();
                isTrackStateInit = true;
            }
            HawkNative.postTrackState(f, f2, f3, f4, f5, f6);
        }
    }

    public static void postInfoToTGPA(String str, String str2) {
        VmpHelper.updateGameInfoToTGPASS(str, str2);
    }

    public static void postInfoToTGPA(int i, String str) {
        VmpHelper.updateGameInfoToTGPAIS(i, str);
    }

    public static String getOptCfgStr() {
        return VmpHelper.getOptCfgStr();
    }

    public static String getDataFromTGPA(String str, String str2) {
        return VmpHelper.getDataFromTGPA(str, str2);
    }

    public static void postInfoToTGPA(String str, HashMap<String, String> hashMap) {
        char c;
        HawkLogger.d("Cannot invoke postInfoToTGPA: " + str);
        int hashCode = str.hashCode();
        if (hashCode != -1520863277) {
            if (hashCode == 673264683 && str.equals("PreDownload")) {
                c = 0;
            }
            c = 65535;
        } else {
            if (str.equals("DeviceBind")) {
                c = 1;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                reportMapToTGPA("PreDownload", hashMap);
                break;
            case 1:
                reportGameUserInfoToTGPA(hashMap);
                break;
        }
        HawkLogger.d("end Cannot invoke postInfoToTGPA: " + str);
    }

    public static void reportMapToTGPA(String str, HashMap<String, String> hashMap) {
        if (sContext == null) {
            HawkLogger.e("reportMapToTGPA, but context is null");
            return;
        }
        try {
            HawkLogger.d("Beign reportMapToTGPA,");
            VmpHelper.reportMapToTGPA(str, hashMap);
            HawkLogger.d("end reportMapToTGPA");
        } catch (Exception unused) {
            HawkLogger.e("reportMapToTGPA, excpetion is occured");
        }
    }

    public static void reportGameUserInfoToTGPA(HashMap<String, String> hashMap) {
        if (sContext == null) {
            HawkLogger.e("ReportGameUser, but context is null");
            return;
        }
        try {
            HawkLogger.d("Beign reportGameUserInfo,");
            VmpHelper.reportGameUserInfoToTGPA(sContext, hashMap);
            HawkLogger.d("end reportGameUserInfo");
        } catch (Exception unused) {
            HawkLogger.e("ReportGameUser, excpetion is occured");
        }
    }

    public static void registerTPGACallback(Context context) {
        if (context == null) {
            HawkLogger.e("RegisterTPGACallback failed, Context is null");
        }
    }

    public static int getCurrentThreadTid() {
        return VmpHelper.getCurrentThreadTid();
    }

    private static boolean validCheck(String str) {
        if (sAppId == null || !isTApmEnabled) {
            return false;
        }
        if (sCurrentSceneName == null) {
            HawkLogger.e(str + "no current scene set");
            return false;
        }
        if (sContext != null) {
            return true;
        }
        HawkLogger.e("Context is null, return " + str);
        return false;
    }

    public static void beignExclude() {
        if (validCheck("beignExclude")) {
            HawkNative.beignExclude();
        }
    }

    public static void endExclude() {
        if (validCheck("endExclude")) {
            HawkNative.endExclude();
        }
    }

    public static synchronized void linkLastStepCategorySession(String str) {
        synchronized (HawkAgent.class) {
            if (sStreamEventPortal == null) {
                HawkLogger.e("linkLastSession: please add stream event first");
                return;
            }
            if (!CC.isTApmEnabled) {
                HawkLogger.e("linkLastStepCategorySession: TAPM DISABLED");
                return;
            }
            if (!CC.getStrategy().isStepEventEnabled) {
                HawkLogger.e("linkLastStepCategorySession: Closed by CC");
                return;
            }
            if (!sIsStepEventInited) {
                HawkLogger.e("linkLastStepCategorySession: StepEvent context is not inited");
            } else if (sIsStepEventFinished) {
                HawkLogger.e("linkLastStepCategorySession: StepEvent context released");
            } else {
                sStreamEventPortal.linkSession(str);
            }
        }
    }

    public static synchronized void postStepEvent(String str, int i, int i2, int i3, String str2, String str3) {
        synchronized (HawkAgent.class) {
            if (sStreamEventPortal == null) {
                HawkLogger.e("postStepEvent: please add stream event first");
                return;
            }
            if (!CC.isTApmEnabled) {
                HawkLogger.e("postStepEvent: TAPM DISABLED");
                return;
            }
            if (!CC.getStrategy().isStepEventEnabled) {
                HawkLogger.e("postStepEvent: Closed by CC");
                return;
            }
            if (!sIsStepEventInited) {
                HawkLogger.e("postStepEvent: please add stepevent category before init context");
            } else if (sIsStepEventFinished) {
                HawkLogger.e("linkLastStepCategorySession: StepEvent context released");
            } else {
                sStreamEventPortal.postStepEvent(str, i, i2, i3, str2, str3);
            }
        }
    }

    public static synchronized void initStepEventContext() {
        synchronized (HawkAgent.class) {
            if (sContext == null) {
                HawkLogger.e("PostStreamEvent Context is null");
                return;
            }
            if (!CC.isTApmEnabled) {
                HawkLogger.e("initStepEventContext: TAPM DISABLED");
                return;
            }
            if (!CC.getStrategy().isStepEventEnabled) {
                HawkLogger.e("initStepEventContext: Closed by CC");
                return;
            }
            if (sIsStepEventInited) {
                HawkLogger.i("initStepEventContext: StepEventContext is inited");
                return;
            }
            if (sSENotification != null) {
                sSENotification.enableStreamEvent();
            }
            if (sStreamEventPortal == null) {
                sStreamEventPortal = new StreamEventPortal(sContext, sSECommittingSem, mStepEventTicker);
            }
            sIsStepEventInited = true;
        }
    }

    public static synchronized void releaseStepEventContext() {
        synchronized (HawkAgent.class) {
            if (sStreamEventPortal == null) {
                HawkLogger.e("releaseStepEventContext: please add stream event first");
                return;
            }
            if (!CC.isTApmEnabled) {
                HawkLogger.e("releaseStepEventContext: TAPM DISABLED");
                return;
            }
            if (!CC.getStrategy().isStepEventEnabled) {
                HawkLogger.e("releaseStepEventContext: Closed by CC");
                return;
            }
            if (sIsStepEventInited && !sIsStepEventFinished) {
                sStreamEventPortal.releaseStepEventContext();
            }
            sIsStepEventFinished = true;
        }
    }

    public static void setDefinedDeviceClass(int i) {
        HawkNative.setDeviceClass(i);
    }

    public static int getSceneMaxPss() {
        Routine routine = mRoutine;
        if (routine == null) {
            return 0;
        }
        return routine.getSceneMaxPss();
    }

    public static float getInstantFps() {
        return HawkNative.getInstantFps();
    }

    public static float getSceneMeanFps(String str) {
        return HawkNative.getSceneMeanFps(str);
    }
}
