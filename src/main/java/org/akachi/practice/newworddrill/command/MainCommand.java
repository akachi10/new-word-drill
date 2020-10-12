package org.akachi.practice.newworddrill.command;

import org.akachi.practice.newworddrill.entity.DrillConstant;
import org.akachi.practice.newworddrill.util.ClassUtil;

/**
 * @author akachi
 */
public class MainCommand extends AbstractCommand implements ICommand {


    @Override
    public void start() {
        super.start();
    }

    /**
     * 首字母大写
     * @param letter 转换字符串
     * @return 帕斯卡命名法后的字符串
     */
    private String upperFirstLatter(String letter){
        return letter.substring(0, 1).toUpperCase()+letter.substring(1);
    }
    @Override
    public void monitorCommand(){
        while (true){
            String command=input();
            if (command==null||"".equals(command)){
                continue;
            }else if(DrillConstant.END.equals(command)||DrillConstant.EXIT.equals(command)){
                break;
            }else if(DrillConstant.HELP.equals(command)){
                help();
            }else if(command!=null&&!"".equals(command)){
                try {
                    Class clazz = Class.forName("org.akachi.practice.newworddrill.command.operate."+upperFirstLatter(command)+"Command");
                    ICommand iCommand = (ICommand)clazz.newInstance();
                    iCommand.start();
                } catch (ClassNotFoundException e) {
                    output("命令["+command+"]不存在");
                } catch (IllegalAccessException | InstantiationException e) {
                    output("命令["+command+"]执行异常");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void help() {
        output(AbstractCommand.ANNOTATION+this.introduce()+AbstractCommand.ANNOTATION);
        StringBuffer sb = new StringBuffer();
        sb.append("可以执行以下命令["+DrillConstant.END+","+DrillConstant.HELP+"");
        ClassUtil.getAllClassByInterface(ICommand.class).forEach(clazz->{
            if(!clazz.equals(AbstractCommand.class)&&!clazz.equals(MainCommand.class)){
                sb.append(",").append(clazz.getSimpleName().toLowerCase().replace("command",""));
            }
        });
        sb.append("]");
        output(sb.toString());
    }

    @Override
    public String introduce() {
        return "启动单词测试";
    }

}
