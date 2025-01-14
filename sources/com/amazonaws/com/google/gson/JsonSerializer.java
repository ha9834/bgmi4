package com.amazonaws.com.google.gson;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public interface JsonSerializer<T> {
    JsonElement serialize(T t, Type type, JsonSerializationContext jsonSerializationContext);
}
