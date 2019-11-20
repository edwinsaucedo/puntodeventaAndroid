// Generated code from Butter Knife. Do not modify!
package com.example.administrador.pvsegalmex.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.administrador.pvsegalmex.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.edtUserNick = Utils.findRequiredViewAsType(source, R.id.edtUserNick, "field 'edtUserNick'", EditText.class);
    target.edtUserPassword = Utils.findRequiredViewAsType(source, R.id.edtUserPassword, "field 'edtUserPassword'", EditText.class);
    target.btnLogin = Utils.findRequiredViewAsType(source, R.id.btnLogin, "field 'btnLogin'", AppCompatButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edtUserNick = null;
    target.edtUserPassword = null;
    target.btnLogin = null;
  }
}
