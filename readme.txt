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

width=150, height=150    设置控制大小dp的时候，在values文件夹底下与写死在布局文件是一样的

imageview 大小， 下载过来的图片大小


内存，磁盘缓存，也叫双缓存

磁盘缓存，缓存了什么
第一： 原始图片
第二：根据view大小，裁剪过后的图片

glide 的图片加载与activity,fragment生命周期相关


glide {总结}

1, google 推荐使用的图片加载库，应用到google开源项目
2, glide 滑行的意思,列表滑动的时候加载流畅
3,  glide vs square公司的picasso
4,  图片加载与activity生命周期相关，onPause 暂停加载，onresume重新加载
5,  占位图设置， error




















