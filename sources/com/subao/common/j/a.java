package com.subao.common.j;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private C0171a f6060a;
    private int b;

    public void a(final Context context) {
        if (com.subao.common.n.i.b()) {
            b(context);
        } else {
            com.subao.common.m.b.a().a(new Runnable() { // from class: com.subao.common.j.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        TelephonyManager telephonyManager;
        if (this.f6060a == null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            this.f6060a = new C0171a(this);
            telephonyManager.listen(this.f6060a, 256);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.subao.common.j.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0171a extends PhoneStateListener {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<a> f6062a;

        C0171a(a aVar) {
            this.f6062a = new WeakReference<>(aVar);
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            a aVar = this.f6062a.get();
            if (aVar != null) {
                synchronized (aVar) {
                    aVar.b = signalStrength.getGsmSignalStrength();
                }
            }
        }
    }
}
