package firdaus.rizkika.exercise2;

import androidx.appcompat.app.AppCompatActivity;
import firdaus.rizkika.exercise2.database.DBController;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class TemanBaru extends AppCompatActivity {
    private TextInputEditText txtNama, txtTelpon;
    private Button simpan;
    String nm,tlp;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_baru);

        txtNama = findViewById(R.id.edtNama);
        txtTelpon = findViewById(R.id.edttelpon);
        simpan = findViewById(R.id.bttnSave);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtNama.getText().toString().equals("") || txtTelpon.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Mohon di isi nama dan telpon",Toast.LENGTH_SHORT).show();
                }
                else {
                    nm = txtNama.getText().toString();
                    tlp = txtTelpon.getText().toString();

                    HashMap<String,String> keyValues = new HashMap<>();
                    keyValues.put("nama",nm);
                    keyValues.put("telpon",tlp);

                    controller.insertData(keyValues);
                    callHome();
                }
            }
        });
    }

    public void callHome(){
        Intent intent = new Intent(TemanBaru.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}