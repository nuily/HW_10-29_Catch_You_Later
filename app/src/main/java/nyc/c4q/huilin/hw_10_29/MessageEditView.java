package nyc.c4q.huilin.hw_10_29;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by huilin on 10/28/16.
 */
public class MessageEditView extends AppCompatActivity {
    public static final String MSG_CONTENT = "extra.msg.content";
    private EditText editMsg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_edit);
        String msgContent = getIntent().getStringExtra(MSG_CONTENT);
        editMsg = (EditText) findViewById(R.id.editMsg);
        editMsg.setText(msgContent);
    }
}
