package nyc.c4q.huilin.hw_10_29;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

/**
 * Created by huilin on 10/29/16.
 */
public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private final List<MainCategories> categories = Arrays.asList(
            new MainCategories("Random"),
            new MainCategories("Professional"),
            new MainCategories("NSFW"),
            new MainCategories("Quotes"),
            new MainCategories("Family-Oriented"),
            new MainCategories("AIM Away Messages"),
            new MainCategories("Join me in this [activity]"),
            new MainCategories("Current Locations")
    );

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        MainCategories categoryName = categories.get(position);
        holder.bind(categoryName);
        holder.setOnClickListener(buildMessageClickListener(categoryName));
    }

    private View.OnClickListener buildMessageClickListener(MainCategories categoryName) {
        if (categoryName != null) {
            return navigateToCategoryClickListener(categoryName.getmCategory());
        }
        return defaultClickListener();
    }

    private View.OnClickListener navigateToCategoryClickListener(final String category) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MessagesView.class);
                intent.putExtra(MainActivity.CATEGORY_NAME, category);
                view.getContext().startActivity(intent);
            }
        };
    }

    private static View.OnClickListener defaultClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Grab a slice of bread", Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}
