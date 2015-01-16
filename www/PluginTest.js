var exec = require('cordova/exec');

module.exports={
	SetData:function(messege,_title,_buttons,success, error) {
    exec(success, error, "PluginTest", "setdatas", [messege,_title,_buttons]);
},
   GetData:function(messege,_title,success, error) {
    exec(success, error, "PluginTest", "getdatas", [messege,_title]);
}
}
