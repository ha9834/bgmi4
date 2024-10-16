package com.discord.connect;

import android.content.Context;
import android.content.SharedPreferences;
import lombok.NonNull;

/* loaded from: classes.dex */
public class b implements e {
    protected static String b = "accessToken";
    protected static String c = "scope";
    protected static String d = "tokenType";
    protected static String e = "expiresInSecs";
    protected static String f = "refreshToken";

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    protected final SharedPreferences f1067a;

    public b(Context context, String str) {
        this.f1067a = context.getSharedPreferences(str, 0);
    }

    public void a(com.discord.connect.auth.a aVar) {
        SharedPreferences.Editor edit = this.f1067a.edit();
        edit.putString(b, aVar.f1065a);
        edit.putString(c, aVar.b);
        edit.putString(d, aVar.c);
        edit.putLong(e, aVar.d);
        edit.putString(f, aVar.e);
        edit.apply();
    }

    @Override // com.discord.connect.e
    public com.discord.connect.auth.a a() {
        String string = this.f1067a.getString(b, null);
        String string2 = this.f1067a.getString(c, null);
        String string3 = this.f1067a.getString(d, null);
        long j = this.f1067a.getLong(e, Long.MAX_VALUE);
        String string4 = this.f1067a.getString(f, null);
        if (string == null && string2 == null && string3 == null && string4 == null) {
            return null;
        }
        return new com.discord.connect.auth.a(string, string2, string3, j, string4);
    }
}
