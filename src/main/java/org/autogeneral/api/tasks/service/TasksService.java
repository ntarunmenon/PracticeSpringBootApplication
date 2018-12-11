package org.autogeneral.api.tasks.service;

import org.autogeneral.api.tasks.controller.response.BalanceTestResult;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service
@SuppressWarnings("unused")
public class TasksService {

    public boolean isBalanced(String input) {
        Stack<Character> s = new Stack<Character>();
        char x;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(' || input.charAt(i) == '[' || input.charAt(i) == '{') {
                s.push(input.charAt(i));
                continue;
            }

            if (s.empty())
                return false;

            switch (input.charAt(i)) {
                case ')':

                    // Store the top element in a
                    x = s.peek();
                    s.pop();
                    if (x == '{' || x == '[')
                        return false;
                    break;
                case '}':

                    // Store the top element in b
                    x = s.peek();
                    s.pop();
                    if (x=='(' || x=='[')
                        return false;
                    break;

                case ']':

                    // Store the top element in c
                    x = s.peek();
                    s.pop();
                    if (x =='(' || x == '{')
                        return false;
                    break;
            }
        }
        return (s.empty());
    }
}
