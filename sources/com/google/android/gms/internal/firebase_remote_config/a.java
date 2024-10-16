package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class a extends zzai {

    /* renamed from: a, reason: collision with root package name */
    private final HttpURLConnection f4021a;
    private final int b;
    private final String c;
    private final ArrayList<String> d = new ArrayList<>();
    private final ArrayList<String> e = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(HttpURLConnection httpURLConnection) throws IOException {
        this.f4021a = httpURLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        this.b = responseCode == -1 ? 0 : responseCode;
        this.c = httpURLConnection.getResponseMessage();
        ArrayList<String> arrayList = this.d;
        ArrayList<String> arrayList2 = this.e;
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            String key = entry.getKey();
            if (key != null) {
                for (String str : entry.getValue()) {
                    if (str != null) {
                        arrayList.add(key);
                        arrayList2.add(str);
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzai
    public final int getStatusCode() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzai
    public final InputStream getContent() throws IOException {
        InputStream errorStream;
        try {
            errorStream = this.f4021a.getInputStream();
        } catch (IOException unused) {
            errorStream = this.f4021a.getErrorStream();
        }
        if (errorStream == null) {
            return null;
        }
        return new c(this, errorStream);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzai
    public final String getContentEncoding() {
        return this.f4021a.getContentEncoding();
    }

    public final long a() {
        String headerField = this.f4021a.getHeaderField("Content-Length");
        if (headerField == null) {
            return -1L;
        }
        return Long.parseLong(headerField);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzai
    public final String getContentType() {
        return this.f4021a.getHeaderField("Content-Type");
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzai
    public final String getReasonPhrase() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzai
    public final String zzag() {
        String headerField = this.f4021a.getHeaderField(0);
        if (headerField == null || !headerField.startsWith("HTTP/1.")) {
            return null;
        }
        return headerField;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzai
    public final int zzah() {
        return this.d.size();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzai
    public final String zzc(int i) {
        return this.d.get(i);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzai
    public final String zzd(int i) {
        return this.e.get(i);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzai
    public final void disconnect() {
        this.f4021a.disconnect();
    }
}
