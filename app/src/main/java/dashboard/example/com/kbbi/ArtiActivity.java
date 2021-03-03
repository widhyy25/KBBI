package dashboard.example.com.kbbi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ArtiActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    Kamus kamusnya;
    TextView txtKata, txtArti;
    RecyclerView rvArti;
    RecyclerView.LayoutManager layoutkamus;
    List<String> tulisannya= new ArrayList<>();
    KamusAdapter kamusAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arti);
        txtKata=(TextView)findViewById(R.id.txt_kata);
        rvArti=(RecyclerView) findViewById(R.id.rv_arti);
        txtArti=(TextView)findViewById(R.id.txt_arti);
        layoutkamus=new LinearLayoutManager(this);
        rvArti.setLayoutManager(layoutkamus);

        Intent datanya=getIntent();
        tulisannya=datanya.getStringArrayListExtra("data1");
       kamusAdapter=new KamusAdapter(tulisannya, ArtiActivity.this);
       rvArti.setAdapter(kamusAdapter);



    }
}
