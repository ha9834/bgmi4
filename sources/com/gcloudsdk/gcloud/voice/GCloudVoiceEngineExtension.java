package com.gcloudsdk.gcloud.voice;

/* loaded from: classes.dex */
public class GCloudVoiceEngineExtension {
    private static GCloudVoiceEngineHelper JNIHelper;

    /* JADX INFO: Access modifiers changed from: protected */
    public GCloudVoiceEngineExtension() {
        JNIHelper = new GCloudVoiceEngineHelper();
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        GCloudVoiceEngineHelper.EngineJniInstance();
    }

    public int JoinTeamRoom_Scenes(String str, String str2, int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.JoinTeamRoomByScenes(str, str2, i);
    }

    public int JoinRangeRoom_Scenes(String str, String str2, int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.JoinRangeRoomByScenes(str, str2, i);
    }

    public int JoinNationalRoom_Scenes(String str, String str2, int i, int i2) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.JoinNationalRoomByScenes(str, str2, i, i2);
    }

    public int QuitRoom_Scenes(String str, int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.QuitRoomByScenes(str, i);
    }

    public int EnableMultiRoom(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.EnableMultiRoom(z);
    }

    public int EnableRoomMicrophone(String str, boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.EnableRoomMicrophone(str, z);
    }

    public int EnableRoomSpeaker(String str, boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.EnableRoomSpeaker(str, z);
    }

    public int SetBGMPath(String str) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SetBGMPath(str);
    }

    public int EnableNativeBGMPlay(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.EnableNativeBGMPlay(z);
    }

    public int StartBGMPlay() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.StartBGMPlay();
    }

    public int SetBGMVol(int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SetBGMVol(i);
    }

    public int PauseBGMPlay() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.PauseBGMPlay();
    }

    public int ResumeBGMPlay() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.ResumeBGMPlay();
    }

    public int GetBGMPlayState() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.GetBGMPlayState();
    }

    public int StopBGMPlay() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.StopBGMPlay();
    }

    public int JoinTeamRoom_Token(String str, String str2, int i, int i2) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.JoinTeamRoom(str, str2, i, i2);
    }

    public int JoinNationalRoom_Token(String str, int i, String str2, int i2, int i3) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.JoinNationalRoom(str, i, str2, i2, i3);
    }

    public int ApplyMessageKey_Token(String str, int i, int i2) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.ApplyMessageKey(str, i, i2);
    }

    public int SpeechToText_Token(String str, String str2, int i, int i2, int i3) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SpeechToText(str, str2, i, i2, i3);
    }

    public int EnableSpeakerOn(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.EnableSpeakerOn(z);
    }

    public int SetMicVolume(int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SetMicVolume(i);
    }

    public int SetSpeakerVolume(int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SetSpeakerVolume(i);
    }

    public int GetMicLevel() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.GetMicLevel();
    }

    public int GetSpeakerLevel() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.GetSpeakerLevel();
    }

    public int GetMicState() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.GetMicState();
    }

    public int GetSpeakerState() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.GetSpeakerState();
    }

    public int TestMic() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.TestMic();
    }

    public int IsSpeaking() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.IsSpeaking();
    }

    public void EnableBluetoothSCO(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        GCloudVoiceEngineHelper.EnableBluetoothSCO(z);
    }

    public int GetMuteResult() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.GetMuteResult();
    }

    public int SetVoiceEffects(int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SetVoiceEffects(i);
    }

    public int SetServerInfo(String str) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SetServerInfo(str);
    }

    public int SetBitRate(int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SetBitRate(i);
    }

    public int SetDataFree(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SetDataFree(z);
    }

    public int EnableLog(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.EnableLog(z);
    }

    public int SetAudience(int[] iArr, String str) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SetAudience(iArr, iArr.length, str);
    }

    public int ForbidMemberVoice(int i, boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.ForbidMemberVoice(i, z, "");
    }

    public int ForbidMemberVoice(int i, boolean z, String str) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.ForbidMemberVoice(i, z, str);
    }

    public int UploadRecordedFile(String str, int i, boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.UploadRecordedFile(str, i, z);
    }

    public int DownloadRecordedFile(String str, String str2, int i, boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.DownloadRecordedFile(str, str2, i, z);
    }

    public int GetFileParam(String str, Integer num, Float f) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.GetFileParam(str, num, f);
    }

    public int SpeechTranslate(String str, int i, int i2, int i3, int i4) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SpeechTranslate(str, i, i2, i3, i4);
    }

    public int SpeechFileTranslate(String str, int i, int i2, int i3, float f, float f2, int i4) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SpeechFileTranslate(str, i, i2, i3, f, f2, i4);
    }

    public int SpeechFileToText(String str, int i, int i2, int i3) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SpeechFileToText(str, i, i2, i3);
    }

    public int TextToSpeech(String str, int i, int i2, int i3) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.TextToSpeech(str, i, i2, i3);
    }

    public int TextToSpeechFile(String str, int i, String str2, int i2, float f, float f2, int i3) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.TextToSpeechFile(str, i, str2, i2, f, f2, i3);
    }

    public int TextTranslate(String str, int i, int i2, int i3) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.TextTranslate(str, i, i2, i3);
    }

    public int RSTSStartRecording(int i, int[] iArr, int i2, int i3, int i4) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.RSTSStartRecording(i, iArr, i2, i3, i4);
    }

    public int RSTSSpeechToSpeech(int i, int[] iArr, int i2, String str, int i3, float f, float f2, int i4) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.RSTSSpeechToSpeech(i, iArr, i2, str, i3, f, f2, i4);
    }

    public int RSTSSpeechToText(int i, int[] iArr, int i2, int i3) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.RSTSSpeechToText(i, iArr, i2, i3);
    }

    public int RSTSStopRecording() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.RSTSStopRecording();
    }

    public int Invoke(int i, int i2, int i3, int[] iArr) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.Invoke(i, i2, i3, iArr);
    }

    public int SetCivilBinPath(String str) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SetCivilBinPath(str);
    }

    public int EnableCivilVoice(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.EnableCivilVoice(z);
    }

    public int EnableKeyWordsDetect(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.EnableKeyWordsDetect(z);
    }

    public int EnableTranslate(String str, boolean z, int i, int i2) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.EnableTranslate(str, z, i, i2);
    }

    public int EnableMagicVoice(String str, boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.EnableMagicVoice(str, z);
    }

    public int EnableRecvMagicVoice(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.EnableRecvMagicVoice(z);
    }

    public int TextToStreamSpeechStart(String str, String str2, int i, String str3) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.TextToStreamSpeechStart(str, str2, i, str3);
    }

    public int TextToStreamSpeechStop() {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.TextToStreamSpeechStop();
    }

    public int RoomGeneralDataChannel(String str, String str2) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.RoomGeneralDataChannel(str, str2);
    }

    public int APITrace(String str, String str2) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.APITrace(str, str2);
    }

    public int SetPlayerInfoAbroad(String[] strArr, int[] iArr, int[] iArr2, int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SetPlayerInfoAbroad(strArr, iArr, iArr2, i);
    }

    public int SetMagicVoiceMsgType(String str) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.SetMagicVoiceMsgType(str);
    }

    public int EnableReportALL(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.EnableReportALL(z);
    }

    public int EnableReportALLAbroad(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.EnableReportALLAbroad(z);
    }

    public int EnableReportForAbroad(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.EnableReportForAbroad(z);
    }

    public int ReportFileForAbroad(String str, boolean z, boolean z2, int i) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.ReportFileForAbroad(str, z, z2, i);
    }

    public int EnableCivilFile(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.EnableCivilFile(z);
    }

    public int AuditionFileForMagicType(String str, String str2) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.AuditionFileForMagicType(str, str2);
    }

    public int IsSaveMagicFile(boolean z) {
        GCloudVoiceEngineHelper gCloudVoiceEngineHelper = JNIHelper;
        return GCloudVoiceEngineHelper.IsSaveMagicFile(z);
    }
}
