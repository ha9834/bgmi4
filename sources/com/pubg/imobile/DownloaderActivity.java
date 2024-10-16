package com.pubg.imobile;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Messenger;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.vending.expansion.zipfile.a;
import com.epicgames.ue4.GameActivity;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.vending.expansion.downloader.DownloadProgressInfo;
import com.google.android.vending.expansion.downloader.b;
import com.google.android.vending.expansion.downloader.c;
import com.google.android.vending.expansion.downloader.d;
import com.google.android.vending.expansion.downloader.e;
import com.google.android.vending.expansion.downloader.f;
import com.google.android.vending.expansion.downloader.g;
import com.pubg.imobile.a;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.CRC32;

/* loaded from: classes2.dex */
public class DownloaderActivity extends Activity implements e {

    /* renamed from: a, reason: collision with root package name */
    static DownloaderActivity f5757a;
    private ProgressBar b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private View h;
    private View i;
    private Button j;
    private Button k;
    private boolean l;
    private int m;
    private f n;
    private g o;
    private final CharSequence[] p = {"Use Store Data", "Use Development Data"};
    private int q = 0;
    private Intent r;
    private boolean s;

    static /* synthetic */ int h(DownloaderActivity downloaderActivity) {
        int i = downloaderActivity.q;
        downloaderActivity.q = i + 1;
        return i;
    }

