package sg.edu.np.practical3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    ArrayList<User> myList = new ArrayList<>();

    public interface OnItemClickListener{
        void onItemClick(ImageView item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_list);

        ImageView image = findViewById(R.id.imageView);

        ArrayList<User> myList = new ArrayList<>();
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("How do you make an octopus laugh? \n\nYou give it ten-tickles.");
                builder.setCancelable(true);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int image) {
                        dialog.cancel();
                        Intent view = new Intent(ListActivity.this, MainActivity.class);
                        Random ran = new Random();
                        int ranval = ran.nextInt(1000000000);
                        view.putExtra("random", ranval);
                        startActivity(view);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int image) {
                        dialog.cancel();

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });*/

        //Create a List of 20 User objects in the ListActivity. Randomize the name, descriptions
        // and value of followed
        setContentView(R.layout.activity_list);
        boolean follow;
        for (int i = 0; i < 20; i++) {
            Random ran = new Random();
            int ranuser = ran.nextInt();
            int randesc = ran.nextInt();
            int ranfollow = ran.nextInt();

            if (ranfollow % 2 == 1) {
                follow = true;
            } else {
                follow = false;
            }
            User user = new User(1, "Name" + ranuser, "Description" + randesc, ranuser, follow);
            myList.add(user);
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerviewer);
        CustomAdaptor cAdaptor = new CustomAdaptor(myList);
        LinearLayoutManager cLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(cLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(cAdaptor);


    }
}
