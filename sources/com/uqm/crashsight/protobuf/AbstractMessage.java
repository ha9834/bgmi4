package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.AbstractMessageLite;
import com.uqm.crashsight.protobuf.Descriptors;
import com.uqm.crashsight.protobuf.Internal;
import com.uqm.crashsight.protobuf.Message;
import com.uqm.crashsight.protobuf.MessageLite;
import com.uqm.crashsight.protobuf.MessageReflection;
import com.uqm.crashsight.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class AbstractMessage extends AbstractMessageLite implements Message {

    /* renamed from: a, reason: collision with root package name */
    protected int f6632a = -1;

    /* loaded from: classes3.dex */
    public interface BuilderParent {
        void a();
    }

    @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return MessageReflection.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Message.Builder a(BuilderParent builderParent) {
        throw new UnsupportedOperationException("Nested builder is not supported for this type.");
    }

    public final String toString() {
        return TextFormat.a().a(this);
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        MessageReflection.a(this, b_(), codedOutputStream, false);
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessageLite
    int getMemoizedSerializedSize() {
        return this.f6632a;
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessageLite
    void setMemoizedSerializedSize(int i) {
        this.f6632a = i;
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f6632a;
        if (i != -1) {
            return i;
        }
        this.f6632a = MessageReflection.a(this, b_());
        return this.f6632a;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Message)) {
            return false;
        }
        Message message = (Message) obj;
        if (d() != message.d()) {
            return false;
        }
        Map<Descriptors.FieldDescriptor, Object> b_ = b_();
        Map<Descriptors.FieldDescriptor, Object> b_2 = message.b_();
        if (b_.size() == b_2.size()) {
            loop0: for (Descriptors.FieldDescriptor fieldDescriptor : b_.keySet()) {
                if (b_2.containsKey(fieldDescriptor)) {
                    Object obj2 = b_.get(fieldDescriptor);
                    Object obj3 = b_2.get(fieldDescriptor);
                    if (fieldDescriptor.h() == Descriptors.FieldDescriptor.Type.BYTES) {
                        if (fieldDescriptor.o()) {
                            List list = (List) obj2;
                            List list2 = (List) obj3;
                            if (list.size() == list2.size()) {
                                for (int i = 0; i < list.size(); i++) {
                                    if (a(list.get(i), list2.get(i))) {
                                    }
                                }
                            }
                        } else if (!a(obj2, obj3)) {
                        }
                    } else if (fieldDescriptor.l()) {
                        if (!MapFieldLite.a(a((List) obj2), a((List) obj3))) {
                        }
                    } else if (!obj2.equals(obj3)) {
                    }
                }
            }
            z = true;
            return !z && b().equals(message.b());
        }
        z = false;
        if (z) {
        }
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int a2 = (a(d().hashCode() + 779, b_()) * 29) + b().hashCode();
        this.memoizedHashCode = a2;
        return a2;
    }

    private static boolean a(Object obj, Object obj2) {
        boolean z = obj instanceof byte[];
        if (z && (obj2 instanceof byte[])) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        return (z ? ByteString.a((byte[]) obj) : (ByteString) obj).equals(obj2 instanceof byte[] ? ByteString.a((byte[]) obj2) : (ByteString) obj2);
    }

    private static Map a(List list) {
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        Message message = (Message) it.next();
        Descriptors.Descriptor d = message.d();
        Descriptors.FieldDescriptor a2 = d.a("key");
        Descriptors.FieldDescriptor a3 = d.a("value");
        Object b = message.b(a3);
        if (b instanceof Descriptors.EnumValueDescriptor) {
            b = Integer.valueOf(((Descriptors.EnumValueDescriptor) b).a());
        }
        hashMap.put(message.b(a2), b);
        while (it.hasNext()) {
            Message message2 = (Message) it.next();
            Object b2 = message2.b(a3);
            if (b2 instanceof Descriptors.EnumValueDescriptor) {
                b2 = Integer.valueOf(((Descriptors.EnumValueDescriptor) b2).a());
            }
            hashMap.put(message2.b(a2), b2);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(int i, Map<Descriptors.FieldDescriptor, Object> map) {
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            int e = (i * 37) + key.e();
            if (key.l()) {
                i = (e * 53) + MapFieldLite.a(a((List) value));
            } else if (key.h() != Descriptors.FieldDescriptor.Type.ENUM) {
                i = (e * 53) + value.hashCode();
            } else if (key.o()) {
                i = (e * 53) + Internal.a((List<? extends Internal.EnumLite>) value);
            } else {
                i = (e * 53) + Internal.a((Internal.EnumLite) value);
            }
        }
        return i;
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessageLite
    UninitializedMessageException newUninitializedMessageException() {
        return Builder.b(this);
    }

    /* loaded from: classes3.dex */
    public static abstract class Builder<BuilderType extends Builder<BuilderType>> extends AbstractMessageLite.Builder implements Message.Builder {
        @Override // com.uqm.crashsight.protobuf.Message.Builder
        public final /* synthetic */ Message.Builder a(ByteString byteString) throws InvalidProtocolBufferException {
            return (Builder) super.mo12mergeFrom(byteString);
        }

        @Override // com.uqm.crashsight.protobuf.Message.Builder
        public final /* synthetic */ Message.Builder a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Builder) super.mo13mergeFrom(byteString, extensionRegistryLite);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo12mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Builder) super.mo12mergeFrom(byteString);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo13mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Builder) super.mo13mergeFrom(byteString, extensionRegistryLite);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom */
        public /* synthetic */ AbstractMessageLite.Builder mo14mergeFrom(CodedInputStream codedInputStream) throws IOException {
            return mergeFrom(codedInputStream, ExtensionRegistry.a());
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo15mergeFrom(InputStream inputStream) throws IOException {
            return (Builder) super.mo15mergeFrom(inputStream);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo16mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Builder) super.mo16mergeFrom(inputStream, extensionRegistryLite);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo17mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Builder) super.mo17mergeFrom(bArr);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo18mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            return (Builder) super.mo18mergeFrom(bArr, i, i2);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo19mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Builder) super.mo19mergeFrom(bArr, i, i2, extensionRegistryLite);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom */
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo20mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Builder) super.mo20mergeFrom(bArr, extensionRegistryLite);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder mo12mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Builder) super.mo12mergeFrom(byteString);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder mo13mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Builder) super.mo13mergeFrom(byteString, extensionRegistryLite);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom, reason: collision with other method in class */
        public /* synthetic */ MessageLite.Builder mo14mergeFrom(CodedInputStream codedInputStream) throws IOException {
            return mergeFrom(codedInputStream, ExtensionRegistry.a());
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder mo15mergeFrom(InputStream inputStream) throws IOException {
            return (Builder) super.mo15mergeFrom(inputStream);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder mo16mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Builder) super.mo16mergeFrom(inputStream, extensionRegistryLite);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder mo17mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Builder) super.mo17mergeFrom(bArr);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder mo18mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            return (Builder) super.mo18mergeFrom(bArr, i, i2);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder mo19mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Builder) super.mo19mergeFrom(bArr, i, i2, extensionRegistryLite);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder mo20mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Builder) super.mo20mergeFrom(bArr, extensionRegistryLite);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public BuilderType mo11clone() {
            throw new UnsupportedOperationException("clone() should be implemented in subclasses.");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public BuilderType internalMergeFrom(Message message) {
            Object value;
            Map<Descriptors.FieldDescriptor, Object> b_ = message.b_();
            if (message.d() != d()) {
                throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
            }
            for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : b_.entrySet()) {
                Descriptors.FieldDescriptor key = entry.getKey();
                if (key.o()) {
                    Iterator it = ((List) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        c(key, it.next());
                    }
                } else {
                    if (key.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        Message message2 = (Message) b(key);
                        if (message2 != message2.r()) {
                            value = message2.q().internalMergeFrom(message2).internalMergeFrom((Message) entry.getValue()).h();
                            d(key, value);
                        }
                    }
                    value = entry.getValue();
                    d(key, value);
                }
            }
            a(message.b());
            return this;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
        /* renamed from: a */
        public BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int a2;
            UnknownFieldSet.Builder a3 = codedInputStream.v() ? null : UnknownFieldSet.a(b());
            do {
                a2 = codedInputStream.a();
                if (a2 == 0) {
                    break;
                }
            } while (MessageReflection.a(codedInputStream, a3, extensionRegistryLite, d(), new MessageReflection.a(this), a2));
            if (a3 != null) {
                d(a3.build());
            }
            return this;
        }

        public BuilderType a(UnknownFieldSet unknownFieldSet) {
            d(UnknownFieldSet.a(b()).a(unknownFieldSet).build());
            return this;
        }

        public String toString() {
            return TextFormat.a().a(this);
        }

        protected static UninitializedMessageException b(Message message) {
            return new UninitializedMessageException(MessageReflection.b(message));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a_() {
            throw new IllegalStateException("Should be overridden by subclasses.");
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            return super.mergeDelimitedFrom(inputStream);
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return super.mergeDelimitedFrom(inputStream, extensionRegistryLite);
        }
    }
}
