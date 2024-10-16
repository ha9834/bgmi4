package a.a.a;

import a.e;
import a.m;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.aa;
import okhttp3.ac;

/* loaded from: classes.dex */
public final class a extends e.a {

    /* renamed from: a, reason: collision with root package name */
    private final Gson f8a;

    public static a a() {
        return a(new Gson());
    }

    public static a a(Gson gson) {
        return new a(gson);
    }

    private a(Gson gson) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        }
        this.f8a = gson;
    }

    @Override // a.e.a
    public e<ac, ?> a(Type type, Annotation[] annotationArr, m mVar) {
        return new c(this.f8a, this.f8a.getAdapter(TypeToken.get(type)));
    }

    @Override // a.e.a
    public e<?, aa> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, m mVar) {
        return new b(this.f8a, this.f8a.getAdapter(TypeToken.get(type)));
    }
}
