package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import androidx.b.a;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzba {
    private final zzax zzar;
    private int zzdw = 0;
    private final Map<Integer, TaskCompletionSource<Void>> zzdx = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzba(zzax zzaxVar) {
        this.zzar = zzaxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized Task<Void> zza(String str) {
        String zzak;
        TaskCompletionSource<Void> taskCompletionSource;
        synchronized (this.zzar) {
            zzak = this.zzar.zzak();
            zzax zzaxVar = this.zzar;
            StringBuilder sb = new StringBuilder(String.valueOf(zzak).length() + 1 + String.valueOf(str).length());
            sb.append(zzak);
            sb.append(",");
            sb.append(str);
            zzaxVar.zzh(sb.toString());
        }
        taskCompletionSource = new TaskCompletionSource<>();
        this.zzdx.put(Integer.valueOf(this.zzdw + (TextUtils.isEmpty(zzak) ? 0 : zzak.split(",").length - 1)), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized boolean zzaq() {
        return zzar() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x000c, code lost:
    
        if (com.google.firebase.iid.FirebaseInstanceId.zzm() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x000e, code lost:
    
        android.util.Log.d("FirebaseInstanceId", "topic sync succeeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0016, code lost:
    
        return true;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzc(com.google.firebase.iid.FirebaseInstanceId r5) {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            java.lang.String r0 = r4.zzar()     // Catch: java.lang.Throwable -> L42
            r1 = 1
            if (r0 != 0) goto L17
            boolean r5 = com.google.firebase.iid.FirebaseInstanceId.zzm()     // Catch: java.lang.Throwable -> L42
            if (r5 == 0) goto L15
            java.lang.String r5 = "FirebaseInstanceId"
            java.lang.String r0 = "topic sync succeeded"
            android.util.Log.d(r5, r0)     // Catch: java.lang.Throwable -> L42
        L15:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            return r1
        L17:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            boolean r2 = zza(r5, r0)
            if (r2 != 0) goto L20
            r5 = 0
            return r5
        L20:
            monitor-enter(r4)
            java.util.Map<java.lang.Integer, com.google.android.gms.tasks.TaskCompletionSource<java.lang.Void>> r2 = r4.zzdx     // Catch: java.lang.Throwable -> L3f
            int r3 = r4.zzdw     // Catch: java.lang.Throwable -> L3f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r2 = r2.remove(r3)     // Catch: java.lang.Throwable -> L3f
            com.google.android.gms.tasks.TaskCompletionSource r2 = (com.google.android.gms.tasks.TaskCompletionSource) r2     // Catch: java.lang.Throwable -> L3f
            r4.zzn(r0)     // Catch: java.lang.Throwable -> L3f
            int r0 = r4.zzdw     // Catch: java.lang.Throwable -> L3f
            int r0 = r0 + r1
            r4.zzdw = r0     // Catch: java.lang.Throwable -> L3f
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
            if (r2 == 0) goto L0
            r0 = 0
            r2.setResult(r0)
            goto L0
        L3f:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
            throw r5
        L42:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzba.zzc(com.google.firebase.iid.FirebaseInstanceId):boolean");
    }

    private final String zzar() {
        String zzak;
        synchronized (this.zzar) {
            zzak = this.zzar.zzak();
        }
        if (TextUtils.isEmpty(zzak)) {
            return null;
        }
        String[] split = zzak.split(",");
        if (split.length <= 1 || TextUtils.isEmpty(split[1])) {
            return null;
        }
        return split[1];
    }

    private final synchronized boolean zzn(String str) {
        synchronized (this.zzar) {
            String zzak = this.zzar.zzak();
            String valueOf = String.valueOf(",");
            String valueOf2 = String.valueOf(str);
            if (!zzak.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                return false;
            }
            String valueOf3 = String.valueOf(",");
            String valueOf4 = String.valueOf(str);
            this.zzar.zzh(zzak.substring((valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3)).length()));
            return true;
        }
    }

    private static boolean zza(FirebaseInstanceId firebaseInstanceId, String str) {
        String[] split = str.split("!");
        if (split.length == 2) {
            String str2 = split[0];
            String str3 = split[1];
            char c = 65535;
            try {
                int hashCode = str2.hashCode();
                if (hashCode != 83) {
                    if (hashCode == 85 && str2.equals("U")) {
                        c = 1;
                    }
                } else if (str2.equals("S")) {
                    c = 0;
                }
                switch (c) {
                    case 0:
                        firebaseInstanceId.zzb(str3);
                        if (FirebaseInstanceId.zzm()) {
                            Log.d("FirebaseInstanceId", "subscribe operation succeeded");
                            break;
                        }
                        break;
                    case 1:
                        firebaseInstanceId.zzc(str3);
                        if (FirebaseInstanceId.zzm()) {
                            Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
                            break;
                        }
                        break;
                }
            } catch (IOException e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.e("FirebaseInstanceId", valueOf.length() != 0 ? "Topic sync failed: ".concat(valueOf) : new String("Topic sync failed: "));
                return false;
            }
        }
        return true;
    }
}
