// Generated by view binder compiler. Do not edit!
package net.appitiza.lib.customalert.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import net.appitiza.lib.customalert.R;

public final class FragmentAlertDialogBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView btnCancel;

  @NonNull
  public final TextView btnOkay;

  @NonNull
  public final ImageView ivLogo;

  @NonNull
  public final TextView tvAlertContent;

  @NonNull
  public final TextView tvAlertHeading;

  private FragmentAlertDialogBinding(@NonNull LinearLayout rootView, @NonNull TextView btnCancel,
      @NonNull TextView btnOkay, @NonNull ImageView ivLogo, @NonNull TextView tvAlertContent,
      @NonNull TextView tvAlertHeading) {
    this.rootView = rootView;
    this.btnCancel = btnCancel;
    this.btnOkay = btnOkay;
    this.ivLogo = ivLogo;
    this.tvAlertContent = tvAlertContent;
    this.tvAlertHeading = tvAlertHeading;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAlertDialogBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAlertDialogBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_alert_dialog, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAlertDialogBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnCancel;
      TextView btnCancel = ViewBindings.findChildViewById(rootView, id);
      if (btnCancel == null) {
        break missingId;
      }

      id = R.id.btnOkay;
      TextView btnOkay = ViewBindings.findChildViewById(rootView, id);
      if (btnOkay == null) {
        break missingId;
      }

      id = R.id.ivLogo;
      ImageView ivLogo = ViewBindings.findChildViewById(rootView, id);
      if (ivLogo == null) {
        break missingId;
      }

      id = R.id.tvAlertContent;
      TextView tvAlertContent = ViewBindings.findChildViewById(rootView, id);
      if (tvAlertContent == null) {
        break missingId;
      }

      id = R.id.tvAlertHeading;
      TextView tvAlertHeading = ViewBindings.findChildViewById(rootView, id);
      if (tvAlertHeading == null) {
        break missingId;
      }

      return new FragmentAlertDialogBinding((LinearLayout) rootView, btnCancel, btnOkay, ivLogo,
          tvAlertContent, tvAlertHeading);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
