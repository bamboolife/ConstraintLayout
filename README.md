#约束布局和运动布局的使用总结

### 1.介绍

ConstraintLayout是一个ViewGroup（ 翻译为 约束布局），也有人把它称作 增强型的相对布局，由 2016 年 Google I/O 推出，可以在Api9以上的Android系统使用它，它的出现主要是为了解决布局嵌套过多的问题，以灵活的方式定位和调整小部件。从 Android Studio 2.3 起，官方的模板默认使用 ConstraintLayout。
扁平式的布局方式，无任何嵌套，减少布局的层级，优化渲染性能。从支持力度而言，将成为主流布局样式，完全代替其他布局。有个成语用的非常好，集万千宠爱于一身，用到这里非常合适，约束集 LinearLayout（线性布局），RelativeLayout（相对布局），百分比布局等的功能于一身，功能强大，使用灵活。

### 2.为什么要用ConstraintLayout

在介绍中其实已经引出了为什么要使用ConstraintLayout，我们在开发过程中经常能遇到一些复杂的UI，可能会出现布局嵌套过多的问题，嵌套得越多，设备绘制视图所需的时间和计算功耗也就越多，ConstaintLayout的出现就解决此问题。

### 3.如何使用ConstraintLayout

以前使用需要自己添加依赖，现在完全不需要自己添加，新版工程创建完了就可以直接使用了，完全不需要自己配置了。也可以看出google是在大力推广使用此控件的。

#### 3.1添加依赖
 
 如果想在老项目中使用当前的module中的build.gradle文件中添加ConstraintLayout的依赖
 ```
 //当前module中使用
 implementation 'com.android.support.constraint:constraint-layout:xxx'
 //作为依赖库使用
  api 'com.android.support.constraint:constraint-layout:xxx'
 ```

#### 3.2相对定位
相对定位可以说和RelativeLayout差不多，使用起来大家掌握的快，但是比RelativeLayout强大了很多

| RelativeLayout属性 | 说明 | 属性值类型 |
|:-------------- |:------ |:-------- |
| layout_centerHrizontal | 水平居中 |   true\false     |
| layout_centerVertical  | 垂直居中 |  true\false     |
| layout_centerInparent  | 相对于父控件完全居中 |  true\false     |
| layout_alignParentBottom  | 贴紧父控件的下边缘 |  true\false     |
| layout_alignParentLeft | 贴紧父控件的左边缘 |  true\false     |
| layout_alignParentRight | 贴紧父控件的右边缘 |  true\false     |
| layout_alignParentTop | 贴紧父控件的上边缘 |  true\false     |
| layout_alignWithParentIfMissing | 如果对应的兄弟控件找不到的话，就以父控件作为参照物 |  true\false     |

| RelativeLayout属性 | 说明 | 属性值类型 |
|:-------------- |:------ |:-------- |
| layout_below  | 在某控件下方 | @id/id-name |
| layout_above  | 在某控件上方 | @id/id-name |
| layout_toLeftOf | 在某控件的左边 | @id/id-name |
| layout_toRightOf | 在某控件的右边 | @id/id-name |
| layout_alignTop | 本控件的上边缘和某控件的上边缘对齐 | @id/id-name |
| layout_alignLeft | 本控件的左边缘和某控件的左边缘对齐 | @id/id-name |
| layout_alignBottom | 本控件的下边缘和某控件的下控件对齐 | @id/id-name |
| layout_alignRight  | 本控件的右边缘和某控件的有边缘对齐 | @id/id-name |



| ConstraintLayout |
|:-------------- |
| layout_constraintLeft_toLeftOf |
| layout_constraintLeft_toRightOf |
| layout_constraintRight_toLeftOf |
| layout_constraintRight_toRightOf |
| layout_constraintTop_toTopOf |
| layout_constraintTop_toBottomOf |
| layout_constraintBottom_toTopOf |
| layout_constraintBottom_toBottomOf |
| layout_constraintBaseline_toBaselineOf |
| layout_constraintStart_toEndOf |
| layout_constraintStart_toStartOf |
| layout_constraintEnd_toStartOf |
| layout_constraintEnd_toEndOf |

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
