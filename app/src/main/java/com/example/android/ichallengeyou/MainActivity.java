package com.example.android.ichallengeyou;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;
import static com.example.android.ichallengeyou.R.id.howard;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
   *Method used to check if all of the question are answered.
    */
    private int allAnswer() {
        int answer = 0;

        if (((RadioGroup) findViewById(R.id.radioGroup1)).getCheckedRadioButtonId() != -1) {
            answer += 1;
        }
        if (((RadioGroup) findViewById(R.id.radioGroup2)).getCheckedRadioButtonId() != -1) {
            answer += 1;
        }
        if (((RadioGroup) findViewById(R.id.radioGroup3)).getCheckedRadioButtonId() != -1) {
            answer += 1;
        }
        if (((RadioGroup) findViewById(R.id.radioGroup4)).getCheckedRadioButtonId() != -1) {
            answer += 1;
        }
        if (((RadioGroup) findViewById(R.id.radioGroup5)).getCheckedRadioButtonId() != -1) {
            answer += 1;
        }
        if (((RadioGroup) findViewById(R.id.radioGroup6)).getCheckedRadioButtonId() != -1) {
            answer += 1;
        }
        if (((RadioGroup) findViewById(R.id.radioGroup7)).getCheckedRadioButtonId() != -1) {
            answer += 1;
        }
        if (((CheckBox) findViewById(R.id.physics)).isChecked() |
                ((CheckBox) findViewById(R.id.math)).isChecked() |
                ((CheckBox) findViewById(R.id.chemistry)).isChecked() |
                ((CheckBox) findViewById(R.id.economics)).isChecked()) {
            answer += 1;
        }

        TextView Jamaica = (TextView) findViewById(R.id.jamaica);
        if (Jamaica.getText().length() > 0) {
            answer += 1;
        }
        TextView Taxy = (TextView) findViewById(R.id.taxi);
//        Log.d("MY LOG","TAXY "+Taxy.getText().length());
        if (Taxy.getText().length() > 0) {
            answer += 1;
        }
//        Log.d("MY LOG","ANSWER "+answer);
        return answer;
    }

    /*
   *Method used to check right answer and display a toast message with the score.
    */
    public void submit(View view) {
        score = 0;
        //Check Q 1
        RadioButton radioButtonOne = (RadioButton) findViewById(howard);
        boolean checkedOne = radioButtonOne.isChecked();
        if (checkedOne)
            score += 1;

        //Check Q 2
        RadioButton radioButtonTwo = (RadioButton) findViewById(R.id.pet_shop_boys);
        boolean checkedTwo = radioButtonTwo.isChecked();
        if (checkedTwo)
            score += 1;

        //Check Q 3
        RadioButton radioButtonThree = (RadioButton) findViewById(R.id.wife);
        boolean checkedThree = radioButtonThree.isChecked();
        if (checkedThree)
            score += 1;

        //Check Q 4
        RadioButton radioButtonFour = (RadioButton) findViewById(R.id.grollo);
        boolean checkedFour = radioButtonFour.isChecked();
        if (checkedFour)
            score += 1;

        //Check Q 5
        RadioButton radioButtonFive = (RadioButton) findViewById(R.id.macmillan);
        boolean checkedFive = radioButtonFive.isChecked();
        if (checkedFive)
            score += 1;

        //Check Q 6
        RadioButton radioButtonSix = (RadioButton) findViewById(R.id.molemap);
        boolean checkedSix = radioButtonSix.isChecked();
        if (checkedSix)
            score += 1;

        //Check Q 7
        RadioButton radioButtonSeven = (RadioButton) findViewById(R.id.deus_ex_machina);
        boolean checkedSeven = radioButtonSeven.isChecked();
        if (checkedSeven)
            score += 1;

        //Check  Q 8
        CheckBox checkBoxPhysics = (CheckBox) findViewById(R.id.physics);
        boolean checkedPhisics = checkBoxPhysics.isChecked();
        CheckBox checkBoxEconomics = (CheckBox) findViewById(R.id.economics);
        boolean checkedEconomics = checkBoxEconomics.isChecked();
        CheckBox checkBoxChemistry = (CheckBox) findViewById(R.id.chemistry);
        boolean checkedChemistry = checkBoxChemistry.isChecked();
        if (checkedPhisics && checkedEconomics && checkedChemistry)
            score += 1;

        //Check Q 9
        EditText jamaica = (EditText) findViewById(R.id.jamaica);
        boolean Florida = false;
        if (jamaica.getText().toString().equals("Florida") || jamaica.getText().toString().equals("florida")) {
            score += 1;
            Florida = true;

        }

        //Checks Q 10
        EditText taxyColor = (EditText) findViewById(R.id.taxi);
        boolean NYCTaxy = false;
        if (taxyColor.getText().toString().equals("Yellow") || taxyColor.getText().toString().equals("yellow")) {
            score += 1;
            NYCTaxy = true;

        }
        if (allAnswer() < 10) {
            //Displays toast "Please give answer to all of the questions "
            Toast.makeText(this, "Please give answer to all of the questions", Toast.LENGTH_LONG).show();
        } else {

            //Displays toast message with the score
            if (score >= 0 && score < 5) {
                Toast.makeText(this, "YOU ARE A LOOSER! Only " + score + " right answers!", Toast.LENGTH_LONG).show();
            } else if (score >= 5 && score <= 8) {
                Toast.makeText(this, "Good job! You have answered " + score + " questions correctly!", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "YOU ARE A GENIUS! " + score + " right answers!", Toast.LENGTH_LONG).show();
            }
            //Green correct radiobutton text
            radioButtonOne.setTextColor(rgb(0, 153, 0));
            radioButtonTwo.setTextColor(rgb(0, 153, 0));
            radioButtonThree.setTextColor(rgb(0, 153, 0));
            radioButtonFour.setTextColor(rgb(0, 153, 0));
            radioButtonFive.setTextColor(rgb(0, 153, 0));
            radioButtonSix.setTextColor(rgb(0, 153, 0));
            radioButtonSeven.setTextColor(rgb(0, 153, 0));

            //Green correct checkboxes
            checkBoxPhysics.setTextColor(rgb(0, 153, 0));
            checkBoxEconomics.setTextColor(rgb(0, 153, 0));
            checkBoxChemistry.setTextColor(rgb(0, 153, 0));
            //Green/Red textview
            if (Florida) {
                jamaica.getText();
                jamaica.setTextColor(rgb(0, 153, 0));
            } else {
                jamaica.setText((jamaica.getText() + "is not right, \"Florida\" is the right answer"));
                jamaica.setTextColor(rgb(255, 0, 0));
            }
            if (NYCTaxy) {
                taxyColor.getText();
                taxyColor.setTextColor(rgb(0, 153, 0));
            } else {
                taxyColor.setText((taxyColor.getText() + "is not right, \"Yellow\" is the right answer"));
                taxyColor.setTextColor(rgb(255, 0, 0));
            }

        }
    }

    /*
   *This method is used to reset the given answers.
    */
    public void reset(View view) {
        //reset radiogroup and radiobutton
        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
        radioGroup1.clearCheck();
        RadioButton radioButton1 = (RadioButton) findViewById(R.id.howard);
        radioButton1.setTextColor(rgb(0, 0, 0));

        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);
        radioGroup2.clearCheck();
        RadioButton radioButton2 = (RadioButton) findViewById(R.id.pet_shop_boys);
        radioButton2.setTextColor(rgb(0, 0, 0));

        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.radioGroup3);
        radioGroup3.clearCheck();
        RadioButton radioButton3 = (RadioButton) findViewById(R.id.wife);
        radioButton3.setTextColor(rgb(0, 0, 0));

        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.radioGroup4);
        radioGroup4.clearCheck();
        RadioButton radioButton4 = (RadioButton) findViewById(R.id.grollo);
        radioButton4.setTextColor(rgb(0, 0, 0));

        RadioGroup radioGroup5 = (RadioGroup) findViewById(R.id.radioGroup5);
        radioGroup5.clearCheck();
        RadioButton radioButton5 = (RadioButton) findViewById(R.id.macmillan);
        radioButton5.setTextColor(rgb(0, 0, 0));

        RadioGroup radioGroup6 = (RadioGroup) findViewById(R.id.radioGroup6);
        radioGroup6.clearCheck();
        RadioButton radioButton6 = (RadioButton) findViewById(R.id.molemap);
        radioButton6.setTextColor(rgb(0, 0, 0));

        RadioGroup radioGroup7 = (RadioGroup) findViewById(R.id.radioGroup7);
        radioGroup7.clearCheck();
        RadioButton radioButton7 = (RadioButton) findViewById(R.id.deus_ex_machina);
        radioButton7.setTextColor(rgb(0, 0, 0));

        // reset checkbox
        if (((CheckBox) findViewById(R.id.physics)).isChecked()) {
            ((CheckBox) findViewById(R.id.physics)).setChecked(false);
        }
        ((CheckBox) findViewById(R.id.physics)).setTextColor(rgb(0, 0, 0));
        if (((CheckBox) findViewById(R.id.math)).isChecked()) {
            ((CheckBox) findViewById(R.id.math)).setChecked(false);
        }
        ((CheckBox) findViewById(R.id.math)).setTextColor(rgb(0, 0, 0));
        if (((CheckBox) findViewById(R.id.economics)).isChecked()) {
            ((CheckBox) findViewById(R.id.economics)).setChecked(false);
        }
        ((CheckBox) findViewById(R.id.economics)).setTextColor(rgb(0, 0, 0));
        if (((CheckBox) findViewById(R.id.chemistry)).isChecked()) {
            ((CheckBox) findViewById(R.id.chemistry)).setChecked(false);
        }
        ((CheckBox) findViewById(R.id.chemistry)).setTextColor(rgb(0, 0, 0));

        // reset textview
        TextView Jamaica = (TextView) findViewById(R.id.taxi);
        Jamaica.setText("");
        Jamaica.setTextColor(rgb(0, 0, 0));
        Jamaica.setHint(R.string.A9_1);
        TextView Taxy = (TextView) findViewById(R.id.jamaica);
        Taxy.setText("");
        Taxy.setTextColor(rgb(0, 0, 0));
        Taxy.setHint(R.string.A10_1);

        // reset score
        score = 0;
    }
}
