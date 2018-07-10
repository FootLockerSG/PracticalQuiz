package sg.edu.rp.c346.practicalquiz;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name2;
    EditText age2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name2 = findViewById(R.id.editText);
        age2 = findViewById(R.id.editText2);

        age2.setText("");


    }

    @Override
    protected void onPause() {
        super.onPause();


            String name1 = name2.getText().toString();
            String age1 = age2.getText().toString();
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor prefEdit = prefs.edit();
            prefEdit.putString("name",name1);
            if("".equals(age1)) {
                prefEdit.putString("ageS","1");
            }
            else {
                prefEdit.putInt("age",Integer.parseInt(age1));

            }
            prefEdit.commit();





    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String msg = prefs.getString("name","");
        Integer msg1 = prefs.getInt("ageS",0);
        String msg2 = prefs.getString("age","");

        if("1".equals(msg2)) {
            name2.setText(msg);
            age2.setText(msg1.toString());
        }
        else {
            name2.setText(msg);
            age2.setText(msg2);
        }


    }
}
