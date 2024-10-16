package com.subao.gamemaster;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import android.os.ConditionVariable;
import android.text.TextUtils;
import android.util.JsonWriter;
import android.util.Log;
import android.util.Pair;
import com.amazonaws.event.ProgressEvent;
import com.facebook.internal.ServerProtocol;
import com.subao.common.a.e;
import com.subao.common.e.ao;
import com.subao.common.e.aq;
import com.subao.common.e.f;
import com.subao.common.e.h;
import com.subao.common.e.r;
import com.subao.common.e.v;
import com.subao.common.i.k;
import com.subao.common.intf.AccelSwitchListener;
import com.subao.common.intf.AppInfo;
import com.subao.common.intf.AsyncInitCallback;
import com.subao.common.intf.NodeDetectCallback;
import com.subao.common.intf.QueryOriginUserStateCallback;
import com.subao.common.intf.QueryProductCallback;
import com.subao.common.intf.QuerySignCouponsCallback;
import com.subao.common.intf.QueryThirdPartyAuthInfoCallback;
import com.subao.common.intf.RequestBuyCallback;
import com.subao.common.intf.RequestTrialCallback;
import com.subao.common.intf.SupportGameLabel;
import com.subao.common.intf.UserAuthCallback;
import com.subao.common.intf.UserInfo;
import com.subao.common.intf.UserStateListener;
import com.subao.common.intf.VPNStateListener;
import com.subao.common.intf.XunyouTokenStateListener;
import com.subao.common.intf.XunyouUserStateCallback;
import com.subao.common.j.e;
import com.subao.common.j.j;
import com.subao.common.j.q;
import com.subao.common.k.m;
import com.subao.common.n.h;
import com.tencent.mid.api.MidConstants;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class GameMaster {
    public static final int ACCEL_RECOMMENDATION_HAS_NEW_FEATURE = 3;
    public static final int ACCEL_RECOMMENDATION_MOBILE_SWITCH = 6;
    public static final int ACCEL_RECOMMENDATION_NONE = 0;
    public static final int ACCEL_RECOMMENDATION_NOTICE = 1;
    public static final int ACCEL_RECOMMENDATION_PROMPT_MONTH_REPORT = 4;
    public static final int ACCEL_RECOMMENDATION_UNKNOWN = -1;
    public static final int ACCEL_RECOMMENDATION_VIP_EXPIRED = 5;
    public static final int ACCEL_RECOMMENDATION_WIFI = 2;
    public static final String BUILD_TIME = "20200908_100430";
    public static final String COMMIT_ID = "7b476d6ac2d43b5bccf5f501f525eb43e4645542";
    public static final long DEFAULT_NODE_DETECT_TIMEOUT = 8000;
    public static final int DEFAULT_UDP_ECHO_PORT = 222;
    public static final int GM_INIT_ALREADY = 1;
    public static final int GM_INIT_FAILURE = -1;
    public static final int GM_INIT_ILLEGAL_ARGUMENT = -4;

    @Deprecated
    public static final int GM_INIT_NOT_IN_MAIN_THREAD = -3;

    @Deprecated
    public static final int GM_INIT_NO_PERMISSION = -2;
    public static final int GM_INIT_PENDING = 2;
    public static final int GM_INIT_SUCCESS = 0;
    public static final int HOOK_TYPE_CONNECT = 0;
    public static final int HOOK_TYPE_CONNECTION_UDP = 4;
    public static final int HOOK_TYPE_SENDMSG_RECVMSG = 2;
    public static final int HOOK_TYPE_SENDTO_RECVFROM = 1;
    public static final int HOOK_TYPE_SENDTO_RECVFROM_AND_TCP = 3;
    public static final int HOOK_TYPE_TCP = 6;
    public static final int HOOK_TYPE_UDP = 5;
    public static final int NETWORK_CLASS_2G = 2;
    public static final int NETWORK_CLASS_3G = 3;
    public static final int NETWORK_CLASS_4G = 4;
    public static final int NETWORK_CLASS_DISCONNECT = -1;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_CLASS_WIFI = 1;
    public static final int PAY_TYPE_ALIPAY = 0;
    public static final int PAY_TYPE_OTHER = 5;
    public static final int PAY_TYPE_PHONE = 4;
    public static final int PAY_TYPE_QQ = 2;
    public static final int PAY_TYPE_UNIONPAY = 3;
    public static final int PAY_TYPE_WECHAT = 1;
    public static final int SDK_EXPIRED = 5;
    public static final int SDK_FREE = 6;
    public static final int SDK_FREE_TRIAL = 2;
    public static final int SDK_IN_USE = 4;

    @Deprecated
    public static final int SDK_MODE_FREE = 3;

    @Deprecated
    public static final int SDK_MODE_GRAY = 1;

    @Deprecated
    public static final int SDK_MODE_OFFICIAL = 2;
    public static final int SDK_NOT_QUALIFIED = 0;
    public static final int SDK_QUALIFIED = 1;
    public static final int SDK_TRIAL_EXPIRED = 3;
    public static final String VERSION_NAME = "3.10.1.1";

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    static com.subao.common.a.c f6138a;
    private static g b;

    /* loaded from: classes2.dex */
    public interface I1 {
        void a(boolean z);
    }

    /* loaded from: classes2.dex */
    public interface I2 {
        void a(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a extends AsyncInitCallback {
        Context a();
    }

    @Deprecated
    public static void clearUDPCache() {
    }

    @Deprecated
    public static long getLong(int i) {
        return 0L;
    }

    @Deprecated
    public static String getString(int i) {
        return "";
    }

    @Deprecated
    public static boolean isNodeDetectSucceed() {
        return true;
    }

    @Deprecated
    public static void onNetDelayQuality(float f2, float f3, float f4, int i) {
    }

    @Deprecated
    public static void setLong(int i, long j) {
    }

    @Deprecated
    public static void setSDKMode(int i) {
    }

    @Deprecated
    public static void setString(int i, String str) {
    }

    static {
        r.b = r.a.SDK;
    }

    private GameMaster() {
    }

    static com.subao.common.g.a a(int i) {
        switch (i) {
            case 0:
            case 6:
                return com.subao.common.g.a.TCP;
            case 1:
            case 2:
                return com.subao.common.g.a.UDP;
            case 3:
                return com.subao.common.g.a.UDP_TCP;
            case 4:
            case 5:
                return com.subao.common.g.a.UDP;
            default:
                return null;
        }
    }

    public static int getJNIBits() {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            return cVar.m();
        }
        return 0;
    }

    public static void setU3DObserver(String str, String str2) {
        Log.d("SubaoGame", String.format("setU3DObserver(%s, %s)", str, str2));
        g a2 = g.a(str, str2);
        synchronized (GameMaster.class) {
            b = a2;
        }
    }

    static g a() {
        g gVar;
        synchronized (GameMaster.class) {
            gVar = b;
        }
        return gVar;
    }

    public static int init(Context context, int i, String str, String str2, int i2) {
        return init(context, i, str, null, str2, i2);
    }

    public static int init(Context context, int i, String str, String str2, String str3, int i2) {
        b bVar;
        com.subao.common.g.a a2 = a(i);
        if (a2 == null) {
            return -4;
        }
        g a3 = a();
        if (a3 != null) {
            bVar = new b(a3);
        } else {
            if (context == null) {
                return -4;
            }
            bVar = null;
        }
        return a(context, str, r.a.SDK, a2, str3, i2, null, null, false, bVar);
    }

    public static void setUsableRegion(String str) {
        if (f6138a != null) {
            Log.d("SubaoGame", "GameMaster init already, cannot set region");
            return;
        }
        Log.d("SubaoGame", "Set usable region=" + h.a(str));
        com.subao.common.e.f.a(TextUtils.isEmpty(str) ? "cn" : str.toLowerCase(Locale.US));
    }

    public static int initWithVPN(Context context, String str) {
        return initWithVPN(context, str, false);
    }

    public static int initWithVPN(Context context, String str, boolean z) {
        return initWithVPN(context, str, z, null);
    }

    public static int initWithVPN(Context context, String str, boolean z, byte[] bArr) {
        return a(context, str, r.a.ROM, com.subao.common.g.a.VPN, null, -1, bArr, null, z, null);
    }

    static int a(Context context, String str, r.a aVar, com.subao.common.g.a aVar2, String str2, int i, byte[] bArr, com.subao.common.a.c cVar, boolean z, a aVar3) {
        if (aVar3 == null) {
            int a2 = a(context, str, aVar, aVar2, str2, i, bArr, cVar, z);
            Log.d("SubaoGame", String.format(r.f6001a, "GameMaster.init() result: %d", Integer.valueOf(a2)));
            return a2;
        }
        d dVar = new d(context, str, aVar, aVar2, str2, i, bArr, cVar, z, aVar3);
        Log.d("SubaoGame", "GameMaster.init() async running");
        new Thread(dVar).start();
        return 2;
    }

    static int a(Context context, String str, r.a aVar, com.subao.common.g.a aVar2, String str2, int i, byte[] bArr, com.subao.common.a.c cVar, boolean z) {
        com.subao.common.a.c cVar2;
        boolean z2;
        Log.i("SubaoGame", String.format("GameMaster %s (%s)\ncommit-id: %s\n", VERSION_NAME, BUILD_TIME, COMMIT_ID));
        if (com.subao.common.d.a("SubaoGame")) {
            Log.d("SubaoGame", String.format("[%s] with %s", str, aVar.g));
        }
        if (TextUtils.isEmpty(str)) {
            Log.e("SubaoGame", "Null game-guid, init failed");
            return -4;
        }
        synchronized (GameMaster.class) {
            if (f6138a != null) {
                return 1;
            }
            if (cVar == null) {
                cVar2 = new com.subao.common.a.c(context, aVar, str, VERSION_NAME, j.a(context), new com.subao.common.g.c("gamemaster"), null, true);
                z2 = z;
            } else {
                cVar2 = cVar;
                z2 = z;
            }
            cVar2.b(z2);
            f6138a = cVar2;
            int a2 = cVar2.a(aVar2, aVar == r.a.ROM ? "android_rom" : "android_sdk", str2, i, bArr);
            if (a2 == 0) {
                if (aVar2 == com.subao.common.g.a.VPN) {
                    cVar2.a(new f());
                }
                com.subao.common.a.b.a(cVar2);
            } else {
                cVar2.a();
                f6138a = null;
            }
            return a2;
        }
    }

    @TargetApi(14)
    public static Intent prepareVPN(Context context) {
        try {
            return VpnService.prepare(context);
        } catch (RuntimeException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static int openVPN() {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            return cVar.C();
        }
        return 1000;
    }

    public static void closeVPN() {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.D();
        }
    }

    public static boolean isVpnEstablished() {
        com.subao.common.a.c cVar = f6138a;
        return cVar != null && cVar.E();
    }

    public static boolean setVPNStateListener(VPNStateListener vPNStateListener) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            return false;
        }
        cVar.a(vPNStateListener);
        return true;
    }

    public static void stopService(Context context) {
        GameMasterVpnService.c(context);
    }

    public static void setVpnSessionName(String str) {
        GameMasterVpnService.a(str);
    }

    public static boolean start(int i) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            return false;
        }
        int o = cVar.o();
        return o == 0 || o == 1002;
    }

    public static void stop() {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.p();
        }
    }

    public static boolean setAccelSwitchListener(AccelSwitchListener accelSwitchListener) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            return false;
        }
        cVar.a(accelSwitchListener);
        return true;
    }

    public static boolean isEngineRunning() {
        return f6138a != null;
    }

    public static boolean isUDPProxy() {
        com.subao.common.a.c cVar = f6138a;
        return cVar != null && cVar.y();
    }

    public static boolean isAccelOpened() {
        com.subao.common.a.c cVar = f6138a;
        return cVar != null && cVar.c();
    }

    public static void startNodeDetect(int i) {
        startNodeDetect(i, 0L, null, null);
    }

    public static boolean startNodeDetect(int i, long j, NodeDetectCallback nodeDetectCallback, Object obj) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            return false;
        }
        cVar.a(i, j, nodeDetectCallback, obj);
        return true;
    }

    public static boolean isNodeDetected(int i) {
        com.subao.common.a.c cVar = f6138a;
        return cVar != null && cVar.m(i);
    }

    public static void setUserStateListener(UserStateListener userStateListener) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.a(userStateListener);
        }
    }

    public static void setUserToken(String str, String str2, String str3) {
        setUserToken(str, str2, str3, 0L, null, null);
    }

    public static int setUserToken(String str, String str2, String str3, long j, UserAuthCallback userAuthCallback, Object obj) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            return 1000;
        }
        cVar.a(str, str2, str3, j, userAuthCallback, obj);
        return 0;
    }

    public static int getCurrentUserFreeFlowType() {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            return cVar.t();
        }
        return -1;
    }

    public static void setFreeFlowUser(int i) {
        if (com.subao.common.d.a("SubaoGame")) {
            Log.d("SubaoGame", "Free flow user: " + i);
        }
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.i(i);
        }
    }

    public static void onNetDelay(int i) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.d(i);
        }
    }

    public static void onNetDelayQuality4(float f2, float f3) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.a(f2, f3);
        }
    }

    public static String getMailAction(long j) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            return cVar.b(j);
        }
        Log.w("SubaoGame", "getMailAction EngineWrapper not init.");
        return null;
    }

    public static void setMailActionSuccess(int i, long j) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.a(i, j);
        } else {
            Log.w("SubaoGame", "setMailActionSuccess EngineWrapper not init.");
        }
    }

    public static void setMailAreadyRead(int i) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.f(i);
        } else {
            Log.w("SubaoGame", "setMailAreadyRead EngineWrapper not init.");
        }
    }

    public static void setMailConform(int i) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.g(i);
        } else {
            Log.w("SubaoGame", "setMailConform EngineWrapper not init.");
        }
    }

    public static void setGoActivity(int i) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.h(i);
        } else {
            Log.w("SubaoGame", "setGoActivity EngineWrapper not init.");
        }
    }

    public static int getAccelRecommendation() {
        com.subao.common.a.c cVar = f6138a;
        int u = cVar != null ? cVar.u() : -1;
        if (com.subao.common.d.a("SubaoGame")) {
            Log.d("SubaoGame", "getAccelRecommendation() return: " + u);
        }
        return u;
    }

    public static void setUdpEchoPort(int i) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.e(i);
        }
    }

    public static int getCurrentConnectionType() {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            return cVar.z();
        }
        return 0;
    }

    public static void addAccelAddress(String str, String str2, int i) {
        Log.d("SubaoGame", String.format(r.f6001a, "addAccelAddress(%s, %s, %d)", str, str2, Integer.valueOf(i)));
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.a(str, str2, i);
        }
    }

    public static void clearAccelAddresses() {
        Log.d("SubaoGame", "Clear all accelerate addresses");
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.B();
        }
    }

    public static void addLobbyAddress(String str, String str2, int i) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            Log.w("SubaoGame", "addLobbyAddress, EngineWrapper not init.");
        } else {
            cVar.b(str, str2, i);
        }
    }

    public static void addNewArenaAddress(String str, String str2, int i) {
        Log.d("SubaoGame", String.format(r.f6001a, "addNewArenaAddress(%s, %s, %d)", str, str2, Integer.valueOf(i)));
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.c(str, str2, i);
        }
    }

    public static void setUserRegion(int i) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            Log.w("SubaoGame", "setUserRegion, EngineWrapper not init.");
        } else {
            cVar.q(i);
        }
    }

    public static boolean isLobbyLinkProxy(String str, int i) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            Log.w("SubaoGame", "isLobbyLinkProxy, EngineWrapper not init.");
            return false;
        }
        return cVar.b(str, i).booleanValue();
    }

    public static void setProxyNodeList(String str) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            Log.w("SubaoGame", "setProxyNodeList, EngineWrapper not init.");
        } else {
            cVar.c(str);
        }
    }

    public static void setProxyPortList(String str) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            Log.w("SubaoGame", "setProxyPortList, EngineWrapper not init.");
        } else {
            cVar.d(str);
        }
    }

    public static void setEchoPortList(String str) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            Log.w("SubaoGame", "setEchoPortList, EngineWrapper not init.");
        } else {
            cVar.e(str);
        }
    }

    @Deprecated
    public static String getWebUIUrl() {
        return getWebUIUrl(0);
    }

    public static String getWebUIUrl(int i) {
        if (com.subao.common.d.a("SubaoGame")) {
            Log.d("SubaoGame", String.format(r.f6001a, "getWebUIUrl(%d)", Integer.valueOf(i)));
        }
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            return cVar.j(i);
        }
        return com.subao.common.a.c.a("", "");
    }

    public static String getServiceUrl() {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            return cVar.v();
        }
        return com.subao.common.a.c.a("", "");
    }

    @Deprecated
    public static void onNetDelayQuality2(float f2, float f3, float f4, float f5, float f6) {
        onNetDelayQuality3(f2, f3, f4, f5, f6, MidConstants.ERROR_ARGUMENT);
    }

    public static void onNetDelayQuality3(float f2, float f3, float f4, float f5, float f6, int i) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.a(f2, f3, f4, f5, f6, i);
        }
    }

    public static String getVIPValidTime() {
        String w;
        com.subao.common.a.c cVar = f6138a;
        return (cVar == null || (w = cVar.w()) == null) ? "" : w;
    }

    public static int getAccelerationStatus() {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            return cVar.x();
        }
        return 0;
    }

    public static String getUserConfig() {
        return k.f();
    }

    public static void gameForeground() {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.d(true);
        }
    }

    public static void gameBackground() {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.d(false);
        }
    }

    public static void setGameId(int i) {
        setGameId(Integer.toString(i));
    }

    public static void setGameId(String str) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.a(str);
        }
    }

    public static void setPlayerLevel(int i) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.k(i);
        }
    }

    public static void setRecommendationGameIP(String str, int i) {
        if (com.subao.common.d.a("SubaoGame")) {
            Log.d("SubaoGame", String.format(r.f6001a, "setRecommendationGameIP(%s, %d", str, Integer.valueOf(i)));
        }
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.a(str, i);
        }
    }

    public static String getAccelRecommendationData(int i) {
        if (com.subao.common.d.a("SubaoGame")) {
            Log.d("SubaoGame", String.format(r.f6001a, "getAccelRecommendationData(%d)", Integer.valueOf(i)));
        }
        com.subao.common.a.c cVar = f6138a;
        return cVar != null ? cVar.l(i) : "";
    }

    public static void onAccelRecommendationResult(int i, boolean z) {
        if (com.subao.common.d.a("SubaoGame")) {
            Log.d("SubaoGame", String.format(r.f6001a, "onAccelRecommendationResult(%d, %b)", Integer.valueOf(i), Boolean.valueOf(z)));
        }
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.a(i, z);
        }
    }

    public static void setWiFiAccelSwitch(boolean z) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.e(z);
        }
    }

    public static void enableWiFiAccelSwitch() {
        setWiFiAccelSwitch(true);
    }

    public static void beginRound(String str, String str2) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.c(str, str2);
        }
    }

    public static void setPayTypeWhiteList(String str) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.b(str);
        }
    }

    public static void setPayTypeWhiteList(int i) {
        if (i == 0) {
            setPayTypeWhiteList((String) null);
            return;
        }
        StringBuilder sb = new StringBuilder(6);
        for (int i2 = 0; i2 < 6; i2++) {
            if (((1 << i2) & i) != 0) {
                sb.append(i2);
            }
        }
        setPayTypeWhiteList(sb.toString());
    }

    public static List<String> getSupportGameList() {
        return getSupportGameList(false);
    }

    public static List<AppInfo> getSupportGameInfoList() {
        return getSupportGameInfoList(false);
    }

    public static List<String> getSupportGameList(boolean z) {
        return a(z, "getSupportGameList", new aq.c());
    }

    public static List<AppInfo> getSupportGameInfoList(boolean z) {
        return a(z, "getSupportGameInfoList", new aq.b());
    }

    private static <T> List<T> a(boolean z, String str, aq.a<T> aVar) {
        aq c2;
        com.subao.common.a.c cVar = f6138a;
        List<T> a2 = (cVar == null || (c2 = cVar.c(z)) == null) ? null : c2.a((aq.a) aVar, false);
        if (a2 == null) {
            a2 = new ArrayList<>();
        }
        if (com.subao.common.d.a("SubaoGame")) {
            Log.d("SubaoGame", String.format(r.f6001a, "%s(%b) return %d element(s)", str, Boolean.valueOf(z), Integer.valueOf(a2.size())));
        }
        return a2;
    }

    public static List<SupportGameLabel> getSupportGameLabelList() {
        com.subao.common.a.c cVar = f6138a;
        return cVar == null ? new ArrayList() : cVar.i();
    }

    public static boolean launcherGame(Context context, String str) {
        return com.subao.common.n.a.a(context, str);
    }

    public static void queryOriginUserState(UserInfo userInfo, long j, QueryOriginUserStateCallback queryOriginUserStateCallback, Object obj) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            queryOriginUserStateCallback.onOriginUserState(userInfo, obj, 1000, 0, null);
        } else {
            cVar.a(userInfo, j, queryOriginUserStateCallback, obj);
        }
    }

    public static long getLastServerTime() {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            return 0L;
        }
        return cVar.q();
    }

    @Deprecated
    public static void queryXunyouUserState(UserInfo userInfo, long j, XunyouUserStateCallback xunyouUserStateCallback, Object obj) {
        queryXunyouUserState(userInfo, j, xunyouUserStateCallback, obj, false);
    }

    public static void queryXunyouUserState(UserInfo userInfo, long j, XunyouUserStateCallback xunyouUserStateCallback, Object obj, boolean z) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            xunyouUserStateCallback.onXunyouUserState(userInfo, obj, 1000, 0, "");
        } else {
            cVar.a(userInfo, j, xunyouUserStateCallback, obj, z);
        }
    }

    @Deprecated
    public static void refreshXunyouUserState(long j, XunyouUserStateCallback xunyouUserStateCallback, Object obj) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.a(j, xunyouUserStateCallback, obj);
        } else if (xunyouUserStateCallback != null) {
            xunyouUserStateCallback.onXunyouUserState(null, obj, 1000, 0, "");
        }
    }

    public static byte[] getXunyouAccessToken() {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            return cVar.r();
        }
        return null;
    }

    public static void loginByXunyouToken(String str, byte[] bArr, XunyouTokenStateListener xunyouTokenStateListener) {
        com.subao.common.a.c cVar;
        if (bArr == null || bArr.length == 0 || (cVar = f6138a) == null) {
            return;
        }
        cVar.a(str, bArr, xunyouTokenStateListener);
    }

    public static void queryThirdPartyAuthInfo(UserInfo userInfo, long j, QueryThirdPartyAuthInfoCallback queryThirdPartyAuthInfoCallback) {
        if (queryThirdPartyAuthInfoCallback == null) {
            return;
        }
        if (userInfo == null || TextUtils.isEmpty(userInfo.getToken())) {
            queryThirdPartyAuthInfoCallback.onThirdPartyAuthInfoResult(1012, null);
            return;
        }
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            queryThirdPartyAuthInfoCallback.onThirdPartyAuthInfoResult(1000, null);
        } else {
            cVar.a(userInfo, (int) j, queryThirdPartyAuthInfoCallback);
        }
    }

    public static boolean requestTrial(RequestTrialCallback requestTrialCallback) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            return cVar.a(requestTrialCallback);
        }
        if (requestTrialCallback == null) {
            return false;
        }
        requestTrialCallback.onRequestTrialResult(1000);
        return false;
    }

    public static void queryProductList(QueryProductCallback queryProductCallback, boolean z) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.a(queryProductCallback, z);
        } else {
            queryProductCallback.onQueryProductResult(1000, null);
        }
    }

    public static void requestBuy(String str, String str2, int i, RequestBuyCallback requestBuyCallback) {
        int i2;
        if (requestBuyCallback == null) {
            throw new NullPointerException("Callback can not be null");
        }
        if (TextUtils.isEmpty(str2)) {
            i2 = 1012;
        } else if (i != 12) {
            i2 = 1011;
        } else {
            com.subao.common.a.c cVar = f6138a;
            if (cVar != null) {
                cVar.a(str, str2, i, requestBuyCallback);
                return;
            }
            i2 = 1000;
        }
        requestBuyCallback.onRequestBuyResult(i2, null);
    }

    public static void queryAvailableSignCoupons(QuerySignCouponsCallback querySignCouponsCallback) {
        if (querySignCouponsCallback == null) {
            return;
        }
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.a(querySignCouponsCallback);
        } else {
            querySignCouponsCallback.onQuerySignCouponsResult(1000, null);
        }
    }

    public static String getLocalIp() {
        com.subao.common.a.c cVar = f6138a;
        return cVar != null ? cVar.F() : "";
    }

    public static int getIOThreadID() {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            return cVar.G();
        }
        return 0;
    }

    static Pair<Integer, Integer> x1() {
        int a2;
        com.subao.common.a.c cVar = f6138a;
        int i = -1;
        if (cVar == null) {
            a2 = 1000;
        } else {
            try {
                i = cVar.s();
                a2 = 0;
            } catch (m.d e2) {
                a2 = e2.a();
            }
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(a2));
    }

    static void x2(String str, String str2) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            return;
        }
        cVar.b(str, str2);
    }

    static String x3(Context context) {
        com.subao.common.i.m mVar = new com.subao.common.i.m(context);
        StringWriter stringWriter = new StringWriter(ProgressEvent.PART_COMPLETED_EVENT_CODE);
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            try {
                mVar.serialize(jsonWriter);
                com.subao.common.e.a(jsonWriter);
                return stringWriter.toString();
            } catch (IOException e2) {
                e2.printStackTrace();
                com.subao.common.e.a(jsonWriter);
                return null;
            }
        } catch (Throwable th) {
            com.subao.common.e.a(jsonWriter);
            throw th;
        }
    }

    static void x4() {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            cVar.A();
        }
    }

    static r.a a(String str) {
        if (ServerProtocol.DIALOG_PARAM_SDK_VERSION.equals(str)) {
            return r.a.SDK;
        }
        if ("rom".equals(str)) {
            return r.a.ROM;
        }
        return r.a.SERVICE;
    }

    static File x8(Context context) {
        com.subao.common.f.a.a(context, r.a.SDK);
        return com.subao.common.f.a.a();
    }

    static void x9(String str, final I1 i1) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar != null) {
            v.a k = cVar.k();
            com.subao.common.e.h.a(k.f6011a, k.c, str, new h.a() { // from class: com.subao.gamemaster.GameMaster.1
                @Override // com.subao.common.e.h.a
                public void a(boolean z) {
                    I1.this.a(z);
                }
            });
        } else {
            i1.a(false);
        }
    }

    static Object x10(Context context, I2 i2) {
        com.subao.common.j.r rVar = new com.subao.common.j.r(new e(i2));
        rVar.a(context);
        return rVar;
    }

    static void x11(Object obj) {
        ((q) obj).a();
    }

    static String x12(String str) {
        c cVar = new c();
        com.subao.common.j.e.a(str, cVar, (Object) null, com.subao.common.e.f.a(f.g.DRONE));
        e.c a2 = cVar.a();
        return a2 != null ? a2.toString() : "fail";
    }

    static int x13(int i) {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            return 1000;
        }
        return cVar.c(i);
    }

    static void xy(Context context, String str) {
        ao.b().b((String) null);
        com.subao.common.f.a.a(context, a(str));
        File a2 = com.subao.common.f.a.a();
        File[] listFiles = a2.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
        a2.delete();
    }

    /* loaded from: classes2.dex */
    static class e implements q.a {

        /* renamed from: a, reason: collision with root package name */
        private final I2 f6143a;

        e(I2 i2) {
            this.f6143a = i2;
        }

        @Override // com.subao.common.j.q.a
        public void a(int i) {
            this.f6143a.a(i);
        }
    }

    /* loaded from: classes2.dex */
    private static class c extends ConditionVariable implements e.a {

        /* renamed from: a, reason: collision with root package name */
        private e.c f6141a;

        private c() {
        }

        @Override // com.subao.common.j.e.a
        public void a(Object obj, e.c cVar) {
            this.f6141a = cVar;
            open();
        }

        public e.c a() {
            block();
            return this.f6141a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class f implements e.a {
        f() {
        }

        @Override // com.subao.common.a.e.a
        public com.subao.common.a.e a() {
            return GameMasterVpnService.c();
        }

        @Override // com.subao.common.a.e.a
        public boolean a(Context context) {
            return GameMasterVpnService.b(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        public final String f6144a;
        public final String b;

        private g(String str, String str2) {
            this.f6144a = str;
            this.b = str2;
        }

        static g a(String str, String str2) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            return new g(str, str2);
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return com.subao.common.e.a(gVar.f6144a, this.f6144a) && com.subao.common.e.a(gVar.b, this.b);
        }

        public int hashCode() {
            return this.f6144a.hashCode() ^ this.b.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final Context f6142a;
        final String b;
        final r.a c;
        final com.subao.common.g.a d;
        final String e;
        final int f;
        final byte[] g;
        final com.subao.common.a.c h;
        final boolean i;
        final a j;

        d(Context context, String str, r.a aVar, com.subao.common.g.a aVar2, String str2, int i, byte[] bArr, com.subao.common.a.c cVar, boolean z, a aVar3) {
            this.f6142a = context;
            this.b = str;
            this.c = aVar;
            this.d = aVar2;
            this.e = str2;
            this.f = i;
            this.g = bArr;
            this.h = cVar;
            this.i = z;
            this.j = aVar3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            int a2;
            Context context2 = this.f6142a;
            if (context2 == null) {
                Context a3 = this.j.a();
                if (a3 == null) {
                    a2 = -4;
                    this.j.onSDKInitCompleted(a2);
                }
                context = a3;
            } else {
                context = context2;
            }
            a2 = GameMaster.a(context, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
            this.j.onSDKInitCompleted(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        private final g f6140a;

        public b(g gVar) {
            this.f6140a = gVar;
        }

        @Override // com.subao.gamemaster.GameMaster.a
        public Context a() {
            return new com.subao.gamemaster.a().a();
        }

        @Override // com.subao.common.intf.AsyncInitCallback
        public void onSDKInitCompleted(int i) {
            Log.d("SubaoGame", String.format(r.f6001a, "Notify U3D observer: %s.%s(%d) result %b", this.f6140a.f6144a, this.f6140a.b, Integer.valueOf(i), Boolean.valueOf(new com.subao.gamemaster.a().a(this.f6140a.f6144a, this.f6140a.b, String.format(r.f6001a, "%d", Integer.valueOf(i))))));
        }
    }

    public static String getUserContractInfo() {
        com.subao.common.a.c cVar = f6138a;
        if (cVar == null) {
            return null;
        }
        return cVar.I();
    }

    public static String getXunyouUserID() {
        return com.subao.common.a.c.H();
    }
}
