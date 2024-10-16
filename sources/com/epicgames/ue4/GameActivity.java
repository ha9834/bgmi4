package com.epicgames.ue4;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NativeActivity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.VpnService;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.provider.Settings;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputMethodManager;
import android.webkit.JavascriptInterface;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.app.k;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.Constants;
import com.b.a.a;
import com.epicgames.ue4.GooglePlayStoreHelper;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.security.CertificateUtil;
import com.gcloudsdk.apollo.ApolloVoiceLog;
import com.gcloudsdk.gcloud.voice.GCloudVoiceEngine;
import com.gcloudsdk.gcloud.voice.GCloudVoiceEngineHelper;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.games.Games;
import com.google.android.gms.plus.Plus;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.vr.sdk.samples.permission.PermissionHelper;
import com.intlgame.INTLApp;
import com.pubg.imobile.DownloaderActivity;
import com.shieldtunnel.svpn.Master;
import com.shieldtunnel.svpn.common.intf.TunnelEventListener;
import com.subao.gamemaster.GameMaster;
import com.tencent.crashsight.core.api.CrashSightPlatform;
import com.tencent.gcloud.GCloud;
import com.tencent.gcloud.qr.QRCodeAPI;
import com.tencent.grobot.lite.GRobot;
import com.tencent.grobot.lite.jni.JNIManager;
import com.tencent.grobot.lite.presenter.PresenterCode;
import com.tencent.gsdk.api.GSDKPlatform;
import com.tencent.hawk.bridge.HawkAgent;
import com.tencent.ieg.gpc.globalization.ue4.UploaderHelper;
import com.tencent.imsdk.android.api.lbs.IMSDKLbs;
import com.tencent.imsdk.android.api.login.IMSDKLogin;
import com.tencent.imsdk.android.api.notice.IMSDKNotice;
import com.tencent.imsdk.android.api.relation.IMSDKFriend;
import com.tencent.imsdk.android.api.stat.IMSDKStat;
import com.tencent.imsdk.android.api.unifiedaccount.IMSDKUnifiedAccount;
import com.tencent.imsdk.android.api.webview.IMSDKWebView;
import com.tencent.imsdk.android.base.interfaces.IStat;
import com.tencent.imsdk.android.extend.adjust.AdjustExtend;
import com.tencent.imsdk.android.extend.admob.AdmobExtend;
import com.tencent.imsdk.android.tools.UrlUtils;
import com.tencent.imsdk.android.tools.log.LogUtils;
import com.tencent.ipubgm.AndroidUtil;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;
import com.tencent.quantum.FirebasePush;
import com.tencent.quantum.GameProcessUtility;
import com.tencent.quantum.QuantumFirebaseRemoteConfig;
import com.tencent.quantum.download.GCBGDownloadInitData;
import com.tencent.quantum.download.GCBGDownloadService;
import com.tencent.quantum.mtr.NetTrace;
import com.tencent.tdm.TDataMaster;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class GameActivity extends NativeActivity implements SensorEventListener, SurfaceHolder.Callback2, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
    public static final String CLASS_DISPLAY_CUTOUT = "android.view.DisplayCutout";
    private static final String CPU_ARCHITECTURE_KEY_64 = "ro.product.cpu.abilist64";
    public static final String CPU_ARCHITECTURE_TYPE_32 = "32";
    public static final String CPU_ARCHITECTURE_TYPE_64 = "64";
    private static final String DIALOG_ERROR = "dialog_error";
    public static final int DOWNLOAD_ACTIVITY_ID = 80001;
    public static final int DOWNLOAD_COMPLETED_OK = 2;
    public static final int DOWNLOAD_FAILED = 4;
    public static final int DOWNLOAD_FILES_PRESENT = 1;
    public static final int DOWNLOAD_INVALID = 5;
    public static final int DOWNLOAD_NO_PLAY_KEY = 6;
    public static final int DOWNLOAD_NO_RETURN_CODE = 0;
    public static final String DOWNLOAD_RETURN_NAME = "Result";
    public static final int DOWNLOAD_USER_QUIT = 3;
    private static final int EI_CLASS = 4;
    private static final int ELFCLASS32 = 1;
    private static final int ELFCLASS64 = 2;
    public static final String FIELD_GET_SAFE_INSET_LEFT = "getSafeInsetLeft";
    public static final String FIELD_GET_SAFE_INSET_RIGHT = "getSafeInsetRight";
    private static final int GOOGLE_SERVICES_REQUEST_RESOLVE_ERROR = 1001;
    public static final String METHOD_GET_DISPLAY_CUTOUT = "getDisplayCutout";
    public static final int NOTCH_IN_SCREEN_VOIO = 32;
    private static final int PLAY_SERVICES_DIALOG_ID = 1;
    private static final String PROC_CPU_INFO_PATH = "/proc/cpuinfo";
    public static final int ROUNDED_IN_SCREEN_VOIO = 8;
    private static final String SYSTEM_LIB_C_PATH = "/system/lib/libc.so";
    private static final String SYSTEM_LIB_C_PATH_64 = "/system/lib64/libc.so";
    static final float SampleDecayRate = 0.85f;
    static GameActivity _activity = null;
    static Bundle _bundle = null;
    static ClipboardManager _clipboardManager = null;
    static Bundle _extraBundle = null;
    private static List<String> aJavicBaba = null;
    public static final int lastVirtualKeyboardCommandDelay = 200;
    private static final String tag = "GCloud";
    private AssetManager AssetManagerReference;
    private int BrightnessMode;
    private String[] CachedQueryProductIDs;
    private StoreHelper IapStoreHelper;
    private SurfaceView MySurfaceView;
    private Handler OrientationHandler;
    private OrientationSensorListener OrientationListener;
    private Sensor OrientationSensor;
    private PowerManager.WakeLock PMWakeLock;
    private Sensor accelerometer;
    LinearLayout activityLayout;
    private LinearLayout adLayout;
    private PopupWindow adPopupWindow;
    private AdView adView;
    private boolean bKeyboardShowing;
    private ConnectivityManager cm;
    AlertDialog consoleAlert;
    LinearLayout consoleAlertLayout;
    ConsoleCmdReceiver consoleCmdReceiver;
    ConsoleKeyboardInput consoleInputBox;
    Spinner consoleSpinner;
    private FrameLayout containerFrameLayout;
    private GoogleApiClient googleClient;
    private Sensor gyroscope;
    private InterstitialAd interstitialAd;
    private AdRequest interstitialAdRequest;
    private String mCurrentTopic;
    private FirebaseAnalytics mFirebaseAnalytics;
    protected Dialog mSplashDialog;
    private Sensor magnetometer;
    private View mainDecorView;
    private Rect mainDecorViewRect;
    private View mainView;
    NetWorkInfoReceiver netReceive;
    VirtualKeyboardInput newVirtualKeyboardInput;
    private SensorManager sensorManager;
    private Handler showWindowImeHandler;
    AlertDialog virtualKeyboardAlert;
    private Handler virtualKeyboardHandler;
    EditText virtualKeyboardInputBox;
    String virtualKeyboardInputContent;
    int virtualKeyboardInputType;
    private LinearLayout virtualKeyboardLayout;
    String virtualKeyboardPreviousContents;
    static float[] last_accelerometer = {0.0f, 0.0f, 0.0f};
    static float[] last_magnetometer = {0.0f, 0.0f, 0.0f};
    static float[] last_gyroscope = {0.0f, 0.0f, 0.0f};
    static float[] last_tilt = {0.0f, 0.0f, 0.0f};
    static float[] last_gravity = {0.0f, 0.0f, 0.0f};
    static float[] last_acceleration = {0.0f, 0.0f, 0.0f};
    static boolean first_acceleration_sample = true;
    public static Logger Log = new Logger("UE4");
    public static VirtualKeyboardCommand lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_NONE;
    private static final String[] CONSOLE_SPINNER_ITEMS = {"Common Console Commands", "stat FPS", "stat Anim", "stat OpenGLRHI", "stat VulkanRHI", "stat DumpEvents", "stat DumpFrame", "stat DumpHitches", "stat Engine", "stat Game", "stat Grouped", "stat Hitches", "stat InitViews", "stat LightRendering", "stat Memory", "stat Particles", "stat SceneRendering", "stat SceneUpdate", "stat ShadowRendering", "stat Slow", "stat Streaming", "stat StreamingDetails", "stat Unit", "stat UnitGraph", "stat StartFile", "stat StopFile", "memreport -full", "GameVer", "show PostProcessing", "LuaDoString ShowGM()", "stat AndroidCPU", "showflag.screensizeculledprimitives 0", "showflag.screensizeculledprimitives 1"};
    public static final boolean bSamsungDevice = Build.MANUFACTURER.equals("samsung");
    public static final boolean bVivoDevice = Build.MANUFACTURER.equals("vivo");
    private static int PackageDataInsideApkValue = -1;
    private static int HasOBBFiles = -1;
    private static String appPackageName = "";
    public static final int ANDROID_BUILD_VERSION = Build.VERSION.SDK_INT;
    public static boolean vlinkHasInit = false;
    private static final DeviceInfoData[] DeviceInfoList = {new DeviceInfoData(1256, 40960, "Samsung Game Pad EI-GP20"), new DeviceInfoData(2389, 29187, "NVIDIA Corporation NVIDIA Controller v01.01"), new DeviceInfoData(2389, 29200, "NVIDIA Corporation NVIDIA Controller v01.03"), new DeviceInfoData(6473, 1028, "Amazon Fire TV Remote"), new DeviceInfoData(6473, 1030, "Amazon Fire Game Controller"), new DeviceInfoData(1848, 21091, "Mad Catz C.T.R.L.R (Smart)"), new DeviceInfoData(1848, 21094, "Mad Catz C.T.R.L.R"), new DeviceInfoData(1118, 736, "Xbox Wireless Controller"), new DeviceInfoData(273, 5145, "SteelSeries Stratus XL"), new DeviceInfoData(1356, 1476, "PS4 Wireless Controller")};
    private static boolean LOGENABLE = false;
    private boolean RegisterSensorListener = false;
    private boolean EnableSensorManager = true;
    private Object SyncSensorDataObject = new Object();
    private boolean RegisterOrientationSensorListener = false;
    private boolean EnableOrientationSensorManager = false;
    private final float[] rotationMatrix = new float[9];
    private final float[] orientationAngles = new float[3];
    private int noActionAnimID = -1;
    int DepthBufferPreference = 0;
    private boolean HasAllFiles = false;
    public boolean VerifyOBBOnStartUp = false;
    private boolean UseExternalFilesDir = false;
    private boolean InitCompletedOK = false;
    private boolean ShouldHideUI = false;
    private boolean IsForDistribution = false;
    private String BuildConfiguration = "";
    private boolean IsInVRMode = false;
    GooglePlayStoreHelper.PurchaseLaunchCallback purchaseLaunchCallback = null;
    private boolean bUseSurfaceView = false;
    private int DesiredHolderWidth = 0;
    private int DesiredHolderHeight = 0;
    private int VulkanVersion = 0;
    private int VulkanLevel = 0;
    private boolean localNotificationAppLaunched = false;
    private String localNotificationLaunchActivationEvent = "";
    private int localNotificationLaunchFireDate = 0;
    public int DeviceRotation = -1;
    private EAlertDialogType CurrentDialogType = EAlertDialogType.None;
    IntentFilter filter = new IntentFilter();
    int CheckHarmonyOSStatus = -1;
    private boolean adInit = false;
    private int adGravity = 48;
    private boolean isInterstitialAdLoaded = false;
    private boolean isInterstitialAdRequested = false;
    private boolean adWantsToBeShown = false;
    private boolean adIsAvailable = false;
    private boolean adIsRequested = false;
    private Handler mRestoreImmersiveModeHandler = new Handler();
    private Runnable restoreImmersiveModeRunnable = new Runnable() { // from class: com.epicgames.ue4.GameActivity.16
        @Override // java.lang.Runnable
        public void run() {
            GameActivity.this.restoreTransparentBars();
        }
    };

    /* loaded from: classes.dex */
    enum EAlertDialogType {
        None,
        Console,
        Keyboard
    }

    /* loaded from: classes.dex */
    public enum VirtualKeyboardCommand {
        VK_CMD_NONE,
        VK_CMD_SHOW,
        VK_CMD_HIDE
    }

    public static native void onTunnelEvent(String str, int i);

    public int AndroidThunkJava_GetDCLS() {
        return 0;
    }

    public void AndroidThunkJava_PutKVD(String str, double d) {
    }

    public void AndroidThunkJava_PutKVI(String str, int i) {
    }

    public void AndroidThunkJava_PutKVS(String str, String str2) {
    }

    @JavascriptInterface
    public void jsCallNative(String str) {
    }

    public native void nativeConsoleCommand(String str);

    public native void nativeGoogleClientConnectCompleted(boolean z, String str);

    public native void nativeHandleSensorEvents(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4);

    public native void nativeInitHMDs();

    public native boolean nativeIsShippingBuild();

    public native void nativeOnActivityResult(GameActivity gameActivity, int i, int i2, Intent intent);

    public native void nativeOnConfigurationChanged(boolean z);

    public native void nativeOnDeviceRotationChanged(int i);

    public native void nativeOnNewIntent();

    public native void nativeOnRequestPermissionsResult(GameActivity gameActivity, int i, String str, String str2);

    public native void nativeOnSubscribeToTopicSuccess(String str, boolean z);

    public native void nativeResumeMainInit();

    public native void nativeSetAndroidVersionInformation(String str, String str2, String str3, String str4);

    public native void nativeSetGlobalActivity(boolean z, boolean z2, String str);

    public native void nativeSetObbInfo(String str, String str2, int i, int i2);

    public native void nativeSetSensorAvailability(boolean z, boolean z2, boolean z3);

    public native void nativeSetSurfaceViewInfo(int i, int i2);

    public native void nativeSetWindowInfo(boolean z, int i);

    public native void nativeVirtualKeyboardChanged(String str);

    public native void nativeVirtualKeyboardHide();

    public native void nativeVirtualKeyboardResult(boolean z, String str);

    public native void nativeVirtualKeyboardSendKey(int i);

    public native void nativeVirtualKeyboardShown(int i, int i2, int i3, int i4);

    public native void nativeVirtualKeyboardVisible(boolean z);

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    static {
        System.loadLibrary("gnustl_shared");
        try {
            System.loadLibrary("gcloudcore");
        } catch (UnsatisfiedLinkError e) {
            Log.debug(e.toString());
            Log.debug("gcloudcore library not loaded and required!");
        }
        try {
            System.loadLibrary("TDataMaster");
        } catch (UnsatisfiedLinkError e2) {
            Log.debug(e2.toString());
            Log.debug("TDataMaster library not loaded and required!");
        }
        try {
            System.loadLibrary("gcloud");
        } catch (UnsatisfiedLinkError e3) {
            Log.debug(e3.toString());
            Log.debug("GCloud library not loaded and required!");
        }
        try {
            System.loadLibrary("anogs");
        } catch (UnsatisfiedLinkError e4) {
            Log.debug(e4.toString());
            Log.debug("Tss tersafe library not loaded and required!");
        }
        try {
            System.loadLibrary("GCloudVoice");
        } catch (UnsatisfiedLinkError e5) {
            Log.debug(e5.toString());
            Log.debug("gcloudvoice library not loaded and required!");
        }
        try {
            System.loadLibrary("helpshiftlistener");
        } catch (UnsatisfiedLinkError e6) {
            Log.debug(e6.toString());
            Log.debug("helpshiftlistener library not loaded and required!");
        }
        try {
            System.loadLibrary("ITOP");
        } catch (UnsatisfiedLinkError e7) {
            Log.debug(e7.toString());
            Log.debug("IMSDK library not loaded and required!");
        }
        try {
            System.loadLibrary("igshare");
        } catch (UnsatisfiedLinkError e8) {
            Log.debug(e8.toString());
            Log.debug("igshare library not loaded and required!");
        }
        System.loadLibrary("UE4");
        aJavicBaba = new ArrayList();
    }

    public boolean IsInVRMode() {
        return this.IsInVRMode;
    }

    public GooglePlayStoreHelper.PurchaseLaunchCallback getPurchaseLaunchCallback() {
        return this.purchaseLaunchCallback;
    }

    public static GameActivity Get() {
        return _activity;
    }

    public void GEM_SetControlAddressUrl(String str) {
        GSDKPlatform.GSDKSetControlAddressUrl(str);
    }

    public void GEM_Init(String str, boolean z, int i) {
        GSDKPlatform.GSDKInit(this, str, z, i);
    }

    public void GEM_SetEvent(int i, boolean z, String str, boolean z2, boolean z3) {
        GSDKPlatform.GSDKSetEvent(i, z, str, z2, z3);
    }

    public void GEM_Start(String str, String str2, String str3) {
        GSDKPlatform.GSDKStart(str, str2, str3);
    }

    public void GEM_SetUserName(int i, String str) {
        GSDKPlatform.GSDKSetUserName(i, str);
    }

    public void GEM_SaveFps(float f, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str) {
        GSDKPlatform.GSDKSaveFps(f, i, i2, i3, i4, i5, i6, i7, i8, i9, str);
    }

    public void GEM_SaveGpuInfo(String str) {
        GSDKPlatform.GSDKSaveGpuInfo(str);
    }

    public void GEM_End() {
        GSDKPlatform.GSDKEnd();
    }

    public void GEM_SetPayEvent(int i, int i2, boolean z, String str) {
        GSDKPlatform.GSDKSetPayEvent(i, i2, z, str);
    }

    public void GEM_TimeOutDetect() {
        GSDKPlatform.GSDKTimeOutDetect();
    }

    public void GEM_ReportEvent(String str, Map<String, String> map) {
        GSDKPlatform.GSDKReportEvent(str, map);
    }

    public Map<String, String> createMap(int i) {
        return new HashMap(i);
    }

    public void AndroidThunkJava_InitContext(String str) {
        HawkAgent.initContext(this, str);
    }

    public void AndroidThunkJava_SetUserId(String str) {
        HawkAgent.setUserId(str);
    }

    public void AndroidThunkJava_MarkLevelLoad(String str, int i) {
        HawkAgent.markLevelLoad(str, i);
    }

    public void AndroidThunkJava_MarkLevelLoadCompleted() {
        HawkAgent.markLevelLoadCompleted();
    }

    public void AndroidThunkJava_MarkLevelFin() {
        HawkAgent.markLevelFin();
    }

    public void AndroidThunkJava_PostNTL(int i, int i2) {
        HawkAgent.postNTL(i, i2);
    }

    public void AndroidThunkJava_EnableDebugMode() {
        HawkAgent.enableDebugMode();
    }

    public void AndroidThunkJava_BeginTag(String str) {
        HawkAgent.beginTag(str);
    }

    public void AndroidThunkJava_EndTag() {
        HawkAgent.endTag();
    }

    public int AndroidThunkJava_GetDCLSByQcc(String str, String str2) {
        return HawkAgent.checkDCLSByQcc(str, str2, str2);
    }

    public void AndroidThunkJava_RegisterCallBackMeta(String str, String str2) {
        HawkAgent.setUserIdenForUE4(str, str2);
    }

    public void AndroidThunkJava_UpdateGameStatusToVmp(int i, String str) {
        HawkAgent.updateGameStatusToVmp(i, str);
    }

    public void AndroidThunkJava_RequestResourceGuarantee(int i, int i2, int i3) {
        HawkAgent.requestResourceGuarantee(i, i2, i3);
    }

    public void AndroidThunkJava_AsyncCheckCCQuality() {
        HawkAgent.ayncFetchQccQuality();
    }

    public void AndroidThunkJava_processAffinitySettingForThread(int i, int i2) {
        HawkAgent.processAffinitySetting(i, i2);
    }

    public void AndroidThunkJava_setTargetFramerate(int i) {
        HawkAgent.setTargetFramerate(i);
    }

    public void AndroidThunkJava_setLocale(String str) {
        HawkAgent.setLocale(str, 1);
    }

    public void AndroidThunkJava_setQuality(int i) {
        HawkAgent.setGlobalQuality(i);
    }

    public void AndroidThunkJava_postLagStatus(float f) {
        HawkAgent.postLagState(f);
    }

    public void AndroidThunkJava_markAppFinishLaunch() {
        HawkAgent.markAppFinishLaunch();
    }

    public void AndroidThunkJava_postEvent(int i, String str) {
        HawkAgent.postEvent(i, str);
    }

    public void AndroidThunkJava_setVersionIden(String str) {
        HawkAgent.setVersionIden(str);
    }

    public void AndroidThunkJava_setPssManualMode() {
        HawkAgent.setPssManualMode();
    }

    public void AndroidThunkJava_requestPssSample() {
        HawkAgent.requestPssSample();
    }

    public void AndroidThunkJava_postFrame(float f) {
        HawkAgent.postFrame(f);
    }

    public String AndroidThunkJava_validateDevice() {
        return HawkAgent.checkDeviceIsReal();
    }

    public void AndroidThunkJava_postStreamEvent(int i, int i2, int i3, String str) {
        HawkAgent.postStreamEvent(i, i2, i3, str);
    }

    public void AndroidThunkJava_postTrackState(float f, float f2, float f3, float f4, float f5, float f6) {
        HawkAgent.postTrackState(f, f2, f3, f4, f5, f6);
    }

    public void AndroidThunkJava_initTGPA() {
        HawkAgent.initTGPA();
    }

    public void AndroidThunkJava_PostInfoToTGPA(String str, String str2) {
        HawkAgent.postInfoToTGPA(str, str2);
    }

    public void AndroidThunkJava_PostInfoToTGPA(int i, String str) {
        HawkAgent.postInfoToTGPA(i, str);
    }

    public void AndroidThunkJava_PostInfoToTGPA(String str, HashMap<String, String> hashMap) {
        HawkAgent.postInfoToTGPA(str, hashMap);
    }

    public String AndroidThunkJava_GetDataFromTGPA(String str, String str2) {
        Log.debug("xclient AndroidThunkJava_GetDataFromTGPA");
        return HawkAgent.getDataFromTGPA(str, str2);
    }

    public String AndroidThunkJava_GetOptCfgStr() {
        return HawkAgent.getOptCfgStr();
    }

    public void AndroidThunkJava_postValue1F(String str, String str2, float f) {
        HawkAgent.postValue1F(str, str2, f);
    }

    public void AndroidThunkJava_postValue2F(String str, String str2, float f, float f2) {
        HawkAgent.postValue2F(str, str2, f, f2);
    }

    public void AndroidThunkJava_postValue3F(String str, String str2, float f, float f2, float f3) {
        HawkAgent.postValue3F(str, str2, f, f2, f3);
    }

    public void AndroidThunkJava_postValue1I(String str, String str2, int i) {
        HawkAgent.postValue1I(str, str2, i);
    }

    public void AndroidThunkJava_postValue2I(String str, String str2, int i, int i2) {
        HawkAgent.postValue2I(str, str2, i, i2);
    }

    public void AndroidThunkJava_postValue3I(String str, String str2, int i, int i2, int i3) {
        HawkAgent.postValue3I(str, str2, i, i2, i3);
    }

    public void AndroidThunkJava_postValueS(String str, String str2, String str3) {
        HawkAgent.postValueS(str, str2, str3);
    }

    public void AndroidThunkJava_postLargeValueS(String str, String str2, String str3) {
        HawkAgent.postLargeValueS(str, str2, str3);
    }

    public void AndroidThunkJava_beginTupleWrap(String str) {
        HawkAgent.beginTupleWrap(str);
    }

    public void AndroidThunkJava_endTupleWrap() {
        HawkAgent.endTupleWrap();
    }

    public void AndroidThunkJava_beignExclude() {
        HawkAgent.beignExclude();
    }

    public void AndroidThunkJava_endExclude() {
        HawkAgent.endExclude();
    }

    public void AndroidThunkJava_initStepEventContext() {
        HawkAgent.initStepEventContext();
    }

    public void AndroidThunkJava_linkLastStepCategorySession(String str) {
        HawkAgent.linkLastStepCategorySession(str);
    }

    public void AndroidThunkJava_postStepEvent(String str, int i, int i2, int i3, String str2, String str3) {
        HawkAgent.postStepEvent(str, i, i2, i3, str2, str3);
    }

    public void AndroidThunkJava_releaseStepEventContext() {
        HawkAgent.releaseStepEventContext();
    }

    public void AndroidThunkJava_setDeviceLevel(int i) {
        HawkAgent.setDefinedDeviceClass(i);
    }

    public void launchClub(Context context, String str) {
        Log.d("MeemoSNS", "openMeemoSnS scheme:" + str);
    }

    public void sendEvent(Context context, String str) {
        Log.d("MeemoSNS", "event:" + str);
    }

    private void sendLifeCycleEvent(String str) {
        Log.d("MeemoSNS", "eventName:" + str);
    }

    public void AndroidThunkJava_DelayInitThirdPartSDK() {
        Log.d("GameActivity", "AndroidThunkJava_DelayInitThirtPartSDK");
    }

    public void AndroidThunkJava_InitVlink() {
        Log.d("GameActivity", "AndroidThunkJava_InitVlink");
        JNIManager.getsInstance();
        GRobot.setActivity(this);
        vlinkHasInit = true;
    }

    public void AndroidThunkJava_StartBackgroundNotification(int i, int i2, String str, String str2, String str3, String str4) {
        Log.d("GameActivity", "AndroidThunkJava_StartBackgroundNotification");
        Intent intent = new Intent();
        intent.putExtra(GCBGDownloadService.EXTRA_DWONLOAD_INFO, new GCBGDownloadInitData(i, i2, str, str2, str3, str4));
        Intent intent2 = new Intent(this, (Class<?>) GameActivity.class);
        intent2.setFlags(335544320);
        intent2.setAction(getIntent().getAction());
        intent.putExtra(GCBGDownloadService.EXTRA_PENDING_INTENT, PendingIntent.getActivity(getApplicationContext(), 10086, intent2, 134217728));
        try {
            GCBGDownloadService.stopDownloadService(getApplicationContext());
            GCBGDownloadService.startDownloadServiceIfRequired(getApplicationContext(), intent);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Log.d("GameActitivy", "AndroidThunkJava_StartBackgroundNotification END");
    }

    public void AndroidThunkJava_StopBackgroundNotification() {
        GCBGDownloadService.stopDownloadService(getApplicationContext());
    }

    public String AndroidThunkJava_GetNativeVersion() {
        Log.d("GameActivity", "AndroidThunkJava_GetNativeVersion");
        try {
            int i = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName + "." + i;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void AndroidThunkJava_StartTrace(String str, int i, int i2, int i3) {
        Log.d("GameActitivy", "AndroidThunkJava_StartTrace START");
        new NetTrace().startTrace(str, i, i2);
    }

    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public boolean AndroidThunkJava_IsHarmonyOS() {
        int i = this.CheckHarmonyOSStatus;
        ?? r1 = 0;
        r1 = 0;
        if (i != -1) {
            return i == 1;
        }
        try {
            if (Class.forName("ohos.utils.system.SystemCapability") != null) {
                r1 = 1;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.CheckHarmonyOSStatus = r1;
        return r1;
    }

    public String AndroidThunkJava_GetFCMToken() {
        Log.d("GameActitivy", "AndroidThunkJava_GetFCMToken START");
        String str = "";
        try {
            FirebaseInstanceId firebaseInstanceId = FirebaseInstanceId.getInstance();
            if (firebaseInstanceId != null) {
                str = firebaseInstanceId.getToken();
            } else {
                Log.d("GameActitivy", "AndroidThunkJava_GetFCMToken firebaseInstanceId is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public void AndroidThunkJava_RestartGame() {
        Log.d("GameActitivy", "AndroidThunkJava_RestartGame START");
        try {
            GameProcessUtility.restartGameProcess(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int AndroidThunkJava_GetRingerMode() {
        Log.d("GameActitivy", "AndroidThunkJava_GetRingerMode START");
        try {
            return ((AudioManager) getSystemService("audio")).getRingerMode();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int AndroidThunkJava_GetVolume(int i) {
        Log.d("GameActitivy", "AndroidThunkJava_GetVolume START");
        try {
            return ((AudioManager) getSystemService("audio")).getStreamVolume(i);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateAdVisibility(boolean z) {
        if (!this.adInit || this.adPopupWindow == null) {
            return;
        }
        if (this.adWantsToBeShown && !this.adIsAvailable && !this.adIsRequested && z) {
            _activity.adView.loadAd(new AdRequest.Builder().build());
            this.adIsRequested = true;
        }
        if (this.adIsAvailable && this.adWantsToBeShown) {
            if (this.adPopupWindow.isShowing()) {
                return;
            }
            this.adPopupWindow.showAtLocation(this.activityLayout, this.adGravity, 0, 0);
            if (ANDROID_BUILD_VERSION != 24) {
                this.adPopupWindow.update();
                return;
            }
            return;
        }
        if (this.adPopupWindow.isShowing()) {
            this.adPopupWindow.dismiss();
            this.adPopupWindow.update();
        }
    }

    public void AndroidThunkJava_ShowAdBanner(String str, boolean z) {
        Log.debug("In AndroidThunkJava_ShowAdBanner");
        Log.debug("AdID: " + str);
        this.adGravity = z ? 80 : 48;
        if (this.adInit) {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GameActivity.this.adPopupWindow == null || GameActivity.this.adPopupWindow.isShowing()) {
                        return;
                    }
                    GameActivity.this.adWantsToBeShown = true;
                    GameActivity.this.updateAdVisibility(true);
                }
            });
            return;
        }
        this.adView = new AdView(this);
        this.adView.setAdUnitId(str);
        this.adView.setAdSize(AdSize.BANNER);
        if (this.adView != null) {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.this.adInit = true;
                    float f = GameActivity.this.getResources().getDisplayMetrics().density;
                    GameActivity.this.adPopupWindow = new PopupWindow(GameActivity._activity);
                    GameActivity.this.adPopupWindow.setWidth((int) (320.0f * f));
                    GameActivity.this.adPopupWindow.setHeight((int) (50.0f * f));
                    GameActivity.this.adPopupWindow.setClippingEnabled(false);
                    GameActivity.this.adLayout = new LinearLayout(GameActivity._activity);
                    int i = (int) (f * (-5.0f));
                    GameActivity.this.adLayout.setPadding(i, i, i, i);
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                    marginLayoutParams.setMargins(0, 0, 0, 0);
                    GameActivity.this.adLayout.setOrientation(1);
                    GameActivity.this.adLayout.addView(GameActivity.this.adView, marginLayoutParams);
                    GameActivity.this.adPopupWindow.setContentView(GameActivity.this.adLayout);
                    GameActivity._activity.adView.setAdListener(new AdListener() { // from class: com.epicgames.ue4.GameActivity.2.1
                        @Override // com.google.android.gms.ads.AdListener
                        public void onAdLoaded() {
                            GameActivity.this.adIsAvailable = true;
                            GameActivity.this.adIsRequested = false;
                            GameActivity.this.updateAdVisibility(true);
                        }

                        @Override // com.google.android.gms.ads.AdListener
                        public void onAdFailedToLoad(int i2) {
                            GameActivity.this.adIsAvailable = false;
                            GameActivity.this.adIsRequested = false;
                            GameActivity.this.updateAdVisibility(false);
                        }
                    });
                    GameActivity.this.adWantsToBeShown = true;
                    GameActivity.this.updateAdVisibility(true);
                }
            });
        }
    }

    public void AndroidThunkJava_HideAdBanner() {
        Log.debug("In AndroidThunkJava_HideAdBanner");
        if (this.adInit) {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.this.adWantsToBeShown = false;
                    GameActivity.this.updateAdVisibility(true);
                }
            });
        }
    }

    public void AndroidThunkJava_CloseAdBanner() {
        Log.debug("In AndroidThunkJava_CloseAdBanner");
        if (this.adInit) {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.this.adWantsToBeShown = false;
                    GameActivity.this.updateAdVisibility(true);
                }
            });
        }
    }

    public void AndroidThunkJava_LoadInterstitialAd(String str) {
        this.interstitialAdRequest = new AdRequest.Builder().build();
        this.interstitialAd = new InterstitialAd(this);
        this.isInterstitialAdLoaded = false;
        this.isInterstitialAdRequested = true;
        this.interstitialAd.setAdUnitId(str);
        _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.5
            @Override // java.lang.Runnable
            public void run() {
                GameActivity.this.interstitialAd.loadAd(GameActivity.this.interstitialAdRequest);
            }
        });
        this.interstitialAd.setAdListener(new AdListener() { // from class: com.epicgames.ue4.GameActivity.6
            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(int i) {
                GameActivity.Log.debug("Interstitial Ad failed to load, errocode: " + i);
                GameActivity.this.isInterstitialAdLoaded = false;
                GameActivity.this.isInterstitialAdRequested = false;
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                GameActivity.this.isInterstitialAdLoaded = true;
                GameActivity.this.isInterstitialAdRequested = false;
            }
        });
    }

    public boolean AndroidThunkJava_IsInterstitialAdAvailable() {
        return this.interstitialAd != null && this.isInterstitialAdLoaded;
    }

    public boolean AndroidThunkJava_IsInterstitialAdRequested() {
        return this.interstitialAd != null && this.isInterstitialAdRequested;
    }

    public void AndroidThunkJava_ShowInterstitialAd() {
        if (this.isInterstitialAdLoaded) {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.this.interstitialAd.show();
                }
            });
        } else {
            Log.debug("Interstitial Ad is not available to show - call LoadInterstitialAd or wait for it to finish loading");
        }
    }

    public String AndroidThunkJava_GetAdvertisingId() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext()).getId();
        } catch (Exception e) {
            Log.debug("GetAdvertisingId failed: " + e.getMessage());
            return null;
        }
    }

    public int AndroidThunkJava_InitGameMaster(int i, String str, String str2, int i2) {
        Log.d("GameActivity", "GameMaster.init() GUID: " + str + " Port:" + String.valueOf(i2));
        int init = GameMaster.init(this, i, str, str2, i2);
        Log.debug("GameMaster.init() return: " + init);
        return init;
    }

    public void AndroidThunkJava_GameMasterSetUserInfo(String str, String str2, String str3) {
        Log.d("GameActivity", "GameMaster.setUserInfo() paid: " + str + " token:" + str2 + " appid:" + str3);
        GameMaster.setUserToken(str, str2, str3);
    }

    public void AndroidThunkJava_GameMasterAddAccelAddr(String str, String str2, int i) {
        Log.d("GameActivity", "GameMaster.AddAddress() pro: " + str + " addr:" + str2 + " port:" + String.valueOf(i));
        GameMaster.addAccelAddress(str, str2, i);
    }

    public void AndroidThunkJava_GameMasterClearAccelAddr() {
        Log.d("GameActivity", "GameMaster.ClearAddress() ");
        GameMaster.clearAccelAddresses();
    }

    public void AndroidThunkJava_GameMasterSetOnlyWifiAccel(boolean z) {
        Log.d("GameActivity", "GameMaster.SetOnlyWifiAccel() ");
        GameMaster.setWiFiAccelSwitch(z);
    }

    public void AndroidThunkJava_GameMasterBeginRound(String str, String str2) {
        Log.d("GameActivity", "GameMaster.BeginRound()");
        GameMaster.beginRound(str, str2);
    }

    public void AndroidThunkJava_GameMasterSetUsableRegion(String str) {
        Log.d("GameActivity", "GameMaster.SetUsableRegion()");
        GameMaster.setUsableRegion(str);
    }

    public void AndroidThunkJava_GameMasterSetFreeFlowUser(int i) {
        Log.d("GameActivity", "GameMaster.SetFreeFlowUser()");
        GameMaster.setFreeFlowUser(i);
    }

    public boolean AndroidThunkJava_GameMasterIsAccelOpened() {
        Log.d("GameActivity", "GameMaster.IsAccelOpened()");
        return GameMaster.isAccelOpened();
    }

    public void AndroidThunkJava_GameMasterOnNetDelay(int i) {
        Log.d("GameActivity", "GameMaster.OnNetDelay()");
        GameMaster.onNetDelay(i);
    }

    public String AndroidThunkJava_GameMasterGetVIPValidTime() {
        Log.d("GameActivity", "GameMaster.GetVIPValidTime()");
        return GameMaster.getVIPValidTime();
    }

    public void AndroidThunkJava_GameMasterSetUdpEchoPort(int i) {
        Log.d("GameActivity", "GameMaster.SetUdpEchoPort()");
        GameMaster.setUdpEchoPort(i);
    }

    public String AndroidThunkJava_GameMasterGetWebUIUrl(int i) {
        Log.d("GameActivity", "GameMaster.GetWebUIUrl()");
        return GameMaster.getWebUIUrl(i);
    }

    public String AndroidThunkJava_GameMasterGetUserID() {
        Log.d("GameActivity", "GameMaster.getXunyouUserID()");
        return GameMaster.getXunyouUserID();
    }

    public void AndroidThunkJava_GameMasterAddNewArenaAddress(String str, String str2, int i) {
        Log.d("GameActivity", "GameMaster.addNewArenaAddress()");
        GameMaster.addNewArenaAddress(str, str2, i);
    }

    public int AndroidThunkJava_GetAccelerationStatus() {
        Log.d("GameActivity", "GameMaster.getAccelerationStatus()");
        int accelerationStatus = GameMaster.getAccelerationStatus();
        Log.debug("GameMaster.getAccelerationStatus() return: " + accelerationStatus);
        return accelerationStatus;
    }

    public int AndroidThunkJava_VPNPrepare() {
        Log.d("GameActivity", "GameMaster.VPNPrepare()");
        Intent prepare = VpnService.prepare(this);
        if (prepare == null) {
            Log.d("GameActivity", "GameMaster.VPNPrepare() succ");
            return 0;
        }
        startActivityForResult(prepare, 29577);
        return 1;
    }

    public int AndroidThunkJava_InitVPN(String str, String str2) {
        Log.d("GameActivity", "GameMaster.initVPN() GUID: " + str + " clientVersion:" + str2);
        int init = Master.init(this, str, str2, null);
        if (init == 0) {
            Master.setTunnelEventListener(new TunnelEventListenerImp());
        }
        Log.d("GameActivity", "GameMaster.initVPN() return: " + String.valueOf(init));
        return init;
    }

    public int AndroidThunkJava_VPNSetUserInfo(String str, String str2, String str3) {
        Log.d("GameActivity", "GameMaster.VPNSetUserInfo() userId: " + str + " userToken:" + str2 + " appId:" + str3);
        int authenticationInfo = Master.setAuthenticationInfo(str, str2, str3);
        StringBuilder sb = new StringBuilder();
        sb.append("GameMaster.VPNSetUserInfo() return: ");
        sb.append(String.valueOf(authenticationInfo));
        Log.d("GameActivity", sb.toString());
        return authenticationInfo;
    }

    public int AndroidThunkJava_VPNDialUp(String str) {
        Log.d("GameActivity", "GameMaster.DialUp()");
        int dialUp = Master.dialUp(str);
        Log.d("GameActivity", "GameMaster.DialUp() return: " + String.valueOf(dialUp));
        return dialUp;
    }

    public int AndroidThunkJava_VPNHandUp() {
        Log.d("GameActivity", "GameMaster.HandUp()");
        int hangUp = Master.hangUp();
        Log.d("GameActivity", "GameMaster.HandUp() return: " + String.valueOf(hangUp));
        return hangUp;
    }

    public String AndroidThunkJava_VPNGetNodeRegionList() {
        Log.d("GameActivity", "GameMaster.getNodeRegionList()");
        String nodeRegionList = Master.getNodeRegionList();
        Log.d("GameActivity", "GameMaster.getNodeRegionList() return: " + String.valueOf(nodeRegionList));
        return nodeRegionList;
    }

    public int AndroidThunkJava_VPNTearDown() {
        Log.d("GameActivity", "GameMaster.tearDown()");
        int tearDown = Master.tearDown();
        Log.d("GameActivity", "GameMaster.tearDown() return: " + String.valueOf(tearDown));
        return tearDown;
    }

    /* loaded from: classes.dex */
    public class TunnelEventListenerImp implements TunnelEventListener {
        public TunnelEventListenerImp() {
        }

        @Override // com.shieldtunnel.svpn.common.intf.TunnelEventListener
        public void onEvent(TunnelEventListener.Event event, int i, String str) {
            Log.d("TunnelEventListenerImp", "TunnelEventListenerImp.onEvent():" + String.valueOf(event) + ", " + String.valueOf(i));
            if (str != null) {
                Log.d("TunnelEventListenerImp", "TunnelEventListenerImp.onEvent():" + str);
            }
            GameActivity.onTunnelEvent(String.valueOf(event), i);
        }
    }

    public int AndroidThunkJava_VPNSetNodelist(String str) {
        Log.d("GameActivity", "GameMaster.setNodeList() " + str);
        int nodeList = Master.setNodeList(str);
        Log.d("GameActivity", "GameMaster.setNodeList() return: " + String.valueOf(nodeList));
        return nodeList;
    }

    public int AndroidThunkJava_VPNSetNodePortRange(int i, int i2) {
        Log.d("GameActivity", "GameMaster.setNodePortRange() " + String.valueOf(i) + ", " + String.valueOf(i2));
        int nodePortRange = Master.setNodePortRange(i, i2);
        StringBuilder sb = new StringBuilder();
        sb.append("GameMaster.setNodePortRange() return: ");
        sb.append(String.valueOf(nodePortRange));
        Log.d("GameActivity", sb.toString());
        return nodePortRange;
    }

    public boolean AndroidThunkJava_SetVpnServiceStrategye(String str, int i) {
        Log.d("GameActivity", "GameMaster.setVpnServiceStrategy() " + String.valueOf(str) + ", " + String.valueOf(i));
        boolean vpnServiceStrategy = Master.setVpnServiceStrategy(str, Integer.valueOf(i));
        StringBuilder sb = new StringBuilder();
        sb.append("GameMaster.setVpnServiceStrategy() return: ");
        sb.append(String.valueOf(vpnServiceStrategy));
        Log.d("GameActivity", sb.toString());
        return vpnServiceStrategy;
    }

    public void AndroidThunkJava_LobbyAddAddress(String str, String str2, int i) {
        Log.d("GameActivity", "GameMaster.addLobbyAddress()" + str + " " + str2 + " " + String.valueOf(i));
        GameMaster.addLobbyAddress(str, str2, i);
    }

    public void AndroidThunkJava_LobbySetUserRegion(int i) {
        Log.d("GameActivity", "GameMaster.setUserRegion() " + String.valueOf(i));
        GameMaster.setUserRegion(i);
    }

    public boolean AndroidThunkJava_LobbyIsLinkProxy(String str, int i) {
        Log.d("GameActivity", "GameMaster.isLobbyLinkProxy() " + str + " " + String.valueOf(i));
        boolean isLobbyLinkProxy = GameMaster.isLobbyLinkProxy(str, i);
        StringBuilder sb = new StringBuilder();
        sb.append("GameMaster.isLobbyLinkProxy() return: ");
        sb.append(String.valueOf(isLobbyLinkProxy));
        Log.d("GameActivity", sb.toString());
        return isLobbyLinkProxy;
    }

    public void AndroidThunkJava_LobbySetProxyNodelist(String str) {
        Log.d("GameActivity", "GameMaster.setProxyNodelist() " + str);
        GameMaster.setProxyNodeList(str);
    }

    public void AndroidThunkJava_LobbySetProxyPortlist(String str) {
        Log.d("GameActivity", "GameMaster.setProxyPortlist() " + str);
        GameMaster.setProxyPortList(str);
    }

    public void AndroidThunkJava_LobbySetEchoPortlist(String str) {
        Log.d("GameActivity", "GameMaster.setEchoPortlist() " + str);
        GameMaster.setEchoPortList(str);
    }

    public boolean AndroidThunkJava_SystemVPNOpened() {
        Log.d("GameActivity", "GameMaster.SystemVPNOpened() ");
        boolean z = false;
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getNetworkInfo(17);
            if (networkInfo != null) {
                z = networkInfo.isConnectedOrConnecting();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("GameActivity", "GameMaster.SystemVPNOpened() return: " + String.valueOf(z));
        return z;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AndroidUtil.onRequestPermissionsResult(i, strArr, iArr);
        nativeOnRequestPermissionsResult(this, i, Arrays.toString(strArr), Arrays.toString(iArr));
    }

    public void insertImage(String str) {
        AndroidUtil.insertImage(str);
    }

    public void gotoGoogleMarket() {
        AndroidUtil.gotoGoogleMarket();
    }

    @Override // android.app.NativeActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        try {
            this.cm = (ConnectivityManager) getSystemService("connectivity");
            if (this.netReceive == null) {
                this.netReceive = new NetWorkInfoReceiver();
                this.netReceive.connectivity = this.cm;
                this.filter.addAction(NetWorkChangeReceiver.NETWORK_CHANGE_ACTION);
                registerReceiver(this.netReceive, this.filter);
            }
        } catch (Exception unused) {
        }
        StopAutoBrightness();
        if (!this.BuildConfiguration.equals("Shipping")) {
            Log.debug("Creating console command broadcast listener");
            this.consoleCmdReceiver = new ConsoleCmdReceiver(this);
            registerReceiver(this.consoleCmdReceiver, new IntentFilter("android.intent.action.RUN"));
        }
        try {
            GCloud.Instance.onStart();
        } catch (Exception unused2) {
        }
        try {
            QuantumFirebaseRemoteConfig.getInstance().InitAndFetch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GameMaster.gameForeground();
        Log.debug("==================================> Inside onStart function in GameActivity");
    }

    public int getDeviceDefaultOrientation() {
        WindowManager windowManager = getWindowManager();
        Configuration configuration = getResources().getConfiguration();
        int rotation = windowManager.getDefaultDisplay().getRotation();
        switch (rotation) {
            case 0:
                this.DeviceRotation = 0;
                break;
            case 1:
                this.DeviceRotation = 90;
                break;
            case 2:
                this.DeviceRotation = 180;
                break;
            case 3:
                this.DeviceRotation = 270;
                break;
        }
        return (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) ? 2 : 1;
    }

    private int getResourceId(String str, String str2, String str3) {
        try {
            return getResources().getIdentifier(str, str2, str3);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void SaveUserBrightnessSetting() {
        try {
            Log.debug("[jimizhang],SaveUserBrightnessSetting");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void StopAutoBrightness() {
        Log.debug("[jimizhang],SCREEN_BRIGHTNESS_MODE_MANUAL");
    }

    public void ResumeAutoBrightness() {
        Log.debug("[jimizhang],ResumeAutoBrightness");
    }

    public void keepScreenOn(Context context, boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            return;
        }
        try {
            if (z) {
                this.PMWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(536870922, "==KeepScreenOn==");
                this.PMWakeLock.acquire();
            } else {
                this.PMWakeLock.release();
                this.PMWakeLock = null;
            }
        } catch (Exception e) {
            Log.debug("GameActivity keepScreenOn exception e = " + e.toString());
        }
    }

    @Override // android.app.NativeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        boolean z;
        String featureInfo;
        int indexOf;
        String substring;
        int indexOf2;
        String substring2;
        int indexOf3;
        super.onCreate(bundle);
        SaveUserBrightnessSetting();
        this.sensorManager = (SensorManager) getSystemService("sensor");
        this.accelerometer = this.sensorManager.getDefaultSensor(1);
        this.magnetometer = this.sensorManager.getDefaultSensor(2);
        this.gyroscope = this.sensorManager.getDefaultSensor(4);
        _clipboardManager = (ClipboardManager) getSystemService("clipboard");
        this.OrientationHandler = new ChangeOrientationHandler(this);
        this.OrientationSensor = this.sensorManager.getDefaultSensor(1);
        this.OrientationListener = new OrientationSensorListener(this.OrientationHandler);
        getWindow().addFlags(128);
        keepScreenOn(getApplicationContext(), true);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.ShouldHideUI = extras.getString("ShouldHideUI") != null;
            if (extras.getString("UseSplashScreen") != null) {
                try {
                    boolean isAlienScreen = isAlienScreen(this);
                    int identifier = getResources().getIdentifier("UE4SplashThemeAllInOne", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, getPackageName());
                    if (isAlienScreen) {
                        identifier = getApplicationContext().getResources().getIdentifier("UE4SplashThemeBG", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, getApplicationContext().getPackageName());
                    }
                    this.mSplashDialog = new Dialog(this, identifier);
                    this.mSplashDialog.setCancelable(false);
                    if (isAlienScreen) {
                        this.mSplashDialog.setContentView(getApplicationContext().getResources().getIdentifier("activity_splash", "layout", getApplicationContext().getPackageName()));
                    }
                    if (this.ShouldHideUI) {
                        View decorView = this.mSplashDialog.getWindow().getDecorView();
                        if (Build.VERSION.SDK_INT >= 19) {
                            decorView.setSystemUiVisibility(3846);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 28) {
                        WindowManager.LayoutParams attributes = this.mSplashDialog.getWindow().getAttributes();
                        attributes.layoutInDisplayCutoutMode = 1;
                        this.mSplashDialog.getWindow().setAttributes(attributes);
                    }
                    this.mSplashDialog.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    this.noActionAnimID = getResources().getIdentifier("noaction", "anim", getPackageName());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            try {
                this.noActionAnimID = getResources().getIdentifier("noaction", "anim", getPackageName());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        try {
            i = getPackageManager().getPackageInfo(getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e4) {
            Log.debug(e4.getMessage());
            i = 0;
        }
        if (ANDROID_BUILD_VERSION >= 23 && i >= 23) {
            Log.debug("Target SDK is " + i + ".  This may cause issues if permissions are denied by the user.");
        }
        nativeSetSensorAvailability(this.accelerometer != null, this.magnetometer != null, this.gyroscope != null);
        if (nativeIsShippingBuild()) {
            Logger.SuppressLogs();
        } else if (ANDROID_BUILD_VERSION <= 18) {
            PermissionHelper.acquirePermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, this);
        }
        _activity = this;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        marginLayoutParams.setMargins(0, 0, 0, 0);
        this.activityLayout = new LinearLayout(_activity);
        _activity.setContentView(this.activityLayout, marginLayoutParams);
        setVolumeControlStream(3);
        if (ANDROID_BUILD_VERSION >= 24) {
            for (FeatureInfo featureInfo2 : getPackageManager().getSystemAvailableFeatures()) {
                if (featureInfo2.name != null) {
                    if (featureInfo2.name.equals("android.hardware.vulkan.level")) {
                        String featureInfo3 = featureInfo2.toString();
                        int indexOf4 = featureInfo3.indexOf("v=");
                        if (indexOf4 >= 0 && (indexOf3 = (substring2 = featureInfo3.substring(indexOf4 + 2)).indexOf(" ")) >= 0) {
                            this.VulkanLevel = Integer.parseInt(substring2.substring(0, indexOf3));
                            Log.debug("Vulkan level: " + this.VulkanLevel);
                        }
                    } else if (featureInfo2.name.equals("android.hardware.vulkan.version") && (indexOf = (featureInfo = featureInfo2.toString()).indexOf("v=")) >= 0 && (indexOf2 = (substring = featureInfo.substring(indexOf + 2)).indexOf(" ")) >= 0) {
                        this.VulkanVersion = Integer.parseInt(substring.substring(0, indexOf2));
                        int i2 = this.VulkanVersion;
                        Log.debug("Vulkan version: " + ((i2 >> 22) & 1023) + "." + ((i2 >> 12) & 1023) + "." + (i2 & 4095));
                    }
                }
            }
        }
        if (getDeviceDefaultOrientation() == 2) {
            if (getPackageManager().hasSystemFeature("com.google.android.tv")) {
                Log.debug("Detected Google TV, will default to landscape");
                z = true;
            } else if (Build.MANUFACTURER.equals("NVIDIA")) {
                if (Build.MODEL.equals("SHIELD")) {
                    Log.debug("Detected NVidia Shield, will default to landscape");
                    z = true;
                }
                z = false;
            } else if (Build.MANUFACTURER.equals("OUYA")) {
                if (Build.MODEL.toLowerCase().startsWith("ouya_")) {
                    Log.debug("Detected Ouya console (" + Build.MODEL + "), will default to landscape");
                    z = true;
                }
                z = false;
            } else {
                if (Build.MANUFACTURER.equals("Amazon") && Build.MODEL.startsWith("AFT")) {
                    Log.debug("Detected Kindle Fire TV (" + Build.MODEL + "), will default to landscape");
                    z = true;
                }
                z = false;
            }
            if (z) {
                Log.debug("Setting screen orientation to landscape because we have detected landscape device");
                _activity.setRequestedOrientation(0);
            }
        }
        this.AssetManagerReference = getAssets();
        appPackageName = getPackageName();
        String packageName = getPackageName();
        String substring3 = packageName.substring(packageName.lastIndexOf(46) + 1);
        try {
            ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(getPackageName(), 128);
            Bundle bundle2 = applicationInfo.metaData;
            _bundle = bundle2;
            if ((applicationInfo.flags & 2) == 0) {
                this.IsForDistribution = true;
            }
            if (bundle2.containsKey("com.epicgames.ue4.GameActivity.DepthBufferPreference")) {
                this.DepthBufferPreference = bundle2.getInt("com.epicgames.ue4.GameActivity.DepthBufferPreference");
                Log.debug("Found DepthBufferPreference = " + this.DepthBufferPreference);
            } else {
                Log.debug("Did not find DepthBufferPreference, using default.");
            }
            if (bundle2.containsKey("com.epicgames.ue4.GameActivity.bPackageDataInsideApk")) {
                PackageDataInsideApkValue = bundle2.getBoolean("com.epicgames.ue4.GameActivity.bPackageDataInsideApk") ? 1 : 0;
                Log.debug("Found bPackageDataInsideApk = " + PackageDataInsideApkValue);
            } else {
                PackageDataInsideApkValue = 0;
                Log.debug("Did not find bPackageDataInsideApk, using default.");
            }
            if (bundle2.containsKey("com.epicgames.ue4.GameActivity.ProjectName")) {
                substring3 = bundle2.getString("com.epicgames.ue4.GameActivity.ProjectName");
                Log.debug("Found ProjectName = " + substring3);
            } else {
                Log.debug("Did not find ProjectName, using package name = " + substring3);
            }
            if (bundle2.containsKey("com.epicgames.ue4.GameActivity.bHasOBBFiles")) {
                HasOBBFiles = bundle2.getBoolean("com.epicgames.ue4.GameActivity.bHasOBBFiles") ? 1 : 0;
                Log.debug("Found bHasOBBFiles = " + HasOBBFiles);
            } else {
                HasOBBFiles = 0;
                Log.debug("Did not find bHasOBBFiles, using default.");
            }
            if (bundle2.containsKey("com.epicgames.ue4.GameActivity.bVerifyOBBOnStartUp")) {
                this.VerifyOBBOnStartUp = bundle2.getBoolean("com.epicgames.ue4.GameActivity.bVerifyOBBOnStartUp");
                Log.debug("Found bVerifyOBBOnStartUp = " + this.VerifyOBBOnStartUp);
            } else {
                this.VerifyOBBOnStartUp = false;
                Log.debug("Did not find bVerifyOBBOnStartUp, using default.");
            }
            if (bundle2.containsKey("com.epicgames.ue4.GameActivity.bShouldHideUI")) {
                this.ShouldHideUI = bundle2.getBoolean("com.epicgames.ue4.GameActivity.bShouldHideUI");
                Log.debug("UI hiding set to " + this.ShouldHideUI);
            } else {
                Log.debug("UI hiding not found. Leaving as " + this.ShouldHideUI);
            }
            if (bundle2.containsKey("com.epicgames.ue4.GameActivity.BuildConfiguration")) {
                this.BuildConfiguration = bundle2.getString("com.epicgames.ue4.GameActivity.BuildConfiguration");
                Log.debug("BuildConfiguration set to " + this.BuildConfiguration);
            } else {
                Log.debug("BuildConfiguration not found");
            }
            if (bundle2.containsKey("com.epicgames.ue4.GameActivity.bUseExternalFilesDir")) {
                this.UseExternalFilesDir = bundle2.getBoolean("com.epicgames.ue4.GameActivity.bUseExternalFilesDir");
                Log.debug("UseExternalFilesDir set to " + this.UseExternalFilesDir);
            } else {
                Log.debug("bUseExternalFilesDir not found. Leaving as " + this.UseExternalFilesDir);
            }
        } catch (PackageManager.NameNotFoundException e5) {
            Log.debug("Failed to load meta-data: NameNotFound: " + e5.getMessage());
        } catch (NullPointerException e6) {
            Log.debug("Failed to load meta-data: NullPointer: " + e6.getMessage());
        }
        String packageResourcePath = getPackageResourcePath();
        Log.debug("APK path: " + packageResourcePath);
        Logger logger = Log;
        StringBuilder sb = new StringBuilder();
        sb.append("OBB in APK: ");
        sb.append(PackageDataInsideApkValue == 1);
        logger.debug(sb.toString());
        nativeSetGlobalActivity(this.UseExternalFilesDir, PackageDataInsideApkValue == 1, packageResourcePath);
        nativeSetWindowInfo(false, this.DepthBufferPreference);
        String locale = Locale.getDefault().toString();
        Log.debug("Android version is " + Build.VERSION.RELEASE);
        Log.debug("Android manufacturer is " + Build.MANUFACTURER);
        Log.debug("Android model is " + Build.MODEL);
        Log.debug("OS language is set to " + locale);
        nativeSetAndroidVersionInformation(Build.VERSION.RELEASE, Build.MANUFACTURER, Build.MODEL, locale);
        try {
            nativeSetObbInfo(substring3, getApplicationContext().getPackageName(), getPackageManager().getPackageInfo(getPackageName(), 0).versionCode, 0);
        } catch (Exception e7) {
            Log.debug("==================================> PackageInfo failure getting .obb info: " + e7.getMessage());
        }
        setVolumeControlStream(3);
        this.consoleInputBox = new ConsoleKeyboardInput(this);
        this.consoleInputBox.setInputType(524289);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        ImageButton button = this.consoleInputBox.getButton();
        this.consoleInputBox.setId(1);
        button.setId(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(0, 2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        relativeLayout.addView(this.consoleInputBox, layoutParams);
        relativeLayout.addView(button, layoutParams2);
        this.consoleSpinner = new Spinner(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.simple_spinner_item, CONSOLE_SPINNER_ITEMS);
        arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item);
        this.consoleSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
        this.consoleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.epicgames.ue4.GameActivity.8
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i3, long j) {
                if (i3 > 0) {
                    GameActivity.this.consoleInputBox.setText(adapterView.getItemAtPosition(i3).toString());
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
                GameActivity.this.consoleInputBox.setText("");
                GameActivity.this.consoleSpinner.setSelection(0);
            }
        });
        this.consoleAlertLayout = new LinearLayout(this);
        this.consoleAlertLayout.setOrientation(1);
        this.consoleAlertLayout.addView(this.consoleSpinner);
        this.consoleAlertLayout.addView(relativeLayout);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Console Window - Enter Command").setMessage("").setView(this.consoleAlertLayout).setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: com.epicgames.ue4.GameActivity.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                String trim = GameActivity.this.consoleInputBox.getText().toString().trim();
                GameActivity.this.consoleInputBox.removeHistory(trim);
                GameActivity.this.consoleInputBox.addHistory(trim);
                GameActivity.this.nativeConsoleCommand(trim);
                GameActivity.this.consoleSpinner.setSelection(0);
                GameActivity.this.consoleInputBox.setText("");
                dialogInterface.dismiss();
                GameActivity.this.CurrentDialogType = EAlertDialogType.None;
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.epicgames.ue4.GameActivity.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                GameActivity.this.consoleSpinner.setSelection(0);
                GameActivity.this.consoleInputBox.setText("");
                dialogInterface.dismiss();
                GameActivity.this.CurrentDialogType = EAlertDialogType.None;
            }
        });
        this.consoleAlert = builder.create();
        this.virtualKeyboardInputBox = new EditText(this);
        this.virtualKeyboardInputBox.setPadding(30, 0, 30, 0);
        this.virtualKeyboardInputBox.addTextChangedListener(new TextWatcher() { // from class: com.epicgames.ue4.GameActivity.11
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                GameActivity.this.nativeVirtualKeyboardChanged(GameActivity.this.virtualKeyboardInputBox.getText().toString());
            }
        });
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle("").setView(this.virtualKeyboardInputBox).setPositiveButton("Ok", new DialogInterface.OnClickListener() { // from class: com.epicgames.ue4.GameActivity.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                GameActivity.this.nativeVirtualKeyboardResult(true, GameActivity.this.virtualKeyboardInputBox.getText().toString());
                GameActivity.this.virtualKeyboardInputBox.setText(" ");
                dialogInterface.dismiss();
                GameActivity.this.CurrentDialogType = EAlertDialogType.None;
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.epicgames.ue4.GameActivity.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                GameActivity gameActivity = GameActivity.this;
                gameActivity.nativeVirtualKeyboardChanged(gameActivity.virtualKeyboardPreviousContents);
                GameActivity.this.nativeVirtualKeyboardResult(false, " ");
                GameActivity.this.virtualKeyboardInputBox.setText(" ");
                dialogInterface.dismiss();
                GameActivity.this.CurrentDialogType = EAlertDialogType.None;
            }
        });
        this.virtualKeyboardAlert = builder2.create();
        GooglePlayLicensing.GoogleLicensing = new GooglePlayLicensing();
        GooglePlayLicensing.GoogleLicensing.Init(this, Log);
        this.googleClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(Games.API).addScope(Games.SCOPE_GAMES).addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN).build();
        if (PackageDataInsideApkValue == 1 || HasOBBFiles == 0) {
            this.HasAllFiles = true;
        }
        if (!this.HasAllFiles && !this.VerifyOBBOnStartUp) {
            this.HasAllFiles = DownloadShim.expansionFilesDelivered(this);
        }
        this.containerFrameLayout = new FrameLayout(_activity);
        this.virtualKeyboardLayout = new LinearLayout(_activity);
        getWindow().takeSurface(null);
        this.MySurfaceView = new SurfaceView(this);
        this.MySurfaceView.setBackgroundColor(0);
        this.MySurfaceView.getHolder().addCallback(this);
        this.containerFrameLayout.addView(this.MySurfaceView);
        this.containerFrameLayout.addView(this.virtualKeyboardLayout);
        setContentView(this.containerFrameLayout);
        this.mainView = findViewById(R.id.content);
        this.mainView.setFocusable(true);
        this.mainView.setFocusableInTouchMode(true);
        this.mainDecorView = getWindow().getDecorView();
        this.mainDecorViewRect = new Rect();
        createVirtualKeyboardInput();
        this.mainView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.epicgames.ue4.GameActivity.14
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int i3;
                int i4;
                int i5;
                int i6;
                if (GameActivity.this.bKeyboardShowing) {
                    Rect rect = new Rect();
                    GameActivity.this.mainView.getRootView().getWindowVisibleDisplayFrame(rect);
                    GameActivity.this.mainDecorView.getDrawingRect(GameActivity.this.mainDecorViewRect);
                    int abs = Math.abs(GameActivity.this.mainDecorViewRect.left - rect.left);
                    int abs2 = Math.abs(GameActivity.this.mainDecorViewRect.top - rect.top);
                    int abs3 = Math.abs(GameActivity.this.mainDecorViewRect.right - rect.right);
                    int abs4 = Math.abs(GameActivity.this.mainDecorViewRect.bottom - rect.bottom);
                    Rect rect2 = new Rect();
                    if (abs3 <= 0) {
                        i3 = GameActivity.this.mainDecorViewRect.left;
                    } else {
                        i3 = rect.right;
                    }
                    rect2.left = i3;
                    if (abs4 <= 0) {
                        i4 = GameActivity.this.mainDecorViewRect.top;
                    } else {
                        i4 = rect.bottom;
                    }
                    rect2.top = i4;
                    if (abs <= 0) {
                        i5 = GameActivity.this.mainDecorViewRect.right;
                    } else {
                        i5 = rect.left;
                    }
                    rect2.right = i5;
                    if (abs2 <= 0) {
                        i6 = GameActivity.this.mainDecorViewRect.bottom;
                    } else {
                        i6 = rect.top;
                    }
                    rect2.bottom = i6;
                    int height = rect.bottom - GameActivity.this.newVirtualKeyboardInput.getHeight();
                    if (height < 0) {
                        height = GameActivity.this.newVirtualKeyboardInput.getHeight() + rect.top;
                    }
                    int max = Math.max(abs4, abs2);
                    GameActivity.this.nativeVirtualKeyboardShown(rect2.left, rect2.top, rect2.right, rect2.bottom);
                    if (max > 100 || ((GameActivity.bSamsungDevice || GameActivity.bVivoDevice) && max >= 0)) {
                        GameActivity.Log.debug("VK: show");
                        GameActivity.this.newVirtualKeyboardInput.setY(height);
                        GameActivity.this.newVirtualKeyboardInput.setVisibility(0);
                        GameActivity.this.newVirtualKeyboardInput.requestFocus();
                        return;
                    }
                    if (GameActivity.this.newVirtualKeyboardInput.getY() <= 0.0f) {
                        if (max == 0) {
                            if (GameActivity.this.mainView != null) {
                                GameActivity.this.mainView.requestLayout();
                                return;
                            } else {
                                GameActivity.Log.debug("VK: show visibleScreenYOffset==0 mainView = null");
                                return;
                            }
                        }
                        return;
                    }
                    GameActivity.Log.debug("VK: hide");
                    GameActivity.this.bKeyboardShowing = false;
                    if (GameActivity.this.ShouldHideUI) {
                        GameActivity.this.restoreTransparentBars();
                    }
                    GameActivity.this.newVirtualKeyboardInput.setVisibility(8);
                    GameActivity.this.newVirtualKeyboardInput.setY(-1000.0f);
                    GameActivity.this.AndroidThunkJava_HideVirtualKeyboardInput();
                }
            }
        });
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
            attributes2.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes2);
        }
        if (getIntent() != null && getIntent().getExtras() != null) {
            _extraBundle = new Bundle();
            _extraBundle.putAll(getIntent().getExtras());
        }
        try {
            Log.i("apolloQR", "oncreate QRCodeAPIinitialize");
            QRCodeAPI.getInstance().Initialize(this);
        } catch (Exception e8) {
            Log.debug("QRCodeAPI Initialize Exception:" + e8.toString());
        }
        try {
            Log.i("GCloudJava", "begin GCloud.Instance.initialize");
            if (!GCloud.Instance.initialize(this)) {
                Log.debug("GCloud Initialize failed");
                finish();
                return;
            }
        } catch (Exception e9) {
            Log.debug("onStart Exception:" + e9.toString());
        }
        TDataMaster.getInstance().enableDeviceInfo(true);
        TDataMaster.getInstance().enableReport(true);
        Log.i("GCloudJava", "after GCloud.Instance.initialize");
        CrashSightPlatform.loadCrashSightCoreSo();
        ApolloVoiceLog.SetLogLevel(5);
        GCloudVoiceEngineHelper.EnableLog(false);
        GCloudVoiceEngine.getInstance().init(getApplicationContext(), this);
        Log.i("GVoiceJava", "after java device init");
        a.a(this);
        a.a();
        FirebasePush.RegisteFCM(this);
        IMSDKLogin.initialize(this);
        IMSDKFriend.initialize(this);
        IMSDKNotice.initialize(this);
        IMSDKStat.initialize(this);
        IMSDKWebView.initialize(this);
        IMSDKStat.initChannel(new HashMap<String, String[]>() { // from class: com.epicgames.ue4.GameActivity.15
            {
                put(IStat.STAT_EVENT_REPORT, new String[]{Constants.LOGTAG, "Facebook", "Firebase"});
                put("eventTrack", new String[]{""});
                put(IStat.STAT_EVENT_PURCHASE_REPORT, new String[]{Constants.LOGTAG});
                put("pageTrack", null);
                put("testSpeed", new String[0]);
            }
        });
        UrlUtils.initialize(this);
        AdjustExtend.addStandardDeepLink(getIntent().getData());
        Adjust.appWillOpenUrl(getIntent().getData());
        IMSDKLbs.initialize(this);
        IMSDKLbs.setChannel("IP");
        AdmobExtend.initailize(this);
        IMSDKUnifiedAccount.initialize(this);
        INTLApp.getInstance().init(getApplication());
        UploaderHelper.initialize(this);
        Log.debug("==============> GameActive.onCreate complete!");
    }

    public void restoreTranslucentBarsDelayed() {
        restoreTransparentBars();
        this.mRestoreImmersiveModeHandler.postDelayed(this.restoreImmersiveModeRunnable, 500L);
    }

    public void restoreTransparentBars() {
        if (Build.VERSION.SDK_INT < 19 || this.bKeyboardShowing) {
            return;
        }
        try {
            View decorView = getWindow().getDecorView();
            Log.debug("===VK: Restoring Transparent Bars === ," + this.bKeyboardShowing);
            decorView.setSystemUiVisibility(1798);
            decorView.setSystemUiVisibility(5894);
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if ((i == 4 || i == 25 || i == 24) && this.ShouldHideUI) {
            Log.debug("=== Restoring Transparent Bars due to KeyCode ===");
            restoreTranslucentBarsDelayed();
        }
        return super.onKeyDown(i, keyEvent);
    }

    public int getScreenOrientation() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        if (defaultDisplay.getWidth() == defaultDisplay.getHeight()) {
            return 3;
        }
        return defaultDisplay.getWidth() < defaultDisplay.getHeight() ? 1 : 2;
    }

    @Override // android.app.NativeActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.EnableSensorManager && !this.RegisterSensorListener) {
            this.RegisterSensorListener = true;
            this.sensorManager.registerListener(this, this.accelerometer, 1);
            this.sensorManager.registerListener(this, this.magnetometer, 1);
            this.sensorManager.registerListener(this, this.gyroscope, 1);
        }
        if (this.EnableOrientationSensorManager && !this.RegisterOrientationSensorListener) {
            this.RegisterOrientationSensorListener = true;
            this.sensorManager.registerListener(this.OrientationListener, this.OrientationSensor, 2);
        }
        nativeSetWindowInfo(false, this.DepthBufferPreference);
        if (this.ShouldHideUI) {
            restoreTransparentBars();
            View decorView = getWindow().getDecorView();
            decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.epicgames.ue4.GameActivity.17
                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i) {
                    GameActivity.Log.debug("=== Restoring Transparent Bars due to Visibility Change ===");
                    GameActivity.this.restoreTransparentBars();
                }
            });
            decorView.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.epicgames.ue4.GameActivity.18
                @Override // android.view.View.OnFocusChangeListener
                public void onFocusChange(View view, boolean z) {
                    GameActivity.Log.debug("=== Restoring Transparent Bars due to Focus Change ===");
                    GameActivity.this.restoreTransparentBars();
                }
            });
        }
        if (this.HasAllFiles) {
            Log.debug("==============> Resuming main init");
            nativeResumeMainInit();
            this.InitCompletedOK = true;
            if (PackageDataInsideApkValue == 0 && HasOBBFiles == 1) {
                Log.debug("GameActivity clear obb notification");
                try {
                    DownloaderActivity downloaderActivity = DownloadShim.DownloadActivity;
                    DownloaderActivity.a();
                    ((NotificationManager) getApplicationContext().getSystemService("notification")).cancel(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            Log.debug("==============> Posting request for downloader activity");
            new Handler().post(new Runnable() { // from class: com.epicgames.ue4.GameActivity.19
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.Log.debug("==============> Starting activity to check files and download if required");
                    Intent intent = new Intent(GameActivity._activity, DownloadShim.GetDownloaderType());
                    intent.addFlags(65536);
                    GameActivity.this.startActivityForResult(intent, GameActivity.DOWNLOAD_ACTIVITY_ID);
                    if (GameActivity.this.noActionAnimID != -1) {
                        GameActivity gameActivity = GameActivity.this;
                        gameActivity.overridePendingTransition(gameActivity.noActionAnimID, GameActivity.this.noActionAnimID);
                    }
                }
            });
        }
        LocalNotificationCheckAppOpen();
        Log.debug("VK: onResume ()-->false");
        this.bKeyboardShowing = false;
        try {
            GCloud.Instance.onResume();
        } catch (Exception unused) {
        }
        try {
            Log.i("GVoiceJava", "call gvoice resume interface");
            GCloudVoiceEngine.getInstance().Resume();
        } catch (Exception unused2) {
        }
        AdmobExtend.onResume();
        AndroidUtil.onResume();
        Log.debug("==============> GameActive.onResume complete!");
    }

    @Override // android.app.NativeActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.RegisterSensorListener) {
            this.RegisterSensorListener = false;
            this.sensorManager.unregisterListener(this);
        }
        if (this.RegisterOrientationSensorListener) {
            this.RegisterOrientationSensorListener = false;
            this.sensorManager.unregisterListener(this.OrientationListener);
        }
        if (this.bKeyboardShowing) {
            AndroidThunkJava_HideVirtualKeyboardInput();
        }
        if (this.CurrentDialogType != EAlertDialogType.None) {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.20
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass43.$SwitchMap$com$epicgames$ue4$GameActivity$EAlertDialogType[GameActivity.this.CurrentDialogType.ordinal()]) {
                        case 1:
                            GameActivity.this.virtualKeyboardAlert.hide();
                            return;
                        case 2:
                            GameActivity.this.consoleAlert.hide();
                            return;
                        default:
                            GameActivity.Log.debug("ERROR: Unknown EAlertDialogType!");
                            return;
                    }
                }
            });
        }
        try {
            GCloud.Instance.onPause();
        } catch (Exception unused) {
        }
        try {
            Log.i("GVoiceJava", "call gvoice pause interface");
            GCloudVoiceEngine.getInstance().Pause();
        } catch (Exception unused2) {
        }
        AdmobExtend.onPause();
        Log.debug("==============> GameActive.onPause complete!");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        int i;
        int i2;
        int i3;
        float[] fArr = {0.0f, 0.0f, 0.0f};
        float[] fArr2 = {0.0f, 0.0f, 0.0f};
        float[] fArr3 = {0.0f, 0.0f, 0.0f};
        if (sensorEvent.sensor.getType() == 1) {
            System.arraycopy(sensorEvent.values, 0, fArr, 0, fArr.length);
            i = 1;
            i2 = 0;
            i3 = 0;
        } else if (sensorEvent.sensor.getType() == 2) {
            System.arraycopy(sensorEvent.values, 0, fArr3, 0, fArr3.length);
            i = 0;
            i2 = 0;
            i3 = 1;
        } else if (sensorEvent.sensor.getType() == 4) {
            System.arraycopy(sensorEvent.values, 0, fArr2, 0, fArr2.length);
            i = 0;
            i2 = 1;
            i3 = 0;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
        }
        if (i > 0) {
            for (int i4 = 0; i4 < fArr.length; i4++) {
                fArr[i4] = fArr[i4] / i;
            }
            last_accelerometer = fArr;
        } else {
            fArr = last_accelerometer;
        }
        if (i2 > 0) {
            for (int i5 = 0; i5 < fArr2.length; i5++) {
                fArr2[i5] = fArr2[i5] / i2;
            }
            last_gyroscope = fArr2;
        }
        if (i3 > 0) {
            for (int i6 = 0; i6 < fArr3.length; i6++) {
                fArr3[i6] = fArr3[i6] / i3;
            }
            last_magnetometer = fArr3;
        } else {
            fArr3 = last_magnetometer;
        }
        if (i > 0 || i2 > 0 || i3 > 0) {
            float[] fArr4 = {0.0f, 0.0f, 0.0f};
            float[] fArr5 = last_gyroscope;
            float[] fArr6 = {0.0f, 0.0f, 0.0f};
            float[] fArr7 = {0.0f, 0.0f, 0.0f};
            if (!first_acceleration_sample) {
                float[] fArr8 = last_gravity;
                fArr6[0] = (fArr8[0] * SampleDecayRate) + (fArr[0] * 0.14999998f);
                fArr6[1] = (fArr8[1] * SampleDecayRate) + (fArr[1] * 0.14999998f);
                fArr6[2] = (fArr8[2] * SampleDecayRate) + (fArr[2] * 0.14999998f);
            }
            first_acceleration_sample = false;
            updateOrientationAngles(fArr, fArr3);
            float[] fArr9 = this.orientationAngles;
            float[] fArr10 = {fArr9[1], fArr9[2], fArr9[0]};
            for (int i7 = 0; i7 < fArr7.length; i7++) {
                fArr7[i7] = fArr[i7] - fArr6[i7];
            }
            if (i2 > 0) {
                fArr5 = fArr2;
            } else if (this.gyroscope == null) {
                for (int i8 = 0; i8 < fArr5.length; i8++) {
                    fArr5[i8] = fArr10[i8] - last_tilt[i8];
                }
            }
            synchronized (this.SyncSensorDataObject) {
                last_tilt = fArr10;
                last_gravity = fArr6;
                last_gyroscope = fArr5;
                last_acceleration = fArr7;
            }
        }
    }

    public void AndroidThunkJava_SensorManagerSwitch(boolean z) {
        try {
            if (z) {
                _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.21
                    @Override // java.lang.Runnable
                    public void run() {
                        GameActivity.Log.debug("AndroidThunkJava_SensorManagerSwitch Register Listener");
                        GameActivity.this.EnableSensorManager = true;
                        if (GameActivity.this.RegisterSensorListener) {
                            return;
                        }
                        GameActivity.this.RegisterSensorListener = true;
                        GameActivity.this.sensorManager.registerListener(GameActivity._activity, GameActivity.this.accelerometer, 1);
                        GameActivity.this.sensorManager.registerListener(GameActivity._activity, GameActivity.this.magnetometer, 1);
                        GameActivity.this.sensorManager.registerListener(GameActivity._activity, GameActivity.this.gyroscope, 1);
                    }
                });
            } else {
                _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.22
                    @Override // java.lang.Runnable
                    public void run() {
                        GameActivity.Log.debug("AndroidThunkJava_SensorManagerSwitch Unregister Listener");
                        GameActivity.this.EnableSensorManager = false;
                        if (GameActivity.this.RegisterSensorListener) {
                            GameActivity.this.RegisterSensorListener = false;
                            GameActivity.this.sensorManager.unregisterListener(GameActivity._activity);
                        }
                    }
                });
            }
        } catch (Exception e) {
            Log.debug("AndroidThunkJava_SensorManagerSwitch Exception = " + e.toString());
        }
    }

    public void AndroidThunkJava_OrientationSensorManagerSwitch(boolean z) {
        try {
            if (z) {
                _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.23
                    @Override // java.lang.Runnable
                    public void run() {
                        GameActivity.Log.debug("AndroidThunkJava_OrientationSensorManagerSwitch Register Listener");
                        GameActivity.this.EnableOrientationSensorManager = true;
                        if (GameActivity.this.RegisterOrientationSensorListener) {
                            return;
                        }
                        GameActivity.this.RegisterOrientationSensorListener = true;
                        GameActivity.this.sensorManager.registerListener(GameActivity.this.OrientationListener, GameActivity.this.OrientationSensor, 2);
                    }
                });
            } else {
                _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.24
                    @Override // java.lang.Runnable
                    public void run() {
                        GameActivity.Log.debug("AndroidThunkJava_OrientationSensorManagerSwitch Unregister Listener");
                        GameActivity.this.EnableOrientationSensorManager = false;
                        if (GameActivity.this.RegisterOrientationSensorListener) {
                            GameActivity.this.RegisterOrientationSensorListener = false;
                            GameActivity.this.sensorManager.unregisterListener(GameActivity.this.OrientationListener);
                        }
                    }
                });
            }
        } catch (Exception e) {
            Log.debug("AndroidThunkJava_SensorManagerSwitch Exception = " + e.toString());
        }
    }

    public void AndroidThunkJava_PushSensorEvents() {
        synchronized (this.SyncSensorDataObject) {
            nativeHandleSensorEvents(last_tilt, last_gyroscope, last_gravity, last_acceleration);
        }
    }

    public void updateOrientationAngles(float[] fArr, float[] fArr2) {
        SensorManager sensorManager = this.sensorManager;
        SensorManager.getRotationMatrix(this.rotationMatrix, null, fArr, fArr2);
        SensorManager sensorManager2 = this.sensorManager;
        SensorManager.getOrientation(this.rotationMatrix, this.orientationAngles);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        try {
            Log.i("apolloQR", "QRCodeAPI onNewIntent RefreshLaunch");
            QRCodeAPI.getInstance().RefreshLaunch(intent);
            GCloud.Instance.onNewIntent(intent);
        } catch (Exception unused) {
        }
        AdjustExtend.addStandardDeepLink(intent.getData());
        Adjust.appWillOpenUrl(intent.getData());
        if (intent != null && intent.getExtras() != null) {
            _extraBundle = new Bundle();
            _extraBundle.putAll(intent.getExtras());
            String stringExtra = intent.getStringExtra("google.message_id");
            String stringExtra2 = intent.getStringExtra("notification_content");
            Log.debug("==============> GameActive.onNewIntent googleMessageID: " + stringExtra + " notificationContent: " + stringExtra2);
        }
        nativeOnNewIntent();
    }

    @Override // android.app.NativeActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ConsoleCmdReceiver consoleCmdReceiver = this.consoleCmdReceiver;
        if (consoleCmdReceiver != null) {
            unregisterReceiver(consoleCmdReceiver);
        }
        try {
            GCloud.Instance.onStop();
        } catch (Exception unused) {
        }
        GameMaster.gameBackground();
        Log.debug("==============> GameActive.onStop complete!");
    }

    @Override // android.app.NativeActivity, android.app.Activity
    public void onDestroy() {
        StoreHelper storeHelper = this.IapStoreHelper;
        if (storeHelper != null) {
            storeHelper.onDestroy();
        }
        NetWorkInfoReceiver netWorkInfoReceiver = this.netReceive;
        if (netWorkInfoReceiver != null) {
            unregisterReceiver(netWorkInfoReceiver);
        }
        Log.debug("==============> GameActive.onDestroy complete!");
        System.exit(0);
        try {
            GCloud.Instance.onDestroy();
        } catch (Exception unused) {
        }
        AdmobExtend.onDestroy();
    }

    @Override // android.app.NativeActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        switch (getWindowManager().getDefaultDisplay().getRotation()) {
            case 0:
                this.DeviceRotation = 0;
                break;
            case 1:
                this.DeviceRotation = 90;
                break;
            case 2:
                this.DeviceRotation = 180;
                break;
            case 3:
                this.DeviceRotation = 270;
                break;
        }
        int i = configuration.orientation;
        String str = configuration.orientation == 2 ? "屏幕设置为：横屏" : "屏幕设置为：竖屏";
        Log.debug("==============> [Notch]onConfigurationChanged2: " + str + " DeviceRotation: " + this.DeviceRotation);
        nativeOnConfigurationChanged(false);
        nativeOnDeviceRotationChanged(this.DeviceRotation);
    }

    @Override // android.app.NativeActivity, android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (this.bUseSurfaceView) {
            int i4 = this.DesiredHolderWidth;
            if (i4 > 0) {
                i2 = i4;
            }
            int i5 = this.DesiredHolderHeight;
            if (i5 > 0) {
                i3 = i5;
            }
            super.surfaceChanged(surfaceHolder, i, i2, i3);
            surfaceHolder.setFixedSize(i2, i3);
            nativeSetSurfaceViewInfo(surfaceHolder.getSurfaceFrame().width(), surfaceHolder.getSurfaceFrame().height());
            return;
        }
        super.surfaceChanged(surfaceHolder, i, i2, i3);
    }

    public void AndroidThunkJava_ShowHiddenAlertDialog() {
        if (this.CurrentDialogType != EAlertDialogType.None) {
            Log.debug("==============> [JAVA] AndroidThunkJava_ShowHiddenAlertDialog() - Showing " + this.CurrentDialogType);
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.25
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass43.$SwitchMap$com$epicgames$ue4$GameActivity$EAlertDialogType[GameActivity.this.CurrentDialogType.ordinal()]) {
                        case 1:
                            GameActivity.this.virtualKeyboardAlert.show();
                            return;
                        case 2:
                            GameActivity.this.consoleAlert.show();
                            return;
                        default:
                            GameActivity.Log.debug("ERROR: Unknown EAlertDialogType!");
                            return;
                    }
                }
            });
        }
    }

    public void AndroidThunkJava_KeepScreenOn(boolean z) {
        if (z) {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.26
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity._activity.getWindow().addFlags(128);
                }
            });
        } else {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.27
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity._activity.getWindow().clearFlags(128);
                }
            });
        }
    }

    public int AndroidThunkJava_GetScreenWidth() {
        int i;
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 19) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (point.y > point.x) {
            i = point.y;
        } else {
            i = point.x;
        }
        Log.debug("GameActive GetScreenWidth3  width = " + i);
        return i;
    }

    public int AndroidThunkJava_GetScreenHeight() {
        int i;
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 19) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (point.y > point.x) {
            i = point.x;
        } else {
            i = point.y;
        }
        Log.debug("GameActive GetScreenWidth3  height = " + i);
        return i;
    }

    /* loaded from: classes.dex */
    private class VibrateRunnable implements Runnable {
        private int duration;
        private Vibrator vibrator;

        VibrateRunnable(int i, Vibrator vibrator) {
            this.duration = i;
            this.vibrator = vibrator;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = this.duration;
            if (i < 1) {
                this.vibrator.cancel();
            } else {
                this.vibrator.vibrate(i);
            }
        }
    }

    public void AndroidThunkJava_Vibrate(int i) {
        Vibrator vibrator = (Vibrator) getSystemService("vibrator");
        if (vibrator != null) {
            _activity.runOnUiThread(new VibrateRunnable(i, vibrator));
        }
    }

    public boolean AndroidThunkJava_HasVibrater() {
        Vibrator vibrator = (Vibrator) getSystemService("vibrator");
        if (vibrator != null) {
            return vibrator.hasVibrator();
        }
        return false;
    }

    public boolean AndroidThunkJava_VibrateEffect(long[] jArr, int[] iArr, int i) {
        Vibrator vibrator = (Vibrator) getSystemService("vibrator");
        if (vibrator == null) {
            return false;
        }
        vibrator.vibrate(VibrationEffect.createWaveform(jArr, iArr, i));
        return true;
    }

    public void AndroidThunkJava_ShowConsoleWindow(String str) {
        if (this.consoleAlert.isShowing()) {
            Log.debug("Console already showing.");
            return;
        }
        this.consoleInputBox.setHistoryEnd();
        this.consoleAlert.setMessage("[Available texture formats: " + str + "]");
        _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.28
            @Override // java.lang.Runnable
            public void run() {
                if (GameActivity.this.consoleAlert.isShowing()) {
                    return;
                }
                GameActivity.Log.debug("Console not showing yet");
                GameActivity.this.consoleAlert.show();
                GameActivity.this.CurrentDialogType = EAlertDialogType.Console;
            }
        });
    }

    public void AndroidThunkJava_HideVirtualKeyboardInputDialog() {
        nativeVirtualKeyboardHide();
        if (!this.virtualKeyboardAlert.isShowing()) {
            Log.debug("Virtual keyboard already hidden.");
        } else {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.29
                @Override // java.lang.Runnable
                public void run() {
                    if (GameActivity.this.virtualKeyboardAlert.isShowing()) {
                        GameActivity.Log.debug("Virtual keyboard hiding");
                        GameActivity.this.virtualKeyboardInputBox.setText(" ");
                        GameActivity.this.virtualKeyboardAlert.dismiss();
                        GameActivity.this.CurrentDialogType = EAlertDialogType.None;
                    }
                }
            });
        }
    }

    public void AndroidThunkJava_ShowVirtualKeyboardInputDialog(final int i, final String str, final String str2) {
        if (this.virtualKeyboardAlert.isShowing()) {
            Log.debug("Virtual keyboard already showing.");
        } else {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.30
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.this.virtualKeyboardAlert.setTitle(str);
                    GameActivity.this.virtualKeyboardInputBox.setRawInputType(i);
                    GameActivity.this.virtualKeyboardInputBox.setTransformationMethod((i & 128) == 0 ? null : PasswordTransformationMethod.getInstance());
                    GameActivity.this.virtualKeyboardInputBox.setText("");
                    GameActivity.this.virtualKeyboardInputBox.append(str2);
                    GameActivity gameActivity = GameActivity.this;
                    gameActivity.virtualKeyboardPreviousContents = str2;
                    if (gameActivity.virtualKeyboardAlert.isShowing()) {
                        return;
                    }
                    GameActivity.Log.debug("Virtual keyboard not showing yet");
                    GameActivity.this.virtualKeyboardAlert.show();
                    GameActivity.this.CurrentDialogType = EAlertDialogType.Keyboard;
                }
            });
        }
    }

    public void AndroidThunkJava_HideVirtualKeyboardInput() {
        nativeVirtualKeyboardHide();
        lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_HIDE;
        this.virtualKeyboardHandler.removeCallbacksAndMessages(null);
        this.virtualKeyboardHandler.postDelayed(new Runnable() { // from class: com.epicgames.ue4.GameActivity.31
            @Override // java.lang.Runnable
            public void run() {
                if (GameActivity.lastVirtualKeyboardCommand == VirtualKeyboardCommand.VK_CMD_HIDE) {
                    if (GameActivity.this.newVirtualKeyboardInput != null) {
                        GameActivity.this.newVirtualKeyboardInput.setY(-1000.0f);
                    }
                    GameActivity.this.processLastVirtualKeyboardCommand();
                }
            }
        }, 200L);
    }

    public void AndroidThunkJava_ShowVirtualKeyboardInput(int i, String str, String str2) {
        Log.debug("VK: AndroidThunkJava_ShowVirtualKeyboardInput");
        this.virtualKeyboardInputContent = str2;
        this.virtualKeyboardInputType = i;
        lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_SHOW;
        this.virtualKeyboardHandler.removeCallbacksAndMessages(null);
        this.virtualKeyboardHandler.postDelayed(new Runnable() { // from class: com.epicgames.ue4.GameActivity.32
            @Override // java.lang.Runnable
            public void run() {
                if (GameActivity.lastVirtualKeyboardCommand == VirtualKeyboardCommand.VK_CMD_SHOW) {
                    GameActivity.this.processLastVirtualKeyboardCommand();
                }
            }
        }, 200L);
    }

    public void DelayShowInputWhenUseQQImeWindowMode() {
        this.showWindowImeHandler.removeCallbacksAndMessages(null);
        this.showWindowImeHandler.postDelayed(new Runnable() { // from class: com.epicgames.ue4.GameActivity.33
            @Override // java.lang.Runnable
            public void run() {
                if (!GameActivity.this.bKeyboardShowing || GameActivity.this.newVirtualKeyboardInput.getY() >= 0.0f) {
                    return;
                }
                GameActivity.this.newVirtualKeyboardInput.setY(0.0f);
            }
        }, 500L);
    }

    public void processLastVirtualKeyboardCommand() {
        Log.debug("VK: process last command " + lastVirtualKeyboardCommand);
        synchronized (this) {
            switch (lastVirtualKeyboardCommand) {
                case VK_CMD_SHOW:
                    this.newVirtualKeyboardInput.setVisibility(0);
                    this.newVirtualKeyboardInput.setY(-1000.0f);
                    this.newVirtualKeyboardInput.setText(this.virtualKeyboardInputContent);
                    int i = (this.virtualKeyboardInputType | 524288) & (-32769);
                    this.newVirtualKeyboardInput.setInputType(i);
                    this.newVirtualKeyboardInput.setRawInputType(i);
                    int i2 = ANDROID_BUILD_VERSION >= 11 ? 301989892 : 268435460;
                    this.newVirtualKeyboardInput.setSingleLine(true);
                    this.newVirtualKeyboardInput.setImeOptions((i2 & (-1073741825)) | 6);
                    this.newVirtualKeyboardInput.setTransformationMethod((this.virtualKeyboardInputType & 128) == 0 ? null : PasswordTransformationMethod.getInstance());
                    this.newVirtualKeyboardInput.setSelection(this.newVirtualKeyboardInput.getText().length());
                    if (this.newVirtualKeyboardInput.requestFocus()) {
                        Log.debug("VK: Show newVirtualKeyboardInput");
                        ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.newVirtualKeyboardInput, 0);
                        nativeVirtualKeyboardVisible(true);
                        DelayShowInputWhenUseQQImeWindowMode();
                        Log.debug("VK: VK_CMD_SHOW ()-->true");
                        this.bKeyboardShowing = true;
                        break;
                    } else {
                        Log.debug("VK: Show newVirtualKeyboardInput  requestFocus false");
                        break;
                    }
                case VK_CMD_HIDE:
                    if (this.newVirtualKeyboardInput != null) {
                        this.newVirtualKeyboardInput.setY(-1000.0f);
                    }
                    if (this.bKeyboardShowing) {
                        Log.debug("VK: Hide newVirtualKeyboardInput");
                        this.newVirtualKeyboardInput.clearFocus();
                        this.newVirtualKeyboardInput.setVisibility(8);
                        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.newVirtualKeyboardInput.getWindowToken(), 0);
                        nativeVirtualKeyboardVisible(false);
                        Log.debug("VK: VK_CMD_HIDE ()-->false");
                        this.bKeyboardShowing = false;
                        if (this.ShouldHideUI) {
                            restoreTransparentBars();
                            break;
                        }
                    } else {
                        nativeVirtualKeyboardHide();
                        break;
                    }
                    break;
            }
        }
        lastVirtualKeyboardCommand = VirtualKeyboardCommand.VK_CMD_NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.epicgames.ue4.GameActivity$43, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass43 {
        static final /* synthetic */ int[] $SwitchMap$com$epicgames$ue4$GameActivity$EAlertDialogType;

        static {
            try {
                $SwitchMap$com$epicgames$ue4$GameActivity$VirtualKeyboardCommand[VirtualKeyboardCommand.VK_CMD_SHOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$epicgames$ue4$GameActivity$VirtualKeyboardCommand[VirtualKeyboardCommand.VK_CMD_HIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $SwitchMap$com$epicgames$ue4$GameActivity$EAlertDialogType = new int[EAlertDialogType.values().length];
            try {
                $SwitchMap$com$epicgames$ue4$GameActivity$EAlertDialogType[EAlertDialogType.Keyboard.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$epicgames$ue4$GameActivity$EAlertDialogType[EAlertDialogType.Console.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public void AndroidThunkJava_LaunchURL(String str) {
        Log.debug("[JAVA} AndroidThunkJava_LaunchURL: URL = " + str);
        if (!str.contains("://")) {
            str = "http://" + str;
            Log.debug("[JAVA} AndroidThunkJava_LaunchURL: corrected URL = " + str);
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(1074266112);
            intent.addFlags(402653184);
            if (intent.resolveActivity(getPackageManager()) != null) {
                Log.debug("[JAVA} AndroidThunkJava_LaunchURL: Starting activity");
                startActivity(intent);
            } else {
                Log.debug("[JAVA} AndroidThunkJava_LaunchURL: Could not find an application to receive the URL intent");
            }
        } catch (Exception e) {
            Log.debug("[JAVA} AndroidThunkJava_LaunchURL: Failed with exception " + e.getMessage());
        }
    }

    public String AndroidThunkJava_GetAndroidId() {
        try {
            return Settings.Secure.getString(getApplicationContext().getContentResolver(), "android_id");
        } catch (Exception e) {
            Log.debug("GetAndroidId failed: " + e.getMessage());
            return null;
        }
    }

    public void AndroidThunkJava_ResetAchievements() {
        Log.debug("AndroidThunkJava_ResetAchievements: disabled");
    }

    @TargetApi(23)
    private String GetAccessToken() {
        try {
            if (PermissionHelper.checkPermission("android.permission.GET_ACCOUNTS")) {
                String accountName = Plus.AccountApi.getAccountName(this.googleClient);
                Log.debug("GetAccessToken: using email " + accountName);
            }
        } catch (Exception e) {
            Log.debug("GetAccessToken failed: " + e.getMessage());
        }
        return "";
    }

    public void AndroidThunkJava_GoogleClientConnect() {
        GoogleApiClient googleApiClient = this.googleClient;
        if (googleApiClient != null) {
            googleApiClient.connect();
        }
    }

    public void AndroidThunkJava_GoogleClientDisconnect() {
        GoogleApiClient googleApiClient = this.googleClient;
        if (googleApiClient != null) {
            googleApiClient.disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(Bundle bundle) {
        GoogleApiClient googleApiClient = this.googleClient;
        if (googleApiClient != null && googleApiClient.isConnected()) {
            new Thread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.34
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.this.nativeGoogleClientConnectCompleted(true, "NOT_ACQUIRED");
                }
            }).start();
        } else {
            nativeGoogleClientConnectCompleted(false, "");
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.debug("Google Client Connect failed. Error Code: " + connectionResult.getErrorCode() + " Description: " + connectionResult.getErrorMessage());
        nativeGoogleClientConnectCompleted(false, "");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        Log.debug("Google Client Connect Suspended: " + i);
    }

    public AssetManager AndroidThunkJava_GetAssetManager() {
        if (this.AssetManagerReference == null) {
            Log.debug("No reference to asset manager found!");
        }
        return this.AssetManagerReference;
    }

    public static boolean isAlienScreen(Activity activity) {
        float f;
        float f2;
        if (activity == null) {
            return false;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            if (i2 > i) {
                f = i;
                f2 = i2;
            } else {
                f = i2;
                f2 = i;
            }
            float f3 = f / f2;
            Log.debug("Screen: " + String.valueOf(displayMetrics.scaledDensity) + " " + String.valueOf(displayMetrics.xdpi) + " " + String.valueOf(displayMetrics.ydpi) + " " + String.valueOf(displayMetrics.densityDpi));
            Logger logger = Log;
            StringBuilder sb = new StringBuilder();
            sb.append("Screen: ");
            sb.append(String.valueOf(f3));
            sb.append(" ");
            sb.append(String.valueOf(i2));
            sb.append(" ");
            sb.append(String.valueOf(i));
            logger.debug(sb.toString());
            double d = f3;
            return d > 0.58d || d < 0.54d;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isOBBInAPK() {
        Logger logger = Log;
        StringBuilder sb = new StringBuilder();
        sb.append("Asking if osOBBInAPK? ");
        sb.append(PackageDataInsideApkValue == 1);
        logger.debug(sb.toString());
        return PackageDataInsideApkValue == 1;
    }

    public void AndroidThunkJava_Minimize() {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        startActivity(intent);
    }

    public void AndroidThunkJava_ForceQuit() {
        ResumeAutoBrightness();
        System.exit(0);
    }

    public void AndroidThunkJava_InitHMDs() {
        _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.35
            @Override // java.lang.Runnable
            public void run() {
                GameActivity.this.nativeInitHMDs();
            }
        });
    }

    public static String AndroidThunkJava_GetFontDirectory() {
        String str;
        int i = 0;
        String[] strArr = {"/system/fonts", "/system/font", "/data/fonts"};
        int length = strArr.length;
        while (true) {
            if (i >= length) {
                str = null;
                break;
            }
            str = strArr[i];
            if (new File(str).exists()) {
                break;
            }
            i++;
        }
        return str + "/";
    }

    public static String getAppPackageName() {
        return appPackageName;
    }

    public boolean AndroidThunkJava_IsMusicActive() {
        return ((AudioManager) getSystemService("audio")).isMusicActive();
    }

    public void AndroidThunkJava_IapSetupService(String str) {
        int checkPermission = getPackageManager().checkPermission("com.android.vending.BILLING", getPackageName());
        getPackageManager();
        if (checkPermission == 0) {
            this.IapStoreHelper = new GooglePlayStoreHelper(str, this, Log);
            if (this.IapStoreHelper != null) {
                Log.debug("[JAVA] - AndroidThunkJava_IapSetupService - Setup started");
                return;
            } else {
                Log.debug("[JAVA] - AndroidThunkJava_IapSetupService - Failed to setup IAP service");
                return;
            }
        }
        Log.debug("[JAVA] - AndroidThunkJava_IapSetupService - You do not have the appropriate permission setup.");
        Log.debug("[JAVA] - AndroidThunkJava_IapSetupService - Please ensure com.android.vending.BILLING is added to the manifest.");
    }

    public boolean AndroidThunkJava_IapQueryInAppPurchases(String[] strArr) {
        Log.debug("[JAVA] - AndroidThunkJava_IapQueryInAppPurchases");
        this.CachedQueryProductIDs = strArr;
        if (this.IapStoreHelper != null) {
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.36
                @Override // java.lang.Runnable
                public void run() {
                    GameActivity.this.IapStoreHelper.QueryInAppPurchases(GameActivity.this.CachedQueryProductIDs);
                }
            });
            return true;
        }
        Log.debug("[JAVA] - Store Helper is invalid");
        return false;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3;
        String str;
        if (i == 80001) {
            if (i2 == -1) {
                i3 = intent.getIntExtra(DOWNLOAD_RETURN_NAME, 0);
                switch (i3) {
                    case 0:
                        str = "DownloadActivity Returned with Download No Return Code";
                        break;
                    case 1:
                        str = "DownloadActivity Returned with Download Files Present";
                        break;
                    case 2:
                        str = "DownloadActivity Returned with Download Completed OK";
                        break;
                    case 3:
                        str = "DownloadActivity Returned with Download User Quit";
                        break;
                    case 4:
                        str = "DownloadActivity Returned with Download Failed";
                        break;
                    case 5:
                        str = "DownloadActivity Returned with Download Invalid";
                        break;
                    case 6:
                        str = "DownloadActivity Returned with Download No Play Key";
                        break;
                    default:
                        str = "DownloadActivity Returned with Unknown message!";
                        break;
                }
                Log.debug(str);
            } else {
                Log.debug("Download activity cancelled by user.");
                i3 = 3;
            }
            this.HasAllFiles = i3 == 1 || i3 == 2;
            if (i3 == 0 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6) {
                finish();
                return;
            }
        } else {
            StoreHelper storeHelper = this.IapStoreHelper;
            if (storeHelper != null) {
                if (!storeHelper.onActivityResult(i, i2, intent)) {
                    super.onActivityResult(i, i2, intent);
                } else {
                    Log.debug("[JAVA] - Store Helper handled onActivityResult");
                }
            } else {
                super.onActivityResult(i, i2, intent);
            }
        }
        try {
            GCloud.Instance.onActivityResult(i, i2, intent);
        } catch (Exception unused) {
        }
        if (vlinkHasInit) {
            GRobot.handleCallBackOnActivityForResult(i, i2, intent);
        }
        if (i == 29577) {
            if (i2 == -1) {
                onTunnelEvent("VPN_PERMISSION_RESULT", 1);
            } else {
                onTunnelEvent("VPN_PERMISSION_RESULT", 0);
            }
        }
        if (this.InitCompletedOK) {
            nativeOnActivityResult(this, i, i2, intent);
        }
    }

    public boolean AndroidThunkJava_IapBeginPurchase(String str) {
        Log.debug("[JAVA] - AndroidThunkJava_IapBeginPurchase");
        StoreHelper storeHelper = this.IapStoreHelper;
        if (storeHelper != null) {
            return storeHelper.BeginPurchase(str);
        }
        Log.debug("[JAVA] - Store Helper is invalid");
        return false;
    }

    public boolean AndroidThunkJava_IapIsAllowedToMakePurchases() {
        Log.debug("[JAVA] - AndroidThunkJava_IapIsAllowedToMakePurchases");
        StoreHelper storeHelper = this.IapStoreHelper;
        if (storeHelper != null) {
            return storeHelper.IsAllowedToMakePurchases();
        }
        Log.debug("[JAVA] - Store Helper is invalid");
        return false;
    }

    public boolean AndroidThunkJava_IapConsumePurchase(String str) {
        Log.debug("[JAVA] - AndroidThunkJava_IapConsumePurchase " + str);
        StoreHelper storeHelper = this.IapStoreHelper;
        if (storeHelper != null) {
            storeHelper.ConsumePurchase(str);
            return true;
        }
        Log.debug("[JAVA] - Store Helper is invalid");
        return false;
    }

    public boolean AndroidThunkJava_IapQueryExistingPurchases() {
        Log.debug("[JAVA] - AndroidThunkJava_IapQueryExistingPurchases");
        if (this.IapStoreHelper != null) {
            Log.debug("[JAVA] - AndroidThunkJava_IapQueryExistingPurchases - Kick off logic here!");
            return this.IapStoreHelper.QueryExistingPurchases();
        }
        Log.debug("[JAVA] - Store Helper is invalid");
        return false;
    }

    public boolean AndroidThunkJava_IapRestorePurchases(String[] strArr, boolean[] zArr) {
        Log.debug("[JAVA] - AndroidThunkJava_IapRestorePurchases");
        if (this.IapStoreHelper != null) {
            Log.debug("[JAVA] - AndroidThunkJava_IapRestorePurchases - Kick off logic here!");
            return this.IapStoreHelper.RestorePurchases(strArr, zArr);
        }
        Log.debug("[JAVA] - Store Helper is invalid");
        return false;
    }

    public void AndroidThunkJava_DismissSplashScreen() {
        Dialog dialog = this.mSplashDialog;
        if (dialog != null) {
            dialog.dismiss();
            this.mSplashDialog = null;
        }
    }

    /* loaded from: classes.dex */
    private static class DeviceInfoData {
        public final String name;
        public final int productId;
        public final int vendorId;

        DeviceInfoData(int i, int i2, String str) {
            this.vendorId = i;
            this.productId = i2;
            this.name = str;
        }

        boolean IsMatch(int i, int i2) {
            return this.vendorId == i && this.productId == i2;
        }
    }

    private void LocalNotificationCheckAppOpen() {
        Intent intent = getIntent();
        if (intent != null) {
            Bundle extras = intent.getExtras();
            this.localNotificationAppLaunched = intent.getBooleanExtra("localNotificationAppLaunched", false);
            if (this.localNotificationAppLaunched) {
                int i = extras.getInt("localNotificationID");
                this.localNotificationLaunchActivationEvent = Integer.toString(i);
                AndroidThunkJava_LocalNotificationRemoveID(i);
                this.localNotificationLaunchFireDate = 0;
                return;
            }
            return;
        }
        this.localNotificationAppLaunched = false;
        this.localNotificationLaunchActivationEvent = "";
        this.localNotificationLaunchFireDate = 0;
    }

    private int LocalNotificationGetID() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("LocalNotificationPreferences", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String string = sharedPreferences.getString("notificationIDs", "");
        int i = 1;
        if (string.length() == 0) {
            edit.putString("notificationIDs", Integer.toString(1));
        } else {
            String[] split = string.split("-");
            ArrayList arrayList = new ArrayList();
            for (String str : split) {
                if (str.length() > 0) {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                }
            }
            while (arrayList.contains(Integer.valueOf(i))) {
                i++;
            }
            edit.putString("notificationIDs", string + "-" + i);
        }
        sharedPreferences.getString("notificationIDs", "");
        edit.commit();
        return i;
    }

    private ArrayList<Integer> LocalNotificationGetIDList() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("LocalNotificationPreferences", 0);
        sharedPreferences.edit();
        String string = sharedPreferences.getString("notificationIDs", "");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String str : string.split("-")) {
            if (str.length() > 0) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str)));
            }
        }
        return arrayList;
    }

    public String AndroidThunkJava_GetAllNotificationID() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("LocalNotificationPreferences", 0);
        sharedPreferences.edit();
        String string = sharedPreferences.getString("notificationIDs", "");
        Log.debug("==============> [JAVA] AndroidThunkJava_GetAllNotificationID() - Showing " + string);
        return string;
    }

    public void AndroidThunkJava_LocalNotificationRemoveID(int i) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("LocalNotificationPreferences", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String string = sharedPreferences.getString("notificationIDs", null);
        ArrayList arrayList = new ArrayList();
        if (string.length() == 0) {
            return;
        }
        for (String str : string.split("-")) {
            if (str.length() > 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.remove(Integer.toString(i))) {
            AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
            PendingIntent broadcast = PendingIntent.getBroadcast(this, i, new Intent(this, (Class<?>) LocalNotificationReceiver.class), 134217728);
            broadcast.cancel();
            alarmManager.cancel(broadcast);
        }
        String str2 = "";
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            str2 = str2.length() == 0 ? str3 : str2 + "-" + str3;
        }
        edit.putString("notificationIDs", str2);
        edit.commit();
        Log.debug("==============> [JAVA] AndroidThunkJava_LocalNotificationRemoveID() - Showing " + str2);
    }

    public void AndroidThunkJava_LocalNotificationScheduleAtTime(String str, boolean z, String str2, String str3, String str4, int i) {
        Intent intent = new Intent(this, (Class<?>) LocalNotificationReceiver.class);
        intent.putExtra("local-notification-ID", i);
        intent.putExtra("local-notification-title", str2);
        intent.putExtra("local-notification-body", str3);
        intent.putExtra("local-notification-action", str4);
        PendingIntent broadcast = PendingIntent.getBroadcast(this, i, intent, 134217728);
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        if (z) {
            timeZone = TimeZone.getDefault();
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(timeZone);
        new Date();
        try {
            Date parse = simpleDateFormat.parse(str);
            new Date();
            ((AlarmManager) getSystemService("alarm")).set(0, parse.getTime(), broadcast);
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("LocalNotificationPreferences", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String string = sharedPreferences.getString("notificationIDs", "");
            if (string.length() == 0) {
                edit.putString("notificationIDs", Integer.toString(i));
            } else {
                edit.putString("notificationIDs", string + "-" + i);
            }
            String string2 = sharedPreferences.getString("notificationIDs", "");
            edit.commit();
            Log.debug("==============> [JAVA] AndroidThunkJava_LocalNotificationScheduleAtTime() - Showing " + string2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /* loaded from: classes.dex */
    public class LaunchNotification {
        public String event;
        public int fireDate;
        public boolean used;

        LaunchNotification(boolean z, String str, int i) {
            this.used = z;
            this.event = str;
            this.fireDate = i;
        }
    }

    public LaunchNotification AndroidThunkJava_LocalNotificationGetLaunchNotification() {
        return new LaunchNotification(this.localNotificationAppLaunched, this.localNotificationLaunchActivationEvent, this.localNotificationLaunchFireDate);
    }

    public void AndroidThunkJava_LocalNotificationClearAll() {
        Iterator<Integer> it = LocalNotificationGetIDList().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            AlarmManager alarmManager = (AlarmManager) getSystemService("alarm");
            PendingIntent broadcast = PendingIntent.getBroadcast(this, intValue, new Intent(this, (Class<?>) LocalNotificationReceiver.class), 134217728);
            broadcast.cancel();
            alarmManager.cancel(broadcast);
        }
        SharedPreferences.Editor edit = getApplicationContext().getSharedPreferences("LocalNotificationPreferences", 0).edit();
        edit.putString("notificationIDs", "");
        edit.commit();
    }

    public void AndroidThunkJava_ClearNotifications() {
        try {
            ((NotificationManager) getApplicationContext().getSystemService("notification")).cancelAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* loaded from: classes.dex */
    public class InputDeviceInfo {
        public int controllerId;
        public String descriptor;
        public int deviceId;
        public String name;
        public int productId;
        public int vendorId;

        InputDeviceInfo(int i, int i2, int i3, int i4, String str, String str2) {
            this.deviceId = i;
            this.vendorId = i2;
            this.productId = i3;
            this.controllerId = i4;
            this.name = str;
            this.descriptor = str2;
        }
    }

    public InputDeviceInfo AndroidThunkJava_GetInputDeviceInfo(int i) {
        int i2;
        int i3;
        int i4;
        for (int i5 : InputDevice.getDeviceIds()) {
            InputDevice device = InputDevice.getDevice(i5);
            if (device.getId() == i) {
                String descriptor = ANDROID_BUILD_VERSION >= 16 ? device.getDescriptor() : Integer.toString(i);
                if (ANDROID_BUILD_VERSION >= 19) {
                    i2 = device.getVendorId();
                    i3 = device.getProductId();
                    i4 = device.getControllerNumber();
                    for (DeviceInfoData deviceInfoData : DeviceInfoList) {
                        if (deviceInfoData.IsMatch(i2, i3)) {
                            return new InputDeviceInfo(i, i2, i3, i4, deviceInfoData.name, descriptor);
                        }
                    }
                } else {
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                }
                return new InputDeviceInfo(i, i2, i3, i4, device.getName(), descriptor);
            }
        }
        return new InputDeviceInfo(i, 0, 0, -1, "Unknown", "Unknown");
    }

    public void AndroidThunkJava_UseSurfaceViewWorkaround() {
        if (this.bUseSurfaceView) {
            return;
        }
        this.bUseSurfaceView = true;
        Log.debug("[JAVA] Using SurfaceView sizing workaround for this device");
        if (this.DesiredHolderWidth <= 0 || this.DesiredHolderHeight <= 0 || this.MySurfaceView == null) {
            return;
        }
        _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.37
            @Override // java.lang.Runnable
            public void run() {
                GameActivity.this.MySurfaceView.getHolder().setFixedSize(GameActivity.this.DesiredHolderWidth, GameActivity.this.DesiredHolderHeight);
            }
        });
    }

    public void AndroidThunkJava_SetDesiredViewSize(int i, int i2) {
        if (i == this.DesiredHolderWidth && i2 == this.DesiredHolderHeight) {
            return;
        }
        Log.debug("[JAVA] - SetDesiredViewSize width=" + i + " and height=" + i2);
        this.DesiredHolderWidth = i;
        this.DesiredHolderHeight = i2;
        if (!this.bUseSurfaceView || this.MySurfaceView == null) {
            return;
        }
        _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.38
            @Override // java.lang.Runnable
            public void run() {
                GameActivity.this.MySurfaceView.getHolder().setFixedSize(GameActivity.this.DesiredHolderWidth, GameActivity.this.DesiredHolderHeight);
            }
        });
    }

    public boolean AndroidThunkJava_IsGamepadAttached() {
        for (int i : InputDevice.getDeviceIds()) {
            InputDevice device = InputDevice.getDevice(i);
            if ((device.getSources() & 1025) == 1025 || (device.getSources() & 16777232) == 16777232 || (device.getSources() & 513) == 513) {
                return true;
            }
        }
        return false;
    }

    public boolean AndroidThunkJava_HasActiveWiFiConnection() {
        NetWorkInfoReceiver netWorkInfoReceiver = this.netReceive;
        if (netWorkInfoReceiver != null && netWorkInfoReceiver.NetWorkType != -2) {
            return this.netReceive.NetWorkType == 1;
        }
        if (this.cm == null) {
            this.cm = (ConnectivityManager) getSystemService("connectivity");
        }
        NetworkInfo networkInfo = this.cm.getNetworkInfo(1);
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public int AndroidThunkJava_GetNetWorkType() {
        NetWorkInfoReceiver netWorkInfoReceiver = this.netReceive;
        if (netWorkInfoReceiver != null && netWorkInfoReceiver.NetWorkType != -2) {
            return this.netReceive.NetWorkType;
        }
        if (this.cm == null) {
            this.cm = (ConnectivityManager) getSystemService("connectivity");
        }
        for (int i = 1; i >= 0; i--) {
            NetworkInfo networkInfo = this.cm.getNetworkInfo(i);
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                return i;
            }
        }
        NetworkInfo activeNetworkInfo = this.cm.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public int AndroidThunkJava_GetNetWorkDetailType() {
        String str;
        int i;
        int i2;
        if (this.cm == null) {
            this.cm = (ConnectivityManager) getSystemService("connectivity");
        }
        NetWorkInfoReceiver netWorkInfoReceiver = this.netReceive;
        if (netWorkInfoReceiver != null && netWorkInfoReceiver.NetWorkType != -2) {
            i = this.netReceive.NetWorkType;
            i2 = this.netReceive.NetworkSubType;
            str = this.netReceive.SubTypeStringName;
        } else {
            NetworkInfo activeNetworkInfo = this.cm.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                i = activeNetworkInfo.getType();
                int subtype = activeNetworkInfo.getSubtype();
                str = activeNetworkInfo.getSubtypeName();
                i2 = subtype;
            } else {
                str = "";
                i = -1;
                i2 = -1;
            }
        }
        if (i < 0) {
            return -1;
        }
        if (i == 1) {
            return 1;
        }
        if (i != 0) {
            return i;
        }
        switch (i2) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 4;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 5;
            case 13:
            case 18:
                return 6;
            case 19:
            case 20:
            default:
                return (str.equalsIgnoreCase("WCDMA") || str.equalsIgnoreCase("CDMA2000")) ? 5 : 0;
        }
    }

    public boolean AndroidThunkJava_HasMetaDataKey(String str) {
        Bundle bundle = _bundle;
        if (bundle == null || str == null) {
            return false;
        }
        return bundle.containsKey(str);
    }

    public boolean AndroidThunkJava_GetMetaDataBoolean(String str) {
        Bundle bundle = _bundle;
        if (bundle == null || str == null) {
            return false;
        }
        return bundle.getBoolean(str);
    }

    public int AndroidThunkJava_GetMetaDataInt(String str) {
        if (str.equals("android.hardware.vulkan.version")) {
            return this.VulkanVersion;
        }
        if (str.equals("android.hardware.vulkan.level")) {
            return this.VulkanLevel;
        }
        if (str.equals("audiomanager.framesPerBuffer")) {
            int parseInt = Integer.parseInt(((AudioManager) getSystemService("audio")).getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER"));
            if (parseInt == 0) {
                parseInt = 256;
            }
            Log.debug("[JAVA] audiomanager.framesPerBuffer = " + parseInt);
            return parseInt;
        }
        if (str.equals("audiomanager.optimalSampleRate")) {
            int parseInt2 = Integer.parseInt(((AudioManager) getSystemService("audio")).getProperty("android.media.property.OUTPUT_SAMPLE_RATE"));
            if (parseInt2 == 0) {
                parseInt2 = 44100;
            }
            Log.debug("[JAVA] audiomanager.optimalSampleRate = " + parseInt2);
            return parseInt2;
        }
        Bundle bundle = _bundle;
        if (bundle == null || str == null) {
            return 0;
        }
        return bundle.getInt(str);
    }

    public String AndroidThunkJava_GetMetaDataString(String str) {
        if (str.equals("ue4.displaymetrics.dpi")) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (Build.VERSION.SDK_INT >= 17) {
                getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            } else {
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            }
            return new DecimalFormat("###.##").format(displayMetrics.xdpi) + "," + new DecimalFormat("###.##").format(displayMetrics.ydpi) + "," + new DecimalFormat("###.##").format(displayMetrics.densityDpi);
        }
        Bundle bundle = _bundle;
        if (bundle == null || str == null) {
            return null;
        }
        return bundle.getString(str);
    }

    public String AndroidThunkJava_GetExtraDataString(String str) {
        Bundle bundle = _extraBundle;
        if (bundle == null || str == null) {
            return null;
        }
        return bundle.getString(str);
    }

    public void AndroidThunkJava_SetSustainedPerformanceMode(final boolean z) {
        if (ANDROID_BUILD_VERSION >= 24) {
            Log.debug("==================================> SetSustainedPerformanceMode:" + z);
            _activity.runOnUiThread(new Runnable() { // from class: com.epicgames.ue4.GameActivity.39
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Window.class.getMethod("setSustainedPerformanceMode", Boolean.TYPE).invoke(GameActivity._activity.getWindow(), Boolean.valueOf(z));
                    } catch (Exception e) {
                        GameActivity.Log.debug("SetSustainedPerformanceMode: failed " + e.getMessage());
                    }
                }
            });
            return;
        }
        Log.debug("==================================> API<24, cannot use SetSustainedPerformanceMode");
    }

    public int getNotchDisplayCutoutWidth() {
        Object invoke;
        if (Build.VERSION.SDK_INT < 28) {
            return 0;
        }
        try {
            WindowInsets rootWindowInsets = getWindow().getDecorView().getRootWindowInsets();
            if (rootWindowInsets == null || (invoke = WindowInsets.class.getMethod(METHOD_GET_DISPLAY_CUTOUT, new Class[0]).invoke(rootWindowInsets, new Object[0])) == null) {
                return 0;
            }
            Class<?> cls = Class.forName(CLASS_DISPLAY_CUTOUT);
            int intValue = ((Integer) cls.getMethod(FIELD_GET_SAFE_INSET_LEFT, new Class[0]).invoke(invoke, new Object[0])).intValue();
            int intValue2 = ((Integer) cls.getMethod(FIELD_GET_SAFE_INSET_RIGHT, new Class[0]).invoke(invoke, new Object[0])).intValue();
            return intValue2 > intValue ? intValue2 : intValue;
        } catch (Exception unused) {
            Log.debug("Can't find cutout reflection");
            return 0;
        }
    }

    public int AndroidThunkJava_GetCutoutInset() {
        return getNotchDisplayCutoutWidth();
    }

    public int AndroidThunkJava_IsFullScreen() {
        return (getWindow().getAttributes().flags & 1024) == 1024 ? 1 : 0;
    }

    public int AndroidThunkJava_GetDeviceScreenBrightness() {
        int i = 0;
        try {
            i = Settings.System.getInt(getApplicationContext().getContentResolver(), "screen_brightness");
            Log.debug("GetDeviceBrightness : " + i);
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    /* loaded from: classes.dex */
    public class ConsoleKeyboardInput extends EditText {
        private ImageButton historyButton;
        private ArrayList<String> historyList;

        public ConsoleKeyboardInput(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            init(context);
        }

        public ConsoleKeyboardInput(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            init(context);
        }

        public ConsoleKeyboardInput(Context context) {
            super(context);
            init(context);
        }

        private void init(Context context) {
            this.historyList = new ArrayList<>();
            this.historyButton = new ImageButton(context);
            this.historyButton.setImageResource(R.drawable.ic_menu_revert);
            this.historyButton.setOnClickListener(new View.OnClickListener() { // from class: com.epicgames.ue4.GameActivity.ConsoleKeyboardInput.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (ConsoleKeyboardInput.this.historyList.size() > 0) {
                        String[] strArr = (String[]) ConsoleKeyboardInput.this.historyList.toArray(new String[ConsoleKeyboardInput.this.historyList.size()]);
                        AlertDialog.Builder builder = new AlertDialog.Builder(ConsoleKeyboardInput.this.getContext());
                        builder.setTitle("History");
                        builder.setCancelable(true);
                        builder.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.epicgames.ue4.GameActivity.ConsoleKeyboardInput.1.1
                            @Override // android.content.DialogInterface.OnClickListener
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String str = (String) ConsoleKeyboardInput.this.historyList.get(i);
                                GameActivity.this.consoleInputBox.removeHistory(str);
                                GameActivity.this.consoleInputBox.addHistory(str);
                                GameActivity.this.consoleInputBox.setText(str);
                                dialogInterface.dismiss();
                            }
                        });
                        builder.show();
                    }
                }
            });
            this.historyButton.setEnabled(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ImageButton getButton() {
            return this.historyButton;
        }

        public void setHistoryList(ArrayList<String> arrayList) {
            this.historyList = arrayList;
        }

        public void removeHistory(String str) {
            int indexOf = this.historyList.indexOf(str);
            if (indexOf >= 0) {
                this.historyList.remove(indexOf);
            }
            this.historyButton.setEnabled(this.historyList.size() > 0);
        }

        public void addHistory(String str) {
            this.historyList.add(0, str);
            this.historyButton.setEnabled(this.historyList.size() > 0);
        }

        public void setHistoryEnd() {
            this.historyButton.setEnabled(this.historyList.size() > 0);
        }
    }

    /* loaded from: classes.dex */
    public class VirtualKeyboardInput extends EditText {
        private EmojiExcludeFilter emojiExcludeFilter;

        public VirtualKeyboardInput(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            init();
        }

        public VirtualKeyboardInput(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            init();
        }

        public VirtualKeyboardInput(Context context) {
            super(context);
            init();
        }

        private void init() {
            if (this.emojiExcludeFilter == null) {
                this.emojiExcludeFilter = new EmojiExcludeFilter();
            }
            setFilters(new InputFilter[]{this.emojiExcludeFilter});
        }

        @Override // android.widget.TextView
        public void setFilters(InputFilter[] inputFilterArr) {
            if (inputFilterArr.length != 0 && this.emojiExcludeFilter != null) {
                int length = inputFilterArr.length;
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = true;
                        break;
                    } else if (inputFilterArr[i] == this.emojiExcludeFilter) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    inputFilterArr = (InputFilter[]) Arrays.copyOf(inputFilterArr, inputFilterArr.length + 1);
                    inputFilterArr[inputFilterArr.length - 1] = this.emojiExcludeFilter;
                }
            }
            super.setFilters(inputFilterArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class EmojiExcludeFilter implements InputFilter {
            private EmojiExcludeFilter() {
            }

            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                while (i < i2) {
                    int type = Character.getType(charSequence.charAt(i));
                    if (type == 19 || type == 28) {
                        return "";
                    }
                    i++;
                }
                return null;
            }
        }

        @Override // android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0) {
                GameActivity.this.AndroidThunkJava_HideVirtualKeyboardInput();
                GameActivity.this.nativeVirtualKeyboardSendKey(4);
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            return new VirtualKeyboardInputConnection(super.onCreateInputConnection(editorInfo), true, this);
        }

        /* loaded from: classes.dex */
        private class VirtualKeyboardInputConnection extends InputConnectionWrapper {
            VirtualKeyboardInput owner;

            public VirtualKeyboardInputConnection(InputConnection inputConnection, boolean z, VirtualKeyboardInput virtualKeyboardInput) {
                super(inputConnection, z);
                this.owner = virtualKeyboardInput;
            }

            private void replaceSubstring(String str) {
                StringBuffer stringBuffer = new StringBuffer(this.owner.getText().toString());
                int selectionStart = this.owner.getSelectionStart();
                int selectionEnd = this.owner.getSelectionEnd();
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                if (min != max) {
                    stringBuffer.replace(min, max, str);
                } else if (str.length() > 0) {
                    stringBuffer.insert(min, str);
                } else if (min > 0) {
                    min--;
                    stringBuffer.replace(min, min + 1, "");
                }
                if (str.length() == 0) {
                    min--;
                }
                this.owner.getText().clear();
                this.owner.append(stringBuffer.toString());
                this.owner.setSelection(min + 1);
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean sendKeyEvent(KeyEvent keyEvent) {
                GameActivity.Log.debug("VK: sendKeyEvent " + keyEvent.getKeyCode());
                if (keyEvent.getAction() != 0) {
                    return true;
                }
                if (keyEvent.getKeyCode() >= 7 && keyEvent.getKeyCode() <= 16) {
                    replaceSubstring(String.valueOf((char) ((keyEvent.getKeyCode() - 7) + 48)));
                    return true;
                }
                if (keyEvent.getKeyCode() >= 144 && keyEvent.getKeyCode() <= 153) {
                    replaceSubstring(String.valueOf((char) ((keyEvent.getKeyCode() - 144) + 48)));
                    return true;
                }
                if (keyEvent.getKeyCode() == 67) {
                    replaceSubstring("");
                    return true;
                }
                if (keyEvent.getKeyCode() != 66) {
                    return true;
                }
                if ((VirtualKeyboardInput.this.getInputType() & 131072) != 0) {
                    replaceSubstring("\n");
                    return true;
                }
                GameActivity.this.AndroidThunkJava_HideVirtualKeyboardInput();
                GameActivity.this.nativeVirtualKeyboardSendKey(66);
                return true;
            }

            @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
            public boolean deleteSurroundingText(int i, int i2) {
                if (i == 1 && i2 == 0) {
                    return sendKeyEvent(new KeyEvent(0, 67)) && sendKeyEvent(new KeyEvent(1, 67));
                }
                return super.deleteSurroundingText(i, i2);
            }
        }
    }

    private void createVirtualKeyboardInput() {
        getWindow().setSoftInputMode(16);
        this.newVirtualKeyboardInput = new VirtualKeyboardInput(this);
        this.newVirtualKeyboardInput.setPadding(100, 0, 100, 0);
        this.newVirtualKeyboardInput.setSingleLine(false);
        this.newVirtualKeyboardInput.setBackgroundColor(-1);
        this.newVirtualKeyboardInput.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.newVirtualKeyboardInput.setVisibility(8);
        if (ANDROID_BUILD_VERSION < 11) {
            this.newVirtualKeyboardInput.setImeOptions(DriveFile.MODE_READ_ONLY);
        } else {
            this.newVirtualKeyboardInput.setImeOptions(301989888);
        }
        this.newVirtualKeyboardInput.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.epicgames.ue4.GameActivity.40
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i & 255) != 6) {
                    return false;
                }
                GameActivity.this.AndroidThunkJava_HideVirtualKeyboardInput();
                GameActivity.this.nativeVirtualKeyboardSendKey(66);
                return true;
            }
        });
        this.newVirtualKeyboardInput.addTextChangedListener(new TextWatcher() { // from class: com.epicgames.ue4.GameActivity.41
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence.length() == 0) {
                    GameActivity.this.virtualKeyboardHandler.postDelayed(new Runnable() { // from class: com.epicgames.ue4.GameActivity.41.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GameActivity.this.nativeVirtualKeyboardChanged(GameActivity.this.newVirtualKeyboardInput.getText().toString());
                        }
                    }, 100L);
                } else {
                    GameActivity.this.nativeVirtualKeyboardChanged(GameActivity.this.newVirtualKeyboardInput.getText().toString());
                }
            }
        });
        this.virtualKeyboardLayout.addView(this.newVirtualKeyboardInput);
        this.virtualKeyboardHandler = new Handler(Looper.getMainLooper());
        this.showWindowImeHandler = new Handler(Looper.getMainLooper());
    }

    public boolean AndroidThunkJava_VirtualInputIgnoreClick(int i, int i2) {
        View currentFocus = getCurrentFocus();
        if (currentFocus != this.newVirtualKeyboardInput) {
            return false;
        }
        Rect rect = new Rect();
        currentFocus.getGlobalVisibleRect(rect);
        return rect.contains(i, i2) || this.newVirtualKeyboardInput.getY() < 0.0f;
    }

    public void AndroidThunkJava_ClipboardCopy(String str) {
        if (str.isEmpty()) {
            return;
        }
        _clipboardManager.setPrimaryClip(ClipData.newPlainText(null, str));
    }

    public String AndroidThunkJava_ClipboardPaste() {
        if (_clipboardManager.hasPrimaryClip()) {
            return _clipboardManager.getPrimaryClip().getItemAt(0).getText().toString();
        }
        return null;
    }

    public static String getSystemProperty(String str) {
        Process process;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                process = Runtime.getRuntime().exec("getprop " + str);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    readLine = "";
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                    Log.debug("Exception while closing InputStream");
                }
                if (process != null) {
                    process.destroy();
                }
                return readLine;
            } catch (IOException unused3) {
                bufferedReader2 = bufferedReader;
                Log.debug("Unable to read sysprop " + str);
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused4) {
                        Log.debug("Exception while closing InputStream");
                    }
                }
                if (process != null) {
                    process.destroy();
                }
                return "";
            } catch (Throwable th2) {
                th = th2;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException unused5) {
                        Log.debug("Exception while closing InputStream");
                    }
                }
                if (process == null) {
                    throw th;
                }
                process.destroy();
                throw th;
            }
        } catch (IOException unused6) {
            process = null;
        } catch (Throwable th3) {
            th = th3;
            process = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x00ce -> B:43:0x00e8). Please report as a decompilation issue!!! */
    public boolean AndroidThunkJava_IsCPUInfo64() {
        FileInputStream fileInputStream;
        Throwable th;
        Throwable th2;
        BufferedReader bufferedReader;
        String readLine;
        ?? file = new File(PROC_CPU_INFO_PATH);
        if (!file.exists()) {
            return false;
        }
        try {
            try {
                try {
                    fileInputStream = new FileInputStream((File) file);
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                fileInputStream = null;
                th = th4;
                file = 0;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 512);
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine != null && LOGENABLE) {
                        Log.debug("###############isCPUInfo64() line: " + readLine);
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    if (LOGENABLE) {
                        Log.debug("###############isCPUInfo64()read /proc/cpuinfo error = " + th2.toString());
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (fileInputStream == null) {
                        return false;
                    }
                    fileInputStream.close();
                    return false;
                }
            } catch (Throwable th6) {
                th = th6;
                file = 0;
                if (file != 0) {
                    try {
                        file.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (fileInputStream == null) {
                    throw th;
                }
                try {
                    fileInputStream.close();
                    throw th;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    throw th;
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (readLine == null || readLine.length() <= 0 || !readLine.toLowerCase(Locale.US).contains("arch64")) {
            if (LOGENABLE) {
                Log.debug("###############isCPUInfo64()/proc/cpuinfo is not arch64");
            }
            try {
                bufferedReader.close();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            fileInputStream.close();
            return false;
        }
        if (LOGENABLE) {
            Log.debug("###############isCPUInfo64()/proc/cpuinfo contains is arch64");
        }
        try {
            bufferedReader.close();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            fileInputStream.close();
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        return true;
    }

    public boolean AndroidThunkJava_IsCPUAbi64() {
        return getSystemProperty(CPU_ARCHITECTURE_KEY_64, "").length() > 0;
    }

    private static String getSystemProperty(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str2 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
        } catch (Exception e) {
            if (LOGENABLE) {
                Log.debug("getSystemPropertykey = " + str + ", error = " + e.getMessage());
            }
        }
        if (LOGENABLE) {
            Log.debug("getSystemProperty" + str + " = " + str2);
        }
        return str2;
    }

    public String AndroidTrunkCpp_GetBrandROMVersion() {
        Log.debug("GetBrandROMVersion start]");
        if ("Xiaomi".equals(Build.MANUFACTURER)) {
            return getSystemProperty("ro.miui.version.code_time");
        }
        if ("HUAWEI".equals(Build.MANUFACTURER)) {
            return getSystemProperty("ro.build.version.emui");
        }
        if ("OPPO".equals(Build.MANUFACTURER)) {
            return getSystemProperty("ro.build.version.opporom");
        }
        if ("vivo".equals(Build.MANUFACTURER)) {
            return getSystemProperty("ro.vivo.os.version");
        }
        return Build.DISPLAY;
    }

    public String AndroidTrunkCpp_GetMainBoradInfo() {
        String str = "Empty";
        try {
            str = getSystemProperty("ro.board.platform");
            Log.debug("GetMainBoradInfo:" + str);
            return str;
        } catch (Exception unused) {
            Log.debug("Exception while Get MainBorad Info");
            return str;
        }
    }

    public int AndroidThunkJava_GetDeviceOrientation() {
        return getWindowManager().getDefaultDisplay().getRotation();
    }

    /* loaded from: classes.dex */
    public class ChangeOrientationHandler extends Handler {
        private Activity activity;

        public ChangeOrientationHandler(Activity activity) {
            this.activity = activity;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 888) {
                int i = message.arg1;
                if (i > 45 && i < 135) {
                    this.activity.setRequestedOrientation(8);
                } else if (i <= 135 || i >= 225) {
                    if (i > 225 && i < 315) {
                        this.activity.setRequestedOrientation(0);
                    } else if (i > 315) {
                    }
                }
            }
            super.handleMessage(message);
        }
    }

    /* loaded from: classes.dex */
    public class OrientationSensorListener implements SensorEventListener {
        public static final int ORIENTATION_UNKNOWN = -1;
        private static final int _DATA_X = 0;
        private static final int _DATA_Y = 1;
        private static final int _DATA_Z = 2;
        private Handler rotateHandler;

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        public OrientationSensorListener(Handler handler) {
            this.rotateHandler = handler;
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            int i;
            float[] fArr = sensorEvent.values;
            float f = -fArr[0];
            float f2 = -fArr[1];
            float f3 = -fArr[2];
            if (((f * f) + (f2 * f2)) * 4.0f >= f3 * f3) {
                i = 90 - Math.round(((float) Math.atan2(-f2, f)) * 57.29578f);
                while (i >= 360) {
                    i += PresenterCode.Code_Engine_Add_Evaluate_Error;
                }
                while (i < 0) {
                    i += 360;
                }
            } else {
                i = -1;
            }
            Handler handler = this.rotateHandler;
            if (handler != null) {
                handler.obtainMessage(888, i, 0).sendToTarget();
            }
        }
    }

    public boolean hasNotchInScreen_HW(Context context) {
        Logger logger;
        StringBuilder sb;
        boolean z = false;
        try {
            try {
                try {
                    Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                    z = ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
                    Log.debug("Notch hasNotchInScreen_HW result1: " + z);
                    logger = Log;
                    sb = new StringBuilder();
                } catch (NoSuchMethodException e) {
                    Log.debug("Notch hasNotchInScreen_HW NoSuchMethodException" + e.getMessage());
                    logger = Log;
                    sb = new StringBuilder();
                }
            } catch (ClassNotFoundException e2) {
                Log.debug("Notch hasNotchInScreen_HW ClassNotFoundException" + e2.getMessage());
                logger = Log;
                sb = new StringBuilder();
            } catch (Exception e3) {
                Log.debug("Notch hasNotchInScreen_HW Exception" + e3.getMessage());
                logger = Log;
                sb = new StringBuilder();
            }
        } catch (Throwable unused) {
            logger = Log;
            sb = new StringBuilder();
        }
        sb.append("Notch hasNotchInScreen_HW result2: ");
        sb.append(z);
        logger.debug(sb.toString());
        return z;
    }

    public int[] getNotchSize_HW(Context context) {
        Logger logger;
        StringBuilder sb;
        int[] iArr;
        int[] iArr2 = {0, 0};
        try {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                iArr = (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
            } catch (Throwable unused) {
            }
        } catch (ClassNotFoundException e) {
            e = e;
        } catch (NoSuchMethodException e2) {
            e = e2;
        } catch (Exception e3) {
            e = e3;
        }
        try {
            Log.debug("Notch getNotchSize_HW result1: " + toStringMethod(iArr));
            Log.debug("Notch getNotchSize_HW result2: " + toStringMethod(iArr));
            return iArr;
        } catch (ClassNotFoundException e4) {
            iArr2 = iArr;
            e = e4;
            Log.debug("Notch getNotchSize_HW ClassNotFoundException" + e.getMessage());
            logger = Log;
            sb = new StringBuilder();
            sb.append("Notch getNotchSize_HW result2: ");
            sb.append(toStringMethod(iArr2));
            logger.debug(sb.toString());
            return iArr2;
        } catch (NoSuchMethodException e5) {
            iArr2 = iArr;
            e = e5;
            Log.debug("Notch getNotchSize_HW NoSuchMethodException" + e.getMessage());
            logger = Log;
            sb = new StringBuilder();
            sb.append("Notch getNotchSize_HW result2: ");
            sb.append(toStringMethod(iArr2));
            logger.debug(sb.toString());
            return iArr2;
        } catch (Exception e6) {
            iArr2 = iArr;
            e = e6;
            Log.debug("Notch getNotchSize_HW Exception" + e.getMessage());
            logger = Log;
            sb = new StringBuilder();
            sb.append("Notch getNotchSize_HW result2: ");
            sb.append(toStringMethod(iArr2));
            logger.debug(sb.toString());
            return iArr2;
        } catch (Throwable unused2) {
            iArr2 = iArr;
            logger = Log;
            sb = new StringBuilder();
            sb.append("Notch getNotchSize_HW result2: ");
            sb.append(toStringMethod(iArr2));
            logger.debug(sb.toString());
            return iArr2;
        }
    }

    public boolean hasNotchInScreen_OPPO(Context context) {
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        Log.debug("Notch hasNotchInScreen_OPPO result: " + hasSystemFeature);
        return hasSystemFeature;
    }

    public int[] getNotchSize_OPPO(Context context) {
        int[] iArr = {0, 0};
        String str = "";
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            String str2 = (String) loadClass.getMethod("get", String.class).invoke(loadClass.newInstance(), "ro.oppo.screen.heteromorphism");
            try {
                Log.debug("Notch getNotchSize_OPPO result1: " + str2);
                str = str2.replace("[", "").replace("]", "").replace(CertificateUtil.DELIMITER, ",");
                String[] split = str.split(",");
                if (split.length == 4) {
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    int parseInt3 = Integer.parseInt(split[2]);
                    int parseInt4 = Integer.parseInt(split[3]);
                    int i = parseInt3 > parseInt ? parseInt3 - parseInt : parseInt - parseInt3;
                    if (parseInt2 > parseInt4) {
                        parseInt4 = parseInt2;
                    }
                    iArr[0] = i;
                    iArr[1] = parseInt4;
                    Log.debug("Notch getNotchSize_OPPO width: " + i + " height: " + parseInt4);
                }
            } catch (ClassNotFoundException e) {
                str = str2;
                e = e;
                Log.debug("Notch getNotchSize_OPPO ClassNotFoundException: " + e.getMessage());
                Log.debug("Notch getNotchSize_OPPO result2: " + str);
                return iArr;
            } catch (IllegalAccessException e2) {
                str = str2;
                e = e2;
                Log.debug("Notch getNotchSize_OPPO IllegalAccessException: " + e.getMessage());
                Log.debug("Notch getNotchSize_OPPO result2: " + str);
                return iArr;
            } catch (IllegalArgumentException e3) {
                str = str2;
                e = e3;
                Log.debug("Notch getNotchSize_OPPO IllegalArgumentException: " + e.getMessage());
                Log.debug("Notch getNotchSize_OPPO result2: " + str);
                return iArr;
            } catch (InstantiationException e4) {
                str = str2;
                e = e4;
                Log.debug("Notch getNotchSize_OPPO InstantiationException: " + e.getMessage());
                Log.debug("Notch getNotchSize_OPPO result2: " + str);
                return iArr;
            } catch (NoSuchMethodException e5) {
                str = str2;
                e = e5;
                Log.debug("Notch getNotchSize_OPPO NoSuchMethodException: " + e.getMessage());
                Log.debug("Notch getNotchSize_OPPO result2: " + str);
                return iArr;
            } catch (Exception unused) {
                str = str2;
                Log.debug("Notch getNotchSize_OPPO hasNotchInScreen Exception: ");
                Log.debug("Notch getNotchSize_OPPO result2: " + str);
                return iArr;
            }
        } catch (ClassNotFoundException e6) {
            e = e6;
        } catch (IllegalAccessException e7) {
            e = e7;
        } catch (IllegalArgumentException e8) {
            e = e8;
        } catch (InstantiationException e9) {
            e = e9;
        } catch (NoSuchMethodException e10) {
            e = e10;
        } catch (Exception unused2) {
        }
        Log.debug("Notch getNotchSize_OPPO result2: " + str);
        return iArr;
    }

    public boolean hasNotchInScreen_VIVO(Context context) {
        Logger logger;
        StringBuilder sb;
        boolean z = false;
        try {
            try {
                try {
                    try {
                        Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                        z = ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
                        Log.debug("Notch hasNotchInScreen_VIVO result1: " + z);
                        logger = Log;
                        sb = new StringBuilder();
                    } catch (NoSuchMethodException e) {
                        Log.debug("Notch hasNotchInScreen_VIVO NoSuchMethodException " + e.getMessage());
                        logger = Log;
                        sb = new StringBuilder();
                    }
                } catch (Exception e2) {
                    Log.debug("Notch hasNotchInScreen_VIVO Exception " + e2.getMessage());
                    logger = Log;
                    sb = new StringBuilder();
                }
            } catch (ClassNotFoundException e3) {
                Log.debug("Notch hasNotchInScreen_VIVO ClassNotFoundException " + e3.getMessage());
                logger = Log;
                sb = new StringBuilder();
            }
        } catch (Throwable unused) {
            logger = Log;
            sb = new StringBuilder();
        }
        sb.append("Notch hasNotchInScreen_VIVO result2: ");
        sb.append(z);
        logger.debug(sb.toString());
        return z;
    }

    public boolean hasRoundInScreen_VIVO(Context context) {
        Logger logger;
        StringBuilder sb;
        boolean z = false;
        try {
            try {
                try {
                    try {
                        Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                        z = ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 8)).booleanValue();
                        Log.debug("Notch hasRoundInScreen_VIVO result1: " + z);
                        logger = Log;
                        sb = new StringBuilder();
                    } catch (NoSuchMethodException e) {
                        Log.debug("Notch hasRoundInScreen_VIVO NoSuchMethodException: " + e.getMessage());
                        logger = Log;
                        sb = new StringBuilder();
                    }
                } catch (Exception e2) {
                    Log.debug("Notch hasRoundInScreen_VIVO Exception: " + e2.getMessage());
                    logger = Log;
                    sb = new StringBuilder();
                }
            } catch (ClassNotFoundException e3) {
                Log.debug("Notch hasRoundInScreen_VIVO ClassNotFoundException: " + e3.getMessage());
                logger = Log;
                sb = new StringBuilder();
            }
        } catch (Throwable unused) {
            logger = Log;
            sb = new StringBuilder();
        }
        sb.append("Notch hasRoundInScreen_VIVO result2: ");
        sb.append(z);
        logger.debug(sb.toString());
        return z;
    }

    public int[] getNotchSize_VIVO(Context context) {
        int[] iArr = {0, 0};
        try {
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier > 0 ? getResources().getDimensionPixelSize(identifier) : -1;
            Log.debug("状态栏-方法1:" + dimensionPixelSize);
            if (dimensionPixelSize > 0) {
                iArr[1] = dimensionPixelSize;
            } else {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                int dimensionPixelSize2 = getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
                Log.debug("状态栏-方法2:" + dimensionPixelSize2);
                if (dimensionPixelSize2 > 0) {
                    iArr[1] = dimensionPixelSize2;
                }
            }
        } catch (Exception e) {
            Log.debug("Notch getNotchSize_VIVO Exception: " + e.getMessage());
        }
        Log.debug("Notch getNotchSize_VIVO width: " + iArr[0] + " height: " + iArr[1]);
        return iArr;
    }

    public boolean hasNotchInScreen_MIUI(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            r0 = ((Integer) loadClass.getMethod("getInt", String.class).invoke(loadClass.newInstance(), "ro.miui.notch")).intValue() == 1;
            Log.debug("Notch hasNotchInScreen_MIUI result1: " + r0);
        } catch (Exception e) {
            Log.debug("Notch hasNotchInScreen_MIUI Exception: " + e.getMessage());
        }
        Log.debug("Notch hasNotchInScreen_MIUI result2: " + r0);
        return r0;
    }

    public int[] getNotchSize_MIUI(Context context) {
        int i;
        int i2;
        int i3;
        int[] iArr = {0, 0};
        try {
            int identifier = context.getResources().getIdentifier("notch_width", "dimen", "android");
            i = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
            try {
                int identifier2 = context.getResources().getIdentifier("notch_height", "dimen", "android");
                i3 = identifier2 > 0 ? context.getResources().getDimensionPixelSize(identifier2) : 0;
            } catch (Exception e) {
                e = e;
                i2 = 0;
                Log.debug("Notch hasNotchInScreen_MIUI Exception: " + e.getMessage());
                i3 = i2;
                iArr[0] = i;
                iArr[1] = i3;
                Log.debug("Notch hasNotchInScreen_MIUI 2 width: " + iArr[0] + " height: " + iArr[1]);
                return iArr;
            }
            try {
                Log.debug("Notch getNotchSize_MIUI 1 width: " + i + " height: " + i3);
            } catch (Exception e2) {
                i2 = i3;
                e = e2;
                Log.debug("Notch hasNotchInScreen_MIUI Exception: " + e.getMessage());
                i3 = i2;
                iArr[0] = i;
                iArr[1] = i3;
                Log.debug("Notch hasNotchInScreen_MIUI 2 width: " + iArr[0] + " height: " + iArr[1]);
                return iArr;
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
        }
        iArr[0] = i;
        iArr[1] = i3;
        Log.debug("Notch hasNotchInScreen_MIUI 2 width: " + iArr[0] + " height: " + iArr[1]);
        return iArr;
    }

    public boolean hasNotchInScreen_AndroidQ(Context context) {
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        List<Rect> boundingRects;
        Log.debug("Notch hasNotchInScreen_AndroidQ SDK_INT: " + Build.VERSION.SDK_INT);
        boolean z = false;
        try {
            if (Build.VERSION.SDK_INT >= 28 && (rootWindowInsets = getWindow().getDecorView().getRootWindowInsets()) != null && (displayCutout = rootWindowInsets.getDisplayCutout()) != null && (boundingRects = displayCutout.getBoundingRects()) != null && boundingRects.size() > 0) {
                z = true;
                Log.debug("Notch hasNotchInScreen_AndroidQ 1 isNotchScreen: true");
            }
        } catch (Exception e) {
            Log.debug("Notch hasNotchInScreen_AndroidQ Exception: " + e.getMessage());
        }
        Log.debug("Notch hasNotchInScreen_AndroidQ 2 isNotchScreen: " + z);
        return z;
    }

    public int[] getNotchSize_AndroidQ(Context context) {
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        int[] iArr = {0, 0};
        try {
            if (Build.VERSION.SDK_INT >= 28 && (rootWindowInsets = getWindow().getDecorView().getRootWindowInsets()) != null && (displayCutout = rootWindowInsets.getDisplayCutout()) != null) {
                Log.debug("Notch getNotchSize_AndroidQ getBoundingRects: " + displayCutout.getBoundingRects());
                Log.debug("Notch getNotchSize_AndroidQ getSafeInsetBottom: " + displayCutout.getSafeInsetBottom());
                Log.debug("Notch getNotchSize_AndroidQ getSafeInsetLeft: " + displayCutout.getSafeInsetLeft());
                Log.debug("Notch getNotchSize_AndroidQ getSafeInsetRight: " + displayCutout.getSafeInsetRight());
                Log.debug("Notch getNotchSize_AndroidQ getSafeInsetTop: " + displayCutout.getSafeInsetTop());
                List<Rect> boundingRects = displayCutout.getBoundingRects();
                int size = boundingRects.size();
                for (int i = 0; i < size; i++) {
                    Rect rect = boundingRects.get(i);
                    if (rect != null) {
                        Log.debug("Notch hasNotchInScreen_AndroidQ rect left: " + rect.left + " right: " + rect.right + " top: " + rect.top + " bottom: " + rect.bottom + " width: " + rect.width() + " height: " + rect.height());
                    }
                }
                int safeInsetTop = displayCutout.getSafeInsetTop();
                int safeInsetLeft = displayCutout.getSafeInsetLeft();
                int safeInsetBottom = displayCutout.getSafeInsetBottom();
                int safeInsetRight = displayCutout.getSafeInsetRight();
                if (safeInsetTop <= safeInsetBottom) {
                    safeInsetTop = safeInsetBottom;
                }
                iArr[0] = safeInsetTop;
                if (safeInsetLeft > safeInsetRight) {
                    safeInsetRight = safeInsetLeft;
                }
                iArr[1] = safeInsetRight;
                int screenOrientation = getScreenOrientation();
                Log.debug("Notch hasNotchInScreen_AndroidQ width: " + iArr[0] + " height: " + iArr[1] + " orientation" + screenOrientation);
            }
        } catch (Exception e) {
            Log.debug("Notch hasNotchInScreen_AndroidQ Exception: " + e.getMessage());
        }
        Log.debug("Notch hasNotchInScreen_AndroidQ width: " + iArr[0] + " height: " + iArr[1]);
        return iArr;
    }

    private String toStringMethod(int[] iArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < iArr.length; i++) {
            if (i != iArr.length - 1) {
                sb.append(iArr[i] + " ,");
            } else {
                sb.append(iArr[i] + " ]");
            }
        }
        String sb2 = sb.toString();
        System.out.println(sb);
        return sb2;
    }

    public boolean AndroidThunkJava_HasNotchInScreen() {
        Context applicationContext = getApplicationContext();
        return hasNotchInScreen_HW(applicationContext) || hasNotchInScreen_OPPO(applicationContext) || hasNotchInScreen_VIVO(applicationContext) || hasNotchInScreen_MIUI(applicationContext) || hasNotchInScreen_AndroidQ(applicationContext);
    }

    public String AndroidThunkJava_GetNotchSize() {
        String str = "";
        Context applicationContext = getApplicationContext();
        if (hasNotchInScreen_AndroidQ(applicationContext)) {
            int[] notchSize_AndroidQ = getNotchSize_AndroidQ(applicationContext);
            if (notchSize_AndroidQ.length == 2 && (notchSize_AndroidQ[0] != 0 || notchSize_AndroidQ[1] != 0)) {
                return notchSize_AndroidQ[0] + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + notchSize_AndroidQ[1];
            }
        }
        if (hasNotchInScreen_HW(applicationContext)) {
            int[] notchSize_HW = getNotchSize_HW(applicationContext);
            if (notchSize_HW.length == 2 && (notchSize_HW[0] != 0 || notchSize_HW[1] != 0)) {
                return notchSize_HW[0] + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + notchSize_HW[1];
            }
        }
        if (hasNotchInScreen_OPPO(applicationContext)) {
            int[] notchSize_OPPO = getNotchSize_OPPO(applicationContext);
            if (notchSize_OPPO.length == 2 && (notchSize_OPPO[0] != 0 || notchSize_OPPO[1] != 0)) {
                return notchSize_OPPO[0] + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + notchSize_OPPO[1];
            }
        }
        if (hasNotchInScreen_VIVO(applicationContext)) {
            int[] notchSize_VIVO = getNotchSize_VIVO(applicationContext);
            if (notchSize_VIVO.length == 2 && (notchSize_VIVO[0] != 0 || notchSize_VIVO[1] != 0)) {
                return notchSize_VIVO[0] + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + notchSize_VIVO[1];
            }
        }
        if (hasRoundInScreen_VIVO(applicationContext)) {
            return "50_50";
        }
        if (hasNotchInScreen_MIUI(applicationContext)) {
            int[] notchSize_MIUI = getNotchSize_MIUI(applicationContext);
            str = notchSize_MIUI[0] + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + notchSize_MIUI[1];
        }
        Log.debug("Notch AndroidThunkJava_GetNotchSize: " + str);
        return str;
    }

    public static boolean checkIfCPUx86() {
        return getSystemProperty("ro.product.cpu.abi", "arm").contains("x86");
    }

    public static String getArchType(Context context) {
        String str;
        if (LOGENABLE) {
            Log.debug("###############getArchType: getSystemProperty() = " + getSystemProperty(CPU_ARCHITECTURE_KEY_64, ""));
            Log.debug("###############getArchType: isCPUInfo64() = " + isCPUInfo64());
            Log.debug("###############getArchType: isLibc64() = " + isLibc64());
        }
        if (isCPUInfo64()) {
            if (LOGENABLE) {
                Log.debug("###############isCPUInfo64(): CPU:64");
            }
            str = "CPU:" + CPU_ARCHITECTURE_TYPE_64;
        } else {
            if (LOGENABLE) {
                Log.debug("###############isCPUInfo64(): CPU:32");
            }
            str = "CPU:" + CPU_ARCHITECTURE_TYPE_32;
        }
        if (getSystemProperty(CPU_ARCHITECTURE_KEY_64, "").length() > 0) {
            if (LOGENABLE) {
                Log.debug("###############getSystemPropertyCPU arch is 64bit");
            }
            return str + ",SYS:" + CPU_ARCHITECTURE_TYPE_64;
        }
        if (isLibc64()) {
            if (LOGENABLE) {
                Log.debug("###############isLibc64()return cpu DEFAULT 64bit!");
            }
            return str + ",SYS:" + CPU_ARCHITECTURE_TYPE_64;
        }
        if (LOGENABLE) {
            Log.debug("###############getArchType()return cpu DEFAULT 32bit!");
        }
        return str + ",SYS:" + CPU_ARCHITECTURE_TYPE_32;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x00ce -> B:43:0x00e8). Please report as a decompilation issue!!! */
    private static boolean isCPUInfo64() {
        FileInputStream fileInputStream;
        Throwable th;
        Throwable th2;
        BufferedReader bufferedReader;
        String readLine;
        ?? file = new File(PROC_CPU_INFO_PATH);
        if (!file.exists()) {
            return false;
        }
        try {
            try {
                try {
                    fileInputStream = new FileInputStream((File) file);
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                fileInputStream = null;
                th = th4;
                file = 0;
            }
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 512);
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine != null && LOGENABLE) {
                        Log.debug("###############isCPUInfo64() line: " + readLine);
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    if (LOGENABLE) {
                        Log.debug("###############isCPUInfo64()read /proc/cpuinfo error = " + th2.toString());
                    }
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (fileInputStream == null) {
                        return false;
                    }
                    fileInputStream.close();
                    return false;
                }
            } catch (Throwable th6) {
                th = th6;
                file = 0;
                if (file != 0) {
                    try {
                        file.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (fileInputStream == null) {
                    throw th;
                }
                try {
                    fileInputStream.close();
                    throw th;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    throw th;
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (readLine == null || readLine.length() <= 0 || !readLine.toLowerCase(Locale.US).contains("arch64")) {
            if (LOGENABLE) {
                Log.debug("###############isCPUInfo64()/proc/cpuinfo is not arch64");
            }
            try {
                bufferedReader.close();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            fileInputStream.close();
            return false;
        }
        if (LOGENABLE) {
            Log.debug("###############isCPUInfo64()/proc/cpuinfo contains is arch64");
        }
        try {
            bufferedReader.close();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            fileInputStream.close();
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        return true;
    }

    private static boolean isLibc64() {
        byte[] readELFHeadrIndentArray;
        byte[] readELFHeadrIndentArray2;
        File file = new File(SYSTEM_LIB_C_PATH);
        if (file.exists() && (readELFHeadrIndentArray2 = readELFHeadrIndentArray(file)) != null && readELFHeadrIndentArray2[4] == 2) {
            if (LOGENABLE) {
                Log.debug("###############isLibc64()/system/lib/libc.so is 64bit");
            }
            return true;
        }
        File file2 = new File(SYSTEM_LIB_C_PATH_64);
        if (!file2.exists() || (readELFHeadrIndentArray = readELFHeadrIndentArray(file2)) == null || readELFHeadrIndentArray[4] != 2) {
            return false;
        }
        if (LOGENABLE) {
            Log.debug("###############isLibc64()/system/lib64/libc.so is 64bit");
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0041 -> B:17:0x007c). Please report as a decompilation issue!!! */
    private static byte[] readELFHeadrIndentArray(File file) {
        FileInputStream fileInputStream;
        byte[] bArr;
        int read;
        if (file != null) {
            ?? exists = file.exists();
            try {
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (exists != 0) {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            bArr = new byte[16];
                            read = fileInputStream.read(bArr, 0, 16);
                        } catch (Throwable th) {
                            th = th;
                            if (LOGENABLE) {
                                Log.error("readELFHeadrIndentArrayError:" + th.toString());
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        exists = 0;
                        if (exists != 0) {
                            try {
                                exists.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    if (read != 16) {
                        if (LOGENABLE) {
                            Log.error("readELFHeadrIndentArrayError: e_indent lenght should be 16, but actual is " + read);
                        }
                        fileInputStream.close();
                    } else {
                        try {
                            fileInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        return bArr;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    public String AndroidThunkJava_GetAndroidSysInfo() {
        String archType = getArchType(null);
        Log.debug("Notch AndroidThunkJava_GetAndroidSysInfo: " + archType);
        return archType;
    }

    public boolean AndroidThunkJava_NotificationsEnabled() {
        try {
            boolean a2 = k.a(this).a();
            Log.debug("AndroidThunkJava_NotificationsEnabled return: " + a2);
            return a2;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public void AndroidThunkJava_DirectToSetting() {
        JumpToAppDetailSetting();
    }

    public void AndroidThunkJava_DirectToNotificationSetup() {
        try {
            String prop = getProp("ro.vivo.os.version");
            if (prop != null && prop.length() > 0) {
                JumpToAppDetailSetting();
                return;
            }
            String prop2 = getProp("ro.miui.ui.version.name");
            if (prop2 != null && prop2.length() > 0) {
                JumpToAppDetailSetting();
                return;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                Intent intent = new Intent();
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());
                intent.putExtra("android.intent.extra.CHANNEL_ID", getApplicationInfo().uid);
                startActivity(intent);
                return;
            }
            if (Build.VERSION.SDK_INT >= 21 && Build.VERSION.SDK_INT < 26) {
                Intent intent2 = new Intent();
                intent2.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent2.putExtra("app_package", getPackageName());
                intent2.putExtra("app_uid", getApplicationInfo().uid);
                startActivity(intent2);
                return;
            }
            JumpToAppDetailSetting();
        } catch (Exception e) {
            e.printStackTrace();
            JumpToAppDetailSetting();
        }
    }

    private void JumpToAppDetailSetting() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", getPackageName(), null));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getProp(String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return readLine;
            } catch (IOException unused) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void AndroidThunkJava_SubscribeToTopic(String str) {
        Log.debug("subscribe topic: " + str);
        this.mCurrentTopic = str;
        try {
            FirebaseMessaging.getInstance().subscribeToTopic(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AndroidThunkJava_UnsubscribeFromTopic(String str) {
        Log.debug("unsubscribe topic: " + str);
        try {
            FirebaseMessaging.getInstance().unsubscribeFromTopic(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AndroidThunkJava_SetUserProperty(String str, String str2) {
        Log.debug("setUserProperty propertyKey: " + str + ", propertyValue: " + str2);
        try {
            if (this.mFirebaseAnalytics == null) {
                this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
            }
            this.mFirebaseAnalytics.setUserProperty(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AndroidThunkJava_LogFirebaseEventWithString(String str, String str2, String str3) {
        Log.debug("AndroidThunkJava_LogFirebaseEventWithString event: " + str + " extra key: " + str2 + " value: " + str3);
        Bundle bundle = new Bundle();
        if (str2 != null && str3 != null) {
            bundle.putString(str2, str3);
        }
        try {
            if (this.mFirebaseAnalytics == null) {
                this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
            }
            this.mFirebaseAnalytics.logEvent(str, bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void AndroidThunkJava_LogFirebaseEventtWithParam(String str, Map<String, String> map) {
        Log.debug("AndroidThunkJava_LogFirebaseEventtWithParam event: " + str);
        try {
            Bundle bundle = new Bundle();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
            if (this.mFirebaseAnalytics == null) {
                this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
            }
            this.mFirebaseAnalytics.logEvent(str, bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean AndroidThunkJava_InsertImage(String str) {
        try {
            insertImage(str);
            Log.debug("AndroidThunkJava_InsertImage succeeded");
            return true;
        } catch (Exception e) {
            Log.debug("AndroidThunkJava_InsertImage Exception : " + e.toString());
            return false;
        }
    }

    public boolean AndroidThunkJava_CheckPermission() {
        return androidx.core.content.a.b(Get(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public boolean AndroidThunkJava_ShouldShowPermissionRationale() {
        return androidx.core.app.a.a((Activity) Get(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public int AndroidThunkJava_GetGoogleServiceVersion() {
        long j;
        try {
            j = getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            j = 0;
        }
        return (int) j;
    }

    public void AndroidThunkJava_CallJavaGC() {
        Log.debug("AndroidThunkJava_CallJavaGC");
        System.gc();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void readFileByLines(java.lang.String r3) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            r3 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3e
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3e
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3e
        L10:
            java.lang.String r3 = r1.readLine()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L48
            if (r3 == 0) goto L31
            java.lang.String r0 = ".so"
            boolean r0 = r3.endsWith(r0)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L48
            if (r0 == 0) goto L10
            java.lang.String r0 = "/"
            int r0 = r3.indexOf(r0)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L48
            r2 = -1
            if (r0 == r2) goto L10
            java.lang.String r3 = r3.substring(r0)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L48
            java.util.List<java.lang.String> r0 = com.epicgames.ue4.GameActivity.aJavicBaba     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L48
            r0.add(r3)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L48
            goto L10
        L31:
            r1.close()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L48
        L34:
            r1.close()     // Catch: java.io.IOException -> L47
            goto L47
        L38:
            r3 = move-exception
            goto L41
        L3a:
            r0 = move-exception
            r1 = r3
            r3 = r0
            goto L49
        L3e:
            r0 = move-exception
            r1 = r3
            r3 = r0
        L41:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L48
            if (r1 == 0) goto L47
            goto L34
        L47:
            return
        L48:
            r3 = move-exception
        L49:
            if (r1 == 0) goto L4e
            r1.close()     // Catch: java.io.IOException -> L4e
        L4e:
            throw r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.epicgames.ue4.GameActivity.readFileByLines(java.lang.String):void");
    }

    public String AndroidThunkJava_GetAoBaba() {
        aJavicBaba.clear();
        String str = "/proc/" + Process.myPid() + "/maps";
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            readFileByLines(file.getAbsolutePath());
        } else {
            Log.debug("not exist[" + str + "]file.");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aJavicBaba.size(); i++) {
            sb.append(aJavicBaba.get(i) + "|");
        }
        return sb.toString();
    }

    public String AndroidThunkJava_GetBoBaba() {
        aJavicBaba.clear();
        String str = "/proc/" + Process.myPid() + "/maps";
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            readFileByLines(file.getAbsolutePath());
        } else {
            Log.debug("not exist[" + str + "]file.");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aJavicBaba.size(); i++) {
            if (aJavicBaba.get(i).startsWith("/data/app/")) {
                sb.append(aJavicBaba.get(i) + "|");
            }
        }
        return sb.toString();
    }

    public boolean AndroidThunkJava_GetIsPlayerUsingVPN() {
        Log.d("GameActivity", "GameActivity.GetIsPlayerUsingVPN() ");
        boolean z = false;
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) getSystemService("connectivity")).getNetworkInfo(17);
            if (networkInfo != null) {
                z = networkInfo.isConnectedOrConnecting();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d("GameActivity", "GameActivity.GetIsPlayerUsingVPN() return: " + String.valueOf(z));
        return z;
    }

    public float AndroidThunkJava_GetCPUTemperature() throws IOException {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        float f;
        float f2;
        int i;
        float f3;
        String str;
        FileReader fileReader;
        BufferedReader bufferedReader3;
        FileReader fileReader2;
        float f4;
        float f5;
        List asList = Arrays.asList("/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/devices/system/cpu/cpu0/cpufreq/FakeShmoo_cpu_temp", "/sys/class/thermal/thermal_zone0/temp", "/sys/class/i2c-adapter/i2c-4/4-004c/temperature", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/temperature", "/sys/devices/platform/omap/omap_temp_sensor.0/temperature", "/sys/devices/platform/tegra_tmon/temp1_input", "/sys/kernel/debug/tegra_thermal/temp_tj", "/sys/devices/platform/s5p-tmu/temperature", "/sys/class/hwmon/hwmon0/device/temp1_input", "/sys/class/hwmon/hwmonX/temp1_input", "/sys/devices/platform/s5p-tmu/curr_temp");
        List asList2 = Arrays.asList("/sys/class/thermal/", "/sys/devices/virtual/thermal/");
        int size = asList.size();
        int size2 = asList2.size();
        float f6 = 0.0f;
        BufferedReader bufferedReader4 = null;
        int i2 = 0;
        FileReader fileReader3 = null;
        float f7 = 0.0f;
        for (int i3 = 0; i3 < size2; i3++) {
            try {
                try {
                    File[] listFiles = new File((String) asList2.get(i3)).listFiles(new FileFilter() { // from class: com.epicgames.ue4.GameActivity.42
                        @Override // java.io.FileFilter
                        public boolean accept(File file) {
                            return Pattern.matches("thermal_zone[0-9]+", file.getName());
                        }
                    });
                    int length = listFiles.length;
                    f2 = f7;
                    i = i2;
                    f3 = f6;
                    for (int i4 = 0; i4 < length; i4++) {
                        try {
                            String str2 = listFiles[i4].getPath() + "/type";
                            str = listFiles[i4].getPath() + "/temp";
                            if (bufferedReader4 != null) {
                                try {
                                    bufferedReader4.close();
                                    bufferedReader4 = null;
                                } catch (IOException unused) {
                                    fileReader = fileReader3;
                                    bufferedReader3 = bufferedReader4;
                                    bufferedReader4 = bufferedReader3;
                                    fileReader3 = fileReader;
                                }
                            }
                            if (fileReader3 != null) {
                                fileReader3.close();
                            }
                            fileReader = new FileReader(str2);
                            try {
                                bufferedReader3 = new BufferedReader(fileReader);
                            } catch (IOException unused2) {
                                bufferedReader3 = bufferedReader4;
                                bufferedReader4 = bufferedReader3;
                                fileReader3 = fileReader;
                            } catch (Exception unused3) {
                            }
                        } catch (Exception unused4) {
                        }
                        try {
                            String readLine = bufferedReader3.readLine();
                            if (readLine == null || !(readLine.contains("cpu") || readLine.contains("tsens"))) {
                                fileReader2 = fileReader;
                            } else {
                                bufferedReader3.close();
                                try {
                                    fileReader.close();
                                    try {
                                        fileReader2 = new FileReader(str);
                                    } catch (IOException unused5) {
                                        bufferedReader3 = null;
                                        fileReader = null;
                                    } catch (Exception unused6) {
                                        bufferedReader4 = null;
                                        fileReader3 = null;
                                    }
                                } catch (IOException unused7) {
                                } catch (Exception unused8) {
                                    fileReader3 = fileReader;
                                }
                                try {
                                    bufferedReader3 = new BufferedReader(fileReader2);
                                } catch (IOException unused9) {
                                    fileReader = fileReader2;
                                    bufferedReader3 = null;
                                    bufferedReader4 = bufferedReader3;
                                    fileReader3 = fileReader;
                                } catch (Exception unused10) {
                                    fileReader3 = fileReader2;
                                    bufferedReader4 = null;
                                    f6 = f3;
                                    i2 = i;
                                    f7 = f2;
                                }
                                try {
                                    String readLine2 = bufferedReader3.readLine();
                                    if (readLine2 != null) {
                                        long parseLong = Long.parseLong(readLine2);
                                        if (parseLong > LogUtils.LOG_FUSE_TIME) {
                                            f4 = ((float) parseLong) / 1000.0f;
                                            f5 = 0.0f;
                                        } else if (parseLong > 1000) {
                                            f4 = ((float) parseLong) / 100.0f;
                                            f5 = 0.0f;
                                        } else if (parseLong > 100) {
                                            f4 = ((float) parseLong) / 10.0f;
                                            f5 = 0.0f;
                                        } else {
                                            f4 = parseLong > 10 ? (float) parseLong : 0.0f;
                                            f5 = 0.0f;
                                        }
                                        if (f4 != f5) {
                                            if (f2 < f4) {
                                                f2 = f4;
                                            }
                                            f3 += f4;
                                            i++;
                                        }
                                    }
                                } catch (IOException unused11) {
                                    fileReader = fileReader2;
                                    bufferedReader4 = bufferedReader3;
                                    fileReader3 = fileReader;
                                } catch (Exception unused12) {
                                    fileReader3 = fileReader2;
                                    bufferedReader4 = bufferedReader3;
                                    f6 = f3;
                                    i2 = i;
                                    f7 = f2;
                                }
                            }
                            BufferedReader bufferedReader5 = bufferedReader3;
                            fileReader3 = fileReader2;
                            bufferedReader4 = bufferedReader5;
                        } catch (IOException unused13) {
                        } catch (Exception unused14) {
                            bufferedReader4 = bufferedReader3;
                            fileReader3 = fileReader;
                            f6 = f3;
                            i2 = i;
                            f7 = f2;
                        }
                    }
                } catch (Exception unused15) {
                    f2 = f7;
                    i = i2;
                    f3 = f6;
                    f6 = f3;
                    i2 = i;
                    f7 = f2;
                }
            } catch (Exception unused16) {
            }
            f6 = f3;
            i2 = i;
            f7 = f2;
        }
        if (Math.abs(f6) < 1.0E-4f) {
            bufferedReader = bufferedReader4;
            float f8 = 0.0f;
            for (int i5 = 0; i5 < size; i5++) {
                try {
                    String str3 = (String) asList.get(i5);
                    if (bufferedReader != null) {
                        bufferedReader.close();
                        bufferedReader = null;
                    }
                    if (fileReader3 != null) {
                        fileReader3.close();
                    }
                    FileReader fileReader4 = new FileReader(str3);
                    try {
                        bufferedReader2 = new BufferedReader(fileReader4);
                    } catch (IOException unused17) {
                    }
                    try {
                        String readLine3 = bufferedReader2.readLine();
                        if (readLine3 != null) {
                            long parseLong2 = Long.parseLong(readLine3);
                            if (parseLong2 > LogUtils.LOG_FUSE_TIME) {
                                f8 = ((float) parseLong2) / 1000.0f;
                                f = 0.0f;
                            } else if (parseLong2 > 1000) {
                                f8 = ((float) parseLong2) / 100.0f;
                                f = 0.0f;
                            } else if (parseLong2 > 100) {
                                f8 = ((float) parseLong2) / 10.0f;
                                f = 0.0f;
                            } else {
                                if (parseLong2 > 10) {
                                    f8 = (float) parseLong2;
                                }
                                f = 0.0f;
                            }
                            if (f8 != f) {
                                if (f7 < f8) {
                                    f7 = f8;
                                }
                                f6 += f8;
                                i2++;
                            }
                        }
                        bufferedReader = bufferedReader2;
                        fileReader3 = fileReader4;
                    } catch (IOException unused18) {
                        bufferedReader = bufferedReader2;
                        fileReader3 = fileReader4;
                        f8 = 0.0f;
                    }
                } catch (IOException unused19) {
                }
            }
        } else {
            bufferedReader = bufferedReader4;
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
        if (i2 > 0) {
            return f6 / i2;
        }
        asList.clear();
        asList2.clear();
        return 0.0f;
    }
}
