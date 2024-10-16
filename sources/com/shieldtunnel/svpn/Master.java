package com.shieldtunnel.svpn;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.shieldtunnel.svpn.common.LogTag;
import com.shieldtunnel.svpn.common.d.a;
import com.shieldtunnel.svpn.common.f.f;
import com.shieldtunnel.svpn.common.intf.AsyncInitCallback;
import com.shieldtunnel.svpn.common.intf.NodeDetectCallback;
import com.shieldtunnel.svpn.common.intf.NodeInfo;
import com.shieldtunnel.svpn.common.intf.TunnelEventListener;
import com.shieldtunnel.svpn.common.intf.VPNStateListener;
import com.shieldtunnel.svpn.common.intf.VpnServiceStrategy;
import com.shieldtunnel.svpn.common.k.e;
import java.io.File;
import java.util.List;

/* loaded from: classes2.dex */
public class Master {
    public static final String BUILD_TIME = "20200723_094319";
    public static final String COMMIT_ID = "ffba34e6e09dad00d90f3f5463d66e966e41c41b";
    public static final String U3D_METHOD_NAME_INIT_COMPLETED = "onSVPNInitCompleted";
    public static final String VERSION_NAME = "1.3.6";
    private static String b;
    static final /* synthetic */ boolean d = !Master.class.desiredAssertionStatus();

    /* renamed from: a, reason: collision with root package name */
    private static volatile com.shieldtunnel.svpn.common.d.a f5769a = new com.shieldtunnel.svpn.common.d.b(false);
    private static final com.shieldtunnel.svpn.a c = new com.shieldtunnel.svpn.a();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a extends AsyncInitCallback {
        Context a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b implements a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f5770a;
        private final AsyncInitCallback b;

        b(Context context, AsyncInitCallback asyncInitCallback) {
            this.f5770a = context;
            this.b = asyncInitCallback;
        }

        @Override // com.shieldtunnel.svpn.Master.a
        public Context a() {
            return this.f5770a;
        }

        @Override // com.shieldtunnel.svpn.common.intf.AsyncInitCallback
        public void onSDKInitCompleted(int i) {
            this.b.onSDKInitCompleted(i);
        }
    }

    /* loaded from: classes2.dex */
    private static class c implements a {

        /* renamed from: a, reason: collision with root package name */
        final String f5771a;

        c(String str) {
            this.f5771a = str;
        }

        @Override // com.shieldtunnel.svpn.Master.a
        public Context a() {
            return new com.shieldtunnel.svpn.b().a();
        }

        @Override // com.shieldtunnel.svpn.common.intf.AsyncInitCallback
        public void onSDKInitCompleted(int i) {
            Log.d(LogTag.MAIN, String.format(f.b, "Notify U3D observer: %s.%s(%d) result %b", this.f5771a, Master.U3D_METHOD_NAME_INIT_COMPLETED, Integer.valueOf(i), Boolean.valueOf(new com.shieldtunnel.svpn.b().a(this.f5771a, Master.U3D_METHOD_NAME_INIT_COMPLETED, String.format(f.b, "%d", Integer.valueOf(i))))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final String f5772a;
        final String b;
        final a c;

        d(String str, String str2, a aVar) {
            this.f5772a = str;
            this.b = str2;
            this.c = aVar;
        }

        private int a() {
            Context a2 = this.c.a();
            if (a2 == null) {
                return 1012;
            }
            return Master.b(a2, this.f5772a, this.b);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.onSDKInitCompleted(a());
            Master.c.a();
        }
    }

    private Master() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Context context, String str, String str2) {
        Log.i(LogTag.MAIN, String.format("Master %s (%s) commit-id: %s", VERSION_NAME, BUILD_TIME, COMMIT_ID));
        if (TextUtils.isEmpty(str)) {
            Log.e(LogTag.MAIN, "Null guid, init failed");
            return 1012;
        }
        synchronized (Master.class) {
            int d2 = f5769a.d();
            if (d2 != 0) {
                return d2;
            }
            com.shieldtunnel.svpn.common.d.c cVar = new com.shieldtunnel.svpn.common.d.c(context, str, str2, VERSION_NAME, com.shieldtunnel.svpn.common.f.d.ANDROID_SDK, new com.shieldtunnel.svpn.common.jni.b(), null);
            f5769a = cVar;
            int g = cVar.g();
            if (g != 0) {
                cVar.c();
                f5769a = new com.shieldtunnel.svpn.common.d.b(true);
            }
            return g;
        }
    }

    private static String c(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static int dialUp(String str) {
        return dialUpByRegion(str);
    }

    public static int dialUpByIdList(String str) {
        return a("dialUpByIdList", f5769a.a(str, a.EnumC0148a.ID_LIST));
    }

    public static int dialUpByRegion(String str) {
        return a("dialUpByRegion", f5769a.a(str, a.EnumC0148a.REGION));
    }

    public static int getJNIBits() {
        return f5769a.e();
    }

    public static int getNodeInfoList(List<NodeInfo> list) {
        return a("getNodeInfoList", f5769a.a(list));
    }

    public static int getNodeRegionList(List<String> list) {
        return a("getNodeRegionList", f5769a.b(list));
    }

    public static int hangUp() {
        return a("hangUp", f5769a.a());
    }

    public static int init(Context context, String str, String str2) {
        c cVar;
        String str3 = b;
        if (str3 != null) {
            cVar = new c(str3);
        } else {
            if (context == null) {
                return a(1012);
            }
            cVar = null;
        }
        return a(a(context, str, str2, cVar));
    }

    public static int setAuthenticationInfo(String str, String str2, String str3) {
        return a("setAuthenticationInfo", f5769a.a(str, str2, str3));
    }

    public static int setNodeList(String str) {
        return a("setNodeList", f5769a.a(str));
    }

    public static int setNodePortRange(int i, int i2) {
        return a("setNodePortRange", f5769a.a(i, i2));
    }

    public static int setTunnelEventListener(TunnelEventListener tunnelEventListener) {
        return a("setTunnelEventListener", f5769a.a(tunnelEventListener));
    }

    public static void setU3DObserver(String str) {
        Log.d(LogTag.MAIN, String.format("setU3DObserver(%s)", str));
        b = str;
    }

    public static int setVPNStateListener(VPNStateListener vPNStateListener) {
        return a("setVPNStateListener", f5769a.a(vPNStateListener));
    }

    public static boolean setVpnServiceStrategy(String str, Object obj) {
        boolean a2 = a(str, obj);
        Log.d(LogTag.MAIN, String.format("setVpnServiceStrategy(%s, %s) return %b", e.a((Object) str), e.a(obj), Boolean.valueOf(a2)));
        return a2;
    }

    public static int startNodeDetect(String str, NodeDetectCallback nodeDetectCallback) {
        return a("startNodeDetect", f5769a.a(str, nodeDetectCallback));
    }

    public static int tearDown() {
        int c2 = f5769a.c();
        if (c2 == 0) {
            synchronized (Master.class) {
                f5769a = new com.shieldtunnel.svpn.common.d.b(true);
            }
        }
        return a("tearDown", c2);
    }

    static int xx(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return 1012;
        }
        return f5769a.a(str, str2);
    }

    static void xy(Context context) {
        File a2 = com.shieldtunnel.svpn.common.g.a.a(context);
        if (a2.isDirectory() && a2.exists()) {
            File[] listFiles = a2.listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    file.delete();
                }
            }
            a2.delete();
        }
    }

