package com.uqm.crashsight.protobuf;

import com.qq.taf.jce.JceStruct;
import com.uqm.crashsight.protobuf.Descriptors;
import com.uqm.crashsight.protobuf.DynamicMessage;
import com.uqm.crashsight.protobuf.TextFormatParseInfoTree;
import com.uqm.crashsight.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class TextFormat {

    /* loaded from: classes3.dex */
    public static class ParseException extends IOException {
    }

    /* loaded from: classes3.dex */
    public static class UnknownFieldParseException extends ParseException {
    }

    private static boolean a(byte b) {
        if (48 <= b && b <= 57) {
            return true;
        }
        if (97 > b || b > 102) {
            return 65 <= b && b <= 70;
        }
        return true;
    }

    private static int b(byte b) {
        return (48 > b || b > 57) ? (97 > b || b > 122) ? (b - 65) + 10 : (b - 97) + 10 : b - 48;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ a a(Appendable appendable) {
        return new a(appendable, false, 0 == true ? 1 : 0);
    }

    private TextFormat() {
    }

    static {
        Logger.getLogger(TextFormat.class.getName());
        Parser.a().a();
    }

    public static Printer a() {
        return Printer.f6765a;
    }

    /* loaded from: classes3.dex */
    public static final class Printer {

        /* renamed from: a, reason: collision with root package name */
        private static final Printer f6765a = new Printer(true, TypeRegistry.a());
        private final boolean b = true;
        private final TypeRegistry c;

        private Printer(boolean z, TypeRegistry typeRegistry) {
            this.c = typeRegistry;
        }

        private static void a(UnknownFieldSet unknownFieldSet, Appendable appendable) throws IOException {
            a(unknownFieldSet, TextFormat.a(appendable));
        }

        private void a(MessageOrBuilder messageOrBuilder, a aVar) throws IOException {
            if (messageOrBuilder.d().c().equals("google.protobuf.Any") && b(messageOrBuilder, aVar)) {
                return;
            }
            for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : messageOrBuilder.b_().entrySet()) {
                Descriptors.FieldDescriptor key = entry.getKey();
                Object value = entry.getValue();
                if (key.o()) {
                    Iterator it = ((List) value).iterator();
                    while (it.hasNext()) {
                        a(key, it.next(), aVar);
                    }
                } else {
                    a(key, value, aVar);
                }
            }
            a(messageOrBuilder.b(), aVar);
        }

        private boolean b(MessageOrBuilder messageOrBuilder, a aVar) throws IOException {
            Descriptors.Descriptor d = messageOrBuilder.d();
            Descriptors.FieldDescriptor b = d.b(1);
            Descriptors.FieldDescriptor b2 = d.b(2);
            if (b == null || b.h() != Descriptors.FieldDescriptor.Type.STRING || b2 == null || b2.h() != Descriptors.FieldDescriptor.Type.BYTES) {
                return false;
            }
            String str = (String) messageOrBuilder.b(b);
            if (str.isEmpty()) {
                return false;
            }
            Object b3 = messageOrBuilder.b(b2);
            try {
                Descriptors.Descriptor a2 = this.c.a(str);
                if (a2 == null) {
                    return false;
                }
                DynamicMessage.Builder c = DynamicMessage.a(a2).c();
                c.a((ByteString) b3);
                aVar.a("[");
                aVar.a(str);
                aVar.a("] {");
                aVar.c();
                aVar.a();
                a(c, aVar);
                aVar.b();
                aVar.a("}");
                aVar.c();
                return true;
            } catch (InvalidProtocolBufferException unused) {
                return false;
            }
        }

        public final String a(MessageOrBuilder messageOrBuilder) {
            try {
                StringBuilder sb = new StringBuilder();
                a(messageOrBuilder, TextFormat.a((Appendable) sb));
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public final String a(UnknownFieldSet unknownFieldSet) {
            try {
                StringBuilder sb = new StringBuilder();
                a(unknownFieldSet, sb);
                return sb.toString();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        private void a(Descriptors.FieldDescriptor fieldDescriptor, Object obj, a aVar) throws IOException {
            String num;
            String a2;
            if (fieldDescriptor.s()) {
                aVar.a("[");
                if (fieldDescriptor.t().e().f() && fieldDescriptor.h() == Descriptors.FieldDescriptor.Type.MESSAGE && fieldDescriptor.n() && fieldDescriptor.v() == fieldDescriptor.w()) {
                    aVar.a(fieldDescriptor.w().c());
                } else {
                    aVar.a(fieldDescriptor.c());
                }
                aVar.a("]");
            } else if (fieldDescriptor.h() == Descriptors.FieldDescriptor.Type.GROUP) {
                aVar.a(fieldDescriptor.w().b());
            } else {
                aVar.a(fieldDescriptor.b());
            }
            if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                aVar.a(" {");
                aVar.c();
                aVar.a();
            } else {
                aVar.a(": ");
            }
            switch (fieldDescriptor.h()) {
                case INT32:
                case SINT32:
                case SFIXED32:
                    num = ((Integer) obj).toString();
                    aVar.a(num);
                    break;
                case INT64:
                case SINT64:
                case SFIXED64:
                    num = ((Long) obj).toString();
                    aVar.a(num);
                    break;
                case BOOL:
                    num = ((Boolean) obj).toString();
                    aVar.a(num);
                    break;
                case FLOAT:
                    num = ((Float) obj).toString();
                    aVar.a(num);
                    break;
                case DOUBLE:
                    num = ((Double) obj).toString();
                    aVar.a(num);
                    break;
                case UINT32:
                case FIXED32:
                    num = TextFormat.a(((Integer) obj).intValue());
                    aVar.a(num);
                    break;
                case UINT64:
                case FIXED64:
                    num = TextFormat.a(((Long) obj).longValue());
                    aVar.a(num);
                    break;
                case STRING:
                    aVar.a("\"");
                    a2 = this.b ? as.a((String) obj) : TextFormat.a((String) obj).replace("\n", "\\n");
                    aVar.a(a2);
                    num = "\"";
                    aVar.a(num);
                    break;
                case BYTES:
                    aVar.a("\"");
                    a2 = obj instanceof ByteString ? TextFormat.a((ByteString) obj) : TextFormat.a((byte[]) obj);
                    aVar.a(a2);
                    num = "\"";
                    aVar.a(num);
                    break;
                case ENUM:
                    num = ((Descriptors.EnumValueDescriptor) obj).b();
                    aVar.a(num);
                    break;
                case MESSAGE:
                case GROUP:
                    a((Message) obj, aVar);
                    break;
            }
            if (fieldDescriptor.f() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                aVar.b();
                aVar.a("}");
            }
            aVar.c();
        }

        private static void a(UnknownFieldSet unknownFieldSet, a aVar) throws IOException {
            for (Map.Entry<Integer, UnknownFieldSet.Field> entry : unknownFieldSet.c().entrySet()) {
                int intValue = entry.getKey().intValue();
                UnknownFieldSet.Field value = entry.getValue();
                a(intValue, 0, value.b(), aVar);
                a(intValue, 5, value.c(), aVar);
                a(intValue, 1, value.d(), aVar);
                a(intValue, 2, value.e(), aVar);
                for (UnknownFieldSet unknownFieldSet2 : value.f()) {
                    aVar.a(entry.getKey().toString());
                    aVar.a(" {");
                    aVar.c();
                    aVar.a();
                    a(unknownFieldSet2, aVar);
                    aVar.b();
                    aVar.a("}");
                    aVar.c();
                }
            }
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0024. Please report as an issue. */
        private static void a(int i, int i2, List<?> list, a aVar) throws IOException {
            String str;
            Object[] objArr;
            String str2;
            for (Object obj : list) {
                aVar.a(String.valueOf(i));
                aVar.a(": ");
                int a2 = WireFormat.a(i2);
                if (a2 != 5) {
                    switch (a2) {
                        case 0:
                            str2 = TextFormat.a(((Long) obj).longValue());
                            aVar.a(str2);
                            aVar.c();
                        case 1:
                            str = "0x%016x";
                            objArr = new Object[]{(Long) obj};
                            break;
                        case 2:
                            try {
                                UnknownFieldSet a3 = UnknownFieldSet.a((ByteString) obj);
                                aVar.a("{");
                                aVar.c();
                                aVar.a();
                                a(a3, aVar);
                                aVar.b();
                                aVar.a("}");
                            } catch (InvalidProtocolBufferException unused) {
                                aVar.a("\"");
                                aVar.a(TextFormat.a((ByteString) obj));
                                str2 = "\"";
                                break;
                            }
                            aVar.c();
                        case 3:
                            a((UnknownFieldSet) obj, aVar);
                            aVar.c();
                        default:
                            throw new IllegalArgumentException("Bad tag: " + i2);
                    }
                } else {
                    str = "0x%08x";
                    objArr = new Object[]{(Integer) obj};
                }
                str2 = String.format(null, str, objArr);
                aVar.a(str2);
                aVar.c();
            }
        }
    }

    public static String a(int i) {
        if (i >= 0) {
            return Integer.toString(i);
        }
        return Long.toString(i & 4294967295L);
    }

    public static String a(long j) {
        if (j >= 0) {
            return Long.toString(j);
        }
        return BigInteger.valueOf(j & Long.MAX_VALUE).setBit(63).toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Appendable f6766a;
        private final StringBuilder b;
        private final boolean c;
        private boolean d;

        /* synthetic */ a(Appendable appendable, boolean z, byte b) {
            this(appendable, false);
        }

        private a(Appendable appendable, boolean z) {
            this.b = new StringBuilder();
            this.d = false;
            this.f6766a = appendable;
            this.c = z;
        }

        public final void a() {
            this.b.append("  ");
        }

        public final void b() {
            int length = this.b.length();
            if (length == 0) {
                throw new IllegalArgumentException(" Outdent() without matching Indent().");
            }
            this.b.setLength(length - 2);
        }

        public final void a(CharSequence charSequence) throws IOException {
            if (this.d) {
                this.d = false;
                this.f6766a.append(this.c ? " " : this.b);
            }
            this.f6766a.append(charSequence);
        }

        public final void c() throws IOException {
            if (!this.c) {
                this.f6766a.append("\n");
            }
            this.d = true;
        }
    }

    /* loaded from: classes3.dex */
    public static class Parser {

        /* loaded from: classes3.dex */
        public enum SingularOverwritePolicy {
            ALLOW_SINGULAR_OVERWRITES,
            FORBID_SINGULAR_OVERWRITES
        }

        /* synthetic */ Parser(TypeRegistry typeRegistry, boolean z, boolean z2, boolean z3, SingularOverwritePolicy singularOverwritePolicy, TextFormatParseInfoTree.Builder builder, byte b) {
            this(typeRegistry, z, z2, z3, singularOverwritePolicy, builder);
        }

        private Parser(TypeRegistry typeRegistry, boolean z, boolean z2, boolean z3, SingularOverwritePolicy singularOverwritePolicy, TextFormatParseInfoTree.Builder builder) {
        }

        public static Builder a() {
            return new Builder();
        }

        /* loaded from: classes3.dex */
        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            private boolean f6763a = false;
            private boolean b = false;
            private boolean c = false;
            private SingularOverwritePolicy d = SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;
            private TextFormatParseInfoTree.Builder e = null;
            private TypeRegistry f = TypeRegistry.a();

            public final Parser a() {
                return new Parser(this.f, false, false, false, this.d, null, (byte) 0);
            }
        }
    }

    public static String a(ByteString byteString) {
        return as.a(byteString);
    }

    public static String a(byte[] bArr) {
        return as.a(bArr);
    }

    public static ByteString a(CharSequence charSequence) throws InvalidEscapeSequenceException {
        ByteString a2 = ByteString.a(charSequence.toString());
        byte[] bArr = new byte[a2.b()];
        int i = 0;
        int i2 = 0;
        while (i < a2.b()) {
            byte a3 = a2.a(i);
            if (a3 == 92) {
                i++;
                if (i < a2.b()) {
                    byte a4 = a2.a(i);
                    if (48 <= a4 && a4 <= 55) {
                        int b = b(a4);
                        int i3 = i + 1;
                        if (i3 < a2.b()) {
                            byte a5 = a2.a(i3);
                            if (48 <= a5 && a5 <= 55) {
                                b = b(a2.a(i3)) + (b << 3);
                                i = i3;
                            }
                        }
                        int i4 = i + 1;
                        if (i4 < a2.b()) {
                            byte a6 = a2.a(i4);
                            if (48 <= a6 && a6 <= 55) {
                                b = b(a2.a(i4)) + (b << 3);
                                i = i4;
                            }
                        }
                        bArr[i2] = (byte) b;
                        i2++;
                    } else if (a4 == 34) {
                        bArr[i2] = 34;
                        i2++;
                    } else if (a4 == 39) {
                        bArr[i2] = 39;
                        i2++;
                    } else if (a4 == 92) {
                        bArr[i2] = 92;
                        i2++;
                    } else if (a4 == 102) {
                        bArr[i2] = JceStruct.ZERO_TAG;
                        i2++;
                    } else if (a4 == 110) {
                        bArr[i2] = 10;
                        i2++;
                    } else if (a4 == 114) {
                        bArr[i2] = JceStruct.SIMPLE_LIST;
                        i2++;
                    } else if (a4 == 116) {
                        bArr[i2] = 9;
                        i2++;
                    } else if (a4 == 118) {
                        bArr[i2] = JceStruct.STRUCT_END;
                        i2++;
                    } else if (a4 != 120) {
                        switch (a4) {
                            case 97:
                                bArr[i2] = 7;
                                i2++;
                                break;
                            case 98:
                                bArr[i2] = 8;
                                i2++;
                                break;
                            default:
                                throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) a4) + '\'');
                        }
                    } else {
                        i++;
                        if (i < a2.b() && a(a2.a(i))) {
                            int b2 = b(a2.a(i));
                            int i5 = i + 1;
                            if (i5 < a2.b() && a(a2.a(i5))) {
                                b2 = b(a2.a(i5)) + (b2 << 4);
                                i = i5;
                            }
                            bArr[i2] = (byte) b2;
                            i2++;
                        } else {
                            throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
                        }
                    }
                } else {
                    throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
                }
            } else {
                bArr[i2] = a3;
                i2++;
            }
            i++;
        }
        return bArr.length == i2 ? ByteString.b(bArr) : ByteString.a(bArr, 0, i2);
    }

    /* loaded from: classes3.dex */
    public static class InvalidEscapeSequenceException extends IOException {
        InvalidEscapeSequenceException(String str) {
            super(str);
        }
    }

    public static String a(String str) {
        return as.b(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(String str) throws NumberFormatException {
        return (int) a(str, true, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(String str) throws NumberFormatException {
        return (int) a(str, false, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long d(String str) throws NumberFormatException {
        return a(str, true, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long e(String str) throws NumberFormatException {
        return a(str, false, true);
    }

    private static long a(String str, boolean z, boolean z2) throws NumberFormatException {
        int i = 0;
        boolean z3 = true;
        if (!str.startsWith("-", 0)) {
            z3 = false;
        } else {
            if (!z) {
                throw new NumberFormatException("Number must be positive: " + str);
            }
            i = 1;
        }
        int i2 = 10;
        if (str.startsWith("0x", i)) {
            i += 2;
            i2 = 16;
        } else if (str.startsWith("0", i)) {
            i2 = 8;
        }
        String substring = str.substring(i);
        if (substring.length() < 16) {
            long parseLong = Long.parseLong(substring, i2);
            if (z3) {
                parseLong = -parseLong;
            }
            if (z2) {
                return parseLong;
            }
            if (z) {
                if (parseLong <= 2147483647L && parseLong >= -2147483648L) {
                    return parseLong;
                }
                throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
            }
            if (parseLong < 4294967296L && parseLong >= 0) {
                return parseLong;
            }
            throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
        }
        BigInteger bigInteger = new BigInteger(substring, i2);
        if (z3) {
            bigInteger = bigInteger.negate();
        }
        if (z2) {
            if (z) {
                if (bigInteger.bitLength() > 63) {
                    throw new NumberFormatException("Number out of range for 64-bit signed integer: " + str);
                }
            } else if (bigInteger.bitLength() > 64) {
                throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + str);
            }
        } else if (z) {
            if (bigInteger.bitLength() > 31) {
                throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
            }
        } else if (bigInteger.bitLength() > 32) {
            throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
        }
        return bigInteger.longValue();
    }
}
