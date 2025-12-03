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
    public boolean onCreateOptionsMenu (Menu menu)
    {

        getMenuInflater () .inflate (R.menu.main,menu);

        return super.onCreateOptionsMenu (menu);
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
        if(isValidInput())
        {
            num1 = Double.parseDouble(str1);
            num2 = Double.parseDouble(str2);

            if (st.equals("+"))
            {

                res = num1 + num2;

            }
            else if (st.equals("-"))
            {

                res = num1 - num2;

            }
            else if (st.equals("*"))
            {
                res = num1 * num2;
            }
            else if (st.equals("/"))
            {
                res = num1 / num2;
            }

        }
        tvResult.setText(String.valueOf(res));
        return super.onOptionsItemSelected(item);
    }
    public boolean isValidInput()
    {
        String str1 = etNum1.getText().toString();
        String str2 = etNum2.getText().toString();

        if (str1.isEmpty())
        {
            return false;
        }
        if (str2.isEmpty())
        {
            return false;
        }
        try
        {
            Double.parseDouble(str1);
            Double.parseDouble(str2);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }
}

