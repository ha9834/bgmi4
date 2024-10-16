package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    private static final r f6833a;
    private static final r b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> a(Object obj, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void a(Object obj, Object obj2, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void b(Object obj, long j);

    /* synthetic */ r(byte b2) {
        this();
    }

    private r() {
    }

    static {
        byte b2 = 0;
        f6833a = new a(b2);
        b = new b(b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r a() {
        return f6833a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static r b() {
        return b;
    }

    /* loaded from: classes3.dex */
    static final class a extends r {

        /* renamed from: a, reason: collision with root package name */
        private static final Class<?> f6834a = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private a() {
            super((byte) 0);
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.uqm.crashsight.protobuf.r
        final <L> List<L> a(Object obj, long j) {
            return a(obj, j, 10);
        }

        @Override // com.uqm.crashsight.protobuf.r
        final void b(Object obj, long j) {
            Object unmodifiableList;
            List list = (List) aw.f(obj, j);
            if (list instanceof LazyStringList) {
                unmodifiableList = ((LazyStringList) list).e();
            } else {
                if (f6834a.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof aj) && (list instanceof Internal.ProtobufList)) {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.a()) {
                        protobufList.b();
                        return;
                    }
                    return;
                }
                unmodifiableList = Collections.unmodifiableList(list);
            }
            aw.a(obj, j, unmodifiableList);
        }

        private static <L> List<L> a(Object obj, long j, int i) {
            List<L> arrayList;
            List<L> list = (List) aw.f(obj, j);
            if (list.isEmpty()) {
                if (list instanceof LazyStringList) {
                    arrayList = new LazyStringArrayList(i);
                } else if ((list instanceof aj) && (list instanceof Internal.ProtobufList)) {
                    arrayList = ((Internal.ProtobufList) list).c(i);
                } else {
                    arrayList = new ArrayList<>(i);
                }
                aw.a(obj, j, arrayList);
                return arrayList;
            }
            if (f6834a.isAssignableFrom(list.getClass())) {
                ArrayList arrayList2 = new ArrayList(list.size() + i);
                arrayList2.addAll(list);
                aw.a(obj, j, arrayList2);
                return arrayList2;
            }
            if (list instanceof UnmodifiableLazyStringList) {
                LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(list.size() + i);
                lazyStringArrayList.addAll((UnmodifiableLazyStringList) list);
                aw.a(obj, j, lazyStringArrayList);
                return lazyStringArrayList;
            }
            if (!(list instanceof aj) || !(list instanceof Internal.ProtobufList)) {
                return list;
            }
            Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
            if (protobufList.a()) {
                return list;
            }
            Internal.ProtobufList c = protobufList.c(list.size() + i);
            aw.a(obj, j, c);
            return c;
        }

        @Override // com.uqm.crashsight.protobuf.r
        final <E> void a(Object obj, Object obj2, long j) {
            List list = (List) aw.f(obj2, j);
            List a2 = a(obj, j, list.size());
            int size = a2.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                a2.addAll(list);
            }
            if (size > 0) {
                list = a2;
            }
            aw.a(obj, j, list);
        }
    }

    /* loaded from: classes3.dex */
    static final class b extends r {
        private b() {
            super((byte) 0);
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.uqm.crashsight.protobuf.r
        final <L> List<L> a(Object obj, long j) {
            Internal.ProtobufList protobufList = (Internal.ProtobufList) aw.f(obj, j);
            if (protobufList.a()) {
                return protobufList;
            }
            int size = protobufList.size();
            Internal.ProtobufList c = protobufList.c(size == 0 ? 10 : size << 1);
            aw.a(obj, j, c);
            return c;
        }

        @Override // com.uqm.crashsight.protobuf.r
        final void b(Object obj, long j) {
            ((Internal.ProtobufList) aw.f(obj, j)).b();
        }

        @Override // com.uqm.crashsight.protobuf.r
        final <E> void a(Object obj, Object obj2, long j) {
            Internal.ProtobufList protobufList = (Internal.ProtobufList) aw.f(obj, j);
            Internal.ProtobufList protobufList2 = (Internal.ProtobufList) aw.f(obj2, j);
            int size = protobufList.size();
            int size2 = protobufList2.size();
            if (size > 0 && size2 > 0) {
                if (!protobufList.a()) {
                    protobufList = protobufList.c(size2 + size);
                }
                protobufList.addAll(protobufList2);
            }
            if (size > 0) {
                protobufList2 = protobufList;
            }
            aw.a(obj, j, protobufList2);
        }
    }
}
