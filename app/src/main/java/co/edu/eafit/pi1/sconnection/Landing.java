package co.edu.eafit.pi1.sconnection;

import android.app.AlertDialog;
import android.content.Intent;
import android.sax.StartElementListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.eafit.pi1.sconnection.Connection.RegisterConnection;

public class Landing extends AppCompatActivity {

    EditText uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        uname = (EditText)findViewById(R.id.editText_username);
    }

    public void userClick(View view){
        RegisterConnection con = new RegisterConnection();
        StringBuffer params = new StringBuffer();
        String type = "";

        params.append("?login=true&name=");
        params.append(uname.getText().toString());

        try {
            type = con.sendGet(params.toString());
        } catch (Exception e){e.printStackTrace();}

        if(type.equals("user")){
            Intent i = new Intent(this, User.class);
            startActivity(i);
        }

    }

    public void providerClick(View view){
        Intent i = new Intent(this, Provider.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_landing, menu);
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
