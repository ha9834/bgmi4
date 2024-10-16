package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.AbstractMessageLite;
import com.uqm.crashsight.protobuf.FieldSet;
import com.uqm.crashsight.protobuf.GeneratedMessageLite;
import com.uqm.crashsight.protobuf.GeneratedMessageLite.Builder;
import com.uqm.crashsight.protobuf.Internal;
import com.uqm.crashsight.protobuf.MessageLite;
import com.uqm.crashsight.protobuf.WireFormat;
import com.uqm.crashsight.protobuf.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected UnknownFieldSetLite unknownFields = UnknownFieldSetLite.a();
    protected int memoizedSerializedSize = -1;

    /* loaded from: classes3.dex */
    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {
    }

    /* loaded from: classes3.dex */
    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends MessageLiteOrBuilder {
    }

    /* loaded from: classes3.dex */
    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    /* loaded from: classes3.dex */
    public static final class SerializedForm implements Serializable {
    }

    protected abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public final Parser<MessageType> getParserForType() {
        return (Parser) dynamicMethod(MethodToInvoke.GET_PARSER);
    }

    @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
    /* renamed from: getDefaultInstanceForType */
    public final MessageType r() {
        return (MessageType) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public final BuilderType newBuilderForType() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    public String toString() {
        return aa.a(this, super.toString());
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        this.memoizedHashCode = ak.a().a((ak) this).a(this);
        return this.memoizedHashCode;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (r().getClass().isInstance(obj)) {
            return ak.a().a((ak) this).a(this, (GeneratedMessageLite<MessageType, BuilderType>) obj);
        }
        return false;
    }

    private final void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == UnknownFieldSetLite.a()) {
            this.unknownFields = UnknownFieldSetLite.b();
        }
    }

    protected boolean parseUnknownField(int i, CodedInputStream codedInputStream) throws IOException {
        if (WireFormat.a(i) == 4) {
            return false;
        }
        if (this.unknownFields == UnknownFieldSetLite.a()) {
            this.unknownFields = UnknownFieldSetLite.b();
        }
        return this.unknownFields.a(i, codedInputStream);
    }

    protected void mergeVarintField(int i, int i2) {
        if (this.unknownFields == UnknownFieldSetLite.a()) {
            this.unknownFields = UnknownFieldSetLite.b();
        }
        this.unknownFields.a(i, i2);
    }

    protected void mergeLengthDelimitedField(int i, ByteString byteString) {
        if (this.unknownFields == UnknownFieldSetLite.a()) {
            this.unknownFields = UnknownFieldSetLite.b();
        }
        this.unknownFields.a(i, byteString);
    }

    protected void makeImmutable() {
        ak.a().a((ak) this).d(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> BuilderType createBuilder(MessageType messagetype) {
        return (BuilderType) createBuilder().mergeFrom(messagetype);
    }

    @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return isInitialized(this, Boolean.TRUE.booleanValue());
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public final BuilderType toBuilder() {
        BuilderType buildertype = (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
        buildertype.mergeFrom(this);
        return buildertype;
    }

    protected Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj) {
        return dynamicMethod(methodToInvoke, obj, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object dynamicMethod(MethodToInvoke methodToInvoke) {
        return dynamicMethod(methodToInvoke, null, null);
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessageLite
    int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize;
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessageLite
    void setMemoizedSerializedSize(int i) {
        this.memoizedSerializedSize = i;
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        ak.a().a((ak) this).a((ao) this, (Writer) g.a(codedOutputStream));
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = ak.a().a((ak) this).b(this);
        }
        return this.memoizedSerializedSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object buildMessageInfo() throws Exception {
        return dynamicMethod(MethodToInvoke.BUILD_MESSAGE_INFO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends GeneratedMessageLite<?, ?>> T getDefaultInstance(Class<T> cls) {
        GeneratedMessageLite<?, ?> generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (generatedMessageLite == null) {
            generatedMessageLite = (T) ((GeneratedMessageLite) aw.a(cls)).r();
            if (generatedMessageLite == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, generatedMessageLite);
        }
        return (T) generatedMessageLite;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> cls, T t) {
        defaultInstanceMap.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object newMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        return new am(messageLite, str, objArr);
    }

    protected final void mergeUnknownFields(UnknownFieldSetLite unknownFieldSetLite) {
        this.unknownFields = UnknownFieldSetLite.a(this.unknownFields, unknownFieldSetLite);
    }

    /* loaded from: classes3.dex */
    public static abstract class Builder<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> extends AbstractMessageLite.Builder<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        protected MessageType instance;
        protected boolean isBuilt = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public Builder(MessageType messagetype) {
            this.defaultInstance = messagetype;
            this.instance = (MessageType) messagetype.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void copyOnWrite() {
            if (this.isBuilt) {
                copyOnWriteInternal();
                this.isBuilt = false;
            }
        }

        protected void copyOnWriteInternal() {
            MessageType messagetype = (MessageType) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            ak.a().a((ak) messagetype).b(messagetype, this.instance);
            this.instance = messagetype;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return GeneratedMessageLite.isInitialized(this.instance, false);
        }

        /* renamed from: clear, reason: merged with bridge method [inline-methods] */
        public final BuilderType m21clear() {
            this.instance = (MessageType) this.instance.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
            return this;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public BuilderType mo11clone() {
            BuilderType buildertype = (BuilderType) r().newBuilderForType();
            buildertype.mergeFrom(g());
            return buildertype;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
        /* renamed from: buildPartial */
        public MessageType g() {
            if (this.isBuilt) {
                return this.instance;
            }
            this.instance.makeImmutable();
            this.isBuilt = true;
            return this.instance;
        }

        @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
        /* renamed from: build */
        public final MessageType h() {
            MessageType g = g();
            if (g.isInitialized()) {
                return g;
            }
            throw newUninitializedMessageException(g);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        public BuilderType internalMergeFrom(MessageType messagetype) {
            return mergeFrom((Builder<MessageType, BuilderType>) messagetype);
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            if (this.isBuilt) {
                copyOnWriteInternal();
                this.isBuilt = false;
            }
            MessageType messagetype2 = this.instance;
            ak.a().a((ak) messagetype2).b(messagetype2, messagetype);
            return this;
        }

        private void mergeFromInstance(MessageType messagetype, MessageType messagetype2) {
            ak.a().a((ak) messagetype).b(messagetype, messagetype2);
        }

        @Override // com.uqm.crashsight.protobuf.MessageLiteOrBuilder
        /* renamed from: getDefaultInstanceForType */
        public MessageType r() {
            return this.defaultInstance;
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType mo19mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            if (this.isBuilt) {
                copyOnWriteInternal();
                this.isBuilt = false;
            }
            try {
                ak.a().a((ak) this.instance).a(this.instance, bArr, i, i + i2, new c.a(extensionRegistryLite));
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw InvalidProtocolBufferException.c();
            }
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType mo18mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            return mo19mergeFrom(bArr, i, i2, ExtensionRegistryLite.c());
        }

        @Override // com.uqm.crashsight.protobuf.AbstractMessageLite.Builder, com.uqm.crashsight.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            if (this.isBuilt) {
                copyOnWriteInternal();
                this.isBuilt = false;
            }
            try {
                ak.a().a((ak) this.instance).a(this.instance, f.a(codedInputStream), extensionRegistryLite);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends GeneratedMessageLite<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType, BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        protected FieldSet<a> f6710a = FieldSet.b();

        /* loaded from: classes3.dex */
        public class ExtensionWriter {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final FieldSet<a> a() {
            if (this.f6710a.f()) {
                this.f6710a = this.f6710a.clone();
            }
            return this.f6710a;
        }
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, Class cls) {
        return new GeneratedExtension<>(containingtype, type, messageLite, new a(enumLiteMap, i, fieldType, false, false));
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, Class cls) {
        return new GeneratedExtension<>(containingtype, Collections.emptyList(), messageLite, new a(enumLiteMap, i, fieldType, true, z));
    }

    /* loaded from: classes3.dex */
    static final class a implements FieldSet.FieldDescriptorLite<a> {

        /* renamed from: a, reason: collision with root package name */
        final boolean f6713a;
        private Internal.EnumLiteMap<?> b;
        private int c;
        private WireFormat.FieldType d;
        private boolean e;

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.c - ((a) obj).c;
        }

        a(Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            this.b = enumLiteMap;
            this.c = i;
            this.d = fieldType;
            this.f6713a = z;
            this.e = z2;
        }

        @Override // com.uqm.crashsight.protobuf.FieldSet.FieldDescriptorLite
        public final int e() {
            return this.c;
        }

        @Override // com.uqm.crashsight.protobuf.FieldSet.FieldDescriptorLite
        public final WireFormat.FieldType i() {
            return this.d;
        }

        @Override // com.uqm.crashsight.protobuf.FieldSet.FieldDescriptorLite
        public final WireFormat.JavaType g() {
            return this.d.a();
        }

        @Override // com.uqm.crashsight.protobuf.FieldSet.FieldDescriptorLite
        public final boolean o() {
            return this.f6713a;
        }

        @Override // com.uqm.crashsight.protobuf.FieldSet.FieldDescriptorLite
        public final boolean p() {
            return this.e;
        }

        public final Internal.EnumLiteMap<?> a() {
            return this.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.uqm.crashsight.protobuf.FieldSet.FieldDescriptorLite
        public final MessageLite.Builder a(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((Builder) messageLite);
        }
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
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

    /* loaded from: classes3.dex */
    public static class GeneratedExtension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

        /* renamed from: a, reason: collision with root package name */
        final a f6711a;
        private MessageLite b;

        GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, a aVar) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (aVar.i() == WireFormat.FieldType.k && messageLite == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.b = messageLite;
            this.f6711a = aVar;
        }

        public final int b() {
            return this.f6711a.e();
        }

        public final MessageLite c() {
            return this.b;
        }

        public final WireFormat.FieldType d() {
            return this.f6711a.i();
        }

        public final boolean e() {
            return this.f6711a.f6713a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends ExtendableMessage<MessageType, BuilderType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>, T> GeneratedExtension<MessageType, T> checkIsLite(ExtensionLite<MessageType, T> extensionLite) {
        if (!extensionLite.a()) {
            throw new IllegalArgumentException("Expected a lite extension.");
        }
        return (GeneratedExtension) extensionLite;
    }

    protected static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T t, boolean z) {
        byte byteValue = ((Byte) t.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean e = ak.a().a((ak) t).e(t);
        if (z) {
            t.dynamicMethod(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, e ? t : null);
        }
        return e;
    }

    protected static Internal.IntList emptyIntList() {
        return q.d();
    }

    protected static Internal.IntList mutableCopy(Internal.IntList intList) {
        int size = intList.size();
        return intList.c(size == 0 ? 10 : size << 1);
    }

    protected static Internal.LongList emptyLongList() {
        return s.d();
    }

    protected static Internal.LongList mutableCopy(Internal.LongList longList) {
        int size = longList.size();
        return longList.c(size == 0 ? 10 : size << 1);
    }

    protected static Internal.FloatList emptyFloatList() {
        return o.d();
    }

    protected static Internal.FloatList mutableCopy(Internal.FloatList floatList) {
        int size = floatList.size();
        return floatList.c(size == 0 ? 10 : size << 1);
    }

    protected static Internal.DoubleList emptyDoubleList() {
        return i.d();
    }

    protected static Internal.DoubleList mutableCopy(Internal.DoubleList doubleList) {
        int size = doubleList.size();
        return doubleList.c(size == 0 ? 10 : size << 1);
    }

    protected static Internal.BooleanList emptyBooleanList() {
        return e.d();
    }

    protected static Internal.BooleanList mutableCopy(Internal.BooleanList booleanList) {
        int size = booleanList.size();
        return booleanList.c(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return al.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> protobufList) {
        int size = protobufList.size();
        return protobufList.c(size == 0 ? 10 : size << 1);
    }

    /* loaded from: classes3.dex */
    public static class DefaultInstanceBasedParser<T extends GeneratedMessageLite<T, ?>> extends AbstractParser<T> {

        /* renamed from: a, reason: collision with root package name */
        private final T f6709a;

        @Override // com.uqm.crashsight.protobuf.AbstractParser
        public final /* synthetic */ MessageLite a(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parsePartialFrom(this.f6709a, bArr, i, i2, extensionRegistryLite);
        }

        @Override // com.uqm.crashsight.protobuf.Parser
        public final /* synthetic */ Object a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parsePartialFrom(this.f6709a, codedInputStream, extensionRegistryLite);
        }

        public DefaultInstanceBasedParser(T t) {
            this.f6709a = t;
        }
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (T) t.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            ao a2 = ak.a().a((ak) t2);
            a2.a(t2, f.a(codedInputStream), extensionRegistryLite);
            a2.d(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e.getCause());
            }
            throw new InvalidProtocolBufferException(e.getMessage()).a(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e2.getCause());
            }
            throw e2;
        }
    }

    static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T t2 = (T) t.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            ao a2 = ak.a().a((ak) t2);
            a2.a(t2, bArr, i, i + i2, new c.a(extensionRegistryLite));
            a2.d(t2);
            if (t2.memoizedHashCode == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e.getCause());
            }
            throw new InvalidProtocolBufferException(e.getMessage()).a(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw InvalidProtocolBufferException.c().a(t2);
        }
    }

    protected static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return (T) parsePartialFrom(t, codedInputStream, ExtensionRegistryLite.c());
    }

    private static <T extends GeneratedMessageLite<T, ?>> T checkMessageInitialized(T t) throws InvalidProtocolBufferException {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw t.newUninitializedMessageException().a().a(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(t, CodedInputStream.a(byteBuffer), extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (T) parseFrom(t, byteBuffer, ExtensionRegistryLite.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteString byteString) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parseFrom(t, byteString, ExtensionRegistryLite.c()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, byteString, extensionRegistryLite));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            CodedInputStream h = byteString.h();
            T t2 = (T) parsePartialFrom(t, h, extensionRegistryLite);
            try {
                h.a(0);
                return t2;
            } catch (InvalidProtocolBufferException e) {
                throw e.a(t2);
            }
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialFrom(T t, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, ExtensionRegistryLite.c()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, CodedInputStream.a(inputStream), ExtensionRegistryLite.c()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, CodedInputStream.a(inputStream), extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        return (T) parseFrom(t, codedInputStream, ExtensionRegistryLite.c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialFrom(t, codedInputStream, extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, ExtensionRegistryLite.c()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends GeneratedMessageLite<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, extensionRegistryLite));
    }

    private static <T extends GeneratedMessageLite<T, ?>> T parsePartialDelimitedFrom(T t, InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            CodedInputStream a2 = CodedInputStream.a(new AbstractMessageLite.Builder.a(inputStream, CodedInputStream.a(read, inputStream)));
            T t2 = (T) parsePartialFrom(t, a2, extensionRegistryLite);
            try {
                a2.a(0);
                return t2;
            } catch (InvalidProtocolBufferException e) {
                throw e.a(t2);
            }
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2.getMessage());
        }
    }
}
