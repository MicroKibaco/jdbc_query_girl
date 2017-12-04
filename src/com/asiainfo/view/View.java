package com.asiainfo.view;

import com.asiainfo.action.GoddessAction;
import com.asiainfo.model.Goddess;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by MicroKibaco on 04/12/2017.
 */
public class View {

    private static final String CONTEXT="欢迎来到女神禁区:下面是女神禁区功能表\n" +
            " [MAIN/M]:返回主菜单\n" +
            " [QUERY/Q]:可以查看禁区女神的基本信息 query()\n" +
            " [GET/G]:可以查看禁区女神的基本信息 get()\n" +
            " [ADD/A]:可以添加心仪禁区女神 add()\n" +
            " [UPDATE/U]:可以删除禁区女神信息 del()\n" +
            " [DELETE/D]:可以更新禁区女神基本信息 edit()\n" +
            " [SEARCH/S]:可以查询女神基本信息 query(List<Map<String,Object>> params)\n" +
            " [EXIT/E]: 退出当前系统返回主菜单\n"+
            " [BREAK/B]:退回当前功能,返回主菜单" ;

    private static final String OPERATION_MAIN = "MAIN";
    private static final String OPERATION_QUERY = "QUERY";
    private static final String OPERATION_GET = "GET";
    private static final String OPERATION_ADD = "ADD";
    private static final String OPERATION_UPDATE = "UPDATE";
    private static final String OPERATION_DELETE = "DELETE";
    private static final String OPERATION_SEARCH = "SEARCH";
    private static final String OPERATION_EXIT = "EXIT";
    private static final String OPERATION_BREAK = "BREAK";

    public static void main(String [] args) throws UnsupportedEncodingException {


        System.out.println(CONTEXT);


        // 怎么保持程序一直运行
        Scanner scan = new Scanner(System.in);

        Goddess goddess = new Goddess();
        GoddessAction action = new GoddessAction();

        String prenious = null;
        Integer step = 1;
        while (scan.hasNext()){
                String in = scan.next().toString();
                if (OPERATION_EXIT.equals(in.toUpperCase())
                        || OPERATION_EXIT.substring(0,1).equals(in.toUpperCase())) {

                    System.out.println("您已经成功退出女神禁区.");
                    break;

                }else if (OPERATION_QUERY.equals(in.toUpperCase())
                    || OPERATION_QUERY.substring(0,1).equals(in.toUpperCase())) {
                    try {
                        List<Goddess> list = action.query();

                        for (Goddess go : list) {
                            System.out.println(go.getId()+",姓名: "+go.getUser_name());
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }else if (OPERATION_ADD.equals(in.toUpperCase())
                        || OPERATION_ADD.substring(0,1).equals(in.toUpperCase())
                        || OPERATION_ADD.equals(prenious)){

                    prenious = OPERATION_ADD;

                    // 新增女神
                    if (1 == step){
                        System.out.println("请输入女神的的 [姓名] ");
                    }else if (2 == step){
                        goddess.setUser_name(in);
                        System.out.println("请输入女神的的 [年龄] ");
                    }else if (3 == step){
                        goddess.setAge(Integer.valueOf(in));
                        System.out.println("请输入女神的的 [生日] ,格式如:yyyy-MM-dd");
                    }else if (4 == step){
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            Date birthday = sdf.parse(in);
                            goddess.setBirthday(birthday);
                            System.out.println("请输入女神的 [邮箱] ");
                        } catch (ParseException e) {
                            e.printStackTrace();
                            System.out.println("您输入的格式有误,请重新输入");
                            step = 3;
                        }
                    }else if (5 == step){

                        goddess.setEmail(in);
                        System.out.println("请输入女神的 [手机号码] ");


                    } else if (6 == step){

                        goddess.setMobile(in);
                        goddess.setSex(0);
                        goddess.setIsdel(0);
                        try {
                            action.add(goddess);
                            System.out.println("新增女神成功");
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println("新增女神失败");
                        }

                    }

                    if (OPERATION_ADD.equals(prenious)){
                        step++;
                    }

                }else {

                    System.out.println("您输入的值为: "+ in);

                }
            }
      }

  }


