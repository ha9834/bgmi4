package com.discord.connect.schema;

import lombok.NonNull;

/* loaded from: classes.dex */
public class a {

    /* renamed from: com.discord.connect.schema.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0082a extends a {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        public final String f1089a;

        protected boolean a(Object obj) {
            return obj instanceof C0082a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0082a)) {
                return false;
            }
            C0082a c0082a = (C0082a) obj;
            if (!c0082a.a(this) || !super.equals(obj)) {
                return false;
            }
            String a2 = a();
            String a3 = c0082a.a();
            return a2 != null ? a2.equals(a3) : a3 == null;
        }

        public int hashCode() {
            int hashCode = super.hashCode();
            String a2 = a();
            return (hashCode * 59) + (a2 == null ? 43 : a2.hashCode());
        }

        public String toString() {
            return "Action.Join(secret=" + a() + ")";
        }

        @NonNull
        public String a() {
            return this.f1089a;
        }
    }
}
