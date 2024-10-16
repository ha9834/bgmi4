package com.tdatamaster.b;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f6152a = new a();

    /* renamed from: com.tdatamaster.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0179a {
        void onResult(int i, Object obj);
    }

    public static a a() {
        return f6152a;
    }

    public void a(Context context, InterfaceC0179a interfaceC0179a) {
        try {
            Class<?> cls = Class.forName("com.tdatamaster.b.b");
            Object invoke = cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            if (invoke != null) {
                cls.getMethod("getTuringTicket", Context.class, InterfaceC0179a.class).invoke(invoke, context, interfaceC0179a);
                return;
            }
        } catch (ClassNotFoundException e) {
            Log.w("TDMTurning", "TuringSDK not found : " + e.getMessage());
        } catch (IllegalAccessException e2) {
            Log.w("TDMTurning", "TuringSDK function not accessible : " + e2.getMessage());
        } catch (NoSuchMethodException e3) {
            Log.w("TDMTurning", "TuringSDK method not found : " + e3.getMessage());
        } catch (InvocationTargetException e4) {
            Log.w("TDMTurning", "TuringSDK invoke failed : " + e4.getTargetException().getMessage());
        } catch (Exception e5) {
            Log.e("TDMTurning", "TuringSDK error : " + e5.getMessage());
        }
        if (interfaceC0179a != null) {
            interfaceC0179a.onResult(2, null);
        }
    }
}
