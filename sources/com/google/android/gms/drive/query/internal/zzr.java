package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator = "LogicalFilterCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzr extends zza {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 1)
    private final zzx f1573a;

    @SafeParcelable.Field(id = 2)
    private final List<FilterHolder> b;
    private List<Filter> c;

    public zzr(zzx zzxVar, Filter filter, Filter... filterArr) {
        this.f1573a = zzxVar;
        this.b = new ArrayList(filterArr.length + 1);
        this.b.add(new FilterHolder(filter));
        this.c = new ArrayList(filterArr.length + 1);
        this.c.add(filter);
        for (Filter filter2 : filterArr) {
            this.b.add(new FilterHolder(filter2));
            this.c.add(filter2);
        }
    }

    public zzr(zzx zzxVar, Iterable<Filter> iterable) {
        this.f1573a = zzxVar;
        this.c = new ArrayList();
        this.b = new ArrayList();
        for (Filter filter : iterable) {
            this.c.add(filter);
            this.b.add(new FilterHolder(filter));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzr(@SafeParcelable.Param(id = 1) zzx zzxVar, @SafeParcelable.Param(id = 2) List<FilterHolder> list) {
        this.f1573a = zzxVar;
        this.b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f1573a, i, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public final <T> T zza(zzj<T> zzjVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<FilterHolder> it = this.b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getFilter().zza(zzjVar));
        }
        return zzjVar.zza(this.f1573a, arrayList);
    }
}
