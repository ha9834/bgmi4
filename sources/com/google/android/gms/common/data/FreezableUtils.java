package com.google.android.gms.common.data;

import com.helpshift.util.HSObservableList;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        HSObservableList hSObservableList = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            hSObservableList.add(arrayList.get(i).freeze());
        }
        return hSObservableList;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        HSObservableList hSObservableList = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            hSObservableList.add(e.freeze());
        }
        return hSObservableList;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        HSObservableList hSObservableList = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            hSObservableList.add(it.next().freeze());
        }
        return hSObservableList;
    }
}
