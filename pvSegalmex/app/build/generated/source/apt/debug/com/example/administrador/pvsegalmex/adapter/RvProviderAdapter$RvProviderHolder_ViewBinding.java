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

public class RvProviderAdapter$RvProviderHolder_ViewBinding implements Unbinder {
  private RvProviderAdapter.RvProviderHolder target;

  @UiThread
  public RvProviderAdapter$RvProviderHolder_ViewBinding(RvProviderAdapter.RvProviderHolder target,
      View source) {
    this.target = target;

    target.tvProviderName = Utils.findRequiredViewAsType(source, R.id.tvProviderName, "field 'tvProviderName'", TextView.class);
    target.tvProviderAlias = Utils.findRequiredViewAsType(source, R.id.tvProviderAlias, "field 'tvProviderAlias'", TextView.class);
    target.tvProviderEmail = Utils.findRequiredViewAsType(source, R.id.tvProviderEmail, "field 'tvProviderEmail'", TextView.class);
    target.tvProviderPhone = Utils.findRequiredViewAsType(source, R.id.tvProviderPhone, "field 'tvProviderPhone'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvProviderAdapter.RvProviderHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvProviderName = null;
    target.tvProviderAlias = null;
    target.tvProviderEmail = null;
    target.tvProviderPhone = null;
  }
}
