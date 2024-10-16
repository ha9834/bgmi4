package com.google.firebase.iid;

import com.amazonaws.event.ProgressEvent;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public final class zza {
    public static KeyPair zzc() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(ProgressEvent.PART_COMPLETED_EVENT_CODE);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }
}
