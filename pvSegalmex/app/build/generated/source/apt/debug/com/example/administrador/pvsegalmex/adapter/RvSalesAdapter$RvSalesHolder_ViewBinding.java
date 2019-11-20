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

public class RvSalesAdapter$RvSalesHolder_ViewBinding implements Unbinder {
  private RvSalesAdapter.RvSalesHolder target;

  @UiThread
  public RvSalesAdapter$RvSalesHolder_ViewBinding(RvSalesAdapter.RvSalesHolder target,
      View source) {
    this.target = target;

    target.tvDateSale = Utils.findRequiredViewAsType(source, R.id.tvDateSale, "field 'tvDateSale'", TextView.class);
    target.tvTotalSale = Utils.findRequiredViewAsType(source, R.id.tvTotalSale, "field 'tvTotalSale'", TextView.class);
    target.tvClienteSaleView = Utils.findRequiredViewAsType(source, R.id.tvClienteSaleView, "field 'tvClienteSaleView'", TextView.class);
    target.tvWayPaySale = Utils.findRequiredViewAsType(source, R.id.tvWayPaySale, "field 'tvWayPaySale'", TextView.class);
    target.tvUtility = Utils.findRequiredViewAsType(source, R.id.tvUtility, "field 'tvUtility'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvSalesAdapter.RvSalesHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvDateSale = null;
    target.tvTotalSale = null;
    target.tvClienteSaleView = null;
    target.tvWayPaySale = null;
    target.tvUtility = null;
  }
}
