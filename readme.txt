android project 基础架构




adb shell setprop log.tag.<tag_name> <VERBOSE|DEBUG>


adb shell setprop log.tag.Engine VERBOSE

adb shell setprop log.tag.Glide VERBOSE

adb shell setprop log.tag.GenericRequest VERBOSE

adb shell setprop log.tag.EngineJob VERBOSE
adb shell setprop log.tag.DecodeJob VERBOSE


一张图片所占内存大小  宽width*高height*每个像素点所占字节,
Bitmap.Config，但通常对于 ARGB_8888 的位图来说，每个像素即为四个字节

即使是一张普通的 1080P 图片也需要 8MB 内存

1080*1920*4 /1024 == 8100 k == 8M




