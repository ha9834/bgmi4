package com.google.android.gms.internal.games;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzbz implements Requests {
    @Override // com.google.android.gms.games.request.Requests
    public final void registerRequestListener(GoogleApiClient googleApiClient, OnRequestReceivedListener onRequestReceivedListener) {
        com.google.android.gms.games.internal.zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzf(googleApiClient.registerListener(onRequestReceivedListener));
        }
    }

    @Override // com.google.android.gms.games.request.Requests
    public final void unregisterRequestListener(GoogleApiClient googleApiClient) {
        com.google.android.gms.games.internal.zze zza = Games.zza(googleApiClient, false);
        if (zza != null) {
            zza.zzbk();
        }
    }

    @Override // com.google.android.gms.games.request.Requests
    public final Intent getInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbv();
    }

    @Override // com.google.android.gms.games.request.Requests
    public final Intent getSendIntent(GoogleApiClient googleApiClient, int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        return Games.zza(googleApiClient).zza(i, bArr, i2, bitmap, str);
    }

    @Override // com.google.android.gms.games.request.Requests
    public final int getMaxPayloadSize(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbw();
    }

    @Override // com.google.android.gms.games.request.Requests
    public final int getMaxLifetimeDays(GoogleApiClient googleApiClient) {
        return Games.zza(googleApiClient).zzbx();
    }

    @Override // com.google.android.gms.games.request.Requests
    public final PendingResult<Requests.UpdateRequestsResult> acceptRequest(GoogleApiClient googleApiClient, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return acceptRequests(googleApiClient, arrayList);
    }

    @Override // com.google.android.gms.games.request.Requests
    public final PendingResult<Requests.UpdateRequestsResult> acceptRequests(GoogleApiClient googleApiClient, List<String> list) {
        return googleApiClient.execute(new ap(this, googleApiClient, list == null ? null : (String[]) list.toArray(new String[list.size()])));
    }

    @Override // com.google.android.gms.games.request.Requests
    public final PendingResult<Requests.UpdateRequestsResult> dismissRequest(GoogleApiClient googleApiClient, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        return dismissRequests(googleApiClient, arrayList);
    }

    @Override // com.google.android.gms.games.request.Requests
    public final PendingResult<Requests.UpdateRequestsResult> dismissRequests(GoogleApiClient googleApiClient, List<String> list) {
        return googleApiClient.execute(new aq(this, googleApiClient, list == null ? null : (String[]) list.toArray(new String[list.size()])));
    }

    @Override // com.google.android.gms.games.request.Requests
    public final PendingResult<Requests.LoadRequestsResult> loadRequests(GoogleApiClient googleApiClient, int i, int i2, int i3) {
        return googleApiClient.enqueue(new ar(this, googleApiClient, i, i2, i3));
    }

    @Override // com.google.android.gms.games.request.Requests
    public final ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent intent) {
        if (intent == null) {
            return new ArrayList<>();
        }
        return getGameRequestsFromBundle(intent.getExtras());
    }

    @Override // com.google.android.gms.games.request.Requests
    public final ArrayList<GameRequest> getGameRequestsFromBundle(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList<>();
        }
        ArrayList arrayList = (ArrayList) bundle.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }
}
