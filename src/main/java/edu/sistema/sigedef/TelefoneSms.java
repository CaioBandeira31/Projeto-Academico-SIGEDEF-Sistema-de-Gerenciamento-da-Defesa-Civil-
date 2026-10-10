package edu.sistema.sigedef;
import java.util.Random;



public class TelefoneSms {
  
  private int id_telefone;
  private String num_telefone;

  public TelefoneSms( String num_telefone) {
    this.num_telefone = num_telefone;
  }

  protected TelefoneSms(){}

  public int getId_telefone() {
    return id_telefone;
  }
  
  public void setId_Telefone(int id_telefone) {
    this.id_telefone = id_telefone;
  }

  public String getNum_Telefone() {
    return num_telefone;
  }

  public void setNum_Telefone(String num_telefone) {
    this.num_telefone = num_telefone;
  }

  public int[] gerarCodigo() {
    Random rand = new Random();
    int num_sms;
    int[] sms = new int[5];

    for (int i = 0; i < sms.length; i++) {
      num_sms = rand.nextInt(9);
      sms[i] = num_sms;
    } 

    return sms;
  }
}
