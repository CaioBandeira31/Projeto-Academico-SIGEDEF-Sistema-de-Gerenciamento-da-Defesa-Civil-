//O BRENO DECIDIU FAZER TODO O JAVASCRIPT DA PAGINA DE DENUNCIAS EM UM UNICO ARQUIVO
//CASO DESEJE FAZER DE OUTRA FORMA, CONVERSAR COM O GRUPO



document.addEventListener("DOMContentLoaded", function () {
  // JAVASCRIPT PORCO PARA O MUDAR A SELEÇÃO DOS BOTÕES NO TIPO DE OCORRENCIA
  const ocorrencia1 = document.getElementsByClassName("tipo-ocorrencia")[0]
  const ocorrencia2 = document.getElementsByClassName("tipo-ocorrencia")[1]
  const ocorrencia3 = document.getElementsByClassName("tipo-ocorrencia")[2]
  const ocorrencia4 = document.getElementsByClassName("tipo-ocorrencia")[3]
  const opcao = document.getElementById("opcao-selecionada")

  let cliques = 0;

  ocorrencia1.addEventListener("click", () =>{
    cliques =1;
      if (cliques == 1) {
        opcao.value = "Alagamento";
        ocorrencia1.style.cssText = "transition: 0.3s; background-color: #0b2d4d; color: #ffffff; font-weight: bold;";
      
      ocorrencia2.style.cssText = "transition: 0.3; background-color: #f4f7fa; color: #000000; font-weight: bold;";
      ocorrencia3.style.cssText = "transition: 0.3; background-color: #f4f7fa; color: #000000; font-weight: bold;";
      ocorrencia4.style.cssText = "transition: 0.3; background-color: #f4f7fa; color: #000000; font-weight: bold;";
      }    
  });
  
  ocorrencia2.addEventListener("click", () =>{
    cliques =2;
      if (cliques==2) {
        opcao.value = "Risco de Desmoronamento";
        ocorrencia2.style.cssText = "transition: 0.3s; background-color: #0b2d4d; color: #ffffff; font-weight: bold;";
      
      ocorrencia1.style.cssText = "transition: 0.3; background-color: #f4f7fa; color: #000000; font-weight: bold;";
      ocorrencia3.style.cssText = "transition: 0.3; background-color: #f4f7fa; color: #000000; font-weight: bold;";
      ocorrencia4.style.cssText = "transition: 0.3; background-color: #f4f7fa; color: #000000; font-weight: bold;";  
      }  

  });

  ocorrencia3.addEventListener("click", () =>{
    cliques =3;
      if (cliques==3) {
        opcao.value = "Queda de Árvore";
        ocorrencia3.style.cssText = "transition: 0.3s; background-color: #0b2d4d; color: #ffffff; font-weight: bold;";
      
      ocorrencia1.style.cssText = "transition: 0.3; background-color: #f4f7fa; color: #000000; font-weight: bold;";
      ocorrencia2.style.cssText = "transition: 0.3; background-color: #f4f7fa; color: #000000; font-weight: bold;";
      ocorrencia4.style.cssText = "transition: 0.3; background-color: #f4f7fa; color: #000000; font-weight: bold;";  
      }
  });

  ocorrencia4.addEventListener("click", () =>{
    cliques =4;
      if (cliques==4) {
        opcao.value = "Outros";
        ocorrencia4.style.cssText = "transition: 0.3s; background-color: #0b2d4d; color: #ffffff; font-weight: bold;";
      
      ocorrencia1.style.cssText = "transition: 0.3; background-color: #f4f7fa; color: #000000; font-weight: bold;";
      ocorrencia2.style.cssText = "transition: 0.3; background-color: #f4f7fa; color: #000000; font-weight: bold;";
      ocorrencia3.style.cssText = "transition: 0.3; background-color: #f4f7fa; color: #000000; font-weight: bold;";  
      }
  });
  
  document.getElementById("form-denuncia").addEventListener("submit", ()=>{
    if (opcao.value == "") {
      event.preventDefault()
      alert("Selecione uma opção válida!")
    }
  })



  // JAVASCRIPT PARA MOSTRAR E ESCONDER O CAMPO DE INFORMAÇÕES PESSOAIS
// DO FORMULÁRIO DE DENUNCIAS

const op1 = document.getElementById("op1");
const op2 = document.getElementById("op2");
const form_pessoal = document.getElementById("caixa-dados-pessoais");

op1.addEventListener("change", () =>{
  form_pessoal.style.display = "flex";
})
op2.addEventListener("change", () => {
  form_pessoal.style.display = "none";
})

});

