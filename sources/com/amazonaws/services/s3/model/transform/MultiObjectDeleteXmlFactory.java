package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.internal.XmlWriter;
import com.amazonaws.services.s3.model.DeleteObjectsRequest;
import com.facebook.internal.ServerProtocol;
import java.util.Iterator;

/* loaded from: classes.dex */
public class MultiObjectDeleteXmlFactory {
    public byte[] convertToXmlByteArray(DeleteObjectsRequest deleteObjectsRequest) throws AmazonClientException {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.start("Delete");
        if (deleteObjectsRequest.getQuiet()) {
            xmlWriter.start("Quiet").value(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE).end();
        }
        Iterator<DeleteObjectsRequest.KeyVersion> it = deleteObjectsRequest.getKeys().iterator();
        while (it.hasNext()) {
            writeKeyVersion(xmlWriter, it.next());
        }
        xmlWriter.end();
        return xmlWriter.getBytes();
    }

    private void writeKeyVersion(XmlWriter xmlWriter, DeleteObjectsRequest.KeyVersion keyVersion) {
        xmlWriter.start("Object");
        xmlWriter.start("Key").value(keyVersion.getKey()).end();
        if (keyVersion.getVersion() != null) {
            xmlWriter.start("VersionId").value(keyVersion.getVersion()).end();
        }
        xmlWriter.end();
    }
}
