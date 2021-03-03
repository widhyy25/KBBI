package dashboard.example.com.kbbi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static final String BASE_URL="https://kbbi-api-zhirrr.vercel.app/api/";
    static Retrofit retrofit;
    public static Retrofit ambilData(){
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
