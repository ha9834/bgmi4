package com.google.android.gms.internal.ads;

import com.amazonaws.services.s3.util.Mimetypes;

/* loaded from: classes2.dex */
final class bf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f2070a;
    private final /* synthetic */ zzajy b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(zzajy zzajyVar, String str) {
        this.b = zzajyVar;
        this.f2070a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbgz zzbgzVar;
        zzbgzVar = this.b.f2743a;
        zzbgzVar.loadData(this.f2070a, Mimetypes.MIMETYPE_HTML, "UTF-8");
    }
}
