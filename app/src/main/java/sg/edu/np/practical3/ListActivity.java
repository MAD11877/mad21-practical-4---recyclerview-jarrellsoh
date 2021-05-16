package sg.edu.np.practical3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import java.util.Random;
import java.util.ArrayList;


public class ListActivity extends AppCompatActivity {

    static ArrayList<User> UserList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list);

        //ImageView image = findViewById(R.id.profilepic);
        //image.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v){
        //       showAlertDialog(v);

        //    }
        //});
        for(int i = 0; i<20; i++){
            int j = new Random().nextInt();
            int k = new Random().nextInt();
            boolean test = true;
            if(j%2 != 0){
                test = false;
            }
            User user = new User();
            user.name = "Name-" + j;
            user.description = "Description " + k;
            user.id = i;
            user.followed = test;
            UserList.add(user);
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        UserAdapter uAdapter = new UserAdapter(UserList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(uAdapter);
    }
    public void showAlertDialog(View v) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Profile");
        alert.setMessage("MADness");
        alert.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.setPositiveButton("VIEW", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent toMain = new Intent(ListActivity.this, MainActivity.class);

                Random id = new Random();
                toMain.putExtra("id", String.valueOf(id.nextInt()));
                startActivity(toMain);
            }
        });
        alert.create().show();
    }
}