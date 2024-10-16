package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.GeneratedMessage;
import com.uqm.crashsight.protobuf.GeneratedMessage.Builder;
import com.uqm.crashsight.protobuf.MessageOrBuilder;

/* loaded from: classes3.dex */
public class SingleFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> implements GeneratedMessage.BuilderParent {

    /* renamed from: a, reason: collision with root package name */
    private GeneratedMessage.BuilderParent f6758a;
    private BType b;
    private MType c;
    private boolean d;

    public SingleFieldBuilder(MType mtype, GeneratedMessage.BuilderParent builderParent, boolean z) {
        this.c = (MType) Internal.a(mtype);
        this.f6758a = builderParent;
        this.d = z;
    }

    public final MType b() {
        if (this.c == null) {
            this.c = (MType) this.b.g();
        }
        return this.c;
    }

    public final BType c() {
        if (this.b == null) {
            this.b = (BType) this.c.c();
            this.b.c(this.c);
            this.b.a_();
        }
        return this.b;
    }

    public final IType d() {
        BType btype = this.b;
        return btype != null ? btype : this.c;
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessage.BuilderParent
    public final void a() {
        GeneratedMessage.BuilderParent builderParent;
        if (this.b != null) {
            this.c = null;
        }
        if (!this.d || (builderParent = this.f6758a) == null) {
            return;
        }
        builderParent.a();
        this.d = false;
    }
}
