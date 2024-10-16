package com.subao.common.j;

import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellInfoLte;
import android.telephony.TelephonyManager;
import java.util.List;

/* loaded from: classes2.dex */
public class g {

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, int i);
    }

    public static void a(Context context, a aVar) {
        if (Build.VERSION.SDK_INT >= 17) {
            com.subao.common.m.d.a().execute(new b(context, aVar));
        } else {
            aVar.a(null, 0);
        }
    }

    /* loaded from: classes2.dex */
    static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Context f6079a;
        private final a b;

        b(Context context, a aVar) {
            this.f6079a = context;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            String str = null;
            try {
                int[] a2 = a();
                if (a2 != null) {
                    str = Integer.toString(a2[0]);
                    i = a2[1];
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            this.b.a(str, i);
        }

        private int[] a() {
            List<CellInfo> allCellInfo;
            TelephonyManager telephonyManager = (TelephonyManager) this.f6079a.getSystemService("phone");
            if (telephonyManager == null || (allCellInfo = telephonyManager.getAllCellInfo()) == null || allCellInfo.isEmpty()) {
                return null;
            }
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo != null && cellInfo.isRegistered() && (cellInfo instanceof CellInfoLte)) {
                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                    return new int[]{cellInfoLte.getCellIdentity().getCi(), cellInfoLte.getCellSignalStrength().getAsuLevel()};
                }
            }
            return null;
        }
    }
}
