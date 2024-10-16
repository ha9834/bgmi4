package com.gcloudsdk.apollo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.File;

/* loaded from: classes.dex */
public class ApolloVoiceConfig {
    private static String VPbinName = "GCloudVoice/cldnn_spkvector.mnn";
    private static String VPbinPath = "/cldnn_spkvector.mnn";
    private static String VPbinSourcePath = null;
    private static String binName = "GCloudVoice/libwxvoiceembed.bin";
    private static String binPath = "/libwxvoiceembed.bin";
    private static String binSourcePath = null;
    private static final String cfgName = "GCloudVoice/config.json";
    private static String dafxBinName = "GCloudVoice/wave_dafx_data.bin";
    private static String dafxBinPath = "/wave_dafx_data.bin";
    private static String dafxBinSourcePath = null;
    private static String dyCfgPath = "/com.gcloudsdk.gcloud.gvoice/config/gvoice.cfg";
    private static Context mainContext = null;
    private static String nsBinName = "GCloudVoice/libgvoicensmodel.bin";
    private static String nsBinPath = "/libgvoicensmodel.bin";
    private static String nsBinSourcePath = null;
    private static String storageCfgPath = null;
    private static String tdBinName = "GCloudVoice/wave_3d_data.bin";
    private static String tdBinPath = "/wave_3d_data.bin";
    private static String tdBinSourcePath;

