//#import <Cordova/Cordova.h> //this is error import
#import <Cordova/CDVPlugin.h>
@interface PluginTest : CDVPlugin
-(void) setdatas:(CDVInvokedUrlCommand*)command;
-(void) getdatas:(CDVInvokedUrlCommand*)command;
@end