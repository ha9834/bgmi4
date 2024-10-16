package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.GeneratedMessageLite;
import com.uqm.crashsight.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class m extends k<GeneratedMessageLite.a> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final boolean a(MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageLite.ExtendableMessage;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final FieldSet<GeneratedMessageLite.a> a(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).f6710a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final FieldSet<GeneratedMessageLite.a> b(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final void c(Object obj) {
        ((GeneratedMessageLite.ExtendableMessage) obj).f6710a.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:43:0x00ff. Please report as an issue. */
    @Override // com.uqm.crashsight.protobuf.k
    public final <UT, UB> UB a(an anVar, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<GeneratedMessageLite.a> fieldSet, UB ub, at<UT, UB> atVar) throws IOException {
        ArrayList arrayList;
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        int b = generatedExtension.b();
        if (generatedExtension.f6711a.o() && generatedExtension.f6711a.p()) {
            switch (AnonymousClass1.f6828a[generatedExtension.d().ordinal()]) {
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
                    arrayList = new ArrayList();
                    anVar.m(arrayList);
                    ub = (UB) aq.a(b, arrayList, generatedExtension.f6711a.a(), ub, atVar);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + generatedExtension.f6711a.i());
            }
            fieldSet.a((FieldSet<GeneratedMessageLite.a>) generatedExtension.f6711a, arrayList);
        } else {
            Object obj2 = null;
            if (generatedExtension.d() == WireFormat.FieldType.n) {
                int i = anVar.i();
                if (generatedExtension.f6711a.a().a(i) == null) {
                    return (UB) aq.a(b, i, ub, atVar);
                }
                obj2 = Integer.valueOf(i);
            } else {
                switch (AnonymousClass1.f6828a[generatedExtension.d().ordinal()]) {
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
                        obj2 = anVar.b(generatedExtension.c().getClass(), extensionRegistryLite);
                        break;
                    case 18:
                        obj2 = anVar.a(generatedExtension.c().getClass(), extensionRegistryLite);
                        break;
                }
            }
            if (generatedExtension.e()) {
                fieldSet.b((FieldSet<GeneratedMessageLite.a>) generatedExtension.f6711a, obj2);
            } else {
                switch (AnonymousClass1.f6828a[generatedExtension.d().ordinal()]) {
                    case 17:
                    case 18:
                        Object b2 = fieldSet.b((FieldSet<GeneratedMessageLite.a>) generatedExtension.f6711a);
                        if (b2 != null) {
                            obj2 = Internal.a(b2, obj2);
                            break;
                        }
                        break;
                }
                fieldSet.a((FieldSet<GeneratedMessageLite.a>) generatedExtension.f6711a, obj2);
            }
        }
        return ub;
    }

    /* renamed from: com.uqm.crashsight.protobuf.m$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6828a = new int[WireFormat.FieldType.values().length];

        static {
            try {
                f6828a[WireFormat.FieldType.f6781a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6828a[WireFormat.FieldType.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6828a[WireFormat.FieldType.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6828a[WireFormat.FieldType.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6828a[WireFormat.FieldType.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6828a[WireFormat.FieldType.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6828a[WireFormat.FieldType.g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6828a[WireFormat.FieldType.h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6828a[WireFormat.FieldType.m.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6828a[WireFormat.FieldType.o.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6828a[WireFormat.FieldType.p.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6828a[WireFormat.FieldType.q.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f6828a[WireFormat.FieldType.r.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f6828a[WireFormat.FieldType.n.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f6828a[WireFormat.FieldType.l.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f6828a[WireFormat.FieldType.i.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f6828a[WireFormat.FieldType.j.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f6828a[WireFormat.FieldType.k.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final int a(Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.a) entry.getKey()).e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final void a(Writer writer, Map.Entry<?, ?> entry) throws IOException {
        GeneratedMessageLite.a aVar = (GeneratedMessageLite.a) entry.getKey();
        if (aVar.o()) {
            switch (AnonymousClass1.f6828a[aVar.i().ordinal()]) {
                case 1:
                    aq.a(aVar.e(), (List<Double>) entry.getValue(), writer, aVar.p());
                    return;
                case 2:
                    aq.b(aVar.e(), (List<Float>) entry.getValue(), writer, aVar.p());
                    return;
                case 3:
                    aq.c(aVar.e(), (List) entry.getValue(), writer, aVar.p());
                    return;
                case 4:
                    aq.d(aVar.e(), (List) entry.getValue(), writer, aVar.p());
                    return;
                case 5:
                    aq.h(aVar.e(), (List) entry.getValue(), writer, aVar.p());
                    return;
                case 6:
                    aq.f(aVar.e(), (List) entry.getValue(), writer, aVar.p());
                    return;
                case 7:
                    aq.k(aVar.e(), (List) entry.getValue(), writer, aVar.p());
                    return;
                case 8:
                    aq.n(aVar.e(), (List) entry.getValue(), writer, aVar.p());
                    return;
                case 9:
                    aq.i(aVar.e(), (List) entry.getValue(), writer, aVar.p());
                    return;
                case 10:
                    aq.l(aVar.e(), (List) entry.getValue(), writer, aVar.p());
                    return;
                case 11:
                    aq.g(aVar.e(), (List) entry.getValue(), writer, aVar.p());
                    return;
                case 12:
                    aq.j(aVar.e(), (List) entry.getValue(), writer, aVar.p());
                    return;
                case 13:
                    aq.e(aVar.e(), (List) entry.getValue(), writer, aVar.p());
                    return;
                case 14:
                    aq.h(aVar.e(), (List) entry.getValue(), writer, aVar.p());
                    return;
                case 15:
                    aq.b(aVar.e(), (List<ByteString>) entry.getValue(), writer);
                    return;
                case 16:
                    aq.a(aVar.e(), (List<String>) entry.getValue(), writer);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    aq.b(aVar.e(), (List<?>) entry.getValue(), writer, ak.a().a((Class) list.get(0).getClass()));
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 == null || list2.isEmpty()) {
                        return;
                    }
                    aq.a(aVar.e(), (List<?>) entry.getValue(), writer, ak.a().a((Class) list2.get(0).getClass()));
                    return;
                default:
                    return;
            }
        }
        switch (AnonymousClass1.f6828a[aVar.i().ordinal()]) {
            case 1:
                writer.a(aVar.e(), ((Double) entry.getValue()).doubleValue());
                return;
            case 2:
                writer.a(aVar.e(), ((Float) entry.getValue()).floatValue());
                return;
            case 3:
                writer.a(aVar.e(), ((Long) entry.getValue()).longValue());
                return;
            case 4:
                writer.c(aVar.e(), ((Long) entry.getValue()).longValue());
                return;
            case 5:
                writer.c(aVar.e(), ((Integer) entry.getValue()).intValue());
                return;
            case 6:
                writer.d(aVar.e(), ((Long) entry.getValue()).longValue());
                return;
            case 7:
                writer.d(aVar.e(), ((Integer) entry.getValue()).intValue());
                return;
            case 8:
                writer.a(aVar.e(), ((Boolean) entry.getValue()).booleanValue());
                return;
            case 9:
                writer.e(aVar.e(), ((Integer) entry.getValue()).intValue());
                return;
            case 10:
                writer.a(aVar.e(), ((Integer) entry.getValue()).intValue());
                return;
            case 11:
                writer.b(aVar.e(), ((Long) entry.getValue()).longValue());
                return;
            case 12:
                writer.f(aVar.e(), ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                writer.e(aVar.e(), ((Long) entry.getValue()).longValue());
                return;
            case 14:
                writer.c(aVar.e(), ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                writer.a(aVar.e(), (ByteString) entry.getValue());
                return;
            case 16:
                writer.a(aVar.e(), (String) entry.getValue());
                return;
            case 17:
                writer.b(aVar.e(), entry.getValue(), ak.a().a((Class) entry.getValue().getClass()));
                return;
            case 18:
                writer.a(aVar.e(), entry.getValue(), ak.a().a((Class) entry.getValue().getClass()));
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final Object a(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i) {
        return extensionRegistryLite.a(messageLite, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final void a(an anVar, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<GeneratedMessageLite.a> fieldSet) throws IOException {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        fieldSet.a((FieldSet<GeneratedMessageLite.a>) generatedExtension.f6711a, anVar.a(generatedExtension.c().getClass(), extensionRegistryLite));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.k
    public final void a(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<GeneratedMessageLite.a> fieldSet) throws IOException {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        MessageLite g = generatedExtension.c().newBuilderForType().g();
        d a2 = d.a(ByteBuffer.wrap(byteString.d()), true);
        ak.a().a(g, a2, extensionRegistryLite);
        fieldSet.a((FieldSet<GeneratedMessageLite.a>) generatedExtension.f6711a, g);
        if (a2.b() != Integer.MAX_VALUE) {
            throw InvalidProtocolBufferException.g();
        }
    }
}