    static int xz(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return 1012;
        }
        return f5769a.a(str, (Object) str2);
    }

    private static int a(String str, int i) {
        Log.d(LogTag.MAIN, String.format(f.f5810a, "Master.%s() return: %d", str, Integer.valueOf(i)));
        return i;
    }

    public static String getNodeRegionList() {
        String b2 = f5769a.b();
        Log.d(LogTag.MAIN, String.format(f.b, "Master.getNodeRegionList() return length: %d", Integer.valueOf(b2.length())));
        return b2;
    }

    private static int a(int i) {
        return a("init", i);
    }

    private static int a(Context context, String str, String str2, a aVar) {
        c.b();
        if (aVar == null) {
            if (!d && context == null) {
                throw new AssertionError();
            }
            int b2 = b(context, str, str2);
            c.a();
            return b2;
        }
        new Thread(new d(str, str2, aVar)).start();
        return 0;
    }

    public static int init(Context context, String str, String str2, AsyncInitCallback asyncInitCallback) {
        if (context != null && !TextUtils.isEmpty(str)) {
            Context applicationContext = context.getApplicationContext();
            return a(a(applicationContext, str, str2, asyncInitCallback == null ? null : new b(applicationContext, asyncInitCallback)));
        }
        if (asyncInitCallback != null) {
            asyncInitCallback.onSDKInitCompleted(1012);
        }
        return a(1012);
    }

    private static boolean a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (VpnServiceStrategy.Name.START_COMMAND_RESULT.equalsIgnoreCase(str)) {
                VpnServiceStrategy.startCommandResult = b(obj);
                return true;
            }
            if (VpnServiceStrategy.Name.FILTER_MODE.equalsIgnoreCase(str)) {
                VpnServiceStrategy.appFilterMode = b(obj);
                return true;
            }
            if (VpnServiceStrategy.Name.ALLOW_SYSTEM_UI.equalsIgnoreCase(str)) {
                VpnServiceStrategy.allowSystemUi = a(obj);
                return true;
            }
            if (VpnServiceStrategy.Name.IP_VERSION_SUPPORT.equalsIgnoreCase(str)) {
                VpnServiceStrategy.ipVersionSupport = b(obj);
                return true;
            }
            if (VpnServiceStrategy.Name.ICON_RES_ID.equalsIgnoreCase(str)) {
                VpnServiceStrategy.iconResId = b(obj);
                return true;
            }
            if (VpnServiceStrategy.Name.SESSION_NAME.equalsIgnoreCase(str)) {
                VpnServiceStrategy.sessionName = c(obj);
                return true;
            }
            if (!"description".equalsIgnoreCase(str)) {
                return false;
            }
            VpnServiceStrategy.description = c(obj);
            return true;
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Integer b(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return Integer.valueOf(Integer.parseInt(obj.toString()));
        }
        return (Integer) obj;
    }

    private static boolean a(Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                return Boolean.parseBoolean(obj.toString());
            }
            return ((Boolean) obj).booleanValue();
        }
        throw new IllegalArgumentException();
    }
}
