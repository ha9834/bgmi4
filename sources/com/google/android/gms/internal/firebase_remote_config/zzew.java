package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
public final class zzew {
    /* JADX WARN: Removed duplicated region for block: B:41:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0087 A[Catch: IOException -> 0x009d, IOException | XmlPullParserException -> 0x009f, TryCatch #2 {IOException | XmlPullParserException -> 0x009f, blocks: (B:3:0x0005, B:5:0x000b, B:8:0x0013, B:10:0x0019, B:12:0x0021, B:17:0x002f, B:19:0x0098, B:22:0x0039, B:26:0x0049, B:28:0x004d, B:34:0x005d, B:40:0x0081, B:42:0x0093, B:44:0x0087, B:46:0x008d, B:48:0x006d, B:51:0x0076), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008d A[Catch: IOException -> 0x009d, IOException | XmlPullParserException -> 0x009f, TryCatch #2 {IOException | XmlPullParserException -> 0x009f, blocks: (B:3:0x0005, B:5:0x000b, B:8:0x0013, B:10:0x0019, B:12:0x0021, B:17:0x002f, B:19:0x0098, B:22:0x0039, B:26:0x0049, B:28:0x004d, B:34:0x005d, B:40:0x0081, B:42:0x0093, B:44:0x0087, B:46:0x008d, B:48:0x006d, B:51:0x0076), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map<java.lang.String, java.lang.String> zza(android.content.Context r8, int r9) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            android.content.res.Resources r8 = r8.getResources()     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
            if (r8 != 0) goto L13
            java.lang.String r8 = "FirebaseRemoteConfig"
            java.lang.String r9 = "Could not find the resources of the current context while trying to set defaults from an XML."
            android.util.Log.e(r8, r9)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
            return r0
        L13:
            android.content.res.XmlResourceParser r8 = r8.getXml(r9)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
            if (r8 != 0) goto L21
            java.lang.String r8 = "FirebaseRemoteConfig"
            java.lang.String r9 = "The XML referenced by the resourceId could not be found while trying to set defaults from an XML."
            android.util.Log.e(r8, r9)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
            return r0
        L21:
            int r9 = r8.getEventType()     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
            r1 = 0
            r2 = r1
            r3 = r2
            r4 = r3
        L29:
            r5 = 1
            if (r9 == r5) goto La7
            r6 = 2
            if (r9 != r6) goto L36
            java.lang.String r9 = r8.getName()     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
            r2 = r9
            goto L98
        L36:
            r6 = 3
            if (r9 != r6) goto L58
            java.lang.String r9 = r8.getName()     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
            java.lang.String r2 = "entry"
            boolean r9 = r9.equals(r2)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
            if (r9 == 0) goto L56
            if (r3 == 0) goto L4d
            if (r4 == 0) goto L4d
            r0.put(r3, r4)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
            goto L54
        L4d:
            java.lang.String r9 = "FirebaseRemoteConfig"
            java.lang.String r2 = "An entry in the defaults XML has an invalid key and/or value tag."
            android.util.Log.w(r9, r2)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
        L54:
            r3 = r1
            r4 = r3
        L56:
            r2 = r1
            goto L98
        L58:
            r6 = 4
            if (r9 != r6) goto L98
            if (r2 == 0) goto L98
            r9 = -1
            int r6 = r2.hashCode()     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
            r7 = 106079(0x19e5f, float:1.48648E-40)
            if (r6 == r7) goto L76
            r7 = 111972721(0x6ac9171, float:6.4912916E-35)
            if (r6 == r7) goto L6d
            goto L80
        L6d:
            java.lang.String r6 = "value"
            boolean r6 = r2.equals(r6)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
            if (r6 == 0) goto L80
            goto L81
        L76:
            java.lang.String r5 = "key"
            boolean r5 = r2.equals(r5)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
            if (r5 == 0) goto L80
            r5 = 0
            goto L81
        L80:
            r5 = -1
        L81:
            switch(r5) {
                case 0: goto L8d;
                case 1: goto L87;
                default: goto L84;
            }     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
        L84:
            java.lang.String r9 = "FirebaseRemoteConfig"
            goto L93
        L87:
            java.lang.String r9 = r8.getText()     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
            r4 = r9
            goto L98
        L8d:
            java.lang.String r9 = r8.getText()     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
            r3 = r9
            goto L98
        L93:
            java.lang.String r5 = "Encountered an unexpected tag while parsing the defaults XML."
            android.util.Log.w(r9, r5)     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
        L98:
            int r9 = r8.next()     // Catch: java.io.IOException -> L9d org.xmlpull.v1.XmlPullParserException -> L9f
            goto L29
        L9d:
            r8 = move-exception
            goto La0
        L9f:
            r8 = move-exception
        La0:
            java.lang.String r9 = "FirebaseRemoteConfig"
            java.lang.String r1 = "Encountered an error while parsing the defaults XML file."
            android.util.Log.e(r9, r1, r8)
        La7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzew.zza(android.content.Context, int):java.util.Map");
    }
}
