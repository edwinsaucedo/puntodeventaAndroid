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

public class RvShowCashShortWayPay$RvShowCashShortWayPayHolder_ViewBinding implements Unbinder {
  private RvShowCashShortWayPay.RvShowCashShortWayPayHolder target;

  @UiThread
  public RvShowCashShortWayPay$RvShowCashShortWayPayHolder_ViewBinding(RvShowCashShortWayPay.RvShowCashShortWayPayHolder target,
      View source) {
    this.target = target;

    target.tvWayPayDescriptionCashShort = Utils.findRequiredViewAsType(source, R.id.tvWayPayDescriptionCashShort, "field 'tvWayPayDescriptionCashShort'", TextView.class);
    target.tvWayPayAmountCapCashShort = Utils.findRequiredViewAsType(source, R.id.tvWayPayAmountCapCashShort, "field 'tvWayPayAmountCapCashShort'", TextView.class);
    target.tvWayPayAmountCalCashShort = Utils.findRequiredViewAsType(source, R.id.tvWayPayAmountCalCashShort, "field 'tvWayPayAmountCalCashShort'", TextView.class);
    target.tvWayPayDifferenceCashShort = Utils.findRequiredViewAsType(source, R.id.tvWayPayDifferenceCashShort, "field 'tvWayPayDifferenceCashShort'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvShowCashShortWayPay.RvShowCashShortWayPayHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvWayPayDescriptionCashShort = null;
    target.tvWayPayAmountCapCashShort = null;
    target.tvWayPayAmountCalCashShort = null;
    target.tvWayPayDifferenceCashShort = null;
  }
}
