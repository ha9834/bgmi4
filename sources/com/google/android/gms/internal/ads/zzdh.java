package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes2.dex */
public final class zzdh {
    private static final String[] e = {"/aclk", "/pcs/click", "/dbm/clk"};

    /* renamed from: a, reason: collision with root package name */
    private String f3557a = "googleads.g.doubleclick.net";
    private String b = "/pagead/ads";
    private String c = "ad.doubleclick.net";
    private String[] d = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzdc f;

    public zzdh(zzdc zzdcVar) {
        this.f = zzdcVar;
    }

    public final void zzb(String str, String str2) {
        this.f3557a = str;
        this.b = str2;
    }

    public final boolean zza(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            if (uri.getHost().equals(this.f3557a)) {
                if (uri.getPath().equals(this.b)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    private final boolean a(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.c);
        } catch (NullPointerException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzc(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String str : this.d) {
                if (host.endsWith(str)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public final void zzam(String str) {
        this.d = str.split(",");
    }

    public final zzdc zzcg() {
        return this.f;
    }

    public final Uri zza(Uri uri, Context context) throws zzdi {
        return a(uri, context, null, false, null, null);
    }

    public final void zza(MotionEvent motionEvent) {
        this.f.zza(motionEvent);
    }

    public final Uri zza(Uri uri, Context context, View view, Activity activity) throws zzdi {
        try {
            return a(uri, context, uri.getQueryParameter("ai"), true, view, activity);
        } catch (UnsupportedOperationException unused) {
            throw new zzdi("Provided Uri is not in a valid state");
        }
    }

    public final boolean zzd(Uri uri) {
        if (zzc(uri)) {
            for (String str : e) {
                if (uri.getPath().endsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final Uri a(Uri uri, Context context, String str, boolean z, View view, Activity activity) throws zzdi {
        String zza;
        try {
            boolean a2 = a(uri);
            if (a2) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzdi("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzdi("Query parameter already exists: ms");
            }
            if (z) {
                zza = this.f.zza(context, str, view, activity);
            } else {
                zza = this.f.zza(context);
            }
            if (a2) {
                String uri2 = uri.toString();
                int indexOf = uri2.indexOf(";adurl");
                if (indexOf != -1) {
                    int i = indexOf + 1;
                    return Uri.parse(uri2.substring(0, i) + "dc_ms=" + zza + ";" + uri2.substring(i));
                }
                String encodedPath = uri.getEncodedPath();
                int indexOf2 = uri2.indexOf(encodedPath);
                return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";dc_ms=" + zza + ";" + uri2.substring(indexOf2 + encodedPath.length()));
            }
            String uri3 = uri.toString();
            int indexOf3 = uri3.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = uri3.indexOf("?adurl");
            }
            if (indexOf3 != -1) {
                int i2 = indexOf3 + 1;
                return Uri.parse(uri3.substring(0, i2) + "ms=" + zza + "&" + uri3.substring(i2));
            }
            return uri.buildUpon().appendQueryParameter("ms", zza).build();
        } catch (UnsupportedOperationException unused) {
            throw new zzdi("Provided Uri is not in a valid state");
        }
    }
}
