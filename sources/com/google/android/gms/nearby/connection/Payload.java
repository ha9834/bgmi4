package com.google.android.gms.nearby.connection;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.drive.DriveFile;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

/* loaded from: classes2.dex */
public class Payload {

    /* renamed from: a, reason: collision with root package name */
    private final long f4971a;

    @Type
    private final int b;
    private final byte[] c;
    private final File d;
    private final Stream e;

    /* loaded from: classes2.dex */
    public static class File {

        /* renamed from: a, reason: collision with root package name */
        private final java.io.File f4972a;
        private final ParcelFileDescriptor b;
        private final long c;

        private File(java.io.File file, ParcelFileDescriptor parcelFileDescriptor, long j) {
            this.f4972a = file;
            this.b = parcelFileDescriptor;
            this.c = j;
        }

        @Hide
        public static File zza(java.io.File file, long j) throws FileNotFoundException {
            return new File((java.io.File) zzbq.checkNotNull(file, "Cannot create Payload.File from null java.io.File."), ParcelFileDescriptor.open(file, DriveFile.MODE_READ_ONLY), j);
        }

        @Hide
        public static File zzb(ParcelFileDescriptor parcelFileDescriptor) {
            return new File(null, (ParcelFileDescriptor) zzbq.checkNotNull(parcelFileDescriptor, "Cannot create Payload.File from null ParcelFileDescriptor."), parcelFileDescriptor.getStatSize());
        }

        public java.io.File asJavaFile() {
            return this.f4972a;
        }

        public ParcelFileDescriptor asParcelFileDescriptor() {
            return this.b;
        }

        public long getSize() {
            return this.c;
        }
    }

    /* loaded from: classes2.dex */
    public static class Stream {

        /* renamed from: a, reason: collision with root package name */
        private final ParcelFileDescriptor f4973a;
        private InputStream b;

        private Stream(ParcelFileDescriptor parcelFileDescriptor, InputStream inputStream) {
            this.f4973a = parcelFileDescriptor;
            this.b = inputStream;
        }

        @Hide
        public static Stream zzc(ParcelFileDescriptor parcelFileDescriptor) {
            zzbq.checkNotNull(parcelFileDescriptor, "Cannot create Payload.Stream from null ParcelFileDescriptor.");
            return new Stream(parcelFileDescriptor, null);
        }

        @Hide
        public static Stream zzf(InputStream inputStream) {
            zzbq.checkNotNull(inputStream, "Cannot create Payload.Stream from null InputStream.");
            return new Stream(null, inputStream);
        }

        public InputStream asInputStream() {
            if (this.b == null) {
                this.b = new ParcelFileDescriptor.AutoCloseInputStream(this.f4973a);
            }
            return this.b;
        }

        public ParcelFileDescriptor asParcelFileDescriptor() {
            return this.f4973a;
        }
    }

    /* loaded from: classes.dex */
    public @interface Type {
        public static final int BYTES = 1;
        public static final int FILE = 2;
        public static final int STREAM = 3;
    }

    private Payload(long j, int i, byte[] bArr, File file, Stream stream) {
        this.f4971a = j;
        this.b = i;
        this.c = bArr;
        this.d = file;
        this.e = stream;
    }

    public static Payload fromBytes(byte[] bArr) {
        zzbq.checkNotNull(bArr, "Cannot create a Payload from null bytes.");
        return zza(bArr, UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromFile(ParcelFileDescriptor parcelFileDescriptor) {
        return zza(File.zzb(parcelFileDescriptor), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromFile(java.io.File file) throws FileNotFoundException {
        return zza(File.zza(file, file.length()), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromStream(ParcelFileDescriptor parcelFileDescriptor) {
        return zza(Stream.zzc(parcelFileDescriptor), UUID.randomUUID().getLeastSignificantBits());
    }

    public static Payload fromStream(InputStream inputStream) {
        return zza(Stream.zzf(inputStream), UUID.randomUUID().getLeastSignificantBits());
    }

    @Hide
    public static Payload zza(File file, long j) {
        return new Payload(j, 2, null, file, null);
    }

    @Hide
    public static Payload zza(Stream stream, long j) {
        return new Payload(j, 3, null, null, stream);
    }

    @Hide
    public static Payload zza(byte[] bArr, long j) {
        return new Payload(j, 1, bArr, null, null);
    }

    public byte[] asBytes() {
        return this.c;
    }

    public File asFile() {
        return this.d;
    }

    public Stream asStream() {
        return this.e;
    }

    public long getId() {
        return this.f4971a;
    }

    @Type
    public int getType() {
        return this.b;
    }
}
