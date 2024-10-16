package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.AbstractMessageLite;
import com.uqm.crashsight.protobuf.AbstractMessageLite.Builder;
import com.uqm.crashsight.protobuf.ByteString;
import com.uqm.crashsight.protobuf.MessageLite;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class AbstractMessageLite<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite {
    protected int memoizedHashCode = 0;

    /* loaded from: classes3.dex */
    public interface InternalOneOfEnum {
    }

    @Override // com.uqm.crashsight.protobuf.MessageLite
    public ByteString toByteString() {
        try {
            ByteString.d c = ByteString.c(getSerializedSize());
            writeTo(c.b());
            return c.a();
        } catch (IOException e) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e);
        }
    }

    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream a2 = CodedOutputStream.a(bArr);
            writeTo(a2);
            a2.k();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e);
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        CodedOutputStream a2 = CodedOutputStream.a(outputStream, CodedOutputStream.a(getSerializedSize()));
        writeTo(a2);
        a2.i();
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream a2 = CodedOutputStream.a(outputStream, CodedOutputStream.a(CodedOutputStream.p(serializedSize) + serializedSize));
        a2.o(serializedSize);
        writeTo(a2);
        a2.i();
    }

    int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    void setMemoizedSerializedSize(int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSerializedSize(ao aoVar) {
        int memoizedSerializedSize = getMemoizedSerializedSize();
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int b = aoVar.b(this);
        setMemoizedSerializedSize(b);
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UninitializedMessageException newUninitializedMessageException() {
        return new UninitializedMessageException();
    }

    private String getSerializingExceptionMessage(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void checkByteStringIsUtf8(ByteString byteString) throws IllegalArgumentException {
        if (!byteString.g()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    @Deprecated
    protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        Builder.addAll((Iterable) iterable, (List) collection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        Builder.addAll((Iterable) iterable, (List) list);
    }

    /* loaded from: classes3.dex */
    public static abstract class Builder<MessageType extends AbstractMessageLite<MessageType, BuilderType>, BuilderType extends Builder<MessageType, BuilderType>> implements MessageLite.Builder {
        @Override // 
        /* renamed from: clone */
        public abstract BuilderType mo11clone();

        protected abstract BuilderType internalMergeFrom(MessageType messagetype);

        @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
        public abstract BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        @Override // 
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType mo14mergeFrom(CodedInputStream codedInputStream) throws IOException {
            return mergeFrom(codedInputStream, ExtensionRegistryLite.c());
        }

        @Override // 
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType mo12mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            try {
                CodedInputStream h = byteString.h();
                mo14mergeFrom(h);
                h.a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e2);
            }
        }

        @Override // 
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType mo13mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            try {
                CodedInputStream h = byteString.h();
                mergeFrom(h, extensionRegistryLite);
                h.a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e2);
            }
        }

        @Override // 
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType mo17mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return mo18mergeFrom(bArr, 0, bArr.length);
        }

        @Override // 
        /* renamed from: mergeFrom */
        public BuilderType mo18mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            try {
                CodedInputStream a2 = CodedInputStream.a(bArr, i, i2);
                mo14mergeFrom(a2);
                a2.a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e2);
            }
        }

        @Override // 
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType mo20mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return mo19mergeFrom(bArr, 0, bArr.length, extensionRegistryLite);
        }

        @Override // 
        /* renamed from: mergeFrom */
        public BuilderType mo19mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            try {
                CodedInputStream a2 = CodedInputStream.a(bArr, i, i2);
                mergeFrom(a2, extensionRegistryLite);
                a2.a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException(getReadingExceptionMessage("byte array"), e2);
            }
        }

        @Override // 
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType mo15mergeFrom(InputStream inputStream) throws IOException {
            CodedInputStream a2 = CodedInputStream.a(inputStream);
            mo14mergeFrom(a2);
            a2.a(0);
            return this;
        }

        @Override // 
        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public BuilderType mo16mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            CodedInputStream a2 = CodedInputStream.a(inputStream);
            mergeFrom(a2, extensionRegistryLite);
            a2.a(0);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class a extends FilterInputStream {

            /* renamed from: a, reason: collision with root package name */
            private int f6633a;

            /* JADX INFO: Access modifiers changed from: package-private */
            public a(InputStream inputStream, int i) {
                super(inputStream);
                this.f6633a = i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final int available() throws IOException {
                return Math.min(super.available(), this.f6633a);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final int read() throws IOException {
                if (this.f6633a <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f6633a--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = this.f6633a;
                if (i3 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i, Math.min(i2, i3));
                if (read >= 0) {
                    this.f6633a -= read;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public final long skip(long j) throws IOException {
                long skip = super.skip(Math.min(j, this.f6633a));
                if (skip >= 0) {
                    this.f6633a = (int) (this.f6633a - skip);
                }
                return skip;
            }
        }

        public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            mo16mergeFrom((InputStream) new a(inputStream, CodedInputStream.a(read, inputStream)), extensionRegistryLite);
            return true;
        }

        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            return mergeDelimitedFrom(inputStream, ExtensionRegistryLite.c());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.uqm.crashsight.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(MessageLite messageLite) {
            if (!r().getClass().isInstance(messageLite)) {
                throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
            }
            return (BuilderType) internalMergeFrom((AbstractMessageLite) messageLite);
        }

        private String getReadingExceptionMessage(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }

        private static <T> void addAllCheckingNulls(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size = list.size();
            for (T t : iterable) {
                if (t == null) {
                    String str = "Element at index " + (list.size() - size) + " is null.";
                    for (int size2 = list.size() - 1; size2 >= size; size2--) {
                        list.remove(size2);
                    }
                    throw new NullPointerException(str);
                }
                list.add(t);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static UninitializedMessageException newUninitializedMessageException(MessageLite messageLite) {
            return new UninitializedMessageException();
        }

        @Deprecated
        protected static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            addAll((Iterable) iterable, (List) collection);
        }

        protected static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
            Internal.a(iterable);
            if (iterable instanceof LazyStringList) {
                List<?> d = ((LazyStringList) iterable).d();
                LazyStringList lazyStringList = (LazyStringList) list;
                int size = list.size();
                for (Object obj : d) {
                    if (obj == null) {
                        String str = "Element at index " + (lazyStringList.size() - size) + " is null.";
                        for (int size2 = lazyStringList.size() - 1; size2 >= size; size2--) {
                            lazyStringList.remove(size2);
                        }
                        throw new NullPointerException(str);
                    }
                    if (obj instanceof ByteString) {
                        lazyStringList.a((ByteString) obj);
                    } else {
                        lazyStringList.add((String) obj);
                    }
                }
                return;
            }
            if (iterable instanceof aj) {
                list.addAll((Collection) iterable);
            } else {
                addAllCheckingNulls(iterable, list);
            }
        }
    }
}
