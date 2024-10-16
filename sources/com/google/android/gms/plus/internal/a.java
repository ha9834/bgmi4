package com.google.android.gms.plus.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.model.people.PersonBuffer;

@VisibleForTesting
/* loaded from: classes2.dex */
final class a implements People.LoadPeopleResult {

    /* renamed from: a, reason: collision with root package name */
    private final Status f5046a;
    private final String b;
    private final PersonBuffer c;

    public a(Status status, DataHolder dataHolder, String str) {
        this.f5046a = status;
        this.b = str;
        this.c = dataHolder != null ? new PersonBuffer(dataHolder) : null;
    }

    @Override // com.google.android.gms.plus.People.LoadPeopleResult
    public final String getNextPageToken() {
        return this.b;
    }

    @Override // com.google.android.gms.plus.People.LoadPeopleResult
    public final PersonBuffer getPersonBuffer() {
        return this.c;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f5046a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public final void release() {
        PersonBuffer personBuffer = this.c;
        if (personBuffer != null) {
            personBuffer.release();
        }
    }
}
