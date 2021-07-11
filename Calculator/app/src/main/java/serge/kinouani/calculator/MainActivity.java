package serge.kinouani.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
        private EditText displayInput;
       private  EditText displayInput2;
       private   EditText displayOutput;
          Button  butadd,butsubs,butdiv,butmul,butclear,butequal,butdecimal;
          Button but1,but2, but3,but4,but5,but6,but7,but8,but9,but0;

    float ValueIn1, ValueIn2;

    boolean mAddition, mSubtract, mMultiplication, mDivision ;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayInput = findViewById(R.id.first);
        displayInput2= findViewById(R.id.second);
        displayOutput = findViewById(R.id.result);

        displayInput.setShowSoftInputOnFocus(false);
        displayInput2.setShowSoftInputOnFocus(false);



        but1 = findViewById(R.id.oneB);
        but2 = findViewById(R.id.twoB);
        but3 = findViewById(R.id.threeB);
        but4 = findViewById(R.id.fourB);
        but5 = findViewById(R.id.fiveB);
        but6 = findViewById(R.id.sixB);
        but8 = findViewById(R.id.eightB);
        but9 = findViewById(R.id.nineB);
        but0= findViewById(R.id.zeroB);

        butadd = findViewById(R.id.plusB);
        butsubs= findViewById(R.id.substractionB);
        butdiv= findViewById(R.id.divideB);
        butmul=findViewById(R.id.multiplyB);
        butclear=findViewById(R.id.clearB);
        butequal = findViewById(R.id.equalB);
        butdecimal = findViewById(R.id.pointB);
        
        displayInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             displayInput.setText("");
            }
        });
                displayInput2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        displayInput2.setText("");
                    }
                });

               displayOutput.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       displayOutput.setText("");
                   }
               });



    }
    private void textUpdate(String stringAdder) {
        String oldString = displayInput.getText().toString();
        String oldString2 = displayInput2.getText().toString();
        int cursorPosition = displayInput.getSelectionStart();
        int cursorPosition2 = displayInput2.getSelectionStart();
        String left = oldString.substring(cursorPosition);
        String left2 = oldString2.substring(cursorPosition2);
        String right = oldString.substring(cursorPosition);
        String right2 = oldString2.substring(cursorPosition2);
        displayInput.setText(String.format("%S%S%S",left,stringAdder,right));
        displayInput2.setText(String.format("%S%S%S",left2,stringAdder,right2));
        displayInput.setSelection(cursorPosition2+1);
    }

    public void zeroBtn (View view){
  textUpdate("0");
    }

    public void oneBtn (View view){
        textUpdate("1");
    }
    public void twoBtn (View view){
        textUpdate("2");
    }
    public void threeBtn (View view){
        textUpdate("3");
    }
    public void fourBtn (View view){
        textUpdate("4");
    }
    public void fiveBtn (View view){
        textUpdate("5");
    }
    public void sixBtn (View view){
        textUpdate("6");
    }
    public void sevenBtn (View view){
        textUpdate("7");
    }
    public void eightBtn (View view){
        textUpdate("8");
    }
    public void nineBtn (View view){
        textUpdate("9");
    }


    public void addBtn (View view){
        textUpdate("+");
    }
    public void multiplyBtn (View view){
        textUpdate("x");
    }
    public void subsBtn (View view){
        textUpdate("0");
    }
    public void divideBtn (View view){
        textUpdate("÷");
    }
    public void clearBtn (View view){
       displayInput.setText("");
    }
    public void pointBtn (View view){
        textUpdate(".");
    }
    public void equalsBtn (View view){
        textUpdate("=");
    }
}