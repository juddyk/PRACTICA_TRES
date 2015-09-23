package com.example.juddyreina.punto5;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button showw = (Button) findViewById(R.id.Bot_Show);
        final RadioGroup sex=(RadioGroup) findViewById(R.id.grupoSex);
        final EditText nombre = (EditText) findViewById(R.id.idName);
        final EditText apellido = (EditText) findViewById(R.id.idLastName);
        final EditText documento = (EditText) findViewById(R.id.docum);
        final Spinner typeDoc = (Spinner) findViewById(R.id.spin_td);
        final Spinner city = (Spinner) findViewById(R.id.spin_Ciudad);
        final DatePicker date=(DatePicker) findViewById(R.id.DatePick);
        final TextView msn = (TextView) findViewById(R.id.mss);
        final CheckBox check1=(CheckBox) findViewById(R.id.hob1);
        final CheckBox check2=(CheckBox) findViewById(R.id.hob2);
        final CheckBox check3=(CheckBox) findViewById(R.id.hob3);
        final CheckBox check4=(CheckBox) findViewById(R.id.hob4);
        final CheckBox check5=(CheckBox) findViewById(R.id.hob5);
        final LinearLayout fila1=(LinearLayout) findViewById(R.id.l1);
        final LinearLayout fila2=(LinearLayout) findViewById(R.id.l2);
        final LinearLayout fila3=(LinearLayout) findViewById(R.id.l3);
        final LinearLayout fila4=(LinearLayout) findViewById(R.id.l4);
        final LinearLayout fila5=(LinearLayout) findViewById(R.id.l5);
        final LinearLayout fila6=(LinearLayout) findViewById(R.id.l6);
        final TextView verNombre=(TextView) findViewById(R.id.show_name);
        final TextView verApellido=(TextView) findViewById(R.id.show_lname);
        final TextView verTD=(TextView) findViewById(R.id.show_doc1);
        final TextView verD=(TextView) findViewById(R.id.show_doc2);
        final TextView verSex=(TextView) findViewById(R.id.show_sex);
        final TextView verDia=(TextView) findViewById(R.id.show_data1);
        final TextView verLugar=(TextView) findViewById(R.id.show_data2);
        final TextView verHobbies=(TextView) findViewById(R.id.show_hobbies);

        showw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nm=nombre.getText().toString();
                String ap=apellido.getText().toString();
                String doc=documento.getText().toString();
                String td=typeDoc.getSelectedItem().toString();
                String ciud=city.getSelectedItem().toString();
                String hobbies=" ";
                String sexo=" ";

                int dia=date.getDayOfMonth();
                int mes=date.getMonth();
                int anio=date.getYear();
                int edad;
                if(mes<9){
                    edad=2015-anio;
                }
                else{
                    edad=2014-anio;
                }

                int selecSex = sex.getCheckedRadioButtonId();

                if (nm.equals("") | ap.equals("") | doc.equals("") | td.equals("NN") | ciud.equals("(Vacio)")| selecSex==-1 ){
                    msn.setText("CAMPO VACIO");
                    msn.setTextColor(Color.parseColor("#7CFC00"));
                } else {
                    msn.setTextColor(Color.parseColor("#FFFFFF"));
                    msn.setText(" Resumen ");

                    if(check1.isChecked()){
                        hobbies="-"+check1.getText().toString()+hobbies+"-";

                    }
                    if(check2.isChecked()){
                        hobbies="-"+check2.getText().toString()+hobbies+"-";
                    }
                     if(check3.isChecked()){
                        hobbies="-"+check3.getText().toString()+hobbies;
                    }
                    if(check4.isChecked()){
                        hobbies="-"+check4.getText().toString()+hobbies;
                    }
                    if(check5.isChecked()){
                        hobbies=check5.getText().toString();
                    }

                    switch (selecSex){
                        case R.id.mas:
                            sexo="Masculino";
                            break;
                        case R.id.fem:
                            sexo="Femenino";
                            break;

                    }

                    verNombre.setText(nm);
                    verApellido.setText(ap);
                    verTD.setText(td);
                    verD.setText(doc);
                    verSex.setText(sexo);
                    verDia.setText(new StringBuilder()
                                    .append(edad).append(" años").append("\n").append(dia).append("/").append(mes+1).append("/").append(anio)
                    );
                    verLugar.setText(ciud);
                    verHobbies.setText(hobbies);


                    fila1.setVisibility(View.VISIBLE);
                    fila2.setVisibility(View.VISIBLE);
                    fila3.setVisibility(View.VISIBLE);
                    fila4.setVisibility(View.VISIBLE);
                    fila5.setVisibility(View.VISIBLE);
                    fila6.setVisibility(View.VISIBLE);
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
