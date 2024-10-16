package com.google.android.gms.internal.firebase_remote_config;

import java.util.List;

/* loaded from: classes2.dex */
public final class zzju extends RuntimeException {
    private final List<String> zzxf;

    public zzju(zzim zzimVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zzxf = null;
    }
}
