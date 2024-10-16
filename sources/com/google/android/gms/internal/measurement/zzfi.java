package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzfi extends IOException {
    private zzgi zzaiw;

    public zzfi(String str) {
        super(str);
        this.zzaiw = null;
    }

    public final zzfi zzg(zzgi zzgiVar) {
        this.zzaiw = zzgiVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfi a() {
        return new zzfi("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfi b() {
        return new zzfi("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfi c() {
        return new zzfi("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfi d() {
        return new zzfi("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfi e() {
        return new zzfi("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfh f() {
        return new zzfh("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfi g() {
        return new zzfi("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfi h() {
        return new zzfi("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfi i() {
        return new zzfi("Protocol message had invalid UTF-8.");
    }
}
