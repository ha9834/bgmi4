package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.ByteString;
import com.uqm.crashsight.protobuf.MessageLite;
import com.uqm.crashsight.protobuf.Writer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class UnknownFieldSet implements MessageLite {

    /* renamed from: a, reason: collision with root package name */
    private static final UnknownFieldSet f6770a = new UnknownFieldSet(Collections.emptyMap(), Collections.emptyMap());
    private static final Parser d = new Parser();
    private final Map<Integer, Field> b;
    private final Map<Integer, Field> c;

    @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
    /* renamed from: getDefaultInstanceForType */
    public final /* bridge */ /* synthetic */ MessageLite r() {
        return f6770a;
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public final /* bridge */ /* synthetic */ com.uqm.crashsight.protobuf.Parser getParserForType() {
        return d;
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public final /* synthetic */ MessageLite.Builder newBuilderForType() {
        return Builder.c();
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public final /* synthetic */ MessageLite.Builder toBuilder() {
        return Builder.c().a(this);
    }

    private UnknownFieldSet() {
        this.b = null;
        this.c = null;
    }

    public static Builder a() {
        return Builder.c();
    }

    public static Builder a(UnknownFieldSet unknownFieldSet) {
        return Builder.c().a(unknownFieldSet);
    }

    public static UnknownFieldSet b() {
        return f6770a;
    }

    UnknownFieldSet(Map<Integer, Field> map, Map<Integer, Field> map2) {
        this.b = map;
        this.c = map2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UnknownFieldSet) && this.b.equals(((UnknownFieldSet) obj).b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final Map<Integer, Field> c() {
        return this.b;
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        for (Map.Entry<Integer, Field> entry : this.b.entrySet()) {
            entry.getValue().a(entry.getKey().intValue(), codedOutputStream);
        }
    }

    public final String toString() {
        return TextFormat.a().a(this);
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public final ByteString toByteString() {
        try {
            ByteString.d c = ByteString.c(getSerializedSize());
            writeTo(c.b());
            return c.a();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
        }
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public final int getSerializedSize() {
        int i = 0;
        for (Map.Entry<Integer, Field> entry : this.b.entrySet()) {
            i += entry.getValue().a(entry.getKey().intValue());
        }
        return i;
    }

    public final void a(CodedOutputStream codedOutputStream) throws IOException {
        for (Map.Entry<Integer, Field> entry : this.b.entrySet()) {
            entry.getValue().b(entry.getKey().intValue(), codedOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Writer writer) throws IOException {
        if (writer.a() == Writer.FieldOrder.DESCENDING) {
            for (Map.Entry<Integer, Field> entry : this.c.entrySet()) {
                entry.getValue().a(entry.getKey().intValue(), writer);
            }
            return;
        }
        for (Map.Entry<Integer, Field> entry2 : this.b.entrySet()) {
            entry2.getValue().a(entry2.getKey().intValue(), writer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Writer writer) throws IOException {
        if (writer.a() == Writer.FieldOrder.DESCENDING) {
            for (Map.Entry<Integer, Field> entry : this.c.entrySet()) {
                Field.a(entry.getValue(), entry.getKey().intValue(), writer);
            }
            return;
        }
        for (Map.Entry<Integer, Field> entry2 : this.b.entrySet()) {
            Field.a(entry2.getValue(), entry2.getKey().intValue(), writer);
        }
    }

    public final int d() {
        int i = 0;
        for (Map.Entry<Integer, Field> entry : this.b.entrySet()) {
            i += entry.getValue().b(entry.getKey().intValue());
        }
        return i;
    }

    public static UnknownFieldSet a(ByteString byteString) throws InvalidProtocolBufferException {
        return Builder.c().a(byteString).build();
    }

    public final Builder e() {
        return Builder.c().a(this);
    }

    /* loaded from: classes3.dex */
    public static final class Builder implements MessageLite.Builder {

        /* renamed from: a, reason: collision with root package name */
        private Map<Integer, Field> f6771a;
        private int b;
        private Field.Builder c;

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        static /* synthetic */ Builder c() {
            Builder builder = new Builder();
            builder.f6771a = Collections.emptyMap();
            builder.b = 0;
            builder.c = null;
            return builder;
        }

        public final /* synthetic */ Object clone() throws CloneNotSupportedException {
            a(0);
            return UnknownFieldSet.a().a(new UnknownFieldSet(this.f6771a, Collections.unmodifiableMap(((TreeMap) this.f6771a).descendingMap())));
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* synthetic */ MessageLite r() {
            return UnknownFieldSet.b();
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
        public final /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int a2;
            do {
                a2 = codedInputStream.a();
                if (a2 == 0) {
                    break;
                }
            } while (a(a2, codedInputStream));
            return this;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
        public final /* synthetic */ MessageLite.Builder mergeFrom(MessageLite messageLite) {
            if (messageLite instanceof UnknownFieldSet) {
                return a((UnknownFieldSet) messageLite);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }

        private Builder() {
        }

        private Field.Builder a(int i) {
            Field.Builder builder = this.c;
            if (builder != null) {
                int i2 = this.b;
                if (i == i2) {
                    return builder;
                }
                b(i2, builder.a());
            }
            if (i == 0) {
                return null;
            }
            Field field = this.f6771a.get(Integer.valueOf(i));
            this.b = i;
            this.c = Field.a();
            if (field != null) {
                this.c.a(field);
            }
            return this.c;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final UnknownFieldSet g() {
            UnknownFieldSet unknownFieldSet;
            a(0);
            if (this.f6771a.isEmpty()) {
                unknownFieldSet = UnknownFieldSet.b();
            } else {
                unknownFieldSet = new UnknownFieldSet(Collections.unmodifiableMap(this.f6771a), Collections.unmodifiableMap(((TreeMap) this.f6771a).descendingMap()));
            }
            this.f6771a = null;
            return unknownFieldSet;
        }

        public final UnknownFieldSet b() {
            return build();
        }

        public final Builder a(UnknownFieldSet unknownFieldSet) {
            if (unknownFieldSet != UnknownFieldSet.b()) {
                for (Map.Entry entry : unknownFieldSet.b.entrySet()) {
                    a(((Integer) entry.getKey()).intValue(), (Field) entry.getValue());
                }
            }
            return this;
        }

        public final Builder a(int i, Field field) {
            if (i == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            if (i != 0) {
                if (i == this.b || this.f6771a.containsKey(Integer.valueOf(i))) {
                    a(i).a(field);
                } else {
                    b(i, field);
                }
                return this;
            }
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }

        public final Builder a(int i, int i2) {
            if (i == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            a(i).a(i2);
            return this;
        }

        private Builder b(int i, Field field) {
            if (i == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            if (this.c != null && this.b == i) {
                this.c = null;
                this.b = 0;
            }
            if (this.f6771a.isEmpty()) {
                this.f6771a = new TreeMap();
            }
            this.f6771a.put(Integer.valueOf(i), field);
            return this;
        }

        public final Builder a(CodedInputStream codedInputStream) throws IOException {
            int a2;
            do {
                a2 = codedInputStream.a();
                if (a2 == 0) {
                    break;
                }
            } while (a(a2, codedInputStream));
            return this;
        }

        public final boolean a(int i, CodedInputStream codedInputStream) throws IOException {
            int b = WireFormat.b(i);
            switch (WireFormat.a(i)) {
                case 0:
                    a(b).a(codedInputStream.e());
                    return true;
                case 1:
                    a(b).b(codedInputStream.g());
                    return true;
                case 2:
                    a(b).a(codedInputStream.l());
                    return true;
                case 3:
                    Builder a2 = UnknownFieldSet.a();
                    codedInputStream.a(b, a2, ExtensionRegistry.a());
                    a(b).a(a2.build());
                    return true;
                case 4:
                    return false;
                case 5:
                    a(b).a(codedInputStream.h());
                    return true;
                default:
                    throw InvalidProtocolBufferException.h();
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Builder a(ByteString byteString) throws InvalidProtocolBufferException {
            int a2;
            try {
                CodedInputStream h = byteString.h();
                do {
                    a2 = h.a();
                    if (a2 == 0) {
                        break;
                    }
                } while (a(a2, h));
                h.a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class Field {

        /* renamed from: a, reason: collision with root package name */
        private List<Long> f6772a;
        private List<Integer> b;
        private List<Long> c;
        private List<ByteString> d;
        private List<UnknownFieldSet> e;

        /* synthetic */ Field(byte b) {
            this();
        }

        static /* synthetic */ void a(Field field, int i, Writer writer) throws IOException {
            if (writer.a() != Writer.FieldOrder.DESCENDING) {
                Iterator<ByteString> it = field.d.iterator();
                while (it.hasNext()) {
                    writer.c(i, it.next());
                }
            } else {
                List<ByteString> list = field.d;
                ListIterator<ByteString> listIterator = list.listIterator(list.size());
                while (listIterator.hasPrevious()) {
                    writer.c(i, listIterator.previous());
                }
            }
        }

        private Field() {
        }

        public static Builder a() {
            return Builder.b();
        }

        static {
            Builder.b().a();
        }

        public final List<Long> b() {
            return this.f6772a;
        }

        public final List<Integer> c() {
            return this.b;
        }

        public final List<Long> d() {
            return this.c;
        }

        public final List<ByteString> e() {
            return this.d;
        }

        public final List<UnknownFieldSet> f() {
            return this.e;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Field) {
                return Arrays.equals(g(), ((Field) obj).g());
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(g());
        }

        private Object[] g() {
            return new Object[]{this.f6772a, this.b, this.c, this.d, this.e};
        }

        public final void a(int i, CodedOutputStream codedOutputStream) throws IOException {
            Iterator<Long> it = this.f6772a.iterator();
            while (it.hasNext()) {
                codedOutputStream.b(i, it.next().longValue());
            }
            Iterator<Integer> it2 = this.b.iterator();
            while (it2.hasNext()) {
                codedOutputStream.e(i, it2.next().intValue());
            }
            Iterator<Long> it3 = this.c.iterator();
            while (it3.hasNext()) {
                codedOutputStream.d(i, it3.next().longValue());
            }
            Iterator<ByteString> it4 = this.d.iterator();
            while (it4.hasNext()) {
                codedOutputStream.a(i, it4.next());
            }
            Iterator<UnknownFieldSet> it5 = this.e.iterator();
            while (it5.hasNext()) {
                codedOutputStream.e(i, it5.next());
            }
        }

        public final int a(int i) {
            Iterator<Long> it = this.f6772a.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2 += CodedOutputStream.g(i, it.next().longValue());
            }
            Iterator<Integer> it2 = this.b.iterator();
            while (it2.hasNext()) {
                i2 += CodedOutputStream.k(i, it2.next().intValue());
            }
            Iterator<Long> it3 = this.c.iterator();
            while (it3.hasNext()) {
                i2 += CodedOutputStream.i(i, it3.next().longValue());
            }
            Iterator<ByteString> it4 = this.d.iterator();
            while (it4.hasNext()) {
                i2 += CodedOutputStream.c(i, it4.next());
            }
            Iterator<UnknownFieldSet> it5 = this.e.iterator();
            while (it5.hasNext()) {
                i2 += CodedOutputStream.f(i, it5.next());
            }
            return i2;
        }

        public final void b(int i, CodedOutputStream codedOutputStream) throws IOException {
            Iterator<ByteString> it = this.d.iterator();
            while (it.hasNext()) {
                codedOutputStream.b(i, it.next());
            }
        }

        final void a(int i, Writer writer) throws IOException {
            writer.c(i, this.f6772a, false);
            writer.b(i, this.b, false);
            writer.e(i, this.c, false);
            writer.b(i, this.d);
            if (writer.a() == Writer.FieldOrder.ASCENDING) {
                for (int i2 = 0; i2 < this.e.size(); i2++) {
                    writer.a(i);
                    this.e.get(i2).a(writer);
                    writer.b(i);
                }
                return;
            }
            for (int size = this.e.size() - 1; size >= 0; size--) {
                writer.b(i);
                this.e.get(size).a(writer);
                writer.a(i);
            }
        }

        public final int b(int i) {
            Iterator<ByteString> it = this.d.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2 += CodedOutputStream.d(i, it.next());
            }
            return i2;
        }

        /* loaded from: classes3.dex */
        public static final class Builder {

            /* renamed from: a, reason: collision with root package name */
            private Field f6773a;

            static /* synthetic */ Builder b() {
                Builder builder = new Builder();
                builder.f6773a = new Field((byte) 0);
                return builder;
            }

            private Builder() {
            }

            public final Field a() {
                if (this.f6773a.f6772a == null) {
                    this.f6773a.f6772a = Collections.emptyList();
                } else {
                    Field field = this.f6773a;
                    field.f6772a = Collections.unmodifiableList(field.f6772a);
                }
                if (this.f6773a.b == null) {
                    this.f6773a.b = Collections.emptyList();
                } else {
                    Field field2 = this.f6773a;
                    field2.b = Collections.unmodifiableList(field2.b);
                }
                if (this.f6773a.c == null) {
                    this.f6773a.c = Collections.emptyList();
                } else {
                    Field field3 = this.f6773a;
                    field3.c = Collections.unmodifiableList(field3.c);
                }
                if (this.f6773a.d == null) {
                    this.f6773a.d = Collections.emptyList();
                } else {
                    Field field4 = this.f6773a;
                    field4.d = Collections.unmodifiableList(field4.d);
                }
                if (this.f6773a.e == null) {
                    this.f6773a.e = Collections.emptyList();
                } else {
                    Field field5 = this.f6773a;
                    field5.e = Collections.unmodifiableList(field5.e);
                }
                Field field6 = this.f6773a;
                this.f6773a = null;
                return field6;
            }

            public final Builder a(Field field) {
                if (!field.f6772a.isEmpty()) {
                    if (this.f6773a.f6772a == null) {
                        this.f6773a.f6772a = new ArrayList();
                    }
                    this.f6773a.f6772a.addAll(field.f6772a);
                }
                if (!field.b.isEmpty()) {
                    if (this.f6773a.b == null) {
                        this.f6773a.b = new ArrayList();
                    }
                    this.f6773a.b.addAll(field.b);
                }
                if (!field.c.isEmpty()) {
                    if (this.f6773a.c == null) {
                        this.f6773a.c = new ArrayList();
                    }
                    this.f6773a.c.addAll(field.c);
                }
                if (!field.d.isEmpty()) {
                    if (this.f6773a.d == null) {
                        this.f6773a.d = new ArrayList();
                    }
                    this.f6773a.d.addAll(field.d);
                }
                if (!field.e.isEmpty()) {
                    if (this.f6773a.e == null) {
                        this.f6773a.e = new ArrayList();
                    }
                    this.f6773a.e.addAll(field.e);
                }
                return this;
            }

            public final Builder a(long j) {
                if (this.f6773a.f6772a == null) {
                    this.f6773a.f6772a = new ArrayList();
                }
                this.f6773a.f6772a.add(Long.valueOf(j));
                return this;
            }

            public final Builder a(int i) {
                if (this.f6773a.b == null) {
                    this.f6773a.b = new ArrayList();
                }
                this.f6773a.b.add(Integer.valueOf(i));
                return this;
            }

            public final Builder b(long j) {
                if (this.f6773a.c == null) {
                    this.f6773a.c = new ArrayList();
                }
                this.f6773a.c.add(Long.valueOf(j));
                return this;
            }

            public final Builder a(ByteString byteString) {
                if (this.f6773a.d == null) {
                    this.f6773a.d = new ArrayList();
                }
                this.f6773a.d.add(byteString);
                return this;
            }

            public final Builder a(UnknownFieldSet unknownFieldSet) {
                if (this.f6773a.e == null) {
                    this.f6773a.e = new ArrayList();
                }
                this.f6773a.e.add(unknownFieldSet);
                return this;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class Parser extends AbstractParser<UnknownFieldSet> {
        @Override // com.uqm.crashsight.protobuf.Parser
        public final /* bridge */ /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return a(codedInputStream);
        }

        private static UnknownFieldSet a(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
            Builder a2 = UnknownFieldSet.a();
            try {
                a2.a(codedInputStream);
                return a2.b();
            } catch (InvalidProtocolBufferException e) {
                throw e.a(a2.b());
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2).a(a2.b());
            }
        }
    }
}
