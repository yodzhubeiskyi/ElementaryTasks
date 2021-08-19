package com.oessoft;

import com.oessoft.service.*;

public class ElementaryTasksApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to Elementary Tasks Application");
        MainMenuService.setArgs(args);
        MainMenuService.showTaskSelection();
    }
}
