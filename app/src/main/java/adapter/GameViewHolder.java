package adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.durak_od.R;

public class GameViewHolder extends RecyclerView.ViewHolder {

    ImageView imageViewLock,imageViewSpeed,imageViewButton;
    TextView textViewMoney,textViewPlayers, textViewRoomName;
    public GameViewHolder(@NonNull View itemView) {
        super(itemView);

        imageViewButton = itemView.findViewById(R.id.card_item_open_button_IV);
        imageViewSpeed = itemView.findViewById(R.id.card_item_speed_IV);
        imageViewLock = itemView.findViewById(R.id.card_item_lock_IV);
        textViewMoney = itemView.findViewById(R.id.card_item_money_TV);
        textViewPlayers = itemView.findViewById(R.id.card_item_players_TV);
        textViewRoomName = itemView.findViewById(R.id.card_item_room_name);
    }
}
