package com.uqm.crashsight.protobuf;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class TextFormatParseLocation {

    /* renamed from: a, reason: collision with root package name */
    private final int f6767a = -1;
    private final int b = -1;

    static {
        new TextFormatParseLocation(-1, -1);
    }

    private TextFormatParseLocation(int i, int i2) {
    }

    public final String toString() {
        return String.format("ParseLocation{line=%d, column=%d}", Integer.valueOf(this.f6767a), Integer.valueOf(this.b));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextFormatParseLocation)) {
            return false;
        }
        TextFormatParseLocation textFormatParseLocation = (TextFormatParseLocation) obj;
        return this.f6767a == textFormatParseLocation.f6767a && this.b == textFormatParseLocation.b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new int[]{this.f6767a, this.b});
    }
}
