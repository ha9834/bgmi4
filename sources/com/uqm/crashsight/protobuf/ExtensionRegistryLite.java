package com.uqm.crashsight.protobuf;

import com.google.android.gms.games.request.GameRequest;
import com.uqm.crashsight.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ExtensionRegistryLite {

    /* renamed from: a, reason: collision with root package name */
    static final ExtensionRegistryLite f6698a = new ExtensionRegistryLite((byte) 0);
    private static volatile boolean b = false;
    private static boolean c = true;
    private static volatile ExtensionRegistryLite d;
    private final Map<a, GeneratedMessageLite.GeneratedExtension<?, ?>> e;

    public static boolean b() {
        return false;
    }

    public static ExtensionRegistryLite c() {
        ExtensionRegistryLite extensionRegistryLite;
        ExtensionRegistryLite extensionRegistryLite2 = d;
        if (extensionRegistryLite2 != null) {
            return extensionRegistryLite2;
        }
        synchronized (ExtensionRegistryLite.class) {
            extensionRegistryLite = d;
            if (extensionRegistryLite == null) {
                extensionRegistryLite = c ? j.a() : f6698a;
                d = extensionRegistryLite;
            }
        }
        return extensionRegistryLite;
    }

    public final <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> a(ContainingType containingtype, int i) {
        return (GeneratedMessageLite.GeneratedExtension) this.e.get(new a(containingtype, i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExtensionRegistryLite() {
        this.e = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExtensionRegistryLite(ExtensionRegistryLite extensionRegistryLite) {
        if (extensionRegistryLite == f6698a) {
            this.e = Collections.emptyMap();
        } else {
            this.e = Collections.unmodifiableMap(extensionRegistryLite.e);
        }
    }

    private ExtensionRegistryLite(byte b2) {
        this.e = Collections.emptyMap();
    }

    /* loaded from: classes3.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f6699a;
        private final int b;

        a(Object obj, int i) {
            this.f6699a = obj;
            this.b = i;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f6699a) * GameRequest.TYPE_ALL) + this.b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f6699a == aVar.f6699a && this.b == aVar.b;
        }
    }
}
