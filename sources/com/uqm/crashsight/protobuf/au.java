package com.uqm.crashsight.protobuf;

import java.io.IOException;

/* loaded from: classes3.dex */
class au extends at<UnknownFieldSetLite, UnknownFieldSetLite> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final boolean a(an anVar) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* synthetic */ UnknownFieldSetLite a() {
        return UnknownFieldSetLite.b();
    }

    @Override // com.uqm.crashsight.protobuf.at
    final /* synthetic */ UnknownFieldSetLite a(UnknownFieldSetLite unknownFieldSetLite) {
        UnknownFieldSetLite unknownFieldSetLite2 = unknownFieldSetLite;
        unknownFieldSetLite2.c();
        return unknownFieldSetLite2;
    }

    @Override // com.uqm.crashsight.protobuf.at
    final /* synthetic */ void a(UnknownFieldSetLite unknownFieldSetLite, int i, int i2) {
        unknownFieldSetLite.a(WireFormat.a(i, 5), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* synthetic */ void a(UnknownFieldSetLite unknownFieldSetLite, int i, long j) {
        unknownFieldSetLite.a(WireFormat.a(i, 0), Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* bridge */ /* synthetic */ void a(UnknownFieldSetLite unknownFieldSetLite, int i, ByteString byteString) {
        unknownFieldSetLite.a(WireFormat.a(i, 2), (Object) byteString);
    }

    @Override // com.uqm.crashsight.protobuf.at
    final /* bridge */ /* synthetic */ void a(UnknownFieldSetLite unknownFieldSetLite, int i, UnknownFieldSetLite unknownFieldSetLite2) {
        unknownFieldSetLite.a(WireFormat.a(i, 3), unknownFieldSetLite2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* synthetic */ void a(UnknownFieldSetLite unknownFieldSetLite, Writer writer) throws IOException {
        unknownFieldSetLite.b(writer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* bridge */ /* synthetic */ void a(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        ((GeneratedMessageLite) obj).unknownFields = unknownFieldSetLite;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* bridge */ /* synthetic */ UnknownFieldSetLite b(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    @Override // com.uqm.crashsight.protobuf.at
    final /* synthetic */ void b(UnknownFieldSetLite unknownFieldSetLite, int i, long j) {
        unknownFieldSetLite.a(WireFormat.a(i, 1), Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* synthetic */ void b(UnknownFieldSetLite unknownFieldSetLite, Writer writer) throws IOException {
        unknownFieldSetLite.a(writer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* bridge */ /* synthetic */ void b(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        ((GeneratedMessageLite) obj).unknownFields = unknownFieldSetLite;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* synthetic */ UnknownFieldSetLite c(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.a()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite b = UnknownFieldSetLite.b();
        generatedMessageLite.unknownFields = b;
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* synthetic */ UnknownFieldSetLite c(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        UnknownFieldSetLite unknownFieldSetLite3 = unknownFieldSetLite;
        UnknownFieldSetLite unknownFieldSetLite4 = unknownFieldSetLite2;
        return unknownFieldSetLite4.equals(UnknownFieldSetLite.a()) ? unknownFieldSetLite3 : UnknownFieldSetLite.a(unknownFieldSetLite3, unknownFieldSetLite4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* synthetic */ int e(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* synthetic */ int f(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final void d(Object obj) {
        ((GeneratedMessageLite) obj).unknownFields.c();
    }
}
