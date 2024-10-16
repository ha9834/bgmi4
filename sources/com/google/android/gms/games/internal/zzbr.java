package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.firebase.FirebaseError;
import com.tencent.midas.oversea.comm.NetErrConstants;
import com.tencent.smtt.sdk.TbsReaderView;

/* loaded from: classes.dex */
public abstract class zzbr extends com.google.android.gms.internal.games.zzb implements zzbq {
    public zzbr() {
        super("com.google.android.gms.games.internal.IGamesCallbacks");
    }

    @Override // com.google.android.gms.internal.games.zzb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case TbsReaderView.ReaderCallback.HIDDEN_BAR /* 5001 */:
                zza(parcel.readInt(), parcel.readString());
                break;
            case TbsReaderView.ReaderCallback.SHOW_BAR /* 5002 */:
                zza((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                break;
            case TbsReaderView.ReaderCallback.COPY_SELECT_TEXT /* 5003 */:
                zzb(parcel.readInt(), parcel.readString());
                break;
            case TbsReaderView.ReaderCallback.SEARCH_SELECT_TEXT /* 5004 */:
                zzc((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                break;
            case TbsReaderView.ReaderCallback.READER_TOAST /* 5005 */:
                zza((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR), (DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                break;
            case TbsReaderView.ReaderCallback.SHOW_DIALOG /* 5006 */:
                zzd((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                break;
            case 5007:
                zze((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                break;
            case TbsReaderView.ReaderCallback.READER_PDF_LIST /* 5008 */:
                zzf((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                break;
            case TbsReaderView.ReaderCallback.READER_PPT_PLAY_MODEL /* 5009 */:
                zzg((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                break;
            case TbsReaderView.ReaderCallback.READER_TXT_READING_MODEL /* 5010 */:
                zzh((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                break;
            case TbsReaderView.ReaderCallback.INSTALL_QB /* 5011 */:
                zzi((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                break;
            default:
                switch (i) {
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_RES_FIXSCREEN_NORMAL /* 5016 */:
                        onSignOutComplete();
                        break;
                    case 5017:
                        zzk((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_COMMAND_ROTATESCREEN /* 5018 */:
                        zzs((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_RES_ROTATESCREEN_NORMAL /* 5019 */:
                        zzt((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                        break;
                    case 5020:
                        onLeftRoom(parcel.readInt(), parcel.readString());
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_RES_PPT_GUIDE /* 5021 */:
                        zzu((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_RES_TXT_GUIDE /* 5022 */:
                        zzv((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_RES_PDF_GUIDE /* 5023 */:
                        zzw((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                        break;
                    case TbsReaderView.ReaderCallback.GET_BAR_ISSHOWING /* 5024 */:
                        zzx((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_SO_ERR /* 5025 */:
                        zzy((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                        break;
                    case TbsReaderView.ReaderCallback.READER_SEARCH_IN_DOCUMENT /* 5026 */:
                        zza((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_SO_INTO_START /* 5027 */:
                        zzb((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_SO_PROGRESS /* 5028 */:
                        zzc((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_RES_DOC_GUIDE /* 5029 */:
                        zzd((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_SO_VERSION /* 5030 */:
                        zze((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                        break;
                    case TbsReaderView.ReaderCallback.READER_OPEN_QQ_FILE_LIST /* 5031 */:
                        zzf((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR), parcel.createStringArray());
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_ACTIVITY_PAUSE /* 5032 */:
                        onRealTimeMessageReceived((RealTimeMessage) com.google.android.gms.internal.games.zzc.zza(parcel, RealTimeMessage.CREATOR));
                        break;
                    case 5033:
                        zza(parcel.readInt(), parcel.readInt(), parcel.readString());
                        break;
                    case 5034:
                        zza(parcel.readInt(), parcel.readString(), com.google.android.gms.internal.games.zzc.zza(parcel));
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_COMMAND_PPT_PLAYER /* 5035 */:
                        zzaa((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_COMMAND_PDF_LIST /* 5036 */:
                        zzc(parcel.readInt());
                        break;
                    case 5037:
                        zzl((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND /* 5038 */:
                        zzz((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND_NEXT /* 5039 */:
                        zzab((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                        break;
                    case TbsReaderView.ReaderCallback.READER_PLUGIN_COMMAND_TEXT_FIND_PREV /* 5040 */:
                        zzd(parcel.readInt());
                        break;
                    default:
                        switch (i) {
                            case 6001:
                                onP2PConnected(parcel.readString());
                                break;
                            case GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE /* 6002 */:
                                onP2PDisconnected(parcel.readString());
                                break;
                            default:
                                switch (i) {
                                    case 8001:
                                        zzac((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                        break;
                                    case 8002:
                                        zza(parcel.readInt(), (Bundle) com.google.android.gms.internal.games.zzc.zza(parcel, Bundle.CREATOR));
                                        break;
                                    case 8003:
                                        zzn((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                        break;
                                    case ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED /* 8004 */:
                                        zzo((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                        break;
                                    case ConnectionsStatusCodes.STATUS_NOT_CONNECTED_TO_ENDPOINT /* 8005 */:
                                        zzp((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                        break;
                                    case 8006:
                                        zzq((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                        break;
                                    case ConnectionsStatusCodes.STATUS_BLUETOOTH_ERROR /* 8007 */:
                                        zzc(parcel.readInt(), parcel.readString());
                                        break;
                                    case ConnectionsStatusCodes.STATUS_ALREADY_HAVE_ACTIVE_STRATEGY /* 8008 */:
                                        zzr((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                        break;
                                    case ConnectionsStatusCodes.STATUS_OUT_OF_ORDER_API_CALL /* 8009 */:
                                        onTurnBasedMatchRemoved(parcel.readString());
                                        break;
                                    case 8010:
                                        onInvitationRemoved(parcel.readString());
                                        break;
                                    default:
                                        switch (i) {
                                            case 10001:
                                                zzm((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                break;
                                            case GamesActivityResultCodes.RESULT_SIGN_IN_FAILED /* 10002 */:
                                                onRequestRemoved(parcel.readString());
                                                break;
                                            case GamesActivityResultCodes.RESULT_LICENSE_FAILED /* 10003 */:
                                                zzad((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                break;
                                            case GamesActivityResultCodes.RESULT_APP_MISCONFIGURED /* 10004 */:
                                                zzae((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                break;
                                            case GamesActivityResultCodes.RESULT_LEFT_ROOM /* 10005 */:
                                                zzb(parcel.readInt(), (Bundle) com.google.android.gms.internal.games.zzc.zza(parcel, Bundle.CREATOR));
                                                break;
                                            case GamesActivityResultCodes.RESULT_NETWORK_FAILURE /* 10006 */:
                                                zzaf((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                break;
                                            default:
                                                switch (i) {
                                                    case 12004:
                                                        zza((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR), (Contents) com.google.android.gms.internal.games.zzc.zza(parcel, Contents.CREATOR));
                                                        break;
                                                    case 12005:
                                                        zzah((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                        break;
                                                    case 12006:
                                                        zzai((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                        break;
                                                    case 12007:
                                                        zzaj((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                        break;
                                                    case 12008:
                                                        zzam((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                        break;
                                                    default:
                                                        switch (i) {
                                                            case 12011:
                                                                zzb((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                break;
                                                            case 12012:
                                                                zzd(parcel.readInt(), parcel.readString());
                                                                break;
                                                            default:
                                                                switch (i) {
                                                                    case 12014:
                                                                        zzak((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                        break;
                                                                    case 12015:
                                                                        zzd(parcel.readInt(), (Bundle) com.google.android.gms.internal.games.zzc.zza(parcel, Bundle.CREATOR));
                                                                        break;
                                                                    case 12016:
                                                                        zzal((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                        break;
                                                                    case 12017:
                                                                        zza((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR), parcel.readString(), (Contents) com.google.android.gms.internal.games.zzc.zza(parcel, Contents.CREATOR), (Contents) com.google.android.gms.internal.games.zzc.zza(parcel, Contents.CREATOR), (Contents) com.google.android.gms.internal.games.zzc.zza(parcel, Contents.CREATOR));
                                                                        break;
                                                                    default:
                                                                        switch (i) {
                                                                            case 13001:
                                                                                zzan((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                                break;
                                                                            case 13002:
                                                                                zze(parcel.readInt());
                                                                                break;
                                                                            default:
                                                                                switch (i) {
                                                                                    case 19001:
                                                                                        zza(parcel.readInt(), (VideoCapabilities) com.google.android.gms.internal.games.zzc.zza(parcel, VideoCapabilities.CREATOR));
                                                                                        break;
                                                                                    case 19002:
                                                                                        zza(parcel.readInt(), com.google.android.gms.internal.games.zzc.zza(parcel));
                                                                                        break;
                                                                                    default:
                                                                                        switch (i) {
                                                                                            case 19008:
                                                                                                zzg(parcel.readInt());
                                                                                                break;
                                                                                            case 19009:
                                                                                                zzh(parcel.readInt());
                                                                                                break;
                                                                                            case 19010:
                                                                                                zzi(parcel.readInt());
                                                                                                break;
                                                                                            default:
                                                                                                switch (i) {
                                                                                                    case NetErrConstants.ERROR_NETWORK_CONTIMEOUT /* 20001 */:
                                                                                                        zzap((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                                                        break;
                                                                                                    case NetErrConstants.ERROR_NETWORK_READTIMEOUT /* 20002 */:
                                                                                                        zzaq((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                                                        break;
                                                                                                    case 20003:
                                                                                                        zzar((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                                                        break;
                                                                                                    case 20004:
                                                                                                        zzas((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                                                        break;
                                                                                                    case NetErrConstants.ERROR_NETWORK_IOEXCEPTION /* 20005 */:
                                                                                                        zzat((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                                                        break;
                                                                                                    case 20006:
                                                                                                        zzau((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                                                        break;
                                                                                                    case 20007:
                                                                                                        zzav((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                                                        break;
                                                                                                    case 20008:
                                                                                                        zzaw((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                                                        break;
                                                                                                    case 20009:
                                                                                                        zzax((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                                                        break;
                                                                                                    default:
                                                                                                        switch (i) {
                                                                                                            case 20019:
                                                                                                                onCaptureOverlayStateChanged(parcel.readInt());
                                                                                                                break;
                                                                                                            case 20020:
                                                                                                                zze(parcel.readInt(), (Bundle) com.google.android.gms.internal.games.zzc.zza(parcel, Bundle.CREATOR));
                                                                                                                break;
                                                                                                            default:
                                                                                                                switch (i) {
                                                                                                                    case GamesStatusCodes.STATUS_VIDEO_UNSUPPORTED /* 9001 */:
                                                                                                                        zzj((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                                                                        break;
                                                                                                                    case 11001:
                                                                                                                        zzc(parcel.readInt(), (Bundle) com.google.android.gms.internal.games.zzc.zza(parcel, Bundle.CREATOR));
                                                                                                                        break;
                                                                                                                    case 12001:
                                                                                                                        zzag((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                                                                        break;
                                                                                                                    case 14001:
                                                                                                                        zza((DataHolder[]) parcel.createTypedArray(DataHolder.CREATOR));
                                                                                                                        break;
                                                                                                                    case 15001:
                                                                                                                        zzao((DataHolder) com.google.android.gms.internal.games.zzc.zza(parcel, DataHolder.CREATOR));
                                                                                                                        break;
                                                                                                                    case FirebaseError.ERROR_CUSTOM_TOKEN_MISMATCH /* 17002 */:
                                                                                                                        zzf(parcel.readInt());
                                                                                                                        break;
                                                                                                                    case 20012:
                                                                                                                        zzc((Status) com.google.android.gms.internal.games.zzc.zza(parcel, Status.CREATOR));
                                                                                                                        break;
                                                                                                                    case 23001:
                                                                                                                        zzj(parcel.readInt());
                                                                                                                        break;
                                                                                                                    default:
                                                                                                                        return false;
                                                                                                                }
                                                                                                        }
                                                                                                }
                                                                                        }
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
        parcel2.writeNoException();
        return true;
    }
}
