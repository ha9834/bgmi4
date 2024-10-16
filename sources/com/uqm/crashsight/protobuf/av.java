package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.UnknownFieldSet;
import java.io.IOException;

/* loaded from: classes3.dex */
class av extends at<UnknownFieldSet, UnknownFieldSet.Builder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final void d(Object obj) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* bridge */ /* synthetic */ UnknownFieldSet.Builder a() {
        return UnknownFieldSet.a();
    }

    @Override // com.uqm.crashsight.protobuf.at
    final /* bridge */ /* synthetic */ UnknownFieldSet a(UnknownFieldSet.Builder builder) {
        return builder.build();
    }

    @Override // com.uqm.crashsight.protobuf.at
    final /* bridge */ /* synthetic */ void a(UnknownFieldSet.Builder builder, int i, int i2) {
        builder.a(i, UnknownFieldSet.Field.a().a(i2).a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* bridge */ /* synthetic */ void a(UnknownFieldSet.Builder builder, int i, long j) {
        builder.a(i, UnknownFieldSet.Field.a().a(j).a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* bridge */ /* synthetic */ void a(UnknownFieldSet.Builder builder, int i, ByteString byteString) {
        builder.a(i, UnknownFieldSet.Field.a().a(byteString).a());
    }

    @Override // com.uqm.crashsight.protobuf.at
    final /* bridge */ /* synthetic */ void a(UnknownFieldSet.Builder builder, int i, UnknownFieldSet unknownFieldSet) {
        builder.a(i, UnknownFieldSet.Field.a().a(unknownFieldSet).a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* bridge */ /* synthetic */ void a(UnknownFieldSet unknownFieldSet, Writer writer) throws IOException {
        unknownFieldSet.a(writer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* bridge */ /* synthetic */ void a(Object obj, UnknownFieldSet unknownFieldSet) {
        ((GeneratedMessageV3) obj).d = unknownFieldSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* bridge */ /* synthetic */ UnknownFieldSet b(Object obj) {
        return ((GeneratedMessageV3) obj).d;
    }

    @Override // com.uqm.crashsight.protobuf.at
    final /* synthetic */ void b(UnknownFieldSet.Builder builder, int i, long j) {
        builder.a(i, UnknownFieldSet.Field.a().b(j).a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* bridge */ /* synthetic */ void b(UnknownFieldSet unknownFieldSet, Writer writer) throws IOException {
        unknownFieldSet.b(writer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* synthetic */ void b(Object obj, UnknownFieldSet.Builder builder) {
        ((GeneratedMessageV3) obj).d = builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* synthetic */ UnknownFieldSet.Builder c(Object obj) {
        return ((GeneratedMessageV3) obj).d.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* synthetic */ UnknownFieldSet c(UnknownFieldSet unknownFieldSet, UnknownFieldSet unknownFieldSet2) {
        return unknownFieldSet.e().a(unknownFieldSet2).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* synthetic */ int e(UnknownFieldSet unknownFieldSet) {
        return unknownFieldSet.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final /* synthetic */ int f(UnknownFieldSet unknownFieldSet) {
        return unknownFieldSet.getSerializedSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.at
    public final boolean a(an anVar) {
        return anVar.a();
    }
}
