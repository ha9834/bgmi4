package com.twitter.sdk.android.core.internal.scribe;

import android.content.Context;
import com.twitter.sdk.android.core.internal.CommonUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class QueueFileEventStorage implements EventsStorage {
    private final Context context;
    private QueueFile queueFile;
    private File targetDirectory;
    private final String targetDirectoryName;
    private final File workingDirectory;
    private final File workingFile;

    public QueueFileEventStorage(Context context, File file, String str, String str2) throws IOException {
        this.context = context;
        this.workingDirectory = file;
        this.targetDirectoryName = str2;
        this.workingFile = new File(this.workingDirectory, str);
        this.queueFile = new QueueFile(this.workingFile);
        createTargetDirectory();
    }

    private void createTargetDirectory() {
        this.targetDirectory = new File(this.workingDirectory, this.targetDirectoryName);
        if (this.targetDirectory.exists()) {
            return;
        }
        this.targetDirectory.mkdirs();
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    public void add(byte[] bArr) throws IOException {
        this.queueFile.add(bArr);
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    public int getWorkingFileUsedSizeInBytes() {
        return this.queueFile.usedBytes();
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    public void rollOver(String str) throws IOException {
        this.queueFile.close();
        move(this.workingFile, new File(this.targetDirectory, str));
        this.queueFile = new QueueFile(this.workingFile);
    }

    private void move(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        OutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            outputStream = getMoveOutputStream(file2);
            CommonUtils.copyStream(fileInputStream, outputStream, new byte[1024]);
            CommonUtils.closeOrLog(fileInputStream, "Failed to close file input stream");
            CommonUtils.closeOrLog(outputStream, "Failed to close output stream");
            file.delete();
        } catch (Throwable th2) {
            th = th2;
            CommonUtils.closeOrLog(fileInputStream, "Failed to close file input stream");
            CommonUtils.closeOrLog(outputStream, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    public OutputStream getMoveOutputStream(File file) throws IOException {
        return new FileOutputStream(file);
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    public File getWorkingDirectory() {
        return this.workingDirectory;
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    public File getRollOverDirectory() {
        return this.targetDirectory;
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    public List<File> getBatchOfFilesToSend(int i) {
        ArrayList arrayList = new ArrayList();
        for (File file : this.targetDirectory.listFiles()) {
            arrayList.add(file);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    public void deleteFilesInRollOverDirectory(List<File> list) {
        for (File file : list) {
            CommonUtils.logControlled(this.context, String.format("deleting sent analytics file %s", file.getName()));
            file.delete();
        }
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    public List<File> getAllFilesInRollOverDirectory() {
        return Arrays.asList(this.targetDirectory.listFiles());
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    public void deleteWorkingFile() {
        try {
            this.queueFile.close();
        } catch (IOException unused) {
        }
        this.workingFile.delete();
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    public boolean isWorkingFileEmpty() {
        return this.queueFile.isEmpty();
    }

    @Override // com.twitter.sdk.android.core.internal.scribe.EventsStorage
    public boolean canWorkingFileStore(int i, int i2) {
        return this.queueFile.hasSpaceFor(i, i2);
    }
}
