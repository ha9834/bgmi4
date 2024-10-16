package com.ihoc.mgpa.l;

import android.os.Build;
import com.tdatamaster.tdm.device.DeviceInfoName;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile String f5658a;

    public static synchronized String a() {
        synchronized (a.class) {
            if (f5658a != null) {
                return f5658a;
            }
            f5658a = com.ihoc.mgpa.l.a.a.a().a(DeviceInfoName.MODEL_STRING);
            if (f5658a != null) {
                return f5658a;
            }
            f5658a = Build.MODEL;
            return f5658a;
        }
    }
}
