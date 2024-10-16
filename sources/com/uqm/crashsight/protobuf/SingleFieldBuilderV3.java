package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.AbstractMessage;
import com.uqm.crashsight.protobuf.AbstractMessage.Builder;
import com.uqm.crashsight.protobuf.MessageOrBuilder;

/* loaded from: classes3.dex */
public class SingleFieldBuilderV3<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {

    /* renamed from: a, reason: collision with root package name */
    private AbstractMessage.BuilderParent f6759a;
    private BType b;
    private MType c;
    private boolean d;

    public SingleFieldBuilderV3(MType mtype, AbstractMessage.BuilderParent builderParent, boolean z) {
        this.c = (MType) Internal.a(mtype);
        this.f6759a = builderParent;
        this.d = z;
    }

    public final MType b() {
        if (this.c == null) {
            this.c = (MType) this.b.g();
        }
        return this.c;
    }

    public final MType c() {
        this.d = true;
        if (this.c == null) {
            this.c = (MType) this.b.g();
        }
        return this.c;
    }

    public final BType d() {
        if (this.b == null) {
            this.b = (BType) this.c.a(this);
            this.b.internalMergeFrom(this.c);
            this.b.a_();
        }
        return this.b;
    }

    public final IType e() {
        BType btype = this.b;
        return btype != null ? btype : this.c;
    }

    public final SingleFieldBuilderV3<MType, BType, IType> a(MType mtype) {
        if (this.b == null) {
            Message message = this.c;
            if (message == message.r()) {
                this.c = mtype;
                f();
                return this;
            }
        }
        d().internalMergeFrom(mtype);
        f();
        return this;
    }

    private void f() {
        AbstractMessage.BuilderParent builderParent;
        if (this.b != null) {
            this.c = null;
        }
        if (!this.d || (builderParent = this.f6759a) == null) {
            return;
        }
        builderParent.a();
        this.d = false;
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessage.BuilderParent
    public final void a() {
        f();
    }
}
