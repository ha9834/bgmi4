package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.s3.internal.S3Direct;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyPartRequest;
import com.amazonaws.services.s3.model.CopyPartResult;
import com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazonaws.services.s3.model.CryptoMode;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutInstructionFileRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.UploadObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class CryptoModuleDispatcher extends S3CryptoModule<MultipartUploadContext> {
    private final S3CryptoModuleAE ae;
    private final CryptoMode defaultCryptoMode;
    private final S3CryptoModuleEO eo;

    public CryptoModuleDispatcher(AWSKMSClient aWSKMSClient, S3Direct s3Direct, AWSCredentialsProvider aWSCredentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        CryptoConfiguration mo3clone = cryptoConfiguration.mo3clone();
        if (mo3clone.getCryptoMode() == null) {
            mo3clone.setCryptoMode(CryptoMode.EncryptionOnly);
        }
        CryptoConfiguration readOnly = mo3clone.readOnly();
        this.defaultCryptoMode = readOnly.getCryptoMode();
        switch (this.defaultCryptoMode) {
            case StrictAuthenticatedEncryption:
                this.ae = new S3CryptoModuleAEStrict(aWSKMSClient, s3Direct, aWSCredentialsProvider, encryptionMaterialsProvider, readOnly);
                this.eo = null;
                return;
            case AuthenticatedEncryption:
                this.ae = new S3CryptoModuleAE(aWSKMSClient, s3Direct, aWSCredentialsProvider, encryptionMaterialsProvider, readOnly);
                this.eo = null;
                return;
            case EncryptionOnly:
                this.eo = new S3CryptoModuleEO(aWSKMSClient, s3Direct, aWSCredentialsProvider, encryptionMaterialsProvider, readOnly);
                CryptoConfiguration mo3clone2 = readOnly.mo3clone();
                try {
                    mo3clone2.setCryptoMode(CryptoMode.AuthenticatedEncryption);
                } catch (UnsupportedOperationException unused) {
                }
                this.ae = new S3CryptoModuleAE(aWSKMSClient, s3Direct, aWSCredentialsProvider, encryptionMaterialsProvider, mo3clone2.readOnly());
                return;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public PutObjectResult putObjectSecurely(PutObjectRequest putObjectRequest) {
        if (this.defaultCryptoMode == CryptoMode.EncryptionOnly) {
            return this.eo.putObjectSecurely(putObjectRequest);
        }
        return this.ae.putObjectSecurely(putObjectRequest);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public S3Object getObjectSecurely(GetObjectRequest getObjectRequest) {
        return this.ae.getObjectSecurely(getObjectRequest);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public ObjectMetadata getObjectSecurely(GetObjectRequest getObjectRequest, File file) {
        return this.ae.getObjectSecurely(getObjectRequest, file);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public CompleteMultipartUploadResult completeMultipartUploadSecurely(CompleteMultipartUploadRequest completeMultipartUploadRequest) {
        if (this.defaultCryptoMode == CryptoMode.EncryptionOnly) {
            return this.eo.completeMultipartUploadSecurely(completeMultipartUploadRequest);
        }
        return this.ae.completeMultipartUploadSecurely(completeMultipartUploadRequest);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public void abortMultipartUploadSecurely(AbortMultipartUploadRequest abortMultipartUploadRequest) {
        if (this.defaultCryptoMode == CryptoMode.EncryptionOnly) {
            this.eo.abortMultipartUploadSecurely(abortMultipartUploadRequest);
        } else {
            this.ae.abortMultipartUploadSecurely(abortMultipartUploadRequest);
        }
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public InitiateMultipartUploadResult initiateMultipartUploadSecurely(InitiateMultipartUploadRequest initiateMultipartUploadRequest) {
        if (this.defaultCryptoMode == CryptoMode.EncryptionOnly) {
            return this.eo.initiateMultipartUploadSecurely(initiateMultipartUploadRequest);
        }
        return this.ae.initiateMultipartUploadSecurely(initiateMultipartUploadRequest);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public UploadPartResult uploadPartSecurely(UploadPartRequest uploadPartRequest) {
        if (this.defaultCryptoMode == CryptoMode.EncryptionOnly) {
            return this.eo.uploadPartSecurely(uploadPartRequest);
        }
        return this.ae.uploadPartSecurely(uploadPartRequest);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public CopyPartResult copyPartSecurely(CopyPartRequest copyPartRequest) {
        if (this.defaultCryptoMode == CryptoMode.EncryptionOnly) {
            return this.eo.copyPartSecurely(copyPartRequest);
        }
        return this.ae.copyPartSecurely(copyPartRequest);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public PutObjectResult putInstructionFileSecurely(PutInstructionFileRequest putInstructionFileRequest) {
        if (this.defaultCryptoMode == CryptoMode.EncryptionOnly) {
            return this.eo.putInstructionFileSecurely(putInstructionFileRequest);
        }
        return this.ae.putInstructionFileSecurely(putInstructionFileRequest);
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public void putLocalObjectSecurely(UploadObjectRequest uploadObjectRequest, String str, OutputStream outputStream) throws IOException {
        if (this.defaultCryptoMode == CryptoMode.EncryptionOnly) {
            this.eo.putLocalObjectSecurely(uploadObjectRequest, str, outputStream);
        } else {
            this.ae.putLocalObjectSecurely(uploadObjectRequest, str, outputStream);
        }
    }
}
