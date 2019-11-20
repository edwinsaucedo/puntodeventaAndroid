// Generated code from Butter Knife. Do not modify!
package com.example.administrador.pvsegalmex.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.administrador.pvsegalmex.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GridWayPaySales$GridWayPaySalesHolder_ViewBinding implements Unbinder {
  private GridWayPaySales.GridWayPaySalesHolder target;

  @UiThread
  public GridWayPaySales$GridWayPaySalesHolder_ViewBinding(GridWayPaySales.GridWayPaySalesHolder target,
      View source) {
    this.target = target;

    target.imvImageWayPaySales = Utils.findRequiredViewAsType(source, R.id.imvImageWayPaySales, "field 'imvImageWayPaySales'", ImageView.class);
    target.tvWayPayDescriptionSales = Utils.findRequiredViewAsType(source, R.id.tvWayPayDescriptionSales, "field 'tvWayPayDescriptionSales'", TextView.class);
    target.itemWayPay = Utils.findRequiredViewAsType(source, R.id.itemWayPay, "field 'itemWayPay'", CardView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GridWayPaySales.GridWayPaySalesHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imvImageWayPaySales = null;
    target.tvWayPayDescriptionSales = null;
    target.itemWayPay = null;
  }
}
