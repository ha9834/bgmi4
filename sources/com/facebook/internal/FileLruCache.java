package com.facebook.internal;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.amazonaws.services.s3.internal.Constants;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;
import kotlin.k;
import kotlin.text.d;
import kotlin.text.l;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes.dex */
public final class FileLruCache {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_CACHEKEY_KEY = "key";
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    private static final String TAG;
    private static final AtomicLong bufferIndex;
    private final Condition condition;
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;
    private final AtomicLong lastClearCacheTime;
    private final Limits limits;
    private final ReentrantLock lock;
    private final String tag;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface StreamCloseCallback {
        void onClose();
    }

    public final InputStream get(String str) throws IOException {
        return get$default(this, str, null, 2, null);
    }

    public final OutputStream openPutStream(String str) throws IOException {
        return openPutStream$default(this, str, null, 2, null);
    }

    public FileLruCache(String str, Limits limits) {
        h.b(str, "tag");
        h.b(limits, "limits");
        this.tag = str;
        this.limits = limits;
        this.directory = new File(FacebookSdk.getCacheDir(), this.tag);
        this.lock = new ReentrantLock();
        this.condition = this.lock.newCondition();
        this.lastClearCacheTime = new AtomicLong(0L);
        if (this.directory.mkdirs() || this.directory.isDirectory()) {
            BufferFile.INSTANCE.deleteAll(this.directory);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long sizeInBytesForTest() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                if (!this.isTrimPending && !this.isTrimInProgress) {
                    break;
                }
                try {
                    this.condition.await();
                } catch (InterruptedException unused) {
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        k kVar = k.f6974a;
        reentrantLock.unlock();
        File[] listFiles = this.directory.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (File file : listFiles) {
                j += file.length();
            }
        }
        return j;
    }

    public static /* synthetic */ InputStream get$default(FileLruCache fileLruCache, String str, String str2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str2 = (String) null;
        }
        return fileLruCache.get(str, str2);
    }

    public final InputStream get(String str, String str2) throws IOException {
        h.b(str, "key");
        File file = new File(this.directory, Utility.md5hash(str));
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 8192);
            boolean z = false;
            try {
                JSONObject readHeader = StreamHeader.INSTANCE.readHeader(bufferedInputStream);
                if (readHeader != null) {
                    if (!(!h.a((Object) readHeader.optString("key"), (Object) str))) {
                        String optString = readHeader.optString("tag", null);
                        if (str2 != null || !(!h.a((Object) str2, (Object) optString))) {
                            long time = new Date().getTime();
                            Logger.Companion.log(LoggingBehavior.CACHE, TAG, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                            file.setLastModified(time);
                            try {
                                return bufferedInputStream;
                            } catch (Throwable th) {
                                th = th;
                                z = true;
                                if (!z) {
                                    bufferedInputStream.close();
                                }
                                throw th;
                            }
                        }
                        bufferedInputStream.close();
                        return null;
                    }
                    bufferedInputStream.close();
                    return null;
                }
                bufferedInputStream.close();
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static /* synthetic */ OutputStream openPutStream$default(FileLruCache fileLruCache, String str, String str2, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            str2 = (String) null;
        }
        return fileLruCache.openPutStream(str, str2);
    }

    public final OutputStream openPutStream(final String str, String str2) throws IOException {
        h.b(str, "key");
        final File newFile = BufferFile.INSTANCE.newFile(this.directory);
        newFile.delete();
        if (!newFile.createNewFile()) {
            throw new IOException("Could not create file at " + newFile.getAbsolutePath());
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(newFile);
            final long currentTimeMillis = System.currentTimeMillis();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new CloseCallbackOutputStream(fileOutputStream, new StreamCloseCallback() { // from class: com.facebook.internal.FileLruCache$openPutStream$renameToTargetCallback$1
                @Override // com.facebook.internal.FileLruCache.StreamCloseCallback
                public void onClose() {
                    AtomicLong atomicLong;
                    long j = currentTimeMillis;
                    atomicLong = FileLruCache.this.lastClearCacheTime;
                    if (j >= atomicLong.get()) {
                        FileLruCache.this.renameToTargetAndTrim(str, newFile);
                    } else {
                        newFile.delete();
                    }
                }
            }), 8192);
            boolean z = false;
            try {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", str);
                    if (!Utility.isNullOrEmpty(str2)) {
                        jSONObject.put("tag", str2);
                    }
                    StreamHeader.INSTANCE.writeHeader(bufferedOutputStream, jSONObject);
                    z = true;
                    return bufferedOutputStream;
                } catch (JSONException e) {
                    Logger.Companion.log(LoggingBehavior.CACHE, 5, TAG, "Error creating JSON header for cache file: " + e);
                    throw new IOException(e.getMessage());
                }
            } catch (Throwable th) {
                if (!z) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e2) {
            Logger.Companion.log(LoggingBehavior.CACHE, 5, TAG, "Error creating buffer output stream: " + e2);
            throw new IOException(e2.getMessage());
        }
    }

