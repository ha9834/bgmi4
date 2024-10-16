package com.subao.common.j;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.subao.common.j.q;

/* loaded from: classes2.dex */
public class r extends q {

    /* renamed from: a, reason: collision with root package name */
    private TelephonyManager f6090a;
    private PhoneStateListener b;

    public r(q.a aVar) {
        super(aVar);
    }

    @Override // com.subao.common.j.q
    public void a(Context context) {
        synchronized (this) {
            if (this.f6090a == null) {
                this.f6090a = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
                if (this.f6090a != null) {
                    this.b = new a(this, this.f6090a);
                    this.f6090a.listen(this.b, 256);
                }
            }
        }
    }

    @Override // com.subao.common.j.q
    public void a() {
        synchronized (this) {
            if (this.f6090a != null) {
                this.f6090a.listen(this.b, 0);
                this.b = null;
                this.f6090a = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    static class a extends PhoneStateListener {

        /* renamed from: a, reason: collision with root package name */
        private final TelephonyManager f6091a;
        private final q b;

        static int a(int i) {
            if (i >= -70) {
                return 4;
            }
            if (i >= -85) {
                return 3;
            }
            if (i >= -95) {
                return 2;
            }
            return i >= -100 ? 1 : 0;
        }

        static int b(int i) {
            if (i >= -90) {
                return 4;
            }
            if (i >= -110) {
                return 3;
            }
            if (i >= -130) {
                return 2;
            }
            return i >= -150 ? 1 : 0;
        }

        static int c(int i) {
            if (i >= 7) {
                return 4;
            }
            if (i >= 5) {
                return 3;
            }
            if (i >= 3) {
                return 2;
            }
            return i >= 1 ? 1 : 0;
        }

        a(q qVar, TelephonyManager telephonyManager) {
            this.f6091a = telephonyManager;
            this.b = qVar;
        }

        static int a(SignalStrength signalStrength, String str) {
            try {
                Object invoke = signalStrength.getClass().getMethod(str, new Class[0]).invoke(signalStrength, new Object[0]);
                if (invoke instanceof Integer) {
                    return ((Integer) invoke).intValue();
                }
                return -1;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }

        static int a(TelephonyManager telephonyManager, SignalStrength signalStrength) {
            int a2;
            int gsmSignalStrength;
            int a3 = a(signalStrength, "getLevel");
            if (a3 >= 0) {
                return Math.min(a3, 4);
            }
            if (signalStrength.isGsm() && (gsmSignalStrength = signalStrength.getGsmSignalStrength()) != 99) {
                return a((gsmSignalStrength * 2) - 113);
            }
            if (telephonyManager.getNetworkType() == 13 && (a2 = a(signalStrength, "getLteLevel")) >= 0) {
                return Math.min(a2, 4);
            }
            int evdoSnr = signalStrength.getEvdoSnr();
            if (evdoSnr < 0) {
                int a4 = a(signalStrength.getCdmaDbm());
                int b = b(signalStrength.getCdmaEcio());
                return a4 < b ? a4 : b;
            }
            return c(evdoSnr);
        }

        static int d(int i) {
            if (i <= 0) {
                return 0;
            }
            if (i >= 4) {
                return 100;
            }
            return (i * 100) / 4;
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            this.b.a(d(a(this.f6091a, signalStrength)));
        }
    }
}
