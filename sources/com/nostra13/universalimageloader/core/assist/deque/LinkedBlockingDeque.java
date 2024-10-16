package com.nostra13.universalimageloader.core.assist.deque;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements com.nostra13.universalimageloader.core.assist.deque.a<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;

    /* renamed from: a, reason: collision with root package name */
    transient c<E> f5737a;
    transient c<E> b;
    private transient int c;
    private final int capacity;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class c<E> {

        /* renamed from: a, reason: collision with root package name */
        E f5739a;
        c<E> b;
        c<E> c;

        c(E e) {
            this.f5739a = e;
        }
    }

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingDeque(int i) {
        this.lock = new ReentrantLock();
        this.notEmpty = this.lock.newCondition();
        this.notFull = this.lock.newCondition();
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = i;
    }

    private boolean b(c<E> cVar) {
        if (this.c >= this.capacity) {
            return false;
        }
        c<E> cVar2 = this.f5737a;
        cVar.c = cVar2;
        this.f5737a = cVar;
        if (this.b == null) {
            this.b = cVar;
        } else {
            cVar2.b = cVar;
        }
        this.c++;
        this.notEmpty.signal();
        return true;
    }

    private boolean c(c<E> cVar) {
        if (this.c >= this.capacity) {
            return false;
        }
        c<E> cVar2 = this.b;
        cVar.b = cVar2;
        this.b = cVar;
        if (this.f5737a == null) {
            this.f5737a = cVar;
        } else {
            cVar2.c = cVar;
        }
        this.c++;
        this.notEmpty.signal();
        return true;
    }

    private E f() {
        c<E> cVar = this.f5737a;
        if (cVar == null) {
            return null;
        }
        c<E> cVar2 = cVar.c;
        E e = cVar.f5739a;
        cVar.f5739a = null;
        cVar.c = cVar;
        this.f5737a = cVar2;
        if (cVar2 == null) {
            this.b = null;
        } else {
            cVar2.b = null;
        }
        this.c--;
        this.notFull.signal();
        return e;
    }

    private E g() {
        c<E> cVar = this.b;
        if (cVar == null) {
            return null;
        }
        c<E> cVar2 = cVar.b;
        E e = cVar.f5739a;
        cVar.f5739a = null;
        cVar.b = cVar;
        this.b = cVar2;
        if (cVar2 == null) {
            this.f5737a = null;
        } else {
            cVar2.c = null;
        }
        this.c--;
        this.notFull.signal();
        return e;
    }

    void a(c<E> cVar) {
        c<E> cVar2 = cVar.b;
        c<E> cVar3 = cVar.c;
        if (cVar2 == null) {
            f();
            return;
        }
        if (cVar3 == null) {
            g();
            return;
        }
        cVar2.c = cVar3;
        cVar3.b = cVar2;
        cVar.f5739a = null;
        this.c--;
        this.notFull.signal();
    }

    public void a(E e) {
        if (!c((LinkedBlockingDeque<E>) e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public boolean b(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        c<E> cVar = new c<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return b((c) cVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean c(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        c<E> cVar = new c<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return c((c) cVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void d(E e) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        c<E> cVar = new c<>(e);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!c((c) cVar)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean a(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        if (e == null) {
            throw new NullPointerException();
        }
        c<E> cVar = new c<>(e);
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (!c((c) cVar)) {
            try {
                if (nanos > 0) {
                    nanos = this.notFull.awaitNanos(nanos);
                } else {
                    return false;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return true;
    }

    public E a() {
        E b2 = b();
        if (b2 != null) {
            return b2;
        }
        throw new NoSuchElementException();
    }

    public E b() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return f();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public E c() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E f = f();
                if (f != null) {
                    return f;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public E a(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E f = f();
                if (f != null) {
                    return f;
                }
                if (nanos > 0) {
                    nanos = this.notEmpty.awaitNanos(nanos);
                } else {
                    return null;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E d() {
        E e = e();
        if (e != null) {
            return e;
        }
        throw new NoSuchElementException();
    }

    public E e() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.f5737a == null ? null : this.f5737a.f5739a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean e(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (c<E> cVar = this.f5737a; cVar != null; cVar = cVar.c) {
                if (obj.equals(cVar.f5739a)) {
                    a((c) cVar);
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue, java.util.concurrent.BlockingQueue
    public boolean add(E e) {
        a((LinkedBlockingDeque<E>) e);
        return true;
    }

    public boolean offer(E e) {
        return c((LinkedBlockingDeque<E>) e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        d(e);
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        return a(e, j, timeUnit);
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E remove() {
        return a();
    }

    @Override // java.util.Queue
    public E poll() {
        return b();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return c();
    }

    @Override // java.util.concurrent.BlockingQueue
    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return a(j, timeUnit);
    }

    @Override // java.util.AbstractQueue, java.util.Queue
    public E element() {
        return d();
    }

    @Override // java.util.Queue
    public E peek() {
        return e();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.capacity - this.c;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        }
        if (collection == this) {
            throw new IllegalArgumentException();
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int min = Math.min(i, this.c);
            for (int i2 = 0; i2 < min; i2++) {
                collection.add(this.f5737a.f5739a);
                f();
            }
            return min;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean remove(Object obj) {
        return e(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.c;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.concurrent.BlockingQueue
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (c<E> cVar = this.f5737a; cVar != null; cVar = cVar.c) {
                if (obj.equals(cVar.f5739a)) {
                    return true;
                }
            }
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.c];
            int i = 0;
            c<E> cVar = this.f5737a;
            while (cVar != null) {
                int i2 = i + 1;
                objArr[i] = cVar.f5739a;
                cVar = cVar.c;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractCollection, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (tArr.length < this.c) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.c));
            }
            int i = 0;
            c<E> cVar = this.f5737a;
            while (cVar != null) {
                tArr[i] = cVar.f5739a;
                cVar = cVar.c;
                i++;
            }
            if (tArr.length > i) {
                tArr[i] = null;
            }
            return tArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractCollection
    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            c<E> cVar = this.f5737a;
            if (cVar == null) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                Object obj = cVar.f5739a;
                if (obj == this) {
                    obj = "(this Collection)";
                }
                sb.append(obj);
                cVar = cVar.c;
                if (cVar == null) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(',');
                sb.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            c<E> cVar = this.f5737a;
            while (cVar != null) {
                cVar.f5739a = null;
                c<E> cVar2 = cVar.c;
                cVar.b = null;
                cVar.c = null;
                cVar = cVar2;
            }
            this.b = null;
            this.f5737a = null;
            this.c = 0;
            this.notFull.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new b();
    }

    /* loaded from: classes2.dex */
    private abstract class a implements Iterator<E> {

        /* renamed from: a, reason: collision with root package name */
        c<E> f5738a;
        E b;
        private c<E> d;

        abstract c<E> a();

        abstract c<E> a(c<E> cVar);

        a() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                this.f5738a = a();
                this.b = this.f5738a == null ? null : this.f5738a.f5739a;
            } finally {
                reentrantLock.unlock();
            }
        }

        private c<E> b(c<E> cVar) {
            while (true) {
                c<E> a2 = a(cVar);
                if (a2 == null) {
                    return null;
                }
                if (a2.f5739a != null) {
                    return a2;
                }
                if (a2 == cVar) {
                    return a();
                }
                cVar = a2;
            }
        }

        void b() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                this.f5738a = b(this.f5738a);
                this.b = this.f5738a == null ? null : this.f5738a.f5739a;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5738a != null;
        }

        @Override // java.util.Iterator
        public E next() {
            c<E> cVar = this.f5738a;
            if (cVar == null) {
                throw new NoSuchElementException();
            }
            this.d = cVar;
            E e = this.b;
            b();
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            c<E> cVar = this.d;
            if (cVar == null) {
                throw new IllegalStateException();
            }
            this.d = null;
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                if (cVar.f5739a != null) {
                    LinkedBlockingDeque.this.a((c) cVar);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class b extends LinkedBlockingDeque<E>.a {
        private b() {
            super();
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.a
        c<E> a() {
            return LinkedBlockingDeque.this.f5737a;
        }

        @Override // com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque.a
        c<E> a(c<E> cVar) {
            return cVar.c;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (c<E> cVar = this.f5737a; cVar != null; cVar = cVar.c) {
                objectOutputStream.writeObject(cVar.f5739a);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.c = 0;
        this.f5737a = null;
        this.b = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject == null) {
                return;
            } else {
                add(readObject);
            }
        }
    }
}
