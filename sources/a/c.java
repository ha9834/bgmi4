package a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public interface c<T> {
    <R> T a(b<R> bVar);

    Type a();

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract c<?> a(Type type, Annotation[] annotationArr, m mVar);

        /* JADX INFO: Access modifiers changed from: protected */
        public static Class<?> a(Type type) {
            return o.a(type);
        }
    }
}
