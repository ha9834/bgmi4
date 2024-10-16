package com.tencent.grobot.lite.ui.view.helper;

/* loaded from: classes2.dex */
public class ClickFrequencyHelper {
    private static final long CLICK_INTERVAL = 1000;
    private long clickedTime = -1;

    public void clicked() {
        this.clickedTime = System.currentTimeMillis();
    }

    public boolean clickable() {
        return this.clickedTime == -1 || System.currentTimeMillis() - this.clickedTime > CLICK_INTERVAL;
    }
}
