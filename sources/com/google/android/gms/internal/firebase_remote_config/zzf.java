package com.google.android.gms.internal.firebase_remote_config;

import com.tencent.imsdk.android.tools.net.volley.upload.HttpClientStack;
import java.io.IOException;

/* loaded from: classes2.dex */
public class zzf<T> extends zzby {
    private final zzd c;
    private final String d;
    private final String e;
    private final zzs f;
    private zzw h;
    private String j;
    private Class<T> k;
    private zzw g = new zzw();
    private int i = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzf(zzd zzdVar, String str, String str2, zzs zzsVar, Class<T> cls) {
        bj b;
        this.k = (Class) zzdt.checkNotNull(cls);
        this.c = (zzd) zzdt.checkNotNull(zzdVar);
        this.d = (String) zzdt.checkNotNull(str);
        this.e = (String) zzdt.checkNotNull(str2);
        this.f = zzsVar;
        this.g.zzu("Google-API-Java-Client");
        zzw zzwVar = this.g;
        b = bj.b();
        zzwVar.zzb("X-Goog-Api-Client", b.a(zzdVar.getClass().getSimpleName()));
    }

    public zzd zzf() {
        return this.c;
    }

    public final zzw zzg() {
        return this.g;
    }

    public final zzw zzh() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IOException a(zzac zzacVar) {
        return new zzaf(zzacVar);
    }

    public final T zzi() throws IOException {
        zzab zza = zzf().zzd().zza(this.d, new zzt(zzal.zza(this.c.zzc(), this.e, this, true)), this.f);
        new zza().zzb(zza);
        zza.zza(zzf().zze());
        if (this.f == null && (this.d.equals("POST") || this.d.equals("PUT") || this.d.equals(HttpClientStack.HttpPatch.METHOD_NAME))) {
            zza.zza(new zzo());
        }
        zza.zzx().putAll(this.g);
        zza.zza(new zzr());
        zza.zza(new cc(this, zza.zzz(), zza));
        zzac zzac = zza.zzac();
        this.h = zzac.zzx();
        this.i = zzac.getStatusCode();
        this.j = zzac.getStatusMessage();
        return (T) zzac.zza(this.k);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzby
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public zzf<T> zzb(String str, Object obj) {
        return (zzf) super.zzb(str, obj);
    }
}
