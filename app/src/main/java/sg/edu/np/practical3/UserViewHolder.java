package sg.edu.np.practical3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder{
    TextView txt, txtx;
    ImageView imgview, bigImg;
    public UserViewHolder(View itemView){
        super(itemView);
        txt = itemView.findViewById(R.id.profilename);
        txtx = itemView.findViewById(R.id.profiledescription);
        imgview = itemView.findViewById(R.id.profilepic);
        bigImg = itemView.findViewById(R.id.bigprofilepic);
    }
}
