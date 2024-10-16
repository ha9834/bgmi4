package androidx.loader.a;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.b.h;
import androidx.lifecycle.k;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import androidx.loader.a.a;
import androidx.loader.content.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends androidx.loader.a.a {

    /* renamed from: a, reason: collision with root package name */
    static boolean f799a;
    private final k b;
    private final c c;

    /* loaded from: classes.dex */
    public static class a<D> extends p<D> implements b.InterfaceC0063b<D> {
        private final int e;
        private final Bundle f;
        private final androidx.loader.content.b<D> g;
        private k h;
        private C0061b<D> i;
        private androidx.loader.content.b<D> j;

        a(int i, Bundle bundle, androidx.loader.content.b<D> bVar, androidx.loader.content.b<D> bVar2) {
            this.e = i;
            this.f = bundle;
            this.g = bVar;
            this.j = bVar2;
            this.g.registerListener(i, this);
        }

        androidx.loader.content.b<D> e() {
            return this.g;
        }

        @Override // androidx.lifecycle.LiveData
        protected void b() {
            if (b.f799a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.g.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        protected void c() {
            if (b.f799a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.g.stopLoading();
        }

        androidx.loader.content.b<D> a(k kVar, a.InterfaceC0060a<D> interfaceC0060a) {
            C0061b<D> c0061b = new C0061b<>(this.g, interfaceC0060a);
            a(kVar, c0061b);
            C0061b<D> c0061b2 = this.i;
            if (c0061b2 != null) {
                b((q) c0061b2);
            }
            this.h = kVar;
            this.i = c0061b;
            return this.g;
        }

        void f() {
            k kVar = this.h;
            C0061b<D> c0061b = this.i;
            if (kVar == null || c0061b == null) {
                return;
            }
            super.b((q) c0061b);
            a(kVar, c0061b);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void b(q<? super D> qVar) {
            super.b((q) qVar);
            this.h = null;
            this.i = null;
        }

        androidx.loader.content.b<D> a(boolean z) {
            if (b.f799a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.g.cancelLoad();
            this.g.abandon();
            C0061b<D> c0061b = this.i;
            if (c0061b != null) {
                b((q) c0061b);
                if (z) {
                    c0061b.b();
                }
            }
            this.g.unregisterListener(this);
            if ((c0061b != null && !c0061b.a()) || z) {
                this.g.reset();
                return this.j;
            }
            return this.g;
        }

        @Override // androidx.loader.content.b.InterfaceC0063b
        public void a(androidx.loader.content.b<D> bVar, D d) {
            if (b.f799a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b((a<D>) d);
                return;
            }
            if (b.f799a) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            a((a<D>) d);
        }

        @Override // androidx.lifecycle.p, androidx.lifecycle.LiveData
        public void b(D d) {
            super.b((a<D>) d);
            androidx.loader.content.b<D> bVar = this.j;
            if (bVar != null) {
                bVar.reset();
                this.j = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.e);
            sb.append(" : ");
            androidx.core.e.a.a(this.g, sb);
            sb.append("}}");
            return sb.toString();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.e);
            printWriter.print(" mArgs=");
            printWriter.println(this.f);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.g);
            this.g.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.i != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.i);
                this.i.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e().dataToString(a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(d());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.loader.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0061b<D> implements q<D> {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.loader.content.b<D> f800a;
        private final a.InterfaceC0060a<D> b;
        private boolean c = false;

        C0061b(androidx.loader.content.b<D> bVar, a.InterfaceC0060a<D> interfaceC0060a) {
            this.f800a = bVar;
            this.b = interfaceC0060a;
        }

        @Override // androidx.lifecycle.q
        public void a(D d) {
            if (b.f799a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f800a + ": " + this.f800a.dataToString(d));
            }
            this.b.a((androidx.loader.content.b<androidx.loader.content.b<D>>) this.f800a, (androidx.loader.content.b<D>) d);
            this.c = true;
        }

        boolean a() {
            return this.c;
        }

        void b() {
            if (this.c) {
                if (b.f799a) {
                    Log.v("LoaderManager", "  Resetting: " + this.f800a);
                }
                this.b.a(this.f800a);
            }
        }

        public String toString() {
            return this.b.toString();
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends v {

        /* renamed from: a, reason: collision with root package name */
        private static final w.b f801a = new w.b() { // from class: androidx.loader.a.b.c.1
            @Override // androidx.lifecycle.w.b
            public <T extends v> T a(Class<T> cls) {
                return new c();
            }
        };
        private h<a> b = new h<>();
        private boolean c = false;

        c() {
        }

        static c a(x xVar) {
            return (c) new w(xVar, f801a).a(c.class);
        }

        void b() {
            this.c = true;
        }

        boolean c() {
            return this.c;
        }

        void e() {
            this.c = false;
        }

        void a(int i, a aVar) {
            this.b.b(i, aVar);
        }

        <D> a<D> a(int i) {
            return this.b.a(i);
        }

        void f() {
            int b = this.b.b();
            for (int i = 0; i < b; i++) {
                this.b.c(i).f();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.v
        public void a() {
            super.a();
            int b = this.b.b();
            for (int i = 0; i < b; i++) {
                this.b.c(i).a(true);
            }
            this.b.c();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.b.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.b.b(); i++) {
                    a c = this.b.c(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.b.b(i));
                    printWriter.print(": ");
                    printWriter.println(c.toString());
                    c.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(k kVar, x xVar) {
        this.b = kVar;
        this.c = c.a(xVar);
    }

    private <D> androidx.loader.content.b<D> a(int i, Bundle bundle, a.InterfaceC0060a<D> interfaceC0060a, androidx.loader.content.b<D> bVar) {
        try {
            this.c.b();
            androidx.loader.content.b<D> a2 = interfaceC0060a.a(i, bundle);
            if (a2 == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (a2.getClass().isMemberClass() && !Modifier.isStatic(a2.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + a2);
            }
            a aVar = new a(i, bundle, a2, bVar);
            if (f799a) {
                Log.v("LoaderManager", "  Created new loader " + aVar);
            }
            this.c.a(i, aVar);
            this.c.e();
            return aVar.a(this.b, interfaceC0060a);
        } catch (Throwable th) {
            this.c.e();
            throw th;
        }
    }

    @Override // androidx.loader.a.a
    public <D> androidx.loader.content.b<D> a(int i, Bundle bundle, a.InterfaceC0060a<D> interfaceC0060a) {
        if (this.c.c()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        a<D> a2 = this.c.a(i);
        if (f799a) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
        }
        if (a2 == null) {
            return a(i, bundle, interfaceC0060a, (androidx.loader.content.b) null);
        }
        if (f799a) {
            Log.v("LoaderManager", "  Re-using existing loader " + a2);
        }
        return a2.a(this.b, interfaceC0060a);
    }

    @Override // androidx.loader.a.a
    public void a() {
        this.c.f();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.e.a.a(this.b, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // androidx.loader.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.c.a(str, fileDescriptor, printWriter, strArr);
    }
}
