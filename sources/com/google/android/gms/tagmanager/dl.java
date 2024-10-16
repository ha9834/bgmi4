package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.amazonaws.http.HttpHeader;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dl implements aa {

    /* renamed from: a, reason: collision with root package name */
    private final String f5123a;
    private final Context b;
    private final dn c;
    private final zzfw d;

    @VisibleForTesting
    private dl(dn dnVar, Context context, zzfw zzfwVar) {
        this.c = dnVar;
        this.b = context.getApplicationContext();
        this.d = zzfwVar;
        String str = Build.VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        String str2 = null;
        if (locale != null && locale.getLanguage() != null && locale.getLanguage().length() != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(locale.getLanguage().toLowerCase());
            if (locale.getCountry() != null && locale.getCountry().length() != 0) {
                sb.append("-");
                sb.append(locale.getCountry().toLowerCase());
            }
            str2 = sb.toString();
        }
        this.f5123a = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleTagManager", "4.00", str, str2, Build.MODEL, Build.ID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public dl(Context context, zzfw zzfwVar) {
        this(new dm(), context, zzfwVar);
    }

    @Override // com.google.android.gms.tagmanager.aa
    public final boolean a() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzdi.zzab("...no network connectivity");
        return false;
    }

    @Override // com.google.android.gms.tagmanager.aa
    public final void a(List<am> list) {
        int min = Math.min(list.size(), 40);
        boolean z = true;
        for (int i = 0; i < min; i++) {
            am amVar = list.get(i);
            URL a2 = a(amVar);
            if (a2 == null) {
                zzdi.zzac("No destination: discarding hit.");
                this.d.zzb(amVar);
            } else {
                InputStream inputStream = null;
                try {
                    HttpURLConnection a3 = this.c.a(a2);
                    if (z) {
                        try {
                            bh.a(this.b);
                            z = false;
                        } catch (Throwable th) {
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            a3.disconnect();
                            throw th;
                            break;
                        }
                    }
                    a3.setRequestProperty(HttpHeader.USER_AGENT, this.f5123a);
                    int responseCode = a3.getResponseCode();
                    inputStream = a3.getInputStream();
                    if (responseCode != 200) {
                        StringBuilder sb = new StringBuilder(25);
                        sb.append("Bad response: ");
                        sb.append(responseCode);
                        zzdi.zzac(sb.toString());
                        this.d.zzc(amVar);
                    } else {
                        this.d.zza(amVar);
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    a3.disconnect();
                } catch (IOException e) {
                    String valueOf = String.valueOf(e.getClass().getSimpleName());
                    zzdi.zzac(valueOf.length() != 0 ? "Exception sending hit: ".concat(valueOf) : new String("Exception sending hit: "));
                    zzdi.zzac(e.getMessage());
                    this.d.zzc(amVar);
                }
            }
        }
    }

    @VisibleForTesting
    private static URL a(am amVar) {
        try {
            return new URL(amVar.c());
        } catch (MalformedURLException unused) {
            zzdi.zzav("Error trying to parse the GTM url.");
            return null;
        }
    }
}
