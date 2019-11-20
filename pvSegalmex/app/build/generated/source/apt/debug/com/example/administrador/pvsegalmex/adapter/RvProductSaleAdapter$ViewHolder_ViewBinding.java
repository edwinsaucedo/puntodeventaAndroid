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

public class RvProductSaleAdapter$ViewHolder_ViewBinding implements Unbinder {
  private RvProductSaleAdapter.ViewHolder target;

  @UiThread
  public RvProductSaleAdapter$ViewHolder_ViewBinding(RvProductSaleAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.tvProductSaleQuantity = Utils.findRequiredViewAsType(source, R.id.tvProductSaleCant, "field 'tvProductSaleQuantity'", TextView.class);
    target.tvProductSaleDescription = Utils.findRequiredViewAsType(source, R.id.tvbtvProductSaleDesc, "field 'tvProductSaleDescription'", TextView.class);
    target.tvProductSaleCost = Utils.findRequiredViewAsType(source, R.id.tvProductSaleCost, "field 'tvProductSaleCost'", TextView.class);
    target.tvProductSaleCostQuantity = Utils.findRequiredViewAsType(source, R.id.tvProductSaleCostQuantity, "field 'tvProductSaleCostQuantity'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvProductSaleAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvProductSaleQuantity = null;
    target.tvProductSaleDescription = null;
    target.tvProductSaleCost = null;
    target.tvProductSaleCostQuantity = null;
  }
}
