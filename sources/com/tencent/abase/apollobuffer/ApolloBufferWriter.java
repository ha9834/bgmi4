package com.tencent.abase.apollobuffer;

import com.tencent.abase.log.XLog;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ApolloBufferWriter {
    private ByteBuffer bs;

    public void Reserve(int i) {
        if (this.bs.remaining() < i) {
            int capacity = (this.bs.capacity() + i) * 2;
            ByteBuffer byteBuffer = null;
            try {
                byteBuffer = ByteBuffer.allocate(capacity);
                byteBuffer.put(this.bs.array(), 0, this.bs.position());
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.bs = byteBuffer;
        }
    }

    public ApolloBufferWriter() {
        this(128);
    }

    public ApolloBufferWriter(int i) {
        this.bs = ByteBuffer.allocate(i);
    }

    public ApolloBufferWriter(ByteBuffer byteBuffer) {
        this.bs = byteBuffer;
    }

    public ByteBuffer GetByteBuffer() {
        return this.bs;
    }

    public byte[] GetBufferData() {
        byte[] bArr = new byte[this.bs.position()];
        System.arraycopy(this.bs.array(), 0, bArr, 0, this.bs.position());
        return bArr;
    }

    public void Write(boolean z) {
        Write(z ? (byte) 1 : (byte) 0);
    }

    public void Write(byte b) {
        Reserve(1);
        this.bs.put(b);
    }

    public void Write(short s) {
        Reserve(2);
        this.bs.putShort(s);
    }

    public void Write(int i) {
        Reserve(4);
        this.bs.putInt(i);
    }

    public void Write(long j) {
        Reserve(8);
        this.bs.putLong(j);
    }

    public void Write(byte[] bArr) {
        Write(bArr, -1);
    }

    public void Write(byte[] bArr, int i) {
        if (bArr != null) {
            if (i == -1 || i > bArr.length) {
                i = bArr.length;
            }
            Write(i);
            Reserve(i);
            this.bs.put(bArr, 0, i);
            return;
        }
        Write(0);
    }

    public void Write(String str) {
        if (str == null) {
            str = "";
        }
        byte[] bytes = str.getBytes();
        if (bytes == null) {
            bytes = new byte[0];
        }
        Write(bytes);
    }

    public <T> void Write(List<T> list) {
        Write(list != null ? list.size() : 0);
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                Write(list.get(i));
            }
        }
    }

    public <T> void Write(Collection<T> collection) {
        Write(collection != null ? collection.size() : 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                Write(it.next());
            }
        }
    }

    public <K, V> void Write(Map<K, V> map) {
        if (map != null) {
            Write(map.size());
            for (Map.Entry<K, V> entry : map.entrySet()) {
                Write(entry.getKey());
                Write(entry.getValue());
            }
            return;
        }
        Write(0);
    }

    public void Write(ApolloBufferBase apolloBufferBase) {
        if (apolloBufferBase != null) {
            apolloBufferBase.Encode(this);
        }
    }

    public void Write(Object obj) {
        if (obj instanceof Byte) {
            Write(((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof Boolean) {
            Write(((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof Short) {
            Write(((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Integer) {
            Write(((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            Write(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Float) {
            Write(Float.valueOf(((Float) obj).floatValue()));
            return;
        }
        if (obj instanceof Double) {
            Write(Double.valueOf(((Double) obj).doubleValue()));
            return;
        }
        if (obj instanceof String) {
            Write((String) obj);
            return;
        }
        if (obj instanceof ApolloBufferBase) {
            Write((ApolloBufferBase) obj);
            return;
        }
        if (obj instanceof byte[]) {
            Write((byte[]) obj);
            return;
        }
        if (obj instanceof boolean[]) {
            Write((boolean[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            Write((short[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            Write((int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            Write((long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            Write((float[]) obj);
            return;
        }
        if (obj instanceof double[]) {
            Write((double[]) obj);
            return;
        }
        if (obj.getClass().isArray()) {
            Write((Object[]) obj);
            return;
        }
        if (obj instanceof List) {
            Write((List) obj);
            return;
        }
        if (obj instanceof Collection) {
            Write((Collection) obj);
        } else if (obj instanceof Map) {
            Write((Map) obj);
        } else {
            XLog.w("ABase", "ApolloBufferWriter Write Unknown Type");
        }
    }
}
