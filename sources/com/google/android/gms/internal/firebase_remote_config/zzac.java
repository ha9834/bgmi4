package com.google.android.gms.internal.firebase_remote_config;

import com.tencent.imsdk.android.tools.net.volley.toolbox.HttpStack;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

/* loaded from: classes2.dex */
public final class zzac {

    /* renamed from: a, reason: collision with root package name */
    private InputStream f4116a;
    private final String b;
    private final String c;
    private final zzy d;
    private zzai e;
    private final int f;
    private final String g;
    private final zzab h;
    private int i;
    private boolean j;
    private boolean k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzac(zzab zzabVar, zzai zzaiVar) throws IOException {
        StringBuilder sb;
        this.h = zzabVar;
        this.i = zzabVar.zzv();
        this.j = zzabVar.zzw();
        this.e = zzaiVar;
        this.b = zzaiVar.getContentEncoding();
        int statusCode = zzaiVar.getStatusCode();
        boolean z = false;
        this.f = statusCode < 0 ? 0 : statusCode;
        String reasonPhrase = zzaiVar.getReasonPhrase();
        this.g = reasonPhrase;
        Logger logger = zzag.f4119a;
        if (this.j && logger.isLoggable(Level.CONFIG)) {
            z = true;
        }
        if (z) {
            sb = new StringBuilder();
            sb.append("-------------- RESPONSE --------------");
            sb.append(zzcl.zzgh);
            String zzag = zzaiVar.zzag();
            if (zzag != null) {
                sb.append(zzag);
            } else {
                sb.append(this.f);
                if (reasonPhrase != null) {
                    sb.append(' ');
                    sb.append(reasonPhrase);
                }
            }
            sb.append(zzcl.zzgh);
        } else {
            sb = null;
        }
        zzabVar.zzy().zza(zzaiVar, z ? sb : null);
        String contentType = zzaiVar.getContentType();
        contentType = contentType == null ? zzabVar.zzy().getContentType() : contentType;
        this.c = contentType;
        this.d = contentType != null ? new zzy(contentType) : null;
        if (z) {
            logger.logp(Level.CONFIG, "com.google.api.client.http.HttpResponse", "<init>", sb.toString());
        }
    }

    public final String getContentType() {
        return this.c;
    }

    public final zzw zzx() {
        return this.h.zzy();
    }

    public final boolean zzad() {
        int i = this.f;
        return i >= 200 && i < 300;
    }

    public final int getStatusCode() {
        return this.f;
    }

    public final String getStatusMessage() {
        return this.g;
    }

    public final InputStream getContent() throws IOException {
        if (!this.k) {
            InputStream content = this.e.getContent();
            if (content != null) {
                try {
                    String str = this.b;
                    if (str != null && str.contains(HttpStack.ENCODING_GZIP)) {
                        content = new GZIPInputStream(content);
                    }
                    Logger logger = zzag.f4119a;
                    if (this.j && logger.isLoggable(Level.CONFIG)) {
                        content = new zzce(content, logger, Level.CONFIG, this.i);
                    }
                    this.f4116a = content;
                } catch (EOFException unused) {
                    content.close();
                } catch (Throwable th) {
                    content.close();
                    throw th;
                }
            }
            this.k = true;
        }
        return this.f4116a;
    }

    public final void ignore() throws IOException {
        InputStream content = getContent();
        if (content != null) {
            content.close();
        }
    }

    public final void disconnect() throws IOException {
        ignore();
        this.e.disconnect();
    }

    public final <T> T zza(Class<T> cls) throws IOException {
        int i = this.f;
        boolean z = true;
        if (this.h.getRequestMethod().equals("HEAD") || i / 100 == 1 || i == 204 || i == 304) {
            ignore();
            z = false;
        }
        if (z) {
            return (T) this.h.zzaa().zza(getContent(), a(), cls);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzae() throws IOException {
        InputStream content = getContent();
        if (content == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            zzdt.checkNotNull(content);
            zzdt.checkNotNull(byteArrayOutputStream);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = content.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    content.close();
                    return byteArrayOutputStream.toString(a().name());
                }
            }
        } catch (Throwable th) {
            content.close();
            throw th;
        }
    }

    private final Charset a() {
        zzy zzyVar = this.d;
        return (zzyVar == null || zzyVar.zzr() == null) ? zzbo.ISO_8859_1 : this.d.zzr();
    }
}
