package com.uqm.crashsight.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
final class StructuralMessageInfo implements y {

    /* renamed from: a, reason: collision with root package name */
    private final ProtoSyntax f6760a;
    private final boolean b;
    private final int[] c;
    private final FieldInfo[] d;
    private final MessageLite e;

    StructuralMessageInfo(ProtoSyntax protoSyntax, boolean z, int[] iArr, FieldInfo[] fieldInfoArr, Object obj) {
        this.f6760a = protoSyntax;
        this.b = z;
        this.c = iArr;
        this.d = fieldInfoArr;
        this.e = (MessageLite) Internal.a(obj, "defaultInstance");
    }

    @Override // com.uqm.crashsight.protobuf.y
    public final ProtoSyntax a() {
        return this.f6760a;
    }

    @Override // com.uqm.crashsight.protobuf.y
    public final boolean b() {
        return this.b;
    }

    public final int[] d() {
        return this.c;
    }

    public final FieldInfo[] e() {
        return this.d;
    }

    @Override // com.uqm.crashsight.protobuf.y
    public final MessageLite c() {
        return this.e;
    }

    public static Builder a(int i) {
        return new Builder(i);
    }

    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final List<FieldInfo> f6761a;
        private ProtoSyntax b;
        private boolean c;
        private boolean d;
        private int[] e;
        private Object f;

        public Builder() {
            this.e = null;
            this.f6761a = new ArrayList();
        }

        public Builder(int i) {
            this.e = null;
            this.f6761a = new ArrayList(i);
        }

        public final void a(Object obj) {
            this.f = obj;
        }

        public final void a(ProtoSyntax protoSyntax) {
            this.b = (ProtoSyntax) Internal.a(protoSyntax, "syntax");
        }

        public final void a(boolean z) {
            this.d = z;
        }

        public final void a(int[] iArr) {
            this.e = iArr;
        }

        public final void a(FieldInfo fieldInfo) {
            if (this.c) {
                throw new IllegalStateException("Builder can only build once");
            }
            this.f6761a.add(fieldInfo);
        }

        public final StructuralMessageInfo a() {
            if (this.c) {
                throw new IllegalStateException("Builder can only build once");
            }
            if (this.b == null) {
                throw new IllegalStateException("Must specify a proto syntax");
            }
            this.c = true;
            Collections.sort(this.f6761a);
            return new StructuralMessageInfo(this.b, this.d, this.e, (FieldInfo[]) this.f6761a.toArray(new FieldInfo[0]), this.f);
        }
    }
}
