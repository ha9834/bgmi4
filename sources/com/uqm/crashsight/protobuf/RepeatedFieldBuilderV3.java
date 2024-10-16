package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.AbstractMessage;
import com.uqm.crashsight.protobuf.AbstractMessage.Builder;
import com.uqm.crashsight.protobuf.MessageOrBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class RepeatedFieldBuilderV3<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {

    /* renamed from: a, reason: collision with root package name */
    private AbstractMessage.BuilderParent f6757a;
    private List<MType> b;
    private boolean c;
    private List<SingleFieldBuilderV3<MType, BType, IType>> d;
    private boolean e;

    public final void b() {
        this.f6757a = null;
    }

    public final int c() {
        return this.b.size();
    }

    public final boolean d() {
        return this.b.isEmpty();
    }

    public final MType a(int i) {
        return a(i, false);
    }

    private MType a(int i, boolean z) {
        List<SingleFieldBuilderV3<MType, BType, IType>> list = this.d;
        if (list == null) {
            return this.b.get(i);
        }
        SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV3 = list.get(i);
        if (singleFieldBuilderV3 == null) {
            return this.b.get(i);
        }
        return z ? singleFieldBuilderV3.c() : singleFieldBuilderV3.b();
    }

    public final BType b(int i) {
        if (this.d == null) {
            this.d = new ArrayList(this.b.size());
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                this.d.add(null);
            }
        }
        SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV3 = this.d.get(i);
        if (singleFieldBuilderV3 == null) {
            SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV32 = new SingleFieldBuilderV3<>(this.b.get(i), this, this.e);
            this.d.set(i, singleFieldBuilderV32);
            singleFieldBuilderV3 = singleFieldBuilderV32;
        }
        return singleFieldBuilderV3.d();
    }

    public final IType c(int i) {
        List<SingleFieldBuilderV3<MType, BType, IType>> list = this.d;
        if (list == null) {
            return this.b.get(i);
        }
        SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV3 = list.get(i);
        if (singleFieldBuilderV3 == null) {
            return this.b.get(i);
        }
        return singleFieldBuilderV3.e();
    }

    public final RepeatedFieldBuilderV3<MType, BType, IType> a(MType mtype) {
        AbstractMessage.BuilderParent builderParent;
        Internal.a(mtype);
        if (!this.c) {
            this.b = new ArrayList(this.b);
            this.c = true;
        }
        this.b.add(mtype);
        List<SingleFieldBuilderV3<MType, BType, IType>> list = this.d;
        if (list != null) {
            list.add(null);
        }
        if (this.e && (builderParent = this.f6757a) != null) {
            builderParent.a();
            this.e = false;
        }
        return this;
    }

    public final RepeatedFieldBuilderV3<MType, BType, IType> a(Iterable<? extends MType> iterable) {
        AbstractMessage.BuilderParent builderParent;
        Iterator<? extends MType> it = iterable.iterator();
        while (it.hasNext()) {
            Internal.a(it.next());
        }
        int i = -1;
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() == 0) {
                return this;
            }
            i = collection.size();
        }
        if (!this.c) {
            this.b = new ArrayList(this.b);
            this.c = true;
        }
        if (i >= 0) {
            List<MType> list = this.b;
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + i);
            }
        }
        Iterator<? extends MType> it2 = iterable.iterator();
        while (it2.hasNext()) {
            a((RepeatedFieldBuilderV3<MType, BType, IType>) it2.next());
        }
        if (this.e && (builderParent = this.f6757a) != null) {
            builderParent.a();
            this.e = false;
        }
        return this;
    }

    public final List<MType> e() {
        boolean z;
        this.e = true;
        if (!this.c && this.d == null) {
            return this.b;
        }
        if (!this.c) {
            int i = 0;
            while (true) {
                if (i >= this.b.size()) {
                    z = true;
                    break;
                }
                MType mtype = this.b.get(i);
                SingleFieldBuilderV3<MType, BType, IType> singleFieldBuilderV3 = this.d.get(i);
                if (singleFieldBuilderV3 != null && singleFieldBuilderV3.c() != mtype) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                return this.b;
            }
        }
        if (!this.c) {
            this.b = new ArrayList(this.b);
            this.c = true;
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            this.b.set(i2, a(i2, true));
        }
        this.b = Collections.unmodifiableList(this.b);
        this.c = false;
        return this.b;
    }

    @Override // com.uqm.crashsight.protobuf.AbstractMessage.BuilderParent
    public final void a() {
        AbstractMessage.BuilderParent builderParent;
        if (!this.e || (builderParent = this.f6757a) == null) {
            return;
        }
        builderParent.a();
        this.e = false;
    }
}
