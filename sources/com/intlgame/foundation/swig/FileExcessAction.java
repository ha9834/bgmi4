package com.intlgame.foundation.swig;

/* loaded from: classes2.dex */
public final class FileExcessAction {
    private final String swigName;
    private final int swigValue;
    public static final FileExcessAction kFileExcessActionReWrite = new FileExcessAction("kFileExcessActionReWrite", INTLFoundationJNI.kFileExcessActionReWrite_get());
    public static final FileExcessAction kFileExcessActionStopAppend = new FileExcessAction("kFileExcessActionStopAppend", INTLFoundationJNI.kFileExcessActionStopAppend_get());
    private static FileExcessAction[] swigValues = {kFileExcessActionReWrite, kFileExcessActionStopAppend};
    private static int swigNext = 0;

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FileExcessAction swigToEnum(int i) {
        FileExcessAction[] fileExcessActionArr = swigValues;
        if (i < fileExcessActionArr.length && i >= 0 && fileExcessActionArr[i].swigValue == i) {
            return fileExcessActionArr[i];
        }
        int i2 = 0;
        while (true) {
            FileExcessAction[] fileExcessActionArr2 = swigValues;
            if (i2 < fileExcessActionArr2.length) {
                if (fileExcessActionArr2[i2].swigValue == i) {
                    return fileExcessActionArr2[i2];
                }
                i2++;
            } else {
                throw new IllegalArgumentException("No enum " + FileExcessAction.class + " with value " + i);
            }
        }
    }

    private FileExcessAction(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private FileExcessAction(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private FileExcessAction(String str, FileExcessAction fileExcessAction) {
        this.swigName = str;
        this.swigValue = fileExcessAction.swigValue;
        swigNext = this.swigValue + 1;
    }
}
