package androidx.g;

import android.view.View;
import android.view.WindowId;

/* loaded from: classes.dex */
class ak implements al {

    /* renamed from: a, reason: collision with root package name */
    private final WindowId f714a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(View view) {
        this.f714a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof ak) && ((ak) obj).f714a.equals(this.f714a);
    }

    public int hashCode() {
        return this.f714a.hashCode();
    }
}
