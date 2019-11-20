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

public class RvDetailSaleAdapter$RvDetailSaleHolder_ViewBinding implements Unbinder {
  private RvDetailSaleAdapter.RvDetailSaleHolder target;

  @UiThread
  public RvDetailSaleAdapter$RvDetailSaleHolder_ViewBinding(RvDetailSaleAdapter.RvDetailSaleHolder target,
      View source) {
    this.target = target;

    target.tvProductDetailSaleCant = Utils.findRequiredViewAsType(source, R.id.tvProductDetailSaleCant, "field 'tvProductDetailSaleCant'", TextView.class);
    target.tvProductDetailSaleName = Utils.findRequiredViewAsType(source, R.id.tvProductDetailSaleName, "field 'tvProductDetailSaleName'", TextView.class);
    target.tvProductDetailSaleCost = Utils.findRequiredViewAsType(source, R.id.tvProductDetailSaleCost, "field 'tvProductDetailSaleCost'", TextView.class);
    target.tvProductDetailSaleCostQuantity = Utils.findRequiredViewAsType(source, R.id.tvProductDetailSaleCostQuantity, "field 'tvProductDetailSaleCostQuantity'", TextView.class);
    target.tvProductDetailUtility = Utils.findRequiredViewAsType(source, R.id.tvProductDetailUtility, "field 'tvProductDetailUtility'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvDetailSaleAdapter.RvDetailSaleHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvProductDetailSaleCant = null;
    target.tvProductDetailSaleName = null;
    target.tvProductDetailSaleCost = null;
    target.tvProductDetailSaleCostQuantity = null;
    target.tvProductDetailUtility = null;
  }
}
