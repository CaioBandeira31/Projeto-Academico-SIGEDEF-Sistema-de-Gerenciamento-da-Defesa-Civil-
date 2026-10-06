package edu.sistema.sigedef;

import java.util.List;

public class Previsao {
    private List<DiaPrevisao> dias;

    public Previsao(){

    }

    public Previsao(List<DiaPrevisao> dias){
        this.dias = dias;
    }

    public List<DiaPrevisao> getDias() {
        return dias;
    }

    public void setDias(List<DiaPrevisao> dias) {
        this.dias = dias;
    }
}
