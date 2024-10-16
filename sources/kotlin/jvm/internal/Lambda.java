package kotlin.jvm.internal;

import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class Lambda<R> implements Serializable, g<R> {
    private final int arity;

    public Lambda(int i) {
        this.arity = i;
    }

    public String toString() {
        String a2 = j.a(this);
        h.a((Object) a2, "Reflection.renderLambdaToString(this)");
        return a2;
    }
}
