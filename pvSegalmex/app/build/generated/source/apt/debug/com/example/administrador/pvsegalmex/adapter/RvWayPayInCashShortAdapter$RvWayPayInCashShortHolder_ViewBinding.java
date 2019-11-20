// Generated code from Butter Knife. Do not modify!
package com.example.administrador.pvsegalmex.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.administrador.pvsegalmex.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RvWayPayInCashShortAdapter$RvWayPayInCashShortHolder_ViewBinding implements Unbinder {
  private RvWayPayInCashShortAdapter.RvWayPayInCashShortHolder target;

  @UiThread
  public RvWayPayInCashShortAdapter$RvWayPayInCashShortHolder_ViewBinding(RvWayPayInCashShortAdapter.RvWayPayInCashShortHolder target,
      View source) {
    this.target = target;

    target.imvWayPayInCashShort = Utils.findRequiredViewAsType(source, R.id.imvWayPayInCashShort, "field 'imvWayPayInCashShort'", ImageView.class);
    target.tvWayPayInCasShortDescription = Utils.findRequiredViewAsType(source, R.id.tvWayPayInCasShortDescription, "field 'tvWayPayInCasShortDescription'", TextView.class);
    target.edt_WayPayInCashShort = Utils.findRequiredViewAsType(source, R.id.edt_WayPayInCashShort, "field 'edt_WayPayInCashShort'", EditText.class);
    target.idWayPayCashShort = Utils.findRequiredViewAsType(source, R.id.idWayPayCashShort, "field 'idWayPayCashShort'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvWayPayInCashShortAdapter.RvWayPayInCashShortHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imvWayPayInCashShort = null;
    target.tvWayPayInCasShortDescription = null;
    target.edt_WayPayInCashShort = null;
    target.idWayPayCashShort = null;
  }
}
