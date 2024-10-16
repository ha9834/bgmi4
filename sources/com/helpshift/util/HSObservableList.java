package com.helpshift.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes2.dex */
public class HSObservableList<T> extends ArrayList<T> {
    private HSListObserver<T> observer;

    public HSObservableList() {
    }

    public HSObservableList(List<T> list) {
        super(list);
    }

    public void setObserver(HSListObserver<T> hSListObserver) {
        this.observer = hSListObserver;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T t) {
        HSListObserver<T> hSListObserver;
        boolean add = super.add(t);
        if (add && (hSListObserver = this.observer) != null) {
            hSListObserver.add(t);
        }
        return add;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends T> collection) {
        HSListObserver<T> hSListObserver;
        boolean addAll = super.addAll(collection);
        if (addAll && (hSListObserver = this.observer) != null) {
            hSListObserver.addAll(collection);
        }
        return addAll;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void prependItems(Collection<? extends T> collection) {
        super.addAll(0, collection);
    }

    public T setAndNotifyObserver(int i, T t) {
        HSListObserver<T> hSListObserver;
        T t2 = (T) super.set(i, t);
        if (t2 != null && (hSListObserver = this.observer) != null) {
            hSListObserver.update(t);
        }
        return t2;
    }
}
