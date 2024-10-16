package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.VolleyLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class DiskBasedCache implements Cache {
    private static final int CACHE_MAGIC = 538247942;
    private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
    private static final float HYSTERESIS_FACTOR = 0.9f;
    private final Map<String, CacheHeader> mEntries;
    private final int mMaxCacheSizeInBytes;
    private final File mRootDirectory;
    private long mTotalSize;

    public DiskBasedCache(File file, int i) {
        this.mEntries = new LinkedHashMap(16, 0.75f, true);
        this.mTotalSize = 0L;
        this.mRootDirectory = file;
        this.mMaxCacheSizeInBytes = i;
    }

    public DiskBasedCache(File file) {
        this(file, DEFAULT_DISK_USAGE_BYTES);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Cache
    public synchronized void clear() {
        File[] listFiles = this.mRootDirectory.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                file.delete();
            }
        }
        this.mEntries.clear();
        this.mTotalSize = 0L;
        VolleyLog.d("Cache cleared.", new Object[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.volley.Cache
    public synchronized Cache.Entry get(String str) {
        File fileForKey;
        CountingInputStream countingInputStream;
        CacheHeader cacheHeader = this.mEntries.get(str);
        CountingInputStream countingInputStream2 = null;
        Object[] objArr = 0;
        if (cacheHeader == null) {
            return null;
        }
        try {
            fileForKey = getFileForKey(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            countingInputStream = new CountingInputStream(new BufferedInputStream(new FileInputStream(fileForKey)));
            try {
                CacheHeader.readHeader(countingInputStream);
                Cache.Entry cacheEntry = cacheHeader.toCacheEntry(streamToBytes(countingInputStream, (int) (fileForKey.length() - countingInputStream.bytesRead)));
                try {
                    countingInputStream.close();
                    return cacheEntry;
                } catch (IOException unused) {
                    return null;
                }
            } catch (IOException e) {
                e = e;
                VolleyLog.d("%s: %s", fileForKey.getAbsolutePath(), e.toString());
                remove(str);
                if (countingInputStream != null) {
                    try {
                        countingInputStream.close();
                    } catch (IOException unused2) {
                        return null;
                    }
                }
                return null;
            }
        } catch (IOException e2) {
            e = e2;
            countingInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
                try {
                    countingInputStream2.close();
                } catch (IOException unused3) {
                    return null;
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.android.volley.Cache
    public synchronized void initialize() {
        BufferedInputStream bufferedInputStream;
        if (!this.mRootDirectory.exists()) {
            if (!this.mRootDirectory.mkdirs()) {
                VolleyLog.e("Unable to create cache dir %s", this.mRootDirectory.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.mRootDirectory.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                CacheHeader readHeader = CacheHeader.readHeader(bufferedInputStream);
                readHeader.size = file.length();
                putEntry(readHeader.key, readHeader);
                try {
                    bufferedInputStream.close();
                } catch (IOException unused2) {
                }
            } catch (IOException unused3) {
                bufferedInputStream2 = bufferedInputStream;
                if (file != null) {
                    file.delete();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void invalidate(String str, boolean z) {
        Cache.Entry entry = get(str);
        if (entry != null) {
            entry.softTtl = 0L;
            if (z) {
                entry.ttl = 0L;
            }
            put(str, entry);
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void put(String str, Cache.Entry entry) {
        pruneIfNeeded(entry.data.length);
        File fileForKey = getFileForKey(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileForKey));
            CacheHeader cacheHeader = new CacheHeader(str, entry);
            if (!cacheHeader.writeHeader(bufferedOutputStream)) {
                bufferedOutputStream.close();
                VolleyLog.d("Failed to write header for %s", fileForKey.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(entry.data);
            bufferedOutputStream.close();
            putEntry(str, cacheHeader);
        } catch (IOException unused) {
            if (fileForKey.delete()) {
                return;
            }
            VolleyLog.d("Could not clean up file %s", fileForKey.getAbsolutePath());
        }
    }

    @Override // com.android.volley.Cache
    public synchronized void remove(String str) {
        boolean delete = getFileForKey(str).delete();
        removeEntry(str);
        if (!delete) {
            VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", str, getFilenameForKey(str));
        }
    }

    private String getFilenameForKey(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    public File getFileForKey(String str) {
        return new File(this.mRootDirectory, getFilenameForKey(str));
    }

    private void pruneIfNeeded(int i) {
        long j;
        long j2 = i;
        if (this.mTotalSize + j2 < this.mMaxCacheSizeInBytes) {
            return;
        }
        if (VolleyLog.DEBUG) {
            VolleyLog.v("Pruning old cache entries.", new Object[0]);
        }
        long j3 = this.mTotalSize;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, CacheHeader>> it = this.mEntries.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            CacheHeader value = it.next().getValue();
            if (getFileForKey(value.key).delete()) {
                j = j2;
                this.mTotalSize -= value.size;
            } else {
                j = j2;
                VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", value.key, getFilenameForKey(value.key));
            }
            it.remove();
            i2++;
            if (((float) (this.mTotalSize + j)) < this.mMaxCacheSizeInBytes * HYSTERESIS_FACTOR) {
                break;
            } else {
                j2 = j;
            }
        }
        if (VolleyLog.DEBUG) {
            VolleyLog.v("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.mTotalSize - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    private void putEntry(String str, CacheHeader cacheHeader) {
        if (!this.mEntries.containsKey(str)) {
            this.mTotalSize += cacheHeader.size;
        } else {
            this.mTotalSize += cacheHeader.size - this.mEntries.get(str).size;
        }
        this.mEntries.put(str, cacheHeader);
    }

    private void removeEntry(String str) {
        CacheHeader cacheHeader = this.mEntries.get(str);
        if (cacheHeader != null) {
            this.mTotalSize -= cacheHeader.size;
            this.mEntries.remove(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] streamToBytes(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CacheHeader {
        public String etag;
        public String key;
        public long lastModified;
        public Map<String, String> responseHeaders;
        public long serverDate;
        public long size;
        public long softTtl;
        public long ttl;

        private CacheHeader() {
        }

        public CacheHeader(String str, Cache.Entry entry) {
            this.key = str;
            this.size = entry.data.length;
            this.etag = entry.etag;
            this.serverDate = entry.serverDate;
            this.lastModified = entry.lastModified;
            this.ttl = entry.ttl;
            this.softTtl = entry.softTtl;
            this.responseHeaders = entry.responseHeaders;
        }

        public static CacheHeader readHeader(InputStream inputStream) throws IOException {
            CacheHeader cacheHeader = new CacheHeader();
            if (DiskBasedCache.readInt(inputStream) != DiskBasedCache.CACHE_MAGIC) {
                throw new IOException();
            }
            cacheHeader.key = DiskBasedCache.readString(inputStream);
            cacheHeader.etag = DiskBasedCache.readString(inputStream);
            if (cacheHeader.etag.equals("")) {
                cacheHeader.etag = null;
            }
            cacheHeader.serverDate = DiskBasedCache.readLong(inputStream);
            cacheHeader.lastModified = DiskBasedCache.readLong(inputStream);
            cacheHeader.ttl = DiskBasedCache.readLong(inputStream);
            cacheHeader.softTtl = DiskBasedCache.readLong(inputStream);
            cacheHeader.responseHeaders = DiskBasedCache.readStringStringMap(inputStream);
            return cacheHeader;
        }

        public Cache.Entry toCacheEntry(byte[] bArr) {
            Cache.Entry entry = new Cache.Entry();
            entry.data = bArr;
            entry.etag = this.etag;
            entry.serverDate = this.serverDate;
            entry.lastModified = this.lastModified;
            entry.ttl = this.ttl;
            entry.softTtl = this.softTtl;
            entry.responseHeaders = this.responseHeaders;
            return entry;
        }

        public boolean writeHeader(OutputStream outputStream) {
            try {
                DiskBasedCache.writeInt(outputStream, DiskBasedCache.CACHE_MAGIC);
                DiskBasedCache.writeString(outputStream, this.key);
                DiskBasedCache.writeString(outputStream, this.etag == null ? "" : this.etag);
                DiskBasedCache.writeLong(outputStream, this.serverDate);
                DiskBasedCache.writeLong(outputStream, this.lastModified);
                DiskBasedCache.writeLong(outputStream, this.ttl);
                DiskBasedCache.writeLong(outputStream, this.softTtl);
                DiskBasedCache.writeStringStringMap(this.responseHeaders, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                VolleyLog.d("%s", e.toString());
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class CountingInputStream extends FilterInputStream {
        private int bytesRead;

        private CountingInputStream(InputStream inputStream) {
            super(inputStream);
            this.bytesRead = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.bytesRead++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.bytesRead += read;
            }
            return read;
        }
    }

    private static int read(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void writeInt(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int readInt(InputStream inputStream) throws IOException {
        return (read(inputStream) << 24) | (read(inputStream) << 0) | 0 | (read(inputStream) << 8) | (read(inputStream) << 16);
    }

    static void writeLong(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static long readLong(InputStream inputStream) throws IOException {
        return ((read(inputStream) & 255) << 0) | 0 | ((read(inputStream) & 255) << 8) | ((read(inputStream) & 255) << 16) | ((read(inputStream) & 255) << 24) | ((read(inputStream) & 255) << 32) | ((read(inputStream) & 255) << 40) | ((read(inputStream) & 255) << 48) | ((255 & read(inputStream)) << 56);
    }

    static void writeString(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        writeLong(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    static String readString(InputStream inputStream) throws IOException {
        return new String(streamToBytes(inputStream, (int) readLong(inputStream)), "UTF-8");
    }

    static void writeStringStringMap(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            writeInt(outputStream, map.size());
            for (Map.Entry<String, String> entry : map.entrySet()) {
                writeString(outputStream, entry.getKey());
                writeString(outputStream, entry.getValue());
            }
            return;
        }
        writeInt(outputStream, 0);
    }

    static Map<String, String> readStringStringMap(InputStream inputStream) throws IOException {
        int readInt = readInt(inputStream);
        Map<String, String> emptyMap = readInt == 0 ? Collections.emptyMap() : new HashMap<>(readInt);
        for (int i = 0; i < readInt; i++) {
            emptyMap.put(readString(inputStream).intern(), readString(inputStream).intern());
        }
        return emptyMap;
    }
}
