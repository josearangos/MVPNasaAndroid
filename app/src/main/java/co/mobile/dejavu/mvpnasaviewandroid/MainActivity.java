package co.mobile.dejavu.mvpnasaviewandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import co.mobile.dejavu.mvpnasaviewandroid.getApodNasa.IGetApodNasaContract;
import co.mobile.dejavu.mvpnasaviewandroid.getApodNasa.Model.Apod;
import co.mobile.dejavu.mvpnasaviewandroid.getApodNasa.PresenterGetApodNasa;

public class MainActivity extends AppCompatActivity implements IGetApodNasaContract.IView {


    private  IGetApodNasaContract.IPresenter presenter;
    private TextView copyright;
    private ImageView imageView;
    private TextView date;
    private TextView explanation;
    private TextView title;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
        presenter= new PresenterGetApodNasa(this);
        presenter.getApodNasa();
    }


    @Override
    public void initializeView() {
        this.progressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.title = (TextView) findViewById(R.id.title);
        this.explanation = (TextView) findViewById(R.id.explanation);
        this.date = (TextView) findViewById(R.id.date);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.copyright = (TextView) findViewById(R.id.copyright);
    }


    @Override
    public void displayApodNasa(Apod apod) {

        title.setText(apod.getTitle());
        explanation.setText(apod.getExplanation());
        date.setText(apod.getDate());
        copyright.setText(apod.getCopyright());

        Glide
            .with(getApplicationContext())
            .load(apod.getUrl())
            .centerCrop()
            .into(imageView);
    }


    @Override
    public void displayLoader(boolean loader) {
        if(loader){
            progressBar.setVisibility(View.VISIBLE);
        }else{
            progressBar.setVisibility(View.GONE);
        }

    }
}
