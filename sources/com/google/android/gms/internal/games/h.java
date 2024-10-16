package com.google.android.gms.internal.games;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;

/* loaded from: classes2.dex */
final class h implements Invitations.LoadInvitationsResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4266a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar, Status status) {
        this.f4266a = status;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4266a;
    }

    @Override // com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult
    public final InvitationBuffer getInvitations() {
        return new InvitationBuffer(DataHolder.empty(14));
    }
}
