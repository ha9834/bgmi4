package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes2.dex */
public final class zzdqs extends RuntimeException {
    private final List<String> zzhle;

    public zzdqs(zzdpk zzdpkVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zzhle = null;
    }

    public final zzdok zzazx() {
        return new zzdok(getMessage());
    }
}
