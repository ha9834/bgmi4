package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzhm extends IOException {
    private zzim zzud;

    public zzhm(String str) {
        super(str);
        this.zzud = null;
    }

    public final zzhm zzg(zzim zzimVar) {
        this.zzud = zzimVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhm a() {
        return new zzhm("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhm b() {
        return new zzhm("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhm c() {
        return new zzhm("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhm d() {
        return new zzhm("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhm e() {
        return new zzhm("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhp f() {
        return new zzhp("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhm g() {
        return new zzhm("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhm h() {
        return new zzhm("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhm i() {
        return new zzhm("Protocol message had invalid UTF-8.");
    }
}
