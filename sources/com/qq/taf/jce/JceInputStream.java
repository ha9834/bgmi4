package com.qq.taf.jce;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class JceInputStream {
    private ByteBuffer bs;
    protected String sServerEncoding = "GBK";

    public static void main(String[] strArr) {
    }

    /* loaded from: classes2.dex */
    public static class HeadData {
        public int tag;
        public byte type;

        public void clear() {
            this.type = (byte) 0;
            this.tag = 0;
        }
    }

    public JceInputStream() {
    }

    public JceInputStream(ByteBuffer byteBuffer) {
        this.bs = byteBuffer;
    }

    public JceInputStream(byte[] bArr) {
        this.bs = ByteBuffer.wrap(bArr);
    }

    public JceInputStream(byte[] bArr, int i) {
        this.bs = ByteBuffer.wrap(bArr);
        this.bs.position(i);
    }

    public void warp(byte[] bArr) {
        wrap(bArr);
    }

    public void wrap(byte[] bArr) {
        this.bs = ByteBuffer.wrap(bArr);
    }

    public static int readHead(HeadData headData, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        headData.type = (byte) (b & 15);
        headData.tag = (b & 240) >> 4;
        if (headData.tag != 15) {
            return 1;
        }
        headData.tag = byteBuffer.get() & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
        return 2;
    }

    public void readHead(HeadData headData) {
        readHead(headData, this.bs);
    }

    private int peakHead(HeadData headData) {
        return readHead(headData, this.bs.duplicate());
    }

    private void skip(int i) {
        ByteBuffer byteBuffer = this.bs;
        byteBuffer.position(byteBuffer.position() + i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
    
        if (r6 != r1.tag) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0019, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:?, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean skipToTag(int r6) {
        /*
            r5 = this;
            r0 = 0
            com.qq.taf.jce.JceInputStream$HeadData r1 = new com.qq.taf.jce.JceInputStream$HeadData     // Catch: java.lang.Throwable -> L24
            r1.<init>()     // Catch: java.lang.Throwable -> L24
        L6:
            int r2 = r5.peakHead(r1)     // Catch: java.lang.Throwable -> L24
            byte r3 = r1.type     // Catch: java.lang.Throwable -> L24
            r4 = 11
            if (r3 != r4) goto L11
            return r0
        L11:
            int r3 = r1.tag     // Catch: java.lang.Throwable -> L24
            if (r6 > r3) goto L1b
            int r1 = r1.tag     // Catch: java.lang.Throwable -> L24
            if (r6 != r1) goto L1a
            r0 = 1
        L1a:
            return r0
        L1b:
            r5.skip(r2)     // Catch: java.lang.Throwable -> L24
            byte r2 = r1.type     // Catch: java.lang.Throwable -> L24
            r5.skipField(r2)     // Catch: java.lang.Throwable -> L24
            goto L6
        L24:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.taf.jce.JceInputStream.skipToTag(int):boolean");
    }

    public void skipToStructEnd() {
        HeadData headData = new HeadData();
        do {
            readHead(headData);
            skipField(headData.type);
        } while (headData.type != 11);
    }

    private void skipField() {
        HeadData headData = new HeadData();
        readHead(headData);
        skipField(headData.type);
    }

    private void skipField(byte b) {
        int i = 0;
        switch (b) {
            case 0:
                skip(1);
                return;
            case 1:
                skip(2);
                return;
            case 2:
                skip(4);
                return;
            case 3:
                skip(8);
                return;
            case 4:
                skip(4);
                return;
            case 5:
                skip(8);
                return;
            case 6:
                int i2 = this.bs.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                skip(i2);
                return;
            case 7:
                skip(this.bs.getInt());
                return;
            case 8:
                int read = read(0, 0, true);
                while (i < read * 2) {
                    skipField();
                    i++;
                }
                return;
            case 9:
                int read2 = read(0, 0, true);
                while (i < read2) {
                    skipField();
                    i++;
                }
                return;
            case 10:
                skipToStructEnd();
                return;
            case 11:
            case 12:
                return;
            case 13:
                HeadData headData = new HeadData();
                readHead(headData);
                if (headData.type != 0) {
                    throw new JceDecodeException("skipField with invalid type, type value: " + ((int) b) + ", " + ((int) headData.type));
                }
                skip(read(0, 0, true));
                return;
            default:
                throw new JceDecodeException("invalid type.");
        }
    }

    public boolean read(boolean z, int i, boolean z2) {
        return read((byte) 0, i, z2) != 0;
    }

    public byte read(byte b, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return b;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        byte b2 = headData.type;
        if (b2 == 0) {
            return this.bs.get();
        }
        if (b2 == 12) {
            return (byte) 0;
        }
        throw new JceDecodeException("type mismatch.");
    }

    public short read(short s, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return s;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        byte b = headData.type;
        if (b == 12) {
            return (short) 0;
        }
        switch (b) {
            case 0:
                return this.bs.get();
            case 1:
                return this.bs.getShort();
            default:
                throw new JceDecodeException("type mismatch.");
        }
    }

    public int read(int i, int i2, boolean z) {
        if (!skipToTag(i2)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return i;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        byte b = headData.type;
        if (b == 12) {
            return 0;
        }
        switch (b) {
            case 0:
                return this.bs.get();
            case 1:
                return this.bs.getShort();
            case 2:
                return this.bs.getInt();
            default:
                throw new JceDecodeException("type mismatch.");
        }
    }

    public long read(long j, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return j;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        byte b = headData.type;
        if (b == 12) {
            return 0L;
        }
        switch (b) {
            case 0:
                return this.bs.get();
            case 1:
                return this.bs.getShort();
            case 2:
                return this.bs.getInt();
            case 3:
                return this.bs.getLong();
            default:
                throw new JceDecodeException("type mismatch.");
        }
    }

    public float read(float f, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return f;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        byte b = headData.type;
        if (b == 4) {
            return this.bs.getFloat();
        }
        if (b == 12) {
            return 0.0f;
        }
        throw new JceDecodeException("type mismatch.");
    }

    public double read(double d, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return d;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        byte b = headData.type;
        if (b == 12) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
        switch (b) {
            case 4:
                return this.bs.getFloat();
            case 5:
                return this.bs.getDouble();
            default:
                throw new JceDecodeException("type mismatch.");
        }
    }

    public String readByteString(String str, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return str;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        switch (headData.type) {
            case 6:
                int i2 = this.bs.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                byte[] bArr = new byte[i2];
                this.bs.get(bArr);
                return HexUtil.bytes2HexStr(bArr);
            case 7:
                int i3 = this.bs.getInt();
                if (i3 > 104857600 || i3 < 0) {
                    throw new JceDecodeException("String too long: " + i3);
                }
                byte[] bArr2 = new byte[i3];
                this.bs.get(bArr2);
                return HexUtil.bytes2HexStr(bArr2);
            default:
                throw new JceDecodeException("type mismatch.");
        }
    }

    public String read(String str, int i, boolean z) {
        String str2;
        String str3;
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return str;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        switch (headData.type) {
            case 6:
                int i2 = this.bs.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                byte[] bArr = new byte[i2];
                this.bs.get(bArr);
                try {
                    str2 = new String(bArr, this.sServerEncoding);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(bArr);
                }
                return str2;
            case 7:
                int i3 = this.bs.getInt();
                if (i3 > 104857600 || i3 < 0) {
                    throw new JceDecodeException("String too long: " + i3);
                }
                byte[] bArr2 = new byte[i3];
                this.bs.get(bArr2);
                try {
                    str3 = new String(bArr2, this.sServerEncoding);
                } catch (UnsupportedEncodingException unused2) {
                    str3 = new String(bArr2);
                }
                return str3;
            default:
                throw new JceDecodeException("type mismatch.");
        }
    }

    public String readString(int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        switch (headData.type) {
            case 6:
                int i2 = this.bs.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                byte[] bArr = new byte[i2];
                this.bs.get(bArr);
                try {
                    return new String(bArr, this.sServerEncoding);
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr);
                }
            case 7:
                int i3 = this.bs.getInt();
                if (i3 > 104857600 || i3 < 0) {
                    throw new JceDecodeException("String too long: " + i3);
                }
                byte[] bArr2 = new byte[i3];
                this.bs.get(bArr2);
                try {
                    return new String(bArr2, this.sServerEncoding);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            default:
                throw new JceDecodeException("type mismatch.");
        }
    }

    public String[] read(String[] strArr, int i, boolean z) {
        return (String[]) readArray(strArr, i, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, String> readStringMap(int i, boolean z) {
        HashMap hashMap = new HashMap();
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 8) {
                int read = read(0, 0, true);
                if (read < 0) {
                    throw new JceDecodeException("size invalid: " + read);
                }
                for (int i2 = 0; i2 < read; i2++) {
                    hashMap.put(readString(0, true), readString(1, true));
                }
            } else {
                throw new JceDecodeException("type mismatch.");
            }
        } else if (z) {
            throw new JceDecodeException("require field not exist.");
        }
        return hashMap;
    }

    public <K, V> HashMap<K, V> readMap(Map<K, V> map, int i, boolean z) {
        return (HashMap) readMap(new HashMap(), map, i, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> readMap(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Map.Entry<K, V> next = map2.entrySet().iterator().next();
        K key = next.getKey();
        V value = next.getValue();
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 8) {
                int read = read(0, 0, true);
                if (read < 0) {
                    throw new JceDecodeException("size invalid: " + read);
                }
                for (int i2 = 0; i2 < read; i2++) {
                    map.put(read((JceInputStream) key, 0, true), read((JceInputStream) value, 1, true));
                }
            } else {
                throw new JceDecodeException("type mismatch.");
            }
        } else if (z) {
            throw new JceDecodeException("require field not exist.");
        }
        return map;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List readList(int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (skipToTag(i)) {
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type == 9) {
                int read = read(0, 0, true);
                if (read < 0) {
                    throw new JceDecodeException("size invalid: " + read);
                }
                for (int i2 = 0; i2 < read; i2++) {
                    HeadData headData2 = new HeadData();
                    readHead(headData2);
                    switch (headData2.type) {
                        case 0:
                            skip(1);
                            break;
                        case 1:
                            skip(2);
                            break;
                        case 2:
                            skip(4);
                            break;
                        case 3:
                            skip(8);
                            break;
                        case 4:
                            skip(4);
                            break;
                        case 5:
                            skip(8);
                            break;
                        case 6:
                            int i3 = this.bs.get();
                            if (i3 < 0) {
                                i3 += 256;
                            }
                            skip(i3);
                            break;
                        case 7:
                            skip(this.bs.getInt());
                            break;
                        case 8:
                        case 9:
                            break;
                        case 10:
                            try {
                                JceStruct jceStruct = (JceStruct) Class.forName(JceStruct.class.getName()).getConstructor(new Class[0]).newInstance(new Object[0]);
                                jceStruct.readFrom(this);
                                skipToStructEnd();
                                arrayList.add(jceStruct);
                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                                throw new JceDecodeException("type mismatch." + e);
                            }
                        case 11:
                        default:
                            throw new JceDecodeException("type mismatch.");
                        case 12:
                            arrayList.add(new Integer(0));
                            break;
                    }
                }
            } else {
                throw new JceDecodeException("type mismatch.");
            }
        } else if (z) {
            throw new JceDecodeException("require field not exist.");
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean[] read(boolean[] zArr, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        if (headData.type == 9) {
            int read = read(0, 0, true);
            if (read < 0) {
                throw new JceDecodeException("size invalid: " + read);
            }
            boolean[] zArr2 = new boolean[read];
            for (int i2 = 0; i2 < read; i2++) {
                zArr2[i2] = read(zArr2[0], 0, true);
            }
            return zArr2;
        }
        throw new JceDecodeException("type mismatch.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte[] read(byte[] bArr, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        byte b = headData.type;
        if (b == 9) {
            int read = read(0, 0, true);
            if (read < 0) {
                throw new JceDecodeException("size invalid: " + read);
            }
            byte[] bArr2 = new byte[read];
            for (int i2 = 0; i2 < read; i2++) {
                bArr2[i2] = read(bArr2[0], 0, true);
            }
            return bArr2;
        }
        if (b == 13) {
            HeadData headData2 = new HeadData();
            readHead(headData2);
            if (headData2.type != 0) {
                throw new JceDecodeException("type mismatch, tag: " + i + ", type: " + ((int) headData.type) + ", " + ((int) headData2.type));
            }
            int read2 = read(0, 0, true);
            if (read2 < 0) {
                throw new JceDecodeException("invalid size, tag: " + i + ", type: " + ((int) headData.type) + ", " + ((int) headData2.type) + ", size: " + read2);
            }
            byte[] bArr3 = new byte[read2];
            this.bs.get(bArr3);
            return bArr3;
        }
        throw new JceDecodeException("type mismatch.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public short[] read(short[] sArr, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        if (headData.type == 9) {
            int read = read(0, 0, true);
            if (read < 0) {
                throw new JceDecodeException("size invalid: " + read);
            }
            short[] sArr2 = new short[read];
            for (int i2 = 0; i2 < read; i2++) {
                sArr2[i2] = read(sArr2[0], 0, true);
            }
            return sArr2;
        }
        throw new JceDecodeException("type mismatch.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int[] read(int[] iArr, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        if (headData.type == 9) {
            int read = read(0, 0, true);
            if (read < 0) {
                throw new JceDecodeException("size invalid: " + read);
            }
            int[] iArr2 = new int[read];
            for (int i2 = 0; i2 < read; i2++) {
                iArr2[i2] = read(iArr2[0], 0, true);
            }
            return iArr2;
        }
        throw new JceDecodeException("type mismatch.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long[] read(long[] jArr, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        if (headData.type == 9) {
            int read = read(0, 0, true);
            if (read < 0) {
                throw new JceDecodeException("size invalid: " + read);
            }
            long[] jArr2 = new long[read];
            for (int i2 = 0; i2 < read; i2++) {
                jArr2[i2] = read(jArr2[0], 0, true);
            }
            return jArr2;
        }
        throw new JceDecodeException("type mismatch.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float[] read(float[] fArr, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        if (headData.type == 9) {
            int read = read(0, 0, true);
            if (read < 0) {
                throw new JceDecodeException("size invalid: " + read);
            }
            float[] fArr2 = new float[read];
            for (int i2 = 0; i2 < read; i2++) {
                fArr2[i2] = read(fArr2[0], 0, true);
            }
            return fArr2;
        }
        throw new JceDecodeException("type mismatch.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double[] read(double[] dArr, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        if (headData.type == 9) {
            int read = read(0, 0, true);
            if (read < 0) {
                throw new JceDecodeException("size invalid: " + read);
            }
            double[] dArr2 = new double[read];
            for (int i2 = 0; i2 < read; i2++) {
                dArr2[i2] = read(dArr2[0], 0, true);
            }
            return dArr2;
        }
        throw new JceDecodeException("type mismatch.");
    }

    public <T> T[] readArray(T[] tArr, int i, boolean z) {
        if (tArr == null || tArr.length == 0) {
            throw new JceDecodeException("unable to get type of key and value.");
        }
        return (T[]) readArrayImpl(tArr[0], i, z);
    }

    public <T> List<T> readArray(List<T> list, int i, boolean z) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        Object[] readArrayImpl = readArrayImpl(list.get(0), i, z);
        if (readArrayImpl == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : readArrayImpl) {
            arrayList.add(obj);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private <T> T[] readArrayImpl(T t, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        HeadData headData = new HeadData();
        readHead(headData);
        if (headData.type == 9) {
            int read = read(0, 0, true);
            if (read < 0) {
                throw new JceDecodeException("size invalid: " + read);
            }
            T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), read));
            for (int i2 = 0; i2 < read; i2++) {
                tArr[i2] = read((JceInputStream) t, 0, true);
            }
            return tArr;
        }
        throw new JceDecodeException("type mismatch.");
    }

    public JceStruct directRead(JceStruct jceStruct, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        try {
            JceStruct newInit = jceStruct.newInit();
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type != 10) {
                throw new JceDecodeException("type mismatch.");
            }
            newInit.readFrom(this);
            skipToStructEnd();
            return newInit;
        } catch (Exception e) {
            throw new JceDecodeException(e.getMessage());
        }
    }

    public JceStruct read(JceStruct jceStruct, int i, boolean z) {
        if (!skipToTag(i)) {
            if (z) {
                throw new JceDecodeException("require field not exist.");
            }
            return null;
        }
        try {
            JceStruct jceStruct2 = (JceStruct) jceStruct.getClass().newInstance();
            HeadData headData = new HeadData();
            readHead(headData);
            if (headData.type != 10) {
                throw new JceDecodeException("type mismatch.");
            }
            jceStruct2.readFrom(this);
            skipToStructEnd();
            return jceStruct2;
        } catch (Exception e) {
            throw new JceDecodeException(e.getMessage());
        }
    }

    public JceStruct[] read(JceStruct[] jceStructArr, int i, boolean z) {
        return (JceStruct[]) readArray(jceStructArr, i, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object read(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(read((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(read(false, i, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(read((short) 0, i, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(read(0, i, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(read(0L, i, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(read(0.0f, i, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(read(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, i, z));
        }
        if (t instanceof String) {
            return readString(i, z);
        }
        if (t instanceof Map) {
            return readMap((Map) t, i, z);
        }
        if (t instanceof List) {
            return readArray((List) t, i, z);
        }
        if (t instanceof JceStruct) {
            return read((JceStruct) t, i, z);
        }
        if (t.getClass().isArray()) {
            if ((t instanceof byte[]) || (t instanceof Byte[])) {
                return read((byte[]) null, i, z);
            }
            if (t instanceof boolean[]) {
                return read((boolean[]) null, i, z);
            }
            if (t instanceof short[]) {
                return read((short[]) null, i, z);
            }
            if (t instanceof int[]) {
                return read((int[]) null, i, z);
            }
            if (t instanceof long[]) {
                return read((long[]) null, i, z);
            }
            if (t instanceof float[]) {
                return read((float[]) null, i, z);
            }
            if (t instanceof double[]) {
                return read((double[]) null, i, z);
            }
            return readArray((Object[]) t, i, z);
        }
        throw new JceDecodeException("read object error: unsupport type.");
    }

    public int setServerEncoding(String str) {
        this.sServerEncoding = str;
        return 0;
    }

    public ByteBuffer getBs() {
        return this.bs;
    }
}
