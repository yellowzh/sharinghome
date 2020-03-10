var opicBox = document.getElementById('picBox');
var osPic = document.getElementsByClassName('sPic');
var opicBtn = document.getElementsByClassName('picBtn');
var oBefore = document.getElementById('before');
var oNext = document.getElementById('next');

slider();
function slider(){
    //调用定时器
    inter();
    var iNow = 0;
    var timer;
    for(var i = 0;i<opicBtn.length;i++){
        //调用点击事件
        bind(i);
    }
    //点击事件函数
    function bind(index){
        opicBtn[index].onclick = function(){
            clearInterval(timer);
            iNow = index;
            changePic(index);
            clickBtn(index);
            //显示完图片后再调用定时器
            inter();
        }
    }

    //上一张函数
    oBefore.onclick = function(){
        clearInterval(timer);
        iNow--;
        if(iNow<0){
            iNow = osPic.length-1;
            changePic(iNow);
            opicBox.style.transition = "";
        }else{
            opicBox.style.transition = "left 0.3s";
            changePic(iNow);
        }
        console.log('前'+iNow);
        changePic(iNow);
        lastBtn(iNow);
        inter();
    }
    //下一张函数
    oNext.onclick = function(){
        clearInterval(timer);
        iNow++;
        if(iNow>osPic.length-1){
            iNow = 0;
            changePic(iNow);
            opicBox.style.transition = "";
        }else{
            opicBox.style.transition = "left 0.3s";
            changePic(iNow);
        }
        console.log('后'+iNow);
        changePic(iNow);
        nextBtn(iNow);
        inter();
    }
    //定时器函数
    function inter(){
        timer = setInterval(function(){
            iNow++;
            if(iNow>(osPic.length-1)){
                iNow = 0;
                changePic(iNow);
                opicBox.style.transition = "";
            }else{
                opicBox.style.transition = "left 0.3s";
                changePic(iNow);
            }
            changePic(iNow);
            nextBtn(iNow);
        },2000)
    }

    //水平切换图片函数
    function changePic(index){
        var nowLeft = -iNow*1266 + "px";
        opicBox.style.left = nowLeft;
        console.log('in'+index);
    }
    //点击下一页时按钮的变化函数
    function nextBtn(index){
        opicBtn[index].style.backgroundColor = "rgba(255,255,255,0.4)";
        if(index>(osPic.length-1)){
            index = 0;
            opicBtn[index].style.backgroundColor = "rgba(255,255,255,0.4)";
        }
        if(index>0){
            opicBtn[index-1].style.backgroundColor = "rgba(0,0,0,0.4)";
        }else{
            opicBtn[osPic.length-1].style.backgroundColor = "rgba(0,0,0,0.4)";
        }
    }
    //点击上一页时按钮的变化函数
    function lastBtn(index){
        opicBtn[index].style.backgroundColor = "rgba(255,255,255,0.4)";
        if(index>(osPic.length-1)){
            index = 0;
            opicBtn[index].style.backgroundColor = "rgba(255,255,255,0.4)";
        }
        if(index<(osPic.length-1)){
            opicBtn[index+1].style.backgroundColor = "rgba(0,0,0,0.4)";
        }
        else{
            opicBtn[0].style.backgroundColor = "rgba(0,0,0,0.4)";
        }
    }
    //点击事件的按钮变化
    function clickBtn(index){

        for(var k = 0;k<opicBtn.length;k++){
            if(k==index){
                opicBtn[k].style.backgroundColor = "rgba(255,255,255,0.4)";
            }else{
                opicBtn[k].style.backgroundColor = "rgba(0,0,0,0.4)";
            }
        }
    }

}