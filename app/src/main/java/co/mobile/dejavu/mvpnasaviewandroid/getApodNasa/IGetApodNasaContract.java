package co.mobile.dejavu.mvpnasaviewandroid.getApodNasa;

import co.mobile.dejavu.mvpnasaviewandroid.getApodNasa.Model.Apod;

public interface IGetApodNasaContract {


    interface  IView{
        void displayApodNasa(Apod apod);
        void displayLoader(boolean loader);
        void initializeView();
        void displayError(String error);
    }

    interface IPresenter{
        void onDestroy();
        void getApodNasa();
    }

    interface IInteractor{
        void getApodNasa();
    }

    interface CompleteListener {
        void onSuccess(Apod apod);
        void onError(String error);
    }




}
