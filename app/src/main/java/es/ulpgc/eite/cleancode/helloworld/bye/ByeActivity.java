package es.ulpgc.eite.cleancode.helloworld.bye;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.cleancode.helloworld.R;
import es.ulpgc.eite.cleancode.helloworld.hello.HelloActivity;


public class ByeActivity
    extends AppCompatActivity implements ByeContract.View {

  public static String TAG = ByeActivity.class.getSimpleName();


  ByeContract.Presenter presenter;

  Button sayByeButton, goHelloButton;
  TextView byeMessage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bye);

    getSupportActionBar().setTitle(R.string.bye_screen_title);

    sayByeButton = findViewById(R.id.sayHelloButton);
    goHelloButton = findViewById(R.id.goByeButton);
    byeMessage = findViewById(R.id.helloMessage);

    sayByeButton.setOnClickListener(v -> presenter.sayByeButtonClicked());

    goHelloButton.setOnClickListener(v -> presenter.goHelloButtonClicked());

    sayByeButton.setText(getSayByeButtonLabel());
    goHelloButton.setText(getGoHelloButtonLabel());

    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

    // do the setup
    ByeScreen.configure(this);

  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.onResumeCalled();
  }

  @Override
  public void displayByeData(ByeViewModel viewModel) {
    Log.e(TAG, "displayByeData()");

    // deal with the data
    byeMessage.setText(viewModel.byeMessage);
  }


  private String getGoHelloButtonLabel() {
    return getResources().getString(R.string.say_bye_button_label);
  }

  private String getSayByeButtonLabel() {
    return getResources().getString(R.string.say_bye_button_label);
  }

  @Override
  public void injectPresenter(ByeContract.Presenter presenter) {
    this.presenter = presenter;
  }


}
