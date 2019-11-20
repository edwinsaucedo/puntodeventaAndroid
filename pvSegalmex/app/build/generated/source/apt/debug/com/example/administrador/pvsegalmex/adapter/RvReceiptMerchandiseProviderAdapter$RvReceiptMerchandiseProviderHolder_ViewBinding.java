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

public class RvReceiptMerchandiseProviderAdapter$RvReceiptMerchandiseProviderHolder_ViewBinding implements Unbinder {
  private RvReceiptMerchandiseProviderAdapter.RvReceiptMerchandiseProviderHolder target;

  @UiThread
  public RvReceiptMerchandiseProviderAdapter$RvReceiptMerchandiseProviderHolder_ViewBinding(RvReceiptMerchandiseProviderAdapter.RvReceiptMerchandiseProviderHolder target,
      View source) {
    this.target = target;

    target.dateRM = Utils.findRequiredViewAsType(source, R.id.tvDateReceiptMerchandise, "field 'dateRM'", TextView.class);
    target.totalRM = Utils.findRequiredViewAsType(source, R.id.tvTotalReceiptMerchandise, "field 'totalRM'", TextView.class);
    target.articlesRM = Utils.findRequiredViewAsType(source, R.id.tvArticlesReceiptMerchandise, "field 'articlesRM'", TextView.class);
    target.providerRM = Utils.findRequiredViewAsType(source, R.id.tvProviderMerchandise, "field 'providerRM'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RvReceiptMerchandiseProviderAdapter.RvReceiptMerchandiseProviderHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.dateRM = null;
    target.totalRM = null;
    target.articlesRM = null;
    target.providerRM = null;
  }
}
