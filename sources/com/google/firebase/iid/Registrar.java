package com.google.firebase.iid;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.events.Subscriber;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@Keep
@KeepForSdk
/* loaded from: classes2.dex */
public final class Registrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public final List<Component<?>> getComponents() {
        return Arrays.asList(Component.builder(FirebaseInstanceId.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(Subscriber.class)).add(Dependency.required(UserAgentPublisher.class)).factory(zzao.zzct).alwaysEager().build(), Component.builder(FirebaseInstanceIdInternal.class).add(Dependency.required(FirebaseInstanceId.class)).factory(zzap.zzct).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class zza implements FirebaseInstanceIdInternal {
        private final FirebaseInstanceId zzcu;

        public zza(FirebaseInstanceId firebaseInstanceId) {
            this.zzcu = firebaseInstanceId;
        }

        @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal
        public final String getId() {
            return this.zzcu.getId();
        }

        @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal
        public final String getToken() {
            return this.zzcu.getToken();
        }
    }
}
