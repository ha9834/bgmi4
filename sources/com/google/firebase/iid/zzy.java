package com.google.firebase.iid;

/* loaded from: classes2.dex */
final class zzy implements InstanceIdResult {
    private final String zzbw;
    private final String zzbx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(String str, String str2) {
        this.zzbw = str;
        this.zzbx = str2;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public final String getId() {
        return this.zzbw;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public final String getToken() {
        return this.zzbx;
    }
}
