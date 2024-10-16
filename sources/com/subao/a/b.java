package com.subao.a;

import android.util.Log;
import com.mediatek.npps.sdk.DLI;
import com.mediatek.npps.sdk.DPPCb;
import com.mediatek.npps.sdk.NPPS;
import com.subao.common.g.c;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final a f5864a = new a();
    private final c b;
    private boolean c;

    /* loaded from: classes2.dex */
    private class a extends DPPCb {
        private a() {
        }

        @Override // com.mediatek.npps.sdk.DPPCb
        public void onStateChanged(int i) {
            Log.d("SubaoParallel", String.format("NDPPSListener onStateChanged event : %d", Integer.valueOf(i)));
            b.this.b.h(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(c cVar) {
        this.b = cVar;
    }

    public void a(int i, int i2) {
        boolean eDPPCb = NPPS.eDPPCb(i2);
        Log.d("SubaoParallel", String.format("call enableDuplicatePacketPredictionCapability, result = %b", Boolean.valueOf(eDPPCb)));
        if (!eDPPCb) {
            this.b.e(i, false);
            return;
        }
        if (!this.c) {
            this.c = NPPS.rgDPPEt(this.f5864a);
            Log.d("SubaoParallel", String.format("NDPPProcessor, registerDuplicatePacketPredictionEvent, return %b", Boolean.valueOf(this.c)));
        }
        this.b.e(i, this.c);
    }

    public void a() {
        Log.d("SubaoParallel", String.format("call unregisterDuplicatePacketPredictionEvent, result = %b", Boolean.valueOf(NPPS.ugDPPEt(this.f5864a))));
        NPPS.dDPPCb();
        Log.d("SubaoParallel", "call disableDuplicatePacketPredictionCapability");
        this.c = false;
    }

    public void a(int i) {
        boolean iDPPeb = NPPS.iDPPeb();
        Log.d("SubaoParallel", String.format("call isDupPacketPredictionEnabled, result = %b", Boolean.valueOf(iDPPeb)));
        this.b.f(i, iDPPeb);
    }

    public void b(int i) {
        boolean stDPP = NPPS.stDPP();
        Log.d("SubaoParallel", String.format("call startDuplicatePacketPrediction, result = %b", Boolean.valueOf(stDPP)));
        this.b.g(i, stDPP);
    }

    public void a(int i, String str, int i2, String str2, int i3, int i4) {
        boolean upMDPL = NPPS.upMDPL(new DLI[]{new DLI(str, str2, i2, i3, i4)});
        Log.d("SubaoParallel", String.format("call updateDuplicatePacketLink, src ip = %s, src port = %d, des ip = %s, des port = %d, protocol = %d, result = %b", str, Integer.valueOf(i2), str2, Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(upMDPL)));
        this.b.h(i, upMDPL);
    }

    public void c(int i) {
        boolean spDPP = NPPS.spDPP();
        Log.d("SubaoParallel", String.format("call stopDuplicatePacketPrediction, result = %b", Boolean.valueOf(spDPP)));
        this.b.i(i, spDPP);
    }
}
