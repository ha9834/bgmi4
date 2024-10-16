package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class TbsCoreLoadStat {
    private static TbsCoreLoadStat d = null;
    public static volatile int mLoadErrorCode = -1;

    /* renamed from: a, reason: collision with root package name */
    private TbsSequenceQueue f6462a = null;
    private boolean b = false;
    private final int c = 3;

    private TbsCoreLoadStat() {
    }

    public static TbsCoreLoadStat getInstance() {
        if (d == null) {
            d = new TbsCoreLoadStat();
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(Context context, int i, Throwable th) {
        if (mLoadErrorCode == -1) {
            mLoadErrorCode = i;
            TbsLog.d("TbsCoreLoadStat", "TbsCoreLoadStat--setLoadErrorCode errorCode=" + i);
            TbsLog.d("TbsCoreLoadStat", "TbsCoreLoadStat--setLoadErrorCode errorDetail=" + th);
            TbsLog.addLog(998, "code=%d,desc=%s", Integer.valueOf(i), String.valueOf(th));
            if (th != null) {
                TbsLogReport.getInstance(context).setLoadErrorCode(i, th);
            } else {
                TbsLog.e("TbsCoreLoadStat", "setLoadErrorCode :: error is null with errorCode: " + i + "; Check & correct it!");
            }
            return;
        }
        TbsLog.w("TbsCoreLoadStat", "setLoadErrorCode :: error(" + mLoadErrorCode + ") was already reported; " + i + " is duplicated. Try to remove it!");
    }

    /* loaded from: classes2.dex */
    public class TbsSequenceQueue {
        private int b;
        private int c;
        private int[] d;
        private int e;
        private int f;

        public TbsSequenceQueue() {
            this.b = 10;
            this.e = 0;
            this.f = 0;
            this.c = this.b;
            this.d = new int[this.c];
        }

        public TbsSequenceQueue(int i, int i2) {
            this.b = 10;
            this.e = 0;
            this.f = 0;
            this.c = i2;
            this.d = new int[this.c];
            this.d[0] = i;
            this.f++;
        }

        public int length() {
            return this.f - this.e;
        }

        public void add(int i) {
            int i2 = this.f;
            if (i2 > this.c - 1) {
                throw new IndexOutOfBoundsException("sequeue is full");
            }
            int[] iArr = this.d;
            this.f = i2 + 1;
            iArr[i2] = i;
        }

        public int remove() {
            if (empty()) {
                throw new IndexOutOfBoundsException("sequeue is null");
            }
            int[] iArr = this.d;
            int i = this.e;
            int i2 = iArr[i];
            this.e = i + 1;
            iArr[i] = 0;
            return i2;
        }

        public int element() {
            if (empty()) {
                throw new IndexOutOfBoundsException("sequeue is null");
            }
            return this.d[this.e];
        }

        public boolean empty() {
            return this.f == this.e;
        }

        public void clear() {
            Arrays.fill(this.d, 0);
            this.e = 0;
            this.f = 0;
        }

        public String toString() {
            if (empty()) {
                return "";
            }
            StringBuilder sb = new StringBuilder("[");
            for (int i = this.e; i < this.f; i++) {
                sb.append(String.valueOf(this.d[i]) + ",");
            }
            int length = sb.length();
            StringBuilder delete = sb.delete(length - 1, length);
            delete.append("]");
            return delete.toString();
        }
    }
}
