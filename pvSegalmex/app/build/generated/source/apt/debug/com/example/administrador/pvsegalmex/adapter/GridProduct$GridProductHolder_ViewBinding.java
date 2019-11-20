// Generated code from Butter Knife. Do not modify!
package com.example.administrador.pvsegalmex.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.administrador.pvsegalmex.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GridProduct$GridProductHolder_ViewBinding implements Unbinder {
  private GridProduct.GridProductHolder target;

  @UiThread
  public GridProduct$GridProductHolder_ViewBinding(GridProduct.GridProductHolder target,
      View source) {
    this.target = target;

    target.tvProductName = Utils.findRequiredViewAsType(source, R.id.tvProductName, "field 'tvProductName'", TextView.class);
    target.tvProductPrice = Utils.findRequiredViewAsType(source, R.id.tvProductPrice, "field 'tvProductPrice'", TextView.class);
    target.imvProductGrid = Utils.findRequiredViewAsType(source, R.id.imvProductGrid, "field 'imvProductGrid'", ImageView.class);
    target.tvProductGranel = Utils.findRequiredViewAsType(source, R.id.tvProductGranel, "field 'tvProductGranel'", TextView.class);
    target.tvProductUnit = Utils.findRequiredViewAsType(source, R.id.tvProductUnit, "field 'tvProductUnit'", TextView.class);
    target.tvProductUUID = Utils.findRequiredViewAsType(source, R.id.tvProductUUID, "field 'tvProductUUID'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    GridProduct.GridProductHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvProductName = null;
    target.tvProductPrice = null;
    target.imvProductGrid = null;
    target.tvProductGranel = null;
    target.tvProductUnit = null;
    target.tvProductUUID = null;
  }
}
