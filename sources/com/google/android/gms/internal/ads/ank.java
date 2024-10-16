package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes2.dex */
final class ank {

    /* renamed from: a, reason: collision with root package name */
    private final zznn[] f1986a;
    private final zznp b;
    private zznn c;

    public ank(zznn[] zznnVarArr, zznp zznpVar) {
        this.f1986a = zznnVarArr;
        this.b = zznpVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zznn a(zzno zznoVar, Uri uri) throws IOException, InterruptedException {
        zznn zznnVar = this.c;
        if (zznnVar != null) {
            return zznnVar;
        }
        zznn[] zznnVarArr = this.f1986a;
        int length = zznnVarArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            zznn zznnVar2 = zznnVarArr[i];
            try {
            } catch (EOFException unused) {
            } finally {
                zznoVar.zzig();
            }
            if (zznnVar2.zza(zznoVar)) {
                this.c = zznnVar2;
                break;
            }
            i++;
        }
        zznn zznnVar3 = this.c;
        if (zznnVar3 == null) {
            String zza = zzsy.zza(this.f1986a);
            StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 58);
            sb.append("None of the available extractors (");
            sb.append(zza);
            sb.append(") could read the stream.");
            throw new zzrc(sb.toString(), uri);
        }
        zznnVar3.zza(this.b);
        return this.c;
    }

    public final void a() {
        zznn zznnVar = this.c;
        if (zznnVar != null) {
            zznnVar.release();
            this.c = null;
        }
    }
}
