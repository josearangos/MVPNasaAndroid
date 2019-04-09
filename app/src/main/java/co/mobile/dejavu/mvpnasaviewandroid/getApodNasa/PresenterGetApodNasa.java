package co.mobile.dejavu.mvpnasaviewandroid.getApodNasa;

import co.mobile.dejavu.mvpnasaviewandroid.getApodNasa.Model.Apod;

public class PresenterGetApodNasa implements IGetApodNasaContract.IPresenter ,IGetApodNasaContract.CompleteListener{

    private IGetApodNasaContract.IView view;
    private IGetApodNasaContract.IInteractor interactor;

    public PresenterGetApodNasa(IGetApodNasaContract.IView view) {
        this.view = view;
        this.interactor= new InteractorGetApodNasa(this);
    }

    @Override
    public void onDestroy() {
        view =null;
    }

    @Override
    public void getApodNasa() {
        if(view != null) {
            view.displayLoader(true);
            interactor.getApodNasa();
         }
    }

    @Override
    public void onSuccess(Apod apod) {
        view.displayLoader(false);
        view.displayApodNasa(apod);
    }

    @Override
    public void onError(String error) {
        view.displayLoader(false);
        view.displayError(error);


    }
}
