package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@zzard
/* loaded from: classes2.dex */
public final class zzbfa implements zzkw, zzqi, zzsj<zzrv>, zztn {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private static int f2865a;

    @VisibleForTesting
    private static int b;
    private final Context c;
    private final zzlo e;
    private final zzbde h;
    private zzkv i;
    private ByteBuffer j;
    private boolean k;
    private zzbfi l;
    private int m;
    private Set<WeakReference<jv>> n = new HashSet();
    private final zzbez d = new zzbez();
    private final zzlo f = new zzms(zzpg.zzbhn);
    private final zzrj g = new zzrg();

    public zzbfa(Context context, zzbde zzbdeVar) {
        this.c = context;
        this.h = zzbdeVar;
        this.e = new zzth(this.c, zzpg.zzbhn, 0L, zzaxi.zzdvv, this, -1);
        if (zzawz.zzvj()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            zzawz.zzds(sb.toString());
        }
        f2865a++;
        this.i = zzkz.zza(new zzlo[]{this.f, this.e}, this.g, this.d);
        this.i.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final void zza(zzln zzlnVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final void zza(zzlr zzlrVar, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final void zza(zzrb zzrbVar, zzro zzroVar) {
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final void zzb(int i, long j) {
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final void zzb(Surface surface) {
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final void zze(zznc zzncVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final /* bridge */ /* synthetic */ void zze(zzrv zzrvVar) {
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final void zze(String str, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final void zzf(zznc zzncVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final void zzgt() {
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final void zzh(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final void zzk(zzlh zzlhVar) {
    }

    public final zzkv zzzt() {
        return this.i;
    }

    public static int zzyp() {
        return f2865a;
    }

    public static int zzyq() {
        return b;
    }

    public final void zza(zzbfi zzbfiVar) {
        this.l = zzbfiVar;
    }

    public final zzbez zzzu() {
        return this.d;
    }

    public final void zza(Uri[] uriArr, String str) {
        zza(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zza(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzql zzqoVar;
        this.j = byteBuffer;
        this.k = z;
        if (uriArr.length == 1) {
            zzqoVar = a(uriArr[0], str);
        } else {
            zzql[] zzqlVarArr = new zzql[uriArr.length];
            for (int i = 0; i < uriArr.length; i++) {
                zzqlVarArr[i] = a(uriArr[i], str);
            }
            zzqoVar = new zzqo(zzqlVarArr);
        }
        this.i.zza(zzqoVar);
        b++;
    }

    public final void release() {
        zzkv zzkvVar = this.i;
        if (zzkvVar != null) {
            zzkvVar.zzb(this);
            this.i.release();
            this.i = null;
            b--;
        }
    }

    public final long getBytesTransferred() {
        return this.m;
    }

    @Override // com.google.android.gms.internal.ads.zzqi
    public final void zzb(IOException iOException) {
        zzbfi zzbfiVar = this.l;
        if (zzbfiVar != null) {
            zzbfiVar.zza("onLoadError", iOException);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztn
    public final void zza(int i, int i2, int i3, float f) {
        zzbfi zzbfiVar = this.l;
        if (zzbfiVar != null) {
            zzbfiVar.zzo(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final void zza(boolean z, int i) {
        zzbfi zzbfiVar = this.l;
        if (zzbfiVar != null) {
            zzbfiVar.zzde(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkw
    public final void zza(zzku zzkuVar) {
        zzbfi zzbfiVar = this.l;
        if (zzbfiVar != null) {
            zzbfiVar.zza("onPlayerError", zzkuVar);
        }
    }

    public final void zzdc(int i) {
        Iterator<WeakReference<jv>> it = this.n.iterator();
        while (it.hasNext()) {
            jv jvVar = it.next().get();
            if (jvVar != null) {
                jvVar.a(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Surface surface, boolean z) {
        zzky zzkyVar = new zzky(this.e, 1, surface);
        if (z) {
            this.i.zzb(zzkyVar);
        } else {
            this.i.zza(zzkyVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(float f, boolean z) {
        zzky zzkyVar = new zzky(this.f, 2, Float.valueOf(f));
        if (z) {
            this.i.zzb(zzkyVar);
        } else {
            this.i.zza(zzkyVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        for (int i = 0; i < this.i.zzgs(); i++) {
            this.g.zzg(i, !z);
        }
    }

    @VisibleForTesting
    private final zzql a(Uri uri, final String str) {
        final zzrw zzrwVar;
        zzrw zzrwVar2;
        if (this.k && this.j.limit() > 0) {
            final byte[] bArr = new byte[this.j.limit()];
            this.j.get(bArr);
            zzrwVar2 = new zzrw(bArr) { // from class: com.google.android.gms.internal.ads.jx

                /* renamed from: a, reason: collision with root package name */
                private final byte[] f2279a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2279a = bArr;
                }

                @Override // com.google.android.gms.internal.ads.zzrw
                public final zzrv zzju() {
                    return new zzru(this.f2279a);
                }
            };
        } else {
            if (this.h.zzeek > 0) {
                zzrwVar = new zzrw(this, str) { // from class: com.google.android.gms.internal.ads.jy

                    /* renamed from: a, reason: collision with root package name */
                    private final zzbfa f2280a;
                    private final String b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2280a = this;
                        this.b = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzrw
                    public final zzrv zzju() {
                        return this.f2280a.b(this.b);
                    }
                };
            } else {
                zzrwVar = new zzrw(this, str) { // from class: com.google.android.gms.internal.ads.jz

                    /* renamed from: a, reason: collision with root package name */
                    private final zzbfa f2281a;
                    private final String b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2281a = this;
                        this.b = str;
                    }

                    @Override // com.google.android.gms.internal.ads.zzrw
                    public final zzrv zzju() {
                        return this.f2281a.a(this.b);
                    }
                };
            }
            final zzrw zzrwVar3 = this.h.zzeel ? new zzrw(this, zzrwVar) { // from class: com.google.android.gms.internal.ads.ka

                /* renamed from: a, reason: collision with root package name */
                private final zzbfa f2282a;
                private final zzrw b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f2282a = this;
                    this.b = zzrwVar;
                }

                @Override // com.google.android.gms.internal.ads.zzrw
                public final zzrv zzju() {
                    return this.f2282a.a(this.b);
                }
            } : zzrwVar;
            if (this.j.limit() > 0) {
                final byte[] bArr2 = new byte[this.j.limit()];
                this.j.get(bArr2);
                zzrwVar3 = new zzrw(zzrwVar3, bArr2) { // from class: com.google.android.gms.internal.ads.kb

                    /* renamed from: a, reason: collision with root package name */
                    private final zzrw f2283a;
                    private final byte[] b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2283a = zzrwVar3;
                        this.b = bArr2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzrw
                    public final zzrv zzju() {
                        zzrw zzrwVar4 = this.f2283a;
                        byte[] bArr3 = this.b;
                        return new ke(new zzru(bArr3), bArr3.length, zzrwVar4.zzju());
                    }
                };
            }
            zzrwVar2 = zzrwVar3;
        }
        return new zzqh(uri, zzrwVar2, kc.f2284a, -1, zzaxi.zzdvv, this, null, this.h.zzeei);
    }

    public final void finalize() throws Throwable {
        f2865a--;
        if (zzawz.zzvj()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            zzawz.zzds(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final /* synthetic */ void zzc(zzrv zzrvVar, int i) {
        this.m += i;
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final /* synthetic */ void zza(zzrv zzrvVar, zzry zzryVar) {
        this.m = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzrv a(zzrw zzrwVar) {
        return new zzbex(this.c, zzrwVar.zzju(), this, new zzbey(this) { // from class: com.google.android.gms.internal.ads.kd

            /* renamed from: a, reason: collision with root package name */
            private final zzbfa f2285a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2285a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbey
            public final void zzd(boolean z, long j) {
                this.f2285a.a(z, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(boolean z, long j) {
        zzbfi zzbfiVar = this.l;
        if (zzbfiVar != null) {
            zzbfiVar.zzd(z, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzrv a(String str) {
        return new zzsa(str, null, this.h.zzeel ? null : this, this.h.zzeef, this.h.zzeeh, true, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzrv b(String str) {
        jv jvVar = new jv(str, this.h.zzeel ? null : this, this.h.zzeef, this.h.zzeeh, this.h.zzeek);
        this.n.add(new WeakReference<>(jvVar));
        return jvVar;
    }
}
