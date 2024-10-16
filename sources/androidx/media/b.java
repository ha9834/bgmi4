package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
/* loaded from: classes.dex */
class b implements a {

    /* renamed from: a, reason: collision with root package name */
    AudioAttributes f833a;
    int b = -1;

    public int hashCode() {
        return this.f833a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f833a.equals(((b) obj).f833a);
        }
        return false;
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f833a;
    }
}
