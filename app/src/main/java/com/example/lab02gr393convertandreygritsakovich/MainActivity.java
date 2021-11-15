package com.example.lab02gr393convertandreygritsakovich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spFrom;
    Spinner spTo;
    EditText eFrom;
    TextView tTo;
    RadioGroup radioGroup2;
    RadioButton radioButton1,radioButton2, radioButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spFrom=findViewById(R.id.s_From);
        spTo=findViewById(R.id.s_To);
        eFrom=findViewById(R.id.e_From);
        tTo=findViewById(R.id.t_To2);
        radioButton1=findViewById(R.id.radio_Длины);
        radioButton2=findViewById(R.id.radio_Массы);
        radioButton3=findViewById(R.id.radio_Время);
        radioGroup2=findViewById(R.id.radio_grop);
    }
    public  void on_vibor(View v)
    {
        ArrayAdapter<String> adp = new <String>ArrayAdapter(this, android.R.layout.simple_list_item_1);
        switch (radioGroup2.getCheckedRadioButtonId())
        {
            case R.id.radio_Длины:
                adp.add("мм");
                adp.add("см");
                adp.add("м");
                adp.add("км");
                Toast.makeText(this,"Вы выбрали Единицы длины",Toast.LENGTH_SHORT).show();break;
            case R.id.radio_Время:
                adp.add("сек");
                adp.add("мин");
                adp.add("час");
                adp.add("сутки");
                Toast.makeText(this,"Вы выбрали Единицы времени",Toast.LENGTH_SHORT).show();break;
            case  R.id.radio_Массы:
                adp.add("гр");
                adp.add("кл");
                adp.add("т");
                Toast.makeText(this,"Вы выбрали Единицы массы",Toast.LENGTH_SHORT).show();break;
        }
        spFrom.setAdapter(adp);
        spTo.setAdapter(adp);
    }
    public void on_convert(View v)
    {
    double from = 0;
    String sFrom = null;
    String sTo= null;


    try
    { //Проверка на ошибку
        from = Double.parseDouble(eFrom.getText().toString());
        sFrom = (String) spFrom.getSelectedItem();
        sTo = (String) spTo.getSelectedItem();
    } catch (NumberFormatException e) {
        e.printStackTrace();
        Toast.makeText(this,"Неправильные значения",Toast.LENGTH_LONG).show();
        return;
    }

    //Длина
    double m = 0.0f;
    double to = 0.0f;
   if(sFrom.equals("мм")) m= from /1000.0f;
    if(sFrom.equals("см")) m= from /100.0f;
    if(sFrom.equals("м")) m= from /1.0f;
    if(sFrom.equals("км")) m= from * 1000.0f;

    if(sTo.equals("мм")) to= m *1000.0f;
    if(sTo.equals("см")) to= m *100.0f;
    if(sTo.equals("м")) to= m *1.0f;
    if(sTo.equals("км")) to= m /1000.0f;

    //Время
    if(sFrom.equals("сек")) m= from /60;
    if(sFrom.equals("мин")) m= from *1;
    if(sFrom.equals("час")) m= from *60;
    if(sFrom.equals("сутки")) m= from *(60*24);

    if(sTo.equals("сек")) to= m *60;
    if(sTo.equals("мин")) to= m *1;
    if(sTo.equals("час")) to= m /60;
    if(sTo.equals("сутки")) to= m /(60*24);

    //Массы
    if(sFrom.equals("гр")) m= from /1000;
    if(sFrom.equals("кл")) m= from /1;
    if(sFrom.equals("т")) m= from *1000;

    if(sTo.equals("гр")) to= m *1000;
    if(sTo.equals("кл")) to= m *1;
    if(sTo.equals("т")) to= m /1000;

    tTo.setText(String.valueOf(to));

}
}