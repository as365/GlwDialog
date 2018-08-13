
GlwDialog
========
简介
----
该项目是结合自己公司实际开发项目进行封装.

目前,国内的android开发项目UI设计分为两种情况,一种是ios一套设计图,android一套设计图(比如微信);另外一种情况是android与ios同一套设计图,并且,这套设计图是根据ios风格设计的.而后者,保证估计占app开发的80%以上.
其中dialog就是这一种情况.这个使用,谷歌工程师为我们设计的AlertDialog就显得比较尴尬了.

正是基于这种考虑,所以有了此项目.


致谢
----
GlwDialog的封装,学习了github上很多优秀的代码,尤其是NiceDialog [点击跳转](https://github.com/SheHuan/NiceDialog)

功能进度
----
1.确认弹窗 (已完成)

2.分享 (已完成)

3.加载提示 (未完成)

4.评论 (未完成)

5.好友设置 (未完成)

6.红包 (未完成)



使用过程存在的坑
----
(一)确认弹窗

如果一个界面(如Activity或Fragment)存在多个弹窗,需要使用 匿名内部类 的方式.如果直接使用 实现基类方法,点击事件业务逻辑操作那里就无法识别来自哪里的操作.





LICENSE
=======
    
    Copyright 2018 高磊华

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
