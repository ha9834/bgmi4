package com.android.vending.expansion.zipfile;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.games.request.GameRequest;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class a {
    private HashMap<String, C0070a> c = new HashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public HashMap<File, ZipFile> f995a = new HashMap<>();
    ByteBuffer b = ByteBuffer.allocate(4);

    private static int a(int i) {
        return ((i & 255) << 24) + ((65280 & i) << 8) + ((16711680 & i) >>> 8) + ((i >>> 24) & 255);
    }

    /* renamed from: com.android.vending.expansion.zipfile.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0070a {

        /* renamed from: a, reason: collision with root package name */
        public final File f996a;
        public final String b;
        public final String c;
        public long d;
        public int e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j = -1;

        public C0070a(String str, File file, String str2) {
            this.b = str2;
            this.c = str;
            this.f996a = file;
        }

        public void a(RandomAccessFile randomAccessFile, ByteBuffer byteBuffer) throws IOException {
            long j = this.d;
            try {
                randomAccessFile.seek(j);
                randomAccessFile.readFully(byteBuffer.array());
                if (byteBuffer.getInt(0) != 67324752) {
                    Log.w("zipro", "didn't find signature at start of lfh");
                    throw new IOException();
                }
                this.j = j + 30 + (byteBuffer.getShort(26) & ISelectionInterface.HELD_NOTHING) + (byteBuffer.getShort(28) & ISelectionInterface.HELD_NOTHING);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        public long a() {
            return this.j;
        }

        public boolean b() {
            return this.e == 0;
        }

        public AssetFileDescriptor c() {
            if (this.e != 0) {
                return null;
            }
            try {
                return new AssetFileDescriptor(ParcelFileDescriptor.open(this.f996a, DriveFile.MODE_READ_ONLY), a(), this.i);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }

        public String d() {
            return this.c;
        }

        public File e() {
            return this.f996a;
        }
    }

    public a(String str) throws IOException {
        b(str);
    }

    public C0070a[] a() {
        Collection<C0070a> values = this.c.values();
        return (C0070a[]) values.toArray(new C0070a[values.size()]);
    }

    public InputStream a(String str) throws IOException {
        C0070a c0070a = this.c.get(str);
        if (c0070a == null) {
            return null;
        }
        if (c0070a.b()) {
            return c0070a.c().createInputStream();
        }
        ZipFile zipFile = this.f995a.get(c0070a.e());
        if (zipFile == null) {
            zipFile = new ZipFile(c0070a.e(), 1);
            this.f995a.put(c0070a.e(), zipFile);
        }
        ZipEntry entry = zipFile.getEntry(str);
        if (entry != null) {
            return zipFile.getInputStream(entry);
        }
        return null;
    }

    private static int a(RandomAccessFile randomAccessFile) throws EOFException, IOException {
        return a(randomAccessFile.readInt());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void b(String str) throws IOException {
        File file = new File(str);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new IOException();
        }
        long j = 65557 > length ? length : 65557L;
        randomAccessFile.seek(0L);
        int a2 = a(randomAccessFile);
        if (a2 == 101010256) {
            Log.i("zipro", "Found Zip archive, but it looks empty");
            throw new IOException();
        }
        if (a2 != 67324752) {
            Log.v("zipro", "Not a Zip archive");
            throw new IOException();
        }
        randomAccessFile.seek(length - j);
        ByteBuffer allocate = ByteBuffer.allocate((int) j);
        byte[] array = allocate.array();
        randomAccessFile.readFully(array);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        int length2 = array.length - 22;
        while (length2 >= 0 && (array[length2] != 80 || allocate.getInt(length2) != 101010256)) {
            length2--;
        }
        if (length2 < 0) {
            Log.d("zipro", "Zip: EOCD not found, " + str + " is not zip");
        }
        short s = allocate.getShort(length2 + 8);
        long j2 = allocate.getInt(length2 + 12) & 4294967295L;
        long j3 = allocate.getInt(length2 + 16) & 4294967295L;
        if (j3 + j2 > length) {
            Log.w("zipro", "bad offsets (dir " + j3 + ", size " + j2 + ", eocd " + length2 + ")");
            throw new IOException();
        }
        if (s == 0) {
            Log.w("zipro", "empty archive?");
            throw new IOException();
        }
        MappedByteBuffer map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, j3, j2);
        map.order(ByteOrder.LITTLE_ENDIAN);
        short s2 = ISelectionInterface.HELD_NOTHING;
        byte[] bArr = new byte[GameRequest.TYPE_ALL];
        ByteBuffer allocate2 = ByteBuffer.allocate(30);
        allocate2.order(ByteOrder.LITTLE_ENDIAN);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < s) {
            if (map.getInt(i3) != 33639248) {
                Log.w("zipro", "Missed a central dir sig (at " + i3 + ")");
                throw new IOException();
            }
            int i4 = map.getShort(i3 + 28) & s2;
            int i5 = map.getShort(i3 + 30) & s2;
            int i6 = map.getShort(i3 + 32) & s2;
            map.position(i3 + 46);
            map.get(bArr, i, i4);
            map.position(i);
            String str2 = new String(bArr, i, i4);
            C0070a c0070a = new C0070a(str, file, str2);
            c0070a.e = map.getShort(i3 + 10) & s2;
            c0070a.f = map.getInt(i3 + 12) & 4294967295L;
            c0070a.g = map.getLong(i3 + 16) & 4294967295L;
            c0070a.h = map.getLong(i3 + 20) & 4294967295L;
            c0070a.i = map.getLong(i3 + 24) & 4294967295L;
            c0070a.d = map.getInt(i3 + 42) & 4294967295L;
            allocate2.clear();
            c0070a.a(randomAccessFile, allocate2);
            this.c.put(str2, c0070a);
            i3 += i4 + 46 + i5 + i6;
            i2++;
            bArr = bArr;
            s2 = ISelectionInterface.HELD_NOTHING;
            i = 0;
        }
    }
}
