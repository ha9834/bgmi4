package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.util.Log;
import androidx.b.g;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzm;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
final class zzas {
    private static int zzcm;
    private static PendingIntent zzcy;
    private final Context zzag;
    private final zzam zzav;

    @GuardedBy("responseCallbacks")
    private final g<String, TaskCompletionSource<Bundle>> zzcz = new g<>();
    private Messenger zzda = new Messenger(new zzav(this, Looper.getMainLooper()));
    private Messenger zzdb;
    private zzm zzdc;

    public zzas(Context context, zzam zzamVar) {
        this.zzag = context;
        this.zzav = zzamVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(Message message) {
        if (message != null && (message.obj instanceof Intent)) {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(new zzm.zza());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof zzm) {
                    this.zzdc = (zzm) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    this.zzdb = (Messenger) parcelableExtra;
                }
            }
            Intent intent2 = (Intent) message.obj;
            String action = intent2.getAction();
            if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(action);
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Unexpected response action: ".concat(valueOf) : new String("Unexpected response action: "));
                    return;
                }
                return;
            }
            String stringExtra = intent2.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent2.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    String valueOf2 = String.valueOf(intent2.getExtras());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 49);
                    sb.append("Unexpected response, no error or registration id ");
                    sb.append(valueOf2);
                    Log.w("FirebaseInstanceId", sb.toString());
                    return;
                }
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf3 = String.valueOf(stringExtra2);
                    Log.d("FirebaseInstanceId", valueOf3.length() != 0 ? "Received InstanceID error ".concat(valueOf3) : new String("Received InstanceID error "));
                }
                if (stringExtra2.startsWith("|")) {
                    String[] split = stringExtra2.split("\\|");
                    if (split.length <= 2 || !"ID".equals(split[1])) {
                        String valueOf4 = String.valueOf(stringExtra2);
                        Log.w("FirebaseInstanceId", valueOf4.length() != 0 ? "Unexpected structured response ".concat(valueOf4) : new String("Unexpected structured response "));
                        return;
                    }
                    String str = split[2];
                    String str2 = split[3];
                    if (str2.startsWith(CertificateUtil.DELIMITER)) {
                        str2 = str2.substring(1);
                    }
                    zza(str, intent2.putExtra("error", str2).getExtras());
                    return;
                }
                synchronized (this.zzcz) {
                    for (int i = 0; i < this.zzcz.size(); i++) {
                        zza(this.zzcz.b(i), intent2.getExtras());
                    }
                }
                return;
            }
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
            if (!matcher.matches()) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf5 = String.valueOf(stringExtra);
                    Log.d("FirebaseInstanceId", valueOf5.length() != 0 ? "Unexpected response string: ".concat(valueOf5) : new String("Unexpected response string: "));
                    return;
                }
                return;
            }
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            Bundle extras = intent2.getExtras();
            extras.putString("registration_id", group2);
            zza(group, extras);
            return;
        }
        Log.w("FirebaseInstanceId", "Dropping invalid message");
    }

    private static synchronized void zza(Context context, Intent intent) {
        synchronized (zzas.class) {
            if (zzcy == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzcy = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra(Constants.JumpUrlConstants.SRC_TYPE_APP, zzcy);
        }
    }

    private final void zza(String str, Bundle bundle) {
        synchronized (this.zzcz) {
            TaskCompletionSource<Bundle> remove = this.zzcz.remove(str);
            if (remove == null) {
                String valueOf = String.valueOf(str);
                Log.w("FirebaseInstanceId", valueOf.length() != 0 ? "Missing callback for ".concat(valueOf) : new String("Missing callback for "));
            } else {
                remove.setResult(bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zzc(Bundle bundle) throws IOException {
        if (this.zzav.zzaf() >= 12000000) {
            try {
                return (Bundle) Tasks.await(zzab.zzc(this.zzag).zzb(1, bundle));
            } catch (InterruptedException | ExecutionException e) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
                    sb.append("Error making request: ");
                    sb.append(valueOf);
                    Log.d("FirebaseInstanceId", sb.toString());
                }
                if ((e.getCause() instanceof zzak) && ((zzak) e.getCause()).getErrorCode() == 4) {
                    return zzd(bundle);
                }
                return null;
            }
        }
        return zzd(bundle);
    }

    private final Bundle zzd(Bundle bundle) throws IOException {
        Bundle zze = zze(bundle);
        if (zze == null || !zze.containsKey("google.messenger")) {
            return zze;
        }
        Bundle zze2 = zze(bundle);
        if (zze2 == null || !zze2.containsKey("google.messenger")) {
            return zze2;
        }
        return null;
    }

    private static synchronized String zzah() {
        String num;
        synchronized (zzas.class) {
            int i = zzcm;
            zzcm = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a3, code lost:
    
        if (r8.zzdc != null) goto L19;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.gms.tasks.TaskCompletionSource, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.util.concurrent.TimeUnit] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00d3 -> B:21:0x00de). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00d9 -> B:21:0x00de). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.os.Bundle zze(android.os.Bundle r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzas.zze(android.os.Bundle):android.os.Bundle");
    }
}
