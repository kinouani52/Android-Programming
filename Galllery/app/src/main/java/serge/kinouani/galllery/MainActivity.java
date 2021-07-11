package serge.kinouani.galllery;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=findViewById(R.id.name_field);
        Password=findViewById(R.id.password_field);
        Login=findViewById(R.id.Login_button);

        Login.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if(Objects.equals(Name.getText().toString(), "admin")&&Objects.equals(Password.getText().toString(),"admin"))
                {
                    Intent intent = new Intent(MainActivity.this, serge.kinouani.galllery.secondActivity.class);
                    startActivity(intent);
                }
                else {


                    Toast.makeText(MainActivity.this,"Authentication Failed", Toast.LENGTH_LONG).show();
                }


            }
        });
}
}