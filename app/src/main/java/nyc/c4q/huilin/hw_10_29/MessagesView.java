package nyc.c4q.huilin.hw_10_29;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import static nyc.c4q.huilin.hw_10_29.MainActivity.CATEGORY_NAME;

public class MessagesView extends AppCompatActivity {

    private Button setReply;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.msg_layout);
        String categorySelected = getIntent().getStringExtra(CATEGORY_NAME);
        if (categorySelected != null) {
            switch (categorySelected) {
                case "Random":
                    showRandom();
                }

            }
        }

    private void showRandom() {
        getFragmentManager().beginTransaction().add(R.id.specificMsgs, new RandomFragment()).commit();
    }

}