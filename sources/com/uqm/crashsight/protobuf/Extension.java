package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.MessageLite;

/* loaded from: classes3.dex */
public abstract class Extension<ContainingType extends MessageLite, Type> extends ExtensionLite<ContainingType, Type> {

    /* loaded from: classes3.dex */
    public enum ExtensionType {
        IMMUTABLE,
        MUTABLE,
        PROTO1
    }

    /* loaded from: classes3.dex */
    public enum MessageType {
        PROTO1,
        PROTO2
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.uqm.crashsight.protobuf.ExtensionLite
    public final boolean a() {
        return false;
    }
}
