package com.tencent.midas.comm.log.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogInfo;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.processor.APLogCompressor;
import com.tencent.midas.comm.log.processor.APLogEncryptor;
import com.tencent.midas.comm.log.processor.APLogWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Locale;

/* loaded from: classes.dex */
public class APLogAppender {
    private static final int AUTO_FLUSH_INTERVAL = 15000;
    private static final int BUFFER_BLOCK_SIZE = 153600;
    private static final int POSITION_INIT = 12;
    private static APLogAppender instance;
    private static boolean stopAutoFlush;
    private Handler autoFlushHandler;
    private HandlerThread autoFlushThread;
    private APLogCompressor mCompressor = null;
    private APLogEncryptor mEncryptor = null;
    private APLogWriter mWriter = null;
    private RandomAccessFile randomAccessFile = null;
    private FileChannel fileChannel = null;
    private MappedByteBuffer mappedByteBuffer = null;
    private Runnable autoFlushRunnable = new Runnable() { // from class: com.tencent.midas.comm.log.internal.APLogAppender.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                Log.d(APLogInfo.LOG_TAG, "auto flush");
                APLogAppender.this.flushAndWrite();
                if (!APLogAppender.stopAutoFlush) {
                    if (APLogAppender.this.autoFlushHandler != null) {
                        APLogAppender.this.autoFlushHandler.postDelayed(APLogAppender.this.autoFlushRunnable, 15000L);
                        return;
                    }
                    return;
                }
                Log.d(APLogInfo.LOG_TAG, "stop auto flush");
            } catch (Throwable th) {
                Log.e(APLogInfo.LOG_TAG, "auto flush error: " + th.getMessage());
            }
        }
    };
    private volatile long seq = 12;
    private final byte[] _bytes = new byte[0];
    private final String SPACE = " ";
    private byte[] EMPTY_BUFFER = new byte[BUFFER_BLOCK_SIZE];
    private String FLAG_BEGIN = "============mmap cache begin===========\r\n";
    private String FLAG_END = "============mmap cache end=============\r\n";

    private APLogAppender() {
        this.autoFlushThread = null;
        this.autoFlushHandler = null;
        this.autoFlushThread = new HandlerThread("LOG-FLUSH");
        this.autoFlushThread.start();
        this.autoFlushHandler = new Handler(this.autoFlushThread.getLooper());
    }

    public static APLogAppender open() {
        Log.w(APLogInfo.LOG_TAG, "open log appender");
        APLogAppender aPLogAppender = instance;
        if (aPLogAppender != null) {
            return aPLogAppender;
        }
        instance = new APLogAppender();
        instance.createBufferProcessor();
        instance.openMmapFile();
        instance.initMmap();
        instance.startAutoFlush();
        return instance;
    }

    private void openMmapFile() {
        try {
            this.randomAccessFile = new RandomAccessFile(APLogFileInfo.mmapName, "rw");
            this.fileChannel = this.randomAccessFile.getChannel();
            this.mappedByteBuffer = this.fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, 153600L);
        } catch (Throwable th) {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "open log mmap file error: <%s>%s", th.getClass().getName(), th.getMessage()));
            th.printStackTrace();
        }
    }

    private void initMmap() {
        if (this.mappedByteBuffer == null) {
            return;
        }
        checkAndFlushBuffer();
        this.mappedByteBuffer.putLong(0, 12L);
        this.mappedByteBuffer.putInt(8, 41);
        resetPosAndSeq();
    }

    private void createBufferProcessor() {
        if (APLog.getLogInfo() != null && APLog.getLogInfo().isCompressLog()) {
            this.mCompressor = APLogCompressor.create();
        }
        if (APLog.getLogInfo() != null && APLog.getLogInfo().isEncryptLog()) {
            this.mEncryptor = APLogEncryptor.create();
        }
        this.mWriter = APLogWriter.create();
    }

    private void startAutoFlush() {
        if (APLog.getLogInfo() == null || !APLog.getLogInfo().isAutoFlush()) {
            return;
        }
        try {
            Log.d(APLogInfo.LOG_TAG, "start auto flush");
            this.autoFlushHandler.postDelayed(this.autoFlushRunnable, 15000L);
        } catch (Throwable th) {
            Log.e(APLogInfo.LOG_TAG, "start auto flush error: " + th.getMessage());
        }
    }

    private void stopAutoFlush() {
        stopAutoFlush = true;
    }

    public void append(String str) {
        try {
            updateMmap(process(str));
        } catch (Throwable th) {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "append log error: <%s> %s", th.getClass().getName(), th.getMessage()));
        }
    }

    public synchronized void updateMmap(byte[] bArr) {
        if (this.seq + bArr.length > 102400) {
            checkAndFlushBuffer();
        }
        if (this.mappedByteBuffer == null) {
            return;
        }
        this.mappedByteBuffer.put(bArr);
        this.seq += bArr.length;
        this.mappedByteBuffer.putLong(0, this.seq);
    }

    private synchronized byte[] process(String str) {
        byte[] bytes;
        try {
            bytes = (System.currentTimeMillis() + " " + str).getBytes();
            if (this.mCompressor != null) {
                bytes = this.mCompressor.compress(bytes);
            }
            if (this.mEncryptor != null) {
                bytes = this.mEncryptor.encrypt(bytes);
            }
        } catch (Throwable th) {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "process log error: <%s>%s", th.getClass().getName(), th.getMessage()));
            return this._bytes;
        }
        return bytes;
    }

    private synchronized void checkAndFlushBuffer() {
        try {
        } catch (Throwable th) {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "check and flush buffer error: <%s>%s", th.getClass().getName(), th.getMessage()));
        }
        if (this.mappedByteBuffer == null) {
            return;
        }
        int i = (int) this.mappedByteBuffer.getLong(0);
        if (i <= 12) {
            this.seq = 12L;
        } else {
            flushBuffer(i - 12);
        }
    }

    private void flushBuffer(int i) {
        if (this.mappedByteBuffer == null) {
            return;
        }
        if (i > BUFFER_BLOCK_SIZE) {
            i = BUFFER_BLOCK_SIZE;
        }
        byte[] bArr = new byte[i];
        this.mappedByteBuffer.position(12);
        this.mappedByteBuffer.get(bArr);
        Log.d(APLogInfo.LOG_TAG, "__flush and write data size: " + i);
        this.mWriter.write(bArr, process(this.FLAG_BEGIN), process(this.FLAG_END));
        this.mappedByteBuffer.position(12);
        this.mappedByteBuffer.put(this.EMPTY_BUFFER, 12, i);
        this.mappedByteBuffer.putLong(0, 0L);
        resetPosAndSeq();
    }

    private void resetPosAndSeq() {
        MappedByteBuffer mappedByteBuffer = this.mappedByteBuffer;
        if (mappedByteBuffer == null) {
            return;
        }
        this.seq = 12L;
        mappedByteBuffer.position(12);
    }

    public void flushAndWrite() {
        try {
            checkAndFlushBuffer();
            if (this.mWriter != null) {
                this.mWriter.flush();
            }
        } catch (Throwable th) {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "flush buffer and write error: <%s>%s", th.getClass().getName(), th.getMessage()));
        }
    }
}
