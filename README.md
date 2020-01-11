#约束布局和运动布局的使用总结

### 1.介绍

ConstraintLayout是Android Studio 2.2中主要的新增功能之一，也是Google在去年的I/O大会上重点宣传的一个功能。我们都知道，在传统的Android开发当中，界面基本都是靠编写XML代码完成的，虽然Android Studio也支持可视化的方式来编写界面，但是操作起来并不方便，我也一直都不推荐使用可视化的方式来编写Android应用程序的界面。

而ConstraintLayout就是为了解决这一现状而出现的。它和传统编写界面的方式恰恰相反，ConstraintLayout非常适合使用可视化的方式来编写界面，但并不太适合使用XML的方式来进行编写。当然，可视化操作的背后仍然还是使用的XML代码来实现的，只不过这些代码是由Android Studio根据我们的操作自动生成的。

另外，ConstraintLayout还有一个优点，它可以有效地解决布局嵌套过多的问题。我们平时编写界面，复杂的布局总会伴随着多层的嵌套，而嵌套越多，程序的性能也就越差。ConstraintLayout则是使用约束的方式来指定各个控件的位置和关系的，它有点类似于RelativeLayout，但远比RelativeLayout要更强大。


### 2.为什么要用ConstraintLayout

### 3.如何使用ConstraintLayout

#### 3.1添加依赖

#### 3.2相对定位

#### 3.3角度定位

#### 3.4边距

#### 3.5居中和偏移

#### 3.6尺寸约束

#### 3.7链

### 辅助工具

#### Optimizer

#### Barrier

#### Group

#### Placeholder

#### Guideline

### 总结

----

### MontionLayout(运动布局)
