package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;

/* loaded from: classes.dex */
final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ BroadcastReceiver.PendingResult f1197a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CampaignTrackingReceiver campaignTrackingReceiver, BroadcastReceiver.PendingResult pendingResult) {
        this.f1197a = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BroadcastReceiver.PendingResult pendingResult = this.f1197a;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}
