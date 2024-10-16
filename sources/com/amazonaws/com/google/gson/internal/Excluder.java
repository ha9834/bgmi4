package com.amazonaws.com.google.gson.internal;

import com.amazonaws.com.google.gson.ExclusionStrategy;
import com.amazonaws.com.google.gson.FieldAttributes;
import com.amazonaws.com.google.gson.Gson;
import com.amazonaws.com.google.gson.TypeAdapter;
import com.amazonaws.com.google.gson.TypeAdapterFactory;
import com.amazonaws.com.google.gson.annotations.Expose;
import com.amazonaws.com.google.gson.annotations.Since;
import com.amazonaws.com.google.gson.annotations.Until;
import com.amazonaws.com.google.gson.reflect.TypeToken;
import com.amazonaws.com.google.gson.stream.JsonReader;
import com.amazonaws.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    private static final double IGNORE_VERSIONS = -1.0d;
    private boolean requireExpose;
    private double version = IGNORE_VERSIONS;
    private int modifiers = 136;
    private boolean serializeInnerClasses = true;
    private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
    private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Excluder m1clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public Excluder withVersion(double d) {
        Excluder m1clone = m1clone();
        m1clone.version = d;
        return m1clone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder m1clone = m1clone();
        m1clone.modifiers = 0;
        for (int i : iArr) {
            m1clone.modifiers = i | m1clone.modifiers;
        }
        return m1clone;
    }

    public Excluder disableInnerClassSerialization() {
        Excluder m1clone = m1clone();
        m1clone.serializeInnerClasses = false;
        return m1clone;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder m1clone = m1clone();
        m1clone.requireExpose = true;
        return m1clone;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder m1clone = m1clone();
        if (z) {
            m1clone.serializationStrategies = new ArrayList(this.serializationStrategies);
            m1clone.serializationStrategies.add(exclusionStrategy);
        }
        if (z2) {
            m1clone.deserializationStrategies = new ArrayList(this.deserializationStrategies);
            m1clone.deserializationStrategies.add(exclusionStrategy);
        }
        return m1clone;
    }

    @Override // com.amazonaws.com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        final boolean excludeClass = excludeClass(rawType, true);
        final boolean excludeClass2 = excludeClass(rawType, false);
        if (excludeClass || excludeClass2) {
            return new TypeAdapter<T>() { // from class: com.amazonaws.com.google.gson.internal.Excluder.1
                private TypeAdapter<T> delegate;

                @Override // com.amazonaws.com.google.gson.TypeAdapter
                /* renamed from: read */
                public T read2(JsonReader jsonReader) throws IOException {
                    if (excludeClass2) {
                        jsonReader.skipValue();
                        return null;
                    }
                    return delegate().read2(jsonReader);
                }

                @Override // com.amazonaws.com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, T t) throws IOException {
                    if (excludeClass) {
                        jsonWriter.nullValue();
                    } else {
                        delegate().write(jsonWriter, t);
                    }
                }

                private TypeAdapter<T> delegate() {
                    TypeAdapter<T> typeAdapter = this.delegate;
                    if (typeAdapter != null) {
                        return typeAdapter;
                    }
                    TypeAdapter<T> delegateAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                    this.delegate = delegateAdapter;
                    return delegateAdapter;
                }
            };
        }
        return null;
    }

    public boolean excludeField(Field field, boolean z) {
        Expose expose;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != IGNORE_VERSIONS && !isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z ? expose.deserialize() : expose.serialize()))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(field.getType())) || isAnonymousOrLocal(field.getType())) {
            return true;
        }
        List<ExclusionStrategy> list = z ? this.serializationStrategies : this.deserializationStrategies;
        if (list.isEmpty()) {
            return false;
        }
        FieldAttributes fieldAttributes = new FieldAttributes(field);
        Iterator<ExclusionStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipField(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }

    public boolean excludeClass(Class<?> cls, boolean z) {
        if (this.version != IGNORE_VERSIONS && !isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(cls)) || isAnonymousOrLocal(cls)) {
            return true;
        }
        Iterator<ExclusionStrategy> it = (z ? this.serializationStrategies : this.deserializationStrategies).iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnonymousOrLocal(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean isInnerClass(Class<?> cls) {
        return cls.isMemberClass() && !isStatic(cls);
    }

    private boolean isStatic(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean isValidVersion(Since since, Until until) {
        return isValidSince(since) && isValidUntil(until);
    }

    private boolean isValidSince(Since since) {
        return since == null || since.value() <= this.version;
    }

    private boolean isValidUntil(Until until) {
        return until == null || until.value() > this.version;
    }
}