package com.daily.programmer.moneymatters;

import java.io.IOException;
import java.util.*;

/**
 * Created by Vlad-Alexandru.PIRCI on 1/8/2017.
 */
public class MoneyMatters {

    private Map<Short, Set<Short>> friendsGraph;

    private Short[] debts;

    private boolean[] friendVisited;

    private short sum;

    MoneyMatters(short noFriends) {
        friendsGraph = new HashMap<>(noFriends);
        debts = new Short[noFriends];
        friendVisited = new boolean[noFriends];
    }

    public void addRelation(short friend1, short friend2) {

        Set set = this.friendsGraph.computeIfAbsent(friend1, k -> new HashSet());
        set.add(friend2);

        set = this.friendsGraph.computeIfAbsent(friend2, k -> new HashSet());
        set.add(friend1);

    }

    public String evaluate() {
        for(Short friend : friendsGraph.keySet()) {
            sum = 0;
            getSumForFriends(friend);
            if(sum != 0) {
                return "IMPOSSIBLE";
            }
        }
        return "POSSIBLE";
    }

    private void getSumForFriends(short friend) {
        if(friendVisited[friend]) {
            return;
        }

        friendVisited[friend] = true;
        Set<Short> friends = friendsGraph.get(friend);
        sum = (short) (sum + debts[friend]);

        for(Short i : friends) {
            getSumForFriends(i);
        }
    }


    private void addDebt(short i, short debt) {
        debts[i] = debt;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        short noFriends = sc.nextShort();
        int noRelations = sc.nextInt();

        MoneyMatters moneyMatters = new MoneyMatters(noFriends);

        for(short i=0;i<noFriends;i++) {
            short debt = sc.nextShort();
            moneyMatters.addDebt(i, debt);
        }

        for(int i=0;i<noRelations;i++) {
            moneyMatters.addRelation(sc.nextShort(), sc.nextShort());
        }

        System.out.println(moneyMatters.evaluate());
    }


}
