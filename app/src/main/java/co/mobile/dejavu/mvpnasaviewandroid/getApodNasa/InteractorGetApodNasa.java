package co.mobile.dejavu.mvpnasaviewandroid.getApodNasa;


import co.mobile.dejavu.mvpnasaviewandroid.getApodNasa.InterfacesAPI.INasaApi;
import co.mobile.dejavu.mvpnasaviewandroid.getApodNasa.Model.Apod;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InteractorGetApodNasa implements  IGetApodNasaContract.IInteractor{

    private IGetApodNasaContract.CompleteListener listener;
    private Retrofit retrofit;


    public InteractorGetApodNasa(IGetApodNasaContract.CompleteListener listener) {
        this.listener = listener;
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.nasa.gov/planetary/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Override
    public void getApodNasa() {

        INasaApi nasaApi = retrofit.create(INasaApi.class);
        Call<Apod> call = nasaApi.getApod();
        call.enqueue(new Callback<Apod>() {
            @Override
            public void onResponse(Call<Apod> call, Response<Apod> response) {
                if(!response.isSuccessful()){
                    listener.onError(response.message());
                }else{
                    listener.onSuccess(response.body());
                }
            }
            @Override
            public void onFailure(Call<Apod> call, Throwable t) {
                listener.onError(t.getMessage());

            }
        });

    }
}