    public static void SetContext(Context context) {
        mainContext = context;
        File externalFilesDir = mainContext.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            storageCfgPath = externalFilesDir.getAbsolutePath() + "/" + cfgName;
            StringBuilder sb = new StringBuilder();
            sb.append("storageCfgPath: ");
            sb.append(storageCfgPath);
            ApolloVoiceLog.LogI(sb.toString());
            return;
        }
        ApolloVoiceLog.LogI("getExternalFilesDir failed !!!");
    }

    public static boolean IsSDCardCfgExist() {
        return new File(storageCfgPath).exists();
    }

    public static String DynamicCfgPath() {
        String str = "invalied";
        try {
            File filesDir = mainContext.getFilesDir();
            if (filesDir != null) {
                str = filesDir.toString() + dyCfgPath;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ApolloVoiceLog.LogI("Read Dynamic: " + str);
        return str;
    }

    public static String ConfigFromManifest(String str) {
        ApplicationInfo applicationInfo;
        String str2 = "invalied";
        if (str == null || str.trim().length() == 0) {
            return "invalied";
        }
        try {
            applicationInfo = mainContext.getPackageManager().getApplicationInfo(mainContext.getPackageName(), 128);
        } catch (Exception e) {
            ApolloVoiceLog.LogE("getApplicationInfo meets errors");
            e.printStackTrace();
        }
        if (applicationInfo != null && applicationInfo.metaData != null) {
            str2 = applicationInfo.metaData.getString(str);
            ApolloVoiceLog.LogI("configItem: " + str + " configValue: " + str2);
            return str2;
        }
        ApolloVoiceLog.LogE("appInfo or appInfo.metaData is null");
        return "invalied";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.io.InputStream] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String JSONCfg(boolean r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L23
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L78
            java.lang.String r1 = com.gcloudsdk.apollo.ApolloVoiceConfig.storageCfgPath     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L78
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L78
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            r1.<init>()     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            java.lang.String r2 = "Read config file from storage: "
            r1.append(r2)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            java.lang.String r2 = com.gcloudsdk.apollo.ApolloVoiceConfig.storageCfgPath     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            r1.append(r2)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            com.gcloudsdk.apollo.ApolloVoiceLog.LogI(r1)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            goto L38
        L21:
            r1 = move-exception
            goto L7a
        L23:
            android.content.Context r8 = com.gcloudsdk.apollo.ApolloVoiceConfig.mainContext     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L78
            android.content.res.Resources r8 = r8.getResources()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L78
            android.content.res.AssetManager r8 = r8.getAssets()     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L78
            java.lang.String r1 = "GCloudVoice/config.json"
            java.io.InputStream r8 = r8.open(r1)     // Catch: java.lang.Throwable -> L73 java.lang.Exception -> L78
            java.lang.String r1 = "Read config file from: GCloudVoice/config.json"
            com.gcloudsdk.apollo.ApolloVoiceLog.LogI(r1)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
        L38:
            int r1 = r8.available()     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            byte[] r2 = new byte[r1]     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            java.lang.String r3 = "UTF-8"
            r4 = 0
        L41:
            if (r4 >= r1) goto L4f
            int r5 = r1 - r4
            int r5 = r8.read(r2, r4, r5)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            r6 = -1
            if (r5 != r6) goto L4d
            goto L4f
        L4d:
            int r4 = r4 + r5
            goto L41
        L4f:
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            r2.<init>()     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            java.lang.String r3 = "Get config: "
            r2.append(r3)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            r2.append(r1)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            com.gcloudsdk.apollo.ApolloVoiceLog.LogI(r2)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L88
            if (r8 == 0) goto L72
            r8.close()     // Catch: java.lang.Exception -> L6e
            goto L72
        L6e:
            r8 = move-exception
            r8.printStackTrace()
        L72:
            return r1
        L73:
            r8 = move-exception
            r7 = r0
            r0 = r8
            r8 = r7
            goto L89
        L78:
            r1 = move-exception
            r8 = r0
        L7a:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L88
            if (r8 == 0) goto L87
            r8.close()     // Catch: java.lang.Exception -> L83
            goto L87
        L83:
            r8 = move-exception
            r8.printStackTrace()
        L87:
            return r0
        L88:
            r0 = move-exception
        L89:
            if (r8 == 0) goto L93
            r8.close()     // Catch: java.lang.Exception -> L8f
            goto L93
        L8f:
            r8 = move-exception
            r8.printStackTrace()
        L93:
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gcloudsdk.apollo.ApolloVoiceConfig.JSONCfg(boolean):java.lang.String");
    }

    public static String GetSourcePath() {
        return binSourcePath;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void CopySourceToDest(java.lang.String r7) {
        /*
            r0 = 0
            android.content.Context r1 = com.gcloudsdk.apollo.ApolloVoiceConfig.mainContext     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            java.lang.String r2 = com.gcloudsdk.apollo.ApolloVoiceConfig.binName     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            java.io.InputStream r1 = r1.open(r2)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.<init>()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.append(r7)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r7 = com.gcloudsdk.apollo.ApolloVoiceConfig.binPath     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.append(r7)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            com.gcloudsdk.apollo.ApolloVoiceConfig.binSourcePath = r7     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r2 = com.gcloudsdk.apollo.ApolloVoiceConfig.binSourcePath     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            boolean r2 = r7.exists()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            if (r2 == 0) goto L3b
            long r2 = r7.length()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L54
        L3b:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r7 = 4096(0x1000, float:5.74E-42)
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
        L44:
            int r0 = r1.read(r7)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r3 = -1
            if (r0 == r3) goto L50
            r3 = 0
            r2.write(r7, r3, r0)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            goto L44
        L50:
            r2.flush()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r0 = r2
        L54:
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.lang.Exception -> L5a
            goto L5e
        L5a:
            r7 = move-exception
            r7.printStackTrace()
        L5e:
            if (r0 == 0) goto L8a
            r0.close()     // Catch: java.lang.Exception -> L86
            goto L8a
        L64:
            r7 = move-exception
            goto L8d
        L66:
            r7 = move-exception
            goto L6c
        L68:
            r7 = move-exception
            goto L8e
        L6a:
            r7 = move-exception
            r2 = r0
        L6c:
            r0 = r1
            goto L73
        L6e:
            r7 = move-exception
            r1 = r0
            goto L8e
        L71:
            r7 = move-exception
            r2 = r0
        L73:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L80
            r0.close()     // Catch: java.lang.Exception -> L7c
            goto L80
        L7c:
            r7 = move-exception
            r7.printStackTrace()
        L80:
            if (r2 == 0) goto L8a
            r2.close()     // Catch: java.lang.Exception -> L86
            goto L8a
        L86:
            r7 = move-exception
            r7.printStackTrace()
        L8a:
            return
        L8b:
            r7 = move-exception
            r1 = r0
        L8d:
            r0 = r2
        L8e:
            if (r1 == 0) goto L98
            r1.close()     // Catch: java.lang.Exception -> L94
            goto L98
        L94:
            r1 = move-exception
            r1.printStackTrace()
        L98:
            if (r0 == 0) goto La2
            r0.close()     // Catch: java.lang.Exception -> L9e
            goto La2
        L9e:
            r0 = move-exception
            r0.printStackTrace()
        La2:
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gcloudsdk.apollo.ApolloVoiceConfig.CopySourceToDest(java.lang.String):void");
    }

    public static String GetNsSourcePath() {
        return nsBinSourcePath;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0074 -> B:16:0x0077). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void CopyNsSourceToDest(java.lang.String r4) {
        /*
            r0 = 0
            android.content.Context r1 = com.gcloudsdk.apollo.ApolloVoiceConfig.mainContext     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            java.lang.String r2 = com.gcloudsdk.apollo.ApolloVoiceConfig.nsBinName     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            java.io.InputStream r1 = r1.open(r2)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r2.<init>()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r2.append(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.String r4 = com.gcloudsdk.apollo.ApolloVoiceConfig.nsBinPath     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r2.append(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.String r4 = r2.toString()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            com.gcloudsdk.apollo.ApolloVoiceConfig.nsBinSourcePath = r4     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.lang.String r2 = com.gcloudsdk.apollo.ApolloVoiceConfig.nsBinSourcePath     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L57
            r4 = 4096(0x1000, float:5.74E-42)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
        L34:
            int r0 = r1.read(r4)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r3 = -1
            if (r0 == r3) goto L40
            r3 = 0
            r2.write(r4, r3, r0)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            goto L34
        L40:
            r2.flush()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r1 == 0) goto L4d
            r1.close()     // Catch: java.lang.Exception -> L49
            goto L4d
        L49:
            r4 = move-exception
            r4.printStackTrace()
        L4d:
            r2.close()     // Catch: java.lang.Exception -> L73
            goto L77
        L51:
            r4 = move-exception
            goto L7a
        L53:
            r4 = move-exception
            goto L59
        L55:
            r4 = move-exception
            goto L7b
        L57:
            r4 = move-exception
            r2 = r0
        L59:
            r0 = r1
            goto L60
        L5b:
            r4 = move-exception
            r1 = r0
            goto L7b
        L5e:
            r4 = move-exception
            r2 = r0
        L60:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L78
            if (r0 == 0) goto L6d
            r0.close()     // Catch: java.lang.Exception -> L69
            goto L6d
        L69:
            r4 = move-exception
            r4.printStackTrace()
        L6d:
            if (r2 == 0) goto L77
            r2.close()     // Catch: java.lang.Exception -> L73
            goto L77
        L73:
            r4 = move-exception
            r4.printStackTrace()
        L77:
            return
        L78:
            r4 = move-exception
            r1 = r0
        L7a:
            r0 = r2
        L7b:
            if (r1 == 0) goto L85
            r1.close()     // Catch: java.lang.Exception -> L81
            goto L85
        L81:
            r1 = move-exception
            r1.printStackTrace()
        L85:
            if (r0 == 0) goto L8f
            r0.close()     // Catch: java.lang.Exception -> L8b
            goto L8f
        L8b:
            r0 = move-exception
            r0.printStackTrace()
        L8f:
            throw r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gcloudsdk.apollo.ApolloVoiceConfig.CopyNsSourceToDest(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void Copy3DSourceToDest(java.lang.String r7) {
        /*
            r0 = 0
            android.content.Context r1 = com.gcloudsdk.apollo.ApolloVoiceConfig.mainContext     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            java.lang.String r2 = com.gcloudsdk.apollo.ApolloVoiceConfig.tdBinName     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            java.io.InputStream r1 = r1.open(r2)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.<init>()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.append(r7)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r7 = com.gcloudsdk.apollo.ApolloVoiceConfig.tdBinPath     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.append(r7)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            com.gcloudsdk.apollo.ApolloVoiceConfig.tdBinSourcePath = r7     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r2 = com.gcloudsdk.apollo.ApolloVoiceConfig.tdBinSourcePath     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            boolean r2 = r7.exists()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            if (r2 == 0) goto L3b
            long r2 = r7.length()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L54
        L3b:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r7 = 4096(0x1000, float:5.74E-42)
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
        L44:
            int r0 = r1.read(r7)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r3 = -1
            if (r0 == r3) goto L50
            r3 = 0
            r2.write(r7, r3, r0)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            goto L44
        L50:
            r2.flush()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r0 = r2
        L54:
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.lang.Exception -> L5a
            goto L5e
        L5a:
            r7 = move-exception
            r7.printStackTrace()
        L5e:
            if (r0 == 0) goto L8a
            r0.close()     // Catch: java.lang.Exception -> L86
            goto L8a
        L64:
            r7 = move-exception
            goto L8d
        L66:
            r7 = move-exception
            goto L6c
        L68:
            r7 = move-exception
            goto L8e
        L6a:
            r7 = move-exception
            r2 = r0
        L6c:
            r0 = r1
            goto L73
        L6e:
            r7 = move-exception
            r1 = r0
            goto L8e
        L71:
            r7 = move-exception
            r2 = r0
        L73:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L80
            r0.close()     // Catch: java.lang.Exception -> L7c
            goto L80
        L7c:
            r7 = move-exception
            r7.printStackTrace()
        L80:
            if (r2 == 0) goto L8a
            r2.close()     // Catch: java.lang.Exception -> L86
            goto L8a
        L86:
            r7 = move-exception
            r7.printStackTrace()
        L8a:
            return
        L8b:
            r7 = move-exception
            r1 = r0
        L8d:
            r0 = r2
        L8e:
            if (r1 == 0) goto L98
            r1.close()     // Catch: java.lang.Exception -> L94
            goto L98
        L94:
            r1 = move-exception
            r1.printStackTrace()
        L98:
            if (r0 == 0) goto La2
            r0.close()     // Catch: java.lang.Exception -> L9e
            goto La2
        L9e:
            r0 = move-exception
            r0.printStackTrace()
        La2:
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gcloudsdk.apollo.ApolloVoiceConfig.Copy3DSourceToDest(java.lang.String):void");
    }

    public static String Get3DSourcePath() {
        return tdBinSourcePath;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void CopyDafxSourceToDest(java.lang.String r7) {
        /*
            r0 = 0
            android.content.Context r1 = com.gcloudsdk.apollo.ApolloVoiceConfig.mainContext     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            java.lang.String r2 = com.gcloudsdk.apollo.ApolloVoiceConfig.dafxBinName     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            java.io.InputStream r1 = r1.open(r2)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.<init>()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.append(r7)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r7 = com.gcloudsdk.apollo.ApolloVoiceConfig.dafxBinPath     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.append(r7)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            com.gcloudsdk.apollo.ApolloVoiceConfig.dafxBinSourcePath = r7     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r2 = com.gcloudsdk.apollo.ApolloVoiceConfig.dafxBinSourcePath     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            boolean r2 = r7.exists()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            if (r2 == 0) goto L3b
            long r2 = r7.length()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L54
        L3b:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r7 = 4096(0x1000, float:5.74E-42)
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
        L44:
            int r0 = r1.read(r7)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r3 = -1
            if (r0 == r3) goto L50
            r3 = 0
            r2.write(r7, r3, r0)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            goto L44
        L50:
            r2.flush()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r0 = r2
        L54:
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.lang.Exception -> L5a
            goto L5e
        L5a:
            r7 = move-exception
            r7.printStackTrace()
        L5e:
            if (r0 == 0) goto L8a
            r0.close()     // Catch: java.lang.Exception -> L86
            goto L8a
        L64:
            r7 = move-exception
            goto L8d
        L66:
            r7 = move-exception
            goto L6c
        L68:
            r7 = move-exception
            goto L8e
        L6a:
            r7 = move-exception
            r2 = r0
        L6c:
            r0 = r1
            goto L73
        L6e:
            r7 = move-exception
            r1 = r0
            goto L8e
        L71:
            r7 = move-exception
            r2 = r0
        L73:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L80
            r0.close()     // Catch: java.lang.Exception -> L7c
            goto L80
        L7c:
            r7 = move-exception
            r7.printStackTrace()
        L80:
            if (r2 == 0) goto L8a
            r2.close()     // Catch: java.lang.Exception -> L86
            goto L8a
        L86:
            r7 = move-exception
            r7.printStackTrace()
        L8a:
            return
        L8b:
            r7 = move-exception
            r1 = r0
        L8d:
            r0 = r2
        L8e:
            if (r1 == 0) goto L98
            r1.close()     // Catch: java.lang.Exception -> L94
            goto L98
        L94:
            r1 = move-exception
            r1.printStackTrace()
        L98:
            if (r0 == 0) goto La2
            r0.close()     // Catch: java.lang.Exception -> L9e
            goto La2
        L9e:
            r0 = move-exception
            r0.printStackTrace()
        La2:
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gcloudsdk.apollo.ApolloVoiceConfig.CopyDafxSourceToDest(java.lang.String):void");
    }

    public static String GetDafxSourcePath() {
        return dafxBinSourcePath;
    }

    public static String GetVPSourcePath() {
        return VPbinSourcePath;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0090 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void CopyVPSourceToDest(java.lang.String r7) {
        /*
            r0 = 0
            android.content.Context r1 = com.gcloudsdk.apollo.ApolloVoiceConfig.mainContext     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            java.lang.String r2 = com.gcloudsdk.apollo.ApolloVoiceConfig.VPbinName     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            java.io.InputStream r1 = r1.open(r2)     // Catch: java.lang.Throwable -> L6e java.lang.Exception -> L71
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.<init>()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.append(r7)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r7 = com.gcloudsdk.apollo.ApolloVoiceConfig.VPbinPath     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.append(r7)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r7 = r2.toString()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            com.gcloudsdk.apollo.ApolloVoiceConfig.VPbinSourcePath = r7     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.io.File r7 = new java.io.File     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            java.lang.String r2 = com.gcloudsdk.apollo.ApolloVoiceConfig.VPbinSourcePath     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            boolean r2 = r7.exists()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            if (r2 == 0) goto L3b
            long r2 = r7.length()     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L54
        L3b:
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6a
            r7 = 4096(0x1000, float:5.74E-42)
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
        L44:
            int r0 = r1.read(r7)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r3 = -1
            if (r0 == r3) goto L50
            r3 = 0
            r2.write(r7, r3, r0)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            goto L44
        L50:
            r2.flush()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            r0 = r2
        L54:
            if (r1 == 0) goto L5e
            r1.close()     // Catch: java.lang.Exception -> L5a
            goto L5e
        L5a:
            r7 = move-exception
            r7.printStackTrace()
        L5e:
            if (r0 == 0) goto L8a
            r0.close()     // Catch: java.lang.Exception -> L86
            goto L8a
        L64:
            r7 = move-exception
            goto L8d
        L66:
            r7 = move-exception
            goto L6c
        L68:
            r7 = move-exception
            goto L8e
        L6a:
            r7 = move-exception
            r2 = r0
        L6c:
            r0 = r1
            goto L73
        L6e:
            r7 = move-exception
            r1 = r0
            goto L8e
        L71:
            r7 = move-exception
            r2 = r0
        L73:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L80
            r0.close()     // Catch: java.lang.Exception -> L7c
            goto L80
        L7c:
            r7 = move-exception
            r7.printStackTrace()
        L80:
            if (r2 == 0) goto L8a
            r2.close()     // Catch: java.lang.Exception -> L86
            goto L8a
        L86:
            r7 = move-exception
            r7.printStackTrace()
        L8a:
            return
        L8b:
            r7 = move-exception
            r1 = r0
        L8d:
            r0 = r2
        L8e:
            if (r1 == 0) goto L98
            r1.close()     // Catch: java.lang.Exception -> L94
            goto L98
        L94:
            r1 = move-exception
            r1.printStackTrace()
        L98:
            if (r0 == 0) goto La2
            r0.close()     // Catch: java.lang.Exception -> L9e
            goto La2
        L9e:
            r0 = move-exception
            r0.printStackTrace()
        La2:
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gcloudsdk.apollo.ApolloVoiceConfig.CopyVPSourceToDest(java.lang.String):void");
    }
}
