package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;

/* loaded from: classes.dex */
public final class zzb extends TurnBasedMatchConfig {

    /* renamed from: a, reason: collision with root package name */
    private final int f1731a;
    private final String[] b;
    private final Bundle c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(TurnBasedMatchConfig.Builder builder) {
        this.f1731a = builder.f1729a;
        this.d = builder.d;
        this.c = builder.c;
        this.b = (String[]) builder.b.toArray(new String[builder.b.size()]);
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public final int getVariant() {
        return this.f1731a;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public final int zzdp() {
        return this.d;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public final String[] getInvitedPlayerIds() {
        return this.b;
    }

    @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
    public final Bundle getAutoMatchCriteria() {
        return this.c;
    }
}
