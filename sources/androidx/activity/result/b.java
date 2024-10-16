package androidx.activity.result;

import android.annotation.SuppressLint;

/* loaded from: classes.dex */
public abstract class b<I> {
    public abstract void a();

    public abstract void a(@SuppressLint({"UnknownNullness"}) I i, androidx.core.app.b bVar);

    public void a(@SuppressLint({"UnknownNullness"}) I i) {
        a(i, null);
    }
}
