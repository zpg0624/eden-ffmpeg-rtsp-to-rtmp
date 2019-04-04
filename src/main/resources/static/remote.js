var flash ;
function getFlashObject() {
    if(!flash){
        //根据id获取flash实例，在这里id是BXPlayer
        flash = (navigator.appName.indexOf ("Microsoft") !=-1)?window["BXPlayer"]:document["BXPlayer"];
    }
}

/***
 *
 * @param ip  ip地址
 */
function playRTMPVideo(ip) {
    getFlashObject();
    //调用ActionScript注册的回调方法
    flash.playRTMPVideo(ip);
}

/**
 *
 * @param screen
 */
function changeScreenRemoteCall(screen) {
    if(!(screen ==1||screen ==4
        ||screen ==9||
        screen === 16 || screen ==25||
        screen === 36 || screen ==49)
    ){
        alert("不支持"+screen+"屏")
        return;
    }
    getFlashObject();
    flash.changeScreenRemoteCall(screen);
}

/**
 * arrs格式
 * <code>
 *      // var arrs = [];
 *      // arrs.push({index:5,value:"rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov"})
 * </code>
 * @param arrs 数组
 * @param ip  ip地址
 */
function playRTMPVideoBySourceUrlList(arrs,ip) {
    getFlashObject();
    flash.playRTMPVideoBySourceUrlList(arrs,ip);
}

/**
 * 单个地址播放
 * @param num 视频位置下标（注：从0开始）
 * @param sourceUrl 原始视频地址
 * @param ip  ip地址
 */
function playRTMPVideoBySingleSourceUrl(num, sourceUrl,ip) {
    getFlashObject();
    flash.playRTMPVideoBySingleSourceUrl(num, sourceUrl,ip);
}

