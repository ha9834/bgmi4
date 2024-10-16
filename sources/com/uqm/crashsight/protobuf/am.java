package com.uqm.crashsight.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class am implements y {

    /* renamed from: a, reason: collision with root package name */
    private final MessageLite f6793a;
    private final String b;
    private final Object[] c;
    private final int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(MessageLite messageLite, String str, Object[] objArr) {
        this.f6793a = messageLite;
        this.b = str;
        this.c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.d = i | (charAt2 << i2);
                return;
            } else {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] e() {
        return this.c;
    }

    @Override // com.uqm.crashsight.protobuf.y
    public final MessageLite c() {
        return this.f6793a;
    }

    @Override // com.uqm.crashsight.protobuf.y
    public final ProtoSyntax a() {
        return (this.d & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    @Override // com.uqm.crashsight.protobuf.y
    public final boolean b() {
        return (this.d & 2) == 2;
    }
}
