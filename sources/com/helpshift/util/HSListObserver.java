package com.helpshift.util;

import java.util.Collection;

/* loaded from: classes2.dex */
public interface HSListObserver<T> {
    void add(T t);

    void addAll(Collection<? extends T> collection);

    void update(T t);
}
