package co.mobile.dejavu.mvpnasaviewandroid.getApodNasa.InterfacesAPI;

import co.mobile.dejavu.mvpnasaviewandroid.getApodNasa.Model.Apod;
import retrofit2.Call;
import retrofit2.http.GET;

public interface INasaApi {
    @GET("apod?api_key=rN5QMwCgflEw9ZXqCj5F6hjiETKUflRCbPruiv1Z")
    Call<Apod> getApod();
}