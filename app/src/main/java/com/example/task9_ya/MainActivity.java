package com.example.task9_ya;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity
{
    private EditText etNum1;
    private EditText etNum2;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1 = findViewById(R.id.editNum1);
        etNum2 = findViewById(R.id.editNum2);
        tvResult = findViewById(R.id.viewResult);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        String st = item.getTitle().toString();
        String str1 = etNum1.getText().toString();
        String str2 = etNum2.getText().toString();
        double num1 = 0;
        double num2 = 0;
        double res = 0;

        if (st.equals("C"))
        {
            etNum1.setText("");
            etNum2.setText("");
            tvResult.setText("");
        }
        else
        {
            if (!isValidInput())
            {
                return true;
            }
            else
            {
                num1 = Double.parseDouble(str1);
                num2 = Double.parseDouble(str2);

                if (st.equals("+")) {

                    res = num1 + num2;

                } else if (st.equals("-")) {

                    res = num1 - num2;

                } else if (st.equals("*")) {
                    res = num1 * num2;
                } else if (st.equals("/"))
                {
                    if (num2 == 0)
                    {
                        tvResult.setText("dont do thattt");
                        return true;
                    }
                    res = num1 / num2;
                }
            }
            tvResult.setText(String.valueOf(formatNiceResult(res)));
        }
        return super.onOptionsItemSelected(item);
    }
    public String formatNiceResult(double num) {
        if (num == 0)
        {
            return "0";
        }
        double absVal = Math.abs(num);
        if (absVal >= 10000000 || absVal <= 0.001)
        {
            return String.format("%.3E", num);
        }
        else if (num == (long) num)
        {
            return String.format("%d", (long) num);
        }
        else
        {
            return String.format("%.3f", num);
        }
    }
    public boolean isValidInput()
    {
        String str1 = etNum1.getText().toString();
        String str2 = etNum2.getText().toString();
        if (str1.isEmpty() || str2.isEmpty())
        {
            return false;
        }

        if (str1.equals(".") || str1.equals("-") || str2.equals(".") || str2.equals("-"))
        {
            return false;
        }
        return true;
    }
}

