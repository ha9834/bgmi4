package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

/* loaded from: classes2.dex */
final class ei implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Bitmap f2147a;
    private final /* synthetic */ zzauq b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ei(zzauq zzauqVar, Bitmap bitmap) {
        this.b = zzauqVar;
        this.f2147a = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        zzdsj zzdsjVar;
        zzdsj zzdsjVar2;
        zzdsj zzdsjVar3;
        zzdsj zzdsjVar4;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f2147a.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        obj = this.b.l;
        synchronized (obj) {
            zzdsjVar = this.b.c;
            zzdsjVar.zzhsc = new zzdso();
            zzdsjVar2 = this.b.c;
            zzdsjVar2.zzhsc.zzhsu = byteArrayOutputStream.toByteArray();
            zzdsjVar3 = this.b.c;
            zzdsjVar3.zzhsc.mimeType = "image/png";
            zzdsjVar4 = this.b.c;
            zzdsjVar4.zzhsc.zzhrv = 1;
        }
    }
}
