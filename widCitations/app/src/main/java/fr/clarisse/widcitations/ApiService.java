package fr.clarisse.widcitations;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/citations")
    Call<List<Citation>> getCitations();
}
