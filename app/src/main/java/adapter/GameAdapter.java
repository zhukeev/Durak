package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.durak_od.R;

import java.util.List;

import model.Game;
import model.GameC;

public class GameAdapter extends RecyclerView.Adapter<GameViewHolder> {
    List<Game> cardsList;
    Context context;

    public GameAdapter(List<Game> cardsList, Context context) {
        this.cardsList = cardsList;
        this.context = context;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);


        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
//        String cur = String.valueOf( cardsList.get(position).getCurrentPlayerCount());
//        String max = String.valueOf( cardsList.get(position).getMaxPlayerCount());
        holder.textViewPlayers.setText(cardsList.get(position).getName().substring(0,3));
        holder.textViewMoney.setText(cardsList.get(position).getPhone().substring(0,3));
        holder.textViewRoomName.setText(cardsList.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return cardsList.size();
    }
}
