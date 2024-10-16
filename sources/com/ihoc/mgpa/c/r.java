package com.ihoc.mgpa.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.tdatamaster.tdm.device.DeviceInfoName;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class r {
    public static String a() {
        String a2 = com.ihoc.mgpa.n.o.a(DeviceInfoName.OAID_STRING, null);
        return (a2 == null || a2.length() <= 4) ? com.ihoc.mgpa.h.p.b() : a2;
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.ServiceManager");
            Method method = cls.getMethod("getService", String.class);
            Object newInstance = cls.newInstance();
            Object[] objArr = new Object[1];
            objArr[0] = "tcexternal";
            IBinder iBinder = (IBinder) method.invoke(newInstance, objArr);
            if (iBinder == null) {
                return "";
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            String str2 = "";
            try {
                try {
                    obtain.writeInterfaceToken("com.os.tencent.TcExternalService");
                    obtain.writeString(str);
                    iBinder.transact(1, obtain, obtain2, 0);
                    int readInt = obtain2.readInt();
                    str2 = readInt == 0 ? obtain2.readString() : String.valueOf(readInt);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                obtain2.recycle();
                obtain.recycle();
                return com.ihoc.mgpa.n.p.b(str2) ? "" : str2;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x0083. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(java.util.Map<java.lang.String, java.lang.String> r4) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.c.r.a(java.util.Map):void");
    }

    public static String b() {
        return com.ihoc.mgpa.d.a.a();
    }

    public static String c() {
        String a2 = com.ihoc.mgpa.n.o.a("XID", null);
        return (a2 == null || a2.length() != 64) ? com.ihoc.mgpa.d.a.b() : a2;
    }

    private static String d() {
        try {
            Class<?> cls = Class.forName("android.os.ServiceManager");
            Method method = cls.getMethod("getService", String.class);
            Object newInstance = cls.newInstance();
            Object[] objArr = new Object[1];
            objArr[0] = "oiface";
            IBinder iBinder = (IBinder) method.invoke(newInstance, objArr);
            if (iBinder == null) {
                return "";
            }
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            String str = "";
            try {
                try {
                    obtain.writeInterfaceToken("com.oppo.oiface.IOIfaceService");
                    iBinder.transact(501, obtain, obtain2, 0);
                    int readInt = obtain2.readInt();
                    str = readInt == 0 ? obtain2.readString() : String.valueOf(readInt);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                obtain2.recycle();
                obtain.recycle();
                return com.ihoc.mgpa.n.p.b(str) ? "" : str;
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
