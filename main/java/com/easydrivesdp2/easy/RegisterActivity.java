package com.easydrivesdp2.easy;

        import android.os.Bundle;

        import android.content.Intent;
        import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.support.v7.app.ActionBarActivity;
        import android.support.v7.app.AppCompatActivity;
        import android.text.Html;
        import android.view.View;
        import android.view.WindowManager;
        import android.widget.Button;
        import android.widget.EditText;


public class RegisterActivity extends AppCompatActivity {
    EditText email, pass, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resistor);

        Button button= (Button) findViewById(R.id.btn_signup);
        Button button1= (Button) findViewById(R.id.btnLinkToLoginScreen);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Register(v);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent a= new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(a);
            }
        });

        name = (EditText) findViewById(R.id.id);
        pass = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);

/*
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#e12929'>Sign Up</font>"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
*/

    }
    //When Button Sign up clicked
    public void Register(View v){
    if (CheckFieldValidation()) {
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
    }
    }

    //checking field are empty
    private boolean CheckFieldValidation(){

        boolean valid=true;
        if(name.getText().toString().equals("")){
            name.setError(getString(R.string.text1));
            valid=false;
        }else if(pass.getText().toString().equals("")){
            pass.setError(getString(R.string.text1));
            valid=false;
        }else if(email.getText().toString().equals("")){
            email.setError(getString(R.string.text1));
            valid=false;
        }

        return valid;

    }
}