package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public class zzax extends zzr<String> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2821a;
    private zzaa<String> b;

    public zzax(int i, String str, zzaa<String> zzaaVar, zzz zzzVar) {
        super(i, str, zzzVar);
        this.f2821a = new Object();
        this.b = zzaaVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zzr
    public void a(String str) {
        zzaa<String> zzaaVar;
        synchronized (this.f2821a) {
            zzaaVar = this.b;
        }
        if (zzaaVar != null) {
            zzaaVar.zzb(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzr
    public final zzy<String> a(zzp zzpVar) {
        String str;
        try {
            byte[] bArr = zzpVar.data;
            String str2 = "ISO-8859-1";
            String str3 = zzpVar.zzab.get("Content-Type");
            if (str3 != null) {
                String[] split = str3.split(";", 0);
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    String[] split2 = split[i].trim().split("=", 0);
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        str2 = split2[1];
                        break;
                    }
                    i++;
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzpVar.data);
        }
        return zzy.zza(str, zzaq.zzb(zzpVar));
    }
}
