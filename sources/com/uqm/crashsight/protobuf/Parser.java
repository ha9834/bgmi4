package com.uqm.crashsight.protobuf;

/* loaded from: classes3.dex */
public interface Parser<MessageType> {
    MessageType a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType a(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException;

    MessageType a(byte[] bArr) throws InvalidProtocolBufferException;
}
