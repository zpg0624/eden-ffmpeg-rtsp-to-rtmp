var swfVersionStr = "11.1.0";
var xiSwfUrlStr = "${expressInstallSwf}";
var flashvars = {};
var params = {};
params.quality = "high";
params.bgcolor = "#ffffff";
params.allowscriptaccess = "always";
params.allowfullscreen = "true";
var attributes = {};
attributes.id = "BXPlayer";
attributes.name = "BXPlayer";
attributes.align = "middle";
params.wmode="transparent";
swfobject.embedSWF(
    "BXPlayer.swf", "flashContent",
    "100%", "100%",
    swfVersionStr, xiSwfUrlStr,
    flashvars, params, attributes);
swfobject.createCSS("#flashContent", "display:block;text-align:left;");