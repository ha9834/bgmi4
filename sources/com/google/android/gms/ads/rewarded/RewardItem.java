package com.google.android.gms.ads.rewarded;

/* loaded from: classes.dex */
public interface RewardItem {
    public static final RewardItem DEFAULT_REWARD = new a();

    int getAmount();

    String getType();
}
