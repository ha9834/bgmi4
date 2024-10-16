package com.tencent.midas.comm.log.processor;

import android.util.Log;
import com.tencent.midas.comm.APLogInfo;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Locale;

/* loaded from: classes.dex */
public class APLogWriter {
    private FileChannel fileChannel = null;
    private MappedByteBuffer mappedByteBuffer = null;
    private RandomAccessFile randomAccessFile = null;

    public static APLogWriter create() {
        APLogWriter aPLogWriter = new APLogWriter();
        aPLogWriter.openLogFile();
        return aPLogWriter;
    }

    private void openLogFile() {
        try {
            Log.d(APLogInfo.LOG_TAG, "open log file: " + APLogFileInfo.fileName);
            this.randomAccessFile = new RandomAccessFile(APLogFileInfo.fileName, "rw");
            this.fileChannel = this.randomAccessFile.getChannel();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void write(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            long refreshFileChannel = refreshFileChannel(bArr.length);
            long currentTimeMillis = System.currentTimeMillis();
            this.mappedByteBuffer = this.fileChannel.map(FileChannel.MapMode.READ_WRITE, refreshFileChannel, bArr.length + bArr2.length + bArr3.length);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            long currentTimeMillis3 = System.currentTimeMillis();
            this.mappedByteBuffer.put(bArr2);
            this.mappedByteBuffer.put(bArr);
            this.mappedByteBuffer.put(bArr3);
            this.mappedByteBuffer.force();
            Log.d(APLogInfo.LOG_TAG, "write map time: " + currentTimeMillis2 + ", sync time: " + (System.currentTimeMillis() - currentTimeMillis3));
            APLogFileUtil.deleteOldFileToday(APLogFileInfo.dirName);
        } catch (Throwable th) {
            Log.e(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "cache log to file error: <%s>%s", th.getClass().getName(), th.getMessage()));
        }
    }

    private long refreshFileChannel(long j) {
        long j2;
        try {
            j2 = this.fileChannel.size();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(APLogInfo.LOG_TAG, "get file channel size error");
            APLogFileInfo.updateFileName();
            openLogFile();
            j2 = 0;
        }
        long j3 = APLogFileUtil.maxLogFileSizeMB * 1024 * 1024;
        long j4 = (j + j2) - j3;
        Log.d(APLogInfo.LOG_TAG, String.format(Locale.CHINA, "size to write: %d, channel size: %d, limit: %d", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        if (j4 <= 0) {
            return j2;
        }
        Log.d(APLogInfo.LOG_TAG, "should refresh file name");
        APLogFileInfo.updateFileName();
        openLogFile();
        return 0L;
    }

    public void flush() {
        MappedByteBuffer mappedByteBuffer = this.mappedByteBuffer;
        if (mappedByteBuffer != null) {
            mappedByteBuffer.force();
        }
    }

    public void close() {
        try {
            if (this.fileChannel != null) {
                this.fileChannel.close();
            }
            if (this.randomAccessFile != null) {
                this.randomAccessFile.close();
            }
            if (this.mappedByteBuffer != null) {
                this.mappedByteBuffer.force();
                this.mappedByteBuffer.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
