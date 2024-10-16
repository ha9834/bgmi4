package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.FieldSet;
import com.uqm.crashsight.protobuf.LazyField;
import com.uqm.crashsight.protobuf.WireFormat;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class ac<T> implements ao<T> {

    /* renamed from: a, reason: collision with root package name */
    private final MessageLite f6788a;
    private final at<?, ?> b;
    private final boolean c;
    private final k<?> d;

    private ac(at<?, ?> atVar, k<?> kVar, MessageLite messageLite) {
        this.b = atVar;
        this.c = kVar.a(messageLite);
        this.d = kVar;
        this.f6788a = messageLite;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ac<T> a(at<?, ?> atVar, k<?> kVar, MessageLite messageLite) {
        return new ac<>(atVar, kVar, messageLite);
    }

    @Override // com.uqm.crashsight.protobuf.ao
    public final T a() {
        return (T) this.f6788a.newBuilderForType().h();
    }

    @Override // com.uqm.crashsight.protobuf.ao
    public final boolean a(T t, T t2) {
        if (!this.b.b(t).equals(this.b.b(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.a(t).equals(this.d.a(t2));
        }
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.ao
    public final int a(T t) {
        int hashCode = this.b.b(t).hashCode();
        return this.c ? (hashCode * 53) + this.d.a(t).hashCode() : hashCode;
    }

    @Override // com.uqm.crashsight.protobuf.ao
    public final void b(T t, T t2) {
        aq.a(this.b, t, t2);
        if (this.c) {
            aq.a(this.d, t, t2);
        }
    }

    @Override // com.uqm.crashsight.protobuf.ao
    public final void a(T t, Writer writer) throws IOException {
        Iterator<Map.Entry<?, Object>> i = this.d.a(t).i();
        while (i.hasNext()) {
            Map.Entry<?, Object> next = i.next();
            FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite) next.getKey();
            if (fieldDescriptorLite.g() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.o() || fieldDescriptorLite.p()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof LazyField.a) {
                writer.c(fieldDescriptorLite.e(), ((LazyField.a) next).a().c());
            } else {
                writer.c(fieldDescriptorLite.e(), next.getValue());
            }
        }
        at<?, ?> atVar = this.b;
        atVar.b((at<?, ?>) atVar.b(t), writer);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x007e. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00cb  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.uqm.crashsight.protobuf.ao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r10, byte[] r11, int r12, int r13, com.uqm.crashsight.protobuf.c.a r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.uqm.crashsight.protobuf.GeneratedMessageLite r0 = (com.uqm.crashsight.protobuf.GeneratedMessageLite) r0
            com.uqm.crashsight.protobuf.UnknownFieldSetLite r1 = r0.unknownFields
            com.uqm.crashsight.protobuf.UnknownFieldSetLite r2 = com.uqm.crashsight.protobuf.UnknownFieldSetLite.a()
            if (r1 != r2) goto L11
            com.uqm.crashsight.protobuf.UnknownFieldSetLite r1 = com.uqm.crashsight.protobuf.UnknownFieldSetLite.b()
            r0.unknownFields = r1
        L11:
            com.uqm.crashsight.protobuf.GeneratedMessageLite$ExtendableMessage r10 = (com.uqm.crashsight.protobuf.GeneratedMessageLite.ExtendableMessage) r10
            com.uqm.crashsight.protobuf.FieldSet r10 = r10.a()
            r0 = 0
            r2 = r0
        L19:
            if (r12 >= r13) goto Ld5
            int r4 = com.uqm.crashsight.protobuf.c.a(r11, r12, r14)
            int r12 = r14.f6808a
            int r3 = com.uqm.crashsight.protobuf.WireFormat.f6779a
            r5 = 2
            if (r12 == r3) goto L6c
            int r3 = com.uqm.crashsight.protobuf.WireFormat.a(r12)
            if (r3 != r5) goto L67
            com.uqm.crashsight.protobuf.k<?> r2 = r9.d
            com.uqm.crashsight.protobuf.ExtensionRegistryLite r3 = r14.d
            com.uqm.crashsight.protobuf.MessageLite r5 = r9.f6788a
            int r6 = com.uqm.crashsight.protobuf.WireFormat.b(r12)
            java.lang.Object r2 = r2.a(r3, r5, r6)
            r8 = r2
            com.uqm.crashsight.protobuf.GeneratedMessageLite$GeneratedExtension r8 = (com.uqm.crashsight.protobuf.GeneratedMessageLite.GeneratedExtension) r8
            if (r8 == 0) goto L5c
            com.uqm.crashsight.protobuf.ak r12 = com.uqm.crashsight.protobuf.ak.a()
            com.uqm.crashsight.protobuf.MessageLite r2 = r8.c()
            java.lang.Class r2 = r2.getClass()
            com.uqm.crashsight.protobuf.ao r12 = r12.a(r2)
            int r12 = com.uqm.crashsight.protobuf.c.a(r12, r11, r4, r13, r14)
            com.uqm.crashsight.protobuf.GeneratedMessageLite$a r2 = r8.f6711a
            java.lang.Object r3 = r14.c
            r10.a(r2, r3)
            r2 = r8
            goto L19
        L5c:
            r2 = r12
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.uqm.crashsight.protobuf.c.a(r2, r3, r4, r5, r6, r7)
            r2 = r8
            goto L19
        L67:
            int r12 = com.uqm.crashsight.protobuf.c.a(r12, r11, r4, r13, r14)
            goto L19
        L6c:
            r12 = 0
            r3 = r0
        L6e:
            if (r4 >= r13) goto Lc9
            int r4 = com.uqm.crashsight.protobuf.c.a(r11, r4, r14)
            int r6 = r14.f6808a
            int r7 = com.uqm.crashsight.protobuf.WireFormat.b(r6)
            int r8 = com.uqm.crashsight.protobuf.WireFormat.a(r6)
            switch(r7) {
                case 2: goto Lab;
                case 3: goto L82;
                default: goto L81;
            }
        L81:
            goto Lc0
        L82:
            if (r2 == 0) goto La0
            com.uqm.crashsight.protobuf.ak r6 = com.uqm.crashsight.protobuf.ak.a()
            com.uqm.crashsight.protobuf.MessageLite r7 = r2.c()
            java.lang.Class r7 = r7.getClass()
            com.uqm.crashsight.protobuf.ao r6 = r6.a(r7)
            int r4 = com.uqm.crashsight.protobuf.c.a(r6, r11, r4, r13, r14)
            com.uqm.crashsight.protobuf.GeneratedMessageLite$a r6 = r2.f6711a
            java.lang.Object r7 = r14.c
            r10.a(r6, r7)
            goto L6e
        La0:
            if (r8 != r5) goto Lc0
            int r4 = com.uqm.crashsight.protobuf.c.e(r11, r4, r14)
            java.lang.Object r3 = r14.c
            com.uqm.crashsight.protobuf.ByteString r3 = (com.uqm.crashsight.protobuf.ByteString) r3
            goto L6e
        Lab:
            if (r8 != 0) goto Lc0
            int r4 = com.uqm.crashsight.protobuf.c.a(r11, r4, r14)
            int r12 = r14.f6808a
            com.uqm.crashsight.protobuf.k<?> r2 = r9.d
            com.uqm.crashsight.protobuf.ExtensionRegistryLite r6 = r14.d
            com.uqm.crashsight.protobuf.MessageLite r7 = r9.f6788a
            java.lang.Object r2 = r2.a(r6, r7, r12)
            com.uqm.crashsight.protobuf.GeneratedMessageLite$GeneratedExtension r2 = (com.uqm.crashsight.protobuf.GeneratedMessageLite.GeneratedExtension) r2
            goto L6e
        Lc0:
            int r7 = com.uqm.crashsight.protobuf.WireFormat.b
            if (r6 == r7) goto Lc9
            int r4 = com.uqm.crashsight.protobuf.c.a(r6, r11, r4, r13, r14)
            goto L6e
        Lc9:
            if (r3 == 0) goto Ld2
            int r12 = com.uqm.crashsight.protobuf.WireFormat.a(r12, r5)
            r1.a(r12, r3)
        Ld2:
            r12 = r4
            goto L19
        Ld5:
            if (r12 != r13) goto Ld8
            return
        Ld8:
            com.uqm.crashsight.protobuf.InvalidProtocolBufferException r10 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.k()
            throw r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.ac.a(java.lang.Object, byte[], int, int, com.uqm.crashsight.protobuf.c$a):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[LOOP:0: B:2:0x000c->B:20:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.uqm.crashsight.protobuf.ao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r11, com.uqm.crashsight.protobuf.an r12, com.uqm.crashsight.protobuf.ExtensionRegistryLite r13) throws java.io.IOException {
        /*
            r10 = this;
            com.uqm.crashsight.protobuf.at<?, ?> r0 = r10.b
            com.uqm.crashsight.protobuf.k<?> r1 = r10.d
            java.lang.Object r2 = r0.c(r11)
            com.uqm.crashsight.protobuf.FieldSet r3 = r1.b(r11)
        Lc:
            int r4 = r12.b()     // Catch: java.lang.Throwable -> L93
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 != r5) goto L19
            r0.b(r11, r2)
            return
        L19:
            int r4 = r12.c()     // Catch: java.lang.Throwable -> L93
            int r6 = com.uqm.crashsight.protobuf.WireFormat.f6779a     // Catch: java.lang.Throwable -> L93
            if (r4 == r6) goto L42
            int r5 = com.uqm.crashsight.protobuf.WireFormat.a(r4)     // Catch: java.lang.Throwable -> L93
            r6 = 2
            if (r5 != r6) goto L3d
            com.uqm.crashsight.protobuf.MessageLite r5 = r10.f6788a     // Catch: java.lang.Throwable -> L93
            int r4 = com.uqm.crashsight.protobuf.WireFormat.b(r4)     // Catch: java.lang.Throwable -> L93
            java.lang.Object r4 = r1.a(r13, r5, r4)     // Catch: java.lang.Throwable -> L93
            if (r4 == 0) goto L38
            r1.a(r12, r4, r13, r3)     // Catch: java.lang.Throwable -> L93
            goto L87
        L38:
            boolean r4 = r0.a(r2, r12)     // Catch: java.lang.Throwable -> L93
            goto L88
        L3d:
            boolean r4 = r12.d()     // Catch: java.lang.Throwable -> L93
            goto L88
        L42:
            r4 = 0
            r6 = 0
            r7 = r6
        L45:
            int r8 = r12.b()     // Catch: java.lang.Throwable -> L93
            if (r8 == r5) goto L74
            int r8 = r12.c()     // Catch: java.lang.Throwable -> L93
            int r9 = com.uqm.crashsight.protobuf.WireFormat.c     // Catch: java.lang.Throwable -> L93
            if (r8 != r9) goto L5e
            int r4 = r12.p()     // Catch: java.lang.Throwable -> L93
            com.uqm.crashsight.protobuf.MessageLite r6 = r10.f6788a     // Catch: java.lang.Throwable -> L93
            java.lang.Object r6 = r1.a(r13, r6, r4)     // Catch: java.lang.Throwable -> L93
            goto L45
        L5e:
            int r9 = com.uqm.crashsight.protobuf.WireFormat.d     // Catch: java.lang.Throwable -> L93
            if (r8 != r9) goto L6d
            if (r6 == 0) goto L68
            r1.a(r12, r6, r13, r3)     // Catch: java.lang.Throwable -> L93
            goto L45
        L68:
            com.uqm.crashsight.protobuf.ByteString r7 = r12.o()     // Catch: java.lang.Throwable -> L93
            goto L45
        L6d:
            boolean r8 = r12.d()     // Catch: java.lang.Throwable -> L93
            if (r8 == 0) goto L74
            goto L45
        L74:
            int r5 = r12.c()     // Catch: java.lang.Throwable -> L93
            int r8 = com.uqm.crashsight.protobuf.WireFormat.b     // Catch: java.lang.Throwable -> L93
            if (r5 != r8) goto L8e
            if (r7 == 0) goto L87
            if (r6 == 0) goto L84
            r1.a(r7, r6, r13, r3)     // Catch: java.lang.Throwable -> L93
            goto L87
        L84:
            r0.a(r2, r4, r7)     // Catch: java.lang.Throwable -> L93
        L87:
            r4 = 1
        L88:
            if (r4 != 0) goto Lc
            r0.b(r11, r2)
            return
        L8e:
            com.uqm.crashsight.protobuf.InvalidProtocolBufferException r12 = com.uqm.crashsight.protobuf.InvalidProtocolBufferException.g()     // Catch: java.lang.Throwable -> L93
            throw r12     // Catch: java.lang.Throwable -> L93
        L93:
            r12 = move-exception
            r0.b(r11, r2)
            throw r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.ac.a(java.lang.Object, com.uqm.crashsight.protobuf.an, com.uqm.crashsight.protobuf.ExtensionRegistryLite):void");
    }

    @Override // com.uqm.crashsight.protobuf.ao
    public final void d(T t) {
        this.b.d(t);
        this.d.c(t);
    }

    @Override // com.uqm.crashsight.protobuf.ao
    public final boolean e(T t) {
        return this.d.a(t).k();
    }

    @Override // com.uqm.crashsight.protobuf.ao
    public final int b(T t) {
        at<?, ?> atVar = this.b;
        int e = atVar.e(atVar.b(t)) + 0;
        return this.c ? e + this.d.a(t).m() : e;
    }
}