    public final void clearCache() {
        final File[] listFiles = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (listFiles != null) {
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.FileLruCache$clearCache$1
                @Override // java.lang.Runnable
                public final void run() {
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            for (File file : listFiles) {
                                file.delete();
                            }
                        } catch (Throwable th) {
                            CrashShieldHandler.handleThrowable(th, this);
                        }
                    } catch (Throwable th2) {
                        CrashShieldHandler.handleThrowable(th2, this);
                    }
                }
            });
        }
    }

    public final String getLocation() {
        String path = this.directory.getPath();
        h.a((Object) path, "directory.path");
        return path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renameToTargetAndTrim(String str, File file) {
        if (!file.renameTo(new File(this.directory, Utility.md5hash(str)))) {
            file.delete();
        }
        postTrim();
    }

    public final InputStream interceptAndPut(String str, InputStream inputStream) throws IOException {
        h.b(str, "key");
        h.b(inputStream, EvaluateItemInfo.ACTIONTYPE_INPUT);
        return new CopyingInputStream(inputStream, openPutStream$default(this, str, null, 2, null));
    }

    public String toString() {
        return "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
    }

    private final void postTrim() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (!this.isTrimPending) {
                this.isTrimPending = true;
                FacebookSdk.getExecutor().execute(new Runnable() { // from class: com.facebook.internal.FileLruCache$postTrim$$inlined$withLock$lambda$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (CrashShieldHandler.isObjectCrashing(this)) {
                            return;
                        }
                        try {
                            if (CrashShieldHandler.isObjectCrashing(this)) {
                                return;
                            }
                            try {
                                FileLruCache.this.trim();
                            } catch (Throwable th) {
                                CrashShieldHandler.handleThrowable(th, this);
                            }
                        } catch (Throwable th2) {
                            CrashShieldHandler.handleThrowable(th2, this);
                        }
                    }
                });
            }
            k kVar = k.f6974a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void trim() {
        long j;
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.isTrimPending = false;
            this.isTrimInProgress = true;
            k kVar = k.f6974a;
            reentrantLock.unlock();
            try {
                Logger.Companion.log(LoggingBehavior.CACHE, TAG, "trim started");
                PriorityQueue priorityQueue = new PriorityQueue();
                File[] listFiles = this.directory.listFiles(BufferFile.INSTANCE.excludeBufferFiles());
                long j2 = 0;
                if (listFiles != null) {
                    j = 0;
                    long j3 = 0;
                    for (File file : listFiles) {
                        h.a((Object) file, TransferTable.COLUMN_FILE);
                        ModifiedFile modifiedFile = new ModifiedFile(file);
                        priorityQueue.add(modifiedFile);
                        Logger.Companion.log(LoggingBehavior.CACHE, TAG, "  trim considering time=" + Long.valueOf(modifiedFile.getModified()) + " name=" + modifiedFile.getFile().getName());
                        j3 += file.length();
                        j++;
                    }
                    j2 = j3;
                } else {
                    j = 0;
                }
                while (true) {
                    if (j2 <= this.limits.getByteCount() && j <= this.limits.getFileCount()) {
                        this.lock.lock();
                        try {
                            this.isTrimInProgress = false;
                            this.condition.signalAll();
                            k kVar2 = k.f6974a;
                            return;
                        } finally {
                        }
                    }
                    File file2 = ((ModifiedFile) priorityQueue.remove()).getFile();
                    Logger.Companion.log(LoggingBehavior.CACHE, TAG, "  trim removing " + file2.getName());
                    j2 -= file2.length();
                    j += -1;
                    file2.delete();
                }
            } catch (Throwable th) {
                this.lock.lock();
                try {
                    this.isTrimInProgress = false;
                    this.condition.signalAll();
                    k kVar3 = k.f6974a;
                    throw th;
                } finally {
                }
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class BufferFile {
        private static final String FILE_NAME_PREFIX = "buffer";
        public static final BufferFile INSTANCE = new BufferFile();
        private static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter() { // from class: com.facebook.internal.FileLruCache$BufferFile$filterExcludeBufferFiles$1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                h.a((Object) str, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME);
                return !l.a(str, "buffer", false, 2, (Object) null);
            }
        };
        private static final FilenameFilter filterExcludeNonBufferFiles = new FilenameFilter() { // from class: com.facebook.internal.FileLruCache$BufferFile$filterExcludeNonBufferFiles$1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                h.a((Object) str, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_FILENAME);
                return l.a(str, "buffer", false, 2, (Object) null);
            }
        };

        private BufferFile() {
        }

        public final void deleteAll(File file) {
            h.b(file, "root");
            File[] listFiles = file.listFiles(excludeNonBufferFiles());
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    file2.delete();
                }
            }
        }

        public final FilenameFilter excludeBufferFiles() {
            return filterExcludeBufferFiles;
        }

        public final FilenameFilter excludeNonBufferFiles() {
            return filterExcludeNonBufferFiles;
        }

        public final File newFile(File file) {
            return new File(file, FILE_NAME_PREFIX + String.valueOf(FileLruCache.bufferIndex.incrementAndGet()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class StreamHeader {
        private static final int HEADER_VERSION = 0;
        public static final StreamHeader INSTANCE = new StreamHeader();

        private StreamHeader() {
        }

        public final void writeHeader(OutputStream outputStream, JSONObject jSONObject) throws IOException {
            h.b(outputStream, "stream");
            h.b(jSONObject, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            String jSONObject2 = jSONObject.toString();
            h.a((Object) jSONObject2, "header.toString()");
            Charset charset = d.f6980a;
            if (jSONObject2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = jSONObject2.getBytes(charset);
            h.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            outputStream.write(0);
            outputStream.write((bytes.length >> 16) & 255);
            outputStream.write((bytes.length >> 8) & 255);
            outputStream.write((bytes.length >> 0) & 255);
            outputStream.write(bytes);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final JSONObject readHeader(InputStream inputStream) throws IOException {
            h.b(inputStream, "stream");
            if (inputStream.read() != 0) {
                return null;
            }
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                int read = inputStream.read();
                if (read == -1) {
                    Logger.Companion.log(LoggingBehavior.CACHE, FileLruCache.Companion.getTAG(), "readHeader: stream.read returned -1 while reading header size");
                    return null;
                }
                i2 = (i2 << 8) + (read & 255);
            }
            byte[] bArr = new byte[i2];
            while (i < bArr.length) {
                int read2 = inputStream.read(bArr, i, bArr.length - i);
                if (read2 < 1) {
                    Logger.Companion.log(LoggingBehavior.CACHE, FileLruCache.Companion.getTAG(), "readHeader: stream.read stopped at " + Integer.valueOf(i) + " when expected " + bArr.length);
                    return null;
                }
                i += read2;
            }
            try {
                Object nextValue = new JSONTokener(new String(bArr, d.f6980a)).nextValue();
                if (!(nextValue instanceof JSONObject)) {
                    Logger.Companion.log(LoggingBehavior.CACHE, FileLruCache.Companion.getTAG(), "readHeader: expected JSONObject, got " + nextValue.getClass().getCanonicalName());
                    return null;
                }
                return (JSONObject) nextValue;
            } catch (JSONException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class CloseCallbackOutputStream extends OutputStream {
        private final StreamCloseCallback callback;
        private final OutputStream innerStream;

        public CloseCallbackOutputStream(OutputStream outputStream, StreamCloseCallback streamCloseCallback) {
            h.b(outputStream, "innerStream");
            h.b(streamCloseCallback, "callback");
            this.innerStream = outputStream;
            this.callback = streamCloseCallback;
        }

        public final StreamCloseCallback getCallback() {
            return this.callback;
        }

        public final OutputStream getInnerStream() {
            return this.innerStream;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.innerStream.close();
            } finally {
                this.callback.onClose();
            }
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.innerStream.flush();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            h.b(bArr, "buffer");
            this.innerStream.write(bArr, i, i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            h.b(bArr, "buffer");
            this.innerStream.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.innerStream.write(i);
        }
    }

    /* loaded from: classes.dex */
    private static final class CopyingInputStream extends InputStream {
        private final InputStream input;
        private final OutputStream output;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        public final InputStream getInput() {
            return this.input;
        }

        public final OutputStream getOutput() {
            return this.output;
        }

        public CopyingInputStream(InputStream inputStream, OutputStream outputStream) {
            h.b(inputStream, EvaluateItemInfo.ACTIONTYPE_INPUT);
            h.b(outputStream, "output");
            this.input = inputStream;
            this.output = outputStream;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.input.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                this.input.close();
            } finally {
                this.output.close();
            }
        }

        @Override // java.io.InputStream
        public void mark(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            h.b(bArr, "buffer");
            int read = this.input.read(bArr);
            if (read > 0) {
                this.output.write(bArr, 0, read);
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int read = this.input.read();
            if (read >= 0) {
                this.output.write(read);
            }
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            h.b(bArr, "buffer");
            int read = this.input.read(bArr, i, i2);
            if (read > 0) {
                this.output.write(bArr, i, read);
            }
            return read;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            throw new UnsupportedOperationException();
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            int read;
            byte[] bArr = new byte[1024];
            long j2 = 0;
            while (j2 < j && (read = read(bArr, 0, (int) Math.min(j - j2, bArr.length))) >= 0) {
                j2 += read;
            }
            return j2;
        }
    }

    /* loaded from: classes.dex */
    public static final class Limits {
        private int byteCount = Constants.MB;
        private int fileCount = 1024;

        public final int getByteCount() {
            return this.byteCount;
        }

        public final void setByteCount(int i) {
            if (i < 0) {
                throw new InvalidParameterException("Cache byte-count limit must be >= 0");
            }
            this.byteCount = i;
        }

        public final int getFileCount() {
            return this.fileCount;
        }

        public final void setFileCount(int i) {
            if (i < 0) {
                throw new InvalidParameterException("Cache file count limit must be >= 0");
            }
            this.fileCount = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ModifiedFile implements Comparable<ModifiedFile> {
        public static final Companion Companion = new Companion(null);
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        private final File file;
        private final long modified;

        public ModifiedFile(File file) {
            h.b(file, TransferTable.COLUMN_FILE);
            this.file = file;
            this.modified = this.file.lastModified();
        }

        public final File getFile() {
            return this.file;
        }

        public final long getModified() {
            return this.modified;
        }

        @Override // java.lang.Comparable
        public int compareTo(ModifiedFile modifiedFile) {
            h.b(modifiedFile, "another");
            long j = this.modified;
            long j2 = modifiedFile.modified;
            if (j < j2) {
                return -1;
            }
            if (j > j2) {
                return 1;
            }
            return this.file.compareTo(modifiedFile.file);
        }

        public boolean equals(Object obj) {
            return (obj instanceof ModifiedFile) && compareTo((ModifiedFile) obj) == 0;
        }

        public int hashCode() {
            return ((1073 + this.file.hashCode()) * 37) + ((int) (this.modified % Integer.MAX_VALUE));
        }

        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(f fVar) {
                this();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final String getTAG() {
            return FileLruCache.TAG;
        }
    }

    static {
        String simpleName = FileLruCache.class.getSimpleName();
        h.a((Object) simpleName, "FileLruCache::class.java.simpleName");
        TAG = simpleName;
        bufferIndex = new AtomicLong();
    }
}
