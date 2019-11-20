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

public class RvClientAdapter$RvClientHolder_ViewBinding implements Unbinder {
  private RvClientAdapter.RvClientHolder target;

  @UiThread
  public RvClientAdapter$RvClientHolder_ViewBinding(RvClientAdapter.RvClientHolder target,
      View source) {
    this.target = target;

    target.imgClient = Utils.findRequiredViewAsType(source, R.id.imvClient, "field 'imgClient'", ImageView.class);
    target.tvClientName = Utils.findRequiredViewAsType(source, R.id.tvClientName, "field 'tvClientName'", TextView.class);
    target.tvClientCurp = Utils.findRequiredViewAsType(source, R.id.tvClientCurp, "field 'tvClientCurp'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvClientAdapter.RvClientHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgClient = null;
    target.tvClientName = null;
    target.tvClientCurp = null;
  }
}
