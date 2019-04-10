package co.mobile.dejavu.mvpnasaviewandroid.UI.getApodNasa;

import co.mobile.dejavu.mvpnasaviewandroid.Domain.Models.Apod;

public class GetApodNasaPresenter implements IGetApodNasaContract.IPresenter ,IGetApodNasaContract.CompleteListener{

    private IGetApodNasaContract.IView view;
    private IGetApodNasaContract.IInteractor interactor;

    public GetApodNasaPresenter(IGetApodNasaContract.IView view) {
        this.view = view;
        this.interactor= new GetApodNasaModel(this);
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
