package nyc.c4q.huilin.hw_10_29;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by huilin on 10/26/16.
 */
public class MessagesVH extends RecyclerView.ViewHolder {
    private final TextView messageV;
    private final View mView;

    public MessagesVH(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        messageV = (TextView) itemView.findViewById(R.id.messageStage);
        }

    private static View inflateView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

    }

    public void bind(Messages message) {
        messageV.setText(message.getMessage());
    }

    public void setOnClickListener(View.OnClickListener clickListener) {
        mView.setOnClickListener(clickListener);
    }
}

