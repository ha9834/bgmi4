package okhttp3.internal.d;

import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public interface a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f7092a = new a() { // from class: okhttp3.internal.d.a.1
        @Override // okhttp3.internal.d.a
        public void a(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // okhttp3.internal.d.a
        public boolean b(File file) {
            return file.exists();
        }

        @Override // okhttp3.internal.d.a
        public long c(File file) {
            return file.length();
        }

        @Override // okhttp3.internal.d.a
        public void a(File file, File file2) throws IOException {
            a(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }
    };

    void a(File file) throws IOException;

    void a(File file, File file2) throws IOException;

    boolean b(File file);

    long c(File file);
}
