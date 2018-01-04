package com.example.mnk.mnkcap.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mnk.mnkcap.R;

import org.w3c.dom.Text;



public class FragmentCalculator extends Fragment {

    EditText txtHeight,txtWeight;
    Button btnCalculate;
    Button btnProteinIntakeCalculate;
    EditText txtProteinCalculatorWeight;
    TextView txtResult;
    TextView txtProteinCalculatorResult;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        txtHeight = (EditText) view.findViewById(R.id.txtHeight);
        txtWeight = (EditText) view.findViewById(R.id.txtWeight);
        btnCalculate = (Button) view.findViewById(R.id.btnCalculate);
        txtResult = (TextView) view.findViewById(R.id.txtResult);
        txtProteinCalculatorWeight = (EditText) view.findViewById(R.id.txtProteinCalculatorWeight);
        btnProteinIntakeCalculate = (Button) view.findViewById(R.id.btnProteinCalculate) ;
        txtProteinCalculatorResult = (TextView) view.findViewById(R.id.txtProteinCalculatorResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int height = Integer.parseInt(txtHeight.getText().toString());
                    int weight = Integer.parseInt(txtWeight.getText().toString());
                    if (BMICalc(height, weight) <= 18.5 )
                        txtResult.setText(BMICalc(height, weight)+" UNDERWEIGHT -  underweight individuals may have poor physical stamina and a weak immune system, leaving them open to infection.Being underweight is an established risk factor for osteoporosis, even for young people. ");
                    else if (BMICalc(height, weight) <= 25 && BMICalc(height, weight) > 18.5){
                        txtResult.setText(BMICalc(height, weight)+ " NORMAL WEIGHT - associated with living longest, the lowest incidence of serious ilness, as well as being perceived as more physically attractive than people with BMI in higher or lower ranges.");}
                    else if (BMICalc(height, weight)< 30 && BMICalc(height, weight)> 25){
                        txtResult.setText(BMICalc(height, weight) + " OVERWEIGHT - generally accepted view is that being overweight causes similar health problems to obesity, but to a lesser degree. Being overweight has been identified as a cause of cancer, and is projected to overtake smoking as the primary cause of cancer in developed countries as cases of cancer linked to smoking dwindle.");}
                    else if (BMICalc(height, weight) >= 30){
                        txtResult.setText(BMICalc(height, weight) + " OBESE - Obesity increases the risk of many physical and mental conditions. These comorbidities are most commonly shown in metabolic syndrome, a combination of medical disorders which includes: diabetes mellitus type 2, high blood pressure, high blood cholesterol, and high triglyceride levels.");}
                }
                catch (Exception e){
                    txtResult.setText("Parametre giriniz.");
                }

            }
        });

        btnProteinIntakeCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                   int weight = Integer.parseInt(txtProteinCalculatorWeight.getText().toString());
                   txtProteinCalculatorResult.setText("Minimum Protein intake is : " + (weight * 0.8) + "g \n" + "Average Protein intake is: " + (weight * 1.4) + "g \n" + "Bodybuilding protein intake is : " + (weight * 2.0) + "g");
               }
               catch (Exception e){
                   txtProteinCalculatorResult.setText("\t \t Parametre giriniz.");
               }
            }
        });

        txtProteinCalculatorWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = txtProteinCalculatorWeight.getText().toString();
                if(text != null && !text.equals("")){
                    int value = Integer.parseInt(text);
                    if(value > 160){
                        value = 160;
                        txtProteinCalculatorWeight.setText(value+"");
                    }

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        return view;


    }
    public float BMICalc(int height,int weight){

        return weight/((float)height*height)*100.0f*100;



    }


}
