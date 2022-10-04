/* issue 11 home ラジオボタン表示切り替え*/
 
 function formSwitch() {
        hoge = document.getElementsByName('root')
        if (hoge[0].checked) {
            // 新着順
            document.getElementById('box1').style.display = "";
            document.getElementById('box2').style.display = "none";
            document.getElementById('box3').style.display = "none";
        } else if (hoge[1].checked) {
            // ブクマ順
            document.getElementById('box1').style.display = "none";
            document.getElementById('box2').style.display = "";
            document.getElementById('box3').style.display = "none";
        } else if (hoge[2].checked) {
            document.getElementById('box1').style.display = "none";
            document.getElementById('box2').style.display = "none";
            document.getElementById('box3').style.display = "";
        }
    }
    window.addEventListener('load', formSwitch());