package com.google.android.gms.games;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.games.internal.zzbo;
import com.google.android.gms.games.internal.zze;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
final class bz extends zzbo<Videos.CaptureOverlayStateListener> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ListenerHolder f1637a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(VideosClient videosClient, ListenerHolder listenerHolder, ListenerHolder listenerHolder2) {
        super(listenerHolder);
        this.f1637a = listenerHolder2;
    }

    @Override // com.google.android.gms.games.internal.zzbo
    protected final void a(zze zzeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException, SecurityException {
        zzeVar.zzg(this.f1637a);
        taskCompletionSource.setResult(null);
    }
}
