package com.solfashop.API.Interfaces;
import com.solfashop.model.DetailOrder;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ratri on 10/21/2016.
 */
public interface DetailorderService {
    @GET("detail_order.php")
    Call<List<DetailOrder>> getDetailOrder(@Query("user" ) String iduser);
}
