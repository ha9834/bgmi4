package com.google.android.gms.tagmanager;

import android.net.Uri;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@ShowFirstParty
@VisibleForTesting
/* loaded from: classes2.dex */
class zzeh {

    /* renamed from: a, reason: collision with root package name */
    private static zzeh f5169a;
    private volatile zza b = zza.NONE;
    private volatile String d = null;
    private volatile String c = null;
    private volatile String e = null;

    /* loaded from: classes2.dex */
    enum zza {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    zzeh() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ShowFirstParty
    public static zzeh a() {
        zzeh zzehVar;
        synchronized (zzeh.class) {
            if (f5169a == null) {
                f5169a = new zzeh();
            }
            zzehVar = f5169a;
        }
        return zzehVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean a(Uri uri) {
        try {
            String decode = URLDecoder.decode(uri.toString(), "UTF-8");
            if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                String valueOf = String.valueOf(decode);
                zzdi.zzab(valueOf.length() != 0 ? "Container preview url: ".concat(valueOf) : new String("Container preview url: "));
                if (decode.matches(".*?&gtm_debug=x$")) {
                    this.b = zza.CONTAINER_DEBUG;
                } else {
                    this.b = zza.CONTAINER;
                }
                this.e = uri.getQuery().replace("&gtm_debug=x", "");
                if (this.b == zza.CONTAINER || this.b == zza.CONTAINER_DEBUG) {
                    String valueOf2 = String.valueOf("/r?");
                    String valueOf3 = String.valueOf(this.e);
                    this.d = valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2);
                }
                this.c = a(this.e);
                return true;
            }
            if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                if (!a(uri.getQuery()).equals(this.c)) {
                    return false;
                }
                String valueOf4 = String.valueOf(this.c);
                zzdi.zzab(valueOf4.length() != 0 ? "Exit preview mode for container: ".concat(valueOf4) : new String("Exit preview mode for container: "));
                this.b = zza.NONE;
                this.d = null;
                return true;
            }
            String valueOf5 = String.valueOf(decode);
            zzdi.zzac(valueOf5.length() != 0 ? "Invalid preview uri: ".concat(valueOf5) : new String("Invalid preview uri: "));
            return false;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zza b() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.c;
    }

    private static String a(String str) {
        return str.split("&")[0].split("=")[1];
    }
}
