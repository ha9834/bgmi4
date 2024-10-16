package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.nearby.connection.Payload;
import java.io.IOException;

/* loaded from: classes.dex */
public final class zzcud {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<zzcub, Pair<ParcelFileDescriptor, ParcelFileDescriptor>> a(Payload payload) throws IOException {
        switch (payload.getType()) {
            case 1:
                return Pair.create(new zzcub(payload.getId(), payload.getType(), payload.asBytes(), null, null, -1L, null), null);
            case 2:
                return Pair.create(new zzcub(payload.getId(), payload.getType(), null, payload.asFile().asParcelFileDescriptor(), payload.asFile().asJavaFile() == null ? null : payload.asFile().asJavaFile().getAbsolutePath(), payload.asFile().getSize(), null), null);
            case 3:
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    ParcelFileDescriptor[] createPipe2 = ParcelFileDescriptor.createPipe();
                    return Pair.create(new zzcub(payload.getId(), payload.getType(), null, createPipe[0], null, -1L, createPipe2[0]), Pair.create(createPipe[1], createPipe2[1]));
                } catch (IOException e) {
                    Log.e("NearbyConnections", String.format("Unable to create PFD pipe for streaming payload %d from client to service.", Long.valueOf(payload.getId())), e);
                    throw e;
                }
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Outgoing Payload %d has unknown type %d", Long.valueOf(payload.getId()), Integer.valueOf(payload.getType())));
                Log.wtf("NearbyConnections", "Unknown payload type!", illegalArgumentException);
                throw illegalArgumentException;
        }
    }
}
