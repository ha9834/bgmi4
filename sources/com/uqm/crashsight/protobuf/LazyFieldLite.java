package com.uqm.crashsight.protobuf;

/* loaded from: classes3.dex */
public class LazyFieldLite {

    /* renamed from: a, reason: collision with root package name */
    private ByteString f6737a;
    private ExtensionRegistryLite b;
    private volatile MessageLite c;
    private volatile ByteString d;

    public int hashCode() {
        return 1;
    }

    static {
        ExtensionRegistryLite.c();
    }

    public LazyFieldLite(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        if (extensionRegistryLite == null) {
            throw new NullPointerException("found null ExtensionRegistry");
        }
        if (byteString == null) {
            throw new NullPointerException("found null ByteString");
        }
        this.b = extensionRegistryLite;
        this.f6737a = byteString;
    }

    public LazyFieldLite() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.c;
        MessageLite messageLite2 = lazyFieldLite.c;
        if (messageLite == null && messageLite2 == null) {
            return c().equals(lazyFieldLite.c());
        }
        if (messageLite != null && messageLite2 != null) {
            return messageLite.equals(messageLite2);
        }
        if (messageLite != null) {
            return messageLite.equals(lazyFieldLite.a(messageLite.r()));
        }
        return a(messageLite2.r()).equals(messageLite2);
    }

    public final MessageLite a(MessageLite messageLite) {
        ByteString byteString;
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    try {
                        if (this.f6737a != null) {
                            this.c = messageLite.getParserForType().a(this.f6737a, this.b);
                            byteString = this.f6737a;
                        } else {
                            this.c = messageLite;
                            byteString = ByteString.f6635a;
                        }
                        this.d = byteString;
                    } catch (InvalidProtocolBufferException unused) {
                        this.c = messageLite;
                        this.d = ByteString.f6635a;
                    }
                }
            }
        }
        return this.c;
    }

    public final MessageLite b(MessageLite messageLite) {
        MessageLite messageLite2 = this.c;
        this.f6737a = null;
        this.d = null;
        this.c = messageLite;
        return messageLite2;
    }

    public final int b() {
        if (this.d != null) {
            return this.d.b();
        }
        ByteString byteString = this.f6737a;
        if (byteString != null) {
            return byteString.b();
        }
        if (this.c != null) {
            return this.c.getSerializedSize();
        }
        return 0;
    }

    public final ByteString c() {
        if (this.d != null) {
            return this.d;
        }
        ByteString byteString = this.f6737a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.d != null) {
                return this.d;
            }
            if (this.c == null) {
                this.d = ByteString.f6635a;
            } else {
                this.d = this.c.toByteString();
            }
            return this.d;
        }
    }
}
