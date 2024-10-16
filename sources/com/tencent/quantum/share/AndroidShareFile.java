package com.tencent.quantum.share;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.widget.Toast;
import com.epicgames.ue4.GameActivity;
import com.google.android.gms.drive.DriveFile;
import com.helpshift.util.AttachmentConstants;
import java.io.File;

/* loaded from: classes.dex */
public class AndroidShareFile {
    public static void AndroidThunkJava_shareFile(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.STREAM", QuantumFileProvider.getUriForFile(GameActivity.Get().getApplicationContext(), GameActivity.Get().getApplicationContext().getPackageName() + ".share.provider", file));
                intent.setType(getMimeType(file.getAbsolutePath()));
                intent.setFlags(DriveFile.MODE_READ_ONLY);
                intent.addFlags(1);
                GameActivity.Get().startActivity(Intent.createChooser(intent, "Share File"));
            } else {
                Toast.makeText(GameActivity.Get().getApplicationContext(), "File Dont exists! " + str, 1).show();
            }
        } catch (Exception e) {
            Toast.makeText(GameActivity.Get().getApplicationContext(), "Get File Failed! " + e.getMessage() + str, 1).show();
        }
    }

    private static String getMimeType(String str) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        if (str == null) {
            return AttachmentConstants.ALLOW_ALL_MIME;
        }
        try {
            mediaMetadataRetriever.setDataSource(str);
            return mediaMetadataRetriever.extractMetadata(12);
        } catch (IllegalArgumentException unused) {
            return AttachmentConstants.ALLOW_ALL_MIME;
        } catch (IllegalStateException unused2) {
            return AttachmentConstants.ALLOW_ALL_MIME;
        } catch (RuntimeException unused3) {
            return AttachmentConstants.ALLOW_ALL_MIME;
        }
    }
}
