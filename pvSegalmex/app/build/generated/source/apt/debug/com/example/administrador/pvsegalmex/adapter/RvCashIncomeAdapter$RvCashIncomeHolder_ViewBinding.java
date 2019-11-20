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

public class RvCashIncomeAdapter$RvCashIncomeHolder_ViewBinding implements Unbinder {
  private RvCashIncomeAdapter.RvCashIncomeHolder target;

  @UiThread
  public RvCashIncomeAdapter$RvCashIncomeHolder_ViewBinding(RvCashIncomeAdapter.RvCashIncomeHolder target,
      View source) {
    this.target = target;

    target.tvAmountIncome = Utils.findRequiredViewAsType(source, R.id.tvAmountIncome, "field 'tvAmountIncome'", TextView.class);
    target.tvDateIncome = Utils.findRequiredViewAsType(source, R.id.tvDateIncome, "field 'tvDateIncome'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvCashIncomeAdapter.RvCashIncomeHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvAmountIncome = null;
    target.tvDateIncome = null;
  }
}
