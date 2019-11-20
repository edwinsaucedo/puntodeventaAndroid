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

public class IncompleteSaleAdapter$IncompleteSaleHolder_ViewBinding implements Unbinder {
  private IncompleteSaleAdapter.IncompleteSaleHolder target;

  @UiThread
  public IncompleteSaleAdapter$IncompleteSaleHolder_ViewBinding(IncompleteSaleAdapter.IncompleteSaleHolder target,
      View source) {
    this.target = target;

    target.tvNoSale = Utils.findRequiredViewAsType(source, R.id.tvNoSale, "field 'tvNoSale'", TextView.class);
    target.tvDateSaleDialog = Utils.findRequiredViewAsType(source, R.id.tvDateSaleDialog, "field 'tvDateSaleDialog'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    IncompleteSaleAdapter.IncompleteSaleHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvNoSale = null;
    target.tvDateSaleDialog = null;
  }
}
