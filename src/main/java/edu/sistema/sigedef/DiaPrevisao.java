package edu.sistema.sigedef;

public class DiaPrevisao {
    private String dia;
    private int max;
    private int min;
    private String condicao;


    protected  DiaPrevisao(){
    }

    public DiaPrevisao(String dia, int max, int min, String condicao){
        this.dia = dia;
        this.max = max;
        this.min = min;
        this.condicao = condicao;
    }

    public String getCondicao() {
        return condicao;
    }
    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public String getDia() {
        return dia;
    }
    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getMax() {
        return max;
    }
    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }
    public void setMin(int min) {
        this.min = min;
    }
}
