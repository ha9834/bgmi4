package com.google.android.gms.games.request;

import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public final class zzb extends DataBufferRef implements GameRequest {
    private final int c;

    public zzb(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.c = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final String getRequestId() {
        return d("external_request_id");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final Game getGame() {
        return new GameRef(this.f1417a, this.b);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final Player getSender() {
        return new PlayerRef(this.f1417a, a(), "sender_");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final List<Player> getRecipients() {
        ArrayList arrayList = new ArrayList(this.c);
        for (int i = 0; i < this.c; i++) {
            arrayList.add(new PlayerRef(this.f1417a, this.b + i, "recipient_"));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final boolean isConsumed(String str) {
        return getRecipientStatus(str) == 1;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final byte[] getData() {
        return f("data");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final int getType() {
        return b("type");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final long getCreationTimestamp() {
        return a(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP);
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final long getExpirationTimestamp() {
        return a("expiration_timestamp");
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final int getRecipientStatus(String str) {
        for (int i = this.b; i < this.b + this.c; i++) {
            int windowIndex = this.f1417a.getWindowIndex(i);
            if (this.f1417a.getString("recipient_external_player_id", i, windowIndex).equals(str)) {
                return this.f1417a.getInteger("recipient_status", i, windowIndex);
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.games.request.GameRequest
    public final int getStatus() {
        return b("status");
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return GameRequestEntity.a(this);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return GameRequestEntity.a(this, obj);
    }

    public final String toString() {
        return GameRequestEntity.b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((GameRequestEntity) ((GameRequest) freeze())).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ GameRequest freeze() {
        return new GameRequestEntity(this);
    }
}
