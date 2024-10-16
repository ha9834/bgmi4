package com.tencent.abase.apollobuffer;

import com.tencent.abase.log.XLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ApolloBufferReader {
    private ByteBuffer bs;

    public ApolloBufferReader() {
    }

    public ApolloBufferReader(ByteBuffer byteBuffer) {
        this.bs = byteBuffer;
    }

    public ApolloBufferReader(byte[] bArr) {
        this.bs = ByteBuffer.wrap(bArr);
    }

    public boolean Read(boolean z) {
        return Read((byte) 0) != 0;
    }

    public byte Read(byte b) {
        ByteBuffer byteBuffer = this.bs;
        if (byteBuffer != null) {
            return byteBuffer.get();
        }
        return (byte) 0;
    }

    public byte[] Read(byte[] bArr) {
        int Read = Read(0);
        if (Read <= 0 || Read >= this.bs.capacity()) {
            return null;
        }
        byte[] bArr2 = new byte[Read];
        this.bs.get(bArr2);
        return bArr2;
    }

    public short Read(short s) {
        ByteBuffer byteBuffer = this.bs;
        if (byteBuffer == null) {
            return (short) 0;
        }
        return byteBuffer.getShort();
    }

    public int Read(int i) {
        ByteBuffer byteBuffer = this.bs;
        if (byteBuffer == null) {
            return 0;
        }
        return byteBuffer.getInt();
    }

    public long Read(long j) {
        ByteBuffer byteBuffer = this.bs;
        if (byteBuffer == null) {
            return 0L;
        }
        return byteBuffer.getLong();
    }

    public String Read(String str) {
        byte[] Read;
        if (this.bs == null || (Read = Read((byte[]) null)) == null) {
            return null;
        }
        return new String(Read);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> List<T> ReadList(List<T> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        int Read = Read(0);
        if (Read <= 0) {
            return new ArrayList();
        }
        T t = list.get(0);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < Read; i++) {
            try {
                arrayList.add(Read((ApolloBufferReader) t.getClass().newInstance()));
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return arrayList;
    }

    public <K, V> Map<K, V> ReadMap(Map<K, V> map) {
        return (HashMap) ReadMap(new HashMap(), map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> ReadMap(Map<K, V> map, Map<K, V> map2) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Map.Entry<K, V> next = map2.entrySet().iterator().next();
        K key = next.getKey();
        V value = next.getValue();
        int Read = Read(0);
        if (Read <= 0) {
            return new HashMap();
        }
        for (int i = 0; i < Read; i++) {
            map.put(Read((ApolloBufferReader) key), Read((ApolloBufferReader) value));
        }
        return map;
    }

    public ApolloBufferBase Read(ApolloBufferBase apolloBufferBase) {
        if (apolloBufferBase != null) {
            apolloBufferBase.Decode(this);
        }
        return apolloBufferBase;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object Read(T t) {
        if (t instanceof Byte) {
            return Byte.valueOf(Read((byte) 0));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(Read(false));
        }
        if (t instanceof Short) {
            return Short.valueOf(Read((short) 0));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(Read(0));
        }
        if (t instanceof Long) {
            return Long.valueOf(Read(0L));
        }
        if (t instanceof String) {
            return Read("");
        }
        if (t instanceof ApolloBufferBase) {
            return Read((ApolloBufferBase) t);
        }
        if (t instanceof List) {
            return ReadList((List) t);
        }
        if (t instanceof Map) {
            return ReadMap((Map) t);
        }
        XLog.w("ABase", "ApolloBufferReader Read Unknown Type");
        return null;
    }
}
