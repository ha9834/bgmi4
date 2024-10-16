package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.AbstractMessage;
import com.uqm.crashsight.protobuf.Descriptors;
import com.uqm.crashsight.protobuf.Message;
import com.uqm.crashsight.protobuf.MessageLite;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class DynamicMessage extends AbstractMessage {
    private final Descriptors.Descriptor b;
    private final FieldSet<Descriptors.FieldDescriptor> c;
    private final Descriptors.FieldDescriptor[] d;
    private final UnknownFieldSet e;
    private int f = -1;

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public final /* synthetic */ MessageLite.Builder newBuilderForType() {
        return new Builder(this.b, (byte) 0);
    }

    @Override // com.uqm.crashsight.protobuf.Message
    public final /* synthetic */ Message.Builder p() {
        return new Builder(this.b, (byte) 0).c(this);
    }

    @Override // com.uqm.crashsight.protobuf.Message
    public final /* synthetic */ Message.Builder q() {
        return new Builder(this.b, (byte) 0);
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public final /* synthetic */ MessageLite.Builder toBuilder() {
        return new Builder(this.b, (byte) 0).c(this);
    }

    DynamicMessage(Descriptors.Descriptor descriptor, FieldSet<Descriptors.FieldDescriptor> fieldSet, Descriptors.FieldDescriptor[] fieldDescriptorArr, UnknownFieldSet unknownFieldSet) {
        this.b = descriptor;
        this.c = fieldSet;
        this.d = fieldDescriptorArr;
        this.e = unknownFieldSet;
    }

    public static DynamicMessage a(Descriptors.Descriptor descriptor) {
        return new DynamicMessage(descriptor, FieldSet.b(), new Descriptors.FieldDescriptor[descriptor.a().k()], UnknownFieldSet.b());
    }

    public static Builder b(Descriptors.Descriptor descriptor) {
        return new Builder(descriptor, (byte) 0);
    }

    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    public final Descriptors.Descriptor d() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    /* renamed from: e, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public DynamicMessage r() {
        Descriptors.Descriptor descriptor = this.b;
        return new DynamicMessage(descriptor, FieldSet.b(), new Descriptors.FieldDescriptor[descriptor.a().k()], UnknownFieldSet.b());
    }

    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    public final Map<Descriptors.FieldDescriptor, Object> b_() {
        return this.c.h();
    }

    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    public final boolean a(Descriptors.FieldDescriptor fieldDescriptor) {
        if (fieldDescriptor.t() != this.b) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
        return this.c.a((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor);
    }

    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    public final Object b(Descriptors.FieldDescriptor fieldDescriptor) {
        if (fieldDescriptor.t() != this.b) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
        Object b = this.c.b((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor);
        if (b != null) {
            return b;
        }
        if (fieldDescriptor.o()) {
            return Collections.emptyList();
        }
        if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
            Descriptors.Descriptor w = fieldDescriptor.w();
            return new DynamicMessage(w, FieldSet.b(), new Descriptors.FieldDescriptor[w.a().k()], UnknownFieldSet.b());
        }
        return fieldDescriptor.r();
    }

    @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
    public final UnknownFieldSet b() {
        return this.e;
    }

    static boolean a(Descriptors.Descriptor descriptor, FieldSet<Descriptors.FieldDescriptor> fieldSet) {
        for (Descriptors.FieldDescriptor fieldDescriptor : descriptor.f()) {
            if (fieldDescriptor.m() && !fieldSet.a((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor)) {
                return false;
            }
        }
        return fieldSet.k();
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return a(this.b, this.c);
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
    public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.b.e().f()) {
            this.c.b(codedOutputStream);
            this.e.a(codedOutputStream);
        } else {
            this.c.a(codedOutputStream);
            this.e.writeTo(codedOutputStream);
        }
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
    public final int getSerializedSize() {
        int l;
        int i = this.f;
        if (i != -1) {
            return i;
        }
        if (this.b.e().f()) {
            l = this.c.m() + this.e.d();
        } else {
            l = this.c.l() + this.e.getSerializedSize();
        }
        this.f = l;
        return l;
    }

    public final Builder c() {
        return new Builder(this.b, (byte) 0);
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public final Parser<DynamicMessage> getParserForType() {
        return new AbstractParser<DynamicMessage>() { // from class: com.uqm.crashsight.protobuf.DynamicMessage.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.uqm.crashsight.protobuf.Parser
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public DynamicMessage a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                Builder b = DynamicMessage.b(DynamicMessage.this.b);
                try {
                    b.mergeFrom(codedInputStream, extensionRegistryLite);
                    return b.g();
                } catch (InvalidProtocolBufferException e) {
                    throw e.a(b.g());
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).a(b.g());
                }
            }
        };
    }

    /* loaded from: classes3.dex */
    public static final class Builder extends AbstractMessage.Builder<Builder> {

        /* renamed from: a, reason: collision with root package name */
        private final Descriptors.Descriptor f6693a;
        private FieldSet<Descriptors.FieldDescriptor> b;
        private final Descriptors.FieldDescriptor[] c;
        private UnknownFieldSet d;

        /* synthetic */ Builder(Descriptors.Descriptor descriptor, byte b) {
            this(descriptor);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
        public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
            this.d = UnknownFieldSet.a(this.d).a(unknownFieldSet).build();
            return this;
        }

        @Override // com.uqm.crashsight.protobuf.Message.Builder
        public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.t() != this.f6693a) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
            if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return new Builder(fieldDescriptor.w());
            }
            throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
        }

        @Override // com.uqm.crashsight.protobuf.Message.Builder
        public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (fieldDescriptor.t() != this.f6693a) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
            if (this.b.f()) {
                this.b = this.b.clone();
            }
            this.b.b((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor, obj);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.Message.Builder
        public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            if (fieldDescriptor.t() != this.f6693a) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
            if (this.b.f()) {
                this.b = this.b.clone();
            }
            if (fieldDescriptor.h() == Descriptors.FieldDescriptor.Type.ENUM) {
                if (fieldDescriptor.o()) {
                    for (Object obj2 : (List) obj) {
                        Internal.a(obj2);
                        if (!(obj2 instanceof Descriptors.EnumValueDescriptor)) {
                            throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
                        }
                    }
                } else {
                    Internal.a(obj);
                    if (!(obj instanceof Descriptors.EnumValueDescriptor)) {
                        throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
                    }
                }
            }
            Descriptors.OneofDescriptor u = fieldDescriptor.u();
            if (u != null) {
                int a2 = u.a();
                Descriptors.FieldDescriptor fieldDescriptor2 = this.c[a2];
                if (fieldDescriptor2 != null && fieldDescriptor2 != fieldDescriptor) {
                    this.b.c((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor2);
                }
                this.c[a2] = fieldDescriptor;
            } else if (fieldDescriptor.d().i() == Descriptors.FileDescriptor.Syntax.PROTO3 && !fieldDescriptor.o() && fieldDescriptor.f() != Descriptors.FieldDescriptor.JavaType.MESSAGE && obj.equals(fieldDescriptor.r())) {
                this.b.c((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor);
                return this;
            }
            this.b.a((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor, obj);
            return this;
        }

        @Override // com.uqm.crashsight.protobuf.Message.Builder
        public final /* bridge */ /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
            this.d = unknownFieldSet;
            return this;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* synthetic */ MessageLite r() {
            return DynamicMessage.a(this.f6693a);
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* synthetic */ Message r() {
            return DynamicMessage.a(this.f6693a);
        }

        private Builder(Descriptors.Descriptor descriptor) {
            FieldSet<Descriptors.FieldDescriptor> fieldSet;
            Object r;
            this.f6693a = descriptor;
            this.b = FieldSet.a();
            this.d = UnknownFieldSet.b();
            this.c = new Descriptors.FieldDescriptor[descriptor.a().k()];
            if (descriptor.e().l()) {
                for (Descriptors.FieldDescriptor fieldDescriptor : this.f6693a.f()) {
                    if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        fieldSet = this.b;
                        r = DynamicMessage.a(fieldDescriptor.w());
                    } else {
                        fieldSet = this.b;
                        r = fieldDescriptor.r();
                    }
                    fieldSet.a((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor, r);
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
        /* renamed from: d, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final Builder internalMergeFrom(Message message) {
            if (message instanceof DynamicMessage) {
                DynamicMessage dynamicMessage = (DynamicMessage) message;
                if (dynamicMessage.b != this.f6693a) {
                    throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
                }
                if (this.b.f()) {
                    this.b = this.b.clone();
                }
                this.b.a(dynamicMessage.c);
                this.d = UnknownFieldSet.a(this.d).a(dynamicMessage.e).build();
                int i = 0;
                while (true) {
                    Descriptors.FieldDescriptor[] fieldDescriptorArr = this.c;
                    if (i >= fieldDescriptorArr.length) {
                        return this;
                    }
                    if (fieldDescriptorArr[i] == null) {
                        fieldDescriptorArr[i] = dynamicMessage.d[i];
                    } else if (dynamicMessage.d[i] != null && this.c[i] != dynamicMessage.d[i]) {
                        this.b.c((FieldSet<Descriptors.FieldDescriptor>) this.c[i]);
                        this.c[i] = dynamicMessage.d[i];
                    }
                    i++;
                }
            } else {
                return (Builder) super.internalMergeFrom(message);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.uqm.crashsight.protobuf.Message.Builder
        /* renamed from: e, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public DynamicMessage h() {
            if (!isInitialized()) {
                Descriptors.Descriptor descriptor = this.f6693a;
                FieldSet<Descriptors.FieldDescriptor> fieldSet = this.b;
                Descriptors.FieldDescriptor[] fieldDescriptorArr = this.c;
                throw new UninitializedMessageException(MessageReflection.b(new DynamicMessage(descriptor, fieldSet, (Descriptors.FieldDescriptor[]) Arrays.copyOf(fieldDescriptorArr, fieldDescriptorArr.length), this.d)));
            }
            return g();
        }

        @Override // com.uqm.crashsight.protobuf.Message.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final DynamicMessage g() {
            this.b.e();
            Descriptors.Descriptor descriptor = this.f6693a;
            FieldSet<Descriptors.FieldDescriptor> fieldSet = this.b;
            Descriptors.FieldDescriptor[] fieldDescriptorArr = this.c;
            return new DynamicMessage(descriptor, fieldSet, (Descriptors.FieldDescriptor[]) Arrays.copyOf(fieldDescriptorArr, fieldDescriptorArr.length), this.d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: f, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public Builder mo11clone() {
            Builder builder = new Builder(this.f6693a);
            builder.b.a(this.b);
            builder.d = UnknownFieldSet.a(builder.d).a(this.d).build();
            Descriptors.FieldDescriptor[] fieldDescriptorArr = this.c;
            System.arraycopy(fieldDescriptorArr, 0, builder.c, 0, fieldDescriptorArr.length);
            return builder;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return DynamicMessage.a(this.f6693a, this.b);
        }

        @Override // com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final Descriptors.Descriptor d() {
            return this.f6693a;
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final Map<Descriptors.FieldDescriptor, Object> b_() {
            return this.b.h();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final boolean a(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.t() != this.f6693a) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
            return this.b.a((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor);
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final Object b(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.t() != this.f6693a) {
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

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }
    }
}
