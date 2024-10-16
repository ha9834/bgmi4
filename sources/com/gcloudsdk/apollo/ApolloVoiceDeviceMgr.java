package com.gcloudsdk.apollo;

import android.app.Activity;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build;
import androidx.core.content.b;
import com.gcloudsdk.apollo.apollovoice.httpclient.AudioDeviceListener;
import com.gcloudsdk.apollo.apollovoice.httpclient.HttpsUtils;
import com.gcloudsdk.gcloud.voice.GCloudVoiceVersion;
import com.gcloudsdk.gcloud.voice.IGCloudVoiceNotify;
import java.util.Locale;

/* loaded from: classes.dex */
public class ApolloVoiceDeviceMgr {
    private static final int MODE_RESET = -2;
    private static final int MODE_SET_AUTO = -1;
    private static final int MODE_SET_ONLY = -3;
    private static final int SCO_CHECK_INTERL = 2000;
    private static final int SCO_CHECK_TIME_MAX = 2;
    private static String appname = "";
    private static boolean bAudioFocus = false;
    private static boolean bFocusPause = false;
    private static boolean bGvoiceDsp = false;
    private static boolean bPermissionOK = false;
    private static String checkDsp = null;
    private static String dataPath = null;
    private static Activity mActivity = null;
    private static AudioDeviceListener mAudioDeviceListener = null;
    private static AudioFocusChangeListener mAudioFocusChangeListener = null;
    private static AudioManager mAudioManager = null;
    private static int mAudioStatusEvent = 0;
    private static BluetoothAdapter mBluetoothAdapter = null;
    private static boolean mBluetoothSCO = false;
    private static boolean mBluetoothSCOEnable = false;
    private static int mBluetoothState = -100;
    private static boolean mCheckDeviceFlag = false;
    private static Context mContext = null;
    private static boolean mCurrVoipState = false;
    private static IGCloudVoiceNotify mGCloudVoiceNotify = null;
    private static BroadcastReceiver mHeadSetReceiver = null;
    private static boolean mIsBluetoothConnected = false;
    private static boolean mIsHeadsetConnected = false;
    private static boolean mIsMicOpen = false;
    private static boolean mIsMultiDeviceConnected = false;
    private static int mMode = -1;
    private static int mSCOReConnecteTimes = 0;
    private static boolean mScoThreadRunning = false;
    protected static boolean mSpeakerphoneOn = true;
    private static int maxVolCall = 0;
    private static int maxVolMusic = 0;
    private static int nGvoiceDspApiVersion = -1;
    private static int nGvoiceDspSet;
    private static int nLangType;

