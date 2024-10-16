package androidx.loader.content;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class b<D> {
    int f;
    InterfaceC0063b<D> g;
    a<D> h;
    Context i;
    boolean j = false;
    boolean k = false;
    boolean l = true;
    boolean m = false;
    boolean n = false;

    /* loaded from: classes.dex */
    public interface a<D> {
        void a(b<D> bVar);
    }

    /* renamed from: androidx.loader.content.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0063b<D> {
        void a(b<D> bVar, D d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    protected boolean b() {
        return false;
    }

    protected void e() {
    }

    protected void f() {
    }

    protected void g() {
    }

    protected void h() {
    }

    public b(Context context) {
        this.i = context.getApplicationContext();
    }

    public void deliverResult(D d) {
        InterfaceC0063b<D> interfaceC0063b = this.g;
        if (interfaceC0063b != null) {
            interfaceC0063b.a(this, d);
        }
    }

    public void deliverCancellation() {
        a<D> aVar = this.h;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public Context getContext() {
        return this.i;
    }

    public int getId() {
        return this.f;
    }

    public void registerListener(int i, InterfaceC0063b<D> interfaceC0063b) {
        if (this.g != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.g = interfaceC0063b;
        this.f = i;
    }

    public void unregisterListener(InterfaceC0063b<D> interfaceC0063b) {
        InterfaceC0063b<D> interfaceC0063b2 = this.g;
        if (interfaceC0063b2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (interfaceC0063b2 != interfaceC0063b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.g = null;
    }

    public void registerOnLoadCanceledListener(a<D> aVar) {
        if (this.h != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.h = aVar;
    }

    public void unregisterOnLoadCanceledListener(a<D> aVar) {
        a<D> aVar2 = this.h;
        if (aVar2 == null) {
            throw new IllegalStateException("No listener register");
        }
        if (aVar2 != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.h = null;
    }

    public boolean isStarted() {
        return this.j;
    }

    public boolean isAbandoned() {
        return this.k;
    }

    public boolean isReset() {
        return this.l;
    }

    public final void startLoading() {
        this.j = true;
        this.l = false;
        this.k = false;
        e();
    }

    public boolean cancelLoad() {
        return b();
    }

    public void forceLoad() {
        a();
    }

    public void stopLoading() {
        this.j = false;
        f();
    }

    public void abandon() {
        this.k = true;
        g();
    }

    public void reset() {
        h();
        this.l = true;
        this.j = false;
        this.k = false;
        this.m = false;
        this.n = false;
    }

    public boolean takeContentChanged() {
        boolean z = this.m;
        this.m = false;
        this.n |= z;
        return z;
    }

    public void commitContentChanged() {
        this.n = false;
    }

    public void rollbackContentChanged() {
        if (this.n) {
            onContentChanged();
        }
    }

    public void onContentChanged() {
        if (this.j) {
            forceLoad();
        } else {
            this.m = true;
        }
    }

    public String dataToString(D d) {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.e.a.a(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        androidx.core.e.a.a(this, sb);
        sb.append(" id=");
        sb.append(this.f);
        sb.append("}");
        return sb.toString();
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f);
        printWriter.print(" mListener=");
        printWriter.println(this.g);
        if (this.j || this.m || this.n) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.j);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.m);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.n);
        }
        if (this.k || this.l) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.k);
            printWriter.print(" mReset=");
            printWriter.println(this.l);
        }
    }
}
