package view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.durak_od.R;

import java.util.List;

import adapter.GameAdapter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import model.Game;
import model.GameC;
import retrofit.ApiService;
import retrofit.RetrofitClient;
import retrofit2.Retrofit;

public class OpenGamesFragment extends Fragment {

    ApiService apiService;
    RecyclerView recycler_posts;
    CompositeDisposable disposable = new CompositeDisposable();
    String TAG = "OpenGamesFragment ";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_open_games,container,false);

        Retrofit retrofit = RetrofitClient.getRetrofitInstance();
        apiService = retrofit.create(ApiService.class);
        recycler_posts = v.findViewById(R.id.recyclerView_open);

        recycler_posts.setHasFixedSize(true);
        recycler_posts.setLayoutManager(new LinearLayoutManager(v.getContext()));

        Log.e(TAG, "onCreateView: RECYCLER VIEW DONE" );
        fetchData();
        Log.e(TAG, "onCreateView: FETCH DONE" );

        return v;
    }

    private void fetchData() {
        disposable.add(apiService.getGame().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<Game>>() {
            @Override
            public void accept(List<Game> games) throws Exception {
                displayGames(games);
            }
        }));
    }

    private void displayGames(List<Game> games) {
        GameAdapter adapter = new GameAdapter(games,getContext());
        recycler_posts.setAdapter(adapter);
        Log.e(TAG, "displayGames: ADAPTER SET" );
    }

    @Override
    public void onStop() {
        disposable.clear();
        super.onStop();
    }
}
