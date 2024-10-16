package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.MessageLite;
import com.uqm.crashsight.protobuf.WireFormat;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class MapEntryLite<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final a<K, V> f6741a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a<K, V> {
        public final WireFormat.FieldType c;
        public final K d;
        public final WireFormat.FieldType e;
        public final V f;

        public a(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
            this.c = fieldType;
            this.d = k;
            this.e = fieldType2;
            this.f = v;
        }
    }

    private MapEntryLite(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
        this.f6741a = new a<>(fieldType, k, fieldType2, v);
    }

    public static <K, V> MapEntryLite<K, V> a(WireFormat.FieldType fieldType, K k, WireFormat.FieldType fieldType2, V v) {
        return new MapEntryLite<>(fieldType, k, fieldType2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void a(CodedOutputStream codedOutputStream, a<K, V> aVar, K k, V v) throws IOException {
        FieldSet.a(codedOutputStream, aVar.c, 1, k);
        FieldSet.a(codedOutputStream, aVar.e, 2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int a(a<K, V> aVar, K k, V v) {
        return FieldSet.a(aVar.c, 1, k) + FieldSet.a(aVar.e, 2, v);
    }

    private static <T> T a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, WireFormat.FieldType fieldType, T t) throws IOException {
        switch (fieldType) {
            case WireFormat.FieldType.k:
                MessageLite.Builder builder = ((MessageLite) t).toBuilder();
                codedInputStream.a(builder, extensionRegistryLite);
                return (T) builder.g();
            case WireFormat.FieldType.n:
                return (T) Integer.valueOf(codedInputStream.n());
            case WireFormat.FieldType.j:
                throw new RuntimeException("Groups are not allowed in maps.");
            default:
                return (T) FieldSet.a(codedInputStream, fieldType, true);
        }
    }

    public final int a(int i, K k, V v) {
        int h = CodedOutputStream.h(i);
        a<K, V> aVar = this.f6741a;
        return h + CodedOutputStream.m(FieldSet.a(aVar.c, 1, k) + FieldSet.a(aVar.e, 2, v));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map.Entry<K, V> a(CodedInputStream codedInputStream, a<K, V> aVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        Object obj = aVar.d;
        Object obj2 = aVar.f;
        while (true) {
            int a2 = codedInputStream.a();
            if (a2 != 0) {
                if (a2 == WireFormat.a(1, aVar.c.b())) {
                    obj = a(codedInputStream, extensionRegistryLite, aVar.c, obj);
                } else if (a2 == WireFormat.a(2, aVar.e.b())) {
                    obj2 = a(codedInputStream, extensionRegistryLite, aVar.e, obj2);
                } else if (!codedInputStream.b(a2)) {
                    break;
                }
            } else {
                break;
            }
        }
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a<K, V> a() {
        return this.f6741a;
    }
}
