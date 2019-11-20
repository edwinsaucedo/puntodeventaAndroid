package com.example.administrador.pvsegalmex.uint;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;


import com.example.administrador.pvsegalmex.R;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * 
 */
public class AsyncTaskExt {
	private static Dialog progressDialog;
	@SuppressWarnings("unchecked")
	public static void doAsync(final ASynCallBack ascb, final Context mContext,
                               final String title, final String body) {
		Executor exec = new ThreadPoolExecutor(5, 128, 10, TimeUnit.SECONDS,
				new LinkedBlockingQueue<Runnable>());
		new AsyncTask() {
			@Override
			protected void onPreExecute() {
				super.onPreExecute();

				progressDialog.setCancelable(true);
				progressDialog.getWindow().setBackgroundDrawableResource(
						android.R.color.transparent);
				progressDialog.show();
				ascb.start();
			}
			@Override
			protected Object doInBackground(Object... params) {
				return ascb.run();
			}
			@Override
			protected void onPostExecute(Object result) {
				super.onPostExecute(result);
				if (progressDialog != null) {
					progressDialog.dismiss();
				}
				ascb.end(result.toString());
			}
			protected void onCancelled(Object result) {

			};

		}.executeOnExecutor(exec);
	}
	public interface ASynCallBack {
		void start();
		String run();
		void end(String str);
	}
}
