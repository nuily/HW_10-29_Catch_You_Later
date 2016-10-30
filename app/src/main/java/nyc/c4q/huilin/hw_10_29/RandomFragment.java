package nyc.c4q.huilin.hw_10_29;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by huilin on 10/29/16.
 */

public class RandomFragment extends Fragment {
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.msg_layout, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.fragment_rv);

        // improve performance; changes in content will not change layout size
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));

        mRecyclerView.setAdapter(new MessagesAdapter());
        return v;
    }
}
