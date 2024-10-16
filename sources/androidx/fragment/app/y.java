package androidx.fragment.app;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
final class y extends Writer {

    /* renamed from: a, reason: collision with root package name */
    private final String f702a;
    private StringBuilder b = new StringBuilder(128);

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(String str) {
        this.f702a = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                a();
            } else {
                this.b.append(c);
            }
        }
    }

    private void a() {
        if (this.b.length() > 0) {
            Log.d(this.f702a, this.b.toString());
            StringBuilder sb = this.b;
            sb.delete(0, sb.length());
        }
    }
}
