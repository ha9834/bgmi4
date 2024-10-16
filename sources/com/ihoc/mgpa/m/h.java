package com.ihoc.mgpa.m;

import com.ihoc.mgpa.IMGPAService;
import com.tencent.turingsmi.sdk.ITuringTouchListener;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class h implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    private IMGPAService.TouchEventWrapper f5663a;

    public h(IMGPAService.TouchEventWrapper touchEventWrapper) {
        this.f5663a = touchEventWrapper;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (!method.getName().equals("onTuringTouchListener")) {
            return method.invoke(this.f5663a, objArr);
        }
        return Boolean.valueOf(this.f5663a.onTuringTouchListener(new g(this, (ITuringTouchListener) objArr[0], obj)));
    }
}
