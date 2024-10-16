package com.mediatek.npps.sdk;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.a;
import com.mediatek.powerhalmgr.IDPPListener;

/* loaded from: classes2.dex */
public abstract class DPPCb implements IInterface {
    private static final String DPP_EVENT_KEY = "STATE";
    private IInterface mCallback;

    public abstract void onStateChanged(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public DPPCb() {
        if (Build.VERSION.SDK_INT > 28) {
            this.mCallback = new a.AbstractBinderC0004a() { // from class: com.mediatek.npps.sdk.DPPCb.1
                @Override // android.os.a
                public void sendResult(Bundle bundle) {
                    if (bundle != null) {
                        DPPCb.this.onStateChanged(bundle.getInt(DPPCb.DPP_EVENT_KEY));
                    }
                }
            };
        } else {
            this.mCallback = new IDPPListener.Stub() { // from class: com.mediatek.npps.sdk.DPPCb.2
                @Override // com.mediatek.powerhalmgr.IDPPListener
                public void onStateChanged(int i) {
                    DPPCb.this.onStateChanged(i);
                }
            };
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.mCallback.asBinder();
    }
}
