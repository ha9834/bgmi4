package com.google.android.gms.internal.plus;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.plus.model.people.Person;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
@SafeParcelable.Class(creator = "PersonEntityCreator")
/* loaded from: classes2.dex */
public final class zzr extends FastSafeParcelableJsonResponse implements Person {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> f4660a;

    @SafeParcelable.Field(id = 29)
    private boolean A;

    @SafeParcelable.Indicator
    private final Set<Integer> b;

    @SafeParcelable.VersionField(id = 1)
    private final int c;

    @SafeParcelable.Field(id = 2)
    private String d;

    @SafeParcelable.Field(id = 3)
    private zza e;

    @SafeParcelable.Field(id = 4)
    private String f;

    @SafeParcelable.Field(id = 5)
    private String g;

    @SafeParcelable.Field(id = 6)
    private int h;

    @SafeParcelable.Field(id = 7)
    private zzb i;

    @SafeParcelable.Field(id = 8)
    private String j;

    @SafeParcelable.Field(id = 9)
    private String k;

    @SafeParcelable.Field(id = 12)
    private int l;

    @SafeParcelable.Field(id = 14)
    private String m;

    @SafeParcelable.Field(id = 15)
    private zzc n;

    @SafeParcelable.Field(id = 16)
    private boolean o;

    @SafeParcelable.Field(id = 18)
    private String p;

    @SafeParcelable.Field(id = 19)
    private zzd q;

    @SafeParcelable.Field(id = 20)
    private String r;

    @SafeParcelable.Field(id = 21)
    private int s;

    @SafeParcelable.Field(id = 22)
    private List<zze> t;

    @SafeParcelable.Field(id = 23)
    private List<zzf> u;

    @SafeParcelable.Field(id = 24)
    private int v;

    @SafeParcelable.Field(id = 25)
    private int w;

    @SafeParcelable.Field(id = 26)
    private String x;

    @SafeParcelable.Field(id = 27)
    private String y;

    @SafeParcelable.Field(id = 28)
    private List<zzg> z;

    @VisibleForTesting
    @SafeParcelable.Class(creator = "PersonEntity_AgeRangeEntityCreator")
    /* loaded from: classes2.dex */
    public static final class zza extends FastSafeParcelableJsonResponse implements Person.AgeRange {
        public static final Parcelable.Creator<zza> CREATOR = new zzt();

        /* renamed from: a, reason: collision with root package name */
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> f4661a;

        @SafeParcelable.Indicator
        private final Set<Integer> b;

        @SafeParcelable.VersionField(id = 1)
        private final int c;

        @SafeParcelable.Field(id = 2)
        private int d;

        @SafeParcelable.Field(id = 3)
        private int e;

        static {
            HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
            f4661a = hashMap;
            hashMap.put("max", FastJsonResponse.Field.forInteger("max", 2));
            f4661a.put("min", FastJsonResponse.Field.forInteger("min", 3));
        }

