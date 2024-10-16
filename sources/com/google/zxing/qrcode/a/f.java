package com.google.zxing.qrcode.a;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private Mode f5435a;
    private ErrorCorrectionLevel b;
    private com.google.zxing.qrcode.decoder.a c;
    private int d = -1;
    private b e;

    public static boolean b(int i) {
        return i >= 0 && i < 8;
    }

    public b a() {
        return this.e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.f5435a);
        sb.append("\n ecLevel: ");
        sb.append(this.b);
        sb.append("\n version: ");
        sb.append(this.c);
        sb.append("\n maskPattern: ");
        sb.append(this.d);
        if (this.e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.e);
        }
        sb.append(">>\n");
        return sb.toString();
    }

    public void a(Mode mode) {
        this.f5435a = mode;
    }

    public void a(ErrorCorrectionLevel errorCorrectionLevel) {
        this.b = errorCorrectionLevel;
    }

    public void a(com.google.zxing.qrcode.decoder.a aVar) {
        this.c = aVar;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(b bVar) {
        this.e = bVar;
    }
}
