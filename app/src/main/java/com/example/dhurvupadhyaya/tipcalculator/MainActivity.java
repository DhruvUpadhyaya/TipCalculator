package com.example.dhurvupadhyaya.tipcalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText _billAmount;
    private TextView _resultTip;
    private SeekBar seekBar;
    private Button _nextButton;
    private TextView _calculatedTip;
    private int newAmount;
    private TextView rating;

    public void onButtonTapped(View view){

        _billAmount = findViewById(R.id.billAmountId);

        int enteredAmount;



        if (_billAmount.getText().toString().trim().length() == 0){
            Toast.makeText(MainActivity.this,"Enter Bill Amount",Toast.LENGTH_LONG).show();
        }else{
            enteredAmount =Integer.parseInt(_billAmount.getText().toString());


            newAmount = (enteredAmount*seekBar.getProgress())/100;
            _calculatedTip.setText("Calculated Tip :" + Integer.toString(newAmount) +"$");

        }


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        _resultTip = findViewById(R.id.resultId);
        seekBar = findViewById(R.id.seekBar);
        rating = findViewById(R.id.ratingId);
        _calculatedTip = findViewById(R.id.calculatedTipId);
        _calculatedTip.setText("Calculated Tip :" + Integer.toString(newAmount) +"$");


        _resultTip.setText("Tip : " + seekBar.getProgress() +"%");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                _resultTip.setText("Tip : " + seekBar.getProgress() +"%");

                if (seekBar.getProgress() == 12 ){
                    rating.setText("Average!!");
                    rating.animate().scaleX(3).setDuration(100);
                    rating.animate().scaleY(3).setDuration(100);
                    rating.setTextColor(Color.RED);

                } else if ((seekBar.getProgress() >=15) && (seekBar.getProgress() <19)){
                    rating.setText("Good!!");
                    rating.animate().scaleX(4).setDuration(100);
                    rating.animate().scaleY(4).setDuration(100);
                    rating.setTextColor(Color.RED);
                } else if (seekBar.getProgress() >=19){
                    rating.setText("Excellent!!");
                    rating.animate().scaleX(5).setDuration(100);
                    rating.animate().scaleY(5).setDuration(100);
                    rating.setTextColor(Color.RED);
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });


    }
    public void onNext(View view){

        _billAmount.setText("");
        newAmount = 0;
        rating.setText("");
        seekBar.setProgress(0);

    }
}

