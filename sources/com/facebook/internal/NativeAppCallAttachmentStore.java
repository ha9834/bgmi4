package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import kotlin.jvm.internal.h;
import kotlin.text.l;

/* loaded from: classes.dex */
public final class NativeAppCallAttachmentStore {
    public static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
    public static final NativeAppCallAttachmentStore INSTANCE = new NativeAppCallAttachmentStore();
    private static final String TAG;
    private static File attachmentsDirectory;

    static {
        String name = NativeAppCallAttachmentStore.class.getName();
        h.a((Object) name, "NativeAppCallAttachmentStore::class.java.name");
        TAG = name;
    }

    private NativeAppCallAttachmentStore() {
    }

    public static final Attachment createAttachment(UUID uuid, Bitmap bitmap) {
        h.b(uuid, "callId");
        h.b(bitmap, "attachmentBitmap");
        return new Attachment(uuid, bitmap, null);
    }

    public static final Attachment createAttachment(UUID uuid, Uri uri) {
        h.b(uuid, "callId");
        h.b(uri, "attachmentUri");
        return new Attachment(uuid, null, uri);
    }

    private final void processAttachmentBitmap(Bitmap bitmap, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        } finally {
            Utility.closeQuietly(fileOutputStream);
        }
    }

    private final void processAttachmentFile(Uri uri, boolean z, File file) throws IOException {
        FileInputStream openInputStream;
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            if (!z) {
                openInputStream = new FileInputStream(uri.getPath());
            } else {
                Context applicationContext = FacebookSdk.getApplicationContext();
                h.a((Object) applicationContext, "FacebookSdk.getApplicationContext()");
                openInputStream = applicationContext.getContentResolver().openInputStream(uri);
            }
            Utility.copyAndCloseInputStream(openInputStream, fileOutputStream);
        } finally {
            Utility.closeQuietly(fileOutputStream);
        }
    }

    public static final void addAttachments(Collection<Attachment> collection) throws FacebookException {
        File attachmentFile;
        if (collection == null || collection.isEmpty()) {
            return;
        }
        if (attachmentsDirectory == null) {
            cleanupAllAttachments();
        }
        ensureAttachmentsDirectoryExists();
        ArrayList<File> arrayList = new ArrayList();
        try {
            for (Attachment attachment : collection) {
                if (attachment.getShouldCreateFile() && (attachmentFile = getAttachmentFile(attachment.getCallId(), attachment.getAttachmentName(), true)) != null) {
                    arrayList.add(attachmentFile);
                    if (attachment.getBitmap() != null) {
                        INSTANCE.processAttachmentBitmap(attachment.getBitmap(), attachmentFile);
                    } else if (attachment.getOriginalUri() != null) {
                        INSTANCE.processAttachmentFile(attachment.getOriginalUri(), attachment.isContentUri(), attachmentFile);
                    }
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "Got unexpected exception:" + e);
            for (File file : arrayList) {
                if (file != null) {
                    try {
                        file.delete();
                    } catch (Exception unused) {
                    }
                }
            }
            throw new FacebookException(e);
        }
    }

    public static final void cleanupAttachmentsForCall(UUID uuid) {
        h.b(uuid, "callId");
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(uuid, false);
        if (attachmentsDirectoryForCall != null) {
            Utility.deleteDirectory(attachmentsDirectoryForCall);
        }
    }

    public static final File openAttachment(UUID uuid, String str) throws FileNotFoundException {
        if (Utility.isNullOrEmpty(str) || uuid == null) {
            throw new FileNotFoundException();
        }
        try {
            return getAttachmentFile(uuid, str, false);
        } catch (IOException unused) {
            throw new FileNotFoundException();
        }
    }

    public static final synchronized File getAttachmentsDirectory() {
        File file;
        synchronized (NativeAppCallAttachmentStore.class) {
            if (attachmentsDirectory == null) {
                Context applicationContext = FacebookSdk.getApplicationContext();
                h.a((Object) applicationContext, "FacebookSdk.getApplicationContext()");
                attachmentsDirectory = new File(applicationContext.getCacheDir(), ATTACHMENTS_DIR_NAME);
            }
            file = attachmentsDirectory;
        }
        return file;
    }

    public static final File ensureAttachmentsDirectoryExists() {
        File attachmentsDirectory2 = getAttachmentsDirectory();
        if (attachmentsDirectory2 != null) {
            attachmentsDirectory2.mkdirs();
        }
        return attachmentsDirectory2;
    }

    public static final File getAttachmentsDirectoryForCall(UUID uuid, boolean z) {
        h.b(uuid, "callId");
        File file = attachmentsDirectory;
        if (file == null) {
            return null;
        }
        File file2 = new File(file, uuid.toString());
        if (z && !file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public static final File getAttachmentFile(UUID uuid, String str, boolean z) throws IOException {
        h.b(uuid, "callId");
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(uuid, z);
        if (attachmentsDirectoryForCall == null) {
            return null;
        }
        try {
            return new File(attachmentsDirectoryForCall, URLEncoder.encode(str, "UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static final void cleanupAllAttachments() {
        Utility.deleteDirectory(getAttachmentsDirectory());
    }

    /* loaded from: classes.dex */
    public static final class Attachment {
        private final String attachmentName;
        private final String attachmentUrl;
        private final Bitmap bitmap;
        private final UUID callId;
        private boolean isContentUri;
        private final Uri originalUri;
        private boolean shouldCreateFile;

        public Attachment(UUID uuid, Bitmap bitmap, Uri uri) {
            String attachmentUrl;
            h.b(uuid, "callId");
            this.callId = uuid;
            this.bitmap = bitmap;
            this.originalUri = uri;
            Uri uri2 = this.originalUri;
            if (uri2 != null) {
                String scheme = uri2.getScheme();
                if (l.a(FirebaseAnalytics.Param.CONTENT, scheme, true)) {
                    this.isContentUri = true;
                    String authority = this.originalUri.getAuthority();
                    this.shouldCreateFile = (authority == null || l.a(authority, "media", false, 2, (Object) null)) ? false : true;
                } else if (l.a(TransferTable.COLUMN_FILE, this.originalUri.getScheme(), true)) {
                    this.shouldCreateFile = true;
                } else if (!Utility.isWebUri(this.originalUri)) {
                    throw new FacebookException("Unsupported scheme for media Uri : " + scheme);
                }
            } else if (this.bitmap != null) {
                this.shouldCreateFile = true;
            } else {
                throw new FacebookException("Cannot share media without a bitmap or Uri set");
            }
            this.attachmentName = this.shouldCreateFile ? UUID.randomUUID().toString() : null;
            if (!this.shouldCreateFile) {
                attachmentUrl = String.valueOf(this.originalUri);
            } else {
                attachmentUrl = FacebookContentProvider.getAttachmentUrl(FacebookSdk.getApplicationId(), this.callId, this.attachmentName);
                h.a((Object) attachmentUrl, "FacebookContentProvider.…, callId, attachmentName)");
            }
            this.attachmentUrl = attachmentUrl;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        public final UUID getCallId() {
            return this.callId;
        }

        public final Uri getOriginalUri() {
            return this.originalUri;
        }

        public final String getAttachmentUrl() {
            return this.attachmentUrl;
        }

        public final String getAttachmentName() {
            return this.attachmentName;
        }

        public final boolean isContentUri() {
            return this.isContentUri;
        }

        public final void setContentUri(boolean z) {
            this.isContentUri = z;
        }

        public final boolean getShouldCreateFile() {
            return this.shouldCreateFile;
        }

        public final void setShouldCreateFile(boolean z) {
            this.shouldCreateFile = z;
        }
    }
}
