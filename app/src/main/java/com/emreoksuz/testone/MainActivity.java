package com.emreoksuz.testone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        EditText editText;
        EditText editText2;
        TextView textView;
        SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.textNumber);
        editText2=findViewById(R.id.textNumber2);
        textView=findViewById(R.id.textView);

        sharedPreferences=this.getSharedPreferences("com.emreoksuz.testone", Context.MODE_PRIVATE);
        int islemSonucu=sharedPreferences.getInt("islemSonucu",0);
        textView.setText("İşlem Sonucu = "+islemSonucu);


    }


    public void toplama(View view){
        int sayi1=Integer.parseInt(editText.getText().toString());
        int sayi2=Integer.parseInt(editText2.getText().toString());
        int sonuc=sayi1+sayi2;
        textView.setText("Sonuc :"+sonuc);
        Toast.makeText(this, "Toplama işlemi gerçekleşti", Toast.LENGTH_SHORT).show();
        sharedPreferences.edit().putInt("islemSonucu",sonuc).apply();

    }
    public void cıkarma(View view){
        int sayi1=Integer.parseInt(editText.getText().toString());
        int sayi2=Integer.parseInt(editText2.getText().toString());
        int sonuc=sayi1-sayi2;
        textView.setText("Sonuc :"+sonuc);
        Toast.makeText(this, "Çıkarma işlemi gerçekleşti", Toast.LENGTH_SHORT).show();
        sharedPreferences.edit().putInt("islemSonucu",sonuc).apply();
    }
    public void carpma(View view){
        int sayi1=Integer.parseInt(editText.getText().toString());
        int sayi2=Integer.parseInt(editText2.getText().toString());
        int sonuc=sayi1*sayi2;
        textView.setText("Sonuc :"+sonuc);
        Toast.makeText(this, "Çarpma işlemi gerçekleşti", Toast.LENGTH_SHORT).show();
        sharedPreferences.edit().putInt("islemSonucu",sonuc).apply();
    }
    public void bolme(View view){
        int sayi1=Integer.parseInt(editText.getText().toString());
        int sayi2=Integer.parseInt(editText2.getText().toString());
        int sonuc=sayi1/sayi2;
        textView.setText("Sonuc :"+sonuc);
        Toast.makeText(this, "Bölme işlemi gerçekleşti", Toast.LENGTH_SHORT).show();
        sharedPreferences.edit().putInt("islemSonucu",sonuc).apply();


    }
    public void temizle(View view){
        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        alert.setMessage("Emin Misiniz?");
        alert.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Silme işlemi gerçekleşti", Toast.LENGTH_SHORT).show();
                int islemSonucu=sharedPreferences.getInt("islemSonucu",0);
                if (islemSonucu ==0){
                    textView.setText("Silindi");
                }else{
                    sharedPreferences.edit().remove("islemSonucu").apply();
                    textView.setText("Silindi");
                }
            }
        });

        alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //Buradaki Toast yazımının farklı olmasının sebebi Toast mesajının ekranda farklı yerlerde görünmesini sağlamak içinde ama başarısız olundu:/
                Toast toast=Toast.makeText(getApplicationContext(),"Silme işlemi gerçekleştirilmedi",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.RIGHT|Gravity.CENTER_HORIZONTAL,10,10);
                toast.show();



            }
        });
        alert.show();
    }
}