package com.example.ing3application;

import utils.Envio;
import utils.GMailSender;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class EmailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        String to = "zucca_17k@hotmail.com, guidozuccarelli@hotmail.com, guidozuccarelli@gmail.com";
        enviar(to, "Hola",
                "Esto es un email enviado desde una app de Android");
    }
 
    private void enviar(String to,
        String asunto, String mensaje) {
        /*Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        //String[] to = direccionesEmail;
        //String[] cc = copias;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));*/
    	 try {   
             GMailSender sender = new GMailSender("ingenieria3.2014@gmail.com", "grupo3ing");
             Envio envio = new Envio(sender, asunto, mensaje, to);
             Thread thread = new Thread(envio);
             thread.start();
         } catch (Exception e) {   
             Log.e("SendMail", e.getMessage(), e); 
             e.printStackTrace();
         } 
    }
}
