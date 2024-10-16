package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Descriptors;
import com.uqm.crashsight.protobuf.ExtensionRegistry;
import com.uqm.crashsight.protobuf.GeneratedMessageV3;
import com.uqm.crashsight.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class l extends k<Descriptors.FieldDescriptor> {

    /* renamed from: a, reason: collision with root package name */
    private static final long f6826a = a();

    l() {
    }

    private static <T> long a() {
        return aw.a(GeneratedMessageV3.ExtendableMessage.class.getDeclaredField("b"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final boolean a(MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageV3.ExtendableMessage;
    }

    @Override // com.uqm.crashsight.protobuf.k
    public final FieldSet<Descriptors.FieldDescriptor> a(Object obj) {
        return (FieldSet) aw.f(obj, f6826a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final FieldSet<Descriptors.FieldDescriptor> b(Object obj) {
        FieldSet<Descriptors.FieldDescriptor> fieldSet = (FieldSet) aw.f(obj, f6826a);
        if (!fieldSet.f()) {
            return fieldSet;
        }
        FieldSet<Descriptors.FieldDescriptor> clone = fieldSet.clone();
        aw.a(obj, f6826a, clone);
        return clone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final void c(Object obj) {
        ((FieldSet) aw.f(obj, f6826a)).e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:55:0x0126. Please report as an issue. */
    @Override // com.uqm.crashsight.protobuf.k
    public final <UT, UB> UB a(an anVar, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> fieldSet, UB ub, at<UT, UB> atVar) throws IOException {
        ArrayList arrayList;
        ExtensionRegistry.ExtensionInfo extensionInfo = (ExtensionRegistry.ExtensionInfo) obj;
        int e = extensionInfo.f6696a.e();
        if (extensionInfo.f6696a.o() && extensionInfo.f6696a.p()) {
            switch (AnonymousClass1.f6827a[extensionInfo.f6696a.i().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    anVar.a(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    anVar.b(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    anVar.d(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    anVar.c(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    anVar.e(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    anVar.f(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    anVar.g(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    anVar.h(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    anVar.l(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    anVar.n(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    anVar.o(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    anVar.p(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    anVar.q(arrayList);
                    break;
                case 14:
                    ArrayList arrayList2 = new ArrayList();
                    anVar.m(arrayList2);
                    ArrayList arrayList3 = new ArrayList();
                    Iterator<Integer> it = arrayList2.iterator();
                    while (it.hasNext()) {
                        int intValue = it.next().intValue();
                        Descriptors.EnumValueDescriptor b = extensionInfo.f6696a.x().b(intValue);
                        if (b != null) {
                            arrayList3.add(b);
                        } else {
                            ub = (UB) aq.a(e, intValue, ub, atVar);
                        }
                    }
                    arrayList = arrayList3;
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + extensionInfo.f6696a.i());
            }
            fieldSet.a((FieldSet<Descriptors.FieldDescriptor>) extensionInfo.f6696a, arrayList);
        } else {
            Object obj2 = null;
            if (extensionInfo.f6696a.i() == WireFormat.FieldType.n) {
                int i = anVar.i();
                obj2 = extensionInfo.f6696a.x().b(i);
                if (obj2 == null) {
                    return (UB) aq.a(e, i, ub, atVar);
                }
            } else {
                switch (AnonymousClass1.f6827a[extensionInfo.f6696a.i().ordinal()]) {
                    case 1:
                        obj2 = Double.valueOf(anVar.e());
                        break;
                    case 2:
                        obj2 = Float.valueOf(anVar.f());
                        break;
                    case 3:
                        obj2 = Long.valueOf(anVar.h());
                        break;
                    case 4:
                        obj2 = Long.valueOf(anVar.g());
                        break;
                    case 5:
                        obj2 = Integer.valueOf(anVar.i());
                        break;
                    case 6:
                        obj2 = Long.valueOf(anVar.j());
                        break;
                    case 7:
                        obj2 = Integer.valueOf(anVar.k());
                        break;
                    case 8:
                        obj2 = Boolean.valueOf(anVar.l());
                        break;
                    case 9:
                        obj2 = Integer.valueOf(anVar.p());
                        break;
                    case 10:
                        obj2 = Integer.valueOf(anVar.r());
                        break;
                    case 11:
                        obj2 = Long.valueOf(anVar.s());
                        break;
                    case 12:
                        obj2 = Integer.valueOf(anVar.t());
                        break;
                    case 13:
                        obj2 = Long.valueOf(anVar.u());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        obj2 = anVar.o();
                        break;
                    case 16:
                        obj2 = anVar.m();
                        break;
                    case 17:
                        obj2 = anVar.b(extensionInfo.b.getClass(), extensionRegistryLite);
                        break;
                    case 18:
                        obj2 = anVar.a(extensionInfo.b.getClass(), extensionRegistryLite);
                        break;
                }
            }
            if (extensionInfo.f6696a.o()) {
                fieldSet.b((FieldSet<Descriptors.FieldDescriptor>) extensionInfo.f6696a, obj2);
            } else {
                switch (AnonymousClass1.f6827a[extensionInfo.f6696a.i().ordinal()]) {
                    case 17:
                    case 18:
                        Object b2 = fieldSet.b((FieldSet<Descriptors.FieldDescriptor>) extensionInfo.f6696a);
                        if (b2 != null) {
                            obj2 = Internal.a(b2, obj2);
                            break;
                        }
                        break;
                }
                fieldSet.a((FieldSet<Descriptors.FieldDescriptor>) extensionInfo.f6696a, obj2);
            }
        }
        return ub;
    }

    /* renamed from: com.uqm.crashsight.protobuf.l$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6827a = new int[WireFormat.FieldType.values().length];

        static {
            try {
                f6827a[WireFormat.FieldType.f6781a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6827a[WireFormat.FieldType.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6827a[WireFormat.FieldType.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6827a[WireFormat.FieldType.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6827a[WireFormat.FieldType.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6827a[WireFormat.FieldType.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6827a[WireFormat.FieldType.g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6827a[WireFormat.FieldType.h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6827a[WireFormat.FieldType.m.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6827a[WireFormat.FieldType.o.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6827a[WireFormat.FieldType.p.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6827a[WireFormat.FieldType.q.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f6827a[WireFormat.FieldType.r.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f6827a[WireFormat.FieldType.n.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f6827a[WireFormat.FieldType.l.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f6827a[WireFormat.FieldType.i.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f6827a[WireFormat.FieldType.j.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f6827a[WireFormat.FieldType.k.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final int a(Map.Entry<?, ?> entry) {
        return ((Descriptors.FieldDescriptor) entry.getKey()).e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final void a(Writer writer, Map.Entry<?, ?> entry) throws IOException {
        Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor) entry.getKey();
        if (fieldDescriptor.o()) {
            switch (AnonymousClass1.f6827a[fieldDescriptor.i().ordinal()]) {
                case 1:
                    aq.a(fieldDescriptor.e(), (List<Double>) entry.getValue(), writer, fieldDescriptor.p());
                    return;
                case 2:
                    aq.b(fieldDescriptor.e(), (List<Float>) entry.getValue(), writer, fieldDescriptor.p());
                    return;
                case 3:
                    aq.c(fieldDescriptor.e(), (List) entry.getValue(), writer, fieldDescriptor.p());
                    return;
                case 4:
                    aq.d(fieldDescriptor.e(), (List) entry.getValue(), writer, fieldDescriptor.p());
                    return;
                case 5:
                    aq.h(fieldDescriptor.e(), (List) entry.getValue(), writer, fieldDescriptor.p());
                    return;
                case 6:
                    aq.f(fieldDescriptor.e(), (List) entry.getValue(), writer, fieldDescriptor.p());
                    return;
                case 7:
                    aq.k(fieldDescriptor.e(), (List) entry.getValue(), writer, fieldDescriptor.p());
                    return;
                case 8:
                    aq.n(fieldDescriptor.e(), (List) entry.getValue(), writer, fieldDescriptor.p());
                    return;
                case 9:
                    aq.i(fieldDescriptor.e(), (List) entry.getValue(), writer, fieldDescriptor.p());
                    return;
                case 10:
                    aq.l(fieldDescriptor.e(), (List) entry.getValue(), writer, fieldDescriptor.p());
                    return;
                case 11:
                    aq.g(fieldDescriptor.e(), (List) entry.getValue(), writer, fieldDescriptor.p());
                    return;
                case 12:
                    aq.j(fieldDescriptor.e(), (List) entry.getValue(), writer, fieldDescriptor.p());
                    return;
                case 13:
                    aq.e(fieldDescriptor.e(), (List) entry.getValue(), writer, fieldDescriptor.p());
                    return;
                case 14:
                    List list = (List) entry.getValue();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Integer.valueOf(((Descriptors.EnumValueDescriptor) it.next()).a()));
                    }
                    aq.h(fieldDescriptor.e(), arrayList, writer, fieldDescriptor.p());
                    return;
                case 15:
                    aq.b(fieldDescriptor.e(), (List<ByteString>) entry.getValue(), writer);
                    return;
                case 16:
                    aq.a(fieldDescriptor.e(), (List<String>) entry.getValue(), writer);
                    return;
                case 17:
                    aq.d(fieldDescriptor.e(), (List<?>) entry.getValue(), writer);
                    return;
                case 18:
                    aq.c(fieldDescriptor.e(), (List<?>) entry.getValue(), writer);
                    return;
                default:
                    return;
            }
        }
        switch (AnonymousClass1.f6827a[fieldDescriptor.i().ordinal()]) {
            case 1:
                writer.a(fieldDescriptor.e(), ((Double) entry.getValue()).doubleValue());
                return;
            case 2:
                writer.a(fieldDescriptor.e(), ((Float) entry.getValue()).floatValue());
                return;
            case 3:
                writer.a(fieldDescriptor.e(), ((Long) entry.getValue()).longValue());
                return;
            case 4:
                writer.c(fieldDescriptor.e(), ((Long) entry.getValue()).longValue());
                return;
            case 5:
                writer.c(fieldDescriptor.e(), ((Integer) entry.getValue()).intValue());
                return;
            case 6:
                writer.d(fieldDescriptor.e(), ((Long) entry.getValue()).longValue());
                return;
            case 7:
                writer.d(fieldDescriptor.e(), ((Integer) entry.getValue()).intValue());
                return;
            case 8:
                writer.a(fieldDescriptor.e(), ((Boolean) entry.getValue()).booleanValue());
                return;
            case 9:
                writer.e(fieldDescriptor.e(), ((Integer) entry.getValue()).intValue());
                return;
            case 10:
                writer.a(fieldDescriptor.e(), ((Integer) entry.getValue()).intValue());
                return;
            case 11:
                writer.b(fieldDescriptor.e(), ((Long) entry.getValue()).longValue());
                return;
            case 12:
                writer.f(fieldDescriptor.e(), ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                writer.e(fieldDescriptor.e(), ((Long) entry.getValue()).longValue());
                return;
            case 14:
                writer.c(fieldDescriptor.e(), ((Descriptors.EnumValueDescriptor) entry.getValue()).a());
                return;
            case 15:
                writer.a(fieldDescriptor.e(), (ByteString) entry.getValue());
                return;
            case 16:
                writer.a(fieldDescriptor.e(), (String) entry.getValue());
                return;
            case 17:
                writer.b(fieldDescriptor.e(), entry.getValue());
                return;
            case 18:
                writer.a(fieldDescriptor.e(), entry.getValue());
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final Object a(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i) {
        return ((ExtensionRegistry) extensionRegistryLite).a(((Message) messageLite).d(), i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final void a(an anVar, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> fieldSet) throws IOException {
        ExtensionRegistry.ExtensionInfo extensionInfo = (ExtensionRegistry.ExtensionInfo) obj;
        if (ExtensionRegistryLite.b()) {
            fieldSet.a((FieldSet<Descriptors.FieldDescriptor>) extensionInfo.f6696a, anVar.a(extensionInfo.b.getClass(), extensionRegistryLite));
        } else {
            fieldSet.a((FieldSet<Descriptors.FieldDescriptor>) extensionInfo.f6696a, new LazyField(extensionInfo.b, extensionRegistryLite, anVar.o()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final void a(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> fieldSet) throws IOException {
        ExtensionRegistry.ExtensionInfo extensionInfo = (ExtensionRegistry.ExtensionInfo) obj;
        Message g = extensionInfo.b.q().g();
        if (ExtensionRegistryLite.b()) {
            d a2 = d.a(ByteBuffer.wrap(byteString.d()), true);
            ak.a().a(g, a2, extensionRegistryLite);
            fieldSet.a((FieldSet<Descriptors.FieldDescriptor>) extensionInfo.f6696a, g);
            if (a2.b() != Integer.MAX_VALUE) {
                throw InvalidProtocolBufferException.g();
            }
            return;
        }
        fieldSet.a((FieldSet<Descriptors.FieldDescriptor>) extensionInfo.f6696a, new LazyField(extensionInfo.b, extensionRegistryLite, byteString));
    }
}
