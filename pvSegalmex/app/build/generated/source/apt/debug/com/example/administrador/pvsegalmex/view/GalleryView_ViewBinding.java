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

public class GalleryView_ViewBinding implements Unbinder {
  private GalleryView target;

  @UiThread
  public GalleryView_ViewBinding(GalleryView target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GalleryView_ViewBinding(GalleryView target, View source) {
    this.target = target;

    target.imvBackCrud = Utils.findRequiredViewAsType(source, R.id.imvBackCrud, "field 'imvBackCrud'", ImageView.class);
    target.imvImageViewer = Utils.findRequiredViewAsType(source, R.id.imvImageViewer, "field 'imvImageViewer'", ImageView.class);
    target.btnAddImage = Utils.findRequiredViewAsType(source, R.id.btnAddImage, "field 'btnAddImage'", AppCompatButton.class);
    target.btnSave = Utils.findRequiredViewAsType(source, R.id.btnSave, "field 'btnSave'", FloatingActionButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GalleryView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imvBackCrud = null;
    target.imvImageViewer = null;
    target.btnAddImage = null;
    target.btnSave = null;
  }
}
