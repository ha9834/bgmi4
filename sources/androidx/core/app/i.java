package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.h;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements g {

    /* renamed from: a, reason: collision with root package name */
    private final Notification.Builder f475a;
    private final h.e b;
    private RemoteViews c;
    private RemoteViews d;
    private final List<Bundle> e = new ArrayList();
    private final Bundle f = new Bundle();
    private int g;
    private RemoteViews h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h.e eVar) {
        this.b = eVar;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f475a = new Notification.Builder(eVar.f473a, eVar.I);
        } else {
            this.f475a = new Notification.Builder(eVar.f473a);
        }
        Notification notification = eVar.P;
        this.f475a.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.h).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(eVar.d).setContentText(eVar.e).setContentInfo(eVar.j).setContentIntent(eVar.f).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(eVar.g, (notification.flags & 128) != 0).setLargeIcon(eVar.i).setNumber(eVar.k).setProgress(eVar.r, eVar.s, eVar.t);
        if (Build.VERSION.SDK_INT < 21) {
            this.f475a.setSound(notification.sound, notification.audioStreamType);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.f475a.setSubText(eVar.p).setUsesChronometer(eVar.n).setPriority(eVar.l);
            Iterator<h.a> it = eVar.b.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            if (eVar.B != null) {
                this.f.putAll(eVar.B);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (eVar.x) {
                    this.f.putBoolean("android.support.localOnly", true);
                }
                if (eVar.u != null) {
                    this.f.putString("android.support.groupKey", eVar.u);
                    if (eVar.v) {
                        this.f.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f.putBoolean("android.support.useSideChannel", true);
                    }
                }
                if (eVar.w != null) {
                    this.f.putString("android.support.sortKey", eVar.w);
                }
            }
            this.c = eVar.F;
            this.d = eVar.G;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.f475a.setShowWhen(eVar.m);
            if (Build.VERSION.SDK_INT < 21 && eVar.R != null && !eVar.R.isEmpty()) {
                this.f.putStringArray("android.people", (String[]) eVar.R.toArray(new String[eVar.R.size()]));
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f475a.setLocalOnly(eVar.x).setGroup(eVar.u).setGroupSummary(eVar.v).setSortKey(eVar.w);
            this.g = eVar.M;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f475a.setCategory(eVar.A).setColor(eVar.C).setVisibility(eVar.D).setPublicVersion(eVar.E).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = eVar.R.iterator();
            while (it2.hasNext()) {
                this.f475a.addPerson(it2.next());
            }
            this.h = eVar.H;
            if (eVar.c.size() > 0) {
                Bundle bundle = eVar.a().getBundle("android.car.EXTENSIONS");
                bundle = bundle == null ? new Bundle() : bundle;
                Bundle bundle2 = new Bundle();
                for (int i = 0; i < eVar.c.size(); i++) {
                    bundle2.putBundle(Integer.toString(i), j.a(eVar.c.get(i)));
                }
                bundle.putBundle("invisible_actions", bundle2);
                eVar.a().putBundle("android.car.EXTENSIONS", bundle);
                this.f.putBundle("android.car.EXTENSIONS", bundle);
            }
        }
        if (Build.VERSION.SDK_INT >= 24) {
            this.f475a.setExtras(eVar.B).setRemoteInputHistory(eVar.q);
            if (eVar.F != null) {
                this.f475a.setCustomContentView(eVar.F);
            }
            if (eVar.G != null) {
                this.f475a.setCustomBigContentView(eVar.G);
            }
            if (eVar.H != null) {
                this.f475a.setCustomHeadsUpContentView(eVar.H);
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.f475a.setBadgeIconType(eVar.J).setShortcutId(eVar.K).setTimeoutAfter(eVar.L).setGroupAlertBehavior(eVar.M);
            if (eVar.z) {
                this.f475a.setColorized(eVar.y);
            }
            if (!TextUtils.isEmpty(eVar.I)) {
                this.f475a.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f475a.setAllowSystemGeneratedContextualActions(eVar.N);
            this.f475a.setBubbleMetadata(h.d.a(eVar.O));
        }
        if (eVar.Q) {
            if (this.b.v) {
                this.g = 2;
            } else {
                this.g = 1;
            }
            this.f475a.setVibrate(null);
            this.f475a.setSound(null);
            notification.defaults &= -2;
            notification.defaults &= -3;
            this.f475a.setDefaults(notification.defaults);
            if (Build.VERSION.SDK_INT >= 26) {
                if (TextUtils.isEmpty(this.b.u)) {
                    this.f475a.setGroup("silent");
                }
                this.f475a.setGroupAlertBehavior(this.g);
            }
        }
    }

    @Override // androidx.core.app.g
    public Notification.Builder a() {
        return this.f475a;
    }

    public Notification b() {
        Bundle a2;
        RemoteViews d;
        RemoteViews c;
        h.f fVar = this.b.o;
        if (fVar != null) {
            fVar.a(this);
        }
        RemoteViews b = fVar != null ? fVar.b(this) : null;
        Notification c2 = c();
        if (b != null) {
            c2.contentView = b;
        } else if (this.b.F != null) {
            c2.contentView = this.b.F;
        }
        if (Build.VERSION.SDK_INT >= 16 && fVar != null && (c = fVar.c(this)) != null) {
            c2.bigContentView = c;
        }
        if (Build.VERSION.SDK_INT >= 21 && fVar != null && (d = this.b.o.d(this)) != null) {
            c2.headsUpContentView = d;
        }
        if (Build.VERSION.SDK_INT >= 16 && fVar != null && (a2 = h.a(c2)) != null) {
            fVar.a(a2);
        }
        return c2;
    }

    private void a(h.a aVar) {
        Notification.Action.Builder builder;
        Bundle bundle;
        if (Build.VERSION.SDK_INT >= 20) {
            IconCompat a2 = aVar.a();
            if (Build.VERSION.SDK_INT >= 23) {
                builder = new Notification.Action.Builder(a2 != null ? a2.e() : null, aVar.b(), aVar.c());
            } else {
                builder = new Notification.Action.Builder(a2 != null ? a2.c() : 0, aVar.b(), aVar.c());
            }
            if (aVar.f() != null) {
                for (RemoteInput remoteInput : l.a(aVar.f())) {
                    builder.addRemoteInput(remoteInput);
                }
            }
            if (aVar.d() != null) {
                bundle = new Bundle(aVar.d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
            if (Build.VERSION.SDK_INT >= 24) {
                builder.setAllowGeneratedReplies(aVar.e());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.g());
            if (Build.VERSION.SDK_INT >= 28) {
                builder.setSemanticAction(aVar.g());
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setContextual(aVar.h());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.j());
            builder.addExtras(bundle);
            this.f475a.addAction(builder.build());
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            this.e.add(j.a(this.f475a, aVar));
        }
    }

    protected Notification c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f475a.build();
        }
        if (Build.VERSION.SDK_INT >= 24) {
            Notification build = this.f475a.build();
            if (this.g != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.g == 2) {
                    a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.g == 1) {
                    a(build);
                }
            }
            return build;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            this.f475a.setExtras(this.f);
            Notification build2 = this.f475a.build();
            RemoteViews remoteViews = this.c;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.d;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.h;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.g != 0) {
                if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.g == 2) {
                    a(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.g == 1) {
                    a(build2);
                }
            }
            return build2;
        }
        if (Build.VERSION.SDK_INT >= 20) {
            this.f475a.setExtras(this.f);
            Notification build3 = this.f475a.build();
            RemoteViews remoteViews4 = this.c;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.d;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.g != 0) {
                if (build3.getGroup() != null && (build3.flags & 512) != 0 && this.g == 2) {
                    a(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.g == 1) {
                    a(build3);
                }
            }
            return build3;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            SparseArray<Bundle> a2 = j.a(this.e);
            if (a2 != null) {
                this.f.putSparseParcelableArray("android.support.actionExtras", a2);
            }
            this.f475a.setExtras(this.f);
            Notification build4 = this.f475a.build();
            RemoteViews remoteViews6 = this.c;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.d;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            Notification build5 = this.f475a.build();
            Bundle a3 = h.a(build5);
            Bundle bundle = new Bundle(this.f);
            for (String str : this.f.keySet()) {
                if (a3.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            a3.putAll(bundle);
            SparseArray<Bundle> a4 = j.a(this.e);
            if (a4 != null) {
                h.a(build5).putSparseParcelableArray("android.support.actionExtras", a4);
            }
            RemoteViews remoteViews8 = this.c;
            if (remoteViews8 != null) {
                build5.contentView = remoteViews8;
            }
            RemoteViews remoteViews9 = this.d;
            if (remoteViews9 != null) {
                build5.bigContentView = remoteViews9;
            }
            return build5;
        }
        return this.f475a.getNotification();
    }

    private void a(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -2;
        notification.defaults &= -3;
    }
}
