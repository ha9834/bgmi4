package com.google.android.gms.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;

/* loaded from: classes.dex */
final class cm implements Games.GetServerAuthCodeResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f1640a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(Games.b bVar, Status status) {
        this.f1640a = status;
    }

    @Override // com.google.android.gms.games.Games.GetServerAuthCodeResult
    public final String getCode() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f1640a;
    }
}
