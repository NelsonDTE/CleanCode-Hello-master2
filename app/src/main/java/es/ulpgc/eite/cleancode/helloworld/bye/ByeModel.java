package es.ulpgc.eite.cleancode.helloworld.bye;

public class ByeModel implements ByeContract.Model {

  public static String TAG = ByeModel.class.getSimpleName();

  private String message;

  public ByeModel(String message) {
    this.message = message;
  }

  @Override
  public String getByeMessage() {
    return message;
  }

}
