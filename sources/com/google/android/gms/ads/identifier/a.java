package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Map f1146a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AdvertisingIdClient advertisingIdClient, Map map) {
        this.f1146a = map;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        String message;
        StringBuilder sb;
        String str2;
        Exception exc;
        new zzc();
        Map map = this.f1146a;
        Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str3 : map.keySet()) {
            buildUpon.appendQueryParameter(str3, (String) map.get(str3));
        }
        String uri = buildUpon.build().toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri).openConnection();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(uri).length() + 65);
                    sb2.append("Received non-success response code ");
                    sb2.append(responseCode);
                    sb2.append(" from pinging URL: ");
                    sb2.append(uri);
                    Log.w("HttpUrlPinger", sb2.toString());
                }
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (IOException e) {
            e = e;
            str = "HttpUrlPinger";
            message = e.getMessage();
            sb = new StringBuilder(String.valueOf(uri).length() + 27 + String.valueOf(message).length());
            str2 = "Error while pinging URL: ";
            exc = e;
            sb.append(str2);
            sb.append(uri);
            sb.append(". ");
            sb.append(message);
            Log.w(str, sb.toString(), exc);
        } catch (IndexOutOfBoundsException e2) {
            str = "HttpUrlPinger";
            message = e2.getMessage();
            sb = new StringBuilder(String.valueOf(uri).length() + 32 + String.valueOf(message).length());
            str2 = "Error while parsing ping URL: ";
            exc = e2;
            sb.append(str2);
            sb.append(uri);
            sb.append(". ");
            sb.append(message);
            Log.w(str, sb.toString(), exc);
        } catch (RuntimeException e3) {
            e = e3;
            str = "HttpUrlPinger";
            message = e.getMessage();
            sb = new StringBuilder(String.valueOf(uri).length() + 27 + String.valueOf(message).length());
            str2 = "Error while pinging URL: ";
            exc = e;
            sb.append(str2);
            sb.append(uri);
            sb.append(". ");
            sb.append(message);
            Log.w(str, sb.toString(), exc);
        }
    }
}
