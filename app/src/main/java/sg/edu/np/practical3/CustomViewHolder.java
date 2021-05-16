package sg.edu.np.practical3;

import android.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomViewHolder extends RecyclerView.ViewHolder {
    TextView txt1;
    TextView txt2;
    ImageView image;

    public CustomViewHolder(View itemView){
        super(itemView);
        txt1 = itemView.findViewById(R.id.textView3);
        txt2 = itemView.findViewById(R.id.textView4);
        image = itemView.findViewById(R.id.imageView);
    }

}
