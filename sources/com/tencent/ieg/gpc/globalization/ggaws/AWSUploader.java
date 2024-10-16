package com.tencent.ieg.gpc.globalization.ggaws;

import android.app.Activity;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferListener;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferState;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.tencent.ieg.gpc.globalization.base.GGConfig;
import com.tencent.ieg.gpc.globalization.base.GGCore;
import com.tencent.ieg.gpc.globalization.base.uploader.GGUploader;
import com.tencent.ieg.gpc.globalization.base.uploader.GGUploaderState;
import com.tencent.ieg.gpc.globalization.utils.GGLog;
import java.io.File;

/* loaded from: classes2.dex */
public class AWSUploader extends GGUploader {
    private static final String AWS_AUTHOR_REGION = "AWS_AUTHOR_REGION";
    private static final String AWS_BUKET_NAME = "AWS_BUKET_NAME";
    private static final String AWS_POOL_ID = "AWS_POOL_ID";
    private static final String AWS_REGION = "AWS_REGION";
    private static final String AWS_SUB_FOLDER = "AWS_SUB_FOLDER";
    private static final String CDN_PATH_CONF = "CDN_PATH_CONF";
    private static String TAG = "AWSUploader";
    CognitoCachingCredentialsProvider credentialsProvider;
    private TransferUtility transferUtility;
    private String aws_upload_file = "";
    public TransferListener awsTransferListener = new TransferListener() { // from class: com.tencent.ieg.gpc.globalization.ggaws.AWSUploader.1
        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void onStateChanged(int i, TransferState transferState) {
            GGLog.d(AWSUploader.TAG, "onStateChanged =" + transferState.name());
            String str = "";
            AWSUploader.this.taskId = i;
            if (transferState == TransferState.COMPLETED) {
                String config = GGConfig.getConfig(AWSUploader.CDN_PATH_CONF);
                if (!config.isEmpty()) {
                    str = config.replaceAll("\\{AWS_BUKET_NAME\\}", GGConfig.getConfig(AWSUploader.AWS_BUKET_NAME)).replaceAll("\\{AWS_REGION\\}", GGConfig.getConfig(AWSUploader.AWS_REGION)).replaceAll("\\{FILE_PATH\\}", AWSUploader.this.aws_upload_file);
                } else {
                    str = String.format("https://%s.s3-%s.amazonaws.com/%s", GGConfig.getConfig(AWSUploader.AWS_BUKET_NAME), GGConfig.getConfig(AWSUploader.AWS_REGION), AWSUploader.this.aws_upload_file);
                }
                AWSUploader.this.taskId = 0;
                AWSUploader.this.stopTimer();
                GGLog.d(AWSUploader.TAG, String.format("image URL= %s", str));
            }
            if (AWSUploader.this.uploaderListener != null) {
                AWSUploader.this.uploaderListener.onStateChanged(i, GGUploaderState.getState(transferState.toString()), str);
            }
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void onProgressChanged(int i, long j, long j2) {
            GGLog.d(AWSUploader.TAG, "onProgressChanged =" + String.valueOf((int) ((j / j2) * 100)));
            if (AWSUploader.this.uploaderListener != null) {
                AWSUploader.this.uploaderListener.onProgressChanged(i, j, j2);
            }
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void onError(int i, Exception exc) {
            GGLog.e(AWSUploader.TAG, exc.getMessage());
            AWSUploader.this.taskId = 0;
            AWSUploader.this.stopTimer();
            if (AWSUploader.this.uploaderListener != null) {
                AWSUploader.this.uploaderListener.onError(i, exc);
            }
        }
    };

    @Override // com.tencent.ieg.gpc.globalization.base.GGMoudle, com.tencent.ieg.gpc.globalization.base.interfaces.IModule
    public void initialize(Activity activity) {
        super.initialize(activity);
        String config = GGConfig.getConfig(AWS_POOL_ID);
        String config2 = GGConfig.getConfig(AWS_AUTHOR_REGION);
        if (config2.isEmpty()) {
            GGLog.d(TAG, "AWS_AUTHOR_REGION is not set and will read AWS_REGION value instead");
            config2 = GGConfig.getConfig(AWS_REGION);
        }
        Regions fromName = Regions.fromName(config2);
        this.credentialsProvider = new CognitoCachingCredentialsProvider(this.currentActivity.getApplicationContext(), new DeveloperAuthenticationProvider("", config, fromName, this.currentActivity.getApplicationContext()), fromName);
    }

    @Override // com.tencent.ieg.gpc.globalization.base.uploader.GGUploader
    public void upload(String str, String str2) {
        super.upload(str);
        GGLog.d(TAG, "upload :" + str);
        String replaceAll = str.replaceAll("file:", "");
        Regions fromName = Regions.fromName(GGConfig.getConfig(AWS_REGION));
        AmazonS3Client amazonS3Client = new AmazonS3Client(this.credentialsProvider);
        amazonS3Client.setRegion(Region.getRegion(fromName));
        this.transferUtility = new TransferUtility(amazonS3Client, this.currentActivity.getApplicationContext());
        File file = new File(replaceAll);
        if (str2.isEmpty()) {
            str2 = GGConfig.getConfig(AWS_SUB_FOLDER);
            if (str2.isEmpty()) {
                str2 = file.getName();
            }
        }
        String replaceAll2 = String.format("%s.%s", str2, file.getName().substring(file.getName().lastIndexOf(".") + 1)).replaceAll("\\{TIME_STAMP\\}", String.valueOf(System.currentTimeMillis()));
        this.aws_upload_file = replaceAll2.replaceAll("\\{FILE_NAME\\}", replaceAll2).replaceAll("\\{OPENID\\}", GGCore.getOpenid());
        this.transferUtility.upload(GGConfig.getConfig(AWS_BUKET_NAME), this.aws_upload_file, file).setTransferListener(this.awsTransferListener);
        startTimer();
    }

    @Override // com.tencent.ieg.gpc.globalization.base.uploader.GGUploader
    public void upload(String str) {
        upload(str, "");
    }

    @Override // com.tencent.ieg.gpc.globalization.base.uploader.GGUploader
    public void cancelUpload(int i) {
        super.cancelUpload(i);
        TransferUtility transferUtility = this.transferUtility;
        if (transferUtility != null) {
            transferUtility.cancel(i);
        }
    }
}
