package com.ihoc.mgpa.notch;

import android.content.Context;
import android.os.Build;
import com.adjust.sdk.Constants;
import com.ihoc.mgpa.notch.impl.NotSupportNotch;
import com.ihoc.mgpa.notch.impl.a;
import com.ihoc.mgpa.notch.impl.b;
import com.ihoc.mgpa.notch.impl.d;
import com.ihoc.mgpa.notch.impl.e;
import com.ihoc.mgpa.notch.impl.f;
import com.ihoc.mgpa.notch.impl.g;

/* loaded from: classes2.dex */
public final class NotchFactory {
    public static INotchSupport createNotch(Context context) {
        INotchSupport gVar;
        if (Build.VERSION.SDK_INT < 28) {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            char c = 65535;
            int hashCode = lowerCase.hashCode();
            if (hashCode != -1206476313) {
                if (hashCode != -759499589) {
                    if (hashCode != 3418016) {
                        if (hashCode == 3620012 && lowerCase.equals("vivo")) {
                            c = 2;
                        }
                    } else if (lowerCase.equals("oppo")) {
                        c = 3;
                    }
                } else if (lowerCase.equals("xiaomi")) {
                    c = 0;
                }
            } else if (lowerCase.equals(Constants.REFERRER_API_HUAWEI)) {
                c = 1;
            }
            switch (c) {
                case 0:
                    gVar = new g();
                    break;
                case 1:
                    gVar = new a();
                    break;
                case 2:
                    gVar = new f();
                    break;
                case 3:
                    gVar = new d();
                    break;
                default:
                    gVar = new NotSupportNotch();
                    com.ihoc.mgpa.notch.a.a.a("NOTCHSDK_Factory", "not support!!!");
                    break;
            }
        } else {
            gVar = Build.MANUFACTURER.toLowerCase().equals(Constants.REFERRER_API_HUAWEI) ? new b() : new e();
        }
        com.ihoc.mgpa.notch.a.a.b("NOTCHSDK_Factory", "Type is " + gVar.getType());
        return gVar;
    }
}
