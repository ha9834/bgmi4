package com.google.android.gms.games.multiplayer.realtime;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;

/* loaded from: classes.dex */
public final class zzb extends EntityBuffer<Room> {
    public zzb(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    protected final String a() {
        return "external_match_id";
    }

    @Override // com.google.android.gms.common.data.EntityBuffer
    protected final /* synthetic */ Room a(int i, int i2) {
        return new zzf(this.f1413a, i, i2);
    }
}
