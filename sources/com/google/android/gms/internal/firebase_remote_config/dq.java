package com.google.android.gms.internal.firebase_remote_config;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* loaded from: classes2.dex */
public final class dq<FieldDescriptorType> extends dn<FieldDescriptorType, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public dq(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dn
    public final void a() {
        if (!b()) {
            for (int i = 0; i < c(); i++) {
                Map.Entry<FieldDescriptorType, Object> b = b(i);
                if (((zzhc) b.getKey()).zzgq()) {
                    b.setValue(Collections.unmodifiableList((List) b.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : d()) {
                if (((zzhc) entry.getKey()).zzgq()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
