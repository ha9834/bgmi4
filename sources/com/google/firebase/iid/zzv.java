package com.google.firebase.iid;

import android.os.Bundle;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzv implements Continuation<Bundle, String> {
    private final /* synthetic */ zzr zzbu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(zzr zzrVar) {
        this.zzbu = zzrVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ String then(Task<Bundle> task) throws Exception {
        String zza;
        Bundle result = task.getResult(IOException.class);
        zzr zzrVar = this.zzbu;
        zza = zzr.zza(result);
        return zza;
    }
}
