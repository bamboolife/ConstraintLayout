### 为什么需要MotionLayout？

MotionLayout，就像它的名字所陈述的一样，首先它是一个Layout，它可以为元素提供布局的功能。实际上它就是ConstraintLayout的子类，有强大并且丰富的布局功能。
MotionLayout的设计是为了连接布局过渡与复杂的手势处理。你可以把它想象成属性动画框架、过渡动画管理和CoordinatorLayout三种能力集于一身的框架。

> 混合了属性动画框架、TransitionManager的布局转换和CoordinatorLayout

它可以能够描述两个布局之间的过渡（ 就像TransitionManager的功能一样），但是它又和TransitionManager不一样的地方在于，在转换的过程中，任何属性都能以动画的形式过渡（不仅仅是已有的属性，自定义属性也可以）。更屌的是，它本身就支持可见的转换,就像CoordinatorLayout一样（这种转换完全由触摸驱动，并且立即转换到任意点）。它支持触摸处理和关键帧（keyFrames),允许开发者非常容易的定制元素之间的过渡。

> MotionLayout完全是声明式的

MotionLayout另一个不同点就是完全是声明式的，你完全可以用xml写一个复杂的转换（如果想用代码，当时也是非常可以的）

> MotionLayout 工具

我们相信 使用这种声明式的说明 将会简化动画的创建，同时也为在Android studio中提供了一个可视化的工具。但是这个工具目前还不是特别稳定，估计会在稳定版或者beta版中与大家见面。

![image](https://github.com/bamboolife/ConstraintLayout/blob/master/imgs/motion_tool.gif)

最后，MotionLayout作为ConstraintLayout 2.0的一部分，将会以support library的形式与大家见面。API支持最低为14，这就意味着至少支持99.8%的Android设备。


### MotionLayout的限制

MotionLayout只能对其直属的子View提供各种变换功能，这一点相对于可以作用布局层级和Activity之间转换的TransitionManager来说，的确是一个劣势。

### 什么时候使用MotionLayout

当你使用MotionLayout，我们预想的情景是这样的：当你想移动、缩放或者缩放页面上的UI元素，就像那些按钮、titlebar等等，那些需要交互的元素。

> 当用户需要与UI元素交互时，就可以使用MotionLayout

意识到这种Motion是很重要的，主要是有以下几个目的：

- 1.它不应该在你的程序里面产生没有必要的特殊效果；
- 2.它应该被用来帮助用户理解你的程序将会做什么。

这类动画只需要处理预定义好的内容，用户没有或者不需要与这些内容直接交互。对于像视频、gif图片或者其他有限的方式，animated vector drawables或者一个lottie文件，MotionLayout不需要指定如果处理这些东西（当然MotionLayout可以包含这些东西在其中）

### 将MotionLayout添加到项目中

添加ConstraintLayout 2.0到gradle 文件中

```gradle
dependencies {
 implementation 'androidx.constraintlayout:constraintlayout:2.0.0-beta4'
 }
```

### 使用MotionLayout
直接在布局中添加使用
```xml
<androidx.constraintlayout.motion.widget.MotionLayout .../>
```

![image](https://github.com/bamboolife/ConstraintLayout/blob/master/imgs/motion_scene.png)

ConstraintLayout 与MotionLayout 最大的区别在于XML层级上面，实际上MotionLayout 并没有包含在布局文件中。
当然啦，MotionLayout非常有特色的将所有的信息保存在了一个独立的XML文件中，保存在XML文件中的信息优先级将会比layout文件中要高。
所以，这个布局文件仅仅只包含了View和它的属性，并没有包含他们的定位或者运动情况。

### ConstraintSets

ConstraintSet是跟随ConstraintLayout 一起的，它封装了layout中的布局规则信息。你可以使用多个ConstraintSet，你可以决定使用哪些布局规则作用到你的layout上，此时并不需要你重新创建View，只需要改变它们的位置或者大小即可。
相比于TransitionManager，在ConstraintLayout 中 ConstraintSet提供了一个相对容易的方式来创建动画。
MotionLayout本质上就是基于以上想法的，在将来这些概念将会被扩展。

### MotionScene

就像已经讲过的，与layouts布局相反，MotionLayout保存的规则就是存放到独立的XML文件中，MotionScene，存放在你的res/xml目录中。


![image](https://github.com/bamboolife/ConstraintLayout/blob/master/imgs/motionScene.png)

一个MotionScene可以包含指定动画的所需要的一切。

- 1.ConstraintSets
- 2.各种ConstraintSets 之间的变换
- 3.关键帧，触摸处理等等
