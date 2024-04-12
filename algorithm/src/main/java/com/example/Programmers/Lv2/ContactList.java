package com.example.Programmers.Lv2;

import java.util.Arrays;

/**
 * 프로그래머스 Lv2 - 전화번호 목록
 */
public class ContactList {
    public boolean solution(String[] phone_book) {

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}
