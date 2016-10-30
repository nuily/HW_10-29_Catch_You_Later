package nyc.c4q.huilin.hw_10_29;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by huilin on 10/29/16.
 */
public class MainViewHolder extends RecyclerView.ViewHolder {
    private TextView mCategory;
    private View mView;

    public MainViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
        mCategory = (TextView) itemView.findViewById(R.id.category_stage);
    }

    private static View inflateView(ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.category_vh, parent, false);

    }

    public void bind(MainCategories mainCategories) {
        mCategory.setText(mainCategories.getmCategory());
    }

    public void setOnClickListener(View.OnClickListener clickListener) {
        mView.setOnClickListener(clickListener);
    }
}
