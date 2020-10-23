package org.akachi.practice.newworddrill.command;

import org.akachi.practice.newworddrill.entity.DrillConstant;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @author akachi
 */
public abstract class AbstractCommand implements ICommand {

    static final String ANNOTATION="===================";

//    @Override
//    public abstract String introduce();

    @Override
    public void start(){
        this.help();
        this.monitorCommand();
    }
    @Override
    public void help(){
        output(AbstractCommand.ANNOTATION+this.introduce()+AbstractCommand.ANNOTATION);
        StringBuffer sb = new StringBuffer();
        sb.append("可以执行以下" +
                "命令["+ DrillConstant.HELP);
        for(Method method:this.getClass().getDeclaredMethods()){
            /*确定其权限为public修饰符方法则使用*/
            if(Modifier.isPublic(method.getModifiers())
                    &&!DrillConstant.START.equals(method.getName())
                    &&!DrillConstant.INTRODUCE.equals(method.getName())) {
                sb.append(","+method.getName());
            }
        }
        sb.append("]");
        output(sb.toString());
    }

    protected void runCommand(String commandName) {
        try {
            if(DrillConstant.START.equals(commandName)){
                throw new IllegalAccessException();
            }
            Method method=null;
            if(commandName.split(DrillConstant.SPACE).length>1){
                String[] params = new String[commandName.split(" ").length-1];
                Class[] clazzs = new Class[commandName.split(" ").length-1];
                for (int i =0;i<commandName.split(DrillConstant.SPACE).length-1;i++){
                    params[i]=commandName.split(DrillConstant.SPACE)[i+1];
                    clazzs[i]=String.class;
                }
                method = this.getClass().getMethod(commandName.split(DrillConstant.SPACE)[0],clazzs);
                method.invoke(this,params);
            }else{
                method = this.getClass().getMethod(commandName);
                method.invoke(this);
            }
        } catch (NoSuchMethodException e) {
            output("命令["+commandName+"]不存在");
        } catch (IllegalAccessException e) {
            output("命令["+commandName+"]执行异常");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            output("命令["+commandName+"] InvocationTargetException");
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 执行命令
     */
    protected void monitorCommand(){
        while (true){
            String command=input();
            if(DrillConstant.END.equals(command)||DrillConstant.EXIT.equals(command)){
                break;
            }else if(command==null){
                continue;
            }
            this.runCommand(command);
        }
    }

    /**
     * 输出内容
     * @param output 输出内容
     */
    protected void output(String output){
        System.out.println("["+this.getClass().getSimpleName()+"]:"+output);
    }

    /**
     * 等待输入时输出
     */
    protected void output(){
        System.out.print("["+this.getClass().getSimpleName()+"]:");
    }

    /**
     * 输入信息
     * @return 输入内容
     */
    protected String input(){
        output();
        Scanner input=new Scanner(System.in);
        String s =  input.nextLine();
        if("".equals(s)){
            s= null;
        }
        return s;
    }

    /**
     * 输入内容
     * @param hint 提示
     * @return
     */
    protected String input(String hint){
        output(hint);
        output();
        Scanner input=new Scanner(System.in);
        String s =  input.nextLine();
        if("".equals(s)){
            s= null;
        }
        return s;
    }

    /**
     * 输入内容
     * @param hint 提示
     * @param def 默认值
     * @return
     */
    protected String input(String hint,String def){
        output(hint);
        output();System.out.print("默认值'"+def+"'");
        Scanner input=new Scanner(System.in);
        String s =  input.nextLine();
        if("".equals(s)){
            s= null;
        }
        if(s==null){
            s=def;
        }
        return s;
    }
}
