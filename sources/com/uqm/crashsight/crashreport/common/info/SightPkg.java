package com.uqm.crashsight.crashreport.common.info;

import com.uqm.crashsight.protobuf.AbstractMessageLite;
import com.uqm.crashsight.protobuf.ByteString;
import com.uqm.crashsight.protobuf.CodedInputStream;
import com.uqm.crashsight.protobuf.ExtensionRegistryLite;
import com.uqm.crashsight.protobuf.GeneratedMessageLite;
import com.uqm.crashsight.protobuf.Internal;
import com.uqm.crashsight.protobuf.InvalidProtocolBufferException;
import com.uqm.crashsight.protobuf.MapEntryLite;
import com.uqm.crashsight.protobuf.MapFieldLite;
import com.uqm.crashsight.protobuf.MessageLiteOrBuilder;
import com.uqm.crashsight.protobuf.Parser;
import com.uqm.crashsight.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class SightPkg {

    /* loaded from: classes3.dex */
    public interface AppInfoOrBuilder extends MessageLiteOrBuilder {
        boolean containsValueMap(String str);

        String getArch();

        ByteString getArchBytes();

        String getBaseAddr();

        ByteString getBaseAddrBytes();

        String getName();

        ByteString getNameBytes();

        String getUUID();

        ByteString getUUIDBytes();

        @Deprecated
        Map<String, String> getValueMap();

        int getValueMapCount();

        Map<String, String> getValueMapMap();

        String getValueMapOrDefault(String str, String str2);

        String getValueMapOrThrow(String str);

        String getVer();

        ByteString getVerBytes();
    }

    /* loaded from: classes3.dex */
    public interface AppSessionOrBuilder extends MessageLiteOrBuilder {
        String getEvents(int i);

        ByteString getEventsBytes(int i);

        int getEventsCount();

        List<String> getEventsList();

        String getSessionId();

        ByteString getSessionIdBytes();
    }

    /* loaded from: classes3.dex */
    public interface AttachmentOrBuilder extends MessageLiteOrBuilder {
        ByteString getData();

        String getFileName();

        ByteString getFileNameBytes();

        int getType();
    }

    /* loaded from: classes3.dex */
    public interface ExceptionUploadOrBuilder extends MessageLiteOrBuilder {
        boolean containsAllStacks(String str);

        boolean containsUserMap(String str);

        boolean containsValueMap(String str);

        @Deprecated
        Map<String, String> getAllStacks();

        int getAllStacksCount();

        Map<String, String> getAllStacksMap();

        String getAllStacksOrDefault(String str, String str2);

        String getAllStacksOrThrow(String str);

        AppInfo getAppInfo();

        Attachment getAttaches(int i);

        int getAttachesCount();

        List<Attachment> getAttachesList();

        String getCallStack();

        ByteString getCallStackBytes();

        boolean getColdStart();

        int getCrashCount();

        String getCrashThread();

        ByteString getCrashThreadBytes();

        long getCrashTime();

        String getDeviceId();

        ByteString getDeviceIdBytes();

        String getExpAddr();

        ByteString getExpAddrBytes();

        String getExpMessage();

        ByteString getExpMessageBytes();

        String getExpName();

        ByteString getExpNameBytes();

        String getExpuid();

        ByteString getExpuidBytes();

        String getGatewayIp();

        ByteString getGatewayIpBytes();

        AppInfo getLibInfos(int i);

        int getLibInfosCount();

        List<AppInfo> getLibInfosList();

        AppInfo getPlugins(int i);

        int getPluginsCount();

        List<AppInfo> getPluginsList();

        AppSession getSession();

        String getType();

        ByteString getTypeBytes();

        @Deprecated
        Map<String, String> getUserMap();

        int getUserMapCount();

        Map<String, String> getUserMapMap();

        String getUserMapOrDefault(String str, String str2);

        String getUserMapOrThrow(String str);

        String getUserid();

        ByteString getUseridBytes();

        @Deprecated
        Map<String, String> getValueMap();

        int getValueMapCount();

        Map<String, String> getValueMapMap();

        String getValueMapOrDefault(String str, String str2);

        String getValueMapOrThrow(String str);

        boolean hasAppInfo();

        boolean hasSession();
    }

    /* loaded from: classes3.dex */
    public interface ExceptionUploadPackageOrBuilder extends MessageLiteOrBuilder {
        ExceptionUpload getList(int i);

        int getListCount();

        List<ExceptionUpload> getListList();
    }

    /* loaded from: classes3.dex */
    public interface RequestPkgOrBuilder extends MessageLiteOrBuilder {
        boolean containsReserved(String str);

        String getAndroidId();

        ByteString getAndroidIdBytes();

        String getApn();

        ByteString getApnBytes();

        String getBundleId();

        ByteString getBundleIdBytes();

        String getChannel();

        ByteString getChannelBytes();

        int getCmd();

        String getDeviceId();

        ByteString getDeviceIdBytes();

        String getIdfv();

        ByteString getIdfvBytes();

        String getImei();

        ByteString getImeiBytes();

        String getImsi();

        ByteString getImsiBytes();

        String getMac();

        ByteString getMacBytes();

        String getModel();

        ByteString getModelBytes();

        String getNetworkType();

        ByteString getNetworkTypeBytes();

        String getOsVer();

        ByteString getOsVerBytes();

        int getPlatformId();

        String getProdId();

        ByteString getProdIdBytes();

        String getQimei();

        ByteString getQimeiBytes();

        @Deprecated
        Map<String, String> getReserved();

        int getReservedCount();

        Map<String, String> getReservedMap();

        String getReservedOrDefault(String str, String str2);

        String getReservedOrThrow(String str);

        ByteString getSBuffer();

        String getSdkId();

        ByteString getSdkIdBytes();

        String getSdkVer();

        ByteString getSdkVerBytes();

        String getSessionId();

        ByteString getSessionIdBytes();

        long getStrategylastUpdateTime();

        long getUploadTime();

        String getVersion();

        ByteString getVersionBytes();
    }

    /* loaded from: classes3.dex */
    public interface ResponsePkgOrBuilder extends MessageLiteOrBuilder {
        boolean containsValueMap(String str);

        int getCmd();

        String getGatewayIp();

        ByteString getGatewayIpBytes();

        String getQimei();

        ByteString getQimeiBytes();

        long getResult();

        ByteString getSBuffer();

        long getServerTime();

        String getStatus();

        ByteString getStatusBytes();

        @Deprecated
        Map<String, String> getValueMap();

        int getValueMapCount();

        Map<String, String> getValueMapMap();

        String getValueMapOrDefault(String str, String str2);

        String getValueMapOrThrow(String str);
    }

    /* loaded from: classes3.dex */
    public interface RqdSecurityOrBuilder extends MessageLiteOrBuilder {
        String getEncKey();

        ByteString getEncKeyBytes();

        String getEncPubKey();

        ByteString getEncPubKeyBytes();
    }

    /* loaded from: classes3.dex */
    public interface RqdStrategyOrBuilder extends MessageLiteOrBuilder {
        boolean containsValueMap(String str);

        boolean getEnable();

        boolean getEnableQuery();

        boolean getEnableUserInfo();

        int getEventRecordCount();

        int getEventTimeInterval();

        String getExpUrl();

        ByteString getExpUrlBytes();

        String getHttpsExpUrl();

        ByteString getHttpsExpUrlBytes();

        String getHttpsUrl();

        ByteString getHttpsUrlBytes();

        RqdSecurity getSecurity();

        long getStrategylastUpdateTime();

        String getUrl();

        ByteString getUrlBytes();

        @Deprecated
        Map<String, String> getValueMap();

        int getValueMapCount();

        Map<String, String> getValueMapMap();

        String getValueMapOrDefault(String str, String str2);

        String getValueMapOrThrow(String str);

        boolean hasSecurity();
    }

    /* loaded from: classes3.dex */
    public interface SummaryInfoOrBuilder extends MessageLiteOrBuilder {
        boolean containsValueMap(String str);

        boolean getColdStart();

        String getGatewayIp();

        ByteString getGatewayIpBytes();

        String getProceName();

        ByteString getProceNameBytes();

        String getSessionId();

        ByteString getSessionIdBytes();

        long getStartTime();

        int getStartType();

        String getUserId();

        ByteString getUserIdBytes();

        @Deprecated
        Map<String, String> getValueMap();

        int getValueMapCount();

        Map<String, String> getValueMapMap();

        String getValueMapOrDefault(String str, String str2);

        String getValueMapOrThrow(String str);
    }

    /* loaded from: classes3.dex */
    public interface UniPacketOrBuilder extends MessageLiteOrBuilder {
        String getEncodeName();

        ByteString getEncodeNameBytes();

        int getIRequestId();

        int getIVersion();

        RequestPkg getRequest();

        ResponsePkg getResponse();

        String getSFuncName();

        ByteString getSFuncNameBytes();

        String getSServantName();

        ByteString getSServantNameBytes();

        boolean hasRequest();

        boolean hasResponse();
    }

    /* loaded from: classes3.dex */
    public interface UserInfoListOrBuilder extends MessageLiteOrBuilder {
        UserInfoPackage getList(int i);

        int getListCount();

        List<UserInfoPackage> getListList();
    }

    /* loaded from: classes3.dex */
    public interface UserInfoPackageOrBuilder extends MessageLiteOrBuilder {
        boolean containsValueMap(String str);

        String getDeviceId();

        ByteString getDeviceIdBytes();

        SummaryInfo getList(int i);

        int getListCount();

        List<SummaryInfo> getListList();

        String getProceName();

        ByteString getProceNameBytes();

        int getType();

        @Deprecated
        Map<String, String> getValueMap();

        int getValueMapCount();

        Map<String, String> getValueMapMap();

        String getValueMapOrDefault(String str, String str2);

        String getValueMapOrThrow(String str);
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private SightPkg() {
    }

    /* loaded from: classes3.dex */
    public static final class ResponsePkg extends GeneratedMessageLite<ResponsePkg, Builder> implements ResponsePkgOrBuilder {
        public static final int CMD_FIELD_NUMBER = 2;
        private static final ResponsePkg DEFAULT_INSTANCE;
        public static final int GATEWAYIP_FIELD_NUMBER = 4;
        private static volatile Parser<ResponsePkg> PARSER = null;
        public static final int QIMEI_FIELD_NUMBER = 7;
        public static final int RESULT_FIELD_NUMBER = 1;
        public static final int SBUFFER_FIELD_NUMBER = 3;
        public static final int SERVERTIME_FIELD_NUMBER = 5;
        public static final int STATUS_FIELD_NUMBER = 6;
        public static final int VALUEMAP_FIELD_NUMBER = 8;
        private int cmd_;
        private long result_;
        private long serverTime_;
        private MapFieldLite<String, String> valueMap_ = MapFieldLite.a();
        private ByteString sBuffer_ = ByteString.f6635a;
        private String gatewayIp_ = "";
        private String status_ = "";
        private String qimei_ = "";

        /* loaded from: classes3.dex */
        static final class a {

            /* renamed from: a, reason: collision with root package name */
            static final MapEntryLite<String, String> f6565a = MapEntryLite.a(WireFormat.FieldType.i, "", WireFormat.FieldType.i, "");
        }

        static /* synthetic */ void access$1200(ResponsePkg responsePkg, String str) {
            str.getClass();
            responsePkg.status_ = str;
        }

        static /* synthetic */ void access$1300(ResponsePkg responsePkg) {
            responsePkg.status_ = getDefaultInstance().getStatus();
        }

        static /* synthetic */ void access$1400(ResponsePkg responsePkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            responsePkg.status_ = byteString.f();
        }

        static /* synthetic */ void access$1500(ResponsePkg responsePkg, String str) {
            str.getClass();
            responsePkg.qimei_ = str;
        }

        static /* synthetic */ void access$1600(ResponsePkg responsePkg) {
            responsePkg.qimei_ = getDefaultInstance().getQimei();
        }

        static /* synthetic */ void access$1700(ResponsePkg responsePkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            responsePkg.qimei_ = byteString.f();
        }

        static /* synthetic */ void access$500(ResponsePkg responsePkg, ByteString byteString) {
            byteString.getClass();
            responsePkg.sBuffer_ = byteString;
        }

        static /* synthetic */ void access$600(ResponsePkg responsePkg) {
            responsePkg.sBuffer_ = getDefaultInstance().getSBuffer();
        }

        static /* synthetic */ void access$700(ResponsePkg responsePkg, String str) {
            str.getClass();
            responsePkg.gatewayIp_ = str;
        }

        static /* synthetic */ void access$800(ResponsePkg responsePkg) {
            responsePkg.gatewayIp_ = getDefaultInstance().getGatewayIp();
        }

        static /* synthetic */ void access$900(ResponsePkg responsePkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            responsePkg.gatewayIp_ = byteString.f();
        }

        private ResponsePkg() {
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        public final long getResult() {
            return this.result_;
        }

        private void setResult(long j) {
            this.result_ = j;
        }

        private void clearResult() {
            this.result_ = 0L;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        public final int getCmd() {
            return this.cmd_;
        }

        private void setCmd(int i) {
            this.cmd_ = i;
        }

        private void clearCmd() {
            this.cmd_ = 0;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        public final ByteString getSBuffer() {
            return this.sBuffer_;
        }

        private void setSBuffer(ByteString byteString) {
            byteString.getClass();
            this.sBuffer_ = byteString;
        }

        private void clearSBuffer() {
            this.sBuffer_ = getDefaultInstance().getSBuffer();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        public final String getGatewayIp() {
            return this.gatewayIp_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        public final ByteString getGatewayIpBytes() {
            return ByteString.a(this.gatewayIp_);
        }

        private void setGatewayIp(String str) {
            str.getClass();
            this.gatewayIp_ = str;
        }

        private void clearGatewayIp() {
            this.gatewayIp_ = getDefaultInstance().getGatewayIp();
        }

        private void setGatewayIpBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.gatewayIp_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        public final long getServerTime() {
            return this.serverTime_;
        }

        private void setServerTime(long j) {
            this.serverTime_ = j;
        }

        private void clearServerTime() {
            this.serverTime_ = 0L;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        public final String getStatus() {
            return this.status_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        public final ByteString getStatusBytes() {
            return ByteString.a(this.status_);
        }

        private void setStatus(String str) {
            str.getClass();
            this.status_ = str;
        }

        private void clearStatus() {
            this.status_ = getDefaultInstance().getStatus();
        }

        private void setStatusBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.status_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        public final String getQimei() {
            return this.qimei_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        public final ByteString getQimeiBytes() {
            return ByteString.a(this.qimei_);
        }

        private void setQimei(String str) {
            str.getClass();
            this.qimei_ = str;
        }

        private void clearQimei() {
            this.qimei_ = getDefaultInstance().getQimei();
        }

        private void setQimeiBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.qimei_ = byteString.f();
        }

        private MapFieldLite<String, String> internalGetValueMap() {
            return this.valueMap_;
        }

        private MapFieldLite<String, String> internalGetMutableValueMap() {
            if (!this.valueMap_.d()) {
                this.valueMap_ = this.valueMap_.b();
            }
            return this.valueMap_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        public final int getValueMapCount() {
            return internalGetValueMap().size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        public final boolean containsValueMap(String str) {
            str.getClass();
            return internalGetValueMap().containsKey(str);
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        @Deprecated
        public final Map<String, String> getValueMap() {
            return getValueMapMap();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        public final Map<String, String> getValueMapMap() {
            return Collections.unmodifiableMap(internalGetValueMap());
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        public final String getValueMapOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> internalGetValueMap = internalGetValueMap();
            return internalGetValueMap.containsKey(str) ? internalGetValueMap.get(str) : str2;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
        public final String getValueMapOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> internalGetValueMap = internalGetValueMap();
            if (!internalGetValueMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return internalGetValueMap.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableValueMapMap() {
            return internalGetMutableValueMap();
        }

        public static ResponsePkg parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ResponsePkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ResponsePkg parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ResponsePkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ResponsePkg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ResponsePkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ResponsePkg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ResponsePkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ResponsePkg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ResponsePkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ResponsePkg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ResponsePkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ResponsePkg parseFrom(InputStream inputStream) throws IOException {
            return (ResponsePkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ResponsePkg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ResponsePkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ResponsePkg parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ResponsePkg) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ResponsePkg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ResponsePkg) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ResponsePkg parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ResponsePkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ResponsePkg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ResponsePkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ResponsePkg responsePkg) {
            return DEFAULT_INSTANCE.createBuilder(responsePkg);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ResponsePkg, Builder> implements ResponsePkgOrBuilder {
            private Builder() {
                super(ResponsePkg.DEFAULT_INSTANCE);
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            public final long getResult() {
                return ((ResponsePkg) this.instance).getResult();
            }

            public final Builder setResult(long j) {
                copyOnWrite();
                ((ResponsePkg) this.instance).result_ = j;
                return this;
            }

            public final Builder clearResult() {
                copyOnWrite();
                ((ResponsePkg) this.instance).result_ = 0L;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            public final int getCmd() {
                return ((ResponsePkg) this.instance).getCmd();
            }

            public final Builder setCmd(int i) {
                copyOnWrite();
                ((ResponsePkg) this.instance).cmd_ = i;
                return this;
            }

            public final Builder clearCmd() {
                copyOnWrite();
                ((ResponsePkg) this.instance).cmd_ = 0;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            public final ByteString getSBuffer() {
                return ((ResponsePkg) this.instance).getSBuffer();
            }

            public final Builder setSBuffer(ByteString byteString) {
                copyOnWrite();
                ResponsePkg.access$500((ResponsePkg) this.instance, byteString);
                return this;
            }

            public final Builder clearSBuffer() {
                copyOnWrite();
                ResponsePkg.access$600((ResponsePkg) this.instance);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            public final String getGatewayIp() {
                return ((ResponsePkg) this.instance).getGatewayIp();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            public final ByteString getGatewayIpBytes() {
                return ((ResponsePkg) this.instance).getGatewayIpBytes();
            }

            public final Builder setGatewayIp(String str) {
                copyOnWrite();
                ResponsePkg.access$700((ResponsePkg) this.instance, str);
                return this;
            }

            public final Builder clearGatewayIp() {
                copyOnWrite();
                ResponsePkg.access$800((ResponsePkg) this.instance);
                return this;
            }

            public final Builder setGatewayIpBytes(ByteString byteString) {
                copyOnWrite();
                ResponsePkg.access$900((ResponsePkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            public final long getServerTime() {
                return ((ResponsePkg) this.instance).getServerTime();
            }

            public final Builder setServerTime(long j) {
                copyOnWrite();
                ((ResponsePkg) this.instance).serverTime_ = j;
                return this;
            }

            public final Builder clearServerTime() {
                copyOnWrite();
                ((ResponsePkg) this.instance).serverTime_ = 0L;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            public final String getStatus() {
                return ((ResponsePkg) this.instance).getStatus();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            public final ByteString getStatusBytes() {
                return ((ResponsePkg) this.instance).getStatusBytes();
            }

            public final Builder setStatus(String str) {
                copyOnWrite();
                ResponsePkg.access$1200((ResponsePkg) this.instance, str);
                return this;
            }

            public final Builder clearStatus() {
                copyOnWrite();
                ResponsePkg.access$1300((ResponsePkg) this.instance);
                return this;
            }

            public final Builder setStatusBytes(ByteString byteString) {
                copyOnWrite();
                ResponsePkg.access$1400((ResponsePkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            public final String getQimei() {
                return ((ResponsePkg) this.instance).getQimei();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            public final ByteString getQimeiBytes() {
                return ((ResponsePkg) this.instance).getQimeiBytes();
            }

            public final Builder setQimei(String str) {
                copyOnWrite();
                ResponsePkg.access$1500((ResponsePkg) this.instance, str);
                return this;
            }

            public final Builder clearQimei() {
                copyOnWrite();
                ResponsePkg.access$1600((ResponsePkg) this.instance);
                return this;
            }

            public final Builder setQimeiBytes(ByteString byteString) {
                copyOnWrite();
                ResponsePkg.access$1700((ResponsePkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            public final int getValueMapCount() {
                return ((ResponsePkg) this.instance).getValueMapMap().size();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            public final boolean containsValueMap(String str) {
                str.getClass();
                return ((ResponsePkg) this.instance).getValueMapMap().containsKey(str);
            }

            public final Builder clearValueMap() {
                copyOnWrite();
                ((ResponsePkg) this.instance).getMutableValueMapMap().clear();
                return this;
            }

            public final Builder removeValueMap(String str) {
                str.getClass();
                copyOnWrite();
                ((ResponsePkg) this.instance).getMutableValueMapMap().remove(str);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            @Deprecated
            public final Map<String, String> getValueMap() {
                return getValueMapMap();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            public final Map<String, String> getValueMapMap() {
                return Collections.unmodifiableMap(((ResponsePkg) this.instance).getValueMapMap());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            public final String getValueMapOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> valueMapMap = ((ResponsePkg) this.instance).getValueMapMap();
                return valueMapMap.containsKey(str) ? valueMapMap.get(str) : str2;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ResponsePkgOrBuilder
            public final String getValueMapOrThrow(String str) {
                str.getClass();
                Map<String, String> valueMapMap = ((ResponsePkg) this.instance).getValueMapMap();
                if (!valueMapMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return valueMapMap.get(str);
            }

            public final Builder putValueMap(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((ResponsePkg) this.instance).getMutableValueMapMap().put(str, str2);
                return this;
            }

            public final Builder putAllValueMap(Map<String, String> map) {
                copyOnWrite();
                ((ResponsePkg) this.instance).getMutableValueMapMap().putAll(map);
                return this;
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new ResponsePkg();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0001\u0000\u0000\u0001\u0002\u0002\u0004\u0003\n\u0004Ȉ\u0005\u0002\u0006Ȉ\u0007Ȉ\b2", new Object[]{"result_", "cmd_", "sBuffer_", "gatewayIp_", "serverTime_", "status_", "qimei_", "valueMap_", a.f6565a});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<ResponsePkg> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (ResponsePkg.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ResponsePkg responsePkg = new ResponsePkg();
            DEFAULT_INSTANCE = responsePkg;
            GeneratedMessageLite.registerDefaultInstance(ResponsePkg.class, responsePkg);
        }

        public static ResponsePkg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ResponsePkg> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes3.dex */
    public static final class RequestPkg extends GeneratedMessageLite<RequestPkg, Builder> implements RequestPkgOrBuilder {
        public static final int ANDROIDID_FIELD_NUMBER = 22;
        public static final int APN_FIELD_NUMBER = 16;
        public static final int BUNDLEID_FIELD_NUMBER = 3;
        public static final int CHANNEL_FIELD_NUMBER = 5;
        public static final int CMD_FIELD_NUMBER = 7;
        private static final RequestPkg DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 15;
        public static final int IDFV_FIELD_NUMBER = 24;
        public static final int IMEI_FIELD_NUMBER = 18;
        public static final int IMSI_FIELD_NUMBER = 20;
        public static final int MAC_FIELD_NUMBER = 21;
        public static final int MODEL_FIELD_NUMBER = 9;
        public static final int NETWORKTYPE_FIELD_NUMBER = 23;
        public static final int OSVER_FIELD_NUMBER = 10;
        private static volatile Parser<RequestPkg> PARSER = null;
        public static final int PLATFORMID_FIELD_NUMBER = 1;
        public static final int PRODID_FIELD_NUMBER = 2;
        public static final int QIMEI_FIELD_NUMBER = 19;
        public static final int RESERVED_FIELD_NUMBER = 11;
        public static final int SBUFFER_FIELD_NUMBER = 8;
        public static final int SDKID_FIELD_NUMBER = 14;
        public static final int SDKVER_FIELD_NUMBER = 6;
        public static final int SESSIONID_FIELD_NUMBER = 12;
        public static final int STRATEGYLASTUPDATETIME_FIELD_NUMBER = 13;
        public static final int UPLOADTIME_FIELD_NUMBER = 17;
        public static final int VERSION_FIELD_NUMBER = 4;
        private int cmd_;
        private int platformId_;
        private long strategylastUpdateTime_;
        private long uploadTime_;
        private MapFieldLite<String, String> reserved_ = MapFieldLite.a();
        private String prodId_ = "";
        private String bundleId_ = "";
        private String version_ = "";
        private String channel_ = "";
        private String sdkVer_ = "";
        private ByteString sBuffer_ = ByteString.f6635a;
        private String model_ = "";
        private String osVer_ = "";
        private String sessionId_ = "";
        private String sdkId_ = "";
        private String deviceId_ = "";
        private String apn_ = "";
        private String imei_ = "";
        private String qimei_ = "";
        private String imsi_ = "";
        private String mac_ = "";
        private String androidId_ = "";
        private String networkType_ = "";
        private String idfv_ = "";

        /* loaded from: classes3.dex */
        static final class a {

            /* renamed from: a, reason: collision with root package name */
            static final MapEntryLite<String, String> f6564a = MapEntryLite.a(WireFormat.FieldType.i, "", WireFormat.FieldType.i, "");
        }

        static /* synthetic */ void access$2300(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.prodId_ = str;
        }

        static /* synthetic */ void access$2400(RequestPkg requestPkg) {
            requestPkg.prodId_ = getDefaultInstance().getProdId();
        }

        static /* synthetic */ void access$2500(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.prodId_ = byteString.f();
        }

        static /* synthetic */ void access$2600(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.bundleId_ = str;
        }

        static /* synthetic */ void access$2700(RequestPkg requestPkg) {
            requestPkg.bundleId_ = getDefaultInstance().getBundleId();
        }

        static /* synthetic */ void access$2800(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.bundleId_ = byteString.f();
        }

        static /* synthetic */ void access$2900(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.version_ = str;
        }

        static /* synthetic */ void access$3000(RequestPkg requestPkg) {
            requestPkg.version_ = getDefaultInstance().getVersion();
        }

        static /* synthetic */ void access$3100(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.version_ = byteString.f();
        }

        static /* synthetic */ void access$3200(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.channel_ = str;
        }

        static /* synthetic */ void access$3300(RequestPkg requestPkg) {
            requestPkg.channel_ = getDefaultInstance().getChannel();
        }

        static /* synthetic */ void access$3400(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.channel_ = byteString.f();
        }

        static /* synthetic */ void access$3500(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.sdkVer_ = str;
        }

        static /* synthetic */ void access$3600(RequestPkg requestPkg) {
            requestPkg.sdkVer_ = getDefaultInstance().getSdkVer();
        }

        static /* synthetic */ void access$3700(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.sdkVer_ = byteString.f();
        }

        static /* synthetic */ void access$4000(RequestPkg requestPkg, ByteString byteString) {
            byteString.getClass();
            requestPkg.sBuffer_ = byteString;
        }

        static /* synthetic */ void access$4100(RequestPkg requestPkg) {
            requestPkg.sBuffer_ = getDefaultInstance().getSBuffer();
        }

        static /* synthetic */ void access$4200(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.model_ = str;
        }

        static /* synthetic */ void access$4300(RequestPkg requestPkg) {
            requestPkg.model_ = getDefaultInstance().getModel();
        }

        static /* synthetic */ void access$4400(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.model_ = byteString.f();
        }

        static /* synthetic */ void access$4500(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.osVer_ = str;
        }

        static /* synthetic */ void access$4600(RequestPkg requestPkg) {
            requestPkg.osVer_ = getDefaultInstance().getOsVer();
        }

        static /* synthetic */ void access$4700(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.osVer_ = byteString.f();
        }

        static /* synthetic */ void access$4900(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.sessionId_ = str;
        }

        static /* synthetic */ void access$5000(RequestPkg requestPkg) {
            requestPkg.sessionId_ = getDefaultInstance().getSessionId();
        }

        static /* synthetic */ void access$5100(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.sessionId_ = byteString.f();
        }

        static /* synthetic */ void access$5400(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.sdkId_ = str;
        }

        static /* synthetic */ void access$5500(RequestPkg requestPkg) {
            requestPkg.sdkId_ = getDefaultInstance().getSdkId();
        }

        static /* synthetic */ void access$5600(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.sdkId_ = byteString.f();
        }

        static /* synthetic */ void access$5700(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.deviceId_ = str;
        }

        static /* synthetic */ void access$5800(RequestPkg requestPkg) {
            requestPkg.deviceId_ = getDefaultInstance().getDeviceId();
        }

        static /* synthetic */ void access$5900(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.deviceId_ = byteString.f();
        }

        static /* synthetic */ void access$6000(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.apn_ = str;
        }

        static /* synthetic */ void access$6100(RequestPkg requestPkg) {
            requestPkg.apn_ = getDefaultInstance().getApn();
        }

        static /* synthetic */ void access$6200(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.apn_ = byteString.f();
        }

        static /* synthetic */ void access$6500(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.imei_ = str;
        }

        static /* synthetic */ void access$6600(RequestPkg requestPkg) {
            requestPkg.imei_ = getDefaultInstance().getImei();
        }

        static /* synthetic */ void access$6700(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.imei_ = byteString.f();
        }

        static /* synthetic */ void access$6800(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.qimei_ = str;
        }

        static /* synthetic */ void access$6900(RequestPkg requestPkg) {
            requestPkg.qimei_ = getDefaultInstance().getQimei();
        }

        static /* synthetic */ void access$7000(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.qimei_ = byteString.f();
        }

        static /* synthetic */ void access$7100(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.imsi_ = str;
        }

        static /* synthetic */ void access$7200(RequestPkg requestPkg) {
            requestPkg.imsi_ = getDefaultInstance().getImsi();
        }

        static /* synthetic */ void access$7300(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.imsi_ = byteString.f();
        }

        static /* synthetic */ void access$7400(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.mac_ = str;
        }

        static /* synthetic */ void access$7500(RequestPkg requestPkg) {
            requestPkg.mac_ = getDefaultInstance().getMac();
        }

        static /* synthetic */ void access$7600(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.mac_ = byteString.f();
        }

        static /* synthetic */ void access$7700(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.androidId_ = str;
        }

        static /* synthetic */ void access$7800(RequestPkg requestPkg) {
            requestPkg.androidId_ = getDefaultInstance().getAndroidId();
        }

        static /* synthetic */ void access$7900(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.androidId_ = byteString.f();
        }

        static /* synthetic */ void access$8000(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.networkType_ = str;
        }

        static /* synthetic */ void access$8100(RequestPkg requestPkg) {
            requestPkg.networkType_ = getDefaultInstance().getNetworkType();
        }

        static /* synthetic */ void access$8200(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.networkType_ = byteString.f();
        }

        static /* synthetic */ void access$8300(RequestPkg requestPkg, String str) {
            str.getClass();
            requestPkg.idfv_ = str;
        }

        static /* synthetic */ void access$8400(RequestPkg requestPkg) {
            requestPkg.idfv_ = getDefaultInstance().getIdfv();
        }

        static /* synthetic */ void access$8500(RequestPkg requestPkg, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            requestPkg.idfv_ = byteString.f();
        }

        private RequestPkg() {
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final int getPlatformId() {
            return this.platformId_;
        }

        private void setPlatformId(int i) {
            this.platformId_ = i;
        }

        private void clearPlatformId() {
            this.platformId_ = 0;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getProdId() {
            return this.prodId_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getProdIdBytes() {
            return ByteString.a(this.prodId_);
        }

        private void setProdId(String str) {
            str.getClass();
            this.prodId_ = str;
        }

        private void clearProdId() {
            this.prodId_ = getDefaultInstance().getProdId();
        }

        private void setProdIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.prodId_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getBundleId() {
            return this.bundleId_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getBundleIdBytes() {
            return ByteString.a(this.bundleId_);
        }

        private void setBundleId(String str) {
            str.getClass();
            this.bundleId_ = str;
        }

        private void clearBundleId() {
            this.bundleId_ = getDefaultInstance().getBundleId();
        }

        private void setBundleIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.bundleId_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getVersion() {
            return this.version_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getVersionBytes() {
            return ByteString.a(this.version_);
        }

        private void setVersion(String str) {
            str.getClass();
            this.version_ = str;
        }

        private void clearVersion() {
            this.version_ = getDefaultInstance().getVersion();
        }

        private void setVersionBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.version_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getChannel() {
            return this.channel_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getChannelBytes() {
            return ByteString.a(this.channel_);
        }

        private void setChannel(String str) {
            str.getClass();
            this.channel_ = str;
        }

        private void clearChannel() {
            this.channel_ = getDefaultInstance().getChannel();
        }

        private void setChannelBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.channel_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getSdkVer() {
            return this.sdkVer_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getSdkVerBytes() {
            return ByteString.a(this.sdkVer_);
        }

        private void setSdkVer(String str) {
            str.getClass();
            this.sdkVer_ = str;
        }

        private void clearSdkVer() {
            this.sdkVer_ = getDefaultInstance().getSdkVer();
        }

        private void setSdkVerBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.sdkVer_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final int getCmd() {
            return this.cmd_;
        }

        private void setCmd(int i) {
            this.cmd_ = i;
        }

        private void clearCmd() {
            this.cmd_ = 0;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getSBuffer() {
            return this.sBuffer_;
        }

        private void setSBuffer(ByteString byteString) {
            byteString.getClass();
            this.sBuffer_ = byteString;
        }

        private void clearSBuffer() {
            this.sBuffer_ = getDefaultInstance().getSBuffer();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getModel() {
            return this.model_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getModelBytes() {
            return ByteString.a(this.model_);
        }

        private void setModel(String str) {
            str.getClass();
            this.model_ = str;
        }

        private void clearModel() {
            this.model_ = getDefaultInstance().getModel();
        }

        private void setModelBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.model_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getOsVer() {
            return this.osVer_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getOsVerBytes() {
            return ByteString.a(this.osVer_);
        }

        private void setOsVer(String str) {
            str.getClass();
            this.osVer_ = str;
        }

        private void clearOsVer() {
            this.osVer_ = getDefaultInstance().getOsVer();
        }

        private void setOsVerBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.osVer_ = byteString.f();
        }

        private MapFieldLite<String, String> internalGetReserved() {
            return this.reserved_;
        }

        private MapFieldLite<String, String> internalGetMutableReserved() {
            if (!this.reserved_.d()) {
                this.reserved_ = this.reserved_.b();
            }
            return this.reserved_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final int getReservedCount() {
            return internalGetReserved().size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final boolean containsReserved(String str) {
            str.getClass();
            return internalGetReserved().containsKey(str);
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        @Deprecated
        public final Map<String, String> getReserved() {
            return getReservedMap();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final Map<String, String> getReservedMap() {
            return Collections.unmodifiableMap(internalGetReserved());
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getReservedOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> internalGetReserved = internalGetReserved();
            return internalGetReserved.containsKey(str) ? internalGetReserved.get(str) : str2;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getReservedOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> internalGetReserved = internalGetReserved();
            if (!internalGetReserved.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return internalGetReserved.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableReservedMap() {
            return internalGetMutableReserved();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getSessionId() {
            return this.sessionId_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getSessionIdBytes() {
            return ByteString.a(this.sessionId_);
        }

        private void setSessionId(String str) {
            str.getClass();
            this.sessionId_ = str;
        }

        private void clearSessionId() {
            this.sessionId_ = getDefaultInstance().getSessionId();
        }

        private void setSessionIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.sessionId_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final long getStrategylastUpdateTime() {
            return this.strategylastUpdateTime_;
        }

        private void setStrategylastUpdateTime(long j) {
            this.strategylastUpdateTime_ = j;
        }

        private void clearStrategylastUpdateTime() {
            this.strategylastUpdateTime_ = 0L;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getSdkId() {
            return this.sdkId_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getSdkIdBytes() {
            return ByteString.a(this.sdkId_);
        }

        private void setSdkId(String str) {
            str.getClass();
            this.sdkId_ = str;
        }

        private void clearSdkId() {
            this.sdkId_ = getDefaultInstance().getSdkId();
        }

        private void setSdkIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.sdkId_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getDeviceId() {
            return this.deviceId_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getDeviceIdBytes() {
            return ByteString.a(this.deviceId_);
        }

        private void setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
        }

        private void clearDeviceId() {
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        private void setDeviceIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.deviceId_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getApn() {
            return this.apn_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getApnBytes() {
            return ByteString.a(this.apn_);
        }

        private void setApn(String str) {
            str.getClass();
            this.apn_ = str;
        }

        private void clearApn() {
            this.apn_ = getDefaultInstance().getApn();
        }

        private void setApnBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.apn_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final long getUploadTime() {
            return this.uploadTime_;
        }

        private void setUploadTime(long j) {
            this.uploadTime_ = j;
        }

        private void clearUploadTime() {
            this.uploadTime_ = 0L;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getImei() {
            return this.imei_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getImeiBytes() {
            return ByteString.a(this.imei_);
        }

        private void setImei(String str) {
            str.getClass();
            this.imei_ = str;
        }

        private void clearImei() {
            this.imei_ = getDefaultInstance().getImei();
        }

        private void setImeiBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.imei_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getQimei() {
            return this.qimei_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getQimeiBytes() {
            return ByteString.a(this.qimei_);
        }

        private void setQimei(String str) {
            str.getClass();
            this.qimei_ = str;
        }

        private void clearQimei() {
            this.qimei_ = getDefaultInstance().getQimei();
        }

        private void setQimeiBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.qimei_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getImsi() {
            return this.imsi_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getImsiBytes() {
            return ByteString.a(this.imsi_);
        }

        private void setImsi(String str) {
            str.getClass();
            this.imsi_ = str;
        }

        private void clearImsi() {
            this.imsi_ = getDefaultInstance().getImsi();
        }

        private void setImsiBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.imsi_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getMac() {
            return this.mac_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getMacBytes() {
            return ByteString.a(this.mac_);
        }

        private void setMac(String str) {
            str.getClass();
            this.mac_ = str;
        }

        private void clearMac() {
            this.mac_ = getDefaultInstance().getMac();
        }

        private void setMacBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.mac_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getAndroidId() {
            return this.androidId_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getAndroidIdBytes() {
            return ByteString.a(this.androidId_);
        }

        private void setAndroidId(String str) {
            str.getClass();
            this.androidId_ = str;
        }

        private void clearAndroidId() {
            this.androidId_ = getDefaultInstance().getAndroidId();
        }

        private void setAndroidIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.androidId_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getNetworkType() {
            return this.networkType_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getNetworkTypeBytes() {
            return ByteString.a(this.networkType_);
        }

        private void setNetworkType(String str) {
            str.getClass();
            this.networkType_ = str;
        }

        private void clearNetworkType() {
            this.networkType_ = getDefaultInstance().getNetworkType();
        }

        private void setNetworkTypeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.networkType_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final String getIdfv() {
            return this.idfv_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
        public final ByteString getIdfvBytes() {
            return ByteString.a(this.idfv_);
        }

        private void setIdfv(String str) {
            str.getClass();
            this.idfv_ = str;
        }

        private void clearIdfv() {
            this.idfv_ = getDefaultInstance().getIdfv();
        }

        private void setIdfvBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.idfv_ = byteString.f();
        }

        public static RequestPkg parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (RequestPkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static RequestPkg parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RequestPkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RequestPkg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (RequestPkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RequestPkg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RequestPkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RequestPkg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (RequestPkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RequestPkg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RequestPkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RequestPkg parseFrom(InputStream inputStream) throws IOException {
            return (RequestPkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RequestPkg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RequestPkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RequestPkg parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RequestPkg) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RequestPkg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RequestPkg) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RequestPkg parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (RequestPkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RequestPkg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RequestPkg) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RequestPkg requestPkg) {
            return DEFAULT_INSTANCE.createBuilder(requestPkg);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<RequestPkg, Builder> implements RequestPkgOrBuilder {
            private Builder() {
                super(RequestPkg.DEFAULT_INSTANCE);
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final int getPlatformId() {
                return ((RequestPkg) this.instance).getPlatformId();
            }

            public final Builder setPlatformId(int i) {
                copyOnWrite();
                ((RequestPkg) this.instance).platformId_ = i;
                return this;
            }

            public final Builder clearPlatformId() {
                copyOnWrite();
                ((RequestPkg) this.instance).platformId_ = 0;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getProdId() {
                return ((RequestPkg) this.instance).getProdId();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getProdIdBytes() {
                return ((RequestPkg) this.instance).getProdIdBytes();
            }

            public final Builder setProdId(String str) {
                copyOnWrite();
                RequestPkg.access$2300((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearProdId() {
                copyOnWrite();
                RequestPkg.access$2400((RequestPkg) this.instance);
                return this;
            }

            public final Builder setProdIdBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$2500((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getBundleId() {
                return ((RequestPkg) this.instance).getBundleId();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getBundleIdBytes() {
                return ((RequestPkg) this.instance).getBundleIdBytes();
            }

            public final Builder setBundleId(String str) {
                copyOnWrite();
                RequestPkg.access$2600((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearBundleId() {
                copyOnWrite();
                RequestPkg.access$2700((RequestPkg) this.instance);
                return this;
            }

            public final Builder setBundleIdBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$2800((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getVersion() {
                return ((RequestPkg) this.instance).getVersion();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getVersionBytes() {
                return ((RequestPkg) this.instance).getVersionBytes();
            }

            public final Builder setVersion(String str) {
                copyOnWrite();
                RequestPkg.access$2900((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearVersion() {
                copyOnWrite();
                RequestPkg.access$3000((RequestPkg) this.instance);
                return this;
            }

            public final Builder setVersionBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$3100((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getChannel() {
                return ((RequestPkg) this.instance).getChannel();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getChannelBytes() {
                return ((RequestPkg) this.instance).getChannelBytes();
            }

            public final Builder setChannel(String str) {
                copyOnWrite();
                RequestPkg.access$3200((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearChannel() {
                copyOnWrite();
                RequestPkg.access$3300((RequestPkg) this.instance);
                return this;
            }

            public final Builder setChannelBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$3400((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getSdkVer() {
                return ((RequestPkg) this.instance).getSdkVer();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getSdkVerBytes() {
                return ((RequestPkg) this.instance).getSdkVerBytes();
            }

            public final Builder setSdkVer(String str) {
                copyOnWrite();
                RequestPkg.access$3500((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearSdkVer() {
                copyOnWrite();
                RequestPkg.access$3600((RequestPkg) this.instance);
                return this;
            }

            public final Builder setSdkVerBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$3700((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final int getCmd() {
                return ((RequestPkg) this.instance).getCmd();
            }

            public final Builder setCmd(int i) {
                copyOnWrite();
                ((RequestPkg) this.instance).cmd_ = i;
                return this;
            }

            public final Builder clearCmd() {
                copyOnWrite();
                ((RequestPkg) this.instance).cmd_ = 0;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getSBuffer() {
                return ((RequestPkg) this.instance).getSBuffer();
            }

            public final Builder setSBuffer(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$4000((RequestPkg) this.instance, byteString);
                return this;
            }

            public final Builder clearSBuffer() {
                copyOnWrite();
                RequestPkg.access$4100((RequestPkg) this.instance);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getModel() {
                return ((RequestPkg) this.instance).getModel();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getModelBytes() {
                return ((RequestPkg) this.instance).getModelBytes();
            }

            public final Builder setModel(String str) {
                copyOnWrite();
                RequestPkg.access$4200((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearModel() {
                copyOnWrite();
                RequestPkg.access$4300((RequestPkg) this.instance);
                return this;
            }

            public final Builder setModelBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$4400((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getOsVer() {
                return ((RequestPkg) this.instance).getOsVer();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getOsVerBytes() {
                return ((RequestPkg) this.instance).getOsVerBytes();
            }

            public final Builder setOsVer(String str) {
                copyOnWrite();
                RequestPkg.access$4500((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearOsVer() {
                copyOnWrite();
                RequestPkg.access$4600((RequestPkg) this.instance);
                return this;
            }

            public final Builder setOsVerBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$4700((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final int getReservedCount() {
                return ((RequestPkg) this.instance).getReservedMap().size();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final boolean containsReserved(String str) {
                str.getClass();
                return ((RequestPkg) this.instance).getReservedMap().containsKey(str);
            }

            public final Builder clearReserved() {
                copyOnWrite();
                ((RequestPkg) this.instance).getMutableReservedMap().clear();
                return this;
            }

            public final Builder removeReserved(String str) {
                str.getClass();
                copyOnWrite();
                ((RequestPkg) this.instance).getMutableReservedMap().remove(str);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            @Deprecated
            public final Map<String, String> getReserved() {
                return getReservedMap();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final Map<String, String> getReservedMap() {
                return Collections.unmodifiableMap(((RequestPkg) this.instance).getReservedMap());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getReservedOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> reservedMap = ((RequestPkg) this.instance).getReservedMap();
                return reservedMap.containsKey(str) ? reservedMap.get(str) : str2;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getReservedOrThrow(String str) {
                str.getClass();
                Map<String, String> reservedMap = ((RequestPkg) this.instance).getReservedMap();
                if (!reservedMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return reservedMap.get(str);
            }

            public final Builder putReserved(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((RequestPkg) this.instance).getMutableReservedMap().put(str, str2);
                return this;
            }

            public final Builder putAllReserved(Map<String, String> map) {
                copyOnWrite();
                ((RequestPkg) this.instance).getMutableReservedMap().putAll(map);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getSessionId() {
                return ((RequestPkg) this.instance).getSessionId();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getSessionIdBytes() {
                return ((RequestPkg) this.instance).getSessionIdBytes();
            }

            public final Builder setSessionId(String str) {
                copyOnWrite();
                RequestPkg.access$4900((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearSessionId() {
                copyOnWrite();
                RequestPkg.access$5000((RequestPkg) this.instance);
                return this;
            }

            public final Builder setSessionIdBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$5100((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final long getStrategylastUpdateTime() {
                return ((RequestPkg) this.instance).getStrategylastUpdateTime();
            }

            public final Builder setStrategylastUpdateTime(long j) {
                copyOnWrite();
                ((RequestPkg) this.instance).strategylastUpdateTime_ = j;
                return this;
            }

            public final Builder clearStrategylastUpdateTime() {
                copyOnWrite();
                ((RequestPkg) this.instance).strategylastUpdateTime_ = 0L;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getSdkId() {
                return ((RequestPkg) this.instance).getSdkId();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getSdkIdBytes() {
                return ((RequestPkg) this.instance).getSdkIdBytes();
            }

            public final Builder setSdkId(String str) {
                copyOnWrite();
                RequestPkg.access$5400((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearSdkId() {
                copyOnWrite();
                RequestPkg.access$5500((RequestPkg) this.instance);
                return this;
            }

            public final Builder setSdkIdBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$5600((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getDeviceId() {
                return ((RequestPkg) this.instance).getDeviceId();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getDeviceIdBytes() {
                return ((RequestPkg) this.instance).getDeviceIdBytes();
            }

            public final Builder setDeviceId(String str) {
                copyOnWrite();
                RequestPkg.access$5700((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearDeviceId() {
                copyOnWrite();
                RequestPkg.access$5800((RequestPkg) this.instance);
                return this;
            }

            public final Builder setDeviceIdBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$5900((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getApn() {
                return ((RequestPkg) this.instance).getApn();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getApnBytes() {
                return ((RequestPkg) this.instance).getApnBytes();
            }

            public final Builder setApn(String str) {
                copyOnWrite();
                RequestPkg.access$6000((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearApn() {
                copyOnWrite();
                RequestPkg.access$6100((RequestPkg) this.instance);
                return this;
            }

            public final Builder setApnBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$6200((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final long getUploadTime() {
                return ((RequestPkg) this.instance).getUploadTime();
            }

            public final Builder setUploadTime(long j) {
                copyOnWrite();
                ((RequestPkg) this.instance).uploadTime_ = j;
                return this;
            }

            public final Builder clearUploadTime() {
                copyOnWrite();
                ((RequestPkg) this.instance).uploadTime_ = 0L;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getImei() {
                return ((RequestPkg) this.instance).getImei();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getImeiBytes() {
                return ((RequestPkg) this.instance).getImeiBytes();
            }

            public final Builder setImei(String str) {
                copyOnWrite();
                RequestPkg.access$6500((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearImei() {
                copyOnWrite();
                RequestPkg.access$6600((RequestPkg) this.instance);
                return this;
            }

            public final Builder setImeiBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$6700((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getQimei() {
                return ((RequestPkg) this.instance).getQimei();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getQimeiBytes() {
                return ((RequestPkg) this.instance).getQimeiBytes();
            }

            public final Builder setQimei(String str) {
                copyOnWrite();
                RequestPkg.access$6800((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearQimei() {
                copyOnWrite();
                RequestPkg.access$6900((RequestPkg) this.instance);
                return this;
            }

            public final Builder setQimeiBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$7000((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getImsi() {
                return ((RequestPkg) this.instance).getImsi();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getImsiBytes() {
                return ((RequestPkg) this.instance).getImsiBytes();
            }

            public final Builder setImsi(String str) {
                copyOnWrite();
                RequestPkg.access$7100((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearImsi() {
                copyOnWrite();
                RequestPkg.access$7200((RequestPkg) this.instance);
                return this;
            }

            public final Builder setImsiBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$7300((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getMac() {
                return ((RequestPkg) this.instance).getMac();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getMacBytes() {
                return ((RequestPkg) this.instance).getMacBytes();
            }

            public final Builder setMac(String str) {
                copyOnWrite();
                RequestPkg.access$7400((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearMac() {
                copyOnWrite();
                RequestPkg.access$7500((RequestPkg) this.instance);
                return this;
            }

            public final Builder setMacBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$7600((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getAndroidId() {
                return ((RequestPkg) this.instance).getAndroidId();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getAndroidIdBytes() {
                return ((RequestPkg) this.instance).getAndroidIdBytes();
            }

            public final Builder setAndroidId(String str) {
                copyOnWrite();
                RequestPkg.access$7700((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearAndroidId() {
                copyOnWrite();
                RequestPkg.access$7800((RequestPkg) this.instance);
                return this;
            }

            public final Builder setAndroidIdBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$7900((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getNetworkType() {
                return ((RequestPkg) this.instance).getNetworkType();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getNetworkTypeBytes() {
                return ((RequestPkg) this.instance).getNetworkTypeBytes();
            }

            public final Builder setNetworkType(String str) {
                copyOnWrite();
                RequestPkg.access$8000((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearNetworkType() {
                copyOnWrite();
                RequestPkg.access$8100((RequestPkg) this.instance);
                return this;
            }

            public final Builder setNetworkTypeBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$8200((RequestPkg) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final String getIdfv() {
                return ((RequestPkg) this.instance).getIdfv();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RequestPkgOrBuilder
            public final ByteString getIdfvBytes() {
                return ((RequestPkg) this.instance).getIdfvBytes();
            }

            public final Builder setIdfv(String str) {
                copyOnWrite();
                RequestPkg.access$8300((RequestPkg) this.instance, str);
                return this;
            }

            public final Builder clearIdfv() {
                copyOnWrite();
                RequestPkg.access$8400((RequestPkg) this.instance);
                return this;
            }

            public final Builder setIdfvBytes(ByteString byteString) {
                copyOnWrite();
                RequestPkg.access$8500((RequestPkg) this.instance, byteString);
                return this;
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new RequestPkg();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0018\u0000\u0000\u0001\u0018\u0018\u0001\u0000\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0004\b\n\tȈ\nȈ\u000b2\fȈ\r\u0002\u000eȈ\u000fȈ\u0010Ȉ\u0011\u0002\u0012Ȉ\u0013Ȉ\u0014Ȉ\u0015Ȉ\u0016Ȉ\u0017Ȉ\u0018Ȉ", new Object[]{"platformId_", "prodId_", "bundleId_", "version_", "channel_", "sdkVer_", "cmd_", "sBuffer_", "model_", "osVer_", "reserved_", a.f6564a, "sessionId_", "strategylastUpdateTime_", "sdkId_", "deviceId_", "apn_", "uploadTime_", "imei_", "qimei_", "imsi_", "mac_", "androidId_", "networkType_", "idfv_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<RequestPkg> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (RequestPkg.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            RequestPkg requestPkg = new RequestPkg();
            DEFAULT_INSTANCE = requestPkg;
            GeneratedMessageLite.registerDefaultInstance(RequestPkg.class, requestPkg);
        }

        public static RequestPkg getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RequestPkg> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes3.dex */
    public static final class UniPacket extends GeneratedMessageLite<UniPacket, Builder> implements UniPacketOrBuilder {
        private static final UniPacket DEFAULT_INSTANCE;
        public static final int ENCODENAME_FIELD_NUMBER = 2;
        public static final int IREQUESTID_FIELD_NUMBER = 3;
        public static final int IVERSION_FIELD_NUMBER = 1;
        private static volatile Parser<UniPacket> PARSER = null;
        public static final int REQUEST_FIELD_NUMBER = 6;
        public static final int RESPONSE_FIELD_NUMBER = 7;
        public static final int SFUNCNAME_FIELD_NUMBER = 5;
        public static final int SSERVANTNAME_FIELD_NUMBER = 4;
        private int iRequestId_;
        private int iVersion_;
        private RequestPkg request_;
        private ResponsePkg response_;
        private String encodeName_ = "";
        private String sServantName_ = "";
        private String sFuncName_ = "";

        static /* synthetic */ void access$10000(UniPacket uniPacket, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            uniPacket.sFuncName_ = byteString.f();
        }

        static /* synthetic */ void access$10100(UniPacket uniPacket, RequestPkg requestPkg) {
            requestPkg.getClass();
            uniPacket.request_ = requestPkg;
        }

        static /* synthetic */ void access$10400(UniPacket uniPacket, ResponsePkg responsePkg) {
            responsePkg.getClass();
            uniPacket.response_ = responsePkg;
        }

        static /* synthetic */ void access$9000(UniPacket uniPacket, String str) {
            str.getClass();
            uniPacket.encodeName_ = str;
        }

        static /* synthetic */ void access$9100(UniPacket uniPacket) {
            uniPacket.encodeName_ = getDefaultInstance().getEncodeName();
        }

        static /* synthetic */ void access$9200(UniPacket uniPacket, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            uniPacket.encodeName_ = byteString.f();
        }

        static /* synthetic */ void access$9500(UniPacket uniPacket, String str) {
            str.getClass();
            uniPacket.sServantName_ = str;
        }

        static /* synthetic */ void access$9600(UniPacket uniPacket) {
            uniPacket.sServantName_ = getDefaultInstance().getSServantName();
        }

        static /* synthetic */ void access$9700(UniPacket uniPacket, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            uniPacket.sServantName_ = byteString.f();
        }

        static /* synthetic */ void access$9800(UniPacket uniPacket, String str) {
            str.getClass();
            uniPacket.sFuncName_ = str;
        }

        static /* synthetic */ void access$9900(UniPacket uniPacket) {
            uniPacket.sFuncName_ = getDefaultInstance().getSFuncName();
        }

        private UniPacket() {
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
        public final int getIVersion() {
            return this.iVersion_;
        }

        private void setIVersion(int i) {
            this.iVersion_ = i;
        }

        private void clearIVersion() {
            this.iVersion_ = 0;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
        public final String getEncodeName() {
            return this.encodeName_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
        public final ByteString getEncodeNameBytes() {
            return ByteString.a(this.encodeName_);
        }

        private void setEncodeName(String str) {
            str.getClass();
            this.encodeName_ = str;
        }

        private void clearEncodeName() {
            this.encodeName_ = getDefaultInstance().getEncodeName();
        }

        private void setEncodeNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.encodeName_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
        public final int getIRequestId() {
            return this.iRequestId_;
        }

        private void setIRequestId(int i) {
            this.iRequestId_ = i;
        }

        private void clearIRequestId() {
            this.iRequestId_ = 0;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
        public final String getSServantName() {
            return this.sServantName_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
        public final ByteString getSServantNameBytes() {
            return ByteString.a(this.sServantName_);
        }

        private void setSServantName(String str) {
            str.getClass();
            this.sServantName_ = str;
        }

        private void clearSServantName() {
            this.sServantName_ = getDefaultInstance().getSServantName();
        }

        private void setSServantNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.sServantName_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
        public final String getSFuncName() {
            return this.sFuncName_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
        public final ByteString getSFuncNameBytes() {
            return ByteString.a(this.sFuncName_);
        }

        private void setSFuncName(String str) {
            str.getClass();
            this.sFuncName_ = str;
        }

        private void clearSFuncName() {
            this.sFuncName_ = getDefaultInstance().getSFuncName();
        }

        private void setSFuncNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.sFuncName_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
        public final boolean hasRequest() {
            return this.request_ != null;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
        public final RequestPkg getRequest() {
            RequestPkg requestPkg = this.request_;
            return requestPkg == null ? RequestPkg.getDefaultInstance() : requestPkg;
        }

        private void setRequest(RequestPkg requestPkg) {
            requestPkg.getClass();
            this.request_ = requestPkg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeRequest(RequestPkg requestPkg) {
            requestPkg.getClass();
            RequestPkg requestPkg2 = this.request_;
            if (requestPkg2 != null && requestPkg2 != RequestPkg.getDefaultInstance()) {
                this.request_ = RequestPkg.newBuilder(this.request_).mergeFrom((RequestPkg.Builder) requestPkg).h();
            } else {
                this.request_ = requestPkg;
            }
        }

        private void clearRequest() {
            this.request_ = null;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
        public final boolean hasResponse() {
            return this.response_ != null;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
        public final ResponsePkg getResponse() {
            ResponsePkg responsePkg = this.response_;
            return responsePkg == null ? ResponsePkg.getDefaultInstance() : responsePkg;
        }

        private void setResponse(ResponsePkg responsePkg) {
            responsePkg.getClass();
            this.response_ = responsePkg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeResponse(ResponsePkg responsePkg) {
            responsePkg.getClass();
            ResponsePkg responsePkg2 = this.response_;
            if (responsePkg2 != null && responsePkg2 != ResponsePkg.getDefaultInstance()) {
                this.response_ = ResponsePkg.newBuilder(this.response_).mergeFrom((ResponsePkg.Builder) responsePkg).h();
            } else {
                this.response_ = responsePkg;
            }
        }

        private void clearResponse() {
            this.response_ = null;
        }

        public static UniPacket parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UniPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static UniPacket parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UniPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UniPacket parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UniPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UniPacket parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UniPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UniPacket parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UniPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UniPacket parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UniPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UniPacket parseFrom(InputStream inputStream) throws IOException {
            return (UniPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UniPacket parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UniPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UniPacket parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UniPacket) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UniPacket parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UniPacket) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UniPacket parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UniPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UniPacket parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UniPacket) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UniPacket uniPacket) {
            return DEFAULT_INSTANCE.createBuilder(uniPacket);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<UniPacket, Builder> implements UniPacketOrBuilder {
            private Builder() {
                super(UniPacket.DEFAULT_INSTANCE);
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
            public final int getIVersion() {
                return ((UniPacket) this.instance).getIVersion();
            }

            public final Builder setIVersion(int i) {
                copyOnWrite();
                ((UniPacket) this.instance).iVersion_ = i;
                return this;
            }

            public final Builder clearIVersion() {
                copyOnWrite();
                ((UniPacket) this.instance).iVersion_ = 0;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
            public final String getEncodeName() {
                return ((UniPacket) this.instance).getEncodeName();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
            public final ByteString getEncodeNameBytes() {
                return ((UniPacket) this.instance).getEncodeNameBytes();
            }

            public final Builder setEncodeName(String str) {
                copyOnWrite();
                UniPacket.access$9000((UniPacket) this.instance, str);
                return this;
            }

            public final Builder clearEncodeName() {
                copyOnWrite();
                UniPacket.access$9100((UniPacket) this.instance);
                return this;
            }

            public final Builder setEncodeNameBytes(ByteString byteString) {
                copyOnWrite();
                UniPacket.access$9200((UniPacket) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
            public final int getIRequestId() {
                return ((UniPacket) this.instance).getIRequestId();
            }

            public final Builder setIRequestId(int i) {
                copyOnWrite();
                ((UniPacket) this.instance).iRequestId_ = i;
                return this;
            }

            public final Builder clearIRequestId() {
                copyOnWrite();
                ((UniPacket) this.instance).iRequestId_ = 0;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
            public final String getSServantName() {
                return ((UniPacket) this.instance).getSServantName();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
            public final ByteString getSServantNameBytes() {
                return ((UniPacket) this.instance).getSServantNameBytes();
            }

            public final Builder setSServantName(String str) {
                copyOnWrite();
                UniPacket.access$9500((UniPacket) this.instance, str);
                return this;
            }

            public final Builder clearSServantName() {
                copyOnWrite();
                UniPacket.access$9600((UniPacket) this.instance);
                return this;
            }

            public final Builder setSServantNameBytes(ByteString byteString) {
                copyOnWrite();
                UniPacket.access$9700((UniPacket) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
            public final String getSFuncName() {
                return ((UniPacket) this.instance).getSFuncName();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
            public final ByteString getSFuncNameBytes() {
                return ((UniPacket) this.instance).getSFuncNameBytes();
            }

            public final Builder setSFuncName(String str) {
                copyOnWrite();
                UniPacket.access$9800((UniPacket) this.instance, str);
                return this;
            }

            public final Builder clearSFuncName() {
                copyOnWrite();
                UniPacket.access$9900((UniPacket) this.instance);
                return this;
            }

            public final Builder setSFuncNameBytes(ByteString byteString) {
                copyOnWrite();
                UniPacket.access$10000((UniPacket) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
            public final boolean hasRequest() {
                return ((UniPacket) this.instance).hasRequest();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
            public final RequestPkg getRequest() {
                return ((UniPacket) this.instance).getRequest();
            }

            public final Builder setRequest(RequestPkg requestPkg) {
                copyOnWrite();
                UniPacket.access$10100((UniPacket) this.instance, requestPkg);
                return this;
            }

            public final Builder setRequest(RequestPkg.Builder builder) {
                copyOnWrite();
                UniPacket.access$10100((UniPacket) this.instance, builder.h());
                return this;
            }

            public final Builder mergeRequest(RequestPkg requestPkg) {
                copyOnWrite();
                ((UniPacket) this.instance).mergeRequest(requestPkg);
                return this;
            }

            public final Builder clearRequest() {
                copyOnWrite();
                ((UniPacket) this.instance).request_ = null;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
            public final boolean hasResponse() {
                return ((UniPacket) this.instance).hasResponse();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UniPacketOrBuilder
            public final ResponsePkg getResponse() {
                return ((UniPacket) this.instance).getResponse();
            }

            public final Builder setResponse(ResponsePkg responsePkg) {
                copyOnWrite();
                UniPacket.access$10400((UniPacket) this.instance, responsePkg);
                return this;
            }

            public final Builder setResponse(ResponsePkg.Builder builder) {
                copyOnWrite();
                UniPacket.access$10400((UniPacket) this.instance, builder.h());
                return this;
            }

            public final Builder mergeResponse(ResponsePkg responsePkg) {
                copyOnWrite();
                ((UniPacket) this.instance).mergeResponse(responsePkg);
                return this;
            }

            public final Builder clearResponse() {
                copyOnWrite();
                ((UniPacket) this.instance).response_ = null;
                return this;
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new UniPacket();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003\u0004\u0004Ȉ\u0005Ȉ\u0006\t\u0007\t", new Object[]{"iVersion_", "encodeName_", "iRequestId_", "sServantName_", "sFuncName_", "request_", "response_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<UniPacket> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (UniPacket.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            UniPacket uniPacket = new UniPacket();
            DEFAULT_INSTANCE = uniPacket;
            GeneratedMessageLite.registerDefaultInstance(UniPacket.class, uniPacket);
        }

        public static UniPacket getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UniPacket> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes3.dex */
    public static final class UserInfoPackage extends GeneratedMessageLite<UserInfoPackage, Builder> implements UserInfoPackageOrBuilder {
        private static final UserInfoPackage DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 3;
        public static final int LIST_FIELD_NUMBER = 4;
        private static volatile Parser<UserInfoPackage> PARSER = null;
        public static final int PROCENAME_FIELD_NUMBER = 2;
        public static final int TYPE_FIELD_NUMBER = 1;
        public static final int VALUEMAP_FIELD_NUMBER = 5;
        private int type_;
        private MapFieldLite<String, String> valueMap_ = MapFieldLite.a();
        private String proceName_ = "";
        private String deviceId_ = "";
        private Internal.ProtobufList<SummaryInfo> list_ = emptyProtobufList();

        /* loaded from: classes3.dex */
        static final class a {

            /* renamed from: a, reason: collision with root package name */
            static final MapEntryLite<String, String> f6568a = MapEntryLite.a(WireFormat.FieldType.i, "", WireFormat.FieldType.i, "");
        }

        static /* synthetic */ void access$11100(UserInfoPackage userInfoPackage, String str) {
            str.getClass();
            userInfoPackage.proceName_ = str;
        }

        static /* synthetic */ void access$11200(UserInfoPackage userInfoPackage) {
            userInfoPackage.proceName_ = getDefaultInstance().getProceName();
        }

        static /* synthetic */ void access$11300(UserInfoPackage userInfoPackage, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            userInfoPackage.proceName_ = byteString.f();
        }

        static /* synthetic */ void access$11400(UserInfoPackage userInfoPackage, String str) {
            str.getClass();
            userInfoPackage.deviceId_ = str;
        }

        static /* synthetic */ void access$11500(UserInfoPackage userInfoPackage) {
            userInfoPackage.deviceId_ = getDefaultInstance().getDeviceId();
        }

        static /* synthetic */ void access$11600(UserInfoPackage userInfoPackage, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            userInfoPackage.deviceId_ = byteString.f();
        }

        static /* synthetic */ void access$12100(UserInfoPackage userInfoPackage) {
            userInfoPackage.list_ = emptyProtobufList();
        }

        private UserInfoPackage() {
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
        public final int getType() {
            return this.type_;
        }

        private void setType(int i) {
            this.type_ = i;
        }

        private void clearType() {
            this.type_ = 0;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
        public final String getProceName() {
            return this.proceName_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
        public final ByteString getProceNameBytes() {
            return ByteString.a(this.proceName_);
        }

        private void setProceName(String str) {
            str.getClass();
            this.proceName_ = str;
        }

        private void clearProceName() {
            this.proceName_ = getDefaultInstance().getProceName();
        }

        private void setProceNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.proceName_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
        public final String getDeviceId() {
            return this.deviceId_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
        public final ByteString getDeviceIdBytes() {
            return ByteString.a(this.deviceId_);
        }

        private void setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
        }

        private void clearDeviceId() {
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        private void setDeviceIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.deviceId_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
        public final List<SummaryInfo> getListList() {
            return this.list_;
        }

        public final List<? extends SummaryInfoOrBuilder> getListOrBuilderList() {
            return this.list_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
        public final int getListCount() {
            return this.list_.size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
        public final SummaryInfo getList(int i) {
            return this.list_.get(i);
        }

        public final SummaryInfoOrBuilder getListOrBuilder(int i) {
            return this.list_.get(i);
        }

        private void ensureListIsMutable() {
            Internal.ProtobufList<SummaryInfo> protobufList = this.list_;
            if (protobufList.a()) {
                return;
            }
            this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setList(int i, SummaryInfo summaryInfo) {
            summaryInfo.getClass();
            Internal.ProtobufList<SummaryInfo> protobufList = this.list_;
            if (!protobufList.a()) {
                this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.list_.set(i, summaryInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addList(SummaryInfo summaryInfo) {
            summaryInfo.getClass();
            Internal.ProtobufList<SummaryInfo> protobufList = this.list_;
            if (!protobufList.a()) {
                this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.list_.add(summaryInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addList(int i, SummaryInfo summaryInfo) {
            summaryInfo.getClass();
            Internal.ProtobufList<SummaryInfo> protobufList = this.list_;
            if (!protobufList.a()) {
                this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.list_.add(i, summaryInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllList(Iterable<? extends SummaryInfo> iterable) {
            Internal.ProtobufList<SummaryInfo> protobufList = this.list_;
            if (!protobufList.a()) {
                this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.list_);
        }

        private void clearList() {
            this.list_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeList(int i) {
            Internal.ProtobufList<SummaryInfo> protobufList = this.list_;
            if (!protobufList.a()) {
                this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.list_.remove(i);
        }

        private MapFieldLite<String, String> internalGetValueMap() {
            return this.valueMap_;
        }

        private MapFieldLite<String, String> internalGetMutableValueMap() {
            if (!this.valueMap_.d()) {
                this.valueMap_ = this.valueMap_.b();
            }
            return this.valueMap_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
        public final int getValueMapCount() {
            return internalGetValueMap().size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
        public final boolean containsValueMap(String str) {
            str.getClass();
            return internalGetValueMap().containsKey(str);
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
        @Deprecated
        public final Map<String, String> getValueMap() {
            return getValueMapMap();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
        public final Map<String, String> getValueMapMap() {
            return Collections.unmodifiableMap(internalGetValueMap());
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
        public final String getValueMapOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> internalGetValueMap = internalGetValueMap();
            return internalGetValueMap.containsKey(str) ? internalGetValueMap.get(str) : str2;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
        public final String getValueMapOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> internalGetValueMap = internalGetValueMap();
            if (!internalGetValueMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return internalGetValueMap.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableValueMapMap() {
            return internalGetMutableValueMap();
        }

        public static UserInfoPackage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UserInfoPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static UserInfoPackage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UserInfoPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UserInfoPackage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UserInfoPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UserInfoPackage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UserInfoPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UserInfoPackage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UserInfoPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UserInfoPackage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UserInfoPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UserInfoPackage parseFrom(InputStream inputStream) throws IOException {
            return (UserInfoPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserInfoPackage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserInfoPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserInfoPackage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UserInfoPackage) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserInfoPackage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserInfoPackage) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserInfoPackage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UserInfoPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UserInfoPackage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserInfoPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UserInfoPackage userInfoPackage) {
            return DEFAULT_INSTANCE.createBuilder(userInfoPackage);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<UserInfoPackage, Builder> implements UserInfoPackageOrBuilder {
            private Builder() {
                super(UserInfoPackage.DEFAULT_INSTANCE);
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
            public final int getType() {
                return ((UserInfoPackage) this.instance).getType();
            }

            public final Builder setType(int i) {
                copyOnWrite();
                ((UserInfoPackage) this.instance).type_ = i;
                return this;
            }

            public final Builder clearType() {
                copyOnWrite();
                ((UserInfoPackage) this.instance).type_ = 0;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
            public final String getProceName() {
                return ((UserInfoPackage) this.instance).getProceName();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
            public final ByteString getProceNameBytes() {
                return ((UserInfoPackage) this.instance).getProceNameBytes();
            }

            public final Builder setProceName(String str) {
                copyOnWrite();
                UserInfoPackage.access$11100((UserInfoPackage) this.instance, str);
                return this;
            }

            public final Builder clearProceName() {
                copyOnWrite();
                UserInfoPackage.access$11200((UserInfoPackage) this.instance);
                return this;
            }

            public final Builder setProceNameBytes(ByteString byteString) {
                copyOnWrite();
                UserInfoPackage.access$11300((UserInfoPackage) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
            public final String getDeviceId() {
                return ((UserInfoPackage) this.instance).getDeviceId();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
            public final ByteString getDeviceIdBytes() {
                return ((UserInfoPackage) this.instance).getDeviceIdBytes();
            }

            public final Builder setDeviceId(String str) {
                copyOnWrite();
                UserInfoPackage.access$11400((UserInfoPackage) this.instance, str);
                return this;
            }

            public final Builder clearDeviceId() {
                copyOnWrite();
                UserInfoPackage.access$11500((UserInfoPackage) this.instance);
                return this;
            }

            public final Builder setDeviceIdBytes(ByteString byteString) {
                copyOnWrite();
                UserInfoPackage.access$11600((UserInfoPackage) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
            public final List<SummaryInfo> getListList() {
                return Collections.unmodifiableList(((UserInfoPackage) this.instance).getListList());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
            public final int getListCount() {
                return ((UserInfoPackage) this.instance).getListCount();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
            public final SummaryInfo getList(int i) {
                return ((UserInfoPackage) this.instance).getList(i);
            }

            public final Builder setList(int i, SummaryInfo summaryInfo) {
                copyOnWrite();
                ((UserInfoPackage) this.instance).setList(i, summaryInfo);
                return this;
            }

            public final Builder setList(int i, SummaryInfo.Builder builder) {
                copyOnWrite();
                ((UserInfoPackage) this.instance).setList(i, builder.h());
                return this;
            }

            public final Builder addList(SummaryInfo summaryInfo) {
                copyOnWrite();
                ((UserInfoPackage) this.instance).addList(summaryInfo);
                return this;
            }

            public final Builder addList(int i, SummaryInfo summaryInfo) {
                copyOnWrite();
                ((UserInfoPackage) this.instance).addList(i, summaryInfo);
                return this;
            }

            public final Builder addList(SummaryInfo.Builder builder) {
                copyOnWrite();
                ((UserInfoPackage) this.instance).addList(builder.h());
                return this;
            }

            public final Builder addList(int i, SummaryInfo.Builder builder) {
                copyOnWrite();
                ((UserInfoPackage) this.instance).addList(i, builder.h());
                return this;
            }

            public final Builder addAllList(Iterable<? extends SummaryInfo> iterable) {
                copyOnWrite();
                ((UserInfoPackage) this.instance).addAllList(iterable);
                return this;
            }

            public final Builder clearList() {
                copyOnWrite();
                UserInfoPackage.access$12100((UserInfoPackage) this.instance);
                return this;
            }

            public final Builder removeList(int i) {
                copyOnWrite();
                ((UserInfoPackage) this.instance).removeList(i);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
            public final int getValueMapCount() {
                return ((UserInfoPackage) this.instance).getValueMapMap().size();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
            public final boolean containsValueMap(String str) {
                str.getClass();
                return ((UserInfoPackage) this.instance).getValueMapMap().containsKey(str);
            }

            public final Builder clearValueMap() {
                copyOnWrite();
                ((UserInfoPackage) this.instance).getMutableValueMapMap().clear();
                return this;
            }

            public final Builder removeValueMap(String str) {
                str.getClass();
                copyOnWrite();
                ((UserInfoPackage) this.instance).getMutableValueMapMap().remove(str);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
            @Deprecated
            public final Map<String, String> getValueMap() {
                return getValueMapMap();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
            public final Map<String, String> getValueMapMap() {
                return Collections.unmodifiableMap(((UserInfoPackage) this.instance).getValueMapMap());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
            public final String getValueMapOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> valueMapMap = ((UserInfoPackage) this.instance).getValueMapMap();
                return valueMapMap.containsKey(str) ? valueMapMap.get(str) : str2;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoPackageOrBuilder
            public final String getValueMapOrThrow(String str) {
                str.getClass();
                Map<String, String> valueMapMap = ((UserInfoPackage) this.instance).getValueMapMap();
                if (!valueMapMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return valueMapMap.get(str);
            }

            public final Builder putValueMap(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((UserInfoPackage) this.instance).getMutableValueMapMap().put(str, str2);
                return this;
            }

            public final Builder putAllValueMap(Map<String, String> map) {
                copyOnWrite();
                ((UserInfoPackage) this.instance).getMutableValueMapMap().putAll(map);
                return this;
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new UserInfoPackage();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0001\u0001\u0000\u0001\u0004\u0002Ȉ\u0003Ȉ\u0004\u001b\u00052", new Object[]{"type_", "proceName_", "deviceId_", "list_", SummaryInfo.class, "valueMap_", a.f6568a});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<UserInfoPackage> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (UserInfoPackage.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            UserInfoPackage userInfoPackage = new UserInfoPackage();
            DEFAULT_INSTANCE = userInfoPackage;
            GeneratedMessageLite.registerDefaultInstance(UserInfoPackage.class, userInfoPackage);
        }

        public static UserInfoPackage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UserInfoPackage> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes3.dex */
    public static final class UserInfoList extends GeneratedMessageLite<UserInfoList, Builder> implements UserInfoListOrBuilder {
        private static final UserInfoList DEFAULT_INSTANCE;
        public static final int LIST_FIELD_NUMBER = 1;
        private static volatile Parser<UserInfoList> PARSER;
        private Internal.ProtobufList<UserInfoPackage> list_ = emptyProtobufList();

        static /* synthetic */ void access$13000(UserInfoList userInfoList) {
            userInfoList.list_ = emptyProtobufList();
        }

        private UserInfoList() {
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoListOrBuilder
        public final List<UserInfoPackage> getListList() {
            return this.list_;
        }

        public final List<? extends UserInfoPackageOrBuilder> getListOrBuilderList() {
            return this.list_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoListOrBuilder
        public final int getListCount() {
            return this.list_.size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoListOrBuilder
        public final UserInfoPackage getList(int i) {
            return this.list_.get(i);
        }

        public final UserInfoPackageOrBuilder getListOrBuilder(int i) {
            return this.list_.get(i);
        }

        private void ensureListIsMutable() {
            Internal.ProtobufList<UserInfoPackage> protobufList = this.list_;
            if (protobufList.a()) {
                return;
            }
            this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setList(int i, UserInfoPackage userInfoPackage) {
            userInfoPackage.getClass();
            Internal.ProtobufList<UserInfoPackage> protobufList = this.list_;
            if (!protobufList.a()) {
                this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.list_.set(i, userInfoPackage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addList(UserInfoPackage userInfoPackage) {
            userInfoPackage.getClass();
            Internal.ProtobufList<UserInfoPackage> protobufList = this.list_;
            if (!protobufList.a()) {
                this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.list_.add(userInfoPackage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addList(int i, UserInfoPackage userInfoPackage) {
            userInfoPackage.getClass();
            Internal.ProtobufList<UserInfoPackage> protobufList = this.list_;
            if (!protobufList.a()) {
                this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.list_.add(i, userInfoPackage);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllList(Iterable<? extends UserInfoPackage> iterable) {
            Internal.ProtobufList<UserInfoPackage> protobufList = this.list_;
            if (!protobufList.a()) {
                this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.list_);
        }

        private void clearList() {
            this.list_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeList(int i) {
            Internal.ProtobufList<UserInfoPackage> protobufList = this.list_;
            if (!protobufList.a()) {
                this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.list_.remove(i);
        }

        public static UserInfoList parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UserInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static UserInfoList parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UserInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UserInfoList parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UserInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static UserInfoList parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UserInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UserInfoList parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UserInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static UserInfoList parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UserInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UserInfoList parseFrom(InputStream inputStream) throws IOException {
            return (UserInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserInfoList parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserInfoList parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UserInfoList) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static UserInfoList parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserInfoList) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UserInfoList parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UserInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UserInfoList parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UserInfoList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UserInfoList userInfoList) {
            return DEFAULT_INSTANCE.createBuilder(userInfoList);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<UserInfoList, Builder> implements UserInfoListOrBuilder {
            private Builder() {
                super(UserInfoList.DEFAULT_INSTANCE);
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoListOrBuilder
            public final List<UserInfoPackage> getListList() {
                return Collections.unmodifiableList(((UserInfoList) this.instance).getListList());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoListOrBuilder
            public final int getListCount() {
                return ((UserInfoList) this.instance).getListCount();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.UserInfoListOrBuilder
            public final UserInfoPackage getList(int i) {
                return ((UserInfoList) this.instance).getList(i);
            }

            public final Builder setList(int i, UserInfoPackage userInfoPackage) {
                copyOnWrite();
                ((UserInfoList) this.instance).setList(i, userInfoPackage);
                return this;
            }

            public final Builder setList(int i, UserInfoPackage.Builder builder) {
                copyOnWrite();
                ((UserInfoList) this.instance).setList(i, builder.h());
                return this;
            }

            public final Builder addList(UserInfoPackage userInfoPackage) {
                copyOnWrite();
                ((UserInfoList) this.instance).addList(userInfoPackage);
                return this;
            }

            public final Builder addList(int i, UserInfoPackage userInfoPackage) {
                copyOnWrite();
                ((UserInfoList) this.instance).addList(i, userInfoPackage);
                return this;
            }

            public final Builder addList(UserInfoPackage.Builder builder) {
                copyOnWrite();
                ((UserInfoList) this.instance).addList(builder.h());
                return this;
            }

            public final Builder addList(int i, UserInfoPackage.Builder builder) {
                copyOnWrite();
                ((UserInfoList) this.instance).addList(i, builder.h());
                return this;
            }

            public final Builder addAllList(Iterable<? extends UserInfoPackage> iterable) {
                copyOnWrite();
                ((UserInfoList) this.instance).addAllList(iterable);
                return this;
            }

            public final Builder clearList() {
                copyOnWrite();
                UserInfoList.access$13000((UserInfoList) this.instance);
                return this;
            }

            public final Builder removeList(int i) {
                copyOnWrite();
                ((UserInfoList) this.instance).removeList(i);
                return this;
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new UserInfoList();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"list_", UserInfoPackage.class});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<UserInfoList> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (UserInfoList.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            UserInfoList userInfoList = new UserInfoList();
            DEFAULT_INSTANCE = userInfoList;
            GeneratedMessageLite.registerDefaultInstance(UserInfoList.class, userInfoList);
        }

        public static UserInfoList getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UserInfoList> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes3.dex */
    public static final class SummaryInfo extends GeneratedMessageLite<SummaryInfo, Builder> implements SummaryInfoOrBuilder {
        public static final int COLDSTART_FIELD_NUMBER = 8;
        private static final SummaryInfo DEFAULT_INSTANCE;
        public static final int GATEWAYIP_FIELD_NUMBER = 7;
        private static volatile Parser<SummaryInfo> PARSER = null;
        public static final int PROCENAME_FIELD_NUMBER = 4;
        public static final int SESSIONID_FIELD_NUMBER = 5;
        public static final int STARTTIME_FIELD_NUMBER = 1;
        public static final int STARTTYPE_FIELD_NUMBER = 2;
        public static final int USERID_FIELD_NUMBER = 3;
        public static final int VALUEMAP_FIELD_NUMBER = 6;
        private boolean coldStart_;
        private long startTime_;
        private int startType_;
        private MapFieldLite<String, String> valueMap_ = MapFieldLite.a();
        private String userId_ = "";
        private String proceName_ = "";
        private String sessionId_ = "";
        private String gatewayIp_ = "";

        /* loaded from: classes3.dex */
        static final class a {

            /* renamed from: a, reason: collision with root package name */
            static final MapEntryLite<String, String> f6567a = MapEntryLite.a(WireFormat.FieldType.i, "", WireFormat.FieldType.i, "");
        }

        static /* synthetic */ void access$13800(SummaryInfo summaryInfo, String str) {
            str.getClass();
            summaryInfo.userId_ = str;
        }

        static /* synthetic */ void access$13900(SummaryInfo summaryInfo) {
            summaryInfo.userId_ = getDefaultInstance().getUserId();
        }

        static /* synthetic */ void access$14000(SummaryInfo summaryInfo, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            summaryInfo.userId_ = byteString.f();
        }

        static /* synthetic */ void access$14100(SummaryInfo summaryInfo, String str) {
            str.getClass();
            summaryInfo.proceName_ = str;
        }

        static /* synthetic */ void access$14200(SummaryInfo summaryInfo) {
            summaryInfo.proceName_ = getDefaultInstance().getProceName();
        }

        static /* synthetic */ void access$14300(SummaryInfo summaryInfo, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            summaryInfo.proceName_ = byteString.f();
        }

        static /* synthetic */ void access$14400(SummaryInfo summaryInfo, String str) {
            str.getClass();
            summaryInfo.sessionId_ = str;
        }

        static /* synthetic */ void access$14500(SummaryInfo summaryInfo) {
            summaryInfo.sessionId_ = getDefaultInstance().getSessionId();
        }

        static /* synthetic */ void access$14600(SummaryInfo summaryInfo, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            summaryInfo.sessionId_ = byteString.f();
        }

        static /* synthetic */ void access$14800(SummaryInfo summaryInfo, String str) {
            str.getClass();
            summaryInfo.gatewayIp_ = str;
        }

        static /* synthetic */ void access$14900(SummaryInfo summaryInfo) {
            summaryInfo.gatewayIp_ = getDefaultInstance().getGatewayIp();
        }

        static /* synthetic */ void access$15000(SummaryInfo summaryInfo, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            summaryInfo.gatewayIp_ = byteString.f();
        }

        private SummaryInfo() {
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final long getStartTime() {
            return this.startTime_;
        }

        private void setStartTime(long j) {
            this.startTime_ = j;
        }

        private void clearStartTime() {
            this.startTime_ = 0L;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final int getStartType() {
            return this.startType_;
        }

        private void setStartType(int i) {
            this.startType_ = i;
        }

        private void clearStartType() {
            this.startType_ = 0;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final String getUserId() {
            return this.userId_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final ByteString getUserIdBytes() {
            return ByteString.a(this.userId_);
        }

        private void setUserId(String str) {
            str.getClass();
            this.userId_ = str;
        }

        private void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        private void setUserIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.userId_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final String getProceName() {
            return this.proceName_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final ByteString getProceNameBytes() {
            return ByteString.a(this.proceName_);
        }

        private void setProceName(String str) {
            str.getClass();
            this.proceName_ = str;
        }

        private void clearProceName() {
            this.proceName_ = getDefaultInstance().getProceName();
        }

        private void setProceNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.proceName_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final String getSessionId() {
            return this.sessionId_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final ByteString getSessionIdBytes() {
            return ByteString.a(this.sessionId_);
        }

        private void setSessionId(String str) {
            str.getClass();
            this.sessionId_ = str;
        }

        private void clearSessionId() {
            this.sessionId_ = getDefaultInstance().getSessionId();
        }

        private void setSessionIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.sessionId_ = byteString.f();
        }

        private MapFieldLite<String, String> internalGetValueMap() {
            return this.valueMap_;
        }

        private MapFieldLite<String, String> internalGetMutableValueMap() {
            if (!this.valueMap_.d()) {
                this.valueMap_ = this.valueMap_.b();
            }
            return this.valueMap_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final int getValueMapCount() {
            return internalGetValueMap().size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final boolean containsValueMap(String str) {
            str.getClass();
            return internalGetValueMap().containsKey(str);
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        @Deprecated
        public final Map<String, String> getValueMap() {
            return getValueMapMap();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final Map<String, String> getValueMapMap() {
            return Collections.unmodifiableMap(internalGetValueMap());
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final String getValueMapOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> internalGetValueMap = internalGetValueMap();
            return internalGetValueMap.containsKey(str) ? internalGetValueMap.get(str) : str2;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final String getValueMapOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> internalGetValueMap = internalGetValueMap();
            if (!internalGetValueMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return internalGetValueMap.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableValueMapMap() {
            return internalGetMutableValueMap();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final String getGatewayIp() {
            return this.gatewayIp_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final ByteString getGatewayIpBytes() {
            return ByteString.a(this.gatewayIp_);
        }

        private void setGatewayIp(String str) {
            str.getClass();
            this.gatewayIp_ = str;
        }

        private void clearGatewayIp() {
            this.gatewayIp_ = getDefaultInstance().getGatewayIp();
        }

        private void setGatewayIpBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.gatewayIp_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
        public final boolean getColdStart() {
            return this.coldStart_;
        }

        private void setColdStart(boolean z) {
            this.coldStart_ = z;
        }

        private void clearColdStart() {
            this.coldStart_ = false;
        }

        public static SummaryInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (SummaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static SummaryInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SummaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static SummaryInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (SummaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static SummaryInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SummaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static SummaryInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (SummaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static SummaryInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (SummaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static SummaryInfo parseFrom(InputStream inputStream) throws IOException {
            return (SummaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SummaryInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SummaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SummaryInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (SummaryInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static SummaryInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SummaryInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static SummaryInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (SummaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static SummaryInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (SummaryInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SummaryInfo summaryInfo) {
            return DEFAULT_INSTANCE.createBuilder(summaryInfo);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<SummaryInfo, Builder> implements SummaryInfoOrBuilder {
            private Builder() {
                super(SummaryInfo.DEFAULT_INSTANCE);
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final long getStartTime() {
                return ((SummaryInfo) this.instance).getStartTime();
            }

            public final Builder setStartTime(long j) {
                copyOnWrite();
                ((SummaryInfo) this.instance).startTime_ = j;
                return this;
            }

            public final Builder clearStartTime() {
                copyOnWrite();
                ((SummaryInfo) this.instance).startTime_ = 0L;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final int getStartType() {
                return ((SummaryInfo) this.instance).getStartType();
            }

            public final Builder setStartType(int i) {
                copyOnWrite();
                ((SummaryInfo) this.instance).startType_ = i;
                return this;
            }

            public final Builder clearStartType() {
                copyOnWrite();
                ((SummaryInfo) this.instance).startType_ = 0;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final String getUserId() {
                return ((SummaryInfo) this.instance).getUserId();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final ByteString getUserIdBytes() {
                return ((SummaryInfo) this.instance).getUserIdBytes();
            }

            public final Builder setUserId(String str) {
                copyOnWrite();
                SummaryInfo.access$13800((SummaryInfo) this.instance, str);
                return this;
            }

            public final Builder clearUserId() {
                copyOnWrite();
                SummaryInfo.access$13900((SummaryInfo) this.instance);
                return this;
            }

            public final Builder setUserIdBytes(ByteString byteString) {
                copyOnWrite();
                SummaryInfo.access$14000((SummaryInfo) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final String getProceName() {
                return ((SummaryInfo) this.instance).getProceName();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final ByteString getProceNameBytes() {
                return ((SummaryInfo) this.instance).getProceNameBytes();
            }

            public final Builder setProceName(String str) {
                copyOnWrite();
                SummaryInfo.access$14100((SummaryInfo) this.instance, str);
                return this;
            }

            public final Builder clearProceName() {
                copyOnWrite();
                SummaryInfo.access$14200((SummaryInfo) this.instance);
                return this;
            }

            public final Builder setProceNameBytes(ByteString byteString) {
                copyOnWrite();
                SummaryInfo.access$14300((SummaryInfo) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final String getSessionId() {
                return ((SummaryInfo) this.instance).getSessionId();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final ByteString getSessionIdBytes() {
                return ((SummaryInfo) this.instance).getSessionIdBytes();
            }

            public final Builder setSessionId(String str) {
                copyOnWrite();
                SummaryInfo.access$14400((SummaryInfo) this.instance, str);
                return this;
            }

            public final Builder clearSessionId() {
                copyOnWrite();
                SummaryInfo.access$14500((SummaryInfo) this.instance);
                return this;
            }

            public final Builder setSessionIdBytes(ByteString byteString) {
                copyOnWrite();
                SummaryInfo.access$14600((SummaryInfo) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final int getValueMapCount() {
                return ((SummaryInfo) this.instance).getValueMapMap().size();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final boolean containsValueMap(String str) {
                str.getClass();
                return ((SummaryInfo) this.instance).getValueMapMap().containsKey(str);
            }

            public final Builder clearValueMap() {
                copyOnWrite();
                ((SummaryInfo) this.instance).getMutableValueMapMap().clear();
                return this;
            }

            public final Builder removeValueMap(String str) {
                str.getClass();
                copyOnWrite();
                ((SummaryInfo) this.instance).getMutableValueMapMap().remove(str);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            @Deprecated
            public final Map<String, String> getValueMap() {
                return getValueMapMap();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final Map<String, String> getValueMapMap() {
                return Collections.unmodifiableMap(((SummaryInfo) this.instance).getValueMapMap());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final String getValueMapOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> valueMapMap = ((SummaryInfo) this.instance).getValueMapMap();
                return valueMapMap.containsKey(str) ? valueMapMap.get(str) : str2;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final String getValueMapOrThrow(String str) {
                str.getClass();
                Map<String, String> valueMapMap = ((SummaryInfo) this.instance).getValueMapMap();
                if (!valueMapMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return valueMapMap.get(str);
            }

            public final Builder putValueMap(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((SummaryInfo) this.instance).getMutableValueMapMap().put(str, str2);
                return this;
            }

            public final Builder putAllValueMap(Map<String, String> map) {
                copyOnWrite();
                ((SummaryInfo) this.instance).getMutableValueMapMap().putAll(map);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final String getGatewayIp() {
                return ((SummaryInfo) this.instance).getGatewayIp();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final ByteString getGatewayIpBytes() {
                return ((SummaryInfo) this.instance).getGatewayIpBytes();
            }

            public final Builder setGatewayIp(String str) {
                copyOnWrite();
                SummaryInfo.access$14800((SummaryInfo) this.instance, str);
                return this;
            }

            public final Builder clearGatewayIp() {
                copyOnWrite();
                SummaryInfo.access$14900((SummaryInfo) this.instance);
                return this;
            }

            public final Builder setGatewayIpBytes(ByteString byteString) {
                copyOnWrite();
                SummaryInfo.access$15000((SummaryInfo) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.SummaryInfoOrBuilder
            public final boolean getColdStart() {
                return ((SummaryInfo) this.instance).getColdStart();
            }

            public final Builder setColdStart(boolean z) {
                copyOnWrite();
                ((SummaryInfo) this.instance).coldStart_ = z;
                return this;
            }

            public final Builder clearColdStart() {
                copyOnWrite();
                ((SummaryInfo) this.instance).coldStart_ = false;
                return this;
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new SummaryInfo();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0001\u0000\u0000\u0001\u0002\u0002\u0004\u0003Ȉ\u0004Ȉ\u0005Ȉ\u00062\u0007Ȉ\b\u0007", new Object[]{"startTime_", "startType_", "userId_", "proceName_", "sessionId_", "valueMap_", a.f6567a, "gatewayIp_", "coldStart_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<SummaryInfo> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (SummaryInfo.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            SummaryInfo summaryInfo = new SummaryInfo();
            DEFAULT_INSTANCE = summaryInfo;
            GeneratedMessageLite.registerDefaultInstance(SummaryInfo.class, summaryInfo);
        }

        public static SummaryInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SummaryInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes3.dex */
    public static final class RqdStrategy extends GeneratedMessageLite<RqdStrategy, Builder> implements RqdStrategyOrBuilder {
        private static final RqdStrategy DEFAULT_INSTANCE;
        public static final int ENABLEQUERY_FIELD_NUMBER = 3;
        public static final int ENABLEUSERINFO_FIELD_NUMBER = 2;
        public static final int ENABLE_FIELD_NUMBER = 1;
        public static final int EVENTRECORDCOUNT_FIELD_NUMBER = 11;
        public static final int EVENTTIMEINTERVAL_FIELD_NUMBER = 12;
        public static final int EXPURL_FIELD_NUMBER = 5;
        public static final int HTTPSEXPURL_FIELD_NUMBER = 10;
        public static final int HTTPSURL_FIELD_NUMBER = 9;
        private static volatile Parser<RqdStrategy> PARSER = null;
        public static final int SECURITY_FIELD_NUMBER = 6;
        public static final int STRATEGYLASTUPDATETIME_FIELD_NUMBER = 8;
        public static final int URL_FIELD_NUMBER = 4;
        public static final int VALUEMAP_FIELD_NUMBER = 7;
        private boolean enableQuery_;
        private boolean enableUserInfo_;
        private boolean enable_;
        private int eventRecordCount_;
        private int eventTimeInterval_;
        private RqdSecurity security_;
        private long strategylastUpdateTime_;
        private MapFieldLite<String, String> valueMap_ = MapFieldLite.a();
        private String url_ = "";
        private String expUrl_ = "";
        private String httpsUrl_ = "";
        private String httpsExpUrl_ = "";

        /* loaded from: classes3.dex */
        static final class a {

            /* renamed from: a, reason: collision with root package name */
            static final MapEntryLite<String, String> f6566a = MapEntryLite.a(WireFormat.FieldType.i, "", WireFormat.FieldType.i, "");
        }

        static /* synthetic */ void access$16100(RqdStrategy rqdStrategy, String str) {
            str.getClass();
            rqdStrategy.url_ = str;
        }

        static /* synthetic */ void access$16200(RqdStrategy rqdStrategy) {
            rqdStrategy.url_ = getDefaultInstance().getUrl();
        }

        static /* synthetic */ void access$16300(RqdStrategy rqdStrategy, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            rqdStrategy.url_ = byteString.f();
        }

        static /* synthetic */ void access$16400(RqdStrategy rqdStrategy, String str) {
            str.getClass();
            rqdStrategy.expUrl_ = str;
        }

        static /* synthetic */ void access$16500(RqdStrategy rqdStrategy) {
            rqdStrategy.expUrl_ = getDefaultInstance().getExpUrl();
        }

        static /* synthetic */ void access$16600(RqdStrategy rqdStrategy, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            rqdStrategy.expUrl_ = byteString.f();
        }

        static /* synthetic */ void access$16700(RqdStrategy rqdStrategy, RqdSecurity rqdSecurity) {
            rqdSecurity.getClass();
            rqdStrategy.security_ = rqdSecurity;
        }

        static /* synthetic */ void access$17300(RqdStrategy rqdStrategy, String str) {
            str.getClass();
            rqdStrategy.httpsUrl_ = str;
        }

        static /* synthetic */ void access$17400(RqdStrategy rqdStrategy) {
            rqdStrategy.httpsUrl_ = getDefaultInstance().getHttpsUrl();
        }

        static /* synthetic */ void access$17500(RqdStrategy rqdStrategy, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            rqdStrategy.httpsUrl_ = byteString.f();
        }

        static /* synthetic */ void access$17600(RqdStrategy rqdStrategy, String str) {
            str.getClass();
            rqdStrategy.httpsExpUrl_ = str;
        }

        static /* synthetic */ void access$17700(RqdStrategy rqdStrategy) {
            rqdStrategy.httpsExpUrl_ = getDefaultInstance().getHttpsExpUrl();
        }

        static /* synthetic */ void access$17800(RqdStrategy rqdStrategy, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            rqdStrategy.httpsExpUrl_ = byteString.f();
        }

        private RqdStrategy() {
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final boolean getEnable() {
            return this.enable_;
        }

        private void setEnable(boolean z) {
            this.enable_ = z;
        }

        private void clearEnable() {
            this.enable_ = false;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final boolean getEnableUserInfo() {
            return this.enableUserInfo_;
        }

        private void setEnableUserInfo(boolean z) {
            this.enableUserInfo_ = z;
        }

        private void clearEnableUserInfo() {
            this.enableUserInfo_ = false;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final boolean getEnableQuery() {
            return this.enableQuery_;
        }

        private void setEnableQuery(boolean z) {
            this.enableQuery_ = z;
        }

        private void clearEnableQuery() {
            this.enableQuery_ = false;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final String getUrl() {
            return this.url_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final ByteString getUrlBytes() {
            return ByteString.a(this.url_);
        }

        private void setUrl(String str) {
            str.getClass();
            this.url_ = str;
        }

        private void clearUrl() {
            this.url_ = getDefaultInstance().getUrl();
        }

        private void setUrlBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.url_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final String getExpUrl() {
            return this.expUrl_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final ByteString getExpUrlBytes() {
            return ByteString.a(this.expUrl_);
        }

        private void setExpUrl(String str) {
            str.getClass();
            this.expUrl_ = str;
        }

        private void clearExpUrl() {
            this.expUrl_ = getDefaultInstance().getExpUrl();
        }

        private void setExpUrlBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.expUrl_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final boolean hasSecurity() {
            return this.security_ != null;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final RqdSecurity getSecurity() {
            RqdSecurity rqdSecurity = this.security_;
            return rqdSecurity == null ? RqdSecurity.getDefaultInstance() : rqdSecurity;
        }

        private void setSecurity(RqdSecurity rqdSecurity) {
            rqdSecurity.getClass();
            this.security_ = rqdSecurity;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSecurity(RqdSecurity rqdSecurity) {
            rqdSecurity.getClass();
            RqdSecurity rqdSecurity2 = this.security_;
            if (rqdSecurity2 != null && rqdSecurity2 != RqdSecurity.getDefaultInstance()) {
                this.security_ = RqdSecurity.newBuilder(this.security_).mergeFrom((RqdSecurity.Builder) rqdSecurity).h();
            } else {
                this.security_ = rqdSecurity;
            }
        }

        private void clearSecurity() {
            this.security_ = null;
        }

        private MapFieldLite<String, String> internalGetValueMap() {
            return this.valueMap_;
        }

        private MapFieldLite<String, String> internalGetMutableValueMap() {
            if (!this.valueMap_.d()) {
                this.valueMap_ = this.valueMap_.b();
            }
            return this.valueMap_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final int getValueMapCount() {
            return internalGetValueMap().size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final boolean containsValueMap(String str) {
            str.getClass();
            return internalGetValueMap().containsKey(str);
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        @Deprecated
        public final Map<String, String> getValueMap() {
            return getValueMapMap();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final Map<String, String> getValueMapMap() {
            return Collections.unmodifiableMap(internalGetValueMap());
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final String getValueMapOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> internalGetValueMap = internalGetValueMap();
            return internalGetValueMap.containsKey(str) ? internalGetValueMap.get(str) : str2;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final String getValueMapOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> internalGetValueMap = internalGetValueMap();
            if (!internalGetValueMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return internalGetValueMap.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableValueMapMap() {
            return internalGetMutableValueMap();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final long getStrategylastUpdateTime() {
            return this.strategylastUpdateTime_;
        }

        private void setStrategylastUpdateTime(long j) {
            this.strategylastUpdateTime_ = j;
        }

        private void clearStrategylastUpdateTime() {
            this.strategylastUpdateTime_ = 0L;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final String getHttpsUrl() {
            return this.httpsUrl_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final ByteString getHttpsUrlBytes() {
            return ByteString.a(this.httpsUrl_);
        }

        private void setHttpsUrl(String str) {
            str.getClass();
            this.httpsUrl_ = str;
        }

        private void clearHttpsUrl() {
            this.httpsUrl_ = getDefaultInstance().getHttpsUrl();
        }

        private void setHttpsUrlBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.httpsUrl_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final String getHttpsExpUrl() {
            return this.httpsExpUrl_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final ByteString getHttpsExpUrlBytes() {
            return ByteString.a(this.httpsExpUrl_);
        }

        private void setHttpsExpUrl(String str) {
            str.getClass();
            this.httpsExpUrl_ = str;
        }

        private void clearHttpsExpUrl() {
            this.httpsExpUrl_ = getDefaultInstance().getHttpsExpUrl();
        }

        private void setHttpsExpUrlBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.httpsExpUrl_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final int getEventRecordCount() {
            return this.eventRecordCount_;
        }

        private void setEventRecordCount(int i) {
            this.eventRecordCount_ = i;
        }

        private void clearEventRecordCount() {
            this.eventRecordCount_ = 0;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
        public final int getEventTimeInterval() {
            return this.eventTimeInterval_;
        }

        private void setEventTimeInterval(int i) {
            this.eventTimeInterval_ = i;
        }

        private void clearEventTimeInterval() {
            this.eventTimeInterval_ = 0;
        }

        public static RqdStrategy parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (RqdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static RqdStrategy parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RqdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RqdStrategy parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (RqdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RqdStrategy parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RqdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RqdStrategy parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (RqdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RqdStrategy parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RqdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RqdStrategy parseFrom(InputStream inputStream) throws IOException {
            return (RqdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RqdStrategy parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RqdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RqdStrategy parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RqdStrategy) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RqdStrategy parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RqdStrategy) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RqdStrategy parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (RqdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RqdStrategy parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RqdStrategy) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RqdStrategy rqdStrategy) {
            return DEFAULT_INSTANCE.createBuilder(rqdStrategy);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<RqdStrategy, Builder> implements RqdStrategyOrBuilder {
            private Builder() {
                super(RqdStrategy.DEFAULT_INSTANCE);
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final boolean getEnable() {
                return ((RqdStrategy) this.instance).getEnable();
            }

            public final Builder setEnable(boolean z) {
                copyOnWrite();
                ((RqdStrategy) this.instance).enable_ = z;
                return this;
            }

            public final Builder clearEnable() {
                copyOnWrite();
                ((RqdStrategy) this.instance).enable_ = false;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final boolean getEnableUserInfo() {
                return ((RqdStrategy) this.instance).getEnableUserInfo();
            }

            public final Builder setEnableUserInfo(boolean z) {
                copyOnWrite();
                ((RqdStrategy) this.instance).enableUserInfo_ = z;
                return this;
            }

            public final Builder clearEnableUserInfo() {
                copyOnWrite();
                ((RqdStrategy) this.instance).enableUserInfo_ = false;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final boolean getEnableQuery() {
                return ((RqdStrategy) this.instance).getEnableQuery();
            }

            public final Builder setEnableQuery(boolean z) {
                copyOnWrite();
                ((RqdStrategy) this.instance).enableQuery_ = z;
                return this;
            }

            public final Builder clearEnableQuery() {
                copyOnWrite();
                ((RqdStrategy) this.instance).enableQuery_ = false;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final String getUrl() {
                return ((RqdStrategy) this.instance).getUrl();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final ByteString getUrlBytes() {
                return ((RqdStrategy) this.instance).getUrlBytes();
            }

            public final Builder setUrl(String str) {
                copyOnWrite();
                RqdStrategy.access$16100((RqdStrategy) this.instance, str);
                return this;
            }

            public final Builder clearUrl() {
                copyOnWrite();
                RqdStrategy.access$16200((RqdStrategy) this.instance);
                return this;
            }

            public final Builder setUrlBytes(ByteString byteString) {
                copyOnWrite();
                RqdStrategy.access$16300((RqdStrategy) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final String getExpUrl() {
                return ((RqdStrategy) this.instance).getExpUrl();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final ByteString getExpUrlBytes() {
                return ((RqdStrategy) this.instance).getExpUrlBytes();
            }

            public final Builder setExpUrl(String str) {
                copyOnWrite();
                RqdStrategy.access$16400((RqdStrategy) this.instance, str);
                return this;
            }

            public final Builder clearExpUrl() {
                copyOnWrite();
                RqdStrategy.access$16500((RqdStrategy) this.instance);
                return this;
            }

            public final Builder setExpUrlBytes(ByteString byteString) {
                copyOnWrite();
                RqdStrategy.access$16600((RqdStrategy) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final boolean hasSecurity() {
                return ((RqdStrategy) this.instance).hasSecurity();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final RqdSecurity getSecurity() {
                return ((RqdStrategy) this.instance).getSecurity();
            }

            public final Builder setSecurity(RqdSecurity rqdSecurity) {
                copyOnWrite();
                RqdStrategy.access$16700((RqdStrategy) this.instance, rqdSecurity);
                return this;
            }

            public final Builder setSecurity(RqdSecurity.Builder builder) {
                copyOnWrite();
                RqdStrategy.access$16700((RqdStrategy) this.instance, builder.h());
                return this;
            }

            public final Builder mergeSecurity(RqdSecurity rqdSecurity) {
                copyOnWrite();
                ((RqdStrategy) this.instance).mergeSecurity(rqdSecurity);
                return this;
            }

            public final Builder clearSecurity() {
                copyOnWrite();
                ((RqdStrategy) this.instance).security_ = null;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final int getValueMapCount() {
                return ((RqdStrategy) this.instance).getValueMapMap().size();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final boolean containsValueMap(String str) {
                str.getClass();
                return ((RqdStrategy) this.instance).getValueMapMap().containsKey(str);
            }

            public final Builder clearValueMap() {
                copyOnWrite();
                ((RqdStrategy) this.instance).getMutableValueMapMap().clear();
                return this;
            }

            public final Builder removeValueMap(String str) {
                str.getClass();
                copyOnWrite();
                ((RqdStrategy) this.instance).getMutableValueMapMap().remove(str);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            @Deprecated
            public final Map<String, String> getValueMap() {
                return getValueMapMap();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final Map<String, String> getValueMapMap() {
                return Collections.unmodifiableMap(((RqdStrategy) this.instance).getValueMapMap());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final String getValueMapOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> valueMapMap = ((RqdStrategy) this.instance).getValueMapMap();
                return valueMapMap.containsKey(str) ? valueMapMap.get(str) : str2;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final String getValueMapOrThrow(String str) {
                str.getClass();
                Map<String, String> valueMapMap = ((RqdStrategy) this.instance).getValueMapMap();
                if (!valueMapMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return valueMapMap.get(str);
            }

            public final Builder putValueMap(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((RqdStrategy) this.instance).getMutableValueMapMap().put(str, str2);
                return this;
            }

            public final Builder putAllValueMap(Map<String, String> map) {
                copyOnWrite();
                ((RqdStrategy) this.instance).getMutableValueMapMap().putAll(map);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final long getStrategylastUpdateTime() {
                return ((RqdStrategy) this.instance).getStrategylastUpdateTime();
            }

            public final Builder setStrategylastUpdateTime(long j) {
                copyOnWrite();
                ((RqdStrategy) this.instance).strategylastUpdateTime_ = j;
                return this;
            }

            public final Builder clearStrategylastUpdateTime() {
                copyOnWrite();
                ((RqdStrategy) this.instance).strategylastUpdateTime_ = 0L;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final String getHttpsUrl() {
                return ((RqdStrategy) this.instance).getHttpsUrl();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final ByteString getHttpsUrlBytes() {
                return ((RqdStrategy) this.instance).getHttpsUrlBytes();
            }

            public final Builder setHttpsUrl(String str) {
                copyOnWrite();
                RqdStrategy.access$17300((RqdStrategy) this.instance, str);
                return this;
            }

            public final Builder clearHttpsUrl() {
                copyOnWrite();
                RqdStrategy.access$17400((RqdStrategy) this.instance);
                return this;
            }

            public final Builder setHttpsUrlBytes(ByteString byteString) {
                copyOnWrite();
                RqdStrategy.access$17500((RqdStrategy) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final String getHttpsExpUrl() {
                return ((RqdStrategy) this.instance).getHttpsExpUrl();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final ByteString getHttpsExpUrlBytes() {
                return ((RqdStrategy) this.instance).getHttpsExpUrlBytes();
            }

            public final Builder setHttpsExpUrl(String str) {
                copyOnWrite();
                RqdStrategy.access$17600((RqdStrategy) this.instance, str);
                return this;
            }

            public final Builder clearHttpsExpUrl() {
                copyOnWrite();
                RqdStrategy.access$17700((RqdStrategy) this.instance);
                return this;
            }

            public final Builder setHttpsExpUrlBytes(ByteString byteString) {
                copyOnWrite();
                RqdStrategy.access$17800((RqdStrategy) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final int getEventRecordCount() {
                return ((RqdStrategy) this.instance).getEventRecordCount();
            }

            public final Builder setEventRecordCount(int i) {
                copyOnWrite();
                ((RqdStrategy) this.instance).eventRecordCount_ = i;
                return this;
            }

            public final Builder clearEventRecordCount() {
                copyOnWrite();
                ((RqdStrategy) this.instance).eventRecordCount_ = 0;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdStrategyOrBuilder
            public final int getEventTimeInterval() {
                return ((RqdStrategy) this.instance).getEventTimeInterval();
            }

            public final Builder setEventTimeInterval(int i) {
                copyOnWrite();
                ((RqdStrategy) this.instance).eventTimeInterval_ = i;
                return this;
            }

            public final Builder clearEventTimeInterval() {
                copyOnWrite();
                ((RqdStrategy) this.instance).eventTimeInterval_ = 0;
                return this;
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new RqdStrategy();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\f\u0000\u0000\u0001\f\f\u0001\u0000\u0000\u0001\u0007\u0002\u0007\u0003\u0007\u0004Ȉ\u0005Ȉ\u0006\t\u00072\b\u0002\tȈ\nȈ\u000b\u0004\f\u0004", new Object[]{"enable_", "enableUserInfo_", "enableQuery_", "url_", "expUrl_", "security_", "valueMap_", a.f6566a, "strategylastUpdateTime_", "httpsUrl_", "httpsExpUrl_", "eventRecordCount_", "eventTimeInterval_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<RqdStrategy> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (RqdStrategy.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            RqdStrategy rqdStrategy = new RqdStrategy();
            DEFAULT_INSTANCE = rqdStrategy;
            GeneratedMessageLite.registerDefaultInstance(RqdStrategy.class, rqdStrategy);
        }

        public static RqdStrategy getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RqdStrategy> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes3.dex */
    public static final class RqdSecurity extends GeneratedMessageLite<RqdSecurity, Builder> implements RqdSecurityOrBuilder {
        private static final RqdSecurity DEFAULT_INSTANCE;
        public static final int ENCKEY_FIELD_NUMBER = 1;
        public static final int ENCPUBKEY_FIELD_NUMBER = 2;
        private static volatile Parser<RqdSecurity> PARSER;
        private String encKey_ = "";
        private String encPubKey_ = "";

        static /* synthetic */ void access$18500(RqdSecurity rqdSecurity, String str) {
            str.getClass();
            rqdSecurity.encKey_ = str;
        }

        static /* synthetic */ void access$18600(RqdSecurity rqdSecurity) {
            rqdSecurity.encKey_ = getDefaultInstance().getEncKey();
        }

        static /* synthetic */ void access$18700(RqdSecurity rqdSecurity, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            rqdSecurity.encKey_ = byteString.f();
        }

        static /* synthetic */ void access$18800(RqdSecurity rqdSecurity, String str) {
            str.getClass();
            rqdSecurity.encPubKey_ = str;
        }

        static /* synthetic */ void access$18900(RqdSecurity rqdSecurity) {
            rqdSecurity.encPubKey_ = getDefaultInstance().getEncPubKey();
        }

        static /* synthetic */ void access$19000(RqdSecurity rqdSecurity, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            rqdSecurity.encPubKey_ = byteString.f();
        }

        private RqdSecurity() {
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdSecurityOrBuilder
        public final String getEncKey() {
            return this.encKey_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdSecurityOrBuilder
        public final ByteString getEncKeyBytes() {
            return ByteString.a(this.encKey_);
        }

        private void setEncKey(String str) {
            str.getClass();
            this.encKey_ = str;
        }

        private void clearEncKey() {
            this.encKey_ = getDefaultInstance().getEncKey();
        }

        private void setEncKeyBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.encKey_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdSecurityOrBuilder
        public final String getEncPubKey() {
            return this.encPubKey_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdSecurityOrBuilder
        public final ByteString getEncPubKeyBytes() {
            return ByteString.a(this.encPubKey_);
        }

        private void setEncPubKey(String str) {
            str.getClass();
            this.encPubKey_ = str;
        }

        private void clearEncPubKey() {
            this.encPubKey_ = getDefaultInstance().getEncPubKey();
        }

        private void setEncPubKeyBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.encPubKey_ = byteString.f();
        }

        public static RqdSecurity parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (RqdSecurity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static RqdSecurity parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RqdSecurity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static RqdSecurity parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (RqdSecurity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static RqdSecurity parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RqdSecurity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static RqdSecurity parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (RqdSecurity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static RqdSecurity parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (RqdSecurity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static RqdSecurity parseFrom(InputStream inputStream) throws IOException {
            return (RqdSecurity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RqdSecurity parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RqdSecurity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RqdSecurity parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (RqdSecurity) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static RqdSecurity parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RqdSecurity) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static RqdSecurity parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (RqdSecurity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static RqdSecurity parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (RqdSecurity) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RqdSecurity rqdSecurity) {
            return DEFAULT_INSTANCE.createBuilder(rqdSecurity);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<RqdSecurity, Builder> implements RqdSecurityOrBuilder {
            private Builder() {
                super(RqdSecurity.DEFAULT_INSTANCE);
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdSecurityOrBuilder
            public final String getEncKey() {
                return ((RqdSecurity) this.instance).getEncKey();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdSecurityOrBuilder
            public final ByteString getEncKeyBytes() {
                return ((RqdSecurity) this.instance).getEncKeyBytes();
            }

            public final Builder setEncKey(String str) {
                copyOnWrite();
                RqdSecurity.access$18500((RqdSecurity) this.instance, str);
                return this;
            }

            public final Builder clearEncKey() {
                copyOnWrite();
                RqdSecurity.access$18600((RqdSecurity) this.instance);
                return this;
            }

            public final Builder setEncKeyBytes(ByteString byteString) {
                copyOnWrite();
                RqdSecurity.access$18700((RqdSecurity) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdSecurityOrBuilder
            public final String getEncPubKey() {
                return ((RqdSecurity) this.instance).getEncPubKey();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.RqdSecurityOrBuilder
            public final ByteString getEncPubKeyBytes() {
                return ((RqdSecurity) this.instance).getEncPubKeyBytes();
            }

            public final Builder setEncPubKey(String str) {
                copyOnWrite();
                RqdSecurity.access$18800((RqdSecurity) this.instance, str);
                return this;
            }

            public final Builder clearEncPubKey() {
                copyOnWrite();
                RqdSecurity.access$18900((RqdSecurity) this.instance);
                return this;
            }

            public final Builder setEncPubKeyBytes(ByteString byteString) {
                copyOnWrite();
                RqdSecurity.access$19000((RqdSecurity) this.instance, byteString);
                return this;
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new RqdSecurity();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"encKey_", "encPubKey_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<RqdSecurity> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (RqdSecurity.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            RqdSecurity rqdSecurity = new RqdSecurity();
            DEFAULT_INSTANCE = rqdSecurity;
            GeneratedMessageLite.registerDefaultInstance(RqdSecurity.class, rqdSecurity);
        }

        public static RqdSecurity getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RqdSecurity> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes3.dex */
    public static final class AppSession extends GeneratedMessageLite<AppSession, Builder> implements AppSessionOrBuilder {
        private static final AppSession DEFAULT_INSTANCE;
        public static final int EVENTS_FIELD_NUMBER = 2;
        private static volatile Parser<AppSession> PARSER = null;
        public static final int SESSIONID_FIELD_NUMBER = 1;
        private String sessionId_ = "";
        private Internal.ProtobufList<String> events_ = GeneratedMessageLite.emptyProtobufList();

        static /* synthetic */ void access$19300(AppSession appSession, String str) {
            str.getClass();
            appSession.sessionId_ = str;
        }

        static /* synthetic */ void access$19400(AppSession appSession) {
            appSession.sessionId_ = getDefaultInstance().getSessionId();
        }

        static /* synthetic */ void access$19500(AppSession appSession, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            appSession.sessionId_ = byteString.f();
        }

        static /* synthetic */ void access$19900(AppSession appSession) {
            appSession.events_ = GeneratedMessageLite.emptyProtobufList();
        }

        private AppSession() {
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppSessionOrBuilder
        public final String getSessionId() {
            return this.sessionId_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppSessionOrBuilder
        public final ByteString getSessionIdBytes() {
            return ByteString.a(this.sessionId_);
        }

        private void setSessionId(String str) {
            str.getClass();
            this.sessionId_ = str;
        }

        private void clearSessionId() {
            this.sessionId_ = getDefaultInstance().getSessionId();
        }

        private void setSessionIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.sessionId_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppSessionOrBuilder
        public final List<String> getEventsList() {
            return this.events_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppSessionOrBuilder
        public final int getEventsCount() {
            return this.events_.size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppSessionOrBuilder
        public final String getEvents(int i) {
            return this.events_.get(i);
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppSessionOrBuilder
        public final ByteString getEventsBytes(int i) {
            return ByteString.a(this.events_.get(i));
        }

        private void ensureEventsIsMutable() {
            Internal.ProtobufList<String> protobufList = this.events_;
            if (protobufList.a()) {
                return;
            }
            this.events_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEvents(int i, String str) {
            str.getClass();
            Internal.ProtobufList<String> protobufList = this.events_;
            if (!protobufList.a()) {
                this.events_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.events_.set(i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEvents(String str) {
            str.getClass();
            Internal.ProtobufList<String> protobufList = this.events_;
            if (!protobufList.a()) {
                this.events_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.events_.add(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllEvents(Iterable<String> iterable) {
            Internal.ProtobufList<String> protobufList = this.events_;
            if (!protobufList.a()) {
                this.events_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.events_);
        }

        private void clearEvents() {
            this.events_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addEventsBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            Internal.ProtobufList<String> protobufList = this.events_;
            if (!protobufList.a()) {
                this.events_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.events_.add(byteString.f());
        }

        public static AppSession parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AppSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AppSession parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AppSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AppSession parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AppSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AppSession parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AppSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AppSession parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AppSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AppSession parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AppSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AppSession parseFrom(InputStream inputStream) throws IOException {
            return (AppSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppSession parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AppSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AppSession parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AppSession) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppSession parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AppSession) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AppSession parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AppSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AppSession parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AppSession) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AppSession appSession) {
            return DEFAULT_INSTANCE.createBuilder(appSession);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<AppSession, Builder> implements AppSessionOrBuilder {
            private Builder() {
                super(AppSession.DEFAULT_INSTANCE);
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppSessionOrBuilder
            public final String getSessionId() {
                return ((AppSession) this.instance).getSessionId();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppSessionOrBuilder
            public final ByteString getSessionIdBytes() {
                return ((AppSession) this.instance).getSessionIdBytes();
            }

            public final Builder setSessionId(String str) {
                copyOnWrite();
                AppSession.access$19300((AppSession) this.instance, str);
                return this;
            }

            public final Builder clearSessionId() {
                copyOnWrite();
                AppSession.access$19400((AppSession) this.instance);
                return this;
            }

            public final Builder setSessionIdBytes(ByteString byteString) {
                copyOnWrite();
                AppSession.access$19500((AppSession) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppSessionOrBuilder
            public final List<String> getEventsList() {
                return Collections.unmodifiableList(((AppSession) this.instance).getEventsList());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppSessionOrBuilder
            public final int getEventsCount() {
                return ((AppSession) this.instance).getEventsCount();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppSessionOrBuilder
            public final String getEvents(int i) {
                return ((AppSession) this.instance).getEvents(i);
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppSessionOrBuilder
            public final ByteString getEventsBytes(int i) {
                return ((AppSession) this.instance).getEventsBytes(i);
            }

            public final Builder setEvents(int i, String str) {
                copyOnWrite();
                ((AppSession) this.instance).setEvents(i, str);
                return this;
            }

            public final Builder addEvents(String str) {
                copyOnWrite();
                ((AppSession) this.instance).addEvents(str);
                return this;
            }

            public final Builder addAllEvents(Iterable<String> iterable) {
                copyOnWrite();
                ((AppSession) this.instance).addAllEvents(iterable);
                return this;
            }

            public final Builder clearEvents() {
                copyOnWrite();
                AppSession.access$19900((AppSession) this.instance);
                return this;
            }

            public final Builder addEventsBytes(ByteString byteString) {
                copyOnWrite();
                ((AppSession) this.instance).addEventsBytes(byteString);
                return this;
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new AppSession();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002Ț", new Object[]{"sessionId_", "events_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<AppSession> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (AppSession.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            AppSession appSession = new AppSession();
            DEFAULT_INSTANCE = appSession;
            GeneratedMessageLite.registerDefaultInstance(AppSession.class, appSession);
        }

        public static AppSession getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AppSession> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes3.dex */
    public static final class AppInfo extends GeneratedMessageLite<AppInfo, Builder> implements AppInfoOrBuilder {
        public static final int ARCH_FIELD_NUMBER = 2;
        public static final int BASEADDR_FIELD_NUMBER = 4;
        private static final AppInfo DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<AppInfo> PARSER = null;
        public static final int UUID_FIELD_NUMBER = 3;
        public static final int VALUEMAP_FIELD_NUMBER = 6;
        public static final int VER_FIELD_NUMBER = 5;
        private MapFieldLite<String, String> valueMap_ = MapFieldLite.a();
        private String name_ = "";
        private String arch_ = "";
        private String uUID_ = "";
        private String baseAddr_ = "";
        private String ver_ = "";

        /* loaded from: classes3.dex */
        static final class a {

            /* renamed from: a, reason: collision with root package name */
            static final MapEntryLite<String, String> f6560a = MapEntryLite.a(WireFormat.FieldType.i, "", WireFormat.FieldType.i, "");
        }

        static /* synthetic */ void access$20300(AppInfo appInfo, String str) {
            str.getClass();
            appInfo.name_ = str;
        }

        static /* synthetic */ void access$20400(AppInfo appInfo) {
            appInfo.name_ = getDefaultInstance().getName();
        }

        static /* synthetic */ void access$20500(AppInfo appInfo, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            appInfo.name_ = byteString.f();
        }

        static /* synthetic */ void access$20600(AppInfo appInfo, String str) {
            str.getClass();
            appInfo.arch_ = str;
        }

        static /* synthetic */ void access$20700(AppInfo appInfo) {
            appInfo.arch_ = getDefaultInstance().getArch();
        }

        static /* synthetic */ void access$20800(AppInfo appInfo, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            appInfo.arch_ = byteString.f();
        }

        static /* synthetic */ void access$20900(AppInfo appInfo, String str) {
            str.getClass();
            appInfo.uUID_ = str;
        }

        static /* synthetic */ void access$21000(AppInfo appInfo) {
            appInfo.uUID_ = getDefaultInstance().getUUID();
        }

        static /* synthetic */ void access$21100(AppInfo appInfo, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            appInfo.uUID_ = byteString.f();
        }

        static /* synthetic */ void access$21200(AppInfo appInfo, String str) {
            str.getClass();
            appInfo.baseAddr_ = str;
        }

        static /* synthetic */ void access$21300(AppInfo appInfo) {
            appInfo.baseAddr_ = getDefaultInstance().getBaseAddr();
        }

        static /* synthetic */ void access$21400(AppInfo appInfo, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            appInfo.baseAddr_ = byteString.f();
        }

        static /* synthetic */ void access$21500(AppInfo appInfo, String str) {
            str.getClass();
            appInfo.ver_ = str;
        }

        static /* synthetic */ void access$21600(AppInfo appInfo) {
            appInfo.ver_ = getDefaultInstance().getVer();
        }

        static /* synthetic */ void access$21700(AppInfo appInfo, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            appInfo.ver_ = byteString.f();
        }

        private AppInfo() {
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        public final String getName() {
            return this.name_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        public final ByteString getNameBytes() {
            return ByteString.a(this.name_);
        }

        private void setName(String str) {
            str.getClass();
            this.name_ = str;
        }

        private void clearName() {
            this.name_ = getDefaultInstance().getName();
        }

        private void setNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.name_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        public final String getArch() {
            return this.arch_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        public final ByteString getArchBytes() {
            return ByteString.a(this.arch_);
        }

        private void setArch(String str) {
            str.getClass();
            this.arch_ = str;
        }

        private void clearArch() {
            this.arch_ = getDefaultInstance().getArch();
        }

        private void setArchBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.arch_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        public final String getUUID() {
            return this.uUID_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        public final ByteString getUUIDBytes() {
            return ByteString.a(this.uUID_);
        }

        private void setUUID(String str) {
            str.getClass();
            this.uUID_ = str;
        }

        private void clearUUID() {
            this.uUID_ = getDefaultInstance().getUUID();
        }

        private void setUUIDBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.uUID_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        public final String getBaseAddr() {
            return this.baseAddr_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        public final ByteString getBaseAddrBytes() {
            return ByteString.a(this.baseAddr_);
        }

        private void setBaseAddr(String str) {
            str.getClass();
            this.baseAddr_ = str;
        }

        private void clearBaseAddr() {
            this.baseAddr_ = getDefaultInstance().getBaseAddr();
        }

        private void setBaseAddrBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.baseAddr_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        public final String getVer() {
            return this.ver_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        public final ByteString getVerBytes() {
            return ByteString.a(this.ver_);
        }

        private void setVer(String str) {
            str.getClass();
            this.ver_ = str;
        }

        private void clearVer() {
            this.ver_ = getDefaultInstance().getVer();
        }

        private void setVerBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.ver_ = byteString.f();
        }

        private MapFieldLite<String, String> internalGetValueMap() {
            return this.valueMap_;
        }

        private MapFieldLite<String, String> internalGetMutableValueMap() {
            if (!this.valueMap_.d()) {
                this.valueMap_ = this.valueMap_.b();
            }
            return this.valueMap_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        public final int getValueMapCount() {
            return internalGetValueMap().size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        public final boolean containsValueMap(String str) {
            str.getClass();
            return internalGetValueMap().containsKey(str);
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        @Deprecated
        public final Map<String, String> getValueMap() {
            return getValueMapMap();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        public final Map<String, String> getValueMapMap() {
            return Collections.unmodifiableMap(internalGetValueMap());
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        public final String getValueMapOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> internalGetValueMap = internalGetValueMap();
            return internalGetValueMap.containsKey(str) ? internalGetValueMap.get(str) : str2;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
        public final String getValueMapOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> internalGetValueMap = internalGetValueMap();
            if (!internalGetValueMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return internalGetValueMap.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableValueMapMap() {
            return internalGetMutableValueMap();
        }

        public static AppInfo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static AppInfo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static AppInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static AppInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static AppInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static AppInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static AppInfo parseFrom(InputStream inputStream) throws IOException {
            return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AppInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (AppInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static AppInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AppInfo) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static AppInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static AppInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (AppInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AppInfo appInfo) {
            return DEFAULT_INSTANCE.createBuilder(appInfo);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<AppInfo, Builder> implements AppInfoOrBuilder {
            private Builder() {
                super(AppInfo.DEFAULT_INSTANCE);
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            public final String getName() {
                return ((AppInfo) this.instance).getName();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            public final ByteString getNameBytes() {
                return ((AppInfo) this.instance).getNameBytes();
            }

            public final Builder setName(String str) {
                copyOnWrite();
                AppInfo.access$20300((AppInfo) this.instance, str);
                return this;
            }

            public final Builder clearName() {
                copyOnWrite();
                AppInfo.access$20400((AppInfo) this.instance);
                return this;
            }

            public final Builder setNameBytes(ByteString byteString) {
                copyOnWrite();
                AppInfo.access$20500((AppInfo) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            public final String getArch() {
                return ((AppInfo) this.instance).getArch();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            public final ByteString getArchBytes() {
                return ((AppInfo) this.instance).getArchBytes();
            }

            public final Builder setArch(String str) {
                copyOnWrite();
                AppInfo.access$20600((AppInfo) this.instance, str);
                return this;
            }

            public final Builder clearArch() {
                copyOnWrite();
                AppInfo.access$20700((AppInfo) this.instance);
                return this;
            }

            public final Builder setArchBytes(ByteString byteString) {
                copyOnWrite();
                AppInfo.access$20800((AppInfo) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            public final String getUUID() {
                return ((AppInfo) this.instance).getUUID();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            public final ByteString getUUIDBytes() {
                return ((AppInfo) this.instance).getUUIDBytes();
            }

            public final Builder setUUID(String str) {
                copyOnWrite();
                AppInfo.access$20900((AppInfo) this.instance, str);
                return this;
            }

            public final Builder clearUUID() {
                copyOnWrite();
                AppInfo.access$21000((AppInfo) this.instance);
                return this;
            }

            public final Builder setUUIDBytes(ByteString byteString) {
                copyOnWrite();
                AppInfo.access$21100((AppInfo) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            public final String getBaseAddr() {
                return ((AppInfo) this.instance).getBaseAddr();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            public final ByteString getBaseAddrBytes() {
                return ((AppInfo) this.instance).getBaseAddrBytes();
            }

            public final Builder setBaseAddr(String str) {
                copyOnWrite();
                AppInfo.access$21200((AppInfo) this.instance, str);
                return this;
            }

            public final Builder clearBaseAddr() {
                copyOnWrite();
                AppInfo.access$21300((AppInfo) this.instance);
                return this;
            }

            public final Builder setBaseAddrBytes(ByteString byteString) {
                copyOnWrite();
                AppInfo.access$21400((AppInfo) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            public final String getVer() {
                return ((AppInfo) this.instance).getVer();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            public final ByteString getVerBytes() {
                return ((AppInfo) this.instance).getVerBytes();
            }

            public final Builder setVer(String str) {
                copyOnWrite();
                AppInfo.access$21500((AppInfo) this.instance, str);
                return this;
            }

            public final Builder clearVer() {
                copyOnWrite();
                AppInfo.access$21600((AppInfo) this.instance);
                return this;
            }

            public final Builder setVerBytes(ByteString byteString) {
                copyOnWrite();
                AppInfo.access$21700((AppInfo) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            public final int getValueMapCount() {
                return ((AppInfo) this.instance).getValueMapMap().size();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            public final boolean containsValueMap(String str) {
                str.getClass();
                return ((AppInfo) this.instance).getValueMapMap().containsKey(str);
            }

            public final Builder clearValueMap() {
                copyOnWrite();
                ((AppInfo) this.instance).getMutableValueMapMap().clear();
                return this;
            }

            public final Builder removeValueMap(String str) {
                str.getClass();
                copyOnWrite();
                ((AppInfo) this.instance).getMutableValueMapMap().remove(str);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            @Deprecated
            public final Map<String, String> getValueMap() {
                return getValueMapMap();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            public final Map<String, String> getValueMapMap() {
                return Collections.unmodifiableMap(((AppInfo) this.instance).getValueMapMap());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            public final String getValueMapOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> valueMapMap = ((AppInfo) this.instance).getValueMapMap();
                return valueMapMap.containsKey(str) ? valueMapMap.get(str) : str2;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AppInfoOrBuilder
            public final String getValueMapOrThrow(String str) {
                str.getClass();
                Map<String, String> valueMapMap = ((AppInfo) this.instance).getValueMapMap();
                if (!valueMapMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return valueMapMap.get(str);
            }

            public final Builder putValueMap(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((AppInfo) this.instance).getMutableValueMapMap().put(str, str2);
                return this;
            }

            public final Builder putAllValueMap(Map<String, String> map) {
                copyOnWrite();
                ((AppInfo) this.instance).getMutableValueMapMap().putAll(map);
                return this;
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new AppInfo();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ\u00062", new Object[]{"name_", "arch_", "uUID_", "baseAddr_", "ver_", "valueMap_", a.f6560a});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<AppInfo> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (AppInfo.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            AppInfo appInfo = new AppInfo();
            DEFAULT_INSTANCE = appInfo;
            GeneratedMessageLite.registerDefaultInstance(AppInfo.class, appInfo);
        }

        public static AppInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AppInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Attachment extends GeneratedMessageLite<Attachment, Builder> implements AttachmentOrBuilder {
        public static final int DATA_FIELD_NUMBER = 3;
        private static final Attachment DEFAULT_INSTANCE;
        public static final int FILENAME_FIELD_NUMBER = 2;
        private static volatile Parser<Attachment> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        private String fileName_ = "";
        private ByteString data_ = ByteString.f6635a;

        static /* synthetic */ void access$22300(Attachment attachment, String str) {
            str.getClass();
            attachment.fileName_ = str;
        }

        static /* synthetic */ void access$22400(Attachment attachment) {
            attachment.fileName_ = getDefaultInstance().getFileName();
        }

        static /* synthetic */ void access$22500(Attachment attachment, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            attachment.fileName_ = byteString.f();
        }

        static /* synthetic */ void access$22600(Attachment attachment, ByteString byteString) {
            byteString.getClass();
            attachment.data_ = byteString;
        }

        static /* synthetic */ void access$22700(Attachment attachment) {
            attachment.data_ = getDefaultInstance().getData();
        }

        private Attachment() {
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AttachmentOrBuilder
        public final int getType() {
            return this.type_;
        }

        private void setType(int i) {
            this.type_ = i;
        }

        private void clearType() {
            this.type_ = 0;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AttachmentOrBuilder
        public final String getFileName() {
            return this.fileName_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AttachmentOrBuilder
        public final ByteString getFileNameBytes() {
            return ByteString.a(this.fileName_);
        }

        private void setFileName(String str) {
            str.getClass();
            this.fileName_ = str;
        }

        private void clearFileName() {
            this.fileName_ = getDefaultInstance().getFileName();
        }

        private void setFileNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.fileName_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AttachmentOrBuilder
        public final ByteString getData() {
            return this.data_;
        }

        private void setData(ByteString byteString) {
            byteString.getClass();
            this.data_ = byteString;
        }

        private void clearData() {
            this.data_ = getDefaultInstance().getData();
        }

        public static Attachment parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Attachment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Attachment parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Attachment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Attachment parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Attachment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Attachment parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Attachment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Attachment parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Attachment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Attachment parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Attachment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Attachment parseFrom(InputStream inputStream) throws IOException {
            return (Attachment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Attachment parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Attachment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Attachment parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Attachment) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Attachment parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Attachment) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Attachment parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Attachment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Attachment parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Attachment) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Attachment attachment) {
            return DEFAULT_INSTANCE.createBuilder(attachment);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Attachment, Builder> implements AttachmentOrBuilder {
            private Builder() {
                super(Attachment.DEFAULT_INSTANCE);
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AttachmentOrBuilder
            public final int getType() {
                return ((Attachment) this.instance).getType();
            }

            public final Builder setType(int i) {
                copyOnWrite();
                ((Attachment) this.instance).type_ = i;
                return this;
            }

            public final Builder clearType() {
                copyOnWrite();
                ((Attachment) this.instance).type_ = 0;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AttachmentOrBuilder
            public final String getFileName() {
                return ((Attachment) this.instance).getFileName();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AttachmentOrBuilder
            public final ByteString getFileNameBytes() {
                return ((Attachment) this.instance).getFileNameBytes();
            }

            public final Builder setFileName(String str) {
                copyOnWrite();
                Attachment.access$22300((Attachment) this.instance, str);
                return this;
            }

            public final Builder clearFileName() {
                copyOnWrite();
                Attachment.access$22400((Attachment) this.instance);
                return this;
            }

            public final Builder setFileNameBytes(ByteString byteString) {
                copyOnWrite();
                Attachment.access$22500((Attachment) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.AttachmentOrBuilder
            public final ByteString getData() {
                return ((Attachment) this.instance).getData();
            }

            public final Builder setData(ByteString byteString) {
                copyOnWrite();
                Attachment.access$22600((Attachment) this.instance, byteString);
                return this;
            }

            public final Builder clearData() {
                copyOnWrite();
                Attachment.access$22700((Attachment) this.instance);
                return this;
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new Attachment();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002Ȉ\u0003\n", new Object[]{"type_", "fileName_", "data_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<Attachment> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (Attachment.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Attachment attachment = new Attachment();
            DEFAULT_INSTANCE = attachment;
            GeneratedMessageLite.registerDefaultInstance(Attachment.class, attachment);
        }

        public static Attachment getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Attachment> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes3.dex */
    public static final class ExceptionUpload extends GeneratedMessageLite<ExceptionUpload, Builder> implements ExceptionUploadOrBuilder {
        public static final int ALLSTACKS_FIELD_NUMBER = 8;
        public static final int APPINFO_FIELD_NUMBER = 14;
        public static final int ATTACHES_FIELD_NUMBER = 17;
        public static final int CALLSTACK_FIELD_NUMBER = 7;
        public static final int COLDSTART_FIELD_NUMBER = 21;
        public static final int CRASHCOUNT_FIELD_NUMBER = 11;
        public static final int CRASHTHREAD_FIELD_NUMBER = 6;
        public static final int CRASHTIME_FIELD_NUMBER = 2;
        private static final ExceptionUpload DEFAULT_INSTANCE;
        public static final int DEVICEID_FIELD_NUMBER = 13;
        public static final int EXPADDR_FIELD_NUMBER = 5;
        public static final int EXPMESSAGE_FIELD_NUMBER = 4;
        public static final int EXPNAME_FIELD_NUMBER = 3;
        public static final int EXPUID_FIELD_NUMBER = 9;
        public static final int GATEWAYIP_FIELD_NUMBER = 20;
        public static final int LIBINFOS_FIELD_NUMBER = 15;
        private static volatile Parser<ExceptionUpload> PARSER = null;
        public static final int PLUGINS_FIELD_NUMBER = 16;
        public static final int SESSION_FIELD_NUMBER = 10;
        public static final int TYPE_FIELD_NUMBER = 1;
        public static final int USERID_FIELD_NUMBER = 12;
        public static final int USERMAP_FIELD_NUMBER = 19;
        public static final int VALUEMAP_FIELD_NUMBER = 18;
        private AppInfo appInfo_;
        private boolean coldStart_;
        private int crashCount_;
        private long crashTime_;
        private AppSession session_;
        private MapFieldLite<String, String> allStacks_ = MapFieldLite.a();
        private MapFieldLite<String, String> valueMap_ = MapFieldLite.a();
        private MapFieldLite<String, String> userMap_ = MapFieldLite.a();
        private String type_ = "";
        private String expName_ = "";
        private String expMessage_ = "";
        private String expAddr_ = "";
        private String crashThread_ = "";
        private String callStack_ = "";
        private String expuid_ = "";
        private String userid_ = "";
        private String deviceId_ = "";
        private Internal.ProtobufList<AppInfo> libInfos_ = emptyProtobufList();
        private Internal.ProtobufList<AppInfo> plugins_ = emptyProtobufList();
        private Internal.ProtobufList<Attachment> attaches_ = emptyProtobufList();
        private String gatewayIp_ = "";

        /* loaded from: classes3.dex */
        static final class a {

            /* renamed from: a, reason: collision with root package name */
            static final MapEntryLite<String, String> f6561a = MapEntryLite.a(WireFormat.FieldType.i, "", WireFormat.FieldType.i, "");
        }

        /* loaded from: classes3.dex */
        static final class b {

            /* renamed from: a, reason: collision with root package name */
            static final MapEntryLite<String, String> f6562a = MapEntryLite.a(WireFormat.FieldType.i, "", WireFormat.FieldType.i, "");
        }

        /* loaded from: classes3.dex */
        static final class c {

            /* renamed from: a, reason: collision with root package name */
            static final MapEntryLite<String, String> f6563a = MapEntryLite.a(WireFormat.FieldType.i, "", WireFormat.FieldType.i, "");
        }

        static /* synthetic */ void access$23000(ExceptionUpload exceptionUpload, String str) {
            str.getClass();
            exceptionUpload.type_ = str;
        }

        static /* synthetic */ void access$23100(ExceptionUpload exceptionUpload) {
            exceptionUpload.type_ = getDefaultInstance().getType();
        }

        static /* synthetic */ void access$23200(ExceptionUpload exceptionUpload, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            exceptionUpload.type_ = byteString.f();
        }

        static /* synthetic */ void access$23500(ExceptionUpload exceptionUpload, String str) {
            str.getClass();
            exceptionUpload.expName_ = str;
        }

        static /* synthetic */ void access$23600(ExceptionUpload exceptionUpload) {
            exceptionUpload.expName_ = getDefaultInstance().getExpName();
        }

        static /* synthetic */ void access$23700(ExceptionUpload exceptionUpload, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            exceptionUpload.expName_ = byteString.f();
        }

        static /* synthetic */ void access$23800(ExceptionUpload exceptionUpload, String str) {
            str.getClass();
            exceptionUpload.expMessage_ = str;
        }

        static /* synthetic */ void access$23900(ExceptionUpload exceptionUpload) {
            exceptionUpload.expMessage_ = getDefaultInstance().getExpMessage();
        }

        static /* synthetic */ void access$24000(ExceptionUpload exceptionUpload, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            exceptionUpload.expMessage_ = byteString.f();
        }

        static /* synthetic */ void access$24100(ExceptionUpload exceptionUpload, String str) {
            str.getClass();
            exceptionUpload.expAddr_ = str;
        }

        static /* synthetic */ void access$24200(ExceptionUpload exceptionUpload) {
            exceptionUpload.expAddr_ = getDefaultInstance().getExpAddr();
        }

        static /* synthetic */ void access$24300(ExceptionUpload exceptionUpload, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            exceptionUpload.expAddr_ = byteString.f();
        }

        static /* synthetic */ void access$24400(ExceptionUpload exceptionUpload, String str) {
            str.getClass();
            exceptionUpload.crashThread_ = str;
        }

        static /* synthetic */ void access$24500(ExceptionUpload exceptionUpload) {
            exceptionUpload.crashThread_ = getDefaultInstance().getCrashThread();
        }

        static /* synthetic */ void access$24600(ExceptionUpload exceptionUpload, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            exceptionUpload.crashThread_ = byteString.f();
        }

        static /* synthetic */ void access$24700(ExceptionUpload exceptionUpload, String str) {
            str.getClass();
            exceptionUpload.callStack_ = str;
        }

        static /* synthetic */ void access$24800(ExceptionUpload exceptionUpload) {
            exceptionUpload.callStack_ = getDefaultInstance().getCallStack();
        }

        static /* synthetic */ void access$24900(ExceptionUpload exceptionUpload, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            exceptionUpload.callStack_ = byteString.f();
        }

        static /* synthetic */ void access$25100(ExceptionUpload exceptionUpload, String str) {
            str.getClass();
            exceptionUpload.expuid_ = str;
        }

        static /* synthetic */ void access$25200(ExceptionUpload exceptionUpload) {
            exceptionUpload.expuid_ = getDefaultInstance().getExpuid();
        }

        static /* synthetic */ void access$25300(ExceptionUpload exceptionUpload, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            exceptionUpload.expuid_ = byteString.f();
        }

        static /* synthetic */ void access$25400(ExceptionUpload exceptionUpload, AppSession appSession) {
            appSession.getClass();
            exceptionUpload.session_ = appSession;
        }

        static /* synthetic */ void access$25900(ExceptionUpload exceptionUpload, String str) {
            str.getClass();
            exceptionUpload.userid_ = str;
        }

        static /* synthetic */ void access$26000(ExceptionUpload exceptionUpload) {
            exceptionUpload.userid_ = getDefaultInstance().getUserid();
        }

        static /* synthetic */ void access$26100(ExceptionUpload exceptionUpload, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            exceptionUpload.userid_ = byteString.f();
        }

        static /* synthetic */ void access$26200(ExceptionUpload exceptionUpload, String str) {
            str.getClass();
            exceptionUpload.deviceId_ = str;
        }

        static /* synthetic */ void access$26300(ExceptionUpload exceptionUpload) {
            exceptionUpload.deviceId_ = getDefaultInstance().getDeviceId();
        }

        static /* synthetic */ void access$26400(ExceptionUpload exceptionUpload, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            exceptionUpload.deviceId_ = byteString.f();
        }

        static /* synthetic */ void access$26500(ExceptionUpload exceptionUpload, AppInfo appInfo) {
            appInfo.getClass();
            exceptionUpload.appInfo_ = appInfo;
        }

        static /* synthetic */ void access$27200(ExceptionUpload exceptionUpload) {
            exceptionUpload.libInfos_ = emptyProtobufList();
        }

        static /* synthetic */ void access$27800(ExceptionUpload exceptionUpload) {
            exceptionUpload.plugins_ = emptyProtobufList();
        }

        static /* synthetic */ void access$28400(ExceptionUpload exceptionUpload) {
            exceptionUpload.attaches_ = emptyProtobufList();
        }

        static /* synthetic */ void access$28800(ExceptionUpload exceptionUpload, String str) {
            str.getClass();
            exceptionUpload.gatewayIp_ = str;
        }

        static /* synthetic */ void access$28900(ExceptionUpload exceptionUpload) {
            exceptionUpload.gatewayIp_ = getDefaultInstance().getGatewayIp();
        }

        static /* synthetic */ void access$29000(ExceptionUpload exceptionUpload, ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            exceptionUpload.gatewayIp_ = byteString.f();
        }

        private ExceptionUpload() {
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getType() {
            return this.type_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final ByteString getTypeBytes() {
            return ByteString.a(this.type_);
        }

        private void setType(String str) {
            str.getClass();
            this.type_ = str;
        }

        private void clearType() {
            this.type_ = getDefaultInstance().getType();
        }

        private void setTypeBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.type_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final long getCrashTime() {
            return this.crashTime_;
        }

        private void setCrashTime(long j) {
            this.crashTime_ = j;
        }

        private void clearCrashTime() {
            this.crashTime_ = 0L;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getExpName() {
            return this.expName_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final ByteString getExpNameBytes() {
            return ByteString.a(this.expName_);
        }

        private void setExpName(String str) {
            str.getClass();
            this.expName_ = str;
        }

        private void clearExpName() {
            this.expName_ = getDefaultInstance().getExpName();
        }

        private void setExpNameBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.expName_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getExpMessage() {
            return this.expMessage_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final ByteString getExpMessageBytes() {
            return ByteString.a(this.expMessage_);
        }

        private void setExpMessage(String str) {
            str.getClass();
            this.expMessage_ = str;
        }

        private void clearExpMessage() {
            this.expMessage_ = getDefaultInstance().getExpMessage();
        }

        private void setExpMessageBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.expMessage_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getExpAddr() {
            return this.expAddr_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final ByteString getExpAddrBytes() {
            return ByteString.a(this.expAddr_);
        }

        private void setExpAddr(String str) {
            str.getClass();
            this.expAddr_ = str;
        }

        private void clearExpAddr() {
            this.expAddr_ = getDefaultInstance().getExpAddr();
        }

        private void setExpAddrBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.expAddr_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getCrashThread() {
            return this.crashThread_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final ByteString getCrashThreadBytes() {
            return ByteString.a(this.crashThread_);
        }

        private void setCrashThread(String str) {
            str.getClass();
            this.crashThread_ = str;
        }

        private void clearCrashThread() {
            this.crashThread_ = getDefaultInstance().getCrashThread();
        }

        private void setCrashThreadBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.crashThread_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getCallStack() {
            return this.callStack_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final ByteString getCallStackBytes() {
            return ByteString.a(this.callStack_);
        }

        private void setCallStack(String str) {
            str.getClass();
            this.callStack_ = str;
        }

        private void clearCallStack() {
            this.callStack_ = getDefaultInstance().getCallStack();
        }

        private void setCallStackBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.callStack_ = byteString.f();
        }

        private MapFieldLite<String, String> internalGetAllStacks() {
            return this.allStacks_;
        }

        private MapFieldLite<String, String> internalGetMutableAllStacks() {
            if (!this.allStacks_.d()) {
                this.allStacks_ = this.allStacks_.b();
            }
            return this.allStacks_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final int getAllStacksCount() {
            return internalGetAllStacks().size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final boolean containsAllStacks(String str) {
            str.getClass();
            return internalGetAllStacks().containsKey(str);
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        @Deprecated
        public final Map<String, String> getAllStacks() {
            return getAllStacksMap();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final Map<String, String> getAllStacksMap() {
            return Collections.unmodifiableMap(internalGetAllStacks());
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getAllStacksOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> internalGetAllStacks = internalGetAllStacks();
            return internalGetAllStacks.containsKey(str) ? internalGetAllStacks.get(str) : str2;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getAllStacksOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> internalGetAllStacks = internalGetAllStacks();
            if (!internalGetAllStacks.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return internalGetAllStacks.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableAllStacksMap() {
            return internalGetMutableAllStacks();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getExpuid() {
            return this.expuid_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final ByteString getExpuidBytes() {
            return ByteString.a(this.expuid_);
        }

        private void setExpuid(String str) {
            str.getClass();
            this.expuid_ = str;
        }

        private void clearExpuid() {
            this.expuid_ = getDefaultInstance().getExpuid();
        }

        private void setExpuidBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.expuid_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final boolean hasSession() {
            return this.session_ != null;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final AppSession getSession() {
            AppSession appSession = this.session_;
            return appSession == null ? AppSession.getDefaultInstance() : appSession;
        }

        private void setSession(AppSession appSession) {
            appSession.getClass();
            this.session_ = appSession;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeSession(AppSession appSession) {
            appSession.getClass();
            AppSession appSession2 = this.session_;
            if (appSession2 != null && appSession2 != AppSession.getDefaultInstance()) {
                this.session_ = AppSession.newBuilder(this.session_).mergeFrom((AppSession.Builder) appSession).h();
            } else {
                this.session_ = appSession;
            }
        }

        private void clearSession() {
            this.session_ = null;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final int getCrashCount() {
            return this.crashCount_;
        }

        private void setCrashCount(int i) {
            this.crashCount_ = i;
        }

        private void clearCrashCount() {
            this.crashCount_ = 0;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getUserid() {
            return this.userid_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final ByteString getUseridBytes() {
            return ByteString.a(this.userid_);
        }

        private void setUserid(String str) {
            str.getClass();
            this.userid_ = str;
        }

        private void clearUserid() {
            this.userid_ = getDefaultInstance().getUserid();
        }

        private void setUseridBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.userid_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getDeviceId() {
            return this.deviceId_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final ByteString getDeviceIdBytes() {
            return ByteString.a(this.deviceId_);
        }

        private void setDeviceId(String str) {
            str.getClass();
            this.deviceId_ = str;
        }

        private void clearDeviceId() {
            this.deviceId_ = getDefaultInstance().getDeviceId();
        }

        private void setDeviceIdBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.deviceId_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final boolean hasAppInfo() {
            return this.appInfo_ != null;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final AppInfo getAppInfo() {
            AppInfo appInfo = this.appInfo_;
            return appInfo == null ? AppInfo.getDefaultInstance() : appInfo;
        }

        private void setAppInfo(AppInfo appInfo) {
            appInfo.getClass();
            this.appInfo_ = appInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAppInfo(AppInfo appInfo) {
            appInfo.getClass();
            AppInfo appInfo2 = this.appInfo_;
            if (appInfo2 != null && appInfo2 != AppInfo.getDefaultInstance()) {
                this.appInfo_ = AppInfo.newBuilder(this.appInfo_).mergeFrom((AppInfo.Builder) appInfo).h();
            } else {
                this.appInfo_ = appInfo;
            }
        }

        private void clearAppInfo() {
            this.appInfo_ = null;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final List<AppInfo> getLibInfosList() {
            return this.libInfos_;
        }

        public final List<? extends AppInfoOrBuilder> getLibInfosOrBuilderList() {
            return this.libInfos_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final int getLibInfosCount() {
            return this.libInfos_.size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final AppInfo getLibInfos(int i) {
            return this.libInfos_.get(i);
        }

        public final AppInfoOrBuilder getLibInfosOrBuilder(int i) {
            return this.libInfos_.get(i);
        }

        private void ensureLibInfosIsMutable() {
            Internal.ProtobufList<AppInfo> protobufList = this.libInfos_;
            if (protobufList.a()) {
                return;
            }
            this.libInfos_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLibInfos(int i, AppInfo appInfo) {
            appInfo.getClass();
            Internal.ProtobufList<AppInfo> protobufList = this.libInfos_;
            if (!protobufList.a()) {
                this.libInfos_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.libInfos_.set(i, appInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLibInfos(AppInfo appInfo) {
            appInfo.getClass();
            Internal.ProtobufList<AppInfo> protobufList = this.libInfos_;
            if (!protobufList.a()) {
                this.libInfos_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.libInfos_.add(appInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addLibInfos(int i, AppInfo appInfo) {
            appInfo.getClass();
            Internal.ProtobufList<AppInfo> protobufList = this.libInfos_;
            if (!protobufList.a()) {
                this.libInfos_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.libInfos_.add(i, appInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllLibInfos(Iterable<? extends AppInfo> iterable) {
            Internal.ProtobufList<AppInfo> protobufList = this.libInfos_;
            if (!protobufList.a()) {
                this.libInfos_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.libInfos_);
        }

        private void clearLibInfos() {
            this.libInfos_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeLibInfos(int i) {
            Internal.ProtobufList<AppInfo> protobufList = this.libInfos_;
            if (!protobufList.a()) {
                this.libInfos_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.libInfos_.remove(i);
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final List<AppInfo> getPluginsList() {
            return this.plugins_;
        }

        public final List<? extends AppInfoOrBuilder> getPluginsOrBuilderList() {
            return this.plugins_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final int getPluginsCount() {
            return this.plugins_.size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final AppInfo getPlugins(int i) {
            return this.plugins_.get(i);
        }

        public final AppInfoOrBuilder getPluginsOrBuilder(int i) {
            return this.plugins_.get(i);
        }

        private void ensurePluginsIsMutable() {
            Internal.ProtobufList<AppInfo> protobufList = this.plugins_;
            if (protobufList.a()) {
                return;
            }
            this.plugins_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPlugins(int i, AppInfo appInfo) {
            appInfo.getClass();
            Internal.ProtobufList<AppInfo> protobufList = this.plugins_;
            if (!protobufList.a()) {
                this.plugins_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.plugins_.set(i, appInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPlugins(AppInfo appInfo) {
            appInfo.getClass();
            Internal.ProtobufList<AppInfo> protobufList = this.plugins_;
            if (!protobufList.a()) {
                this.plugins_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.plugins_.add(appInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPlugins(int i, AppInfo appInfo) {
            appInfo.getClass();
            Internal.ProtobufList<AppInfo> protobufList = this.plugins_;
            if (!protobufList.a()) {
                this.plugins_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.plugins_.add(i, appInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllPlugins(Iterable<? extends AppInfo> iterable) {
            Internal.ProtobufList<AppInfo> protobufList = this.plugins_;
            if (!protobufList.a()) {
                this.plugins_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.plugins_);
        }

        private void clearPlugins() {
            this.plugins_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removePlugins(int i) {
            Internal.ProtobufList<AppInfo> protobufList = this.plugins_;
            if (!protobufList.a()) {
                this.plugins_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.plugins_.remove(i);
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final List<Attachment> getAttachesList() {
            return this.attaches_;
        }

        public final List<? extends AttachmentOrBuilder> getAttachesOrBuilderList() {
            return this.attaches_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final int getAttachesCount() {
            return this.attaches_.size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final Attachment getAttaches(int i) {
            return this.attaches_.get(i);
        }

        public final AttachmentOrBuilder getAttachesOrBuilder(int i) {
            return this.attaches_.get(i);
        }

        private void ensureAttachesIsMutable() {
            Internal.ProtobufList<Attachment> protobufList = this.attaches_;
            if (protobufList.a()) {
                return;
            }
            this.attaches_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAttaches(int i, Attachment attachment) {
            attachment.getClass();
            Internal.ProtobufList<Attachment> protobufList = this.attaches_;
            if (!protobufList.a()) {
                this.attaches_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.attaches_.set(i, attachment);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAttaches(Attachment attachment) {
            attachment.getClass();
            Internal.ProtobufList<Attachment> protobufList = this.attaches_;
            if (!protobufList.a()) {
                this.attaches_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.attaches_.add(attachment);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAttaches(int i, Attachment attachment) {
            attachment.getClass();
            Internal.ProtobufList<Attachment> protobufList = this.attaches_;
            if (!protobufList.a()) {
                this.attaches_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.attaches_.add(i, attachment);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllAttaches(Iterable<? extends Attachment> iterable) {
            Internal.ProtobufList<Attachment> protobufList = this.attaches_;
            if (!protobufList.a()) {
                this.attaches_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.attaches_);
        }

        private void clearAttaches() {
            this.attaches_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeAttaches(int i) {
            Internal.ProtobufList<Attachment> protobufList = this.attaches_;
            if (!protobufList.a()) {
                this.attaches_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.attaches_.remove(i);
        }

        private MapFieldLite<String, String> internalGetValueMap() {
            return this.valueMap_;
        }

        private MapFieldLite<String, String> internalGetMutableValueMap() {
            if (!this.valueMap_.d()) {
                this.valueMap_ = this.valueMap_.b();
            }
            return this.valueMap_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final int getValueMapCount() {
            return internalGetValueMap().size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final boolean containsValueMap(String str) {
            str.getClass();
            return internalGetValueMap().containsKey(str);
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        @Deprecated
        public final Map<String, String> getValueMap() {
            return getValueMapMap();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final Map<String, String> getValueMapMap() {
            return Collections.unmodifiableMap(internalGetValueMap());
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getValueMapOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> internalGetValueMap = internalGetValueMap();
            return internalGetValueMap.containsKey(str) ? internalGetValueMap.get(str) : str2;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getValueMapOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> internalGetValueMap = internalGetValueMap();
            if (!internalGetValueMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return internalGetValueMap.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableValueMapMap() {
            return internalGetMutableValueMap();
        }

        private MapFieldLite<String, String> internalGetUserMap() {
            return this.userMap_;
        }

        private MapFieldLite<String, String> internalGetMutableUserMap() {
            if (!this.userMap_.d()) {
                this.userMap_ = this.userMap_.b();
            }
            return this.userMap_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final int getUserMapCount() {
            return internalGetUserMap().size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final boolean containsUserMap(String str) {
            str.getClass();
            return internalGetUserMap().containsKey(str);
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        @Deprecated
        public final Map<String, String> getUserMap() {
            return getUserMapMap();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final Map<String, String> getUserMapMap() {
            return Collections.unmodifiableMap(internalGetUserMap());
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getUserMapOrDefault(String str, String str2) {
            str.getClass();
            MapFieldLite<String, String> internalGetUserMap = internalGetUserMap();
            return internalGetUserMap.containsKey(str) ? internalGetUserMap.get(str) : str2;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getUserMapOrThrow(String str) {
            str.getClass();
            MapFieldLite<String, String> internalGetUserMap = internalGetUserMap();
            if (!internalGetUserMap.containsKey(str)) {
                throw new IllegalArgumentException();
            }
            return internalGetUserMap.get(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> getMutableUserMapMap() {
            return internalGetMutableUserMap();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final String getGatewayIp() {
            return this.gatewayIp_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final ByteString getGatewayIpBytes() {
            return ByteString.a(this.gatewayIp_);
        }

        private void setGatewayIp(String str) {
            str.getClass();
            this.gatewayIp_ = str;
        }

        private void clearGatewayIp() {
            this.gatewayIp_ = getDefaultInstance().getGatewayIp();
        }

        private void setGatewayIpBytes(ByteString byteString) {
            checkByteStringIsUtf8(byteString);
            this.gatewayIp_ = byteString.f();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
        public final boolean getColdStart() {
            return this.coldStart_;
        }

        private void setColdStart(boolean z) {
            this.coldStart_ = z;
        }

        private void clearColdStart() {
            this.coldStart_ = false;
        }

        public static ExceptionUpload parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ExceptionUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ExceptionUpload parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExceptionUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ExceptionUpload parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ExceptionUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ExceptionUpload parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExceptionUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExceptionUpload parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ExceptionUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ExceptionUpload parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExceptionUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ExceptionUpload parseFrom(InputStream inputStream) throws IOException {
            return (ExceptionUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExceptionUpload parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExceptionUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExceptionUpload parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ExceptionUpload) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExceptionUpload parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExceptionUpload) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExceptionUpload parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ExceptionUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExceptionUpload parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExceptionUpload) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ExceptionUpload exceptionUpload) {
            return DEFAULT_INSTANCE.createBuilder(exceptionUpload);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ExceptionUpload, Builder> implements ExceptionUploadOrBuilder {
            private Builder() {
                super(ExceptionUpload.DEFAULT_INSTANCE);
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getType() {
                return ((ExceptionUpload) this.instance).getType();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final ByteString getTypeBytes() {
                return ((ExceptionUpload) this.instance).getTypeBytes();
            }

            public final Builder setType(String str) {
                copyOnWrite();
                ExceptionUpload.access$23000((ExceptionUpload) this.instance, str);
                return this;
            }

            public final Builder clearType() {
                copyOnWrite();
                ExceptionUpload.access$23100((ExceptionUpload) this.instance);
                return this;
            }

            public final Builder setTypeBytes(ByteString byteString) {
                copyOnWrite();
                ExceptionUpload.access$23200((ExceptionUpload) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final long getCrashTime() {
                return ((ExceptionUpload) this.instance).getCrashTime();
            }

            public final Builder setCrashTime(long j) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).crashTime_ = j;
                return this;
            }

            public final Builder clearCrashTime() {
                copyOnWrite();
                ((ExceptionUpload) this.instance).crashTime_ = 0L;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getExpName() {
                return ((ExceptionUpload) this.instance).getExpName();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final ByteString getExpNameBytes() {
                return ((ExceptionUpload) this.instance).getExpNameBytes();
            }

            public final Builder setExpName(String str) {
                copyOnWrite();
                ExceptionUpload.access$23500((ExceptionUpload) this.instance, str);
                return this;
            }

            public final Builder clearExpName() {
                copyOnWrite();
                ExceptionUpload.access$23600((ExceptionUpload) this.instance);
                return this;
            }

            public final Builder setExpNameBytes(ByteString byteString) {
                copyOnWrite();
                ExceptionUpload.access$23700((ExceptionUpload) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getExpMessage() {
                return ((ExceptionUpload) this.instance).getExpMessage();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final ByteString getExpMessageBytes() {
                return ((ExceptionUpload) this.instance).getExpMessageBytes();
            }

            public final Builder setExpMessage(String str) {
                copyOnWrite();
                ExceptionUpload.access$23800((ExceptionUpload) this.instance, str);
                return this;
            }

            public final Builder clearExpMessage() {
                copyOnWrite();
                ExceptionUpload.access$23900((ExceptionUpload) this.instance);
                return this;
            }

            public final Builder setExpMessageBytes(ByteString byteString) {
                copyOnWrite();
                ExceptionUpload.access$24000((ExceptionUpload) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getExpAddr() {
                return ((ExceptionUpload) this.instance).getExpAddr();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final ByteString getExpAddrBytes() {
                return ((ExceptionUpload) this.instance).getExpAddrBytes();
            }

            public final Builder setExpAddr(String str) {
                copyOnWrite();
                ExceptionUpload.access$24100((ExceptionUpload) this.instance, str);
                return this;
            }

            public final Builder clearExpAddr() {
                copyOnWrite();
                ExceptionUpload.access$24200((ExceptionUpload) this.instance);
                return this;
            }

            public final Builder setExpAddrBytes(ByteString byteString) {
                copyOnWrite();
                ExceptionUpload.access$24300((ExceptionUpload) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getCrashThread() {
                return ((ExceptionUpload) this.instance).getCrashThread();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final ByteString getCrashThreadBytes() {
                return ((ExceptionUpload) this.instance).getCrashThreadBytes();
            }

            public final Builder setCrashThread(String str) {
                copyOnWrite();
                ExceptionUpload.access$24400((ExceptionUpload) this.instance, str);
                return this;
            }

            public final Builder clearCrashThread() {
                copyOnWrite();
                ExceptionUpload.access$24500((ExceptionUpload) this.instance);
                return this;
            }

            public final Builder setCrashThreadBytes(ByteString byteString) {
                copyOnWrite();
                ExceptionUpload.access$24600((ExceptionUpload) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getCallStack() {
                return ((ExceptionUpload) this.instance).getCallStack();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final ByteString getCallStackBytes() {
                return ((ExceptionUpload) this.instance).getCallStackBytes();
            }

            public final Builder setCallStack(String str) {
                copyOnWrite();
                ExceptionUpload.access$24700((ExceptionUpload) this.instance, str);
                return this;
            }

            public final Builder clearCallStack() {
                copyOnWrite();
                ExceptionUpload.access$24800((ExceptionUpload) this.instance);
                return this;
            }

            public final Builder setCallStackBytes(ByteString byteString) {
                copyOnWrite();
                ExceptionUpload.access$24900((ExceptionUpload) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final int getAllStacksCount() {
                return ((ExceptionUpload) this.instance).getAllStacksMap().size();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final boolean containsAllStacks(String str) {
                str.getClass();
                return ((ExceptionUpload) this.instance).getAllStacksMap().containsKey(str);
            }

            public final Builder clearAllStacks() {
                copyOnWrite();
                ((ExceptionUpload) this.instance).getMutableAllStacksMap().clear();
                return this;
            }

            public final Builder removeAllStacks(String str) {
                str.getClass();
                copyOnWrite();
                ((ExceptionUpload) this.instance).getMutableAllStacksMap().remove(str);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            @Deprecated
            public final Map<String, String> getAllStacks() {
                return getAllStacksMap();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final Map<String, String> getAllStacksMap() {
                return Collections.unmodifiableMap(((ExceptionUpload) this.instance).getAllStacksMap());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getAllStacksOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> allStacksMap = ((ExceptionUpload) this.instance).getAllStacksMap();
                return allStacksMap.containsKey(str) ? allStacksMap.get(str) : str2;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getAllStacksOrThrow(String str) {
                str.getClass();
                Map<String, String> allStacksMap = ((ExceptionUpload) this.instance).getAllStacksMap();
                if (!allStacksMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return allStacksMap.get(str);
            }

            public final Builder putAllStacks(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((ExceptionUpload) this.instance).getMutableAllStacksMap().put(str, str2);
                return this;
            }

            public final Builder putAllAllStacks(Map<String, String> map) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).getMutableAllStacksMap().putAll(map);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getExpuid() {
                return ((ExceptionUpload) this.instance).getExpuid();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final ByteString getExpuidBytes() {
                return ((ExceptionUpload) this.instance).getExpuidBytes();
            }

            public final Builder setExpuid(String str) {
                copyOnWrite();
                ExceptionUpload.access$25100((ExceptionUpload) this.instance, str);
                return this;
            }

            public final Builder clearExpuid() {
                copyOnWrite();
                ExceptionUpload.access$25200((ExceptionUpload) this.instance);
                return this;
            }

            public final Builder setExpuidBytes(ByteString byteString) {
                copyOnWrite();
                ExceptionUpload.access$25300((ExceptionUpload) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final boolean hasSession() {
                return ((ExceptionUpload) this.instance).hasSession();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final AppSession getSession() {
                return ((ExceptionUpload) this.instance).getSession();
            }

            public final Builder setSession(AppSession appSession) {
                copyOnWrite();
                ExceptionUpload.access$25400((ExceptionUpload) this.instance, appSession);
                return this;
            }

            public final Builder setSession(AppSession.Builder builder) {
                copyOnWrite();
                ExceptionUpload.access$25400((ExceptionUpload) this.instance, builder.h());
                return this;
            }

            public final Builder mergeSession(AppSession appSession) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).mergeSession(appSession);
                return this;
            }

            public final Builder clearSession() {
                copyOnWrite();
                ((ExceptionUpload) this.instance).session_ = null;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final int getCrashCount() {
                return ((ExceptionUpload) this.instance).getCrashCount();
            }

            public final Builder setCrashCount(int i) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).crashCount_ = i;
                return this;
            }

            public final Builder clearCrashCount() {
                copyOnWrite();
                ((ExceptionUpload) this.instance).crashCount_ = 0;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getUserid() {
                return ((ExceptionUpload) this.instance).getUserid();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final ByteString getUseridBytes() {
                return ((ExceptionUpload) this.instance).getUseridBytes();
            }

            public final Builder setUserid(String str) {
                copyOnWrite();
                ExceptionUpload.access$25900((ExceptionUpload) this.instance, str);
                return this;
            }

            public final Builder clearUserid() {
                copyOnWrite();
                ExceptionUpload.access$26000((ExceptionUpload) this.instance);
                return this;
            }

            public final Builder setUseridBytes(ByteString byteString) {
                copyOnWrite();
                ExceptionUpload.access$26100((ExceptionUpload) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getDeviceId() {
                return ((ExceptionUpload) this.instance).getDeviceId();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final ByteString getDeviceIdBytes() {
                return ((ExceptionUpload) this.instance).getDeviceIdBytes();
            }

            public final Builder setDeviceId(String str) {
                copyOnWrite();
                ExceptionUpload.access$26200((ExceptionUpload) this.instance, str);
                return this;
            }

            public final Builder clearDeviceId() {
                copyOnWrite();
                ExceptionUpload.access$26300((ExceptionUpload) this.instance);
                return this;
            }

            public final Builder setDeviceIdBytes(ByteString byteString) {
                copyOnWrite();
                ExceptionUpload.access$26400((ExceptionUpload) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final boolean hasAppInfo() {
                return ((ExceptionUpload) this.instance).hasAppInfo();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final AppInfo getAppInfo() {
                return ((ExceptionUpload) this.instance).getAppInfo();
            }

            public final Builder setAppInfo(AppInfo appInfo) {
                copyOnWrite();
                ExceptionUpload.access$26500((ExceptionUpload) this.instance, appInfo);
                return this;
            }

            public final Builder setAppInfo(AppInfo.Builder builder) {
                copyOnWrite();
                ExceptionUpload.access$26500((ExceptionUpload) this.instance, builder.h());
                return this;
            }

            public final Builder mergeAppInfo(AppInfo appInfo) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).mergeAppInfo(appInfo);
                return this;
            }

            public final Builder clearAppInfo() {
                copyOnWrite();
                ((ExceptionUpload) this.instance).appInfo_ = null;
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final List<AppInfo> getLibInfosList() {
                return Collections.unmodifiableList(((ExceptionUpload) this.instance).getLibInfosList());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final int getLibInfosCount() {
                return ((ExceptionUpload) this.instance).getLibInfosCount();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final AppInfo getLibInfos(int i) {
                return ((ExceptionUpload) this.instance).getLibInfos(i);
            }

            public final Builder setLibInfos(int i, AppInfo appInfo) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).setLibInfos(i, appInfo);
                return this;
            }

            public final Builder setLibInfos(int i, AppInfo.Builder builder) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).setLibInfos(i, builder.h());
                return this;
            }

            public final Builder addLibInfos(AppInfo appInfo) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).addLibInfos(appInfo);
                return this;
            }

            public final Builder addLibInfos(int i, AppInfo appInfo) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).addLibInfos(i, appInfo);
                return this;
            }

            public final Builder addLibInfos(AppInfo.Builder builder) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).addLibInfos(builder.h());
                return this;
            }

            public final Builder addLibInfos(int i, AppInfo.Builder builder) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).addLibInfos(i, builder.h());
                return this;
            }

            public final Builder addAllLibInfos(Iterable<? extends AppInfo> iterable) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).addAllLibInfos(iterable);
                return this;
            }

            public final Builder clearLibInfos() {
                copyOnWrite();
                ExceptionUpload.access$27200((ExceptionUpload) this.instance);
                return this;
            }

            public final Builder removeLibInfos(int i) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).removeLibInfos(i);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final List<AppInfo> getPluginsList() {
                return Collections.unmodifiableList(((ExceptionUpload) this.instance).getPluginsList());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final int getPluginsCount() {
                return ((ExceptionUpload) this.instance).getPluginsCount();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final AppInfo getPlugins(int i) {
                return ((ExceptionUpload) this.instance).getPlugins(i);
            }

            public final Builder setPlugins(int i, AppInfo appInfo) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).setPlugins(i, appInfo);
                return this;
            }

            public final Builder setPlugins(int i, AppInfo.Builder builder) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).setPlugins(i, builder.h());
                return this;
            }

            public final Builder addPlugins(AppInfo appInfo) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).addPlugins(appInfo);
                return this;
            }

            public final Builder addPlugins(int i, AppInfo appInfo) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).addPlugins(i, appInfo);
                return this;
            }

            public final Builder addPlugins(AppInfo.Builder builder) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).addPlugins(builder.h());
                return this;
            }

            public final Builder addPlugins(int i, AppInfo.Builder builder) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).addPlugins(i, builder.h());
                return this;
            }

            public final Builder addAllPlugins(Iterable<? extends AppInfo> iterable) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).addAllPlugins(iterable);
                return this;
            }

            public final Builder clearPlugins() {
                copyOnWrite();
                ExceptionUpload.access$27800((ExceptionUpload) this.instance);
                return this;
            }

            public final Builder removePlugins(int i) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).removePlugins(i);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final List<Attachment> getAttachesList() {
                return Collections.unmodifiableList(((ExceptionUpload) this.instance).getAttachesList());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final int getAttachesCount() {
                return ((ExceptionUpload) this.instance).getAttachesCount();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final Attachment getAttaches(int i) {
                return ((ExceptionUpload) this.instance).getAttaches(i);
            }

            public final Builder setAttaches(int i, Attachment attachment) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).setAttaches(i, attachment);
                return this;
            }

            public final Builder setAttaches(int i, Attachment.Builder builder) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).setAttaches(i, builder.h());
                return this;
            }

            public final Builder addAttaches(Attachment attachment) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).addAttaches(attachment);
                return this;
            }

            public final Builder addAttaches(int i, Attachment attachment) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).addAttaches(i, attachment);
                return this;
            }

            public final Builder addAttaches(Attachment.Builder builder) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).addAttaches(builder.h());
                return this;
            }

            public final Builder addAttaches(int i, Attachment.Builder builder) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).addAttaches(i, builder.h());
                return this;
            }

            public final Builder addAllAttaches(Iterable<? extends Attachment> iterable) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).addAllAttaches(iterable);
                return this;
            }

            public final Builder clearAttaches() {
                copyOnWrite();
                ExceptionUpload.access$28400((ExceptionUpload) this.instance);
                return this;
            }

            public final Builder removeAttaches(int i) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).removeAttaches(i);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final int getValueMapCount() {
                return ((ExceptionUpload) this.instance).getValueMapMap().size();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final boolean containsValueMap(String str) {
                str.getClass();
                return ((ExceptionUpload) this.instance).getValueMapMap().containsKey(str);
            }

            public final Builder clearValueMap() {
                copyOnWrite();
                ((ExceptionUpload) this.instance).getMutableValueMapMap().clear();
                return this;
            }

            public final Builder removeValueMap(String str) {
                str.getClass();
                copyOnWrite();
                ((ExceptionUpload) this.instance).getMutableValueMapMap().remove(str);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            @Deprecated
            public final Map<String, String> getValueMap() {
                return getValueMapMap();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final Map<String, String> getValueMapMap() {
                return Collections.unmodifiableMap(((ExceptionUpload) this.instance).getValueMapMap());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getValueMapOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> valueMapMap = ((ExceptionUpload) this.instance).getValueMapMap();
                return valueMapMap.containsKey(str) ? valueMapMap.get(str) : str2;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getValueMapOrThrow(String str) {
                str.getClass();
                Map<String, String> valueMapMap = ((ExceptionUpload) this.instance).getValueMapMap();
                if (!valueMapMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return valueMapMap.get(str);
            }

            public final Builder putValueMap(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((ExceptionUpload) this.instance).getMutableValueMapMap().put(str, str2);
                return this;
            }

            public final Builder putAllValueMap(Map<String, String> map) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).getMutableValueMapMap().putAll(map);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final int getUserMapCount() {
                return ((ExceptionUpload) this.instance).getUserMapMap().size();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final boolean containsUserMap(String str) {
                str.getClass();
                return ((ExceptionUpload) this.instance).getUserMapMap().containsKey(str);
            }

            public final Builder clearUserMap() {
                copyOnWrite();
                ((ExceptionUpload) this.instance).getMutableUserMapMap().clear();
                return this;
            }

            public final Builder removeUserMap(String str) {
                str.getClass();
                copyOnWrite();
                ((ExceptionUpload) this.instance).getMutableUserMapMap().remove(str);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            @Deprecated
            public final Map<String, String> getUserMap() {
                return getUserMapMap();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final Map<String, String> getUserMapMap() {
                return Collections.unmodifiableMap(((ExceptionUpload) this.instance).getUserMapMap());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getUserMapOrDefault(String str, String str2) {
                str.getClass();
                Map<String, String> userMapMap = ((ExceptionUpload) this.instance).getUserMapMap();
                return userMapMap.containsKey(str) ? userMapMap.get(str) : str2;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getUserMapOrThrow(String str) {
                str.getClass();
                Map<String, String> userMapMap = ((ExceptionUpload) this.instance).getUserMapMap();
                if (!userMapMap.containsKey(str)) {
                    throw new IllegalArgumentException();
                }
                return userMapMap.get(str);
            }

            public final Builder putUserMap(String str, String str2) {
                str.getClass();
                str2.getClass();
                copyOnWrite();
                ((ExceptionUpload) this.instance).getMutableUserMapMap().put(str, str2);
                return this;
            }

            public final Builder putAllUserMap(Map<String, String> map) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).getMutableUserMapMap().putAll(map);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final String getGatewayIp() {
                return ((ExceptionUpload) this.instance).getGatewayIp();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final ByteString getGatewayIpBytes() {
                return ((ExceptionUpload) this.instance).getGatewayIpBytes();
            }

            public final Builder setGatewayIp(String str) {
                copyOnWrite();
                ExceptionUpload.access$28800((ExceptionUpload) this.instance, str);
                return this;
            }

            public final Builder clearGatewayIp() {
                copyOnWrite();
                ExceptionUpload.access$28900((ExceptionUpload) this.instance);
                return this;
            }

            public final Builder setGatewayIpBytes(ByteString byteString) {
                copyOnWrite();
                ExceptionUpload.access$29000((ExceptionUpload) this.instance, byteString);
                return this;
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadOrBuilder
            public final boolean getColdStart() {
                return ((ExceptionUpload) this.instance).getColdStart();
            }

            public final Builder setColdStart(boolean z) {
                copyOnWrite();
                ((ExceptionUpload) this.instance).coldStart_ = z;
                return this;
            }

            public final Builder clearColdStart() {
                copyOnWrite();
                ((ExceptionUpload) this.instance).coldStart_ = false;
                return this;
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new ExceptionUpload();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0015\u0000\u0000\u0001\u0015\u0015\u0003\u0003\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007Ȉ\b2\tȈ\n\t\u000b\u0004\fȈ\rȈ\u000e\t\u000f\u001b\u0010\u001b\u0011\u001b\u00122\u00132\u0014Ȉ\u0015\u0007", new Object[]{"type_", "crashTime_", "expName_", "expMessage_", "expAddr_", "crashThread_", "callStack_", "allStacks_", a.f6561a, "expuid_", "session_", "crashCount_", "userid_", "deviceId_", "appInfo_", "libInfos_", AppInfo.class, "plugins_", AppInfo.class, "attaches_", Attachment.class, "valueMap_", c.f6563a, "userMap_", b.f6562a, "gatewayIp_", "coldStart_"});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<ExceptionUpload> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (ExceptionUpload.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ExceptionUpload exceptionUpload = new ExceptionUpload();
            DEFAULT_INSTANCE = exceptionUpload;
            GeneratedMessageLite.registerDefaultInstance(ExceptionUpload.class, exceptionUpload);
        }

        public static ExceptionUpload getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ExceptionUpload> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* loaded from: classes3.dex */
    public static final class ExceptionUploadPackage extends GeneratedMessageLite<ExceptionUploadPackage, Builder> implements ExceptionUploadPackageOrBuilder {
        private static final ExceptionUploadPackage DEFAULT_INSTANCE;
        public static final int LIST_FIELD_NUMBER = 1;
        private static volatile Parser<ExceptionUploadPackage> PARSER;
        private Internal.ProtobufList<ExceptionUpload> list_ = emptyProtobufList();

        static /* synthetic */ void access$29900(ExceptionUploadPackage exceptionUploadPackage) {
            exceptionUploadPackage.list_ = emptyProtobufList();
        }

        private ExceptionUploadPackage() {
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadPackageOrBuilder
        public final List<ExceptionUpload> getListList() {
            return this.list_;
        }

        public final List<? extends ExceptionUploadOrBuilder> getListOrBuilderList() {
            return this.list_;
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadPackageOrBuilder
        public final int getListCount() {
            return this.list_.size();
        }

        @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadPackageOrBuilder
        public final ExceptionUpload getList(int i) {
            return this.list_.get(i);
        }

        public final ExceptionUploadOrBuilder getListOrBuilder(int i) {
            return this.list_.get(i);
        }

        private void ensureListIsMutable() {
            Internal.ProtobufList<ExceptionUpload> protobufList = this.list_;
            if (protobufList.a()) {
                return;
            }
            this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setList(int i, ExceptionUpload exceptionUpload) {
            exceptionUpload.getClass();
            Internal.ProtobufList<ExceptionUpload> protobufList = this.list_;
            if (!protobufList.a()) {
                this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.list_.set(i, exceptionUpload);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addList(ExceptionUpload exceptionUpload) {
            exceptionUpload.getClass();
            Internal.ProtobufList<ExceptionUpload> protobufList = this.list_;
            if (!protobufList.a()) {
                this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.list_.add(exceptionUpload);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addList(int i, ExceptionUpload exceptionUpload) {
            exceptionUpload.getClass();
            Internal.ProtobufList<ExceptionUpload> protobufList = this.list_;
            if (!protobufList.a()) {
                this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.list_.add(i, exceptionUpload);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllList(Iterable<? extends ExceptionUpload> iterable) {
            Internal.ProtobufList<ExceptionUpload> protobufList = this.list_;
            if (!protobufList.a()) {
                this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            AbstractMessageLite.addAll((Iterable) iterable, (List) this.list_);
        }

        private void clearList() {
            this.list_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeList(int i) {
            Internal.ProtobufList<ExceptionUpload> protobufList = this.list_;
            if (!protobufList.a()) {
                this.list_ = GeneratedMessageLite.mutableCopy(protobufList);
            }
            this.list_.remove(i);
        }

        public static ExceptionUploadPackage parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (ExceptionUploadPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        public static ExceptionUploadPackage parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExceptionUploadPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static ExceptionUploadPackage parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (ExceptionUploadPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static ExceptionUploadPackage parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExceptionUploadPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static ExceptionUploadPackage parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (ExceptionUploadPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static ExceptionUploadPackage parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (ExceptionUploadPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static ExceptionUploadPackage parseFrom(InputStream inputStream) throws IOException {
            return (ExceptionUploadPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExceptionUploadPackage parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExceptionUploadPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExceptionUploadPackage parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (ExceptionUploadPackage) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static ExceptionUploadPackage parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExceptionUploadPackage) parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static ExceptionUploadPackage parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (ExceptionUploadPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static ExceptionUploadPackage parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (ExceptionUploadPackage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ExceptionUploadPackage exceptionUploadPackage) {
            return DEFAULT_INSTANCE.createBuilder(exceptionUploadPackage);
        }

        /* loaded from: classes3.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<ExceptionUploadPackage, Builder> implements ExceptionUploadPackageOrBuilder {
            private Builder() {
                super(ExceptionUploadPackage.DEFAULT_INSTANCE);
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadPackageOrBuilder
            public final List<ExceptionUpload> getListList() {
                return Collections.unmodifiableList(((ExceptionUploadPackage) this.instance).getListList());
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadPackageOrBuilder
            public final int getListCount() {
                return ((ExceptionUploadPackage) this.instance).getListCount();
            }

            @Override // com.uqm.crashsight.crashreport.common.info.SightPkg.ExceptionUploadPackageOrBuilder
            public final ExceptionUpload getList(int i) {
                return ((ExceptionUploadPackage) this.instance).getList(i);
            }

            public final Builder setList(int i, ExceptionUpload exceptionUpload) {
                copyOnWrite();
                ((ExceptionUploadPackage) this.instance).setList(i, exceptionUpload);
                return this;
            }

            public final Builder setList(int i, ExceptionUpload.Builder builder) {
                copyOnWrite();
                ((ExceptionUploadPackage) this.instance).setList(i, builder.h());
                return this;
            }

            public final Builder addList(ExceptionUpload exceptionUpload) {
                copyOnWrite();
                ((ExceptionUploadPackage) this.instance).addList(exceptionUpload);
                return this;
            }

            public final Builder addList(int i, ExceptionUpload exceptionUpload) {
                copyOnWrite();
                ((ExceptionUploadPackage) this.instance).addList(i, exceptionUpload);
                return this;
            }

            public final Builder addList(ExceptionUpload.Builder builder) {
                copyOnWrite();
                ((ExceptionUploadPackage) this.instance).addList(builder.h());
                return this;
            }

            public final Builder addList(int i, ExceptionUpload.Builder builder) {
                copyOnWrite();
                ((ExceptionUploadPackage) this.instance).addList(i, builder.h());
                return this;
            }

            public final Builder addAllList(Iterable<? extends ExceptionUpload> iterable) {
                copyOnWrite();
                ((ExceptionUploadPackage) this.instance).addAllList(iterable);
                return this;
            }

            public final Builder clearList() {
                copyOnWrite();
                ExceptionUploadPackage.access$29900((ExceptionUploadPackage) this.instance);
                return this;
            }

            public final Builder removeList(int i) {
                copyOnWrite();
                ((ExceptionUploadPackage) this.instance).removeList(i);
                return this;
            }
        }

        @Override // com.uqm.crashsight.protobuf.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            Parser parser;
            switch (methodToInvoke) {
                case NEW_MUTABLE_INSTANCE:
                    return new ExceptionUploadPackage();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"list_", ExceptionUpload.class});
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<ExceptionUploadPackage> parser2 = PARSER;
                    if (parser2 != null) {
                        return parser2;
                    }
                    synchronized (ExceptionUploadPackage.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ExceptionUploadPackage exceptionUploadPackage = new ExceptionUploadPackage();
            DEFAULT_INSTANCE = exceptionUploadPackage;
            GeneratedMessageLite.registerDefaultInstance(ExceptionUploadPackage.class, exceptionUploadPackage);
        }

        public static ExceptionUploadPackage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ExceptionUploadPackage> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
