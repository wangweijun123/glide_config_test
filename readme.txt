android project 基础架构




adb shell setprop log.tag.<tag_name> <VERBOSE|DEBUG>


adb shell setprop log.tag.Engine VERBOSE

adb shell setprop log.tag.Glide VERBOSE

adb shell setprop log.tag.GenericRequest VERBOSE

adb shell setprop log.tag.EngineJob VERBOSE
adb shell setprop log.tag.DecodeJob VERBOSE


adb shell setprop log.tag.DiskLruCacheWrapper VERBOSE
adb shell setprop log.tag.MemorySizeCalculator VERBOSE

adb shell getprop log.tag.MemorySizeCalculator


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
5,  占位图设置， error,
6, 图片裁剪，缓存(内存与磁盘)动画, gif
7, glide 与 volley,okhttp 集成
8, listview 滑动的时候，停止图片的加载，稳定的时候再加载(这里需要测试)





OOM 


1， dalvik 虚拟机为对象分配空间
2， 各个对象分散在各处，也就是说，分配的空间不是连续的
3， 如果应用试图分配一个大对象，大于临近的两个对象之间的空闲的空间，就会oom，
    即使总的剩余空间大于这个对象


glide 总结:

1, api 生成(链式掉哟个)
2, 占位符(placeholder(默认图片), error(错误显示))
3, 选项(过渡动画,缩略图,图片加载失败指定本地资源图片，也可以加载url)
4, transformation(变化)-->处理原始图片(圆形头像,圆角icon,centercrop),
  自定义Transformation必须复写三个方法(hashcode, equals, updatekeys)
5, target(目标)

  取消请求
   Glide.with(fragment)
     .load(url)
     .into(imageView);

   // Some time in the future:
   Glide.with(fragment).clear(imageView);

6, 过渡(动画)：

性能提示: 动画的开销比较大，尤其是大量的动画
交叉淡入: 一个淡出，一个淡入alpha

7, 配置(option):
  一，一个app只有一个AppGlideModule的子类实现(添加注解@GlideModule,所以必须依赖注解解析器)
      可以有多个LibraryGlideModule的子类实现
  二，内存缓存大小的配置，存储目录(磁盘)以及大小配置
  三,配置单个图片请求的解码质量(rgb_565(一个像素占2两个字节), rgb_8888(一个像素占4个字节))
  四, 配置异常的捕获,如果发生了比如oom,如何处理这个callback
  五, 替换组件(比如换掉glide网络库，使用okhttp-->replace)

8, 缓存(重点)
   第一, (Active resource)是否有另一个view正在显示这张图片
   第二, memory cache
    第三(Resource)，图片是否之前被转换写入过缓存
    第四(Data),构建这个图片的资源是否之前写入过缓存

    前两步在内存，后两步在文件,如果都没有，就从网络下载

    key的生成(重点)

    设计到元素(url,签名,宽度，高度，变换,数据类型)

    缓存刷新(通常是改变url)

    资源管理: 内存与磁盘都是lru,达到设定的最大值时，最近最少使用
           的item遍历出来，删除remove

 9, 资源重用
    过多内存分配，降低程序性能
    BitmapPool(其实里面就是LinkedHashMap)


10, debug调试
    第一，可以设置监听器request listener
    oom (1，过大的内存分配(2m的图片，以ARGB_8888解码格式加载到内存,一个像素占四个字节,需要内存8m)
         2，内存泄漏问题:重复操作某个特定的步骤，是否内存一点一点的增加，最后oom,dump heap,查看activities,fragments,等等对象)















