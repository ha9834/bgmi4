package com.facebook.internal.gatekeeper;

import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public final class GateKeeper {
    private final String name;
    private final boolean value;

    public static /* synthetic */ GateKeeper copy$default(GateKeeper gateKeeper, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = gateKeeper.name;
        }
        if ((i & 2) != 0) {
            z = gateKeeper.value;
        }
        return gateKeeper.copy(str, z);
    }

    public final String component1() {
        return this.name;
    }

    public final boolean component2() {
        return this.value;
    }

    public final GateKeeper copy(String str, boolean z) {
        h.b(str, "name");
        return new GateKeeper(str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GateKeeper)) {
            return false;
        }
        GateKeeper gateKeeper = (GateKeeper) obj;
        return h.a((Object) this.name, (Object) gateKeeper.name) && this.value == gateKeeper.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.name;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.value;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "GateKeeper(name=" + this.name + ", value=" + this.value + ")";
    }

    public GateKeeper(String str, boolean z) {
        h.b(str, "name");
        this.name = str;
        this.value = z;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getValue() {
        return this.value;
    }
}
