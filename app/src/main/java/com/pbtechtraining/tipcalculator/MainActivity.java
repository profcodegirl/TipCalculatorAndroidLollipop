package com.pbtechtraining.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity {

    private double billTotal = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button calcButton = (Button)findViewById(R.id.btnCalculate);
        final Spinner tipSpinner = (Spinner)findViewById(R.id.tipSpinner);
        final EditText txtAmount = (EditText)findViewById(R.id.txtAmount);
        final TextView txtTip = (TextView)findViewById(R.id.txtTip);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                billTotal = Double.parseDouble(tipSpinner.getSelectedItem().toString())/100 *
                        Double.parseDouble(txtAmount.getText().toString());
                DecimalFormat df = new DecimalFormat("#.00");
                txtTip.setText("$"+df.format(billTotal));
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
