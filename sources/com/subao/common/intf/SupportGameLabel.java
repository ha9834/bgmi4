package com.subao.common.intf;

/* loaded from: classes2.dex */
public class SupportGameLabel {
    private final boolean exact;
    private final String label;

    public SupportGameLabel(String str, boolean z) {
        this.label = str;
        this.exact = z;
    }

    public String getLabel() {
        return this.label;
    }

    public boolean isExact() {
        return this.exact;
    }
}
