package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Descriptors;
import com.uqm.crashsight.protobuf.MessageLite;

/* loaded from: classes3.dex */
public interface Message extends MessageLite, MessageOrBuilder {

    /* loaded from: classes3.dex */
    public interface Builder extends MessageLite.Builder, MessageOrBuilder {
        Builder a(ByteString byteString) throws InvalidProtocolBufferException;

        Builder a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

        Builder c(Descriptors.FieldDescriptor fieldDescriptor);

        Builder c(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        /* renamed from: c */
        Builder internalMergeFrom(Message message);

        @Override // com.uqm.crashsight.protobuf.MessageOrBuilder
        Descriptors.Descriptor d();

        Builder d(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        Builder d(UnknownFieldSet unknownFieldSet);

        Message g();

        Message h();
    }

    Builder p();

    Builder q();
}
