function useGameCheckboxCtl() {
  let open = document.getElementById("radio-open");
  let quesiton = document.getElementById("radio-question");
  let useGame = document.getElementById("useGame");

  if(open.checked && quesiton.checked){
    useGame.disabled = false;
  }else{
    useGame.checked = false;
    useGame.disabled = true;
  }
}