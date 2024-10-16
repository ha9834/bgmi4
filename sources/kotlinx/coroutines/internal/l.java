package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;

/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a */
    private static final String f7015a;
    private static final String b;

    public static final /* synthetic */ Throwable a(Throwable th, kotlin.coroutines.jvm.internal.a aVar) {
        return b(th, aVar);
    }

    static {
        Object e;
        Object e2;
        try {
            Result.a aVar = Result.f6935a;
            e = Result.e(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th) {
            Result.a aVar2 = Result.f6935a;
            e = Result.e(kotlin.h.a(th));
        }
        if (Result.c(e) != null) {
            e = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f7015a = (String) e;
        try {
            Result.a aVar3 = Result.f6935a;
            e2 = Result.e(Class.forName("kotlinx.coroutines.internal.l").getCanonicalName());
        } catch (Throwable th2) {
            Result.a aVar4 = Result.f6935a;
            e2 = Result.e(kotlin.h.a(th2));
        }
        if (Result.c(e2) != null) {
            e2 = "kotlinx.coroutines.internal.l";
        }
        b = (String) e2;
    }

    public static final <E extends Throwable> E b(E e, kotlin.coroutines.jvm.internal.a aVar) {
        Pair a2 = a(e);
        Throwable th = (Throwable) a2.c();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) a2.d();
        Throwable a3 = d.a(th);
        if (a3 == null || (!kotlin.jvm.internal.h.a((Object) a3.getMessage(), (Object) th.getMessage()))) {
            return e;
        }
        ArrayDeque<StackTraceElement> a4 = a(aVar);
        if (a4.isEmpty()) {
            return e;
        }
        if (th != e) {
            a(stackTraceElementArr, a4);
        }
        return (E) a(th, a3, a4);
    }

    private static final <E extends Throwable> E a(E e, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(a("Coroutine boundary"));
        StackTraceElement[] stackTrace = e.getStackTrace();
        int a2 = a(stackTrace, f7015a);
        int i = 0;
        if (a2 != -1) {
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + a2];
            for (int i2 = 0; i2 < a2; i2++) {
                stackTraceElementArr[i2] = stackTrace[i2];
            }
            Iterator<T> it = arrayDeque.iterator();
            while (it.hasNext()) {
                stackTraceElementArr[a2 + i] = (StackTraceElement) it.next();
                i++;
            }
            e2.setStackTrace(stackTraceElementArr);
            return e2;
        }
        Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        e2.setStackTrace((StackTraceElement[]) array);
        return e2;
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> a(E e) {
        boolean z;
        Throwable cause = e.getCause();
        if (cause != null && kotlin.jvm.internal.h.a(cause.getClass(), e.getClass())) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                }
                if (a(stackTrace[i])) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                return kotlin.i.a(cause, stackTrace);
            }
            return kotlin.i.a(e, new StackTraceElement[0]);
        }
        return kotlin.i.a(e, new StackTraceElement[0]);
    }

    private static final ArrayDeque<StackTraceElement> a(kotlin.coroutines.jvm.internal.a aVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement d = aVar.d();
        if (d != null) {
            arrayDeque.add(d);
        }
        while (true) {
            if (!(aVar instanceof kotlin.coroutines.jvm.internal.a)) {
                aVar = null;
            }
            if (aVar == null || (aVar = aVar.c()) == null) {
                break;
            }
            StackTraceElement d2 = aVar.d();
            if (d2 != null) {
                arrayDeque.add(d2);
            }
        }
        return arrayDeque;
    }

    public static final StackTraceElement a(String str) {
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    public static final boolean a(StackTraceElement stackTraceElement) {
        return kotlin.text.l.a(stackTraceElement.getClassName(), "\b\b\b", false, 2, (Object) null);
    }

    private static final boolean a(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && kotlin.jvm.internal.h.a((Object) stackTraceElement.getMethodName(), (Object) stackTraceElement2.getMethodName()) && kotlin.jvm.internal.h.a((Object) stackTraceElement.getFileName(), (Object) stackTraceElement2.getFileName()) && kotlin.jvm.internal.h.a((Object) stackTraceElement.getClassName(), (Object) stackTraceElement2.getClassName());
    }

    private static final void a(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (a(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 < i2) {
            return;
        }
        while (true) {
            if (a(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i2) {
                return;
            } else {
                length2--;
            }
        }
    }

    private static final int a(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (kotlin.jvm.internal.h.a((Object) str, (Object) stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }
}
