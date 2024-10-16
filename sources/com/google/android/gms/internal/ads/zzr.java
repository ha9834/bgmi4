package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzag;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class zzr<T> implements Comparable<zzr<T>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzag.a f3715a;
    private final int b;
    private final String c;
    private final int d;
    private final Object e;
    private zzz f;
    private Integer g;
    private zzv h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private zzac m;
    private zzc n;
    private anv o;

    public zzr(int i, String str, zzz zzzVar) {
        Uri parse;
        String host;
        this.f3715a = zzag.a.f2720a ? new zzag.a() : null;
        this.e = new Object();
        this.i = true;
        int i2 = 0;
        this.j = false;
        this.k = false;
        this.l = false;
        this.n = null;
        this.b = i;
        this.c = str;
        this.f = zzzVar;
        this.m = new zzh();
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && (host = parse.getHost()) != null) {
            i2 = host.hashCode();
        }
        this.d = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract zzy<T> a(zzp zzpVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(T t);

    public byte[] zzg() throws zza {
        return null;
    }

    public final int getMethod() {
        return this.b;
    }

    public final int zzd() {
        return this.d;
    }

    public final void zzb(String str) {
        if (zzag.a.f2720a) {
            this.f3715a.a(str, Thread.currentThread().getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(String str) {
        zzv zzvVar = this.h;
        if (zzvVar != null) {
            zzvVar.a(this);
        }
        if (zzag.a.f2720a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new ans(this, str, id));
            } else {
                this.f3715a.a(str, id);
                this.f3715a.a(toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i) {
        zzv zzvVar = this.h;
        if (zzvVar != null) {
            zzvVar.a(this, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzr<?> zza(zzv zzvVar) {
        this.h = zzvVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzr<?> zzb(int i) {
        this.g = Integer.valueOf(i);
        return this;
    }

    public final String getUrl() {
        return this.c;
    }

    public final String zze() {
        String str = this.c;
        int i = this.b;
        if (i == 0 || i == -1) {
            return str;
        }
        String num = Integer.toString(i);
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 1 + String.valueOf(str).length());
        sb.append(num);
        sb.append('-');
        sb.append(str);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzr<?> zza(zzc zzcVar) {
        this.n = zzcVar;
        return this;
    }

    public final zzc zzf() {
        return this.n;
    }

    public final boolean isCanceled() {
        synchronized (this.e) {
        }
        return false;
    }

    public Map<String, String> getHeaders() throws zza {
        return Collections.emptyMap();
    }

    public final boolean zzh() {
        return this.i;
    }

    public final int zzi() {
        return this.m.zzb();
    }

    public final zzac zzj() {
        return this.m;
    }

    public final void zzk() {
        synchronized (this.e) {
            this.k = true;
        }
    }

    public final boolean zzl() {
        boolean z;
        synchronized (this.e) {
            z = this.k;
        }
        return z;
    }

    public final void zzb(zzaf zzafVar) {
        zzz zzzVar;
        synchronized (this.e) {
            zzzVar = this.f;
        }
        if (zzzVar != null) {
            zzzVar.zzd(zzafVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(anv anvVar) {
        synchronized (this.e) {
            this.o = anvVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzy<?> zzyVar) {
        anv anvVar;
        synchronized (this.e) {
            anvVar = this.o;
        }
        if (anvVar != null) {
            anvVar.a(this, zzyVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        anv anvVar;
        synchronized (this.e) {
            anvVar = this.o;
        }
        if (anvVar != null) {
            anvVar.a(this);
        }
    }

    public String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.d));
        String concat = valueOf.length() != 0 ? "0x".concat(valueOf) : new String("0x");
        isCanceled();
        String str = this.c;
        String valueOf2 = String.valueOf(zzu.NORMAL);
        String valueOf3 = String.valueOf(this.g);
        StringBuilder sb = new StringBuilder(String.valueOf("[ ] ").length() + 3 + String.valueOf(str).length() + String.valueOf(concat).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append("[ ] ");
        sb.append(str);
        sb.append(" ");
        sb.append(concat);
        sb.append(" ");
        sb.append(valueOf2);
        sb.append(" ");
        sb.append(valueOf3);
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        zzr zzrVar = (zzr) obj;
        zzu zzuVar = zzu.NORMAL;
        zzu zzuVar2 = zzu.NORMAL;
        return zzuVar == zzuVar2 ? this.g.intValue() - zzrVar.g.intValue() : zzuVar2.ordinal() - zzuVar.ordinal();
    }
}
