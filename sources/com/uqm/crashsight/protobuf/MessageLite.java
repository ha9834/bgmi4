package com.uqm.crashsight.protobuf;

import java.io.IOException;

/* loaded from: classes3.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    /* loaded from: classes3.dex */
    public interface Builder extends MessageLiteOrBuilder, Cloneable {
        MessageLite build();

        MessageLite buildPartial();

        Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        Builder mergeFrom(MessageLite messageLite);
    }

    Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    Builder newBuilderForType();

    Builder toBuilder();

    ByteString toByteString();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
