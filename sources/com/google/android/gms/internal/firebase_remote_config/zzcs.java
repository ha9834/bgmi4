package com.google.android.gms.internal.firebase_remote_config;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* loaded from: classes2.dex */
public final class zzcs {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcr f4148a = new zzcu("-_.*", true);
    private static final zzcr b = new zzcu("-_.!~*'()@:$&,;=", false);
    private static final zzcr c = new zzcu("-_.!~*'()@:$&,;=+/?", false);
    private static final zzcr d = new zzcu("-_.!~*'():$&,;=", false);
    private static final zzcr e = new zzcu("-_.!~*'()@:$,;/?:", false);

    public static String zzah(String str) {
        return f4148a.zzag(str);
    }

    public static String zzai(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String zzaj(String str) {
        return b.zzag(str);
    }

    public static String zzak(String str) {
        return c.zzag(str);
    }

    public static String zzal(String str) {
        return d.zzag(str);
    }

    public static String zzam(String str) {
        return e.zzag(str);
    }
}
