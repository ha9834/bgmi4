package com.helpshift.android.commons.downloader.runnable;

import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener;
import com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener;
import com.helpshift.util.HSLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class RawResponseDownloadRunnable extends BaseDownloadRunnable {
    private static final String TAG = "Helpshift_RawDownRun";

    @Override // com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable
    protected void clearCache() {
    }

    @Override // com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable
    protected long getAlreadyDownloadedBytes() {
        return 0L;
    }

    @Override // com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable
    protected boolean isGzipSupported() {
        return true;
    }

    public RawResponseDownloadRunnable(DownloadRequestedFileInfo downloadRequestedFileInfo, NetworkAuthDataFetcher networkAuthDataFetcher, OnProgressChangedListener onProgressChangedListener, OnDownloadFinishListener onDownloadFinishListener) {
        super(downloadRequestedFileInfo, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable
    protected void processHttpResponse(InputStream inputStream, int i, int i2, String str) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else {
                        sb.append(readLine);
                    }
                } catch (IOException e) {
                    HSLogger.d(TAG, "IO Exception while reading response", e);
                }
            } finally {
                closeFileStream(bufferedReader);
            }
        }
        try {
            try {
                notifyDownloadFinish(true, new JSONObject(sb.toString()), i2, str);
            } catch (JSONException unused) {
                notifyDownloadFinish(true, sb, i2, str);
            }
        } catch (JSONException unused2) {
            notifyDownloadFinish(true, new JSONArray(sb.toString()), i2, str);
        }
    }
}
