package nyc.c4q.huilin.hw_10_29;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

/**
 * Created by huilin on 10/26/16.
 */
public class MessagesAdapter extends RecyclerView.Adapter<MessagesVH> {

    private final List<Messages> original = Arrays.asList(
            new Messages("I’m swamped right now but I will get back to you. Please give me a few days to compose a thoughtful response."),
            new Messages("Taking off my eyes off the road for more than 2 seconds doubles my risk of a crash. I'll text you back later."),
            new Messages("Ignore this message for the first 2 days but if you're still getting this on the 3rd day, please call the cops!"),
            new Messages("Too busy screaming over my dramas/shows to hear my phone... wait for me to return to reality."),
            new Messages("Taking a break from this $$$$ distraction... call me if it's something serious. SRSLY SERIOUS."),
            new Messages("Message me on FB/Hangouts/Skype/AIM (JK WHO STILL USES AIM!)"),
            new Messages("I am unavailable because I am playing a game that takes up the entire screen."),
            new Messages("You rarely have time for everything you want in this life, so you need to make choices. And hopefully your choices can come from a deep sense of who you are.")
    );

    @Override
    public MessagesVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessagesVH(parent);
    }

    @Override
    public void onBindViewHolder(MessagesVH holder, int position) {
        Messages message = original.get(position);
        holder.bind(message);
        holder.setOnClickListener(buildMessageClickListener(message));

    }

    private View.OnClickListener buildMessageClickListener(Messages message) {
        if (message != null) {
            return navigateToMsgViewListener(message.getMessage());
        }
        return defaultClickListener();
    }

    // To avoid application crashing
    private View.OnClickListener defaultClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Toast the bread", Toast.LENGTH_SHORT).show();
            }
        };
    }

    /**
     * This click listener launches an intent with the original message contents as an extra
     * @param originalMsg
     * @return
     */

    private View.OnClickListener navigateToMsgViewListener(final String originalMsg) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MessageEditView.class);
                intent.putExtra(MessageEditView.MSG_CONTENT, originalMsg);
                view.getContext().startActivity(intent);
            }
        };
    }

    @Override
    public int getItemCount() {
        return original.size();
    }
}
