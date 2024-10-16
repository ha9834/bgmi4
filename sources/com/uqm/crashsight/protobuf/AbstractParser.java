package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.MessageLite;

/* loaded from: classes3.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {

    /* renamed from: a, reason: collision with root package name */
    private static final ExtensionRegistryLite f6634a = ExtensionRegistryLite.c();

    @Override // com.uqm.crashsight.protobuf.Parser
    public final /* synthetic */ Object a(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return a((AbstractParser<MessageType>) b(byteString, extensionRegistryLite));
    }

    @Override // com.uqm.crashsight.protobuf.Parser
    public final /* bridge */ /* synthetic */ Object a(byte[] bArr) throws InvalidProtocolBufferException {
        return a((AbstractParser<MessageType>) a(bArr, 0, bArr.length, f6634a));
    }

    private MessageType a(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw (messagetype instanceof AbstractMessageLite ? ((AbstractMessageLite) messagetype).newUninitializedMessageException() : new UninitializedMessageException()).a().a(messagetype);
    }

    private MessageType b(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            CodedInputStream h = byteString.h();
            MessageType messagetype = (MessageType) a(h, extensionRegistryLite);
            try {
                h.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e) {
                throw e.a(messagetype);
            }
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }

    public MessageType a(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        try {
            CodedInputStream a2 = CodedInputStream.a(bArr, i, i2);
            MessageType messagetype = (MessageType) a(a2, extensionRegistryLite);
            try {
                a2.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e) {
                throw e.a(messagetype);
            }
        } catch (InvalidProtocolBufferException e2) {
            throw e2;
        }
    }
}
