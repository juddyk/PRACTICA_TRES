package com.juddyreina.punto3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText quices=(EditText) findViewById(R.id.qcs);
        final EditText expos=(EditText) findViewById(R.id.exp);
        final EditText Plab=(EditText) findViewById(R.id.pL);
        final EditText Pfinal=(EditText) findViewById(R.id.pF);

        final TextView messResul=(TextView) findViewById(R.id.nota);
        final TextView messAviso=(TextView) findViewById(R.id.mss);

        Button calcNota=(Button) findViewById(R.id.rslt);

        calcNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(quices.getText().toString().equals("") | expos.getText().toString().equals("") | Plab.getText().toString().equals("") | Pfinal.getText().toString().equals("") ){
                messAviso.setText("CAMPO VACIO");

            }
            else{
                messAviso.setText(" ");
                double valQ = Double.parseDouble(quices.getText().toString());
                double valE = Double.parseDouble(expos.getText().toString());
                double valPL = Double.parseDouble(Plab.getText().toString());
                double valPF = Double.parseDouble(Pfinal.getText().toString());

                if (valQ <= 5.0 & valE <= 5.0 & valPF <= 5.0 & valPL <= 5.0 & valQ >= 0 & valE >= 0 & valPF >= 0 & valPL >= 0) {
                    double resN = valQ * 0.15 + valE * 0.1 + valPL * 0.4 + valPF * 0.35;
                    messResul.setText(String.valueOf(resN));

                    if (resN < 3.0) {
                        messAviso.setTextColor(Color.parseColor("#FF0000"));
                        messAviso.setText("**PERDIO** ");
                    } else {
                        messAviso.setTextColor(Color.parseColor("#FFFFFF"));
                        messAviso.setText("**GANO** ");

                    }
                } else {
                    messAviso.setText("INVALIDO ");

                }
            }
        }
    }
        );




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