    static {
        try {
            System.loadLibrary("GCloudVoice");
        } catch (UnsatisfiedLinkError unused) {
            System.err.println("load library failed!!!");
        }
        mHeadSetReceiver = new BroadcastReceiver() { // from class: com.gcloudsdk.apollo.ApolloVoiceDeviceMgr.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String str = "";
                try {
                    if (intent.getAction().equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                        int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                        if (intExtra == 2) {
                            ApolloVoiceLog.LogI("bluetooth connect ,cur state is " + intExtra);
                            boolean unused2 = ApolloVoiceDeviceMgr.mIsBluetoothConnected = true;
                            str = "bluetooth headset connect";
                            ApolloVoiceEngine.SetBluetoothState(true);
                            int unused3 = ApolloVoiceDeviceMgr.mAudioStatusEvent = 21;
                        } else if (intExtra == 0) {
                            ApolloVoiceLog.LogI("bluetooth disconnect,cur state is " + intExtra);
                            boolean unused4 = ApolloVoiceDeviceMgr.mIsBluetoothConnected = false;
                            str = "bluetooth headset disconnect";
                            ApolloVoiceEngine.SetBluetoothState(false);
                            if (ApolloVoiceDeviceMgr.mIsHeadsetConnected) {
                                int unused5 = ApolloVoiceDeviceMgr.mAudioStatusEvent = 11;
                            } else {
                                int unused6 = ApolloVoiceDeviceMgr.mAudioStatusEvent = 20;
                            }
                        } else if (intExtra == 1) {
                            ApolloVoiceLog.LogI("bluetoothHeadset connecting...");
                            return;
                        }
                    } else if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
                        if (intent.hasExtra("state")) {
                            int intExtra2 = intent.getIntExtra("state", -1);
                            switch (intExtra2) {
                                case 0:
                                    ApolloVoiceLog.LogI("headset disconnect ,cur state is " + intExtra2);
                                    boolean unused7 = ApolloVoiceDeviceMgr.mIsHeadsetConnected = false;
                                    ApolloVoiceEngine.SetHeadSetState(false);
                                    if (ApolloVoiceDeviceMgr.mIsBluetoothConnected) {
                                        int unused8 = ApolloVoiceDeviceMgr.mAudioStatusEvent = 21;
                                        break;
                                    } else {
                                        int unused9 = ApolloVoiceDeviceMgr.mAudioStatusEvent = 10;
                                        break;
                                    }
                                case 1:
                                    ApolloVoiceLog.LogI("headset connect ,cur state is " + intExtra2);
                                    boolean unused10 = ApolloVoiceDeviceMgr.mIsHeadsetConnected = true;
                                    boolean unused11 = ApolloVoiceDeviceMgr.mIsBluetoothConnected = false;
                                    int unused12 = ApolloVoiceDeviceMgr.mAudioStatusEvent = 11;
                                    str = "headset connect";
                                    ApolloVoiceEngine.SetHeadSetState(true);
                                    break;
                            }
                            ApolloVoiceLog.LogE("BroadcastReceiver ACTION_HEADSET_PLUG onReceive bSetValue=" + ApolloVoiceDeviceMgr.mSpeakerphoneOn);
                        }
                    } else if (intent.getAction().equals("android.media.ACTION_SCO_AUDIO_STATE_UPDATED")) {
                        int intExtra3 = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0);
                        ApolloVoiceLog.LogI("ApolloVoiceDeviceManager ::SCO cur state is " + intExtra3);
                        int unused13 = ApolloVoiceDeviceMgr.mBluetoothState = intExtra3;
                        if (intExtra3 == 1) {
                            boolean unused14 = ApolloVoiceDeviceMgr.mBluetoothSCO = true;
                            ApolloVoiceDeviceMgr.mAudioManager.setBluetoothScoOn(true);
                        } else if (intExtra3 == 0) {
                            boolean unused15 = ApolloVoiceDeviceMgr.mBluetoothSCO = false;
                            ApolloVoiceDeviceMgr.mAudioManager.setBluetoothScoOn(false);
                            ApolloVoiceDeviceMgr.ApolloVoiceDeviceSetMode(0);
                        }
                    }
                    if (ApolloVoiceDeviceMgr.mAudioStatusEvent != 0) {
                        ApolloVoiceDeviceMgr.mAudioDeviceListener.onStatus(ApolloVoiceDeviceMgr.mAudioStatusEvent, str);
                        int unused16 = ApolloVoiceDeviceMgr.mAudioStatusEvent = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        mAudioDeviceListener = new AudioDeviceListener() { // from class: com.gcloudsdk.apollo.ApolloVoiceDeviceMgr.2
            @Override // com.gcloudsdk.apollo.apollovoice.httpclient.AudioDeviceListener
            public synchronized void onStatus(int i, String str) {
                ApolloVoiceLog.LogI("--mAudioStatusEvent---:" + i);
                ApolloVoiceEngine.OnEvent(i, str);
                if (ApolloVoiceDeviceMgr.mGCloudVoiceNotify != null) {
                    ApolloVoiceDeviceMgr.mGCloudVoiceNotify.OnEvent(i, str);
                }
            }
        };
    }

    public static boolean CheckManifestPermission() {
        Context context = mContext;
        if (context == null) {
            return false;
        }
        try {
            for (String str : context.getPackageManager().getPackageInfo(mContext.getPackageName(), 4096).requestedPermissions) {
                if (str.equals("android.permission.MODIFY_AUDIO_SETTINGS")) {
                    ApolloVoiceLog.LogI("Check permission ok.");
                    bPermissionOK = true;
                    return true;
                }
                ApolloVoiceLog.LogE(str);
            }
            return false;
        } catch (Exception unused) {
            ApolloVoiceLog.LogE("getPackageName throw an exception!");
            return true;
        }
    }

    public static void ApolloVoiceDeviceInit(Context context, Activity activity) {
        ApolloVoiceLog.LogI("GCloudVoice Version in java code: " + GCloudVoiceVersion.Version());
        ApolloVoiceLog.LogI("ApolloVoiceDeviceInit");
        if (mContext != null) {
            return;
        }
        mContext = context;
        if (!CheckManifestPermission()) {
            ApolloVoiceLog.LogE("Check the permissions GVoice needed!");
            return;
        }
        mActivity = activity;
        NetInterfaceHelper.init(activity);
        if (checkAudioManagerIsInit()) {
            CheckSysLang();
            ApolloVoiceLog.LogI("GVOICE_DSP:getParameters begin");
            try {
                ApolloVoiceLog.LogI("GVOICE_DSP:try getParameters version 1");
                checkDsp = mAudioManager.getParameters("vivo_adsp_support_gvoice");
                ApolloVoiceLog.LogI(checkDsp);
                if (checkDsp.equals("vivo_adsp_support_gvoice=true")) {
                    ApolloVoiceLog.LogI("GVOICE_DSP:APP supports gvoice dsp api(v1). NS will run on adsp");
                    nGvoiceDspApiVersion = 1;
                    nGvoiceDspSet = 1;
                    bGvoiceDsp = true;
                } else if (checkDsp.equals("vivo_adsp_support_gvoice=false")) {
                    ApolloVoiceLog.LogI("GVOICE_DSP:APP does not support gvoice dsp(v1).No gvoice module runs on adsp");
                    nGvoiceDspApiVersion = 1;
                    nGvoiceDspSet = 0;
                    bGvoiceDsp = false;
                } else {
                    ApolloVoiceLog.LogI("GVOICE_DSP:try getParameters version 2");
                    checkDsp = mAudioManager.getParameters("adsp_support_gvoice");
                    ApolloVoiceLog.LogI(checkDsp);
                    if (checkDsp != null) {
                        if (checkDsp.equals("adsp_support_gvoice=0001")) {
                            nGvoiceDspSet = 1;
                            bGvoiceDsp = true;
                            nGvoiceDspApiVersion = 2;
                            ApolloVoiceLog.LogI("GVOICE_DSP:APP supports gvoice dsp(v2).nGvoiceDspSet=" + nGvoiceDspSet);
                        } else if (checkDsp.equals("adsp_support_gvoice=0010")) {
                            nGvoiceDspSet = 2;
                            bGvoiceDsp = true;
                            nGvoiceDspApiVersion = 2;
                            ApolloVoiceLog.LogI("GVOICE_DSP:APP supports gvoice dsp(v2).nGvoiceDspSet=" + nGvoiceDspSet);
                        } else if (checkDsp.equals("adsp_support_gvoice=0011")) {
                            nGvoiceDspSet = 3;
                            bGvoiceDsp = true;
                            nGvoiceDspApiVersion = 2;
                            ApolloVoiceLog.LogI("GVOICE_DSP:APP supports gvoice dsp(v2).nGvoiceDspSet=" + nGvoiceDspSet);
                        } else {
                            ApolloVoiceLog.LogI("GVOICE_DSP:reset nGvoiceDspSet to 0,reset bGvoiceDsp to false");
                            nGvoiceDspSet = 0;
                            bGvoiceDsp = false;
                        }
                    } else {
                        ApolloVoiceLog.LogE("GVOICE_DSP:getParameters(adsp_support_gvoice)  returns null");
                    }
                }
                SetGVoiceDsp(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ApolloVoiceLog.LogI("GVOICE_DSP:getParameters done");
            try {
                mAudioManager.setMode(0);
            } catch (IllegalArgumentException e2) {
                ApolloVoiceLog.LogE(e2.getMessage());
            }
            int audioDeviceConnectionState = getAudioDeviceConnectionState();
            if (audioDeviceConnectionState == 2 || audioDeviceConnectionState == 3) {
                ApolloVoiceEngine.SetBluetoothState(true);
                mIsBluetoothConnected = true;
            } else {
                mIsBluetoothConnected = false;
            }
            ApolloVoiceLog.LogI("apollovoicemanager:: getMode: " + mAudioManager.getMode());
            AudioManager audioManager = mAudioManager;
            if (audioManager != null) {
                if (audioDeviceConnectionState == 0) {
                    try {
                        audioManager.setSpeakerphoneOn(true);
                        mSpeakerphoneOn = true;
                    } catch (Exception e3) {
                        ApolloVoiceLog.LogI("Init failed!!! The exception is " + e3.toString());
                    }
                }
                AudioManager audioManager2 = mAudioManager;
                AudioManager audioManager3 = mAudioManager;
                maxVolMusic = audioManager2.getStreamMaxVolume(3);
                AudioManager audioManager4 = mAudioManager;
                AudioManager audioManager5 = mAudioManager;
                maxVolCall = audioManager4.getStreamMaxVolume(0);
                ApolloVoiceLog.LogI("GCloudVoice::max music " + maxVolMusic + "max call =  " + maxVolCall);
            }
            registerHeadsetPlugReceiver();
            ApolloVoiceConfig.SetContext(context);
            ApolloVoiceUDID.SetContext(context);
            ApolloVoiceNetStatus.SetContext(context);
            HttpsUtils.setContext(context);
            mAudioFocusChangeListener = new AudioFocusChangeListener();
            EnableAudioFocus(true);
        }
    }

    public static void ApolloVoiceDeviceUninit() {
        mActivity = null;
        if (mContext != null) {
            unregisterHeadsetPlugReceiver();
            mAudioManager.setMode(0);
            mAudioManager = null;
            mContext = null;
        }
    }

    private static boolean IsHeadSet() {
        AudioManager audioManager = mAudioManager;
        if (audioManager != null) {
            return audioManager.isWiredHeadsetOn();
        }
        return false;
    }

    public static int ApolloVoiceGetCurrMode() {
        AudioManager audioManager = mAudioManager;
        if (audioManager != null) {
            return audioManager.getMode();
        }
        return -2;
    }

    private static void unregisterHeadsetPlugReceiver() {
        Context context = mContext;
        if (context == null) {
            return;
        }
        try {
            context.unregisterReceiver(mHeadSetReceiver);
        } catch (Exception e) {
            ApolloVoiceLog.LogI("Registe headset failed!!! The exception is " + e.toString());
        }
    }

    private static void registerHeadsetPlugReceiver() {
        if (mContext == null) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
            intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
            if ("EVA-AL00".equals(Build.MODEL) || "Nexus 6P".equals(Build.MODEL)) {
                intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            }
            mContext.registerReceiver(mHeadSetReceiver, intentFilter);
        } catch (Exception e) {
            ApolloVoiceLog.LogI("Registe headset failed!!! The exception is " + e.toString());
        }
    }

    public static void SetpreVoipMode(int i) {
        mCurrVoipState = i == 1;
    }

    public static void ApolloVoiceSetSpeakerOn(boolean z) {
        ApolloVoiceLog.LogI("apolloVoiceDevice::SetSpeakerOn is " + z);
        if (checkAudioManagerIsInit()) {
            try {
                if (!mIsBluetoothConnected && !mIsHeadsetConnected) {
                    mAudioManager.setSpeakerphoneOn(true);
                } else {
                    mAudioManager.setSpeakerphoneOn(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            mSpeakerphoneOn = z;
        }
    }

    public static boolean ApolloVoiceDeviceSetMode(int i) {
        ApolloVoiceLog.LogI("ApolloVoiceDeviceSetMode mode:" + i);
        if (!checkAudioManagerIsInit()) {
            return false;
        }
        mMode = i;
        try {
            if (mAudioManager.getMode() != i) {
                mAudioManager.setMode(i);
            }
            ApolloVoiceSetSpeakerOn(true);
            if (mAudioManager.getMode() != i) {
                ApolloVoiceLog.LogI("cur mode:" + mAudioManager.getMode() + " ,want mode:" + i);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean HaveMicrophonePermission(boolean r5) {
        /*
            android.content.Context r0 = com.gcloudsdk.apollo.ApolloVoiceDeviceMgr.mContext
            r1 = 0
            if (r0 == 0) goto Lab
            boolean r2 = com.gcloudsdk.apollo.ApolloVoiceDeviceMgr.bPermissionOK
            if (r2 != 0) goto Lb
            goto Lab
        Lb:
            r2 = 23
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L34
            android.content.Context r3 = com.gcloudsdk.apollo.ApolloVoiceDeviceMgr.mContext     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L34
            java.lang.String r3 = r3.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L34
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r3, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L34
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L34
            int r0 = r0.targetSdkVersion     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L34
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L36
            r3.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L36
            java.lang.String r4 = "targetSdkVersion = "
            r3.append(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L36
            r3.append(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L36
            java.lang.String r3 = r3.toString()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L36
            com.gcloudsdk.apollo.ApolloVoiceLog.LogI(r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L36
            goto L50
        L34:
            r0 = 23
        L36:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Can't find package : "
            r3.append(r4)
            android.content.Context r4 = com.gcloudsdk.apollo.ApolloVoiceDeviceMgr.mContext
            java.lang.String r4 = r4.getPackageName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.gcloudsdk.apollo.ApolloVoiceLog.LogE(r3)
        L50:
            if (r0 >= r2) goto L5e
            boolean r0 = CheckPermiss()
            if (r0 != 0) goto L5e
            java.lang.String r5 = "Don't have microphone permission"
            com.gcloudsdk.apollo.ApolloVoiceLog.LogE(r5)
            return r1
        L5e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "buildVersion = "
            r0.append(r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.gcloudsdk.apollo.ApolloVoiceLog.LogI(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 1
            if (r0 < r2) goto L9e
            android.content.Context r0 = com.gcloudsdk.apollo.ApolloVoiceDeviceMgr.mContext
            java.lang.String r2 = "android.permission.RECORD_AUDIO"
            int r0 = androidx.core.content.a.b(r0, r2)
            if (r0 == 0) goto L98
            java.lang.String r0 = "Don't have microphone permission"
            com.gcloudsdk.apollo.ApolloVoiceLog.LogE(r0)
            if (r5 == 0) goto L97
            android.app.Activity r5 = com.gcloudsdk.apollo.ApolloVoiceDeviceMgr.mActivity
            java.lang.String[] r0 = new java.lang.String[r3]
            java.lang.String r2 = "android.permission.RECORD_AUDIO"
            r0[r1] = r2
            r2 = 100
            androidx.core.app.a.a(r5, r0, r2)
        L97:
            return r1
        L98:
            java.lang.String r5 = "Have microphone permission"
            com.gcloudsdk.apollo.ApolloVoiceLog.LogI(r5)
            return r3
        L9e:
            boolean r5 = CheckPermiss()
            if (r5 != 0) goto Laa
            java.lang.String r5 = "Don't have microphone permission"
            com.gcloudsdk.apollo.ApolloVoiceLog.LogE(r5)
            return r1
        Laa:
            return r3
        Lab:
            boolean r5 = com.gcloudsdk.apollo.ApolloVoiceDeviceMgr.bPermissionOK
            if (r5 == 0) goto Lb2
            java.lang.String r5 = "bPermissionOK"
            goto Lb4
        Lb2:
            java.lang.String r5 = "not bPermissionOK"
        Lb4:
            com.gcloudsdk.apollo.ApolloVoiceLog.LogE(r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gcloudsdk.apollo.ApolloVoiceDeviceMgr.HaveMicrophonePermission(boolean):boolean");
    }

    public static boolean CheckPermiss() {
        try {
            return b.a(mContext, "android.permission.RECORD_AUDIO") == 0;
        } catch (Exception unused) {
            ApolloVoiceLog.LogW("CheckPermiss get an exception !");
            return false;
        }
    }

    public static boolean hasRecordPermission() {
        AudioRecord audioRecord;
        byte[] bArr = new byte[512];
        AudioRecord audioRecord2 = null;
        try {
            try {
                audioRecord = new AudioRecord(0, 44100, 16, 2, AudioRecord.getMinBufferSize(44100, 16, 2));
            } catch (IllegalStateException unused) {
            }
            try {
                audioRecord.startRecording();
                if (audioRecord.getRecordingState() != 3) {
                    ApolloVoiceLog.LogI("startRecording but not in recording state");
                    audioRecord.stop();
                    audioRecord.release();
                    return false;
                }
                int read = audioRecord.read(bArr, 0, 512);
                ApolloVoiceLog.LogI("hasRecordPermission is recording readsize " + read);
                if (read < 0) {
                    audioRecord.stop();
                    audioRecord.release();
                    return false;
                }
                audioRecord.stop();
                audioRecord.release();
                return true;
            } catch (IllegalStateException unused2) {
                audioRecord2 = audioRecord;
                ApolloVoiceLog.LogE("IllegalStateException when startRecording, which maybe do not have RECORD_AUDIO permission in actual");
                if (audioRecord2 != null) {
                    audioRecord2.release();
                }
                return false;
            }
        } catch (IllegalArgumentException unused3) {
            ApolloVoiceLog.LogW("IllegalArgumentException when create AudioRecord");
            return false;
        }
    }

    public static boolean checkAudioManagerIsInit() {
        if (mAudioManager != null) {
            return true;
        }
        Context context = mContext;
        if (context != null) {
            mAudioManager = (AudioManager) context.getSystemService("audio");
            if (mAudioManager != null) {
                return true;
            }
            ApolloVoiceLog.LogI("apolloVoiceDevice::get AudioManager null....\n");
            return false;
        }
        ApolloVoiceLog.LogI("apolloVoiceDevice::context is null....\n");
        return false;
    }

    public static boolean IsSupportGVoiceDsp() {
        return bGvoiceDsp;
    }

    public static int GetSupportGVoiceDspSet() {
        ApolloVoiceLog.LogI("GVOICE_DSP:GetSupportGVoiceDspSet return nGvoiceDspSet=" + nGvoiceDspSet);
        return nGvoiceDspSet;
    }

    public static void SetGVoiceDsp(boolean z) {
        if (mAudioManager == null) {
            return;
        }
        try {
            ApolloVoiceLog.LogI("GVOICE_DSP:SetGVoiceDsp(bGvoiceDsp=" + bGvoiceDsp + ",nGvoiceDspApiVersion=" + nGvoiceDspApiVersion + ")");
            if (bGvoiceDsp) {
                if (1 == nGvoiceDspApiVersion) {
                    if (z) {
                        ApolloVoiceLog.LogI("GVOICE_DSP:enable gvoice dsp.");
                        mAudioManager.setParameters("vivo_adsp_gvoice_mode=true");
                    } else {
                        ApolloVoiceLog.LogI("GVOICE_DSP:disable gvoice dsp.");
                        mAudioManager.setParameters("vivo_adsp_gvoice_mode=false");
                    }
                } else if (z) {
                    ApolloVoiceLog.LogI("GVOICE_DSP:enable gvoice dsp.");
                    mAudioManager.setParameters("adsp_gvoice_mode=true");
                } else {
                    ApolloVoiceLog.LogI("GVOICE_DSP:disable gvoice dsp.");
                    mAudioManager.setParameters("adsp_gvoice_mode=false");
                }
            }
        } catch (Exception unused) {
            ApolloVoiceLog.LogI("GVOICE_DSP:SetGVoiceDsp set fail.\n");
        }
    }

    public static void setGCloudVoiceNotify(IGCloudVoiceNotify iGCloudVoiceNotify) {
        mGCloudVoiceNotify = iGCloudVoiceNotify;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AudioFocusChangeListener implements AudioManager.OnAudioFocusChangeListener {
        private AudioFocusChangeListener() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            ApolloVoiceLog.LogI("mAudioStatusEvent focusChange:" + i);
            ApolloVoiceLog.LogI("is background  " + ApolloVoiceDeviceMgr.isBackground());
            if (i != -2 && i != -3) {
                if (i == 1 && ApolloVoiceDeviceMgr.bFocusPause) {
                    if (!ApolloVoiceDeviceMgr.isBackground()) {
                        ApolloVoiceEngine.Resume();
                    }
                    boolean unused = ApolloVoiceDeviceMgr.bFocusPause = false;
                    return;
                }
                return;
            }
            if (ApolloVoiceEngine.IsPause()) {
                boolean unused2 = ApolloVoiceDeviceMgr.bFocusPause = false;
            } else {
                ApolloVoiceEngine.Pause();
                boolean unused3 = ApolloVoiceDeviceMgr.bFocusPause = true;
            }
        }
    }

    public static int getAudioDeviceConnectionState() {
        boolean z;
        int i;
        int i2;
        boolean z2;
        if (!checkAudioManagerIsInit()) {
            return 0;
        }
        if (mAudioManager.isWiredHeadsetOn()) {
            mIsHeadsetConnected = true;
            z = true;
            i = 1;
        } else {
            mIsHeadsetConnected = false;
            z = false;
            i = 0;
        }
        if (mBluetoothAdapter == null) {
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        BluetoothAdapter bluetoothAdapter = mBluetoothAdapter;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            int profileConnectionState = mBluetoothAdapter.getProfileConnectionState(2);
            int profileConnectionState2 = mBluetoothAdapter.getProfileConnectionState(1);
            int profileConnectionState3 = mBluetoothAdapter.getProfileConnectionState(3);
            if (profileConnectionState2 == 2) {
                z2 = true;
                i2 = 2;
            } else {
                i2 = i;
                z2 = false;
            }
            if (z && z2) {
                mIsMultiDeviceConnected = true;
                if (mIsHeadsetConnected && !mIsBluetoothConnected) {
                    ApolloVoiceLog.LogW("getHeadsetDeviceStatus: wiredheadset actually!");
                    i = 1;
                } else if (mIsHeadsetConnected || !mIsBluetoothConnected) {
                    i = 3;
                } else {
                    ApolloVoiceLog.LogW("getHeadsetDeviceStatus: bluetooth actually!");
                    i = 2;
                }
            } else {
                mIsMultiDeviceConnected = false;
                i = i2;
            }
            ApolloVoiceLog.LogI("getHeadsetDeviceStatus state:" + i + " a2dp:" + profileConnectionState + " headset:" + profileConnectionState2 + " health:" + profileConnectionState3 + " mIsHeadsetConnected:" + mIsHeadsetConnected + " mIsBluetoothConnected:" + mIsBluetoothConnected);
        }
        return i;
    }

    public static void SetBluetoothSCOEnable(boolean z) {
        ApolloVoiceLog.LogI("bluetoothSCOEnable:" + z);
        if (checkAudioManagerIsInit()) {
            try {
                if (z) {
                    if (mAudioManager.isBluetoothScoAvailableOffCall()) {
                        if (ApolloVoiceGetCurrMode() != 3) {
                            ApolloVoiceDeviceSetMode(3);
                        }
                        mAudioManager.startBluetoothSco();
                        return;
                    }
                    return;
                }
                if (mAudioManager.isBluetoothScoOn()) {
                    mAudioManager.stopBluetoothSco();
                }
            } catch (Exception unused) {
                ApolloVoiceLog.LogI("SetBluetoothSCOEnable set fail.\n");
            }
        }
    }

    public static boolean isBackground() {
        ApolloVoiceLog.LogI("is background call.\n");
        if (Build.VERSION.SDK_INT <= 21) {
            return true;
        }
        try {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance != 100 && runningAppProcessInfo.importance != 200) {
                return true;
            }
            ApolloVoiceLog.LogI("is not background .\n");
            return false;
        } catch (Exception unused) {
            ApolloVoiceLog.LogI("getMyMemoryState fail.\n");
            return true;
        }
    }

    public static int CheckSysLang() {
        try {
            Locale locale = Locale.getDefault();
            if (locale.getLanguage().equals(new Locale("zh").getLanguage())) {
                if (locale.getCountry().equals("CN")) {
                    nLangType = 0;
                } else {
                    nLangType = 15;
                }
            } else if (locale.getLanguage().equals(new Locale("en").getLanguage())) {
                nLangType = 1;
            } else if (locale.getLanguage().equals(new Locale("ja").getLanguage())) {
                nLangType = 2;
            } else if (locale.getLanguage().equals(new Locale("ko").getLanguage())) {
                nLangType = 3;
            } else if (locale.getLanguage().equals(new Locale("de").getLanguage())) {
                nLangType = 4;
            } else if (locale.getLanguage().equals(new Locale("fr").getLanguage())) {
                nLangType = 5;
            } else if (locale.getLanguage().equals(new Locale("es").getLanguage())) {
                nLangType = 6;
            } else if (locale.getLanguage().equals(new Locale("it").getLanguage())) {
                nLangType = 7;
            } else if (locale.getLanguage().equals(new Locale("en").getLanguage())) {
                nLangType = 8;
            } else if (locale.getLanguage().equals(new Locale("ru").getLanguage())) {
                nLangType = 9;
            } else if (locale.getLanguage().equals(new Locale("pt").getLanguage())) {
                nLangType = 10;
            } else if (locale.getLanguage().equals(new Locale("vi").getLanguage())) {
                nLangType = 11;
            } else if (locale.getLanguage().equals(new Locale("id").getLanguage())) {
                nLangType = 12;
            } else if (locale.getLanguage().equals(new Locale("ms").getLanguage())) {
                nLangType = 13;
            } else if (locale.getLanguage().equals(new Locale("th").getLanguage())) {
                nLangType = 14;
            }
        } catch (Exception unused) {
            ApolloVoiceLog.LogI("CheckSysLang fail.\n");
            nLangType = -1;
        }
        return nLangType;
    }

    public static int GetLangType() {
        return nLangType;
    }

    public static int EnableAudioFocus(boolean z) {
        if (z == bAudioFocus) {
            return 0;
        }
        ApolloVoiceLog.LogI("EnableAudioFocus: " + z);
        if (z) {
            try {
                if (mAudioManager.requestAudioFocus(mAudioFocusChangeListener, 3, 1) == 1) {
                    ApolloVoiceLog.LogI("own requestAudioFocus  successfully.");
                    bAudioFocus = true;
                } else {
                    bAudioFocus = false;
                    ApolloVoiceLog.LogE("own requestAudioFocus  failed.");
                }
            } catch (Exception unused) {
                ApolloVoiceLog.LogE("requestAudioFocus exception.");
            }
        } else {
            try {
                if (mAudioManager.abandonAudioFocus(mAudioFocusChangeListener) == 1) {
                    ApolloVoiceLog.LogI("own abandonAudioFocus  successfully.");
                    bAudioFocus = false;
                } else {
                    bAudioFocus = true;
                    ApolloVoiceLog.LogE("own abandonAudioFocus  failed.");
                }
            } catch (Exception unused2) {
                ApolloVoiceLog.LogE("requestAudioFocus exception.");
            }
        }
        return 0;
    }
}
