package a;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.aa;
import okhttp3.ac;

/* loaded from: classes.dex */
public interface e<F, T> {

    /* loaded from: classes.dex */
    public static abstract class a {
        public e<ac, ?> a(Type type, Annotation[] annotationArr, m mVar) {
            return null;
        }

        public e<?, aa> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, m mVar) {
            return null;
        }

        public e<?, String> b(Type type, Annotation[] annotationArr, m mVar) {
            return null;
        }
    }

    T a(F f) throws IOException;
}
