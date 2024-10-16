package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* loaded from: classes.dex */
public final class EventRef extends DataBufferRef implements Event {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EventRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getEventId() {
        return d("external_event_id");
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getName() {
        return d("name");
    }

    @Override // com.google.android.gms.games.event.Event
    public final void getName(CharArrayBuffer charArrayBuffer) {
        a("name", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getDescription() {
        return d("description");
    }

    @Override // com.google.android.gms.games.event.Event
    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        a("description", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public final Uri getIconImageUri() {
        return g("icon_image_uri");
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getIconImageUrl() {
        return d("icon_image_url");
    }

    @Override // com.google.android.gms.games.event.Event
    public final Player getPlayer() {
        return new PlayerRef(this.f1417a, this.b);
    }

    @Override // com.google.android.gms.games.event.Event
    public final long getValue() {
        return a("value");
    }

    @Override // com.google.android.gms.games.event.Event
    public final String getFormattedValue() {
        return d("formatted_value");
    }

    @Override // com.google.android.gms.games.event.Event
    public final void getFormattedValue(CharArrayBuffer charArrayBuffer) {
        a("formatted_value", charArrayBuffer);
    }

    @Override // com.google.android.gms.games.event.Event
    public final boolean isVisible() {
        return c(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return EventEntity.a(this);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return EventEntity.a(this, obj);
    }

    public final String toString() {
        return EventEntity.b(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ((EventEntity) ((Event) freeze())).writeToParcel(parcel, i);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Event freeze() {
        return new EventEntity(this);
    }
}
