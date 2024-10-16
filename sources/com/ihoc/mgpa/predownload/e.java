package com.ihoc.mgpa.predownload;

import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ihoc.mgpa.n.m;
import com.ihoc.mgpa.predownload.b;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public long f5693a = 0;
    private long b = 0;
    public long c = 0;
    public long d = 0;
    private final com.ihoc.mgpa.predownload.a e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f5694a;
        public int b;
        public String c;

        public a(long j, int i, String str) {
            this.f5694a = j;
            this.b = i;
            this.c = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<c> f5695a;
        private final String b;

        public b(String str, ArrayList<c> arrayList) {
            this.b = str;
            this.f5695a = arrayList;
        }

        private boolean a(c cVar) {
            m.a("can not delete predownload file content.", new Object[0]);
            return false;
        }

        private boolean b(c cVar) {
            m.a("use modify instead of insert predownload file content.", new Object[0]);
            return c(cVar);
        }

        private boolean c(c cVar) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.b), "rw");
                long length = randomAccessFile.length();
                long j = cVar.c;
                int i = cVar.d;
                byte[] b = com.ihoc.mgpa.n.g.b(cVar.e);
                if (b.length != i) {
                    Log.e("TGPA", "cloud operation's content size is not matched, ple check it.");
                    return false;
                }
                randomAccessFile.seek(length - j);
                randomAccessFile.write(b, 0, i);
                randomAccessFile.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("TGPA", "can not modify predownload file content.");
                return false;
            }
        }

        public boolean a() {
            ArrayList<c> arrayList;
            if (this.b == null || (arrayList = this.f5695a) == null || arrayList.size() <= 0) {
                return false;
            }
            Iterator<c> it = this.f5695a.iterator();
            while (it.hasNext()) {
                c next = it.next();
                String str = next.b;
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1335458389) {
                    if (hashCode != -1183792455) {
                        if (hashCode == -1068795718 && str.equals("modify")) {
                            c = 2;
                        }
                    } else if (str.equals("insert")) {
                        c = 0;
                    }
                } else if (str.equals("delete")) {
                    c = 1;
                }
                if (c != 0) {
                    if (c != 1) {
                        if (c == 2 && !c(next)) {
                            return false;
                        }
                    } else if (!a(next)) {
                        return false;
                    }
                } else if (!b(next)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public int f5696a;
        public String b;
        public long c;
        public int d;
        public String e;

        private c() {
        }

        public boolean a(JSONObject jSONObject) {
            if (!jSONObject.has(FirebaseAnalytics.Param.INDEX) || !jSONObject.has("action") || !jSONObject.has("offset") || !jSONObject.has("size") || !jSONObject.has(FirebaseAnalytics.Param.CONTENT)) {
                return false;
            }
            try {
                this.f5696a = jSONObject.getInt(FirebaseAnalytics.Param.INDEX);
                this.b = jSONObject.getString("action");
                this.c = jSONObject.getLong("offset");
                this.d = jSONObject.getInt("size");
                this.e = jSONObject.getString(FirebaseAnalytics.Param.CONTENT);
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public e(com.ihoc.mgpa.predownload.a aVar) {
        this.e = aVar;
    }

    private b.EnumC0140b a(String str, String str2, int i, a aVar, ArrayList<c> arrayList) {
        long j = aVar.f5694a;
        int i2 = aVar.b;
        String str3 = aVar.c;
        if (i != 0 && i != 1) {
            m.a("current server forbid to combine apk. status: %d", Integer.valueOf(i));
            return b.EnumC0140b.ServerForbidCombineApk;
        }
        try {
            byte[] b2 = com.ihoc.mgpa.n.g.b(str3);
            if (b2.length != i2) {
                m.a("cloud channel tag's content size is not matched, ple check it.", new Object[0]);
                return b.EnumC0140b.CloudChannelTagSizeNotMatch;
            }
            byte[] a2 = a(j, i2, str2);
            if (a2 == null) {
                return b.EnumC0140b.ReadPredownloadFileException;
            }
            if (i != 0) {
                return i == 1 ? !new b(str2, arrayList).a() ? b.EnumC0140b.OperationExecuteFailed : !a(str, str2) ? b.EnumC0140b.LocalFileMd5IsNotMatched : b.EnumC0140b.Success : b.EnumC0140b.ServerForbidCombineApk;
            }
            m.a("local tag: %s, cloud tag: %s", String.valueOf(com.ihoc.mgpa.n.g.a(a2)), str3);
            if (!a(a2, b2)) {
                m.a("you can't combine other channels' predownload file.", new Object[0]);
                return b.EnumC0140b.ServerForbidCombineApkOverChannels;
            }
            if (new b(str2, arrayList).a()) {
                return !a(str, str2) ? b.EnumC0140b.LocalFileMd5IsNotMatched : b.EnumC0140b.Success;
            }
            m.a("cloud operation do failed, ple check it.", new Object[0]);
            return b.EnumC0140b.OperationExecuteFailed;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("TGPA", "cloud channel tag's content decrypt failed. ");
            return b.EnumC0140b.ContentDecryptException;
        }
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            m.a("combine apk cdnMD5 is null, do not need check.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String a2 = com.ihoc.mgpa.n.g.a(new File(str2));
        this.d = System.currentTimeMillis() - currentTimeMillis;
        if (a2 != null && a2.equals(str)) {
            return true;
        }
        m.b("combine apk failed, md5 is not matched. md5: %s", a2);
        return false;
    }

    private boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        if (Arrays.equals(bArr, bArr2)) {
            return true;
        }
        Log.e("TGPA", "predownload file's channel tag is not matched in cloud config.");
        return false;
    }

    private byte[] a(long j, int i, String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(new File(str), "rw");
            randomAccessFile.seek(randomAccessFile.length() - j);
            byte[] bArr = new byte[i];
            randomAccessFile.read(bArr, 0, i);
            randomAccessFile.close();
            return bArr;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("TGPA", "can not read tgpa channel in predownload file content.");
            return null;
        }
    }

    private boolean c(JSONObject jSONObject) {
        JSONObject optJSONObject;
        return jSONObject.has("channel_tag") && (optJSONObject = jSONObject.optJSONObject("channel_tag")) != null && optJSONObject.has("offset") && optJSONObject.has("size") && optJSONObject.has(FirebaseAnalytics.Param.CONTENT);
    }

    public b.EnumC0140b a(String str) {
        if (str == null) {
            m.b("combine package request failed, please check. ", new Object[0]);
            return b.EnumC0140b.NetWorkRequestFailed;
        }
        m.a("combine package response: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("ret")) {
                m.a("combine package response parse exception, no ret, please check!", new Object[0]);
                return b.EnumC0140b.JsonParseFailed;
            }
            int i = jSONObject.getInt("ret");
            if (i != 0) {
                m.a("combine package request error, ret is not 0, ret = %d , please check!", Integer.valueOf(i));
                return b.EnumC0140b.ServerCheckError;
            }
            if (jSONObject.has("data")) {
                return b.EnumC0140b.Success;
            }
            m.a("combine package request error, no data, please check!", new Object[0]);
            return b.EnumC0140b.JsonParseFailed;
        } catch (JSONException e) {
            e.printStackTrace();
            m.b("combine package response parse to json exception.", new Object[0]);
            return b.EnumC0140b.JsonParseFailed;
        }
    }

    public b.EnumC0140b a(String str, com.ihoc.mgpa.predownload.a aVar) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            int i = jSONObject.getInt("status");
            if (!c(jSONObject)) {
                m.a("cloud channel tag parse failed, ple check it.", new Object[0]);
                return b.EnumC0140b.CloudChannelTagIsNotCorrect;
            }
            a a2 = a(jSONObject);
            ArrayList<c> b2 = b(jSONObject);
            if (b2 != null) {
                return a(aVar.b, aVar.c, i, a2, b2);
            }
            m.a("cloud operation parse failed, ple check it.", new Object[0]);
            return b.EnumC0140b.JsonParseFailed;
        } catch (JSONException e) {
            e.printStackTrace();
            return b.EnumC0140b.JsonParseFailed;
        } catch (Exception e2) {
            e2.printStackTrace();
            m.b("combine apk failed because of unkown exception. ple call the developer.", new Object[0]);
            return b.EnumC0140b.CodeRunTimeException;
        }
    }

    public a a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("channel_tag");
        return new a(optJSONObject.getLong("offset"), optJSONObject.getInt("size"), optJSONObject.getString(FirebaseAnalytics.Param.CONTENT));
    }

    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("event_name", "CombineApk");
        hashMap.put("game_name", this.e.e);
        hashMap.put("begin_time", String.valueOf(this.f5693a));
        hashMap.put("load_time", String.valueOf(this.f5693a));
        hashMap.put("end_time", String.valueOf(this.b));
        hashMap.put("md5_time", String.valueOf(this.d));
        hashMap.put("request_time", String.valueOf(this.c - this.f5693a));
        hashMap.put("run_time", String.valueOf(this.b - this.f5693a));
        hashMap.put("report_time", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("predown_file", String.valueOf(this.e.c));
        hashMap.put("file_name", String.valueOf(this.e.f5686a));
        hashMap.put("file_md5", String.valueOf(this.e.b));
        hashMap.put("predownfile_md5", this.e.d);
        return hashMap;
    }

    public ArrayList<c> b(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (jSONObject == null || !jSONObject.has("alter_list") || (optJSONArray = jSONObject.optJSONArray("alter_list")) == null || optJSONArray.length() <= 0) {
            return null;
        }
        ArrayList<c> arrayList = new ArrayList<>();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject == null || optJSONObject.optInt(FirebaseAnalytics.Param.INDEX) != i) {
                return null;
            }
            c cVar = new c();
            if (!cVar.a(optJSONObject)) {
                m.a("File operation parse exception, index: " + i, new Object[0]);
                return null;
            }
            arrayList.add(cVar);
        }
        if (arrayList.size() <= 0) {
            return null;
        }
        return arrayList;
    }

    public void b() {
        this.c = System.currentTimeMillis();
    }

    public void c() {
        this.b = System.currentTimeMillis();
    }

    public void d() {
        this.f5693a = System.currentTimeMillis();
    }
}
