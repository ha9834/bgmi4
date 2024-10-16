package com.google.android.gms.internal.firebase_remote_config;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class x extends y {

    /* renamed from: a, reason: collision with root package name */
    private final char f4111a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(char c) {
        this.f4111a = c;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzdj
    public final boolean zzb(char c) {
        return c == this.f4111a;
    }

    public final String toString() {
        String b;
        b = zzdj.b(this.f4111a);
        StringBuilder sb = new StringBuilder(String.valueOf(b).length() + 18);
        sb.append("CharMatcher.is('");
        sb.append(b);
        sb.append("')");
        return sb.toString();
    }
}
