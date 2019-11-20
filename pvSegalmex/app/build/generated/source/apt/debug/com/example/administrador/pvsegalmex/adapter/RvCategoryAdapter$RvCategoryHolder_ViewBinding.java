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

public class RvCategoryAdapter$RvCategoryHolder_ViewBinding implements Unbinder {
  private RvCategoryAdapter.RvCategoryHolder target;

  @UiThread
  public RvCategoryAdapter$RvCategoryHolder_ViewBinding(RvCategoryAdapter.RvCategoryHolder target,
      View source) {
    this.target = target;

    target.tvCategoryDescription = Utils.findRequiredViewAsType(source, R.id.tvCategoryDescription, "field 'tvCategoryDescription'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvCategoryAdapter.RvCategoryHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvCategoryDescription = null;
  }
}
