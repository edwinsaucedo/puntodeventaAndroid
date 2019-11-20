// Generated code from Butter Knife. Do not modify!
package com.example.administrador.pvsegalmex.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.administrador.pvsegalmex.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RvExistProductAdapter$RvExistProductHolder_ViewBinding implements Unbinder {
  private RvExistProductAdapter.RvExistProductHolder target;

  @UiThread
  public RvExistProductAdapter$RvExistProductHolder_ViewBinding(RvExistProductAdapter.RvExistProductHolder target,
      View source) {
    this.target = target;

    target.tvExist = Utils.findRequiredViewAsType(source, R.id.tvExist, "field 'tvExist'", TextView.class);
    target.tvProductExist = Utils.findRequiredViewAsType(source, R.id.tvProductExist, "field 'tvProductExist'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvExistProductAdapter.RvExistProductHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvExist = null;
    target.tvProductExist = null;
  }
}
