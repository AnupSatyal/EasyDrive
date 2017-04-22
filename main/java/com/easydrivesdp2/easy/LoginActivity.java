package com.easydrivesdp2.easy;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.ActionBarActivity;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

        import android.content.Intent;
        import android.view.Menu;
        import android.view.View;
        import android.widget.AutoCompleteTextView;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;




public class LoginActivity extends ActionBarActivity {

    DatabaseHelper helper = new DatabaseHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }


    public void onButtonClick(View v) {
        if (v.getId() == R.id.Blogin) {
            EditText a = (EditText) findViewById(R.id.TFname);
            String str = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.TFpass1);
            String pass = b.getText().toString();


            String password = helper.searchPass(str);
            if (pass.equals(password)) {


                Intent i = new Intent(LoginActivity.this, Welcome.class);
                i.putExtra("name", str);
                startActivity(i);


            } else {
                Toast temp = Toast.makeText(LoginActivity.this, "Name and Password don't match!", Toast.LENGTH_SHORT);
                temp.show();
            }


        }
        if (v.getId() == R.id.Bsignup) {
            Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(i);
        }


    }
    @Override
    public void onBackPressed() {
        Intent i= new Intent(LoginActivity.this,LanguageActivity.class);
        startActivity(i);

}
    }


