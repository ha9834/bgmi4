package com.google.firebase.components;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class ComponentRuntime extends AbstractComponentContainer {
    private static final Provider<Set<Object>> EMPTY_PROVIDER;
    private final EventBus eventBus;
    private final Map<Component<?>, Lazy<?>> components = new HashMap();
    private final Map<Class<?>, Lazy<?>> lazyInstanceMap = new HashMap();
    private final Map<Class<?>, Lazy<Set<?>>> lazySetMap = new HashMap();

    @Override // com.google.firebase.components.AbstractComponentContainer, com.google.firebase.components.ComponentContainer
    public /* bridge */ /* synthetic */ Object get(Class cls) {
        return super.get(cls);
    }

    @Override // com.google.firebase.components.AbstractComponentContainer, com.google.firebase.components.ComponentContainer
    public /* bridge */ /* synthetic */ Set setOf(Class cls) {
        return super.setOf(cls);
    }

    static {
        Provider<Set<Object>> provider;
        provider = ComponentRuntime$$Lambda$5.instance;
        EMPTY_PROVIDER = provider;
    }

    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        this.eventBus = new EventBus(executor);
        ArrayList<Component<?>> arrayList = new ArrayList();
        arrayList.add(Component.of(this.eventBus, EventBus.class, Subscriber.class, Publisher.class));
        Iterator<ComponentRegistrar> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getComponents());
        }
        Collections.addAll(arrayList, componentArr);
        CycleDetector.detect(arrayList);
        for (Component<?> component : arrayList) {
            this.components.put(component, new Lazy<>(ComponentRuntime$$Lambda$1.lambdaFactory$(this, component)));
        }
        processInstanceComponents();
        processSetComponents();
    }

    private void processInstanceComponents() {
        for (Map.Entry<Component<?>, Lazy<?>> entry : this.components.entrySet()) {
            Component<?> key = entry.getKey();
            if (key.isValue()) {
                Lazy<?> value = entry.getValue();
                Iterator<Class<? super Object>> it = key.getProvidedInterfaces().iterator();
                while (it.hasNext()) {
                    this.lazyInstanceMap.put(it.next(), value);
                }
            }
        }
        validateDependencies();
    }

    private void processSetComponents() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Component<?>, Lazy<?>> entry : this.components.entrySet()) {
            Component<?> key = entry.getKey();
            if (!key.isValue()) {
                Lazy<?> value = entry.getValue();
                for (Class<? super Object> cls : key.getProvidedInterfaces()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            this.lazySetMap.put((Class) entry2.getKey(), new Lazy<>(ComponentRuntime$$Lambda$4.lambdaFactory$((Set) entry2.getValue())));
        }
    }

    public static /* synthetic */ Set lambda$processSetComponents$1(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((Lazy) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<T> getProvider(Class<T> cls) {
        Preconditions.checkNotNull(cls, "Null interface requested.");
        return this.lazyInstanceMap.get(cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        Lazy<Set<?>> lazy = this.lazySetMap.get(cls);
        return lazy != null ? lazy : (Provider<Set<T>>) EMPTY_PROVIDER;
    }

    public void initializeEagerComponents(boolean z) {
        for (Map.Entry<Component<?>, Lazy<?>> entry : this.components.entrySet()) {
            Component<?> key = entry.getKey();
            Lazy<?> value = entry.getValue();
            if (key.isAlwaysEager() || (key.isEagerInDefaultApp() && z)) {
                value.get();
            }
        }
        this.eventBus.enablePublishingAndFlushPending();
    }

    private void validateDependencies() {
        for (Component<?> component : this.components.keySet()) {
            for (Dependency dependency : component.getDependencies()) {
                if (dependency.isRequired() && !this.lazyInstanceMap.containsKey(dependency.getInterface())) {
                    throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", component, dependency.getInterface()));
                }
            }
        }
    }
}
