package com.example.administrador.pvsegalmex;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.administrador.pvsegalmex.mode.Barcodemode;
import com.example.administrador.pvsegalmex.uint.ScanHelper;
import com.example.administrador.pvsegalmex.uint.SysBarcodeUtil;

import java.util.ArrayList;
import java.util.List;

public class Segunda extends Activity implements View.OnClickListener {

    private int scanmode = -1;
    private boolean bleft = false, bright = false, bsound = false;
    private int Index = 1;
    private List<Barcodemode> readermodes = new ArrayList<Barcodemode>();
    private String m_Broadcastname;
    private String[] ItemName = { "Export Data", "Clear Data"};
    public static long lastTime;
    //* ****************************************************************
    private ListView list_code;
    private Button btn_ScanCode;
    private ImageButton btn_menu_data;
    private EditText edt;

    protected static final String action = "com.barcode.sendBroadcast";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        edt = (EditText) findViewById(R.id.edt);
        ScanSetting();
        Barcodemode code = new Barcodemode();

        edt.setText(code.getBarcode());
    }

    @Override
    public void onClick(View view) {

    }

    private void sendKeyCode1(int keyCode) {
        try {
            String keyCommand = "input keycode " + keyCode;
            Runtime.getRuntime().exec(keyCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendKeyEvent(final int KeyCode) {
        new Thread() {
            public void run() {
                try {
                    Instrumentation inst = new Instrumentation();
                    inst.sendKeyDownUpSync(KeyCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    private void ScanSetting() {
        // 0 : fast; 1 : slow; 2 : broadcast
        String version = android.os.Build.VERSION.RELEASE;
        if (version.equals("4.2.2")) {
            scanmode = SysBarcodeUtil.getBarcodeSendMode(Segunda.this);
            bleft = SysBarcodeUtil.getLeftSwitchState(Segunda.this);
            bright = SysBarcodeUtil.getRightSwitchState(Segunda.this);
            if (!bleft) {
                SysBarcodeUtil.setLeftSwitchState(Segunda.this, true);
            }
            if (!bright) {
                SysBarcodeUtil.setRightSwitchState(Segunda.this, true);
            }
            if (scanmode != 2) {
                SysBarcodeUtil.setBarcodeSendMode(Segunda.this, 2);
            }
        } else {
            scanmode = ScanHelper.getBarcodeReceiveMode(Segunda.this);
            bleft = ScanHelper.getScanSwitchLeft(Segunda.this);
            bright = ScanHelper.getScanSwitchRight(Segunda.this);
            bsound = ScanHelper.getScanSound(Segunda.this);
            if (!bsound) {
                ScanHelper.setScanSound(Segunda.this, true);
            }
            if (!bleft) {
                ScanHelper.setScanSwitchLeft(Segunda.this, true);
            }
            if (!bright) {
                ScanHelper.setScanSwitchRight(Segunda.this, true);
            }
            if (scanmode != 2)
                ScanHelper.setBarcodeReceiveMode(Segunda.this, 2);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String version = android.os.Build.VERSION.RELEASE;
        if (version.equals("4.2.2")) {
            SysBarcodeUtil.setLeftSwitchState(Segunda.this, bleft);
            SysBarcodeUtil.setRightSwitchState(Segunda.this, bright);
            SysBarcodeUtil.setBarcodeSendMode(Segunda.this, scanmode);
        } else {
            ScanHelper.setScanSwitchLeft(Segunda.this, bleft);
            ScanHelper.setScanSwitchRight(Segunda.this, bright);
            ScanHelper.setBarcodeReceiveMode(Segunda.this, scanmode);
            ScanHelper.setScanSound(Segunda.this, bsound);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        final IntentFilter intentFilter = new IntentFilter();
        m_Broadcastname = "com.barcode.sendBroadcast";// com.barcode.sendBroadcastScan
        intentFilter.addAction(m_Broadcastname);
        registerReceiver(receiver, intentFilter);
    }
    @Override	protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context arg0, Intent arg1) {
            if (arg1.getAction().equals(m_Broadcastname)) {
                String str = arg1.getStringExtra("BARCODE");
                if (!"".equals(str)) {
                    Barcodemode code = new Barcodemode();
                    code.setBarcode(str);
                    edt.setText(str);

                }
            }
        }
    };
}


