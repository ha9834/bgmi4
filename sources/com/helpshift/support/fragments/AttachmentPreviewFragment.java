package com.helpshift.support.fragments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.helpshift.R;
import com.helpshift.common.domain.AttachmentFileManagerDM;
import com.helpshift.common.exception.RootAPIException;
import com.helpshift.conversation.activeconversation.AttachmentPreviewRenderer;
import com.helpshift.conversation.dto.AttachmentPickerFile;
import com.helpshift.conversation.viewmodel.AttachmentPreviewVM;
import com.helpshift.support.contracts.AttachmentPreviewListener;
import com.helpshift.support.controllers.SupportController;
import com.helpshift.support.imageloader.ImageLoader;
import com.helpshift.support.storage.IMAppSessionStorage;
import com.helpshift.support.util.AppSessionConstants;
import com.helpshift.support.util.SnackbarUtil;
import com.helpshift.support.util.Styles;
import com.helpshift.util.AndroidFileUtil;
import com.helpshift.util.AttachmentFileSize;
import com.helpshift.util.HelpshiftContext;
import com.helpshift.util.StringUtils;

/* loaded from: classes2.dex */
public class AttachmentPreviewFragment extends MainFragment implements View.OnClickListener, AttachmentFileManagerDM.Listener, AttachmentPreviewRenderer {
    public static final String FRAGMENT_TAG = "AttachmentPreviewFragment";
    public static final String KEY_ATTACHMENT_MODE = "key_attachment_mode";
    public static final String KEY_ATTACHMENT_TYPE = "key_attachment_type";
    public static final String KEY_MESSAGE_REFERS_ID = "key_refers_id";
    private static final AppSessionConstants.Screen screenType = AppSessionConstants.Screen.SCREENSHOT_PREVIEW;
    private TextView attachmentFileNameView;
    private TextView attachmentFileSizeView;
    private TextView attachmentFileTypeView;
    private String attachmentMessageRefersId;
    AttachmentPickerFile attachmentPickerFile;
    private int attachmentPickerType;
    private AttachmentPreviewListener attachmentPreviewListener;
    private AttachmentPreviewVM attachmentPreviewVM;
    private View buttonsContainer;
    private View genericAttachmentPreview;
    LaunchSource launchSource;
    private int mode;
    ProgressBar progressBar;
    private ImageView screenshotPreview;
    private Button secondaryButton;

    /* loaded from: classes2.dex */
    public enum AttachmentAction {
        ADD,
        SEND,
        REMOVE,
        CHANGE
    }

    /* loaded from: classes2.dex */
    public enum LaunchSource {
        ATTACHMENT_DRAFT,
        GALLERY_APP
    }

    /* loaded from: classes2.dex */
    public static class Modes {
        public static final int ADD = 1;
        public static final int REMOVE = 2;
        public static final int SEND = 3;
    }

    @Override // com.helpshift.support.fragments.MainFragment
    public boolean shouldRefreshMenu() {
        return true;
    }

    public static AttachmentPreviewFragment newInstance(AttachmentPreviewListener attachmentPreviewListener) {
        AttachmentPreviewFragment attachmentPreviewFragment = new AttachmentPreviewFragment();
        attachmentPreviewFragment.attachmentPreviewListener = attachmentPreviewListener;
        return attachmentPreviewFragment;
    }

