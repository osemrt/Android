package ce.yildiz.edu.tr.recyclerview.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import ce.yildiz.edu.tr.recyclerview.R;
import ce.yildiz.edu.tr.recyclerview.models.Monster;

public class MonsterAdapter extends RecyclerView.Adapter<MonsterAdapter.ViewHolder> {

    private List<Monster> monsterList;
    private Context context;

    public MonsterAdapter(Context context, List<Monster> monsterList) {
        this.context = context;
        this.monsterList = monsterList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView name;
        private TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            name = (TextView) itemView.findViewById(R.id.name_textView);
            description = (TextView) itemView.findViewById(R.id.description_textView);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_monster_list_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Monster monster = monsterList.get(position);

        // Set the name and description of the monster
        holder.name.setText(monster.getName());
        holder.description.setText(monster.getDescription());

        // Set the image
        Glide.with(context)
                .load(monster.getImageUrl())
                .override(200, 200)
                .placeholder(R.drawable.monster_placeholder)
                .error(R.drawable.monster_error)
                .centerCrop()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return monsterList.size();
    }

}
