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

public class RvDepartmentAdapter$RvDepartmentHolder_ViewBinding implements Unbinder {
  private RvDepartmentAdapter.RvDepartmentHolder target;

  @UiThread
  public RvDepartmentAdapter$RvDepartmentHolder_ViewBinding(RvDepartmentAdapter.RvDepartmentHolder target,
      View source) {
    this.target = target;

    target.tvDepartamentDescription = Utils.findRequiredViewAsType(source, R.id.tvDepartamentDescription, "field 'tvDepartamentDescription'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvDepartmentAdapter.RvDepartmentHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvDepartamentDescription = null;
  }
}
