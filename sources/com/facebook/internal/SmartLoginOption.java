package com.facebook.internal;

import java.util.EnumSet;
import java.util.Iterator;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* loaded from: classes.dex */
public enum SmartLoginOption {
    None(0),
    Enabled(1),
    RequireConfirm(2);

    private static final EnumSet<SmartLoginOption> ALL;
    public static final Companion Companion = new Companion(null);
    private final long value;

    public static final EnumSet<SmartLoginOption> parseOptions(long j) {
        return Companion.parseOptions(j);
    }

    SmartLoginOption(long j) {
        this.value = j;
    }

    public final long getValue() {
        return this.value;
    }

    static {
        EnumSet<SmartLoginOption> allOf = EnumSet.allOf(SmartLoginOption.class);
        h.a((Object) allOf, "EnumSet.allOf(SmartLoginOption::class.java)");
        ALL = allOf;
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final EnumSet<SmartLoginOption> parseOptions(long j) {
            EnumSet<SmartLoginOption> noneOf = EnumSet.noneOf(SmartLoginOption.class);
            Iterator it = SmartLoginOption.ALL.iterator();
            while (it.hasNext()) {
                SmartLoginOption smartLoginOption = (SmartLoginOption) it.next();
                if ((smartLoginOption.getValue() & j) != 0) {
                    noneOf.add(smartLoginOption);
                }
            }
            h.a((Object) noneOf, "result");
            return noneOf;
        }
    }
}
