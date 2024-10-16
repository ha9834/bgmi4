package com.ihoc.mgpa.k;

import com.ihoc.mgpa.MgpaCallback;
import com.ihoc.mgpa.i.f;
import com.ihoc.mgpa.n.m;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class b implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    private MgpaCallback f5655a;
    private a b;

    public b(MgpaCallback mgpaCallback) {
        this.f5655a = mgpaCallback;
    }

    public b(a aVar) {
        this.b = aVar;
    }

    private int a(Object obj, Method method, Object[] objArr) {
        if (!f.ka()) {
            return -1;
        }
        String str = (String) objArr[0];
        m.a("Transceiver local api callback info: %s", String.valueOf(str));
        if (str == null) {
            m.a("Transceiver local api callback info is null!", new Object[0]);
            return -3;
        }
        a aVar = this.b;
        if (aVar == null) {
            m.a("Transceiver local api callback is null!", new Object[0]);
            return -2;
        }
        aVar.a(str);
        return 0;
    }

    private int b(Object obj, Method method, Object[] objArr) {
        if (!f.ka()) {
            return -1;
        }
        String str = (String) objArr[0];
        m.a("Transceiver callback info: %s", String.valueOf(str));
        if (str == null) {
            m.a("Transceiver callback info is null!", new Object[0]);
            return -3;
        }
        MgpaCallback mgpaCallback = this.f5655a;
        if (mgpaCallback == null) {
            m.a("Transceiver callback is null!", new Object[0]);
            return -2;
        }
        mgpaCallback.notifySystemInfo(str);
        return 0;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        int a2;
        if (this.f5655a != null) {
            a2 = b(obj, method, objArr);
        } else {
            if (this.b == null) {
                return null;
            }
            a2 = a(obj, method, objArr);
        }
        return Integer.valueOf(a2);
    }
}
