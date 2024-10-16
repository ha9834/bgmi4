package com.google.android.gms.games.internal;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.tencent.midas.oversea.comm.NetErrConstants;
import com.tencent.smtt.sdk.TbsReaderView;

/* loaded from: classes.dex */
public final class zzbv extends com.google.android.gms.internal.games.zza implements zzbu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.games.internal.IGamesService");
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeLong(j);
        b(TbsReaderView.ReaderCallback.HIDDEN_BAR, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        b(TbsReaderView.ReaderCallback.SHOW_BAR, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final String zzbr() throws RemoteException {
        Parcel a2 = a(TbsReaderView.ReaderCallback.COPY_SELECT_TEXT, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Bundle getConnectionHint() throws RemoteException {
        Parcel a2 = a(TbsReaderView.ReaderCallback.SEARCH_SELECT_TEXT, a());
        Bundle bundle = (Bundle) com.google.android.gms.internal.games.zzc.zza(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        a2.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzc.zza(a2, bundle);
        b(TbsReaderView.ReaderCallback.READER_TOAST, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzci() throws RemoteException {
        b(TbsReaderView.ReaderCallback.SHOW_DIALOG, a());
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final String zzau() throws RemoteException {
        Parcel a2 = a(5007, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final String zzck() throws RemoteException {
        Parcel a2 = a(TbsReaderView.ReaderCallback.READER_PLUGIN_STATUS, a());
        String readString = a2.readString();
        a2.recycle();
        return readString;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final DataHolder zzcl() throws RemoteException {
        Parcel a2 = a(TbsReaderView.ReaderCallback.READER_PLUGIN_CANLOAD, a());
        DataHolder dataHolder = (DataHolder) com.google.android.gms.internal.games.zzc.zza(a2, DataHolder.CREATOR);
        a2.recycle();
        return dataHolder;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, int i, boolean z, boolean z2) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeInt(i);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z2);
        b(TbsReaderView.ReaderCallback.READER_PLUGIN_COMMAND_FIXSCREEN, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        a2.writeInt(i);
        a2.writeInt(i2);
        a2.writeInt(i3);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        b(TbsReaderView.ReaderCallback.READER_PLUGIN_RES_ROTATESCREEN_NORMAL, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        a2.writeInt(i);
        a2.writeInt(i2);
        a2.writeInt(i3);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        b(5020, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, Bundle bundle, int i, int i2) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        com.google.android.gms.internal.games.zzc.zza(a2, bundle);
        a2.writeInt(i);
        a2.writeInt(i2);
        b(TbsReaderView.ReaderCallback.READER_PLUGIN_RES_PPT_GUIDE, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        a2.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzc.zza(a2, bundle);
        b(TbsReaderView.ReaderCallback.READER_PLUGIN_RES_PDF_GUIDE, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        a2.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzc.zza(a2, bundle);
        b(TbsReaderView.ReaderCallback.GET_BAR_ISSHOWING, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        a2.writeInt(i);
        a2.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzc.zza(a2, bundle);
        b(TbsReaderView.ReaderCallback.READER_PLUGIN_SO_ERR, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        b(TbsReaderView.ReaderCallback.READER_SEARCH_IN_DOCUMENT, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzd(String str, int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeInt(i);
        b(TbsReaderView.ReaderCallback.READER_PLUGIN_SO_PROGRESS, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(String str, int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeInt(i);
        b(TbsReaderView.ReaderCallback.READER_PLUGIN_RES_DOC_GUIDE, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, long j) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeLong(j);
        b(5058, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeLong(j);
        b(5059, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, IBinder iBinder, int i, String[] strArr, Bundle bundle, boolean z, long j) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeStrongBinder(iBinder);
        a2.writeInt(i);
        a2.writeStringArray(strArr);
        com.google.android.gms.internal.games.zzc.zza(a2, bundle);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, false);
        a2.writeLong(j);
        b(TbsReaderView.ReaderCallback.READER_PLUGIN_SO_VERSION, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, IBinder iBinder, String str, boolean z, long j) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeStrongBinder(iBinder);
        a2.writeString(str);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, false);
        a2.writeLong(j);
        b(TbsReaderView.ReaderCallback.READER_OPEN_QQ_FILE_LIST, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        b(TbsReaderView.ReaderCallback.READER_PLUGIN_ACTIVITY_PAUSE, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zza(zzbq zzbqVar, byte[] bArr, String str, String str2) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeByteArray(bArr);
        a2.writeString(str);
        a2.writeString(str2);
        Parcel a3 = a(5033, a2);
        int readInt = a3.readInt();
        a3.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zzb(byte[] bArr, String str, String[] strArr) throws RemoteException {
        Parcel a2 = a();
        a2.writeByteArray(bArr);
        a2.writeString(str);
        a2.writeStringArray(strArr);
        Parcel a3 = a(5034, a2);
        int readInt = a3.readInt();
        a3.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzl(int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        b(TbsReaderView.ReaderCallback.READER_PLUGIN_COMMAND_PDF_LIST, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final DataHolder zzcm() throws RemoteException {
        Parcel a2 = a(5502, a());
        DataHolder dataHolder = (DataHolder) com.google.android.gms.internal.games.zzc.zza(a2, DataHolder.CREATOR);
        a2.recycle();
        return dataHolder;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, boolean z) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        b(6001, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, boolean z) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        b(GamesStatusCodes.STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, boolean z) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        b(GamesStatusCodes.STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, long j, String str2) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        a2.writeLong(j);
        a2.writeString(str2);
        b(GamesStatusCodes.STATUS_INVALID_REAL_TIME_ROOM_ID, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        a2.writeInt(i);
        a2.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzc.zza(a2, bundle);
        b(GamesStatusCodes.STATUS_PARTICIPANT_NOT_CONNECTED, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, String str2, int i, int i2) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(null);
        a2.writeString(str2);
        a2.writeInt(i);
        a2.writeInt(i2);
        b(8001, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzf(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        b(8002, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, int i, int i2, String[] strArr, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeInt(i);
        a2.writeInt(i2);
        a2.writeStringArray(strArr);
        com.google.android.gms.internal.games.zzc.zza(a2, bundle);
        b(ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, String str) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        b(ConnectionsStatusCodes.STATUS_NOT_CONNECTED_TO_ENDPOINT, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzc(zzbq zzbqVar, String str) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        b(8006, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        a2.writeByteArray(bArr);
        a2.writeString(str2);
        a2.writeTypedArray(participantResultArr, 0);
        b(ConnectionsStatusCodes.STATUS_BLUETOOTH_ERROR, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        a2.writeByteArray(bArr);
        a2.writeTypedArray(participantResultArr, 0);
        b(ConnectionsStatusCodes.STATUS_ALREADY_HAVE_ACTIVE_STRATEGY, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzd(zzbq zzbqVar, String str) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        b(ConnectionsStatusCodes.STATUS_OUT_OF_ORDER_API_CALL, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zze(zzbq zzbqVar, String str) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        b(8010, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, String str2) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        a2.writeString(str2);
        b(ConnectionsStatusCodes.STATUS_ENDPOINT_UNKNOWN, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, long j) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeLong(j);
        b(ConnectionsStatusCodes.STATUS_ENDPOINT_IO_ERROR, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzc(long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeLong(j);
        b(ConnectionsStatusCodes.STATUS_PAYLOAD_IO_ERROR, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzf(zzbq zzbqVar, String str) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        b(8014, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zzbt() throws RemoteException {
        Parcel a2 = a(8024, a());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzc(zzbq zzbqVar, boolean z) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        b(8027, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzba() throws RemoteException {
        Parcel a2 = a(GamesStatusCodes.STATUS_VIDEO_STORAGE_ERROR, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzbc() throws RemoteException {
        Parcel a2 = a(9005, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzbd() throws RemoteException {
        Parcel a2 = a(GamesStatusCodes.STATUS_VIDEO_ALREADY_CAPTURING, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzbe() throws RemoteException {
        Parcel a2 = a(9007, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zza(int i, int i2, boolean z) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        a2.writeInt(i2);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        Parcel a3 = a(9008, a2);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a3, Intent.CREATOR);
        a3.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzc(int i, int i2, boolean z) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        a2.writeInt(i2);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        Parcel a3 = a(GamesStatusCodes.STATUS_VIDEO_OUT_OF_DISK_SPACE, a2);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a3, Intent.CREATOR);
        a3.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzbl() throws RemoteException {
        Parcel a2 = a(9010, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zza(RoomEntity roomEntity, int i) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, roomEntity);
        a2.writeInt(i);
        Parcel a3 = a(9011, a2);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a3, Intent.CREATOR);
        a3.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzbn() throws RemoteException {
        Parcel a2 = a(9012, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zzbp() throws RemoteException {
        Parcel a2 = a(9019, a());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, int i, boolean z, boolean z2) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        a2.writeInt(i);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z2);
        b(9020, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzc(zzbq zzbqVar, long j) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeLong(j);
        b(10001, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzd(long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeLong(j);
        b(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String[] strArr) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeStringArray(strArr);
        b(GamesActivityResultCodes.RESULT_NETWORK_FAILURE, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, String[] strArr) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeStringArray(strArr);
        b(GamesActivityResultCodes.RESULT_SEND_REQUEST_FAILED, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, int i, int i2, int i3) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeInt(i);
        a2.writeInt(i2);
        a2.writeInt(i3);
        b(10009, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zza(int i, byte[] bArr, int i2, String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        a2.writeByteArray(bArr);
        a2.writeInt(i2);
        a2.writeString(str);
        Parcel a3 = a(10012, a2);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a3, Intent.CREATOR);
        a3.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zzbw() throws RemoteException {
        Parcel a2 = a(10013, a());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zzbx() throws RemoteException {
        Parcel a2 = a(10023, a());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzbv() throws RemoteException {
        Parcel a2 = a(10015, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, int i) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeInt(i);
        b(10016, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, int i, int[] iArr) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeInt(i);
        a2.writeIntArray(iArr);
        b(10018, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zza(String str, boolean z, boolean z2, int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z2);
        a2.writeInt(i);
        Parcel a3 = a(12001, a2);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a3, Intent.CREATOR);
        a3.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzd(zzbq zzbqVar, boolean z) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        b(12002, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        com.google.android.gms.internal.games.zzc.zza(a2, snapshotMetadataChangeEntity);
        com.google.android.gms.internal.games.zzc.zza(a2, contents);
        b(12007, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(Contents contents) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, contents);
        b(12019, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzg(zzbq zzbqVar, String str) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        b(12020, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        a2.writeString(str2);
        com.google.android.gms.internal.games.zzc.zza(a2, snapshotMetadataChangeEntity);
        com.google.android.gms.internal.games.zzc.zza(a2, contents);
        b(12033, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zzby() throws RemoteException {
        Parcel a2 = a(12035, a());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final int zzca() throws RemoteException {
        Parcel a2 = a(12036, a());
        int readInt = a2.readInt();
        a2.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zze(zzbq zzbqVar, boolean z) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        b(12016, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, boolean z, String[] strArr) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        a2.writeStringArray(strArr);
        b(12031, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(String str, int i) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeInt(i);
        b(12017, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzh(zzbq zzbqVar, String str) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        b(12008, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, String str, String str2) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        a2.writeString(str2);
        b(12009, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, int[] iArr, int i, boolean z) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeIntArray(iArr);
        a2.writeInt(i);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        b(12010, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String[] strArr, boolean z) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeStringArray(strArr);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        b(12029, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzd(zzbq zzbqVar, long j) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeLong(j);
        b(12011, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zze(long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeLong(j);
        b(12012, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zza(int[] iArr) throws RemoteException {
        Parcel a2 = a();
        a2.writeIntArray(iArr);
        Parcel a3 = a(12030, a2);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a3, Intent.CREATOR);
        a3.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzd(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        Parcel a3 = a(12034, a2);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a3, Intent.CREATOR);
        a3.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games.zzc.zza(a2, bundle);
        b(13002, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, String str, boolean z) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        b(13006, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbq zzbqVar, String str, boolean z, int i) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeString(str);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        a2.writeInt(i);
        b(15001, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(zzbs zzbsVar, long j) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbsVar);
        a2.writeLong(j);
        b(15501, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zza(PlayerEntity playerEntity) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, playerEntity);
        Parcel a3 = a(15503, a2);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a3, Intent.CREATOR);
        a3.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzf(zzbq zzbqVar, boolean z) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        com.google.android.gms.internal.games.zzc.writeBoolean(a2, z);
        b(17001, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzb(String str, int i, int i2) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeInt(i);
        a2.writeInt(i2);
        Parcel a3 = a(18001, a2);
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a3, Intent.CREATOR);
        a3.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final Intent zzcn() throws RemoteException {
        Parcel a2 = a(19002, a());
        Intent intent = (Intent) com.google.android.gms.internal.games.zzc.zza(a2, Intent.CREATOR);
        a2.recycle();
        return intent;
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zza(String str, zzbq zzbqVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        b(NetErrConstants.ERROR_NETWORK_CONTIMEOUT, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzc(zzbq zzbqVar) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        b(21007, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzb(zzbq zzbqVar, int i) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeInt(i);
        b(22016, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zze(zzbq zzbqVar, long j) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        a2.writeLong(j);
        b(22026, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzf(long j) throws RemoteException {
        Parcel a2 = a();
        a2.writeLong(j);
        b(22027, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final void zzd(zzbq zzbqVar) throws RemoteException {
        Parcel a2 = a();
        com.google.android.gms.internal.games.zzc.zza(a2, zzbqVar);
        b(22028, a2);
    }

    @Override // com.google.android.gms.games.internal.zzbu
    public final boolean zzce() throws RemoteException {
        Parcel a2 = a(22030, a());
        boolean zza = com.google.android.gms.internal.games.zzc.zza(a2);
        a2.recycle();
        return zza;
    }
}
