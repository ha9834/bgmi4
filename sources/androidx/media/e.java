package androidx.media;

import android.os.Build;
import android.util.Log;
import androidx.media.g;
import androidx.media.h;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    static final boolean f835a = Log.isLoggable("MediaSessionManager", 3);
    private static final Object b = new Object();

    /* loaded from: classes.dex */
    interface b {
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        b f836a;

        public a(String str, int i, int i2) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f836a = new g.a(str, i, i2);
            } else {
                this.f836a = new h.a(str, i, i2);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return this.f836a.equals(((a) obj).f836a);
            }
            return false;
        }

        public int hashCode() {
            return this.f836a.hashCode();
        }
    }
}
