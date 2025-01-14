package com.google.firebase.iid;

import android.os.Bundle;

/* loaded from: classes2.dex */
final class zzai extends zzal<Void> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzai(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.zzal
    public final boolean zzab() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.iid.zzal
    public final void zzb(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            finish(null);
        } else {
            zza(new zzak(4, "Invalid response to one way request"));
        }
    }
}
