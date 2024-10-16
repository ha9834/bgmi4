package com.google.android.gms.internal.gtm;

/* renamed from: com.google.android.gms.internal.gtm.do, reason: invalid class name */
/* loaded from: classes2.dex */
final class Cdo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(zzps zzpsVar) {
        dp dpVar = new dp(zzpsVar);
        StringBuilder sb = new StringBuilder(dpVar.a());
        for (int i = 0; i < dpVar.a(); i++) {
            byte a2 = dpVar.a(i);
            if (a2 == 34) {
                sb.append("\\\"");
            } else if (a2 == 39) {
                sb.append("\\'");
            } else if (a2 != 92) {
                switch (a2) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (a2 >= 32 && a2 <= 126) {
                            sb.append((char) a2);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((a2 >>> 6) & 3) + 48));
                            sb.append((char) (((a2 >>> 3) & 7) + 48));
                            sb.append((char) ((a2 & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
