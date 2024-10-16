package com.helpshift.websockets;

/* loaded from: classes2.dex */
class CounterPayloadGenerator implements PayloadGenerator {
    private long mCount;

    @Override // com.helpshift.websockets.PayloadGenerator
    public byte[] generate() {
        this.mCount = Math.max(this.mCount + 1, 1L);
        return Misc.getBytesUTF8(String.valueOf(this.mCount));
    }
}
