package com.uqm.crashsight.protobuf;

import java.io.IOException;

/* loaded from: classes3.dex */
public class InvalidProtocolBufferException extends IOException {

    /* renamed from: a, reason: collision with root package name */
    private MessageLite f6732a;

    public InvalidProtocolBufferException(String str) {
        super(str);
        this.f6732a = null;
    }

    public InvalidProtocolBufferException(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.f6732a = null;
    }

    public final InvalidProtocolBufferException a(MessageLite messageLite) {
        this.f6732a = messageLite;
        return this;
    }

    public final MessageLite a() {
        return this.f6732a;
    }

    public final IOException b() {
        return getCause() instanceof IOException ? (IOException) getCause() : this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferException c() {
        return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferException d() {
        return new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferException e() {
        return new InvalidProtocolBufferException("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferException f() {
        return new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferException g() {
        return new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidWireTypeException h() {
        return new InvalidWireTypeException("Protocol message tag had invalid wire type.");
    }

    /* loaded from: classes3.dex */
    public static class InvalidWireTypeException extends InvalidProtocolBufferException {
        public InvalidWireTypeException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferException i() {
        return new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferException j() {
        return new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferException k() {
        return new InvalidProtocolBufferException("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferException l() {
        return new InvalidProtocolBufferException("Protocol message had invalid UTF-8.");
    }
}
