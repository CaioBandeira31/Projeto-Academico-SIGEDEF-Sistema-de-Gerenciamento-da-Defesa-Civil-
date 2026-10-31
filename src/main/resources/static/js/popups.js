// POPUP NOVO ALERTA
function novoAlerta() {
    document.getElementById("caixa-form-gerar-alerta").style.display = "flex";
    document.getElementsByClassName("form-overlay")[0].style.display = "flex";
}

function cancelarAlerta() {

    document.querySelectorAll("#caixa-form-gerar-alerta input, #caixa-form-gerar-alerta textarea").forEach(input => {
        input.value = "";
    });

    

    document.getElementById("caixa-form-gerar-alerta").style.display = "none";
    document.getElementsByClassName("form-overlay")[0].style.display = "none";
}
// /////////////////////////////////////////////////
