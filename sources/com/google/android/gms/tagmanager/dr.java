package com.google.android.gms.tagmanager;

import com.google.android.gms.tagmanager.DataLayer;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dr implements DataLayer.b {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ TagManager f5126a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(TagManager tagManager) {
        this.f5126a = tagManager;
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.b
    public final void a(Map<String, Object> map) {
        Object obj = map.get(DataLayer.EVENT_KEY);
        if (obj != null) {
            this.f5126a.a(obj.toString());
        }
    }
}
