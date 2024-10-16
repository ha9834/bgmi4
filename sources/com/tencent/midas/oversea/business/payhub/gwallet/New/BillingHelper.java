package com.tencent.midas.oversea.business.payhub.gwallet.New;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.android.billingclient.api.b;
import com.android.billingclient.api.c;
import com.android.billingclient.api.d;
import com.android.billingclient.api.f;
import com.android.billingclient.api.g;
import com.android.billingclient.api.h;
import com.android.billingclient.api.i;
import com.android.billingclient.api.j;
import com.android.billingclient.api.l;
import com.android.billingclient.api.n;
import com.android.billingclient.api.o;
import com.android.billingclient.api.p;
import com.android.billingclient.api.q;
import com.android.billingclient.api.r;
import com.android.vending.billing.util.IabHelper;
import com.tencent.midas.oversea.comm.APDataReportManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class BillingHelper implements o {
    public static final String TAG = "BillingHelper";
    private d mBillingClient;
    private boolean mIsServiceConnected = false;
    private OnIabPurchaseListener mPurchaseListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface IabRunnable {
        void run(h hVar);
    }

    /* loaded from: classes.dex */
    public interface OnIabConsumeListener {
        void onConsumeResponse(WrapperBillingResult wrapperBillingResult, String str);
    }

    /* loaded from: classes.dex */
    public interface OnIabPurchaseListener {
        void onPurchaseResponse(WrapperBillingResult wrapperBillingResult, List<l> list);
    }

    /* loaded from: classes.dex */
    public interface OnIabQueryPurchasesListener {
        void onQueryPurchasesResponse(WrapperBillingResult wrapperBillingResult, List<l> list);
    }

    /* loaded from: classes.dex */
    public interface OnIabQuerySkuDetailsListener {
        void onSkuDetailsResponse(WrapperBillingResult wrapperBillingResult, List<p> list);
    }

    /* loaded from: classes.dex */
    public interface OnIabSetupFinishedListener {
        void onIabSetupFinished(WrapperBillingResult wrapperBillingResult);
    }

    public BillingHelper(Context context) {
        this.mBillingClient = d.a(context).a(this).a().b();
    }

    public void startSetup(final OnIabSetupFinishedListener onIabSetupFinishedListener) {
        Log.i(TAG, "startSetup");
        startServiceConnection(new IabRunnable() { // from class: com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.1
            @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.IabRunnable
            public void run(h hVar) {
                OnIabSetupFinishedListener onIabSetupFinishedListener2 = onIabSetupFinishedListener;
                if (onIabSetupFinishedListener2 != null) {
                    onIabSetupFinishedListener2.onIabSetupFinished(new WrapperBillingResult(hVar));
                }
            }
        });
    }

    public void launchPurchaseFlow(final Activity activity, final g gVar, final OnIabPurchaseListener onIabPurchaseListener) {
        Log.i(TAG, "launchPurchaseFlow");
        if (onIabPurchaseListener == null) {
            Log.e(TAG, "launchPurchaseFlow: listener is null.");
        } else {
            this.mPurchaseListener = onIabPurchaseListener;
            executeServiceRequest(new IabRunnable() { // from class: com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.2
                @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.IabRunnable
                public void run(h hVar) {
                    if (BillingHelper.this.mBillingClient != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Launching in-app purchase flow, Replace old SKU ? ");
                        sb.append(gVar.a() != null);
                        Log.i(BillingHelper.TAG, sb.toString());
                        BillingHelper.this.mBillingClient.a(activity, gVar);
                        return;
                    }
                    Log.e(BillingHelper.TAG, "launchPurchaseFlow: BillingClient is null.");
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_CALL_GW_SDK_INNER_ERROR, "version=2.0&ret=-1&msg=billclient is null");
                    onIabPurchaseListener.onPurchaseResponse(new WrapperBillingResult(h.c().a(6).a("BillingClient is null.").a()), null);
                }
            });
        }
    }

    public void querySkuDetailsAsync(final q qVar, final OnIabQuerySkuDetailsListener onIabQuerySkuDetailsListener) {
        Log.i(TAG, "querySkuDetailsAsync");
        if (onIabQuerySkuDetailsListener == null) {
            Log.e(TAG, "querySkuDetailsAsync: listener is null.");
        } else {
            executeServiceRequest(new IabRunnable() { // from class: com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.3
                @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.IabRunnable
                public void run(h hVar) {
                    if (BillingHelper.this.mBillingClient != null) {
                        try {
                            BillingHelper.this.mBillingClient.a(qVar, new r() { // from class: com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.3.1
                                @Override // com.android.billingclient.api.r
                                public void onSkuDetailsResponse(h hVar2, List<p> list) {
                                    onIabQuerySkuDetailsListener.onSkuDetailsResponse(new WrapperBillingResult(hVar2), list);
                                }
                            });
                            return;
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    Log.e(BillingHelper.TAG, "querySkuDetailsAsync: BillingClient is null.");
                    onIabQuerySkuDetailsListener.onSkuDetailsResponse(new WrapperBillingResult(h.c().a(6).a("BillingClient is null.").a()), null);
                }
            });
        }
    }

    public void queryPurchasesAsync(final OnIabQueryPurchasesListener onIabQueryPurchasesListener) {
        Log.i(TAG, "queryPurchasesAsync");
        if (onIabQueryPurchasesListener == null) {
            Log.e(TAG, "queryPurchasesAsync: listener is null.");
        } else {
            executeServiceRequest(new IabRunnable() { // from class: com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.4
                @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.IabRunnable
                public void run(h hVar) {
                    if (BillingHelper.this.mBillingClient != null) {
                        ArrayList arrayList = new ArrayList();
                        l.a b = BillingHelper.this.mBillingClient.b("inapp");
                        if (b.b() == 0) {
                            List<l> c = b.c();
                            if (c != null && !c.isEmpty()) {
                                arrayList.addAll(c);
                            }
                        } else {
                            Log.e(BillingHelper.TAG, "queryPurchasesAsync: Get an error response trying to query in-app purchases.");
                        }
                        if (BillingHelper.this.isSubscriptionSupported()) {
                            l.a b2 = BillingHelper.this.mBillingClient.b(IabHelper.ITEM_TYPE_SUBS);
                            if (b2.b() == 0) {
                                List<l> c2 = b2.c();
                                if (c2 != null && !c2.isEmpty()) {
                                    arrayList.addAll(c2);
                                }
                            } else {
                                Log.e(BillingHelper.TAG, "queryPurchasesAsync: Get an error response trying to query subscription purchases.");
                            }
                        } else {
                            Log.i(BillingHelper.TAG, "queryPurchasesAsync: don't support subscription.");
                        }
                        onIabQueryPurchasesListener.onQueryPurchasesResponse(new WrapperBillingResult(b.a()), arrayList);
                        return;
                    }
                    Log.e(BillingHelper.TAG, "queryPurchasesAsync: BillingClient is null.");
                    onIabQueryPurchasesListener.onQueryPurchasesResponse(new WrapperBillingResult(h.c().a(6).a("BillingClient is null.").a()), null);
                }
            });
        }
    }

    public void consumeAsync(final i iVar, final OnIabConsumeListener onIabConsumeListener) {
        Log.i(TAG, "consumeAsync");
        if (onIabConsumeListener == null) {
            Log.e(TAG, "consumeAsync: listener is null.");
        } else {
            executeServiceRequest(new IabRunnable() { // from class: com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.5
                @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.IabRunnable
                public void run(h hVar) {
                    if (BillingHelper.this.mBillingClient != null) {
                        BillingHelper.this.mBillingClient.a(iVar, new j() { // from class: com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.5.1
                            @Override // com.android.billingclient.api.j
                            public void onConsumeResponse(h hVar2, String str) {
                                onIabConsumeListener.onConsumeResponse(new WrapperBillingResult(hVar2), str);
                            }
                        });
                        return;
                    }
                    Log.e(BillingHelper.TAG, "consumeAsync: BillingClient is null.");
                    onIabConsumeListener.onConsumeResponse(new WrapperBillingResult(h.c().a(6).a("BillingClient is null.").a()), iVar.a());
                }
            });
        }
    }

    public void queryPurchaseHistoryAsync(final String str, final n nVar) {
        Log.i(TAG, "queryPurchaseHistoryAsync");
        if (nVar == null) {
            Log.e(TAG, "queryPurchaseHistoryAsync: listener is null.");
        } else {
            executeServiceRequest(new IabRunnable() { // from class: com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.6
                @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.IabRunnable
                public void run(h hVar) {
                    if (BillingHelper.this.mBillingClient != null) {
                        BillingHelper.this.mBillingClient.a(str, nVar);
                        return;
                    }
                    Log.e(BillingHelper.TAG, "queryPurchaseHistoryAsync: BillingClient null.");
                    nVar.a(h.c().a(6).a("BillingClient is null.").a(), null);
                }
            });
        }
    }

    public void acknowledge(final b bVar, final c cVar) {
        Log.i(TAG, "acknowledge");
        if (cVar == null) {
            Log.e(TAG, "acknowledge: listener is null.");
        } else {
            executeServiceRequest(new IabRunnable() { // from class: com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.7
                @Override // com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.IabRunnable
                public void run(h hVar) {
                    if (BillingHelper.this.mBillingClient != null) {
                        BillingHelper.this.mBillingClient.a(bVar, cVar);
                        return;
                    }
                    Log.e(BillingHelper.TAG, "acknowledge: BillingClient null.");
                    cVar.a(h.c().a(6).a("BillingClient is null.").a());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSubscriptionSupported() {
        d dVar = this.mBillingClient;
        return dVar != null && dVar.a("subscriptions").a() == 0;
    }

    public void dispose() {
        Log.i(TAG, "dispose");
        d dVar = this.mBillingClient;
        if (dVar == null || !dVar.a()) {
            return;
        }
        this.mBillingClient.b();
        this.mIsServiceConnected = false;
        this.mBillingClient = null;
        this.mPurchaseListener = null;
    }

    private void startServiceConnection(final IabRunnable iabRunnable) {
        if (this.mIsServiceConnected) {
            Log.i(TAG, "Service is connected.");
            return;
        }
        d dVar = this.mBillingClient;
        if (dVar != null) {
            dVar.a(new f() { // from class: com.tencent.midas.oversea.business.payhub.gwallet.New.BillingHelper.8
                @Override // com.android.billingclient.api.f
                public void onBillingSetupFinished(h hVar) {
                    if (hVar.a() == 0) {
                        BillingHelper.this.mIsServiceConnected = true;
                    }
                    iabRunnable.run(hVar);
                }

                @Override // com.android.billingclient.api.f
                public void onBillingServiceDisconnected() {
                    BillingHelper.this.mIsServiceConnected = false;
                    iabRunnable.run(h.c().a(-1).a());
                }
            });
        } else {
            Log.e(TAG, "startServiceConnection: BillingClient is null.");
            iabRunnable.run(h.c().a(6).a("BillingClient is null.").a());
        }
    }

    private void executeServiceRequest(IabRunnable iabRunnable) {
        if (this.mIsServiceConnected) {
            iabRunnable.run(null);
        } else {
            startServiceConnection(iabRunnable);
        }
    }

    @Override // com.android.billingclient.api.o
    public void onPurchasesUpdated(h hVar, List<l> list) {
        Log.i(TAG, "onPurchasesUpdated");
        OnIabPurchaseListener onIabPurchaseListener = this.mPurchaseListener;
        if (onIabPurchaseListener != null) {
            onIabPurchaseListener.onPurchaseResponse(new WrapperBillingResult(hVar), list);
        }
    }
}
