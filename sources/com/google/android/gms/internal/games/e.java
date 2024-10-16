package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GamesMetadata;

/* loaded from: classes2.dex */
final class e implements GamesMetadata.LoadGamesResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4264a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Status status) {
        this.f4264a = status;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4264a;
    }

    @Override // com.google.android.gms.games.GamesMetadata.LoadGamesResult
    public final GameBuffer getGames() {
        return new GameBuffer(DataHolder.empty(14));
    }
}
