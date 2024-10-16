package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.MapEntryLite;
import java.util.Map;

/* loaded from: classes3.dex */
class v implements u {
    v() {
    }

    @Override // com.uqm.crashsight.protobuf.u
    public final Map<?, ?> a(Object obj) {
        return ((MapField) obj).b();
    }

    @Override // com.uqm.crashsight.protobuf.u
    public final Map<?, ?> b(Object obj) {
        return ((MapField) obj).a();
    }

    @Override // com.uqm.crashsight.protobuf.u
    public final boolean c(Object obj) {
        return !((MapField) obj).h();
    }

    @Override // com.uqm.crashsight.protobuf.u
    public final Object d(Object obj) {
        ((MapField) obj).g();
        return obj;
    }

    @Override // com.uqm.crashsight.protobuf.u
    public final Object e(Object obj) {
        return MapField.a((MapEntry) obj);
    }

    @Override // com.uqm.crashsight.protobuf.u
    public final MapEntryLite.a<?, ?> f(Object obj) {
        return ((MapEntry) obj).g();
    }

    @Override // com.uqm.crashsight.protobuf.u
    public final Object a(Object obj, Object obj2) {
        MapField mapField = (MapField) obj;
        MapField mapField2 = (MapField) obj2;
        if (!mapField.h()) {
            mapField.c();
        }
        mapField.a(mapField2);
        return mapField;
    }

    @Override // com.uqm.crashsight.protobuf.u
    public final int a(int i, Object obj, Object obj2) {
        int i2 = 0;
        if (obj == null) {
            return 0;
        }
        Map a2 = ((MapField) obj).a();
        MapEntry mapEntry = (MapEntry) obj2;
        if (a2.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : a2.entrySet()) {
            i2 += CodedOutputStream.h(i) + CodedOutputStream.m(MapEntryLite.a(mapEntry.g(), entry.getKey(), entry.getValue()));
        }
        return i2;
    }
}
