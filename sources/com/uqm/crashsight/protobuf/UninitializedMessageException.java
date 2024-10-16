package com.uqm.crashsight.protobuf;

import java.util.List;

/* loaded from: classes3.dex */
public class UninitializedMessageException extends RuntimeException {
    public UninitializedMessageException() {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public UninitializedMessageException(List<String> list) {
        super(a(list));
    }

    public final InvalidProtocolBufferException a() {
        return new InvalidProtocolBufferException(getMessage());
    }

    private static String a(List<String> list) {
        StringBuilder sb = new StringBuilder("Message missing required fields: ");
        boolean z = true;
        for (String str : list) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
