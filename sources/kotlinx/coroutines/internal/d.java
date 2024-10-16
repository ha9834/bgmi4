package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final int f7007a = a(Throwable.class, -1);
    private static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    private static final WeakHashMap<Class<? extends Throwable>, kotlin.jvm.a.b<Throwable, Throwable>> c = new WeakHashMap<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final <E extends Throwable> E a(E e) {
        Object e2;
        ReentrantReadWriteLock.ReadLock readLock;
        int readHoldCount;
        ReentrantReadWriteLock.WriteLock writeLock;
        if (e instanceof kotlinx.coroutines.g) {
            try {
                Result.a aVar = Result.f6935a;
                e2 = Result.e(((kotlinx.coroutines.g) e).a());
            } catch (Throwable th) {
                Result.a aVar2 = Result.f6935a;
                e2 = Result.e(kotlin.h.a(th));
            }
            if (Result.b(e2)) {
                e2 = null;
            }
            return (E) e2;
        }
        ReentrantReadWriteLock.ReadLock readLock2 = b.readLock();
        readLock2.lock();
        try {
            kotlin.jvm.a.b<Throwable, Throwable> bVar = c.get(e.getClass());
            if (bVar != null) {
                return (E) bVar.a(e);
            }
            int i = 0;
            if (f7007a != a(e.getClass(), 0)) {
                ReentrantReadWriteLock reentrantReadWriteLock = b;
                readLock = reentrantReadWriteLock.readLock();
                readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i2 = 0; i2 < readHoldCount; i2++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    c.put(e.getClass(), new kotlin.jvm.a.b() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1
                        @Override // kotlin.jvm.a.b
                        public final Void a(Throwable th2) {
                            return null;
                        }
                    });
                    kotlin.k kVar = kotlin.k.f6974a;
                    return null;
                } finally {
                    while (i < readHoldCount) {
                        readLock.lock();
                        i++;
                    }
                    writeLock.unlock();
                }
            }
            kotlin.jvm.a.b<Throwable, Throwable> bVar2 = (kotlin.jvm.a.b) null;
            Iterator it = kotlin.collections.d.c(e.getClass().getConstructors(), new a()).iterator();
            while (it.hasNext() && (bVar2 = a((Constructor<?>) it.next())) == null) {
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = b;
            readLock = reentrantReadWriteLock2.readLock();
            readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i3 = 0; i3 < readHoldCount; i3++) {
                readLock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                c.put(e.getClass(), bVar2 != null ? bVar2 : new kotlin.jvm.a.b() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1
                    @Override // kotlin.jvm.a.b
                    public final Void a(Throwable th2) {
                        return null;
                    }
                });
                kotlin.k kVar2 = kotlin.k.f6974a;
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
                if (bVar2 != null) {
                    return (E) bVar2.a(e);
                }
                return null;
            } finally {
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock2.unlock();
        }
    }

    private static final kotlin.jvm.a.b<Throwable, Throwable> a(final Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        switch (parameterTypes.length) {
            case 0:
                return new kotlin.jvm.a.b<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.a.b
                    public final Throwable a(Throwable th) {
                        Object e;
                        Object newInstance;
                        try {
                            Result.a aVar = Result.f6935a;
                            newInstance = constructor.newInstance(new Object[0]);
                        } catch (Throwable th2) {
                            Result.a aVar2 = Result.f6935a;
                            e = Result.e(kotlin.h.a(th2));
                        }
                        if (newInstance != null) {
                            Throwable th3 = (Throwable) newInstance;
                            th3.initCause(th);
                            e = Result.e(th3);
                            if (Result.b(e)) {
                                e = null;
                            }
                            return (Throwable) e;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            case 1:
                Class<?> cls = parameterTypes[0];
                if (!kotlin.jvm.internal.h.a(cls, Throwable.class)) {
                    if (kotlin.jvm.internal.h.a(cls, String.class)) {
                        return new kotlin.jvm.a.b<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.a.b
                            public final Throwable a(Throwable th) {
                                Object e;
                                Object newInstance;
                                try {
                                    Result.a aVar = Result.f6935a;
                                    newInstance = constructor.newInstance(th.getMessage());
                                } catch (Throwable th2) {
                                    Result.a aVar2 = Result.f6935a;
                                    e = Result.e(kotlin.h.a(th2));
                                }
                                if (newInstance != null) {
                                    Throwable th3 = (Throwable) newInstance;
                                    th3.initCause(th);
                                    e = Result.e(th3);
                                    if (Result.b(e)) {
                                        e = null;
                                    }
                                    return (Throwable) e;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                            }
                        };
                    }
                    return null;
                }
                return new kotlin.jvm.a.b<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.a.b
                    public final Throwable a(Throwable th) {
                        Object e;
                        Object newInstance;
                        try {
                            Result.a aVar = Result.f6935a;
                            newInstance = constructor.newInstance(th);
                        } catch (Throwable th2) {
                            Result.a aVar2 = Result.f6935a;
                            e = Result.e(kotlin.h.a(th2));
                        }
                        if (newInstance != null) {
                            e = Result.e((Throwable) newInstance);
                            if (Result.b(e)) {
                                e = null;
                            }
                            return (Throwable) e;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            case 2:
                if (kotlin.jvm.internal.h.a(parameterTypes[0], String.class) && kotlin.jvm.internal.h.a(parameterTypes[1], Throwable.class)) {
                    return new kotlin.jvm.a.b<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.a.b
                        public final Throwable a(Throwable th) {
                            Object e;
                            Object newInstance;
                            try {
                                Result.a aVar = Result.f6935a;
                                newInstance = constructor.newInstance(th.getMessage(), th);
                            } catch (Throwable th2) {
                                Result.a aVar2 = Result.f6935a;
                                e = Result.e(kotlin.h.a(th2));
                            }
                            if (newInstance != null) {
                                e = Result.e((Throwable) newInstance);
                                if (Result.b(e)) {
                                    e = null;
                                }
                                return (Throwable) e;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                        }
                    };
                }
                return null;
            default:
                return null;
        }
    }

    private static final int a(Class<?> cls, int i) {
        Object e;
        kotlin.jvm.a.a(cls);
        try {
            Result.a aVar = Result.f6935a;
            e = Result.e(Integer.valueOf(a(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f6935a;
            e = Result.e(kotlin.h.a(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.b(e)) {
            e = valueOf;
        }
        return ((Number) e).intValue();
    }

    static /* synthetic */ int a(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return b(cls, i);
    }

    private static final int b(Class<?> cls, int i) {
        do {
            int length = cls.getDeclaredFields().length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (!Modifier.isStatic(r0[i3].getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    /* loaded from: classes3.dex */
    public static final class a<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return kotlin.a.a.a(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
        }
    }
}
