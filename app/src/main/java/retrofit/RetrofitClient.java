package retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    final static String ROOT_URL = "https://jsonplaceholder.typicode.com/";

    private static Retrofit instance;

    public static Retrofit getRetrofitInstance(){
        if (instance ==null)
            instance = new Retrofit.Builder()
                    .baseUrl(ROOT_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

         return instance;
    }

    private RetrofitClient() {
    }
}
