package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import java.io.DataInputStream;
import java.io.IOException;

@zzard
@SafeParcelable.Class(creator = "LargeParcelTeleporterCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzaru extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaru> CREATOR = new zzarw();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    private ParcelFileDescriptor f2788a;
    private Parcelable b = null;
    private boolean c = true;

    @SafeParcelable.Constructor
    public zzaru(@SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.f2788a = parcelFileDescriptor;
    }

    public final <T extends SafeParcelable> T zza(Parcelable.Creator<T> creator) {
        if (this.c) {
            ParcelFileDescriptor parcelFileDescriptor = this.f2788a;
            if (parcelFileDescriptor == null) {
                zzawz.zzen("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor));
            try {
                try {
                    byte[] bArr = new byte[dataInputStream.readInt()];
                    dataInputStream.readFully(bArr, 0, bArr.length);
                    IOUtils.closeQuietly(dataInputStream);
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.unmarshall(bArr, 0, bArr.length);
                        obtain.setDataPosition(0);
                        this.b = creator.createFromParcel(obtain);
                        obtain.recycle();
                        this.c = false;
                    } catch (Throwable th) {
                        obtain.recycle();
                        throw th;
                    }
                } catch (IOException e) {
                    zzawz.zzc("Could not read from parcel file descriptor", e);
                    IOUtils.closeQuietly(dataInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                IOUtils.closeQuietly(dataInputStream);
                throw th2;
            }
        }
        return (T) this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        a();
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f2788a, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private final ParcelFileDescriptor a() {
        if (this.f2788a == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.b.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.f2788a = a(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        return this.f2788a;
    }

    private final <T> ParcelFileDescriptor a(byte[] bArr) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        ParcelFileDescriptor[] createPipe;
        try {
            createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
        } catch (IOException e) {
            e = e;
            autoCloseOutputStream = null;
        }
        try {
            new Thread(new ea(this, autoCloseOutputStream, bArr)).start();
            return createPipe[0];
        } catch (IOException e2) {
            e = e2;
            zzawz.zzc("Error transporting the ad response", e);
            zzk.zzlk().zza(e, "LargeParcelTeleporter.pipeData.2");
            IOUtils.closeQuietly(autoCloseOutputStream);
            return null;
        }
    }
}
