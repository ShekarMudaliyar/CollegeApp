package com.mudaliyar.shekar.mldcc_clone;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    Intent intent;

    BackgroundWorker(Context cxt){
        context = cxt;
    }

    @Override
    protected String doInBackground(String... voids) {
        String type = voids[0];
        String result_url="https://mldcc-clone4.000webhostapp.com/result.php";
        String pdf_notice_url="https://mldcc-clone4.000webhostapp.com/pdfnotices.php";
        String gallery_url="https://mldcc-clone4.000webhostapp.com/gallery.php";
        String notification_url="https://mldcc-clone4.000webhostapp.com/notification.php";
        if(type.equals("login")){
            try {
                String section = voids[1];
                String seatno = voids[2];

                //connection
                URL url = new URL(result_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                //send the data to server
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("section","UTF-8")+"="+URLEncoder.encode(section,"UTF-8")+"&"
                        +URLEncoder.encode("seatno","UTF-8")+"="+URLEncoder.encode(seatno,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                //get data from server
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result +=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(type.equals("pdfnotice")){
            URL url = null;
            try {
                //connection
                url = new URL(pdf_notice_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                //get data
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result +=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(type.equals("gallery")){
            URL url = null;
            try {
                //connection
                url = new URL(gallery_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                //get data
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result +=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(type.equals("notifications")){
            URL url = null;
            try {
                //connection
                url = new URL(notification_url);
                HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                //get data
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!=null){
                    result +=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("loading ");
    }

    @Override
    protected void onPostExecute(String result) {
        Log.i("test",result);
      //  alertDialog.setMessage(result);
       // alertDialog.show();
        if(result.contains(",")) {
            intent = new Intent(context, finalResult.class);
            intent.putExtra("final_result", result);
            context.startActivity(intent);
            Log.i("test",result);

        }
        if(result.contains("!")){
            intent = new Intent(context, NoticePdfActivity.class);
            intent.putExtra("notices", result);
            context.startActivity(intent);
            Log.i("test",result);

        }
        if(result.contains("~")){
            intent = new Intent(context, GalleryActivity.class);
            intent.putExtra("gallery", result);
            context.startActivity(intent);
            Log.i("test",result);

        }
        if(result.contains("%")){
            intent = new Intent(context, NotificationActivity.class);
            intent.putExtra("notification", result);
            context.startActivity(intent);
            Log.i("test",result);

        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
