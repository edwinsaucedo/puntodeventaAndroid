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

public class RvCashShortDetailAdapter$RvCashShortDetailHolder_ViewBinding implements Unbinder {
  private RvCashShortDetailAdapter.RvCashShortDetailHolder target;

  @UiThread
  public RvCashShortDetailAdapter$RvCashShortDetailHolder_ViewBinding(RvCashShortDetailAdapter.RvCashShortDetailHolder target,
      View source) {
    this.target = target;

    target.tvAmountCashShortDetail = Utils.findRequiredViewAsType(source, R.id.tvAmountCashShortDetail, "field 'tvAmountCashShortDetail'", TextView.class);
    target.tvDateCashShortDetail = Utils.findRequiredViewAsType(source, R.id.tvDateCashShortDetail, "field 'tvDateCashShortDetail'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvCashShortDetailAdapter.RvCashShortDetailHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvAmountCashShortDetail = null;
    target.tvDateCashShortDetail = null;
  }
}
