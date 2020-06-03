package com.company;

import javax.swing.*;

public class InputClear {
    private String input;
    private String clearinput;
    private PanelInput m;

    InputClear(PanelInput in){
        clearInput(in);
        m = in;
    }

    public void clearInput(PanelInput Input){
        input = Input.getInputData();
        char[] inputchar = input.toCharArray();
//        for(int i = 0; i < input.length(); i++){
//            if (inputchar[i] == '1' || inputchar[i] == '2' || inputchar[i] == '3' || inputchar[i] == '4' || inputchar[i] == '5' || inputchar[i] == '6' || inputchar[i] == '7' || inputchar[i] == '8' || inputchar[i] == '9' || inputchar[i] == '0'){
//                clearinput+=inputchar[i];
//            } else if(inputchar[i] == '(' || inputchar[i] == ')' || inputchar[i] == '+' || inputchar[i] == '-' || inputchar[i] == '*' || inputchar[i] == '/' || inputchar[i] == '.' || inputchar[i] == '√'){
//                clearinput += inputchar[i];
//            } else if (inputchar[i] == 's' && inputchar[i+1] == 'i' && inputchar[i+2] == 'n'){
//                clearinput+= inputchar[i];
//                clearinput+= inputchar[i+1];
//                clearinput+= inputchar[i+2];
//                i+=2;
//            } else if (inputchar[i] == 'c' && inputchar[i+1] == 'o' && inputchar[i+2] == 's'){
//                clearinput+= inputchar[i];
//                clearinput+= inputchar[i+1];
//                clearinput+= inputchar[i+2];
//                i+=2;
//            } else if (inputchar[i] == 't' && inputchar[i+1] == 'a' && inputchar[i+2] == 'n'){
//                clearinput+= inputchar[i];
//                clearinput+= inputchar[i+1];
//                clearinput+= inputchar[i+2];
//                i+=2;
//            } else if (inputchar[i] == 'c' && inputchar[i+1] == 't' && inputchar[i+2] == 'g'){
//                clearinput+= inputchar[i];
//                clearinput+= inputchar[i+1];
//                clearinput+= inputchar[i+2];
//                i+=2;
//            }
//            else if (inputchar[i] == 's' && inputchar[i+1] == 'q' && inputchar[i+2] == 'r' && inputchar[i+3] == 't'){
//                clearinput+= inputchar[i];
//                clearinput+= inputchar[i+1];
//                clearinput+= inputchar[i+2];
//                clearinput+= inputchar[i+3];
//                i+=3;
//            }
//            else if (inputchar[i] == ' '){
//                clearinput += inputchar[i];
//            }
//        }
        clearinput = input;
    }
    public String getClearinput(){
        clearInput(m);
        return clearinput;
    }
}