    private static void setSecondaryButtonTextAndDrawable(Button button, int i) {
        String string;
        Drawable drawable;
        Resources resources = button.getResources();
        switch (i) {
            case 1:
                string = resources.getString(R.string.hs__screenshot_add);
                drawable = null;
                break;
            case 2:
                string = resources.getString(R.string.hs__screenshot_remove);
                drawable = null;
                break;
            case 3:
                string = resources.getString(R.string.hs__send_msg_btn);
                drawable = getSendIconAsDrawable(button.getContext());
                break;
            default:
                string = "";
                drawable = null;
                break;
        }
        button.setText(string);
        if (drawable != null) {
            button.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    private static Drawable getSendIconAsDrawable(Context context) {
        Drawable mutate = context.getResources().getDrawable(Styles.getResourceIdForAttribute(context, R.attr.hs__messageSendIcon)).mutate();
        com.helpshift.util.Styles.setColorFilter(context, mutate, android.R.attr.textColorPrimaryInverse);
        return mutate;
    }

    public void setParams(Bundle bundle, AttachmentPickerFile attachmentPickerFile, LaunchSource launchSource) {
        this.mode = bundle.getInt(KEY_ATTACHMENT_MODE);
        this.attachmentMessageRefersId = bundle.getString(KEY_MESSAGE_REFERS_ID);
        this.attachmentPickerType = bundle.getInt(KEY_ATTACHMENT_TYPE);
        this.attachmentPickerFile = attachmentPickerFile;
        this.launchSource = launchSource;
        setAttachmentPreview();
    }

    public void setAttachmentPreviewListener(AttachmentPreviewListener attachmentPreviewListener) {
        this.attachmentPreviewListener = attachmentPreviewListener;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.hs__attachment_preview_fragment, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.attachmentPreviewVM = HelpshiftContext.getCoreApi().getAttachmentPreviewModel(this);
        this.screenshotPreview = (ImageView) view.findViewById(R.id.screenshot_preview);
        this.genericAttachmentPreview = view.findViewById(R.id.generic_attachment_preview);
        this.attachmentFileNameView = (TextView) view.findViewById(R.id.attachment_file_name);
        this.attachmentFileTypeView = (TextView) view.findViewById(R.id.attachment_file_type);
        this.attachmentFileSizeView = (TextView) view.findViewById(R.id.attachment_file_size);
        ((Button) view.findViewById(R.id.change)).setOnClickListener(this);
        this.secondaryButton = (Button) view.findViewById(R.id.secondary_button);
        this.secondaryButton.setOnClickListener(this);
        this.progressBar = (ProgressBar) view.findViewById(R.id.screenshot_loading_indicator);
        this.buttonsContainer = view.findViewById(R.id.button_containers);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setSecondaryButtonTextAndDrawable(this.secondaryButton, this.mode);
        setAttachmentPreview();
        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        setToolbarTitle(getString(R.string.hs__preview_header));
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.attachmentPreviewVM.unregisterRenderer();
        ImageLoader.getInstance().cancelAll();
        super.onDestroyView();
    }

    @Override // com.helpshift.support.fragments.MainFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        IMAppSessionStorage.getInstance().set(AppSessionConstants.CURRENT_OPEN_SCREEN, screenType);
    }

    @Override // com.helpshift.support.fragments.MainFragment, androidx.fragment.app.Fragment
    public void onPause() {
        SnackbarUtil.hideSnackbar(getView());
        super.onPause();
    }

    @Override // com.helpshift.support.fragments.MainFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        AppSessionConstants.Screen screen = (AppSessionConstants.Screen) IMAppSessionStorage.getInstance().get(AppSessionConstants.CURRENT_OPEN_SCREEN);
        if (screen == null || !screen.equals(screenType)) {
            return;
        }
        IMAppSessionStorage.getInstance().removeKey(AppSessionConstants.CURRENT_OPEN_SCREEN);
    }

    public void deleteAttachmentLocalCopy() {
        if (this.launchSource == LaunchSource.GALLERY_APP) {
            HelpshiftContext.getCoreApi().getAttachmentFileManagerDM().deleteAttachmentLocalCopy(this.attachmentPickerFile);
        }
    }

    private void setAttachmentPreview() {
        if (isResumed()) {
            AttachmentPickerFile attachmentPickerFile = this.attachmentPickerFile;
            if (attachmentPickerFile == null) {
                AttachmentPreviewListener attachmentPreviewListener = this.attachmentPreviewListener;
                if (attachmentPreviewListener != null) {
                    attachmentPreviewListener.removeAttachmentPreviewFragment();
                    return;
                }
                return;
            }
            if (attachmentPickerFile.filePath != null) {
                renderPreview(this.attachmentPickerFile.filePath);
            } else if (this.attachmentPickerFile.transientUri != null) {
                toggleProgressBarViewsVisibility(true);
                HelpshiftContext.getCoreApi().getAttachmentFileManagerDM().compressAndCopyAttachment(this.attachmentPickerFile, this);
            }
        }
    }

