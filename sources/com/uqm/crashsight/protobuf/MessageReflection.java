package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Descriptors;
import com.uqm.crashsight.protobuf.ExtensionRegistry;
import com.uqm.crashsight.protobuf.GeneratedMessage;
import com.uqm.crashsight.protobuf.Message;
import com.uqm.crashsight.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MessageReflection {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface MergeTarget {

        /* loaded from: classes3.dex */
        public enum ContainerType {
            MESSAGE,
            EXTENSION_SET
        }

        ExtensionRegistry.ExtensionInfo a(ExtensionRegistry extensionRegistry, Descriptors.Descriptor descriptor, int i);

        ContainerType a();

        MergeTarget a(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        Object a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException;

        Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException;

        boolean a(Descriptors.FieldDescriptor fieldDescriptor);

        MergeTarget b(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        WireFormat.Utf8Validation b(Descriptors.FieldDescriptor fieldDescriptor);

        Object b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Message message, Map<Descriptors.FieldDescriptor, Object> map, CodedOutputStream codedOutputStream, boolean z) throws IOException {
        boolean f = message.d().e().f();
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (f && key.s() && key.h() == Descriptors.FieldDescriptor.Type.MESSAGE && !key.o()) {
                codedOutputStream.b(key.e(), (Message) value);
            } else {
                FieldSet.a(key, value, codedOutputStream);
            }
        }
        UnknownFieldSet b2 = message.b();
        if (f) {
            b2.a(codedOutputStream);
        } else {
            b2.writeTo(codedOutputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Message message, Map<Descriptors.FieldDescriptor, Object> map) {
        boolean f = message.d().e().f();
        int i = 0;
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (f && key.s() && key.h() == Descriptors.FieldDescriptor.Type.MESSAGE && !key.o()) {
                i += CodedOutputStream.d(key.e(), (Message) value);
            } else {
                i += FieldSet.c(key, value);
            }
        }
        UnknownFieldSet b2 = message.b();
        if (f) {
            return i + b2.d();
        }
        return i + b2.getSerializedSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(MessageOrBuilder messageOrBuilder) {
        for (Descriptors.FieldDescriptor fieldDescriptor : messageOrBuilder.d().f()) {
            if (fieldDescriptor.m() && !messageOrBuilder.a(fieldDescriptor)) {
                return false;
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : messageOrBuilder.b_().entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            if (key.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (key.o()) {
                    Iterator it = ((List) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        if (!((Message) it.next()).isInitialized()) {
                            return false;
                        }
                    }
                } else if (!((Message) entry.getValue()).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String a(String str, Descriptors.FieldDescriptor fieldDescriptor, int i) {
        StringBuilder sb = new StringBuilder(str);
        if (fieldDescriptor.s()) {
            sb.append('(');
            sb.append(fieldDescriptor.c());
            sb.append(')');
        } else {
            sb.append(fieldDescriptor.b());
        }
        if (i != -1) {
            sb.append('[');
            sb.append(i);
            sb.append(']');
        }
        sb.append('.');
        return sb.toString();
    }

    private static void a(MessageOrBuilder messageOrBuilder, String str, List<String> list) {
        for (Descriptors.FieldDescriptor fieldDescriptor : messageOrBuilder.d().f()) {
            if (fieldDescriptor.m() && !messageOrBuilder.a(fieldDescriptor)) {
                list.add(str + fieldDescriptor.b());
            }
        }
        for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : messageOrBuilder.b_().entrySet()) {
            Descriptors.FieldDescriptor key = entry.getKey();
            Object value = entry.getValue();
            if (key.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (key.o()) {
                    int i = 0;
                    Iterator it = ((List) value).iterator();
                    while (it.hasNext()) {
                        a((MessageOrBuilder) it.next(), a(str, key, i), list);
                        i++;
                    }
                } else if (messageOrBuilder.a(key)) {
                    a((MessageOrBuilder) value, a(str, key, -1), list);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> b(MessageOrBuilder messageOrBuilder) {
        ArrayList arrayList = new ArrayList();
        a(messageOrBuilder, "", arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a implements MergeTarget {

        /* renamed from: a, reason: collision with root package name */
        private final Message.Builder f6753a;

        public a(Message.Builder builder) {
            this.f6753a = builder;
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final boolean a(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.f6753a.a(fieldDescriptor);
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final MergeTarget a(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.f6753a.d(fieldDescriptor, obj);
            return this;
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final MergeTarget b(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.f6753a.c(fieldDescriptor, obj);
            return this;
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final MergeTarget.ContainerType a() {
            return MergeTarget.ContainerType.MESSAGE;
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final ExtensionRegistry.ExtensionInfo a(ExtensionRegistry extensionRegistry, Descriptors.Descriptor descriptor, int i) {
            return extensionRegistry.b(descriptor, i);
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException {
            Message.Builder c;
            Message message2;
            if (message != null) {
                c = message.q();
            } else {
                c = this.f6753a.c(fieldDescriptor);
            }
            if (!fieldDescriptor.o() && (message2 = (Message) this.f6753a.b(fieldDescriptor)) != null) {
                c.internalMergeFrom(message2);
            }
            codedInputStream.a(fieldDescriptor.e(), c, extensionRegistryLite);
            return c.h();
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final Object b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException {
            Message.Builder c;
            Message message2;
            if (message != null) {
                c = message.q();
            } else {
                c = this.f6753a.c(fieldDescriptor);
            }
            if (!fieldDescriptor.o() && (message2 = (Message) this.f6753a.b(fieldDescriptor)) != null) {
                c.internalMergeFrom(message2);
            }
            codedInputStream.a(c, extensionRegistryLite);
            return c.h();
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final Object a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException {
            Message.Builder c;
            Message message2;
            if (message != null) {
                c = message.q();
            } else {
                c = this.f6753a.c(fieldDescriptor);
            }
            if (!fieldDescriptor.o() && (message2 = (Message) this.f6753a.b(fieldDescriptor)) != null) {
                c.internalMergeFrom(message2);
            }
            c.a(byteString, extensionRegistryLite);
            return c.h();
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final WireFormat.Utf8Validation b(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.k()) {
                return WireFormat.Utf8Validation.STRICT;
            }
            if (!fieldDescriptor.o() && (this.f6753a instanceof GeneratedMessage.Builder)) {
                return WireFormat.Utf8Validation.LAZY;
            }
            return WireFormat.Utf8Validation.LOOSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b implements MergeTarget {

        /* renamed from: a, reason: collision with root package name */
        private final FieldSet<Descriptors.FieldDescriptor> f6754a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(FieldSet<Descriptors.FieldDescriptor> fieldSet) {
            this.f6754a = fieldSet;
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final boolean a(Descriptors.FieldDescriptor fieldDescriptor) {
            return this.f6754a.a((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor);
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final MergeTarget a(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.f6754a.a((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor, obj);
            return this;
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final MergeTarget b(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            this.f6754a.b((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor, obj);
            return this;
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final MergeTarget.ContainerType a() {
            return MergeTarget.ContainerType.EXTENSION_SET;
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final ExtensionRegistry.ExtensionInfo a(ExtensionRegistry extensionRegistry, Descriptors.Descriptor descriptor, int i) {
            return extensionRegistry.b(descriptor, i);
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException {
            Message message2;
            Message.Builder q = message.q();
            if (!fieldDescriptor.o() && (message2 = (Message) this.f6754a.b((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor)) != null) {
                q.internalMergeFrom(message2);
            }
            codedInputStream.a(fieldDescriptor.e(), q, extensionRegistryLite);
            return q.h();
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final Object b(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException {
            Message message2;
            Message.Builder q = message.q();
            if (!fieldDescriptor.o() && (message2 = (Message) this.f6754a.b((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor)) != null) {
                q.internalMergeFrom(message2);
            }
            codedInputStream.a(q, extensionRegistryLite);
            return q.h();
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final Object a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite, Descriptors.FieldDescriptor fieldDescriptor, Message message) throws IOException {
            Message message2;
            Message.Builder q = message.q();
            if (!fieldDescriptor.o() && (message2 = (Message) this.f6754a.b((FieldSet<Descriptors.FieldDescriptor>) fieldDescriptor)) != null) {
                q.internalMergeFrom(message2);
            }
            q.a(byteString, extensionRegistryLite);
            return q.h();
        }

        @Override // com.uqm.crashsight.protobuf.MessageReflection.MergeTarget
        public final WireFormat.Utf8Validation b(Descriptors.FieldDescriptor fieldDescriptor) {
            if (fieldDescriptor.k()) {
                return WireFormat.Utf8Validation.STRICT;
            }
            return WireFormat.Utf8Validation.LOOSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(com.uqm.crashsight.protobuf.CodedInputStream r8, com.uqm.crashsight.protobuf.UnknownFieldSet.Builder r9, com.uqm.crashsight.protobuf.ExtensionRegistryLite r10, com.uqm.crashsight.protobuf.Descriptors.Descriptor r11, com.uqm.crashsight.protobuf.MessageReflection.MergeTarget r12, int r13) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.MessageReflection.a(com.uqm.crashsight.protobuf.CodedInputStream, com.uqm.crashsight.protobuf.UnknownFieldSet$Builder, com.uqm.crashsight.protobuf.ExtensionRegistryLite, com.uqm.crashsight.protobuf.Descriptors$Descriptor, com.uqm.crashsight.protobuf.MessageReflection$MergeTarget, int):boolean");
    }
}
