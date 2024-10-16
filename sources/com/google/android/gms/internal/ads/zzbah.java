package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@zzard
/* loaded from: classes2.dex */
public final class zzbah implements zzazw {

    /* renamed from: a, reason: collision with root package name */
    private final String f2847a;

    public zzbah() {
        this(null);
    }

    public zzbah(String str) {
        this.f2847a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzazw
    public final void zzed(String str) {
        try {
            String valueOf = String.valueOf(str);
            zzbad.zzdp(valueOf.length() != 0 ? "Pinging URL: ".concat(valueOf) : new String("Pinging URL: "));
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                zzyt.zzpa();
                zzazt.zza(true, httpURLConnection, this.f2847a);
                zzazx zzazxVar = new zzazx();
                zzazxVar.zza(httpURLConnection, (byte[]) null);
                int responseCode = httpURLConnection.getResponseCode();
                zzazxVar.zza(httpURLConnection, responseCode);
                if (responseCode < 200 || responseCode >= 300) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 65);
                    sb.append("Received non-success response code ");
                    sb.append(responseCode);
                    sb.append(" from pinging URL: ");
                    sb.append(str);
                    zzbad.zzep(sb.toString());
                }
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (IOException e) {
            String message = e.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message).length());
            sb2.append("Error while pinging URL: ");
            sb2.append(str);
            sb2.append(". ");
            sb2.append(message);
            zzbad.zzep(sb2.toString());
        } catch (IndexOutOfBoundsException e2) {
            String message2 = e2.getMessage();
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 32 + String.valueOf(message2).length());
            sb3.append("Error while parsing ping URL: ");
            sb3.append(str);
            sb3.append(". ");
            sb3.append(message2);
            zzbad.zzep(sb3.toString());
        } catch (RuntimeException e3) {
            String message3 = e3.getMessage();
            StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 27 + String.valueOf(message3).length());
            sb4.append("Error while pinging URL: ");
            sb4.append(str);
            sb4.append(". ");
            sb4.append(message3);
            zzbad.zzep(sb4.toString());
        }
    }
}
