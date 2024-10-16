package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.MapEntryLite;
import java.util.Map;

/* loaded from: classes3.dex */
class w implements u {
    @Override // com.uqm.crashsight.protobuf.u
    public final Map<?, ?> a(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // com.uqm.crashsight.protobuf.u
    public final MapEntryLite.a<?, ?> f(Object obj) {
        return ((MapEntryLite) obj).a();
    }

    @Override // com.uqm.crashsight.protobuf.u
    public final Map<?, ?> b(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // com.uqm.crashsight.protobuf.u
    public final boolean c(Object obj) {
        return !((MapFieldLite) obj).d();
    }

    @Override // com.uqm.crashsight.protobuf.u
    public final Object d(Object obj) {
        ((MapFieldLite) obj).c();
        return obj;
    }

    @Override // com.uqm.crashsight.protobuf.u
    public final Object e(Object obj) {
        return MapFieldLite.a().b();
    }

    @Override // com.uqm.crashsight.protobuf.u
    public final Object a(Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        MapFieldLite mapFieldLite2 = (MapFieldLite) obj2;
        if (!mapFieldLite2.isEmpty()) {
            if (!mapFieldLite.d()) {
                mapFieldLite = mapFieldLite.b();
            }
            mapFieldLite.a(mapFieldLite2);
        }
        return mapFieldLite;
    }

    @Override // com.uqm.crashsight.protobuf.u
    public final int a(int i, Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        MapEntryLite mapEntryLite = (MapEntryLite) obj2;
        int i2 = 0;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : mapFieldLite.entrySet()) {
            i2 += mapEntryLite.a(i, (int) entry.getKey(), entry.getValue());
        }
        return i2;
    }
}
