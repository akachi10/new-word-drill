package org.akachi.practice.newworddrill.command;

import org.akachi.practice.dictionary.service.DictionaryService;
import org.akachi.practice.dictionary.service.impl.YoudaoDictionaryService;
import org.akachi.practice.newworddrill.Service.NewWordService;
import org.akachi.practice.newworddrill.config.DrillConfig;
import org.akachi.practice.newworddrill.constant.DrillConstant;
import org.akachi.practice.newworddrill.util.SpringApplicationContextHolder;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Scanner;

/**
 * @author akachi
 */
public abstract class AbstractCommand implements ICommand {

    protected DictionaryService dictionaryService = SpringApplicationContextHolder.getBean(YoudaoDictionaryService.class);

    protected NewWordService newWordService = SpringApplicationContextHolder.getBean(NewWordService.class);

    static final String ANNOTATION = "===================";

//    @Override
//    public abstract String introduce();

    @Override
    public void start() {
        this.help();
        this.monitorCommand();
    }

    /**
     * 帮助
     * 会打印所有帮助内容
     */
    @Override
    public void help() {
        output(AbstractCommand.ANNOTATION + this.introduce() + AbstractCommand.ANNOTATION);
        StringBuffer sb = new StringBuffer();
        sb.append("可以执行以下" +
                "命令[" + DrillConstant.END + "," + DrillConstant.HELP);
        for (Method method : this.getClass().getDeclaredMethods()) {
            StringBuffer params = new StringBuffer();
            Parameter[] parameters = method.getParameters();
            for (Parameter param : parameters) {
                params.append(" ");
                params.append(param.getName());
            }
            /*确定其权限为public修饰符方法则使用*/
            if (Modifier.isPublic(method.getModifiers())
                    && !DrillConstant.START.equals(method.getName())
                    && !DrillConstant.INTRODUCE.equals(method.getName())) {
                sb.append("," + method.getName() + params.toString());
            }
        }
        sb.append("]");
        output(sb.toString());
    }

    /**
     * 执行命令
     *
     * @param commandName 命令名称
     */
    protected void runCommand(String commandName) {
        try {
            if (DrillConstant.START.equals(commandName)) {
                throw new IllegalAccessException();
            }
            Method method = null;
            if (commandName.split(DrillConstant.SPACE).length > 1) {
                String[] params = new String[commandName.split(" ").length - 1];
                Class[] clazzs = new Class[commandName.split(" ").length - 1];
                for (int i = 0; i < commandName.split(DrillConstant.SPACE).length - 1; i++) {
                    params[i] = commandName.split(DrillConstant.SPACE)[i + 1];
                    clazzs[i] = String.class;
                }
                method = this.getClass().getMethod(commandName.split(DrillConstant.SPACE)[0], clazzs);
                method.invoke(this, params);
            } else {
                method = this.getClass().getMethod(commandName);
                method.invoke(this);
            }
        } catch (NoSuchMethodException e) {
            output("命令[" + commandName + "]不存在");
        } catch (IllegalAccessException e) {
            output("命令[" + commandName + "]执行异常");
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            output("命令[" + commandName + "] InvocationTargetException");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行命令
     */
    protected void monitorCommand() {
        while (true) {
            String command = input();
            if (DrillConstant.END.equals(command) || DrillConstant.EXIT.equals(command)) {
                break;
            } else if (command == null) {
                continue;
            }
            this.runCommand(command);
        }
    }

    /**
     * 获得当前坐标
     *
     * @return
     */
    public String getSimpleName() {
        return this.getClass().getSimpleName() + "#" + DrillConfig.FLAG;
    }

    /**
     * 输出内容
     *
     * @param output 输出内容
     */
    public void output(String output) {
        if (output == null) {
            return;
        }
        System.out.println("[" + getSimpleName() + "]:" + output);
    }

    /**
     * 等待输入时输出
     */
    public void output() {
        System.out.print("[" + getSimpleName() + "]:");
    }

    /**
     * 输入信息
     *
     * @return 输入内容
     */
    protected String input() {
        output();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        if ("".equals(s)) {
            s = null;
        }
        return s;
    }

    /**
     * 输入内容
     *
     * @param hint 提示
     * @return
     */
    protected String input(String hint) {
        output(hint);
        output();
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        if ("".equals(s)) {
            s = null;
        }
        return s;
    }

    /**
     * 输入内容
     *
     * @param hint 提示
     * @param def  默认值
     * @return
     */
    protected String input(String hint, String def) {
        output(hint);
        output();
        System.out.print("默认值'" + def + "'");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        if ("".equals(s)) {
            s = null;
        }
        if (s == null) {
            s = def;
        }
        return s;
    }


    /**
     * 打印例句
     *
     * @param phrase 单词或短语
     */
    protected void example(String phrase) {
        List<String> list = dictionaryService.explainWeb(phrase);
        if (list == null || list.size() == 0) {
            return;
        }
        output("例子:");
        list.forEach(
                example -> {
                    output(example);
                }
        );
        String phonetic = dictionaryService.phonetic(phrase);
        if (phonetic != null) {
            /*因为微软dos灾难性的编码格式导致音标无法显示*/
//                output("音标:" + new String(phonetic.getBytes(),"GBK"));
        }
    }


    /**
     * 词典翻译
     *
     * @param word
     * @param chinese
     */
    protected void dictionary(String word, String chinese) {
        String dictionary = explain(word);
        if (chinese != null && dictionary != null && !dictionary.equals(chinese)) {
            output("词典翻译:" + dictionary);
        } else {
//            output(chinese + ":未查询到词典。");
        }
    }

    /**
     * 获得翻译
     *
     * @param word 单词
     * @return 中文翻译
     */
    protected String explain(String word) {
        try {
            return dictionaryService.explain(word);
        } catch (NullPointerException e) {
            output("不能翻译此单词");
        }
        return null;
    }

}
