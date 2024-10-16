package com.google.android.gms.internal.firebase_remote_config;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.internal.firebase_remote_config.zzfe;
import com.google.android.gms.internal.firebase_remote_config.zzkt;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes2.dex */
public final class zzfd {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f4169a = Charset.forName("UTF-8");
    private static final ThreadLocal<DateFormat> b = new ax();
    private final Context c;
    private final String d;
    private final SharedPreferences e;

    public zzfd(Context context, String str) {
        this.c = context;
        this.d = str;
        this.e = context.getSharedPreferences("com.google.firebase.remoteconfig_legacy_settings", 0);
    }

    public final boolean zzdf() {
        zzep a2;
        zzep b2;
        zzep c;
        zzep c2;
        zzep b3;
        zzep a3;
        if (!this.e.getBoolean("save_legacy_configs", true)) {
            return false;
        }
        zzfe.zze a4 = a();
        HashMap hashMap = new HashMap();
        if (a4 != null) {
            Map<String, zzep> a5 = a(a4.zzdu());
            Map<String, zzep> a6 = a(a4.zzdt());
            Map<String, zzep> a7 = a(a4.zzdv());
            HashSet<String> hashSet = new HashSet();
            hashSet.addAll(a5.keySet());
            hashSet.addAll(a6.keySet());
            hashSet.addAll(a7.keySet());
            for (String str : hashSet) {
                ay ayVar = new ay(null);
                if (a5.containsKey(str)) {
                    ayVar.b(a5.get(str));
                }
                if (a6.containsKey(str)) {
                    ayVar.a(a6.get(str));
                }
                if (a7.containsKey(str)) {
                    ayVar.c(a7.get(str));
                }
                hashMap.put(str, ayVar);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            ay ayVar2 = (ay) entry.getValue();
            zzeh a8 = a(str2, "fetch");
            zzeh a9 = a(str2, "activate");
            zzeh a10 = a(str2, "defaults");
            a2 = ayVar2.a();
            if (a2 != null) {
                a3 = ayVar2.a();
                a8.zzc(a3);
            }
            b2 = ayVar2.b();
            if (b2 != null) {
                b3 = ayVar2.b();
                a9.zzc(b3);
            }
            c = ayVar2.c();
            if (c != null) {
                c2 = ayVar2.c();
                a10.zzc(c2);
            }
        }
        this.e.edit().putBoolean("save_legacy_configs", false).commit();
        return true;
    }

    private final Map<String, zzep> a(zzfe.zza zzaVar) {
        HashMap hashMap = new HashMap();
        Date date = new Date(zzaVar.getTimestamp());
        List<zzfx> zzdl = zzaVar.zzdl();
        ArrayList arrayList = new ArrayList();
        Iterator<zzfx> it = zzdl.iterator();
        while (it.hasNext()) {
            zzkt.zzb a2 = a(it.next());
            if (a2 != null) {
                zzdd zzddVar = new zzdd();
                zzddVar.zzan(a2.zzjm());
                zzddVar.zzaq(a2.zzjn());
                zzddVar.zzao(b.get().format(new Date(a2.zzjo())));
                zzddVar.zzap(a2.zzjp());
                zzddVar.zzb(Long.valueOf(a2.zzjq()));
                zzddVar.zza(Long.valueOf(a2.zzjr()));
                arrayList.add(zzddVar);
            }
        }
        for (zzfe.zzd zzdVar : zzaVar.zzdk()) {
            String namespace = zzdVar.getNamespace();
            if (namespace.startsWith("configns:")) {
                namespace = namespace.substring(9);
            }
            zzer zzct = zzep.zzct();
            List<zzfe.zzb> zzdr = zzdVar.zzdr();
            HashMap hashMap2 = new HashMap();
            for (zzfe.zzb zzbVar : zzdr) {
                hashMap2.put(zzbVar.getKey(), zzbVar.zzdo().zzb(f4169a));
            }
            zzer zzc = zzct.zzd(hashMap2).zzc(date);
            if (namespace.equals("firebase")) {
                zzc.zzb(arrayList);
            }
            try {
                hashMap.put(namespace, zzc.zzcw());
            } catch (JSONException unused) {
                Log.i("FirebaseRemoteConfig", "A set of legacy configs could not be converted.");
            }
        }
        return hashMap;
    }

    private static zzkt.zzb a(zzfx zzfxVar) {
        try {
            zzgc zzgcVar = (zzgc) zzfxVar.iterator();
            byte[] bArr = new byte[zzfxVar.size()];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = zzgcVar.next().byteValue();
            }
            return zzkt.zzb.zzg(bArr);
        } catch (zzhm e) {
            Log.i("FirebaseRemoteConfig", "Payload was not defined or could not be deserialized.", e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    private final zzfe.zze a() {
        FileInputStream fileInputStream;
        ?? r0 = this.c;
        try {
            if (r0 == 0) {
                return null;
            }
            try {
                fileInputStream = r0.openFileInput("persisted_config");
                try {
                    zzfe.zze zzb = zzfe.zze.zzb(fileInputStream);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e);
                        }
                    }
                    return zzb;
                } catch (FileNotFoundException e2) {
                    e = e2;
                    if (Log.isLoggable("FirebaseRemoteConfig", 3)) {
                        Log.d("FirebaseRemoteConfig", "Persisted config file was not found.", e);
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e3);
                        }
                    }
                    return null;
                } catch (IOException e4) {
                    e = e4;
                    Log.e("FirebaseRemoteConfig", "Cannot initialize from persisted config.", e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e5);
                        }
                    }
                    return null;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
                fileInputStream = null;
            } catch (IOException e7) {
                e = e7;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                r0 = 0;
                if (r0 != 0) {
                    try {
                        r0.close();
                    } catch (IOException e8) {
                        Log.e("FirebaseRemoteConfig", "Failed to close persisted config file.", e8);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private final zzeh a(String str, String str2) {
        return RemoteConfigComponent.zza(this.c, this.d, str, str2);
    }
}
