package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        loadProfile();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveProfile();

    }

    public void loadProfile(){
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String name = preferences.getString("nameKey","");
        String status = preferences.getString("statusKey", "");

        TextView nameTextView = (TextView) findViewById(R.id.name_textview);
        TextView statusTextView = (TextView) findViewById(R.id.status_textview);

        nameTextView.setText(name);
        statusTextView.setText(status);


    }

    public void saveProfile() {
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        TextView nameView = findViewById(R.id.name_textview);
        editor.putString("nameKey", nameView.getText().toString());

        TextView statusView = findViewById(R.id.status_textview);
        editor.putString("statusKey", statusView.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        editor.apply();
    }

    public void onLaunchProfileClicked(View view) {
        saveProfile();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onExitClicked(View view) {
        finish();
    }
}