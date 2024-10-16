package com.tencent.hawk.bridge;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes2.dex */
public class ProcFile extends File implements Parcelable {
    public static final Parcelable.Creator<ProcFile> CREATOR = new Parcelable.Creator<ProcFile>() { // from class: com.tencent.hawk.bridge.ProcFile.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProcFile createFromParcel(Parcel parcel) {
            return new ProcFile(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ProcFile[] newArray(int i) {
            return new ProcFile[i];
        }
    };
    private static final long serialVersionUID = 1;
    public final String content;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String readFile(String str) throws IOException {
        BufferedReader bufferedReader;
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new FileReader(str));
            try {
                String str2 = "";
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    sb.append(str2);
                    sb.append(readLine);
                    str2 = "\n";
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return sb2;
            } catch (Throwable th) {
                th = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    protected ProcFile(String str) throws IOException {
        super(str);
        this.content = readFile(str);
    }

    protected ProcFile(Parcel parcel) {
        super(parcel.readString());
        this.content = parcel.readString();
    }

    @Override // java.io.File
    public long length() {
        return this.content.length();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getAbsolutePath());
        parcel.writeString(this.content);
    }

    @Override // java.io.File
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj) || !(obj instanceof ProcFile)) {
            return false;
        }
        ProcFile procFile = (ProcFile) obj;
        if (procFile.content == null || this.content == null || !super.equals(obj) || !procFile.content.equals(this.content)) {
            return super.equals(obj) && procFile.content == null && this.content == null;
        }
        return true;
    }

    @Override // java.io.File
    public int hashCode() {
        int hashCode = super.hashCode();
        String str = this.content;
        return str == null ? hashCode : hashCode + str.hashCode();
    }
}
