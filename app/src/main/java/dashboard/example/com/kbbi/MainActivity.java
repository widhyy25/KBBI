package dashboard.example.com.kbbi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    Kamus kamusnya;
    TextView txt_kataa, txt_cari;
    EditText katanyaa;
    Button btnCari;
    String kata;
    List<String> arti;
    Kamus adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_kataa = (TextView) findViewById(R.id.txt_kataa);
        txt_cari = (TextView) findViewById(R.id.txt_cari);
        katanyaa = (EditText) findViewById(R.id.edt_kata);
        btnCari = (Button) findViewById(R.id.btn_cari);

        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kata = katanyaa.getText().toString();
                if (kata.equals("")) {
                    Toast.makeText(MainActivity.this, "Masukkan kata dulu", Toast.LENGTH_LONG).show();
                } else {


                    apiInterface = ApiClient.ambilData().create(ApiInterface.class);
                    Call<Kamus> call = apiInterface.getKamusSaya(kata);
                    call.enqueue(new Callback<Kamus>() {
                        @Override
                        public void onResponse(Call<Kamus> call, Response<Kamus> response) {
                            kamusnya = response.body();
                            txt_kataa.setText(kamusnya.getLema());
                            arti = kamusnya.getArti();
                            Intent pindah = new Intent(MainActivity.this, ArtiActivity.class);
                            pindah.putExtra("data1", (Serializable) arti);
                            startActivity(pindah);

                        }

                        @Override
                        public void onFailure(Call<Kamus> call, Throwable t) {

                        }
                    });
                }


            }

        });
    }
}
