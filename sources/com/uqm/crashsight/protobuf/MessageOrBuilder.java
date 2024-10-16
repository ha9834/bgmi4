package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Descriptors;
import java.util.Map;

/* loaded from: classes3.dex */
public interface MessageOrBuilder extends MessageLiteOrBuilder {
    boolean a(Descriptors.FieldDescriptor fieldDescriptor);

    UnknownFieldSet b();

    Object b(Descriptors.FieldDescriptor fieldDescriptor);

    Map<Descriptors.FieldDescriptor, Object> b_();

    Descriptors.Descriptor d();

    Message r();
}
