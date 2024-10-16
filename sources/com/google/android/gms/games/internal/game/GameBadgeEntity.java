package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "GameBadgeEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class GameBadgeEntity extends GamesDowngradeableSafeParcel implements zza {
    public static final Parcelable.Creator<GameBadgeEntity> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(getter = "getType", id = 1)
    private int f1669a;

    @SafeParcelable.Field(getter = "getTitle", id = 2)
    private String b;

    @SafeParcelable.Field(getter = "getDescription", id = 3)
    private String c;

    @SafeParcelable.Field(getter = "getIconImageUri", id = 4)
    private Uri d;

    /* loaded from: classes.dex */
    static final class a extends zzb {
        a() {
        }

        @Override // com.google.android.gms.games.internal.game.zzb
        /* renamed from: zzd */
        public final GameBadgeEntity createFromParcel(Parcel parcel) {
            if (GameBadgeEntity.b(GameBadgeEntity.c()) || GameBadgeEntity.a(GameBadgeEntity.class.getCanonicalName())) {
                return super.createFromParcel(parcel);
            }
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            return new GameBadgeEntity(readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
        }

        @Override // com.google.android.gms.games.internal.game.zzb, android.os.Parcelable.Creator
        public final /* synthetic */ GameBadgeEntity createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public GameBadgeEntity(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) Uri uri) {
        this.f1669a = i;
        this.b = str;
        this.c = str2;
        this.d = uri;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ zza freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.internal.game.zza
    public final int getType() {
        return this.f1669a;
    }

    @Override // com.google.android.gms.games.internal.game.zza
    public final String getTitle() {
        return this.b;
    }

    @Override // com.google.android.gms.games.internal.game.zza
    public final String getDescription() {
        return this.c;
    }

    @Override // com.google.android.gms.games.internal.game.zza
    public final Uri getIconImageUri() {
        return this.d;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(getType()), getTitle(), getDescription(), getIconImageUri());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zza)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zza zzaVar = (zza) obj;
        return Objects.equal(Integer.valueOf(zzaVar.getType()), getTitle()) && Objects.equal(zzaVar.getDescription(), getIconImageUri());
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Type", Integer.valueOf(getType())).add("Title", getTitle()).add("Description", getDescription()).add("IconImageUri", getIconImageUri()).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        if (!b()) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.f1669a);
            SafeParcelWriter.writeString(parcel, 2, this.b, false);
            SafeParcelWriter.writeString(parcel, 3, this.c, false);
            SafeParcelWriter.writeParcelable(parcel, 4, this.d, i, false);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            return;
        }
        parcel.writeInt(this.f1669a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        Uri uri = this.d;
        parcel.writeString(uri == null ? null : uri.toString());
    }

    static /* synthetic */ Integer c() {
        return a();
    }
}
