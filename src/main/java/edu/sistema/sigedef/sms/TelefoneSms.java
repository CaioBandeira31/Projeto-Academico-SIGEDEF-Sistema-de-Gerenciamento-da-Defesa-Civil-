package edu.sistema.sigedef.sms;
import java.util.Random;



public class TelefoneSms {
  
  private int id_telefone;
  private String num_telefone;
  private String codigo;

  public TelefoneSms(  String num_telefone) {
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

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  public String gerarCodigo() {
    Random rand = new Random();
    int num_sms;
    String valor_sms="";

    for (int i = 0; i < 5; i++) {
      num_sms = rand.nextInt(9);
      valor_sms += Integer.toString(num_sms);
    }
    
    setCodigo(valor_sms);
    
    return valor_sms;
  }
}
