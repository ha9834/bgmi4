package com.uqm.crashsight.protobuf;

import com.google.android.gms.games.request.GameRequest;
import com.uqm.crashsight.protobuf.Descriptors;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ExtensionRegistry extends ExtensionRegistryLite {
    private static ExtensionRegistry c = new ExtensionRegistry((byte) 0);
    private final Map<a, ExtensionInfo> b;

    /* loaded from: classes3.dex */
    public static final class ExtensionInfo {

        /* renamed from: a, reason: collision with root package name */
        public final Descriptors.FieldDescriptor f6696a;
        public final Message b;
    }

    public static ExtensionRegistry a() {
        return c;
    }

    @Deprecated
    public final ExtensionInfo a(Descriptors.Descriptor descriptor, int i) {
        return this.b.get(new a(descriptor, i));
    }

    public final ExtensionInfo b(Descriptors.Descriptor descriptor, int i) {
        return this.b.get(new a(descriptor, i));
    }

    private ExtensionRegistry() {
        new HashMap();
        new HashMap();
        this.b = new HashMap();
        new HashMap();
    }

    private ExtensionRegistry(byte b) {
        super(f6698a);
        Collections.emptyMap();
        Collections.emptyMap();
        this.b = Collections.emptyMap();
        Collections.emptyMap();
    }

    /* loaded from: classes3.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Descriptors.Descriptor f6697a;
        private final int b;

        a(Descriptors.Descriptor descriptor, int i) {
            this.f6697a = descriptor;
            this.b = i;
        }

        public final int hashCode() {
            return (this.f6697a.hashCode() * GameRequest.TYPE_ALL) + this.b;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f6697a == aVar.f6697a && this.b == aVar.b;
        }
    }
}
