package com.google.android.gms.internal.plus;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.model.people.PersonBuffer;

/* loaded from: classes2.dex */
final class j implements People.LoadPeopleResult {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Status f4656a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, Status status) {
        this.f4656a = status;
    }

    @Override // com.google.android.gms.plus.People.LoadPeopleResult
    public final String getNextPageToken() {
        return null;
    }

    @Override // com.google.android.gms.plus.People.LoadPeopleResult
    public final PersonBuffer getPersonBuffer() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4656a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
    }
}
