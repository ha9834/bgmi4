package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
abstract class ah extends v<String> {

    /* renamed from: a, reason: collision with root package name */
    final CharSequence f4025a;
    private final zzdj b;
    private final boolean c;
    private int d = 0;
    private int e;

    /* JADX INFO: Access modifiers changed from: protected */
    public ah(zzds zzdsVar, CharSequence charSequence) {
        zzdj zzdjVar;
        int i;
        zzdjVar = zzdsVar.f4154a;
        this.b = zzdjVar;
        this.c = false;
        i = zzdsVar.d;
        this.e = i;
        this.f4025a = charSequence;
    }

    abstract int a(int i);

    abstract int b(int i);

    @Override // com.google.android.gms.internal.firebase_remote_config.v
    protected final /* synthetic */ String a() {
        int a2;
        int i = this.d;
        while (true) {
            int i2 = this.d;
            if (i2 != -1) {
                a2 = a(i2);
                if (a2 == -1) {
                    a2 = this.f4025a.length();
                    this.d = -1;
                } else {
                    this.d = b(a2);
                }
                int i3 = this.d;
                if (i3 == i) {
                    this.d = i3 + 1;
                    if (this.d > this.f4025a.length()) {
                        this.d = -1;
                    }
                } else {
                    while (i < a2 && this.b.zzb(this.f4025a.charAt(i))) {
                        i++;
                    }
                    while (a2 > i && this.b.zzb(this.f4025a.charAt(a2 - 1))) {
                        a2--;
                    }
                    if (!this.c || i != a2) {
                        break;
                    }
                    i = this.d;
                }
            } else {
                b();
                return null;
            }
        }
        int i4 = this.e;
        if (i4 == 1) {
            a2 = this.f4025a.length();
            this.d = -1;
            while (a2 > i && this.b.zzb(this.f4025a.charAt(a2 - 1))) {
                a2--;
            }
        } else {
            this.e = i4 - 1;
        }
        return this.f4025a.subSequence(i, a2).toString();
    }
}
