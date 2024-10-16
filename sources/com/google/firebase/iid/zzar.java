package com.google.firebase.iid;

import android.util.Log;
import android.util.Pair;
import androidx.b.a;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzar {
    private final Executor executor;

    @GuardedBy("this")
    private final Map<Pair<String, String>, Task<InstanceIdResult>> zzcx = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzar(Executor executor) {
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized Task<InstanceIdResult> zza(String str, String str2, zzat zzatVar) {
        final Pair pair = new Pair(str, str2);
        Task<InstanceIdResult> task = this.zzcx.get(pair);
        if (task != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 29);
                sb.append("Joining ongoing request for: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            return task;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(pair);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 24);
            sb2.append("Making new request for: ");
            sb2.append(valueOf2);
            Log.d("FirebaseInstanceId", sb2.toString());
        }
        Task continueWithTask = zzatVar.zzs().continueWithTask(this.executor, new Continuation(this, pair) { // from class: com.google.firebase.iid.zzaq
            private final zzar zzcv;
            private final Pair zzcw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzcv = this;
                this.zzcw = pair;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                return this.zzcv.zza(this.zzcw, task2);
            }
        });
        this.zzcx.put(pair, continueWithTask);
        return continueWithTask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(Pair pair, Task task) throws Exception {
        synchronized (this) {
            this.zzcx.remove(pair);
        }
        return task;
    }
}
