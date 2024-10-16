package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class RealTimeMessage implements Parcelable {
    public static final Parcelable.Creator<RealTimeMessage> CREATOR = new a();
    public static final int RELIABLE = 1;
    public static final int UNRELIABLE = 0;

    /* renamed from: a, reason: collision with root package name */
    private final String f1723a;
    private final byte[] b;
    private final int c;

    private RealTimeMessage(String str, byte[] bArr, int i) {
        this.f1723a = (String) Preconditions.checkNotNull(str);
        this.b = (byte[]) ((byte[]) Preconditions.checkNotNull(bArr)).clone();
        this.c = i;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getSenderParticipantId() {
        return this.f1723a;
    }

    public final byte[] getMessageData() {
        return this.b;
    }

    public final boolean isReliable() {
        return this.c == 1;
    }

    private RealTimeMessage(Parcel parcel) {
        this(parcel.readString(), parcel.createByteArray(), parcel.readInt());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1723a);
        parcel.writeByteArray(this.b);
        parcel.writeInt(this.c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ RealTimeMessage(Parcel parcel, a aVar) {
        this(parcel);
    }
}
