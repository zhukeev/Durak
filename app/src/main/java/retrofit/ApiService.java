package retrofit;

import java.util.List;

import io.reactivex.Observable;
import model.Game;
import retrofit2.http.GET;

public interface ApiService {

    @GET("users")
    Observable<List<Game>> getGame();
}
