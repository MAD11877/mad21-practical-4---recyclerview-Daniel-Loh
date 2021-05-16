package sg.edu.np.practical3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomAdaptor extends RecyclerView.Adapter<CustomViewHolder> {
    ArrayList<User> list_users;

    public CustomAdaptor(ArrayList<User> input) {
        this.list_users = input;
    }

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlayout, parent, false);
        return new CustomViewHolder(item);
    }

    public void onBindViewHolder (CustomViewHolder holder, int position) {
        User list_items = list_users.get(position);
        holder.txt1.setText(list_items.name);
        holder.txt2.setText(list_items.Description);
        holder.image.setImageResource(R.mipmap.ic_launcher_round);

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());
                builder.setTitle("Profile");
                builder.setMessage(list_items.name);
                builder.setCancelable(false);
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        String nameholder = list_items.name;
                        Intent intent = new Intent(v.getContext(), MainActivity.class);
                        intent.putExtra("name",list_items.name);
                        intent.putExtra("Desc",list_items.Description);
                        intent.putExtra("Follow", list_items.followed);
                        v.getContext().startActivity(intent);

                        //v.getContext().startActivity(new Intent(v.getContext(), MainActivity.class));
                        //Bundle extra = v.put


                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
    public  int getItemCount() {
        return list_users.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(0);
    }


}
