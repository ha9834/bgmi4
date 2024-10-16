package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.FieldSet;
import com.uqm.crashsight.protobuf.FieldSet.FieldDescriptorLite;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class k<T extends FieldSet.FieldDescriptorLite<T>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int a(Map.Entry<?, ?> entry);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract FieldSet<T> a(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object a(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <UT, UB> UB a(an anVar, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet, UB ub, at<UT, UB> atVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(Writer writer, Map.Entry<?, ?> entry) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(an anVar, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean a(MessageLite messageLite);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract FieldSet<T> b(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(Object obj);
}
