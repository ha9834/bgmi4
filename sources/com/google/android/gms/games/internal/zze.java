package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.FirstPartyScopes;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.DataHolderResult;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomEntity;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestEntity;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotContentsEntity;
import com.google.android.gms.games.snapshot.SnapshotEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataEntity;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.PlayerStats;
import com.google.android.gms.games.stats.PlayerStatsBuffer;
import com.google.android.gms.games.stats.PlayerStatsEntity;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.internal.games.zzeh;
import com.google.android.gms.internal.games.zzej;
import com.google.android.gms.internal.games.zzek;
import com.google.android.gms.signin.internal.SignInClientImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class zze extends GmsClient<zzbu> {
    private final zzej d;
    private final String e;
    private PlayerEntity f;
    private GameEntity g;
    private final zzby h;
    private boolean i;
    private final Binder j;
    private final long k;
    private boolean l;
    private final Games.GamesOptions m;
    private Bundle n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface aa<T> {
        void a(T t, int i, Room room);
    }

    /* loaded from: classes.dex */
    private static final class aj extends af implements TurnBasedMultiplayer.UpdateMatchResult {
        aj(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    /* loaded from: classes.dex */
    private static abstract class au extends DataHolderResult {
        au(DataHolder dataHolder) {
            super(dataHolder, GamesStatusCodes.zza(dataHolder.getStatusCode()));
        }
    }

    /* loaded from: classes.dex */
    private static final class aw extends af implements TurnBasedMultiplayer.InitiateMatchResult {
        aw(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b extends af implements TurnBasedMultiplayer.LoadMatchResult {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    /* loaded from: classes.dex */
    private static final class bc extends af implements TurnBasedMultiplayer.LeaveMatchResult {
        bc(DataHolder dataHolder) {
            super(dataHolder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface q<T> {
        void a(T t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface w<T> {
        void a(T t, Room room, ArrayList<String> arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface x<T> {
        void a(T t, Room room);
    }

    public zze(Context context, Looper looper, ClientSettings clientSettings, Games.GamesOptions gamesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 1, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.d = new com.google.android.gms.games.internal.ak(this);
        this.i = false;
        this.l = false;
        this.e = clientSettings.getRealClientPackageName();
        this.j = new Binder();
        this.h = zzby.zza(this, clientSettings.getGravityForPopups());
        this.k = hashCode();
        this.m = gamesOptions;
        if (this.m.zzaz) {
            return;
        }
        if (clientSettings.getViewForPopups() != null || (context instanceof Activity)) {
            zza(clientSettings.getViewForPopups());
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected String a() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public boolean requiresSignIn() {
        return true;
    }

    /* loaded from: classes.dex */
    private static final class ab extends u<Achievements.UpdateAchievementResult> {
        ab(BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzb(int i, String str) {
            a(new ai(i, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ad extends u<TurnBasedMultiplayer.InitiateMatchResult> {
        ad(BaseImplementation.ResultHolder<TurnBasedMultiplayer.InitiateMatchResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzo(DataHolder dataHolder) {
            a(new aw(dataHolder));
        }
    }

    /* loaded from: classes.dex */
    private static final class ae extends u<TurnBasedMultiplayer.LeaveMatchResult> {
        ae(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LeaveMatchResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzq(DataHolder dataHolder) {
            a(new bc(dataHolder));
        }
    }

    /* loaded from: classes.dex */
    private static final class ag extends u<TurnBasedMultiplayer.UpdateMatchResult> {
        ag(BaseImplementation.ResultHolder<TurnBasedMultiplayer.UpdateMatchResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzp(DataHolder dataHolder) {
            a(new aj(dataHolder));
        }
    }

    /* loaded from: classes.dex */
    private static final class ah extends u<TurnBasedMultiplayer.LoadMatchesResult> {
        ah(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LoadMatchesResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zza(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            a(new c(GamesStatusCodes.zza(i), bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class as extends u<Events.LoadEventsResult> {
        as(BaseImplementation.ResultHolder<Events.LoadEventsResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzb(DataHolder dataHolder) {
            a(new bg(dataHolder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ax extends bd<OnInvitationReceivedListener> {
        ax(ListenerHolder<OnInvitationReceivedListener> listenerHolder) {
            super(listenerHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzl(DataHolder dataHolder) {
            InvitationBuffer invitationBuffer = new InvitationBuffer(dataHolder);
            try {
                final Invitation freeze = invitationBuffer.getCount() > 0 ? invitationBuffer.get(0).freeze() : null;
                if (freeze != null) {
                    a(new q(freeze) { // from class: com.google.android.gms.games.internal.e

                        /* renamed from: a, reason: collision with root package name */
                        private final Invitation f1665a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f1665a = freeze;
                        }

                        @Override // com.google.android.gms.games.internal.zze.q
                        public final void a(Object obj) {
                            ((OnInvitationReceivedListener) obj).onInvitationReceived(this.f1665a);
                        }
                    });
                }
            } finally {
                invitationBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void onInvitationRemoved(final String str) {
            a(new q(str) { // from class: com.google.android.gms.games.internal.f

                /* renamed from: a, reason: collision with root package name */
                private final String f1667a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f1667a = str;
                }

                @Override // com.google.android.gms.games.internal.zze.q
                public final void a(Object obj) {
                    ((OnInvitationReceivedListener) obj).onInvitationRemoved(this.f1667a);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    private static final class ay extends u<Invitations.LoadInvitationsResult> {
        ay(BaseImplementation.ResultHolder<Invitations.LoadInvitationsResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzk(DataHolder dataHolder) {
            a(new bi(dataHolder));
        }
    }

    /* loaded from: classes.dex */
    private static final class ba extends u<Leaderboards.LoadScoresResult> {
        ba(BaseImplementation.ResultHolder<Leaderboards.LoadScoresResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zza(DataHolder dataHolder, DataHolder dataHolder2) {
            a(new i(dataHolder, dataHolder2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class bb extends u<Leaderboards.LeaderboardMetadataResult> {
        bb(BaseImplementation.ResultHolder<Leaderboards.LeaderboardMetadataResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzc(DataHolder dataHolder) {
            a(new az(dataHolder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class be<T> implements ListenerHolder.Notifier<T> {
        private be() {
        }

        @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
        public void onNotifyListenerFailed() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ be(com.google.android.gms.games.internal.ak akVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    private static final class g extends au implements Quests.LoadQuestsResult {
        g(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.quest.Quests.LoadQuestsResult
        public final QuestBuffer getQuests() {
            return new QuestBuffer(this.b);
        }
    }

    /* loaded from: classes.dex */
    private static final class j extends au implements Snapshots.LoadSnapshotsResult {
        j(DataHolder dataHolder) {
            super(dataHolder);
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult
        public final SnapshotMetadataBuffer getSnapshots() {
            return new SnapshotMetadataBuffer(this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class k extends bd<OnTurnBasedMatchUpdateReceivedListener> {
        k(ListenerHolder<OnTurnBasedMatchUpdateReceivedListener> listenerHolder) {
            super(listenerHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzr(DataHolder dataHolder) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                final TurnBasedMatch freeze = turnBasedMatchBuffer.getCount() > 0 ? turnBasedMatchBuffer.get(0).freeze() : null;
                if (freeze != null) {
                    a(new q(freeze) { // from class: com.google.android.gms.games.internal.g

                        /* renamed from: a, reason: collision with root package name */
                        private final TurnBasedMatch f1668a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f1668a = freeze;
                        }

                        @Override // com.google.android.gms.games.internal.zze.q
                        public final void a(Object obj) {
                            ((OnTurnBasedMatchUpdateReceivedListener) obj).onTurnBasedMatchReceived(this.f1668a);
                        }
                    });
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void onTurnBasedMatchRemoved(final String str) {
            a(new q(str) { // from class: com.google.android.gms.games.internal.h

                /* renamed from: a, reason: collision with root package name */
                private final String f1671a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f1671a = str;
                }

                @Override // com.google.android.gms.games.internal.zze.q
                public final void a(Object obj) {
                    ((OnTurnBasedMatchUpdateReceivedListener) obj).onTurnBasedMatchRemoved(this.f1671a);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    private static final class l extends au implements Snapshots.OpenSnapshotResult {
        private final Snapshot c;
        private final String d;
        private final Snapshot e;
        private final SnapshotContents f;

        l(DataHolder dataHolder, Contents contents) {
            this(dataHolder, null, contents, null, null);
        }

        l(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() == 0) {
                    this.c = null;
                    this.e = null;
                } else {
                    boolean z = true;
                    if (snapshotMetadataBuffer.getCount() == 1) {
                        if (dataHolder.getStatusCode() == 4004) {
                            z = false;
                        }
                        Asserts.checkState(z);
                        this.c = new SnapshotEntity(new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                        this.e = null;
                    } else {
                        this.c = new SnapshotEntity(new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(0)), new SnapshotContentsEntity(contents));
                        this.e = new SnapshotEntity(new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(1)), new SnapshotContentsEntity(contents2));
                    }
                }
                snapshotMetadataBuffer.release();
                this.d = str;
                this.f = new SnapshotContentsEntity(contents3);
            } catch (Throwable th) {
                snapshotMetadataBuffer.release();
                throw th;
            }
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public final Snapshot getSnapshot() {
            return this.c;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public final String getConflictId() {
            return this.d;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public final Snapshot getConflictingSnapshot() {
            return this.e;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult
        public final SnapshotContents getResolutionSnapshotContents() {
            return this.f;
        }
    }

    /* loaded from: classes.dex */
    private static final class m extends u<Players.LoadPlayersResult> {
        m(BaseImplementation.ResultHolder<Players.LoadPlayersResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zze(DataHolder dataHolder) {
            a(new f(dataHolder));
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzf(DataHolder dataHolder) {
            a(new f(dataHolder));
        }
    }

    /* loaded from: classes.dex */
    private static final class n extends bd<QuestUpdateListener> {
        n(ListenerHolder<QuestUpdateListener> listenerHolder) {
            super(listenerHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzak(DataHolder dataHolder) {
            final Quest a2 = a(dataHolder);
            if (a2 != null) {
                a(new q(a2) { // from class: com.google.android.gms.games.internal.i

                    /* renamed from: a, reason: collision with root package name */
                    private final Quest f1672a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f1672a = a2;
                    }

                    @Override // com.google.android.gms.games.internal.zze.q
                    public final void a(Object obj) {
                        ((QuestUpdateListener) obj).onQuestCompleted(this.f1672a);
                    }
                });
            }
        }

        private static Quest a(DataHolder dataHolder) {
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                return questBuffer.getCount() > 0 ? questBuffer.get(0).freeze() : null;
            } finally {
                questBuffer.release();
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class o extends u<Quests.LoadQuestsResult> {
        o(BaseImplementation.ResultHolder<Quests.LoadQuestsResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzam(DataHolder dataHolder) {
            a(new g(dataHolder));
        }
    }

    /* loaded from: classes.dex */
    private static final class r extends bd<OnRequestReceivedListener> {
        r(ListenerHolder<OnRequestReceivedListener> listenerHolder) {
            super(listenerHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzm(DataHolder dataHolder) {
            GameRequestBuffer gameRequestBuffer = new GameRequestBuffer(dataHolder);
            try {
                final GameRequest freeze = gameRequestBuffer.getCount() > 0 ? gameRequestBuffer.get(0).freeze() : null;
                if (freeze != null) {
                    a(new q(freeze) { // from class: com.google.android.gms.games.internal.k

                        /* renamed from: a, reason: collision with root package name */
                        private final GameRequest f1674a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f1674a = freeze;
                        }

                        @Override // com.google.android.gms.games.internal.zze.q
                        public final void a(Object obj) {
                            ((OnRequestReceivedListener) obj).onRequestReceived(this.f1674a);
                        }
                    });
                }
            } finally {
                gameRequestBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void onRequestRemoved(final String str) {
            a(new q(str) { // from class: com.google.android.gms.games.internal.l

                /* renamed from: a, reason: collision with root package name */
                private final String f1675a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f1675a = str;
                }

                @Override // com.google.android.gms.games.internal.zze.q
                public final void a(Object obj) {
                    ((OnRequestReceivedListener) obj).onRequestRemoved(this.f1675a);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    private static final class s extends u<Requests.LoadRequestsResult> {
        s(BaseImplementation.ResultHolder<Requests.LoadRequestsResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzb(int i, Bundle bundle) {
            bundle.setClassLoader(getClass().getClassLoader());
            a(new h(GamesStatusCodes.zza(i), bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class t extends u<Requests.UpdateRequestsResult> {
        t(BaseImplementation.ResultHolder<Requests.UpdateRequestsResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzad(DataHolder dataHolder) {
            a(new ak(dataHolder));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class v extends zza {

        /* renamed from: a, reason: collision with root package name */
        private final ListenerHolder<? extends RoomUpdateListener> f1711a;
        private final ListenerHolder<? extends RoomStatusUpdateListener> b;
        private final ListenerHolder<? extends RealTimeMessageReceivedListener> c;

        v(ListenerHolder<? extends RoomUpdateListener> listenerHolder) {
            this(listenerHolder, null, null);
        }

        v(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3) {
            this.f1711a = (ListenerHolder) Preconditions.checkNotNull(listenerHolder, "Callbacks must not be null");
            this.b = listenerHolder2;
            this.c = listenerHolder3;
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzs(DataHolder dataHolder) {
            this.f1711a.notifyListener(zze.b(dataHolder, com.google.android.gms.games.internal.m.f1676a));
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzt(DataHolder dataHolder) {
            this.f1711a.notifyListener(zze.b(dataHolder, com.google.android.gms.games.internal.n.f1677a));
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void onLeftRoom(final int i, final String str) {
            this.f1711a.notifyListener(zze.b(new q(i, str) { // from class: com.google.android.gms.games.internal.v

                /* renamed from: a, reason: collision with root package name */
                private final int f1689a;
                private final String b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f1689a = i;
                    this.b = str;
                }

                @Override // com.google.android.gms.games.internal.zze.q
                public final void a(Object obj) {
                    ((RoomUpdateListener) obj).onLeftRoom(this.f1689a, this.b);
                }
            }));
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzw(DataHolder dataHolder) {
            this.f1711a.notifyListener(zze.b(dataHolder, com.google.android.gms.games.internal.w.f1690a));
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzu(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.b;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.b(dataHolder, com.google.android.gms.games.internal.x.f1691a));
            }
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzv(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.b;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.b(dataHolder, com.google.android.gms.games.internal.y.f1692a));
            }
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzx(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.b;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.b(dataHolder, com.google.android.gms.games.internal.z.f1693a));
            }
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzy(DataHolder dataHolder) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.b;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.b(dataHolder, com.google.android.gms.games.internal.aa.f1647a));
            }
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zze(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.b;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.b(dataHolder, strArr, com.google.android.gms.games.internal.ab.f1648a));
            }
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzf(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.b;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.b(dataHolder, strArr, com.google.android.gms.games.internal.ac.f1649a));
            }
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zza(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.b;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.b(dataHolder, strArr, com.google.android.gms.games.internal.o.f1678a));
            }
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzb(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.b;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.b(dataHolder, strArr, com.google.android.gms.games.internal.p.f1679a));
            }
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzc(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.b;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.b(dataHolder, strArr, com.google.android.gms.games.internal.q.f1684a));
            }
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzd(DataHolder dataHolder, String[] strArr) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.b;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.b(dataHolder, strArr, com.google.android.gms.games.internal.r.f1685a));
            }
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void onP2PConnected(final String str) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.b;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.b(new q(str) { // from class: com.google.android.gms.games.internal.s

                    /* renamed from: a, reason: collision with root package name */
                    private final String f1686a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f1686a = str;
                    }

                    @Override // com.google.android.gms.games.internal.zze.q
                    public final void a(Object obj) {
                        ((RoomStatusUpdateListener) obj).onP2PConnected(this.f1686a);
                    }
                }));
            }
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void onP2PDisconnected(final String str) {
            ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder = this.b;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.b(new q(str) { // from class: com.google.android.gms.games.internal.t

                    /* renamed from: a, reason: collision with root package name */
                    private final String f1687a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f1687a = str;
                    }

                    @Override // com.google.android.gms.games.internal.zze.q
                    public final void a(Object obj) {
                        ((RoomStatusUpdateListener) obj).onP2PDisconnected(this.f1687a);
                    }
                }));
            }
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void onRealTimeMessageReceived(final RealTimeMessage realTimeMessage) {
            ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder = this.c;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.b(new q(realTimeMessage) { // from class: com.google.android.gms.games.internal.u

                    /* renamed from: a, reason: collision with root package name */
                    private final RealTimeMessage f1688a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f1688a = realTimeMessage;
                    }

                    @Override // com.google.android.gms.games.internal.zze.q
                    public final void a(Object obj) {
                        ((RealTimeMessageReceivedListener) obj).onRealTimeMessageReceived(this.f1688a);
                    }
                }));
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class y extends u<Snapshots.OpenSnapshotResult> {
        y(BaseImplementation.ResultHolder<Snapshots.OpenSnapshotResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zza(DataHolder dataHolder, Contents contents) {
            a(new l(dataHolder, contents));
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) {
            a(new l(dataHolder, str, contents, contents2, contents3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class z extends u<Snapshots.LoadSnapshotsResult> {
        z(BaseImplementation.ResultHolder<Snapshots.LoadSnapshotsResult> resultHolder) {
            super(resultHolder);
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zzag(DataHolder dataHolder) {
            a(new j(dataHolder));
        }
    }

    /* loaded from: classes.dex */
    private static final class ak extends au implements Requests.UpdateRequestsResult {
        private final zzek c;

        ak(DataHolder dataHolder) {
            super(dataHolder);
            this.c = zzek.zzbb(dataHolder);
        }

        @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
        public final int getRequestOutcome(String str) {
            return this.c.getRequestOutcome(str);
        }

        @Override // com.google.android.gms.games.request.Requests.UpdateRequestsResult
        public final Set<String> getRequestIds() {
            return this.c.getRequestIds();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class at extends zzeh {
        /* JADX INFO: Access modifiers changed from: package-private */
        public at() {
            super(zze.this.getContext().getMainLooper(), 1000);
        }

        @Override // com.google.android.gms.internal.games.zzeh
        protected final void a(String str, int i) {
            try {
                if (zze.this.isConnected()) {
                    ((zzbu) zze.this.getService()).zza(str, i);
                    return;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 89);
                sb.append("Unable to increment event ");
                sb.append(str);
                sb.append(" by ");
                sb.append(i);
                sb.append(" because the games client is no longer connected");
                zzbd.e("GamesClientImpl", sb.toString());
            } catch (RemoteException e) {
                zze zzeVar = zze.this;
                zze.a(e);
            } catch (SecurityException e2) {
                zze zzeVar2 = zze.this;
                zze.a(e2);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class az extends au implements Leaderboards.LeaderboardMetadataResult {
        private final LeaderboardBuffer c;

        az(DataHolder dataHolder) {
            super(dataHolder);
            this.c = new LeaderboardBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult
        public final LeaderboardBuffer getLeaderboards() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class bd<T> extends zza {

        /* renamed from: a, reason: collision with root package name */
        private final ListenerHolder<T> f1706a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public bd(ListenerHolder<T> listenerHolder) {
            this.f1706a = (ListenerHolder) Preconditions.checkNotNull(listenerHolder, "Callback must not be null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void a(q<T> qVar) {
            this.f1706a.notifyListener(zze.b(qVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class bf extends au implements Achievements.LoadAchievementsResult {
        private final AchievementBuffer c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public bf(DataHolder dataHolder) {
            super(dataHolder);
            this.c = new AchievementBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult
        public final AchievementBuffer getAchievements() {
            return this.c;
        }
    }

    /* loaded from: classes.dex */
    private static final class bg extends au implements Events.LoadEventsResult {
        private final EventBuffer c;

        bg(DataHolder dataHolder) {
            super(dataHolder);
            this.c = new EventBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.event.Events.LoadEventsResult
        public final EventBuffer getEvents() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class bh extends au implements GamesMetadata.LoadGamesResult {
        private final GameBuffer c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public bh(DataHolder dataHolder) {
            super(dataHolder);
            this.c = new GameBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.GamesMetadata.LoadGamesResult
        public final GameBuffer getGames() {
            return this.c;
        }
    }

    /* loaded from: classes.dex */
    private static final class bi extends au implements Invitations.LoadInvitationsResult {
        private final InvitationBuffer c;

        bi(DataHolder dataHolder) {
            super(dataHolder);
            this.c = new InvitationBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.multiplayer.Invitations.LoadInvitationsResult
        public final InvitationBuffer getInvitations() {
            return this.c;
        }
    }

    /* loaded from: classes.dex */
    private static final class f extends au implements Players.LoadPlayersResult {
        private final PlayerBuffer c;

        f(DataHolder dataHolder) {
            super(dataHolder);
            this.c = new PlayerBuffer(dataHolder);
        }

        @Override // com.google.android.gms.games.Players.LoadPlayersResult
        public final PlayerBuffer getPlayers() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class p extends zza {

        /* renamed from: a, reason: collision with root package name */
        private final ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback> f1709a;

        p(ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback> listenerHolder) {
            this.f1709a = listenerHolder;
        }

        @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzbq
        public final void zza(final int i, final int i2, final String str) {
            ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback> listenerHolder = this.f1709a;
            if (listenerHolder != null) {
                listenerHolder.notifyListener(zze.b(new q(i, i2, str) { // from class: com.google.android.gms.games.internal.j

                    /* renamed from: a, reason: collision with root package name */
                    private final int f1673a;
                    private final int b;
                    private final String c;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f1673a = i;
                        this.b = i2;
                        this.c = str;
                    }

                    @Override // com.google.android.gms.games.internal.zze.q
                    public final void a(Object obj) {
                        ((RealTimeMultiplayer.ReliableMessageSentCallback) obj).onRealTimeMessageSent(this.f1673a, this.b, this.c);
                    }
                }));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class u<T> extends zza {

        /* renamed from: a, reason: collision with root package name */
        private final BaseImplementation.ResultHolder<T> f1710a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public u(BaseImplementation.ResultHolder<T> resultHolder) {
            this.f1710a = (BaseImplementation.ResultHolder) Preconditions.checkNotNull(resultHolder, "Holder must not be null");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void a(T t) {
            this.f1710a.setResult(t);
        }
    }

    /* loaded from: classes.dex */
    private static final class ai implements Achievements.UpdateAchievementResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f1698a;
        private final String b;

        ai(int i, String str) {
            this.f1698a = GamesStatusCodes.zza(i);
            this.b = str;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.f1698a;
        }

        @Override // com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult
        public final String getAchievementId() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class al implements TurnBasedMultiplayer.CancelMatchResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f1699a;
        private final String b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public al(Status status, String str) {
            this.f1699a = status;
            this.b = str;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.f1699a;
        }

        @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult
        public final String getMatchId() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class am implements Videos.CaptureAvailableResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f1700a;
        private final boolean b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public am(Status status, boolean z) {
            this.f1700a = status;
            this.b = z;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.f1700a;
        }

        @Override // com.google.android.gms.games.video.Videos.CaptureAvailableResult
        public final boolean isAvailable() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class an implements Videos.CaptureCapabilitiesResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f1701a;
        private final VideoCapabilities b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public an(Status status, VideoCapabilities videoCapabilities) {
            this.f1701a = status;
            this.b = videoCapabilities;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.f1701a;
        }

        @Override // com.google.android.gms.games.video.Videos.CaptureCapabilitiesResult
        public final VideoCapabilities getCapabilities() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ao implements Videos.CaptureStateResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f1702a;
        private final CaptureState b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ao(Status status, CaptureState captureState) {
            this.f1702a = status;
            this.b = captureState;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.f1702a;
        }

        @Override // com.google.android.gms.games.video.Videos.CaptureStateResult
        public final CaptureState getCaptureState() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ar implements Snapshots.DeleteSnapshotResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f1703a;
        private final String b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ar(int i, String str) {
            this.f1703a = GamesStatusCodes.zza(i);
            this.b = str;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.f1703a;
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult
        public final String getSnapshotId() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class av implements Games.GetServerAuthCodeResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f1705a;
        private final String b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public av(Status status, String str) {
            this.f1705a = status;
            this.b = str;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.f1705a;
        }

        @Override // com.google.android.gms.games.Games.GetServerAuthCodeResult
        public final String getCode() {
            return this.b;
        }
    }

    /* loaded from: classes.dex */
    private static final class c implements TurnBasedMultiplayer.LoadMatchesResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f1707a;
        private final LoadMatchesResponse b;

        c(Status status, Bundle bundle) {
            this.f1707a = status;
            this.b = new LoadMatchesResponse(bundle);
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.f1707a;
        }

        @Override // com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult
        public final LoadMatchesResponse getMatches() {
            return this.b;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public final void release() {
            this.b.release();
        }
    }

    /* loaded from: classes.dex */
    private static final class h implements Requests.LoadRequestsResult {

        /* renamed from: a, reason: collision with root package name */
        private final Status f1708a;
        private final Bundle b;

        h(Status status, Bundle bundle) {
            this.f1708a = status;
            this.b = bundle;
        }

        @Override // com.google.android.gms.common.api.Result
        public final Status getStatus() {
            return this.f1708a;
        }

        @Override // com.google.android.gms.games.request.Requests.LoadRequestsResult
        public final GameRequestBuffer getRequests(int i) {
            String str;
            switch (i) {
                case 1:
                    str = "GIFT";
                    break;
                case 2:
                    str = "WISH";
                    break;
                default:
                    StringBuilder sb = new StringBuilder(33);
                    sb.append("Unknown request type: ");
                    sb.append(i);
                    zzbd.e("RequestType", sb.toString());
                    str = "UNKNOWN_TYPE";
                    break;
            }
            if (this.b.containsKey(str)) {
                return new GameRequestBuffer((DataHolder) this.b.get(str));
            }
            return null;
        }

        @Override // com.google.android.gms.common.api.Releasable
        public final void release() {
            Iterator<String> it = this.b.keySet().iterator();
            while (it.hasNext()) {
                DataHolder dataHolder = (DataHolder) this.b.getParcelable(it.next());
                if (dataHolder != null) {
                    dataHolder.close();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ac extends au implements Leaderboards.SubmitScoreResult {
        private final ScoreSubmissionData c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ac(DataHolder dataHolder) {
            super(dataHolder);
            try {
                this.c = new ScoreSubmissionData(dataHolder);
            } finally {
                dataHolder.close();
            }
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult
        public final ScoreSubmissionData getScoreData() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a extends au implements Quests.AcceptQuestResult {
        private final Quest c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(DataHolder dataHolder) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.c = new QuestEntity(questBuffer.get(0));
                } else {
                    this.c = null;
                }
            } finally {
                questBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.quest.Quests.AcceptQuestResult
        public final Quest getQuest() {
            return this.c;
        }
    }

    /* loaded from: classes.dex */
    private static abstract class af extends au {
        private final TurnBasedMatch c;

        af(DataHolder dataHolder) {
            super(dataHolder);
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.c = turnBasedMatchBuffer.get(0).freeze();
                } else {
                    this.c = null;
                }
            } finally {
                turnBasedMatchBuffer.release();
            }
        }

        public TurnBasedMatch getMatch() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class aq extends au implements Snapshots.CommitSnapshotResult {
        private final SnapshotMetadata c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public aq(DataHolder dataHolder) {
            super(dataHolder);
            SnapshotMetadataBuffer snapshotMetadataBuffer = new SnapshotMetadataBuffer(dataHolder);
            try {
                if (snapshotMetadataBuffer.getCount() > 0) {
                    this.c = new SnapshotMetadataEntity((SnapshotMetadata) snapshotMetadataBuffer.get(0));
                } else {
                    this.c = null;
                }
            } finally {
                snapshotMetadataBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult
        public final SnapshotMetadata getSnapshotMetadata() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d extends au implements Leaderboards.LoadPlayerScoreResult {
        private final LeaderboardScoreEntity c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(DataHolder dataHolder) {
            super(dataHolder);
            LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
            try {
                if (leaderboardScoreBuffer.getCount() > 0) {
                    this.c = (LeaderboardScoreEntity) ((LeaderboardScore) leaderboardScoreBuffer.get(0)).freeze();
                } else {
                    this.c = null;
                }
            } finally {
                leaderboardScoreBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult
        public final LeaderboardScore getScore() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class e extends au implements Stats.LoadPlayerStatsResult {
        private final PlayerStats c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(DataHolder dataHolder) {
            super(dataHolder);
            PlayerStatsBuffer playerStatsBuffer = new PlayerStatsBuffer(dataHolder);
            try {
                if (playerStatsBuffer.getCount() > 0) {
                    this.c = new PlayerStatsEntity((PlayerStats) playerStatsBuffer.get(0));
                } else {
                    this.c = null;
                }
            } finally {
                playerStatsBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult
        public final PlayerStats getPlayerStats() {
            return this.c;
        }
    }

    /* loaded from: classes.dex */
    private static final class i extends au implements Leaderboards.LoadScoresResult {
        private final LeaderboardEntity c;
        private final LeaderboardScoreBuffer d;

        i(DataHolder dataHolder, DataHolder dataHolder2) {
            super(dataHolder2);
            LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
            try {
                if (leaderboardBuffer.getCount() > 0) {
                    this.c = (LeaderboardEntity) leaderboardBuffer.get(0).freeze();
                } else {
                    this.c = null;
                }
                leaderboardBuffer.release();
                this.d = new LeaderboardScoreBuffer(dataHolder2);
            } catch (Throwable th) {
                leaderboardBuffer.release();
                throw th;
            }
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
        public final Leaderboard getLeaderboard() {
            return this.c;
        }

        @Override // com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult
        public final LeaderboardScoreBuffer getScores() {
            return this.d;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ap extends au implements Quests.ClaimMilestoneResult {
        private final Milestone c;
        private final Quest d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ap(DataHolder dataHolder, String str) {
            super(dataHolder);
            QuestBuffer questBuffer = new QuestBuffer(dataHolder);
            try {
                if (questBuffer.getCount() > 0) {
                    this.d = new QuestEntity(questBuffer.get(0));
                    List<Milestone> zzdq = this.d.zzdq();
                    int size = zzdq.size();
                    for (int i = 0; i < size; i++) {
                        if (zzdq.get(i).getMilestoneId().equals(str)) {
                            this.c = zzdq.get(i);
                            return;
                        }
                    }
                    this.c = null;
                } else {
                    this.c = null;
                    this.d = null;
                }
            } finally {
                questBuffer.release();
            }
        }

        @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
        public final Milestone getMilestone() {
            return this.c;
        }

        @Override // com.google.android.gms.games.quest.Quests.ClaimMilestoneResult
        public final Quest getQuest() {
            return this.d;
        }
    }

    public final void zzk(int i2) {
        this.h.setGravity(i2);
    }

    public final void zza(View view) {
        this.h.zzb(view);
    }

    @Override // com.google.android.gms.common.internal.GmsClient
    protected Set<Scope> a(Set<Scope> set) {
        HashSet hashSet = new HashSet(set);
        boolean contains = set.contains(Games.SCOPE_GAMES);
        boolean contains2 = set.contains(Games.SCOPE_GAMES_LITE);
        if (set.contains(Games.zzam)) {
            Preconditions.checkState(!contains, "Cannot have both %s and %s!", Scopes.GAMES, FirstPartyScopes.GAMES_1P);
        } else {
            Preconditions.checkState(contains || contains2, "Games APIs requires %s function.", Scopes.GAMES_LITE);
            if (contains2 && contains) {
                hashSet.remove(Games.SCOPE_GAMES_LITE);
            }
        }
        return hashSet;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.f = null;
        this.g = null;
        super.connect(connectionProgressReportCallbacks);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public void disconnect() {
        this.i = false;
        if (isConnected()) {
            try {
                zzbu zzbuVar = (zzbu) getService();
                zzbuVar.zzci();
                this.d.flush();
                zzbuVar.zza(this.k);
            } catch (RemoteException unused) {
                zzbd.w("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState
    public Bundle getConnectionHint() {
        try {
            Bundle connectionHint = ((zzbu) getService()).getConnectionHint();
            if (connectionHint != null) {
                connectionHint.setClassLoader(zze.class.getClassLoader());
                this.n = connectionHint;
            }
            return connectionHint;
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final Bundle zzat() {
        Bundle connectionHint = getConnectionHint();
        if (connectionHint == null) {
            connectionHint = this.n;
        }
        this.n = null;
        return connectionHint;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected Bundle d() {
        String locale = getContext().getResources().getConfiguration().locale.toString();
        Bundle zzg = this.m.zzg();
        zzg.putString(ServiceSpecificExtraArgs.GamesExtraArgs.GAME_PACKAGE_NAME, this.e);
        zzg.putString(ServiceSpecificExtraArgs.GamesExtraArgs.DESIRED_LOCALE, locale);
        zzg.putParcelable(ServiceSpecificExtraArgs.GamesExtraArgs.WINDOW_TOKEN, new BinderWrapper(this.h.zzcp()));
        zzg.putInt("com.google.android.gms.games.key.API_VERSION", 6);
        zzg.putBundle(ServiceSpecificExtraArgs.GamesExtraArgs.SIGNIN_OPTIONS, SignInClientImpl.createBundleFromClientSettings(h()));
        return zzg;
    }

    public final String zzau() throws RemoteException {
        return ((zzbu) getService()).zzau();
    }

    public final String zzav() {
        try {
            return zzau();
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final void zza(String str, BaseImplementation.ResultHolder<Games.GetServerAuthCodeResult> resultHolder) throws RemoteException {
        Preconditions.checkNotEmpty(str, "Please provide a valid serverClientId");
        try {
            ((zzbu) getService()).zza(str, new com.google.android.gms.games.internal.bd(resultHolder));
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final String zza(boolean z2) throws RemoteException {
        PlayerEntity playerEntity = this.f;
        if (playerEntity != null) {
            return playerEntity.getPlayerId();
        }
        return ((zzbu) getService()).zzck();
    }

    public final String zzb(boolean z2) {
        try {
            return zza(true);
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final Player zzaw() throws RemoteException {
        e();
        synchronized (this) {
            if (this.f == null) {
                PlayerBuffer playerBuffer = new PlayerBuffer(((zzbu) getService()).zzcl());
                try {
                    if (playerBuffer.getCount() > 0) {
                        this.f = (PlayerEntity) ((Player) playerBuffer.get(0)).freeze();
                    }
                    playerBuffer.release();
                } catch (Throwable th) {
                    playerBuffer.release();
                    throw th;
                }
            }
        }
        return this.f;
    }

    public final Player zzax() {
        try {
            return zzaw();
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final Game zzay() throws RemoteException {
        e();
        synchronized (this) {
            if (this.g == null) {
                GameBuffer gameBuffer = new GameBuffer(((zzbu) getService()).zzcm());
                try {
                    if (gameBuffer.getCount() > 0) {
                        this.g = (GameEntity) ((Game) gameBuffer.get(0)).freeze();
                    }
                    gameBuffer.release();
                } catch (Throwable th) {
                    gameBuffer.release();
                    throw th;
                }
            }
        }
        return this.g;
    }

    public final Game zzaz() {
        try {
            return zzay();
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Players.LoadPlayersResult> resultHolder, String str, boolean z2) throws RemoteException {
        try {
            ((zzbu) getService()).zzb(new m(resultHolder), str, z2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Players.LoadPlayersResult> resultHolder, int i2, boolean z2, boolean z3) throws RemoteException {
        try {
            ((zzbu) getService()).zza(new m(resultHolder), i2, z2, z3);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Players.LoadPlayersResult> resultHolder, String str, int i2, boolean z2, boolean z3) throws RemoteException {
        if (((str.hashCode() == 156408498 && str.equals("played_with")) ? (char) 0 : (char) 65535) != 0) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid player collection: ".concat(valueOf) : new String("Invalid player collection: "));
        }
        try {
            ((zzbu) getService()).zza(new m(resultHolder), str, i2, z2, z3);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Players.LoadPlayersResult> resultHolder, boolean z2) throws RemoteException {
        try {
            ((zzbu) getService()).zzc(new m(resultHolder), z2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final Intent zzba() throws RemoteException {
        return ((zzbu) getService()).zzba();
    }

    public final Intent zzbb() {
        try {
            return zzba();
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final Intent zza(String str, int i2, int i3) {
        try {
            return ((zzbu) getService()).zzb(str, i2, i3);
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Leaderboards.LeaderboardMetadataResult> resultHolder, boolean z2) throws RemoteException {
        try {
            ((zzbu) getService()).zzb(new bb(resultHolder), z2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Leaderboards.LeaderboardMetadataResult> resultHolder, String str, boolean z2) throws RemoteException {
        try {
            ((zzbu) getService()).zza(new bb(resultHolder), str, z2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Leaderboards.LoadPlayerScoreResult> resultHolder, String str, String str2, int i2, int i3) throws RemoteException {
        try {
            ((zzbu) getService()).zza(new com.google.android.gms.games.internal.be(resultHolder), (String) null, str2, i2, i3);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Leaderboards.LoadScoresResult> resultHolder, String str, int i2, int i3, int i4, boolean z2) throws RemoteException {
        try {
            ((zzbu) getService()).zza(new ba(resultHolder), str, i2, i3, i4, z2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Leaderboards.LoadScoresResult> resultHolder, String str, int i2, int i3, int i4, boolean z2) throws RemoteException {
        try {
            ((zzbu) getService()).zzb(new ba(resultHolder), str, i2, i3, i4, z2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Leaderboards.LoadScoresResult> resultHolder, LeaderboardScoreBuffer leaderboardScoreBuffer, int i2, int i3) throws RemoteException {
        try {
            ((zzbu) getService()).zza(new ba(resultHolder), leaderboardScoreBuffer.zzdi().zzdj(), i2, i3);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Leaderboards.SubmitScoreResult> resultHolder, String str, long j2, String str2) throws RemoteException {
        try {
            ((zzbu) getService()).zza(resultHolder == null ? null : new com.google.android.gms.games.internal.a(resultHolder), str, j2, str2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final Intent zzbc() {
        try {
            return ((zzbu) getService()).zzbc();
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final void zzc(BaseImplementation.ResultHolder<Achievements.LoadAchievementsResult> resultHolder, boolean z2) throws RemoteException {
        try {
            ((zzbu) getService()).zza(new com.google.android.gms.games.internal.b(resultHolder), z2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zza(resultHolder == null ? null : new ab(resultHolder), str, this.h.zzcp(), this.h.zzco());
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zzb(resultHolder == null ? null : new ab(resultHolder), str, this.h.zzcp(), this.h.zzco());
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult> resultHolder, String str, int i2) throws RemoteException {
        try {
            ((zzbu) getService()).zza(resultHolder == null ? null : new ab(resultHolder), str, i2, this.h.zzcp(), this.h.zzco());
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Achievements.UpdateAchievementResult> resultHolder, String str, int i2) throws RemoteException {
        try {
            ((zzbu) getService()).zzb(resultHolder == null ? null : new ab(resultHolder), str, i2, this.h.zzcp(), this.h.zzco());
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzd(BaseImplementation.ResultHolder<Events.LoadEventsResult> resultHolder, boolean z2) throws RemoteException {
        this.d.flush();
        try {
            ((zzbu) getService()).zze(new as(resultHolder), z2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Events.LoadEventsResult> resultHolder, boolean z2, String... strArr) throws RemoteException {
        this.d.flush();
        try {
            ((zzbu) getService()).zza(new as(resultHolder), z2, strArr);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(String str, int i2) {
        this.d.zza(str, i2);
    }

    public final Intent zzbd() {
        try {
            return ((zzbu) getService()).zzbd();
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final Intent zzbe() {
        try {
            return ((zzbu) getService()).zzbe();
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final void zza(ListenerHolder<OnInvitationReceivedListener> listenerHolder) throws RemoteException {
        ((zzbu) getService()).zza(new ax(listenerHolder), this.k);
    }

    public final void zzb(ListenerHolder<OnInvitationReceivedListener> listenerHolder) {
        try {
            zza(listenerHolder);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final void zzbf() throws RemoteException {
        ((zzbu) getService()).zzb(this.k);
    }

    public final void zzbg() {
        try {
            zzbf();
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final void zzc(ListenerHolder<OnTurnBasedMatchUpdateReceivedListener> listenerHolder) throws RemoteException {
        ((zzbu) getService()).zzb(new k(listenerHolder), this.k);
    }

    public final void zzd(ListenerHolder<OnTurnBasedMatchUpdateReceivedListener> listenerHolder) {
        try {
            zzc(listenerHolder);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final void zzbh() throws RemoteException {
        ((zzbu) getService()).zzc(this.k);
    }

    public final void zzbi() {
        try {
            zzbh();
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final void zze(ListenerHolder<QuestUpdateListener> listenerHolder) {
        try {
            ((zzbu) getService()).zzd(new n(listenerHolder), this.k);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final void zzbj() {
        try {
            ((zzbu) getService()).zze(this.k);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final void zzf(ListenerHolder<OnRequestReceivedListener> listenerHolder) {
        try {
            ((zzbu) getService()).zzc(new r(listenerHolder), this.k);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final void zzbk() {
        try {
            ((zzbu) getService()).zzd(this.k);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final Intent zza(PlayerEntity playerEntity) throws RemoteException {
        return ((zzbu) getService()).zza(playerEntity);
    }

    public final Intent zzb(PlayerEntity playerEntity) {
        try {
            return zza(playerEntity);
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final Intent zzbl() throws RemoteException {
        return ((zzbu) getService()).zzbl();
    }

    public final Intent zzbm() {
        try {
            return zzbl();
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final Intent zza(Room room, int i2) throws RemoteException {
        return ((zzbu) getService()).zza((RoomEntity) room.freeze(), i2);
    }

    public final Intent zzb(Room room, int i2) {
        try {
            return zza(room, i2);
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final Intent zzbn() throws RemoteException {
        return ((zzbu) getService()).zzbn();
    }

    public final Intent zzbo() {
        try {
            return zzbn();
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<GamesMetadata.LoadGamesResult> resultHolder) throws RemoteException {
        try {
            ((zzbu) getService()).zzb(new com.google.android.gms.games.internal.c(resultHolder));
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        try {
            zzb(new com.google.android.gms.games.internal.d(signOutCallbacks));
        } catch (RemoteException unused) {
            signOutCallbacks.onSignOutComplete();
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Status> resultHolder) throws RemoteException {
        this.d.flush();
        try {
            ((zzbu) getService()).zza(new com.google.android.gms.games.internal.al(resultHolder));
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final int zzbp() throws RemoteException {
        return ((zzbu) getService()).zzbp();
    }

    public final int zzbq() {
        try {
            return zzbp();
        } catch (RemoteException e2) {
            a(e2);
            return 4368;
        }
    }

    public final String zzbr() throws RemoteException {
        return ((zzbu) getService()).zzbr();
    }

    public final String zzbs() {
        try {
            return zzbr();
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Invitations.LoadInvitationsResult> resultHolder, int i2) throws RemoteException {
        try {
            ((zzbu) getService()).zza((zzbq) new ay(resultHolder), i2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzb(String str, int i2) throws RemoteException {
        ((zzbu) getService()).zzb(str, i2);
    }

    public final void zzc(String str, int i2) {
        try {
            zzb(str, i2);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final void zzd(String str, int i2) throws RemoteException {
        ((zzbu) getService()).zzd(str, i2);
    }

    public final void zze(String str, int i2) {
        try {
            zzd(str, i2);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final Intent zza(int i2, int i3, boolean z2) throws RemoteException {
        return ((zzbu) getService()).zza(i2, i3, z2);
    }

    public final Intent zzb(int i2, int i3, boolean z2) {
        try {
            return zza(i2, i3, z2);
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<TurnBasedMultiplayer.InitiateMatchResult> resultHolder, TurnBasedMatchConfig turnBasedMatchConfig) throws RemoteException {
        try {
            ((zzbu) getService()).zza(new ad(resultHolder), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.zzdp(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzc(BaseImplementation.ResultHolder<TurnBasedMultiplayer.InitiateMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zzb(new ad(resultHolder), str);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzd(BaseImplementation.ResultHolder<TurnBasedMultiplayer.InitiateMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zzc(new ad(resultHolder), str);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final int zzbt() throws RemoteException {
        return ((zzbu) getService()).zzbt();
    }

    public final int zzbu() {
        try {
            return zzbt();
        } catch (RemoteException e2) {
            a(e2);
            return -1;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<TurnBasedMultiplayer.UpdateMatchResult> resultHolder, String str, byte[] bArr, String str2, ParticipantResult[] participantResultArr) throws RemoteException {
        try {
            ((zzbu) getService()).zza(new ag(resultHolder), str, bArr, str2, participantResultArr);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<TurnBasedMultiplayer.UpdateMatchResult> resultHolder, String str, byte[] bArr, ParticipantResult[] participantResultArr) throws RemoteException {
        try {
            ((zzbu) getService()).zza(new ag(resultHolder), str, bArr, participantResultArr);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zze(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LeaveMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zze(new ae(resultHolder), str);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LeaveMatchResult> resultHolder, String str, String str2) throws RemoteException {
        try {
            ((zzbu) getService()).zza(new ae(resultHolder), str, str2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzf(BaseImplementation.ResultHolder<TurnBasedMultiplayer.CancelMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zzd(new com.google.android.gms.games.internal.am(resultHolder), str);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzb(String str) throws RemoteException {
        ((zzbu) getService()).zzf(str);
    }

    public final void zzc(String str) {
        try {
            zzb(str);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LoadMatchesResult> resultHolder, int i2, int[] iArr) throws RemoteException {
        try {
            ((zzbu) getService()).zza(new ah(resultHolder), i2, iArr);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzg(BaseImplementation.ResultHolder<TurnBasedMultiplayer.LoadMatchResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zzf(new com.google.android.gms.games.internal.an(resultHolder), str);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final Intent zzc(int i2, int i3, boolean z2) throws RemoteException {
        return ((zzbu) getService()).zzc(i2, i3, z2);
    }

    public final Intent zzd(int i2, int i3, boolean z2) {
        try {
            return zzc(i2, i3, z2);
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final void zza(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) throws RemoteException {
        ((zzbu) getService()).zza(new v(listenerHolder, listenerHolder2, listenerHolder3), this.j, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), false, this.k);
    }

    public final void zzb(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) {
        try {
            zza(listenerHolder, listenerHolder2, listenerHolder3, roomConfig);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final void zzc(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) throws RemoteException {
        ((zzbu) getService()).zza((zzbq) new v(listenerHolder, listenerHolder2, listenerHolder3), (IBinder) this.j, roomConfig.getInvitationId(), false, this.k);
    }

    public final void zzd(ListenerHolder<? extends RoomUpdateListener> listenerHolder, ListenerHolder<? extends RoomStatusUpdateListener> listenerHolder2, ListenerHolder<? extends RealTimeMessageReceivedListener> listenerHolder3, RoomConfig roomConfig) {
        try {
            zzc(listenerHolder, listenerHolder2, listenerHolder3, roomConfig);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final void zza(ListenerHolder<? extends RoomUpdateListener> listenerHolder, String str) {
        try {
            ((zzbu) getService()).zza(new v(listenerHolder), str);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final int zza(ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback> listenerHolder, byte[] bArr, String str, String str2) throws RemoteException {
        return ((zzbu) getService()).zza(new p(listenerHolder), bArr, str, str2);
    }

    public final int zzb(ListenerHolder<RealTimeMultiplayer.ReliableMessageSentCallback> listenerHolder, byte[] bArr, String str, String str2) {
        try {
            return zza(listenerHolder, bArr, str, str2);
        } catch (RemoteException e2) {
            a(e2);
            return -1;
        }
    }

    public final int zza(byte[] bArr, String str, String[] strArr) {
        Preconditions.checkNotNull(strArr, "Participant IDs must not be null");
        try {
            Preconditions.checkNotNull(strArr, "Participant IDs must not be null");
            return ((zzbu) getService()).zzb(bArr, str, strArr);
        } catch (RemoteException e2) {
            a(e2);
            return -1;
        }
    }

    public final int zza(byte[] bArr, String str) throws RemoteException {
        return ((zzbu) getService()).zzb(bArr, str, (String[]) null);
    }

    public final int zzb(byte[] bArr, String str) {
        try {
            return zza(bArr, str);
        } catch (RemoteException e2) {
            a(e2);
            return -1;
        }
    }

    public final void zzl(int i2) throws RemoteException {
        ((zzbu) getService()).zzl(i2);
    }

    public final void zzm(int i2) {
        try {
            zzl(i2);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final Intent zzbv() {
        try {
            return ((zzbu) getService()).zzbv();
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final Intent zza(int i2, byte[] bArr, int i3, Bitmap bitmap, String str) {
        try {
            Intent zza = ((zzbu) getService()).zza(i2, bArr, i3, str);
            Preconditions.checkNotNull(bitmap, "Must provide a non null icon");
            zza.putExtra("com.google.android.gms.games.REQUEST_ITEM_ICON", bitmap);
            return zza;
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final int zzbw() {
        try {
            return ((zzbu) getService()).zzbw();
        } catch (RemoteException e2) {
            a(e2);
            return -1;
        }
    }

    public final int zzbx() {
        try {
            return ((zzbu) getService()).zzbx();
        } catch (RemoteException e2) {
            a(e2);
            return -1;
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Requests.UpdateRequestsResult> resultHolder, String[] strArr) throws RemoteException {
        try {
            ((zzbu) getService()).zza(new t(resultHolder), strArr);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Requests.UpdateRequestsResult> resultHolder, String[] strArr) throws RemoteException {
        try {
            ((zzbu) getService()).zzb(new t(resultHolder), strArr);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Requests.LoadRequestsResult> resultHolder, int i2, int i3, int i4) throws RemoteException {
        try {
            ((zzbu) getService()).zza(new s(resultHolder), i2, i3, i4);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zze(BaseImplementation.ResultHolder<Stats.LoadPlayerStatsResult> resultHolder, boolean z2) throws RemoteException {
        try {
            ((zzbu) getService()).zzf(new com.google.android.gms.games.internal.ao(resultHolder), z2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final Intent zza(int[] iArr) {
        try {
            return ((zzbu) getService()).zza(iArr);
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final Intent zzd(String str) {
        try {
            return ((zzbu) getService()).zzd(str);
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final void zzh(BaseImplementation.ResultHolder<Quests.AcceptQuestResult> resultHolder, String str) throws RemoteException {
        this.d.flush();
        try {
            ((zzbu) getService()).zzh(new com.google.android.gms.games.internal.ap(resultHolder), str);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Quests.ClaimMilestoneResult> resultHolder, String str, String str2) throws RemoteException {
        this.d.flush();
        try {
            Preconditions.checkNotNull(str2, "MilestoneId must not be null");
            ((zzbu) getService()).zzb(new com.google.android.gms.games.internal.aq(resultHolder, str2), str, str2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Quests.LoadQuestsResult> resultHolder, int[] iArr, int i2, boolean z2) throws RemoteException {
        this.d.flush();
        try {
            ((zzbu) getService()).zza(new o(resultHolder), iArr, i2, z2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Quests.LoadQuestsResult> resultHolder, boolean z2, String[] strArr) throws RemoteException {
        this.d.flush();
        try {
            ((zzbu) getService()).zza(new o(resultHolder), strArr, z2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zze(String str) {
        try {
            ((zzbu) getService()).zza(str, this.h.zzcp(), this.h.zzco());
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final int zzby() throws RemoteException {
        return ((zzbu) getService()).zzby();
    }

    public final int zzbz() {
        try {
            return zzby();
        } catch (RemoteException e2) {
            a(e2);
            return -1;
        }
    }

    public final int zzca() throws RemoteException {
        return ((zzbu) getService()).zzca();
    }

    public final int zzcb() {
        try {
            return zzca();
        } catch (RemoteException e2) {
            a(e2);
            return -1;
        }
    }

    public final Intent zza(String str, boolean z2, boolean z3, int i2) throws RemoteException {
        return ((zzbu) getService()).zza(str, z2, z3, i2);
    }

    public final Intent zzb(String str, boolean z2, boolean z3, int i2) {
        try {
            return zza(str, z2, z3, i2);
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final void zzf(BaseImplementation.ResultHolder<Snapshots.LoadSnapshotsResult> resultHolder, boolean z2) throws RemoteException {
        try {
            ((zzbu) getService()).zzd(new z(resultHolder), z2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Snapshots.OpenSnapshotResult> resultHolder, String str, boolean z2, int i2) throws RemoteException {
        try {
            ((zzbu) getService()).zza(new y(resultHolder), str, z2, i2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Snapshots.CommitSnapshotResult> resultHolder, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        BitmapTeleporter zzdt = snapshotMetadataChange.zzdt();
        if (zzdt != null) {
            zzdt.setTempDir(getContext().getCacheDir());
        }
        Contents zzds = snapshotContents.zzds();
        snapshotContents.close();
        try {
            ((zzbu) getService()).zza(new com.google.android.gms.games.internal.ar(resultHolder), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzds);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(Snapshot snapshot) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        Contents zzds = snapshotContents.zzds();
        snapshotContents.close();
        ((zzbu) getService()).zza(zzds);
    }

    public final void zzb(Snapshot snapshot) {
        try {
            zza(snapshot);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final void zzi(BaseImplementation.ResultHolder<Snapshots.DeleteSnapshotResult> resultHolder, String str) throws RemoteException {
        try {
            ((zzbu) getService()).zzg(new com.google.android.gms.games.internal.as(resultHolder), str);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zza(BaseImplementation.ResultHolder<Snapshots.OpenSnapshotResult> resultHolder, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        Preconditions.checkState(!snapshotContents.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter zzdt = snapshotMetadataChange.zzdt();
        if (zzdt != null) {
            zzdt.setTempDir(getContext().getCacheDir());
        }
        Contents zzds = snapshotContents.zzds();
        snapshotContents.close();
        try {
            ((zzbu) getService()).zza(new y(resultHolder), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, zzds);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzc(BaseImplementation.ResultHolder<Videos.CaptureCapabilitiesResult> resultHolder) throws RemoteException {
        try {
            ((zzbu) getService()).zzc(new com.google.android.gms.games.internal.at(resultHolder));
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final Intent zzcc() throws RemoteException {
        return ((zzbu) getService()).zzcn();
    }

    public final Intent zzcd() {
        try {
            return zzcc();
        } catch (RemoteException e2) {
            a(e2);
            return null;
        }
    }

    public final void zzd(BaseImplementation.ResultHolder<Videos.CaptureStateResult> resultHolder) throws RemoteException {
        try {
            ((zzbu) getService()).zzd(new com.google.android.gms.games.internal.av(resultHolder));
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final void zzb(BaseImplementation.ResultHolder<Videos.CaptureAvailableResult> resultHolder, int i2) throws RemoteException {
        try {
            ((zzbu) getService()).zzb((zzbq) new com.google.android.gms.games.internal.aw(resultHolder), i2);
        } catch (SecurityException e2) {
            a(resultHolder, e2);
        }
    }

    public final boolean zzce() throws RemoteException {
        return ((zzbu) getService()).zzce();
    }

    public final boolean zzcf() {
        try {
            return zzce();
        } catch (RemoteException e2) {
            a(e2);
            return false;
        }
    }

    public final void zzg(ListenerHolder<Videos.CaptureOverlayStateListener> listenerHolder) throws RemoteException {
        ((zzbu) getService()).zze(new com.google.android.gms.games.internal.ax(listenerHolder), this.k);
    }

    public final void zzh(ListenerHolder<Videos.CaptureOverlayStateListener> listenerHolder) {
        try {
            zzg(listenerHolder);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    public final void zzcg() throws RemoteException {
        ((zzbu) getService()).zzf(this.k);
    }

    public final void zzch() {
        try {
            zzcg();
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            try {
                ((zzbu) getService()).zza(iBinder, bundle);
            } catch (RemoteException e2) {
                a(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i() {
        if (isConnected()) {
            try {
                ((zzbu) getService()).zzci();
            } catch (RemoteException e2) {
                a(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(RemoteException remoteException) {
        zzbd.w("GamesClientImpl", "service died", remoteException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(SecurityException securityException) {
        zzbd.e("GamesClientImpl", "Is player signed out?", securityException);
    }

    private static <R> void a(BaseImplementation.ResultHolder<R> resultHolder, SecurityException securityException) {
        if (resultHolder != null) {
            resultHolder.setFailedResult(GamesClientStatusCodes.zza(4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Room b(DataHolder dataHolder) {
        com.google.android.gms.games.multiplayer.realtime.zzb zzbVar = new com.google.android.gms.games.multiplayer.realtime.zzb(dataHolder);
        try {
            return zzbVar.getCount() > 0 ? zzbVar.get(0).freeze() : null;
        } finally {
            zzbVar.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public void a(int i2, IBinder iBinder, Bundle bundle, int i3) {
        if (i2 == 0 && bundle != null) {
            bundle.setClassLoader(zze.class.getClassLoader());
            this.i = bundle.getBoolean("show_welcome_popup");
            this.l = this.i;
            this.f = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
            this.g = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
        }
        super.a(i2, iBinder, bundle, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> ListenerHolder.Notifier<T> b(q<T> qVar) {
        return new com.google.android.gms.games.internal.az(qVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> ListenerHolder.Notifier<T> b(DataHolder dataHolder, x<T> xVar) {
        return new com.google.android.gms.games.internal.ba(xVar, dataHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> ListenerHolder.Notifier<T> b(DataHolder dataHolder, String[] strArr, w<T> wVar) {
        return new com.google.android.gms.games.internal.bb(wVar, dataHolder, new ArrayList(Arrays.asList(strArr)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> ListenerHolder.Notifier<T> b(DataHolder dataHolder, aa<T> aaVar) {
        return new com.google.android.gms.games.internal.bc(aaVar, dataHolder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public /* synthetic */ void onConnectedLocked(IInterface iInterface) {
        zzbu zzbuVar = (zzbu) iInterface;
        super.onConnectedLocked(zzbuVar);
        if (this.i) {
            this.h.zzcr();
            this.i = false;
        }
        if (this.m.zzar || this.m.zzaz) {
            return;
        }
        try {
            zzbuVar.zza(new com.google.android.gms.games.internal.au(new zzbw(this.h.zzcq())), this.k);
        } catch (RemoteException e2) {
            a(e2);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
        if (queryLocalInterface instanceof zzbu) {
            return (zzbu) queryLocalInterface;
        }
        return new zzbv(iBinder);
    }
}
