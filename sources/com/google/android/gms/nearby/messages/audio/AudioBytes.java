package com.google.android.gms.nearby.messages.audio;

import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class AudioBytes {
    public static final int MAX_SIZE = 10;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f4990a;

    public AudioBytes(byte[] bArr) {
        zzbq.checkNotNull(bArr);
        zzbq.checkArgument(bArr.length <= 10, "Given byte array longer than 10 bytes, given by AudioBytes.MAX_SIZE.");
        zzbq.checkArgument(bArr.length > 0, "Given byte array is of zero length.");
        this.f4990a = bArr;
    }

    public static AudioBytes from(Message message) {
        zzbq.checkNotNull(message);
        boolean zzkx = message.zzkx(Message.MESSAGE_TYPE_AUDIO_BYTES);
        String type = message.getType();
        StringBuilder sb = new StringBuilder(String.valueOf(type).length() + 56);
        sb.append("Message type '");
        sb.append(type);
        sb.append("' is not Message.MESSAGE_TYPE_AUDIO_BYTES.");
        zzbq.checkArgument(zzkx, sb.toString());
        return new AudioBytes(message.getContent());
    }

    public final byte[] getBytes() {
        return this.f4990a;
    }

    public final Message toMessage() {
        return new Message(this.f4990a, Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_AUDIO_BYTES);
    }

    public final String toString() {
        String arrays = Arrays.toString(this.f4990a);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 14);
        sb.append("AudioBytes [");
        sb.append(arrays);
        sb.append(" ]");
        return sb.toString();
    }
}
