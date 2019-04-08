package co.mobile.dejavu.mvpnasaviewandroid.getApodNasa;


import co.mobile.dejavu.mvpnasaviewandroid.getApodNasa.Model.Apod;

public class InteractorGetApodNasa implements  IGetApodNasaContract.IInteractor{

    private IGetApodNasaContract.IPresenter presenter;

    public InteractorGetApodNasa(IGetApodNasaContract.IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Apod getApodNasa() {

        return new Apod();
    }
}
