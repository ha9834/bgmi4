package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.GeneratedMessage;
import com.uqm.crashsight.protobuf.GeneratedMessage.Builder;
import com.uqm.crashsight.protobuf.MessageOrBuilder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class RepeatedFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> implements GeneratedMessage.BuilderParent {

    /* renamed from: a, reason: collision with root package name */
    private List<SingleFieldBuilder<MType, BType, IType>> f6756a;

    @Override // com.uqm.crashsight.protobuf.AbstractMessage.BuilderParent
    public final void a() {
    }

    public final int b() {
        List list = null;
        return list.size();
    }

    public final MType a(int i) {
        SingleFieldBuilder<MType, BType, IType> singleFieldBuilder;
        List<SingleFieldBuilder<MType, BType, IType>> list = this.f6756a;
        List list2 = null;
        return (list == null || (singleFieldBuilder = list.get(i)) == null) ? (MType) list2.get(i) : singleFieldBuilder.b();
    }

    public final BType b(int i) {
        List list = null;
        if (this.f6756a == null) {
            this.f6756a = new ArrayList(list.size());
            for (int i2 = 0; i2 < list.size(); i2++) {
                this.f6756a.add(null);
            }
        }
        SingleFieldBuilder<MType, BType, IType> singleFieldBuilder = this.f6756a.get(i);
        if (singleFieldBuilder == null) {
            SingleFieldBuilder<MType, BType, IType> singleFieldBuilder2 = new SingleFieldBuilder<>((GeneratedMessage) list.get(i), this, false);
            this.f6756a.set(i, singleFieldBuilder2);
            singleFieldBuilder = singleFieldBuilder2;
        }
        return singleFieldBuilder.c();
    }

    public final IType c(int i) {
        List<SingleFieldBuilder<MType, BType, IType>> list = this.f6756a;
        List list2 = null;
        if (list == null) {
            return (IType) list2.get(i);
        }
        SingleFieldBuilder<MType, BType, IType> singleFieldBuilder = list.get(i);
        if (singleFieldBuilder == null) {
            return (IType) list2.get(i);
        }
        return singleFieldBuilder.d();
    }
}
