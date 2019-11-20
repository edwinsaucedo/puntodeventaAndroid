// Generated code from Butter Knife. Do not modify!
package com.example.administrador.pvsegalmex.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.administrador.pvsegalmex.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RvWayPayAdapter$RvWayPayHolder_ViewBinding implements Unbinder {
  private RvWayPayAdapter.RvWayPayHolder target;

  @UiThread
  public RvWayPayAdapter$RvWayPayHolder_ViewBinding(RvWayPayAdapter.RvWayPayHolder target,
      View source) {
    this.target = target;

    target.imgWayPay = Utils.findRequiredViewAsType(source, R.id.imvWayPay, "field 'imgWayPay'", ImageView.class);
    target.tvWayPayDescription = Utils.findRequiredViewAsType(source, R.id.tvWayPayDescription, "field 'tvWayPayDescription'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvWayPayAdapter.RvWayPayHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgWayPay = null;
    target.tvWayPayDescription = null;
  }
}
