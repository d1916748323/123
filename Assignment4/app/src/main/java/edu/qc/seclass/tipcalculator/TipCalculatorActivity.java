package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TipCalculatorActivity extends AppCompatActivity {
    private EditText checkamount , peoplenum;
    private TextView p15,p20,p25,t15,t20,t25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkamount = (EditText) findViewById(R.id.checkAmountValue);
        peoplenum= (EditText) findViewById(R.id.partySizeValue);
        p15=findViewById(R.id.fifteenPercentTipValue);
        p20=findViewById(R.id.twentyPercentTipValue);
        p25=findViewById(R.id.twentyfivePercentTipValue);
        t15=findViewById(R.id.fifteenPercentTotalValue);
        t20=findViewById(R.id.twentyPercentTotalValue);
        t25=findViewById(R.id.twentyfivePercentTotalValue);



    }

    public void clickedButton(View view){
        String amount=checkamount.getText().toString();
        String num=peoplenum.getText().toString();

        double totalpay=Double.parseDouble(amount);
        int totalnum=Integer.parseInt(num);
        if(totalpay<=0){
            Toast.makeText(getApplicationContext(),"Enter positive check amount\n",Toast.LENGTH_SHORT).show();
            return;
        }
        if(totalnum<=0){
            Toast.makeText(getApplicationContext(),"Enter positive amount of people\n",Toast.LENGTH_SHORT).show();
            return;
        }
        double tip15=totalpay*0.15 /totalnum;
        double tip20=totalpay*0.2/totalnum;
        double tip25=totalpay*0.25/totalnum;

        double total15=totalpay/ totalnum +tip15;
        double total20=totalpay/ totalnum +tip20;
        double total25=totalpay/ totalnum +tip25;

        p15.setText(String.format("%d",Math.round(tip15)));
        p20.setText(String.format("%d",Math.round(tip20)));
        p25.setText(String.format("%d",Math.round(tip25)));
        t15.setText(String.format("%d",Math.round(total15)));
        t20.setText(String.format("%d",Math.round(total20)));
        t25.setText(String.format("%d",Math.round(total25)));


    }

}