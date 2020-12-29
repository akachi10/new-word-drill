package org.akachi.practice.newworddrill.command;

import org.akachi.practice.newworddrill.Service.NewWordService;
import org.akachi.practice.newworddrill.config.DrillConfig;
import org.akachi.practice.newworddrill.constant.DrillConstant;
import org.akachi.practice.newworddrill.util.ClassUtil;
import org.akachi.practice.newworddrill.util.SpringApplicationContextHolder;

/**
 * @author akachi
 */
public class MainCommand extends AbstractCommand implements ICommand {

    @Override
    public void start() {
        super.start();
    }

    public void setFlag(String flag) {
        DrillConfig.FLAG = flag;
    }

    /**
     * 重写入了help
     */
    @Override
    public void help() {
        output(AbstractCommand.ANNOTATION + this.introduce() + AbstractCommand.ANNOTATION);
        StringBuffer sb = new StringBuffer();
        sb.append("可以执行以下命令[" + DrillConstant.END + "," + DrillConstant.HELP + "," + DrillConstant.FLAG + "," + DrillConstant.FLAGLIST);
        ClassUtil.getAllClassByInterface(ICommand.class).forEach(clazz -> {
            if (!clazz.equals(AbstractCommand.class) && !clazz.equals(MainCommand.class)) {
                sb.append(",").append(clazz.getSimpleName().toLowerCase().replace("command", ""));
            }
        });
        sb.append("]");
        output(sb.toString());
    }


    @Override
    public String introduce() {
        return "启动单词测试=" + DrillConfig.FLAG;
    }

    @Override
    public void monitorCommand() {
        while (true) {
            String command = input();
            if (command == null || "".equals(command)) {
                continue;
            } else if (DrillConstant.FLAGLIST.equals(command)) {
                StringBuffer stringBuffer = new StringBuffer();
                this.newWordService.flagList().forEach(flag -> {
                    stringBuffer.append(flag).append(",");
                });
                output("打印flag列表");
                output(stringBuffer.toString());
            } else if (command.split(" ").length == 2 &&
                    DrillConstant.FLAG.equals(command.split(" ")[0]) &&
                    !DrillConstant.TEST_CONTINUE.equals(command.split(" ")[1])) {
                DrillConfig.FLAG = command.split(" ")[1];
                output("已经设置flag为'" + command.split(" ")[1] + "'");
            } else if (DrillConstant.FLAG.equals(command)) {
                output("已经设置flag为'" + DrillConfig.FLAG + "'");
                this.setFlag(DrillConfig.FLAG);
            } else if (DrillConstant.END.equals(command) || DrillConstant.EXIT.equals(command)) {
                break;
            } else if (DrillConstant.HELP.equals(command)) {
                help();
            } else if (command != null && !"".equals(command)) {
                try {
                    Class clazz = Class.forName("org.akachi.practice.newworddrill.command.operate." + upperFirstLatter(command) + "Command");
                    ICommand iCommand = (ICommand) clazz.newInstance();
                    iCommand.start();
                    this.help();
                } catch (ClassNotFoundException e) {
                    output("命令[" + command + "]不存在");
                } catch (IllegalAccessException | InstantiationException e) {
                    output("命令[" + command + "]执行异常");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 首字母大写
     *
     * @param letter 转换字符串
     * @return 帕斯卡命名法后的字符串
     */
    private String upperFirstLatter(String letter) {
        return letter.substring(0, 1).toUpperCase() + letter.substring(1);
    }


}
