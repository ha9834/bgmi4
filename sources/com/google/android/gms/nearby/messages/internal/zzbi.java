package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.content.Intent;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcvb;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;

/* loaded from: classes2.dex */
public final class zzbi implements Messages {
    public static final zzbi zzkdv = new zzbi();
    public static final Api.zzf<zzah> zzegu = new Api.zzf<>();
    public static final Api.zza<zzah, MessagesOptions> zzegv = new w();

    private zzbi() {
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> getPermissionStatus(GoogleApiClient googleApiClient) {
        return googleApiClient.zze(new ae(this, googleApiClient));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final void handleIntent(Intent intent, MessageListener messageListener) {
        zzcvb.zza(intent, messageListener);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> publish(GoogleApiClient googleApiClient, Message message) {
        return publish(googleApiClient, message, PublishOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> publish(GoogleApiClient googleApiClient, Message message, PublishOptions publishOptions) {
        zzbq.checkNotNull(message);
        zzbq.checkNotNull(publishOptions);
        com.google.android.gms.common.api.internal.zzci zzt = publishOptions.getCallback() == null ? null : googleApiClient.zzt(publishOptions.getCallback());
        return googleApiClient.zze(new y(this, googleApiClient, message, zzt != null ? new ag(zzt) : null, publishOptions));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> registerStatusCallback(GoogleApiClient googleApiClient, StatusCallback statusCallback) {
        zzbq.checkNotNull(statusCallback);
        return googleApiClient.zze(new af(this, googleApiClient, googleApiClient.zzt(statusCallback)));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return subscribe(googleApiClient, pendingIntent, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
        zzbq.checkNotNull(pendingIntent);
        zzbq.checkNotNull(subscribeOptions);
        com.google.android.gms.common.api.internal.zzci zzt = subscribeOptions.getCallback() == null ? null : googleApiClient.zzt(subscribeOptions.getCallback());
        return googleApiClient.zze(new ab(this, googleApiClient, pendingIntent, zzt != null ? new aj(zzt) : null, subscribeOptions));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return subscribe(googleApiClient, messageListener, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, SubscribeOptions subscribeOptions) {
        zzbq.checkNotNull(messageListener);
        zzbq.checkNotNull(subscribeOptions);
        zzbq.checkArgument(subscribeOptions.getStrategy().zzbdu() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        com.google.android.gms.common.api.internal.zzci zzt = googleApiClient.zzt(messageListener);
        com.google.android.gms.common.api.internal.zzci zzt2 = subscribeOptions.getCallback() == null ? null : googleApiClient.zzt(subscribeOptions.getCallback());
        return googleApiClient.zze(new aa(this, googleApiClient, zzt, zzt2 != null ? new aj(zzt2) : null, subscribeOptions));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> unpublish(GoogleApiClient googleApiClient, Message message) {
        zzbq.checkNotNull(message);
        return googleApiClient.zze(new z(this, googleApiClient, message));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> unregisterStatusCallback(GoogleApiClient googleApiClient, StatusCallback statusCallback) {
        zzbq.checkNotNull(statusCallback);
        return googleApiClient.zze(new x(this, googleApiClient, googleApiClient.zzt(statusCallback)));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        zzbq.checkNotNull(pendingIntent);
        return googleApiClient.zze(new ad(this, googleApiClient, pendingIntent));
    }

    @Override // com.google.android.gms.nearby.messages.Messages
    public final PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, MessageListener messageListener) {
        zzbq.checkNotNull(messageListener);
        return googleApiClient.zze(new ac(this, googleApiClient, googleApiClient.zzt(messageListener)));
    }
}