    void renderPreview(String str) {
        String str2;
        if (this.attachmentPickerFile.attachmentType == 1) {
            this.genericAttachmentPreview.setVisibility(8);
            this.screenshotPreview.setVisibility(0);
            ImageLoader.getInstance().loadImageWithoutSampling(str, this.screenshotPreview, getContext().getResources().getDrawable(R.drawable.hs__placeholder_image), -1);
            return;
        }
        this.genericAttachmentPreview.setVisibility(0);
        this.screenshotPreview.setVisibility(8);
        this.attachmentFileNameView.setText(this.attachmentPickerFile.originalFileName);
        String fileExtension = AndroidFileUtil.getFileExtension(this.attachmentPickerFile.originalFileName);
        if (StringUtils.isEmpty(fileExtension)) {
            str2 = "";
        } else {
            str2 = getString(R.string.hs__file_type, fileExtension.replace(".", "").toUpperCase());
        }
        this.attachmentFileTypeView.setText(str2);
        this.attachmentFileSizeView.setText(AttachmentFileSize.getFormattedFileSize(this.attachmentPickerFile.originalFileSize.longValue()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AttachmentPickerFile attachmentPickerFile;
        int id = view.getId();
        if (id == R.id.secondary_button && (attachmentPickerFile = this.attachmentPickerFile) != null) {
            switch (this.mode) {
                case 1:
                    this.attachmentPreviewListener.addAttachment(attachmentPickerFile);
                    return;
                case 2:
                    HelpshiftContext.getCoreApi().getAttachmentFileManagerDM().deleteAttachmentLocalCopy(this.attachmentPickerFile);
                    this.attachmentPreviewListener.removeAttachment();
                    return;
                case 3:
                    this.attachmentPreviewListener.sendAttachment(attachmentPickerFile, this.attachmentMessageRefersId);
                    return;
                default:
                    return;
            }
        }
        if (id == R.id.change) {
            if (this.mode == 2) {
                this.mode = 1;
            }
            HelpshiftContext.getCoreApi().getAttachmentFileManagerDM().deleteAttachmentLocalCopy(this.attachmentPickerFile);
            this.attachmentPickerFile = null;
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_ATTACHMENT_MODE, this.mode);
            bundle.putString(KEY_MESSAGE_REFERS_ID, this.attachmentMessageRefersId);
            bundle.putInt(KEY_ATTACHMENT_TYPE, this.attachmentPickerType);
            this.attachmentPreviewListener.changeAttachment(bundle);
        }
    }

    @Override // com.helpshift.common.domain.AttachmentFileManagerDM.Listener
    public void onCompressAndCopyFailure(RootAPIException rootAPIException) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() { // from class: com.helpshift.support.fragments.AttachmentPreviewFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    AttachmentPreviewFragment.this.progressBar.setVisibility(8);
                    SnackbarUtil.showSnackbar(AttachmentPreviewFragment.this.getView(), R.string.hs__screenshot_cloud_attach_error, -2);
                }
            });
        }
    }

    @Override // com.helpshift.common.domain.AttachmentFileManagerDM.Listener
    public void onCompressAndCopySuccess(final AttachmentPickerFile attachmentPickerFile) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() { // from class: com.helpshift.support.fragments.AttachmentPreviewFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    AttachmentPreviewFragment.this.toggleProgressBarViewsVisibility(false);
                    AttachmentPreviewFragment.this.renderPreview(attachmentPickerFile.filePath);
                }
            });
        }
    }

    void toggleProgressBarViewsVisibility(boolean z) {
        if (z) {
            this.progressBar.setVisibility(0);
            this.buttonsContainer.setVisibility(8);
            this.screenshotPreview.setVisibility(8);
            this.genericAttachmentPreview.setVisibility(8);
            return;
        }
        this.progressBar.setVisibility(8);
        this.buttonsContainer.setVisibility(0);
        if (this.attachmentPickerFile.attachmentType == 1) {
            this.screenshotPreview.setVisibility(0);
        } else {
            this.genericAttachmentPreview.setVisibility(0);
        }
    }

    @Override // com.helpshift.conversation.activeconversation.AttachmentPreviewRenderer
    public void onAuthenticationFailure() {
        SupportController supportController = ((SupportFragment) getParentFragment()).getSupportController();
        if (supportController != null) {
            supportController.onAuthenticationFailure();
        }
    }
}
