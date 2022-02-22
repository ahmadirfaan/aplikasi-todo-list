package com.irfaan.belajar.todolist.util;

import java.util.Scanner;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: InputUtil.java, v 0.1 2022‐02‐22 17.34 Ahmad Irfaan Hibatullah Exp $$
 */
public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static String input(String info) {
        System.out.print(info + " : ");
        return scanner.nextLine();
    }

}