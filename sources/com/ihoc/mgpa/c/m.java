package com.ihoc.mgpa.c;

import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import com.amazonaws.services.s3.internal.crypto.JceEncryptionConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ihoc.mgpa.TGPANative;
import com.ihoc.mgpa.f.H;
import com.ihoc.mgpa.f.RunnableC0236b;
import com.ihoc.mgpa.g.t;
import com.ihoc.mgpa.g.v;
import com.ihoc.mgpa.g.w;
import com.ihoc.mgpa.predownload.a.a;
import com.tencent.connect.common.Constants;
import com.tencent.mtt.engine.http.HttpUtils;
import com.tencent.smtt.sdk.TbsReaderView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class m implements a.InterfaceC0139a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile m f5507a;
    private ArrayList<String> c;
    private t e;
    private com.ihoc.mgpa.predownload.a.c g;
    private int b = 0;
    private HashMap<String, String> d = new HashMap<>();
    private boolean h = false;
    private List<com.ihoc.mgpa.predownload.a.a> i = new ArrayList();
    private final com.ihoc.mgpa.predownload.a.b f = new com.ihoc.mgpa.predownload.a.b();

    private m() {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x006e -> B:14:0x0081). Please report as a decompilation issue!!! */
    private static com.ihoc.mgpa.i.g a(String str, String str2, String str3) {
        byte[] bArr;
        FileOutputStream fileOutputStream;
        com.ihoc.mgpa.i.g gVar = com.ihoc.mgpa.i.g.VMP_SUCCESS;
        FileOutputStream fileOutputStream2 = null;
        try {
            bArr = Base64.encode(a(("{\"pn\":\"" + com.ihoc.mgpa.n.a.c() + "\",\"mv\":\"" + str + "\",\"sv\":\"" + str2 + "\"}").getBytes(HttpUtils.DEFAULT_ENCODE_NAME)), 2);
        } catch (Exception unused) {
            gVar = com.ihoc.mgpa.i.g.PREDOWNLOAD_ENCRYPT_EXCEPTION;
            bArr = null;
        }
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e.printStackTrace();
            gVar = com.ihoc.mgpa.i.g.PREDOWNLOAD_CLOSE_FILE_EXCEPTION;
        }
        if (bArr != null) {
            try {
                fileOutputStream = new FileOutputStream(str3);
            } catch (Exception e2) {
                e = e2;
            }
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } catch (Exception e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                gVar = com.ihoc.mgpa.i.g.PREDOWNLOAD_SAVE_FILE_EXCEPTION;
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                return gVar;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        com.ihoc.mgpa.i.g gVar2 = com.ihoc.mgpa.i.g.PREDOWNLOAD_CLOSE_FILE_EXCEPTION;
                    }
                }
                throw th;
            }
        }
        return gVar;
    }

    private String a(boolean z) {
        t tVar;
        this.h = true;
        if (!g() || (tVar = this.e) == null) {
            this.d.put("NoFileName", "none,-2");
            return "-2";
        }
        HashMap<String, ArrayList<String>> hashMap = tVar.f5580a;
        HashMap<String, t.a> hashMap2 = tVar.b;
        if (hashMap == null || hashMap.size() <= 0) {
            com.ihoc.mgpa.n.m.a("TGPA_Predownload", "get predownload channel path map null.");
            this.d.put("NoFileName", "none,-3");
            return "-3";
        }
        if (hashMap.size() > 1) {
            com.ihoc.mgpa.n.m.d("predownpath's channel get from cloud is more than 1. ", new Object[0]);
        }
        new Thread(new l(this)).start();
        for (Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().size() > 1) {
                com.ihoc.mgpa.n.m.a("channel's predownpaths get from cloud is more than 1, channel: " + key, new Object[0]);
            }
            if (hashMap2 == null || hashMap2.size() <= 0) {
                String str = Environment.getExternalStorageDirectory().getPath() + File.separator + entry.getValue().get(0) + File.separator;
                com.ihoc.mgpa.n.m.a("too many predownload path, use first one: " + str, new Object[0]);
                this.d.put("NoFileName", key + ",0");
                return str;
            }
            if (d()) {
                com.ihoc.mgpa.n.m.a("TGPA_Predownload", "support move File from gameCenter");
                String b = b(z);
                if (!"-6".equals(b)) {
                    return b;
                }
                Iterator<String> it = hashMap2.keySet().iterator();
                while (it.hasNext()) {
                    if (com.ihoc.mgpa.n.i.a(com.ihoc.mgpa.n.a.g() + File.separator + it.next())) {
                        return com.ihoc.mgpa.n.a.g();
                    }
                }
            }
            com.ihoc.mgpa.n.m.a("TGPA_Predownload", "return config pre Download dirPath");
            for (String str2 : hashMap2.keySet()) {
                Iterator<String> it2 = entry.getValue().iterator();
                while (it2.hasNext()) {
                    String str3 = Environment.getExternalStorageDirectory().getPath() + File.separator + it2.next() + File.separator;
                    if (com.ihoc.mgpa.n.i.a(str3 + File.separator + str2)) {
                        com.ihoc.mgpa.n.m.a("predownload pkg file " + str2 + " was found by channel " + key + " , in " + str3, new Object[0]);
                        HashMap<String, String> hashMap3 = this.d;
                        StringBuilder sb = new StringBuilder();
                        sb.append(key);
                        sb.append(",1");
                        hashMap3.put(str2, sb.toString());
                        return str3;
                    }
                    com.ihoc.mgpa.n.m.a("predownload pkg file " + str2 + " was not found by channel " + key + " , in " + str3, new Object[0]);
                }
            }
        }
        com.ihoc.mgpa.n.m.a("can not find pkg file in cloud predownload path.", new Object[0]);
        this.d.put("NoFileName", "none,-4");
        return "-4";
    }

    private static byte[] a(long j, int i, String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(str), "rw");
            randomAccessFile.seek(randomAccessFile.length() - j);
            byte[] bArr = new byte[i];
            randomAccessFile.read(bArr, 0, i);
            randomAccessFile.close();
            return bArr;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("TGPA", "can not read tgpa channel in predownload file content.");
            return null;
        }
    }

    private static byte[] a(byte[] bArr) {
        Cipher cipher = Cipher.getInstance(JceEncryptionConstants.SYMMETRIC_CIPHER_METHOD);
        cipher.init(1, new SecretKeySpec(TGPANative.getKey().getBytes(HttpUtils.DEFAULT_ENCODE_NAME), JceEncryptionConstants.SYMMETRIC_KEY_ALGORITHM), new IvParameterSpec(TGPANative.getIVParameter().getBytes(HttpUtils.DEFAULT_ENCODE_NAME)));
        return cipher.doFinal(bArr);
    }

    private static com.ihoc.mgpa.i.g b(String str, String str2) {
        com.ihoc.mgpa.i.g gVar = com.ihoc.mgpa.i.g.VMP_SUCCESS;
        String str3 = com.ihoc.mgpa.n.a.b() + File.separator + ".vmppd";
        File file = new File(str3);
        return (!file.exists() || file.delete()) ? a(str, str2, str3) : com.ihoc.mgpa.i.g.PREDOWNLOAD_DELETE_FILE_FAILED;
    }

    private String b(boolean z) {
        HashMap<String, t.a> hashMap = this.e.b;
        String lowerCase = com.ihoc.mgpa.n.f.c().toLowerCase();
        com.ihoc.mgpa.predownload.a.c cVar = this.g;
        int i = 0;
        if (cVar == null) {
            com.ihoc.mgpa.n.m.a("manufacturer is not support fileMove == null", new Object[0]);
            this.d.put("NoFileName", "none,-5");
            return "-6";
        }
        if (!cVar.a()) {
            com.ihoc.mgpa.n.m.d("TGPA_Predownload", lowerCase + " isAppStoreSupportPreDownload get : false.");
            this.d.put("NoFileName", "none,-5");
            return "-6";
        }
        this.i.clear();
        for (Map.Entry<String, t.a> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            t.a value = entry.getValue();
            if (key != null && value != null) {
                String str = value.c;
                String a2 = this.g.a(str);
                String str2 = IntegrityManager.INTEGRITY_TYPE_NONE.equals(a2) ? "2" : "1";
                HashMap hashMap2 = new HashMap();
                hashMap2.put("fileName", key);
                hashMap2.put("fileMD5", str);
                hashMap2.put(TbsReaderView.KEY_FILE_PATH, a2);
                hashMap2.put("action", "2");
                hashMap2.put("state", str2);
                hashMap2.put("owner", z ? "0" : "1");
                com.ihoc.mgpa.i.m.g(hashMap2);
                com.ihoc.mgpa.n.m.a("TGPA_Predownload", key + " query file path is: " + a2);
                if (a2.startsWith(FirebaseAnalytics.Param.CONTENT)) {
                    com.ihoc.mgpa.predownload.a.a aVar = new com.ihoc.mgpa.predownload.a.a(this.g, new com.ihoc.mgpa.predownload.a.e(value, a2), z);
                    aVar.a(this);
                    if (!this.i.contains(aVar)) {
                        com.ihoc.mgpa.n.m.a("TGPA_Predownload", "[movePDTask]: add new task: " + key);
                        this.i.add(aVar);
                    }
                } else if (a2.startsWith("/sdcard/")) {
                    String substring = a2.substring(0, a2.lastIndexOf("/") + 1);
                    com.ihoc.mgpa.n.m.d("TGPA_Predownload", lowerCase + " query file path is not uri, fileDirPath: " + substring);
                    return substring;
                }
            }
        }
        if (this.i.isEmpty()) {
            com.ihoc.mgpa.n.m.a("android 11 sandbox can not find pkg file in channel path.", new Object[0]);
            this.d.put("NoFileName", "none,-5");
            return "-6";
        }
        while (i < this.i.size()) {
            com.ihoc.mgpa.predownload.a.e b = this.i.get(i).b();
            b.b(this.i.size());
            int i2 = i + 1;
            b.a(i2);
            this.f.a(this.i.get(i));
            i = i2;
        }
        return "1";
    }

    private void b(com.ihoc.mgpa.predownload.a.e eVar, int i, int i2) {
        String str = "{\"CopyPreDownload\":{\"fileName\":\"testFileName\",\"progress\":0,\"status\":-1}}";
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("fileName", eVar.a().f5581a);
            jSONObject2.put("progress", i);
            jSONObject2.put("status", i2);
            jSONObject2.put("dir", com.ihoc.mgpa.n.a.g());
            jSONObject2.put("fileNum", eVar.c());
            jSONObject2.put("currentIndex", eVar.b());
            jSONObject.put("CopyPreDownload", jSONObject2);
            str = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        com.ihoc.mgpa.n.m.a("TGPA_Predownload", "notifyCopyFileProgressToGame notifyInfo: " + str);
        H.b().a(new RunnableC0236b(com.ihoc.mgpa.a.a.COPY_PREDOWNLOAD_FROM_PROVIDER, str));
    }

    public static m c() {
        if (f5507a == null) {
            synchronized (m.class) {
                if (f5507a == null) {
                    f5507a = new m();
                }
            }
        }
        return f5507a;
    }

    private String e(String str) {
        t tVar;
        if (!g() || (tVar = this.e) == null) {
            this.d.put(str, "none,-2");
            return "-2";
        }
        HashMap<String, ArrayList<String>> hashMap = tVar.f5580a;
        if (hashMap == null) {
            this.d.put(str, "none,-3");
            return "-3";
        }
        com.ihoc.mgpa.n.m.a("TGPA_Predownload", "Start to check cloud channel path.");
        for (Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                String str2 = Environment.getExternalStorageDirectory().getPath() + File.separator + it.next() + File.separator;
                if (com.ihoc.mgpa.n.i.a(str2 + str)) {
                    com.ihoc.mgpa.n.m.a("TGPA_Predownload", "predownload pkg file was found by channel " + key + " , in " + str2);
                    HashMap<String, String> hashMap2 = this.d;
                    StringBuilder sb = new StringBuilder();
                    sb.append(key);
                    sb.append(",0");
                    hashMap2.put(str, sb.toString());
                    return str2;
                }
                com.ihoc.mgpa.n.m.a("TGPA_Predownload", "predownload pkg file was not found by channel " + key + " , in " + str2);
            }
        }
        com.ihoc.mgpa.n.m.a("TGPA_Predownload", "can not find pkg file in cloud predownload path.");
        this.d.put(str, "none,-4");
        return "-4";
    }

    private void f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(com.ihoc.mgpa.a.e.MAIN_VERCODE.b(), "");
            String optString2 = jSONObject.optString(com.ihoc.mgpa.a.e.SUB_VERCODE.b(), "");
            if (!com.ihoc.mgpa.n.p.a(optString)) {
                com.ihoc.mgpa.i.f.m(optString);
            }
            if (com.ihoc.mgpa.n.p.a(optString2)) {
                return;
            }
            com.ihoc.mgpa.i.f.u(optString2);
        } catch (Throwable th) {
            th.printStackTrace();
            com.ihoc.mgpa.n.m.b("fail to parse version info: " + str, new Object[0]);
        }
    }

    private boolean g() {
        com.ihoc.mgpa.n.m.a("TGPA_Predownload", "check predownload config start! ");
        if (this.e != null) {
            com.ihoc.mgpa.n.m.a("TGPA_Predownload", "check predownload config, predownload config already exsit.");
            return true;
        }
        v vVar = new v();
        if (vVar.a() != com.ihoc.mgpa.i.g.VMP_SUCCESS || vVar.b() == null) {
            return false;
        }
        this.e = vVar.b();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        int i;
        HashMap hashMap = new HashMap();
        hashMap.put("stage", "2");
        try {
            hashMap.put("channel_id", String.valueOf(com.ihoc.mgpa.i.f.f()));
            hashMap.put("read_sd", com.ihoc.mgpa.n.f.a("android.permission.READ_EXTERNAL_STORAGE") ? "0" : "1");
            hashMap.put("write_sd", com.ihoc.mgpa.n.f.a("android.permission.WRITE_EXTERNAL_STORAGE") ? "0" : "1");
            HashMap<String, ArrayList<String>> hashMap2 = this.e.f5580a;
            HashMap<String, t.a> hashMap3 = this.e.b;
            if (hashMap2 != null && hashMap2.size() > 0) {
                if (hashMap3 != null && hashMap3.size() > 0) {
                    for (Map.Entry<String, ArrayList<String>> entry : hashMap2.entrySet()) {
                        String key = entry.getKey();
                        for (String str : hashMap3.keySet()) {
                            Iterator<String> it = entry.getValue().iterator();
                            while (it.hasNext()) {
                                String next = it.next();
                                String str2 = Environment.getExternalStorageDirectory().getPath() + File.separator + next + File.separator;
                                String str3 = str2 + File.separator + str;
                                boolean a2 = com.ihoc.mgpa.n.i.a(str3);
                                hashMap.put("predown_path", next);
                                hashMap.put(Constants.PARAM_PKG_NAME, str);
                                hashMap.put("file_exsit", a2 ? "1" : "0");
                                hashMap.put("channel_name", key);
                                if (a2) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("PD: check file tag, pkg file was found by channel ");
                                    sb.append(key);
                                    sb.append(" , in ");
                                    sb.append(str2);
                                    com.ihoc.mgpa.n.m.a("TGPA_Predownload", sb.toString());
                                    t.a aVar = hashMap3.get(str);
                                    if (aVar != null && aVar.d != 0) {
                                        byte[] a3 = a(aVar.d, aVar.e, str3);
                                        if (a3 == null) {
                                            com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: check file tag, get channel tag null. ");
                                            i = -4;
                                        } else {
                                            hashMap.put("result", String.valueOf(0));
                                            hashMap.put("channel_hextag", com.ihoc.mgpa.n.g.a(a3));
                                            hashMap.put("channel_tag", new String(a3));
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("PD: check file tag, get channel tag sucess: ");
                                            sb2.append(new String(a3));
                                            com.ihoc.mgpa.n.m.a("TGPA_Predownload", sb2.toString());
                                            com.ihoc.mgpa.i.m.i(hashMap);
                                        }
                                    }
                                    i = -3;
                                } else {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("PD: check file tag, pkg file ");
                                    sb3.append(str);
                                    sb3.append(" was not found in ");
                                    sb3.append(str2);
                                    com.ihoc.mgpa.n.m.a("TGPA_Predownload", sb3.toString());
                                    i = -5;
                                }
                                hashMap.put("result", String.valueOf(i));
                                com.ihoc.mgpa.i.m.i(hashMap);
                            }
                        }
                    }
                    return;
                }
                com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: check file tag, can not get file lists in cloud config. ");
                hashMap.put("result", String.valueOf(-2));
                com.ihoc.mgpa.i.m.i(hashMap);
                return;
            }
            com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: check file tag,  can not get file lists in cloud config. ");
            hashMap.put("result", String.valueOf(-1));
            com.ihoc.mgpa.i.m.i(hashMap);
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: check file tag, run exception.");
            hashMap.put("result", String.valueOf(-6));
            com.ihoc.mgpa.i.m.i(hashMap);
        }
    }

    private int i() {
        StringBuilder sb;
        String name;
        String str;
        if (!com.ihoc.mgpa.i.f.W()) {
            com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: clean pd files, func is not open.");
            return -1;
        }
        if (com.ihoc.mgpa.g.o.b().c.m == null) {
            com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: clean pd files, get config null.");
            return -2;
        }
        if (com.ihoc.mgpa.i.f.h() == 0) {
            com.ihoc.mgpa.i.f.a(com.ihoc.mgpa.n.f.a(com.ihoc.mgpa.n.a.a()));
        }
        long h = com.ihoc.mgpa.i.f.h();
        long j = com.ihoc.mgpa.g.o.b().c.m.f5579a;
        if (h < j) {
            com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: clean pd files, do not clean when game'code " + h + " < target code " + j + " .");
            return -3;
        }
        ArrayList<String> arrayList = com.ihoc.mgpa.g.o.b().c.m.b;
        if (arrayList == null || arrayList.size() <= 0) {
            com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: clean pd files, get clean dirs from config failed.");
            return -4;
        }
        ArrayList<String> arrayList2 = com.ihoc.mgpa.g.o.b().c.m.c;
        if (arrayList2 == null || arrayList2.size() <= 0) {
            com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: clean pd files, get clean files from config failed.");
            return -14;
        }
        Iterator<String> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                if (this.c == null) {
                    com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: clean pd files, no file need delete.");
                    return -5;
                }
                com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: clean pd files, total delete files: " + this.c.toString());
                return 0;
            }
            String str2 = Environment.getExternalStorageDirectory().getPath() + File.separator + it.next() + File.separator;
            com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: clean pd files, start to clean : " + str2);
            File file = new File(str2);
            if (!file.isDirectory()) {
                return -6;
            }
            if (!file.canRead()) {
                return -7;
            }
            if (!file.canWrite()) {
                return -8;
            }
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return -9;
            }
            for (File file2 : listFiles) {
                if (!file2.isDirectory() && !file2.isHidden()) {
                    if (arrayList2.contains(com.ihoc.mgpa.n.i.g(file2.getName()))) {
                        if (this.c == null) {
                            this.c = new ArrayList<>();
                        }
                        this.b++;
                        if (com.ihoc.mgpa.n.i.b(file2)) {
                            this.c.add(file2.getAbsolutePath());
                            sb = new StringBuilder();
                            str = "PD: clean pd files, delete success, file: ";
                        } else {
                            sb = new StringBuilder();
                            str = "PD: clean pd files, delete failed, file: ";
                        }
                        sb.append(str);
                        name = file2.getAbsolutePath();
                    } else {
                        sb = new StringBuilder();
                        sb.append("PD: clean pd files, this file is not in delete files, filename: ");
                        name = file2.getName();
                    }
                    sb.append(name);
                    com.ihoc.mgpa.n.m.a("TGPA_Predownload", sb.toString());
                }
            }
        }
    }

    public String a(String str) {
        String str2;
        com.ihoc.mgpa.n.m.a("TGPA_Predownload", "Get predownload path for file: " + String.valueOf(str));
        long currentTimeMillis = System.currentTimeMillis();
        try {
            str2 = e(str);
        } catch (Throwable th) {
            th.printStackTrace();
            com.ihoc.mgpa.n.m.b("get predownload dir code run exception, ple check it!", new Object[0]);
            str2 = "-5";
        }
        com.ihoc.mgpa.n.m.a("TGPA_Predownload", "check predownload config success, run time: " + (System.currentTimeMillis() - currentTimeMillis));
        return str2;
    }

    public void a() {
        HashMap<String, ArrayList<String>> hashMap;
        StringBuilder sb;
        String str;
        com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: start to check predownload file.");
        w wVar = com.ihoc.mgpa.g.o.b().c.h;
        if (wVar == null || (hashMap = wVar.f5584a) == null) {
            return;
        }
        for (Map.Entry<String, ArrayList<String>> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            if (value.size() > 0) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    String str2 = Environment.getExternalStorageDirectory() + File.separator + key + File.separator + next;
                    boolean a2 = com.ihoc.mgpa.n.i.a(str2);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("stage", "1");
                    hashMap2.put("predown_path", key);
                    hashMap2.put(Constants.PARAM_PKG_NAME, next);
                    hashMap2.put("file_exsit", a2 ? "1" : "0");
                    com.ihoc.mgpa.i.m.i(hashMap2);
                    if (a2) {
                        sb = new StringBuilder();
                        str = "PD: pkg file was found in ";
                    } else {
                        sb = new StringBuilder();
                        sb.append("PD: pkg file ");
                        sb.append(str2);
                        str = " was not found in ";
                    }
                    sb.append(str);
                    sb.append(key);
                    com.ihoc.mgpa.n.m.a("TGPA_Predownload", sb.toString());
                }
            } else {
                com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: no pkg file in cloud config.");
            }
        }
    }

    @Override // com.ihoc.mgpa.predownload.a.a.InterfaceC0139a
    public void a(com.ihoc.mgpa.predownload.a.e eVar, int i, int i2) {
        b(eVar, i, i2);
    }

    public void a(String str, String str2) {
        com.ihoc.mgpa.i.g gVar;
        com.ihoc.mgpa.i.g gVar2 = com.ihoc.mgpa.i.g.VMP_SUCCESS;
        if (com.ihoc.mgpa.i.f.W()) {
            com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: start to save game version. ");
            gVar = com.ihoc.mgpa.n.p.b(str) ? com.ihoc.mgpa.i.g.PREDOWNLOAD_MAIN_VERSION_IS_NULL : com.ihoc.mgpa.n.p.b(str2) ? com.ihoc.mgpa.i.g.PREDOWNLOAD_SUB_VERSION_IS_NULL : b(str, str2);
        } else {
            gVar = com.ihoc.mgpa.i.g.PREDOWNLOAD_FUNC_IS_NOT_AVAILABLE;
        }
        com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: save gameinfo result: " + gVar.a());
        int i = i();
        com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: clean predownload file result: " + i);
        HashMap hashMap = new HashMap();
        hashMap.put("result", gVar.a());
        hashMap.put(ViewHierarchyConstants.TAG_KEY, "1");
        hashMap.put("clean_result", String.valueOf(i));
        hashMap.put("total_num", String.valueOf(this.b));
        hashMap.put("read_sd", com.ihoc.mgpa.n.f.a("android.permission.READ_EXTERNAL_STORAGE") ? "0" : "1");
        hashMap.put("write_sd", com.ihoc.mgpa.n.f.a("android.permission.WRITE_EXTERNAL_STORAGE") ? "0" : "1");
        ArrayList<String> arrayList = this.c;
        if (arrayList != null) {
            hashMap.put("clean_num", String.valueOf(arrayList.size()));
            hashMap.put("clean_files", com.ihoc.mgpa.n.b.a(this.c, ";"));
        } else {
            hashMap.put("clean_num", "0");
            hashMap.put("clean_files", "");
        }
        com.ihoc.mgpa.i.m.j(hashMap);
    }

    public String b(String str) {
        String str2;
        com.ihoc.mgpa.n.m.a("TGPA_Predownload", "Get predownload path with no file name. ");
        long currentTimeMillis = System.currentTimeMillis();
        f(str);
        try {
            str2 = a(true);
        } catch (Throwable th) {
            th.printStackTrace();
            com.ihoc.mgpa.n.m.b("get predownload dir code run exception, ple check it!", new Object[0]);
            str2 = "-5";
        }
        com.ihoc.mgpa.n.m.a("TGPA_Predownload", "check predownload config success, run time: " + (System.currentTimeMillis() - currentTimeMillis));
        return str2;
    }

    public void b() {
        int i = i();
        com.ihoc.mgpa.n.m.a("TGPA_Predownload", "PD: clean predownload file result: " + i);
        HashMap hashMap = new HashMap();
        hashMap.put("result", "0");
        hashMap.put(ViewHierarchyConstants.TAG_KEY, "2");
        hashMap.put("clean_result", String.valueOf(i));
        hashMap.put("total_num", String.valueOf(this.b));
        hashMap.put("read_sd", com.ihoc.mgpa.n.f.a("android.permission.READ_EXTERNAL_STORAGE") ? "0" : "1");
        hashMap.put("write_sd", com.ihoc.mgpa.n.f.a("android.permission.WRITE_EXTERNAL_STORAGE") ? "0" : "1");
        ArrayList<String> arrayList = this.c;
        if (arrayList != null) {
            hashMap.put("clean_num", String.valueOf(arrayList.size()));
            hashMap.put("clean_files", com.ihoc.mgpa.n.b.a(this.c, ";"));
        } else {
            hashMap.put("clean_num", "0");
            hashMap.put("clean_files", "");
        }
        com.ihoc.mgpa.i.m.j(hashMap);
    }

    public String c(String str) {
        String str2;
        if (str == null || (str2 = this.d.get(str)) == null) {
            return IntegrityManager.INTEGRITY_TYPE_NONE;
        }
        String[] split = str2.split(",");
        return split.length == 2 ? split[0] : str2;
    }

    public String d(String str) {
        if (str == null) {
            return "-3";
        }
        String str2 = this.d.get(str);
        if (str2 == null) {
            return "-2";
        }
        String[] split = str2.split(",");
        return split.length == 2 ? split[1] : str2;
    }

    public boolean d() {
        com.ihoc.mgpa.predownload.a.c dVar;
        t tVar = this.e;
        if (tVar == null || !tVar.c) {
            com.ihoc.mgpa.n.m.a("TGPA_Predownload", "CloudConfig is not support to copyPreFile!");
            return false;
        }
        String lowerCase = com.ihoc.mgpa.n.f.c().toLowerCase();
        char c = 65535;
        int hashCode = lowerCase.hashCode();
        if (hashCode != -1320380160) {
            if (hashCode != -934971466) {
                if (hashCode != 3418016) {
                    if (hashCode == 3620012 && lowerCase.equals("vivo")) {
                        c = 3;
                    }
                } else if (lowerCase.equals("oppo")) {
                    c = 0;
                }
            } else if (lowerCase.equals("realme")) {
                c = 1;
            }
        } else if (lowerCase.equals("oneplus")) {
            c = 2;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                dVar = new com.ihoc.mgpa.predownload.a.d();
                this.g = dVar;
                break;
            case 3:
                dVar = new com.ihoc.mgpa.predownload.a.f();
                this.g = dVar;
                break;
            default:
                com.ihoc.mgpa.n.m.d("TGPA_Predownload", lowerCase + " getPredownloadFilePathAndAndroid11, manufacturer is not support at now: " + lowerCase);
                break;
        }
        com.ihoc.mgpa.predownload.a.c cVar = this.g;
        if (cVar == null) {
            com.ihoc.mgpa.n.m.a("[isFeatureSupportMoveFile]: FileMover == null.", new Object[0]);
            return false;
        }
        boolean a2 = cVar.a();
        com.ihoc.mgpa.n.m.d("TGPA_Predownload", lowerCase + " isAppStoreSupportPreDownload get : " + a2);
        return a2;
    }

    public void e() {
        this.f.b();
    }

    public void f() {
        if (this.h && this.f.a()) {
            this.f.c();
        } else {
            if (this.h) {
                return;
            }
            this.h = true;
            a(false);
        }
    }
}