        public zza() {
            this.c = 1;
            this.b = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SafeParcelable.Constructor
        public zza(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3) {
            this.b = set;
            this.c = i;
            this.d = i2;
            this.e = i3;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final void a(FastJsonResponse.Field<?, ?> field, String str, int i) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.d = i;
                    break;
                case 3:
                    this.e = i;
                    break;
                default:
                    StringBuilder sb = new StringBuilder(52);
                    sb.append("Field with id=");
                    sb.append(safeParcelableFieldId);
                    sb.append(" is not known to be an int.");
                    throw new IllegalArgumentException(sb.toString());
            }
            this.b.add(Integer.valueOf(safeParcelableFieldId));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final boolean a(FastJsonResponse.Field field) {
            return this.b.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final Object b(FastJsonResponse.Field field) {
            int i;
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    i = this.d;
                    break;
                case 3:
                    i = this.e;
                    break;
                default:
                    int safeParcelableFieldId = field.getSafeParcelableFieldId();
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unknown safe parcelable id=");
                    sb.append(safeParcelableFieldId);
                    throw new IllegalStateException(sb.toString());
            }
            return Integer.valueOf(i);
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zza zzaVar = (zza) obj;
            for (FastJsonResponse.Field<?, ?> field : f4661a.values()) {
                if (a(field)) {
                    if (!zzaVar.a(field) || !b(field).equals(zzaVar.b(field))) {
                        return false;
                    }
                } else if (zzaVar.a(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final /* bridge */ /* synthetic */ Person.AgeRange freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final /* synthetic */ Map getFieldMappings() {
            return f4661a;
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public final int getMax() {
            return this.d;
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public final int getMin() {
            return this.e;
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public final boolean hasMax() {
            return this.b.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.AgeRange
        public final boolean hasMin() {
            return this.b.contains(3);
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final int hashCode() {
            int i = 0;
            for (FastJsonResponse.Field<?, ?> field : f4661a.values()) {
                if (a(field)) {
                    i = i + field.getSafeParcelableFieldId() + b(field).hashCode();
                }
            }
            return i;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            Set<Integer> set = this.b;
            if (set.contains(1)) {
                SafeParcelWriter.writeInt(parcel, 1, this.c);
            }
            if (set.contains(2)) {
                SafeParcelWriter.writeInt(parcel, 2, this.d);
            }
            if (set.contains(3)) {
                SafeParcelWriter.writeInt(parcel, 3, this.e);
            }
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @VisibleForTesting
    @SafeParcelable.Class(creator = "PersonEntity_CoverEntityCreator")
    /* loaded from: classes2.dex */
    public static final class zzb extends FastSafeParcelableJsonResponse implements Person.Cover {
        public static final Parcelable.Creator<zzb> CREATOR = new zzu();

        /* renamed from: a, reason: collision with root package name */
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> f4662a;

        @SafeParcelable.Indicator
        private final Set<Integer> b;

        @SafeParcelable.VersionField(id = 1)
        private final int c;

        @SafeParcelable.Field(id = 2)
        private zza d;

        @SafeParcelable.Field(id = 3)
        private C0112zzb e;

        @SafeParcelable.Field(id = 4)
        private int f;

        @VisibleForTesting
        @SafeParcelable.Class(creator = "PersonEntity_CoverEntity_CoverInfoEntityCreator")
        /* loaded from: classes2.dex */
        public static final class zza extends FastSafeParcelableJsonResponse implements Person.Cover.CoverInfo {
            public static final Parcelable.Creator<zza> CREATOR = new zzv();

            /* renamed from: a, reason: collision with root package name */
            private static final HashMap<String, FastJsonResponse.Field<?, ?>> f4663a;

            @SafeParcelable.Indicator
            private final Set<Integer> b;

            @SafeParcelable.VersionField(id = 1)
            private final int c;

            @SafeParcelable.Field(id = 2)
            private int d;

            @SafeParcelable.Field(id = 3)
            private int e;

            static {
                HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
                f4663a = hashMap;
                hashMap.put("leftImageOffset", FastJsonResponse.Field.forInteger("leftImageOffset", 2));
                f4663a.put("topImageOffset", FastJsonResponse.Field.forInteger("topImageOffset", 3));
            }

            public zza() {
                this.c = 1;
                this.b = new HashSet();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @SafeParcelable.Constructor
            public zza(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3) {
                this.b = set;
                this.c = i;
                this.d = i2;
                this.e = i3;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected final void a(FastJsonResponse.Field<?, ?> field, String str, int i) {
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                switch (safeParcelableFieldId) {
                    case 2:
                        this.d = i;
                        break;
                    case 3:
                        this.e = i;
                        break;
                    default:
                        StringBuilder sb = new StringBuilder(52);
                        sb.append("Field with id=");
                        sb.append(safeParcelableFieldId);
                        sb.append(" is not known to be an int.");
                        throw new IllegalArgumentException(sb.toString());
                }
                this.b.add(Integer.valueOf(safeParcelableFieldId));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            public final boolean a(FastJsonResponse.Field field) {
                return this.b.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            public final Object b(FastJsonResponse.Field field) {
                int i;
                switch (field.getSafeParcelableFieldId()) {
                    case 2:
                        i = this.d;
                        break;
                    case 3:
                        i = this.e;
                        break;
                    default:
                        int safeParcelableFieldId = field.getSafeParcelableFieldId();
                        StringBuilder sb = new StringBuilder(38);
                        sb.append("Unknown safe parcelable id=");
                        sb.append(safeParcelableFieldId);
                        throw new IllegalStateException(sb.toString());
                }
                return Integer.valueOf(i);
            }

            @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
            public final boolean equals(Object obj) {
                if (!(obj instanceof zza)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                zza zzaVar = (zza) obj;
                for (FastJsonResponse.Field<?, ?> field : f4663a.values()) {
                    if (a(field)) {
                        if (!zzaVar.a(field) || !b(field).equals(zzaVar.b(field))) {
                            return false;
                        }
                    } else if (zzaVar.a(field)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.android.gms.common.data.Freezable
            public final /* bridge */ /* synthetic */ Person.Cover.CoverInfo freeze() {
                return this;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            public final /* synthetic */ Map getFieldMappings() {
                return f4663a;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public final int getLeftImageOffset() {
                return this.d;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public final int getTopImageOffset() {
                return this.e;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public final boolean hasLeftImageOffset() {
                return this.b.contains(2);
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverInfo
            public final boolean hasTopImageOffset() {
                return this.b.contains(3);
            }

            @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
            public final int hashCode() {
                int i = 0;
                for (FastJsonResponse.Field<?, ?> field : f4663a.values()) {
                    if (a(field)) {
                        i = i + field.getSafeParcelableFieldId() + b(field).hashCode();
                    }
                }
                return i;
            }

            @Override // com.google.android.gms.common.data.Freezable
            public final boolean isDataValid() {
                return true;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i) {
                int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
                Set<Integer> set = this.b;
                if (set.contains(1)) {
                    SafeParcelWriter.writeInt(parcel, 1, this.c);
                }
                if (set.contains(2)) {
                    SafeParcelWriter.writeInt(parcel, 2, this.d);
                }
                if (set.contains(3)) {
                    SafeParcelWriter.writeInt(parcel, 3, this.e);
                }
                SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            }
        }

        @VisibleForTesting
        @SafeParcelable.Class(creator = "PersonEntity_CoverEntity_CoverPhotoEntityCreator")
        /* renamed from: com.google.android.gms.internal.plus.zzr$zzb$zzb, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0112zzb extends FastSafeParcelableJsonResponse implements Person.Cover.CoverPhoto {
            public static final Parcelable.Creator<C0112zzb> CREATOR = new zzw();

            /* renamed from: a, reason: collision with root package name */
            private static final HashMap<String, FastJsonResponse.Field<?, ?>> f4664a;

            @SafeParcelable.Indicator
            private final Set<Integer> b;

            @SafeParcelable.VersionField(id = 1)
            private final int c;

            @SafeParcelable.Field(id = 2)
            private int d;

            @SafeParcelable.Field(id = 3)
            private String e;

            @SafeParcelable.Field(id = 4)
            private int f;

            static {
                HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
                f4664a = hashMap;
                hashMap.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, FastJsonResponse.Field.forInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 2));
                f4664a.put("url", FastJsonResponse.Field.forString("url", 3));
                f4664a.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, FastJsonResponse.Field.forInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 4));
            }

            public C0112zzb() {
                this.c = 1;
                this.b = new HashSet();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @SafeParcelable.Constructor
            public C0112zzb(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) int i3) {
                this.b = set;
                this.c = i;
                this.d = i2;
                this.e = str;
                this.f = i3;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected final void a(FastJsonResponse.Field<?, ?> field, String str, int i) {
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                if (safeParcelableFieldId == 2) {
                    this.d = i;
                } else {
                    if (safeParcelableFieldId != 4) {
                        StringBuilder sb = new StringBuilder(52);
                        sb.append("Field with id=");
                        sb.append(safeParcelableFieldId);
                        sb.append(" is not known to be an int.");
                        throw new IllegalArgumentException(sb.toString());
                    }
                    this.f = i;
                }
                this.b.add(Integer.valueOf(safeParcelableFieldId));
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            protected final void a(FastJsonResponse.Field<?, ?> field, String str, String str2) {
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                if (safeParcelableFieldId == 3) {
                    this.e = str2;
                    this.b.add(Integer.valueOf(safeParcelableFieldId));
                } else {
                    StringBuilder sb = new StringBuilder(54);
                    sb.append("Field with id=");
                    sb.append(safeParcelableFieldId);
                    sb.append(" is not known to be a String.");
                    throw new IllegalArgumentException(sb.toString());
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            public final boolean a(FastJsonResponse.Field field) {
                return this.b.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            public final Object b(FastJsonResponse.Field field) {
                int i;
                switch (field.getSafeParcelableFieldId()) {
                    case 2:
                        i = this.d;
                        break;
                    case 3:
                        return this.e;
                    case 4:
                        i = this.f;
                        break;
                    default:
                        int safeParcelableFieldId = field.getSafeParcelableFieldId();
                        StringBuilder sb = new StringBuilder(38);
                        sb.append("Unknown safe parcelable id=");
                        sb.append(safeParcelableFieldId);
                        throw new IllegalStateException(sb.toString());
                }
                return Integer.valueOf(i);
            }

            @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
            public final boolean equals(Object obj) {
                if (!(obj instanceof C0112zzb)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                C0112zzb c0112zzb = (C0112zzb) obj;
                for (FastJsonResponse.Field<?, ?> field : f4664a.values()) {
                    if (a(field)) {
                        if (!c0112zzb.a(field) || !b(field).equals(c0112zzb.b(field))) {
                            return false;
                        }
                    } else if (c0112zzb.a(field)) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.android.gms.common.data.Freezable
            public final /* bridge */ /* synthetic */ Person.Cover.CoverPhoto freeze() {
                return this;
            }

            @Override // com.google.android.gms.common.server.response.FastJsonResponse
            public final /* synthetic */ Map getFieldMappings() {
                return f4664a;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public final int getHeight() {
                return this.d;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public final String getUrl() {
                return this.e;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public final int getWidth() {
                return this.f;
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public final boolean hasHeight() {
                return this.b.contains(2);
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public final boolean hasUrl() {
                return this.b.contains(3);
            }

            @Override // com.google.android.gms.plus.model.people.Person.Cover.CoverPhoto
            public final boolean hasWidth() {
                return this.b.contains(4);
            }

            @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
            public final int hashCode() {
                int i = 0;
                for (FastJsonResponse.Field<?, ?> field : f4664a.values()) {
                    if (a(field)) {
                        i = i + field.getSafeParcelableFieldId() + b(field).hashCode();
                    }
                }
                return i;
            }

            @Override // com.google.android.gms.common.data.Freezable
            public final boolean isDataValid() {
                return true;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i) {
                int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
                Set<Integer> set = this.b;
                if (set.contains(1)) {
                    SafeParcelWriter.writeInt(parcel, 1, this.c);
                }
                if (set.contains(2)) {
                    SafeParcelWriter.writeInt(parcel, 2, this.d);
                }
                if (set.contains(3)) {
                    SafeParcelWriter.writeString(parcel, 3, this.e, true);
                }
                if (set.contains(4)) {
                    SafeParcelWriter.writeInt(parcel, 4, this.f);
                }
                SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            }
        }

        static {
            HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
            f4662a = hashMap;
            hashMap.put("coverInfo", FastJsonResponse.Field.forConcreteType("coverInfo", 2, zza.class));
            f4662a.put("coverPhoto", FastJsonResponse.Field.forConcreteType("coverPhoto", 3, C0112zzb.class));
            f4662a.put("layout", FastJsonResponse.Field.withConverter("layout", 4, new StringToIntConverter().add("banner", 0), false));
        }

        public zzb() {
            this.c = 1;
            this.b = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SafeParcelable.Constructor
        public zzb(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) zza zzaVar, @SafeParcelable.Param(id = 3) C0112zzb c0112zzb, @SafeParcelable.Param(id = 4) int i2) {
            this.b = set;
            this.c = i;
            this.d = zzaVar;
            this.e = c0112zzb;
            this.f = i2;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final void a(FastJsonResponse.Field<?, ?> field, String str, int i) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 4) {
                this.f = i;
                this.b.add(Integer.valueOf(safeParcelableFieldId));
            } else {
                StringBuilder sb = new StringBuilder(52);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be an int.");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final boolean a(FastJsonResponse.Field field) {
            return this.b.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.d = (zza) t;
                    break;
                case 3:
                    this.e = (C0112zzb) t;
                    break;
                default:
                    String canonicalName = t.getClass().getCanonicalName();
                    StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 62);
                    sb.append("Field with id=");
                    sb.append(safeParcelableFieldId);
                    sb.append(" is not a known custom type.  Found ");
                    sb.append(canonicalName);
                    sb.append(".");
                    throw new IllegalArgumentException(sb.toString());
            }
            this.b.add(Integer.valueOf(safeParcelableFieldId));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final Object b(FastJsonResponse.Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.d;
                case 3:
                    return this.e;
                case 4:
                    return Integer.valueOf(this.f);
                default:
                    int safeParcelableFieldId = field.getSafeParcelableFieldId();
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unknown safe parcelable id=");
                    sb.append(safeParcelableFieldId);
                    throw new IllegalStateException(sb.toString());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzb zzbVar = (zzb) obj;
            for (FastJsonResponse.Field<?, ?> field : f4662a.values()) {
                if (a(field)) {
                    if (!zzbVar.a(field) || !b(field).equals(zzbVar.b(field))) {
                        return false;
                    }
                } else if (zzbVar.a(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final /* bridge */ /* synthetic */ Person.Cover freeze() {
            return this;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public final Person.Cover.CoverInfo getCoverInfo() {
            return this.d;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public final Person.Cover.CoverPhoto getCoverPhoto() {
            return this.e;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final /* synthetic */ Map getFieldMappings() {
            return f4662a;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public final int getLayout() {
            return this.f;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public final boolean hasCoverInfo() {
            return this.b.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public final boolean hasCoverPhoto() {
            return this.b.contains(3);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Cover
        public final boolean hasLayout() {
            return this.b.contains(4);
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final int hashCode() {
            int i = 0;
            for (FastJsonResponse.Field<?, ?> field : f4662a.values()) {
                if (a(field)) {
                    i = i + field.getSafeParcelableFieldId() + b(field).hashCode();
                }
            }
            return i;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            Set<Integer> set = this.b;
            if (set.contains(1)) {
                SafeParcelWriter.writeInt(parcel, 1, this.c);
            }
            if (set.contains(2)) {
                SafeParcelWriter.writeParcelable(parcel, 2, this.d, i, true);
            }
            if (set.contains(3)) {
                SafeParcelWriter.writeParcelable(parcel, 3, this.e, i, true);
            }
            if (set.contains(4)) {
                SafeParcelWriter.writeInt(parcel, 4, this.f);
            }
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @VisibleForTesting
    @SafeParcelable.Class(creator = "PersonEntity_ImageEntityCreator")
    /* loaded from: classes2.dex */
    public static final class zzc extends FastSafeParcelableJsonResponse implements Person.Image {
        public static final Parcelable.Creator<zzc> CREATOR = new zzx();

        /* renamed from: a, reason: collision with root package name */
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> f4665a;

        @SafeParcelable.Indicator
        private final Set<Integer> b;

        @SafeParcelable.VersionField(id = 1)
        private final int c;

        @SafeParcelable.Field(id = 2)
        private String d;

        static {
            HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
            f4665a = hashMap;
            hashMap.put("url", FastJsonResponse.Field.forString("url", 2));
        }

        public zzc() {
            this.c = 1;
            this.b = new HashSet();
        }

        public zzc(String str) {
            this.b = new HashSet();
            this.c = 1;
            this.d = str;
            this.b.add(2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SafeParcelable.Constructor
        public zzc(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str) {
            this.b = set;
            this.c = i;
            this.d = str;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final void a(FastJsonResponse.Field<?, ?> field, String str, String str2) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 2) {
                this.d = str2;
                this.b.add(Integer.valueOf(safeParcelableFieldId));
            } else {
                StringBuilder sb = new StringBuilder(54);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be a String.");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final boolean a(FastJsonResponse.Field field) {
            return this.b.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final Object b(FastJsonResponse.Field field) {
            if (field.getSafeParcelableFieldId() == 2) {
                return this.d;
            }
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            StringBuilder sb = new StringBuilder(38);
            sb.append("Unknown safe parcelable id=");
            sb.append(safeParcelableFieldId);
            throw new IllegalStateException(sb.toString());
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc zzcVar = (zzc) obj;
            for (FastJsonResponse.Field<?, ?> field : f4665a.values()) {
                if (a(field)) {
                    if (!zzcVar.a(field) || !b(field).equals(zzcVar.b(field))) {
                        return false;
                    }
                } else if (zzcVar.a(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final /* bridge */ /* synthetic */ Person.Image freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final /* synthetic */ Map getFieldMappings() {
            return f4665a;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Image
        public final String getUrl() {
            return this.d;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Image
        public final boolean hasUrl() {
            return this.b.contains(2);
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final int hashCode() {
            int i = 0;
            for (FastJsonResponse.Field<?, ?> field : f4665a.values()) {
                if (a(field)) {
                    i = i + field.getSafeParcelableFieldId() + b(field).hashCode();
                }
            }
            return i;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            Set<Integer> set = this.b;
            if (set.contains(1)) {
                SafeParcelWriter.writeInt(parcel, 1, this.c);
            }
            if (set.contains(2)) {
                SafeParcelWriter.writeString(parcel, 2, this.d, true);
            }
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @VisibleForTesting
    @SafeParcelable.Class(creator = "PersonEntity_NameEntityCreator")
    /* loaded from: classes2.dex */
    public static final class zzd extends FastSafeParcelableJsonResponse implements Person.Name {
        public static final Parcelable.Creator<zzd> CREATOR = new zzy();

        /* renamed from: a, reason: collision with root package name */
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> f4666a;

        @SafeParcelable.Indicator
        private final Set<Integer> b;

        @SafeParcelable.VersionField(id = 1)
        private final int c;

        @SafeParcelable.Field(id = 2)
        private String d;

        @SafeParcelable.Field(id = 3)
        private String e;

        @SafeParcelable.Field(id = 4)
        private String f;

        @SafeParcelable.Field(id = 5)
        private String g;

        @SafeParcelable.Field(id = 6)
        private String h;

        @SafeParcelable.Field(id = 7)
        private String i;

        static {
            HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
            f4666a = hashMap;
            hashMap.put("familyName", FastJsonResponse.Field.forString("familyName", 2));
            f4666a.put("formatted", FastJsonResponse.Field.forString("formatted", 3));
            f4666a.put("givenName", FastJsonResponse.Field.forString("givenName", 4));
            f4666a.put("honorificPrefix", FastJsonResponse.Field.forString("honorificPrefix", 5));
            f4666a.put("honorificSuffix", FastJsonResponse.Field.forString("honorificSuffix", 6));
            f4666a.put("middleName", FastJsonResponse.Field.forString("middleName", 7));
        }

        public zzd() {
            this.c = 1;
            this.b = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SafeParcelable.Constructor
        public zzd(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) String str6) {
            this.b = set;
            this.c = i;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = str5;
            this.i = str6;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final void a(FastJsonResponse.Field<?, ?> field, String str, String str2) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.d = str2;
                    break;
                case 3:
                    this.e = str2;
                    break;
                case 4:
                    this.f = str2;
                    break;
                case 5:
                    this.g = str2;
                    break;
                case 6:
                    this.h = str2;
                    break;
                case 7:
                    this.i = str2;
                    break;
                default:
                    StringBuilder sb = new StringBuilder(54);
                    sb.append("Field with id=");
                    sb.append(safeParcelableFieldId);
                    sb.append(" is not known to be a String.");
                    throw new IllegalArgumentException(sb.toString());
            }
            this.b.add(Integer.valueOf(safeParcelableFieldId));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final boolean a(FastJsonResponse.Field field) {
            return this.b.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final Object b(FastJsonResponse.Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.d;
                case 3:
                    return this.e;
                case 4:
                    return this.f;
                case 5:
                    return this.g;
                case 6:
                    return this.h;
                case 7:
                    return this.i;
                default:
                    int safeParcelableFieldId = field.getSafeParcelableFieldId();
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unknown safe parcelable id=");
                    sb.append(safeParcelableFieldId);
                    throw new IllegalStateException(sb.toString());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final boolean equals(Object obj) {
            if (!(obj instanceof zzd)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzd zzdVar = (zzd) obj;
            for (FastJsonResponse.Field<?, ?> field : f4666a.values()) {
                if (a(field)) {
                    if (!zzdVar.a(field) || !b(field).equals(zzdVar.b(field))) {
                        return false;
                    }
                } else if (zzdVar.a(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final /* bridge */ /* synthetic */ Person.Name freeze() {
            return this;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final String getFamilyName() {
            return this.d;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final /* synthetic */ Map getFieldMappings() {
            return f4666a;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final String getFormatted() {
            return this.e;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final String getGivenName() {
            return this.f;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final String getHonorificPrefix() {
            return this.g;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final String getHonorificSuffix() {
            return this.h;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final String getMiddleName() {
            return this.i;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final boolean hasFamilyName() {
            return this.b.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final boolean hasFormatted() {
            return this.b.contains(3);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final boolean hasGivenName() {
            return this.b.contains(4);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final boolean hasHonorificPrefix() {
            return this.b.contains(5);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final boolean hasHonorificSuffix() {
            return this.b.contains(6);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Name
        public final boolean hasMiddleName() {
            return this.b.contains(7);
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final int hashCode() {
            int i = 0;
            for (FastJsonResponse.Field<?, ?> field : f4666a.values()) {
                if (a(field)) {
                    i = i + field.getSafeParcelableFieldId() + b(field).hashCode();
                }
            }
            return i;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            Set<Integer> set = this.b;
            if (set.contains(1)) {
                SafeParcelWriter.writeInt(parcel, 1, this.c);
            }
            if (set.contains(2)) {
                SafeParcelWriter.writeString(parcel, 2, this.d, true);
            }
            if (set.contains(3)) {
                SafeParcelWriter.writeString(parcel, 3, this.e, true);
            }
            if (set.contains(4)) {
                SafeParcelWriter.writeString(parcel, 4, this.f, true);
            }
            if (set.contains(5)) {
                SafeParcelWriter.writeString(parcel, 5, this.g, true);
            }
            if (set.contains(6)) {
                SafeParcelWriter.writeString(parcel, 6, this.h, true);
            }
            if (set.contains(7)) {
                SafeParcelWriter.writeString(parcel, 7, this.i, true);
            }
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @VisibleForTesting
    @SafeParcelable.Class(creator = "PersonEntity_OrganizationsEntityCreator")
    /* loaded from: classes2.dex */
    public static final class zze extends FastSafeParcelableJsonResponse implements Person.Organizations {
        public static final Parcelable.Creator<zze> CREATOR = new zzz();

        /* renamed from: a, reason: collision with root package name */
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> f4667a;

        @SafeParcelable.Indicator
        private final Set<Integer> b;

        @SafeParcelable.VersionField(id = 1)
        private final int c;

        @SafeParcelable.Field(id = 2)
        private String d;

        @SafeParcelable.Field(id = 3)
        private String e;

        @SafeParcelable.Field(id = 4)
        private String f;

        @SafeParcelable.Field(id = 5)
        private String g;

        @SafeParcelable.Field(id = 6)
        private String h;

        @SafeParcelable.Field(id = 7)
        private boolean i;

        @SafeParcelable.Field(id = 8)
        private String j;

        @SafeParcelable.Field(id = 9)
        private String k;

        @SafeParcelable.Field(id = 10)
        private int l;

        static {
            HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
            f4667a = hashMap;
            hashMap.put("department", FastJsonResponse.Field.forString("department", 2));
            f4667a.put("description", FastJsonResponse.Field.forString("description", 3));
            f4667a.put("endDate", FastJsonResponse.Field.forString("endDate", 4));
            f4667a.put(FirebaseAnalytics.Param.LOCATION, FastJsonResponse.Field.forString(FirebaseAnalytics.Param.LOCATION, 5));
            f4667a.put("name", FastJsonResponse.Field.forString("name", 6));
            f4667a.put("primary", FastJsonResponse.Field.forBoolean("primary", 7));
            f4667a.put("startDate", FastJsonResponse.Field.forString("startDate", 8));
            f4667a.put("title", FastJsonResponse.Field.forString("title", 9));
            f4667a.put("type", FastJsonResponse.Field.withConverter("type", 10, new StringToIntConverter().add("work", 0).add("school", 1), false));
        }

        public zze() {
            this.c = 1;
            this.b = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SafeParcelable.Constructor
        public zze(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) String str4, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) boolean z, @SafeParcelable.Param(id = 8) String str6, @SafeParcelable.Param(id = 9) String str7, @SafeParcelable.Param(id = 10) int i2) {
            this.b = set;
            this.c = i;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = str5;
            this.i = z;
            this.j = str6;
            this.k = str7;
            this.l = i2;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final void a(FastJsonResponse.Field<?, ?> field, String str, int i) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 10) {
                this.l = i;
                this.b.add(Integer.valueOf(safeParcelableFieldId));
            } else {
                StringBuilder sb = new StringBuilder(52);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be an int.");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final void a(FastJsonResponse.Field<?, ?> field, String str, String str2) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 2:
                    this.d = str2;
                    break;
                case 3:
                    this.e = str2;
                    break;
                case 4:
                    this.f = str2;
                    break;
                case 5:
                    this.g = str2;
                    break;
                case 6:
                    this.h = str2;
                    break;
                case 7:
                default:
                    StringBuilder sb = new StringBuilder(54);
                    sb.append("Field with id=");
                    sb.append(safeParcelableFieldId);
                    sb.append(" is not known to be a String.");
                    throw new IllegalArgumentException(sb.toString());
                case 8:
                    this.j = str2;
                    break;
                case 9:
                    this.k = str2;
                    break;
            }
            this.b.add(Integer.valueOf(safeParcelableFieldId));
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final void a(FastJsonResponse.Field<?, ?> field, String str, boolean z) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 7) {
                this.i = z;
                this.b.add(Integer.valueOf(safeParcelableFieldId));
            } else {
                StringBuilder sb = new StringBuilder(55);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be a boolean.");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final boolean a(FastJsonResponse.Field field) {
            return this.b.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final Object b(FastJsonResponse.Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return this.d;
                case 3:
                    return this.e;
                case 4:
                    return this.f;
                case 5:
                    return this.g;
                case 6:
                    return this.h;
                case 7:
                    return Boolean.valueOf(this.i);
                case 8:
                    return this.j;
                case 9:
                    return this.k;
                case 10:
                    return Integer.valueOf(this.l);
                default:
                    int safeParcelableFieldId = field.getSafeParcelableFieldId();
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unknown safe parcelable id=");
                    sb.append(safeParcelableFieldId);
                    throw new IllegalStateException(sb.toString());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final boolean equals(Object obj) {
            if (!(obj instanceof zze)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zze zzeVar = (zze) obj;
            for (FastJsonResponse.Field<?, ?> field : f4667a.values()) {
                if (a(field)) {
                    if (!zzeVar.a(field) || !b(field).equals(zzeVar.b(field))) {
                        return false;
                    }
                } else if (zzeVar.a(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final /* bridge */ /* synthetic */ Person.Organizations freeze() {
            return this;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final String getDepartment() {
            return this.d;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final String getDescription() {
            return this.e;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final String getEndDate() {
            return this.f;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final /* synthetic */ Map getFieldMappings() {
            return f4667a;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final String getLocation() {
            return this.g;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final String getName() {
            return this.h;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final String getStartDate() {
            return this.j;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final String getTitle() {
            return this.k;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final int getType() {
            return this.l;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasDepartment() {
            return this.b.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasDescription() {
            return this.b.contains(3);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasEndDate() {
            return this.b.contains(4);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasLocation() {
            return this.b.contains(5);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasName() {
            return this.b.contains(6);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasPrimary() {
            return this.b.contains(7);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasStartDate() {
            return this.b.contains(8);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasTitle() {
            return this.b.contains(9);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean hasType() {
            return this.b.contains(10);
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final int hashCode() {
            int i = 0;
            for (FastJsonResponse.Field<?, ?> field : f4667a.values()) {
                if (a(field)) {
                    i = i + field.getSafeParcelableFieldId() + b(field).hashCode();
                }
            }
            return i;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Organizations
        public final boolean isPrimary() {
            return this.i;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            Set<Integer> set = this.b;
            if (set.contains(1)) {
                SafeParcelWriter.writeInt(parcel, 1, this.c);
            }
            if (set.contains(2)) {
                SafeParcelWriter.writeString(parcel, 2, this.d, true);
            }
            if (set.contains(3)) {
                SafeParcelWriter.writeString(parcel, 3, this.e, true);
            }
            if (set.contains(4)) {
                SafeParcelWriter.writeString(parcel, 4, this.f, true);
            }
            if (set.contains(5)) {
                SafeParcelWriter.writeString(parcel, 5, this.g, true);
            }
            if (set.contains(6)) {
                SafeParcelWriter.writeString(parcel, 6, this.h, true);
            }
            if (set.contains(7)) {
                SafeParcelWriter.writeBoolean(parcel, 7, this.i);
            }
            if (set.contains(8)) {
                SafeParcelWriter.writeString(parcel, 8, this.j, true);
            }
            if (set.contains(9)) {
                SafeParcelWriter.writeString(parcel, 9, this.k, true);
            }
            if (set.contains(10)) {
                SafeParcelWriter.writeInt(parcel, 10, this.l);
            }
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @VisibleForTesting
    @SafeParcelable.Class(creator = "PersonEntity_PlacesLivedEntityCreator")
    /* loaded from: classes2.dex */
    public static final class zzf extends FastSafeParcelableJsonResponse implements Person.PlacesLived {
        public static final Parcelable.Creator<zzf> CREATOR = new zzaa();

        /* renamed from: a, reason: collision with root package name */
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> f4668a;

        @SafeParcelable.Indicator
        private final Set<Integer> b;

        @SafeParcelable.VersionField(id = 1)
        private final int c;

        @SafeParcelable.Field(id = 2)
        private boolean d;

        @SafeParcelable.Field(id = 3)
        private String e;

        static {
            HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
            f4668a = hashMap;
            hashMap.put("primary", FastJsonResponse.Field.forBoolean("primary", 2));
            f4668a.put("value", FastJsonResponse.Field.forString("value", 3));
        }

        public zzf() {
            this.c = 1;
            this.b = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SafeParcelable.Constructor
        public zzf(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) String str) {
            this.b = set;
            this.c = i;
            this.d = z;
            this.e = str;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final void a(FastJsonResponse.Field<?, ?> field, String str, String str2) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 3) {
                this.e = str2;
                this.b.add(Integer.valueOf(safeParcelableFieldId));
            } else {
                StringBuilder sb = new StringBuilder(54);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be a String.");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final void a(FastJsonResponse.Field<?, ?> field, String str, boolean z) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 2) {
                this.d = z;
                this.b.add(Integer.valueOf(safeParcelableFieldId));
            } else {
                StringBuilder sb = new StringBuilder(55);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be a boolean.");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final boolean a(FastJsonResponse.Field field) {
            return this.b.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final Object b(FastJsonResponse.Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 2:
                    return Boolean.valueOf(this.d);
                case 3:
                    return this.e;
                default:
                    int safeParcelableFieldId = field.getSafeParcelableFieldId();
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unknown safe parcelable id=");
                    sb.append(safeParcelableFieldId);
                    throw new IllegalStateException(sb.toString());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final boolean equals(Object obj) {
            if (!(obj instanceof zzf)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzf zzfVar = (zzf) obj;
            for (FastJsonResponse.Field<?, ?> field : f4668a.values()) {
                if (a(field)) {
                    if (!zzfVar.a(field) || !b(field).equals(zzfVar.b(field))) {
                        return false;
                    }
                } else if (zzfVar.a(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final /* bridge */ /* synthetic */ Person.PlacesLived freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final /* synthetic */ Map getFieldMappings() {
            return f4668a;
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public final String getValue() {
            return this.e;
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public final boolean hasPrimary() {
            return this.b.contains(2);
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public final boolean hasValue() {
            return this.b.contains(3);
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final int hashCode() {
            int i = 0;
            for (FastJsonResponse.Field<?, ?> field : f4668a.values()) {
                if (a(field)) {
                    i = i + field.getSafeParcelableFieldId() + b(field).hashCode();
                }
            }
            return i;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // com.google.android.gms.plus.model.people.Person.PlacesLived
        public final boolean isPrimary() {
            return this.d;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            Set<Integer> set = this.b;
            if (set.contains(1)) {
                SafeParcelWriter.writeInt(parcel, 1, this.c);
            }
            if (set.contains(2)) {
                SafeParcelWriter.writeBoolean(parcel, 2, this.d);
            }
            if (set.contains(3)) {
                SafeParcelWriter.writeString(parcel, 3, this.e, true);
            }
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @VisibleForTesting
    @SafeParcelable.Class(creator = "PersonEntity_UrlsEntityCreator")
    /* loaded from: classes2.dex */
    public static final class zzg extends FastSafeParcelableJsonResponse implements Person.Urls {
        public static final Parcelable.Creator<zzg> CREATOR = new zzab();

        /* renamed from: a, reason: collision with root package name */
        private static final HashMap<String, FastJsonResponse.Field<?, ?>> f4669a;

        @SafeParcelable.Indicator
        private final Set<Integer> b;

        @SafeParcelable.VersionField(id = 1)
        private final int c;

        @SafeParcelable.Field(id = 5)
        private String d;

        @SafeParcelable.Field(getter = "getType_DEPRECATED_FENACHO", id = 3)
        private final int e;

        @SafeParcelable.Field(id = 6)
        private int f;

        @SafeParcelable.Field(id = 4)
        private String g;

        static {
            HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
            f4669a = hashMap;
            hashMap.put("label", FastJsonResponse.Field.forString("label", 5));
            f4669a.put("type", FastJsonResponse.Field.withConverter("type", 6, new StringToIntConverter().add("home", 0).add("work", 1).add("blog", 2).add(Scopes.PROFILE, 3).add("other", 4).add("otherProfile", 5).add("contributor", 6).add("website", 7), false));
            f4669a.put("value", FastJsonResponse.Field.forString("value", 4));
        }

        public zzg() {
            this.e = 4;
            this.c = 1;
            this.b = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @SafeParcelable.Constructor
        public zzg(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) int i2, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 3) int i3) {
            this.e = 4;
            this.b = set;
            this.c = i;
            this.d = str;
            this.f = i2;
            this.g = str2;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final void a(FastJsonResponse.Field<?, ?> field, String str, int i) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            if (safeParcelableFieldId == 6) {
                this.f = i;
                this.b.add(Integer.valueOf(safeParcelableFieldId));
            } else {
                StringBuilder sb = new StringBuilder(52);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be an int.");
                throw new IllegalArgumentException(sb.toString());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        protected final void a(FastJsonResponse.Field<?, ?> field, String str, String str2) {
            int safeParcelableFieldId = field.getSafeParcelableFieldId();
            switch (safeParcelableFieldId) {
                case 4:
                    this.g = str2;
                    break;
                case 5:
                    this.d = str2;
                    break;
                default:
                    StringBuilder sb = new StringBuilder(54);
                    sb.append("Field with id=");
                    sb.append(safeParcelableFieldId);
                    sb.append(" is not known to be a String.");
                    throw new IllegalArgumentException(sb.toString());
            }
            this.b.add(Integer.valueOf(safeParcelableFieldId));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final boolean a(FastJsonResponse.Field field) {
            return this.b.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final Object b(FastJsonResponse.Field field) {
            switch (field.getSafeParcelableFieldId()) {
                case 4:
                    return this.g;
                case 5:
                    return this.d;
                case 6:
                    return Integer.valueOf(this.f);
                default:
                    int safeParcelableFieldId = field.getSafeParcelableFieldId();
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unknown safe parcelable id=");
                    sb.append(safeParcelableFieldId);
                    throw new IllegalStateException(sb.toString());
            }
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final boolean equals(Object obj) {
            if (!(obj instanceof zzg)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzg zzgVar = (zzg) obj;
            for (FastJsonResponse.Field<?, ?> field : f4669a.values()) {
                if (a(field)) {
                    if (!zzgVar.a(field) || !b(field).equals(zzgVar.b(field))) {
                        return false;
                    }
                } else if (zzgVar.a(field)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final /* bridge */ /* synthetic */ Person.Urls freeze() {
            return this;
        }

        @Override // com.google.android.gms.common.server.response.FastJsonResponse
        public final /* synthetic */ Map getFieldMappings() {
            return f4669a;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public final String getLabel() {
            return this.d;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public final int getType() {
            return this.f;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public final String getValue() {
            return this.g;
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public final boolean hasLabel() {
            return this.b.contains(5);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public final boolean hasType() {
            return this.b.contains(6);
        }

        @Override // com.google.android.gms.plus.model.people.Person.Urls
        public final boolean hasValue() {
            return this.b.contains(4);
        }

        @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
        public final int hashCode() {
            int i = 0;
            for (FastJsonResponse.Field<?, ?> field : f4669a.values()) {
                if (a(field)) {
                    i = i + field.getSafeParcelableFieldId() + b(field).hashCode();
                }
            }
            return i;
        }

        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return true;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            Set<Integer> set = this.b;
            if (set.contains(1)) {
                SafeParcelWriter.writeInt(parcel, 1, this.c);
            }
            if (set.contains(3)) {
                SafeParcelWriter.writeInt(parcel, 3, 4);
            }
            if (set.contains(4)) {
                SafeParcelWriter.writeString(parcel, 4, this.g, true);
            }
            if (set.contains(5)) {
                SafeParcelWriter.writeString(parcel, 5, this.d, true);
            }
            if (set.contains(6)) {
                SafeParcelWriter.writeInt(parcel, 6, this.f);
            }
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        f4660a = hashMap;
        hashMap.put("aboutMe", FastJsonResponse.Field.forString("aboutMe", 2));
        f4660a.put("ageRange", FastJsonResponse.Field.forConcreteType("ageRange", 3, zza.class));
        f4660a.put("birthday", FastJsonResponse.Field.forString("birthday", 4));
        f4660a.put("braggingRights", FastJsonResponse.Field.forString("braggingRights", 5));
        f4660a.put("circledByCount", FastJsonResponse.Field.forInteger("circledByCount", 6));
        f4660a.put("cover", FastJsonResponse.Field.forConcreteType("cover", 7, zzb.class));
        f4660a.put("currentLocation", FastJsonResponse.Field.forString("currentLocation", 8));
        f4660a.put("displayName", FastJsonResponse.Field.forString("displayName", 9));
        f4660a.put("gender", FastJsonResponse.Field.withConverter("gender", 12, new StringToIntConverter().add("male", 0).add("female", 1).add("other", 2), false));
        f4660a.put("id", FastJsonResponse.Field.forString("id", 14));
        f4660a.put("image", FastJsonResponse.Field.forConcreteType("image", 15, zzc.class));
        f4660a.put("isPlusUser", FastJsonResponse.Field.forBoolean("isPlusUser", 16));
        f4660a.put("language", FastJsonResponse.Field.forString("language", 18));
        f4660a.put("name", FastJsonResponse.Field.forConcreteType("name", 19, zzd.class));
        f4660a.put("nickname", FastJsonResponse.Field.forString("nickname", 20));
        f4660a.put("objectType", FastJsonResponse.Field.withConverter("objectType", 21, new StringToIntConverter().add("person", 0).add("page", 1), false));
        f4660a.put("organizations", FastJsonResponse.Field.forConcreteTypeArray("organizations", 22, zze.class));
        f4660a.put("placesLived", FastJsonResponse.Field.forConcreteTypeArray("placesLived", 23, zzf.class));
        f4660a.put("plusOneCount", FastJsonResponse.Field.forInteger("plusOneCount", 24));
        f4660a.put("relationshipStatus", FastJsonResponse.Field.withConverter("relationshipStatus", 25, new StringToIntConverter().add("single", 0).add("in_a_relationship", 1).add("engaged", 2).add("married", 3).add("its_complicated", 4).add("open_relationship", 5).add("widowed", 6).add("in_domestic_partnership", 7).add("in_civil_union", 8), false));
        f4660a.put("tagline", FastJsonResponse.Field.forString("tagline", 26));
        f4660a.put("url", FastJsonResponse.Field.forString("url", 27));
        f4660a.put("urls", FastJsonResponse.Field.forConcreteTypeArray("urls", 28, zzg.class));
        f4660a.put("verified", FastJsonResponse.Field.forBoolean("verified", 29));
    }

    public zzr() {
        this.c = 1;
        this.b = new HashSet();
    }

    public zzr(String str, String str2, zzc zzcVar, int i, String str3) {
        this.c = 1;
        this.b = new HashSet();
        this.k = str;
        this.b.add(9);
        this.m = str2;
        this.b.add(14);
        this.n = zzcVar;
        this.b.add(15);
        this.s = i;
        this.b.add(21);
        this.y = str3;
        this.b.add(27);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) zza zzaVar, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) int i2, @SafeParcelable.Param(id = 7) zzb zzbVar, @SafeParcelable.Param(id = 8) String str4, @SafeParcelable.Param(id = 9) String str5, @SafeParcelable.Param(id = 12) int i3, @SafeParcelable.Param(id = 14) String str6, @SafeParcelable.Param(id = 15) zzc zzcVar, @SafeParcelable.Param(id = 16) boolean z, @SafeParcelable.Param(id = 18) String str7, @SafeParcelable.Param(id = 19) zzd zzdVar, @SafeParcelable.Param(id = 20) String str8, @SafeParcelable.Param(id = 21) int i4, @SafeParcelable.Param(id = 22) List<zze> list, @SafeParcelable.Param(id = 23) List<zzf> list2, @SafeParcelable.Param(id = 24) int i5, @SafeParcelable.Param(id = 25) int i6, @SafeParcelable.Param(id = 26) String str9, @SafeParcelable.Param(id = 27) String str10, @SafeParcelable.Param(id = 28) List<zzg> list3, @SafeParcelable.Param(id = 29) boolean z2) {
        this.b = set;
        this.c = i;
        this.d = str;
        this.e = zzaVar;
        this.f = str2;
        this.g = str3;
        this.h = i2;
        this.i = zzbVar;
        this.j = str4;
        this.k = str5;
        this.l = i3;
        this.m = str6;
        this.n = zzcVar;
        this.o = z;
        this.p = str7;
        this.q = zzdVar;
        this.r = str8;
        this.s = i4;
        this.t = list;
        this.u = list2;
        this.v = i5;
        this.w = i6;
        this.x = str9;
        this.y = str10;
        this.z = list3;
        this.A = z2;
    }

    public static zzr zza(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        zzr createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void a(FastJsonResponse.Field<?, ?> field, String str, int i) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 6) {
            this.h = i;
        } else if (safeParcelableFieldId == 12) {
            this.l = i;
        } else if (safeParcelableFieldId != 21) {
            switch (safeParcelableFieldId) {
                case 24:
                    this.v = i;
                    break;
                case 25:
                    this.w = i;
                    break;
                default:
                    StringBuilder sb = new StringBuilder(52);
                    sb.append("Field with id=");
                    sb.append(safeParcelableFieldId);
                    sb.append(" is not known to be an int.");
                    throw new IllegalArgumentException(sb.toString());
            }
        } else {
            this.s = i;
        }
        this.b.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void a(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        switch (safeParcelableFieldId) {
            case 2:
                this.d = str2;
                break;
            case 4:
                this.f = str2;
                break;
            case 5:
                this.g = str2;
                break;
            case 8:
                this.j = str2;
                break;
            case 9:
                this.k = str2;
                break;
            case 14:
                this.m = str2;
                break;
            case 18:
                this.p = str2;
                break;
            case 20:
                this.r = str2;
                break;
            case 26:
                this.x = str2;
                break;
            case 27:
                this.y = str2;
                break;
            default:
                StringBuilder sb = new StringBuilder(54);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be a String.");
                throw new IllegalArgumentException(sb.toString());
        }
        this.b.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected final void a(FastJsonResponse.Field<?, ?> field, String str, boolean z) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 16) {
            this.o = z;
        } else {
            if (safeParcelableFieldId != 29) {
                StringBuilder sb = new StringBuilder(55);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not known to be a boolean.");
                throw new IllegalArgumentException(sb.toString());
            }
            this.A = z;
        }
        this.b.add(Integer.valueOf(safeParcelableFieldId));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final boolean a(FastJsonResponse.Field field) {
        return this.b.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> field, String str, ArrayList<T> arrayList) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId != 28) {
            switch (safeParcelableFieldId) {
                case 22:
                    this.t = arrayList;
                    break;
                case 23:
                    this.u = arrayList;
                    break;
                default:
                    String canonicalName = arrayList.getClass().getCanonicalName();
                    StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 71);
                    sb.append("Field with id=");
                    sb.append(safeParcelableFieldId);
                    sb.append(" is not a known array of custom type.  Found ");
                    sb.append(canonicalName);
                    sb.append(".");
                    throw new IllegalArgumentException(sb.toString());
            }
        } else {
            this.z = arrayList;
        }
        this.b.add(Integer.valueOf(safeParcelableFieldId));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> field, String str, T t) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 3) {
            this.e = (zza) t;
        } else if (safeParcelableFieldId == 7) {
            this.i = (zzb) t;
        } else if (safeParcelableFieldId == 15) {
            this.n = (zzc) t;
        } else {
            if (safeParcelableFieldId != 19) {
                String canonicalName = t.getClass().getCanonicalName();
                StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 62);
                sb.append("Field with id=");
                sb.append(safeParcelableFieldId);
                sb.append(" is not a known custom type.  Found ");
                sb.append(canonicalName);
                sb.append(".");
                throw new IllegalArgumentException(sb.toString());
            }
            this.q = (zzd) t;
        }
        this.b.add(Integer.valueOf(safeParcelableFieldId));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final Object b(FastJsonResponse.Field field) {
        switch (field.getSafeParcelableFieldId()) {
            case 2:
                return this.d;
            case 3:
                return this.e;
            case 4:
                return this.f;
            case 5:
                return this.g;
            case 6:
                return Integer.valueOf(this.h);
            case 7:
                return this.i;
            case 8:
                return this.j;
            case 9:
                return this.k;
            case 10:
            case 11:
            case 13:
            case 17:
            default:
                int safeParcelableFieldId = field.getSafeParcelableFieldId();
                StringBuilder sb = new StringBuilder(38);
                sb.append("Unknown safe parcelable id=");
                sb.append(safeParcelableFieldId);
                throw new IllegalStateException(sb.toString());
            case 12:
                return Integer.valueOf(this.l);
            case 14:
                return this.m;
            case 15:
                return this.n;
            case 16:
                return Boolean.valueOf(this.o);
            case 18:
                return this.p;
            case 19:
                return this.q;
            case 20:
                return this.r;
            case 21:
                return Integer.valueOf(this.s);
            case 22:
                return this.t;
            case 23:
                return this.u;
            case 24:
                return Integer.valueOf(this.v);
            case 25:
                return Integer.valueOf(this.w);
            case 26:
                return this.x;
            case 27:
                return this.y;
            case 28:
                return this.z;
            case 29:
                return Boolean.valueOf(this.A);
        }
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final boolean equals(Object obj) {
        if (!(obj instanceof zzr)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzr zzrVar = (zzr) obj;
        for (FastJsonResponse.Field<?, ?> field : f4660a.values()) {
            if (a(field)) {
                if (!zzrVar.a(field) || !b(field).equals(zzrVar.b(field))) {
                    return false;
                }
            } else if (zzrVar.a(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ Person freeze() {
        return this;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getAboutMe() {
        return this.d;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final Person.AgeRange getAgeRange() {
        return this.e;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getBirthday() {
        return this.f;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getBraggingRights() {
        return this.g;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final int getCircledByCount() {
        return this.h;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final Person.Cover getCover() {
        return this.i;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getCurrentLocation() {
        return this.j;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getDisplayName() {
        return this.k;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public final /* synthetic */ Map getFieldMappings() {
        return f4660a;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final int getGender() {
        return this.l;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getId() {
        return this.m;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final Person.Image getImage() {
        return this.n;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getLanguage() {
        return this.p;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final Person.Name getName() {
        return this.q;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getNickname() {
        return this.r;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final int getObjectType() {
        return this.s;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final List<Person.Organizations> getOrganizations() {
        return (ArrayList) this.t;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final List<Person.PlacesLived> getPlacesLived() {
        return (ArrayList) this.u;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final int getPlusOneCount() {
        return this.v;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final int getRelationshipStatus() {
        return this.w;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getTagline() {
        return this.x;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final String getUrl() {
        return this.y;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final List<Person.Urls> getUrls() {
        return (ArrayList) this.z;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasAboutMe() {
        return this.b.contains(2);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasAgeRange() {
        return this.b.contains(3);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasBirthday() {
        return this.b.contains(4);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasBraggingRights() {
        return this.b.contains(5);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasCircledByCount() {
        return this.b.contains(6);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasCover() {
        return this.b.contains(7);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasCurrentLocation() {
        return this.b.contains(8);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasDisplayName() {
        return this.b.contains(9);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasGender() {
        return this.b.contains(12);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasId() {
        return this.b.contains(14);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasImage() {
        return this.b.contains(15);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasIsPlusUser() {
        return this.b.contains(16);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasLanguage() {
        return this.b.contains(18);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasName() {
        return this.b.contains(19);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasNickname() {
        return this.b.contains(20);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasObjectType() {
        return this.b.contains(21);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasOrganizations() {
        return this.b.contains(22);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasPlacesLived() {
        return this.b.contains(23);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasPlusOneCount() {
        return this.b.contains(24);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasRelationshipStatus() {
        return this.b.contains(25);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasTagline() {
        return this.b.contains(26);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasUrl() {
        return this.b.contains(27);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasUrls() {
        return this.b.contains(28);
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean hasVerified() {
        return this.b.contains(29);
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse
    public final int hashCode() {
        int i = 0;
        for (FastJsonResponse.Field<?, ?> field : f4660a.values()) {
            if (a(field)) {
                i = i + field.getSafeParcelableFieldId() + b(field).hashCode();
            }
        }
        return i;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean isPlusUser() {
        return this.o;
    }

    @Override // com.google.android.gms.plus.model.people.Person
    public final boolean isVerified() {
        return this.A;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> set = this.b;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.c);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeString(parcel, 2, this.d, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeParcelable(parcel, 3, this.e, i, true);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeString(parcel, 4, this.f, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.writeString(parcel, 5, this.g, true);
        }
        if (set.contains(6)) {
            SafeParcelWriter.writeInt(parcel, 6, this.h);
        }
        if (set.contains(7)) {
            SafeParcelWriter.writeParcelable(parcel, 7, this.i, i, true);
        }
        if (set.contains(8)) {
            SafeParcelWriter.writeString(parcel, 8, this.j, true);
        }
        if (set.contains(9)) {
            SafeParcelWriter.writeString(parcel, 9, this.k, true);
        }
        if (set.contains(12)) {
            SafeParcelWriter.writeInt(parcel, 12, this.l);
        }
        if (set.contains(14)) {
            SafeParcelWriter.writeString(parcel, 14, this.m, true);
        }
        if (set.contains(15)) {
            SafeParcelWriter.writeParcelable(parcel, 15, this.n, i, true);
        }
        if (set.contains(16)) {
            SafeParcelWriter.writeBoolean(parcel, 16, this.o);
        }
        if (set.contains(18)) {
            SafeParcelWriter.writeString(parcel, 18, this.p, true);
        }
        if (set.contains(19)) {
            SafeParcelWriter.writeParcelable(parcel, 19, this.q, i, true);
        }
        if (set.contains(20)) {
            SafeParcelWriter.writeString(parcel, 20, this.r, true);
        }
        if (set.contains(21)) {
            SafeParcelWriter.writeInt(parcel, 21, this.s);
        }
        if (set.contains(22)) {
            SafeParcelWriter.writeTypedList(parcel, 22, this.t, true);
        }
        if (set.contains(23)) {
            SafeParcelWriter.writeTypedList(parcel, 23, this.u, true);
        }
        if (set.contains(24)) {
            SafeParcelWriter.writeInt(parcel, 24, this.v);
        }
        if (set.contains(25)) {
            SafeParcelWriter.writeInt(parcel, 25, this.w);
        }
        if (set.contains(26)) {
            SafeParcelWriter.writeString(parcel, 26, this.x, true);
        }
        if (set.contains(27)) {
            SafeParcelWriter.writeString(parcel, 27, this.y, true);
        }
        if (set.contains(28)) {
            SafeParcelWriter.writeTypedList(parcel, 28, this.z, true);
        }
        if (set.contains(29)) {
            SafeParcelWriter.writeBoolean(parcel, 29, this.A);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
