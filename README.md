# new-word-drill
单词强化训练区，当前版本结合必须结合Mysql使用
软件虽然简单但是符合脑神经科学原理真的能帮助记忆单词。

===============================
application-dev.properties中关键参数介绍
drill.magnitude=1.7 //间隔指数 y=x^magnitude(y下次训练的天数 ，x是单词训练的次数 magnitude是系数)单词没成功训练一次X就会+1 每次训练间隔时间增加
drill.loseMinCount=3 //训练或测验时失败的次数，超过这个次数无法真确拼写则表示失败。
drill.loseMaxCount=10 //超过min时系统会逐步提示单词 期初提示单词的位数（#####）、逐渐增加提示的内容（###ld）、直到等于max时会完全提示单词（world）
drill.totalDrillCount=22 //每个单词的总训练次数、其实改为无穷大也并不会有过大负担
