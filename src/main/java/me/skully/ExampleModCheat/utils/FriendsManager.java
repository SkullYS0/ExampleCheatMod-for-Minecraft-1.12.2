package me.skully.ExampleModCheat.utils;

import java.util.ArrayList;
import java.util.UUID;

public class FriendsManager {
    public static boolean doCheck = false;
    private static ArrayList<UUID> friends = new ArrayList<>();

    public static void addFriend(UUID target) {
        friends.add(target);
    }

    public static void removeFriend(UUID target){
        for (int i = 0;i < friends.size();i++){
            if (friends.get(i) == target){
                friends.remove(i);
            }
        }
    }

    public static void toggleFriend(UUID target){
        if (isFriend(target)){
            removeFriend(target);
        } else {
            addFriend(target);
        }
    }
    public static void clearFriends() {
        friends.clear();
    }

    public static boolean isFriend(UUID target) {
        if(doCheck) {
            for (UUID friend : friends) {
                if (target == friend) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int getNumFriends(){
        return friends.size();
    }
}
