package com.google.android.gms.internal.plus;

import android.annotation.SuppressLint;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class zzj implements People {
    @Override // com.google.android.gms.plus.People
    public final Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.zza(googleApiClient, true).zzb();
    }

    @Override // com.google.android.gms.plus.People
    @VisibleForTesting
    @SuppressLint({"MissingRemoteException"})
    public final PendingResult<People.LoadPeopleResult> load(GoogleApiClient googleApiClient, Collection<String> collection) {
        return googleApiClient.enqueue(new g(this, googleApiClient, collection));
    }

    @Override // com.google.android.gms.plus.People
    @VisibleForTesting
    @SuppressLint({"MissingRemoteException"})
    public final PendingResult<People.LoadPeopleResult> load(GoogleApiClient googleApiClient, String... strArr) {
        return googleApiClient.enqueue(new h(this, googleApiClient, strArr));
    }

    @Override // com.google.android.gms.plus.People
    @VisibleForTesting
    @SuppressLint({"MissingRemoteException"})
    public final PendingResult<People.LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.enqueue(new f(this, googleApiClient));
    }

    @Override // com.google.android.gms.plus.People
    @VisibleForTesting
    @SuppressLint({"MissingRemoteException"})
    public final PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, int i, String str) {
        return googleApiClient.enqueue(new d(this, googleApiClient, i, str));
    }

    @Override // com.google.android.gms.plus.People
    @VisibleForTesting
    @SuppressLint({"MissingRemoteException"})
    public final PendingResult<People.LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, String str) {
        return googleApiClient.enqueue(new e(this, googleApiClient, str));
    }
}
