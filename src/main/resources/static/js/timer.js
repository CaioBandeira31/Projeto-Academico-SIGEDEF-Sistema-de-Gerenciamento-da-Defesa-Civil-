var seg;
seg = 90;

function timer() {
  
  if( seg>0) {
    seg = seg-1;
    
  document.getElementById('timer').innerHTML = 'Tempo restante: '+seg.toString().padStart(2,'0');
  setTimeout(timer,1000);
  }
  
}

timer();