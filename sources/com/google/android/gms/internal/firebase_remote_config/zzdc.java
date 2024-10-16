package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
public final class zzdc extends zzdb<zzdf> {

    @zzcc
    private String namespace;

    @zzcc
    private String project;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzdc(zzcz zzczVar, String str, String str2, zzdg zzdgVar) {
        super(zzczVar.f4150a.f4153a, "POST", "v1/projects/{project}/namespaces/{namespace}:fetch", zzdgVar, zzdf.class);
        this.project = (String) zzch.checkNotNull(str, "Required parameter project must be specified.");
        this.namespace = (String) zzch.checkNotNull(str2, "Required parameter namespace must be specified.");
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzdb
    /* renamed from: zzg */
    public final /* synthetic */ zzdb<zzdf> zzb(String str, Object obj) {
        return (zzdc) zzb(str, obj);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzdb, com.google.android.gms.internal.firebase_remote_config.zzn
    /* renamed from: zzd */
    public final /* synthetic */ zzn zzb(String str, Object obj) {
        return (zzdc) zzb(str, obj);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzdb, com.google.android.gms.internal.firebase_remote_config.zzn, com.google.android.gms.internal.firebase_remote_config.zzf
    /* renamed from: zzc */
    public final /* synthetic */ zzf zzb(String str, Object obj) {
        return (zzdc) zzb(str, obj);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzdb, com.google.android.gms.internal.firebase_remote_config.zzn, com.google.android.gms.internal.firebase_remote_config.zzf, com.google.android.gms.internal.firebase_remote_config.zzby
    public final /* synthetic */ zzby zzb(String str, Object obj) {
        return (zzdc) super.zzb(str, obj);
    }
}
