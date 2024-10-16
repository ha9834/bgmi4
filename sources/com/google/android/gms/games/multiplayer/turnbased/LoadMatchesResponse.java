package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.zzbd;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

/* loaded from: classes.dex */
public final class LoadMatchesResponse {

    /* renamed from: a, reason: collision with root package name */
    private final InvitationBuffer f1728a;
    private final TurnBasedMatchBuffer b;
    private final TurnBasedMatchBuffer c;
    private final TurnBasedMatchBuffer d;

    public LoadMatchesResponse(Bundle bundle) {
        DataHolder a2 = a(bundle, 0);
        if (a2 != null) {
            this.f1728a = new InvitationBuffer(a2);
        } else {
            this.f1728a = null;
        }
        DataHolder a3 = a(bundle, 1);
        if (a3 != null) {
            this.b = new TurnBasedMatchBuffer(a3);
        } else {
            this.b = null;
        }
        DataHolder a4 = a(bundle, 2);
        if (a4 != null) {
            this.c = new TurnBasedMatchBuffer(a4);
        } else {
            this.c = null;
        }
        DataHolder a5 = a(bundle, 3);
        if (a5 != null) {
            this.d = new TurnBasedMatchBuffer(a5);
        } else {
            this.d = null;
        }
    }

    private static DataHolder a(Bundle bundle, int i) {
        String str;
        switch (i) {
            case 0:
                str = "TURN_STATUS_INVITED";
                break;
            case 1:
                str = "TURN_STATUS_MY_TURN";
                break;
            case 2:
                str = "TURN_STATUS_THEIR_TURN";
                break;
            case 3:
                str = "TURN_STATUS_COMPLETE";
                break;
            default:
                StringBuilder sb = new StringBuilder(38);
                sb.append("Unknown match turn status: ");
                sb.append(i);
                zzbd.e("MatchTurnStatus", sb.toString());
                str = "TURN_STATUS_UNKNOWN";
                break;
        }
        if (bundle.containsKey(str)) {
            return (DataHolder) bundle.getParcelable(str);
        }
        return null;
    }

    public final InvitationBuffer getInvitations() {
        return this.f1728a;
    }

    public final TurnBasedMatchBuffer getMyTurnMatches() {
        return this.b;
    }

    public final TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.c;
    }

    public final TurnBasedMatchBuffer getCompletedMatches() {
        return this.d;
    }

    @Deprecated
    public final void close() {
        release();
    }

    public final void release() {
        InvitationBuffer invitationBuffer = this.f1728a;
        if (invitationBuffer != null) {
            invitationBuffer.release();
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer = this.b;
        if (turnBasedMatchBuffer != null) {
            turnBasedMatchBuffer.release();
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer2 = this.c;
        if (turnBasedMatchBuffer2 != null) {
            turnBasedMatchBuffer2.release();
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer3 = this.d;
        if (turnBasedMatchBuffer3 != null) {
            turnBasedMatchBuffer3.release();
        }
    }

    public final boolean hasData() {
        InvitationBuffer invitationBuffer = this.f1728a;
        if (invitationBuffer != null && invitationBuffer.getCount() > 0) {
            return true;
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer = this.b;
        if (turnBasedMatchBuffer != null && turnBasedMatchBuffer.getCount() > 0) {
            return true;
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer2 = this.c;
        if (turnBasedMatchBuffer2 != null && turnBasedMatchBuffer2.getCount() > 0) {
            return true;
        }
        TurnBasedMatchBuffer turnBasedMatchBuffer3 = this.d;
        return turnBasedMatchBuffer3 != null && turnBasedMatchBuffer3.getCount() > 0;
    }
}
