package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zza;
import com.tencent.midas.oversea.comm.IabBroadcastReceiver;

/* loaded from: classes.dex */
public class ProxyBillingActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private ResultReceiver f940a;
    private boolean b;

    private final Intent a() {
        Intent intent = new Intent(IabBroadcastReceiver.ACTION);
        intent.setPackage(getApplicationContext().getPackageName());
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            super.onActivityResult(r4, r5, r6)
            r0 = 0
            r1 = 100
            if (r4 != r1) goto L5c
            java.lang.String r4 = "ProxyBillingActivity"
            com.android.billingclient.api.h r4 = com.google.android.gms.internal.play_billing.zza.zzc(r6, r4)
            int r4 = r4.a()
            r1 = -1
            if (r5 != r1) goto L1b
            if (r4 == 0) goto L19
            r5 = -1
            goto L1b
        L19:
            r4 = 0
            goto L3b
        L1b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 85
            r1.<init>(r2)
            java.lang.String r2 = "Activity finished with resultCode "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = " and billing's responseCode: "
            r1.append(r5)
            r1.append(r4)
            java.lang.String r5 = "ProxyBillingActivity"
            java.lang.String r1 = r1.toString()
            com.google.android.gms.internal.play_billing.zza.zzb(r5, r1)
        L3b:
            android.os.ResultReceiver r5 = r3.f940a
            if (r5 == 0) goto L4b
            if (r6 != 0) goto L43
            r6 = 0
            goto L47
        L43:
            android.os.Bundle r6 = r6.getExtras()
        L47:
            r5.send(r4, r6)
            goto L79
        L4b:
            android.content.Intent r4 = r3.a()
            if (r6 == 0) goto L58
            android.os.Bundle r5 = r6.getExtras()
            r4.putExtras(r5)
        L58:
            r3.sendBroadcast(r4)
            goto L79
        L5c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r6 = 69
            r5.<init>(r6)
            java.lang.String r6 = "Got onActivityResult with wrong requestCode: "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = "; skipping..."
            r5.append(r4)
            java.lang.String r4 = "ProxyBillingActivity"
            java.lang.String r5 = r5.toString()
            com.google.android.gms.internal.play_billing.zza.zzb(r4, r5)
        L79:
            r3.b = r0
            r3.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.ProxyBillingActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        if (bundle == null) {
            zza.zza("ProxyBillingActivity", "Launching Play Store billing flow");
            if (getIntent().hasExtra("BUY_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            } else if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
                this.f940a = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
            } else {
                pendingIntent = null;
            }
            try {
                this.b = true;
                startIntentSenderForResult(pendingIntent.getIntentSender(), 100, new Intent(), 0, 0, 0);
                return;
            } catch (IntentSender.SendIntentException e) {
                String valueOf = String.valueOf(e);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 53);
                sb.append("Got exception while trying to start a purchase flow: ");
                sb.append(valueOf);
                zza.zzb("ProxyBillingActivity", sb.toString());
                ResultReceiver resultReceiver = this.f940a;
                if (resultReceiver != null) {
                    resultReceiver.send(6, null);
                } else {
                    Intent a2 = a();
                    a2.putExtra("RESPONSE_CODE", 6);
                    a2.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
                    sendBroadcast(a2);
                }
                this.b = false;
                finish();
                return;
            }
        }
        zza.zza("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
        this.b = bundle.getBoolean("send_cancelled_broadcast_if_finished", false);
        if (bundle.containsKey("result_receiver")) {
            this.f940a = (ResultReceiver) bundle.getParcelable("result_receiver");
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing() && this.b) {
            Intent a2 = a();
            a2.putExtra("RESPONSE_CODE", 1);
            a2.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
            sendBroadcast(a2);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        ResultReceiver resultReceiver = this.f940a;
        if (resultReceiver != null) {
            bundle.putParcelable("result_receiver", resultReceiver);
        }
        bundle.putBoolean("send_cancelled_broadcast_if_finished", this.b);
    }
}
