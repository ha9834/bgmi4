package com.uqm.crashsight.protobuf;

/* loaded from: classes3.dex */
class p implements z {

    /* renamed from: a, reason: collision with root package name */
    private static final p f6831a = new p();

    private p() {
    }

    public static p a() {
        return f6831a;
    }

    @Override // com.uqm.crashsight.protobuf.z
    public final boolean a(Class<?> cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }

    @Override // com.uqm.crashsight.protobuf.z
    public final y b(Class<?> cls) {
        if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (y) GeneratedMessageLite.getDefaultInstance(cls.asSubclass(GeneratedMessageLite.class)).buildMessageInfo();
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e);
        }
    }
}
