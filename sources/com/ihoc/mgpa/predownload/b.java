package com.ihoc.mgpa.predownload;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes2.dex */
public interface b {

    /* loaded from: classes2.dex */
    public interface a {
    }

    /* renamed from: com.ihoc.mgpa.predownload.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public enum EnumC0140b {
        Success(0),
        ContextIsNULL(-1),
        ChannelIsNULL(-2),
        CDNUrlOrMD5IsNULL(-3),
        GamePackageNameIsNULL(-4),
        PredownFilePathIsNULL(-5),
        PredownFilePathNotExsit(-6),
        NetWorkRequestFailed(-7),
        JsonParseFailed(-8),
        CodeRunTimeException(-9),
        ServerForbidCombineApk(-10),
        CloudChannelTagIsNotCorrect(-11),
        CloudChannelTagSizeNotMatch(-12),
        ContentDecryptException(-13),
        OperationExecuteFailed(-14),
        LocalFileMd5IsNotMatched(-15),
        ServerForbidCombineApkOverChannels(-16),
        ServerCheckError(-17),
        ReadPredownloadFileException(-18);

        private final int u;

        EnumC0140b(int i) {
            this.u = i;
        }

        public int a() {
            return this.u;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
    }

    /* loaded from: classes2.dex */
    public enum d {
        Success(0, "get predownload info success!"),
        NetworkException(2, "network request exception!"),
        ResponseDataIsNotJson(3, "response content parse to json exception!"),
        ResponseDataJsonFormatException(4, "response content's json format is not correct!");

        private final int f;
        private final String g;

        d(int i, String str) {
            this.f = i;
            this.g = str;
        }

        public String a() {
            return String.format(Locale.getDefault(), "{\"ret\": %d,\"data\":{},\"msg\": \"%s\"}", Integer.valueOf(this.f), this.g);
        }
    }

    int a(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    void a(Context context, String str, ArrayList<String> arrayList, GameCallback gameCallback);

    void a(Context context, HashMap<String, String> hashMap);

    void a(String str);

    void b(String str);

    void c(String str);
}
