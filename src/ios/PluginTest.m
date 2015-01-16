/**
 
 **/

#import "PluginTest.h"

@implementation PluginTest
-(void) setdatas:(CDVInvokedUrlCommand *)command
{
    NSString *message = [command.arguments objectAtIndex:0];//这是我JavaScripte 传来的数据；
    NSString *title=[command.arguments objectAtIndex:1];
    NSArray  *buttons=[command.arguments objectAtIndex:2];
    NSString *yesbutton=[buttons objectAtIndex:0];
    NSString *nobutton=[buttons objectAtIndex:1];
    
    BOOL arg = YES;
    CDVPluginResult* result;//
    
    if (arg)
    {
        // Success Callback
        result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"我返回的数据"];
        
        UIAlertView *alert=[[UIAlertView alloc] initWithTitle:title message:message delegate:self cancelButtonTitle:nobutton otherButtonTitles:yesbutton, nil];
        [alert show];
        //[self writeJavascript:[result toSuccessCallbackString:command.callbackId]];//version=3.6
        [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];//version =4.0
    }
    else
    {
        // Error Callback
        result = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"error"];
        [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];//version =4.0
        //[self writeJavascript:[result toErrorCallbackString:command.callbackId]];
    }
}
-(void) getdatas:(CDVInvokedUrlCommand *)command{
    CDVPluginResult* resultwrite;
    UIAlertView *alertwrite=[[UIAlertView alloc] initWithTitle:@"this is write" message:@"this is data for write" delegate:self cancelButtonTitle:@"cancelBtn" otherButtonTitles:@"sureBtn", nil];
    [alertwrite show];
    resultwrite=[CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"this is data that i callback"];
    [self.commandDelegate sendPluginResult:resultwrite callbackId:command.callbackId];
}
@end
