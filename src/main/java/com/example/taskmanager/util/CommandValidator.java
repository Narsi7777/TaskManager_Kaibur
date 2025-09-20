package com.example.taskmanager.util;

public class CommandValidator {
    public static boolean isSafe(String command) {
        String[] blacklist = {"rm", "shutdown", "reboot", ":", "&"};
        for(String b : blacklist){
            if(command.contains(b)) return false;
        }
        return true;
    }
}
