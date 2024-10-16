package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.zzcm;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcvb;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesClient;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
public final class zzak extends MessagesClient {
    private static final Api.zzf<zzah> b = new Api.zzf<>();
    private static final Api.zza<zzah, MessagesOptions> c = new j();
    private static final Api<MessagesOptions> d = new Api<>("Nearby.MESSAGES_API", c, b);
    private final int e;

    public zzak(Activity activity, MessagesOptions messagesOptions) {
        super(activity, d, messagesOptions, GoogleApi.zza.zzfsr);
        this.e = 1;
        activity.getApplication().registerActivityLifecycleCallbacks(new q(activity, this, null));
    }

    public zzak(Context context, MessagesOptions messagesOptions) {
        super(context, d, messagesOptions, GoogleApi.zza.zzfsr);
        this.e = zzah.a(context);
    }

    private final <T> Task<Void> a(com.google.android.gms.common.api.internal.zzci<T> zzciVar, r rVar, r rVar2) {
        return zza(new n(this, zzciVar, rVar), new o(this, zzciVar.zzakx(), rVar2));
    }

    private final Task<Void> a(r rVar) {
        return zzb(new p(this, rVar));
    }

    private final <T> Task<Void> a(T t) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zza(zzcm.zzb(t, t.getClass().getName())).addOnCompleteListener(new m(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final void a(int i) {
        a(new r(1) { // from class: com.google.android.gms.nearby.messages.internal.i

            /* renamed from: a, reason: collision with root package name */
            private final int f5010a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f5010a = r1;
            }
        });
    }

    private final <T> com.google.android.gms.common.api.internal.zzci<T> b(T t) {
        if (t == null) {
            return null;
        }
        return zza(t, t.getClass().getName());
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final void handleIntent(Intent intent, MessageListener messageListener) {
        zzcvb.zza(intent, messageListener);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> publish(Message message) {
        return publish(message, PublishOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> publish(Message message, PublishOptions publishOptions) {
        zzbq.checkNotNull(message);
        zzbq.checkNotNull(publishOptions);
        com.google.android.gms.common.api.internal.zzci b2 = b(message);
        return a(b2, new r(this, message, new k(this, b(publishOptions.getCallback()), b2), publishOptions) { // from class: com.google.android.gms.nearby.messages.internal.a

            /* renamed from: a, reason: collision with root package name */
            private final zzak f4994a;
            private final Message b;
            private final s c;
            private final PublishOptions d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4994a = this;
                this.b = message;
                this.c = r3;
                this.d = publishOptions;
            }
        }, new r(message) { // from class: com.google.android.gms.nearby.messages.internal.b

            /* renamed from: a, reason: collision with root package name */
            private final Message f5003a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f5003a = message;
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> registerStatusCallback(StatusCallback statusCallback) {
        zzbq.checkNotNull(statusCallback);
        com.google.android.gms.common.api.internal.zzci b2 = b(statusCallback);
        return a(b2, new r(b2) { // from class: com.google.android.gms.nearby.messages.internal.g

            /* renamed from: a, reason: collision with root package name */
            private final com.google.android.gms.common.api.internal.zzci f5008a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f5008a = b2;
            }
        }, new r(b2) { // from class: com.google.android.gms.nearby.messages.internal.h

            /* renamed from: a, reason: collision with root package name */
            private final com.google.android.gms.common.api.internal.zzci f5009a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f5009a = b2;
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(PendingIntent pendingIntent) {
        return subscribe(pendingIntent, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
        zzbq.checkNotNull(pendingIntent);
        zzbq.checkNotNull(subscribeOptions);
        com.google.android.gms.common.api.internal.zzci b2 = b(subscribeOptions.getCallback());
        return a(new r(this, pendingIntent, b2 == null ? null : new u(b2), subscribeOptions) { // from class: com.google.android.gms.nearby.messages.internal.e

            /* renamed from: a, reason: collision with root package name */
            private final zzak f5006a;
            private final PendingIntent b;
            private final u c;
            private final SubscribeOptions d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f5006a = this;
                this.b = pendingIntent;
                this.c = r3;
                this.d = subscribeOptions;
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(MessageListener messageListener) {
        return subscribe(messageListener, SubscribeOptions.DEFAULT);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> subscribe(MessageListener messageListener, SubscribeOptions subscribeOptions) {
        zzbq.checkNotNull(messageListener);
        zzbq.checkNotNull(subscribeOptions);
        zzbq.checkArgument(subscribeOptions.getStrategy().zzbdu() == 0, "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        com.google.android.gms.common.api.internal.zzci b2 = b(messageListener);
        return a(b2, new r(this, b2, new l(this, b(subscribeOptions.getCallback()), b2), subscribeOptions) { // from class: com.google.android.gms.nearby.messages.internal.c

            /* renamed from: a, reason: collision with root package name */
            private final zzak f5004a;
            private final com.google.android.gms.common.api.internal.zzci b;
            private final u c;
            private final SubscribeOptions d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f5004a = this;
                this.b = b2;
                this.c = r3;
                this.d = subscribeOptions;
            }
        }, new r(b2) { // from class: com.google.android.gms.nearby.messages.internal.d

            /* renamed from: a, reason: collision with root package name */
            private final com.google.android.gms.common.api.internal.zzci f5005a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f5005a = b2;
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unpublish(Message message) {
        zzbq.checkNotNull(message);
        return a((zzak) message);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unregisterStatusCallback(StatusCallback statusCallback) {
        zzbq.checkNotNull(statusCallback);
        return a((zzak) statusCallback);
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unsubscribe(PendingIntent pendingIntent) {
        zzbq.checkNotNull(pendingIntent);
        return a(new r(pendingIntent) { // from class: com.google.android.gms.nearby.messages.internal.f

            /* renamed from: a, reason: collision with root package name */
            private final PendingIntent f5007a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f5007a = pendingIntent;
            }
        });
    }

    @Override // com.google.android.gms.nearby.messages.MessagesClient
    public final Task<Void> unsubscribe(MessageListener messageListener) {
        zzbq.checkNotNull(messageListener);
        return a((zzak) messageListener);
    }
}
