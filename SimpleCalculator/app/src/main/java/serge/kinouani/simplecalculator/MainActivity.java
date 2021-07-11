package serge.kinouani.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText display1;
    EditText display2;
    TextView display3;

    Button addition,multiplication,substraction,division;
    float value1;
    float value2;
    float result;
   // boolean add,multiply,divide,susbtract;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display1 = findViewById(R.id.first);
        display2 = findViewById(R.id.second);
        display3 = findViewById(R.id.results);

    }

    public void addition (View v){
        String oldString = display1.getText().toString();
         value1 = Float.parseFloat(oldString);
        oldString = display2.getText().toString();
         value2 = Float.parseFloat(oldString);
         result = value1+ value2;
        display3.setText("Result: "+result);
    }
    public void substraction(View v){
        String oldString = display1.getText().toString();
         value1 = Float.parseFloat(oldString);
        oldString = display2.getText().toString();
         value2 = Float.parseFloat(oldString);
         result = value1 - value2;
        display3.setText("Result: "+result);
    }
    public void multiplication(View v){
        String oldString = display1.getText().toString();
         value1 = Float.parseFloat(oldString);
        oldString = display2.getText().toString();
         value2 = Float.parseFloat(oldString);
         result = value1 * value2;
        display3.setText("Result: "+result);
    }
    public void division(View v){
        String oldString = display1.getText().toString();
        value1 = Float.parseFloat(oldString);
        oldString = display2.getText().toString();
         value2 = Float.parseFloat(oldString);
        if(value2 == 0.0){
            Toast.makeText(MainActivity.this,
                    "Cannot divide by 0",
                    Toast.LENGTH_LONG).show();
            return;
        }

         result = value1/value2;
        display3.setText("Result: "+result);
    }
}