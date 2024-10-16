package com.samsung.android.game.compatibility;

import android.os.MemoryFile;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;

/* loaded from: classes2.dex */
public class SharedMemory implements Parcelable, Closeable {
    public static final Parcelable.Creator<SharedMemory> CREATOR = new Parcelable.Creator<SharedMemory>() { // from class: com.samsung.android.game.compatibility.SharedMemory.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SharedMemory createFromParcel(Parcel parcel) {
            return new SharedMemory(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SharedMemory[] newArray(int i) {
            return new SharedMemory[i];
        }
    };
    private static final String LOG_TAG = "SharedMemory";
    private FileDescriptor mFd;
    private MemoryFile mFile;
    private int mSize;
    private boolean mWriteable;

    private SharedMemory(Parcel parcel) {
        this.mWriteable = false;
        this.mFd = parcel.readFileDescriptor().getFileDescriptor();
        this.mSize = parcel.readInt();
    }

    public SharedMemory(String str, int i) {
        this.mFile = new MemoryFile(str, i);
        this.mSize = i;
        this.mWriteable = true;
        try {
            this.mFd = (FileDescriptor) this.mFile.getClass().getDeclaredMethod("getFileDescriptor", new Class[0]).invoke(this.mFile, new Object[0]);
        } catch (Exception unused) {
            throw new IOException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    public int length() {
        return this.mSize;
    }

    public void readBytes(byte[] bArr, int i, int i2, int i3) {
        if (!this.mWriteable) {
            throw new IOException();
        }
        this.mFile.readBytes(bArr, i, i2, i3);
    }

    public void writeBytes(byte[] bArr, int i, int i2, int i3) {
        if (!this.mWriteable) {
            throw new IOException();
        }
        this.mFile.writeBytes(bArr, i, i2, i3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFileDescriptor(this.mFd);
        parcel.writeInt(this.mSize);
    }
}
