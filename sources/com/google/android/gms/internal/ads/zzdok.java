package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzdok extends IOException {
    private zzdpk zzhid;

    public zzdok(String str) {
        super(str);
        this.zzhid = null;
    }

    public final zzdok zzo(zzdpk zzdpkVar) {
        this.zzhid = zzdpkVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdok a() {
        return new zzdok("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdok b() {
        return new zzdok("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdok c() {
        return new zzdok("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdok d() {
        return new zzdok("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdok e() {
        return new zzdok("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdol f() {
        return new zzdol("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdok g() {
        return new zzdok("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdok h() {
        return new zzdok("Protocol message had invalid UTF-8.");
    }
}
