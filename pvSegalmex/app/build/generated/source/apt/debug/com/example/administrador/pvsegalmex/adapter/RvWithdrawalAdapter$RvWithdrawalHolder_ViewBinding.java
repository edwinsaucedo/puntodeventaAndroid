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

public class RvWithdrawalAdapter$RvWithdrawalHolder_ViewBinding implements Unbinder {
  private RvWithdrawalAdapter.RvWithdrawalHolder target;

  @UiThread
  public RvWithdrawalAdapter$RvWithdrawalHolder_ViewBinding(RvWithdrawalAdapter.RvWithdrawalHolder target,
      View source) {
    this.target = target;

    target.tvAmountWildrawal = Utils.findRequiredViewAsType(source, R.id.tvAmountWildrawal, "field 'tvAmountWildrawal'", TextView.class);
    target.tvDateWithdrawal = Utils.findRequiredViewAsType(source, R.id.tvDateWithdrawal, "field 'tvDateWithdrawal'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvWithdrawalAdapter.RvWithdrawalHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvAmountWildrawal = null;
    target.tvDateWithdrawal = null;
  }
}
