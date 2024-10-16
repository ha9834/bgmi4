package androidx.g;

import android.os.IBinder;

/* loaded from: classes.dex */
class aj implements al {

    /* renamed from: a, reason: collision with root package name */
    private final IBinder f713a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(IBinder iBinder) {
        this.f713a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof aj) && ((aj) obj).f713a.equals(this.f713a);
    }

    public int hashCode() {
        return this.f713a.hashCode();
    }
}
