package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Descriptors;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class TypeRegistry {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Descriptors.Descriptor> f6768a;

    static {
        Logger.getLogger(TypeRegistry.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final TypeRegistry f6769a = new TypeRegistry(Collections.emptyMap());
    }

    public static TypeRegistry a() {
        return a.f6769a;
    }

    public final Descriptors.Descriptor a(String str) throws InvalidProtocolBufferException {
        String[] split = str.split("/");
        if (split.length != 1) {
            return this.f6768a.get(split[split.length - 1]);
        }
        throw new InvalidProtocolBufferException("Invalid type url found: " + str);
    }

    TypeRegistry(Map<String, Descriptors.Descriptor> map) {
        this.f6768a = map;
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private Builder() {
            new HashSet();
            new HashMap();
        }
    }
}
