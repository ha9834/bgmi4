package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class c {
    public static final StackTraceElement a(BaseContinuationImpl baseContinuationImpl) {
        String str;
        h.b(baseContinuationImpl, "$this$getStackTraceElementImpl");
        b b = b(baseContinuationImpl);
        if (b == null) {
            return null;
        }
        a(1, b.a());
        int c = c(baseContinuationImpl);
        int i = c < 0 ? -1 : b.c()[c];
        String a2 = e.f6955a.a(baseContinuationImpl);
        if (a2 == null) {
            str = b.e();
        } else {
            str = a2 + '/' + b.e();
        }
        return new StackTraceElement(str, b.d(), b.b(), i);
    }

    private static final b b(BaseContinuationImpl baseContinuationImpl) {
        return (b) baseContinuationImpl.getClass().getAnnotation(b.class);
    }

    private static final int c(BaseContinuationImpl baseContinuationImpl) {
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            h.a((Object) declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    private static final void a(int i, int i2) {
        if (i2 <= i) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i + ", got " + i2 + ". Please update the Kotlin standard library.").toString());
    }
}
