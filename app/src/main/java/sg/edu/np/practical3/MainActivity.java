package sg.edu.np.practical3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "On Create!");

        // Identifying Widgets
        Button button = findViewById(R.id.button);  // Identify button (Follow)
        Button button2 = findViewById(R.id.button2);  // Identify button2 (Message)
        TextView textView = findViewById(R.id.textView); // Identify TextView (Name)
        TextView textView2 = findViewById(R.id.textView2); // Identify TextView (Description)

        Intent receiveData = getIntent();

        User user = new User(R.mipmap.ic_launcher_round,"Random Octopus","Octopuses have 3 hearts, because two pump blood to the gills and a larger heart circulates blood to the rest of the body. Octopuses have 9 brains because, in addition to the central brain, each of 8 arms has a mini-brain that allows it to act independently.", 0, false);

        //user.id = receiveData.getIntExtra("random", 0);
        // Receieve Data from listUser
        user.name = receiveData.getStringExtra("name");
        user.Description = receiveData.getStringExtra("Desc");
        user.followed = receiveData.getBooleanExtra("Follow", false);

        // Initialize name and description texts from the User object
        textView.setText(user.name);
        textView2.setText(user.Description);

        //  initialize Button Text based on Followed Bool
        if (user.followed == true){
            button.setText("Unfollow");
        }
        else {
            button.setText("Follow");
        }

        // Change the button text after clicking and update the bool
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.followed == true) {
                    button.setText("Follow");
                    user.setFollowed(false);
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
                else {
                    button.setText("Unfollow");
                    user.setFollowed(true);
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("follow", user.followed);
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG, "On Start!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v(TAG, "On Resume!");
    }

    @Override
    protected void  onPause(){
        super.onPause();
        Log.v(TAG, "On Pause!");

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.v(TAG, "On Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "On Destroy");
    }
}