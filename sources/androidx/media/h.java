package androidx.media;

import android.text.TextUtils;
import androidx.media.e;

/* loaded from: classes.dex */
class h {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f838a = e.f835a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements e.b {

        /* renamed from: a, reason: collision with root package name */
        private String f839a;
        private int b;
        private int c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str, int i, int i2) {
            this.f839a = str;
            this.b = i;
            this.c = i2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.f839a, aVar.f839a) && this.b == aVar.b && this.c == aVar.c;
        }

        public int hashCode() {
            return androidx.core.e.b.a(this.f839a, Integer.valueOf(this.b), Integer.valueOf(this.c));
        }
    }
}