    private void c(int i) {
        if (this.m != i) {
            this.m = i;
            this.c.setText(d.a(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.l = z;
        this.j.setText(z ? R.string.text_button_resume : R.string.text_button_pause);
    }

    public static void a() {
        if (f5757a != null) {
            GameActivity.Log.debug("DownloaderActivity stopDownloader.");
            try {
                Intent intent = new Intent();
                intent.setClassName(f5757a.getPackageName(), OBBDownloaderService.class.getName());
                f5757a.stopService(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    boolean b() {
        for (a.C0146a c0146a : a.f5766a) {
            String a2 = d.a(this, c0146a.f5767a, c0146a.b);
            GameActivity.Log.debug("Checking for file : " + a2);
            GameActivity.Log.debug("which is really being resolved to : " + d.a(this, a2) + "\n Or : " + d.b(this, a2));
            if (!d.a((Context) this, a2, c0146a.c, false) && !d.b(this, a2, c0146a.c, false)) {
                return false;
            }
        }
        return true;
    }

    boolean c() {
        for (a.C0146a c0146a : a.f5766a) {
            String a2 = d.a(this, c0146a.f5767a, c0146a.b);
            GameActivity.Log.debug("Checking for file : " + a2);
            d.a(this, a2);
            d.b(this, a2);
            if (d.a((Context) this, a2, c0146a.c, false) && d.b(this, a2, c0146a.c, false)) {
                return false;
            }
        }
        return true;
    }

    File d() {
        return new File(getExternalFilesDir(null), "cacheFile.txt");
    }

    boolean e() {
        File d = d();
        HashMap hashMap = new HashMap();
        if (d.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(d));
                ArrayList<String> arrayList = new ArrayList();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    arrayList.add(readLine);
                }
                bufferedReader.close();
                for (String str : arrayList) {
                    GameActivity.Log.debug("Splitting dataLine => " + str);
                    String[] split = str.split(",");
                    hashMap.put(split[0], Long.valueOf(Long.parseLong(split[1])));
                }
            } catch (Exception e) {
                GameActivity.Log.debug("Exception thrown during file details reading.");
                e.printStackTrace();
                hashMap.clear();
            }
        }
        for (a.C0146a c0146a : a.f5766a) {
            String a2 = d.a(this, c0146a.f5767a, c0146a.b);
            String a3 = d.a(this, a2);
            String b = d.b(this, a2);
            File file = new File(a3);
            File file2 = new File(b);
            long lastModified = file.lastModified();
            long lastModified2 = file2.lastModified();
            if ((!file.exists() || !hashMap.containsKey(a2) || lastModified != ((Long) hashMap.get(a2)).longValue()) && (!file2.exists() || !hashMap.containsKey(a2) || lastModified2 != ((Long) hashMap.get(a2)).longValue())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(int i) {
        for (a.C0146a c0146a : a.f5766a) {
            String a2 = d.a(f5757a, c0146a.f5767a, c0146a.b);
            switch (i) {
                case 0:
                    new File(d.a(f5757a, a2)).delete();
                    break;
                case 1:
                    new File(d.b(f5757a, a2)).delete();
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (GameActivity.Get().VerifyOBBOnStartUp && !e()) {
            f();
            return;
        }
        this.r.putExtra(GameActivity.DOWNLOAD_RETURN_NAME, 1);
        setResult(-1, this.r);
        finish();
        overridePendingTransition(R.anim.noaction, R.anim.noaction);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 2 && iArr.length > 0 && iArr[0] == 0) {
            recreate();
        }
    }

    void f() {
        new AsyncTask<Object, DownloadProgressInfo, Boolean>() { // from class: com.pubg.imobile.DownloaderActivity.1
            @Override // android.os.AsyncTask
            protected void onPreExecute() {
                DownloaderActivity.this.h.setVisibility(0);
                DownloaderActivity.this.i.setVisibility(8);
                DownloaderActivity.this.c.setText(R.string.text_verifying_download);
                DownloaderActivity.this.j.setOnClickListener(new View.OnClickListener() { // from class: com.pubg.imobile.DownloaderActivity.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DownloaderActivity.this.s = true;
                    }
                });
                DownloaderActivity.this.j.setVisibility(8);
                super.onPreExecute();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean doInBackground(Object... objArr) {
                String b;
                a.C0146a[] c0146aArr;
                a.C0070a[] c0070aArr;
                com.android.vending.expansion.zipfile.a aVar;
                int i;
                int i2;
                byte[] bArr;
                DataInputStream dataInputStream;
                a.C0146a[] c0146aArr2;
                int i3;
                a.C0146a[] c0146aArr3 = a.f5766a;
                int length = c0146aArr3.length;
                boolean z = false;
                int i4 = 0;
                while (i4 < length) {
                    a.C0146a c0146a = c0146aArr3[i4];
                    String a2 = d.a(DownloaderActivity.this, c0146a.f5767a, c0146a.b);
                    boolean a3 = d.a(DownloaderActivity.this, a2, c0146a.c, z);
                    boolean b2 = d.b(DownloaderActivity.this, a2, c0146a.c, z);
                    if (!a3 && !b2) {
                        return Boolean.valueOf(z);
                    }
                    if (a3) {
                        b = d.a(DownloaderActivity.this, a2);
                    } else {
                        b = d.b(DownloaderActivity.this, a2);
                    }
                    byte[] bArr2 = new byte[262144];
                    try {
                        com.android.vending.expansion.zipfile.a aVar2 = new com.android.vending.expansion.zipfile.a(b);
                        a.C0070a[] a4 = aVar2.a();
                        long j = 0;
                        for (a.C0070a c0070a : a4) {
                            j += c0070a.h;
                        }
                        int length2 = a4.length;
                        long j2 = j;
                        float f = 0.0f;
                        int i5 = 0;
                        while (i5 < length2) {
                            a.C0070a c0070a2 = a4[i5];
                            float f2 = f;
                            if (-1 != c0070a2.g) {
                                long j3 = c0070a2.i;
                                CRC32 crc32 = new CRC32();
                                try {
                                    dataInputStream = new DataInputStream(aVar2.a(c0070a2.b));
                                    try {
                                        long uptimeMillis = SystemClock.uptimeMillis();
                                        long j4 = 0;
                                        while (j3 > j4) {
                                            com.android.vending.expansion.zipfile.a aVar3 = aVar2;
                                            int i6 = length2;
                                            int length3 = (int) (j3 > ((long) bArr2.length) ? bArr2.length : j3);
                                            dataInputStream.readFully(bArr2, 0, length3);
                                            crc32.update(bArr2, 0, length3);
                                            a.C0070a[] c0070aArr2 = a4;
                                            byte[] bArr3 = bArr2;
                                            long j5 = length3;
                                            long j6 = j3 - j5;
                                            long uptimeMillis2 = SystemClock.uptimeMillis();
                                            long j7 = uptimeMillis2 - uptimeMillis;
                                            j4 = 0;
                                            if (j7 > 0) {
                                                float f3 = length3 / ((float) j7);
                                                if (0.0f != f2) {
                                                    f3 = (f3 * 0.005f) + (f2 * 0.995f);
                                                }
                                                long j8 = j2 - j5;
                                                c0146aArr2 = c0146aArr3;
                                                i3 = i5;
                                                publishProgress(new DownloadProgressInfo(j, j - j8, ((float) j8) / f3, f3));
                                                j2 = j8;
                                                f2 = f3;
                                            } else {
                                                c0146aArr2 = c0146aArr3;
                                                i3 = i5;
                                            }
                                            if (DownloaderActivity.this.s) {
                                                dataInputStream.close();
                                                return true;
                                            }
                                            bArr2 = bArr3;
                                            a4 = c0070aArr2;
                                            i5 = i3;
                                            aVar2 = aVar3;
                                            length2 = i6;
                                            j3 = j6;
                                            uptimeMillis = uptimeMillis2;
                                            c0146aArr3 = c0146aArr2;
                                        }
                                        c0146aArr = c0146aArr3;
                                        c0070aArr = a4;
                                        aVar = aVar2;
                                        i = length2;
                                        i2 = i5;
                                        bArr = bArr2;
                                        if (crc32.getValue() != c0070a2.g) {
                                            Log.e("LVLDL", "CRC does not match for entry: " + c0070a2.b);
                                            Log.e("LVLDL", "In file: " + c0070a2.d());
                                            dataInputStream.close();
                                            return false;
                                        }
                                        dataInputStream.close();
                                        f = f2;
                                    } catch (Throwable th) {
                                        th = th;
                                        if (dataInputStream != null) {
                                            dataInputStream.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    dataInputStream = null;
                                }
                            } else {
                                c0146aArr = c0146aArr3;
                                c0070aArr = a4;
                                aVar = aVar2;
                                i = length2;
                                i2 = i5;
                                bArr = bArr2;
                                f = f2;
                            }
                            i5 = i2 + 1;
                            bArr2 = bArr;
                            a4 = c0070aArr;
                            aVar2 = aVar;
                            length2 = i;
                            c0146aArr3 = c0146aArr;
                        }
                        i4++;
                        c0146aArr3 = c0146aArr3;
                        z = false;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                }
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onProgressUpdate(DownloadProgressInfo... downloadProgressInfoArr) {
                DownloaderActivity.this.a(downloadProgressInfoArr[0]);
                super.onProgressUpdate(downloadProgressInfoArr);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.os.AsyncTask
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Boolean bool) {
                if (bool.booleanValue()) {
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DownloaderActivity.this.d()));
                        for (a.C0146a c0146a : a.f5766a) {
                            String a2 = d.a(DownloaderActivity.this, c0146a.f5767a, c0146a.b);
                            String a3 = d.a(DownloaderActivity.this, a2);
                            String b = d.b(DownloaderActivity.this, a2);
                            GameActivity.Log.debug("Writing details for file : " + a2);
                            File file = new File(a3);
                            File file2 = new File(b);
                            if (file.exists()) {
                                long lastModified = file.lastModified();
                                bufferedWriter.write(a2);
                                bufferedWriter.write(",");
                                bufferedWriter.write(new Long(lastModified).toString());
                                bufferedWriter.newLine();
                                GameActivity.Log.debug("Details for file : " + a2 + " with modified time of " + new Long(lastModified).toString());
                            } else {
                                long lastModified2 = file2.lastModified();
                                bufferedWriter.write(a2);
                                bufferedWriter.write(",");
                                bufferedWriter.write(new Long(lastModified2).toString());
                                bufferedWriter.newLine();
                                GameActivity.Log.debug("Details for file : " + a2 + " with modified time of " + new Long(lastModified2).toString());
                            }
                        }
                        bufferedWriter.close();
                    } catch (Exception e) {
                        GameActivity.Log.debug("Exception thrown during file details writing.");
                        e.printStackTrace();
                    }
                    DownloaderActivity.this.r.putExtra(GameActivity.DOWNLOAD_RETURN_NAME, 1);
                    DownloaderActivity downloaderActivity = DownloaderActivity.this;
                    downloaderActivity.setResult(-1, downloaderActivity.r);
                    DownloaderActivity.this.finish();
                } else {
                    File d = DownloaderActivity.this.d();
                    if (d.exists()) {
                        d.delete();
                    }
                    DownloaderActivity.this.h.setVisibility(0);
                    DownloaderActivity.this.i.setVisibility(8);
                    DownloaderActivity.this.c.setText(R.string.text_validation_failed);
                    DownloaderActivity.this.j.setOnClickListener(new View.OnClickListener() { // from class: com.pubg.imobile.DownloaderActivity.1.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DownloaderActivity.this.r.putExtra(GameActivity.DOWNLOAD_RETURN_NAME, 5);
                            DownloaderActivity.this.setResult(-1, DownloaderActivity.this.r);
                            DownloaderActivity.this.finish();
                        }
                    });
                    DownloaderActivity.this.j.setText(R.string.cancel);
                    if (DownloaderActivity.this.q <= 3) {
                        androidx.core.app.a.a(GameActivity.Get(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 2);
                        DownloaderActivity.h(DownloaderActivity.this);
                        DownloaderActivity.this.f();
                    }
                }
                super.onPostExecute(bool);
            }
        }.execute(new Object());
    }

    private void h() {
        this.o = b.a(this, OBBDownloaderService.class);
        boolean isAlienScreen = GameActivity.isAlienScreen(this);
        b(isAlienScreen);
        setContentView(R.layout.downloader_progress);
        this.b = (ProgressBar) findViewById(R.id.progressBar);
        this.c = (TextView) findViewById(R.id.statusText);
        this.d = (TextView) findViewById(R.id.progressAsFraction);
        this.e = (TextView) findViewById(R.id.progressAsPercentage);
        this.f = (TextView) findViewById(R.id.progressAverageSpeed);
        this.g = (TextView) findViewById(R.id.progressTimeRemaining);
        this.h = findViewById(R.id.downloaderDashboard);
        this.i = findViewById(R.id.approveCellular);
        this.j = (Button) findViewById(R.id.pauseButton);
        this.k = (Button) findViewById(R.id.wifiSettingsButton);
        View findViewById = findViewById(R.id.splashLayout);
        if (isAlienScreen) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(4);
        }
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.pubg.imobile.DownloaderActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DownloaderActivity.this.l) {
                    DownloaderActivity.this.n.c();
                } else {
                    DownloaderActivity.this.n.b();
                }
                DownloaderActivity.this.a(!r2.l);
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.pubg.imobile.DownloaderActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloaderActivity.this.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
            }
        });
        ((Button) findViewById(R.id.resumeOverCellular)).setOnClickListener(new View.OnClickListener() { // from class: com.pubg.imobile.DownloaderActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DownloaderActivity.this.n.a(1);
                DownloaderActivity.this.n.c();
                DownloaderActivity.this.i.setVisibility(8);
            }
        });
    }

    private void b(boolean z) {
        try {
            if (z) {
                setTheme(getApplicationContext().getResources().getIdentifier("UE4SplashTheme", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, getApplicationContext().getPackageName()));
            } else {
                setTheme(getApplicationContext().getResources().getIdentifier("UE4SplashThemeAllInOne", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, getApplicationContext().getPackageName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GameActivity.Log.debug("Starting DownloaderActivity...");
        f5757a = this;
        this.r = new Intent();
        h();
        GameActivity.Log.debug("... UI setup. Checking for files.");
        if (!b()) {
            GameActivity.Log.debug("... Whoops... missing; go go go download system!");
            try {
                if (OBBDownloaderService.n() == 0) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setCancelable(false).setTitle("No Google Play Store Key").setMessage("No OBB found and no store key to try to download. Please set one up in Android Project Settings").setPositiveButton("Exit", new DialogInterface.OnClickListener() { // from class: com.pubg.imobile.DownloaderActivity.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            DownloaderActivity.this.r.putExtra(GameActivity.DOWNLOAD_RETURN_NAME, 6);
                            DownloaderActivity downloaderActivity = DownloaderActivity.this;
                            downloaderActivity.setResult(-1, downloaderActivity.r);
                            DownloaderActivity.this.finish();
                        }
                    });
                    builder.create().show();
                    return;
                }
                Intent intent = getIntent();
                Intent intent2 = new Intent(this, getClass());
                intent2.setFlags(335544320);
                intent2.setAction(intent.getAction());
                if (intent.getCategories() != null) {
                    Iterator<String> it = intent.getCategories().iterator();
                    while (it.hasNext()) {
                        intent2.addCategory(it.next());
                    }
                }
                if (b.a(this, PendingIntent.getActivity(this, 0, intent2, 134217728), (Class<?>) OBBDownloaderService.class) != 0) {
                    h();
                    return;
                }
                this.r.putExtra(GameActivity.DOWNLOAD_RETURN_NAME, 1);
                setResult(-1, this.r);
                finish();
                return;
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("LVLDownloader", "Cannot find own package! MAYDAY!");
                e.printStackTrace();
                return;
            }
        }
        GameActivity.Log.debug("... Can has! Check 'em Dano!");
        if (!c()) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
            builder2.setCancelable(false).setTitle("Select OBB to use").setItems(this.p, new DialogInterface.OnClickListener() { // from class: com.pubg.imobile.DownloaderActivity.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DownloaderActivity.d(i);
                    DownloaderActivity.this.g();
                }
            });
            builder2.create().show();
            return;
        }
        g();
    }

    @Override // android.app.Activity
    protected void onStart() {
        g gVar = this.o;
        if (gVar != null) {
            gVar.a(this);
        }
        super.onStart();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        GameActivity.Log.debug("In onPause");
        if (this.r.getIntExtra(GameActivity.DOWNLOAD_RETURN_NAME, 0) == 0) {
            GameActivity.Log.debug("onPause returning that user quit the download.");
            this.r.putExtra(GameActivity.DOWNLOAD_RETURN_NAME, 3);
            setResult(-1, this.r);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        g gVar = this.o;
        if (gVar != null) {
            gVar.b(this);
        }
        super.onStop();
        setResult(-1, this.r);
    }

    @Override // com.google.android.vending.expansion.downloader.e
    public void a(Messenger messenger) {
        this.n = c.a(messenger);
        this.n.a(this.o.a());
    }

    @Override // com.google.android.vending.expansion.downloader.e
    public void a(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        c(i);
        boolean z4 = true;
        switch (i) {
            case 1:
                z = false;
                z2 = false;
                z3 = true;
                break;
            case 2:
            case 3:
                z = false;
                z2 = false;
                z3 = true;
                break;
            case 4:
                z = false;
                z2 = false;
                z3 = false;
                break;
            case 5:
                f();
                return;
            case 6:
            case 10:
            case 11:
            case 13:
            case 17:
            default:
                z = false;
                z2 = true;
                z3 = true;
                break;
            case 7:
                z = false;
                z2 = true;
                z3 = false;
                break;
            case 8:
            case 9:
                z = true;
                z4 = false;
                z2 = true;
                z3 = false;
                break;
            case 12:
            case 14:
                z = false;
                z2 = true;
                z3 = false;
                break;
            case 15:
            case 16:
            case 18:
            case 19:
                z = false;
                z4 = false;
                z2 = true;
                z3 = false;
                break;
        }
        int i2 = z4 ? 0 : 8;
        if (this.h.getVisibility() != i2) {
            this.h.setVisibility(i2);
        }
        int i3 = z ? 0 : 8;
        if (this.i.getVisibility() != i3) {
            this.i.setVisibility(i3);
        }
        this.b.setIndeterminate(z3);
        a(z2);
    }

    @Override // com.google.android.vending.expansion.downloader.e
    public void a(DownloadProgressInfo downloadProgressInfo) {
        this.f.setText(getString(R.string.kilobytes_per_second, new Object[]{d.a(downloadProgressInfo.d)}));
        this.g.setText(getString(R.string.time_remaining, new Object[]{d.a(downloadProgressInfo.c)}));
        downloadProgressInfo.f5356a = downloadProgressInfo.f5356a;
        this.b.setMax((int) (downloadProgressInfo.f5356a >> 8));
        this.b.setProgress((int) (downloadProgressInfo.b >> 8));
        this.e.setText(Long.toString((downloadProgressInfo.b * 100) / downloadProgressInfo.f5356a) + "%");
        this.d.setText(d.a(downloadProgressInfo.b, downloadProgressInfo.f5356a));
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.s = true;
        super.onDestroy();
    }
}
