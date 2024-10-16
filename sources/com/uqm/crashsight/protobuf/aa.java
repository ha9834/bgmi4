package com.uqm.crashsight.protobuf;

import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(MessageLite messageLite, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        a(messageLite, sb, 0);
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x01bd, code lost:
    
        if (((java.lang.Boolean) r6).booleanValue() == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01bf, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01cf, code lost:
    
        if (((java.lang.Integer) r6).intValue() == 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01e0, code lost:
    
        if (((java.lang.Float) r6).floatValue() == 0.0f) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01f2, code lost:
    
        if (((java.lang.Double) r6).doubleValue() == com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void a(com.uqm.crashsight.protobuf.MessageLite r13, java.lang.StringBuilder r14, int r15) {
        /*
            Method dump skipped, instructions count: 650
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.protobuf.aa.a(com.uqm.crashsight.protobuf.MessageLite, java.lang.StringBuilder, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                a(sb, i, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                a(sb, i, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(as.a((String) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof ByteString) {
            sb.append(": \"");
            sb.append(as.a((ByteString) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof GeneratedMessageLite) {
            sb.append(" {");
            a((GeneratedMessageLite) obj, sb, i + 2);
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        if (obj instanceof Map.Entry) {
            sb.append(" {");
            Map.Entry entry = (Map.Entry) obj;
            int i4 = i + 2;
            a(sb, i4, "key", entry.getKey());
            a(sb, i4, "value", entry.getValue());
            sb.append("\n");
            while (i2 < i) {
                sb.append(' ');
                i2++;
            }
            sb.append("}");
            return;
        }
        sb.append(": ");
        sb.append(obj.toString());
    }

    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
