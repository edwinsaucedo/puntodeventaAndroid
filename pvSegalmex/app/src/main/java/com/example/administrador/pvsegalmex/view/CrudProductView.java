package com.example.administrador.pvsegalmex.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.TabLayout;
import android.widget.LinearLayout;

import com.example.administrador.pvsegalmex.R;
import com.example.administrador.pvsegalmex.adapter.ViewPagerAdapter;
import com.example.administrador.pvsegalmex.entity.ProductEntity;
import com.example.administrador.pvsegalmex.mode.Barcodemode;
import com.example.administrador.pvsegalmex.uint.ScanHelper;
import com.example.administrador.pvsegalmex.uint.SysBarcodeUtil;
import com.example.administrador.pvsegalmex.utils.CustomViewPager;

public class CrudProductView extends MenuView {

    int scanmode = -1;
    boolean bleft = false, bright = false, bsound = false;
    private String m_Broadcastname;
    String barCode;

    //region PROTECTED METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CustomViewPager viewPager = findViewById(R.id.ViewPager);
        TabLayout tabLayout = findViewById(R.id.Tabbar);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentProduct(), getString(R.string.pageTitleFragmentProduct));
        adapter.addFragment(new FramgmentProductPrice(), getString(R.string.pageTitleFragmentProductPrice));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        LinearLayout tabStrip = ((LinearLayout) tabLayout.getChildAt(0));
        tabStrip.setEnabled(false);
        viewPager.setPagingEnabled(false);
        for (int i = 0; i < tabStrip.getChildCount(); i++) {
            tabStrip.getChildAt(i).setClickable(false);
        }
        ScanSetting();

        Barcodemode br = new Barcodemode();
        barCode = br.getBarcode();
        if (ProductEntity.instance.getId() != -1) {
            LinearLayout tabStripp = ((LinearLayout) tabLayout.getChildAt(0));
            tabStripp.setEnabled(true);
            viewPager.setPagingEnabled(true);
            for (int i = 0; i < tabStripp.getChildCount(); i++) {
                tabStripp.getChildAt(i).setClickable(true);
            }
        }

    }

    @Override
    protected int getPageLayoutId() {
        return R.layout.activity_crud_product_view;
    }

    @Override
    protected String getScreenTitle() {
        return getString(R.string.itemMenu8);
    }

    //endregion

    @Override
    protected void onResume() {
        super.onResume();
        final IntentFilter intentFilter = new IntentFilter();
        m_Broadcastname = "com.barcode.sendBroadcast";// com.barcode.sendBroadcastScan
        intentFilter.addAction(m_Broadcastname);
        registerReceiver(receiver, intentFilter);
        Barcodemode br = new Barcodemode();
        barCode = br.getBarcode();
    }

    private void ScanSetting() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.System.canWrite(this)) {
                String version = android.os.Build.VERSION.RELEASE;
                if (version.equals("4.2.2")) {
                    scanmode = SysBarcodeUtil.getBarcodeSendMode(CrudProductView.this);
                    bleft = SysBarcodeUtil.getLeftSwitchState(CrudProductView.this);
                    bright = SysBarcodeUtil.getRightSwitchState(CrudProductView.this);
                    if (!bleft) {
                        SysBarcodeUtil.setLeftSwitchState(CrudProductView.this, true);
                    }
                    if (!bright) {
                        SysBarcodeUtil.setRightSwitchState(CrudProductView.this, true);
                    }
                    if (scanmode != 2) {
                        SysBarcodeUtil.setBarcodeSendMode(CrudProductView.this, 2);
                    }
                } else {
                    scanmode = ScanHelper.getBarcodeReceiveMode(CrudProductView.this);
                    bleft = ScanHelper.getScanSwitchLeft(CrudProductView.this);
                    bright = ScanHelper.getScanSwitchRight(CrudProductView.this);
                    bsound = ScanHelper.getScanSound(CrudProductView.this);
                    if (!bsound) {
                        ScanHelper.setScanSound(CrudProductView.this, true);
                    }
                    if (!bleft) {
                        ScanHelper.setScanSwitchLeft(CrudProductView.this, true);
                    }
                    if (!bright) {
                        ScanHelper.setScanSwitchRight(CrudProductView.this, true);
                    }
                    if (scanmode != 2) {
                        ScanHelper.setBarcodeReceiveMode(CrudProductView.this, 2);
                    }
                }
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context arg0, Intent arg1) {
            String str;
            if (arg1.getAction().equals(m_Broadcastname)) {
                str = arg1.getStringExtra("BARCODE");
                if (!"".equals(str)) {
                    Barcodemode code = new Barcodemode();
                    code.setBarcode(str);
                    barCode = str;

                }
            }
        }
    };
}
