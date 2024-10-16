package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GoogleSignInOptionsCreator")
/* loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f1250a;

    @SafeParcelable.Field(getter = "getScopes", id = 2)
    private final ArrayList<Scope> b;

    @SafeParcelable.Field(getter = "getAccount", id = 3)
    private Account c;

    @SafeParcelable.Field(getter = "isIdTokenRequested", id = 4)
    private boolean d;

    @SafeParcelable.Field(getter = "isServerAuthCodeRequested", id = 5)
    private final boolean e;

    @SafeParcelable.Field(getter = "isForceCodeForRefreshToken", id = 6)
    private final boolean f;

    @SafeParcelable.Field(getter = "getServerClientId", id = 7)
    private String g;

    @SafeParcelable.Field(getter = "getHostedDomain", id = 8)
    private String h;

    @SafeParcelable.Field(getter = "getExtensions", id = 9)
    private ArrayList<GoogleSignInOptionsExtensionParcelable> i;
    private Map<Integer, GoogleSignInOptionsExtensionParcelable> j;

    @VisibleForTesting
    public static final Scope zar = new Scope(Scopes.PROFILE);

    @VisibleForTesting
    public static final Scope zas = new Scope("email");

    @VisibleForTesting
    public static final Scope zat = new Scope("openid");

    @VisibleForTesting
    public static final Scope zau = new Scope(Scopes.GAMES_LITE);

    @VisibleForTesting
    public static final Scope zav = new Scope(Scopes.GAMES);
    public static final GoogleSignInOptions DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN = new Builder().requestScopes(zau, new Scope[0]).build();
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zad();
    private static Comparator<Scope> k = new b();

    public static GoogleSignInOptions zab(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        String optString = jSONObject.optString("accountName", null);
        return new GoogleSignInOptions(3, (ArrayList<Scope>) new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.optString("serverClientId", null), jSONObject.optString("hostedDomain", null), new HashMap());
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Set<Scope> f1251a;
        private boolean b;
        private boolean c;
        private boolean d;
        private String e;
        private Account f;
        private String g;
        private Map<Integer, GoogleSignInOptionsExtensionParcelable> h;

        public Builder() {
            this.f1251a = new HashSet();
            this.h = new HashMap();
        }

        public Builder(GoogleSignInOptions googleSignInOptions) {
            this.f1251a = new HashSet();
            this.h = new HashMap();
            Preconditions.checkNotNull(googleSignInOptions);
            this.f1251a = new HashSet(googleSignInOptions.b);
            this.b = googleSignInOptions.e;
            this.c = googleSignInOptions.f;
            this.d = googleSignInOptions.d;
            this.e = googleSignInOptions.g;
            this.f = googleSignInOptions.c;
            this.g = googleSignInOptions.h;
            this.h = GoogleSignInOptions.b(googleSignInOptions.i);
        }

        public final Builder requestId() {
            this.f1251a.add(GoogleSignInOptions.zat);
            return this;
        }

        public final Builder requestEmail() {
            this.f1251a.add(GoogleSignInOptions.zas);
            return this;
        }

        public final Builder requestProfile() {
            this.f1251a.add(GoogleSignInOptions.zar);
            return this;
        }

        public final Builder requestScopes(Scope scope, Scope... scopeArr) {
            this.f1251a.add(scope);
            this.f1251a.addAll(Arrays.asList(scopeArr));
            return this;
        }

        public final Builder requestIdToken(String str) {
            this.d = true;
            this.e = a(str);
            return this;
        }

        public final Builder requestServerAuthCode(String str) {
            return requestServerAuthCode(str, false);
        }

        public final Builder requestServerAuthCode(String str, boolean z) {
            this.b = true;
            this.e = a(str);
            this.c = z;
            return this;
        }

        public final Builder setAccountName(String str) {
            this.f = new Account(Preconditions.checkNotEmpty(str), "com.google");
            return this;
        }

        public final Builder setHostedDomain(String str) {
            this.g = Preconditions.checkNotEmpty(str);
            return this;
        }

        public final Builder addExtension(GoogleSignInOptionsExtension googleSignInOptionsExtension) {
            if (this.h.containsKey(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()))) {
                throw new IllegalStateException("Only one extension per type may be added");
            }
            if (googleSignInOptionsExtension.getImpliedScopes() != null) {
                this.f1251a.addAll(googleSignInOptionsExtension.getImpliedScopes());
            }
            this.h.put(Integer.valueOf(googleSignInOptionsExtension.getExtensionType()), new GoogleSignInOptionsExtensionParcelable(googleSignInOptionsExtension));
            return this;
        }

        public final GoogleSignInOptions build() {
            if (this.f1251a.contains(GoogleSignInOptions.zav) && this.f1251a.contains(GoogleSignInOptions.zau)) {
                this.f1251a.remove(GoogleSignInOptions.zau);
            }
            if (this.d && (this.f == null || !this.f1251a.isEmpty())) {
                requestId();
            }
            return new GoogleSignInOptions(3, new ArrayList(this.f1251a), this.f, this.d, this.b, this.c, this.e, this.g, this.h, null);
        }

        private final String a(String str) {
            Preconditions.checkNotEmpty(str);
            String str2 = this.e;
            Preconditions.checkArgument(str2 == null || str2.equals(str), "two different server client ids provided");
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public GoogleSignInOptions(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) ArrayList<Scope> arrayList, @SafeParcelable.Param(id = 3) Account account, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) boolean z3, @SafeParcelable.Param(id = 7) String str, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) ArrayList<GoogleSignInOptionsExtensionParcelable> arrayList2) {
        this(i, arrayList, account, z, z2, z3, str, str2, b(arrayList2));
    }

    private GoogleSignInOptions(int i, ArrayList<Scope> arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map<Integer, GoogleSignInOptionsExtensionParcelable> map) {
        this.f1250a = i;
        this.b = arrayList;
        this.c = account;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = str;
        this.h = str2;
        this.i = new ArrayList<>(map.values());
        this.j = map;
    }

    @KeepForSdk
    public ArrayList<Scope> getScopes() {
        return new ArrayList<>(this.b);
    }

    public Scope[] getScopeArray() {
        ArrayList<Scope> arrayList = this.b;
        return (Scope[]) arrayList.toArray(new Scope[arrayList.size()]);
    }

    @KeepForSdk
    public Account getAccount() {
        return this.c;
    }

    @KeepForSdk
    public boolean isIdTokenRequested() {
        return this.d;
    }

    @KeepForSdk
    public boolean isServerAuthCodeRequested() {
        return this.e;
    }

    @KeepForSdk
    public boolean isForceCodeForRefreshToken() {
        return this.f;
    }

    @KeepForSdk
    public String getServerClientId() {
        return this.g;
    }

    @KeepForSdk
    public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<Integer, GoogleSignInOptionsExtensionParcelable> b(List<GoogleSignInOptionsExtensionParcelable> list) {
        HashMap hashMap = new HashMap();
        if (list == null) {
            return hashMap;
        }
        for (GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable : list) {
            hashMap.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.getType()), googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f1250a);
        SafeParcelWriter.writeTypedList(parcel, 2, getScopes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getAccount(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isIdTokenRequested());
        SafeParcelWriter.writeBoolean(parcel, 5, isServerAuthCodeRequested());
        SafeParcelWriter.writeBoolean(parcel, 6, isForceCodeForRefreshToken());
        SafeParcelWriter.writeString(parcel, 7, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 8, this.h, false);
        SafeParcelWriter.writeTypedList(parcel, 9, getExtensions(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
    
        if (r3.g.equals(r4.getServerClientId()) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x004a, code lost:
    
        if (r3.c.equals(r4.getAccount()) != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r4 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r4     // Catch: java.lang.ClassCastException -> L88
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r3.i     // Catch: java.lang.ClassCastException -> L88
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L88
            if (r1 > 0) goto L87
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r1 = r4.i     // Catch: java.lang.ClassCastException -> L88
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L88
            if (r1 <= 0) goto L18
            goto L87
        L18:
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.b     // Catch: java.lang.ClassCastException -> L88
            int r1 = r1.size()     // Catch: java.lang.ClassCastException -> L88
            java.util.ArrayList r2 = r4.getScopes()     // Catch: java.lang.ClassCastException -> L88
            int r2 = r2.size()     // Catch: java.lang.ClassCastException -> L88
            if (r1 != r2) goto L86
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r3.b     // Catch: java.lang.ClassCastException -> L88
            java.util.ArrayList r2 = r4.getScopes()     // Catch: java.lang.ClassCastException -> L88
            boolean r1 = r1.containsAll(r2)     // Catch: java.lang.ClassCastException -> L88
            if (r1 != 0) goto L35
            goto L86
        L35:
            android.accounts.Account r1 = r3.c     // Catch: java.lang.ClassCastException -> L88
            if (r1 != 0) goto L40
            android.accounts.Account r1 = r4.getAccount()     // Catch: java.lang.ClassCastException -> L88
            if (r1 != 0) goto L85
            goto L4c
        L40:
            android.accounts.Account r1 = r3.c     // Catch: java.lang.ClassCastException -> L88
            android.accounts.Account r2 = r4.getAccount()     // Catch: java.lang.ClassCastException -> L88
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L88
            if (r1 == 0) goto L85
        L4c:
            java.lang.String r1 = r3.g     // Catch: java.lang.ClassCastException -> L88
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L88
            if (r1 == 0) goto L5f
            java.lang.String r1 = r4.getServerClientId()     // Catch: java.lang.ClassCastException -> L88
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.ClassCastException -> L88
            if (r1 == 0) goto L85
            goto L6b
        L5f:
            java.lang.String r1 = r3.g     // Catch: java.lang.ClassCastException -> L88
            java.lang.String r2 = r4.getServerClientId()     // Catch: java.lang.ClassCastException -> L88
            boolean r1 = r1.equals(r2)     // Catch: java.lang.ClassCastException -> L88
            if (r1 == 0) goto L85
        L6b:
            boolean r1 = r3.f     // Catch: java.lang.ClassCastException -> L88
            boolean r2 = r4.isForceCodeForRefreshToken()     // Catch: java.lang.ClassCastException -> L88
            if (r1 != r2) goto L85
            boolean r1 = r3.d     // Catch: java.lang.ClassCastException -> L88
            boolean r2 = r4.isIdTokenRequested()     // Catch: java.lang.ClassCastException -> L88
            if (r1 != r2) goto L85
            boolean r1 = r3.e     // Catch: java.lang.ClassCastException -> L88
            boolean r4 = r4.isServerAuthCodeRequested()     // Catch: java.lang.ClassCastException -> L88
            if (r1 != r4) goto L85
            r4 = 1
            return r4
        L85:
            return r0
        L86:
            return r0
        L87:
            return r0
        L88:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.b;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Scope scope = arrayList2.get(i);
            i++;
            arrayList.add(scope.getScopeUri());
        }
        Collections.sort(arrayList);
        return new HashAccumulator().addObject(arrayList).addObject(this.c).addObject(this.g).zaa(this.f).zaa(this.d).zaa(this.e).hash();
    }

    public final String zae() {
        return a().toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.b, k);
            ArrayList<Scope> arrayList = this.b;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Scope scope = arrayList.get(i);
                i++;
                jSONArray.put(scope.getScopeUri());
            }
            jSONObject.put("scopes", jSONArray);
            if (this.c != null) {
                jSONObject.put("accountName", this.c.name);
            }
            jSONObject.put("idTokenRequested", this.d);
            jSONObject.put("forceCodeForRefreshToken", this.f);
            jSONObject.put("serverAuthRequested", this.e);
            if (!TextUtils.isEmpty(this.g)) {
                jSONObject.put("serverClientId", this.g);
            }
            if (!TextUtils.isEmpty(this.h)) {
                jSONObject.put("hostedDomain", this.h);
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /* synthetic */ GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, Map map, b bVar) {
        this(3, (ArrayList<Scope>) arrayList, account, z, z2, z3, str, str2, (Map<Integer, GoogleSignInOptionsExtensionParcelable>) map);
    }
}
