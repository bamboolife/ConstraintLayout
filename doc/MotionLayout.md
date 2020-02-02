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

### MotionLayout常用属性
| 属性 | 说明 |
|:----- |:------ |
| app:layoutDescription=”reference” | 指定你需要绑定的MotionScene XML 文件 |
| app:applyMotionScene=”boolean”  | 是否启用MotionScene，默认是true |
| app:showPaths=”boolean” | debug模式比较有用的模式，可以显示动画运动的路径 |
| app:progress=”float”  | 指定转换的完成度 范围是0 - 1 |
| app:currentState=”reference”  | 强制指定特定的ConstraintSet |

###  关键帧（Key Frames）
如果要改变路径的形状，则必须提供一些介于起点和终点之间关键。

```xml
<KeyFrameSet >

            ...

</KeyFrameSet >
```
### KeyPosition

KeyPosition 可以帮助视图改变运动路径的形状。创建它们时，请确保提供目标视图的ID，沿时间轴的位置，可以是0到100之间的任意数字，以及指定X或Y坐标已经运行到的百分比。可以设置type参数指出坐标是相对于实际的X或Y轴，还是相对于路径本身。

```xml
<KeyFrameSet >

    <KeyPosition

    app:target="@+id/button"

    app:framePosition="30"

    app:type="deltaRelative"

    app:percentX="0.85"/>

    <KeyPosition

    app:target="@+id/button"

    app:framePosition="60"

    app:type="deltaRelative"

    app:percentX="1"/>

</KeyFrameSet>
```
上面第一个KeyPosition代表button按钮在运行道30%的时候，相对于运行轨迹x已经运行了85%了。第二个KeyPosition代表button按钮在运行道60%的时候，相对于运行轨迹x已经运行了100%了

### KeyCycle

KeyCycle用来给动画添加振动。可以通过提供诸如要使用的波形和波形周期等详细信息来配置KeyCycle。下面是KeyCycle支持的各种振动波形：
![image]()

在上述动画中加入如下KeyCycle

```xml
<KeyCycle

    app:target="@+id/button"

    app:framePosition="30"

    android:rotation="50"

    app:waveShape="sin"

    app:wavePeriod="1"/>
```
### 交互式动画

上面的动画运行我都是通过对Button按钮设置点击监听事件，然后调用motion_container.transitionToEnd();方法来使他运行的。其实完全不必这么麻烦，因为MotionLayout的视图允许开发者将触摸事件直接附加到视图中。截止到现在，它支持点击和滑动事件。要实现上面实现的点击事件可以在MotionScene中增加代码如下：

```xml
<OnClick

    app:target="@+id/button"

    app:mode="transitionToEnd"/>
```
而可以通过给MotionScene增加OnSwipe标签来使视图通过在屏幕滑动而大运行。在创建该标签时，必须确保提供正确的拖动方向以及应作为拖动控制柄的视图的边。可以这么理解，相对于初始位置，如果想往上滑起到增加动画进度就设置为dragUp，想往下滑起到增加动画进度就设置为dragDown，左右同样道理。至于touchAnchorSide这个参数的本意应该设置拉目标视图的边，但我发现就算不设置touchAnchorSide这个参数或者设置成任意值top bottom或者left right，对动画都没有影响。这可能是MotionLayout的一个bug毕竟现在还只是alpha版。

```xml
<OnSwipe

    app:touchAnchorId="@+id/actor"

    app:dragDirection="dragUp"/>
```
