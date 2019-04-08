package co.mobile.dejavu.mvpnasaviewandroid.getApodNasa;

import co.mobile.dejavu.mvpnasaviewandroid.getApodNasa.Model.Apod;

public class PresenterGetApodNasa implements IGetApodNasaContract.IPresenter {

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
            Apod apod = interactor.getApodNasa();
            if(apod != null){
                view.displayApodNasa(apod);
            }else{

            }
            view.displayLoader(false);

        }

    }


}
