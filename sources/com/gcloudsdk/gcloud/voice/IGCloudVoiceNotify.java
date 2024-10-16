package com.gcloudsdk.gcloud.voice;

/* loaded from: classes.dex */
public interface IGCloudVoiceNotify {
    void OnApplyMessageKey(int i);

    void OnDownloadFile(int i, String str, String str2);

    void OnEnableMagicVoice(int i, String str, boolean z);

    void OnEnableRecvMagicVoice(int i, boolean z);

    void OnEnableTranslate(int i, String str, int i2);

    void OnEvent(int i, String str);

    void OnJoinRoom(int i, String str, int i2);

    void OnMagicVoiceMsg(int i, String str);

    void OnMemberVoice(String str, int i, int i2);

    void OnMemberVoice(int[] iArr, int i);

    void OnPlayRecordedFile(int i, String str);

    void OnQuitRoom(int i, String str);

    void OnRSTS(int i, int i2, int i3, String str, String str2, String str3, int i4);

    void OnRSTSSpeechToSpeech(int i, int i2, int i3, String str, String str2, String str3, int i4);

    void OnRSTSSpeechToText(int i, int i2, int i3, String str, String str2, int i4);

    void OnRealTimeTranslateText(String str, int i, String str2, int i2, String str3);

    void OnRecording(char[] cArr, int i);

    void OnReportPlayer(int i, String str);

    void OnRoleChanged(int i, String str, int i2, int i3);

    void OnSTTReport(int i, String str, String str2, String str3);

    void OnSpeechFileToText(int i, String str, String str2, int i2);

    void OnSpeechFileTranslate(int i, String str, String str2, String str3, int i2);

    void OnSpeechToText(int i, String str, String str2);

    void OnSpeechTranslate(int i, String str, String str2, String str3, int i2);

    void OnStatusUpdate(int i, String str, int i2);

    void OnStreamSpeechToText(int i, int i2, String str, String str2);

    void OnTextToSpeech(int i, String str, int i2, String str2);

    void OnTextToSpeechFile(int i, String str, int i2, String str2);

    void OnTextToStreamSpeech(int i, String str, int i2);

    void OnTextTranslate(int i, int i2, String str, int i3, String str2);

    void OnUploadFile(int i, String str, String str2);
}
