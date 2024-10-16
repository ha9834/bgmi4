package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class t extends s {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* loaded from: classes3.dex */
    public static final class a<T> implements kotlin.f.b<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f6945a;

        public a(Iterable iterable) {
            this.f6945a = iterable;
        }

        @Override // kotlin.f.b
        public Iterator<T> a() {
            return this.f6945a.iterator();
        }
    }

    public static final <T> boolean a(Iterable<? extends T> iterable, T t) {
        kotlin.jvm.internal.h.b(iterable, "$this$contains");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t);
        }
        return j.b(iterable, t) >= 0;
    }

    public static final <T> T c(List<? extends T> list) {
        kotlin.jvm.internal.h.b(list, "$this$first");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final <T> int b(Iterable<? extends T> iterable, T t) {
        kotlin.jvm.internal.h.b(iterable, "$this$indexOf");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t);
        }
        int i = 0;
        for (T t2 : iterable) {
            if (i < 0) {
                j.b();
            }
            if (kotlin.jvm.internal.h.a(t, t2)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static final <T> T d(List<? extends T> list) {
        kotlin.jvm.internal.h.b(list, "$this$last");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(j.a((List) list));
    }

    public static final <T> T a(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.h.b(iterable, "$this$single");
        if (iterable instanceof List) {
            return (T) j.e((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T e(List<? extends T> list) {
        kotlin.jvm.internal.h.b(list, "$this$single");
        switch (list.size()) {
            case 0:
                throw new NoSuchElementException("List is empty.");
            case 1:
                return list.get(0);
            default:
                throw new IllegalArgumentException("List has more than one element.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> a(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        kotlin.jvm.internal.h.b(iterable, "$this$sortedWith");
        kotlin.jvm.internal.h.b(comparator, "comparator");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return j.b(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            if (array != null) {
                d.a(array, (Comparator) comparator);
                return d.a(array);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        List<T> c = j.c(iterable);
        j.a((List) c, (Comparator) comparator);
        return c;
    }

    public static final <T, C extends Collection<? super T>> C a(Iterable<? extends T> iterable, C c) {
        kotlin.jvm.internal.h.b(iterable, "$this$toCollection");
        kotlin.jvm.internal.h.b(c, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            c.add(it.next());
        }
        return c;
    }

    public static final <T> List<T> b(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.h.b(iterable, "$this$toList");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            switch (collection.size()) {
                case 0:
                    return j.a();
                case 1:
                    return j.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
                default:
                    return j.b(collection);
            }
        }
        return j.b(j.c(iterable));
    }

    public static final <T> List<T> c(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.h.b(iterable, "$this$toMutableList");
        if (iterable instanceof Collection) {
            return j.b((Collection) iterable);
        }
        return (List) j.a((Iterable) iterable, new ArrayList());
    }

    public static final <T> List<T> b(Collection<? extends T> collection) {
        kotlin.jvm.internal.h.b(collection, "$this$toMutableList");
        return new ArrayList(collection);
    }

    public static final <T> Set<T> d(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.h.b(iterable, "$this$toSet");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            switch (collection.size()) {
                case 0:
                    return ab.a();
                case 1:
                    return ab.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
                default:
                    return (Set) j.a((Iterable) iterable, new LinkedHashSet(w.a(collection.size())));
            }
        }
        return ab.a((Set) j.a((Iterable) iterable, new LinkedHashSet()));
    }

    public static final <T> List<T> a(Collection<? extends T> collection, T t) {
        kotlin.jvm.internal.h.b(collection, "$this$plus");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t);
        return arrayList;
    }

    public static final <T, A extends Appendable> A a(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.h.b(iterable, "$this$joinTo");
        kotlin.jvm.internal.h.b(a2, "buffer");
        kotlin.jvm.internal.h.b(charSequence, "separator");
        kotlin.jvm.internal.h.b(charSequence2, "prefix");
        kotlin.jvm.internal.h.b(charSequence3, "postfix");
        kotlin.jvm.internal.h.b(charSequence4, "truncated");
        a2.append(charSequence2);
        int i2 = 0;
        for (T t : iterable) {
            i2++;
            if (i2 > 1) {
                a2.append(charSequence);
            }
            if (i >= 0 && i2 > i) {
                break;
            }
            kotlin.text.l.a(a2, t, bVar);
        }
        if (i >= 0 && i2 > i) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static /* synthetic */ String a(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b bVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
        }
        if ((i2 & 2) != 0) {
        }
        CharSequence charSequence5 = charSequence2;
        if ((i2 & 4) != 0) {
        }
        CharSequence charSequence6 = charSequence3;
        int i3 = (i2 & 8) != 0 ? -1 : i;
        if ((i2 & 16) != 0) {
        }
        CharSequence charSequence7 = charSequence4;
        if ((i2 & 32) != 0) {
            bVar = (kotlin.jvm.a.b) null;
        }
        return j.a(iterable, charSequence, charSequence5, charSequence6, i3, charSequence7, bVar);
    }

    public static final <T> String a(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, CharSequence charSequence4, kotlin.jvm.a.b<? super T, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.h.b(iterable, "$this$joinToString");
        kotlin.jvm.internal.h.b(charSequence, "separator");
        kotlin.jvm.internal.h.b(charSequence2, "prefix");
        kotlin.jvm.internal.h.b(charSequence3, "postfix");
        kotlin.jvm.internal.h.b(charSequence4, "truncated");
        String sb = ((StringBuilder) j.a(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i, charSequence4, bVar)).toString();
        kotlin.jvm.internal.h.a((Object) sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final <T> kotlin.f.b<T> e(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.h.b(iterable, "$this$asSequence");
        return new a(iterable);
    }

    public static final <T, R> List<Pair<T, R>> a(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        kotlin.jvm.internal.h.b(iterable, "$this$zip");
        kotlin.jvm.internal.h.b(iterable2, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(j.a(iterable, 10), j.a(iterable2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(kotlin.i.a(it.next(), it2.next()));
        }
        return arrayList;
    }
}
