package com.uqm.crashsight.protobuf;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.uqm.crashsight.protobuf.AbstractMessage;
import com.uqm.crashsight.protobuf.Descriptors;
import com.uqm.crashsight.protobuf.FieldSet;
import com.uqm.crashsight.protobuf.Internal;
import com.uqm.crashsight.protobuf.LazyField;
import com.uqm.crashsight.protobuf.Message;
import com.uqm.crashsight.protobuf.MessageReflection;
import com.uqm.crashsight.protobuf.UnknownFieldSet;
import com.uqm.crashsight.protobuf.WireFormat;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public abstract class GeneratedMessageV3 extends AbstractMessage implements Serializable {
    protected static boolean c;
    protected UnknownFieldSet d;

    /* loaded from: classes3.dex */
    public interface BuilderParent extends AbstractMessage.BuilderParent {
    }

    /* loaded from: classes3.dex */
    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageOrBuilder {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P() {
    }

    protected abstract Message.Builder a(BuilderParent builderParent);

    protected abstract FieldAccessorTable c();

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneratedMessageV3() {
        this.d = UnknownFieldSet.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneratedMessageV3(Builder<?> builder) {
        this.d = builder.b();
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public Parser<? extends GeneratedMessageV3> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    public final Descriptors.Descriptor d() {
        return c().f6718a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Descriptors.FieldDescriptor, Object> a(boolean z) {
        TreeMap treeMap = new TreeMap();
        List<Descriptors.FieldDescriptor> f = c().f6718a.f();
        int i = 0;
        while (i < f.size()) {
            Descriptors.FieldDescriptor fieldDescriptor = f.get(i);
            Descriptors.OneofDescriptor u = fieldDescriptor.u();
            if (u != null) {
                i += u.f() - 1;
                if (FieldAccessorTable.a(c(), u).a(this)) {
                    fieldDescriptor = FieldAccessorTable.a(c(), u).b(this);
                    if (!z && fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.STRING) {
                        treeMap.put(fieldDescriptor, FieldAccessorTable.a(c(), fieldDescriptor).b(this));
                    } else {
                        treeMap.put(fieldDescriptor, b(fieldDescriptor));
                    }
                    i++;
                } else {
                    i++;
                }
            } else {
                if (fieldDescriptor.o()) {
                    List list = (List) b(fieldDescriptor);
                    if (!list.isEmpty()) {
                        treeMap.put(fieldDescriptor, list);
                    }
                } else {
                    if (!a(fieldDescriptor)) {
                    }
                    if (!z) {
                    }
                    treeMap.put(fieldDescriptor, b(fieldDescriptor));
                }
                i++;
            }
        }
        return treeMap;
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        for (Descriptors.FieldDescriptor fieldDescriptor : c().f6718a.f()) {
            if (fieldDescriptor.m() && !a(fieldDescriptor)) {
                return false;
            }
            if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (fieldDescriptor.o()) {
                    Iterator it = ((List) b(fieldDescriptor)).iterator();
                    while (it.hasNext()) {
                        if (!((Message) it.next()).isInitialized()) {
                            return false;
                        }
                    }
                } else if (a(fieldDescriptor) && !((Message) b(fieldDescriptor)).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> b_() {
        return Collections.unmodifiableMap(a(false));
    }

    Map<Descriptors.FieldDescriptor, Object> N() {
        return Collections.unmodifiableMap(a(true));
    }

    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    public boolean a(Descriptors.FieldDescriptor fieldDescriptor) {
        return FieldAccessorTable.a(c(), fieldDescriptor).c(this);
    }

    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    public Object b(Descriptors.FieldDescriptor fieldDescriptor) {
        return FieldAccessorTable.a(c(), fieldDescriptor).a(this);
    }

    public UnknownFieldSet b() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
        if (codedInputStream.v()) {
            return codedInputStream.b(i);
        }
        return builder.a(i, codedInputStream);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Internal.IntList O() {
        return q.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Internal.IntList a(Internal.IntList intList) {
        int size = intList.size();
        return intList.c(size == 0 ? 10 : size << 1);
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        MessageReflection.a(this, N(), codedOutputStream, false);
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f6632a;
        if (i != -1) {
            return i;
        }
        this.f6632a = MessageReflection.a(this, N());
        return this.f6632a;
    }

    /* loaded from: classes3.dex */
    public static final class UnusedPrivateParameter {

        /* renamed from: a, reason: collision with root package name */
        static final UnusedPrivateParameter f6725a = new UnusedPrivateParameter();

        private UnusedPrivateParameter() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object a() {
        throw new UnsupportedOperationException("This method must be overridden by the subclass.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.uqm.crashsight.protobuf.AbstractMessage
    public final Message.Builder a(final AbstractMessage.BuilderParent builderParent) {
        return a(new BuilderParent(this) { // from class: com.uqm.crashsight.protobuf.GeneratedMessageV3.1
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.BuilderParent
            public final void a() {
                builderParent.a();
            }
        });
    }

    /* loaded from: classes3.dex */
    public static abstract class Builder<BuilderType extends Builder<BuilderType>> extends AbstractMessage.Builder<BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        private BuilderParent f6715a;
        private boolean b;
        private UnknownFieldSet c;

        protected abstract FieldAccessorTable c();

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder() {
            this(null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder(BuilderParent builderParent) {
            this.c = UnknownFieldSet.b();
            this.f6715a = builderParent;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void i() {
            if (this.f6715a != null) {
                this.b = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
        public final void a_() {
            this.b = true;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public BuilderType mo11clone() {
            BuilderType buildertype = (BuilderType) r().q();
            buildertype.internalMergeFrom(g());
            return buildertype;
        }

        public Descriptors.Descriptor d() {
            return c().f6718a;
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> b_() {
            return Collections.unmodifiableMap(e());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<Descriptors.FieldDescriptor, Object> e() {
            TreeMap treeMap = new TreeMap();
            List<Descriptors.FieldDescriptor> f = c().f6718a.f();
            int i = 0;
            while (i < f.size()) {
                Descriptors.FieldDescriptor fieldDescriptor = f.get(i);
                Descriptors.OneofDescriptor u = fieldDescriptor.u();
                if (u != null) {
                    i += u.f() - 1;
                    if (FieldAccessorTable.a(c(), u).a(this)) {
                        fieldDescriptor = FieldAccessorTable.a(c(), u).b(this);
                        treeMap.put(fieldDescriptor, b(fieldDescriptor));
                        i++;
                    } else {
                        i++;
                    }
                } else {
                    if (fieldDescriptor.o()) {
                        List list = (List) b(fieldDescriptor);
                        if (!list.isEmpty()) {
                            treeMap.put(fieldDescriptor, list);
                        }
                    } else {
                        if (!a(fieldDescriptor)) {
                        }
                        treeMap.put(fieldDescriptor, b(fieldDescriptor));
                    }
                    i++;
                }
            }
            return treeMap;
        }

        @Override // com.uqm.crashsight.protobuf.Message.Builder
        public Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor) {
            return FieldAccessorTable.a(c(), fieldDescriptor).a();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public boolean a(Descriptors.FieldDescriptor fieldDescriptor) {
            return FieldAccessorTable.a(c(), fieldDescriptor).b(this);
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public Object b(Descriptors.FieldDescriptor fieldDescriptor) {
            Object a2 = FieldAccessorTable.a(c(), fieldDescriptor).a(this);
            return fieldDescriptor.o() ? Collections.unmodifiableList((List) a2) : a2;
        }

        @Override // com.uqm.crashsight.protobuf.Message.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BuilderType d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            FieldAccessorTable.a(c(), fieldDescriptor).a(this, obj);
            return this;
        }

        @Override // com.uqm.crashsight.protobuf.Message.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BuilderType c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            FieldAccessorTable.a(c(), fieldDescriptor).b(this, obj);
            return this;
        }

        @Override // com.uqm.crashsight.protobuf.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public BuilderType d(UnknownFieldSet unknownFieldSet) {
            BuilderParent builderParent;
            this.c = unknownFieldSet;
            if (this.b && (builderParent = this.f6715a) != null) {
                builderParent.a();
                this.b = false;
            }
            return this;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public BuilderType a(UnknownFieldSet unknownFieldSet) {
            return d(UnknownFieldSet.a(this.c).a(unknownFieldSet).build());
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            for (Descriptors.FieldDescriptor fieldDescriptor : d().f()) {
                if (fieldDescriptor.m() && !a(fieldDescriptor)) {
                    return false;
                }
                if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    if (fieldDescriptor.o()) {
                        Iterator it = ((List) b(fieldDescriptor)).iterator();
                        while (it.hasNext()) {
                            if (!((Message) it.next()).isInitialized()) {
                                return false;
                            }
                        }
                    } else if (a(fieldDescriptor) && !((Message) b(fieldDescriptor)).isInitialized()) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void j() {
            BuilderParent builderParent;
            if (!this.b || (builderParent = this.f6715a) == null) {
                return;
            }
            builderParent.a();
            this.b = false;
        }

        protected final MapField k() {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }

        protected final MapField l() {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage> extends GeneratedMessageV3 implements ExtendableMessageOrBuilder<MessageType> {
        private final FieldSet<Descriptors.FieldDescriptor> b;

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableMessage() {
            this.b = FieldSet.a();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableMessage(ExtendableBuilder<MessageType, ?> extendableBuilder) {
            super(extendableBuilder);
            this.b = ExtendableBuilder.a((ExtendableBuilder) extendableBuilder);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final boolean R() {
            return this.b.k();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return super.isInitialized() && this.b.k();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        public final boolean a(CodedInputStream codedInputStream, UnknownFieldSet.Builder builder, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            if (codedInputStream.v()) {
                builder = null;
            }
            return MessageReflection.a(codedInputStream, builder, extensionRegistryLite, d(), new MessageReflection.b(this.b), i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        public final void P() {
            this.b.e();
        }

        /* loaded from: classes3.dex */
        public class ExtensionWriter {

            /* renamed from: a, reason: collision with root package name */
            private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> f6717a;
            private Map.Entry<Descriptors.FieldDescriptor, Object> b;
            private final boolean c;

            /* JADX INFO: Access modifiers changed from: package-private */
            public /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z, byte b) {
                this(false);
            }

            private ExtensionWriter(boolean z) {
                this.f6717a = ExtendableMessage.this.b.i();
                if (this.f6717a.hasNext()) {
                    this.b = this.f6717a.next();
                }
                this.c = z;
            }

            public final void a(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<Descriptors.FieldDescriptor, Object> entry = this.b;
                    if (entry == null || entry.getKey().e() >= 536870912) {
                        return;
                    }
                    Descriptors.FieldDescriptor key = this.b.getKey();
                    if (this.c && key.g() == WireFormat.JavaType.MESSAGE && !key.o()) {
                        if (this.b instanceof LazyField.a) {
                            codedOutputStream.b(key.e(), ((LazyField.a) this.b).a().c());
                        } else {
                            codedOutputStream.b(key.e(), (Message) this.b.getValue());
                        }
                    } else {
                        FieldSet.a(key, this.b.getValue(), codedOutputStream);
                    }
                    if (this.f6717a.hasNext()) {
                        this.b = this.f6717a.next();
                    } else {
                        this.b = null;
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final int S() {
            return this.b.l();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final Map<Descriptors.FieldDescriptor, Object> T() {
            return this.b.h();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final Map<Descriptors.FieldDescriptor, Object> b_() {
            Map a2 = a(false);
            a2.putAll(this.b.h());
            return Collections.unmodifiableMap(a2);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        public final Map<Descriptors.FieldDescriptor, Object> N() {
            Map a2 = a(false);
            a2.putAll(this.b.h());
            return Collections.unmodifiableMap(a2);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final boolean a(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.s()) {
                if (fieldDescriptor.t() != d()) {
                    throw new IllegalArgumentException("FieldDescriptor does not match message type.");
                }
                return this.b.a((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor);
            }
            return super.a(fieldDescriptor);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final Object b(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.s()) {
                if (fieldDescriptor.t() != d()) {
                    throw new IllegalArgumentException("FieldDescriptor does not match message type.");
                }
                Object b = this.b.b((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor);
                if (b != null) {
                    return b;
                }
                if (fieldDescriptor.o()) {
                    return Collections.emptyList();
                }
                if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    return DynamicMessage.a(fieldDescriptor.w());
                }
                return fieldDescriptor.r();
            }
            return super.b(fieldDescriptor);
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<BuilderType> implements ExtendableMessageOrBuilder<MessageType> {

        /* renamed from: a, reason: collision with root package name */
        private FieldSet.a<Descriptors.FieldDescriptor> f6716a;

        static /* synthetic */ FieldSet a(ExtendableBuilder extendableBuilder) {
            FieldSet.a<Descriptors.FieldDescriptor> aVar = extendableBuilder.f6716a;
            return aVar == null ? FieldSet.b() : aVar.a();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableBuilder() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableBuilder(BuilderParent builderParent) {
            super(builderParent);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final boolean m() {
            FieldSet.a<Descriptors.FieldDescriptor> aVar = this.f6716a;
            if (aVar == null) {
                return true;
            }
            return aVar.c();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            if (!super.isInitialized()) {
                return false;
            }
            FieldSet.a<Descriptors.FieldDescriptor> aVar = this.f6716a;
            return aVar == null ? true : aVar.c();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final Map<Descriptors.FieldDescriptor, Object> b_() {
            Map e = e();
            FieldSet.a<Descriptors.FieldDescriptor> aVar = this.f6716a;
            if (aVar != null) {
                e.putAll(aVar.b());
            }
            return Collections.unmodifiableMap(e);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final Object b(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.s()) {
                if (fieldDescriptor.t() != d()) {
                    throw new IllegalArgumentException("FieldDescriptor does not match message type.");
                }
                FieldSet.a<Descriptors.FieldDescriptor> aVar = this.f6716a;
                Object b = aVar == null ? null : aVar.b(fieldDescriptor);
                if (b != null) {
                    return b;
                }
                if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    return DynamicMessage.a(fieldDescriptor.w());
                }
                return fieldDescriptor.r();
            }
            return super.b(fieldDescriptor);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final boolean a(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.s()) {
                if (fieldDescriptor.t() != d()) {
                    throw new IllegalArgumentException("FieldDescriptor does not match message type.");
                }
                FieldSet.a<Descriptors.FieldDescriptor> aVar = this.f6716a;
                if (aVar == null) {
                    return false;
                }
                return aVar.a((FieldSet.a<Descriptors.FieldDescriptor>) fieldDescriptor);
            }
            return super.a(fieldDescriptor);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public BuilderType d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (fieldDescriptor.s()) {
                if (fieldDescriptor.t() != d()) {
                    throw new IllegalArgumentException("FieldDescriptor does not match message type.");
                }
                if (this.f6716a == null) {
                    this.f6716a = FieldSet.c();
                }
                this.f6716a.a((FieldSet.a<Descriptors.FieldDescriptor>) fieldDescriptor, obj);
                j();
                return this;
            }
            return (BuilderType) super.d(fieldDescriptor, obj);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public BuilderType c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (fieldDescriptor.s()) {
                if (fieldDescriptor.t() != d()) {
                    throw new IllegalArgumentException("FieldDescriptor does not match message type.");
                }
                if (this.f6716a == null) {
                    this.f6716a = FieldSet.c();
                }
                this.f6716a.b(fieldDescriptor, obj);
                j();
                return this;
            }
            return (BuilderType) super.c(fieldDescriptor, obj);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
        public final Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.s()) {
                return DynamicMessage.b(fieldDescriptor.w());
            }
            return super.c(fieldDescriptor);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void a(ExtendableMessage extendableMessage) {
            if (extendableMessage.b != null) {
                if (this.f6716a == null) {
                    this.f6716a = FieldSet.c();
                }
                this.f6716a.a(extendableMessage.b);
                j();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method b(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object b(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected final MapField Q() {
        throw new RuntimeException("No map fields found in " + getClass().getName());
    }

    /* loaded from: classes3.dex */
    public static final class FieldAccessorTable {

        /* renamed from: a, reason: collision with root package name */
        private final Descriptors.Descriptor f6718a;
        private final a[] b;
        private String[] c;
        private final c[] d;
        private volatile boolean e = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public interface a {
            Message.Builder a();

            Object a(Builder builder);

            Object a(GeneratedMessageV3 generatedMessageV3);

            void a(Builder builder, Object obj);

            Object b(GeneratedMessageV3 generatedMessageV3);

            void b(Builder builder, Object obj);

            boolean b(Builder builder);

            boolean c(GeneratedMessageV3 generatedMessageV3);
        }

        static /* synthetic */ a a(FieldAccessorTable fieldAccessorTable, Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.t() != fieldAccessorTable.f6718a) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
            if (fieldDescriptor.s()) {
                throw new IllegalArgumentException("This type does not have extensions.");
            }
            return fieldAccessorTable.b[fieldDescriptor.a()];
        }

        static /* synthetic */ c a(FieldAccessorTable fieldAccessorTable, Descriptors.OneofDescriptor oneofDescriptor) {
            if (oneofDescriptor.e() == fieldAccessorTable.f6718a) {
                return fieldAccessorTable.d[oneofDescriptor.a()];
            }
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        static /* synthetic */ boolean a(Descriptors.FileDescriptor fileDescriptor) {
            return fileDescriptor.i() == Descriptors.FileDescriptor.Syntax.PROTO2;
        }

        public FieldAccessorTable(Descriptors.Descriptor descriptor, String[] strArr) {
            this.f6718a = descriptor;
            this.c = strArr;
            this.b = new a[descriptor.f().size()];
            this.d = new c[descriptor.g().size()];
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final FieldAccessorTable a(Class<? extends GeneratedMessageV3> cls, Class<? extends Builder> cls2) {
            if (this.e) {
                return this;
            }
            synchronized (this) {
                if (this.e) {
                    return this;
                }
                int length = this.b.length;
                for (int i2 = 0; i2 < length; i2++) {
                    Descriptors.FieldDescriptor fieldDescriptor = this.f6718a.f().get(i2);
                    String str = fieldDescriptor.u() != null ? this.c[fieldDescriptor.u().a() + length] : null;
                    if (fieldDescriptor.o()) {
                        if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                            if (fieldDescriptor.l()) {
                                a[] aVarArr = this.b;
                                String[] strArr = this.c;
                                aVarArr[i2] = new b(fieldDescriptor, cls);
                            } else {
                                this.b[i2] = new f(fieldDescriptor, this.c[i2], cls, cls2);
                            }
                        } else if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                            this.b[i2] = new d(fieldDescriptor, this.c[i2], cls, cls2);
                        } else {
                            this.b[i2] = new e(fieldDescriptor, this.c[i2], cls, cls2);
                        }
                    } else if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        this.b[i2] = new i(fieldDescriptor, this.c[i2], cls, cls2, str);
                    } else if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                        this.b[i2] = new g(fieldDescriptor, this.c[i2], cls, cls2, str);
                    } else if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.STRING) {
                        this.b[i2] = new j(fieldDescriptor, this.c[i2], cls, cls2, str);
                    } else {
                        this.b[i2] = new h(fieldDescriptor, this.c[i2], cls, cls2, str);
                    }
                }
                int length2 = this.d.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    this.d[i3] = new c(this.f6718a, this.c[i3 + length], cls, cls2);
                }
                this.e = true;
                this.c = null;
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static class c {

            /* renamed from: a, reason: collision with root package name */
            private final Descriptors.Descriptor f6720a;
            private final Method b;
            private final Method c;

            c(Descriptors.Descriptor descriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends Builder> cls2) {
                this.f6720a = descriptor;
                this.b = GeneratedMessageV3.b(cls, "get" + str + "Case", new Class[0]);
                this.c = GeneratedMessageV3.b(cls2, "get" + str + "Case", new Class[0]);
                StringBuilder sb = new StringBuilder("clear");
                sb.append(str);
                GeneratedMessageV3.b(cls2, sb.toString(), new Class[0]);
            }

            public final boolean a(GeneratedMessageV3 generatedMessageV3) {
                return ((Internal.EnumLite) GeneratedMessageV3.b(this.b, generatedMessageV3, new Object[0])).a() != 0;
            }

            public final boolean a(Builder builder) {
                return ((Internal.EnumLite) GeneratedMessageV3.b(this.c, builder, new Object[0])).a() != 0;
            }

            public final Descriptors.FieldDescriptor b(GeneratedMessageV3 generatedMessageV3) {
                int a2 = ((Internal.EnumLite) GeneratedMessageV3.b(this.b, generatedMessageV3, new Object[0])).a();
                if (a2 > 0) {
                    return this.f6720a.b(a2);
                }
                return null;
            }

            public final Descriptors.FieldDescriptor b(Builder builder) {
                int a2 = ((Internal.EnumLite) GeneratedMessageV3.b(this.c, builder, new Object[0])).a();
                if (a2 > 0) {
                    return this.f6720a.b(a2);
                }
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static class h implements a {

            /* renamed from: a, reason: collision with root package name */
            protected final Class<?> f6723a;
            private Descriptors.FieldDescriptor b;
            private boolean c;
            private boolean d;
            private a e;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes3.dex */
            public interface a {
                Object a(Builder<?> builder);

                Object a(GeneratedMessageV3 generatedMessageV3);

                void a(Builder<?> builder, Object obj);

                int b(Builder<?> builder);

                int b(GeneratedMessageV3 generatedMessageV3);

                boolean c(Builder<?> builder);

                boolean c(GeneratedMessageV3 generatedMessageV3);
            }

            /* loaded from: classes3.dex */
            static final class b implements a {

                /* renamed from: a, reason: collision with root package name */
                protected final Method f6724a;
                private Method b;
                private Method c;
                private Method d;
                private Method e;
                private Method f;
                private Method g;

                b(String str, Class<? extends GeneratedMessageV3> cls, Class<? extends Builder> cls2, String str2, boolean z, boolean z2) {
                    Method method;
                    Method method2;
                    Method method3;
                    this.f6724a = GeneratedMessageV3.b(cls, "get" + str, new Class[0]);
                    this.b = GeneratedMessageV3.b(cls2, "get" + str, new Class[0]);
                    this.c = GeneratedMessageV3.b(cls2, "set" + str, this.f6724a.getReturnType());
                    Method method4 = null;
                    if (z2) {
                        method = GeneratedMessageV3.b(cls, "has" + str, new Class[0]);
                    } else {
                        method = null;
                    }
                    this.d = method;
                    if (z2) {
                        method2 = GeneratedMessageV3.b(cls2, "has" + str, new Class[0]);
                    } else {
                        method2 = null;
                    }
                    this.e = method2;
                    GeneratedMessageV3.b(cls2, "clear" + str, new Class[0]);
                    if (z) {
                        method3 = GeneratedMessageV3.b(cls, "get" + str2 + "Case", new Class[0]);
                    } else {
                        method3 = null;
                    }
                    this.f = method3;
                    if (z) {
                        method4 = GeneratedMessageV3.b(cls2, "get" + str2 + "Case", new Class[0]);
                    }
                    this.g = method4;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.h.a
                public final Object a(GeneratedMessageV3 generatedMessageV3) {
                    return GeneratedMessageV3.b(this.f6724a, generatedMessageV3, new Object[0]);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.h.a
                public final Object a(Builder<?> builder) {
                    return GeneratedMessageV3.b(this.b, builder, new Object[0]);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.h.a
                public final int b(GeneratedMessageV3 generatedMessageV3) {
                    return ((Internal.EnumLite) GeneratedMessageV3.b(this.f, generatedMessageV3, new Object[0])).a();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.h.a
                public final int b(Builder<?> builder) {
                    return ((Internal.EnumLite) GeneratedMessageV3.b(this.g, builder, new Object[0])).a();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.h.a
                public final void a(Builder<?> builder, Object obj) {
                    GeneratedMessageV3.b(this.c, builder, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.h.a
                public final boolean c(GeneratedMessageV3 generatedMessageV3) {
                    return ((Boolean) GeneratedMessageV3.b(this.d, generatedMessageV3, new Object[0])).booleanValue();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.h.a
                public final boolean c(Builder<?> builder) {
                    return ((Boolean) GeneratedMessageV3.b(this.e, builder, new Object[0])).booleanValue();
                }
            }

            h(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends Builder> cls2, String str2) {
                boolean z = true;
                this.c = fieldDescriptor.u() != null;
                if (!FieldAccessorTable.a(fieldDescriptor.d()) && (this.c || fieldDescriptor.f() != Descriptors.FieldDescriptor.JavaType.MESSAGE)) {
                    z = false;
                }
                this.d = z;
                b bVar = new b(str, cls, cls2, str2, this.c, this.d);
                this.b = fieldDescriptor;
                this.f6723a = bVar.f6724a.getReturnType();
                this.e = bVar;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public Object a(GeneratedMessageV3 generatedMessageV3) {
                return this.e.a(generatedMessageV3);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public Object a(Builder builder) {
                return this.e.a((Builder<?>) builder);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public Object b(GeneratedMessageV3 generatedMessageV3) {
                return a(generatedMessageV3);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public void a(Builder builder, Object obj) {
                this.e.a(builder, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final void b(Builder builder, Object obj) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final boolean c(GeneratedMessageV3 generatedMessageV3) {
                if (this.d) {
                    return this.e.c(generatedMessageV3);
                }
                return this.c ? this.e.b(generatedMessageV3) == this.b.e() : !a(generatedMessageV3).equals(this.b.r());
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final boolean b(Builder builder) {
                if (this.d) {
                    return this.e.c((Builder<?>) builder);
                }
                return this.c ? this.e.b((Builder<?>) builder) == this.b.e() : !a(builder).equals(this.b.r());
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public Message.Builder a() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static class e implements a {

            /* renamed from: a, reason: collision with root package name */
            protected final Class f6721a;
            private a b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes3.dex */
            public interface a {
                Object a(Builder<?> builder);

                Object a(Builder<?> builder, int i);

                Object a(GeneratedMessageV3 generatedMessageV3);

                Object a(GeneratedMessageV3 generatedMessageV3, int i);

                void a(Builder<?> builder, Object obj);

                int b(Builder<?> builder);

                int b(GeneratedMessageV3 generatedMessageV3);

                void c(Builder<?> builder);
            }

            /* loaded from: classes3.dex */
            static final class b implements a {

                /* renamed from: a, reason: collision with root package name */
                protected final Method f6722a;
                private Method b;
                private Method c;
                private Method d;
                private Method e;
                private Method f;
                private Method g;
                private Method h;

                b(String str, Class<? extends GeneratedMessageV3> cls, Class<? extends Builder> cls2) {
                    this.b = GeneratedMessageV3.b(cls, "get" + str + "List", new Class[0]);
                    this.c = GeneratedMessageV3.b(cls2, "get" + str + "List", new Class[0]);
                    StringBuilder sb = new StringBuilder("get");
                    sb.append(str);
                    this.f6722a = GeneratedMessageV3.b(cls, sb.toString(), Integer.TYPE);
                    this.d = GeneratedMessageV3.b(cls2, "get" + str, Integer.TYPE);
                    Class<?> returnType = this.f6722a.getReturnType();
                    GeneratedMessageV3.b(cls2, "set" + str, Integer.TYPE, returnType);
                    this.e = GeneratedMessageV3.b(cls2, ProductAction.ACTION_ADD + str, returnType);
                    this.f = GeneratedMessageV3.b(cls, "get" + str + "Count", new Class[0]);
                    this.g = GeneratedMessageV3.b(cls2, "get" + str + "Count", new Class[0]);
                    StringBuilder sb2 = new StringBuilder("clear");
                    sb2.append(str);
                    this.h = GeneratedMessageV3.b(cls2, sb2.toString(), new Class[0]);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.e.a
                public final Object a(GeneratedMessageV3 generatedMessageV3) {
                    return GeneratedMessageV3.b(this.b, generatedMessageV3, new Object[0]);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.e.a
                public final Object a(Builder<?> builder) {
                    return GeneratedMessageV3.b(this.c, builder, new Object[0]);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.e.a
                public final Object a(GeneratedMessageV3 generatedMessageV3, int i) {
                    return GeneratedMessageV3.b(this.f6722a, generatedMessageV3, Integer.valueOf(i));
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.e.a
                public final Object a(Builder<?> builder, int i) {
                    return GeneratedMessageV3.b(this.d, builder, Integer.valueOf(i));
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.e.a
                public final void a(Builder<?> builder, Object obj) {
                    GeneratedMessageV3.b(this.e, builder, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.e.a
                public final int b(GeneratedMessageV3 generatedMessageV3) {
                    return ((Integer) GeneratedMessageV3.b(this.f, generatedMessageV3, new Object[0])).intValue();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.e.a
                public final int b(Builder<?> builder) {
                    return ((Integer) GeneratedMessageV3.b(this.g, builder, new Object[0])).intValue();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.e.a
                public final void c(Builder<?> builder) {
                    GeneratedMessageV3.b(this.h, builder, new Object[0]);
                }
            }

            e(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends Builder> cls2) {
                b bVar = new b(str, cls, cls2);
                this.f6721a = bVar.f6722a.getReturnType();
                this.b = bVar;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public Object a(GeneratedMessageV3 generatedMessageV3) {
                return this.b.a(generatedMessageV3);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public Object a(Builder builder) {
                return this.b.a((Builder<?>) builder);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final Object b(GeneratedMessageV3 generatedMessageV3) {
                return a(generatedMessageV3);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final void a(Builder builder, Object obj) {
                this.b.c(builder);
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    b(builder, it.next());
                }
            }

            public Object a(GeneratedMessageV3 generatedMessageV3, int i) {
                return this.b.a(generatedMessageV3, i);
            }

            public Object a(Builder builder, int i) {
                return this.b.a((Builder<?>) builder, i);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public void b(Builder builder, Object obj) {
                this.b.a((Builder<?>) builder, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final boolean c(GeneratedMessageV3 generatedMessageV3) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final boolean b(Builder builder) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            public final int d(GeneratedMessageV3 generatedMessageV3) {
                return this.b.b(generatedMessageV3);
            }

            public final int c(Builder builder) {
                return this.b.b((Builder<?>) builder);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public Message.Builder a() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static class b implements a {

            /* renamed from: a, reason: collision with root package name */
            private final Descriptors.FieldDescriptor f6719a;
            private final Message b;

            b(Descriptors.FieldDescriptor fieldDescriptor, Class<? extends GeneratedMessageV3> cls) {
                this.f6719a = fieldDescriptor;
                GeneratedMessageV3 generatedMessageV3 = (GeneratedMessageV3) GeneratedMessageV3.b(GeneratedMessageV3.b(cls, "getDefaultInstance", new Class[0]), (Object) null, new Object[0]);
                this.f6719a.e();
                this.b = generatedMessageV3.Q().f();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final Object a(GeneratedMessageV3 generatedMessageV3) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    this.f6719a.e();
                    if (i < generatedMessageV3.Q().d().size()) {
                        this.f6719a.e();
                        arrayList.add(generatedMessageV3.Q().d().get(i));
                        i++;
                    } else {
                        return Collections.unmodifiableList(arrayList);
                    }
                }
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final Object a(Builder builder) {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (true) {
                    this.f6719a.e();
                    if (i < builder.k().d().size()) {
                        this.f6719a.e();
                        arrayList.add(builder.k().d().get(i));
                        i++;
                    } else {
                        return Collections.unmodifiableList(arrayList);
                    }
                }
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final Object b(GeneratedMessageV3 generatedMessageV3) {
                return a(generatedMessageV3);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final void a(Builder builder, Object obj) {
                this.f6719a.e();
                builder.l().e().clear();
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    b(builder, it.next());
                }
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final void b(Builder builder, Object obj) {
                this.f6719a.e();
                List<Message> e = builder.l().e();
                Message message = (Message) obj;
                if (message == null) {
                    message = null;
                } else if (!this.b.getClass().isInstance(message)) {
                    message = this.b.p().internalMergeFrom(message).h();
                }
                e.add(message);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final boolean c(GeneratedMessageV3 generatedMessageV3) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final boolean b(Builder builder) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final Message.Builder a() {
                return this.b.q();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class g extends h {
            private Descriptors.EnumDescriptor b;
            private Method c;
            private Method d;
            private boolean e;
            private Method f;
            private Method g;
            private Method h;

            g(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends Builder> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.b = fieldDescriptor.x();
                this.c = GeneratedMessageV3.b(this.f6723a, "valueOf", Descriptors.EnumValueDescriptor.class);
                this.d = GeneratedMessageV3.b(this.f6723a, "getValueDescriptor", new Class[0]);
                this.e = fieldDescriptor.d().k();
                if (this.e) {
                    this.f = GeneratedMessageV3.b(cls, "get" + str + "Value", new Class[0]);
                    this.g = GeneratedMessageV3.b(cls2, "get" + str + "Value", new Class[0]);
                    this.h = GeneratedMessageV3.b(cls2, "set" + str + "Value", Integer.TYPE);
                }
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.h, com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final Object a(GeneratedMessageV3 generatedMessageV3) {
                if (this.e) {
                    return this.b.c(((Integer) GeneratedMessageV3.b(this.f, generatedMessageV3, new Object[0])).intValue());
                }
                return GeneratedMessageV3.b(this.d, super.a(generatedMessageV3), new Object[0]);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.h, com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final Object a(Builder builder) {
                if (this.e) {
                    return this.b.c(((Integer) GeneratedMessageV3.b(this.g, builder, new Object[0])).intValue());
                }
                return GeneratedMessageV3.b(this.d, super.a(builder), new Object[0]);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.h, com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final void a(Builder builder, Object obj) {
                if (this.e) {
                    GeneratedMessageV3.b(this.h, builder, Integer.valueOf(((Descriptors.EnumValueDescriptor) obj).a()));
                } else {
                    super.a(builder, GeneratedMessageV3.b(this.c, (Object) null, obj));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class d extends e {
            private Descriptors.EnumDescriptor b;
            private final Method c;
            private final Method d;
            private boolean e;
            private Method f;
            private Method g;
            private Method h;

            d(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends Builder> cls2) {
                super(fieldDescriptor, str, cls, cls2);
                this.b = fieldDescriptor.x();
                this.c = GeneratedMessageV3.b(this.f6721a, "valueOf", Descriptors.EnumValueDescriptor.class);
                this.d = GeneratedMessageV3.b(this.f6721a, "getValueDescriptor", new Class[0]);
                this.e = fieldDescriptor.d().k();
                if (this.e) {
                    this.f = GeneratedMessageV3.b(cls, "get" + str + "Value", Integer.TYPE);
                    this.g = GeneratedMessageV3.b(cls2, "get" + str + "Value", Integer.TYPE);
                    GeneratedMessageV3.b(cls2, "set" + str + "Value", Integer.TYPE, Integer.TYPE);
                    this.h = GeneratedMessageV3.b(cls2, ProductAction.ACTION_ADD + str + "Value", Integer.TYPE);
                }
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.e, com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final Object a(GeneratedMessageV3 generatedMessageV3) {
                ArrayList arrayList = new ArrayList();
                int d = d(generatedMessageV3);
                for (int i = 0; i < d; i++) {
                    arrayList.add(a(generatedMessageV3, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.e, com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final Object a(Builder builder) {
                ArrayList arrayList = new ArrayList();
                int c = c(builder);
                for (int i = 0; i < c; i++) {
                    arrayList.add(a(builder, i));
                }
                return Collections.unmodifiableList(arrayList);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.e
            public final Object a(GeneratedMessageV3 generatedMessageV3, int i) {
                if (!this.e) {
                    return GeneratedMessageV3.b(this.d, super.a(generatedMessageV3, i), new Object[0]);
                }
                return this.b.c(((Integer) GeneratedMessageV3.b(this.f, generatedMessageV3, Integer.valueOf(i))).intValue());
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.e
            public final Object a(Builder builder, int i) {
                if (!this.e) {
                    return GeneratedMessageV3.b(this.d, super.a(builder, i), new Object[0]);
                }
                return this.b.c(((Integer) GeneratedMessageV3.b(this.g, builder, Integer.valueOf(i))).intValue());
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.e, com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final void b(Builder builder, Object obj) {
                if (this.e) {
                    GeneratedMessageV3.b(this.h, builder, Integer.valueOf(((Descriptors.EnumValueDescriptor) obj).a()));
                } else {
                    super.b(builder, GeneratedMessageV3.b(this.c, (Object) null, obj));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class j extends h {
            private final Method b;
            private final Method c;

            j(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends Builder> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.b = GeneratedMessageV3.b(cls, "get" + str + "Bytes", new Class[0]);
                GeneratedMessageV3.b(cls2, "get" + str + "Bytes", new Class[0]);
                this.c = GeneratedMessageV3.b(cls2, "set" + str + "Bytes", ByteString.class);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.h, com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final Object b(GeneratedMessageV3 generatedMessageV3) {
                return GeneratedMessageV3.b(this.b, generatedMessageV3, new Object[0]);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.h, com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final void a(Builder builder, Object obj) {
                if (obj instanceof ByteString) {
                    GeneratedMessageV3.b(this.c, builder, obj);
                } else {
                    super.a(builder, obj);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class i extends h {
            private final Method b;

            i(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends Builder> cls2, String str2) {
                super(fieldDescriptor, str, cls, cls2, str2);
                this.b = GeneratedMessageV3.b(this.f6723a, "newBuilder", new Class[0]);
                GeneratedMessageV3.b(cls2, "get" + str + "Builder", new Class[0]);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.h, com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final void a(Builder builder, Object obj) {
                if (!this.f6723a.isInstance(obj)) {
                    obj = ((Message.Builder) GeneratedMessageV3.b(this.b, (Object) null, new Object[0])).internalMergeFrom((Message) obj).g();
                }
                super.a(builder, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.h, com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final Message.Builder a() {
                return (Message.Builder) GeneratedMessageV3.b(this.b, (Object) null, new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class f extends e {
            private final Method b;

            f(Descriptors.FieldDescriptor fieldDescriptor, String str, Class<? extends GeneratedMessageV3> cls, Class<? extends Builder> cls2) {
                super(fieldDescriptor, str, cls, cls2);
                this.b = GeneratedMessageV3.b(this.f6721a, "newBuilder", new Class[0]);
                GeneratedMessageV3.b(cls2, "get" + str + "Builder", Integer.TYPE);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.e, com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final void b(Builder builder, Object obj) {
                if (!this.f6721a.isInstance(obj)) {
                    obj = ((Message.Builder) GeneratedMessageV3.b(this.b, (Object) null, new Object[0])).internalMergeFrom((Message) obj).h();
                }
                super.b(builder, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.e, com.uqm.crashsight.protobuf.GeneratedMessageV3.FieldAccessorTable.a
            public final Message.Builder a() {
                return (Message.Builder) GeneratedMessageV3.b(this.b, (Object) null, new Object[0]);
            }
        }
    }
}
