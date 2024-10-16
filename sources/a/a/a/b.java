package a.a.a;

import a.e;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.aa;
import okhttp3.v;

/* loaded from: classes.dex */
final class b<T> implements e<T, aa> {

    /* renamed from: a, reason: collision with root package name */
    private static final v f9a = v.b("application/json; charset=UTF-8");
    private static final Charset b = Charset.forName("UTF-8");
    private final Gson c;
    private final TypeAdapter<T> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Gson gson, TypeAdapter<T> typeAdapter) {
        this.c = gson;
        this.d = typeAdapter;
    }

    @Override // a.e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public aa a(T t) throws IOException {
        okio.c cVar = new okio.c();
        JsonWriter newJsonWriter = this.c.newJsonWriter(new OutputStreamWriter(cVar.d(), b));
        this.d.write(newJsonWriter, t);
        newJsonWriter.close();
        return aa.a(f9a, cVar.o());
    }
}
