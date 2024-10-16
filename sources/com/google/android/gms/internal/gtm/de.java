package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
/* loaded from: classes2.dex */
public final class de<FieldDescriptorType> extends dd<FieldDescriptorType, Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public de(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.gtm.dd
    public final void a() {
        if (!b()) {
            for (int i = 0; i < c(); i++) {
                Map.Entry<FieldDescriptorType, Object> b = b(i);
                if (((zzqv) b.getKey()).zzoz()) {
                    b.setValue(Collections.unmodifiableList((List) b.getValue()));
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : d()) {
                if (((zzqv) entry.getKey()).zzoz()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.a();
    }
}
