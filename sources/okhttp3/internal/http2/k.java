package okhttp3.internal.http2;

import com.google.android.gms.games.request.GameRequest;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private int f7138a;
    private final int[] b = new int[10];

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f7138a = 0;
        Arrays.fill(this.b, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k a(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.b;
            if (i < iArr.length) {
                this.f7138a = (1 << i) | this.f7138a;
                iArr[i] = i2;
                return this;
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        return ((1 << i) & this.f7138a) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i) {
        return this.b[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return Integer.bitCount(this.f7138a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        if ((this.f7138a & 2) != 0) {
            return this.b[1];
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i) {
        return (this.f7138a & 16) != 0 ? this.b[4] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i) {
        return (this.f7138a & 32) != 0 ? this.b[5] : i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return (this.f7138a & 128) != 0 ? this.b[7] : GameRequest.TYPE_ALL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(k kVar) {
        for (int i = 0; i < 10; i++) {
            if (kVar.a(i)) {
                a(i, kVar.b(i));
            }
        }
    }
}
