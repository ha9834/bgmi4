package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;

/* loaded from: classes2.dex */
final class dk implements Events.LoadEventsResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4263a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(dj djVar, Status status) {
        this.f4263a = status;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4263a;
    }

    @Override // com.google.android.gms.games.event.Events.LoadEventsResult
    public final EventBuffer getEvents() {
        return new EventBuffer(DataHolder.empty(14));
    }
}
