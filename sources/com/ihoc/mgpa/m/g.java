package com.ihoc.mgpa.m;

import android.view.MotionEvent;
import android.view.View;
import com.ihoc.mgpa.IMGPAService;
import com.tencent.turingsmi.sdk.ITuringTouchListener;
import com.tencent.turingsmi.sdk.ITuringTouchWrapper;

/* loaded from: classes2.dex */
class g implements IMGPAService.TouchEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ITuringTouchListener f5662a;
    final /* synthetic */ Object b;
    final /* synthetic */ h c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(h hVar, ITuringTouchListener iTuringTouchListener, Object obj) {
        this.c = hVar;
        this.f5662a = iTuringTouchListener;
        this.b = obj;
    }

    @Override // com.ihoc.mgpa.IMGPAService.TouchEventListener
    public boolean onTouch(IMGPAService.TouchEventWrapper touchEventWrapper, View view, MotionEvent motionEvent) {
        this.f5662a.onTouch((ITuringTouchWrapper) this.b, view, motionEvent);
        return true;
    }
}
