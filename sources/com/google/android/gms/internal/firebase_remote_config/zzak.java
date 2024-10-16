package com.google.android.gms.internal.firebase_remote_config;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public enum zzak {
    PLUS('+', "", ",", false, true),
    HASH('#', "#", ",", false, true),
    DOT('.', ".", ".", false, false),
    FORWARD_SLASH('/', "/", "/", false, false),
    SEMI_COLON(';', ";", ";", true, false),
    QUERY('?', "?", "&", true, false),
    AMP('&', "&", "&", true, false),
    SIMPLE(null, "", ",", false, false);

    private final Character zzcl;
    private final String zzcm;
    private final String zzcn;
    private final boolean zzco;
    private final boolean zzcp;

    zzak(Character ch, String str, String str2, boolean z, boolean z2) {
        this.zzcl = ch;
        this.zzcm = (String) zzdt.checkNotNull(str);
        this.zzcn = (String) zzdt.checkNotNull(str2);
        this.zzco = z;
        this.zzcp = z2;
        if (ch != null) {
            zzal.f4122a.put(ch, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        return this.zzcm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() {
        return this.zzcn;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c() {
        return this.zzco;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int d() {
        return this.zzcl == null ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a(String str) {
        if (this.zzcp) {
            return zzcs.zzaj(str);
        }
        return zzcs.zzah(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean e() {
        return this.zzcp;
    }
}
