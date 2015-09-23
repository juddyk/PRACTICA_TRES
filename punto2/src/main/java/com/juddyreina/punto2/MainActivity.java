package com.juddyreina.punto2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numero1 = (EditText) findViewById(R.id.num1);
        final EditText numero2 = (EditText) findViewById(R.id.num2);
        final TextView messError=(TextView) findViewById(R.id.mess);
        final TextView messResul=(TextView) findViewById(R.id.result);
        Button calcular = (Button) findViewById(R.id.calc);
        final RadioGroup opp= (RadioGroup) findViewById(R.id.operaciones);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = opp.getCheckedRadioButtonId();

                if(numero1.getText().toString().equals("") | numero2.getText().toString().equals("")){
                    messError.setText("**CAMPO VACIO**");
                }
                else{
                    messError.setText("Resultado: ");
                double val1=Double.parseDouble(numero1.getText().toString());
                double val2=Double.parseDouble(numero2.getText().toString());

                switch(selectedId){
                    case R.id.sum:

                        double r1=val1+val2;
                        messError.setText("Resultado: ");
                        messResul.setText(String.valueOf(r1));
                        break;
                    case R.id.rest:
                        double r2=val1-val2;
                        messError.setText("Resultado: ");
                        messResul.setText(String.valueOf(r2));
                        break;
                    case R.id.mul:
                        double r3=val1*val2;
                        messError.setText("Resultado: ");
                        messResul.setText(String.valueOf(r3));
                        break;
                    case R.id.div:
                        double r4 = val1 / val2;
                        if(val2==0){
                            messError.setText("*******DIVISION POR CERO********");
                            messResul.setText(String.valueOf(r4));
                        }
                        else {
                            messResul.setText(String.valueOf(r4));
                        }
                        break;
                }
            }
            }
        });
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
