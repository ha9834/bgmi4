package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.AbstractMessage;
import com.uqm.crashsight.protobuf.AbstractMessageLite;
import com.uqm.crashsight.protobuf.Descriptors;
import com.uqm.crashsight.protobuf.MapEntryLite;
import com.uqm.crashsight.protobuf.Message;
import com.uqm.crashsight.protobuf.MessageLite;
import com.uqm.crashsight.protobuf.WireFormat;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class MapEntry<K, V> extends AbstractMessage {
    private final K b;
    private final V c;
    private final a<K, V> d;
    private volatile int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a<K, V> extends MapEntryLite.a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Descriptors.Descriptor f6740a;
        public final Parser<MapEntry<K, V>> b;
    }

    /* synthetic */ MapEntry(a aVar, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b) throws InvalidProtocolBufferException {
        this(aVar, codedInputStream, extensionRegistryLite);
    }

    /* synthetic */ MapEntry(a aVar, Object obj, Object obj2, byte b) {
        this(aVar, obj, obj2);
    }

    static /* synthetic */ boolean a(a aVar, Object obj) {
        if (aVar.e.a() == WireFormat.JavaType.MESSAGE) {
            return ((MessageLite) obj).isInitialized();
        }
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
    /* renamed from: getDefaultInstanceForType */
    public final /* synthetic */ MessageLite r() {
        a<K, V> aVar = this.d;
        return new MapEntry(aVar, aVar.d, this.d.f);
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public final /* synthetic */ MessageLite.Builder newBuilderForType() {
        return new Builder(this.d, (byte) 0);
    }

    @Override // com.uqm.crashsight.protobuf.Message
    public final /* synthetic */ Message.Builder p() {
        return new Builder(this.d, this.b, this.c, true, true, (byte) 0);
    }

    @Override // com.uqm.crashsight.protobuf.Message
    public final /* synthetic */ Message.Builder q() {
        return new Builder(this.d, (byte) 0);
    }

    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    public final /* synthetic */ Message r() {
        a<K, V> aVar = this.d;
        return new MapEntry(aVar, aVar.d, this.d.f);
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public final /* synthetic */ MessageLite.Builder toBuilder() {
        return new Builder(this.d, this.b, this.c, true, true, (byte) 0);
    }

    private MapEntry(a aVar, K k, V v) {
        this.e = -1;
        this.b = k;
        this.c = v;
        this.d = aVar;
    }

    private MapEntry(a<K, V> aVar, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.e = -1;
        try {
            this.d = aVar;
            Map.Entry a2 = MapEntryLite.a(codedInputStream, aVar, extensionRegistryLite);
            this.b = (K) a2.getKey();
            this.c = (V) a2.getValue();
        } catch (InvalidProtocolBufferException e) {
            throw e.a(this);
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2).a(this);
        }
    }

    public final K c() {
        return this.b;
    }

    public final V e() {
        return this.c;
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
    public final int getSerializedSize() {
        if (this.e != -1) {
            return this.e;
        }
        int a2 = MapEntryLite.a(this.d, this.b, this.c);
        this.e = a2;
        return a2;
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
    public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        MapEntryLite.a(codedOutputStream, this.d, this.b, this.c);
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        a<K, V> aVar = this.d;
        V v = this.c;
        if (aVar.e.a() == WireFormat.JavaType.MESSAGE) {
            return ((MessageLite) v).isInitialized();
        }
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public final Parser<MapEntry<K, V>> getParserForType() {
        return this.d.b;
    }

    public final Builder<K, V> f() {
        return new Builder<>(this.d, (byte) 0);
    }

    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    public final Descriptors.Descriptor d() {
        return this.d.f6740a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    public final Map<Descriptors.FieldDescriptor, Object> b_() {
        TreeMap treeMap = new TreeMap();
        for (Descriptors.FieldDescriptor fieldDescriptor : this.d.f6740a.f()) {
            c(fieldDescriptor);
            treeMap.put(fieldDescriptor, b(fieldDescriptor));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    private void c(Descriptors.FieldDescriptor fieldDescriptor) {
        if (fieldDescriptor.t() == this.d.f6740a) {
            return;
        }
        throw new RuntimeException("Wrong FieldDescriptor \"" + fieldDescriptor.c() + "\" used in message \"" + this.d.f6740a.c());
    }

    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    public final boolean a(Descriptors.FieldDescriptor fieldDescriptor) {
        c(fieldDescriptor);
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    public final Object b(Descriptors.FieldDescriptor fieldDescriptor) {
        c(fieldDescriptor);
        Object obj = fieldDescriptor.e() == 1 ? this.b : this.c;
        return fieldDescriptor.h() == Descriptors.FieldDescriptor.Type.ENUM ? fieldDescriptor.x().c(((Integer) obj).intValue()) : obj;
    }

    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    public final UnknownFieldSet b() {
        return UnknownFieldSet.b();
    }

    /* loaded from: classes3.dex */
    public static class Builder<K, V> extends AbstractMessage.Builder<Builder<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private final a<K, V> f6739a;
        private K b;
        private V c;
        private boolean d;
        private boolean e;

        @Override // com.uqm.crashsight.protobuf.Message.Builder
        public final /* bridge */ /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
            return this;
        }

        /* synthetic */ Builder(a aVar, byte b) {
            this(aVar);
        }

        /* synthetic */ Builder(a aVar, Object obj, Object obj2, boolean z, boolean z2, byte b) {
            this(aVar, obj, obj2, true, true);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
        /* renamed from: a */
        public final /* synthetic */ AbstractMessage.Builder mo11clone() {
            return new Builder(this.f6739a, this.b, this.c, this.d, this.e);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
        /* renamed from: buildPartial */
        public /* synthetic */ MessageLite g() {
            return new MapEntry((a) this.f6739a, (Object) this.b, (Object) this.c, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.Message.Builder
        public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            throw new RuntimeException("There is no repeated field in a map entry message.");
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public /* synthetic */ AbstractMessageLite.Builder mo11clone() {
            return new Builder(this.f6739a, this.b, this.c, this.d, this.e);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public /* synthetic */ MessageLite.Builder mo11clone() {
            return new Builder(this.f6739a, this.b, this.c, this.d, this.e);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
            return new Builder(this.f6739a, this.b, this.c, this.d, this.e);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.uqm.crashsight.protobuf.Message.Builder
        public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            V v;
            d(fieldDescriptor);
            if (fieldDescriptor.e() == 1) {
                this.b = obj;
                this.d = true;
            } else {
                if (fieldDescriptor.h() == Descriptors.FieldDescriptor.Type.ENUM) {
                    v = (V) Integer.valueOf(((Descriptors.EnumValueDescriptor) obj).a());
                } else {
                    v = obj;
                    v = obj;
                    if (fieldDescriptor.h() == Descriptors.FieldDescriptor.Type.MESSAGE && obj != 0) {
                        boolean isInstance = this.f6739a.f.getClass().isInstance(obj);
                        v = obj;
                        if (!isInstance) {
                            v = (V) ((Message) this.f6739a.f).p().internalMergeFrom((Message) obj).h();
                        }
                    }
                }
                this.c = v;
                this.e = true;
            }
            return this;
        }

        @Override // com.uqm.crashsight.protobuf.Message.Builder
        public final /* synthetic */ Message g() {
            return new MapEntry((a) this.f6739a, (Object) this.b, (Object) this.c, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public /* synthetic */ MessageLite r() {
            a<K, V> aVar = this.f6739a;
            return new MapEntry((a) aVar, (Object) aVar.d, (Object) this.f6739a.f, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* synthetic */ Message r() {
            a<K, V> aVar = this.f6739a;
            return new MapEntry((a) aVar, (Object) aVar.d, (Object) this.f6739a.f, (byte) 0);
        }

        private Builder(a<K, V> aVar) {
            this(aVar, aVar.d, aVar.f, false, false);
        }

        private Builder(a<K, V> aVar, K k, V v, boolean z, boolean z2) {
            this.f6739a = aVar;
            this.b = k;
            this.c = v;
            this.d = z;
            this.e = z2;
        }

        public final Builder<K, V> a(K k) {
            this.b = k;
            this.d = true;
            return this;
        }

        public final Builder<K, V> b(V v) {
            this.c = v;
            this.e = true;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.uqm.crashsight.protobuf.Message.Builder
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public MapEntry<K, V> h() {
            MapEntry<K, V> mapEntry = new MapEntry<>((a) this.f6739a, (Object) this.b, (Object) this.c, (byte) 0);
            if (mapEntry.isInitialized()) {
                return mapEntry;
            }
            throw new UninitializedMessageException(MessageReflection.b(mapEntry));
        }

        public final MapEntry<K, V> c() {
            return new MapEntry<>((a) this.f6739a, (Object) this.b, (Object) this.c, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final Descriptors.Descriptor d() {
            return this.f6739a.f6740a;
        }

        private void d(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.t() == this.f6739a.f6740a) {
                return;
            }
            throw new RuntimeException("Wrong FieldDescriptor \"" + fieldDescriptor.c() + "\" used in message \"" + this.f6739a.f6740a.c());
        }

        @Override // com.uqm.crashsight.protobuf.Message.Builder
        public final Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor) {
            d(fieldDescriptor);
            if (fieldDescriptor.e() != 2 || fieldDescriptor.f() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                throw new RuntimeException("\"" + fieldDescriptor.c() + "\" is not a message value field.");
            }
            return ((Message) this.c).q();
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return MapEntry.a((a) this.f6739a, (Object) this.c);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final Map<Descriptors.FieldDescriptor, Object> b_() {
            TreeMap treeMap = new TreeMap();
            for (Descriptors.FieldDescriptor fieldDescriptor : this.f6739a.f6740a.f()) {
                d(fieldDescriptor);
                if (fieldDescriptor.e() == 1 ? this.d : this.e) {
                    treeMap.put(fieldDescriptor, b(fieldDescriptor));
                }
            }
            return Collections.unmodifiableMap(treeMap);
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final boolean a(Descriptors.FieldDescriptor fieldDescriptor) {
            d(fieldDescriptor);
            return fieldDescriptor.e() == 1 ? this.d : this.e;
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final Object b(Descriptors.FieldDescriptor fieldDescriptor) {
            d(fieldDescriptor);
            Object obj = fieldDescriptor.e() == 1 ? this.b : this.c;
            return fieldDescriptor.h() == Descriptors.FieldDescriptor.Type.ENUM ? fieldDescriptor.x().c(((Integer) obj).intValue()) : obj;
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return UnknownFieldSet.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a<K, V> g() {
        return this.d;
    }
}
