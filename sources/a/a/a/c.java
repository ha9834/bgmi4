package a.a.a;

import a.e;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import okhttp3.ac;

/* loaded from: classes.dex */
final class c<T> implements e<ac, T> {

    /* renamed from: a, reason: collision with root package name */
    private final Gson f10a;
    private final TypeAdapter<T> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f10a = gson;
        this.b = typeAdapter;
    }

    @Override // a.e
    public T a(ac acVar) throws IOException {
        try {
            return this.b.read2(this.f10a.newJsonReader(acVar.f()));
        } finally {
            acVar.close();
        }
    }
}
