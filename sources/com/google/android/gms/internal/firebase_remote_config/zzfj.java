package com.google.android.gms.internal.firebase_remote_config;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* loaded from: classes2.dex */
public final class zzfj implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f4170a = ")]}'\n".toCharArray();
    private final Reader b;
    private long j;
    private int k;
    private String l;
    private int n;
    private String[] o;
    private int[] p;
    private boolean c = false;
    private final char[] d = new char[1024];
    private int e = 0;
    private int f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private int[] m = new int[32];

    public zzfj(Reader reader) {
        this.n = 0;
        int[] iArr = this.m;
        int i = this.n;
        this.n = i + 1;
        iArr[i] = 6;
        this.o = new String[32];
        this.p = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.b = reader;
    }

    public final void setLenient(boolean z) {
        this.c = true;
    }

    public final void beginArray() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = a();
        }
        if (i == 3) {
            a(1);
            this.p[this.n - 1] = 0;
            this.i = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + zzdy() + e());
        }
    }

    public final void endArray() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = a();
        }
        if (i == 4) {
            this.n--;
            int[] iArr = this.p;
            int i2 = this.n - 1;
            iArr[i2] = iArr[i2] + 1;
            this.i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + zzdy() + e());
    }

    public final void beginObject() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = a();
        }
        if (i == 1) {
            a(3);
            this.i = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + zzdy() + e());
        }
    }

    public final void endObject() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = a();
        }
        if (i == 2) {
            this.n--;
            String[] strArr = this.o;
            int i2 = this.n;
            strArr[i2] = null;
            int[] iArr = this.p;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.i = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + zzdy() + e());
    }

    public final zzfl zzdy() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = a();
        }
        switch (i) {
            case 1:
                return zzfl.BEGIN_OBJECT;
            case 2:
                return zzfl.END_OBJECT;
            case 3:
                return zzfl.BEGIN_ARRAY;
            case 4:
                return zzfl.END_ARRAY;
            case 5:
            case 6:
                return zzfl.BOOLEAN;
            case 7:
                return zzfl.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return zzfl.STRING;
            case 12:
            case 13:
            case 14:
                return zzfl.NAME;
            case 15:
            case 16:
                return zzfl.NUMBER;
            case 17:
                return zzfl.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x021c, code lost:
    
        if (a(r15) == false) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x021f, code lost:
    
        if (r8 != 2) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0221, code lost:
    
        if (r10 == false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0227, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0229, code lost:
    
        if (r16 == false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x022f, code lost:
    
        if (r11 != 0) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0231, code lost:
    
        if (r16 != false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0233, code lost:
    
        if (r16 == false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0236, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0237, code lost:
    
        r20.j = r11;
        r20.e += r3;
        r20.i = 15;
        r17 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0245, code lost:
    
        if (r8 == 2) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0248, code lost:
    
        if (r8 == 4) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x024b, code lost:
    
        if (r8 != 7) goto L176;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x024e, code lost:
    
        r17 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0251, code lost:
    
        r20.k = r3;
        r20.i = 16;
        r17 = 16;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:73:0x01b3. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0180 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0181  */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int a() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzfj.a():int");
    }

    private final boolean a(char c) throws IOException {
        switch (c) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                return false;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                c();
                return false;
            default:
                return true;
        }
    }

    public final String nextName() throws IOException {
        String b;
        int i = this.i;
        if (i == 0) {
            i = a();
        }
        if (i == 14) {
            b = b();
        } else if (i == 12) {
            b = b('\'');
        } else if (i == 13) {
            b = b('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + zzdy() + e());
        }
        this.i = 0;
        this.o[this.n - 1] = b;
        return b;
    }

    public final String nextString() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = a();
        }
        String str = null;
        if (i == 10) {
            str = b();
        } else if (i == 8) {
            str = b('\'');
        } else if (i == 9) {
            str = b('\"');
        } else if (i == 11) {
            this.l = null;
        } else if (i == 15) {
            str = Long.toString(this.j);
        } else if (i == 16) {
            str = new String(this.d, this.e, this.k);
            this.e += this.k;
        } else {
            throw new IllegalStateException("Expected a string but was " + zzdy() + e());
        }
        this.i = 0;
        int[] iArr = this.p;
        int i2 = this.n - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public final boolean nextBoolean() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = a();
        }
        if (i == 5) {
            this.i = 0;
            int[] iArr = this.p;
            int i2 = this.n - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (i == 6) {
            this.i = 0;
            int[] iArr2 = this.p;
            int i3 = this.n - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + zzdy() + e());
    }

    public final void nextNull() throws IOException {
        int i = this.i;
        if (i == 0) {
            i = a();
        }
        if (i == 7) {
            this.i = 0;
            int[] iArr = this.p;
            int i2 = this.n - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + zzdy() + e());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String b(char c) throws IOException {
        char[] cArr = this.d;
        StringBuilder sb = null;
        while (true) {
            int i = this.e;
            int i2 = this.f;
            int i3 = i;
            while (true) {
                if (i3 < i2) {
                    int i4 = i3 + 1;
                    char c2 = cArr[i3];
                    if (c2 == c) {
                        this.e = i4;
                        int i5 = (i4 - i) - 1;
                        if (sb == null) {
                            return new String(cArr, i, i5);
                        }
                        sb.append(cArr, i, i5);
                        return sb.toString();
                    }
                    if (c2 == '\\') {
                        this.e = i4;
                        int i6 = (i4 - i) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i6 + 1) << 1, 16));
                        }
                        sb.append(cArr, i, i6);
                        sb.append(f());
                    } else {
                        if (c2 == '\n') {
                            this.g++;
                            this.h = i4;
                        }
                        i3 = i4;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i3 - i) << 1, 16));
                    }
                    sb.append(cArr, i, i3 - i);
                    this.e = i3;
                    if (!b(1)) {
                        throw a("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:30:0x0011. Please report as an issue. */
    private final String b() throws IOException {
        String sb;
        int i = 0;
        StringBuilder sb2 = null;
        int i2 = 0;
        while (true) {
            int i3 = this.e;
            if (i3 + i2 < this.f) {
                switch (this.d[i3 + i2]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        c();
                        break;
                    default:
                        i2++;
                }
            } else if (i2 < this.d.length) {
                if (b(i2 + 1)) {
                }
            } else {
                if (sb2 == null) {
                    sb2 = new StringBuilder(Math.max(i2, 16));
                }
                sb2.append(this.d, this.e, i2);
                this.e += i2;
                if (b(1)) {
                    i2 = 0;
                }
            }
        }
        i = i2;
        if (sb2 == null) {
            sb = new String(this.d, this.e, i);
        } else {
            sb2.append(this.d, this.e, i);
            sb = sb2.toString();
        }
        this.e += i;
        return sb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void c(char c) throws IOException {
        char[] cArr = this.d;
        while (true) {
            int i = this.e;
            int i2 = this.f;
            while (true) {
                if (i < i2) {
                    int i3 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.e = i3;
                        return;
                    }
                    if (c2 == '\\') {
                        this.e = i3;
                        f();
                        break;
                    } else {
                        if (c2 == '\n') {
                            this.g++;
                            this.h = i3;
                        }
                        i = i3;
                    }
                } else {
                    this.e = i;
                    if (!b(1)) {
                        throw a("Unterminated string");
                    }
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.i = 0;
        this.m[0] = 8;
        this.n = 1;
        this.b.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x007f, code lost:
    
        r7.e += r2;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:45:0x0076. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void skipValue() throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            int r2 = r7.i
            if (r2 != 0) goto La
            int r2 = r7.a()
        La:
            r3 = 3
            r4 = 1
            if (r2 != r3) goto L15
            r7.a(r4)
            int r1 = r1 + 1
            goto L8e
        L15:
            if (r2 != r4) goto L1e
            r7.a(r3)
            int r1 = r1 + 1
            goto L8e
        L1e:
            r3 = 4
            if (r2 != r3) goto L2a
            int r2 = r7.n
            int r2 = r2 - r4
            r7.n = r2
            int r1 = r1 + (-1)
            goto L8e
        L2a:
            r3 = 2
            if (r2 != r3) goto L35
            int r2 = r7.n
            int r2 = r2 - r4
            r7.n = r2
            int r1 = r1 + (-1)
            goto L8e
        L35:
            r3 = 14
            if (r2 == r3) goto L68
            r3 = 10
            if (r2 != r3) goto L3e
            goto L68
        L3e:
            r3 = 8
            if (r2 == r3) goto L62
            r3 = 12
            if (r2 != r3) goto L47
            goto L62
        L47:
            r3 = 9
            if (r2 == r3) goto L5c
            r3 = 13
            if (r2 != r3) goto L50
            goto L5c
        L50:
            r3 = 16
            if (r2 != r3) goto L8e
            int r2 = r7.e
            int r3 = r7.k
            int r2 = r2 + r3
            r7.e = r2
            goto L8e
        L5c:
            r2 = 34
            r7.c(r2)
            goto L8e
        L62:
            r2 = 39
            r7.c(r2)
            goto L8e
        L68:
            r2 = 0
        L69:
            int r3 = r7.e
            int r5 = r3 + r2
            int r6 = r7.f
            if (r5 >= r6) goto L85
            char[] r5 = r7.d
            int r3 = r3 + r2
            char r3 = r5[r3]
            switch(r3) {
                case 9: goto L7f;
                case 10: goto L7f;
                case 12: goto L7f;
                case 13: goto L7f;
                case 32: goto L7f;
                case 35: goto L7c;
                case 44: goto L7f;
                case 47: goto L7c;
                case 58: goto L7f;
                case 59: goto L7c;
                case 61: goto L7c;
                case 91: goto L7f;
                case 92: goto L7c;
                case 93: goto L7f;
                case 123: goto L7f;
                case 125: goto L7f;
                default: goto L79;
            }
        L79:
            int r2 = r2 + 1
            goto L69
        L7c:
            r7.c()
        L7f:
            int r3 = r7.e
            int r3 = r3 + r2
            r7.e = r3
            goto L8e
        L85:
            int r3 = r3 + r2
            r7.e = r3
            boolean r2 = r7.b(r4)
            if (r2 != 0) goto L68
        L8e:
            r7.i = r0
            if (r1 != 0) goto L2
            int[] r0 = r7.p
            int r1 = r7.n
            int r2 = r1 + (-1)
            r3 = r0[r2]
            int r3 = r3 + r4
            r0[r2] = r3
            java.lang.String[] r0 = r7.o
            int r1 = r1 - r4
            java.lang.String r2 = "null"
            r0[r1] = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.zzfj.skipValue():void");
    }

    private final void a(int i) {
        int i2 = this.n;
        int[] iArr = this.m;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[i2 << 1];
            int[] iArr3 = new int[i2 << 1];
            String[] strArr = new String[i2 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            System.arraycopy(this.p, 0, iArr3, 0, this.n);
            System.arraycopy(this.o, 0, strArr, 0, this.n);
            this.m = iArr2;
            this.p = iArr3;
            this.o = strArr;
        }
        int[] iArr4 = this.m;
        int i3 = this.n;
        this.n = i3 + 1;
        iArr4[i3] = i;
    }

    private final boolean b(int i) throws IOException {
        int i2;
        char[] cArr = this.d;
        int i3 = this.h;
        int i4 = this.e;
        this.h = i3 - i4;
        int i5 = this.f;
        if (i5 != i4) {
            this.f = i5 - i4;
            System.arraycopy(cArr, i4, cArr, 0, this.f);
        } else {
            this.f = 0;
        }
        this.e = 0;
        do {
            Reader reader = this.b;
            int i6 = this.f;
            int read = reader.read(cArr, i6, cArr.length - i6);
            if (read == -1) {
                return false;
            }
            this.f += read;
            if (this.g == 0 && (i2 = this.h) == 0 && this.f > 0 && cArr[0] == 65279) {
                this.e++;
                this.h = i2 + 1;
                i++;
            }
        } while (this.f < i);
        return true;
    }

    private final int a(boolean z) throws IOException {
        int i;
        char[] cArr = this.d;
        int i2 = this.e;
        int i3 = this.f;
        while (true) {
            boolean z2 = true;
            if (i2 == i3) {
                this.e = i2;
                if (!b(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + e());
                }
                i2 = this.e;
                i3 = this.f;
            }
            int i4 = i2 + 1;
            char c = cArr[i2];
            if (c == '\n') {
                this.g++;
                this.h = i4;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.e = i4;
                    if (i4 == i3) {
                        this.e--;
                        boolean b = b(2);
                        this.e++;
                        if (!b) {
                            return c;
                        }
                    }
                    c();
                    int i5 = this.e;
                    char c2 = cArr[i5];
                    if (c2 == '*') {
                        this.e = i5 + 1;
                        while (true) {
                            if (this.e + 2 > this.f && !b(2)) {
                                z2 = false;
                                break;
                            }
                            char[] cArr2 = this.d;
                            int i6 = this.e;
                            if (cArr2[i6] != '\n') {
                                while (i < 2) {
                                    i = this.d[this.e + i] == "*/".charAt(i) ? i + 1 : 0;
                                }
                                break;
                            }
                            this.g++;
                            this.h = i6 + 1;
                            this.e++;
                        }
                        if (!z2) {
                            throw a("Unterminated comment");
                        }
                        i2 = this.e + 2;
                        i3 = this.f;
                    } else {
                        if (c2 != '/') {
                            return c;
                        }
                        this.e = i5 + 1;
                        d();
                        i2 = this.e;
                        i3 = this.f;
                    }
                } else if (c == '#') {
                    this.e = i4;
                    c();
                    d();
                    i2 = this.e;
                    i3 = this.f;
                } else {
                    this.e = i4;
                    return c;
                }
            }
            i2 = i4;
        }
    }

    private final void c() throws IOException {
        if (!this.c) {
            throw a("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private final void d() throws IOException {
        char c;
        do {
            if (this.e >= this.f && !b(1)) {
                return;
            }
            char[] cArr = this.d;
            int i = this.e;
            this.e = i + 1;
            c = cArr[i];
            if (c == '\n') {
                this.g++;
                this.h = this.e;
                return;
            }
        } while (c != '\r');
    }

    public final String toString() {
        return getClass().getSimpleName() + e();
    }

    private final String e() {
        int i = this.g + 1;
        int i2 = (this.e - this.h) + 1;
        StringBuilder sb = new StringBuilder(" at line ");
        sb.append(i);
        sb.append(" column ");
        sb.append(i2);
        sb.append(" path ");
        StringBuilder sb2 = new StringBuilder("$");
        int i3 = this.n;
        for (int i4 = 0; i4 < i3; i4++) {
            switch (this.m[i4]) {
                case 1:
                case 2:
                    sb2.append('[');
                    sb2.append(this.p[i4]);
                    sb2.append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sb2.append('.');
                    String[] strArr = this.o;
                    if (strArr[i4] != null) {
                        sb2.append(strArr[i4]);
                        break;
                    } else {
                        break;
                    }
            }
        }
        sb.append(sb2.toString());
        return sb.toString();
    }

    private final char f() throws IOException {
        int i;
        if (this.e == this.f && !b(1)) {
            throw a("Unterminated escape sequence");
        }
        char[] cArr = this.d;
        int i2 = this.e;
        this.e = i2 + 1;
        char c = cArr[i2];
        if (c == '\n') {
            this.g++;
            this.h = this.e;
        } else if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
            if (c == 'b') {
                return '\b';
            }
            if (c == 'f') {
                return '\f';
            }
            if (c == 'n') {
                return '\n';
            }
            if (c == 'r') {
                return '\r';
            }
            switch (c) {
                case 't':
                    return '\t';
                case 'u':
                    if (this.e + 4 > this.f && !b(4)) {
                        throw a("Unterminated escape sequence");
                    }
                    char c2 = 0;
                    int i3 = this.e;
                    int i4 = i3 + 4;
                    while (i3 < i4) {
                        char c3 = this.d[i3];
                        char c4 = (char) (c2 << 4);
                        if (c3 >= '0' && c3 <= '9') {
                            i = c3 - '0';
                        } else if (c3 >= 'a' && c3 <= 'f') {
                            i = (c3 - 'a') + 10;
                        } else {
                            if (c3 < 'A' || c3 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.d, this.e, 4));
                            }
                            i = (c3 - 'A') + 10;
                        }
                        c2 = (char) (c4 + i);
                        i3++;
                    }
                    this.e += 4;
                    return c2;
                default:
                    throw a("Invalid escape sequence");
            }
        }
        return c;
    }

    private final IOException a(String str) throws IOException {
        throw new zzfn(str + e());
    }

    static {
        zzfh.zznf = new ba();
    }
}
