package firdaus.rizkika.exercise2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import firdaus.rizkika.exercise2.adapter.TemanAdapter;
import firdaus.rizkika.exercise2.database.DBController;
import firdaus.rizkika.exercise2.database.Teman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton addbutton;
    private RecyclerView recyclerView;
    private TemanAdapter adapter;
    private ArrayList<Teman>temanArrayList;
    DBController controller = new DBController(this);
    String id,nm,tlp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.kontakRC);
        addbutton = findViewById(R.id.floatingButton);

        adapter = new TemanAdapter(temanArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TemanBaru.class);
                startActivity(intent);
            }
        });
    }

    public void BacaData(){
        ArrayList<HashMap<String,String>> newdaftarteman = controller.getAllTeman();
        temanArrayList = new ArrayList<>();
        //pindah hasil query kedalam teman
        for (int i = 0; i <newdaftarteman.size();i++){
            Teman teman = new Teman();

            teman.setId(newdaftarteman.get(i).get("id").toString());
            teman.setNama(newdaftarteman.get(i).get("nama").toString());
            teman.setTelpon(newdaftarteman.get(i).get("telpon").toString());
            //pindah kan dari Teman ke dalam ArrayList teman di adapter
            temanArrayList.add(teman);
        }
    }
}