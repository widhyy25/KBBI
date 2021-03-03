package dashboard.example.com.kbbi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("kbbi")
    Call<Kamus> getKamusSaya(@Query("text") String a);

}