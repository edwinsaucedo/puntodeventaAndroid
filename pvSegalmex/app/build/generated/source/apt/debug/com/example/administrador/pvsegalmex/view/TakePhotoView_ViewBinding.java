// Generated code from Butter Knife. Do not modify!
package com.example.administrador.pvsegalmex.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.administrador.pvsegalmex.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TakePhotoView_ViewBinding implements Unbinder {
  private TakePhotoView target;

  @UiThread
  public TakePhotoView_ViewBinding(TakePhotoView target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TakePhotoView_ViewBinding(TakePhotoView target, View source) {
    this.target = target;

    target.imvBack = Utils.findRequiredViewAsType(source, R.id.imvBack, "field 'imvBack'", ImageView.class);
    target.imvPhotoViewer = Utils.findRequiredViewAsType(source, R.id.imvPhotoViewer, "field 'imvPhotoViewer'", ImageView.class);
    target.btnTakePhoto = Utils.findRequiredViewAsType(source, R.id.btnTakePhoto, "field 'btnTakePhoto'", AppCompatButton.class);
    target.btnDone = Utils.findRequiredViewAsType(source, R.id.btnDone, "field 'btnDone'", FloatingActionButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TakePhotoView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imvBack = null;
    target.imvPhotoViewer = null;
    target.btnTakePhoto = null;
    target.btnDone = null;
  }
}
