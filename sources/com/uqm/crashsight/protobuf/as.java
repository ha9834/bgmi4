package com.uqm.crashsight.protobuf;

/* loaded from: classes3.dex */
final class as {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        byte a(int i);

        int a();
    }

    private static String a(a aVar) {
        StringBuilder sb = new StringBuilder(aVar.a());
        for (int i = 0; i < aVar.a(); i++) {
            byte a2 = aVar.a(i);
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
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.uqm.crashsight.protobuf.as$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static class AnonymousClass1 implements a {

        /* renamed from: a, reason: collision with root package name */
        private /* synthetic */ ByteString f6802a;

        AnonymousClass1(ByteString byteString) {
            this.f6802a = byteString;
        }

        @Override // com.uqm.crashsight.protobuf.as.a
        public final int a() {
            return this.f6802a.b();
        }

        @Override // com.uqm.crashsight.protobuf.as.a
        public final byte a(int i) {
            return this.f6802a.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(ByteString byteString) {
        return a(new AnonymousClass1(byteString));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(final byte[] bArr) {
        return a(new a() { // from class: com.uqm.crashsight.protobuf.as.2
            @Override // com.uqm.crashsight.protobuf.as.a
            public final int a() {
                return bArr.length;
            }

            @Override // com.uqm.crashsight.protobuf.as.a
            public final byte a(int i) {
                return bArr[i];
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        return a(new AnonymousClass1(ByteString.a(str)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
