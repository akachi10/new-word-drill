package org.akachi.practice.newworddrill.command;

/**
 * @author akachi
 */
public interface ICommand {
    /**
     * 开始执行方法
     */
    void start();

    //    /**
//     * 执行命令
//     * @param commandName 执行命令名
//     */
//    void runCommand(String commandName);
//
//    /**
//     * 监听方法 是个死循环唯有end明天才能推出
//     */
//    void monitorCommand();

    /**
     * 文档命令
     */
    void help();

    /**
     * 对象名
     */
    String introduce();

}
