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

public class RvProductAdapter$RvProductHolder_ViewBinding implements Unbinder {
  private RvProductAdapter.RvProductHolder target;

  @UiThread
  public RvProductAdapter$RvProductHolder_ViewBinding(RvProductAdapter.RvProductHolder target,
      View source) {
    this.target = target;

    target.tvProductDescription = Utils.findRequiredViewAsType(source, R.id.tvProductDescription, "field 'tvProductDescription'", TextView.class);
    target.tvProductCode = Utils.findRequiredViewAsType(source, R.id.tvProductCode, "field 'tvProductCode'", TextView.class);
    target.tvProductCost = Utils.findRequiredViewAsType(source, R.id.tvProductCost, "field 'tvProductCost'", TextView.class);
    target.imvProduct = Utils.findRequiredViewAsType(source, R.id.imvProduct, "field 'imvProduct'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvProductAdapter.RvProductHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvProductDescription = null;
    target.tvProductCode = null;
    target.tvProductCost = null;
    target.imvProduct = null;
  }
}
