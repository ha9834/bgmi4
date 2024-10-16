package com.uqm.crashsight.protobuf;

import com.amazonaws.event.ProgressEvent;
import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.nearby.connection.Connections;
import com.tencent.smtt.sdk.TbsListener;
import com.uqm.crashsight.protobuf.AbstractMessage;
import com.uqm.crashsight.protobuf.AbstractMessageLite;
import com.uqm.crashsight.protobuf.Descriptors;
import com.uqm.crashsight.protobuf.GeneratedMessageV3;
import com.uqm.crashsight.protobuf.Internal;
import com.uqm.crashsight.protobuf.Message;
import com.uqm.crashsight.protobuf.MessageLite;
import com.uqm.crashsight.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class DescriptorProtos {
    private static final Descriptors.Descriptor A;
    private static final GeneratedMessageV3.FieldAccessorTable B;
    private static final Descriptors.Descriptor C;
    private static final GeneratedMessageV3.FieldAccessorTable D;
    private static final Descriptors.Descriptor E;
    private static final GeneratedMessageV3.FieldAccessorTable F;
    private static final Descriptors.Descriptor G;
    private static final GeneratedMessageV3.FieldAccessorTable H;
    private static final Descriptors.Descriptor I;
    private static final GeneratedMessageV3.FieldAccessorTable J;
    private static final Descriptors.Descriptor K;
    private static final GeneratedMessageV3.FieldAccessorTable L;
    private static final Descriptors.Descriptor M;
    private static final GeneratedMessageV3.FieldAccessorTable N;
    private static final Descriptors.Descriptor O;
    private static final GeneratedMessageV3.FieldAccessorTable P;
    private static final Descriptors.Descriptor Q;
    private static final GeneratedMessageV3.FieldAccessorTable R;
    private static final Descriptors.Descriptor S;
    private static final GeneratedMessageV3.FieldAccessorTable T;
    private static final Descriptors.Descriptor U;
    private static final GeneratedMessageV3.FieldAccessorTable V;
    private static final Descriptors.Descriptor W;
    private static final GeneratedMessageV3.FieldAccessorTable X;
    private static final Descriptors.Descriptor Y;
    private static final GeneratedMessageV3.FieldAccessorTable Z;

    /* renamed from: a, reason: collision with root package name */
    private static final Descriptors.Descriptor f6641a;
    private static final Descriptors.Descriptor aa;
    private static final GeneratedMessageV3.FieldAccessorTable ab;
    private static Descriptors.FileDescriptor ac;
    private static final GeneratedMessageV3.FieldAccessorTable b;
    private static final Descriptors.Descriptor c;
    private static final GeneratedMessageV3.FieldAccessorTable d;
    private static final Descriptors.Descriptor e;
    private static final GeneratedMessageV3.FieldAccessorTable f;
    private static final Descriptors.Descriptor g;
    private static final GeneratedMessageV3.FieldAccessorTable h;
    private static final Descriptors.Descriptor i;
    private static final GeneratedMessageV3.FieldAccessorTable j;
    private static final Descriptors.Descriptor k;
    private static final GeneratedMessageV3.FieldAccessorTable l;
    private static final Descriptors.Descriptor m;
    private static final GeneratedMessageV3.FieldAccessorTable n;
    private static final Descriptors.Descriptor o;
    private static final GeneratedMessageV3.FieldAccessorTable p;
    private static final Descriptors.Descriptor q;
    private static final GeneratedMessageV3.FieldAccessorTable r;
    private static final Descriptors.Descriptor s;
    private static final GeneratedMessageV3.FieldAccessorTable t;
    private static final Descriptors.Descriptor u;
    private static final GeneratedMessageV3.FieldAccessorTable v;
    private static final Descriptors.Descriptor w;
    private static final GeneratedMessageV3.FieldAccessorTable x;
    private static final Descriptors.Descriptor y;
    private static final GeneratedMessageV3.FieldAccessorTable z;

    /* loaded from: classes3.dex */
    public interface DescriptorProtoOrBuilder extends MessageOrBuilder {
    }

    /* loaded from: classes3.dex */
    public interface EnumDescriptorProtoOrBuilder extends MessageOrBuilder {
    }

    /* loaded from: classes3.dex */
    public interface EnumOptionsOrBuilder extends GeneratedMessageV3.ExtendableMessageOrBuilder<EnumOptions> {
    }

    /* loaded from: classes3.dex */
    public interface EnumValueDescriptorProtoOrBuilder extends MessageOrBuilder {
    }

    /* loaded from: classes3.dex */
    public interface EnumValueOptionsOrBuilder extends GeneratedMessageV3.ExtendableMessageOrBuilder<EnumValueOptions> {
    }

    /* loaded from: classes3.dex */
    public interface ExtensionRangeOptionsOrBuilder extends GeneratedMessageV3.ExtendableMessageOrBuilder<ExtensionRangeOptions> {
    }

    /* loaded from: classes3.dex */
    public interface FieldDescriptorProtoOrBuilder extends MessageOrBuilder {
    }

    /* loaded from: classes3.dex */
    public interface FieldOptionsOrBuilder extends GeneratedMessageV3.ExtendableMessageOrBuilder<FieldOptions> {
    }

    /* loaded from: classes3.dex */
    public interface FileDescriptorProtoOrBuilder extends MessageOrBuilder {
    }

    /* loaded from: classes3.dex */
    public interface FileDescriptorSetOrBuilder extends MessageOrBuilder {
    }

    /* loaded from: classes3.dex */
    public interface FileOptionsOrBuilder extends GeneratedMessageV3.ExtendableMessageOrBuilder<FileOptions> {
    }

    /* loaded from: classes3.dex */
    public interface GeneratedCodeInfoOrBuilder extends MessageOrBuilder {
    }

    /* loaded from: classes3.dex */
    public interface MessageOptionsOrBuilder extends GeneratedMessageV3.ExtendableMessageOrBuilder<MessageOptions> {
    }

    /* loaded from: classes3.dex */
    public interface MethodDescriptorProtoOrBuilder extends MessageOrBuilder {
    }

    /* loaded from: classes3.dex */
    public interface MethodOptionsOrBuilder extends GeneratedMessageV3.ExtendableMessageOrBuilder<MethodOptions> {
    }

    /* loaded from: classes3.dex */
    public interface OneofDescriptorProtoOrBuilder extends MessageOrBuilder {
    }

    /* loaded from: classes3.dex */
    public interface OneofOptionsOrBuilder extends GeneratedMessageV3.ExtendableMessageOrBuilder<OneofOptions> {
    }

    /* loaded from: classes3.dex */
    public interface ServiceDescriptorProtoOrBuilder extends MessageOrBuilder {
    }

    /* loaded from: classes3.dex */
    public interface ServiceOptionsOrBuilder extends GeneratedMessageV3.ExtendableMessageOrBuilder<ServiceOptions> {
    }

    /* loaded from: classes3.dex */
    public interface SourceCodeInfoOrBuilder extends MessageOrBuilder {
    }

    /* loaded from: classes3.dex */
    public interface UninterpretedOptionOrBuilder extends MessageOrBuilder {
    }

    private DescriptorProtos() {
    }

    /* loaded from: classes3.dex */
    public static final class FileDescriptorSet extends GeneratedMessageV3 implements FileDescriptorSetOrBuilder {
        private List<FileDescriptorProto> e;
        private byte f;
        private static final FileDescriptorSet g = new FileDescriptorSet();

        @Deprecated
        public static final Parser<FileDescriptorSet> b = new AbstractParser<FileDescriptorSet>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.FileDescriptorSet.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new FileDescriptorSet(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* synthetic */ FileDescriptorSet(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ FileDescriptorSet(GeneratedMessageV3.Builder builder, byte b2) {
            this(builder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return g;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return f();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == g ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return f();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return g;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == g ? new Builder(b2) : new Builder(b2).a(this);
        }

        private FileDescriptorSet(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.f = (byte) -1;
        }

        private FileDescriptorSet() {
            this.f = (byte) -1;
            this.e = Collections.emptyList();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new FileDescriptorSet();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FileDescriptorSet(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 10) {
                            if (!(z2 & true)) {
                                this.e = new ArrayList();
                                z2 |= true;
                            }
                            this.e.add(codedInputStream.a(FileDescriptorProto.b, extensionRegistryLite));
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.e = Collections.unmodifiableList(this.e);
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.b.a(FileDescriptorSet.class, Builder.class);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.e.size(); i++) {
                if (!this.e.get(i).isInitialized()) {
                    this.f = (byte) 0;
                    return false;
                }
            }
            this.f = (byte) 1;
            return true;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.e.size(); i++) {
                codedOutputStream.a(1, this.e.get(i));
            }
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.f6632a;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                i2 += CodedOutputStream.c(1, this.e.get(i3));
            }
            int serializedSize = i2 + this.d.getSerializedSize();
            this.f6632a = serializedSize;
            return serializedSize;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FileDescriptorSet)) {
                return super.equals(obj);
            }
            FileDescriptorSet fileDescriptorSet = (FileDescriptorSet) obj;
            return this.e.equals(fileDescriptorSet.e) && this.d.equals(fileDescriptorSet.d);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.f6641a.hashCode() + 779;
                if (this.e.size() > 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + this.e.hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.d.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }
            return this.memoizedHashCode;
        }

        private static Builder f() {
            FileDescriptorSet fileDescriptorSet = g;
            byte b2 = 0;
            return fileDescriptorSet == fileDescriptorSet ? new Builder(b2) : new Builder(b2).a(fileDescriptorSet);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FileDescriptorSetOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6658a;
            private List<FileDescriptorProto> b;
            private RepeatedFieldBuilderV3<FileDescriptorProto, FileDescriptorProto.Builder, FileDescriptorProtoOrBuilder> c;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof FileDescriptorSet) {
                    return a((FileDescriptorSet) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                FileDescriptorSet g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof FileDescriptorSet) {
                    return a((FileDescriptorSet) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return FileDescriptorSet.e();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                FileDescriptorSet g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return FileDescriptorSet.e();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.b.a(FileDescriptorSet.class, Builder.class);
            }

            private Builder() {
                this.b = Collections.emptyList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = Collections.emptyList();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.f6641a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public FileDescriptorSet g() {
                FileDescriptorSet fileDescriptorSet = new FileDescriptorSet((GeneratedMessageV3.Builder) this, (byte) 0);
                int i = this.f6658a;
                RepeatedFieldBuilderV3<FileDescriptorProto, FileDescriptorProto.Builder, FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.c;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) != 0) {
                        this.b = Collections.unmodifiableList(this.b);
                        this.f6658a &= -2;
                    }
                    fileDescriptorSet.e = this.b;
                } else {
                    fileDescriptorSet.e = repeatedFieldBuilderV3.e();
                }
                i();
                return fileDescriptorSet;
            }

            public final Builder a(FileDescriptorSet fileDescriptorSet) {
                if (fileDescriptorSet == FileDescriptorSet.e()) {
                    return this;
                }
                if (this.c == null) {
                    if (!fileDescriptorSet.e.isEmpty()) {
                        if (this.b.isEmpty()) {
                            this.b = fileDescriptorSet.e;
                            this.f6658a &= -2;
                        } else {
                            if ((this.f6658a & 1) == 0) {
                                this.b = new ArrayList(this.b);
                                this.f6658a |= 1;
                            }
                            this.b.addAll(fileDescriptorSet.e);
                        }
                        j();
                    }
                } else if (!fileDescriptorSet.e.isEmpty()) {
                    if (!this.c.d()) {
                        this.c.a(fileDescriptorSet.e);
                    } else {
                        this.c.b();
                        this.c = null;
                        this.b = fileDescriptorSet.e;
                        this.f6658a &= -2;
                        this.c = null;
                    }
                }
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int i = 0;
                while (true) {
                    RepeatedFieldBuilderV3<FileDescriptorProto, FileDescriptorProto.Builder, FileDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.c;
                    if (i >= (repeatedFieldBuilderV3 == null ? this.b.size() : repeatedFieldBuilderV3.c())) {
                        return true;
                    }
                    RepeatedFieldBuilderV3<FileDescriptorProto, FileDescriptorProto.Builder, FileDescriptorProtoOrBuilder> repeatedFieldBuilderV32 = this.c;
                    if (!(repeatedFieldBuilderV32 == null ? this.b.get(i) : repeatedFieldBuilderV32.a(i)).isInitialized()) {
                        return false;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.FileDescriptorSet.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$FileDescriptorSet> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.FileDescriptorSet.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$FileDescriptorSet r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.FileDescriptorSet) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$FileDescriptorSet r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.FileDescriptorSet) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.FileDescriptorSet.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$FileDescriptorSet$Builder");
            }
        }

        public static FileDescriptorSet e() {
            return g;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<FileDescriptorSet> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class FileDescriptorProto extends GeneratedMessageV3 implements FileDescriptorProtoOrBuilder {
        private int e;
        private volatile Object f;
        private volatile Object g;
        private LazyStringList h;
        private Internal.IntList i;
        private Internal.IntList j;
        private List<DescriptorProto> k;
        private List<EnumDescriptorProto> l;
        private List<ServiceDescriptorProto> m;
        private List<FieldDescriptorProto> n;
        private FileOptions o;
        private SourceCodeInfo p;
        private volatile Object q;
        private byte r;
        private static final FileDescriptorProto s = new FileDescriptorProto();

        @Deprecated
        public static final Parser<FileDescriptorProto> b = new AbstractParser<FileDescriptorProto>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.FileDescriptorProto.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new FileDescriptorProto(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* synthetic */ FileDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ FileDescriptorProto(GeneratedMessageV3.Builder builder, byte b2) {
            this(builder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return s;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return z();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == s ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return z();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return s;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == s ? new Builder(b2) : new Builder(b2).a(this);
        }

        private FileDescriptorProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.r = (byte) -1;
        }

        private FileDescriptorProto() {
            this.r = (byte) -1;
            this.f = "";
            this.g = "";
            this.h = LazyStringArrayList.f6738a;
            this.i = q.d();
            this.j = q.d();
            this.k = Collections.emptyList();
            this.l = Collections.emptyList();
            this.m = Collections.emptyList();
            this.n = Collections.emptyList();
            this.q = "";
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new FileDescriptorProto();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0013. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FileDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            int i = 0;
            while (!z) {
                try {
                    try {
                        try {
                            int a3 = codedInputStream.a();
                            switch (a3) {
                                case 0:
                                    z = true;
                                case 10:
                                    ByteString l = codedInputStream.l();
                                    this.e |= 1;
                                    this.f = l;
                                case 18:
                                    ByteString l2 = codedInputStream.l();
                                    this.e |= 2;
                                    this.g = l2;
                                case 26:
                                    ByteString l3 = codedInputStream.l();
                                    if ((i & 4) == 0) {
                                        this.h = new LazyStringArrayList();
                                        i |= 4;
                                    }
                                    this.h.a(l3);
                                case 34:
                                    if ((i & 32) == 0) {
                                        this.k = new ArrayList();
                                        i |= 32;
                                    }
                                    this.k.add(codedInputStream.a(DescriptorProto.b, extensionRegistryLite));
                                case 42:
                                    if ((i & 64) == 0) {
                                        this.l = new ArrayList();
                                        i |= 64;
                                    }
                                    this.l.add(codedInputStream.a(EnumDescriptorProto.b, extensionRegistryLite));
                                case 50:
                                    if ((i & 128) == 0) {
                                        this.m = new ArrayList();
                                        i |= 128;
                                    }
                                    this.m.add(codedInputStream.a(ServiceDescriptorProto.b, extensionRegistryLite));
                                case 58:
                                    if ((i & 256) == 0) {
                                        this.n = new ArrayList();
                                        i |= 256;
                                    }
                                    this.n.add(codedInputStream.a(FieldDescriptorProto.b, extensionRegistryLite));
                                case 66:
                                    FileOptions.Builder L = (this.e & 4) != 0 ? this.o.L() : null;
                                    this.o = (FileOptions) codedInputStream.a(FileOptions.b, extensionRegistryLite);
                                    if (L != null) {
                                        L.a(this.o);
                                        this.o = L.g();
                                    }
                                    this.e |= 4;
                                case 74:
                                    SourceCodeInfo.Builder e = (this.e & 8) != 0 ? this.p.e() : null;
                                    this.p = (SourceCodeInfo) codedInputStream.a(SourceCodeInfo.b, extensionRegistryLite);
                                    if (e != null) {
                                        e.a(this.p);
                                        this.p = e.g();
                                    }
                                    this.e |= 8;
                                case 80:
                                    if ((i & 8) == 0) {
                                        this.i = new q();
                                        i |= 8;
                                    }
                                    this.i.d(codedInputStream.f());
                                case 82:
                                    int c = codedInputStream.c(codedInputStream.s());
                                    if ((i & 8) == 0 && codedInputStream.w() > 0) {
                                        this.i = new q();
                                        i |= 8;
                                    }
                                    while (codedInputStream.w() > 0) {
                                        this.i.d(codedInputStream.f());
                                    }
                                    codedInputStream.d(c);
                                    break;
                                case 88:
                                    if ((i & 16) == 0) {
                                        this.j = new q();
                                        i |= 16;
                                    }
                                    this.j.d(codedInputStream.f());
                                case 90:
                                    int c2 = codedInputStream.c(codedInputStream.s());
                                    if ((i & 16) == 0 && codedInputStream.w() > 0) {
                                        this.j = new q();
                                        i |= 16;
                                    }
                                    while (codedInputStream.w() > 0) {
                                        this.j.d(codedInputStream.f());
                                    }
                                    codedInputStream.d(c2);
                                    break;
                                case 98:
                                    ByteString l4 = codedInputStream.l();
                                    this.e |= 16;
                                    this.q = l4;
                                default:
                                    if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                                        z = true;
                                    }
                            }
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.a(this);
                        }
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3).a(this);
                    }
                } finally {
                    if ((i & 4) != 0) {
                        this.h = this.h.e();
                    }
                    if ((i & 32) != 0) {
                        this.k = Collections.unmodifiableList(this.k);
                    }
                    if ((i & 64) != 0) {
                        this.l = Collections.unmodifiableList(this.l);
                    }
                    if ((i & 128) != 0) {
                        this.m = Collections.unmodifiableList(this.m);
                    }
                    if ((i & 256) != 0) {
                        this.n = Collections.unmodifiableList(this.n);
                    }
                    if ((i & 8) != 0) {
                        this.i.b();
                    }
                    if ((i & 16) != 0) {
                        this.j.b();
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.d.a(FileDescriptorProto.class, Builder.class);
        }

        public final boolean e() {
            return (this.e & 1) != 0;
        }

        public final String f() {
            Object obj = this.f;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.f = f;
            }
            return f;
        }

        public final boolean g() {
            return (this.e & 2) != 0;
        }

        public final String h() {
            Object obj = this.g;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.g = f;
            }
            return f;
        }

        public final int i() {
            return this.h.size();
        }

        public final String a(int i) {
            return (String) this.h.get(i);
        }

        public final int j() {
            return this.i.size();
        }

        public final int b(int i) {
            return this.i.b(i);
        }

        public final int k() {
            return this.k.size();
        }

        public final DescriptorProto c(int i) {
            return this.k.get(i);
        }

        public final int l() {
            return this.l.size();
        }

        public final EnumDescriptorProto d(int i) {
            return this.l.get(i);
        }

        public final int m() {
            return this.m.size();
        }

        public final ServiceDescriptorProto e(int i) {
            return this.m.get(i);
        }

        public final int n() {
            return this.n.size();
        }

        public final FieldDescriptorProto f(int i) {
            return this.n.get(i);
        }

        public final boolean o() {
            return (this.e & 4) != 0;
        }

        public final FileOptions s() {
            FileOptions fileOptions = this.o;
            return fileOptions == null ? FileOptions.M() : fileOptions;
        }

        public final boolean t() {
            return (this.e & 8) != 0;
        }

        public final SourceCodeInfo u() {
            SourceCodeInfo sourceCodeInfo = this.p;
            return sourceCodeInfo == null ? SourceCodeInfo.f() : sourceCodeInfo;
        }

        public final boolean v() {
            return (this.e & 16) != 0;
        }

        public final String w() {
            Object obj = this.q;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.q = f;
            }
            return f;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.r;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.k.size(); i++) {
                if (!this.k.get(i).isInitialized()) {
                    this.r = (byte) 0;
                    return false;
                }
            }
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                if (!this.l.get(i2).isInitialized()) {
                    this.r = (byte) 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < this.m.size(); i3++) {
                if (!this.m.get(i3).isInitialized()) {
                    this.r = (byte) 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < this.n.size(); i4++) {
                if (!this.n.get(i4).isInitialized()) {
                    this.r = (byte) 0;
                    return false;
                }
            }
            if ((this.e & 4) != 0) {
                FileOptions fileOptions = this.o;
                if (fileOptions == null) {
                    fileOptions = FileOptions.M();
                }
                if (!fileOptions.isInitialized()) {
                    this.r = (byte) 0;
                    return false;
                }
            }
            this.r = (byte) 1;
            return true;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                if (obj instanceof String) {
                    codedOutputStream.a(1, (String) obj);
                } else {
                    codedOutputStream.a(1, (ByteString) obj);
                }
            }
            if ((this.e & 2) != 0) {
                Object obj2 = this.g;
                if (obj2 instanceof String) {
                    codedOutputStream.a(2, (String) obj2);
                } else {
                    codedOutputStream.a(2, (ByteString) obj2);
                }
            }
            for (int i = 0; i < this.h.size(); i++) {
                Object b2 = this.h.b(i);
                if (b2 instanceof String) {
                    codedOutputStream.a(3, (String) b2);
                } else {
                    codedOutputStream.a(3, (ByteString) b2);
                }
            }
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                codedOutputStream.a(4, this.k.get(i2));
            }
            for (int i3 = 0; i3 < this.l.size(); i3++) {
                codedOutputStream.a(5, this.l.get(i3));
            }
            for (int i4 = 0; i4 < this.m.size(); i4++) {
                codedOutputStream.a(6, this.m.get(i4));
            }
            for (int i5 = 0; i5 < this.n.size(); i5++) {
                codedOutputStream.a(7, this.n.get(i5));
            }
            if ((this.e & 4) != 0) {
                FileOptions fileOptions = this.o;
                if (fileOptions == null) {
                    fileOptions = FileOptions.M();
                }
                codedOutputStream.a(8, fileOptions);
            }
            if ((this.e & 8) != 0) {
                SourceCodeInfo sourceCodeInfo = this.p;
                if (sourceCodeInfo == null) {
                    sourceCodeInfo = SourceCodeInfo.f();
                }
                codedOutputStream.a(9, sourceCodeInfo);
            }
            for (int i6 = 0; i6 < this.i.size(); i6++) {
                codedOutputStream.b(10, this.i.b(i6));
            }
            for (int i7 = 0; i7 < this.j.size(); i7++) {
                codedOutputStream.b(11, this.j.b(i7));
            }
            if ((this.e & 16) != 0) {
                Object obj3 = this.q;
                if (obj3 instanceof String) {
                    codedOutputStream.a(12, (String) obj3);
                } else {
                    codedOutputStream.a(12, (ByteString) obj3);
                }
            }
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i;
            int i2 = this.f6632a;
            if (i2 != -1) {
                return i2;
            }
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                i = (obj instanceof String ? CodedOutputStream.b(1, (String) obj) : CodedOutputStream.c(1, (ByteString) obj)) + 0;
            } else {
                i = 0;
            }
            if ((this.e & 2) != 0) {
                Object obj2 = this.g;
                i += obj2 instanceof String ? CodedOutputStream.b(2, (String) obj2) : CodedOutputStream.c(2, (ByteString) obj2);
            }
            int i3 = 0;
            for (int i4 = 0; i4 < this.h.size(); i4++) {
                Object b2 = this.h.b(i4);
                i3 += b2 instanceof String ? CodedOutputStream.b((String) b2) : CodedOutputStream.b((ByteString) b2);
            }
            int size = i + i3 + (this.h.size() * 1);
            for (int i5 = 0; i5 < this.k.size(); i5++) {
                size += CodedOutputStream.c(4, this.k.get(i5));
            }
            for (int i6 = 0; i6 < this.l.size(); i6++) {
                size += CodedOutputStream.c(5, this.l.get(i6));
            }
            for (int i7 = 0; i7 < this.m.size(); i7++) {
                size += CodedOutputStream.c(6, this.m.get(i7));
            }
            for (int i8 = 0; i8 < this.n.size(); i8++) {
                size += CodedOutputStream.c(7, this.n.get(i8));
            }
            if ((this.e & 4) != 0) {
                FileOptions fileOptions = this.o;
                if (fileOptions == null) {
                    fileOptions = FileOptions.M();
                }
                size += CodedOutputStream.c(8, fileOptions);
            }
            if ((this.e & 8) != 0) {
                SourceCodeInfo sourceCodeInfo = this.p;
                if (sourceCodeInfo == null) {
                    sourceCodeInfo = SourceCodeInfo.f();
                }
                size += CodedOutputStream.c(9, sourceCodeInfo);
            }
            int i9 = 0;
            for (int i10 = 0; i10 < this.i.size(); i10++) {
                i9 += CodedOutputStream.i(this.i.b(i10));
            }
            int size2 = size + i9 + (this.i.size() * 1);
            int i11 = 0;
            for (int i12 = 0; i12 < this.j.size(); i12++) {
                i11 += CodedOutputStream.i(this.j.b(i12));
            }
            int size3 = size2 + i11 + (this.j.size() * 1);
            if ((this.e & 16) != 0) {
                Object obj3 = this.q;
                size3 += obj3 instanceof String ? CodedOutputStream.b(12, (String) obj3) : CodedOutputStream.c(12, (ByteString) obj3);
            }
            int serializedSize = size3 + this.d.getSerializedSize();
            this.f6632a = serializedSize;
            return serializedSize;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FileDescriptorProto)) {
                return super.equals(obj);
            }
            FileDescriptorProto fileDescriptorProto = (FileDescriptorProto) obj;
            if (((this.e & 1) != 0) != ((fileDescriptorProto.e & 1) != 0)) {
                return false;
            }
            if (((this.e & 1) != 0) && !f().equals(fileDescriptorProto.f())) {
                return false;
            }
            if (((this.e & 2) != 0) != ((fileDescriptorProto.e & 2) != 0)) {
                return false;
            }
            if ((((this.e & 2) != 0) && !h().equals(fileDescriptorProto.h())) || !this.h.equals(fileDescriptorProto.h) || !this.i.equals(fileDescriptorProto.i) || !this.j.equals(fileDescriptorProto.j) || !this.k.equals(fileDescriptorProto.k) || !this.l.equals(fileDescriptorProto.l) || !this.m.equals(fileDescriptorProto.m) || !this.n.equals(fileDescriptorProto.n)) {
                return false;
            }
            if (((this.e & 4) != 0) != ((fileDescriptorProto.e & 4) != 0)) {
                return false;
            }
            if ((this.e & 4) != 0) {
                FileOptions fileOptions = this.o;
                if (fileOptions == null) {
                    fileOptions = FileOptions.M();
                }
                FileOptions fileOptions2 = fileDescriptorProto.o;
                if (fileOptions2 == null) {
                    fileOptions2 = FileOptions.M();
                }
                if (!fileOptions.equals(fileOptions2)) {
                    return false;
                }
            }
            if (((this.e & 8) != 0) != ((fileDescriptorProto.e & 8) != 0)) {
                return false;
            }
            if ((this.e & 8) != 0) {
                SourceCodeInfo sourceCodeInfo = this.p;
                if (sourceCodeInfo == null) {
                    sourceCodeInfo = SourceCodeInfo.f();
                }
                SourceCodeInfo sourceCodeInfo2 = fileDescriptorProto.p;
                if (sourceCodeInfo2 == null) {
                    sourceCodeInfo2 = SourceCodeInfo.f();
                }
                if (!sourceCodeInfo.equals(sourceCodeInfo2)) {
                    return false;
                }
            }
            if (((this.e & 16) != 0) != ((fileDescriptorProto.e & 16) != 0)) {
                return false;
            }
            return (!((this.e & 16) != 0) || w().equals(fileDescriptorProto.w())) && this.d.equals(fileDescriptorProto.d);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.c.hashCode() + 779;
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + f().hashCode();
                }
                if ((this.e & 2) != 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + h().hashCode();
                }
                if (this.h.size() > 0) {
                    hashCode = (((hashCode * 37) + 3) * 53) + this.h.hashCode();
                }
                if (this.i.size() > 0) {
                    hashCode = (((hashCode * 37) + 10) * 53) + this.i.hashCode();
                }
                if (this.j.size() > 0) {
                    hashCode = (((hashCode * 37) + 11) * 53) + this.j.hashCode();
                }
                if (this.k.size() > 0) {
                    hashCode = (((hashCode * 37) + 4) * 53) + this.k.hashCode();
                }
                if (this.l.size() > 0) {
                    hashCode = (((hashCode * 37) + 5) * 53) + this.l.hashCode();
                }
                if (this.m.size() > 0) {
                    hashCode = (((hashCode * 37) + 6) * 53) + this.m.hashCode();
                }
                if (this.n.size() > 0) {
                    hashCode = (((hashCode * 37) + 7) * 53) + this.n.hashCode();
                }
                if ((this.e & 4) != 0) {
                    int i = ((hashCode * 37) + 8) * 53;
                    FileOptions fileOptions = this.o;
                    if (fileOptions == null) {
                        fileOptions = FileOptions.M();
                    }
                    hashCode = i + fileOptions.hashCode();
                }
                if ((this.e & 8) != 0) {
                    int i2 = ((hashCode * 37) + 9) * 53;
                    SourceCodeInfo sourceCodeInfo = this.p;
                    if (sourceCodeInfo == null) {
                        sourceCodeInfo = SourceCodeInfo.f();
                    }
                    hashCode = i2 + sourceCodeInfo.hashCode();
                }
                if ((this.e & 16) != 0) {
                    hashCode = (((hashCode * 37) + 12) * 53) + w().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.d.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }
            return this.memoizedHashCode;
        }

        public static FileDescriptorProto a(byte[] bArr) throws InvalidProtocolBufferException {
            return b.a(bArr);
        }

        private static Builder z() {
            FileDescriptorProto fileDescriptorProto = s;
            byte b2 = 0;
            return fileDescriptorProto == fileDescriptorProto ? new Builder(b2) : new Builder(b2).a(fileDescriptorProto);
        }

        public static Builder x() {
            FileDescriptorProto fileDescriptorProto = s;
            byte b2 = 0;
            return fileDescriptorProto == fileDescriptorProto ? new Builder(b2) : new Builder(b2).a(fileDescriptorProto);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FileDescriptorProtoOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6657a;
            private Object b;
            private Object c;
            private LazyStringList d;
            private Internal.IntList e;
            private Internal.IntList f;
            private List<DescriptorProto> g;
            private RepeatedFieldBuilderV3<DescriptorProto, DescriptorProto.Builder, DescriptorProtoOrBuilder> h;
            private List<EnumDescriptorProto> i;
            private RepeatedFieldBuilderV3<EnumDescriptorProto, EnumDescriptorProto.Builder, EnumDescriptorProtoOrBuilder> j;
            private List<ServiceDescriptorProto> k;
            private RepeatedFieldBuilderV3<ServiceDescriptorProto, ServiceDescriptorProto.Builder, ServiceDescriptorProtoOrBuilder> l;
            private List<FieldDescriptorProto> m;
            private RepeatedFieldBuilderV3<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> n;
            private FileOptions o;
            private SingleFieldBuilderV3<FileOptions, FileOptions.Builder, FileOptionsOrBuilder> p;
            private SourceCodeInfo q;
            private SingleFieldBuilderV3<SourceCodeInfo, SourceCodeInfo.Builder, SourceCodeInfoOrBuilder> r;
            private Object s;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof FileDescriptorProto) {
                    return a((FileDescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                FileDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof FileDescriptorProto) {
                    return a((FileDescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return FileDescriptorProto.y();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                FileDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return FileDescriptorProto.y();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.d.a(FileDescriptorProto.class, Builder.class);
            }

            private Builder() {
                this.b = "";
                this.c = "";
                this.d = LazyStringArrayList.f6738a;
                this.e = GeneratedMessageV3.O();
                this.f = GeneratedMessageV3.O();
                this.g = Collections.emptyList();
                this.i = Collections.emptyList();
                this.k = Collections.emptyList();
                this.m = Collections.emptyList();
                this.s = "";
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = "";
                this.c = "";
                this.d = LazyStringArrayList.f6738a;
                this.e = GeneratedMessageV3.O();
                this.f = GeneratedMessageV3.O();
                this.g = Collections.emptyList();
                this.i = Collections.emptyList();
                this.k = Collections.emptyList();
                this.m = Collections.emptyList();
                this.s = "";
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.c;
            }

            public final FileDescriptorProto e() {
                FileDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public FileDescriptorProto g() {
                FileDescriptorProto fileDescriptorProto = new FileDescriptorProto((GeneratedMessageV3.Builder) this, (byte) (0 == true ? 1 : 0));
                int i = this.f6657a;
                int i2 = (i & 1) != 0 ? 1 : 0;
                fileDescriptorProto.f = this.b;
                if ((i & 2) != 0) {
                    i2 |= 2;
                }
                fileDescriptorProto.g = this.c;
                if ((this.f6657a & 4) != 0) {
                    this.d = this.d.e();
                    this.f6657a &= -5;
                }
                fileDescriptorProto.h = this.d;
                if ((this.f6657a & 8) != 0) {
                    this.e.b();
                    this.f6657a &= -9;
                }
                fileDescriptorProto.i = this.e;
                if ((this.f6657a & 16) != 0) {
                    this.f.b();
                    this.f6657a &= -17;
                }
                fileDescriptorProto.j = this.f;
                RepeatedFieldBuilderV3<DescriptorProto, DescriptorProto.Builder, DescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.h;
                if (repeatedFieldBuilderV3 != null) {
                    fileDescriptorProto.k = repeatedFieldBuilderV3.e();
                } else {
                    if ((this.f6657a & 32) != 0) {
                        this.g = Collections.unmodifiableList(this.g);
                        this.f6657a &= -33;
                    }
                    fileDescriptorProto.k = this.g;
                }
                RepeatedFieldBuilderV3<EnumDescriptorProto, EnumDescriptorProto.Builder, EnumDescriptorProtoOrBuilder> repeatedFieldBuilderV32 = this.j;
                if (repeatedFieldBuilderV32 != null) {
                    fileDescriptorProto.l = repeatedFieldBuilderV32.e();
                } else {
                    if ((this.f6657a & 64) != 0) {
                        this.i = Collections.unmodifiableList(this.i);
                        this.f6657a &= -65;
                    }
                    fileDescriptorProto.l = this.i;
                }
                RepeatedFieldBuilderV3<ServiceDescriptorProto, ServiceDescriptorProto.Builder, ServiceDescriptorProtoOrBuilder> repeatedFieldBuilderV33 = this.l;
                if (repeatedFieldBuilderV33 != null) {
                    fileDescriptorProto.m = repeatedFieldBuilderV33.e();
                } else {
                    if ((this.f6657a & 128) != 0) {
                        this.k = Collections.unmodifiableList(this.k);
                        this.f6657a &= -129;
                    }
                    fileDescriptorProto.m = this.k;
                }
                RepeatedFieldBuilderV3<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> repeatedFieldBuilderV34 = this.n;
                if (repeatedFieldBuilderV34 != null) {
                    fileDescriptorProto.n = repeatedFieldBuilderV34.e();
                } else {
                    if ((this.f6657a & 256) != 0) {
                        this.m = Collections.unmodifiableList(this.m);
                        this.f6657a &= -257;
                    }
                    fileDescriptorProto.n = this.m;
                }
                if ((i & 512) != 0) {
                    SingleFieldBuilderV3<FileOptions, FileOptions.Builder, FileOptionsOrBuilder> singleFieldBuilderV3 = this.p;
                    if (singleFieldBuilderV3 == null) {
                        fileDescriptorProto.o = this.o;
                    } else {
                        fileDescriptorProto.o = singleFieldBuilderV3.c();
                    }
                    i2 |= 4;
                }
                if ((i & 1024) != 0) {
                    SingleFieldBuilderV3<SourceCodeInfo, SourceCodeInfo.Builder, SourceCodeInfoOrBuilder> singleFieldBuilderV32 = this.r;
                    if (singleFieldBuilderV32 == null) {
                        fileDescriptorProto.p = this.q;
                    } else {
                        fileDescriptorProto.p = singleFieldBuilderV32.c();
                    }
                    i2 |= 8;
                }
                if ((i & ProgressEvent.PART_COMPLETED_EVENT_CODE) != 0) {
                    i2 |= 16;
                }
                fileDescriptorProto.q = this.s;
                fileDescriptorProto.e = i2;
                i();
                return fileDescriptorProto;
            }

            public final Builder a(FileDescriptorProto fileDescriptorProto) {
                SourceCodeInfo sourceCodeInfo;
                FileOptions fileOptions;
                if (fileDescriptorProto == FileDescriptorProto.y()) {
                    return this;
                }
                if (fileDescriptorProto.e()) {
                    this.f6657a |= 1;
                    this.b = fileDescriptorProto.f;
                    j();
                }
                if (fileDescriptorProto.g()) {
                    this.f6657a |= 2;
                    this.c = fileDescriptorProto.g;
                    j();
                }
                if (!fileDescriptorProto.h.isEmpty()) {
                    if (this.d.isEmpty()) {
                        this.d = fileDescriptorProto.h;
                        this.f6657a &= -5;
                    } else {
                        if ((this.f6657a & 4) == 0) {
                            this.d = new LazyStringArrayList(this.d);
                            this.f6657a |= 4;
                        }
                        this.d.addAll(fileDescriptorProto.h);
                    }
                    j();
                }
                if (!fileDescriptorProto.i.isEmpty()) {
                    if (this.e.isEmpty()) {
                        this.e = fileDescriptorProto.i;
                        this.f6657a &= -9;
                    } else {
                        if ((this.f6657a & 8) == 0) {
                            this.e = GeneratedMessageV3.a(this.e);
                            this.f6657a |= 8;
                        }
                        this.e.addAll(fileDescriptorProto.i);
                    }
                    j();
                }
                if (!fileDescriptorProto.j.isEmpty()) {
                    if (this.f.isEmpty()) {
                        this.f = fileDescriptorProto.j;
                        this.f6657a &= -17;
                    } else {
                        if ((this.f6657a & 16) == 0) {
                            this.f = GeneratedMessageV3.a(this.f);
                            this.f6657a |= 16;
                        }
                        this.f.addAll(fileDescriptorProto.j);
                    }
                    j();
                }
                if (this.h == null) {
                    if (!fileDescriptorProto.k.isEmpty()) {
                        if (this.g.isEmpty()) {
                            this.g = fileDescriptorProto.k;
                            this.f6657a &= -33;
                        } else {
                            n();
                            this.g.addAll(fileDescriptorProto.k);
                        }
                        j();
                    }
                } else if (!fileDescriptorProto.k.isEmpty()) {
                    if (!this.h.d()) {
                        this.h.a(fileDescriptorProto.k);
                    } else {
                        this.h.b();
                        this.h = null;
                        this.g = fileDescriptorProto.k;
                        this.f6657a &= -33;
                        this.h = null;
                    }
                }
                if (this.j == null) {
                    if (!fileDescriptorProto.l.isEmpty()) {
                        if (this.i.isEmpty()) {
                            this.i = fileDescriptorProto.l;
                            this.f6657a &= -65;
                        } else {
                            if ((this.f6657a & 64) == 0) {
                                this.i = new ArrayList(this.i);
                                this.f6657a |= 64;
                            }
                            this.i.addAll(fileDescriptorProto.l);
                        }
                        j();
                    }
                } else if (!fileDescriptorProto.l.isEmpty()) {
                    if (!this.j.d()) {
                        this.j.a(fileDescriptorProto.l);
                    } else {
                        this.j.b();
                        this.j = null;
                        this.i = fileDescriptorProto.l;
                        this.f6657a &= -65;
                        this.j = null;
                    }
                }
                if (this.l == null) {
                    if (!fileDescriptorProto.m.isEmpty()) {
                        if (this.k.isEmpty()) {
                            this.k = fileDescriptorProto.m;
                            this.f6657a &= -129;
                        } else {
                            if ((this.f6657a & 128) == 0) {
                                this.k = new ArrayList(this.k);
                                this.f6657a |= 128;
                            }
                            this.k.addAll(fileDescriptorProto.m);
                        }
                        j();
                    }
                } else if (!fileDescriptorProto.m.isEmpty()) {
                    if (!this.l.d()) {
                        this.l.a(fileDescriptorProto.m);
                    } else {
                        this.l.b();
                        this.l = null;
                        this.k = fileDescriptorProto.m;
                        this.f6657a &= -129;
                        this.l = null;
                    }
                }
                if (this.n == null) {
                    if (!fileDescriptorProto.n.isEmpty()) {
                        if (this.m.isEmpty()) {
                            this.m = fileDescriptorProto.n;
                            this.f6657a &= -257;
                        } else {
                            if ((this.f6657a & 256) == 0) {
                                this.m = new ArrayList(this.m);
                                this.f6657a |= 256;
                            }
                            this.m.addAll(fileDescriptorProto.n);
                        }
                        j();
                    }
                } else if (!fileDescriptorProto.n.isEmpty()) {
                    if (!this.n.d()) {
                        this.n.a(fileDescriptorProto.n);
                    } else {
                        this.n.b();
                        this.n = null;
                        this.m = fileDescriptorProto.n;
                        this.f6657a &= -257;
                        this.n = null;
                    }
                }
                if (fileDescriptorProto.o()) {
                    FileOptions s = fileDescriptorProto.s();
                    SingleFieldBuilderV3<FileOptions, FileOptions.Builder, FileOptionsOrBuilder> singleFieldBuilderV3 = this.p;
                    if (singleFieldBuilderV3 == null) {
                        if ((this.f6657a & 512) != 0 && (fileOptions = this.o) != null && fileOptions != FileOptions.M()) {
                            s = FileOptions.a(this.o).a(s).g();
                        }
                        this.o = s;
                        j();
                    } else {
                        singleFieldBuilderV3.a(s);
                    }
                    this.f6657a |= 512;
                }
                if (fileDescriptorProto.t()) {
                    SourceCodeInfo u = fileDescriptorProto.u();
                    SingleFieldBuilderV3<SourceCodeInfo, SourceCodeInfo.Builder, SourceCodeInfoOrBuilder> singleFieldBuilderV32 = this.r;
                    if (singleFieldBuilderV32 == null) {
                        if ((this.f6657a & 1024) != 0 && (sourceCodeInfo = this.q) != null && sourceCodeInfo != SourceCodeInfo.f()) {
                            u = SourceCodeInfo.a(this.q).a(u).g();
                        }
                        this.q = u;
                        j();
                    } else {
                        singleFieldBuilderV32.a(u);
                    }
                    this.f6657a |= 1024;
                }
                if (fileDescriptorProto.v()) {
                    this.f6657a |= ProgressEvent.PART_COMPLETED_EVENT_CODE;
                    this.s = fileDescriptorProto.q;
                    j();
                }
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int i = 0;
                while (true) {
                    RepeatedFieldBuilderV3<DescriptorProto, DescriptorProto.Builder, DescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.h;
                    if (i < (repeatedFieldBuilderV3 == null ? this.g.size() : repeatedFieldBuilderV3.c())) {
                        RepeatedFieldBuilderV3<DescriptorProto, DescriptorProto.Builder, DescriptorProtoOrBuilder> repeatedFieldBuilderV32 = this.h;
                        if (!(repeatedFieldBuilderV32 == null ? this.g.get(i) : repeatedFieldBuilderV32.a(i)).isInitialized()) {
                            return false;
                        }
                        i++;
                    } else {
                        int i2 = 0;
                        while (true) {
                            RepeatedFieldBuilderV3<EnumDescriptorProto, EnumDescriptorProto.Builder, EnumDescriptorProtoOrBuilder> repeatedFieldBuilderV33 = this.j;
                            if (i2 < (repeatedFieldBuilderV33 == null ? this.i.size() : repeatedFieldBuilderV33.c())) {
                                RepeatedFieldBuilderV3<EnumDescriptorProto, EnumDescriptorProto.Builder, EnumDescriptorProtoOrBuilder> repeatedFieldBuilderV34 = this.j;
                                if (!(repeatedFieldBuilderV34 == null ? this.i.get(i2) : repeatedFieldBuilderV34.a(i2)).isInitialized()) {
                                    return false;
                                }
                                i2++;
                            } else {
                                int i3 = 0;
                                while (true) {
                                    RepeatedFieldBuilderV3<ServiceDescriptorProto, ServiceDescriptorProto.Builder, ServiceDescriptorProtoOrBuilder> repeatedFieldBuilderV35 = this.l;
                                    if (i3 < (repeatedFieldBuilderV35 == null ? this.k.size() : repeatedFieldBuilderV35.c())) {
                                        RepeatedFieldBuilderV3<ServiceDescriptorProto, ServiceDescriptorProto.Builder, ServiceDescriptorProtoOrBuilder> repeatedFieldBuilderV36 = this.l;
                                        if (!(repeatedFieldBuilderV36 == null ? this.k.get(i3) : repeatedFieldBuilderV36.a(i3)).isInitialized()) {
                                            return false;
                                        }
                                        i3++;
                                    } else {
                                        int i4 = 0;
                                        while (true) {
                                            RepeatedFieldBuilderV3<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> repeatedFieldBuilderV37 = this.n;
                                            if (i4 >= (repeatedFieldBuilderV37 == null ? this.m.size() : repeatedFieldBuilderV37.c())) {
                                                return !((this.f6657a & 512) != 0) || o().isInitialized();
                                            }
                                            RepeatedFieldBuilderV3<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> repeatedFieldBuilderV38 = this.n;
                                            if (!(repeatedFieldBuilderV38 == null ? this.m.get(i4) : repeatedFieldBuilderV38.a(i4)).isInitialized()) {
                                                return false;
                                            }
                                            i4++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.FileDescriptorProto.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$FileDescriptorProto> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.FileDescriptorProto.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$FileDescriptorProto r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.FileDescriptorProto) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$FileDescriptorProto r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.FileDescriptorProto) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.FileDescriptorProto.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$FileDescriptorProto$Builder");
            }

            public final Builder a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f6657a |= 1;
                this.b = str;
                j();
                return this;
            }

            public final Builder b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f6657a |= 2;
                this.c = str;
                j();
                return this;
            }

            private void n() {
                if ((this.f6657a & 32) == 0) {
                    this.g = new ArrayList(this.g);
                    this.f6657a |= 32;
                }
            }

            public final Builder a(DescriptorProto descriptorProto) {
                RepeatedFieldBuilderV3<DescriptorProto, DescriptorProto.Builder, DescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.h;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.a((RepeatedFieldBuilderV3<DescriptorProto, DescriptorProto.Builder, DescriptorProtoOrBuilder>) descriptorProto);
                } else {
                    if (descriptorProto == null) {
                        throw new NullPointerException();
                    }
                    n();
                    this.g.add(descriptorProto);
                    j();
                }
                return this;
            }

            private FileOptions o() {
                SingleFieldBuilderV3<FileOptions, FileOptions.Builder, FileOptionsOrBuilder> singleFieldBuilderV3 = this.p;
                if (singleFieldBuilderV3 == null) {
                    FileOptions fileOptions = this.o;
                    return fileOptions == null ? FileOptions.M() : fileOptions;
                }
                return singleFieldBuilderV3.b();
            }
        }

        public static FileDescriptorProto y() {
            return s;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<FileDescriptorProto> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class DescriptorProto extends GeneratedMessageV3 implements DescriptorProtoOrBuilder {
        private int e;
        private volatile Object f;
        private List<FieldDescriptorProto> g;
        private List<FieldDescriptorProto> h;
        private List<DescriptorProto> i;
        private List<EnumDescriptorProto> j;
        private List<ExtensionRange> k;
        private List<OneofDescriptorProto> l;
        private MessageOptions m;
        private List<ReservedRange> n;
        private LazyStringList o;
        private byte p;
        private static final DescriptorProto q = new DescriptorProto();

        @Deprecated
        public static final Parser<DescriptorProto> b = new AbstractParser<DescriptorProto>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new DescriptorProto(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* loaded from: classes3.dex */
        public interface ExtensionRangeOrBuilder extends MessageOrBuilder {
        }

        /* loaded from: classes3.dex */
        public interface ReservedRangeOrBuilder extends MessageOrBuilder {
        }

        /* synthetic */ DescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ DescriptorProto(GeneratedMessageV3.Builder builder, byte b2) {
            this(builder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return q;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return s();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == q ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return s();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return q;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == q ? new Builder(b2) : new Builder(b2).a(this);
        }

        private DescriptorProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.p = (byte) -1;
        }

        private DescriptorProto() {
            this.p = (byte) -1;
            this.f = "";
            this.g = Collections.emptyList();
            this.h = Collections.emptyList();
            this.i = Collections.emptyList();
            this.j = Collections.emptyList();
            this.k = Collections.emptyList();
            this.l = Collections.emptyList();
            this.n = Collections.emptyList();
            this.o = LazyStringArrayList.f6738a;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new DescriptorProto();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0012. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private DescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            int i = 0;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        switch (a3) {
                            case 0:
                                z = true;
                            case 10:
                                ByteString l = codedInputStream.l();
                                this.e |= 1;
                                this.f = l;
                            case 18:
                                if ((i & 2) == 0) {
                                    this.g = new ArrayList();
                                    i |= 2;
                                }
                                this.g.add(codedInputStream.a(FieldDescriptorProto.b, extensionRegistryLite));
                            case 26:
                                if ((i & 8) == 0) {
                                    this.i = new ArrayList();
                                    i |= 8;
                                }
                                this.i.add(codedInputStream.a(b, extensionRegistryLite));
                            case 34:
                                if ((i & 16) == 0) {
                                    this.j = new ArrayList();
                                    i |= 16;
                                }
                                this.j.add(codedInputStream.a(EnumDescriptorProto.b, extensionRegistryLite));
                            case 42:
                                if ((i & 32) == 0) {
                                    this.k = new ArrayList();
                                    i |= 32;
                                }
                                this.k.add(codedInputStream.a(ExtensionRange.b, extensionRegistryLite));
                            case 50:
                                if ((i & 4) == 0) {
                                    this.h = new ArrayList();
                                    i |= 4;
                                }
                                this.h.add(codedInputStream.a(FieldDescriptorProto.b, extensionRegistryLite));
                            case 58:
                                MessageOptions.Builder m = (this.e & 2) != 0 ? this.m.m() : null;
                                this.m = (MessageOptions) codedInputStream.a(MessageOptions.b, extensionRegistryLite);
                                if (m != null) {
                                    m.a(this.m);
                                    this.m = m.g();
                                }
                                this.e |= 2;
                            case 66:
                                if ((i & 64) == 0) {
                                    this.l = new ArrayList();
                                    i |= 64;
                                }
                                this.l.add(codedInputStream.a(OneofDescriptorProto.b, extensionRegistryLite));
                            case 74:
                                if ((i & 256) == 0) {
                                    this.n = new ArrayList();
                                    i |= 256;
                                }
                                this.n.add(codedInputStream.a(ReservedRange.b, extensionRegistryLite));
                            case 82:
                                ByteString l2 = codedInputStream.l();
                                if ((i & 512) == 0) {
                                    this.o = new LazyStringArrayList();
                                    i |= 512;
                                }
                                this.o.a(l2);
                            default:
                                if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                                    z = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if ((i & 2) != 0) {
                        this.g = Collections.unmodifiableList(this.g);
                    }
                    if ((i & 8) != 0) {
                        this.i = Collections.unmodifiableList(this.i);
                    }
                    if ((i & 16) != 0) {
                        this.j = Collections.unmodifiableList(this.j);
                    }
                    if ((i & 32) != 0) {
                        this.k = Collections.unmodifiableList(this.k);
                    }
                    if ((i & 4) != 0) {
                        this.h = Collections.unmodifiableList(this.h);
                    }
                    if ((i & 64) != 0) {
                        this.l = Collections.unmodifiableList(this.l);
                    }
                    if ((i & 256) != 0) {
                        this.n = Collections.unmodifiableList(this.n);
                    }
                    if ((i & 512) != 0) {
                        this.o = this.o.e();
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.f.a(DescriptorProto.class, Builder.class);
        }

        /* loaded from: classes3.dex */
        public static final class ExtensionRange extends GeneratedMessageV3 implements ExtensionRangeOrBuilder {
            private int e;
            private int f;
            private int g;
            private ExtensionRangeOptions h;
            private byte i;
            private static final ExtensionRange j = new ExtensionRange();

            @Deprecated
            public static final Parser<ExtensionRange> b = new AbstractParser<ExtensionRange>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.ExtensionRange.1
                @Override // com.uqm.crashsight.protobuf.Parser
                public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new ExtensionRange(codedInputStream, extensionRegistryLite, (byte) 0);
                }
            };

            /* synthetic */ ExtensionRange(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
                this(codedInputStream, extensionRegistryLite);
            }

            /* synthetic */ ExtensionRange(GeneratedMessageV3.Builder builder, byte b2) {
                this(builder);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
                return new Builder(builderParent, (byte) 0);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* bridge */ /* synthetic */ MessageLite r() {
                return j;
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite
            public final /* synthetic */ MessageLite.Builder newBuilderForType() {
                return m();
            }

            @Override // com.uqm.crashsight.protobuf.Message
            public final /* synthetic */ Message.Builder p() {
                byte b2 = 0;
                return this == j ? new Builder(b2) : new Builder(b2).a(this);
            }

            @Override // com.uqm.crashsight.protobuf.Message
            public final /* synthetic */ Message.Builder q() {
                return m();
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* bridge */ /* synthetic */ Message r() {
                return j;
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite
            public final /* synthetic */ MessageLite.Builder toBuilder() {
                byte b2 = 0;
                return this == j ? new Builder(b2) : new Builder(b2).a(this);
            }

            private ExtensionRange(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.i = (byte) -1;
            }

            private ExtensionRange() {
                this.i = (byte) -1;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final Object a() {
                return new ExtensionRange();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final UnknownFieldSet b() {
                return this.d;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private ExtensionRange(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                if (extensionRegistryLite == null) {
                    throw new NullPointerException();
                }
                UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int a3 = codedInputStream.a();
                            if (a3 == 0) {
                                z = true;
                            } else if (a3 == 8) {
                                this.e |= 1;
                                this.f = codedInputStream.f();
                            } else if (a3 == 16) {
                                this.e |= 2;
                                this.g = codedInputStream.f();
                            } else if (a3 == 26) {
                                ExtensionRangeOptions.Builder e = (this.e & 4) != 0 ? this.h.e() : null;
                                this.h = (ExtensionRangeOptions) codedInputStream.a(ExtensionRangeOptions.b, extensionRegistryLite);
                                if (e != null) {
                                    e.a(this.h);
                                    this.h = e.g();
                                }
                                this.e |= 4;
                            } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                                z = true;
                            }
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.a(this);
                        } catch (IOException e3) {
                            throw new InvalidProtocolBufferException(e3).a(this);
                        }
                    } finally {
                        this.d = a2.build();
                        P();
                    }
                }
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.h.a(ExtensionRange.class, Builder.class);
            }

            public final boolean e() {
                return (this.e & 1) != 0;
            }

            public final int f() {
                return this.f;
            }

            public final boolean g() {
                return (this.e & 2) != 0;
            }

            public final int h() {
                return this.g;
            }

            public final boolean i() {
                return (this.e & 4) != 0;
            }

            public final ExtensionRangeOptions j() {
                ExtensionRangeOptions extensionRangeOptions = this.h;
                return extensionRangeOptions == null ? ExtensionRangeOptions.f() : extensionRangeOptions;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b2 = this.i;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                if ((this.e & 4) != 0) {
                    ExtensionRangeOptions extensionRangeOptions = this.h;
                    if (extensionRangeOptions == null) {
                        extensionRangeOptions = ExtensionRangeOptions.f();
                    }
                    if (!extensionRangeOptions.isInitialized()) {
                        this.i = (byte) 0;
                        return false;
                    }
                }
                this.i = (byte) 1;
                return true;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
            public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.e & 1) != 0) {
                    codedOutputStream.b(1, this.f);
                }
                if ((this.e & 2) != 0) {
                    codedOutputStream.b(2, this.g);
                }
                if ((this.e & 4) != 0) {
                    ExtensionRangeOptions extensionRangeOptions = this.h;
                    if (extensionRangeOptions == null) {
                        extensionRangeOptions = ExtensionRangeOptions.f();
                    }
                    codedOutputStream.a(3, extensionRangeOptions);
                }
                this.d.writeTo(codedOutputStream);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
            public final int getSerializedSize() {
                int i = this.f6632a;
                if (i != -1) {
                    return i;
                }
                int h = (this.e & 1) != 0 ? 0 + CodedOutputStream.h(1, this.f) : 0;
                if ((this.e & 2) != 0) {
                    h += CodedOutputStream.h(2, this.g);
                }
                if ((this.e & 4) != 0) {
                    ExtensionRangeOptions extensionRangeOptions = this.h;
                    if (extensionRangeOptions == null) {
                        extensionRangeOptions = ExtensionRangeOptions.f();
                    }
                    h += CodedOutputStream.c(3, extensionRangeOptions);
                }
                int serializedSize = h + this.d.getSerializedSize();
                this.f6632a = serializedSize;
                return serializedSize;
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage
            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof ExtensionRange)) {
                    return super.equals(obj);
                }
                ExtensionRange extensionRange = (ExtensionRange) obj;
                if (((this.e & 1) != 0) != ((extensionRange.e & 1) != 0)) {
                    return false;
                }
                if (((this.e & 1) != 0) && this.f != extensionRange.f) {
                    return false;
                }
                if (((this.e & 2) != 0) != ((extensionRange.e & 2) != 0)) {
                    return false;
                }
                if (((this.e & 2) != 0) && this.g != extensionRange.g) {
                    return false;
                }
                if (((this.e & 4) != 0) != ((extensionRange.e & 4) != 0)) {
                    return false;
                }
                if ((this.e & 4) != 0) {
                    ExtensionRangeOptions extensionRangeOptions = this.h;
                    if (extensionRangeOptions == null) {
                        extensionRangeOptions = ExtensionRangeOptions.f();
                    }
                    ExtensionRangeOptions extensionRangeOptions2 = extensionRange.h;
                    if (extensionRangeOptions2 == null) {
                        extensionRangeOptions2 = ExtensionRangeOptions.f();
                    }
                    if (!extensionRangeOptions.equals(extensionRangeOptions2)) {
                        return false;
                    }
                }
                return this.d.equals(extensionRange.d);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage
            public final int hashCode() {
                if (this.memoizedHashCode == 0) {
                    int hashCode = DescriptorProtos.g.hashCode() + 779;
                    if ((this.e & 1) != 0) {
                        hashCode = (((hashCode * 37) + 1) * 53) + this.f;
                    }
                    if ((this.e & 2) != 0) {
                        hashCode = (((hashCode * 37) + 2) * 53) + this.g;
                    }
                    if ((this.e & 4) != 0) {
                        int i = ((hashCode * 37) + 3) * 53;
                        ExtensionRangeOptions extensionRangeOptions = this.h;
                        if (extensionRangeOptions == null) {
                            extensionRangeOptions = ExtensionRangeOptions.f();
                        }
                        hashCode = i + extensionRangeOptions.hashCode();
                    }
                    int hashCode2 = (hashCode * 29) + this.d.hashCode();
                    this.memoizedHashCode = hashCode2;
                    return hashCode2;
                }
                return this.memoizedHashCode;
            }

            private static Builder m() {
                ExtensionRange extensionRange = j;
                byte b2 = 0;
                return extensionRange == extensionRange ? new Builder(b2) : new Builder(b2).a(extensionRange);
            }

            public static Builder k() {
                ExtensionRange extensionRange = j;
                byte b2 = 0;
                return extensionRange == extensionRange ? new Builder(b2) : new Builder(b2).a(extensionRange);
            }

            /* loaded from: classes3.dex */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ExtensionRangeOrBuilder {

                /* renamed from: a, reason: collision with root package name */
                private int f6643a;
                private int b;
                private int c;
                private ExtensionRangeOptions d;
                private SingleFieldBuilderV3<ExtensionRangeOptions, ExtensionRangeOptions.Builder, ExtensionRangeOptionsOrBuilder> e;

                /* synthetic */ Builder(byte b) {
                    this();
                }

                /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                    this(builderParent);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
                /* renamed from: a */
                public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                    if (message instanceof ExtensionRange) {
                        return a((ExtensionRange) message);
                    }
                    super.internalMergeFrom(message);
                    return this;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
                public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.a(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.c(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: b */
                public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.d(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: b */
                public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.a(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
                /* renamed from: build */
                public final /* synthetic */ MessageLite h() {
                    ExtensionRange g = g();
                    if (g.isInitialized()) {
                        return g;
                    }
                    throw new UninitializedMessageException(MessageReflection.b(g));
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: c */
                public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.d(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.c(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
                /* renamed from: c */
                public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                    if (message instanceof ExtensionRange) {
                        return a((ExtensionRange) message);
                    }
                    super.internalMergeFrom(message);
                    return this;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ MessageLite.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.d(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.d(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: f */
                public final /* bridge */ /* synthetic */ Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
                /* renamed from: getDefaultInstanceForType */
                public final /* synthetic */ MessageLite r() {
                    return ExtensionRange.l();
                }

                @Override // com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message h() {
                    ExtensionRange g = g();
                    if (g.isInitialized()) {
                        return g;
                    }
                    throw new UninitializedMessageException(MessageReflection.b(g));
                }

                @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
                public final /* synthetic */ Message r() {
                    return ExtensionRange.l();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                protected final GeneratedMessageV3.FieldAccessorTable c() {
                    return DescriptorProtos.h.a(ExtensionRange.class, Builder.class);
                }

                private Builder() {
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
                public final Descriptors.Descriptor d() {
                    return DescriptorProtos.g;
                }

                public final ExtensionRange e() {
                    ExtensionRange g = g();
                    if (g.isInitialized()) {
                        return g;
                    }
                    throw new UninitializedMessageException(MessageReflection.b(g));
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.uqm.crashsight.protobuf.Message.Builder
                /* renamed from: m, reason: merged with bridge method [inline-methods] */
                public ExtensionRange g() {
                    int i = 0;
                    ExtensionRange extensionRange = new ExtensionRange((GeneratedMessageV3.Builder) this, (byte) (0 == true ? 1 : 0));
                    int i2 = this.f6643a;
                    if ((i2 & 1) != 0) {
                        extensionRange.f = this.b;
                        i = 1;
                    }
                    if ((i2 & 2) != 0) {
                        extensionRange.g = this.c;
                        i |= 2;
                    }
                    if ((i2 & 4) != 0) {
                        SingleFieldBuilderV3<ExtensionRangeOptions, ExtensionRangeOptions.Builder, ExtensionRangeOptionsOrBuilder> singleFieldBuilderV3 = this.e;
                        if (singleFieldBuilderV3 == null) {
                            extensionRange.h = this.d;
                        } else {
                            extensionRange.h = singleFieldBuilderV3.c();
                        }
                        i |= 4;
                    }
                    extensionRange.e = i;
                    i();
                    return extensionRange;
                }

                public final Builder a(ExtensionRange extensionRange) {
                    ExtensionRangeOptions extensionRangeOptions;
                    if (extensionRange == ExtensionRange.l()) {
                        return this;
                    }
                    if (extensionRange.e()) {
                        int f = extensionRange.f();
                        this.f6643a |= 1;
                        this.b = f;
                        j();
                    }
                    if (extensionRange.g()) {
                        int h = extensionRange.h();
                        this.f6643a |= 2;
                        this.c = h;
                        j();
                    }
                    if (extensionRange.i()) {
                        ExtensionRangeOptions j = extensionRange.j();
                        SingleFieldBuilderV3<ExtensionRangeOptions, ExtensionRangeOptions.Builder, ExtensionRangeOptionsOrBuilder> singleFieldBuilderV3 = this.e;
                        if (singleFieldBuilderV3 == null) {
                            if ((this.f6643a & 4) != 0 && (extensionRangeOptions = this.d) != null && extensionRangeOptions != ExtensionRangeOptions.f()) {
                                j = ExtensionRangeOptions.a(this.d).a(j).g();
                            }
                            this.d = j;
                            j();
                        } else {
                            singleFieldBuilderV3.a(j);
                        }
                        this.f6643a |= 4;
                    }
                    j();
                    return this;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return !((this.f6643a & 4) != 0) || n().isInitialized();
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.ExtensionRange.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.ExtensionRange.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        com.uqm.crashsight.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.ExtensionRange) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        if (r3 == 0) goto Le
                        r2.a(r3)
                    Le:
                        return r2
                    Lf:
                        r3 = move-exception
                        goto L1f
                    L11:
                        r3 = move-exception
                        com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                        com.uqm.crashsight.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.ExtensionRange) r4     // Catch: java.lang.Throwable -> Lf
                        java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                        throw r3     // Catch: java.lang.Throwable -> L1d
                    L1d:
                        r3 = move-exception
                        r0 = r4
                    L1f:
                        if (r0 == 0) goto L24
                        r2.a(r0)
                    L24:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.ExtensionRange.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$DescriptorProto$ExtensionRange$Builder");
                }

                public final Builder a(int i) {
                    this.f6643a |= 1;
                    this.b = i;
                    j();
                    return this;
                }

                public final Builder b(int i) {
                    this.f6643a |= 2;
                    this.c = i;
                    j();
                    return this;
                }

                private ExtensionRangeOptions n() {
                    SingleFieldBuilderV3<ExtensionRangeOptions, ExtensionRangeOptions.Builder, ExtensionRangeOptionsOrBuilder> singleFieldBuilderV3 = this.e;
                    if (singleFieldBuilderV3 == null) {
                        ExtensionRangeOptions extensionRangeOptions = this.d;
                        return extensionRangeOptions == null ? ExtensionRangeOptions.f() : extensionRangeOptions;
                    }
                    return singleFieldBuilderV3.b();
                }
            }

            public static ExtensionRange l() {
                return j;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
            public final Parser<ExtensionRange> getParserForType() {
                return b;
            }
        }

        /* loaded from: classes3.dex */
        public static final class ReservedRange extends GeneratedMessageV3 implements ReservedRangeOrBuilder {
            private int e;
            private int f;
            private int g;
            private byte h;
            private static final ReservedRange i = new ReservedRange();

            @Deprecated
            public static final Parser<ReservedRange> b = new AbstractParser<ReservedRange>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.ReservedRange.1
                @Override // com.uqm.crashsight.protobuf.Parser
                public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new ReservedRange(codedInputStream, extensionRegistryLite, (byte) 0);
                }
            };

            /* synthetic */ ReservedRange(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
                this(codedInputStream, extensionRegistryLite);
            }

            /* synthetic */ ReservedRange(GeneratedMessageV3.Builder builder, byte b2) {
                this(builder);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
                return new Builder(builderParent, (byte) 0);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* bridge */ /* synthetic */ MessageLite r() {
                return i;
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite
            public final /* synthetic */ MessageLite.Builder newBuilderForType() {
                return j();
            }

            @Override // com.uqm.crashsight.protobuf.Message
            public final /* synthetic */ Message.Builder p() {
                byte b2 = 0;
                return this == i ? new Builder(b2) : new Builder(b2).a(this);
            }

            @Override // com.uqm.crashsight.protobuf.Message
            public final /* synthetic */ Message.Builder q() {
                return j();
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* bridge */ /* synthetic */ Message r() {
                return i;
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite
            public final /* synthetic */ MessageLite.Builder toBuilder() {
                byte b2 = 0;
                return this == i ? new Builder(b2) : new Builder(b2).a(this);
            }

            private ReservedRange(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.h = (byte) -1;
            }

            private ReservedRange() {
                this.h = (byte) -1;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final Object a() {
                return new ReservedRange();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final UnknownFieldSet b() {
                return this.d;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private ReservedRange(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                if (extensionRegistryLite == null) {
                    throw new NullPointerException();
                }
                UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int a3 = codedInputStream.a();
                            if (a3 == 0) {
                                z = true;
                            } else if (a3 == 8) {
                                this.e |= 1;
                                this.f = codedInputStream.f();
                            } else if (a3 == 16) {
                                this.e |= 2;
                                this.g = codedInputStream.f();
                            } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                                z = true;
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw e.a(this);
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2).a(this);
                        }
                    } finally {
                        this.d = a2.build();
                        P();
                    }
                }
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.j.a(ReservedRange.class, Builder.class);
            }

            public final boolean e() {
                return (this.e & 1) != 0;
            }

            public final int f() {
                return this.f;
            }

            public final boolean g() {
                return (this.e & 2) != 0;
            }

            public final int h() {
                return this.g;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b2 = this.h;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.h = (byte) 1;
                return true;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
            public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.e & 1) != 0) {
                    codedOutputStream.b(1, this.f);
                }
                if ((this.e & 2) != 0) {
                    codedOutputStream.b(2, this.g);
                }
                this.d.writeTo(codedOutputStream);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
            public final int getSerializedSize() {
                int i2 = this.f6632a;
                if (i2 != -1) {
                    return i2;
                }
                int h = (this.e & 1) != 0 ? 0 + CodedOutputStream.h(1, this.f) : 0;
                if ((this.e & 2) != 0) {
                    h += CodedOutputStream.h(2, this.g);
                }
                int serializedSize = h + this.d.getSerializedSize();
                this.f6632a = serializedSize;
                return serializedSize;
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage
            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof ReservedRange)) {
                    return super.equals(obj);
                }
                ReservedRange reservedRange = (ReservedRange) obj;
                if (((this.e & 1) != 0) != ((reservedRange.e & 1) != 0)) {
                    return false;
                }
                if (((this.e & 1) != 0) && this.f != reservedRange.f) {
                    return false;
                }
                if (((this.e & 2) != 0) != ((reservedRange.e & 2) != 0)) {
                    return false;
                }
                return (!((this.e & 2) != 0) || this.g == reservedRange.g) && this.d.equals(reservedRange.d);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage
            public final int hashCode() {
                if (this.memoizedHashCode == 0) {
                    int hashCode = DescriptorProtos.i.hashCode() + 779;
                    if ((this.e & 1) != 0) {
                        hashCode = (((hashCode * 37) + 1) * 53) + this.f;
                    }
                    if ((this.e & 2) != 0) {
                        hashCode = (((hashCode * 37) + 2) * 53) + this.g;
                    }
                    int hashCode2 = (hashCode * 29) + this.d.hashCode();
                    this.memoizedHashCode = hashCode2;
                    return hashCode2;
                }
                return this.memoizedHashCode;
            }

            private static Builder j() {
                ReservedRange reservedRange = i;
                byte b2 = 0;
                return reservedRange == reservedRange ? new Builder(b2) : new Builder(b2).a(reservedRange);
            }

            /* loaded from: classes3.dex */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReservedRangeOrBuilder {

                /* renamed from: a, reason: collision with root package name */
                private int f6644a;
                private int b;
                private int c;

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                /* synthetic */ Builder(byte b) {
                    this();
                }

                /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                    this(builderParent);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
                /* renamed from: a */
                public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                    if (message instanceof ReservedRange) {
                        return a((ReservedRange) message);
                    }
                    super.internalMergeFrom(message);
                    return this;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
                public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.a(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.c(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: b */
                public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.d(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: b */
                public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.a(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
                /* renamed from: build */
                public final /* synthetic */ MessageLite h() {
                    ReservedRange g = g();
                    if (g.isInitialized()) {
                        return g;
                    }
                    throw new UninitializedMessageException(MessageReflection.b(g));
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: c */
                public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.d(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.c(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
                /* renamed from: c */
                public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                    if (message instanceof ReservedRange) {
                        return a((ReservedRange) message);
                    }
                    super.internalMergeFrom(message);
                    return this;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ MessageLite.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.d(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.d(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: f */
                public final /* bridge */ /* synthetic */ Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
                /* renamed from: getDefaultInstanceForType */
                public final /* synthetic */ MessageLite r() {
                    return ReservedRange.i();
                }

                @Override // com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message h() {
                    ReservedRange g = g();
                    if (g.isInitialized()) {
                        return g;
                    }
                    throw new UninitializedMessageException(MessageReflection.b(g));
                }

                @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
                public final /* synthetic */ Message r() {
                    return ReservedRange.i();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                protected final GeneratedMessageV3.FieldAccessorTable c() {
                    return DescriptorProtos.j.a(ReservedRange.class, Builder.class);
                }

                private Builder() {
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
                public final Descriptors.Descriptor d() {
                    return DescriptorProtos.i;
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.uqm.crashsight.protobuf.Message.Builder
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public ReservedRange g() {
                    int i = 0;
                    ReservedRange reservedRange = new ReservedRange((GeneratedMessageV3.Builder) this, (byte) (0 == true ? 1 : 0));
                    int i2 = this.f6644a;
                    if ((i2 & 1) != 0) {
                        reservedRange.f = this.b;
                        i = 1;
                    }
                    if ((i2 & 2) != 0) {
                        reservedRange.g = this.c;
                        i |= 2;
                    }
                    reservedRange.e = i;
                    i();
                    return reservedRange;
                }

                public final Builder a(ReservedRange reservedRange) {
                    if (reservedRange == ReservedRange.i()) {
                        return this;
                    }
                    if (reservedRange.e()) {
                        int f = reservedRange.f();
                        this.f6644a |= 1;
                        this.b = f;
                        j();
                    }
                    if (reservedRange.g()) {
                        int h = reservedRange.h();
                        this.f6644a |= 2;
                        this.c = h;
                        j();
                    }
                    j();
                    return this;
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.ReservedRange.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$DescriptorProto$ReservedRange> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.ReservedRange.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        com.uqm.crashsight.protobuf.DescriptorProtos$DescriptorProto$ReservedRange r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.ReservedRange) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        if (r3 == 0) goto Le
                        r2.a(r3)
                    Le:
                        return r2
                    Lf:
                        r3 = move-exception
                        goto L1f
                    L11:
                        r3 = move-exception
                        com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                        com.uqm.crashsight.protobuf.DescriptorProtos$DescriptorProto$ReservedRange r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.ReservedRange) r4     // Catch: java.lang.Throwable -> Lf
                        java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                        throw r3     // Catch: java.lang.Throwable -> L1d
                    L1d:
                        r3 = move-exception
                        r0 = r4
                    L1f:
                        if (r0 == 0) goto L24
                        r2.a(r0)
                    L24:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.ReservedRange.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$DescriptorProto$ReservedRange$Builder");
                }
            }

            public static ReservedRange i() {
                return i;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
            public final Parser<ReservedRange> getParserForType() {
                return b;
            }
        }

        public final boolean c_() {
            return (this.e & 1) != 0;
        }

        public final String e() {
            Object obj = this.f;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.f = f;
            }
            return f;
        }

        public final int f() {
            return this.g.size();
        }

        public final FieldDescriptorProto a(int i) {
            return this.g.get(i);
        }

        public final int g() {
            return this.h.size();
        }

        public final FieldDescriptorProto b(int i) {
            return this.h.get(i);
        }

        public final int h() {
            return this.i.size();
        }

        public final DescriptorProto c(int i) {
            return this.i.get(i);
        }

        public final int i() {
            return this.j.size();
        }

        public final EnumDescriptorProto d(int i) {
            return this.j.get(i);
        }

        public final List<ExtensionRange> j() {
            return this.k;
        }

        public final int k() {
            return this.l.size();
        }

        public final OneofDescriptorProto e(int i) {
            return this.l.get(i);
        }

        public final boolean l() {
            return (this.e & 2) != 0;
        }

        public final MessageOptions m() {
            MessageOptions messageOptions = this.m;
            return messageOptions == null ? MessageOptions.n() : messageOptions;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.p;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.g.size(); i++) {
                if (!this.g.get(i).isInitialized()) {
                    this.p = (byte) 0;
                    return false;
                }
            }
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                if (!this.h.get(i2).isInitialized()) {
                    this.p = (byte) 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                if (!this.i.get(i3).isInitialized()) {
                    this.p = (byte) 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < this.j.size(); i4++) {
                if (!this.j.get(i4).isInitialized()) {
                    this.p = (byte) 0;
                    return false;
                }
            }
            for (int i5 = 0; i5 < this.k.size(); i5++) {
                if (!this.k.get(i5).isInitialized()) {
                    this.p = (byte) 0;
                    return false;
                }
            }
            for (int i6 = 0; i6 < this.l.size(); i6++) {
                if (!this.l.get(i6).isInitialized()) {
                    this.p = (byte) 0;
                    return false;
                }
            }
            if ((this.e & 2) != 0) {
                MessageOptions messageOptions = this.m;
                if (messageOptions == null) {
                    messageOptions = MessageOptions.n();
                }
                if (!messageOptions.isInitialized()) {
                    this.p = (byte) 0;
                    return false;
                }
            }
            this.p = (byte) 1;
            return true;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                if (obj instanceof String) {
                    codedOutputStream.a(1, (String) obj);
                } else {
                    codedOutputStream.a(1, (ByteString) obj);
                }
            }
            for (int i = 0; i < this.g.size(); i++) {
                codedOutputStream.a(2, this.g.get(i));
            }
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                codedOutputStream.a(3, this.i.get(i2));
            }
            for (int i3 = 0; i3 < this.j.size(); i3++) {
                codedOutputStream.a(4, this.j.get(i3));
            }
            for (int i4 = 0; i4 < this.k.size(); i4++) {
                codedOutputStream.a(5, this.k.get(i4));
            }
            for (int i5 = 0; i5 < this.h.size(); i5++) {
                codedOutputStream.a(6, this.h.get(i5));
            }
            if ((this.e & 2) != 0) {
                MessageOptions messageOptions = this.m;
                if (messageOptions == null) {
                    messageOptions = MessageOptions.n();
                }
                codedOutputStream.a(7, messageOptions);
            }
            for (int i6 = 0; i6 < this.l.size(); i6++) {
                codedOutputStream.a(8, this.l.get(i6));
            }
            for (int i7 = 0; i7 < this.n.size(); i7++) {
                codedOutputStream.a(9, this.n.get(i7));
            }
            for (int i8 = 0; i8 < this.o.size(); i8++) {
                Object b2 = this.o.b(i8);
                if (b2 instanceof String) {
                    codedOutputStream.a(10, (String) b2);
                } else {
                    codedOutputStream.a(10, (ByteString) b2);
                }
            }
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i;
            int i2 = this.f6632a;
            if (i2 != -1) {
                return i2;
            }
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                i = (obj instanceof String ? CodedOutputStream.b(1, (String) obj) : CodedOutputStream.c(1, (ByteString) obj)) + 0;
            } else {
                i = 0;
            }
            int i3 = i;
            for (int i4 = 0; i4 < this.g.size(); i4++) {
                i3 += CodedOutputStream.c(2, this.g.get(i4));
            }
            for (int i5 = 0; i5 < this.i.size(); i5++) {
                i3 += CodedOutputStream.c(3, this.i.get(i5));
            }
            for (int i6 = 0; i6 < this.j.size(); i6++) {
                i3 += CodedOutputStream.c(4, this.j.get(i6));
            }
            for (int i7 = 0; i7 < this.k.size(); i7++) {
                i3 += CodedOutputStream.c(5, this.k.get(i7));
            }
            for (int i8 = 0; i8 < this.h.size(); i8++) {
                i3 += CodedOutputStream.c(6, this.h.get(i8));
            }
            if ((this.e & 2) != 0) {
                MessageOptions messageOptions = this.m;
                if (messageOptions == null) {
                    messageOptions = MessageOptions.n();
                }
                i3 += CodedOutputStream.c(7, messageOptions);
            }
            for (int i9 = 0; i9 < this.l.size(); i9++) {
                i3 += CodedOutputStream.c(8, this.l.get(i9));
            }
            for (int i10 = 0; i10 < this.n.size(); i10++) {
                i3 += CodedOutputStream.c(9, this.n.get(i10));
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.o.size(); i12++) {
                Object b2 = this.o.b(i12);
                i11 += b2 instanceof String ? CodedOutputStream.b((String) b2) : CodedOutputStream.b((ByteString) b2);
            }
            int size = i3 + i11 + (this.o.size() * 1) + this.d.getSerializedSize();
            this.f6632a = size;
            return size;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DescriptorProto)) {
                return super.equals(obj);
            }
            DescriptorProto descriptorProto = (DescriptorProto) obj;
            if (((this.e & 1) != 0) != ((descriptorProto.e & 1) != 0)) {
                return false;
            }
            if ((((this.e & 1) != 0) && !e().equals(descriptorProto.e())) || !this.g.equals(descriptorProto.g) || !this.h.equals(descriptorProto.h) || !this.i.equals(descriptorProto.i) || !this.j.equals(descriptorProto.j) || !this.k.equals(descriptorProto.k) || !this.l.equals(descriptorProto.l)) {
                return false;
            }
            if (((this.e & 2) != 0) != ((descriptorProto.e & 2) != 0)) {
                return false;
            }
            if ((this.e & 2) != 0) {
                MessageOptions messageOptions = this.m;
                if (messageOptions == null) {
                    messageOptions = MessageOptions.n();
                }
                MessageOptions messageOptions2 = descriptorProto.m;
                if (messageOptions2 == null) {
                    messageOptions2 = MessageOptions.n();
                }
                if (!messageOptions.equals(messageOptions2)) {
                    return false;
                }
            }
            return this.n.equals(descriptorProto.n) && this.o.equals(descriptorProto.o) && this.d.equals(descriptorProto.d);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.e.hashCode() + 779;
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + e().hashCode();
                }
                if (this.g.size() > 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + this.g.hashCode();
                }
                if (this.h.size() > 0) {
                    hashCode = (((hashCode * 37) + 6) * 53) + this.h.hashCode();
                }
                if (this.i.size() > 0) {
                    hashCode = (((hashCode * 37) + 3) * 53) + this.i.hashCode();
                }
                if (this.j.size() > 0) {
                    hashCode = (((hashCode * 37) + 4) * 53) + this.j.hashCode();
                }
                if (this.k.size() > 0) {
                    hashCode = (((hashCode * 37) + 5) * 53) + this.k.hashCode();
                }
                if (this.l.size() > 0) {
                    hashCode = (((hashCode * 37) + 8) * 53) + this.l.hashCode();
                }
                if ((this.e & 2) != 0) {
                    int i = ((hashCode * 37) + 7) * 53;
                    MessageOptions messageOptions = this.m;
                    if (messageOptions == null) {
                        messageOptions = MessageOptions.n();
                    }
                    hashCode = i + messageOptions.hashCode();
                }
                if (this.n.size() > 0) {
                    hashCode = (((hashCode * 37) + 9) * 53) + this.n.hashCode();
                }
                if (this.o.size() > 0) {
                    hashCode = (((hashCode * 37) + 10) * 53) + this.o.hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.d.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }
            return this.memoizedHashCode;
        }

        private static Builder s() {
            DescriptorProto descriptorProto = q;
            byte b2 = 0;
            return descriptorProto == descriptorProto ? new Builder(b2) : new Builder(b2).a(descriptorProto);
        }

        public static Builder n() {
            DescriptorProto descriptorProto = q;
            byte b2 = 0;
            return descriptorProto == descriptorProto ? new Builder(b2) : new Builder(b2).a(descriptorProto);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DescriptorProtoOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6642a;
            private Object b;
            private List<FieldDescriptorProto> c;
            private RepeatedFieldBuilderV3<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> d;
            private List<FieldDescriptorProto> e;
            private RepeatedFieldBuilderV3<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> f;
            private List<DescriptorProto> g;
            private RepeatedFieldBuilderV3<DescriptorProto, Builder, DescriptorProtoOrBuilder> h;
            private List<EnumDescriptorProto> i;
            private RepeatedFieldBuilderV3<EnumDescriptorProto, EnumDescriptorProto.Builder, EnumDescriptorProtoOrBuilder> j;
            private List<ExtensionRange> k;
            private RepeatedFieldBuilderV3<ExtensionRange, ExtensionRange.Builder, ExtensionRangeOrBuilder> l;
            private List<OneofDescriptorProto> m;
            private RepeatedFieldBuilderV3<OneofDescriptorProto, OneofDescriptorProto.Builder, OneofDescriptorProtoOrBuilder> n;
            private MessageOptions o;
            private SingleFieldBuilderV3<MessageOptions, MessageOptions.Builder, MessageOptionsOrBuilder> p;
            private List<ReservedRange> q;
            private RepeatedFieldBuilderV3<ReservedRange, ReservedRange.Builder, ReservedRangeOrBuilder> r;
            private LazyStringList s;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof DescriptorProto) {
                    return a((DescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                DescriptorProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw new UninitializedMessageException(MessageReflection.b(buildPartial));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof DescriptorProto) {
                    return a((DescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return DescriptorProto.o();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                DescriptorProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw new UninitializedMessageException(MessageReflection.b(buildPartial));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return DescriptorProto.o();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.f.a(DescriptorProto.class, Builder.class);
            }

            private Builder() {
                this.b = "";
                this.c = Collections.emptyList();
                this.e = Collections.emptyList();
                this.g = Collections.emptyList();
                this.i = Collections.emptyList();
                this.k = Collections.emptyList();
                this.m = Collections.emptyList();
                this.q = Collections.emptyList();
                this.s = LazyStringArrayList.f6738a;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = "";
                this.c = Collections.emptyList();
                this.e = Collections.emptyList();
                this.g = Collections.emptyList();
                this.i = Collections.emptyList();
                this.k = Collections.emptyList();
                this.m = Collections.emptyList();
                this.q = Collections.emptyList();
                this.s = LazyStringArrayList.f6738a;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.e;
            }

            public final DescriptorProto e() {
                DescriptorProto buildPartial = buildPartial();
                if (buildPartial.isInitialized()) {
                    return buildPartial;
                }
                throw new UninitializedMessageException(MessageReflection.b(buildPartial));
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: m, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public DescriptorProto g() {
                DescriptorProto descriptorProto = new DescriptorProto((GeneratedMessageV3.Builder) this, (byte) (0 == true ? 1 : 0));
                int i = this.f6642a;
                int i2 = (i & 1) != 0 ? 1 : 0;
                descriptorProto.f = this.b;
                RepeatedFieldBuilderV3<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.d;
                if (repeatedFieldBuilderV3 != null) {
                    descriptorProto.g = repeatedFieldBuilderV3.e();
                } else {
                    if ((this.f6642a & 2) != 0) {
                        this.c = Collections.unmodifiableList(this.c);
                        this.f6642a &= -3;
                    }
                    descriptorProto.g = this.c;
                }
                RepeatedFieldBuilderV3<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> repeatedFieldBuilderV32 = this.f;
                if (repeatedFieldBuilderV32 != null) {
                    descriptorProto.h = repeatedFieldBuilderV32.e();
                } else {
                    if ((this.f6642a & 4) != 0) {
                        this.e = Collections.unmodifiableList(this.e);
                        this.f6642a &= -5;
                    }
                    descriptorProto.h = this.e;
                }
                RepeatedFieldBuilderV3<DescriptorProto, Builder, DescriptorProtoOrBuilder> repeatedFieldBuilderV33 = this.h;
                if (repeatedFieldBuilderV33 != null) {
                    descriptorProto.i = repeatedFieldBuilderV33.e();
                } else {
                    if ((this.f6642a & 8) != 0) {
                        this.g = Collections.unmodifiableList(this.g);
                        this.f6642a &= -9;
                    }
                    descriptorProto.i = this.g;
                }
                RepeatedFieldBuilderV3<EnumDescriptorProto, EnumDescriptorProto.Builder, EnumDescriptorProtoOrBuilder> repeatedFieldBuilderV34 = this.j;
                if (repeatedFieldBuilderV34 != null) {
                    descriptorProto.j = repeatedFieldBuilderV34.e();
                } else {
                    if ((this.f6642a & 16) != 0) {
                        this.i = Collections.unmodifiableList(this.i);
                        this.f6642a &= -17;
                    }
                    descriptorProto.j = this.i;
                }
                RepeatedFieldBuilderV3<ExtensionRange, ExtensionRange.Builder, ExtensionRangeOrBuilder> repeatedFieldBuilderV35 = this.l;
                if (repeatedFieldBuilderV35 != null) {
                    descriptorProto.k = repeatedFieldBuilderV35.e();
                } else {
                    if ((this.f6642a & 32) != 0) {
                        this.k = Collections.unmodifiableList(this.k);
                        this.f6642a &= -33;
                    }
                    descriptorProto.k = this.k;
                }
                RepeatedFieldBuilderV3<OneofDescriptorProto, OneofDescriptorProto.Builder, OneofDescriptorProtoOrBuilder> repeatedFieldBuilderV36 = this.n;
                if (repeatedFieldBuilderV36 != null) {
                    descriptorProto.l = repeatedFieldBuilderV36.e();
                } else {
                    if ((this.f6642a & 64) != 0) {
                        this.m = Collections.unmodifiableList(this.m);
                        this.f6642a &= -65;
                    }
                    descriptorProto.l = this.m;
                }
                if ((i & 128) != 0) {
                    SingleFieldBuilderV3<MessageOptions, MessageOptions.Builder, MessageOptionsOrBuilder> singleFieldBuilderV3 = this.p;
                    if (singleFieldBuilderV3 == null) {
                        descriptorProto.m = this.o;
                    } else {
                        descriptorProto.m = singleFieldBuilderV3.c();
                    }
                    i2 |= 2;
                }
                RepeatedFieldBuilderV3<ReservedRange, ReservedRange.Builder, ReservedRangeOrBuilder> repeatedFieldBuilderV37 = this.r;
                if (repeatedFieldBuilderV37 != null) {
                    descriptorProto.n = repeatedFieldBuilderV37.e();
                } else {
                    if ((this.f6642a & 256) != 0) {
                        this.q = Collections.unmodifiableList(this.q);
                        this.f6642a &= -257;
                    }
                    descriptorProto.n = this.q;
                }
                if ((this.f6642a & 512) != 0) {
                    this.s = this.s.e();
                    this.f6642a &= -513;
                }
                descriptorProto.o = this.s;
                descriptorProto.e = i2;
                i();
                return descriptorProto;
            }

            public final Builder a(DescriptorProto descriptorProto) {
                MessageOptions messageOptions;
                if (descriptorProto == DescriptorProto.o()) {
                    return this;
                }
                if (descriptorProto.c_()) {
                    this.f6642a |= 1;
                    this.b = descriptorProto.f;
                    j();
                }
                if (this.d == null) {
                    if (!descriptorProto.g.isEmpty()) {
                        if (this.c.isEmpty()) {
                            this.c = descriptorProto.g;
                            this.f6642a &= -3;
                        } else {
                            if ((this.f6642a & 2) == 0) {
                                this.c = new ArrayList(this.c);
                                this.f6642a |= 2;
                            }
                            this.c.addAll(descriptorProto.g);
                        }
                        j();
                    }
                } else if (!descriptorProto.g.isEmpty()) {
                    if (!this.d.d()) {
                        this.d.a(descriptorProto.g);
                    } else {
                        this.d.b();
                        this.d = null;
                        this.c = descriptorProto.g;
                        this.f6642a &= -3;
                        this.d = null;
                    }
                }
                if (this.f == null) {
                    if (!descriptorProto.h.isEmpty()) {
                        if (this.e.isEmpty()) {
                            this.e = descriptorProto.h;
                            this.f6642a &= -5;
                        } else {
                            if ((this.f6642a & 4) == 0) {
                                this.e = new ArrayList(this.e);
                                this.f6642a |= 4;
                            }
                            this.e.addAll(descriptorProto.h);
                        }
                        j();
                    }
                } else if (!descriptorProto.h.isEmpty()) {
                    if (!this.f.d()) {
                        this.f.a(descriptorProto.h);
                    } else {
                        this.f.b();
                        this.f = null;
                        this.e = descriptorProto.h;
                        this.f6642a &= -5;
                        this.f = null;
                    }
                }
                if (this.h == null) {
                    if (!descriptorProto.i.isEmpty()) {
                        if (this.g.isEmpty()) {
                            this.g = descriptorProto.i;
                            this.f6642a &= -9;
                        } else {
                            if ((this.f6642a & 8) == 0) {
                                this.g = new ArrayList(this.g);
                                this.f6642a |= 8;
                            }
                            this.g.addAll(descriptorProto.i);
                        }
                        j();
                    }
                } else if (!descriptorProto.i.isEmpty()) {
                    if (!this.h.d()) {
                        this.h.a(descriptorProto.i);
                    } else {
                        this.h.b();
                        this.h = null;
                        this.g = descriptorProto.i;
                        this.f6642a &= -9;
                        this.h = null;
                    }
                }
                if (this.j == null) {
                    if (!descriptorProto.j.isEmpty()) {
                        if (this.i.isEmpty()) {
                            this.i = descriptorProto.j;
                            this.f6642a &= -17;
                        } else {
                            if ((this.f6642a & 16) == 0) {
                                this.i = new ArrayList(this.i);
                                this.f6642a |= 16;
                            }
                            this.i.addAll(descriptorProto.j);
                        }
                        j();
                    }
                } else if (!descriptorProto.j.isEmpty()) {
                    if (!this.j.d()) {
                        this.j.a(descriptorProto.j);
                    } else {
                        this.j.b();
                        this.j = null;
                        this.i = descriptorProto.j;
                        this.f6642a &= -17;
                        this.j = null;
                    }
                }
                if (this.l == null) {
                    if (!descriptorProto.k.isEmpty()) {
                        if (this.k.isEmpty()) {
                            this.k = descriptorProto.k;
                            this.f6642a &= -33;
                        } else {
                            n();
                            this.k.addAll(descriptorProto.k);
                        }
                        j();
                    }
                } else if (!descriptorProto.k.isEmpty()) {
                    if (!this.l.d()) {
                        this.l.a(descriptorProto.k);
                    } else {
                        this.l.b();
                        this.l = null;
                        this.k = descriptorProto.k;
                        this.f6642a &= -33;
                        this.l = null;
                    }
                }
                if (this.n == null) {
                    if (!descriptorProto.l.isEmpty()) {
                        if (this.m.isEmpty()) {
                            this.m = descriptorProto.l;
                            this.f6642a &= -65;
                        } else {
                            if ((this.f6642a & 64) == 0) {
                                this.m = new ArrayList(this.m);
                                this.f6642a |= 64;
                            }
                            this.m.addAll(descriptorProto.l);
                        }
                        j();
                    }
                } else if (!descriptorProto.l.isEmpty()) {
                    if (!this.n.d()) {
                        this.n.a(descriptorProto.l);
                    } else {
                        this.n.b();
                        this.n = null;
                        this.m = descriptorProto.l;
                        this.f6642a &= -65;
                        this.n = null;
                    }
                }
                if (descriptorProto.l()) {
                    MessageOptions m = descriptorProto.m();
                    SingleFieldBuilderV3<MessageOptions, MessageOptions.Builder, MessageOptionsOrBuilder> singleFieldBuilderV3 = this.p;
                    if (singleFieldBuilderV3 == null) {
                        if ((this.f6642a & 128) != 0 && (messageOptions = this.o) != null && messageOptions != MessageOptions.n()) {
                            m = MessageOptions.a(this.o).a(m).g();
                        }
                        this.o = m;
                        j();
                    } else {
                        singleFieldBuilderV3.a(m);
                    }
                    this.f6642a |= 128;
                }
                if (this.r == null) {
                    if (!descriptorProto.n.isEmpty()) {
                        if (this.q.isEmpty()) {
                            this.q = descriptorProto.n;
                            this.f6642a &= -257;
                        } else {
                            if ((this.f6642a & 256) == 0) {
                                this.q = new ArrayList(this.q);
                                this.f6642a |= 256;
                            }
                            this.q.addAll(descriptorProto.n);
                        }
                        j();
                    }
                } else if (!descriptorProto.n.isEmpty()) {
                    if (!this.r.d()) {
                        this.r.a(descriptorProto.n);
                    } else {
                        this.r.b();
                        this.r = null;
                        this.q = descriptorProto.n;
                        this.f6642a &= -257;
                        this.r = null;
                    }
                }
                if (!descriptorProto.o.isEmpty()) {
                    if (this.s.isEmpty()) {
                        this.s = descriptorProto.o;
                        this.f6642a &= -513;
                    } else {
                        if ((this.f6642a & 512) == 0) {
                            this.s = new LazyStringArrayList(this.s);
                            this.f6642a |= 512;
                        }
                        this.s.addAll(descriptorProto.o);
                    }
                    j();
                }
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int i = 0;
                while (true) {
                    RepeatedFieldBuilderV3<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.d;
                    if (i < (repeatedFieldBuilderV3 == null ? this.c.size() : repeatedFieldBuilderV3.c())) {
                        RepeatedFieldBuilderV3<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> repeatedFieldBuilderV32 = this.d;
                        if (!(repeatedFieldBuilderV32 == null ? this.c.get(i) : repeatedFieldBuilderV32.a(i)).isInitialized()) {
                            return false;
                        }
                        i++;
                    } else {
                        int i2 = 0;
                        while (true) {
                            RepeatedFieldBuilderV3<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> repeatedFieldBuilderV33 = this.f;
                            if (i2 < (repeatedFieldBuilderV33 == null ? this.e.size() : repeatedFieldBuilderV33.c())) {
                                RepeatedFieldBuilderV3<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> repeatedFieldBuilderV34 = this.f;
                                if (!(repeatedFieldBuilderV34 == null ? this.e.get(i2) : repeatedFieldBuilderV34.a(i2)).isInitialized()) {
                                    return false;
                                }
                                i2++;
                            } else {
                                int i3 = 0;
                                while (true) {
                                    RepeatedFieldBuilderV3<DescriptorProto, Builder, DescriptorProtoOrBuilder> repeatedFieldBuilderV35 = this.h;
                                    if (i3 < (repeatedFieldBuilderV35 == null ? this.g.size() : repeatedFieldBuilderV35.c())) {
                                        RepeatedFieldBuilderV3<DescriptorProto, Builder, DescriptorProtoOrBuilder> repeatedFieldBuilderV36 = this.h;
                                        if (!(repeatedFieldBuilderV36 == null ? this.g.get(i3) : repeatedFieldBuilderV36.a(i3)).isInitialized()) {
                                            return false;
                                        }
                                        i3++;
                                    } else {
                                        int i4 = 0;
                                        while (true) {
                                            RepeatedFieldBuilderV3<EnumDescriptorProto, EnumDescriptorProto.Builder, EnumDescriptorProtoOrBuilder> repeatedFieldBuilderV37 = this.j;
                                            if (i4 < (repeatedFieldBuilderV37 == null ? this.i.size() : repeatedFieldBuilderV37.c())) {
                                                RepeatedFieldBuilderV3<EnumDescriptorProto, EnumDescriptorProto.Builder, EnumDescriptorProtoOrBuilder> repeatedFieldBuilderV38 = this.j;
                                                if (!(repeatedFieldBuilderV38 == null ? this.i.get(i4) : repeatedFieldBuilderV38.a(i4)).isInitialized()) {
                                                    return false;
                                                }
                                                i4++;
                                            } else {
                                                int i5 = 0;
                                                while (true) {
                                                    RepeatedFieldBuilderV3<ExtensionRange, ExtensionRange.Builder, ExtensionRangeOrBuilder> repeatedFieldBuilderV39 = this.l;
                                                    if (i5 < (repeatedFieldBuilderV39 == null ? this.k.size() : repeatedFieldBuilderV39.c())) {
                                                        RepeatedFieldBuilderV3<ExtensionRange, ExtensionRange.Builder, ExtensionRangeOrBuilder> repeatedFieldBuilderV310 = this.l;
                                                        if (!(repeatedFieldBuilderV310 == null ? this.k.get(i5) : repeatedFieldBuilderV310.a(i5)).isInitialized()) {
                                                            return false;
                                                        }
                                                        i5++;
                                                    } else {
                                                        int i6 = 0;
                                                        while (true) {
                                                            RepeatedFieldBuilderV3<OneofDescriptorProto, OneofDescriptorProto.Builder, OneofDescriptorProtoOrBuilder> repeatedFieldBuilderV311 = this.n;
                                                            if (i6 >= (repeatedFieldBuilderV311 == null ? this.m.size() : repeatedFieldBuilderV311.c())) {
                                                                return !((this.f6642a & 128) != 0) || o().isInitialized();
                                                            }
                                                            RepeatedFieldBuilderV3<OneofDescriptorProto, OneofDescriptorProto.Builder, OneofDescriptorProtoOrBuilder> repeatedFieldBuilderV312 = this.n;
                                                            if (!(repeatedFieldBuilderV312 == null ? this.m.get(i6) : repeatedFieldBuilderV312.a(i6)).isInitialized()) {
                                                                return false;
                                                            }
                                                            i6++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$DescriptorProto> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$DescriptorProto r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$DescriptorProto r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.DescriptorProto.Builder.a(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$DescriptorProto$Builder");
            }

            public final Builder a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f6642a |= 1;
                this.b = str;
                j();
                return this;
            }

            private void n() {
                if ((this.f6642a & 32) == 0) {
                    this.k = new ArrayList(this.k);
                    this.f6642a |= 32;
                }
            }

            public final Builder a(ExtensionRange extensionRange) {
                RepeatedFieldBuilderV3<ExtensionRange, ExtensionRange.Builder, ExtensionRangeOrBuilder> repeatedFieldBuilderV3 = this.l;
                if (repeatedFieldBuilderV3 != null) {
                    repeatedFieldBuilderV3.a((RepeatedFieldBuilderV3<ExtensionRange, ExtensionRange.Builder, ExtensionRangeOrBuilder>) extensionRange);
                } else {
                    if (extensionRange == null) {
                        throw new NullPointerException();
                    }
                    n();
                    this.k.add(extensionRange);
                    j();
                }
                return this;
            }

            private MessageOptions o() {
                SingleFieldBuilderV3<MessageOptions, MessageOptions.Builder, MessageOptionsOrBuilder> singleFieldBuilderV3 = this.p;
                if (singleFieldBuilderV3 == null) {
                    MessageOptions messageOptions = this.o;
                    return messageOptions == null ? MessageOptions.n() : messageOptions;
                }
                return singleFieldBuilderV3.b();
            }
        }

        public static DescriptorProto o() {
            return q;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<DescriptorProto> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class ExtensionRangeOptions extends GeneratedMessageV3.ExtendableMessage<ExtensionRangeOptions> implements ExtensionRangeOptionsOrBuilder {
        private List<UninterpretedOption> e;
        private byte f;
        private static final ExtensionRangeOptions g = new ExtensionRangeOptions();

        @Deprecated
        public static final Parser<ExtensionRangeOptions> b = new AbstractParser<ExtensionRangeOptions>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.ExtensionRangeOptions.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ExtensionRangeOptions(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* synthetic */ ExtensionRangeOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ ExtensionRangeOptions(GeneratedMessageV3.ExtendableBuilder extendableBuilder, byte b2) {
            this(extendableBuilder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return g;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return g();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == g ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return g();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return g;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == g ? new Builder(b2) : new Builder(b2).a(this);
        }

        private ExtensionRangeOptions(GeneratedMessageV3.ExtendableBuilder<ExtensionRangeOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.f = (byte) -1;
        }

        private ExtensionRangeOptions() {
            this.f = (byte) -1;
            this.e = Collections.emptyList();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new ExtensionRangeOptions();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ExtensionRangeOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 7994) {
                            if (!(z2 & true)) {
                                this.e = new ArrayList();
                                z2 |= true;
                            }
                            this.e.add(codedInputStream.a(UninterpretedOption.b, extensionRegistryLite));
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.e = Collections.unmodifiableList(this.e);
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.l.a(ExtensionRangeOptions.class, Builder.class);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableMessage, com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.e.size(); i++) {
                if (!this.e.get(i).isInitialized()) {
                    this.f = (byte) 0;
                    return false;
                }
            }
            if (!R()) {
                this.f = (byte) 0;
                return false;
            }
            this.f = (byte) 1;
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage.ExtensionWriter extensionWriter = new GeneratedMessageV3.ExtendableMessage.ExtensionWriter(this, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
            for (int i = 0; i < this.e.size(); i++) {
                codedOutputStream.a(999, this.e.get(i));
            }
            extensionWriter.a(DriveFile.MODE_WRITE_ONLY, codedOutputStream);
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.f6632a;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                i2 += CodedOutputStream.c(999, this.e.get(i3));
            }
            int S = i2 + S() + this.d.getSerializedSize();
            this.f6632a = S;
            return S;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ExtensionRangeOptions)) {
                return super.equals(obj);
            }
            ExtensionRangeOptions extensionRangeOptions = (ExtensionRangeOptions) obj;
            return this.e.equals(extensionRangeOptions.e) && this.d.equals(extensionRangeOptions.d) && T().equals(extensionRangeOptions.T());
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.k.hashCode() + 779;
                if (this.e.size() > 0) {
                    hashCode = (((hashCode * 37) + 999) * 53) + this.e.hashCode();
                }
                int a2 = (a(hashCode, T()) * 29) + this.d.hashCode();
                this.memoizedHashCode = a2;
                return a2;
            }
            return this.memoizedHashCode;
        }

        private static Builder g() {
            ExtensionRangeOptions extensionRangeOptions = g;
            byte b2 = 0;
            return extensionRangeOptions == extensionRangeOptions ? new Builder(b2) : new Builder(b2).a(extensionRangeOptions);
        }

        public static Builder a(ExtensionRangeOptions extensionRangeOptions) {
            ExtensionRangeOptions extensionRangeOptions2 = g;
            byte b2 = 0;
            return (extensionRangeOptions2 == extensionRangeOptions2 ? new Builder(b2) : new Builder(b2).a(extensionRangeOptions2)).a(extensionRangeOptions);
        }

        public final Builder e() {
            byte b2 = 0;
            return this == g ? new Builder(b2) : new Builder(b2).a(this);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.ExtendableBuilder<ExtensionRangeOptions, Builder> implements ExtensionRangeOptionsOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6650a;
            private List<UninterpretedOption> b;
            private RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> c;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof ExtensionRangeOptions) {
                    return a((ExtensionRangeOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* synthetic */ GeneratedMessageV3.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* synthetic */ GeneratedMessageV3.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                ExtensionRangeOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof ExtensionRangeOptions) {
                    return a((ExtensionRangeOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: e */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return ExtensionRangeOptions.f();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                ExtensionRangeOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return ExtensionRangeOptions.f();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.l.a(ExtensionRangeOptions.class, Builder.class);
            }

            private Builder() {
                this.b = Collections.emptyList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = Collections.emptyList();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.k;
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final ExtensionRangeOptions g() {
                ExtensionRangeOptions extensionRangeOptions = new ExtensionRangeOptions((GeneratedMessageV3.ExtendableBuilder) this, (byte) 0);
                int i = this.f6650a;
                RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.c;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) != 0) {
                        this.b = Collections.unmodifiableList(this.b);
                        this.f6650a &= -2;
                    }
                    extensionRangeOptions.e = this.b;
                } else {
                    extensionRangeOptions.e = repeatedFieldBuilderV3.e();
                }
                i();
                return extensionRangeOptions;
            }

            public final Builder a(ExtensionRangeOptions extensionRangeOptions) {
                if (extensionRangeOptions == ExtensionRangeOptions.f()) {
                    return this;
                }
                if (this.c == null) {
                    if (!extensionRangeOptions.e.isEmpty()) {
                        if (this.b.isEmpty()) {
                            this.b = extensionRangeOptions.e;
                            this.f6650a &= -2;
                        } else {
                            if ((this.f6650a & 1) == 0) {
                                this.b = new ArrayList(this.b);
                                this.f6650a |= 1;
                            }
                            this.b.addAll(extensionRangeOptions.e);
                        }
                        j();
                    }
                } else if (!extensionRangeOptions.e.isEmpty()) {
                    if (!this.c.d()) {
                        this.c.a(extensionRangeOptions.e);
                    } else {
                        this.c.b();
                        this.c = null;
                        this.b = extensionRangeOptions.e;
                        this.f6650a &= -2;
                        this.c = null;
                    }
                }
                a((GeneratedMessageV3.ExtendableMessage) extensionRangeOptions);
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int i = 0;
                while (true) {
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.c;
                    if (i >= (repeatedFieldBuilderV3 == null ? this.b.size() : repeatedFieldBuilderV3.c())) {
                        return m();
                    }
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV32 = this.c;
                    if (!(repeatedFieldBuilderV32 == null ? this.b.get(i) : repeatedFieldBuilderV32.a(i)).isInitialized()) {
                        return false;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.ExtensionRangeOptions.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$ExtensionRangeOptions> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.ExtensionRangeOptions.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$ExtensionRangeOptions r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.ExtensionRangeOptions) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$ExtensionRangeOptions r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.ExtensionRangeOptions) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.ExtensionRangeOptions.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$ExtensionRangeOptions$Builder");
            }
        }

        public static ExtensionRangeOptions f() {
            return g;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<ExtensionRangeOptions> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class FieldDescriptorProto extends GeneratedMessageV3 implements FieldDescriptorProtoOrBuilder {
        private int e;
        private volatile Object f;
        private int g;
        private int h;
        private int i;
        private volatile Object j;
        private volatile Object k;
        private volatile Object l;
        private int m;
        private volatile Object n;
        private FieldOptions o;
        private byte p;
        private static final FieldDescriptorProto q = new FieldDescriptorProto();

        @Deprecated
        public static final Parser<FieldDescriptorProto> b = new AbstractParser<FieldDescriptorProto>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.FieldDescriptorProto.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new FieldDescriptorProto(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* synthetic */ FieldDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ FieldDescriptorProto(GeneratedMessageV3.Builder builder, byte b2) {
            this(builder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return q;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return C();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == q ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return C();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return q;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == q ? new Builder(b2) : new Builder(b2).a(this);
        }

        private FieldDescriptorProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.p = (byte) -1;
        }

        private FieldDescriptorProto() {
            this.p = (byte) -1;
            this.f = "";
            this.h = 1;
            this.i = 1;
            this.j = "";
            this.k = "";
            this.l = "";
            this.n = "";
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new FieldDescriptorProto();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0011. Please report as an issue. */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FieldDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        switch (a3) {
                            case 0:
                                z = true;
                            case 10:
                                ByteString l = codedInputStream.l();
                                this.e |= 1;
                                this.f = l;
                            case 18:
                                ByteString l2 = codedInputStream.l();
                                this.e |= 32;
                                this.k = l2;
                            case 24:
                                this.e |= 2;
                                this.g = codedInputStream.f();
                            case 32:
                                int n = codedInputStream.n();
                                if (Label.a(n) == null) {
                                    a2.a(4, n);
                                } else {
                                    this.e |= 4;
                                    this.h = n;
                                }
                            case 40:
                                int n2 = codedInputStream.n();
                                if (Type.a(n2) == null) {
                                    a2.a(5, n2);
                                } else {
                                    this.e |= 8;
                                    this.i = n2;
                                }
                            case 50:
                                ByteString l3 = codedInputStream.l();
                                this.e |= 16;
                                this.j = l3;
                            case 58:
                                ByteString l4 = codedInputStream.l();
                                this.e |= 64;
                                this.l = l4;
                            case 66:
                                FieldOptions.Builder t = (this.e & 512) != 0 ? this.o.t() : null;
                                this.o = (FieldOptions) codedInputStream.a(FieldOptions.b, extensionRegistryLite);
                                if (t != null) {
                                    t.a(this.o);
                                    this.o = t.g();
                                }
                                this.e |= 512;
                            case 72:
                                this.e |= 128;
                                this.m = codedInputStream.f();
                            case 82:
                                ByteString l5 = codedInputStream.l();
                                this.e |= 256;
                                this.n = l5;
                            default:
                                if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                                    z = true;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.n.a(FieldDescriptorProto.class, Builder.class);
        }

        /* loaded from: classes3.dex */
        public enum Type implements ProtocolMessageEnum {
            TYPE_DOUBLE(1),
            TYPE_FLOAT(2),
            TYPE_INT64(3),
            TYPE_UINT64(4),
            TYPE_INT32(5),
            TYPE_FIXED64(6),
            TYPE_FIXED32(7),
            TYPE_BOOL(8),
            TYPE_STRING(9),
            TYPE_GROUP(10),
            TYPE_MESSAGE(11),
            TYPE_BYTES(12),
            TYPE_UINT32(13),
            TYPE_ENUM(14),
            TYPE_SFIXED32(15),
            TYPE_SFIXED64(16),
            TYPE_SINT32(17),
            TYPE_SINT64(18);

            private final int s;

            static {
                new Internal.EnumLiteMap<Type>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.FieldDescriptorProto.Type.1
                    @Override // com.uqm.crashsight.protobuf.Internal.EnumLiteMap
                    public final /* synthetic */ Type a(int i) {
                        return Type.b(i);
                    }
                };
                values();
            }

            @Override // com.uqm.crashsight.protobuf.Internal.EnumLite
            public final int a() {
                return this.s;
            }

            @Deprecated
            public static Type a(int i) {
                return b(i);
            }

            public static Type b(int i) {
                switch (i) {
                    case 1:
                        return TYPE_DOUBLE;
                    case 2:
                        return TYPE_FLOAT;
                    case 3:
                        return TYPE_INT64;
                    case 4:
                        return TYPE_UINT64;
                    case 5:
                        return TYPE_INT32;
                    case 6:
                        return TYPE_FIXED64;
                    case 7:
                        return TYPE_FIXED32;
                    case 8:
                        return TYPE_BOOL;
                    case 9:
                        return TYPE_STRING;
                    case 10:
                        return TYPE_GROUP;
                    case 11:
                        return TYPE_MESSAGE;
                    case 12:
                        return TYPE_BYTES;
                    case 13:
                        return TYPE_UINT32;
                    case 14:
                        return TYPE_ENUM;
                    case 15:
                        return TYPE_SFIXED32;
                    case 16:
                        return TYPE_SFIXED64;
                    case 17:
                        return TYPE_SINT32;
                    case 18:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }

            Type(int i) {
                this.s = i;
            }
        }

        /* loaded from: classes3.dex */
        public enum Label implements ProtocolMessageEnum {
            LABEL_OPTIONAL(1),
            LABEL_REQUIRED(2),
            LABEL_REPEATED(3);

            private final int d;

            static {
                new Internal.EnumLiteMap<Label>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.FieldDescriptorProto.Label.1
                    @Override // com.uqm.crashsight.protobuf.Internal.EnumLiteMap
                    public final /* synthetic */ Label a(int i) {
                        return Label.b(i);
                    }
                };
                values();
            }

            @Override // com.uqm.crashsight.protobuf.Internal.EnumLite
            public final int a() {
                return this.d;
            }

            @Deprecated
            public static Label a(int i) {
                return b(i);
            }

            public static Label b(int i) {
                switch (i) {
                    case 1:
                        return LABEL_OPTIONAL;
                    case 2:
                        return LABEL_REQUIRED;
                    case 3:
                        return LABEL_REPEATED;
                    default:
                        return null;
                }
            }

            Label(int i) {
                this.d = i;
            }
        }

        public final boolean e() {
            return (this.e & 1) != 0;
        }

        public final String f() {
            Object obj = this.f;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.f = f;
            }
            return f;
        }

        public final boolean g() {
            return (this.e & 2) != 0;
        }

        public final int h() {
            return this.g;
        }

        public final boolean i() {
            return (this.e & 4) != 0;
        }

        public final Label j() {
            Label a2 = Label.a(this.h);
            return a2 == null ? Label.LABEL_OPTIONAL : a2;
        }

        public final boolean k() {
            return (this.e & 8) != 0;
        }

        public final Type l() {
            Type a2 = Type.a(this.i);
            return a2 == null ? Type.TYPE_DOUBLE : a2;
        }

        public final boolean m() {
            return (this.e & 16) != 0;
        }

        public final String n() {
            Object obj = this.j;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.j = f;
            }
            return f;
        }

        public final boolean o() {
            return (this.e & 32) != 0;
        }

        public final String s() {
            Object obj = this.k;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.k = f;
            }
            return f;
        }

        public final boolean t() {
            return (this.e & 64) != 0;
        }

        public final String u() {
            Object obj = this.l;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.l = f;
            }
            return f;
        }

        public final boolean v() {
            return (this.e & 128) != 0;
        }

        public final int w() {
            return this.m;
        }

        public final boolean x() {
            return (this.e & 256) != 0;
        }

        public final String y() {
            Object obj = this.n;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.n = f;
            }
            return f;
        }

        public final boolean z() {
            return (this.e & 512) != 0;
        }

        public final FieldOptions A() {
            FieldOptions fieldOptions = this.o;
            return fieldOptions == null ? FieldOptions.u() : fieldOptions;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.p;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if ((this.e & 512) != 0) {
                FieldOptions fieldOptions = this.o;
                if (fieldOptions == null) {
                    fieldOptions = FieldOptions.u();
                }
                if (!fieldOptions.isInitialized()) {
                    this.p = (byte) 0;
                    return false;
                }
            }
            this.p = (byte) 1;
            return true;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                if (obj instanceof String) {
                    codedOutputStream.a(1, (String) obj);
                } else {
                    codedOutputStream.a(1, (ByteString) obj);
                }
            }
            if ((this.e & 32) != 0) {
                Object obj2 = this.k;
                if (obj2 instanceof String) {
                    codedOutputStream.a(2, (String) obj2);
                } else {
                    codedOutputStream.a(2, (ByteString) obj2);
                }
            }
            if ((this.e & 2) != 0) {
                codedOutputStream.b(3, this.g);
            }
            if ((this.e & 4) != 0) {
                codedOutputStream.g(4, this.h);
            }
            if ((this.e & 8) != 0) {
                codedOutputStream.g(5, this.i);
            }
            if ((this.e & 16) != 0) {
                Object obj3 = this.j;
                if (obj3 instanceof String) {
                    codedOutputStream.a(6, (String) obj3);
                } else {
                    codedOutputStream.a(6, (ByteString) obj3);
                }
            }
            if ((this.e & 64) != 0) {
                Object obj4 = this.l;
                if (obj4 instanceof String) {
                    codedOutputStream.a(7, (String) obj4);
                } else {
                    codedOutputStream.a(7, (ByteString) obj4);
                }
            }
            if ((this.e & 512) != 0) {
                FieldOptions fieldOptions = this.o;
                if (fieldOptions == null) {
                    fieldOptions = FieldOptions.u();
                }
                codedOutputStream.a(8, fieldOptions);
            }
            if ((this.e & 128) != 0) {
                codedOutputStream.b(9, this.m);
            }
            if ((this.e & 256) != 0) {
                Object obj5 = this.n;
                if (obj5 instanceof String) {
                    codedOutputStream.a(10, (String) obj5);
                } else {
                    codedOutputStream.a(10, (ByteString) obj5);
                }
            }
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.f6632a;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                i2 = 0 + (obj instanceof String ? CodedOutputStream.b(1, (String) obj) : CodedOutputStream.c(1, (ByteString) obj));
            }
            if ((this.e & 32) != 0) {
                Object obj2 = this.k;
                i2 += obj2 instanceof String ? CodedOutputStream.b(2, (String) obj2) : CodedOutputStream.c(2, (ByteString) obj2);
            }
            if ((this.e & 2) != 0) {
                i2 += CodedOutputStream.h(3, this.g);
            }
            if ((this.e & 4) != 0) {
                i2 += CodedOutputStream.m(4, this.h);
            }
            if ((this.e & 8) != 0) {
                i2 += CodedOutputStream.m(5, this.i);
            }
            if ((this.e & 16) != 0) {
                Object obj3 = this.j;
                i2 += obj3 instanceof String ? CodedOutputStream.b(6, (String) obj3) : CodedOutputStream.c(6, (ByteString) obj3);
            }
            if ((this.e & 64) != 0) {
                Object obj4 = this.l;
                i2 += obj4 instanceof String ? CodedOutputStream.b(7, (String) obj4) : CodedOutputStream.c(7, (ByteString) obj4);
            }
            if ((this.e & 512) != 0) {
                FieldOptions fieldOptions = this.o;
                if (fieldOptions == null) {
                    fieldOptions = FieldOptions.u();
                }
                i2 += CodedOutputStream.c(8, fieldOptions);
            }
            if ((this.e & 128) != 0) {
                i2 += CodedOutputStream.h(9, this.m);
            }
            if ((this.e & 256) != 0) {
                Object obj5 = this.n;
                i2 += obj5 instanceof String ? CodedOutputStream.b(10, (String) obj5) : CodedOutputStream.c(10, (ByteString) obj5);
            }
            int serializedSize = i2 + this.d.getSerializedSize();
            this.f6632a = serializedSize;
            return serializedSize;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FieldDescriptorProto)) {
                return super.equals(obj);
            }
            FieldDescriptorProto fieldDescriptorProto = (FieldDescriptorProto) obj;
            if (((this.e & 1) != 0) != ((fieldDescriptorProto.e & 1) != 0)) {
                return false;
            }
            if (((this.e & 1) != 0) && !f().equals(fieldDescriptorProto.f())) {
                return false;
            }
            if (((this.e & 2) != 0) != ((fieldDescriptorProto.e & 2) != 0)) {
                return false;
            }
            if (((this.e & 2) != 0) && this.g != fieldDescriptorProto.g) {
                return false;
            }
            if (((this.e & 4) != 0) != ((fieldDescriptorProto.e & 4) != 0)) {
                return false;
            }
            if (((this.e & 4) != 0) && this.h != fieldDescriptorProto.h) {
                return false;
            }
            if (((this.e & 8) != 0) != ((fieldDescriptorProto.e & 8) != 0)) {
                return false;
            }
            if (((this.e & 8) != 0) && this.i != fieldDescriptorProto.i) {
                return false;
            }
            if (((this.e & 16) != 0) != ((fieldDescriptorProto.e & 16) != 0)) {
                return false;
            }
            if (((this.e & 16) != 0) && !n().equals(fieldDescriptorProto.n())) {
                return false;
            }
            if (((this.e & 32) != 0) != ((fieldDescriptorProto.e & 32) != 0)) {
                return false;
            }
            if (((this.e & 32) != 0) && !s().equals(fieldDescriptorProto.s())) {
                return false;
            }
            if (((this.e & 64) != 0) != ((fieldDescriptorProto.e & 64) != 0)) {
                return false;
            }
            if (((this.e & 64) != 0) && !u().equals(fieldDescriptorProto.u())) {
                return false;
            }
            if (((this.e & 128) != 0) != ((fieldDescriptorProto.e & 128) != 0)) {
                return false;
            }
            if (((this.e & 128) != 0) && this.m != fieldDescriptorProto.m) {
                return false;
            }
            if (((this.e & 256) != 0) != ((fieldDescriptorProto.e & 256) != 0)) {
                return false;
            }
            if (((this.e & 256) != 0) && !y().equals(fieldDescriptorProto.y())) {
                return false;
            }
            if (((this.e & 512) != 0) != ((fieldDescriptorProto.e & 512) != 0)) {
                return false;
            }
            if ((this.e & 512) != 0) {
                FieldOptions fieldOptions = this.o;
                if (fieldOptions == null) {
                    fieldOptions = FieldOptions.u();
                }
                FieldOptions fieldOptions2 = fieldDescriptorProto.o;
                if (fieldOptions2 == null) {
                    fieldOptions2 = FieldOptions.u();
                }
                if (!fieldOptions.equals(fieldOptions2)) {
                    return false;
                }
            }
            return this.d.equals(fieldDescriptorProto.d);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.m.hashCode() + 779;
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + f().hashCode();
                }
                if ((this.e & 2) != 0) {
                    hashCode = (((hashCode * 37) + 3) * 53) + this.g;
                }
                if ((this.e & 4) != 0) {
                    hashCode = (((hashCode * 37) + 4) * 53) + this.h;
                }
                if ((this.e & 8) != 0) {
                    hashCode = (((hashCode * 37) + 5) * 53) + this.i;
                }
                if ((this.e & 16) != 0) {
                    hashCode = (((hashCode * 37) + 6) * 53) + n().hashCode();
                }
                if ((this.e & 32) != 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + s().hashCode();
                }
                if ((this.e & 64) != 0) {
                    hashCode = (((hashCode * 37) + 7) * 53) + u().hashCode();
                }
                if ((this.e & 128) != 0) {
                    hashCode = (((hashCode * 37) + 9) * 53) + this.m;
                }
                if ((this.e & 256) != 0) {
                    hashCode = (((hashCode * 37) + 10) * 53) + y().hashCode();
                }
                if ((this.e & 512) != 0) {
                    int i = ((hashCode * 37) + 8) * 53;
                    FieldOptions fieldOptions = this.o;
                    if (fieldOptions == null) {
                        fieldOptions = FieldOptions.u();
                    }
                    hashCode = i + fieldOptions.hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.d.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }
            return this.memoizedHashCode;
        }

        private static Builder C() {
            FieldDescriptorProto fieldDescriptorProto = q;
            byte b2 = 0;
            return fieldDescriptorProto == fieldDescriptorProto ? new Builder(b2) : new Builder(b2).a(fieldDescriptorProto);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FieldDescriptorProtoOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6651a;
            private Object b;
            private int c;
            private int d;
            private int e;
            private Object f;
            private Object g;
            private Object h;
            private int i;
            private Object j;
            private FieldOptions k;
            private SingleFieldBuilderV3<FieldOptions, FieldOptions.Builder, FieldOptionsOrBuilder> l;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof FieldDescriptorProto) {
                    return a((FieldDescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                FieldDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof FieldDescriptorProto) {
                    return a((FieldDescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return FieldDescriptorProto.B();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                FieldDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return FieldDescriptorProto.B();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.n.a(FieldDescriptorProto.class, Builder.class);
            }

            private Builder() {
                this.b = "";
                this.d = 1;
                this.e = 1;
                this.f = "";
                this.g = "";
                this.h = "";
                this.j = "";
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = "";
                this.d = 1;
                this.e = 1;
                this.f = "";
                this.g = "";
                this.h = "";
                this.j = "";
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.m;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public FieldDescriptorProto g() {
                FieldDescriptorProto fieldDescriptorProto = new FieldDescriptorProto((GeneratedMessageV3.Builder) this, (byte) (0 == true ? 1 : 0));
                int i = this.f6651a;
                int i2 = (i & 1) != 0 ? 1 : 0;
                fieldDescriptorProto.f = this.b;
                if ((i & 2) != 0) {
                    fieldDescriptorProto.g = this.c;
                    i2 |= 2;
                }
                if ((i & 4) != 0) {
                    i2 |= 4;
                }
                fieldDescriptorProto.h = this.d;
                if ((i & 8) != 0) {
                    i2 |= 8;
                }
                fieldDescriptorProto.i = this.e;
                if ((i & 16) != 0) {
                    i2 |= 16;
                }
                fieldDescriptorProto.j = this.f;
                if ((i & 32) != 0) {
                    i2 |= 32;
                }
                fieldDescriptorProto.k = this.g;
                if ((i & 64) != 0) {
                    i2 |= 64;
                }
                fieldDescriptorProto.l = this.h;
                if ((i & 128) != 0) {
                    fieldDescriptorProto.m = this.i;
                    i2 |= 128;
                }
                if ((i & 256) != 0) {
                    i2 |= 256;
                }
                fieldDescriptorProto.n = this.j;
                if ((i & 512) != 0) {
                    SingleFieldBuilderV3<FieldOptions, FieldOptions.Builder, FieldOptionsOrBuilder> singleFieldBuilderV3 = this.l;
                    if (singleFieldBuilderV3 == null) {
                        fieldDescriptorProto.o = this.k;
                    } else {
                        fieldDescriptorProto.o = singleFieldBuilderV3.c();
                    }
                    i2 |= 512;
                }
                fieldDescriptorProto.e = i2;
                i();
                return fieldDescriptorProto;
            }

            public final Builder a(FieldDescriptorProto fieldDescriptorProto) {
                FieldOptions fieldOptions;
                if (fieldDescriptorProto == FieldDescriptorProto.B()) {
                    return this;
                }
                if (fieldDescriptorProto.e()) {
                    this.f6651a |= 1;
                    this.b = fieldDescriptorProto.f;
                    j();
                }
                if (fieldDescriptorProto.g()) {
                    int h = fieldDescriptorProto.h();
                    this.f6651a |= 2;
                    this.c = h;
                    j();
                }
                if (fieldDescriptorProto.i()) {
                    Label j = fieldDescriptorProto.j();
                    if (j == null) {
                        throw new NullPointerException();
                    }
                    this.f6651a |= 4;
                    this.d = j.a();
                    j();
                }
                if (fieldDescriptorProto.k()) {
                    Type l = fieldDescriptorProto.l();
                    if (l == null) {
                        throw new NullPointerException();
                    }
                    this.f6651a |= 8;
                    this.e = l.a();
                    j();
                }
                if (fieldDescriptorProto.m()) {
                    this.f6651a |= 16;
                    this.f = fieldDescriptorProto.j;
                    j();
                }
                if (fieldDescriptorProto.o()) {
                    this.f6651a |= 32;
                    this.g = fieldDescriptorProto.k;
                    j();
                }
                if (fieldDescriptorProto.t()) {
                    this.f6651a |= 64;
                    this.h = fieldDescriptorProto.l;
                    j();
                }
                if (fieldDescriptorProto.v()) {
                    int w = fieldDescriptorProto.w();
                    this.f6651a |= 128;
                    this.i = w;
                    j();
                }
                if (fieldDescriptorProto.x()) {
                    this.f6651a |= 256;
                    this.j = fieldDescriptorProto.n;
                    j();
                }
                if (fieldDescriptorProto.z()) {
                    FieldOptions A = fieldDescriptorProto.A();
                    SingleFieldBuilderV3<FieldOptions, FieldOptions.Builder, FieldOptionsOrBuilder> singleFieldBuilderV3 = this.l;
                    if (singleFieldBuilderV3 == null) {
                        if ((this.f6651a & 512) != 0 && (fieldOptions = this.k) != null && fieldOptions != FieldOptions.u()) {
                            A = FieldOptions.a(this.k).a(A).g();
                        }
                        this.k = A;
                        j();
                    } else {
                        singleFieldBuilderV3.a(A);
                    }
                    this.f6651a |= 512;
                }
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return !((this.f6651a & 512) != 0) || m().isInitialized();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.FieldDescriptorProto.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$FieldDescriptorProto> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.FieldDescriptorProto.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$FieldDescriptorProto r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.FieldDescriptorProto) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$FieldDescriptorProto r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.FieldDescriptorProto) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.FieldDescriptorProto.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$FieldDescriptorProto$Builder");
            }

            private FieldOptions m() {
                SingleFieldBuilderV3<FieldOptions, FieldOptions.Builder, FieldOptionsOrBuilder> singleFieldBuilderV3 = this.l;
                if (singleFieldBuilderV3 == null) {
                    FieldOptions fieldOptions = this.k;
                    return fieldOptions == null ? FieldOptions.u() : fieldOptions;
                }
                return singleFieldBuilderV3.b();
            }
        }

        public static FieldDescriptorProto B() {
            return q;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<FieldDescriptorProto> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class OneofDescriptorProto extends GeneratedMessageV3 implements OneofDescriptorProtoOrBuilder {
        private int e;
        private volatile Object f;
        private OneofOptions g;
        private byte h;
        private static final OneofDescriptorProto i = new OneofDescriptorProto();

        @Deprecated
        public static final Parser<OneofDescriptorProto> b = new AbstractParser<OneofDescriptorProto>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.OneofDescriptorProto.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new OneofDescriptorProto(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* synthetic */ OneofDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ OneofDescriptorProto(GeneratedMessageV3.Builder builder, byte b2) {
            this(builder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return i;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return j();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == i ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return j();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return i;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == i ? new Builder(b2) : new Builder(b2).a(this);
        }

        private OneofDescriptorProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.h = (byte) -1;
        }

        private OneofDescriptorProto() {
            this.h = (byte) -1;
            this.f = "";
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new OneofDescriptorProto();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private OneofDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 10) {
                            ByteString l = codedInputStream.l();
                            this.e |= 1;
                            this.f = l;
                        } else if (a3 == 18) {
                            OneofOptions.Builder e = (this.e & 2) != 0 ? this.g.e() : null;
                            this.g = (OneofOptions) codedInputStream.a(OneofOptions.b, extensionRegistryLite);
                            if (e != null) {
                                e.a(this.g);
                                this.g = e.g();
                            }
                            this.e |= 2;
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.a(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3).a(this);
                    }
                } finally {
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.p.a(OneofDescriptorProto.class, Builder.class);
        }

        public final boolean e() {
            return (this.e & 1) != 0;
        }

        public final String f() {
            Object obj = this.f;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.f = f;
            }
            return f;
        }

        public final boolean g() {
            return (this.e & 2) != 0;
        }

        public final OneofOptions h() {
            OneofOptions oneofOptions = this.g;
            return oneofOptions == null ? OneofOptions.f() : oneofOptions;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.h;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if ((this.e & 2) != 0) {
                OneofOptions oneofOptions = this.g;
                if (oneofOptions == null) {
                    oneofOptions = OneofOptions.f();
                }
                if (!oneofOptions.isInitialized()) {
                    this.h = (byte) 0;
                    return false;
                }
            }
            this.h = (byte) 1;
            return true;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                if (obj instanceof String) {
                    codedOutputStream.a(1, (String) obj);
                } else {
                    codedOutputStream.a(1, (ByteString) obj);
                }
            }
            if ((this.e & 2) != 0) {
                OneofOptions oneofOptions = this.g;
                if (oneofOptions == null) {
                    oneofOptions = OneofOptions.f();
                }
                codedOutputStream.a(2, oneofOptions);
            }
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i2 = this.f6632a;
            if (i2 != -1) {
                return i2;
            }
            int i3 = 0;
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                i3 = 0 + (obj instanceof String ? CodedOutputStream.b(1, (String) obj) : CodedOutputStream.c(1, (ByteString) obj));
            }
            if ((this.e & 2) != 0) {
                OneofOptions oneofOptions = this.g;
                if (oneofOptions == null) {
                    oneofOptions = OneofOptions.f();
                }
                i3 += CodedOutputStream.c(2, oneofOptions);
            }
            int serializedSize = i3 + this.d.getSerializedSize();
            this.f6632a = serializedSize;
            return serializedSize;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OneofDescriptorProto)) {
                return super.equals(obj);
            }
            OneofDescriptorProto oneofDescriptorProto = (OneofDescriptorProto) obj;
            if (((this.e & 1) != 0) != ((oneofDescriptorProto.e & 1) != 0)) {
                return false;
            }
            if (((this.e & 1) != 0) && !f().equals(oneofDescriptorProto.f())) {
                return false;
            }
            if (((this.e & 2) != 0) != ((oneofDescriptorProto.e & 2) != 0)) {
                return false;
            }
            if ((this.e & 2) != 0) {
                OneofOptions oneofOptions = this.g;
                if (oneofOptions == null) {
                    oneofOptions = OneofOptions.f();
                }
                OneofOptions oneofOptions2 = oneofDescriptorProto.g;
                if (oneofOptions2 == null) {
                    oneofOptions2 = OneofOptions.f();
                }
                if (!oneofOptions.equals(oneofOptions2)) {
                    return false;
                }
            }
            return this.d.equals(oneofDescriptorProto.d);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.o.hashCode() + 779;
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + f().hashCode();
                }
                if ((this.e & 2) != 0) {
                    int i2 = ((hashCode * 37) + 2) * 53;
                    OneofOptions oneofOptions = this.g;
                    if (oneofOptions == null) {
                        oneofOptions = OneofOptions.f();
                    }
                    hashCode = i2 + oneofOptions.hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.d.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }
            return this.memoizedHashCode;
        }

        private static Builder j() {
            OneofDescriptorProto oneofDescriptorProto = i;
            byte b2 = 0;
            return oneofDescriptorProto == oneofDescriptorProto ? new Builder(b2) : new Builder(b2).a(oneofDescriptorProto);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OneofDescriptorProtoOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6667a;
            private Object b;
            private OneofOptions c;
            private SingleFieldBuilderV3<OneofOptions, OneofOptions.Builder, OneofOptionsOrBuilder> d;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof OneofDescriptorProto) {
                    return a((OneofDescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                OneofDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof OneofDescriptorProto) {
                    return a((OneofDescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return OneofDescriptorProto.i();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                OneofDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return OneofDescriptorProto.i();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.p.a(OneofDescriptorProto.class, Builder.class);
            }

            private Builder() {
                this.b = "";
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = "";
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.o;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public OneofDescriptorProto g() {
                OneofDescriptorProto oneofDescriptorProto = new OneofDescriptorProto((GeneratedMessageV3.Builder) this, (byte) (0 == true ? 1 : 0));
                int i = this.f6667a;
                int i2 = (i & 1) != 0 ? 1 : 0;
                oneofDescriptorProto.f = this.b;
                if ((i & 2) != 0) {
                    SingleFieldBuilderV3<OneofOptions, OneofOptions.Builder, OneofOptionsOrBuilder> singleFieldBuilderV3 = this.d;
                    if (singleFieldBuilderV3 == null) {
                        oneofDescriptorProto.g = this.c;
                    } else {
                        oneofDescriptorProto.g = singleFieldBuilderV3.c();
                    }
                    i2 |= 2;
                }
                oneofDescriptorProto.e = i2;
                i();
                return oneofDescriptorProto;
            }

            public final Builder a(OneofDescriptorProto oneofDescriptorProto) {
                OneofOptions oneofOptions;
                if (oneofDescriptorProto == OneofDescriptorProto.i()) {
                    return this;
                }
                if (oneofDescriptorProto.e()) {
                    this.f6667a |= 1;
                    this.b = oneofDescriptorProto.f;
                    j();
                }
                if (oneofDescriptorProto.g()) {
                    OneofOptions h = oneofDescriptorProto.h();
                    SingleFieldBuilderV3<OneofOptions, OneofOptions.Builder, OneofOptionsOrBuilder> singleFieldBuilderV3 = this.d;
                    if (singleFieldBuilderV3 == null) {
                        if ((this.f6667a & 2) != 0 && (oneofOptions = this.c) != null && oneofOptions != OneofOptions.f()) {
                            h = OneofOptions.a(this.c).a(h).g();
                        }
                        this.c = h;
                        j();
                    } else {
                        singleFieldBuilderV3.a(h);
                    }
                    this.f6667a |= 2;
                }
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return !((this.f6667a & 2) != 0) || m().isInitialized();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.OneofDescriptorProto.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$OneofDescriptorProto> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.OneofDescriptorProto.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$OneofDescriptorProto r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.OneofDescriptorProto) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$OneofDescriptorProto r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.OneofDescriptorProto) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.OneofDescriptorProto.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$OneofDescriptorProto$Builder");
            }

            private OneofOptions m() {
                SingleFieldBuilderV3<OneofOptions, OneofOptions.Builder, OneofOptionsOrBuilder> singleFieldBuilderV3 = this.d;
                if (singleFieldBuilderV3 == null) {
                    OneofOptions oneofOptions = this.c;
                    return oneofOptions == null ? OneofOptions.f() : oneofOptions;
                }
                return singleFieldBuilderV3.b();
            }
        }

        public static OneofDescriptorProto i() {
            return i;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<OneofDescriptorProto> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class EnumDescriptorProto extends GeneratedMessageV3 implements EnumDescriptorProtoOrBuilder {
        private int e;
        private volatile Object f;
        private List<EnumValueDescriptorProto> g;
        private EnumOptions h;
        private List<EnumReservedRange> i;
        private LazyStringList j;
        private byte k;
        private static final EnumDescriptorProto l = new EnumDescriptorProto();

        @Deprecated
        public static final Parser<EnumDescriptorProto> b = new AbstractParser<EnumDescriptorProto>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.EnumDescriptorProto.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new EnumDescriptorProto(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* loaded from: classes3.dex */
        public interface EnumReservedRangeOrBuilder extends MessageOrBuilder {
        }

        /* synthetic */ EnumDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ EnumDescriptorProto(GeneratedMessageV3.Builder builder, byte b2) {
            this(builder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return l;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return k();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == l ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return k();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return l;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == l ? new Builder(b2) : new Builder(b2).a(this);
        }

        private EnumDescriptorProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.k = (byte) -1;
        }

        private EnumDescriptorProto() {
            this.k = (byte) -1;
            this.f = "";
            this.g = Collections.emptyList();
            this.i = Collections.emptyList();
            this.j = LazyStringArrayList.f6738a;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new EnumDescriptorProto();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private EnumDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            int i = 0;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 10) {
                            ByteString l2 = codedInputStream.l();
                            this.e |= 1;
                            this.f = l2;
                        } else if (a3 == 18) {
                            if ((i & 2) == 0) {
                                this.g = new ArrayList();
                                i |= 2;
                            }
                            this.g.add(codedInputStream.a(EnumValueDescriptorProto.b, extensionRegistryLite));
                        } else if (a3 == 26) {
                            EnumOptions.Builder i2 = (this.e & 2) != 0 ? this.h.i() : null;
                            this.h = (EnumOptions) codedInputStream.a(EnumOptions.b, extensionRegistryLite);
                            if (i2 != null) {
                                i2.a(this.h);
                                this.h = i2.g();
                            }
                            this.e |= 2;
                        } else if (a3 == 34) {
                            if ((i & 8) == 0) {
                                this.i = new ArrayList();
                                i |= 8;
                            }
                            this.i.add(codedInputStream.a(EnumReservedRange.b, extensionRegistryLite));
                        } else if (a3 == 42) {
                            ByteString l3 = codedInputStream.l();
                            if ((i & 16) == 0) {
                                this.j = new LazyStringArrayList();
                                i |= 16;
                            }
                            this.j.a(l3);
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if ((i & 2) != 0) {
                        this.g = Collections.unmodifiableList(this.g);
                    }
                    if ((i & 8) != 0) {
                        this.i = Collections.unmodifiableList(this.i);
                    }
                    if ((i & 16) != 0) {
                        this.j = this.j.e();
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.r.a(EnumDescriptorProto.class, Builder.class);
        }

        /* loaded from: classes3.dex */
        public static final class EnumReservedRange extends GeneratedMessageV3 implements EnumReservedRangeOrBuilder {
            private int e;
            private int f;
            private int g;
            private byte h;
            private static final EnumReservedRange i = new EnumReservedRange();

            @Deprecated
            public static final Parser<EnumReservedRange> b = new AbstractParser<EnumReservedRange>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRange.1
                @Override // com.uqm.crashsight.protobuf.Parser
                public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new EnumReservedRange(codedInputStream, extensionRegistryLite, (byte) 0);
                }
            };

            /* synthetic */ EnumReservedRange(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
                this(codedInputStream, extensionRegistryLite);
            }

            /* synthetic */ EnumReservedRange(GeneratedMessageV3.Builder builder, byte b2) {
                this(builder);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
                return new Builder(builderParent, (byte) 0);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* bridge */ /* synthetic */ MessageLite r() {
                return i;
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite
            public final /* synthetic */ MessageLite.Builder newBuilderForType() {
                return j();
            }

            @Override // com.uqm.crashsight.protobuf.Message
            public final /* synthetic */ Message.Builder p() {
                byte b2 = 0;
                return this == i ? new Builder(b2) : new Builder(b2).a(this);
            }

            @Override // com.uqm.crashsight.protobuf.Message
            public final /* synthetic */ Message.Builder q() {
                return j();
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* bridge */ /* synthetic */ Message r() {
                return i;
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite
            public final /* synthetic */ MessageLite.Builder toBuilder() {
                byte b2 = 0;
                return this == i ? new Builder(b2) : new Builder(b2).a(this);
            }

            private EnumReservedRange(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.h = (byte) -1;
            }

            private EnumReservedRange() {
                this.h = (byte) -1;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final Object a() {
                return new EnumReservedRange();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final UnknownFieldSet b() {
                return this.d;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private EnumReservedRange(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                if (extensionRegistryLite == null) {
                    throw new NullPointerException();
                }
                UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int a3 = codedInputStream.a();
                            if (a3 == 0) {
                                z = true;
                            } else if (a3 == 8) {
                                this.e |= 1;
                                this.f = codedInputStream.f();
                            } else if (a3 == 16) {
                                this.e |= 2;
                                this.g = codedInputStream.f();
                            } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                                z = true;
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw e.a(this);
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2).a(this);
                        }
                    } finally {
                        this.d = a2.build();
                        P();
                    }
                }
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.t.a(EnumReservedRange.class, Builder.class);
            }

            public final boolean e() {
                return (this.e & 1) != 0;
            }

            public final int f() {
                return this.f;
            }

            public final boolean g() {
                return (this.e & 2) != 0;
            }

            public final int h() {
                return this.g;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b2 = this.h;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.h = (byte) 1;
                return true;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
            public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.e & 1) != 0) {
                    codedOutputStream.b(1, this.f);
                }
                if ((this.e & 2) != 0) {
                    codedOutputStream.b(2, this.g);
                }
                this.d.writeTo(codedOutputStream);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
            public final int getSerializedSize() {
                int i2 = this.f6632a;
                if (i2 != -1) {
                    return i2;
                }
                int h = (this.e & 1) != 0 ? 0 + CodedOutputStream.h(1, this.f) : 0;
                if ((this.e & 2) != 0) {
                    h += CodedOutputStream.h(2, this.g);
                }
                int serializedSize = h + this.d.getSerializedSize();
                this.f6632a = serializedSize;
                return serializedSize;
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage
            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof EnumReservedRange)) {
                    return super.equals(obj);
                }
                EnumReservedRange enumReservedRange = (EnumReservedRange) obj;
                if (((this.e & 1) != 0) != ((enumReservedRange.e & 1) != 0)) {
                    return false;
                }
                if (((this.e & 1) != 0) && this.f != enumReservedRange.f) {
                    return false;
                }
                if (((this.e & 2) != 0) != ((enumReservedRange.e & 2) != 0)) {
                    return false;
                }
                return (!((this.e & 2) != 0) || this.g == enumReservedRange.g) && this.d.equals(enumReservedRange.d);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage
            public final int hashCode() {
                if (this.memoizedHashCode == 0) {
                    int hashCode = DescriptorProtos.s.hashCode() + 779;
                    if ((this.e & 1) != 0) {
                        hashCode = (((hashCode * 37) + 1) * 53) + this.f;
                    }
                    if ((this.e & 2) != 0) {
                        hashCode = (((hashCode * 37) + 2) * 53) + this.g;
                    }
                    int hashCode2 = (hashCode * 29) + this.d.hashCode();
                    this.memoizedHashCode = hashCode2;
                    return hashCode2;
                }
                return this.memoizedHashCode;
            }

            private static Builder j() {
                EnumReservedRange enumReservedRange = i;
                byte b2 = 0;
                return enumReservedRange == enumReservedRange ? new Builder(b2) : new Builder(b2).a(enumReservedRange);
            }

            /* loaded from: classes3.dex */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EnumReservedRangeOrBuilder {

                /* renamed from: a, reason: collision with root package name */
                private int f6646a;
                private int b;
                private int c;

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                /* synthetic */ Builder(byte b) {
                    this();
                }

                /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                    this(builderParent);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
                /* renamed from: a */
                public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                    if (message instanceof EnumReservedRange) {
                        return a((EnumReservedRange) message);
                    }
                    super.internalMergeFrom(message);
                    return this;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
                public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.a(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.c(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: b */
                public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.d(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: b */
                public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.a(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
                /* renamed from: build */
                public final /* synthetic */ MessageLite h() {
                    EnumReservedRange g = g();
                    if (g.isInitialized()) {
                        return g;
                    }
                    throw new UninitializedMessageException(MessageReflection.b(g));
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: c */
                public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.d(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.c(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
                /* renamed from: c */
                public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                    if (message instanceof EnumReservedRange) {
                        return a((EnumReservedRange) message);
                    }
                    super.internalMergeFrom(message);
                    return this;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ MessageLite.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.d(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.d(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: f */
                public final /* bridge */ /* synthetic */ Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
                /* renamed from: getDefaultInstanceForType */
                public final /* synthetic */ MessageLite r() {
                    return EnumReservedRange.i();
                }

                @Override // com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message h() {
                    EnumReservedRange g = g();
                    if (g.isInitialized()) {
                        return g;
                    }
                    throw new UninitializedMessageException(MessageReflection.b(g));
                }

                @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
                public final /* synthetic */ Message r() {
                    return EnumReservedRange.i();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                protected final GeneratedMessageV3.FieldAccessorTable c() {
                    return DescriptorProtos.t.a(EnumReservedRange.class, Builder.class);
                }

                private Builder() {
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
                public final Descriptors.Descriptor d() {
                    return DescriptorProtos.s;
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.uqm.crashsight.protobuf.Message.Builder
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public EnumReservedRange g() {
                    int i = 0;
                    EnumReservedRange enumReservedRange = new EnumReservedRange((GeneratedMessageV3.Builder) this, (byte) (0 == true ? 1 : 0));
                    int i2 = this.f6646a;
                    if ((i2 & 1) != 0) {
                        enumReservedRange.f = this.b;
                        i = 1;
                    }
                    if ((i2 & 2) != 0) {
                        enumReservedRange.g = this.c;
                        i |= 2;
                    }
                    enumReservedRange.e = i;
                    i();
                    return enumReservedRange;
                }

                public final Builder a(EnumReservedRange enumReservedRange) {
                    if (enumReservedRange == EnumReservedRange.i()) {
                        return this;
                    }
                    if (enumReservedRange.e()) {
                        int f = enumReservedRange.f();
                        this.f6646a |= 1;
                        this.b = f;
                        j();
                    }
                    if (enumReservedRange.g()) {
                        int h = enumReservedRange.h();
                        this.f6646a |= 2;
                        this.c = h;
                        j();
                    }
                    j();
                    return this;
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public com.uqm.crashsight.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRange> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRange.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        com.uqm.crashsight.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRange r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRange) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        if (r3 == 0) goto Le
                        r2.a(r3)
                    Le:
                        return r2
                    Lf:
                        r3 = move-exception
                        goto L1f
                    L11:
                        r3 = move-exception
                        com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                        com.uqm.crashsight.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRange r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRange) r4     // Catch: java.lang.Throwable -> Lf
                        java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                        throw r3     // Catch: java.lang.Throwable -> L1d
                    L1d:
                        r3 = move-exception
                        r0 = r4
                    L1f:
                        if (r0 == 0) goto L24
                        r2.a(r0)
                    L24:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.EnumDescriptorProto.EnumReservedRange.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$EnumDescriptorProto$EnumReservedRange$Builder");
                }
            }

            public static EnumReservedRange i() {
                return i;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
            public final Parser<EnumReservedRange> getParserForType() {
                return b;
            }
        }

        public final boolean e() {
            return (this.e & 1) != 0;
        }

        public final String f() {
            Object obj = this.f;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.f = f;
            }
            return f;
        }

        public final int g() {
            return this.g.size();
        }

        public final EnumValueDescriptorProto a(int i) {
            return this.g.get(i);
        }

        public final boolean h() {
            return (this.e & 2) != 0;
        }

        public final EnumOptions i() {
            EnumOptions enumOptions = this.h;
            return enumOptions == null ? EnumOptions.j() : enumOptions;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.k;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.g.size(); i++) {
                if (!this.g.get(i).isInitialized()) {
                    this.k = (byte) 0;
                    return false;
                }
            }
            if ((this.e & 2) != 0) {
                EnumOptions enumOptions = this.h;
                if (enumOptions == null) {
                    enumOptions = EnumOptions.j();
                }
                if (!enumOptions.isInitialized()) {
                    this.k = (byte) 0;
                    return false;
                }
            }
            this.k = (byte) 1;
            return true;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                if (obj instanceof String) {
                    codedOutputStream.a(1, (String) obj);
                } else {
                    codedOutputStream.a(1, (ByteString) obj);
                }
            }
            for (int i = 0; i < this.g.size(); i++) {
                codedOutputStream.a(2, this.g.get(i));
            }
            if ((this.e & 2) != 0) {
                EnumOptions enumOptions = this.h;
                if (enumOptions == null) {
                    enumOptions = EnumOptions.j();
                }
                codedOutputStream.a(3, enumOptions);
            }
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                codedOutputStream.a(4, this.i.get(i2));
            }
            for (int i3 = 0; i3 < this.j.size(); i3++) {
                Object b2 = this.j.b(i3);
                if (b2 instanceof String) {
                    codedOutputStream.a(5, (String) b2);
                } else {
                    codedOutputStream.a(5, (ByteString) b2);
                }
            }
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i;
            int i2 = this.f6632a;
            if (i2 != -1) {
                return i2;
            }
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                i = (obj instanceof String ? CodedOutputStream.b(1, (String) obj) : CodedOutputStream.c(1, (ByteString) obj)) + 0;
            } else {
                i = 0;
            }
            int i3 = i;
            for (int i4 = 0; i4 < this.g.size(); i4++) {
                i3 += CodedOutputStream.c(2, this.g.get(i4));
            }
            if ((this.e & 2) != 0) {
                EnumOptions enumOptions = this.h;
                if (enumOptions == null) {
                    enumOptions = EnumOptions.j();
                }
                i3 += CodedOutputStream.c(3, enumOptions);
            }
            for (int i5 = 0; i5 < this.i.size(); i5++) {
                i3 += CodedOutputStream.c(4, this.i.get(i5));
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.j.size(); i7++) {
                Object b2 = this.j.b(i7);
                i6 += b2 instanceof String ? CodedOutputStream.b((String) b2) : CodedOutputStream.b((ByteString) b2);
            }
            int size = i3 + i6 + (this.j.size() * 1) + this.d.getSerializedSize();
            this.f6632a = size;
            return size;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EnumDescriptorProto)) {
                return super.equals(obj);
            }
            EnumDescriptorProto enumDescriptorProto = (EnumDescriptorProto) obj;
            if (((this.e & 1) != 0) != ((enumDescriptorProto.e & 1) != 0)) {
                return false;
            }
            if ((((this.e & 1) != 0) && !f().equals(enumDescriptorProto.f())) || !this.g.equals(enumDescriptorProto.g)) {
                return false;
            }
            if (((this.e & 2) != 0) != ((enumDescriptorProto.e & 2) != 0)) {
                return false;
            }
            if ((this.e & 2) != 0) {
                EnumOptions enumOptions = this.h;
                if (enumOptions == null) {
                    enumOptions = EnumOptions.j();
                }
                EnumOptions enumOptions2 = enumDescriptorProto.h;
                if (enumOptions2 == null) {
                    enumOptions2 = EnumOptions.j();
                }
                if (!enumOptions.equals(enumOptions2)) {
                    return false;
                }
            }
            return this.i.equals(enumDescriptorProto.i) && this.j.equals(enumDescriptorProto.j) && this.d.equals(enumDescriptorProto.d);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.q.hashCode() + 779;
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + f().hashCode();
                }
                if (this.g.size() > 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + this.g.hashCode();
                }
                if ((this.e & 2) != 0) {
                    int i = ((hashCode * 37) + 3) * 53;
                    EnumOptions enumOptions = this.h;
                    if (enumOptions == null) {
                        enumOptions = EnumOptions.j();
                    }
                    hashCode = i + enumOptions.hashCode();
                }
                if (this.i.size() > 0) {
                    hashCode = (((hashCode * 37) + 4) * 53) + this.i.hashCode();
                }
                if (this.j.size() > 0) {
                    hashCode = (((hashCode * 37) + 5) * 53) + this.j.hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.d.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }
            return this.memoizedHashCode;
        }

        private static Builder k() {
            EnumDescriptorProto enumDescriptorProto = l;
            byte b2 = 0;
            return enumDescriptorProto == enumDescriptorProto ? new Builder(b2) : new Builder(b2).a(enumDescriptorProto);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EnumDescriptorProtoOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6645a;
            private Object b;
            private List<EnumValueDescriptorProto> c;
            private RepeatedFieldBuilderV3<EnumValueDescriptorProto, EnumValueDescriptorProto.Builder, EnumValueDescriptorProtoOrBuilder> d;
            private EnumOptions e;
            private SingleFieldBuilderV3<EnumOptions, EnumOptions.Builder, EnumOptionsOrBuilder> f;
            private List<EnumReservedRange> g;
            private RepeatedFieldBuilderV3<EnumReservedRange, EnumReservedRange.Builder, EnumReservedRangeOrBuilder> h;
            private LazyStringList i;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof EnumDescriptorProto) {
                    return a((EnumDescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                EnumDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof EnumDescriptorProto) {
                    return a((EnumDescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return EnumDescriptorProto.j();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                EnumDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return EnumDescriptorProto.j();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.r.a(EnumDescriptorProto.class, Builder.class);
            }

            private Builder() {
                this.b = "";
                this.c = Collections.emptyList();
                this.g = Collections.emptyList();
                this.i = LazyStringArrayList.f6738a;
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = "";
                this.c = Collections.emptyList();
                this.g = Collections.emptyList();
                this.i = LazyStringArrayList.f6738a;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.q;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public EnumDescriptorProto g() {
                EnumDescriptorProto enumDescriptorProto = new EnumDescriptorProto((GeneratedMessageV3.Builder) this, (byte) (0 == true ? 1 : 0));
                int i = this.f6645a;
                int i2 = (i & 1) != 0 ? 1 : 0;
                enumDescriptorProto.f = this.b;
                RepeatedFieldBuilderV3<EnumValueDescriptorProto, EnumValueDescriptorProto.Builder, EnumValueDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.d;
                if (repeatedFieldBuilderV3 != null) {
                    enumDescriptorProto.g = repeatedFieldBuilderV3.e();
                } else {
                    if ((this.f6645a & 2) != 0) {
                        this.c = Collections.unmodifiableList(this.c);
                        this.f6645a &= -3;
                    }
                    enumDescriptorProto.g = this.c;
                }
                if ((i & 4) != 0) {
                    SingleFieldBuilderV3<EnumOptions, EnumOptions.Builder, EnumOptionsOrBuilder> singleFieldBuilderV3 = this.f;
                    if (singleFieldBuilderV3 == null) {
                        enumDescriptorProto.h = this.e;
                    } else {
                        enumDescriptorProto.h = singleFieldBuilderV3.c();
                    }
                    i2 |= 2;
                }
                RepeatedFieldBuilderV3<EnumReservedRange, EnumReservedRange.Builder, EnumReservedRangeOrBuilder> repeatedFieldBuilderV32 = this.h;
                if (repeatedFieldBuilderV32 != null) {
                    enumDescriptorProto.i = repeatedFieldBuilderV32.e();
                } else {
                    if ((this.f6645a & 8) != 0) {
                        this.g = Collections.unmodifiableList(this.g);
                        this.f6645a &= -9;
                    }
                    enumDescriptorProto.i = this.g;
                }
                if ((this.f6645a & 16) != 0) {
                    this.i = this.i.e();
                    this.f6645a &= -17;
                }
                enumDescriptorProto.j = this.i;
                enumDescriptorProto.e = i2;
                i();
                return enumDescriptorProto;
            }

            public final Builder a(EnumDescriptorProto enumDescriptorProto) {
                EnumOptions enumOptions;
                if (enumDescriptorProto == EnumDescriptorProto.j()) {
                    return this;
                }
                if (enumDescriptorProto.e()) {
                    this.f6645a |= 1;
                    this.b = enumDescriptorProto.f;
                    j();
                }
                if (this.d == null) {
                    if (!enumDescriptorProto.g.isEmpty()) {
                        if (this.c.isEmpty()) {
                            this.c = enumDescriptorProto.g;
                            this.f6645a &= -3;
                        } else {
                            if ((this.f6645a & 2) == 0) {
                                this.c = new ArrayList(this.c);
                                this.f6645a |= 2;
                            }
                            this.c.addAll(enumDescriptorProto.g);
                        }
                        j();
                    }
                } else if (!enumDescriptorProto.g.isEmpty()) {
                    if (!this.d.d()) {
                        this.d.a(enumDescriptorProto.g);
                    } else {
                        this.d.b();
                        this.d = null;
                        this.c = enumDescriptorProto.g;
                        this.f6645a &= -3;
                        this.d = null;
                    }
                }
                if (enumDescriptorProto.h()) {
                    EnumOptions i = enumDescriptorProto.i();
                    SingleFieldBuilderV3<EnumOptions, EnumOptions.Builder, EnumOptionsOrBuilder> singleFieldBuilderV3 = this.f;
                    if (singleFieldBuilderV3 == null) {
                        if ((this.f6645a & 4) != 0 && (enumOptions = this.e) != null && enumOptions != EnumOptions.j()) {
                            i = EnumOptions.a(this.e).a(i).g();
                        }
                        this.e = i;
                        j();
                    } else {
                        singleFieldBuilderV3.a(i);
                    }
                    this.f6645a |= 4;
                }
                if (this.h == null) {
                    if (!enumDescriptorProto.i.isEmpty()) {
                        if (this.g.isEmpty()) {
                            this.g = enumDescriptorProto.i;
                            this.f6645a &= -9;
                        } else {
                            if ((this.f6645a & 8) == 0) {
                                this.g = new ArrayList(this.g);
                                this.f6645a |= 8;
                            }
                            this.g.addAll(enumDescriptorProto.i);
                        }
                        j();
                    }
                } else if (!enumDescriptorProto.i.isEmpty()) {
                    if (!this.h.d()) {
                        this.h.a(enumDescriptorProto.i);
                    } else {
                        this.h.b();
                        this.h = null;
                        this.g = enumDescriptorProto.i;
                        this.f6645a &= -9;
                        this.h = null;
                    }
                }
                if (!enumDescriptorProto.j.isEmpty()) {
                    if (this.i.isEmpty()) {
                        this.i = enumDescriptorProto.j;
                        this.f6645a &= -17;
                    } else {
                        if ((this.f6645a & 16) == 0) {
                            this.i = new LazyStringArrayList(this.i);
                            this.f6645a |= 16;
                        }
                        this.i.addAll(enumDescriptorProto.j);
                    }
                    j();
                }
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int i = 0;
                while (true) {
                    RepeatedFieldBuilderV3<EnumValueDescriptorProto, EnumValueDescriptorProto.Builder, EnumValueDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.d;
                    if (i >= (repeatedFieldBuilderV3 == null ? this.c.size() : repeatedFieldBuilderV3.c())) {
                        return !((this.f6645a & 4) != 0) || m().isInitialized();
                    }
                    RepeatedFieldBuilderV3<EnumValueDescriptorProto, EnumValueDescriptorProto.Builder, EnumValueDescriptorProtoOrBuilder> repeatedFieldBuilderV32 = this.d;
                    if (!(repeatedFieldBuilderV32 == null ? this.c.get(i) : repeatedFieldBuilderV32.a(i)).isInitialized()) {
                        return false;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.EnumDescriptorProto.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$EnumDescriptorProto> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.EnumDescriptorProto.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$EnumDescriptorProto r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.EnumDescriptorProto) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$EnumDescriptorProto r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.EnumDescriptorProto) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.EnumDescriptorProto.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$EnumDescriptorProto$Builder");
            }

            private EnumOptions m() {
                SingleFieldBuilderV3<EnumOptions, EnumOptions.Builder, EnumOptionsOrBuilder> singleFieldBuilderV3 = this.f;
                if (singleFieldBuilderV3 == null) {
                    EnumOptions enumOptions = this.e;
                    return enumOptions == null ? EnumOptions.j() : enumOptions;
                }
                return singleFieldBuilderV3.b();
            }
        }

        public static EnumDescriptorProto j() {
            return l;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<EnumDescriptorProto> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class EnumValueDescriptorProto extends GeneratedMessageV3 implements EnumValueDescriptorProtoOrBuilder {
        private int e;
        private volatile Object f;
        private int g;
        private EnumValueOptions h;
        private byte i;
        private static final EnumValueDescriptorProto j = new EnumValueDescriptorProto();

        @Deprecated
        public static final Parser<EnumValueDescriptorProto> b = new AbstractParser<EnumValueDescriptorProto>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.EnumValueDescriptorProto.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new EnumValueDescriptorProto(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* synthetic */ EnumValueDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ EnumValueDescriptorProto(GeneratedMessageV3.Builder builder, byte b2) {
            this(builder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return j;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return m();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == j ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return m();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return j;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == j ? new Builder(b2) : new Builder(b2).a(this);
        }

        private EnumValueDescriptorProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.i = (byte) -1;
        }

        private EnumValueDescriptorProto() {
            this.i = (byte) -1;
            this.f = "";
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new EnumValueDescriptorProto();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private EnumValueDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 10) {
                            ByteString l = codedInputStream.l();
                            this.e |= 1;
                            this.f = l;
                        } else if (a3 == 16) {
                            this.e |= 2;
                            this.g = codedInputStream.f();
                        } else if (a3 == 26) {
                            EnumValueOptions.Builder g = (this.e & 4) != 0 ? this.h.g() : null;
                            this.h = (EnumValueOptions) codedInputStream.a(EnumValueOptions.b, extensionRegistryLite);
                            if (g != null) {
                                g.a(this.h);
                                this.h = g.g();
                            }
                            this.e |= 4;
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.v.a(EnumValueDescriptorProto.class, Builder.class);
        }

        public final boolean e() {
            return (this.e & 1) != 0;
        }

        public final String f() {
            Object obj = this.f;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.f = f;
            }
            return f;
        }

        public final boolean g() {
            return (this.e & 2) != 0;
        }

        public final int h() {
            return this.g;
        }

        public final boolean i() {
            return (this.e & 4) != 0;
        }

        public final EnumValueOptions j() {
            EnumValueOptions enumValueOptions = this.h;
            return enumValueOptions == null ? EnumValueOptions.h() : enumValueOptions;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.i;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if ((this.e & 4) != 0) {
                EnumValueOptions enumValueOptions = this.h;
                if (enumValueOptions == null) {
                    enumValueOptions = EnumValueOptions.h();
                }
                if (!enumValueOptions.isInitialized()) {
                    this.i = (byte) 0;
                    return false;
                }
            }
            this.i = (byte) 1;
            return true;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                if (obj instanceof String) {
                    codedOutputStream.a(1, (String) obj);
                } else {
                    codedOutputStream.a(1, (ByteString) obj);
                }
            }
            if ((this.e & 2) != 0) {
                codedOutputStream.b(2, this.g);
            }
            if ((this.e & 4) != 0) {
                EnumValueOptions enumValueOptions = this.h;
                if (enumValueOptions == null) {
                    enumValueOptions = EnumValueOptions.h();
                }
                codedOutputStream.a(3, enumValueOptions);
            }
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.f6632a;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                i2 = 0 + (obj instanceof String ? CodedOutputStream.b(1, (String) obj) : CodedOutputStream.c(1, (ByteString) obj));
            }
            if ((this.e & 2) != 0) {
                i2 += CodedOutputStream.h(2, this.g);
            }
            if ((this.e & 4) != 0) {
                EnumValueOptions enumValueOptions = this.h;
                if (enumValueOptions == null) {
                    enumValueOptions = EnumValueOptions.h();
                }
                i2 += CodedOutputStream.c(3, enumValueOptions);
            }
            int serializedSize = i2 + this.d.getSerializedSize();
            this.f6632a = serializedSize;
            return serializedSize;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EnumValueDescriptorProto)) {
                return super.equals(obj);
            }
            EnumValueDescriptorProto enumValueDescriptorProto = (EnumValueDescriptorProto) obj;
            if (((this.e & 1) != 0) != ((enumValueDescriptorProto.e & 1) != 0)) {
                return false;
            }
            if (((this.e & 1) != 0) && !f().equals(enumValueDescriptorProto.f())) {
                return false;
            }
            if (((this.e & 2) != 0) != ((enumValueDescriptorProto.e & 2) != 0)) {
                return false;
            }
            if (((this.e & 2) != 0) && this.g != enumValueDescriptorProto.g) {
                return false;
            }
            if (((this.e & 4) != 0) != ((enumValueDescriptorProto.e & 4) != 0)) {
                return false;
            }
            if ((this.e & 4) != 0) {
                EnumValueOptions enumValueOptions = this.h;
                if (enumValueOptions == null) {
                    enumValueOptions = EnumValueOptions.h();
                }
                EnumValueOptions enumValueOptions2 = enumValueDescriptorProto.h;
                if (enumValueOptions2 == null) {
                    enumValueOptions2 = EnumValueOptions.h();
                }
                if (!enumValueOptions.equals(enumValueOptions2)) {
                    return false;
                }
            }
            return this.d.equals(enumValueDescriptorProto.d);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.u.hashCode() + 779;
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + f().hashCode();
                }
                if ((this.e & 2) != 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + this.g;
                }
                if ((this.e & 4) != 0) {
                    int i = ((hashCode * 37) + 3) * 53;
                    EnumValueOptions enumValueOptions = this.h;
                    if (enumValueOptions == null) {
                        enumValueOptions = EnumValueOptions.h();
                    }
                    hashCode = i + enumValueOptions.hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.d.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }
            return this.memoizedHashCode;
        }

        private static Builder m() {
            EnumValueDescriptorProto enumValueDescriptorProto = j;
            byte b2 = 0;
            return enumValueDescriptorProto == enumValueDescriptorProto ? new Builder(b2) : new Builder(b2).a(enumValueDescriptorProto);
        }

        public static Builder k() {
            EnumValueDescriptorProto enumValueDescriptorProto = j;
            byte b2 = 0;
            return enumValueDescriptorProto == enumValueDescriptorProto ? new Builder(b2) : new Builder(b2).a(enumValueDescriptorProto);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EnumValueDescriptorProtoOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6648a;
            private Object b;
            private int c;
            private EnumValueOptions d;
            private SingleFieldBuilderV3<EnumValueOptions, EnumValueOptions.Builder, EnumValueOptionsOrBuilder> e;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof EnumValueDescriptorProto) {
                    return a((EnumValueDescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                EnumValueDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof EnumValueDescriptorProto) {
                    return a((EnumValueDescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return EnumValueDescriptorProto.l();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                EnumValueDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return EnumValueDescriptorProto.l();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.v.a(EnumValueDescriptorProto.class, Builder.class);
            }

            private Builder() {
                this.b = "";
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = "";
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.u;
            }

            public final EnumValueDescriptorProto e() {
                EnumValueDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public EnumValueDescriptorProto g() {
                EnumValueDescriptorProto enumValueDescriptorProto = new EnumValueDescriptorProto((GeneratedMessageV3.Builder) this, (byte) (0 == true ? 1 : 0));
                int i = this.f6648a;
                int i2 = (i & 1) != 0 ? 1 : 0;
                enumValueDescriptorProto.f = this.b;
                if ((i & 2) != 0) {
                    enumValueDescriptorProto.g = this.c;
                    i2 |= 2;
                }
                if ((i & 4) != 0) {
                    SingleFieldBuilderV3<EnumValueOptions, EnumValueOptions.Builder, EnumValueOptionsOrBuilder> singleFieldBuilderV3 = this.e;
                    if (singleFieldBuilderV3 == null) {
                        enumValueDescriptorProto.h = this.d;
                    } else {
                        enumValueDescriptorProto.h = singleFieldBuilderV3.c();
                    }
                    i2 |= 4;
                }
                enumValueDescriptorProto.e = i2;
                i();
                return enumValueDescriptorProto;
            }

            public final Builder a(EnumValueDescriptorProto enumValueDescriptorProto) {
                EnumValueOptions enumValueOptions;
                if (enumValueDescriptorProto == EnumValueDescriptorProto.l()) {
                    return this;
                }
                if (enumValueDescriptorProto.e()) {
                    this.f6648a |= 1;
                    this.b = enumValueDescriptorProto.f;
                    j();
                }
                if (enumValueDescriptorProto.g()) {
                    int h = enumValueDescriptorProto.h();
                    this.f6648a |= 2;
                    this.c = h;
                    j();
                }
                if (enumValueDescriptorProto.i()) {
                    EnumValueOptions j = enumValueDescriptorProto.j();
                    SingleFieldBuilderV3<EnumValueOptions, EnumValueOptions.Builder, EnumValueOptionsOrBuilder> singleFieldBuilderV3 = this.e;
                    if (singleFieldBuilderV3 == null) {
                        if ((this.f6648a & 4) != 0 && (enumValueOptions = this.d) != null && enumValueOptions != EnumValueOptions.h()) {
                            j = EnumValueOptions.a(this.d).a(j).g();
                        }
                        this.d = j;
                        j();
                    } else {
                        singleFieldBuilderV3.a(j);
                    }
                    this.f6648a |= 4;
                }
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return !((this.f6648a & 4) != 0) || n().isInitialized();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.EnumValueDescriptorProto.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$EnumValueDescriptorProto> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.EnumValueDescriptorProto.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$EnumValueDescriptorProto r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.EnumValueDescriptorProto) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$EnumValueDescriptorProto r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.EnumValueDescriptorProto) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.EnumValueDescriptorProto.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$EnumValueDescriptorProto$Builder");
            }

            public final Builder a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f6648a |= 1;
                this.b = str;
                j();
                return this;
            }

            public final Builder a(int i) {
                this.f6648a |= 2;
                this.c = i;
                j();
                return this;
            }

            private EnumValueOptions n() {
                SingleFieldBuilderV3<EnumValueOptions, EnumValueOptions.Builder, EnumValueOptionsOrBuilder> singleFieldBuilderV3 = this.e;
                if (singleFieldBuilderV3 == null) {
                    EnumValueOptions enumValueOptions = this.d;
                    return enumValueOptions == null ? EnumValueOptions.h() : enumValueOptions;
                }
                return singleFieldBuilderV3.b();
            }
        }

        public static EnumValueDescriptorProto l() {
            return j;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<EnumValueDescriptorProto> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class ServiceDescriptorProto extends GeneratedMessageV3 implements ServiceDescriptorProtoOrBuilder {
        private int e;
        private volatile Object f;
        private List<MethodDescriptorProto> g;
        private ServiceOptions h;
        private byte i;
        private static final ServiceDescriptorProto j = new ServiceDescriptorProto();

        @Deprecated
        public static final Parser<ServiceDescriptorProto> b = new AbstractParser<ServiceDescriptorProto>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.ServiceDescriptorProto.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ServiceDescriptorProto(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* synthetic */ ServiceDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ ServiceDescriptorProto(GeneratedMessageV3.Builder builder, byte b2) {
            this(builder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return j;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return k();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == j ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return k();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return j;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == j ? new Builder(b2) : new Builder(b2).a(this);
        }

        private ServiceDescriptorProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.i = (byte) -1;
        }

        private ServiceDescriptorProto() {
            this.i = (byte) -1;
            this.f = "";
            this.g = Collections.emptyList();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new ServiceDescriptorProto();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ServiceDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            int i = 0;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 10) {
                            ByteString l = codedInputStream.l();
                            this.e |= 1;
                            this.f = l;
                        } else if (a3 == 18) {
                            if ((i & 2) == 0) {
                                this.g = new ArrayList();
                                i |= 2;
                            }
                            this.g.add(codedInputStream.a(MethodDescriptorProto.b, extensionRegistryLite));
                        } else if (a3 == 26) {
                            ServiceOptions.Builder g = (this.e & 2) != 0 ? this.h.g() : null;
                            this.h = (ServiceOptions) codedInputStream.a(ServiceOptions.b, extensionRegistryLite);
                            if (g != null) {
                                g.a(this.h);
                                this.h = g.g();
                            }
                            this.e |= 2;
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if ((i & 2) != 0) {
                        this.g = Collections.unmodifiableList(this.g);
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.x.a(ServiceDescriptorProto.class, Builder.class);
        }

        public final boolean e() {
            return (this.e & 1) != 0;
        }

        public final String f() {
            Object obj = this.f;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.f = f;
            }
            return f;
        }

        public final int g() {
            return this.g.size();
        }

        public final MethodDescriptorProto a(int i) {
            return this.g.get(i);
        }

        public final boolean h() {
            return (this.e & 2) != 0;
        }

        public final ServiceOptions i() {
            ServiceOptions serviceOptions = this.h;
            return serviceOptions == null ? ServiceOptions.h() : serviceOptions;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.i;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.g.size(); i++) {
                if (!this.g.get(i).isInitialized()) {
                    this.i = (byte) 0;
                    return false;
                }
            }
            if ((this.e & 2) != 0) {
                ServiceOptions serviceOptions = this.h;
                if (serviceOptions == null) {
                    serviceOptions = ServiceOptions.h();
                }
                if (!serviceOptions.isInitialized()) {
                    this.i = (byte) 0;
                    return false;
                }
            }
            this.i = (byte) 1;
            return true;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                if (obj instanceof String) {
                    codedOutputStream.a(1, (String) obj);
                } else {
                    codedOutputStream.a(1, (ByteString) obj);
                }
            }
            for (int i = 0; i < this.g.size(); i++) {
                codedOutputStream.a(2, this.g.get(i));
            }
            if ((this.e & 2) != 0) {
                ServiceOptions serviceOptions = this.h;
                if (serviceOptions == null) {
                    serviceOptions = ServiceOptions.h();
                }
                codedOutputStream.a(3, serviceOptions);
            }
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i;
            int i2 = this.f6632a;
            if (i2 != -1) {
                return i2;
            }
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                i = (obj instanceof String ? CodedOutputStream.b(1, (String) obj) : CodedOutputStream.c(1, (ByteString) obj)) + 0;
            } else {
                i = 0;
            }
            for (int i3 = 0; i3 < this.g.size(); i3++) {
                i += CodedOutputStream.c(2, this.g.get(i3));
            }
            if ((this.e & 2) != 0) {
                ServiceOptions serviceOptions = this.h;
                if (serviceOptions == null) {
                    serviceOptions = ServiceOptions.h();
                }
                i += CodedOutputStream.c(3, serviceOptions);
            }
            int serializedSize = i + this.d.getSerializedSize();
            this.f6632a = serializedSize;
            return serializedSize;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ServiceDescriptorProto)) {
                return super.equals(obj);
            }
            ServiceDescriptorProto serviceDescriptorProto = (ServiceDescriptorProto) obj;
            if (((this.e & 1) != 0) != ((serviceDescriptorProto.e & 1) != 0)) {
                return false;
            }
            if ((((this.e & 1) != 0) && !f().equals(serviceDescriptorProto.f())) || !this.g.equals(serviceDescriptorProto.g)) {
                return false;
            }
            if (((this.e & 2) != 0) != ((serviceDescriptorProto.e & 2) != 0)) {
                return false;
            }
            if ((this.e & 2) != 0) {
                ServiceOptions serviceOptions = this.h;
                if (serviceOptions == null) {
                    serviceOptions = ServiceOptions.h();
                }
                ServiceOptions serviceOptions2 = serviceDescriptorProto.h;
                if (serviceOptions2 == null) {
                    serviceOptions2 = ServiceOptions.h();
                }
                if (!serviceOptions.equals(serviceOptions2)) {
                    return false;
                }
            }
            return this.d.equals(serviceDescriptorProto.d);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.w.hashCode() + 779;
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + f().hashCode();
                }
                if (this.g.size() > 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + this.g.hashCode();
                }
                if ((this.e & 2) != 0) {
                    int i = ((hashCode * 37) + 3) * 53;
                    ServiceOptions serviceOptions = this.h;
                    if (serviceOptions == null) {
                        serviceOptions = ServiceOptions.h();
                    }
                    hashCode = i + serviceOptions.hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.d.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }
            return this.memoizedHashCode;
        }

        private static Builder k() {
            ServiceDescriptorProto serviceDescriptorProto = j;
            byte b2 = 0;
            return serviceDescriptorProto == serviceDescriptorProto ? new Builder(b2) : new Builder(b2).a(serviceDescriptorProto);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ServiceDescriptorProtoOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6669a;
            private Object b;
            private List<MethodDescriptorProto> c;
            private RepeatedFieldBuilderV3<MethodDescriptorProto, MethodDescriptorProto.Builder, MethodDescriptorProtoOrBuilder> d;
            private ServiceOptions e;
            private SingleFieldBuilderV3<ServiceOptions, ServiceOptions.Builder, ServiceOptionsOrBuilder> f;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof ServiceDescriptorProto) {
                    return a((ServiceDescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                ServiceDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof ServiceDescriptorProto) {
                    return a((ServiceDescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return ServiceDescriptorProto.j();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                ServiceDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return ServiceDescriptorProto.j();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.x.a(ServiceDescriptorProto.class, Builder.class);
            }

            private Builder() {
                this.b = "";
                this.c = Collections.emptyList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = "";
                this.c = Collections.emptyList();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.w;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public ServiceDescriptorProto g() {
                ServiceDescriptorProto serviceDescriptorProto = new ServiceDescriptorProto((GeneratedMessageV3.Builder) this, (byte) (0 == true ? 1 : 0));
                int i = this.f6669a;
                int i2 = (i & 1) != 0 ? 1 : 0;
                serviceDescriptorProto.f = this.b;
                RepeatedFieldBuilderV3<MethodDescriptorProto, MethodDescriptorProto.Builder, MethodDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.d;
                if (repeatedFieldBuilderV3 != null) {
                    serviceDescriptorProto.g = repeatedFieldBuilderV3.e();
                } else {
                    if ((this.f6669a & 2) != 0) {
                        this.c = Collections.unmodifiableList(this.c);
                        this.f6669a &= -3;
                    }
                    serviceDescriptorProto.g = this.c;
                }
                if ((i & 4) != 0) {
                    SingleFieldBuilderV3<ServiceOptions, ServiceOptions.Builder, ServiceOptionsOrBuilder> singleFieldBuilderV3 = this.f;
                    if (singleFieldBuilderV3 == null) {
                        serviceDescriptorProto.h = this.e;
                    } else {
                        serviceDescriptorProto.h = singleFieldBuilderV3.c();
                    }
                    i2 |= 2;
                }
                serviceDescriptorProto.e = i2;
                i();
                return serviceDescriptorProto;
            }

            public final Builder a(ServiceDescriptorProto serviceDescriptorProto) {
                ServiceOptions serviceOptions;
                if (serviceDescriptorProto == ServiceDescriptorProto.j()) {
                    return this;
                }
                if (serviceDescriptorProto.e()) {
                    this.f6669a |= 1;
                    this.b = serviceDescriptorProto.f;
                    j();
                }
                if (this.d == null) {
                    if (!serviceDescriptorProto.g.isEmpty()) {
                        if (this.c.isEmpty()) {
                            this.c = serviceDescriptorProto.g;
                            this.f6669a &= -3;
                        } else {
                            if ((this.f6669a & 2) == 0) {
                                this.c = new ArrayList(this.c);
                                this.f6669a |= 2;
                            }
                            this.c.addAll(serviceDescriptorProto.g);
                        }
                        j();
                    }
                } else if (!serviceDescriptorProto.g.isEmpty()) {
                    if (!this.d.d()) {
                        this.d.a(serviceDescriptorProto.g);
                    } else {
                        this.d.b();
                        this.d = null;
                        this.c = serviceDescriptorProto.g;
                        this.f6669a &= -3;
                        this.d = null;
                    }
                }
                if (serviceDescriptorProto.h()) {
                    ServiceOptions i = serviceDescriptorProto.i();
                    SingleFieldBuilderV3<ServiceOptions, ServiceOptions.Builder, ServiceOptionsOrBuilder> singleFieldBuilderV3 = this.f;
                    if (singleFieldBuilderV3 == null) {
                        if ((this.f6669a & 4) != 0 && (serviceOptions = this.e) != null && serviceOptions != ServiceOptions.h()) {
                            i = ServiceOptions.a(this.e).a(i).g();
                        }
                        this.e = i;
                        j();
                    } else {
                        singleFieldBuilderV3.a(i);
                    }
                    this.f6669a |= 4;
                }
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int i = 0;
                while (true) {
                    RepeatedFieldBuilderV3<MethodDescriptorProto, MethodDescriptorProto.Builder, MethodDescriptorProtoOrBuilder> repeatedFieldBuilderV3 = this.d;
                    if (i >= (repeatedFieldBuilderV3 == null ? this.c.size() : repeatedFieldBuilderV3.c())) {
                        return !((this.f6669a & 4) != 0) || m().isInitialized();
                    }
                    RepeatedFieldBuilderV3<MethodDescriptorProto, MethodDescriptorProto.Builder, MethodDescriptorProtoOrBuilder> repeatedFieldBuilderV32 = this.d;
                    if (!(repeatedFieldBuilderV32 == null ? this.c.get(i) : repeatedFieldBuilderV32.a(i)).isInitialized()) {
                        return false;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.ServiceDescriptorProto.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$ServiceDescriptorProto> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.ServiceDescriptorProto.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$ServiceDescriptorProto r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.ServiceDescriptorProto) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$ServiceDescriptorProto r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.ServiceDescriptorProto) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.ServiceDescriptorProto.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$ServiceDescriptorProto$Builder");
            }

            private ServiceOptions m() {
                SingleFieldBuilderV3<ServiceOptions, ServiceOptions.Builder, ServiceOptionsOrBuilder> singleFieldBuilderV3 = this.f;
                if (singleFieldBuilderV3 == null) {
                    ServiceOptions serviceOptions = this.e;
                    return serviceOptions == null ? ServiceOptions.h() : serviceOptions;
                }
                return singleFieldBuilderV3.b();
            }
        }

        public static ServiceDescriptorProto j() {
            return j;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<ServiceDescriptorProto> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class MethodDescriptorProto extends GeneratedMessageV3 implements MethodDescriptorProtoOrBuilder {
        private int e;
        private volatile Object f;
        private volatile Object g;
        private volatile Object h;
        private MethodOptions i;
        private boolean j;
        private boolean k;
        private byte l;
        private static final MethodDescriptorProto m = new MethodDescriptorProto();

        @Deprecated
        public static final Parser<MethodDescriptorProto> b = new AbstractParser<MethodDescriptorProto>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.MethodDescriptorProto.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MethodDescriptorProto(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* synthetic */ MethodDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ MethodDescriptorProto(GeneratedMessageV3.Builder builder, byte b2) {
            this(builder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return m;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return u();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == m ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return u();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return m;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == m ? new Builder(b2) : new Builder(b2).a(this);
        }

        private MethodDescriptorProto(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.l = (byte) -1;
        }

        private MethodDescriptorProto() {
            this.l = (byte) -1;
            this.f = "";
            this.g = "";
            this.h = "";
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new MethodDescriptorProto();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MethodDescriptorProto(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 10) {
                            ByteString l = codedInputStream.l();
                            this.e |= 1;
                            this.f = l;
                        } else if (a3 == 18) {
                            ByteString l2 = codedInputStream.l();
                            this.e |= 2;
                            this.g = l2;
                        } else if (a3 == 26) {
                            ByteString l3 = codedInputStream.l();
                            this.e |= 4;
                            this.h = l3;
                        } else if (a3 == 34) {
                            MethodOptions.Builder i = (this.e & 8) != 0 ? this.i.i() : null;
                            this.i = (MethodOptions) codedInputStream.a(MethodOptions.b, extensionRegistryLite);
                            if (i != null) {
                                i.a(this.i);
                                this.i = i.g();
                            }
                            this.e |= 8;
                        } else if (a3 == 40) {
                            this.e |= 16;
                            this.j = codedInputStream.i();
                        } else if (a3 == 48) {
                            this.e |= 32;
                            this.k = codedInputStream.i();
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.z.a(MethodDescriptorProto.class, Builder.class);
        }

        public final boolean e() {
            return (this.e & 1) != 0;
        }

        public final String f() {
            Object obj = this.f;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.f = f;
            }
            return f;
        }

        public final boolean g() {
            return (this.e & 2) != 0;
        }

        public final String h() {
            Object obj = this.g;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.g = f;
            }
            return f;
        }

        public final boolean i() {
            return (this.e & 4) != 0;
        }

        public final String j() {
            Object obj = this.h;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.h = f;
            }
            return f;
        }

        public final boolean k() {
            return (this.e & 8) != 0;
        }

        public final MethodOptions l() {
            MethodOptions methodOptions = this.i;
            return methodOptions == null ? MethodOptions.j() : methodOptions;
        }

        public final boolean m() {
            return (this.e & 16) != 0;
        }

        public final boolean n() {
            return this.j;
        }

        public final boolean o() {
            return (this.e & 32) != 0;
        }

        public final boolean s() {
            return this.k;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.l;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if ((this.e & 8) != 0) {
                MethodOptions methodOptions = this.i;
                if (methodOptions == null) {
                    methodOptions = MethodOptions.j();
                }
                if (!methodOptions.isInitialized()) {
                    this.l = (byte) 0;
                    return false;
                }
            }
            this.l = (byte) 1;
            return true;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                if (obj instanceof String) {
                    codedOutputStream.a(1, (String) obj);
                } else {
                    codedOutputStream.a(1, (ByteString) obj);
                }
            }
            if ((this.e & 2) != 0) {
                Object obj2 = this.g;
                if (obj2 instanceof String) {
                    codedOutputStream.a(2, (String) obj2);
                } else {
                    codedOutputStream.a(2, (ByteString) obj2);
                }
            }
            if ((this.e & 4) != 0) {
                Object obj3 = this.h;
                if (obj3 instanceof String) {
                    codedOutputStream.a(3, (String) obj3);
                } else {
                    codedOutputStream.a(3, (ByteString) obj3);
                }
            }
            if ((this.e & 8) != 0) {
                MethodOptions methodOptions = this.i;
                if (methodOptions == null) {
                    methodOptions = MethodOptions.j();
                }
                codedOutputStream.a(4, methodOptions);
            }
            if ((this.e & 16) != 0) {
                codedOutputStream.a(5, this.j);
            }
            if ((this.e & 32) != 0) {
                codedOutputStream.a(6, this.k);
            }
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.f6632a;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                i2 = 0 + (obj instanceof String ? CodedOutputStream.b(1, (String) obj) : CodedOutputStream.c(1, (ByteString) obj));
            }
            if ((this.e & 2) != 0) {
                Object obj2 = this.g;
                i2 += obj2 instanceof String ? CodedOutputStream.b(2, (String) obj2) : CodedOutputStream.c(2, (ByteString) obj2);
            }
            if ((this.e & 4) != 0) {
                Object obj3 = this.h;
                i2 += obj3 instanceof String ? CodedOutputStream.b(3, (String) obj3) : CodedOutputStream.c(3, (ByteString) obj3);
            }
            if ((this.e & 8) != 0) {
                MethodOptions methodOptions = this.i;
                if (methodOptions == null) {
                    methodOptions = MethodOptions.j();
                }
                i2 += CodedOutputStream.c(4, methodOptions);
            }
            if ((this.e & 16) != 0) {
                i2 += CodedOutputStream.b(5, this.j);
            }
            if ((this.e & 32) != 0) {
                i2 += CodedOutputStream.b(6, this.k);
            }
            int serializedSize = i2 + this.d.getSerializedSize();
            this.f6632a = serializedSize;
            return serializedSize;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MethodDescriptorProto)) {
                return super.equals(obj);
            }
            MethodDescriptorProto methodDescriptorProto = (MethodDescriptorProto) obj;
            if (((this.e & 1) != 0) != ((methodDescriptorProto.e & 1) != 0)) {
                return false;
            }
            if (((this.e & 1) != 0) && !f().equals(methodDescriptorProto.f())) {
                return false;
            }
            if (((this.e & 2) != 0) != ((methodDescriptorProto.e & 2) != 0)) {
                return false;
            }
            if (((this.e & 2) != 0) && !h().equals(methodDescriptorProto.h())) {
                return false;
            }
            if (((this.e & 4) != 0) != ((methodDescriptorProto.e & 4) != 0)) {
                return false;
            }
            if (((this.e & 4) != 0) && !j().equals(methodDescriptorProto.j())) {
                return false;
            }
            if (((this.e & 8) != 0) != ((methodDescriptorProto.e & 8) != 0)) {
                return false;
            }
            if ((this.e & 8) != 0) {
                MethodOptions methodOptions = this.i;
                if (methodOptions == null) {
                    methodOptions = MethodOptions.j();
                }
                MethodOptions methodOptions2 = methodDescriptorProto.i;
                if (methodOptions2 == null) {
                    methodOptions2 = MethodOptions.j();
                }
                if (!methodOptions.equals(methodOptions2)) {
                    return false;
                }
            }
            if (((this.e & 16) != 0) != ((methodDescriptorProto.e & 16) != 0)) {
                return false;
            }
            if (((this.e & 16) != 0) && this.j != methodDescriptorProto.j) {
                return false;
            }
            if (((this.e & 32) != 0) != ((methodDescriptorProto.e & 32) != 0)) {
                return false;
            }
            return (!((this.e & 32) != 0) || this.k == methodDescriptorProto.k) && this.d.equals(methodDescriptorProto.d);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.y.hashCode() + 779;
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + f().hashCode();
                }
                if ((this.e & 2) != 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + h().hashCode();
                }
                if ((this.e & 4) != 0) {
                    hashCode = (((hashCode * 37) + 3) * 53) + j().hashCode();
                }
                if ((this.e & 8) != 0) {
                    int i = ((hashCode * 37) + 4) * 53;
                    MethodOptions methodOptions = this.i;
                    if (methodOptions == null) {
                        methodOptions = MethodOptions.j();
                    }
                    hashCode = i + methodOptions.hashCode();
                }
                if ((this.e & 16) != 0) {
                    hashCode = (((hashCode * 37) + 5) * 53) + Internal.a(this.j);
                }
                if ((this.e & 32) != 0) {
                    hashCode = (((hashCode * 37) + 6) * 53) + Internal.a(this.k);
                }
                int hashCode2 = (hashCode * 29) + this.d.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }
            return this.memoizedHashCode;
        }

        private static Builder u() {
            MethodDescriptorProto methodDescriptorProto = m;
            byte b2 = 0;
            return methodDescriptorProto == methodDescriptorProto ? new Builder(b2) : new Builder(b2).a(methodDescriptorProto);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MethodDescriptorProtoOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6664a;
            private Object b;
            private Object c;
            private Object d;
            private MethodOptions e;
            private SingleFieldBuilderV3<MethodOptions, MethodOptions.Builder, MethodOptionsOrBuilder> f;
            private boolean g;
            private boolean h;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof MethodDescriptorProto) {
                    return a((MethodDescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                MethodDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof MethodDescriptorProto) {
                    return a((MethodDescriptorProto) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return MethodDescriptorProto.t();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                MethodDescriptorProto g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return MethodDescriptorProto.t();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.z.a(MethodDescriptorProto.class, Builder.class);
            }

            private Builder() {
                this.b = "";
                this.c = "";
                this.d = "";
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = "";
                this.c = "";
                this.d = "";
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.y;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public MethodDescriptorProto g() {
                MethodDescriptorProto methodDescriptorProto = new MethodDescriptorProto((GeneratedMessageV3.Builder) this, (byte) (0 == true ? 1 : 0));
                int i = this.f6664a;
                int i2 = (i & 1) != 0 ? 1 : 0;
                methodDescriptorProto.f = this.b;
                if ((i & 2) != 0) {
                    i2 |= 2;
                }
                methodDescriptorProto.g = this.c;
                if ((i & 4) != 0) {
                    i2 |= 4;
                }
                methodDescriptorProto.h = this.d;
                if ((i & 8) != 0) {
                    SingleFieldBuilderV3<MethodOptions, MethodOptions.Builder, MethodOptionsOrBuilder> singleFieldBuilderV3 = this.f;
                    if (singleFieldBuilderV3 == null) {
                        methodDescriptorProto.i = this.e;
                    } else {
                        methodDescriptorProto.i = singleFieldBuilderV3.c();
                    }
                    i2 |= 8;
                }
                if ((i & 16) != 0) {
                    methodDescriptorProto.j = this.g;
                    i2 |= 16;
                }
                if ((i & 32) != 0) {
                    methodDescriptorProto.k = this.h;
                    i2 |= 32;
                }
                methodDescriptorProto.e = i2;
                i();
                return methodDescriptorProto;
            }

            public final Builder a(MethodDescriptorProto methodDescriptorProto) {
                MethodOptions methodOptions;
                if (methodDescriptorProto == MethodDescriptorProto.t()) {
                    return this;
                }
                if (methodDescriptorProto.e()) {
                    this.f6664a |= 1;
                    this.b = methodDescriptorProto.f;
                    j();
                }
                if (methodDescriptorProto.g()) {
                    this.f6664a |= 2;
                    this.c = methodDescriptorProto.g;
                    j();
                }
                if (methodDescriptorProto.i()) {
                    this.f6664a |= 4;
                    this.d = methodDescriptorProto.h;
                    j();
                }
                if (methodDescriptorProto.k()) {
                    MethodOptions l = methodDescriptorProto.l();
                    SingleFieldBuilderV3<MethodOptions, MethodOptions.Builder, MethodOptionsOrBuilder> singleFieldBuilderV3 = this.f;
                    if (singleFieldBuilderV3 == null) {
                        if ((this.f6664a & 8) != 0 && (methodOptions = this.e) != null && methodOptions != MethodOptions.j()) {
                            l = MethodOptions.a(this.e).a(l).g();
                        }
                        this.e = l;
                        j();
                    } else {
                        singleFieldBuilderV3.a(l);
                    }
                    this.f6664a |= 8;
                }
                if (methodDescriptorProto.m()) {
                    boolean n = methodDescriptorProto.n();
                    this.f6664a |= 16;
                    this.g = n;
                    j();
                }
                if (methodDescriptorProto.o()) {
                    boolean s = methodDescriptorProto.s();
                    this.f6664a |= 32;
                    this.h = s;
                    j();
                }
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return !((this.f6664a & 8) != 0) || m().isInitialized();
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.MethodDescriptorProto.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$MethodDescriptorProto> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.MethodDescriptorProto.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$MethodDescriptorProto r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.MethodDescriptorProto) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$MethodDescriptorProto r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.MethodDescriptorProto) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.MethodDescriptorProto.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$MethodDescriptorProto$Builder");
            }

            private MethodOptions m() {
                SingleFieldBuilderV3<MethodOptions, MethodOptions.Builder, MethodOptionsOrBuilder> singleFieldBuilderV3 = this.f;
                if (singleFieldBuilderV3 == null) {
                    MethodOptions methodOptions = this.e;
                    return methodOptions == null ? MethodOptions.j() : methodOptions;
                }
                return singleFieldBuilderV3.b();
            }
        }

        public static MethodDescriptorProto t() {
            return m;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<MethodDescriptorProto> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class FileOptions extends GeneratedMessageV3.ExtendableMessage<FileOptions> implements FileOptionsOrBuilder {
        private static final FileOptions B = new FileOptions();

        @Deprecated
        public static final Parser<FileOptions> b = new AbstractParser<FileOptions>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.FileOptions.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new FileOptions(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };
        private byte A;
        private int e;
        private volatile Object f;
        private volatile Object g;
        private boolean h;
        private boolean i;
        private boolean j;
        private int k;
        private volatile Object l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        private boolean q;
        private boolean r;
        private volatile Object s;
        private volatile Object t;
        private volatile Object u;
        private volatile Object v;
        private volatile Object w;
        private volatile Object x;
        private volatile Object y;
        private List<UninterpretedOption> z;

        /* synthetic */ FileOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ FileOptions(GeneratedMessageV3.ExtendableBuilder extendableBuilder, byte b2) {
            this(extendableBuilder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return B;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return ae();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == B ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return ae();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return B;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == B ? new Builder(b2) : new Builder(b2).a(this);
        }

        private FileOptions(GeneratedMessageV3.ExtendableBuilder<FileOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.A = (byte) -1;
        }

        private FileOptions() {
            this.A = (byte) -1;
            this.f = "";
            this.g = "";
            this.k = 1;
            this.l = "";
            this.s = "";
            this.t = "";
            this.u = "";
            this.v = "";
            this.w = "";
            this.x = "";
            this.y = "";
            this.z = Collections.emptyList();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new FileOptions();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0014. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v2, types: [boolean] */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FileOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            int i = 0;
            while (true) {
                int i2 = Constants.MB;
                ?? r4 = 1048576;
                if (z) {
                    return;
                }
                try {
                    try {
                        try {
                            int a3 = codedInputStream.a();
                            switch (a3) {
                                case 0:
                                    z = true;
                                case 10:
                                    ByteString l = codedInputStream.l();
                                    this.e |= 1;
                                    this.f = l;
                                case 66:
                                    ByteString l2 = codedInputStream.l();
                                    this.e |= 2;
                                    this.g = l2;
                                case 72:
                                    int n = codedInputStream.n();
                                    if (OptimizeMode.a(n) == null) {
                                        a2.a(9, n);
                                    } else {
                                        this.e |= 32;
                                        this.k = n;
                                    }
                                case 80:
                                    this.e |= 4;
                                    this.h = codedInputStream.i();
                                case 90:
                                    ByteString l3 = codedInputStream.l();
                                    this.e |= 64;
                                    this.l = l3;
                                case 128:
                                    this.e |= 128;
                                    this.m = codedInputStream.i();
                                case 136:
                                    this.e |= 256;
                                    this.n = codedInputStream.i();
                                case 144:
                                    this.e |= 512;
                                    this.o = codedInputStream.i();
                                case TbsListener.ErrorCode.STARTDOWNLOAD_1 /* 160 */:
                                    this.e |= 8;
                                    this.i = codedInputStream.i();
                                case 184:
                                    this.e |= ProgressEvent.PART_COMPLETED_EVENT_CODE;
                                    this.q = codedInputStream.i();
                                case TbsListener.ErrorCode.INCR_UPDATE_ERROR /* 216 */:
                                    this.e |= 16;
                                    this.j = codedInputStream.i();
                                case 248:
                                    this.e |= 4096;
                                    this.r = codedInputStream.i();
                                case 290:
                                    ByteString l4 = codedInputStream.l();
                                    this.e |= 8192;
                                    this.s = l4;
                                case 298:
                                    ByteString l5 = codedInputStream.l();
                                    this.e |= 16384;
                                    this.t = l5;
                                case 314:
                                    ByteString l6 = codedInputStream.l();
                                    this.e |= Connections.MAX_BYTES_DATA_SIZE;
                                    this.u = l6;
                                case 322:
                                    ByteString l7 = codedInputStream.l();
                                    this.e |= 65536;
                                    this.v = l7;
                                case 330:
                                    ByteString l8 = codedInputStream.l();
                                    this.e |= 131072;
                                    this.w = l8;
                                case 336:
                                    this.e |= 1024;
                                    this.p = codedInputStream.i();
                                case 354:
                                    ByteString l9 = codedInputStream.l();
                                    this.e |= 262144;
                                    this.x = l9;
                                case 362:
                                    ByteString l10 = codedInputStream.l();
                                    this.e |= 524288;
                                    this.y = l10;
                                case 7994:
                                    if ((i & Constants.MB) == 0) {
                                        this.z = new ArrayList();
                                        i |= Constants.MB;
                                    }
                                    this.z.add(codedInputStream.a(UninterpretedOption.b, extensionRegistryLite));
                                default:
                                    r4 = a(codedInputStream, a2, extensionRegistryLite, a3);
                                    if (r4 == 0) {
                                        z = true;
                                    }
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw e.a(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if ((i & r4) != 0) {
                        this.z = Collections.unmodifiableList(this.z);
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.B.a(FileOptions.class, Builder.class);
        }

        /* loaded from: classes3.dex */
        public enum OptimizeMode implements ProtocolMessageEnum {
            SPEED(1),
            CODE_SIZE(2),
            LITE_RUNTIME(3);

            private final int d;

            static {
                new Internal.EnumLiteMap<OptimizeMode>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.FileOptions.OptimizeMode.1
                    @Override // com.uqm.crashsight.protobuf.Internal.EnumLiteMap
                    public final /* synthetic */ OptimizeMode a(int i) {
                        return OptimizeMode.b(i);
                    }
                };
                values();
            }

            @Override // com.uqm.crashsight.protobuf.Internal.EnumLite
            public final int a() {
                return this.d;
            }

            @Deprecated
            public static OptimizeMode a(int i) {
                return b(i);
            }

            public static OptimizeMode b(int i) {
                switch (i) {
                    case 1:
                        return SPEED;
                    case 2:
                        return CODE_SIZE;
                    case 3:
                        return LITE_RUNTIME;
                    default:
                        return null;
                }
            }

            OptimizeMode(int i) {
                this.d = i;
            }
        }

        public final boolean e() {
            return (this.e & 1) != 0;
        }

        private String U() {
            Object obj = this.f;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.f = f;
            }
            return f;
        }

        public final boolean f() {
            return (this.e & 2) != 0;
        }

        private String V() {
            Object obj = this.g;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.g = f;
            }
            return f;
        }

        public final boolean g() {
            return (this.e & 4) != 0;
        }

        public final boolean h() {
            return this.h;
        }

        @Deprecated
        public final boolean i() {
            return (this.e & 8) != 0;
        }

        @Deprecated
        public final boolean j() {
            return this.i;
        }

        public final boolean k() {
            return (this.e & 16) != 0;
        }

        public final boolean l() {
            return this.j;
        }

        public final boolean m() {
            return (this.e & 32) != 0;
        }

        public final OptimizeMode n() {
            OptimizeMode a2 = OptimizeMode.a(this.k);
            return a2 == null ? OptimizeMode.SPEED : a2;
        }

        public final boolean o() {
            return (this.e & 64) != 0;
        }

        private String W() {
            Object obj = this.l;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.l = f;
            }
            return f;
        }

        public final boolean s() {
            return (this.e & 128) != 0;
        }

        public final boolean t() {
            return this.m;
        }

        public final boolean u() {
            return (this.e & 256) != 0;
        }

        public final boolean v() {
            return this.n;
        }

        public final boolean w() {
            return (this.e & 512) != 0;
        }

        public final boolean x() {
            return this.o;
        }

        public final boolean y() {
            return (this.e & 1024) != 0;
        }

        public final boolean z() {
            return this.p;
        }

        public final boolean A() {
            return (this.e & ProgressEvent.PART_COMPLETED_EVENT_CODE) != 0;
        }

        public final boolean B() {
            return this.q;
        }

        public final boolean C() {
            return (this.e & 4096) != 0;
        }

        public final boolean D() {
            return this.r;
        }

        public final boolean E() {
            return (this.e & 8192) != 0;
        }

        private String X() {
            Object obj = this.s;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.s = f;
            }
            return f;
        }

        public final boolean F() {
            return (this.e & 16384) != 0;
        }

        private String Y() {
            Object obj = this.t;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.t = f;
            }
            return f;
        }

        public final boolean G() {
            return (this.e & Connections.MAX_BYTES_DATA_SIZE) != 0;
        }

        private String Z() {
            Object obj = this.u;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.u = f;
            }
            return f;
        }

        public final boolean H() {
            return (this.e & 65536) != 0;
        }

        private String aa() {
            Object obj = this.v;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.v = f;
            }
            return f;
        }

        public final boolean I() {
            return (this.e & 131072) != 0;
        }

        private String ab() {
            Object obj = this.w;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.w = f;
            }
            return f;
        }

        public final boolean J() {
            return (this.e & 262144) != 0;
        }

        private String ac() {
            Object obj = this.x;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.x = f;
            }
            return f;
        }

        public final boolean K() {
            return (this.e & 524288) != 0;
        }

        private String ad() {
            Object obj = this.y;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.y = f;
            }
            return f;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableMessage, com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.A;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.z.size(); i++) {
                if (!this.z.get(i).isInitialized()) {
                    this.A = (byte) 0;
                    return false;
                }
            }
            if (!R()) {
                this.A = (byte) 0;
                return false;
            }
            this.A = (byte) 1;
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage.ExtensionWriter extensionWriter = new GeneratedMessageV3.ExtendableMessage.ExtensionWriter(this, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                if (obj instanceof String) {
                    codedOutputStream.a(1, (String) obj);
                } else {
                    codedOutputStream.a(1, (ByteString) obj);
                }
            }
            if ((this.e & 2) != 0) {
                Object obj2 = this.g;
                if (obj2 instanceof String) {
                    codedOutputStream.a(8, (String) obj2);
                } else {
                    codedOutputStream.a(8, (ByteString) obj2);
                }
            }
            if ((this.e & 32) != 0) {
                codedOutputStream.g(9, this.k);
            }
            if ((this.e & 4) != 0) {
                codedOutputStream.a(10, this.h);
            }
            if ((this.e & 64) != 0) {
                Object obj3 = this.l;
                if (obj3 instanceof String) {
                    codedOutputStream.a(11, (String) obj3);
                } else {
                    codedOutputStream.a(11, (ByteString) obj3);
                }
            }
            if ((this.e & 128) != 0) {
                codedOutputStream.a(16, this.m);
            }
            if ((this.e & 256) != 0) {
                codedOutputStream.a(17, this.n);
            }
            if ((this.e & 512) != 0) {
                codedOutputStream.a(18, this.o);
            }
            if ((this.e & 8) != 0) {
                codedOutputStream.a(20, this.i);
            }
            if ((this.e & ProgressEvent.PART_COMPLETED_EVENT_CODE) != 0) {
                codedOutputStream.a(23, this.q);
            }
            if ((this.e & 16) != 0) {
                codedOutputStream.a(27, this.j);
            }
            if ((this.e & 4096) != 0) {
                codedOutputStream.a(31, this.r);
            }
            if ((this.e & 8192) != 0) {
                Object obj4 = this.s;
                if (obj4 instanceof String) {
                    codedOutputStream.a(36, (String) obj4);
                } else {
                    codedOutputStream.a(36, (ByteString) obj4);
                }
            }
            if ((this.e & 16384) != 0) {
                Object obj5 = this.t;
                if (obj5 instanceof String) {
                    codedOutputStream.a(37, (String) obj5);
                } else {
                    codedOutputStream.a(37, (ByteString) obj5);
                }
            }
            if ((this.e & Connections.MAX_BYTES_DATA_SIZE) != 0) {
                Object obj6 = this.u;
                if (obj6 instanceof String) {
                    codedOutputStream.a(39, (String) obj6);
                } else {
                    codedOutputStream.a(39, (ByteString) obj6);
                }
            }
            if ((this.e & 65536) != 0) {
                Object obj7 = this.v;
                if (obj7 instanceof String) {
                    codedOutputStream.a(40, (String) obj7);
                } else {
                    codedOutputStream.a(40, (ByteString) obj7);
                }
            }
            if ((this.e & 131072) != 0) {
                Object obj8 = this.w;
                if (obj8 instanceof String) {
                    codedOutputStream.a(41, (String) obj8);
                } else {
                    codedOutputStream.a(41, (ByteString) obj8);
                }
            }
            if ((this.e & 1024) != 0) {
                codedOutputStream.a(42, this.p);
            }
            if ((this.e & 262144) != 0) {
                Object obj9 = this.x;
                if (obj9 instanceof String) {
                    codedOutputStream.a(44, (String) obj9);
                } else {
                    codedOutputStream.a(44, (ByteString) obj9);
                }
            }
            if ((this.e & 524288) != 0) {
                Object obj10 = this.y;
                if (obj10 instanceof String) {
                    codedOutputStream.a(45, (String) obj10);
                } else {
                    codedOutputStream.a(45, (ByteString) obj10);
                }
            }
            for (int i = 0; i < this.z.size(); i++) {
                codedOutputStream.a(999, this.z.get(i));
            }
            extensionWriter.a(DriveFile.MODE_WRITE_ONLY, codedOutputStream);
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i;
            int i2 = this.f6632a;
            if (i2 != -1) {
                return i2;
            }
            if ((this.e & 1) != 0) {
                Object obj = this.f;
                i = (obj instanceof String ? CodedOutputStream.b(1, (String) obj) : CodedOutputStream.c(1, (ByteString) obj)) + 0;
            } else {
                i = 0;
            }
            if ((this.e & 2) != 0) {
                Object obj2 = this.g;
                i += obj2 instanceof String ? CodedOutputStream.b(8, (String) obj2) : CodedOutputStream.c(8, (ByteString) obj2);
            }
            if ((this.e & 32) != 0) {
                i += CodedOutputStream.m(9, this.k);
            }
            if ((this.e & 4) != 0) {
                i += CodedOutputStream.b(10, this.h);
            }
            if ((this.e & 64) != 0) {
                Object obj3 = this.l;
                i += obj3 instanceof String ? CodedOutputStream.b(11, (String) obj3) : CodedOutputStream.c(11, (ByteString) obj3);
            }
            if ((this.e & 128) != 0) {
                i += CodedOutputStream.b(16, this.m);
            }
            if ((this.e & 256) != 0) {
                i += CodedOutputStream.b(17, this.n);
            }
            if ((this.e & 512) != 0) {
                i += CodedOutputStream.b(18, this.o);
            }
            if ((this.e & 8) != 0) {
                i += CodedOutputStream.b(20, this.i);
            }
            if ((this.e & ProgressEvent.PART_COMPLETED_EVENT_CODE) != 0) {
                i += CodedOutputStream.b(23, this.q);
            }
            if ((this.e & 16) != 0) {
                i += CodedOutputStream.b(27, this.j);
            }
            if ((this.e & 4096) != 0) {
                i += CodedOutputStream.b(31, this.r);
            }
            if ((this.e & 8192) != 0) {
                Object obj4 = this.s;
                i += obj4 instanceof String ? CodedOutputStream.b(36, (String) obj4) : CodedOutputStream.c(36, (ByteString) obj4);
            }
            if ((this.e & 16384) != 0) {
                Object obj5 = this.t;
                i += obj5 instanceof String ? CodedOutputStream.b(37, (String) obj5) : CodedOutputStream.c(37, (ByteString) obj5);
            }
            if ((this.e & Connections.MAX_BYTES_DATA_SIZE) != 0) {
                Object obj6 = this.u;
                i += obj6 instanceof String ? CodedOutputStream.b(39, (String) obj6) : CodedOutputStream.c(39, (ByteString) obj6);
            }
            if ((this.e & 65536) != 0) {
                Object obj7 = this.v;
                i += obj7 instanceof String ? CodedOutputStream.b(40, (String) obj7) : CodedOutputStream.c(40, (ByteString) obj7);
            }
            if ((this.e & 131072) != 0) {
                Object obj8 = this.w;
                i += obj8 instanceof String ? CodedOutputStream.b(41, (String) obj8) : CodedOutputStream.c(41, (ByteString) obj8);
            }
            if ((this.e & 1024) != 0) {
                i += CodedOutputStream.b(42, this.p);
            }
            if ((this.e & 262144) != 0) {
                Object obj9 = this.x;
                i += obj9 instanceof String ? CodedOutputStream.b(44, (String) obj9) : CodedOutputStream.c(44, (ByteString) obj9);
            }
            if ((this.e & 524288) != 0) {
                Object obj10 = this.y;
                i += obj10 instanceof String ? CodedOutputStream.b(45, (String) obj10) : CodedOutputStream.c(45, (ByteString) obj10);
            }
            for (int i3 = 0; i3 < this.z.size(); i3++) {
                i += CodedOutputStream.c(999, this.z.get(i3));
            }
            int S = i + S() + this.d.getSerializedSize();
            this.f6632a = S;
            return S;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FileOptions)) {
                return super.equals(obj);
            }
            FileOptions fileOptions = (FileOptions) obj;
            if (((this.e & 1) != 0) != ((fileOptions.e & 1) != 0)) {
                return false;
            }
            if (((this.e & 1) != 0) && !U().equals(fileOptions.U())) {
                return false;
            }
            if (((this.e & 2) != 0) != ((fileOptions.e & 2) != 0)) {
                return false;
            }
            if (((this.e & 2) != 0) && !V().equals(fileOptions.V())) {
                return false;
            }
            if (((this.e & 4) != 0) != ((fileOptions.e & 4) != 0)) {
                return false;
            }
            if (((this.e & 4) != 0) && this.h != fileOptions.h) {
                return false;
            }
            if (((this.e & 8) != 0) != ((fileOptions.e & 8) != 0)) {
                return false;
            }
            if (((this.e & 8) != 0) && this.i != fileOptions.i) {
                return false;
            }
            if (((this.e & 16) != 0) != ((fileOptions.e & 16) != 0)) {
                return false;
            }
            if (((this.e & 16) != 0) && this.j != fileOptions.j) {
                return false;
            }
            if (((this.e & 32) != 0) != ((fileOptions.e & 32) != 0)) {
                return false;
            }
            if (((this.e & 32) != 0) && this.k != fileOptions.k) {
                return false;
            }
            if (((this.e & 64) != 0) != ((fileOptions.e & 64) != 0)) {
                return false;
            }
            if (((this.e & 64) != 0) && !W().equals(fileOptions.W())) {
                return false;
            }
            if (((this.e & 128) != 0) != ((fileOptions.e & 128) != 0)) {
                return false;
            }
            if (((this.e & 128) != 0) && this.m != fileOptions.m) {
                return false;
            }
            if (((this.e & 256) != 0) != ((fileOptions.e & 256) != 0)) {
                return false;
            }
            if (((this.e & 256) != 0) && this.n != fileOptions.n) {
                return false;
            }
            if (((this.e & 512) != 0) != ((fileOptions.e & 512) != 0)) {
                return false;
            }
            if (((this.e & 512) != 0) && this.o != fileOptions.o) {
                return false;
            }
            if (((this.e & 1024) != 0) != ((fileOptions.e & 1024) != 0)) {
                return false;
            }
            if (((this.e & 1024) != 0) && this.p != fileOptions.p) {
                return false;
            }
            if (((this.e & ProgressEvent.PART_COMPLETED_EVENT_CODE) != 0) != ((fileOptions.e & ProgressEvent.PART_COMPLETED_EVENT_CODE) != 0)) {
                return false;
            }
            if (((this.e & ProgressEvent.PART_COMPLETED_EVENT_CODE) != 0) && this.q != fileOptions.q) {
                return false;
            }
            if (((this.e & 4096) != 0) != ((fileOptions.e & 4096) != 0)) {
                return false;
            }
            if (((this.e & 4096) != 0) && this.r != fileOptions.r) {
                return false;
            }
            if (((this.e & 8192) != 0) != ((fileOptions.e & 8192) != 0)) {
                return false;
            }
            if (((this.e & 8192) != 0) && !X().equals(fileOptions.X())) {
                return false;
            }
            if (((this.e & 16384) != 0) != ((fileOptions.e & 16384) != 0)) {
                return false;
            }
            if (((this.e & 16384) != 0) && !Y().equals(fileOptions.Y())) {
                return false;
            }
            if (((this.e & Connections.MAX_BYTES_DATA_SIZE) != 0) != ((fileOptions.e & Connections.MAX_BYTES_DATA_SIZE) != 0)) {
                return false;
            }
            if (((this.e & Connections.MAX_BYTES_DATA_SIZE) != 0) && !Z().equals(fileOptions.Z())) {
                return false;
            }
            if (((this.e & 65536) != 0) != ((fileOptions.e & 65536) != 0)) {
                return false;
            }
            if (((this.e & 65536) != 0) && !aa().equals(fileOptions.aa())) {
                return false;
            }
            if (((this.e & 131072) != 0) != ((fileOptions.e & 131072) != 0)) {
                return false;
            }
            if (((this.e & 131072) != 0) && !ab().equals(fileOptions.ab())) {
                return false;
            }
            if (((this.e & 262144) != 0) != ((fileOptions.e & 262144) != 0)) {
                return false;
            }
            if (((this.e & 262144) != 0) && !ac().equals(fileOptions.ac())) {
                return false;
            }
            if (((this.e & 524288) != 0) != ((fileOptions.e & 524288) != 0)) {
                return false;
            }
            return (!((this.e & 524288) != 0) || ad().equals(fileOptions.ad())) && this.z.equals(fileOptions.z) && this.d.equals(fileOptions.d) && T().equals(fileOptions.T());
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.A.hashCode() + 779;
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + U().hashCode();
                }
                if ((this.e & 2) != 0) {
                    hashCode = (((hashCode * 37) + 8) * 53) + V().hashCode();
                }
                if ((this.e & 4) != 0) {
                    hashCode = (((hashCode * 37) + 10) * 53) + Internal.a(this.h);
                }
                if ((this.e & 8) != 0) {
                    hashCode = (((hashCode * 37) + 20) * 53) + Internal.a(this.i);
                }
                if ((this.e & 16) != 0) {
                    hashCode = (((hashCode * 37) + 27) * 53) + Internal.a(this.j);
                }
                if ((this.e & 32) != 0) {
                    hashCode = (((hashCode * 37) + 9) * 53) + this.k;
                }
                if ((this.e & 64) != 0) {
                    hashCode = (((hashCode * 37) + 11) * 53) + W().hashCode();
                }
                if ((this.e & 128) != 0) {
                    hashCode = (((hashCode * 37) + 16) * 53) + Internal.a(this.m);
                }
                if ((this.e & 256) != 0) {
                    hashCode = (((hashCode * 37) + 17) * 53) + Internal.a(this.n);
                }
                if ((this.e & 512) != 0) {
                    hashCode = (((hashCode * 37) + 18) * 53) + Internal.a(this.o);
                }
                if ((this.e & 1024) != 0) {
                    hashCode = (((hashCode * 37) + 42) * 53) + Internal.a(this.p);
                }
                if ((this.e & ProgressEvent.PART_COMPLETED_EVENT_CODE) != 0) {
                    hashCode = (((hashCode * 37) + 23) * 53) + Internal.a(this.q);
                }
                if ((this.e & 4096) != 0) {
                    hashCode = (((hashCode * 37) + 31) * 53) + Internal.a(this.r);
                }
                if ((this.e & 8192) != 0) {
                    hashCode = (((hashCode * 37) + 36) * 53) + X().hashCode();
                }
                if ((this.e & 16384) != 0) {
                    hashCode = (((hashCode * 37) + 37) * 53) + Y().hashCode();
                }
                if ((this.e & Connections.MAX_BYTES_DATA_SIZE) != 0) {
                    hashCode = (((hashCode * 37) + 39) * 53) + Z().hashCode();
                }
                if ((this.e & 65536) != 0) {
                    hashCode = (((hashCode * 37) + 40) * 53) + aa().hashCode();
                }
                if ((this.e & 131072) != 0) {
                    hashCode = (((hashCode * 37) + 41) * 53) + ab().hashCode();
                }
                if ((this.e & 262144) != 0) {
                    hashCode = (((hashCode * 37) + 44) * 53) + ac().hashCode();
                }
                if ((this.e & 524288) != 0) {
                    hashCode = (((hashCode * 37) + 45) * 53) + ad().hashCode();
                }
                if (this.z.size() > 0) {
                    hashCode = (((hashCode * 37) + 999) * 53) + this.z.hashCode();
                }
                int a2 = (a(hashCode, T()) * 29) + this.d.hashCode();
                this.memoizedHashCode = a2;
                return a2;
            }
            return this.memoizedHashCode;
        }

        private static Builder ae() {
            FileOptions fileOptions = B;
            byte b2 = 0;
            return fileOptions == fileOptions ? new Builder(b2) : new Builder(b2).a(fileOptions);
        }

        public static Builder a(FileOptions fileOptions) {
            FileOptions fileOptions2 = B;
            byte b2 = 0;
            return (fileOptions2 == fileOptions2 ? new Builder(b2) : new Builder(b2).a(fileOptions2)).a(fileOptions);
        }

        public final Builder L() {
            byte b2 = 0;
            return this == B ? new Builder(b2) : new Builder(b2).a(this);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.ExtendableBuilder<FileOptions, Builder> implements FileOptionsOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6659a;
            private Object b;
            private Object c;
            private boolean d;
            private boolean e;
            private boolean f;
            private int g;
            private Object h;
            private boolean i;
            private boolean j;
            private boolean k;
            private boolean l;
            private boolean m;
            private boolean n;
            private Object o;
            private Object p;
            private Object q;
            private Object r;
            private Object s;
            private Object t;
            private Object u;
            private List<UninterpretedOption> v;
            private RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> w;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof FileOptions) {
                    return a((FileOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* synthetic */ GeneratedMessageV3.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* synthetic */ GeneratedMessageV3.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                FileOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof FileOptions) {
                    return a((FileOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: e */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return FileOptions.M();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                FileOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return FileOptions.M();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.B.a(FileOptions.class, Builder.class);
            }

            private Builder() {
                this.b = "";
                this.c = "";
                this.g = 1;
                this.h = "";
                this.o = "";
                this.p = "";
                this.q = "";
                this.r = "";
                this.s = "";
                this.t = "";
                this.u = "";
                this.v = Collections.emptyList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = "";
                this.c = "";
                this.g = 1;
                this.h = "";
                this.o = "";
                this.p = "";
                this.q = "";
                this.r = "";
                this.s = "";
                this.t = "";
                this.u = "";
                this.v = Collections.emptyList();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.A;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final FileOptions g() {
                FileOptions fileOptions = new FileOptions((GeneratedMessageV3.ExtendableBuilder) this, (byte) (0 == true ? 1 : 0));
                int i = this.f6659a;
                int i2 = (i & 1) != 0 ? 1 : 0;
                fileOptions.f = this.b;
                if ((i & 2) != 0) {
                    i2 |= 2;
                }
                fileOptions.g = this.c;
                if ((i & 4) != 0) {
                    fileOptions.h = this.d;
                    i2 |= 4;
                }
                if ((i & 8) != 0) {
                    fileOptions.i = this.e;
                    i2 |= 8;
                }
                if ((i & 16) != 0) {
                    fileOptions.j = this.f;
                    i2 |= 16;
                }
                if ((i & 32) != 0) {
                    i2 |= 32;
                }
                fileOptions.k = this.g;
                if ((i & 64) != 0) {
                    i2 |= 64;
                }
                fileOptions.l = this.h;
                if ((i & 128) != 0) {
                    fileOptions.m = this.i;
                    i2 |= 128;
                }
                if ((i & 256) != 0) {
                    fileOptions.n = this.j;
                    i2 |= 256;
                }
                if ((i & 512) != 0) {
                    fileOptions.o = this.k;
                    i2 |= 512;
                }
                if ((i & 1024) != 0) {
                    fileOptions.p = this.l;
                    i2 |= 1024;
                }
                if ((i & ProgressEvent.PART_COMPLETED_EVENT_CODE) != 0) {
                    fileOptions.q = this.m;
                    i2 |= ProgressEvent.PART_COMPLETED_EVENT_CODE;
                }
                if ((i & 4096) != 0) {
                    fileOptions.r = this.n;
                    i2 |= 4096;
                }
                if ((i & 8192) != 0) {
                    i2 |= 8192;
                }
                fileOptions.s = this.o;
                if ((i & 16384) != 0) {
                    i2 |= 16384;
                }
                fileOptions.t = this.p;
                if ((32768 & i) != 0) {
                    i2 |= Connections.MAX_BYTES_DATA_SIZE;
                }
                fileOptions.u = this.q;
                if ((65536 & i) != 0) {
                    i2 |= 65536;
                }
                fileOptions.v = this.r;
                if ((131072 & i) != 0) {
                    i2 |= 131072;
                }
                fileOptions.w = this.s;
                if ((262144 & i) != 0) {
                    i2 |= 262144;
                }
                fileOptions.x = this.t;
                if ((i & 524288) != 0) {
                    i2 |= 524288;
                }
                fileOptions.y = this.u;
                RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.w;
                if (repeatedFieldBuilderV3 != null) {
                    fileOptions.z = repeatedFieldBuilderV3.e();
                } else {
                    if ((this.f6659a & Constants.MB) != 0) {
                        this.v = Collections.unmodifiableList(this.v);
                        this.f6659a &= -1048577;
                    }
                    fileOptions.z = this.v;
                }
                fileOptions.e = i2;
                i();
                return fileOptions;
            }

            public final Builder a(FileOptions fileOptions) {
                if (fileOptions == FileOptions.M()) {
                    return this;
                }
                if (fileOptions.e()) {
                    this.f6659a |= 1;
                    this.b = fileOptions.f;
                    j();
                }
                if (fileOptions.f()) {
                    this.f6659a |= 2;
                    this.c = fileOptions.g;
                    j();
                }
                if (fileOptions.g()) {
                    boolean h = fileOptions.h();
                    this.f6659a |= 4;
                    this.d = h;
                    j();
                }
                if (fileOptions.i()) {
                    boolean j = fileOptions.j();
                    this.f6659a |= 8;
                    this.e = j;
                    j();
                }
                if (fileOptions.k()) {
                    boolean l = fileOptions.l();
                    this.f6659a |= 16;
                    this.f = l;
                    j();
                }
                if (fileOptions.m()) {
                    OptimizeMode n = fileOptions.n();
                    if (n == null) {
                        throw new NullPointerException();
                    }
                    this.f6659a |= 32;
                    this.g = n.a();
                    j();
                }
                if (fileOptions.o()) {
                    this.f6659a |= 64;
                    this.h = fileOptions.l;
                    j();
                }
                if (fileOptions.s()) {
                    boolean t = fileOptions.t();
                    this.f6659a |= 128;
                    this.i = t;
                    j();
                }
                if (fileOptions.u()) {
                    boolean v = fileOptions.v();
                    this.f6659a |= 256;
                    this.j = v;
                    j();
                }
                if (fileOptions.w()) {
                    boolean x = fileOptions.x();
                    this.f6659a |= 512;
                    this.k = x;
                    j();
                }
                if (fileOptions.y()) {
                    boolean z = fileOptions.z();
                    this.f6659a |= 1024;
                    this.l = z;
                    j();
                }
                if (fileOptions.A()) {
                    boolean B = fileOptions.B();
                    this.f6659a |= ProgressEvent.PART_COMPLETED_EVENT_CODE;
                    this.m = B;
                    j();
                }
                if (fileOptions.C()) {
                    boolean D = fileOptions.D();
                    this.f6659a |= 4096;
                    this.n = D;
                    j();
                }
                if (fileOptions.E()) {
                    this.f6659a |= 8192;
                    this.o = fileOptions.s;
                    j();
                }
                if (fileOptions.F()) {
                    this.f6659a |= 16384;
                    this.p = fileOptions.t;
                    j();
                }
                if (fileOptions.G()) {
                    this.f6659a |= Connections.MAX_BYTES_DATA_SIZE;
                    this.q = fileOptions.u;
                    j();
                }
                if (fileOptions.H()) {
                    this.f6659a |= 65536;
                    this.r = fileOptions.v;
                    j();
                }
                if (fileOptions.I()) {
                    this.f6659a |= 131072;
                    this.s = fileOptions.w;
                    j();
                }
                if (fileOptions.J()) {
                    this.f6659a |= 262144;
                    this.t = fileOptions.x;
                    j();
                }
                if (fileOptions.K()) {
                    this.f6659a |= 524288;
                    this.u = fileOptions.y;
                    j();
                }
                if (this.w == null) {
                    if (!fileOptions.z.isEmpty()) {
                        if (this.v.isEmpty()) {
                            this.v = fileOptions.z;
                            this.f6659a &= -1048577;
                        } else {
                            if ((this.f6659a & Constants.MB) == 0) {
                                this.v = new ArrayList(this.v);
                                this.f6659a |= Constants.MB;
                            }
                            this.v.addAll(fileOptions.z);
                        }
                        j();
                    }
                } else if (!fileOptions.z.isEmpty()) {
                    if (!this.w.d()) {
                        this.w.a(fileOptions.z);
                    } else {
                        this.w.b();
                        this.w = null;
                        this.v = fileOptions.z;
                        this.f6659a = (-1048577) & this.f6659a;
                        this.w = null;
                    }
                }
                a((GeneratedMessageV3.ExtendableMessage) fileOptions);
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int i = 0;
                while (true) {
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.w;
                    if (i >= (repeatedFieldBuilderV3 == null ? this.v.size() : repeatedFieldBuilderV3.c())) {
                        return m();
                    }
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV32 = this.w;
                    if (!(repeatedFieldBuilderV32 == null ? this.v.get(i) : repeatedFieldBuilderV32.a(i)).isInitialized()) {
                        return false;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.FileOptions.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$FileOptions> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.FileOptions.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$FileOptions r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.FileOptions) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$FileOptions r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.FileOptions) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.FileOptions.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$FileOptions$Builder");
            }
        }

        public static FileOptions M() {
            return B;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<FileOptions> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class MessageOptions extends GeneratedMessageV3.ExtendableMessage<MessageOptions> implements MessageOptionsOrBuilder {
        private int e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private List<UninterpretedOption> j;
        private byte k;
        private static final MessageOptions l = new MessageOptions();

        @Deprecated
        public static final Parser<MessageOptions> b = new AbstractParser<MessageOptions>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.MessageOptions.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MessageOptions(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* synthetic */ MessageOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ MessageOptions(GeneratedMessageV3.ExtendableBuilder extendableBuilder, byte b2) {
            this(extendableBuilder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return l;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return o();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == l ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return o();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return l;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == l ? new Builder(b2) : new Builder(b2).a(this);
        }

        private MessageOptions(GeneratedMessageV3.ExtendableBuilder<MessageOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.k = (byte) -1;
        }

        private MessageOptions() {
            this.k = (byte) -1;
            this.j = Collections.emptyList();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new MessageOptions();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MessageOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            int i = 0;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 8) {
                            this.e |= 1;
                            this.f = codedInputStream.i();
                        } else if (a3 == 16) {
                            this.e |= 2;
                            this.g = codedInputStream.i();
                        } else if (a3 == 24) {
                            this.e |= 4;
                            this.h = codedInputStream.i();
                        } else if (a3 == 56) {
                            this.e |= 8;
                            this.i = codedInputStream.i();
                        } else if (a3 == 7994) {
                            if ((i & 16) == 0) {
                                this.j = new ArrayList();
                                i |= 16;
                            }
                            this.j.add(codedInputStream.a(UninterpretedOption.b, extensionRegistryLite));
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if ((i & 16) != 0) {
                        this.j = Collections.unmodifiableList(this.j);
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.D.a(MessageOptions.class, Builder.class);
        }

        public final boolean e() {
            return (this.e & 1) != 0;
        }

        public final boolean f() {
            return this.f;
        }

        public final boolean g() {
            return (this.e & 2) != 0;
        }

        public final boolean h() {
            return this.g;
        }

        public final boolean i() {
            return (this.e & 4) != 0;
        }

        public final boolean j() {
            return this.h;
        }

        public final boolean k() {
            return (this.e & 8) != 0;
        }

        public final boolean l() {
            return this.i;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableMessage, com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.k;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.j.size(); i++) {
                if (!this.j.get(i).isInitialized()) {
                    this.k = (byte) 0;
                    return false;
                }
            }
            if (!R()) {
                this.k = (byte) 0;
                return false;
            }
            this.k = (byte) 1;
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage.ExtensionWriter extensionWriter = new GeneratedMessageV3.ExtendableMessage.ExtensionWriter(this, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
            if ((this.e & 1) != 0) {
                codedOutputStream.a(1, this.f);
            }
            if ((this.e & 2) != 0) {
                codedOutputStream.a(2, this.g);
            }
            if ((this.e & 4) != 0) {
                codedOutputStream.a(3, this.h);
            }
            if ((this.e & 8) != 0) {
                codedOutputStream.a(7, this.i);
            }
            for (int i = 0; i < this.j.size(); i++) {
                codedOutputStream.a(999, this.j.get(i));
            }
            extensionWriter.a(DriveFile.MODE_WRITE_ONLY, codedOutputStream);
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.f6632a;
            if (i != -1) {
                return i;
            }
            int b2 = (this.e & 1) != 0 ? CodedOutputStream.b(1, this.f) + 0 : 0;
            if ((this.e & 2) != 0) {
                b2 += CodedOutputStream.b(2, this.g);
            }
            if ((this.e & 4) != 0) {
                b2 += CodedOutputStream.b(3, this.h);
            }
            if ((this.e & 8) != 0) {
                b2 += CodedOutputStream.b(7, this.i);
            }
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                b2 += CodedOutputStream.c(999, this.j.get(i2));
            }
            int S = b2 + S() + this.d.getSerializedSize();
            this.f6632a = S;
            return S;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MessageOptions)) {
                return super.equals(obj);
            }
            MessageOptions messageOptions = (MessageOptions) obj;
            if (((this.e & 1) != 0) != ((messageOptions.e & 1) != 0)) {
                return false;
            }
            if (((this.e & 1) != 0) && this.f != messageOptions.f) {
                return false;
            }
            if (((this.e & 2) != 0) != ((messageOptions.e & 2) != 0)) {
                return false;
            }
            if (((this.e & 2) != 0) && this.g != messageOptions.g) {
                return false;
            }
            if (((this.e & 4) != 0) != ((messageOptions.e & 4) != 0)) {
                return false;
            }
            if (((this.e & 4) != 0) && this.h != messageOptions.h) {
                return false;
            }
            if (((this.e & 8) != 0) != ((messageOptions.e & 8) != 0)) {
                return false;
            }
            return (!((this.e & 8) != 0) || this.i == messageOptions.i) && this.j.equals(messageOptions.j) && this.d.equals(messageOptions.d) && T().equals(messageOptions.T());
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.C.hashCode() + 779;
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + Internal.a(this.f);
                }
                if ((this.e & 2) != 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + Internal.a(this.g);
                }
                if ((this.e & 4) != 0) {
                    hashCode = (((hashCode * 37) + 3) * 53) + Internal.a(this.h);
                }
                if ((this.e & 8) != 0) {
                    hashCode = (((hashCode * 37) + 7) * 53) + Internal.a(this.i);
                }
                if (this.j.size() > 0) {
                    hashCode = (((hashCode * 37) + 999) * 53) + this.j.hashCode();
                }
                int a2 = (a(hashCode, T()) * 29) + this.d.hashCode();
                this.memoizedHashCode = a2;
                return a2;
            }
            return this.memoizedHashCode;
        }

        private static Builder o() {
            MessageOptions messageOptions = l;
            byte b2 = 0;
            return messageOptions == messageOptions ? new Builder(b2) : new Builder(b2).a(messageOptions);
        }

        public static Builder a(MessageOptions messageOptions) {
            MessageOptions messageOptions2 = l;
            byte b2 = 0;
            return (messageOptions2 == messageOptions2 ? new Builder(b2) : new Builder(b2).a(messageOptions2)).a(messageOptions);
        }

        public final Builder m() {
            byte b2 = 0;
            return this == l ? new Builder(b2) : new Builder(b2).a(this);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.ExtendableBuilder<MessageOptions, Builder> implements MessageOptionsOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6663a;
            private boolean b;
            private boolean c;
            private boolean d;
            private boolean e;
            private List<UninterpretedOption> f;
            private RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> g;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof MessageOptions) {
                    return a((MessageOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* synthetic */ GeneratedMessageV3.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* synthetic */ GeneratedMessageV3.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                MessageOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof MessageOptions) {
                    return a((MessageOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: e */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return MessageOptions.n();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                MessageOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return MessageOptions.n();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.D.a(MessageOptions.class, Builder.class);
            }

            private Builder() {
                this.f = Collections.emptyList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.f = Collections.emptyList();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.C;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final MessageOptions g() {
                int i = 0;
                MessageOptions messageOptions = new MessageOptions((GeneratedMessageV3.ExtendableBuilder) this, (byte) (0 == true ? 1 : 0));
                int i2 = this.f6663a;
                if ((i2 & 1) != 0) {
                    messageOptions.f = this.b;
                    i = 1;
                }
                if ((i2 & 2) != 0) {
                    messageOptions.g = this.c;
                    i |= 2;
                }
                if ((i2 & 4) != 0) {
                    messageOptions.h = this.d;
                    i |= 4;
                }
                if ((i2 & 8) != 0) {
                    messageOptions.i = this.e;
                    i |= 8;
                }
                RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.g;
                if (repeatedFieldBuilderV3 != null) {
                    messageOptions.j = repeatedFieldBuilderV3.e();
                } else {
                    if ((this.f6663a & 16) != 0) {
                        this.f = Collections.unmodifiableList(this.f);
                        this.f6663a &= -17;
                    }
                    messageOptions.j = this.f;
                }
                messageOptions.e = i;
                i();
                return messageOptions;
            }

            public final Builder a(MessageOptions messageOptions) {
                if (messageOptions == MessageOptions.n()) {
                    return this;
                }
                if (messageOptions.e()) {
                    boolean f = messageOptions.f();
                    this.f6663a |= 1;
                    this.b = f;
                    j();
                }
                if (messageOptions.g()) {
                    boolean h = messageOptions.h();
                    this.f6663a |= 2;
                    this.c = h;
                    j();
                }
                if (messageOptions.i()) {
                    boolean j = messageOptions.j();
                    this.f6663a |= 4;
                    this.d = j;
                    j();
                }
                if (messageOptions.k()) {
                    boolean l = messageOptions.l();
                    this.f6663a |= 8;
                    this.e = l;
                    j();
                }
                if (this.g == null) {
                    if (!messageOptions.j.isEmpty()) {
                        if (this.f.isEmpty()) {
                            this.f = messageOptions.j;
                            this.f6663a &= -17;
                        } else {
                            if ((this.f6663a & 16) == 0) {
                                this.f = new ArrayList(this.f);
                                this.f6663a |= 16;
                            }
                            this.f.addAll(messageOptions.j);
                        }
                        j();
                    }
                } else if (!messageOptions.j.isEmpty()) {
                    if (!this.g.d()) {
                        this.g.a(messageOptions.j);
                    } else {
                        this.g.b();
                        this.g = null;
                        this.f = messageOptions.j;
                        this.f6663a &= -17;
                        this.g = null;
                    }
                }
                a((GeneratedMessageV3.ExtendableMessage) messageOptions);
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int i = 0;
                while (true) {
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.g;
                    if (i >= (repeatedFieldBuilderV3 == null ? this.f.size() : repeatedFieldBuilderV3.c())) {
                        return m();
                    }
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV32 = this.g;
                    if (!(repeatedFieldBuilderV32 == null ? this.f.get(i) : repeatedFieldBuilderV32.a(i)).isInitialized()) {
                        return false;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.MessageOptions.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$MessageOptions> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.MessageOptions.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$MessageOptions r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.MessageOptions) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$MessageOptions r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.MessageOptions) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.MessageOptions.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$MessageOptions$Builder");
            }
        }

        public static MessageOptions n() {
            return l;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<MessageOptions> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class FieldOptions extends GeneratedMessageV3.ExtendableMessage<FieldOptions> implements FieldOptionsOrBuilder {
        private int e;
        private int f;
        private boolean g;
        private int h;
        private boolean i;
        private boolean j;
        private boolean k;
        private List<UninterpretedOption> l;
        private byte m;
        private static final FieldOptions n = new FieldOptions();

        @Deprecated
        public static final Parser<FieldOptions> b = new AbstractParser<FieldOptions>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.FieldOptions.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new FieldOptions(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* synthetic */ FieldOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ FieldOptions(GeneratedMessageV3.ExtendableBuilder extendableBuilder, byte b2) {
            this(extendableBuilder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return n;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return v();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == n ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return v();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return n;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == n ? new Builder(b2) : new Builder(b2).a(this);
        }

        private FieldOptions(GeneratedMessageV3.ExtendableBuilder<FieldOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.m = (byte) -1;
        }

        private FieldOptions() {
            this.m = (byte) -1;
            this.f = 0;
            this.h = 0;
            this.l = Collections.emptyList();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new FieldOptions();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private FieldOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            int i = 0;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 8) {
                            int n2 = codedInputStream.n();
                            if (CType.a(n2) == null) {
                                a2.a(1, n2);
                            } else {
                                this.e |= 1;
                                this.f = n2;
                            }
                        } else if (a3 == 16) {
                            this.e |= 2;
                            this.g = codedInputStream.i();
                        } else if (a3 == 24) {
                            this.e |= 16;
                            this.j = codedInputStream.i();
                        } else if (a3 == 40) {
                            this.e |= 8;
                            this.i = codedInputStream.i();
                        } else if (a3 == 48) {
                            int n3 = codedInputStream.n();
                            if (JSType.a(n3) == null) {
                                a2.a(6, n3);
                            } else {
                                this.e |= 4;
                                this.h = n3;
                            }
                        } else if (a3 == 80) {
                            this.e |= 32;
                            this.k = codedInputStream.i();
                        } else if (a3 == 7994) {
                            if ((i & 64) == 0) {
                                this.l = new ArrayList();
                                i |= 64;
                            }
                            this.l.add(codedInputStream.a(UninterpretedOption.b, extensionRegistryLite));
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if ((i & 64) != 0) {
                        this.l = Collections.unmodifiableList(this.l);
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.F.a(FieldOptions.class, Builder.class);
        }

        /* loaded from: classes3.dex */
        public enum CType implements ProtocolMessageEnum {
            STRING(0),
            CORD(1),
            STRING_PIECE(2);

            private final int d;

            static {
                new Internal.EnumLiteMap<CType>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.FieldOptions.CType.1
                    @Override // com.uqm.crashsight.protobuf.Internal.EnumLiteMap
                    public final /* synthetic */ CType a(int i) {
                        return CType.b(i);
                    }
                };
                values();
            }

            @Override // com.uqm.crashsight.protobuf.Internal.EnumLite
            public final int a() {
                return this.d;
            }

            @Deprecated
            public static CType a(int i) {
                return b(i);
            }

            public static CType b(int i) {
                switch (i) {
                    case 0:
                        return STRING;
                    case 1:
                        return CORD;
                    case 2:
                        return STRING_PIECE;
                    default:
                        return null;
                }
            }

            CType(int i) {
                this.d = i;
            }
        }

        /* loaded from: classes3.dex */
        public enum JSType implements ProtocolMessageEnum {
            JS_NORMAL(0),
            JS_STRING(1),
            JS_NUMBER(2);

            private final int d;

            static {
                new Internal.EnumLiteMap<JSType>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.FieldOptions.JSType.1
                    @Override // com.uqm.crashsight.protobuf.Internal.EnumLiteMap
                    public final /* synthetic */ JSType a(int i) {
                        return JSType.b(i);
                    }
                };
                values();
            }

            @Override // com.uqm.crashsight.protobuf.Internal.EnumLite
            public final int a() {
                return this.d;
            }

            @Deprecated
            public static JSType a(int i) {
                return b(i);
            }

            public static JSType b(int i) {
                switch (i) {
                    case 0:
                        return JS_NORMAL;
                    case 1:
                        return JS_STRING;
                    case 2:
                        return JS_NUMBER;
                    default:
                        return null;
                }
            }

            JSType(int i) {
                this.d = i;
            }
        }

        public final boolean e() {
            return (this.e & 1) != 0;
        }

        public final CType f() {
            CType a2 = CType.a(this.f);
            return a2 == null ? CType.STRING : a2;
        }

        public final boolean g() {
            return (this.e & 2) != 0;
        }

        public final boolean h() {
            return this.g;
        }

        public final boolean i() {
            return (this.e & 4) != 0;
        }

        public final JSType j() {
            JSType a2 = JSType.a(this.h);
            return a2 == null ? JSType.JS_NORMAL : a2;
        }

        public final boolean k() {
            return (this.e & 8) != 0;
        }

        public final boolean l() {
            return this.i;
        }

        public final boolean m() {
            return (this.e & 16) != 0;
        }

        public final boolean n() {
            return this.j;
        }

        public final boolean o() {
            return (this.e & 32) != 0;
        }

        public final boolean s() {
            return this.k;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableMessage, com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.m;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.l.size(); i++) {
                if (!this.l.get(i).isInitialized()) {
                    this.m = (byte) 0;
                    return false;
                }
            }
            if (!R()) {
                this.m = (byte) 0;
                return false;
            }
            this.m = (byte) 1;
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage.ExtensionWriter extensionWriter = new GeneratedMessageV3.ExtendableMessage.ExtensionWriter(this, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
            if ((this.e & 1) != 0) {
                codedOutputStream.g(1, this.f);
            }
            if ((this.e & 2) != 0) {
                codedOutputStream.a(2, this.g);
            }
            if ((this.e & 16) != 0) {
                codedOutputStream.a(3, this.j);
            }
            if ((this.e & 8) != 0) {
                codedOutputStream.a(5, this.i);
            }
            if ((this.e & 4) != 0) {
                codedOutputStream.g(6, this.h);
            }
            if ((this.e & 32) != 0) {
                codedOutputStream.a(10, this.k);
            }
            for (int i = 0; i < this.l.size(); i++) {
                codedOutputStream.a(999, this.l.get(i));
            }
            extensionWriter.a(DriveFile.MODE_WRITE_ONLY, codedOutputStream);
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.f6632a;
            if (i != -1) {
                return i;
            }
            int m = (this.e & 1) != 0 ? CodedOutputStream.m(1, this.f) + 0 : 0;
            if ((this.e & 2) != 0) {
                m += CodedOutputStream.b(2, this.g);
            }
            if ((this.e & 16) != 0) {
                m += CodedOutputStream.b(3, this.j);
            }
            if ((this.e & 8) != 0) {
                m += CodedOutputStream.b(5, this.i);
            }
            if ((this.e & 4) != 0) {
                m += CodedOutputStream.m(6, this.h);
            }
            if ((this.e & 32) != 0) {
                m += CodedOutputStream.b(10, this.k);
            }
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                m += CodedOutputStream.c(999, this.l.get(i2));
            }
            int S = m + S() + this.d.getSerializedSize();
            this.f6632a = S;
            return S;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof FieldOptions)) {
                return super.equals(obj);
            }
            FieldOptions fieldOptions = (FieldOptions) obj;
            if (((this.e & 1) != 0) != ((fieldOptions.e & 1) != 0)) {
                return false;
            }
            if (((this.e & 1) != 0) && this.f != fieldOptions.f) {
                return false;
            }
            if (((this.e & 2) != 0) != ((fieldOptions.e & 2) != 0)) {
                return false;
            }
            if (((this.e & 2) != 0) && this.g != fieldOptions.g) {
                return false;
            }
            if (((this.e & 4) != 0) != ((fieldOptions.e & 4) != 0)) {
                return false;
            }
            if (((this.e & 4) != 0) && this.h != fieldOptions.h) {
                return false;
            }
            if (((this.e & 8) != 0) != ((fieldOptions.e & 8) != 0)) {
                return false;
            }
            if (((this.e & 8) != 0) && this.i != fieldOptions.i) {
                return false;
            }
            if (((this.e & 16) != 0) != ((fieldOptions.e & 16) != 0)) {
                return false;
            }
            if (((this.e & 16) != 0) && this.j != fieldOptions.j) {
                return false;
            }
            if (((this.e & 32) != 0) != ((fieldOptions.e & 32) != 0)) {
                return false;
            }
            return (!((this.e & 32) != 0) || this.k == fieldOptions.k) && this.l.equals(fieldOptions.l) && this.d.equals(fieldOptions.d) && T().equals(fieldOptions.T());
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.E.hashCode() + 779;
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + this.f;
                }
                if ((this.e & 2) != 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + Internal.a(this.g);
                }
                if ((this.e & 4) != 0) {
                    hashCode = (((hashCode * 37) + 6) * 53) + this.h;
                }
                if ((this.e & 8) != 0) {
                    hashCode = (((hashCode * 37) + 5) * 53) + Internal.a(this.i);
                }
                if ((this.e & 16) != 0) {
                    hashCode = (((hashCode * 37) + 3) * 53) + Internal.a(this.j);
                }
                if ((this.e & 32) != 0) {
                    hashCode = (((hashCode * 37) + 10) * 53) + Internal.a(this.k);
                }
                if (this.l.size() > 0) {
                    hashCode = (((hashCode * 37) + 999) * 53) + this.l.hashCode();
                }
                int a2 = (a(hashCode, T()) * 29) + this.d.hashCode();
                this.memoizedHashCode = a2;
                return a2;
            }
            return this.memoizedHashCode;
        }

        private static Builder v() {
            FieldOptions fieldOptions = n;
            byte b2 = 0;
            return fieldOptions == fieldOptions ? new Builder(b2) : new Builder(b2).a(fieldOptions);
        }

        public static Builder a(FieldOptions fieldOptions) {
            FieldOptions fieldOptions2 = n;
            byte b2 = 0;
            return (fieldOptions2 == fieldOptions2 ? new Builder(b2) : new Builder(b2).a(fieldOptions2)).a(fieldOptions);
        }

        public final Builder t() {
            byte b2 = 0;
            return this == n ? new Builder(b2) : new Builder(b2).a(this);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.ExtendableBuilder<FieldOptions, Builder> implements FieldOptionsOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6654a;
            private int b;
            private boolean c;
            private int d;
            private boolean e;
            private boolean f;
            private boolean g;
            private List<UninterpretedOption> h;
            private RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> i;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof FieldOptions) {
                    return a((FieldOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* synthetic */ GeneratedMessageV3.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* synthetic */ GeneratedMessageV3.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                FieldOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof FieldOptions) {
                    return a((FieldOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: e */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return FieldOptions.u();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                FieldOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return FieldOptions.u();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.F.a(FieldOptions.class, Builder.class);
            }

            private Builder() {
                this.b = 0;
                this.d = 0;
                this.h = Collections.emptyList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = 0;
                this.d = 0;
                this.h = Collections.emptyList();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.E;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final FieldOptions g() {
                FieldOptions fieldOptions = new FieldOptions((GeneratedMessageV3.ExtendableBuilder) this, (byte) (0 == true ? 1 : 0));
                int i = this.f6654a;
                int i2 = (i & 1) != 0 ? 1 : 0;
                fieldOptions.f = this.b;
                if ((i & 2) != 0) {
                    fieldOptions.g = this.c;
                    i2 |= 2;
                }
                if ((i & 4) != 0) {
                    i2 |= 4;
                }
                fieldOptions.h = this.d;
                if ((i & 8) != 0) {
                    fieldOptions.i = this.e;
                    i2 |= 8;
                }
                if ((i & 16) != 0) {
                    fieldOptions.j = this.f;
                    i2 |= 16;
                }
                if ((i & 32) != 0) {
                    fieldOptions.k = this.g;
                    i2 |= 32;
                }
                RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.i;
                if (repeatedFieldBuilderV3 != null) {
                    fieldOptions.l = repeatedFieldBuilderV3.e();
                } else {
                    if ((this.f6654a & 64) != 0) {
                        this.h = Collections.unmodifiableList(this.h);
                        this.f6654a &= -65;
                    }
                    fieldOptions.l = this.h;
                }
                fieldOptions.e = i2;
                i();
                return fieldOptions;
            }

            public final Builder a(FieldOptions fieldOptions) {
                if (fieldOptions == FieldOptions.u()) {
                    return this;
                }
                if (fieldOptions.e()) {
                    CType f = fieldOptions.f();
                    if (f == null) {
                        throw new NullPointerException();
                    }
                    this.f6654a |= 1;
                    this.b = f.a();
                    j();
                }
                if (fieldOptions.g()) {
                    boolean h = fieldOptions.h();
                    this.f6654a |= 2;
                    this.c = h;
                    j();
                }
                if (fieldOptions.i()) {
                    JSType j = fieldOptions.j();
                    if (j == null) {
                        throw new NullPointerException();
                    }
                    this.f6654a |= 4;
                    this.d = j.a();
                    j();
                }
                if (fieldOptions.k()) {
                    boolean l = fieldOptions.l();
                    this.f6654a |= 8;
                    this.e = l;
                    j();
                }
                if (fieldOptions.m()) {
                    boolean n = fieldOptions.n();
                    this.f6654a |= 16;
                    this.f = n;
                    j();
                }
                if (fieldOptions.o()) {
                    boolean s = fieldOptions.s();
                    this.f6654a |= 32;
                    this.g = s;
                    j();
                }
                if (this.i == null) {
                    if (!fieldOptions.l.isEmpty()) {
                        if (this.h.isEmpty()) {
                            this.h = fieldOptions.l;
                            this.f6654a &= -65;
                        } else {
                            if ((this.f6654a & 64) == 0) {
                                this.h = new ArrayList(this.h);
                                this.f6654a |= 64;
                            }
                            this.h.addAll(fieldOptions.l);
                        }
                        j();
                    }
                } else if (!fieldOptions.l.isEmpty()) {
                    if (!this.i.d()) {
                        this.i.a(fieldOptions.l);
                    } else {
                        this.i.b();
                        this.i = null;
                        this.h = fieldOptions.l;
                        this.f6654a &= -65;
                        this.i = null;
                    }
                }
                a((GeneratedMessageV3.ExtendableMessage) fieldOptions);
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int i = 0;
                while (true) {
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.i;
                    if (i >= (repeatedFieldBuilderV3 == null ? this.h.size() : repeatedFieldBuilderV3.c())) {
                        return m();
                    }
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV32 = this.i;
                    if (!(repeatedFieldBuilderV32 == null ? this.h.get(i) : repeatedFieldBuilderV32.a(i)).isInitialized()) {
                        return false;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.FieldOptions.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$FieldOptions> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.FieldOptions.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$FieldOptions r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.FieldOptions) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$FieldOptions r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.FieldOptions) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.FieldOptions.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$FieldOptions$Builder");
            }
        }

        public static FieldOptions u() {
            return n;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<FieldOptions> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class OneofOptions extends GeneratedMessageV3.ExtendableMessage<OneofOptions> implements OneofOptionsOrBuilder {
        private List<UninterpretedOption> e;
        private byte f;
        private static final OneofOptions g = new OneofOptions();

        @Deprecated
        public static final Parser<OneofOptions> b = new AbstractParser<OneofOptions>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.OneofOptions.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new OneofOptions(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* synthetic */ OneofOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ OneofOptions(GeneratedMessageV3.ExtendableBuilder extendableBuilder, byte b2) {
            this(extendableBuilder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return g;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return g();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == g ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return g();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return g;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == g ? new Builder(b2) : new Builder(b2).a(this);
        }

        private OneofOptions(GeneratedMessageV3.ExtendableBuilder<OneofOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.f = (byte) -1;
        }

        private OneofOptions() {
            this.f = (byte) -1;
            this.e = Collections.emptyList();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new OneofOptions();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private OneofOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 7994) {
                            if (!(z2 & true)) {
                                this.e = new ArrayList();
                                z2 |= true;
                            }
                            this.e.add(codedInputStream.a(UninterpretedOption.b, extensionRegistryLite));
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.e = Collections.unmodifiableList(this.e);
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.H.a(OneofOptions.class, Builder.class);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableMessage, com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.e.size(); i++) {
                if (!this.e.get(i).isInitialized()) {
                    this.f = (byte) 0;
                    return false;
                }
            }
            if (!R()) {
                this.f = (byte) 0;
                return false;
            }
            this.f = (byte) 1;
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage.ExtensionWriter extensionWriter = new GeneratedMessageV3.ExtendableMessage.ExtensionWriter(this, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
            for (int i = 0; i < this.e.size(); i++) {
                codedOutputStream.a(999, this.e.get(i));
            }
            extensionWriter.a(DriveFile.MODE_WRITE_ONLY, codedOutputStream);
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.f6632a;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                i2 += CodedOutputStream.c(999, this.e.get(i3));
            }
            int S = i2 + S() + this.d.getSerializedSize();
            this.f6632a = S;
            return S;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof OneofOptions)) {
                return super.equals(obj);
            }
            OneofOptions oneofOptions = (OneofOptions) obj;
            return this.e.equals(oneofOptions.e) && this.d.equals(oneofOptions.d) && T().equals(oneofOptions.T());
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.G.hashCode() + 779;
                if (this.e.size() > 0) {
                    hashCode = (((hashCode * 37) + 999) * 53) + this.e.hashCode();
                }
                int a2 = (a(hashCode, T()) * 29) + this.d.hashCode();
                this.memoizedHashCode = a2;
                return a2;
            }
            return this.memoizedHashCode;
        }

        private static Builder g() {
            OneofOptions oneofOptions = g;
            byte b2 = 0;
            return oneofOptions == oneofOptions ? new Builder(b2) : new Builder(b2).a(oneofOptions);
        }

        public static Builder a(OneofOptions oneofOptions) {
            OneofOptions oneofOptions2 = g;
            byte b2 = 0;
            return (oneofOptions2 == oneofOptions2 ? new Builder(b2) : new Builder(b2).a(oneofOptions2)).a(oneofOptions);
        }

        public final Builder e() {
            byte b2 = 0;
            return this == g ? new Builder(b2) : new Builder(b2).a(this);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.ExtendableBuilder<OneofOptions, Builder> implements OneofOptionsOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6668a;
            private List<UninterpretedOption> b;
            private RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> c;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof OneofOptions) {
                    return a((OneofOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* synthetic */ GeneratedMessageV3.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* synthetic */ GeneratedMessageV3.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                OneofOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof OneofOptions) {
                    return a((OneofOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: e */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return OneofOptions.f();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                OneofOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return OneofOptions.f();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.H.a(OneofOptions.class, Builder.class);
            }

            private Builder() {
                this.b = Collections.emptyList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = Collections.emptyList();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.G;
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final OneofOptions g() {
                OneofOptions oneofOptions = new OneofOptions((GeneratedMessageV3.ExtendableBuilder) this, (byte) 0);
                int i = this.f6668a;
                RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.c;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) != 0) {
                        this.b = Collections.unmodifiableList(this.b);
                        this.f6668a &= -2;
                    }
                    oneofOptions.e = this.b;
                } else {
                    oneofOptions.e = repeatedFieldBuilderV3.e();
                }
                i();
                return oneofOptions;
            }

            public final Builder a(OneofOptions oneofOptions) {
                if (oneofOptions == OneofOptions.f()) {
                    return this;
                }
                if (this.c == null) {
                    if (!oneofOptions.e.isEmpty()) {
                        if (this.b.isEmpty()) {
                            this.b = oneofOptions.e;
                            this.f6668a &= -2;
                        } else {
                            if ((this.f6668a & 1) == 0) {
                                this.b = new ArrayList(this.b);
                                this.f6668a |= 1;
                            }
                            this.b.addAll(oneofOptions.e);
                        }
                        j();
                    }
                } else if (!oneofOptions.e.isEmpty()) {
                    if (!this.c.d()) {
                        this.c.a(oneofOptions.e);
                    } else {
                        this.c.b();
                        this.c = null;
                        this.b = oneofOptions.e;
                        this.f6668a &= -2;
                        this.c = null;
                    }
                }
                a((GeneratedMessageV3.ExtendableMessage) oneofOptions);
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int i = 0;
                while (true) {
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.c;
                    if (i >= (repeatedFieldBuilderV3 == null ? this.b.size() : repeatedFieldBuilderV3.c())) {
                        return m();
                    }
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV32 = this.c;
                    if (!(repeatedFieldBuilderV32 == null ? this.b.get(i) : repeatedFieldBuilderV32.a(i)).isInitialized()) {
                        return false;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.OneofOptions.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$OneofOptions> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.OneofOptions.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$OneofOptions r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.OneofOptions) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$OneofOptions r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.OneofOptions) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.OneofOptions.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$OneofOptions$Builder");
            }
        }

        public static OneofOptions f() {
            return g;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<OneofOptions> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class EnumOptions extends GeneratedMessageV3.ExtendableMessage<EnumOptions> implements EnumOptionsOrBuilder {
        private int e;
        private boolean f;
        private boolean g;
        private List<UninterpretedOption> h;
        private byte i;
        private static final EnumOptions j = new EnumOptions();

        @Deprecated
        public static final Parser<EnumOptions> b = new AbstractParser<EnumOptions>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.EnumOptions.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new EnumOptions(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* synthetic */ EnumOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ EnumOptions(GeneratedMessageV3.ExtendableBuilder extendableBuilder, byte b2) {
            this(extendableBuilder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return j;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return k();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == j ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return k();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return j;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == j ? new Builder(b2) : new Builder(b2).a(this);
        }

        private EnumOptions(GeneratedMessageV3.ExtendableBuilder<EnumOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.i = (byte) -1;
        }

        private EnumOptions() {
            this.i = (byte) -1;
            this.h = Collections.emptyList();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new EnumOptions();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private EnumOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            int i = 0;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 16) {
                            this.e |= 1;
                            this.f = codedInputStream.i();
                        } else if (a3 == 24) {
                            this.e |= 2;
                            this.g = codedInputStream.i();
                        } else if (a3 == 7994) {
                            if ((i & 4) == 0) {
                                this.h = new ArrayList();
                                i |= 4;
                            }
                            this.h.add(codedInputStream.a(UninterpretedOption.b, extensionRegistryLite));
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if ((i & 4) != 0) {
                        this.h = Collections.unmodifiableList(this.h);
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.J.a(EnumOptions.class, Builder.class);
        }

        public final boolean e() {
            return (this.e & 1) != 0;
        }

        public final boolean f() {
            return this.f;
        }

        public final boolean g() {
            return (this.e & 2) != 0;
        }

        public final boolean h() {
            return this.g;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableMessage, com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.i;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.h.size(); i++) {
                if (!this.h.get(i).isInitialized()) {
                    this.i = (byte) 0;
                    return false;
                }
            }
            if (!R()) {
                this.i = (byte) 0;
                return false;
            }
            this.i = (byte) 1;
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage.ExtensionWriter extensionWriter = new GeneratedMessageV3.ExtendableMessage.ExtensionWriter(this, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
            if ((this.e & 1) != 0) {
                codedOutputStream.a(2, this.f);
            }
            if ((this.e & 2) != 0) {
                codedOutputStream.a(3, this.g);
            }
            for (int i = 0; i < this.h.size(); i++) {
                codedOutputStream.a(999, this.h.get(i));
            }
            extensionWriter.a(DriveFile.MODE_WRITE_ONLY, codedOutputStream);
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.f6632a;
            if (i != -1) {
                return i;
            }
            int b2 = (this.e & 1) != 0 ? CodedOutputStream.b(2, this.f) + 0 : 0;
            if ((2 & this.e) != 0) {
                b2 += CodedOutputStream.b(3, this.g);
            }
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                b2 += CodedOutputStream.c(999, this.h.get(i2));
            }
            int S = b2 + S() + this.d.getSerializedSize();
            this.f6632a = S;
            return S;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EnumOptions)) {
                return super.equals(obj);
            }
            EnumOptions enumOptions = (EnumOptions) obj;
            if (((this.e & 1) != 0) != ((enumOptions.e & 1) != 0)) {
                return false;
            }
            if (((this.e & 1) != 0) && this.f != enumOptions.f) {
                return false;
            }
            if (((this.e & 2) != 0) != ((enumOptions.e & 2) != 0)) {
                return false;
            }
            return (!((this.e & 2) != 0) || this.g == enumOptions.g) && this.h.equals(enumOptions.h) && this.d.equals(enumOptions.d) && T().equals(enumOptions.T());
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.I.hashCode() + 779;
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + Internal.a(this.f);
                }
                if ((this.e & 2) != 0) {
                    hashCode = (((hashCode * 37) + 3) * 53) + Internal.a(this.g);
                }
                if (this.h.size() > 0) {
                    hashCode = (((hashCode * 37) + 999) * 53) + this.h.hashCode();
                }
                int a2 = (a(hashCode, T()) * 29) + this.d.hashCode();
                this.memoizedHashCode = a2;
                return a2;
            }
            return this.memoizedHashCode;
        }

        private static Builder k() {
            EnumOptions enumOptions = j;
            byte b2 = 0;
            return enumOptions == enumOptions ? new Builder(b2) : new Builder(b2).a(enumOptions);
        }

        public static Builder a(EnumOptions enumOptions) {
            EnumOptions enumOptions2 = j;
            byte b2 = 0;
            return (enumOptions2 == enumOptions2 ? new Builder(b2) : new Builder(b2).a(enumOptions2)).a(enumOptions);
        }

        public final Builder i() {
            byte b2 = 0;
            return this == j ? new Builder(b2) : new Builder(b2).a(this);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.ExtendableBuilder<EnumOptions, Builder> implements EnumOptionsOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6647a;
            private boolean b;
            private boolean c;
            private List<UninterpretedOption> d;
            private RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> e;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof EnumOptions) {
                    return a((EnumOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* synthetic */ GeneratedMessageV3.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* synthetic */ GeneratedMessageV3.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                EnumOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof EnumOptions) {
                    return a((EnumOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: e */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return EnumOptions.j();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                EnumOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return EnumOptions.j();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.J.a(EnumOptions.class, Builder.class);
            }

            private Builder() {
                this.d = Collections.emptyList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.d = Collections.emptyList();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.I;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final EnumOptions g() {
                int i = 0;
                EnumOptions enumOptions = new EnumOptions((GeneratedMessageV3.ExtendableBuilder) this, (byte) (0 == true ? 1 : 0));
                int i2 = this.f6647a;
                if ((i2 & 1) != 0) {
                    enumOptions.f = this.b;
                    i = 1;
                }
                if ((i2 & 2) != 0) {
                    enumOptions.g = this.c;
                    i |= 2;
                }
                RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.e;
                if (repeatedFieldBuilderV3 != null) {
                    enumOptions.h = repeatedFieldBuilderV3.e();
                } else {
                    if ((this.f6647a & 4) != 0) {
                        this.d = Collections.unmodifiableList(this.d);
                        this.f6647a &= -5;
                    }
                    enumOptions.h = this.d;
                }
                enumOptions.e = i;
                i();
                return enumOptions;
            }

            public final Builder a(EnumOptions enumOptions) {
                if (enumOptions == EnumOptions.j()) {
                    return this;
                }
                if (enumOptions.e()) {
                    boolean f = enumOptions.f();
                    this.f6647a |= 1;
                    this.b = f;
                    j();
                }
                if (enumOptions.g()) {
                    boolean h = enumOptions.h();
                    this.f6647a |= 2;
                    this.c = h;
                    j();
                }
                if (this.e == null) {
                    if (!enumOptions.h.isEmpty()) {
                        if (this.d.isEmpty()) {
                            this.d = enumOptions.h;
                            this.f6647a &= -5;
                        } else {
                            if ((this.f6647a & 4) == 0) {
                                this.d = new ArrayList(this.d);
                                this.f6647a |= 4;
                            }
                            this.d.addAll(enumOptions.h);
                        }
                        j();
                    }
                } else if (!enumOptions.h.isEmpty()) {
                    if (!this.e.d()) {
                        this.e.a(enumOptions.h);
                    } else {
                        this.e.b();
                        this.e = null;
                        this.d = enumOptions.h;
                        this.f6647a &= -5;
                        this.e = null;
                    }
                }
                a((GeneratedMessageV3.ExtendableMessage) enumOptions);
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int i = 0;
                while (true) {
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.e;
                    if (i >= (repeatedFieldBuilderV3 == null ? this.d.size() : repeatedFieldBuilderV3.c())) {
                        return m();
                    }
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV32 = this.e;
                    if (!(repeatedFieldBuilderV32 == null ? this.d.get(i) : repeatedFieldBuilderV32.a(i)).isInitialized()) {
                        return false;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.EnumOptions.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$EnumOptions> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.EnumOptions.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$EnumOptions r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.EnumOptions) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$EnumOptions r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.EnumOptions) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.EnumOptions.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$EnumOptions$Builder");
            }
        }

        public static EnumOptions j() {
            return j;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<EnumOptions> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class EnumValueOptions extends GeneratedMessageV3.ExtendableMessage<EnumValueOptions> implements EnumValueOptionsOrBuilder {
        private int e;
        private boolean f;
        private List<UninterpretedOption> g;
        private byte h;
        private static final EnumValueOptions i = new EnumValueOptions();

        @Deprecated
        public static final Parser<EnumValueOptions> b = new AbstractParser<EnumValueOptions>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.EnumValueOptions.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new EnumValueOptions(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* synthetic */ EnumValueOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ EnumValueOptions(GeneratedMessageV3.ExtendableBuilder extendableBuilder, byte b2) {
            this(extendableBuilder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return i;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return i();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == i ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return i();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return i;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == i ? new Builder(b2) : new Builder(b2).a(this);
        }

        private EnumValueOptions(GeneratedMessageV3.ExtendableBuilder<EnumValueOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.h = (byte) -1;
        }

        private EnumValueOptions() {
            this.h = (byte) -1;
            this.g = Collections.emptyList();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new EnumValueOptions();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private EnumValueOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            int i2 = 0;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 8) {
                            this.e |= 1;
                            this.f = codedInputStream.i();
                        } else if (a3 == 7994) {
                            if ((i2 & 2) == 0) {
                                this.g = new ArrayList();
                                i2 |= 2;
                            }
                            this.g.add(codedInputStream.a(UninterpretedOption.b, extensionRegistryLite));
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if ((i2 & 2) != 0) {
                        this.g = Collections.unmodifiableList(this.g);
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.L.a(EnumValueOptions.class, Builder.class);
        }

        public final boolean e() {
            return (this.e & 1) != 0;
        }

        public final boolean f() {
            return this.f;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableMessage, com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.h;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                if (!this.g.get(i2).isInitialized()) {
                    this.h = (byte) 0;
                    return false;
                }
            }
            if (!R()) {
                this.h = (byte) 0;
                return false;
            }
            this.h = (byte) 1;
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage.ExtensionWriter extensionWriter = new GeneratedMessageV3.ExtendableMessage.ExtensionWriter(this, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
            if ((this.e & 1) != 0) {
                codedOutputStream.a(1, this.f);
            }
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                codedOutputStream.a(999, this.g.get(i2));
            }
            extensionWriter.a(DriveFile.MODE_WRITE_ONLY, codedOutputStream);
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i2 = this.f6632a;
            if (i2 != -1) {
                return i2;
            }
            int b2 = (this.e & 1) != 0 ? CodedOutputStream.b(1, this.f) + 0 : 0;
            for (int i3 = 0; i3 < this.g.size(); i3++) {
                b2 += CodedOutputStream.c(999, this.g.get(i3));
            }
            int S = b2 + S() + this.d.getSerializedSize();
            this.f6632a = S;
            return S;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EnumValueOptions)) {
                return super.equals(obj);
            }
            EnumValueOptions enumValueOptions = (EnumValueOptions) obj;
            if (((this.e & 1) != 0) != ((enumValueOptions.e & 1) != 0)) {
                return false;
            }
            return (!((this.e & 1) != 0) || this.f == enumValueOptions.f) && this.g.equals(enumValueOptions.g) && this.d.equals(enumValueOptions.d) && T().equals(enumValueOptions.T());
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.K.hashCode() + 779;
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + Internal.a(this.f);
                }
                if (this.g.size() > 0) {
                    hashCode = (((hashCode * 37) + 999) * 53) + this.g.hashCode();
                }
                int a2 = (a(hashCode, T()) * 29) + this.d.hashCode();
                this.memoizedHashCode = a2;
                return a2;
            }
            return this.memoizedHashCode;
        }

        private static Builder i() {
            EnumValueOptions enumValueOptions = i;
            byte b2 = 0;
            return enumValueOptions == enumValueOptions ? new Builder(b2) : new Builder(b2).a(enumValueOptions);
        }

        public static Builder a(EnumValueOptions enumValueOptions) {
            EnumValueOptions enumValueOptions2 = i;
            byte b2 = 0;
            return (enumValueOptions2 == enumValueOptions2 ? new Builder(b2) : new Builder(b2).a(enumValueOptions2)).a(enumValueOptions);
        }

        public final Builder g() {
            byte b2 = 0;
            return this == i ? new Builder(b2) : new Builder(b2).a(this);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.ExtendableBuilder<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6649a;
            private boolean b;
            private List<UninterpretedOption> c;
            private RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> d;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof EnumValueOptions) {
                    return a((EnumValueOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* synthetic */ GeneratedMessageV3.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* synthetic */ GeneratedMessageV3.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                EnumValueOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof EnumValueOptions) {
                    return a((EnumValueOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: e */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return EnumValueOptions.h();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                EnumValueOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return EnumValueOptions.h();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.L.a(EnumValueOptions.class, Builder.class);
            }

            private Builder() {
                this.c = Collections.emptyList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.c = Collections.emptyList();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.K;
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final EnumValueOptions g() {
                byte b = 0;
                EnumValueOptions enumValueOptions = new EnumValueOptions(this, b);
                if ((this.f6649a & 1) != 0) {
                    enumValueOptions.f = this.b;
                    b = 1;
                }
                RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.d;
                if (repeatedFieldBuilderV3 != null) {
                    enumValueOptions.g = repeatedFieldBuilderV3.e();
                } else {
                    if ((this.f6649a & 2) != 0) {
                        this.c = Collections.unmodifiableList(this.c);
                        this.f6649a &= -3;
                    }
                    enumValueOptions.g = this.c;
                }
                enumValueOptions.e = b;
                i();
                return enumValueOptions;
            }

            public final Builder a(EnumValueOptions enumValueOptions) {
                if (enumValueOptions == EnumValueOptions.h()) {
                    return this;
                }
                if (enumValueOptions.e()) {
                    boolean f = enumValueOptions.f();
                    this.f6649a |= 1;
                    this.b = f;
                    j();
                }
                if (this.d == null) {
                    if (!enumValueOptions.g.isEmpty()) {
                        if (this.c.isEmpty()) {
                            this.c = enumValueOptions.g;
                            this.f6649a &= -3;
                        } else {
                            if ((this.f6649a & 2) == 0) {
                                this.c = new ArrayList(this.c);
                                this.f6649a |= 2;
                            }
                            this.c.addAll(enumValueOptions.g);
                        }
                        j();
                    }
                } else if (!enumValueOptions.g.isEmpty()) {
                    if (!this.d.d()) {
                        this.d.a(enumValueOptions.g);
                    } else {
                        this.d.b();
                        this.d = null;
                        this.c = enumValueOptions.g;
                        this.f6649a &= -3;
                        this.d = null;
                    }
                }
                a((GeneratedMessageV3.ExtendableMessage) enumValueOptions);
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int i = 0;
                while (true) {
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.d;
                    if (i >= (repeatedFieldBuilderV3 == null ? this.c.size() : repeatedFieldBuilderV3.c())) {
                        return m();
                    }
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV32 = this.d;
                    if (!(repeatedFieldBuilderV32 == null ? this.c.get(i) : repeatedFieldBuilderV32.a(i)).isInitialized()) {
                        return false;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.EnumValueOptions.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$EnumValueOptions> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.EnumValueOptions.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$EnumValueOptions r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.EnumValueOptions) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$EnumValueOptions r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.EnumValueOptions) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.EnumValueOptions.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$EnumValueOptions$Builder");
            }
        }

        public static EnumValueOptions h() {
            return i;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<EnumValueOptions> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class ServiceOptions extends GeneratedMessageV3.ExtendableMessage<ServiceOptions> implements ServiceOptionsOrBuilder {
        private int e;
        private boolean f;
        private List<UninterpretedOption> g;
        private byte h;
        private static final ServiceOptions i = new ServiceOptions();

        @Deprecated
        public static final Parser<ServiceOptions> b = new AbstractParser<ServiceOptions>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.ServiceOptions.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new ServiceOptions(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* synthetic */ ServiceOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ ServiceOptions(GeneratedMessageV3.ExtendableBuilder extendableBuilder, byte b2) {
            this(extendableBuilder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return i;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return i();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == i ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return i();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return i;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == i ? new Builder(b2) : new Builder(b2).a(this);
        }

        private ServiceOptions(GeneratedMessageV3.ExtendableBuilder<ServiceOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.h = (byte) -1;
        }

        private ServiceOptions() {
            this.h = (byte) -1;
            this.g = Collections.emptyList();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new ServiceOptions();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private ServiceOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            int i2 = 0;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 264) {
                            this.e |= 1;
                            this.f = codedInputStream.i();
                        } else if (a3 == 7994) {
                            if ((i2 & 2) == 0) {
                                this.g = new ArrayList();
                                i2 |= 2;
                            }
                            this.g.add(codedInputStream.a(UninterpretedOption.b, extensionRegistryLite));
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if ((i2 & 2) != 0) {
                        this.g = Collections.unmodifiableList(this.g);
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.N.a(ServiceOptions.class, Builder.class);
        }

        public final boolean e() {
            return (this.e & 1) != 0;
        }

        public final boolean f() {
            return this.f;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableMessage, com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.h;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                if (!this.g.get(i2).isInitialized()) {
                    this.h = (byte) 0;
                    return false;
                }
            }
            if (!R()) {
                this.h = (byte) 0;
                return false;
            }
            this.h = (byte) 1;
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage.ExtensionWriter extensionWriter = new GeneratedMessageV3.ExtendableMessage.ExtensionWriter(this, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
            if ((this.e & 1) != 0) {
                codedOutputStream.a(33, this.f);
            }
            for (int i2 = 0; i2 < this.g.size(); i2++) {
                codedOutputStream.a(999, this.g.get(i2));
            }
            extensionWriter.a(DriveFile.MODE_WRITE_ONLY, codedOutputStream);
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i2 = this.f6632a;
            if (i2 != -1) {
                return i2;
            }
            int b2 = (this.e & 1) != 0 ? CodedOutputStream.b(33, this.f) + 0 : 0;
            for (int i3 = 0; i3 < this.g.size(); i3++) {
                b2 += CodedOutputStream.c(999, this.g.get(i3));
            }
            int S = b2 + S() + this.d.getSerializedSize();
            this.f6632a = S;
            return S;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ServiceOptions)) {
                return super.equals(obj);
            }
            ServiceOptions serviceOptions = (ServiceOptions) obj;
            if (((this.e & 1) != 0) != ((serviceOptions.e & 1) != 0)) {
                return false;
            }
            return (!((this.e & 1) != 0) || this.f == serviceOptions.f) && this.g.equals(serviceOptions.g) && this.d.equals(serviceOptions.d) && T().equals(serviceOptions.T());
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.M.hashCode() + 779;
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 33) * 53) + Internal.a(this.f);
                }
                if (this.g.size() > 0) {
                    hashCode = (((hashCode * 37) + 999) * 53) + this.g.hashCode();
                }
                int a2 = (a(hashCode, T()) * 29) + this.d.hashCode();
                this.memoizedHashCode = a2;
                return a2;
            }
            return this.memoizedHashCode;
        }

        private static Builder i() {
            ServiceOptions serviceOptions = i;
            byte b2 = 0;
            return serviceOptions == serviceOptions ? new Builder(b2) : new Builder(b2).a(serviceOptions);
        }

        public static Builder a(ServiceOptions serviceOptions) {
            ServiceOptions serviceOptions2 = i;
            byte b2 = 0;
            return (serviceOptions2 == serviceOptions2 ? new Builder(b2) : new Builder(b2).a(serviceOptions2)).a(serviceOptions);
        }

        public final Builder g() {
            byte b2 = 0;
            return this == i ? new Builder(b2) : new Builder(b2).a(this);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.ExtendableBuilder<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6670a;
            private boolean b;
            private List<UninterpretedOption> c;
            private RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> d;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof ServiceOptions) {
                    return a((ServiceOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* synthetic */ GeneratedMessageV3.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* synthetic */ GeneratedMessageV3.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                ServiceOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof ServiceOptions) {
                    return a((ServiceOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: e */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return ServiceOptions.h();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                ServiceOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return ServiceOptions.h();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.N.a(ServiceOptions.class, Builder.class);
            }

            private Builder() {
                this.c = Collections.emptyList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.c = Collections.emptyList();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.M;
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final ServiceOptions g() {
                byte b = 0;
                ServiceOptions serviceOptions = new ServiceOptions(this, b);
                if ((this.f6670a & 1) != 0) {
                    serviceOptions.f = this.b;
                    b = 1;
                }
                RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.d;
                if (repeatedFieldBuilderV3 != null) {
                    serviceOptions.g = repeatedFieldBuilderV3.e();
                } else {
                    if ((this.f6670a & 2) != 0) {
                        this.c = Collections.unmodifiableList(this.c);
                        this.f6670a &= -3;
                    }
                    serviceOptions.g = this.c;
                }
                serviceOptions.e = b;
                i();
                return serviceOptions;
            }

            public final Builder a(ServiceOptions serviceOptions) {
                if (serviceOptions == ServiceOptions.h()) {
                    return this;
                }
                if (serviceOptions.e()) {
                    boolean f = serviceOptions.f();
                    this.f6670a |= 1;
                    this.b = f;
                    j();
                }
                if (this.d == null) {
                    if (!serviceOptions.g.isEmpty()) {
                        if (this.c.isEmpty()) {
                            this.c = serviceOptions.g;
                            this.f6670a &= -3;
                        } else {
                            if ((this.f6670a & 2) == 0) {
                                this.c = new ArrayList(this.c);
                                this.f6670a |= 2;
                            }
                            this.c.addAll(serviceOptions.g);
                        }
                        j();
                    }
                } else if (!serviceOptions.g.isEmpty()) {
                    if (!this.d.d()) {
                        this.d.a(serviceOptions.g);
                    } else {
                        this.d.b();
                        this.d = null;
                        this.c = serviceOptions.g;
                        this.f6670a &= -3;
                        this.d = null;
                    }
                }
                a((GeneratedMessageV3.ExtendableMessage) serviceOptions);
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int i = 0;
                while (true) {
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.d;
                    if (i >= (repeatedFieldBuilderV3 == null ? this.c.size() : repeatedFieldBuilderV3.c())) {
                        return m();
                    }
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV32 = this.d;
                    if (!(repeatedFieldBuilderV32 == null ? this.c.get(i) : repeatedFieldBuilderV32.a(i)).isInitialized()) {
                        return false;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.ServiceOptions.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$ServiceOptions> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.ServiceOptions.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$ServiceOptions r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.ServiceOptions) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$ServiceOptions r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.ServiceOptions) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.ServiceOptions.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$ServiceOptions$Builder");
            }
        }

        public static ServiceOptions h() {
            return i;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<ServiceOptions> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class MethodOptions extends GeneratedMessageV3.ExtendableMessage<MethodOptions> implements MethodOptionsOrBuilder {
        private int e;
        private boolean f;
        private int g;
        private List<UninterpretedOption> h;
        private byte i;
        private static final MethodOptions j = new MethodOptions();

        @Deprecated
        public static final Parser<MethodOptions> b = new AbstractParser<MethodOptions>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.MethodOptions.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new MethodOptions(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* synthetic */ MethodOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ MethodOptions(GeneratedMessageV3.ExtendableBuilder extendableBuilder, byte b2) {
            this(extendableBuilder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return j;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return k();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == j ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return k();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return j;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == j ? new Builder(b2) : new Builder(b2).a(this);
        }

        private MethodOptions(GeneratedMessageV3.ExtendableBuilder<MethodOptions, ?> extendableBuilder) {
            super(extendableBuilder);
            this.i = (byte) -1;
        }

        private MethodOptions() {
            this.i = (byte) -1;
            this.g = 0;
            this.h = Collections.emptyList();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new MethodOptions();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MethodOptions(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            int i = 0;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 264) {
                            this.e |= 1;
                            this.f = codedInputStream.i();
                        } else if (a3 == 272) {
                            int n = codedInputStream.n();
                            if (IdempotencyLevel.a(n) == null) {
                                a2.a(34, n);
                            } else {
                                this.e |= 2;
                                this.g = n;
                            }
                        } else if (a3 == 7994) {
                            if ((i & 4) == 0) {
                                this.h = new ArrayList();
                                i |= 4;
                            }
                            this.h.add(codedInputStream.a(UninterpretedOption.b, extensionRegistryLite));
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if ((i & 4) != 0) {
                        this.h = Collections.unmodifiableList(this.h);
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.P.a(MethodOptions.class, Builder.class);
        }

        /* loaded from: classes3.dex */
        public enum IdempotencyLevel implements ProtocolMessageEnum {
            IDEMPOTENCY_UNKNOWN(0),
            NO_SIDE_EFFECTS(1),
            IDEMPOTENT(2);

            private final int d;

            static {
                new Internal.EnumLiteMap<IdempotencyLevel>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.MethodOptions.IdempotencyLevel.1
                    @Override // com.uqm.crashsight.protobuf.Internal.EnumLiteMap
                    public final /* synthetic */ IdempotencyLevel a(int i) {
                        return IdempotencyLevel.b(i);
                    }
                };
                values();
            }

            @Override // com.uqm.crashsight.protobuf.Internal.EnumLite
            public final int a() {
                return this.d;
            }

            @Deprecated
            public static IdempotencyLevel a(int i) {
                return b(i);
            }

            public static IdempotencyLevel b(int i) {
                switch (i) {
                    case 0:
                        return IDEMPOTENCY_UNKNOWN;
                    case 1:
                        return NO_SIDE_EFFECTS;
                    case 2:
                        return IDEMPOTENT;
                    default:
                        return null;
                }
            }

            IdempotencyLevel(int i) {
                this.d = i;
            }
        }

        public final boolean e() {
            return (this.e & 1) != 0;
        }

        public final boolean f() {
            return this.f;
        }

        public final boolean g() {
            return (this.e & 2) != 0;
        }

        public final IdempotencyLevel h() {
            IdempotencyLevel a2 = IdempotencyLevel.a(this.g);
            return a2 == null ? IdempotencyLevel.IDEMPOTENCY_UNKNOWN : a2;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableMessage, com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.i;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.h.size(); i++) {
                if (!this.h.get(i).isInitialized()) {
                    this.i = (byte) 0;
                    return false;
                }
            }
            if (!R()) {
                this.i = (byte) 0;
                return false;
            }
            this.i = (byte) 1;
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            GeneratedMessageV3.ExtendableMessage.ExtensionWriter extensionWriter = new GeneratedMessageV3.ExtendableMessage.ExtensionWriter(this, 0 == true ? 1 : 0, 0 == true ? 1 : 0);
            if ((this.e & 1) != 0) {
                codedOutputStream.a(33, this.f);
            }
            if ((this.e & 2) != 0) {
                codedOutputStream.g(34, this.g);
            }
            for (int i = 0; i < this.h.size(); i++) {
                codedOutputStream.a(999, this.h.get(i));
            }
            extensionWriter.a(DriveFile.MODE_WRITE_ONLY, codedOutputStream);
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.f6632a;
            if (i != -1) {
                return i;
            }
            int b2 = (this.e & 1) != 0 ? CodedOutputStream.b(33, this.f) + 0 : 0;
            if ((this.e & 2) != 0) {
                b2 += CodedOutputStream.m(34, this.g);
            }
            for (int i2 = 0; i2 < this.h.size(); i2++) {
                b2 += CodedOutputStream.c(999, this.h.get(i2));
            }
            int S = b2 + S() + this.d.getSerializedSize();
            this.f6632a = S;
            return S;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MethodOptions)) {
                return super.equals(obj);
            }
            MethodOptions methodOptions = (MethodOptions) obj;
            if (((this.e & 1) != 0) != ((methodOptions.e & 1) != 0)) {
                return false;
            }
            if (((this.e & 1) != 0) && this.f != methodOptions.f) {
                return false;
            }
            if (((this.e & 2) != 0) != ((methodOptions.e & 2) != 0)) {
                return false;
            }
            return (!((this.e & 2) != 0) || this.g == methodOptions.g) && this.h.equals(methodOptions.h) && this.d.equals(methodOptions.d) && T().equals(methodOptions.T());
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.O.hashCode() + 779;
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 33) * 53) + Internal.a(this.f);
                }
                if ((this.e & 2) != 0) {
                    hashCode = (((hashCode * 37) + 34) * 53) + this.g;
                }
                if (this.h.size() > 0) {
                    hashCode = (((hashCode * 37) + 999) * 53) + this.h.hashCode();
                }
                int a2 = (a(hashCode, T()) * 29) + this.d.hashCode();
                this.memoizedHashCode = a2;
                return a2;
            }
            return this.memoizedHashCode;
        }

        private static Builder k() {
            MethodOptions methodOptions = j;
            byte b2 = 0;
            return methodOptions == methodOptions ? new Builder(b2) : new Builder(b2).a(methodOptions);
        }

        public static Builder a(MethodOptions methodOptions) {
            MethodOptions methodOptions2 = j;
            byte b2 = 0;
            return (methodOptions2 == methodOptions2 ? new Builder(b2) : new Builder(b2).a(methodOptions2)).a(methodOptions);
        }

        public final Builder i() {
            byte b2 = 0;
            return this == j ? new Builder(b2) : new Builder(b2).a(this);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.ExtendableBuilder<MethodOptions, Builder> implements MethodOptionsOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6665a;
            private boolean b;
            private int c;
            private List<UninterpretedOption> d;
            private RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> e;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof MethodOptions) {
                    return a((MethodOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* synthetic */ GeneratedMessageV3.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* synthetic */ GeneratedMessageV3.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                MethodOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof MethodOptions) {
                    return a((MethodOptions) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: e */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return MethodOptions.j();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                MethodOptions g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return MethodOptions.j();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.P.a(MethodOptions.class, Builder.class);
            }

            private Builder() {
                this.c = 0;
                this.d = Collections.emptyList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.c = 0;
                this.d = Collections.emptyList();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.O;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final MethodOptions g() {
                int i = 0;
                MethodOptions methodOptions = new MethodOptions((GeneratedMessageV3.ExtendableBuilder) this, (byte) (0 == true ? 1 : 0));
                int i2 = this.f6665a;
                if ((i2 & 1) != 0) {
                    methodOptions.f = this.b;
                    i = 1;
                }
                if ((i2 & 2) != 0) {
                    i |= 2;
                }
                methodOptions.g = this.c;
                RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.e;
                if (repeatedFieldBuilderV3 != null) {
                    methodOptions.h = repeatedFieldBuilderV3.e();
                } else {
                    if ((this.f6665a & 4) != 0) {
                        this.d = Collections.unmodifiableList(this.d);
                        this.f6665a &= -5;
                    }
                    methodOptions.h = this.d;
                }
                methodOptions.e = i;
                i();
                return methodOptions;
            }

            public final Builder a(MethodOptions methodOptions) {
                if (methodOptions == MethodOptions.j()) {
                    return this;
                }
                if (methodOptions.e()) {
                    boolean f = methodOptions.f();
                    this.f6665a |= 1;
                    this.b = f;
                    j();
                }
                if (methodOptions.g()) {
                    IdempotencyLevel h = methodOptions.h();
                    if (h == null) {
                        throw new NullPointerException();
                    }
                    this.f6665a |= 2;
                    this.c = h.a();
                    j();
                }
                if (this.e == null) {
                    if (!methodOptions.h.isEmpty()) {
                        if (this.d.isEmpty()) {
                            this.d = methodOptions.h;
                            this.f6665a &= -5;
                        } else {
                            if ((this.f6665a & 4) == 0) {
                                this.d = new ArrayList(this.d);
                                this.f6665a |= 4;
                            }
                            this.d.addAll(methodOptions.h);
                        }
                        j();
                    }
                } else if (!methodOptions.h.isEmpty()) {
                    if (!this.e.d()) {
                        this.e.a(methodOptions.h);
                    } else {
                        this.e.b();
                        this.e = null;
                        this.d = methodOptions.h;
                        this.f6665a &= -5;
                        this.e = null;
                    }
                }
                a((GeneratedMessageV3.ExtendableMessage) methodOptions);
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.ExtendableBuilder, com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int i = 0;
                while (true) {
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV3 = this.e;
                    if (i >= (repeatedFieldBuilderV3 == null ? this.d.size() : repeatedFieldBuilderV3.c())) {
                        return m();
                    }
                    RepeatedFieldBuilderV3<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> repeatedFieldBuilderV32 = this.e;
                    if (!(repeatedFieldBuilderV32 == null ? this.d.get(i) : repeatedFieldBuilderV32.a(i)).isInitialized()) {
                        return false;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.MethodOptions.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$MethodOptions> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.MethodOptions.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$MethodOptions r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.MethodOptions) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$MethodOptions r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.MethodOptions) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.MethodOptions.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$MethodOptions$Builder");
            }
        }

        public static MethodOptions j() {
            return j;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<MethodOptions> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class UninterpretedOption extends GeneratedMessageV3 implements UninterpretedOptionOrBuilder {
        private int e;
        private List<NamePart> f;
        private volatile Object g;
        private long h;
        private long i;
        private double j;
        private ByteString k;
        private volatile Object l;
        private byte m;
        private static final UninterpretedOption n = new UninterpretedOption();

        @Deprecated
        public static final Parser<UninterpretedOption> b = new AbstractParser<UninterpretedOption>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.UninterpretedOption.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new UninterpretedOption(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* loaded from: classes3.dex */
        public interface NamePartOrBuilder extends MessageOrBuilder {
        }

        /* synthetic */ UninterpretedOption(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ UninterpretedOption(GeneratedMessageV3.Builder builder, byte b2) {
            this(builder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return n;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return u();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == n ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return u();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return n;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == n ? new Builder(b2) : new Builder(b2).a(this);
        }

        private UninterpretedOption(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.m = (byte) -1;
        }

        private UninterpretedOption() {
            this.m = (byte) -1;
            this.f = Collections.emptyList();
            this.g = "";
            this.k = ByteString.f6635a;
            this.l = "";
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new UninterpretedOption();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private UninterpretedOption(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        try {
                            int a3 = codedInputStream.a();
                            if (a3 == 0) {
                                z = true;
                            } else if (a3 == 18) {
                                if (!(z2 & true)) {
                                    this.f = new ArrayList();
                                    z2 |= true;
                                }
                                this.f.add(codedInputStream.a(NamePart.b, extensionRegistryLite));
                            } else if (a3 == 26) {
                                ByteString l = codedInputStream.l();
                                this.e |= 1;
                                this.g = l;
                            } else if (a3 == 32) {
                                this.e |= 2;
                                this.h = codedInputStream.d();
                            } else if (a3 == 40) {
                                this.e |= 4;
                                this.i = codedInputStream.e();
                            } else if (a3 == 49) {
                                this.e |= 8;
                                this.j = codedInputStream.b();
                            } else if (a3 == 58) {
                                this.e |= 16;
                                this.k = codedInputStream.l();
                            } else if (a3 == 66) {
                                ByteString l2 = codedInputStream.l();
                                this.e = 32 | this.e;
                                this.l = l2;
                            } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                                z = true;
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw e.a(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.f = Collections.unmodifiableList(this.f);
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.R.a(UninterpretedOption.class, Builder.class);
        }

        /* loaded from: classes3.dex */
        public static final class NamePart extends GeneratedMessageV3 implements NamePartOrBuilder {
            private int e;
            private volatile Object f;
            private boolean g;
            private byte h;
            private static final NamePart i = new NamePart();

            @Deprecated
            public static final Parser<NamePart> b = new AbstractParser<NamePart>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.UninterpretedOption.NamePart.1
                @Override // com.uqm.crashsight.protobuf.Parser
                public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new NamePart(codedInputStream, extensionRegistryLite, (byte) 0);
                }
            };

            /* synthetic */ NamePart(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
                this(codedInputStream, extensionRegistryLite);
            }

            /* synthetic */ NamePart(GeneratedMessageV3.Builder builder, byte b2) {
                this(builder);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
                return new Builder(builderParent, (byte) 0);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* bridge */ /* synthetic */ MessageLite r() {
                return i;
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite
            public final /* synthetic */ MessageLite.Builder newBuilderForType() {
                return j();
            }

            @Override // com.uqm.crashsight.protobuf.Message
            public final /* synthetic */ Message.Builder p() {
                byte b2 = 0;
                return this == i ? new Builder(b2) : new Builder(b2).a(this);
            }

            @Override // com.uqm.crashsight.protobuf.Message
            public final /* synthetic */ Message.Builder q() {
                return j();
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* bridge */ /* synthetic */ Message r() {
                return i;
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite
            public final /* synthetic */ MessageLite.Builder toBuilder() {
                byte b2 = 0;
                return this == i ? new Builder(b2) : new Builder(b2).a(this);
            }

            private NamePart(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.h = (byte) -1;
            }

            private NamePart() {
                this.h = (byte) -1;
                this.f = "";
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final Object a() {
                return new NamePart();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final UnknownFieldSet b() {
                return this.d;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private NamePart(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                if (extensionRegistryLite == null) {
                    throw new NullPointerException();
                }
                UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            int a3 = codedInputStream.a();
                            if (a3 == 0) {
                                z = true;
                            } else if (a3 == 10) {
                                ByteString l = codedInputStream.l();
                                this.e |= 1;
                                this.f = l;
                            } else if (a3 == 16) {
                                this.e |= 2;
                                this.g = codedInputStream.i();
                            } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                                z = true;
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw e.a(this);
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2).a(this);
                        }
                    } finally {
                        this.d = a2.build();
                        P();
                    }
                }
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.T.a(NamePart.class, Builder.class);
            }

            public final boolean e() {
                return (this.e & 1) != 0;
            }

            private String i() {
                Object obj = this.f;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String f = byteString.f();
                if (byteString.g()) {
                    this.f = f;
                }
                return f;
            }

            public final boolean f() {
                return (this.e & 2) != 0;
            }

            public final boolean g() {
                return this.g;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b2 = this.h;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                if (!((this.e & 1) != 0)) {
                    this.h = (byte) 0;
                    return false;
                }
                if (!((this.e & 2) != 0)) {
                    this.h = (byte) 0;
                    return false;
                }
                this.h = (byte) 1;
                return true;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
            public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                if ((this.e & 1) != 0) {
                    Object obj = this.f;
                    if (obj instanceof String) {
                        codedOutputStream.a(1, (String) obj);
                    } else {
                        codedOutputStream.a(1, (ByteString) obj);
                    }
                }
                if ((this.e & 2) != 0) {
                    codedOutputStream.a(2, this.g);
                }
                this.d.writeTo(codedOutputStream);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
            public final int getSerializedSize() {
                int i2 = this.f6632a;
                if (i2 != -1) {
                    return i2;
                }
                int i3 = 0;
                if ((this.e & 1) != 0) {
                    Object obj = this.f;
                    i3 = 0 + (obj instanceof String ? CodedOutputStream.b(1, (String) obj) : CodedOutputStream.c(1, (ByteString) obj));
                }
                if ((this.e & 2) != 0) {
                    i3 += CodedOutputStream.b(2, this.g);
                }
                int serializedSize = i3 + this.d.getSerializedSize();
                this.f6632a = serializedSize;
                return serializedSize;
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage
            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof NamePart)) {
                    return super.equals(obj);
                }
                NamePart namePart = (NamePart) obj;
                if (((this.e & 1) != 0) != ((namePart.e & 1) != 0)) {
                    return false;
                }
                if (((this.e & 1) != 0) && !i().equals(namePart.i())) {
                    return false;
                }
                if (((this.e & 2) != 0) != ((namePart.e & 2) != 0)) {
                    return false;
                }
                return (!((this.e & 2) != 0) || this.g == namePart.g) && this.d.equals(namePart.d);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage
            public final int hashCode() {
                if (this.memoizedHashCode == 0) {
                    int hashCode = DescriptorProtos.S.hashCode() + 779;
                    if ((this.e & 1) != 0) {
                        hashCode = (((hashCode * 37) + 1) * 53) + i().hashCode();
                    }
                    if ((this.e & 2) != 0) {
                        hashCode = (((hashCode * 37) + 2) * 53) + Internal.a(this.g);
                    }
                    int hashCode2 = (hashCode * 29) + this.d.hashCode();
                    this.memoizedHashCode = hashCode2;
                    return hashCode2;
                }
                return this.memoizedHashCode;
            }

            private static Builder j() {
                NamePart namePart = i;
                byte b2 = 0;
                return namePart == namePart ? new Builder(b2) : new Builder(b2).a(namePart);
            }

            /* loaded from: classes3.dex */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NamePartOrBuilder {

                /* renamed from: a, reason: collision with root package name */
                private int f6674a;
                private Object b;
                private boolean c;

                /* synthetic */ Builder(byte b) {
                    this();
                }

                /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                    this(builderParent);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
                /* renamed from: a */
                public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                    if (message instanceof NamePart) {
                        return a((NamePart) message);
                    }
                    super.internalMergeFrom(message);
                    return this;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
                public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.a(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.c(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: b */
                public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.d(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: b */
                public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.a(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
                /* renamed from: build */
                public final /* synthetic */ MessageLite h() {
                    NamePart g = g();
                    if (g.isInitialized()) {
                        return g;
                    }
                    throw new UninitializedMessageException(MessageReflection.b(g));
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: c */
                public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.d(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.c(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
                /* renamed from: c */
                public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                    if (message instanceof NamePart) {
                        return a((NamePart) message);
                    }
                    super.internalMergeFrom(message);
                    return this;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ MessageLite.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.d(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.d(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: f */
                public final /* bridge */ /* synthetic */ Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
                /* renamed from: getDefaultInstanceForType */
                public final /* synthetic */ MessageLite r() {
                    return NamePart.h();
                }

                @Override // com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message h() {
                    NamePart g = g();
                    if (g.isInitialized()) {
                        return g;
                    }
                    throw new UninitializedMessageException(MessageReflection.b(g));
                }

                @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
                public final /* synthetic */ Message r() {
                    return NamePart.h();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                protected final GeneratedMessageV3.FieldAccessorTable c() {
                    return DescriptorProtos.T.a(NamePart.class, Builder.class);
                }

                private Builder() {
                    this.b = "";
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.b = "";
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
                public final Descriptors.Descriptor d() {
                    return DescriptorProtos.S;
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.uqm.crashsight.protobuf.Message.Builder
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public NamePart g() {
                    NamePart namePart = new NamePart((GeneratedMessageV3.Builder) this, (byte) (0 == true ? 1 : 0));
                    int i = this.f6674a;
                    int i2 = (i & 1) != 0 ? 1 : 0;
                    namePart.f = this.b;
                    if ((i & 2) != 0) {
                        namePart.g = this.c;
                        i2 |= 2;
                    }
                    namePart.e = i2;
                    i();
                    return namePart;
                }

                public final Builder a(NamePart namePart) {
                    if (namePart == NamePart.h()) {
                        return this;
                    }
                    if (namePart.e()) {
                        this.f6674a |= 1;
                        this.b = namePart.f;
                        j();
                    }
                    if (namePart.f()) {
                        boolean g = namePart.g();
                        this.f6674a |= 2;
                        this.c = g;
                        j();
                    }
                    j();
                    return this;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if ((this.f6674a & 1) != 0) {
                        return (this.f6674a & 2) != 0;
                    }
                    return false;
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public com.uqm.crashsight.protobuf.DescriptorProtos.UninterpretedOption.NamePart.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$UninterpretedOption$NamePart> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.UninterpretedOption.NamePart.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        com.uqm.crashsight.protobuf.DescriptorProtos$UninterpretedOption$NamePart r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.UninterpretedOption.NamePart) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        if (r3 == 0) goto Le
                        r2.a(r3)
                    Le:
                        return r2
                    Lf:
                        r3 = move-exception
                        goto L1f
                    L11:
                        r3 = move-exception
                        com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                        com.uqm.crashsight.protobuf.DescriptorProtos$UninterpretedOption$NamePart r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.UninterpretedOption.NamePart) r4     // Catch: java.lang.Throwable -> Lf
                        java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                        throw r3     // Catch: java.lang.Throwable -> L1d
                    L1d:
                        r3 = move-exception
                        r0 = r4
                    L1f:
                        if (r0 == 0) goto L24
                        r2.a(r0)
                    L24:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.UninterpretedOption.NamePart.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$UninterpretedOption$NamePart$Builder");
                }
            }

            public static NamePart h() {
                return i;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
            public final Parser<NamePart> getParserForType() {
                return b;
            }
        }

        public final boolean e() {
            return (this.e & 1) != 0;
        }

        private String s() {
            Object obj = this.g;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.g = f;
            }
            return f;
        }

        public final boolean f() {
            return (this.e & 2) != 0;
        }

        public final long g() {
            return this.h;
        }

        public final boolean h() {
            return (this.e & 4) != 0;
        }

        public final long i() {
            return this.i;
        }

        public final boolean j() {
            return (this.e & 8) != 0;
        }

        public final double k() {
            return this.j;
        }

        public final boolean l() {
            return (this.e & 16) != 0;
        }

        public final ByteString m() {
            return this.k;
        }

        public final boolean n() {
            return (this.e & 32) != 0;
        }

        private String t() {
            Object obj = this.l;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.l = f;
            }
            return f;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.m;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            for (int i = 0; i < this.f.size(); i++) {
                if (!this.f.get(i).isInitialized()) {
                    this.m = (byte) 0;
                    return false;
                }
            }
            this.m = (byte) 1;
            return true;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.f.size(); i++) {
                codedOutputStream.a(2, this.f.get(i));
            }
            if ((this.e & 1) != 0) {
                Object obj = this.g;
                if (obj instanceof String) {
                    codedOutputStream.a(3, (String) obj);
                } else {
                    codedOutputStream.a(3, (ByteString) obj);
                }
            }
            if ((this.e & 2) != 0) {
                codedOutputStream.b(4, this.h);
            }
            if ((this.e & 4) != 0) {
                codedOutputStream.a(5, this.i);
            }
            if ((this.e & 8) != 0) {
                codedOutputStream.a(6, this.j);
            }
            if ((this.e & 16) != 0) {
                codedOutputStream.a(7, this.k);
            }
            if ((this.e & 32) != 0) {
                Object obj2 = this.l;
                if (obj2 instanceof String) {
                    codedOutputStream.a(8, (String) obj2);
                } else {
                    codedOutputStream.a(8, (ByteString) obj2);
                }
            }
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.f6632a;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                i2 += CodedOutputStream.c(2, this.f.get(i3));
            }
            if ((this.e & 1) != 0) {
                Object obj = this.g;
                i2 += obj instanceof String ? CodedOutputStream.b(3, (String) obj) : CodedOutputStream.c(3, (ByteString) obj);
            }
            if ((this.e & 2) != 0) {
                i2 += CodedOutputStream.g(4, this.h);
            }
            if ((this.e & 4) != 0) {
                i2 += CodedOutputStream.f(5, this.i);
            }
            if ((this.e & 8) != 0) {
                i2 += CodedOutputStream.b(6, this.j);
            }
            if ((this.e & 16) != 0) {
                i2 += CodedOutputStream.c(7, this.k);
            }
            if ((this.e & 32) != 0) {
                Object obj2 = this.l;
                i2 += obj2 instanceof String ? CodedOutputStream.b(8, (String) obj2) : CodedOutputStream.c(8, (ByteString) obj2);
            }
            int serializedSize = i2 + this.d.getSerializedSize();
            this.f6632a = serializedSize;
            return serializedSize;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UninterpretedOption)) {
                return super.equals(obj);
            }
            UninterpretedOption uninterpretedOption = (UninterpretedOption) obj;
            if (!this.f.equals(uninterpretedOption.f)) {
                return false;
            }
            if (((this.e & 1) != 0) != ((uninterpretedOption.e & 1) != 0)) {
                return false;
            }
            if (((this.e & 1) != 0) && !s().equals(uninterpretedOption.s())) {
                return false;
            }
            if (((this.e & 2) != 0) != ((uninterpretedOption.e & 2) != 0)) {
                return false;
            }
            if (((this.e & 2) != 0) && this.h != uninterpretedOption.h) {
                return false;
            }
            if (((this.e & 4) != 0) != ((uninterpretedOption.e & 4) != 0)) {
                return false;
            }
            if (((this.e & 4) != 0) && this.i != uninterpretedOption.i) {
                return false;
            }
            if (((this.e & 8) != 0) != ((uninterpretedOption.e & 8) != 0)) {
                return false;
            }
            if (((this.e & 8) != 0) && Double.doubleToLongBits(this.j) != Double.doubleToLongBits(uninterpretedOption.j)) {
                return false;
            }
            if (((this.e & 16) != 0) != ((uninterpretedOption.e & 16) != 0)) {
                return false;
            }
            if (((this.e & 16) != 0) && !this.k.equals(uninterpretedOption.k)) {
                return false;
            }
            if (((this.e & 32) != 0) != ((uninterpretedOption.e & 32) != 0)) {
                return false;
            }
            return (!((this.e & 32) != 0) || t().equals(uninterpretedOption.t())) && this.d.equals(uninterpretedOption.d);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.Q.hashCode() + 779;
                if (this.f.size() > 0) {
                    hashCode = (((hashCode * 37) + 2) * 53) + this.f.hashCode();
                }
                if ((this.e & 1) != 0) {
                    hashCode = (((hashCode * 37) + 3) * 53) + s().hashCode();
                }
                if ((this.e & 2) != 0) {
                    hashCode = (((hashCode * 37) + 4) * 53) + Internal.a(this.h);
                }
                if ((this.e & 4) != 0) {
                    hashCode = (((hashCode * 37) + 5) * 53) + Internal.a(this.i);
                }
                if ((this.e & 8) != 0) {
                    hashCode = (((hashCode * 37) + 6) * 53) + Internal.a(Double.doubleToLongBits(this.j));
                }
                if ((this.e & 16) != 0) {
                    hashCode = (((hashCode * 37) + 7) * 53) + this.k.hashCode();
                }
                if ((this.e & 32) != 0) {
                    hashCode = (((hashCode * 37) + 8) * 53) + t().hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.d.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }
            return this.memoizedHashCode;
        }

        private static Builder u() {
            UninterpretedOption uninterpretedOption = n;
            byte b2 = 0;
            return uninterpretedOption == uninterpretedOption ? new Builder(b2) : new Builder(b2).a(uninterpretedOption);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UninterpretedOptionOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6673a;
            private List<NamePart> b;
            private RepeatedFieldBuilderV3<NamePart, NamePart.Builder, NamePartOrBuilder> c;
            private Object d;
            private long e;
            private long f;
            private double g;
            private ByteString h;
            private Object i;

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof UninterpretedOption) {
                    return a((UninterpretedOption) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                UninterpretedOption g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof UninterpretedOption) {
                    return a((UninterpretedOption) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return UninterpretedOption.o();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                UninterpretedOption g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return UninterpretedOption.o();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.R.a(UninterpretedOption.class, Builder.class);
            }

            private Builder() {
                this.b = Collections.emptyList();
                this.d = "";
                this.h = ByteString.f6635a;
                this.i = "";
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = Collections.emptyList();
                this.d = "";
                this.h = ByteString.f6635a;
                this.i = "";
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.Q;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public UninterpretedOption g() {
                UninterpretedOption uninterpretedOption = new UninterpretedOption((GeneratedMessageV3.Builder) this, (byte) (0 == true ? 1 : 0));
                int i = this.f6673a;
                RepeatedFieldBuilderV3<NamePart, NamePart.Builder, NamePartOrBuilder> repeatedFieldBuilderV3 = this.c;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) != 0) {
                        this.b = Collections.unmodifiableList(this.b);
                        this.f6673a &= -2;
                    }
                    uninterpretedOption.f = this.b;
                } else {
                    uninterpretedOption.f = repeatedFieldBuilderV3.e();
                }
                int i2 = (i & 2) != 0 ? 1 : 0;
                uninterpretedOption.g = this.d;
                if ((i & 4) != 0) {
                    uninterpretedOption.h = this.e;
                    i2 |= 2;
                }
                if ((i & 8) != 0) {
                    uninterpretedOption.i = this.f;
                    i2 |= 4;
                }
                if ((i & 16) != 0) {
                    uninterpretedOption.j = this.g;
                    i2 |= 8;
                }
                if ((i & 32) != 0) {
                    i2 |= 16;
                }
                uninterpretedOption.k = this.h;
                if ((i & 64) != 0) {
                    i2 |= 32;
                }
                uninterpretedOption.l = this.i;
                uninterpretedOption.e = i2;
                i();
                return uninterpretedOption;
            }

            public final Builder a(UninterpretedOption uninterpretedOption) {
                if (uninterpretedOption == UninterpretedOption.o()) {
                    return this;
                }
                if (this.c == null) {
                    if (!uninterpretedOption.f.isEmpty()) {
                        if (this.b.isEmpty()) {
                            this.b = uninterpretedOption.f;
                            this.f6673a &= -2;
                        } else {
                            if ((this.f6673a & 1) == 0) {
                                this.b = new ArrayList(this.b);
                                this.f6673a |= 1;
                            }
                            this.b.addAll(uninterpretedOption.f);
                        }
                        j();
                    }
                } else if (!uninterpretedOption.f.isEmpty()) {
                    if (!this.c.d()) {
                        this.c.a(uninterpretedOption.f);
                    } else {
                        this.c.b();
                        this.c = null;
                        this.b = uninterpretedOption.f;
                        this.f6673a &= -2;
                        this.c = null;
                    }
                }
                if (uninterpretedOption.e()) {
                    this.f6673a |= 2;
                    this.d = uninterpretedOption.g;
                    j();
                }
                if (uninterpretedOption.f()) {
                    long g = uninterpretedOption.g();
                    this.f6673a |= 4;
                    this.e = g;
                    j();
                }
                if (uninterpretedOption.h()) {
                    long i = uninterpretedOption.i();
                    this.f6673a |= 8;
                    this.f = i;
                    j();
                }
                if (uninterpretedOption.j()) {
                    double k = uninterpretedOption.k();
                    this.f6673a |= 16;
                    this.g = k;
                    j();
                }
                if (uninterpretedOption.l()) {
                    ByteString m = uninterpretedOption.m();
                    if (m == null) {
                        throw new NullPointerException();
                    }
                    this.f6673a |= 32;
                    this.h = m;
                    j();
                }
                if (uninterpretedOption.n()) {
                    this.f6673a |= 64;
                    this.i = uninterpretedOption.l;
                    j();
                }
                j();
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int i = 0;
                while (true) {
                    RepeatedFieldBuilderV3<NamePart, NamePart.Builder, NamePartOrBuilder> repeatedFieldBuilderV3 = this.c;
                    if (i >= (repeatedFieldBuilderV3 == null ? this.b.size() : repeatedFieldBuilderV3.c())) {
                        return true;
                    }
                    RepeatedFieldBuilderV3<NamePart, NamePart.Builder, NamePartOrBuilder> repeatedFieldBuilderV32 = this.c;
                    if (!(repeatedFieldBuilderV32 == null ? this.b.get(i) : repeatedFieldBuilderV32.a(i)).isInitialized()) {
                        return false;
                    }
                    i++;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.UninterpretedOption.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$UninterpretedOption> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.UninterpretedOption.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$UninterpretedOption r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.UninterpretedOption) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$UninterpretedOption r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.UninterpretedOption) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.UninterpretedOption.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$UninterpretedOption$Builder");
            }
        }

        public static UninterpretedOption o() {
            return n;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<UninterpretedOption> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class SourceCodeInfo extends GeneratedMessageV3 implements SourceCodeInfoOrBuilder {
        private List<Location> e;
        private byte f;
        private static final SourceCodeInfo g = new SourceCodeInfo();

        @Deprecated
        public static final Parser<SourceCodeInfo> b = new AbstractParser<SourceCodeInfo>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.SourceCodeInfo.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new SourceCodeInfo(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* loaded from: classes3.dex */
        public interface LocationOrBuilder extends MessageOrBuilder {
        }

        /* synthetic */ SourceCodeInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ SourceCodeInfo(GeneratedMessageV3.Builder builder, byte b2) {
            this(builder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return g;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return g();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == g ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return g();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return g;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == g ? new Builder(b2) : new Builder(b2).a(this);
        }

        private SourceCodeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.f = (byte) -1;
        }

        private SourceCodeInfo() {
            this.f = (byte) -1;
            this.e = Collections.emptyList();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new SourceCodeInfo();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SourceCodeInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 10) {
                            if (!(z2 & true)) {
                                this.e = new ArrayList();
                                z2 |= true;
                            }
                            this.e.add(codedInputStream.a(Location.b, extensionRegistryLite));
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.e = Collections.unmodifiableList(this.e);
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.V.a(SourceCodeInfo.class, Builder.class);
        }

        /* loaded from: classes3.dex */
        public static final class Location extends GeneratedMessageV3 implements LocationOrBuilder {
            private int e;
            private Internal.IntList f;
            private int g;
            private Internal.IntList h;
            private int i;
            private volatile Object j;
            private volatile Object k;
            private LazyStringList l;
            private byte m;
            private static final Location n = new Location();

            @Deprecated
            public static final Parser<Location> b = new AbstractParser<Location>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.SourceCodeInfo.Location.1
                @Override // com.uqm.crashsight.protobuf.Parser
                public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Location(codedInputStream, extensionRegistryLite, (byte) 0);
                }
            };

            /* synthetic */ Location(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
                this(codedInputStream, extensionRegistryLite);
            }

            /* synthetic */ Location(GeneratedMessageV3.Builder builder, byte b2) {
                this(builder);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
                return new Builder(builderParent, (byte) 0);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* bridge */ /* synthetic */ MessageLite r() {
                return n;
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite
            public final /* synthetic */ MessageLite.Builder newBuilderForType() {
                return j();
            }

            @Override // com.uqm.crashsight.protobuf.Message
            public final /* synthetic */ Message.Builder p() {
                byte b2 = 0;
                return this == n ? new Builder(b2) : new Builder(b2).a(this);
            }

            @Override // com.uqm.crashsight.protobuf.Message
            public final /* synthetic */ Message.Builder q() {
                return j();
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* bridge */ /* synthetic */ Message r() {
                return n;
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite
            public final /* synthetic */ MessageLite.Builder toBuilder() {
                byte b2 = 0;
                return this == n ? new Builder(b2) : new Builder(b2).a(this);
            }

            private Location(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.g = -1;
                this.i = -1;
                this.m = (byte) -1;
            }

            private Location() {
                this.g = -1;
                this.i = -1;
                this.m = (byte) -1;
                this.f = q.d();
                this.h = q.d();
                this.j = "";
                this.k = "";
                this.l = LazyStringArrayList.f6738a;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final Object a() {
                return new Location();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final UnknownFieldSet b() {
                return this.d;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Location(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                if (extensionRegistryLite == null) {
                    throw new NullPointerException();
                }
                UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
                boolean z = false;
                int i = 0;
                while (!z) {
                    try {
                        try {
                            int a3 = codedInputStream.a();
                            if (a3 == 0) {
                                z = true;
                            } else if (a3 == 8) {
                                if ((i & 1) == 0) {
                                    this.f = new q();
                                    i |= 1;
                                }
                                this.f.d(codedInputStream.f());
                            } else if (a3 == 10) {
                                int c = codedInputStream.c(codedInputStream.s());
                                if ((i & 1) == 0 && codedInputStream.w() > 0) {
                                    this.f = new q();
                                    i |= 1;
                                }
                                while (codedInputStream.w() > 0) {
                                    this.f.d(codedInputStream.f());
                                }
                                codedInputStream.d(c);
                            } else if (a3 == 16) {
                                if ((i & 2) == 0) {
                                    this.h = new q();
                                    i |= 2;
                                }
                                this.h.d(codedInputStream.f());
                            } else if (a3 == 18) {
                                int c2 = codedInputStream.c(codedInputStream.s());
                                if ((i & 2) == 0 && codedInputStream.w() > 0) {
                                    this.h = new q();
                                    i |= 2;
                                }
                                while (codedInputStream.w() > 0) {
                                    this.h.d(codedInputStream.f());
                                }
                                codedInputStream.d(c2);
                            } else if (a3 == 26) {
                                ByteString l = codedInputStream.l();
                                this.e |= 1;
                                this.j = l;
                            } else if (a3 == 34) {
                                ByteString l2 = codedInputStream.l();
                                this.e |= 2;
                                this.k = l2;
                            } else if (a3 == 50) {
                                ByteString l3 = codedInputStream.l();
                                if ((i & 16) == 0) {
                                    this.l = new LazyStringArrayList();
                                    i |= 16;
                                }
                                this.l.a(l3);
                            } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                                z = true;
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw e.a(this);
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2).a(this);
                        }
                    } finally {
                        if ((i & 1) != 0) {
                            this.f.b();
                        }
                        if ((i & 2) != 0) {
                            this.h.b();
                        }
                        if ((i & 16) != 0) {
                            this.l = this.l.e();
                        }
                        this.d = a2.build();
                        P();
                    }
                }
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.X.a(Location.class, Builder.class);
            }

            public final boolean e() {
                return (this.e & 1) != 0;
            }

            private String h() {
                Object obj = this.j;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String f = byteString.f();
                if (byteString.g()) {
                    this.j = f;
                }
                return f;
            }

            public final boolean f() {
                return (this.e & 2) != 0;
            }

            private String i() {
                Object obj = this.k;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String f = byteString.f();
                if (byteString.g()) {
                    this.k = f;
                }
                return f;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b2 = this.m;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.m = (byte) 1;
                return true;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
            public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if (this.f.size() > 0) {
                    codedOutputStream.c(10);
                    codedOutputStream.c(this.g);
                }
                for (int i = 0; i < this.f.size(); i++) {
                    codedOutputStream.b(this.f.b(i));
                }
                if (this.h.size() > 0) {
                    codedOutputStream.c(18);
                    codedOutputStream.c(this.i);
                }
                for (int i2 = 0; i2 < this.h.size(); i2++) {
                    codedOutputStream.b(this.h.b(i2));
                }
                if ((this.e & 1) != 0) {
                    Object obj = this.j;
                    if (obj instanceof String) {
                        codedOutputStream.a(3, (String) obj);
                    } else {
                        codedOutputStream.a(3, (ByteString) obj);
                    }
                }
                if ((this.e & 2) != 0) {
                    Object obj2 = this.k;
                    if (obj2 instanceof String) {
                        codedOutputStream.a(4, (String) obj2);
                    } else {
                        codedOutputStream.a(4, (ByteString) obj2);
                    }
                }
                for (int i3 = 0; i3 < this.l.size(); i3++) {
                    Object b2 = this.l.b(i3);
                    if (b2 instanceof String) {
                        codedOutputStream.a(6, (String) b2);
                    } else {
                        codedOutputStream.a(6, (ByteString) b2);
                    }
                }
                this.d.writeTo(codedOutputStream);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
            public final int getSerializedSize() {
                int i = this.f6632a;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                for (int i3 = 0; i3 < this.f.size(); i3++) {
                    i2 += CodedOutputStream.i(this.f.b(i3));
                }
                int i4 = i2 + 0;
                if (!this.f.isEmpty()) {
                    i4 = i4 + 1 + CodedOutputStream.i(i2);
                }
                this.g = i2;
                int i5 = 0;
                for (int i6 = 0; i6 < this.h.size(); i6++) {
                    i5 += CodedOutputStream.i(this.h.b(i6));
                }
                int i7 = i4 + i5;
                if (!this.h.isEmpty()) {
                    i7 = i7 + 1 + CodedOutputStream.i(i5);
                }
                this.i = i5;
                if ((this.e & 1) != 0) {
                    Object obj = this.j;
                    i7 += obj instanceof String ? CodedOutputStream.b(3, (String) obj) : CodedOutputStream.c(3, (ByteString) obj);
                }
                if ((this.e & 2) != 0) {
                    Object obj2 = this.k;
                    i7 += obj2 instanceof String ? CodedOutputStream.b(4, (String) obj2) : CodedOutputStream.c(4, (ByteString) obj2);
                }
                int i8 = 0;
                for (int i9 = 0; i9 < this.l.size(); i9++) {
                    Object b2 = this.l.b(i9);
                    i8 += b2 instanceof String ? CodedOutputStream.b((String) b2) : CodedOutputStream.b((ByteString) b2);
                }
                int size = i7 + i8 + (this.l.size() * 1) + this.d.getSerializedSize();
                this.f6632a = size;
                return size;
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage
            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Location)) {
                    return super.equals(obj);
                }
                Location location = (Location) obj;
                if (!this.f.equals(location.f) || !this.h.equals(location.h)) {
                    return false;
                }
                if (((this.e & 1) != 0) != ((location.e & 1) != 0)) {
                    return false;
                }
                if (((this.e & 1) != 0) && !h().equals(location.h())) {
                    return false;
                }
                if (((this.e & 2) != 0) != ((location.e & 2) != 0)) {
                    return false;
                }
                return (!((this.e & 2) != 0) || i().equals(location.i())) && this.l.equals(location.l) && this.d.equals(location.d);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage
            public final int hashCode() {
                if (this.memoizedHashCode == 0) {
                    int hashCode = DescriptorProtos.W.hashCode() + 779;
                    if (this.f.size() > 0) {
                        hashCode = (((hashCode * 37) + 1) * 53) + this.f.hashCode();
                    }
                    if (this.h.size() > 0) {
                        hashCode = (((hashCode * 37) + 2) * 53) + this.h.hashCode();
                    }
                    if ((this.e & 1) != 0) {
                        hashCode = (((hashCode * 37) + 3) * 53) + h().hashCode();
                    }
                    if ((this.e & 2) != 0) {
                        hashCode = (((hashCode * 37) + 4) * 53) + i().hashCode();
                    }
                    if (this.l.size() > 0) {
                        hashCode = (((hashCode * 37) + 6) * 53) + this.l.hashCode();
                    }
                    int hashCode2 = (hashCode * 29) + this.d.hashCode();
                    this.memoizedHashCode = hashCode2;
                    return hashCode2;
                }
                return this.memoizedHashCode;
            }

            private static Builder j() {
                Location location = n;
                byte b2 = 0;
                return location == location ? new Builder(b2) : new Builder(b2).a(location);
            }

            /* loaded from: classes3.dex */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LocationOrBuilder {

                /* renamed from: a, reason: collision with root package name */
                private int f6672a;
                private Internal.IntList b;
                private Internal.IntList c;
                private Object d;
                private Object e;
                private LazyStringList f;

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                /* synthetic */ Builder(byte b) {
                    this();
                }

                /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                    this(builderParent);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
                /* renamed from: a */
                public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                    if (message instanceof Location) {
                        return a((Location) message);
                    }
                    super.internalMergeFrom(message);
                    return this;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
                public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.a(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.c(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: b */
                public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.d(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: b */
                public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.a(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
                /* renamed from: build */
                public final /* synthetic */ MessageLite h() {
                    Location g = g();
                    if (g.isInitialized()) {
                        return g;
                    }
                    throw new UninitializedMessageException(MessageReflection.b(g));
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: c */
                public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.d(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.c(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
                /* renamed from: c */
                public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                    if (message instanceof Location) {
                        return a((Location) message);
                    }
                    super.internalMergeFrom(message);
                    return this;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ MessageLite.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.d(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.d(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: f */
                public final /* bridge */ /* synthetic */ Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
                /* renamed from: getDefaultInstanceForType */
                public final /* synthetic */ MessageLite r() {
                    return Location.g();
                }

                @Override // com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message h() {
                    Location g = g();
                    if (g.isInitialized()) {
                        return g;
                    }
                    throw new UninitializedMessageException(MessageReflection.b(g));
                }

                @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
                public final /* synthetic */ Message r() {
                    return Location.g();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                protected final GeneratedMessageV3.FieldAccessorTable c() {
                    return DescriptorProtos.X.a(Location.class, Builder.class);
                }

                private Builder() {
                    this.b = GeneratedMessageV3.O();
                    this.c = GeneratedMessageV3.O();
                    this.d = "";
                    this.e = "";
                    this.f = LazyStringArrayList.f6738a;
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.b = GeneratedMessageV3.O();
                    this.c = GeneratedMessageV3.O();
                    this.d = "";
                    this.e = "";
                    this.f = LazyStringArrayList.f6738a;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
                public final Descriptors.Descriptor d() {
                    return DescriptorProtos.W;
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.uqm.crashsight.protobuf.Message.Builder
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public Location g() {
                    Location location = new Location((GeneratedMessageV3.Builder) this, (byte) (0 == true ? 1 : 0));
                    int i = this.f6672a;
                    if ((i & 1) != 0) {
                        this.b.b();
                        this.f6672a &= -2;
                    }
                    location.f = this.b;
                    if ((this.f6672a & 2) != 0) {
                        this.c.b();
                        this.f6672a &= -3;
                    }
                    location.h = this.c;
                    int i2 = (i & 4) != 0 ? 1 : 0;
                    location.j = this.d;
                    if ((i & 8) != 0) {
                        i2 |= 2;
                    }
                    location.k = this.e;
                    if ((this.f6672a & 16) != 0) {
                        this.f = this.f.e();
                        this.f6672a &= -17;
                    }
                    location.l = this.f;
                    location.e = i2;
                    i();
                    return location;
                }

                public final Builder a(Location location) {
                    if (location == Location.g()) {
                        return this;
                    }
                    if (!location.f.isEmpty()) {
                        if (this.b.isEmpty()) {
                            this.b = location.f;
                            this.f6672a &= -2;
                        } else {
                            if ((this.f6672a & 1) == 0) {
                                this.b = GeneratedMessageV3.a(this.b);
                                this.f6672a |= 1;
                            }
                            this.b.addAll(location.f);
                        }
                        j();
                    }
                    if (!location.h.isEmpty()) {
                        if (this.c.isEmpty()) {
                            this.c = location.h;
                            this.f6672a &= -3;
                        } else {
                            if ((this.f6672a & 2) == 0) {
                                this.c = GeneratedMessageV3.a(this.c);
                                this.f6672a |= 2;
                            }
                            this.c.addAll(location.h);
                        }
                        j();
                    }
                    if (location.e()) {
                        this.f6672a |= 4;
                        this.d = location.j;
                        j();
                    }
                    if (location.f()) {
                        this.f6672a |= 8;
                        this.e = location.k;
                        j();
                    }
                    if (!location.l.isEmpty()) {
                        if (this.f.isEmpty()) {
                            this.f = location.l;
                            this.f6672a &= -17;
                        } else {
                            if ((this.f6672a & 16) == 0) {
                                this.f = new LazyStringArrayList(this.f);
                                this.f6672a |= 16;
                            }
                            this.f.addAll(location.l);
                        }
                        j();
                    }
                    j();
                    return this;
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public com.uqm.crashsight.protobuf.DescriptorProtos.SourceCodeInfo.Location.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$SourceCodeInfo$Location> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.SourceCodeInfo.Location.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        com.uqm.crashsight.protobuf.DescriptorProtos$SourceCodeInfo$Location r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.SourceCodeInfo.Location) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        if (r3 == 0) goto Le
                        r2.a(r3)
                    Le:
                        return r2
                    Lf:
                        r3 = move-exception
                        goto L1f
                    L11:
                        r3 = move-exception
                        com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                        com.uqm.crashsight.protobuf.DescriptorProtos$SourceCodeInfo$Location r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.SourceCodeInfo.Location) r4     // Catch: java.lang.Throwable -> Lf
                        java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                        throw r3     // Catch: java.lang.Throwable -> L1d
                    L1d:
                        r3 = move-exception
                        r0 = r4
                    L1f:
                        if (r0 == 0) goto L24
                        r2.a(r0)
                    L24:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.SourceCodeInfo.Location.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$SourceCodeInfo$Location$Builder");
                }
            }

            public static Location g() {
                return n;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
            public final Parser<Location> getParserForType() {
                return b;
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.f = (byte) 1;
            return true;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.e.size(); i++) {
                codedOutputStream.a(1, this.e.get(i));
            }
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.f6632a;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                i2 += CodedOutputStream.c(1, this.e.get(i3));
            }
            int serializedSize = i2 + this.d.getSerializedSize();
            this.f6632a = serializedSize;
            return serializedSize;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SourceCodeInfo)) {
                return super.equals(obj);
            }
            SourceCodeInfo sourceCodeInfo = (SourceCodeInfo) obj;
            return this.e.equals(sourceCodeInfo.e) && this.d.equals(sourceCodeInfo.d);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.U.hashCode() + 779;
                if (this.e.size() > 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + this.e.hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.d.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }
            return this.memoizedHashCode;
        }

        private static Builder g() {
            SourceCodeInfo sourceCodeInfo = g;
            byte b2 = 0;
            return sourceCodeInfo == sourceCodeInfo ? new Builder(b2) : new Builder(b2).a(sourceCodeInfo);
        }

        public static Builder a(SourceCodeInfo sourceCodeInfo) {
            SourceCodeInfo sourceCodeInfo2 = g;
            byte b2 = 0;
            return (sourceCodeInfo2 == sourceCodeInfo2 ? new Builder(b2) : new Builder(b2).a(sourceCodeInfo2)).a(sourceCodeInfo);
        }

        public final Builder e() {
            byte b2 = 0;
            return this == g ? new Builder(b2) : new Builder(b2).a(this);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SourceCodeInfoOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6671a;
            private List<Location> b;
            private RepeatedFieldBuilderV3<Location, Location.Builder, LocationOrBuilder> c;

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof SourceCodeInfo) {
                    return a((SourceCodeInfo) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                SourceCodeInfo g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof SourceCodeInfo) {
                    return a((SourceCodeInfo) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return SourceCodeInfo.f();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                SourceCodeInfo g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return SourceCodeInfo.f();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.V.a(SourceCodeInfo.class, Builder.class);
            }

            private Builder() {
                this.b = Collections.emptyList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = Collections.emptyList();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.U;
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final SourceCodeInfo g() {
                SourceCodeInfo sourceCodeInfo = new SourceCodeInfo((GeneratedMessageV3.Builder) this, (byte) 0);
                int i = this.f6671a;
                RepeatedFieldBuilderV3<Location, Location.Builder, LocationOrBuilder> repeatedFieldBuilderV3 = this.c;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) != 0) {
                        this.b = Collections.unmodifiableList(this.b);
                        this.f6671a &= -2;
                    }
                    sourceCodeInfo.e = this.b;
                } else {
                    sourceCodeInfo.e = repeatedFieldBuilderV3.e();
                }
                i();
                return sourceCodeInfo;
            }

            public final Builder a(SourceCodeInfo sourceCodeInfo) {
                if (sourceCodeInfo == SourceCodeInfo.f()) {
                    return this;
                }
                if (this.c == null) {
                    if (!sourceCodeInfo.e.isEmpty()) {
                        if (this.b.isEmpty()) {
                            this.b = sourceCodeInfo.e;
                            this.f6671a &= -2;
                        } else {
                            if ((this.f6671a & 1) == 0) {
                                this.b = new ArrayList(this.b);
                                this.f6671a |= 1;
                            }
                            this.b.addAll(sourceCodeInfo.e);
                        }
                        j();
                    }
                } else if (!sourceCodeInfo.e.isEmpty()) {
                    if (!this.c.d()) {
                        this.c.a(sourceCodeInfo.e);
                    } else {
                        this.c.b();
                        this.c = null;
                        this.b = sourceCodeInfo.e;
                        this.f6671a &= -2;
                        this.c = null;
                    }
                }
                j();
                return this;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.SourceCodeInfo.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$SourceCodeInfo> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.SourceCodeInfo.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$SourceCodeInfo r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.SourceCodeInfo) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$SourceCodeInfo r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.SourceCodeInfo) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.SourceCodeInfo.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$SourceCodeInfo$Builder");
            }
        }

        public static SourceCodeInfo f() {
            return g;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<SourceCodeInfo> getParserForType() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class GeneratedCodeInfo extends GeneratedMessageV3 implements GeneratedCodeInfoOrBuilder {
        private List<Annotation> e;
        private byte f;
        private static final GeneratedCodeInfo g = new GeneratedCodeInfo();

        @Deprecated
        public static final Parser<GeneratedCodeInfo> b = new AbstractParser<GeneratedCodeInfo>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.GeneratedCodeInfo.1
            @Override // com.uqm.crashsight.protobuf.Parser
            public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new GeneratedCodeInfo(codedInputStream, extensionRegistryLite, (byte) 0);
            }
        };

        /* loaded from: classes3.dex */
        public interface AnnotationOrBuilder extends MessageOrBuilder {
        }

        /* synthetic */ GeneratedCodeInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
            this(codedInputStream, extensionRegistryLite);
        }

        /* synthetic */ GeneratedCodeInfo(GeneratedMessageV3.Builder builder, byte b2) {
            this(builder);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
            return new Builder(builderParent, (byte) 0);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public final /* bridge */ /* synthetic */ MessageLite r() {
            return g;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder newBuilderForType() {
            return f();
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder p() {
            byte b2 = 0;
            return this == g ? new Builder(b2) : new Builder(b2).a(this);
        }

        @Override // com.uqm.crashsight.protobuf.Message
        public final /* synthetic */ Message.Builder q() {
            return f();
        }

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        public final /* bridge */ /* synthetic */ Message r() {
            return g;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite
        public final /* synthetic */ MessageLite.Builder toBuilder() {
            byte b2 = 0;
            return this == g ? new Builder(b2) : new Builder(b2).a(this);
        }

        private GeneratedCodeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.f = (byte) -1;
        }

        private GeneratedCodeInfo() {
            this.f = (byte) -1;
            this.e = Collections.emptyList();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final Object a() {
            return new GeneratedCodeInfo();
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
        public final UnknownFieldSet b() {
            return this.d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private GeneratedCodeInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this();
            if (extensionRegistryLite == null) {
                throw new NullPointerException();
            }
            UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
            boolean z = false;
            boolean z2 = false;
            while (!z) {
                try {
                    try {
                        int a3 = codedInputStream.a();
                        if (a3 == 0) {
                            z = true;
                        } else if (a3 == 10) {
                            if (!(z2 & true)) {
                                this.e = new ArrayList();
                                z2 |= true;
                            }
                            this.e.add(codedInputStream.a(Annotation.b, extensionRegistryLite));
                        } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                            z = true;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.a(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).a(this);
                    }
                } finally {
                    if (z2 & true) {
                        this.e = Collections.unmodifiableList(this.e);
                    }
                    this.d = a2.build();
                    P();
                }
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
        protected final GeneratedMessageV3.FieldAccessorTable c() {
            return DescriptorProtos.Z.a(GeneratedCodeInfo.class, Builder.class);
        }

        /* loaded from: classes3.dex */
        public static final class Annotation extends GeneratedMessageV3 implements AnnotationOrBuilder {
            private int e;
            private Internal.IntList f;
            private int g;
            private volatile Object h;
            private int i;
            private int j;
            private byte k;
            private static final Annotation l = new Annotation();

            @Deprecated
            public static final Parser<Annotation> b = new AbstractParser<Annotation>() { // from class: com.uqm.crashsight.protobuf.DescriptorProtos.GeneratedCodeInfo.Annotation.1
                @Override // com.uqm.crashsight.protobuf.Parser
                public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new Annotation(codedInputStream, extensionRegistryLite, (byte) 0);
                }
            };

            /* synthetic */ Annotation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, byte b2) throws InvalidProtocolBufferException {
                this(codedInputStream, extensionRegistryLite);
            }

            /* synthetic */ Annotation(GeneratedMessageV3.Builder builder, byte b2) {
                this(builder);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final /* synthetic */ Message.Builder a(GeneratedMessageV3.BuilderParent builderParent) {
                return new Builder(builderParent, (byte) 0);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* bridge */ /* synthetic */ MessageLite r() {
                return l;
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite
            public final /* synthetic */ MessageLite.Builder newBuilderForType() {
                return l();
            }

            @Override // com.uqm.crashsight.protobuf.Message
            public final /* synthetic */ Message.Builder p() {
                byte b2 = 0;
                return this == l ? new Builder(b2) : new Builder(b2).a(this);
            }

            @Override // com.uqm.crashsight.protobuf.Message
            public final /* synthetic */ Message.Builder q() {
                return l();
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* bridge */ /* synthetic */ Message r() {
                return l;
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite
            public final /* synthetic */ MessageLite.Builder toBuilder() {
                byte b2 = 0;
                return this == l ? new Builder(b2) : new Builder(b2).a(this);
            }

            private Annotation(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.g = -1;
                this.k = (byte) -1;
            }

            private Annotation() {
                this.g = -1;
                this.k = (byte) -1;
                this.f = q.d();
                this.h = "";
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final Object a() {
                return new Annotation();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final UnknownFieldSet b() {
                return this.d;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            private Annotation(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this();
                if (extensionRegistryLite == null) {
                    throw new NullPointerException();
                }
                UnknownFieldSet.Builder a2 = UnknownFieldSet.a();
                boolean z = false;
                boolean z2 = false;
                while (!z) {
                    try {
                        try {
                            try {
                                int a3 = codedInputStream.a();
                                if (a3 == 0) {
                                    z = true;
                                } else if (a3 == 8) {
                                    if (!(z2 & true)) {
                                        this.f = new q();
                                        z2 |= true;
                                    }
                                    this.f.d(codedInputStream.f());
                                } else if (a3 == 10) {
                                    int c = codedInputStream.c(codedInputStream.s());
                                    if (!(z2 & true) && codedInputStream.w() > 0) {
                                        this.f = new q();
                                        z2 |= true;
                                    }
                                    while (codedInputStream.w() > 0) {
                                        this.f.d(codedInputStream.f());
                                    }
                                    codedInputStream.d(c);
                                } else if (a3 == 18) {
                                    ByteString l2 = codedInputStream.l();
                                    this.e |= 1;
                                    this.h = l2;
                                } else if (a3 == 24) {
                                    this.e |= 2;
                                    this.i = codedInputStream.f();
                                } else if (a3 == 32) {
                                    this.e |= 4;
                                    this.j = codedInputStream.f();
                                } else if (!a(codedInputStream, a2, extensionRegistryLite, a3)) {
                                    z = true;
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw e.a(this);
                            }
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2).a(this);
                        }
                    } finally {
                        if (z2 & true) {
                            this.f.b();
                        }
                        this.d = a2.build();
                        P();
                    }
                }
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.ab.a(Annotation.class, Builder.class);
            }

            public final boolean e() {
                return (this.e & 1) != 0;
            }

            private String k() {
                Object obj = this.h;
                if (obj instanceof String) {
                    return (String) obj;
                }
                ByteString byteString = (ByteString) obj;
                String f = byteString.f();
                if (byteString.g()) {
                    this.h = f;
                }
                return f;
            }

            public final boolean f() {
                return (this.e & 2) != 0;
            }

            public final int g() {
                return this.i;
            }

            public final boolean h() {
                return (this.e & 4) != 0;
            }

            public final int i() {
                return this.j;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b2 = this.k;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                this.k = (byte) 1;
                return true;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
            public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if (this.f.size() > 0) {
                    codedOutputStream.c(10);
                    codedOutputStream.c(this.g);
                }
                for (int i = 0; i < this.f.size(); i++) {
                    codedOutputStream.b(this.f.b(i));
                }
                if ((this.e & 1) != 0) {
                    Object obj = this.h;
                    if (obj instanceof String) {
                        codedOutputStream.a(2, (String) obj);
                    } else {
                        codedOutputStream.a(2, (ByteString) obj);
                    }
                }
                if ((this.e & 2) != 0) {
                    codedOutputStream.b(3, this.i);
                }
                if ((this.e & 4) != 0) {
                    codedOutputStream.b(4, this.j);
                }
                this.d.writeTo(codedOutputStream);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
            public final int getSerializedSize() {
                int i = this.f6632a;
                if (i != -1) {
                    return i;
                }
                int i2 = 0;
                for (int i3 = 0; i3 < this.f.size(); i3++) {
                    i2 += CodedOutputStream.i(this.f.b(i3));
                }
                int i4 = i2 + 0;
                if (!this.f.isEmpty()) {
                    i4 = i4 + 1 + CodedOutputStream.i(i2);
                }
                this.g = i2;
                if ((this.e & 1) != 0) {
                    Object obj = this.h;
                    i4 += obj instanceof String ? CodedOutputStream.b(2, (String) obj) : CodedOutputStream.c(2, (ByteString) obj);
                }
                if ((this.e & 2) != 0) {
                    i4 += CodedOutputStream.h(3, this.i);
                }
                if ((this.e & 4) != 0) {
                    i4 += CodedOutputStream.h(4, this.j);
                }
                int serializedSize = i4 + this.d.getSerializedSize();
                this.f6632a = serializedSize;
                return serializedSize;
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage
            public final boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Annotation)) {
                    return super.equals(obj);
                }
                Annotation annotation = (Annotation) obj;
                if (!this.f.equals(annotation.f)) {
                    return false;
                }
                if (((this.e & 1) != 0) != ((annotation.e & 1) != 0)) {
                    return false;
                }
                if (((this.e & 1) != 0) && !k().equals(annotation.k())) {
                    return false;
                }
                if (((this.e & 2) != 0) != ((annotation.e & 2) != 0)) {
                    return false;
                }
                if (((this.e & 2) != 0) && this.i != annotation.i) {
                    return false;
                }
                if (((this.e & 4) != 0) != ((annotation.e & 4) != 0)) {
                    return false;
                }
                return (!((this.e & 4) != 0) || this.j == annotation.j) && this.d.equals(annotation.d);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage
            public final int hashCode() {
                if (this.memoizedHashCode == 0) {
                    int hashCode = DescriptorProtos.aa.hashCode() + 779;
                    if (this.f.size() > 0) {
                        hashCode = (((hashCode * 37) + 1) * 53) + this.f.hashCode();
                    }
                    if ((this.e & 1) != 0) {
                        hashCode = (((hashCode * 37) + 2) * 53) + k().hashCode();
                    }
                    if ((this.e & 2) != 0) {
                        hashCode = (((hashCode * 37) + 3) * 53) + this.i;
                    }
                    if ((this.e & 4) != 0) {
                        hashCode = (((hashCode * 37) + 4) * 53) + this.j;
                    }
                    int hashCode2 = (hashCode * 29) + this.d.hashCode();
                    this.memoizedHashCode = hashCode2;
                    return hashCode2;
                }
                return this.memoizedHashCode;
            }

            private static Builder l() {
                Annotation annotation = l;
                byte b2 = 0;
                return annotation == annotation ? new Builder(b2) : new Builder(b2).a(annotation);
            }

            /* loaded from: classes3.dex */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AnnotationOrBuilder {

                /* renamed from: a, reason: collision with root package name */
                private int f6661a;
                private Internal.IntList b;
                private Object c;
                private int d;
                private int e;

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                /* synthetic */ Builder(byte b) {
                    this();
                }

                /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                    this(builderParent);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
                /* renamed from: a */
                public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                    if (message instanceof Annotation) {
                        return a((Annotation) message);
                    }
                    super.internalMergeFrom(message);
                    return this;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
                public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.a(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: a */
                public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.c(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: b */
                public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.d(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: b */
                public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.a(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
                /* renamed from: build */
                public final /* synthetic */ MessageLite h() {
                    Annotation g = g();
                    if (g.isInitialized()) {
                        return g;
                    }
                    throw new UninitializedMessageException(MessageReflection.b(g));
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: c */
                public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.d(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.c(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
                /* renamed from: c */
                public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                    if (message instanceof Annotation) {
                        return a((Annotation) message);
                    }
                    super.internalMergeFrom(message);
                    return this;
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ MessageLite.Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
                /* renamed from: clone */
                public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                    return (Builder) super.d(fieldDescriptor, obj);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                    return (Builder) super.d(unknownFieldSet);
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                /* renamed from: f */
                public final /* bridge */ /* synthetic */ Builder mo11clone() {
                    return (Builder) super.mo11clone();
                }

                @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
                /* renamed from: getDefaultInstanceForType */
                public final /* synthetic */ MessageLite r() {
                    return Annotation.j();
                }

                @Override // com.uqm.crashsight.protobuf.Message.Builder
                public final /* synthetic */ Message h() {
                    Annotation g = g();
                    if (g.isInitialized()) {
                        return g;
                    }
                    throw new UninitializedMessageException(MessageReflection.b(g));
                }

                @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
                public final /* synthetic */ Message r() {
                    return Annotation.j();
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
                protected final GeneratedMessageV3.FieldAccessorTable c() {
                    return DescriptorProtos.ab.a(Annotation.class, Builder.class);
                }

                private Builder() {
                    this.b = GeneratedMessageV3.O();
                    this.c = "";
                }

                private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                    super(builderParent);
                    this.b = GeneratedMessageV3.O();
                    this.c = "";
                }

                @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
                public final Descriptors.Descriptor d() {
                    return DescriptorProtos.aa;
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.uqm.crashsight.protobuf.Message.Builder
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public Annotation g() {
                    Annotation annotation = new Annotation((GeneratedMessageV3.Builder) this, (byte) (0 == true ? 1 : 0));
                    int i = this.f6661a;
                    if ((i & 1) != 0) {
                        this.b.b();
                        this.f6661a &= -2;
                    }
                    annotation.f = this.b;
                    int i2 = (i & 2) != 0 ? 1 : 0;
                    annotation.h = this.c;
                    if ((i & 4) != 0) {
                        annotation.i = this.d;
                        i2 |= 2;
                    }
                    if ((i & 8) != 0) {
                        annotation.j = this.e;
                        i2 |= 4;
                    }
                    annotation.e = i2;
                    i();
                    return annotation;
                }

                public final Builder a(Annotation annotation) {
                    if (annotation == Annotation.j()) {
                        return this;
                    }
                    if (!annotation.f.isEmpty()) {
                        if (this.b.isEmpty()) {
                            this.b = annotation.f;
                            this.f6661a &= -2;
                        } else {
                            if ((this.f6661a & 1) == 0) {
                                this.b = GeneratedMessageV3.a(this.b);
                                this.f6661a |= 1;
                            }
                            this.b.addAll(annotation.f);
                        }
                        j();
                    }
                    if (annotation.e()) {
                        this.f6661a |= 2;
                        this.c = annotation.h;
                        j();
                    }
                    if (annotation.f()) {
                        int g = annotation.g();
                        this.f6661a |= 4;
                        this.d = g;
                        j();
                    }
                    if (annotation.h()) {
                        int i = annotation.i();
                        this.f6661a |= 8;
                        this.e = i;
                        j();
                    }
                    j();
                    return this;
                }

                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
                @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public com.uqm.crashsight.protobuf.DescriptorProtos.GeneratedCodeInfo.Annotation.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$GeneratedCodeInfo$Annotation> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.GeneratedCodeInfo.Annotation.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        com.uqm.crashsight.protobuf.DescriptorProtos$GeneratedCodeInfo$Annotation r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.GeneratedCodeInfo.Annotation) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                        if (r3 == 0) goto Le
                        r2.a(r3)
                    Le:
                        return r2
                    Lf:
                        r3 = move-exception
                        goto L1f
                    L11:
                        r3 = move-exception
                        com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                        com.uqm.crashsight.protobuf.DescriptorProtos$GeneratedCodeInfo$Annotation r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.GeneratedCodeInfo.Annotation) r4     // Catch: java.lang.Throwable -> Lf
                        java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                        throw r3     // Catch: java.lang.Throwable -> L1d
                    L1d:
                        r3 = move-exception
                        r0 = r4
                    L1f:
                        if (r0 == 0) goto L24
                        r2.a(r0)
                    L24:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.GeneratedCodeInfo.Annotation.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$GeneratedCodeInfo$Annotation$Builder");
                }
            }

            public static Annotation j() {
                return l;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
            public final Parser<Annotation> getParserForType() {
                return b;
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b2 = this.f;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.f = (byte) 1;
            return true;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.e.size(); i++) {
                codedOutputStream.a(1, this.e.get(i));
            }
            this.d.writeTo(codedOutputStream);
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.AbstractMessage, com.uqm.crashsight.protobuf.MessageLite
        public final int getSerializedSize() {
            int i = this.f6632a;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.e.size(); i3++) {
                i2 += CodedOutputStream.c(1, this.e.get(i3));
            }
            int serializedSize = i2 + this.d.getSerializedSize();
            this.f6632a = serializedSize;
            return serializedSize;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GeneratedCodeInfo)) {
                return super.equals(obj);
            }
            GeneratedCodeInfo generatedCodeInfo = (GeneratedCodeInfo) obj;
            return this.e.equals(generatedCodeInfo.e) && this.d.equals(generatedCodeInfo.d);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessage
        public final int hashCode() {
            if (this.memoizedHashCode == 0) {
                int hashCode = DescriptorProtos.Y.hashCode() + 779;
                if (this.e.size() > 0) {
                    hashCode = (((hashCode * 37) + 1) * 53) + this.e.hashCode();
                }
                int hashCode2 = (hashCode * 29) + this.d.hashCode();
                this.memoizedHashCode = hashCode2;
                return hashCode2;
            }
            return this.memoizedHashCode;
        }

        private static Builder f() {
            GeneratedCodeInfo generatedCodeInfo = g;
            byte b2 = 0;
            return generatedCodeInfo == generatedCodeInfo ? new Builder(b2) : new Builder(b2).a(generatedCodeInfo);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GeneratedCodeInfoOrBuilder {

            /* renamed from: a, reason: collision with root package name */
            private int f6662a;
            private List<Annotation> b;
            private RepeatedFieldBuilderV3<Annotation, Annotation.Builder, AnnotationOrBuilder> c;

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            /* synthetic */ Builder(byte b) {
                this();
            }

            /* synthetic */ Builder(GeneratedMessageV3.BuilderParent builderParent, byte b) {
                this(builderParent);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* synthetic */ AbstractMessage.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ AbstractMessage.Builder internalMergeFrom(Message message) {
                if (message instanceof GeneratedCodeInfo) {
                    return a((GeneratedCodeInfo) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder
            public final /* synthetic */ AbstractMessage.Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: a */
            public final /* bridge */ /* synthetic */ Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: b */
            public final /* bridge */ /* synthetic */ Builder a(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.a(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: build */
            public final /* synthetic */ MessageLite h() {
                GeneratedCodeInfo g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: c */
            public final /* bridge */ /* synthetic */ Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.c(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: c */
            public final /* synthetic */ Message.Builder internalMergeFrom(Message message) {
                if (message instanceof GeneratedCodeInfo) {
                    return a((GeneratedCodeInfo) message);
                }
                super.internalMergeFrom(message);
                return this;
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ AbstractMessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ MessageLite.Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public final /* synthetic */ Object mo11clone() throws CloneNotSupportedException {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
                return (Builder) super.d(fieldDescriptor, obj);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message.Builder d(UnknownFieldSet unknownFieldSet) {
                return (Builder) super.d(unknownFieldSet);
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            /* renamed from: f */
            public final /* bridge */ /* synthetic */ Builder mo11clone() {
                return (Builder) super.mo11clone();
            }

            @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
            /* renamed from: getDefaultInstanceForType */
            public final /* synthetic */ MessageLite r() {
                return GeneratedCodeInfo.e();
            }

            @Override // com.uqm.crashsight.protobuf.Message.Builder
            public final /* synthetic */ Message h() {
                GeneratedCodeInfo g = g();
                if (g.isInitialized()) {
                    return g;
                }
                throw new UninitializedMessageException(MessageReflection.b(g));
            }

            @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
            public final /* synthetic */ Message r() {
                return GeneratedCodeInfo.e();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder
            protected final GeneratedMessageV3.FieldAccessorTable c() {
                return DescriptorProtos.Z.a(GeneratedCodeInfo.class, Builder.class);
            }

            private Builder() {
                this.b = Collections.emptyList();
            }

            private Builder(GeneratedMessageV3.BuilderParent builderParent) {
                super(builderParent);
                this.b = Collections.emptyList();
            }

            @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3.Builder, com.uqm.crashsight.protobuf.Message.Builder, com.uqm.crashsight.protobuf.MessageOrBuilder
            public final Descriptors.Descriptor d() {
                return DescriptorProtos.Y;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.uqm.crashsight.protobuf.Message.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public GeneratedCodeInfo g() {
                GeneratedCodeInfo generatedCodeInfo = new GeneratedCodeInfo((GeneratedMessageV3.Builder) this, (byte) 0);
                int i = this.f6662a;
                RepeatedFieldBuilderV3<Annotation, Annotation.Builder, AnnotationOrBuilder> repeatedFieldBuilderV3 = this.c;
                if (repeatedFieldBuilderV3 == null) {
                    if ((i & 1) != 0) {
                        this.b = Collections.unmodifiableList(this.b);
                        this.f6662a &= -2;
                    }
                    generatedCodeInfo.e = this.b;
                } else {
                    generatedCodeInfo.e = repeatedFieldBuilderV3.e();
                }
                i();
                return generatedCodeInfo;
            }

            public final Builder a(GeneratedCodeInfo generatedCodeInfo) {
                if (generatedCodeInfo == GeneratedCodeInfo.e()) {
                    return this;
                }
                if (this.c == null) {
                    if (!generatedCodeInfo.e.isEmpty()) {
                        if (this.b.isEmpty()) {
                            this.b = generatedCodeInfo.e;
                            this.f6662a &= -2;
                        } else {
                            if ((this.f6662a & 1) == 0) {
                                this.b = new ArrayList(this.b);
                                this.f6662a |= 1;
                            }
                            this.b.addAll(generatedCodeInfo.e);
                        }
                        j();
                    }
                } else if (!generatedCodeInfo.e.isEmpty()) {
                    if (!this.c.d()) {
                        this.c.a(generatedCodeInfo.e);
                    } else {
                        this.c.b();
                        this.c = null;
                        this.b = generatedCodeInfo.e;
                        this.f6662a &= -2;
                        this.c = null;
                    }
                }
                j();
                return this;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0021  */
            @Override // com.uqm.crashsight.protobuf.AbstractMessage.Builder, com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public com.uqm.crashsight.protobuf.DescriptorProtos.GeneratedCodeInfo.Builder mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream r3, com.uqm.crashsight.protobuf.ExtensionRegistryLite r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    com.uqm.crashsight.protobuf.Parser<com.uqm.crashsight.protobuf.DescriptorProtos$GeneratedCodeInfo> r1 = com.uqm.crashsight.protobuf.DescriptorProtos.GeneratedCodeInfo.b     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.a(r3, r4)     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    com.uqm.crashsight.protobuf.DescriptorProtos$GeneratedCodeInfo r3 = (com.uqm.crashsight.protobuf.DescriptorProtos.GeneratedCodeInfo) r3     // Catch: java.lang.Throwable -> Lf com.uqm.crashsight.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.a(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1f
                L11:
                    r3 = move-exception
                    com.uqm.crashsight.protobuf.MessageLite r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                    com.uqm.crashsight.protobuf.DescriptorProtos$GeneratedCodeInfo r4 = (com.uqm.crashsight.protobuf.DescriptorProtos.GeneratedCodeInfo) r4     // Catch: java.lang.Throwable -> Lf
                    java.io.IOException r3 = r3.b()     // Catch: java.lang.Throwable -> L1d
                    throw r3     // Catch: java.lang.Throwable -> L1d
                L1d:
                    r3 = move-exception
                    r0 = r4
                L1f:
                    if (r0 == 0) goto L24
                    r2.a(r0)
                L24:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.DescriptorProtos.GeneratedCodeInfo.Builder.mergeFrom(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.ExtensionRegistryLite):com.uqm.crashsight.protobuf.DescriptorProtos$GeneratedCodeInfo$Builder");
            }
        }

        public static GeneratedCodeInfo e() {
            return g;
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageV3, com.uqm.crashsight.protobuf.MessageLite
        public final Parser<GeneratedCodeInfo> getParserForType() {
            return b;
        }
    }

    static {
        Descriptors.FileDescriptor a2 = Descriptors.FileDescriptor.a(new String[]{"\n google/protobuf/descriptor.proto\u0012\u000fgoogle.protobuf\"G\n\u0011FileDescriptorSet\u00122\n\u0004file\u0018\u0001 \u0003(\u000b2$.google.protobuf.FileDescriptorProto\"Û\u0003\n\u0013FileDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007package\u0018\u0002 \u0001(\t\u0012\u0012\n\ndependency\u0018\u0003 \u0003(\t\u0012\u0019\n\u0011public_dependency\u0018\n \u0003(\u0005\u0012\u0017\n\u000fweak_dependency\u0018\u000b \u0003(\u0005\u00126\n\fmessage_type\u0018\u0004 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0005 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u00128\n\u0007service\u0018\u0006 \u0003(\u000b2'.google.protobuf.ServiceDescriptorProto\u00128\n\textension\u0018\u0007 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u0012-\n\u0007options\u0018\b \u0001(\u000b2\u001c.google.protobuf.FileOptions\u00129\n\u0010source_code_info\u0018\t \u0001(\u000b2\u001f.google.protobuf.SourceCodeInfo\u0012\u000e\n\u0006syntax\u0018\f \u0001(\t\"©\u0005\n\u000fDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00124\n\u0005field\u0018\u0002 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00128\n\textension\u0018\u0006 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00125\n\u000bnested_type\u0018\u0003 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0004 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u0012H\n\u000fextension_range\u0018\u0005 \u0003(\u000b2/.google.protobuf.DescriptorProto.ExtensionRange\u00129\n\noneof_decl\u0018\b \u0003(\u000b2%.google.protobuf.OneofDescriptorProto\u00120\n\u0007options\u0018\u0007 \u0001(\u000b2\u001f.google.protobuf.MessageOptions\u0012F\n\u000ereserved_range\u0018\t \u0003(\u000b2..google.protobuf.DescriptorProto.ReservedRange\u0012\u0015\n\rreserved_name\u0018\n \u0003(\t\u001ae\n\u000eExtensionRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\u00127\n\u0007options\u0018\u0003 \u0001(\u000b2&.google.protobuf.ExtensionRangeOptions\u001a+\n\rReservedRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"g\n\u0015ExtensionRangeOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"¼\u0005\n\u0014FieldDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0003 \u0001(\u0005\u0012:\n\u0005label\u0018\u0004 \u0001(\u000e2+.google.protobuf.FieldDescriptorProto.Label\u00128\n\u0004type\u0018\u0005 \u0001(\u000e2*.google.protobuf.FieldDescriptorProto.Type\u0012\u0011\n\ttype_name\u0018\u0006 \u0001(\t\u0012\u0010\n\bextendee\u0018\u0002 \u0001(\t\u0012\u0015\n\rdefault_value\u0018\u0007 \u0001(\t\u0012\u0013\n\u000boneof_index\u0018\t \u0001(\u0005\u0012\u0011\n\tjson_name\u0018\n \u0001(\t\u0012.\n\u0007options\u0018\b \u0001(\u000b2\u001d.google.protobuf.FieldOptions\"¶\u0002\n\u0004Type\u0012\u000f\n\u000bTYPE_DOUBLE\u0010\u0001\u0012\u000e\n\nTYPE_FLOAT\u0010\u0002\u0012\u000e\n\nTYPE_INT64\u0010\u0003\u0012\u000f\n\u000bTYPE_UINT64\u0010\u0004\u0012\u000e\n\nTYPE_INT32\u0010\u0005\u0012\u0010\n\fTYPE_FIXED64\u0010\u0006\u0012\u0010\n\fTYPE_FIXED32\u0010\u0007\u0012\r\n\tTYPE_BOOL\u0010\b\u0012\u000f\n\u000bTYPE_STRING\u0010\t\u0012\u000e\n\nTYPE_GROUP\u0010\n\u0012\u0010\n\fTYPE_MESSAGE\u0010\u000b\u0012\u000e\n\nTYPE_BYTES\u0010\f\u0012\u000f\n\u000bTYPE_UINT32\u0010\r\u0012\r\n\tTYPE_ENUM\u0010\u000e\u0012\u0011\n\rTYPE_SFIXED32\u0010\u000f\u0012\u0011\n\rTYPE_SFIXED64\u0010\u0010\u0012\u000f\n\u000bTYPE_SINT32\u0010\u0011\u0012\u000f\n\u000bTYPE_SINT64\u0010\u0012\"C\n\u0005Label\u0012\u0012\n\u000eLABEL_OPTIONAL\u0010\u0001\u0012\u0012\n\u000eLABEL_REQUIRED\u0010\u0002\u0012\u0012\n\u000eLABEL_REPEATED\u0010\u0003\"T\n\u0014OneofDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012.\n\u0007options\u0018\u0002 \u0001(\u000b2\u001d.google.protobuf.OneofOptions\"¤\u0002\n\u0013EnumDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00128\n\u0005value\u0018\u0002 \u0003(\u000b2).google.protobuf.EnumValueDescriptorProto\u0012-\n\u0007options\u0018\u0003 \u0001(\u000b2\u001c.google.protobuf.EnumOptions\u0012N\n\u000ereserved_range\u0018\u0004 \u0003(\u000b26.google.protobuf.EnumDescriptorProto.EnumReservedRange\u0012\u0015\n\rreserved_name\u0018\u0005 \u0003(\t\u001a/\n\u0011EnumReservedRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"l\n\u0018EnumValueDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0002 \u0001(\u0005\u00122\n\u0007options\u0018\u0003 \u0001(\u000b2!.google.protobuf.EnumValueOptions\"\u0090\u0001\n\u0016ServiceDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00126\n\u0006method\u0018\u0002 \u0003(\u000b2&.google.protobuf.MethodDescriptorProto\u00120\n\u0007options\u0018\u0003 \u0001(\u000b2\u001f.google.protobuf.ServiceOptions\"Á\u0001\n\u0015MethodDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0012\n\ninput_type\u0018\u0002 \u0001(\t\u0012\u0013\n\u000boutput_type\u0018\u0003 \u0001(\t\u0012/\n\u0007options\u0018\u0004 \u0001(\u000b2\u001e.google.protobuf.MethodOptions\u0012\u001f\n\u0010client_streaming\u0018\u0005 \u0001(\b:\u0005false\u0012\u001f\n\u0010server_streaming\u0018\u0006 \u0001(\b:\u0005false\"¦\u0006\n\u000bFileOptions\u0012\u0014\n\fjava_package\u0018\u0001 \u0001(\t\u0012\u001c\n\u0014java_outer_classname\u0018\b \u0001(\t\u0012\"\n\u0013java_multiple_files\u0018\n \u0001(\b:\u0005false\u0012)\n\u001djava_generate_equals_and_hash\u0018\u0014 \u0001(\bB\u0002\u0018\u0001\u0012%\n\u0016java_string_check_utf8\u0018\u001b \u0001(\b:\u0005false\u0012F\n\foptimize_for\u0018\t \u0001(\u000e2).google.protobuf.FileOptions.OptimizeMode:\u0005SPEED\u0012\u0012\n\ngo_package\u0018\u000b \u0001(\t\u0012\"\n\u0013cc_generic_services\u0018\u0010 \u0001(\b:\u0005false\u0012$\n\u0015java_generic_services\u0018\u0011 \u0001(\b:\u0005false\u0012\"\n\u0013py_generic_services\u0018\u0012 \u0001(\b:\u0005false\u0012#\n\u0014php_generic_services\u0018* \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0017 \u0001(\b:\u0005false\u0012\u001f\n\u0010cc_enable_arenas\u0018\u001f \u0001(\b:\u0005false\u0012\u0019\n\u0011objc_class_prefix\u0018$ \u0001(\t\u0012\u0018\n\u0010csharp_namespace\u0018% \u0001(\t\u0012\u0014\n\fswift_prefix\u0018' \u0001(\t\u0012\u0018\n\u0010php_class_prefix\u0018( \u0001(\t\u0012\u0015\n\rphp_namespace\u0018) \u0001(\t\u0012\u001e\n\u0016php_metadata_namespace\u0018, \u0001(\t\u0012\u0014\n\fruby_package\u0018- \u0001(\t\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode\u0012\t\n\u0005SPEED\u0010\u0001\u0012\r\n\tCODE_SIZE\u0010\u0002\u0012\u0010\n\fLITE_RUNTIME\u0010\u0003*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002J\u0004\b&\u0010'\"ò\u0001\n\u000eMessageOptions\u0012&\n\u0017message_set_wire_format\u0018\u0001 \u0001(\b:\u0005false\u0012.\n\u001fno_standard_descriptor_accessor\u0018\u0002 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0011\n\tmap_entry\u0018\u0007 \u0001(\b\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002J\u0004\b\b\u0010\tJ\u0004\b\t\u0010\n\"\u009e\u0003\n\fFieldOptions\u0012:\n\u0005ctype\u0018\u0001 \u0001(\u000e2#.google.protobuf.FieldOptions.CType:\u0006STRING\u0012\u000e\n\u0006packed\u0018\u0002 \u0001(\b\u0012?\n\u0006jstype\u0018\u0006 \u0001(\u000e2$.google.protobuf.FieldOptions.JSType:\tJS_NORMAL\u0012\u0013\n\u0004lazy\u0018\u0005 \u0001(\b:\u0005false\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u0013\n\u0004weak\u0018\n \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"/\n\u0005CType\u0012\n\n\u0006STRING\u0010\u0000\u0012\b\n\u0004CORD\u0010\u0001\u0012\u0010\n\fSTRING_PIECE\u0010\u0002\"5\n\u0006JSType\u0012\r\n\tJS_NORMAL\u0010\u0000\u0012\r\n\tJS_STRING\u0010\u0001\u0012\r\n\tJS_NUMBER\u0010\u0002*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002J\u0004\b\u0004\u0010\u0005\"^\n\fOneofOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u0093\u0001\n\u000bEnumOptions\u0012\u0013\n\u000ballow_alias\u0018\u0002 \u0001(\b\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002J\u0004\b\u0005\u0010\u0006\"}\n\u0010EnumValueOptions\u0012\u0019\n\ndeprecated\u0018\u0001 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"{\n\u000eServiceOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u00ad\u0002\n\rMethodOptions\u0012\u0019\n\ndeprecated\u0018! \u0001(\b:\u0005false\u0012_\n\u0011idempotency_level\u0018\" \u0001(\u000e2/.google.protobuf.MethodOptions.IdempotencyLevel:\u0013IDEMPOTENCY_UNKNOWN\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"P\n\u0010IdempotencyLevel\u0012\u0017\n\u0013IDEMPOTENCY_UNKNOWN\u0010\u0000\u0012\u0013\n\u000fNO_SIDE_EFFECTS\u0010\u0001\u0012\u000e\n\nIDEMPOTENT\u0010\u0002*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u009e\u0002\n\u0013UninterpretedOption\u0012;\n\u0004name\u0018\u0002 \u0003(\u000b2-.google.protobuf.UninterpretedOption.NamePart\u0012\u0018\n\u0010identifier_value\u0018\u0003 \u0001(\t\u0012\u001a\n\u0012positive_int_value\u0018\u0004 \u0001(\u0004\u0012\u001a\n\u0012negative_int_value\u0018\u0005 \u0001(\u0003\u0012\u0014\n\fdouble_value\u0018\u0006 \u0001(\u0001\u0012\u0014\n\fstring_value\u0018\u0007 \u0001(\f\u0012\u0017\n\u000faggregate_value\u0018\b \u0001(\t\u001a3\n\bNamePart\u0012\u0011\n\tname_part\u0018\u0001 \u0002(\t\u0012\u0014\n\fis_extension\u0018\u0002 \u0002(\b\"Õ\u0001\n\u000eSourceCodeInfo\u0012:\n\blocation\u0018\u0001 \u0003(\u000b2(.google.protobuf.SourceCodeInfo.Location\u001a\u0086\u0001\n\bLocation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0010\n\u0004span\u0018\u0002 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0018\n\u0010leading_comments\u0018\u0003 \u0001(\t\u0012\u0019\n\u0011trailing_comments\u0018\u0004 \u0001(\t\u0012!\n\u0019leading_detached_comments\u0018\u0006 \u0003(\t\"§\u0001\n\u0011GeneratedCodeInfo\u0012A\n\nannotation\u0018\u0001 \u0003(\u000b2-.google.protobuf.GeneratedCodeInfo.Annotation\u001aO\n\nAnnotation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0013\n\u000bsource_file\u0018\u0002 \u0001(\t\u0012\r\n\u0005begin\u0018\u0003 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0004 \u0001(\u0005B\u008f\u0001\n\u0013com.uqm.crashsight.protobufB\u0010DescriptorProtosH\u0001Z>github.com/golang/protobuf/protoc-gen-go/descriptor;descriptorø\u0001\u0001¢\u0002\u0003GPBª\u0002\u001aGoogle.Protobuf.Reflection"}, new Descriptors.FileDescriptor[0]);
        ac = a2;
        f6641a = a2.g().get(0);
        b = new GeneratedMessageV3.FieldAccessorTable(f6641a, new String[]{"File"});
        c = ac.g().get(1);
        d = new GeneratedMessageV3.FieldAccessorTable(c, new String[]{"Name", "Package", "Dependency", "PublicDependency", "WeakDependency", "MessageType", "EnumType", "Service", "Extension", "Options", "SourceCodeInfo", "Syntax"});
        e = ac.g().get(2);
        f = new GeneratedMessageV3.FieldAccessorTable(e, new String[]{"Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "OneofDecl", "Options", "ReservedRange", "ReservedName"});
        g = e.h().get(0);
        h = new GeneratedMessageV3.FieldAccessorTable(g, new String[]{"Start", "End", "Options"});
        i = e.h().get(1);
        j = new GeneratedMessageV3.FieldAccessorTable(i, new String[]{"Start", "End"});
        k = ac.g().get(3);
        l = new GeneratedMessageV3.FieldAccessorTable(k, new String[]{"UninterpretedOption"});
        m = ac.g().get(4);
        n = new GeneratedMessageV3.FieldAccessorTable(m, new String[]{"Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "OneofIndex", "JsonName", "Options"});
        o = ac.g().get(5);
        p = new GeneratedMessageV3.FieldAccessorTable(o, new String[]{"Name", "Options"});
        q = ac.g().get(6);
        r = new GeneratedMessageV3.FieldAccessorTable(q, new String[]{"Name", "Value", "Options", "ReservedRange", "ReservedName"});
        s = q.h().get(0);
        t = new GeneratedMessageV3.FieldAccessorTable(s, new String[]{"Start", "End"});
        u = ac.g().get(7);
        v = new GeneratedMessageV3.FieldAccessorTable(u, new String[]{"Name", "Number", "Options"});
        w = ac.g().get(8);
        x = new GeneratedMessageV3.FieldAccessorTable(w, new String[]{"Name", "Method", "Options"});
        y = ac.g().get(9);
        z = new GeneratedMessageV3.FieldAccessorTable(y, new String[]{"Name", "InputType", "OutputType", "Options", "ClientStreaming", "ServerStreaming"});
        A = ac.g().get(10);
        B = new GeneratedMessageV3.FieldAccessorTable(A, new String[]{"JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "JavaStringCheckUtf8", "OptimizeFor", "GoPackage", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "PhpGenericServices", "Deprecated", "CcEnableArenas", "ObjcClassPrefix", "CsharpNamespace", "SwiftPrefix", "PhpClassPrefix", "PhpNamespace", "PhpMetadataNamespace", "RubyPackage", "UninterpretedOption"});
        C = ac.g().get(11);
        D = new GeneratedMessageV3.FieldAccessorTable(C, new String[]{"MessageSetWireFormat", "NoStandardDescriptorAccessor", "Deprecated", "MapEntry", "UninterpretedOption"});
        E = ac.g().get(12);
        F = new GeneratedMessageV3.FieldAccessorTable(E, new String[]{"Ctype", "Packed", "Jstype", "Lazy", "Deprecated", "Weak", "UninterpretedOption"});
        G = ac.g().get(13);
        H = new GeneratedMessageV3.FieldAccessorTable(G, new String[]{"UninterpretedOption"});
        I = ac.g().get(14);
        J = new GeneratedMessageV3.FieldAccessorTable(I, new String[]{"AllowAlias", "Deprecated", "UninterpretedOption"});
        K = ac.g().get(15);
        L = new GeneratedMessageV3.FieldAccessorTable(K, new String[]{"Deprecated", "UninterpretedOption"});
        M = ac.g().get(16);
        N = new GeneratedMessageV3.FieldAccessorTable(M, new String[]{"Deprecated", "UninterpretedOption"});
        O = ac.g().get(17);
        P = new GeneratedMessageV3.FieldAccessorTable(O, new String[]{"Deprecated", "IdempotencyLevel", "UninterpretedOption"});
        Q = ac.g().get(18);
        R = new GeneratedMessageV3.FieldAccessorTable(Q, new String[]{"Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue"});
        S = Q.h().get(0);
        T = new GeneratedMessageV3.FieldAccessorTable(S, new String[]{"NamePart", "IsExtension"});
        U = ac.g().get(19);
        V = new GeneratedMessageV3.FieldAccessorTable(U, new String[]{HttpHeader.LOCATION});
        W = U.h().get(0);
        X = new GeneratedMessageV3.FieldAccessorTable(W, new String[]{"Path", "Span", "LeadingComments", "TrailingComments", "LeadingDetachedComments"});
        Y = ac.g().get(20);
        Z = new GeneratedMessageV3.FieldAccessorTable(Y, new String[]{"Annotation"});
        aa = Y.h().get(0);
        ab = new GeneratedMessageV3.FieldAccessorTable(aa, new String[]{"Path", "SourceFile", "Begin", "End"});
    }
}
