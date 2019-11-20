package com.example.administrador.pvsegalmex.pojo;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.administrador.pvsegalmex.entity.DepartmentEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class Connection extends AsyncTask<String, String, String> {
    private ArrayList<DepartmentEntity> departmentList;
    private Context httpContext;
    ProgressDialog progressDialog;

    @Override
    protected String doInBackground(String... strings) {
        HttpsURLConnection httpsURLConnection = null;
        URL url = null;
        try {
            url = new URL(strings[0]);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        try {
            httpsURLConnection = (HttpsURLConnection)url.openConnection();
            httpsURLConnection.connect();
            int code = httpsURLConnection.getResponseCode();
            if(code == HttpsURLConnection.HTTP_OK){
               InputStream in = new BufferedInputStream(httpsURLConnection.getInputStream());
               BufferedReader reader = new BufferedReader(new InputStreamReader(in));
               String line ="";
               StringBuffer buffer = new StringBuffer();
               while ((line =reader.readLine())!=null){
                   buffer.append(line);
               }
               return buffer.toString();
            }

        }
        catch (Exception e){

        }
        return null;
    }
}
