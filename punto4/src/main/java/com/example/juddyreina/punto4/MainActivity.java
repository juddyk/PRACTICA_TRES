package com.example.juddyreina.punto4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boton = (Button) findViewById(R.id.bArea);
        final RadioButton bCir= (RadioButton) findViewById(R.id.circulo);
        final RadioButton bT= (RadioButton) findViewById(R.id.triangulo);
        final RadioButton bR= (RadioButton) findViewById(R.id.rectangulo);
        final RadioButton bCu= (RadioButton) findViewById(R.id.cuadrado);
        final RadioGroup figGeo =(RadioGroup) findViewById(R.id.figuras);
        final LinearLayout CoC=(LinearLayout) findViewById(R.id.show_CoC);
        final LinearLayout ToR=(LinearLayout) findViewById(R.id.show_ToR);
        final LinearLayout ver=(LinearLayout) findViewById(R.id.show);
        final EditText datoCoC = (EditText) findViewById(R.id.dataC);
        final EditText datoToR1 = (EditText) findViewById(R.id.data1);
        final EditText datoToR2 = (EditText) findViewById(R.id.data2);
        final TextView type=(TextView) findViewById(R.id.ver);
        final TextView type2=(TextView) findViewById(R.id.var);
        final TextView msm=(TextView) findViewById(R.id.veer);


        bCir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msm.setText("");
                datoCoC.setText("");
                datoToR1.setText("");
                datoToR2.setText("");

                type2.setText("Radio ");
                CoC.setVisibility(View.VISIBLE);
                ToR.setVisibility(View.GONE);
                type.setText("");

            }
        });

        bCu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msm.setText("");
                datoCoC.setText("");
                datoToR1.setText("");
                datoToR2.setText("");

                type2.setText("Lado ");
                CoC.setVisibility(View.VISIBLE);
                ToR.setVisibility(View.GONE);
                type.setText(" ");
            }
        });

        bT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msm.setText("");
                datoCoC.setText("");
                datoToR1.setText("");
                datoToR2.setText("");

                CoC.setVisibility(View.GONE);
                ToR.setVisibility(View.VISIBLE);
                type.setText(" ");
            }
        });

        bR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msm.setText("");
                datoCoC.setText("");
                datoToR1.setText("");
                datoToR2.setText("");

                CoC.setVisibility(View.GONE);
                ToR.setVisibility(View.VISIBLE);
                type.setText(" ");
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double pi=3.141593;
                double area;
                int fig = figGeo.getCheckedRadioButtonId();
                if(fig==-1){

                    msm.setText("SELECCIONE UNA OPCION");
                }
                else {
                    msm.setText(" ");
                    ver.setVisibility(View.VISIBLE);
                    switch (fig) {
                        case R.id.circulo:
                            if (datoCoC.getText().toString().equals("")) {
                                msm.setText("CAMPO VACIO");
                            } else {
                                double radio = Double.parseDouble(datoCoC.getText().toString());
                                area = pi * radio * radio;
                                type.setText(String.valueOf(area));

                            }
                            break;
                        case R.id.triangulo:
                            if(datoToR1.getText().toString().equals("") | datoToR2.getText().toString().equals("")){
                                msm.setText("CAMPO VACIO");
                            }
                            else{
                                double baseT = Double.parseDouble(datoToR1.getText().toString());
                                double alturaT = Double.parseDouble(datoToR2.getText().toString());
                                area = (baseT * alturaT) / 2;
                                type.setText(String.valueOf(area));

                            }
                            break;
                        case R.id.cuadrado:
                            if(datoCoC.getText().toString().equals("")){
                                msm.setText("CAMPO VACIO");
                            }
                            else {
                                double lado = Double.parseDouble(datoCoC.getText().toString());
                                area = lado * lado;
                                type.setText(String.valueOf(area));
                            }
                            break;
                        case R.id.rectangulo:
                            if(datoToR1.getText().toString().equals("") | datoToR2.getText().toString().equals("")){
                                msm.setText("CAMPO VACIO");
                            }
                            else{
                                double baseR=Double.parseDouble(datoToR1.getText().toString());
                                double alturaR=Double.parseDouble(datoToR2.getText().toString());
                                area=baseR*alturaR;
                                type.setText(String.valueOf(area));
                            }
                            break;
                    }
                    datoCoC.setText("");
                    datoToR1.setText("");
                    datoToR2.setText("");

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
