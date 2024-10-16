package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
public interface j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f7137a = new j() { // from class: okhttp3.internal.http2.j.1
        @Override // okhttp3.internal.http2.j
        public void a(int i, ErrorCode errorCode) {
        }

        @Override // okhttp3.internal.http2.j
        public boolean a(int i, List<a> list) {
            return true;
        }

        @Override // okhttp3.internal.http2.j
        public boolean a(int i, List<a> list, boolean z) {
            return true;
        }

        @Override // okhttp3.internal.http2.j
        public boolean a(int i, okio.e eVar, int i2, boolean z) throws IOException {
            eVar.i(i2);
            return true;
        }
    };

    void a(int i, ErrorCode errorCode);

    boolean a(int i, List<a> list);

    boolean a(int i, List<a> list, boolean z);

    boolean a(int i, okio.e eVar, int i2, boolean z) throws IOException;
}
