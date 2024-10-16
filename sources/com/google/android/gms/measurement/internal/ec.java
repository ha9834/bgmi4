package com.google.android.gms.measurement.internal;

/* loaded from: classes2.dex */
final class ec implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f4827a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ long d;
    private final /* synthetic */ zzfk e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ec(zzfk zzfkVar, String str, String str2, String str3, long j) {
        this.e = zzfkVar;
        this.f4827a = str;
        this.b = str2;
        this.c = str3;
        this.d = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzjg zzjgVar;
        zzjg zzjgVar2;
        String str = this.f4827a;
        if (str != null) {
            zzhr zzhrVar = new zzhr(this.c, str, this.d);
            zzjgVar = this.e.f4942a;
            zzjgVar.f().zzt().zza(this.b, zzhrVar);
        } else {
            zzjgVar2 = this.e.f4942a;
            zzjgVar2.f().zzt().zza(this.b, null);
        }
    }
}
