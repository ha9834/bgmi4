package com.uqm.crashsight.proguard;

import java.io.Serializable;

/* loaded from: classes3.dex */
public final class a implements Serializable, Comparable<a> {

    /* renamed from: a, reason: collision with root package name */
    public long f6607a;
    public String b;
    public long c;
    public int d;
    public String e;
    public String f;
    public long g;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
        return (int) (this.c - aVar.c);
    }
}
