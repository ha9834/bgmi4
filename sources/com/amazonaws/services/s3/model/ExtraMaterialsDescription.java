package com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ExtraMaterialsDescription implements Serializable {
    public static final ExtraMaterialsDescription NONE = new ExtraMaterialsDescription(Collections.EMPTY_MAP);
    private final Map<String, String> extra;
    private final ConflictResolution resolve;

    /* loaded from: classes.dex */
    public enum ConflictResolution {
        FAIL_FAST,
        OVERRIDE,
        OVERRIDDEN
    }

    public ExtraMaterialsDescription(Map<String, String> map) {
        this(map, ConflictResolution.FAIL_FAST);
    }

    public ExtraMaterialsDescription(Map<String, String> map, ConflictResolution conflictResolution) {
        if (map == null || conflictResolution == null) {
            throw new IllegalArgumentException();
        }
        this.extra = Collections.unmodifiableMap(new HashMap(map));
        this.resolve = conflictResolution;
    }

    public Map<String, String> getMaterialDescription() {
        return this.extra;
    }

    public ConflictResolution getConflictResolution() {
        return this.resolve;
    }

    public Map<String, String> mergeInto(Map<String, String> map) {
        if (this.extra.size() == 0) {
            return map;
        }
        if (map == null || map.size() == 0) {
            return this.extra;
        }
        switch (this.resolve) {
            case FAIL_FAST:
                int size = map.size() + this.extra.size();
                HashMap hashMap = new HashMap(map);
                hashMap.putAll(this.extra);
                if (size != hashMap.size()) {
                    throw new IllegalArgumentException("The supplemental material descriptions contains conflicting entries");
                }
                return Collections.unmodifiableMap(hashMap);
            case OVERRIDDEN:
                HashMap hashMap2 = new HashMap(this.extra);
                hashMap2.putAll(map);
                return Collections.unmodifiableMap(hashMap2);
            case OVERRIDE:
                HashMap hashMap3 = new HashMap(map);
                hashMap3.putAll(this.extra);
                return Collections.unmodifiableMap(hashMap3);
            default:
                throw new UnsupportedOperationException();
        }
    }
}
