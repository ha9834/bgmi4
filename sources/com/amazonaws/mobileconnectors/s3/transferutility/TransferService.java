package com.amazonaws.mobileconnectors.s3.transferutility;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.amazonaws.services.s3.AmazonS3;
import com.tencent.midas.oversea.comm.NetWorkChangeReceiver;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes.dex */
public class TransferService extends Service {
    static final String INTENT_ACTION_TRANSFER_ADD = "add_transfer";
    static final String INTENT_ACTION_TRANSFER_CANCEL = "cancel_transfer";
    static final String INTENT_ACTION_TRANSFER_PAUSE = "pause_transfer";
    static final String INTENT_ACTION_TRANSFER_RESUME = "resume_transfer";
    static final String INTENT_BUNDLE_S3_REFERENCE_KEY = "s3_reference_key";
    static final String INTENT_BUNDLE_TRANSFER_ID = "id";
    private static final int MINUTE_IN_MILLIS = 60000;
    static final int MSG_CHECK = 200;
    static final int MSG_DISCONNECT = 300;
    static final int MSG_EXEC = 100;
    private TransferDBUtil dbUtil;
    private HandlerThread handlerThread;
    private volatile long lastActiveTime;
    private NetworkInfoReceiver networkInfoReceiver;
    private AmazonS3 s3;
    private volatile int startId;
    private Handler updateHandler;
    TransferStatusUpdater updater;
    private static final Log LOGGER = LogFactory.getLog(TransferService.class);
    private static final String TAG = TransferService.class.getSimpleName();
    private boolean shouldScan = true;
    private boolean isFirst = true;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Can't bind to TransferService");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LOGGER.debug("Starting Transfer Service");
        this.dbUtil = new TransferDBUtil(getApplicationContext());
        this.updater = new TransferStatusUpdater(this.dbUtil);
        this.handlerThread = new HandlerThread(TAG + "-AWSTransferUpdateHandlerThread");
        this.handlerThread.start();
        setHandlerLooper(this.handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class NetworkInfoReceiver extends BroadcastReceiver {
        private final ConnectivityManager connManager;
        private final Handler handler;

        public NetworkInfoReceiver(Context context, Handler handler) {
            this.handler = handler;
            this.connManager = (ConnectivityManager) context.getSystemService("connectivity");
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (NetWorkChangeReceiver.NETWORK_CHANGE_ACTION.equals(intent.getAction())) {
                boolean isNetworkConnected = isNetworkConnected();
                TransferService.LOGGER.debug("Network connected: " + isNetworkConnected);
                this.handler.sendEmptyMessage(isNetworkConnected ? 200 : 300);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isNetworkConnected() {
            NetworkInfo activeNetworkInfo = this.connManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.startId = i2;
        if (intent == null) {
            return 3;
        }
        this.s3 = S3ClientReference.get(intent.getStringExtra(INTENT_BUNDLE_S3_REFERENCE_KEY));
        if (this.s3 == null) {
            LOGGER.warn("TransferService can't get s3 client, and it will stop.");
            stopSelf(i2);
            return 2;
        }
        Handler handler = this.updateHandler;
        handler.sendMessage(handler.obtainMessage(100, intent));
        if (this.isFirst) {
            registerReceiver(this.networkInfoReceiver, new IntentFilter(NetWorkChangeReceiver.NETWORK_CHANGE_ACTION));
            this.isFirst = false;
        }
        return 2;
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            unregisterReceiver(this.networkInfoReceiver);
        } catch (IllegalArgumentException e) {
            LOGGER.warn("exception trying to destroy the service", e);
        }
        this.handlerThread.quit();
        TransferThreadPool.closeThreadPool();
        S3ClientReference.clear();
        this.dbUtil.closeDB();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class UpdateHandler extends Handler {
        public UpdateHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 200) {
                TransferService.this.updateHandler.removeMessages(200);
                TransferService.this.checkTransfers();
                return;
            }
            if (message.what == 100) {
                TransferService.this.execCommand((Intent) message.obj);
                return;
            }
            if (message.what != 300) {
                TransferService.LOGGER.error("Unknown command: " + message.what);
                return;
            }
            TransferService.this.pauseAllForNetwork();
        }
    }

    void checkTransfers() {
        if (this.shouldScan && this.networkInfoReceiver.isNetworkConnected() && this.s3 != null) {
            loadTransfersFromDB();
            this.shouldScan = false;
        }
        removeCompletedTransfers();
        if (isActive()) {
            this.lastActiveTime = System.currentTimeMillis();
            this.updateHandler.sendEmptyMessageDelayed(200, 60000L);
        } else {
            LOGGER.debug("Stop self");
            stopSelf(this.startId);
        }
    }

    void execCommand(Intent intent) {
        this.lastActiveTime = System.currentTimeMillis();
        String action = intent.getAction();
        int intExtra = intent.getIntExtra("id", 0);
        if (intExtra == 0) {
            LOGGER.error("Invalid id: " + intExtra);
            return;
        }
        if (INTENT_ACTION_TRANSFER_ADD.equals(action)) {
            if (this.updater.getTransfer(intExtra) != null) {
                LOGGER.warn("Transfer has already been added: " + intExtra);
                return;
            }
            TransferRecord transferById = this.dbUtil.getTransferById(intExtra);
            if (transferById != null) {
                this.updater.addTransfer(transferById);
                transferById.start(this.s3, this.dbUtil, this.updater, this.networkInfoReceiver);
                return;
            }
            LOGGER.error("Can't find transfer: " + intExtra);
            return;
        }
        if (INTENT_ACTION_TRANSFER_PAUSE.equals(action)) {
            TransferRecord transfer = this.updater.getTransfer(intExtra);
            if (transfer == null) {
                transfer = this.dbUtil.getTransferById(intExtra);
            }
            if (transfer != null) {
                transfer.pause(this.s3, this.updater);
                return;
            }
            return;
        }
        if (INTENT_ACTION_TRANSFER_RESUME.equals(action)) {
            TransferRecord transfer2 = this.updater.getTransfer(intExtra);
            if (transfer2 == null) {
                transfer2 = this.dbUtil.getTransferById(intExtra);
                if (transfer2 != null) {
                    this.updater.addTransfer(transfer2);
                } else {
                    LOGGER.error("Can't find transfer: " + intExtra);
                }
            }
            if (transfer2 != null) {
                transfer2.start(this.s3, this.dbUtil, this.updater, this.networkInfoReceiver);
                return;
            }
            return;
        }
        if (INTENT_ACTION_TRANSFER_CANCEL.equals(action)) {
            TransferRecord transfer3 = this.updater.getTransfer(intExtra);
            if (transfer3 == null) {
                transfer3 = this.dbUtil.getTransferById(intExtra);
            }
            if (transfer3 != null) {
                transfer3.cancel(this.s3, this.updater);
                return;
            }
            return;
        }
        LOGGER.error("Unknown action: " + action);
    }

    private boolean isActive() {
        if (this.shouldScan) {
            return true;
        }
        Iterator<TransferRecord> it = this.updater.getTransfers().values().iterator();
        while (it.hasNext()) {
            if (it.next().isRunning()) {
                return true;
            }
        }
        return System.currentTimeMillis() - this.lastActiveTime < 60000;
    }

    private void removeCompletedTransfers() {
        ArrayList arrayList = new ArrayList();
        for (TransferRecord transferRecord : this.updater.getTransfers().values()) {
            if (TransferState.COMPLETED.equals(transferRecord.state)) {
                arrayList.add(Integer.valueOf(transferRecord.id));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.updater.removeTransfer(((Integer) it.next()).intValue());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void loadTransfersFromDB() {
        LOGGER.debug("Loading transfers from database");
        Cursor cursor = null;
        try {
            cursor = this.dbUtil.queryAllTransfersWithType(TransferType.ANY);
            int i = 0;
            while (cursor.moveToNext()) {
                int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                TransferState state = TransferState.getState(cursor.getString(cursor.getColumnIndexOrThrow("state")));
                if ((cursor.getInt(cursor.getColumnIndexOrThrow(TransferTable.COLUMN_PART_NUM)) == 0 && (TransferState.WAITING.equals(state) || TransferState.WAITING_FOR_NETWORK.equals(state) || TransferState.RESUMED_WAITING.equals(state))) || TransferState.IN_PROGRESS.equals(state)) {
                    if (this.updater.getTransfer(i2) == null) {
                        TransferRecord transferRecord = new TransferRecord(i2);
                        transferRecord.updateFromDB(cursor);
                        if (transferRecord.start(this.s3, this.dbUtil, this.updater, this.networkInfoReceiver)) {
                            this.updater.addTransfer(transferRecord);
                            i++;
                        }
                    } else {
                        TransferRecord transfer = this.updater.getTransfer(i2);
                        if (!transfer.isRunning()) {
                            transfer.start(this.s3, this.dbUtil, this.updater, this.networkInfoReceiver);
                        }
                    }
                }
            }
            cursor.close();
            LOGGER.debug(i + " transfers are loaded from database");
        } catch (Throwable th) {
            cursor.close();
            throw th;
        }
    }

    void pauseAllForNetwork() {
        for (TransferRecord transferRecord : this.updater.getTransfers().values()) {
            AmazonS3 amazonS3 = this.s3;
            if (amazonS3 != null && transferRecord != null && transferRecord.pause(amazonS3, this.updater)) {
                this.updater.updateState(transferRecord.id, TransferState.WAITING_FOR_NETWORK);
            }
        }
        this.shouldScan = true;
    }

    void setHandlerLooper(Looper looper) {
        this.updateHandler = new UpdateHandler(looper);
        this.networkInfoReceiver = new NetworkInfoReceiver(getApplicationContext(), this.updateHandler);
    }

    @Override // android.app.Service
    protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if ((getApplicationInfo().flags & 2) == 0) {
            return;
        }
        printWriter.printf("start id: %d\n", Integer.valueOf(this.startId));
        printWriter.printf("network status: %s\n", Boolean.valueOf(this.networkInfoReceiver.isNetworkConnected()));
        printWriter.printf("lastActiveTime: %s, shouldScan: %s\n", new Date(this.lastActiveTime), Boolean.valueOf(this.shouldScan));
        Map<Integer, TransferRecord> transfers = this.updater.getTransfers();
        printWriter.printf("# of active transfers: %d\n", Integer.valueOf(transfers.size()));
        for (TransferRecord transferRecord : transfers.values()) {
            printWriter.printf("bucket: %s, key: %s, status: %s, total size: %d, current: %d\n", transferRecord.bucketName, transferRecord.key, transferRecord.state, Long.valueOf(transferRecord.bytesTotal), Long.valueOf(transferRecord.bytesCurrent));
        }
        printWriter.flush();
    }
}
