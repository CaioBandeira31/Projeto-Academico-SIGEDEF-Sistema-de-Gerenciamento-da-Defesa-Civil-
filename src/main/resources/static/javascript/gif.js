document.addEventListener("DOMContentLoaded", function() {

  const aviso = document.getElementById("aviso");
  const denuncia = document.getElementById("denuncia");

  denuncia.addEventListener("mouseenter", function () {
    aviso.src = "/imagens/gif/aviso.gif";
  });

  denuncia.addEventListener("mouseleave", function () {
    aviso.src = "/imagens/aviso.png";
  });

  const apertodemao = document.getElementById("aperto-de-mao");
  const transparencia = document.getElementById("transparencia");

  transparencia.addEventListener("mouseenter", function () {
    apertodemao.src = "/imagens/gif/aperto-de-mao.gif";
  });

  transparencia.addEventListener("mouseleave", function () {
    apertodemao.src = "/imagens/aperto-de-mao.png"
  });

  const chuva = document.getElementById("chuva");
  const tempo = document.getElementById("tempo");

  tempo.addEventListener("mouseenter", function () {
    chuva.src = "/imagens/gif/chuva.gif";
  });

  tempo.addEventListener("mouseleave", function () {
    chuva.src = "/imagens/chuva.png"
  });

  const telefone = document.getElementById("telefone");
  const sms = document.getElementById("sms");

  sms.addEventListener("mouseenter", function () {
    telefone.src = "/imagens/gif/telefone.gif";
  });

  sms.addEventListener("mouseleave", function () {
    telefone.src = "/imagens/telefone.png"
  });

});