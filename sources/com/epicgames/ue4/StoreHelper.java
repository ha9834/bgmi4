package com.epicgames.ue4;

import android.content.Intent;

/* loaded from: classes.dex */
public interface StoreHelper {
    boolean BeginPurchase(String str);

    void ConsumePurchase(String str);

    boolean IsAllowedToMakePurchases();

    boolean QueryExistingPurchases();

    boolean QueryInAppPurchases(String[] strArr);

    boolean RestorePurchases(String[] strArr, boolean[] zArr);

    boolean onActivityResult(int i, int i2, Intent intent);

    void onDestroy();
}
