package androidx.loader.a;

import android.os.Bundle;
import androidx.lifecycle.k;
import androidx.lifecycle.y;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: androidx.loader.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0060a<D> {
        androidx.loader.content.b<D> a(int i, Bundle bundle);

        void a(androidx.loader.content.b<D> bVar);

        void a(androidx.loader.content.b<D> bVar, D d);
    }

    public abstract <D> androidx.loader.content.b<D> a(int i, Bundle bundle, InterfaceC0060a<D> interfaceC0060a);

    public abstract void a();

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public static <T extends k & y> a a(T t) {
        return new b(t, t.getViewModelStore());
    }
}
