package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.media.e;

/* loaded from: classes.dex */
class g extends f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements e.b {

        /* renamed from: a, reason: collision with root package name */
        final MediaSessionManager.RemoteUserInfo f837a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str, int i, int i2) {
            this.f837a = new MediaSessionManager.RemoteUserInfo(str, i, i2);
        }

        public int hashCode() {
            return androidx.core.e.b.a(this.f837a);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                return this.f837a.equals(((a) obj).f837a);
            }
            return false;
        }
    }
}
